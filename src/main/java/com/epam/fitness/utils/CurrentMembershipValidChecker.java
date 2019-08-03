package com.epam.fitness.utils;

import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.OrderInformation;
import com.epam.fitness.service.OrderInformationService;

import java.util.Date;
import java.util.Optional;

/**
 * Designed to valid membership
 */
public class CurrentMembershipValidChecker {

    /**
     * Is current membership valid boolean.
     *
     * @param clientId the client id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public boolean isCurrentMembershipValid(Long clientId) throws ServiceException {
        OrderInformationService orderInformationService = new OrderInformationService();
        Optional<OrderInformation> orderInformationOptional = orderInformationService.findByClientId(clientId);
        return orderInformationOptional.filter(orderInformation ->
                isCurrentDateLessEndTrainDate(orderInformation.getMembershipEndDate())).isPresent();
    }

    private boolean isCurrentDateLessEndTrainDate(Date endTrainDate){
        return new Date().before(endTrainDate);
    }
}
