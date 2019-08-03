package com.epam.fitness.command.client;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Client;
import com.epam.fitness.model.Coach;
import com.epam.fitness.service.ClientService;
import com.epam.fitness.service.CoachService;
import com.epam.fitness.utils.RequestParameterValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static com.epam.fitness.command.client.constant.ParameterConstants.*;


/**
 *  Designed for the selection of the coach
 */
public class ChooseCoachCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(ChooseCoachCommand.class.getName());
    private static RequestParameterValidator validator = new RequestParameterValidator();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String coachIdString = request.getParameter(COACH_ID);
        if(coachIdString==null || !validator.isIdentifiableIdValid(coachIdString)){
            LOGGER.info("invalid coach_id format: coach_id:" + coachIdString);
            return forwardToExercisePageWithError(request,INCORRECT_COACH_ID_FORMAT_ERROR);
        }
        Long coachId = Long.valueOf(coachIdString);
        if(!isCoachIdExist(coachId)) {
            LOGGER.info("coach with coach:id" + coachId + " doesn't exist");
            return forwardToExercisePageWithError(request,NOT_EXIST_COACH_ID_ERROR);
        }
        HttpSession session = request.getSession();
        Long clientId = (Long) session.getAttribute(SessionAttributes.ID);
        ClientService clientService = new ClientService();
        Optional<Client> client = clientService.findById(clientId);
        if(client.isPresent()){
            client.get().setCoachId(coachId);
            clientService.save(client.get());
        }
        LOGGER.info("coach with coach:id" + coachId + " was chosen");
        return new CommandResult(MAIN_PAGE,false);
    }

    private CommandResult forwardToExercisePageWithError(HttpServletRequest request,String error) {
        request.setAttribute(error, true);
        return new CommandResult(COACHES_PAGE,false);
    }

    private boolean isCoachIdExist(Long coachId) throws ServiceException {
        CoachService coachService = new CoachService();
        Optional<Coach> coach = coachService.findById(coachId);
        return coach.isPresent();
    }

}
