package com.epam.fitness.command.exercise;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.exercise.validator.ParameterValidator;
import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Client;
import com.epam.fitness.model.UserRole;
import com.epam.fitness.service.ClientService;
import com.epam.fitness.service.ExerciseDtoService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static com.epam.fitness.command.exercise.constant.TextConstants.*;

/**
 * Designed to delete exercises
 */
public class DeleteExerciseCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(DeleteExerciseCommand.class.getName());
    private ParameterValidator validator = new ParameterValidator();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        if(session.getAttribute(SessionAttributes.ROLE).equals(UserRole.COACH)){
            setClientId(request);
        }
        String exerciseDtoIdString = request.getParameter(EXERCISE_DTO_ID);
        if(!validator.isIdentifiableIdValid(exerciseDtoIdString)){
            LOGGER.info("incorrеct exercise id was received:" + exerciseDtoIdString);
            return forwardToExercisePageWithError(request,INVALID_EXERCISE_ID_FORMAT);
        }
        Long exerciseDtoId = Long.valueOf(exerciseDtoIdString);
        if(!validator.isExerciseExist(exerciseDtoId)){
            LOGGER.info("exercise with id:" + exerciseDtoId +" doesn't exist");
            forwardToExercisePageWithError(request,NOT_EXIST_EXERCISE_ID);
        }
        ExerciseDtoService exerciseDtoService = new ExerciseDtoService();
        exerciseDtoService.deleteExercise(exerciseDtoId);
        LOGGER.info("exercise with id:" + exerciseDtoId + " has been deleted");
        return new CommandResult(PROFILE_PAGE,true);
    }

    private void setClientId(HttpServletRequest request) throws ServiceException {
        Long exerciseDtoId = Long.parseLong(request.getParameter(EXERCISE_DTO_ID));
        ClientService clientService = new ClientService();
        Optional<Client> clientOptional = clientService.findByExerciseDtoId(exerciseDtoId);
        clientOptional.ifPresent(client -> {
            HttpSession session = request.getSession();
            session.setAttribute(COACH_CLIENT_ID,client.getId());
        });
    }

    private CommandResult forwardToExercisePageWithError(HttpServletRequest request,String error) {
        request.setAttribute(error, true);
        return new CommandResult(error,false);
    }
}
