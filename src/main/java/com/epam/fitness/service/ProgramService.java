package com.epam.fitness.service;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Program;
import com.epam.fitness.repository.ProgramRepository;
import com.epam.fitness.repository.creator.RepositoryCreator;
import com.epam.fitness.repository.specifications.program.ProgramById;

import java.util.Optional;


/**
 * Class provides methods to work with {@link Program} objects.
 */
public class ProgramService {

    /**
     * Find program by id optional.
     *
     * @param programID the program id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<Program> findProgramById(Long programID) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {

            ProgramRepository programRepository = repositoryCreator.getProgramRepository();
            ProgramById specification = new ProgramById(programID);
            Optional<Program> program = programRepository.queryForSingleResult(specification);
            return program;
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * Save long.
     *
     * @param program the program
     * @return the long
     * @throws ServiceException the service exception
     */
    public Long save(Program program) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            ProgramRepository programRepository = repositoryCreator.getProgramRepository();
            return programRepository.save(program);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }


}
