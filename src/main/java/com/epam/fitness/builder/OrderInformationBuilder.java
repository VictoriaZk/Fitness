package com.epam.fitness.builder;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.OrderInformation;
import com.epam.fitness.repository.database.constants.OrderInformationTableConstants;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Designed to build an object of type {@link com.epam.fitness.model.OrderInformation} with specified characteristics.
 */
public class OrderInformationBuilder implements Builder<OrderInformation> {

    @Override
    public OrderInformation build(ResultSet resultSet) throws RepositoryException {
        try {
            Long orderID = resultSet.getLong(OrderInformationTableConstants.ID.getFieldName());
            BigDecimal cost = resultSet.getBigDecimal(OrderInformationTableConstants.COST.getFieldName());
            Timestamp paymentData = resultSet.getTimestamp(OrderInformationTableConstants.PAYMENT_DATA.getFieldName());
            Date membership_end_date = resultSet.getDate(OrderInformationTableConstants.MEMBERSHIP_END_DATE.getFieldName());
            Long clientId = resultSet.getLong(OrderInformationTableConstants.CLIENT_ID.getFieldName());
            String cardNumber = resultSet.getString(OrderInformationTableConstants.CARD_NUMBER.getFieldName());
            return new OrderInformation(orderID,cost,paymentData,membership_end_date,clientId,cardNumber) ;
        }catch (SQLException exception){
            throw new RepositoryException(exception.getMessage(),exception);
        }
    }
}
