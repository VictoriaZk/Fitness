package com.epam.fitness.repository;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.List;
import java.util.Optional;

/**
 * The interface Repository.
 *
 * @param <T> the type parameter
 */
public interface Repository<T>{
    /**
     * Query list.
     *
     * @param specification the specification
     * @return list
     * @throws RepositoryException the repository exception
     */
    List<T> query(SqlSpecification specification) throws RepositoryException;

    /**
     * Query for single result optional.
     *
     * @param specification the specification
     * @return optional
     * @throws RepositoryException the repository exception
     */
    Optional<T> queryForSingleResult(SqlSpecification specification) throws RepositoryException;

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return optional
     * @throws RepositoryException the repository exception
     */
    Optional<T> findById(Long id) throws RepositoryException;

    /**
     * Find all list.
     *
     * @return the list
     * @throws RepositoryException the repository exception
     */
    List<T> findAll() throws RepositoryException;

    /**
     * Save long.
     *
     * @param object the object
     * @return the long
     * @throws RepositoryException the repository exception
     */
    Long save(T object) throws RepositoryException;

}
