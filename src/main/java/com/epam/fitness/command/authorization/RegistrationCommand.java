package com.epam.fitness.command.authorization;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.*;
import com.epam.fitness.service.ClientService;
import com.epam.fitness.service.CoachService;
import com.epam.fitness.service.NutritionService;
import com.epam.fitness.service.ProgramService;
import com.epam.fitness.utils.RequestParameterValidator;
import com.epam.fitness.utils.page.Page;
import com.epam.fitness.utils.sale.SaleSystem;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static com.epam.fitness.command.authorization.constant.ParameterConstants.*;

/**
 * Designed to perform registration process.
 */
public class RegistrationCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class.getName());
    private final RequestParameterValidator parameterValidator = new RequestParameterValidator();
    private final static SaleSystem SALE_SYSTEM = SaleSystem.getInstance();


    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String login = request.getParameter(LOGIN_FOR_REGISTER);
        if(login==null || !parameterValidator.isLoginValid(login)){
            LOGGER.info("invalid login format was received:" + login);
            return forwardToLoginWithError(request,INCORRECT_LOGIN_DATA);
        }
        String password = request.getParameter(PASSWORD_FOR_REGISTER);
        if(password==null || !parameterValidator.isPasswordValid(password)){
            LOGGER.info("invalid password format was received:" + password);
            return forwardToLoginWithError(request,INCORRECT_PASSWORD_DATA);
        }
        String name = request.getParameter(NAME_FOR_REGISTER);
        String surname = request.getParameter(SURNAME_FOR_REGISTER);
        if(name==null || surname==null || !(parameterValidator.isNameValid(name) && parameterValidator.isSurnameValid(surname))){
            LOGGER.info("invalid name or surname format was received:" + name + " " + surname);
            return forwardToLoginWithError(request,INCORRECT_NAME_SURNAME_DATA);
        }
        if(isLoginExistInDatabase(login)){
            LOGGER.info("user with such format was received:" + login);
            request.setAttribute(LOGIN_EXIST_ERROR,true);
            return new CommandResult(Page.LOGIN.getPage(),false);
        }
        Client client = buildClient(request);
        ClientService clientService = new ClientService();
        Long clientId = clientService.save(client);
        client.setID(clientId);
        setSessionAttributes(request,clientId);
        LOGGER.info("user was registered: login:" + login + " password:" + password);
        return new CommandResult(COMMAND_MAIN,true);
    }

    private Client buildClient(HttpServletRequest request) throws ServiceException {
        String login = request.getParameter(LOGIN_FOR_REGISTER);
        String password = request.getParameter(PASSWORD_FOR_REGISTER);
        String name = request.getParameter(NAME_FOR_REGISTER);
        String surname = request.getParameter(SURNAME_FOR_REGISTER);
        float personalSale = SALE_SYSTEM.getSaleByVisitNumber(START_VISIT_NUMBER);
        Program program = buildProgram();
        return new Client(null,null,name,surname,login,password,START_VISIT_NUMBER,personalSale,program.getId());
    }

    private Program buildProgram() throws ServiceException {
        Program program = new Program();
        Nutrition nutrition = buildNutrition();
        program.setNutritionId(nutrition.getId());
        program.setTrainsPerWeek(STANDARD_TRAINS_PER_WEEK);
        ProgramService  programService = new ProgramService();
        Long programId = programService.save(program);
        program.setId(programId);
        return program;
    }

    private Nutrition buildNutrition() throws ServiceException {
        Nutrition nutrition = new Nutrition();
        NutritionService nutritionService = new NutritionService();
        Long nutritionId  = nutritionService.save(nutrition);
        nutrition.setId(nutritionId);
        return nutrition;
    }

    /**
     * Is login exist in database boolean.
     *
     * @param login the login
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public boolean isLoginExistInDatabase(String login) throws ServiceException {
        ClientService clientService = new ClientService();
        Optional<Client> client = clientService.findByLogin(login);
        if(client.isPresent()){
            return true;
        }
        CoachService coachService = new CoachService();
        Optional<Coach> coach = coachService.findByLogin(login);
        return coach.isPresent();
    }

    private void setSessionAttributes(HttpServletRequest request,Long clientId){
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttributes.ID,clientId);
        session.setAttribute(SessionAttributes.ROLE, UserRole.CLIENT);
    }

    private CommandResult forwardToLoginWithError(HttpServletRequest request,String ERROR){
        request.setAttribute(ERROR, true);
        return new CommandResult(LOGIN_PAGE, false);
    }

}