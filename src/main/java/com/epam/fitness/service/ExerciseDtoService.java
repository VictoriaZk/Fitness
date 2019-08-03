package com.epam.fitness.service;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.dto.ExerciseDto;
import com.epam.fitness.repository.ExerciseDtoRepository;
import com.epam.fitness.repository.creator.RepositoryCreator;
import com.epam.fitness.repository.specifications.exercise.dto.ExerciseDtoById;
import com.epam.fitness.repository.specifications.exercise.dto.ExerciseDtoByProgramId;

import java.util.List;
import java.util.Optional;


/**
 * Class provides methods to work with {@link com.epam.fitness.model.dto.ExerciseDto} objects.
 */
public class ExerciseDtoService {

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<ExerciseDto> findById(long id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ExerciseDtoRepository exerciseDtoRepository = repositoryCreator.getExerciseDtoRepository();
            ExerciseDtoById specification = new ExerciseDtoById(id);
            return exerciseDtoRepository.queryForSingleResult(specification);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Find exercises by program id list.
     *
     * @param programId the program id
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<ExerciseDto> findExercisesByProgramId(Long programId) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ExerciseDtoRepository exerciseDtoRepository = repositoryCreator.getExerciseDtoRepository();
            ExerciseDtoByProgramId specification = new ExerciseDtoByProgramId(programId);
            return exerciseDtoRepository.query(specification);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Save.
     *
     * @param exerciseDto the exercise dto
     * @throws ServiceException the service exception
     */
    public void save(ExerciseDto exerciseDto) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ExerciseDtoRepository exerciseDtoRepository = repositoryCreator.getExerciseDtoRepository();
            exerciseDtoRepository.save(exerciseDto);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Delete exercise long.
     *
     * @param exerciseDtoId the exercise dto id
     * @return the long
     * @throws ServiceException the service exception
     */
    public long deleteExercise(long exerciseDtoId) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ExerciseDtoRepository exerciseDtoRepository = repositoryCreator.getExerciseDtoRepository();
            return exerciseDtoRepository.delete(exerciseDtoId);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

}
