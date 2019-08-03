package com.epam.fitness.service;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Coach;
import com.epam.fitness.repository.CoachRepository;
import com.epam.fitness.repository.creator.RepositoryCreator;
import com.epam.fitness.repository.specifications.coach.CoachByClientId;
import com.epam.fitness.repository.specifications.coach.CoachByLogin;
import com.epam.fitness.repository.specifications.coach.CoachByLoginAndPassword;

import java.util.List;
import java.util.Optional;


/**
 * Class provides methods to work with {@link Coach} objects.
 */
public class CoachService  {


    /**
     * Login optional.
     *
     * @param login    the login
     * @param password the password
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Coach> login(String login, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            CoachRepository coachRepository = repositoryCreator.getCoachRepository();
            CoachByLoginAndPassword specification = new CoachByLoginAndPassword(login, password);
            return coachRepository.queryForSingleResult(specification);
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
    public Optional<Coach> findById(long id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            CoachRepository coachRepository = repositoryCreator.getCoachRepository();
            return coachRepository.findById(id);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Find by client id optional.
     *
     * @param clientId the client id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Coach> findByClientId(long clientId) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            CoachRepository coachRepository = repositoryCreator.getCoachRepository();
            CoachByClientId specification = new CoachByClientId(clientId);
            return coachRepository.queryForSingleResult(specification);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Find by login optional.
     *
     * @param login the login
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Coach> findByLogin(String login) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            CoachRepository coachRepository = repositoryCreator.getCoachRepository();
            CoachByLogin specification = new CoachByLogin(login);
            return coachRepository.queryForSingleResult(specification);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Find all list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<Coach> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            CoachRepository coachRepository = repositoryCreator.getCoachRepository();
            return coachRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }


}
