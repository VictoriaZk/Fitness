package com.epam.fitness.builder;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Exercise;
import com.epam.fitness.model.dto.ExerciseDto;
import com.epam.fitness.repository.database.constants.ExerciseDtoTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Designed to build an object of type {@link com.epam.fitness.model.dto.ExerciseDto} with specified characteristics.
 */
public class ExerciseDtoBuilder implements Builder<ExerciseDto> {

    @Override
    public ExerciseDto build(ResultSet resultSet) throws RepositoryException {
        Exercise exercise = new ExerciseBuilder().build(resultSet);
        try {
            Long id = resultSet.getLong(ExerciseDtoTableConstants.ID.getFieldName());
            Integer repeatNumber = resultSet.getInt(ExerciseDtoTableConstants.REPEAT_NUMBER.getFieldName());
            Integer setNumber = resultSet.getInt(ExerciseDtoTableConstants.SET_NUMBER.getFieldName());
            Integer numberOfTrainDay = resultSet.getInt(ExerciseDtoTableConstants.NUMBER_TRAIN_DAY.getFieldName());
            Long programId = resultSet.getLong(ExerciseDtoTableConstants.PROGRAM_ID.getFieldName());
            return new ExerciseDto(id,exercise,programId,repeatNumber,setNumber,numberOfTrainDay);
        }catch (SQLException exception){
            throw new RepositoryException(exception.getMessage(),exception);
        }
    }
}
