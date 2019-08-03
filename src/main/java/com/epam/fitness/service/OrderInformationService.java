package com.epam.fitness.service;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.OrderInformation;
import com.epam.fitness.repository.OrderInformationRepository;
import com.epam.fitness.repository.creator.RepositoryCreator;
import com.epam.fitness.repository.specifications.order.LastOrderByClientId;
import com.epam.fitness.repository.specifications.order.OrdersByClientId;

import java.util.List;
import java.util.Optional;


/**
 * Class provides methods to work with {@link com.epam.fitness.model.Nutrition} objects.
 */
public class OrderInformationService {


    /**
     * Find by client id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<OrderInformation> findByClientId(long id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderInformationRepository orderInformationRepository = repositoryCreator.getOrderInformationRepository();
            LastOrderByClientId specification = new LastOrderByClientId(id);
            return orderInformationRepository.queryForSingleResult(specification);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Save.
     *
     * @param orderInformation the order information
     * @throws ServiceException the service exception
     */
    public void save(OrderInformation orderInformation) throws ServiceException {
        try(RepositoryCreator repositoryCreator = new RepositoryCreator()){
            OrderInformationRepository orderInformationRepository = repositoryCreator.getOrderInformationRepository();
            try {
                orderInformationRepository.save(orderInformation);
            } catch (RepositoryException e) {
                throw new ServiceException(e.getMessage(),e);
            }
        }
    }

    /**
     * Find by orders client id list.
     *
     * @param clientId the client id
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<OrderInformation> findByOrdersClientId(Long clientId) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderInformationRepository orderInformationRepository = repositoryCreator.getOrderInformationRepository();
            OrdersByClientId specification = new OrdersByClientId(clientId);
            return orderInformationRepository.query(specification);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
