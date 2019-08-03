package com.epam.fitness.service;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Exercise;
import com.epam.fitness.repository.ExerciseRepository;
import com.epam.fitness.repository.creator.RepositoryCreator;

import java.util.List;
import java.util.Optional;


/**
 * Class provides methods to work with {@link Exercise} objects.
 */
public class ExerciseService {
    /**
     * Find all list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<Exercise> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ExerciseRepository exerciseRepository = repositoryCreator.getExerciseRepository();
            return exerciseRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Exercise> findById(long id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ExerciseRepository exerciseRepository = repositoryCreator.getExerciseRepository();
            return exerciseRepository.findById(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
