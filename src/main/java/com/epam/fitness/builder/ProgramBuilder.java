package com.epam.fitness.builder;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Program;
import com.epam.fitness.repository.database.constants.ProgramTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Designed to build an object of type {@link com.epam.fitness.model.Program} with specified characteristics.
 */
public class ProgramBuilder implements Builder<Program> {

    @Override
    public Program build(ResultSet resultSet) throws RepositoryException {
        try {
            Long id = resultSet.getLong(ProgramTableConstants.ID.getFieldName());
            Long nutritionId = resultSet.getLong(ProgramTableConstants.NUTRITION_ID.getFieldName());
            Integer trainsPerWeek = resultSet.getInt(ProgramTableConstants.TRAINS_PER_WEEK.getFieldName());
            return new Program(id,nutritionId,trainsPerWeek);
        }catch (SQLException exception){
            throw new RepositoryException(exception.getMessage(),exception);
        }
    }
}
