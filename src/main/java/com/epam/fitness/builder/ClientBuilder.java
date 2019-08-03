package com.epam.fitness.builder;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Client;
import com.epam.fitness.repository.database.constants.ClientTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Designed to build an object of type {@link com.epam.fitness.model.Client} with specified characteristics.
 */
public class ClientBuilder implements Builder<Client> {

    @Override
    public Client build(ResultSet resultSet) throws RepositoryException {
        try {
            Long id = resultSet.getLong(ClientTableConstants.ID.getFieldName());
            Long coach_id = resultSet.getLong(ClientTableConstants.COACH_ID.getFieldName());
            String name = resultSet.getString(ClientTableConstants.NAME.getFieldName());
            String surname = resultSet.getString(ClientTableConstants.SURNAME.getFieldName());
            String login = resultSet.getString(ClientTableConstants.LOGIN.getFieldName());
            String password = resultSet.getString(ClientTableConstants.PASSWORD.getFieldName());
            int membershipPurchasedNumber = resultSet.getInt(ClientTableConstants.MEMBERSHIP_PURCHASED_NUMBER.getFieldName());
            float personalDiscount = resultSet.getFloat(ClientTableConstants.PERSONAL_DISCOUNT.getFieldName());
            Long programId = resultSet.getLong(ClientTableConstants.PROGRAM_ID.getFieldName());
            return new Client(id,coach_id,name,surname,login,password,membershipPurchasedNumber,personalDiscount,programId);
        }catch (SQLException exception){
            throw new RepositoryException(exception.getMessage(),exception);
        }
    }
}
