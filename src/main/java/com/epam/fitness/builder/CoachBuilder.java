package com.epam.fitness.builder;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Coach;
import com.epam.fitness.repository.database.constants.CoachTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Designed to build an object of type {@link com.epam.fitness.model.Coach} with specified characteristics.
 */
public class CoachBuilder implements Builder<Coach> {

    @Override
    public Coach build(ResultSet resultSet) throws RepositoryException {
        try {
            Long id = resultSet.getLong(CoachTableConstants.ID.getFieldName());
            String name = resultSet.getString(CoachTableConstants.NAME.getFieldName());
            String surname = resultSet.getString(CoachTableConstants.SURNAME.getFieldName());
            String login = resultSet.getString(CoachTableConstants.LOGIN.getFieldName());
            String password = resultSet.getString(CoachTableConstants.PASSWORD.getFieldName());
            return new Coach(id,name,surname,login,password);
        }catch (SQLException exception){
            throw new RepositoryException(exception.getMessage(),exception);
        }
    }
}
