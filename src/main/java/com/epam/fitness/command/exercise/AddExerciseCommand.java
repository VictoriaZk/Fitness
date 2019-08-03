package com.epam.fitness.command.exercise;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.exercise.validator.ParameterValidator;
import com.epam.fitness.exception.IncorrectInputDataException;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Client;
import com.epam.fitness.model.Exercise;
import com.epam.fitness.model.dto.ExerciseDto;
import com.epam.fitness.service.ExerciseDtoService;
import com.epam.fitness.service.ExerciseService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static com.epam.fitness.command.exercise.constant.TextConstants.*;


/**
 * Designed to add exercises
 */
public class AddExerciseCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(AddExerciseCommand.class.getName());
    private final ParameterValidator parameterValidator = new ParameterValidator();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectInputDataException {
        String repeatsString = request.getParameter(REPEATS);
        String setNumberString = request.getParameter(SET_NUMBER);
        if(!parameterValidator.isRepeatsValid(repeatsString)){
            LOGGER.info("format number of repeats is not correct");
            return forwardToExercisePageWithError(request);
        }
        if(!parameterValidator.isSetNumberValid(setNumberString)){
            LOGGER.info("format number of set number is not correct");
            return forwardToExercisePageWithError(request);
        }
        Integer repeats = Integer.valueOf(repeatsString);
        Integer setNumber = Integer.valueOf(setNumberString);
        ExerciseDto exerciseDto = makeExercise(request,repeats,setNumber);
        ExerciseDtoService exerciseDtoService = new ExerciseDtoService();
        exerciseDtoService.save(exerciseDto);
        LOGGER.info("exercise with id:" + exerciseDto.getId() + " has been added");
        return new CommandResult(PROFILE_PAGE,true);
    }

    private ExerciseDto makeExercise(HttpServletRequest request, Integer repeats, Integer setNumber) throws ServiceException, IncorrectInputDataException {
        ExerciseService service = new ExerciseService();
        Long exerciseId = Long.parseLong(request.getParameter(EXERCISE_ID));
        Optional<Exercise> exercise = service.findById(exerciseId);
        Integer trainDay = Integer.parseInt(request.getParameter(TRAIN_DAY));
        Long programId = Long.parseLong(request.getParameter(PROGRAM_ID));
        return new ExerciseDto(null, exercise.get(), programId, repeats, setNumber, trainDay);
    }


    private CommandResult forwardToExercisePageWithError(HttpServletRequest request) {
        request.setAttribute(INCORRECT_INPUT_DATA_ERROR, true);
        return new CommandResult(CLIENT_EXERCISE_PAGE,false);

    }
}
