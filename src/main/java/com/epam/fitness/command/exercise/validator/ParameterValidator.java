package com.epam.fitness.command.exercise.validator;

import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.dto.ExerciseDto;
import com.epam.fitness.service.ExerciseDtoService;
import com.epam.fitness.utils.RequestParameterValidator;

import java.util.Optional;

/**
 * Designed to validate request parameters
 */
public class ParameterValidator {

    private RequestParameterValidator validator = new RequestParameterValidator();

    /**
     * Is repeats valid boolean.
     *
     * @param repeats the repeats
     * @return the boolean
     */
    public boolean isRepeatsValid(String repeats){
        return repeats != null && validator.isRepeatsValid(repeats);
    }

    /**
     * Is set number valid boolean.
     *
     * @param setNumber the set number
     * @return the boolean
     */
    public boolean isSetNumberValid(String setNumber){
        return setNumber != null && validator.isSetNumberValid(setNumber);
    }

    /**
     * Is identifiable id valid boolean.
     *
     * @param exerciseDtoIdString the exercise dto id string
     * @return the boolean
     */
    public boolean isIdentifiableIdValid(String exerciseDtoIdString){
        return exerciseDtoIdString != null && validator.isIdentifiableIdValid(exerciseDtoIdString);
    }

    /**
     * Is exercise exist boolean.
     *
     * @param exerciseId the exercise id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public boolean isExerciseExist(Long exerciseId) throws ServiceException {
        ExerciseDtoService exerciseDtoService = new ExerciseDtoService();
        Optional<ExerciseDto> exerciseDto = exerciseDtoService.findById(exerciseId);
        return exerciseDto.isPresent();
    }

}
