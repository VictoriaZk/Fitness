package com.epam.fitness.command.exercise;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.exercise.validator.ParameterValidator;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.dto.ExerciseDto;
import com.epam.fitness.service.ExerciseDtoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static com.epam.fitness.command.exercise.constant.TextConstants.*;

/**
 * Designed to update exercises
 */
public class UpdateExerciseCommand implements Command {

    private ParameterValidator validator = new ParameterValidator();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String repeatsString = request.getParameter(REPEATS);
        String setNumberString = request.getParameter(SET_NUMBER);
        if (!validator.isRepeatsValid(repeatsString)) {
            LOGGER.info("incorrect number repeats format was received:" + repeatsString);
            return forwardToExercisePageWithError(request, INCORRECT_INPUT_DATA_ERROR);
        }
        if (!validator.isSetNumberValid(setNumberString)) {
            LOGGER.info("incorrect sets number format was received:" + repeatsString);
            return forwardToExercisePageWithError(request, INCORRECT_INPUT_DATA_ERROR);
        }
        String exerciseDtoIdString = request.getParameter(EXERCISE_DTO_ID);
        if (!validator.isIdentifiableIdValid(exerciseDtoIdString)) {
            LOGGER.info("incorrect exercise id was received:" + exerciseDtoIdString);
            return forwardToExercisePageWithError(request, INVALID_EXERCISE_ID_FORMAT);
        }
        Long exerciseDtoId = Long.valueOf(exerciseDtoIdString);
        if (!validator.isExerciseExist(exerciseDtoId)) {
            LOGGER.info("exercise with id:" + exerciseDtoId + " doesn't exist");
            forwardToExercisePageWithError(request, NOT_EXIST_EXERCISE_ID);
        }
        Integer repeats = Integer.valueOf(repeatsString);
        Integer setNumber = Integer.valueOf(setNumberString);
        ExerciseDtoService exerciseDtoService = new ExerciseDtoService();
        Optional<ExerciseDto> exerciseDto = exerciseDtoService.findById(exerciseDtoId);
        if (exerciseDto.isPresent()) {
            exerciseDto.get().setSetNumber(setNumber);
            exerciseDto.get().setRepeatNumber(repeats);
            exerciseDtoService.save(exerciseDto.get());
        }
        LOGGER.info("exercise with id:" + exerciseDtoId + " has benn changed");
        return new CommandResult(PROFILE_PAGE, true);
    }

    private CommandResult forwardToExercisePageWithError(HttpServletRequest request, String error) {
        request.setAttribute(error, true);
        return new CommandResult(CLIENT_EXERCISE_PAGE, false);
    }
}
