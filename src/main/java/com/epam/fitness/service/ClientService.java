package com.epam.fitness.service;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Client;
import com.epam.fitness.model.dto.ExerciseDto;
import com.epam.fitness.repository.ClientRepository;
import com.epam.fitness.repository.creator.RepositoryCreator;
import com.epam.fitness.repository.specifications.client.*;

import java.util.List;
import java.util.Optional;

/**
 * Class provides methods to work with {@link Client} objects.
 */
public class ClientService {

    /**
     * Login optional.
     *
     * @param login    the login
     * @param password the password
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Client> login(String login, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ClientRepository clientRepository = repositoryCreator.getClientRepository();
            ClientByLoginAndPassword specification = new ClientByLoginAndPassword(login, password);
            return clientRepository.queryForSingleResult(specification);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Client> findById(long id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ClientRepository clientRepository = repositoryCreator.getClientRepository();
            return clientRepository.findById(id);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Find by coach id list.
     *
     * @param coachId the coach id
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<Client> findByCoachId(long coachId) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ClientRepository clientRepository = repositoryCreator.getClientRepository();
            ClientsByCoachId specification = new ClientsByCoachId(coachId);
            return clientRepository.query(specification);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Find by program id optional.
     *
     * @param programId the program id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Client> findByProgramId(long programId) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ClientRepository clientRepository = repositoryCreator.getClientRepository();
            CLientByProgramId specification = new CLientByProgramId(programId);
            return clientRepository.queryForSingleResult(specification);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Find by exercise dto id optional.
     *
     * @param exerciseDtoId the exercise dto id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Client> findByExerciseDtoId(long exerciseDtoId) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ExerciseDtoService exerciseDtoService = new ExerciseDtoService();
            Optional<ExerciseDto> exerciseDto = exerciseDtoService.findById(exerciseDtoId);
            Long programId = exerciseDto.get().getProgramId();
            CLientByProgramId specification = new CLientByProgramId(programId);
            ClientRepository clientRepository = repositoryCreator.getClientRepository();
            return clientRepository.queryForSingleResult(specification);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Find by nutrition id optional.
     *
     * @param nutritionId the nutrition id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Client> findByNutritionId(long nutritionId) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ClientByNutritionId specification = new ClientByNutritionId(nutritionId);
            ClientRepository clientRepository = repositoryCreator.getClientRepository();
            return clientRepository.queryForSingleResult(specification);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }

    /**
     * Find by login optional.
     *
     * @param login the login
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Client> findByLogin(String login) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ClientByLogin specification = new ClientByLogin(login);
            ClientRepository clientRepository = repositoryCreator.getClientRepository();
            return clientRepository.queryForSingleResult(specification);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }


    /**
     * Save long.
     *
     * @param client the client
     * @return the long
     * @throws ServiceException the service exception
     */
    public Long save(Client client) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ClientRepository clientRepository = repositoryCreator.getClientRepository();
            return clientRepository.save(client);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }


}

