package com.epam.fitness.command.authorization;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Client;
import com.epam.fitness.model.Coach;
import com.epam.fitness.model.Identifiable;
import com.epam.fitness.service.ClientService;
import com.epam.fitness.service.CoachService;
import com.epam.fitness.utils.RequestParameterValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static com.epam.fitness.command.authorization.constant.ParameterConstants.*;

/**
 * Designed to perform login process.
 */
public class LoginCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class.getName());

    private final RequestParameterValidator parameterValidator = new RequestParameterValidator();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        if(login==null || !parameterValidator.isLoginValid(login)){
            LOGGER.info("invalid login was received");
            return forwardToLoginWithError(request,INCORRECT_LOGIN_DATA);
        }
        if(password==null || !parameterValidator.isPasswordValid(password)){
            LOGGER.info("invalid password was received");
            return forwardToLoginWithError(request,INCORRECT_PASSWORD_DATA);
        }
        boolean isClientOrCoachFind;
        if(!initializeCoachIfExist(login,password,request)){
            isClientOrCoachFind = initializeClientIfExist(login,password,request);
        }else{
            isClientOrCoachFind = true;
        }

        if(isClientOrCoachFind){
            LOGGER.info("user has been authorized: login:" + login + " password:" + password);
            return new CommandResult(COMMAND_MAIN, true);
        }  else {
            LOGGER.info("user with such login and password doesn't exist");
            return forwardToLoginWithError(request,AUTHENTICATION_ERROR);
        }
    }

    /**
     * Initialize client if exist boolean.
     *
     * @param login    the login
     * @param password the password
     * @param request  the request
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public boolean initializeClientIfExist(String login, String password, HttpServletRequest request) throws ServiceException {
        ClientService clientService = new ClientService();
        Optional<Client> client = clientService.login(login, password);
        boolean clientExist = false;
        if(client.isPresent()){
            setAttributesToSession(client.get(),request);
            clientExist = true;
        }
        return clientExist;
    }

    /**
     * Initialize coach if exist boolean.
     *
     * @param login    the login
     * @param password the password
     * @param request  the request
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public boolean initializeCoachIfExist(String login, String password, HttpServletRequest request) throws ServiceException {
        CoachService coachService = new CoachService();
        Optional<Coach> coach = coachService.login(login,password);
        boolean coachExist = false;
        if(coach.isPresent()){
            setAttributesToSession(coach.get(),request);
            coachExist = true;
        }
        return coachExist;
    }

    private void setAttributesToSession(Identifiable entity, HttpServletRequest request){
        long userID = entity.getId();
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttributes.ID, userID);
        String entityName = entity.getClass().getSimpleName().toLowerCase();
        session.setAttribute(SessionAttributes.ROLE,entityName);
    }

    private CommandResult forwardToLoginWithError(HttpServletRequest request,String ERROR){
        request.setAttribute(ERROR, true);
        return new CommandResult(LOGIN_PAGE, false);
    }




}
