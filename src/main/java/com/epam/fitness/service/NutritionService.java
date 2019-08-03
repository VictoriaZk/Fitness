package com.epam.fitness.service;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Nutrition;
import com.epam.fitness.repository.NutritionRepository;
import com.epam.fitness.repository.creator.RepositoryCreator;
import com.epam.fitness.repository.specifications.nutrition.NutritionByClientId;

import java.util.Optional;


/**
 * Class provides methods to work with {@link Nutrition} objects.
 */
public class NutritionService {

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Nutrition> findById(long id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            NutritionRepository nutritionRepository = repositoryCreator.getNutritionRepository();
            return nutritionRepository.findById(id);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Save long.
     *
     * @param nutrition the nutrition
     * @return the long
     * @throws ServiceException the service exception
     */
    public Long save(Nutrition nutrition) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            NutritionRepository nutritionRepository = repositoryCreator.getNutritionRepository();
            return nutritionRepository.save(nutrition);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Find by client id optional.
     *
     * @param clientId the client id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Nutrition> findByClientId(long clientId) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            NutritionRepository nutritionRepository = repositoryCreator.getNutritionRepository();
            NutritionByClientId specification = new NutritionByClientId(clientId);
            return nutritionRepository.queryForSingleResult(specification);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

}
