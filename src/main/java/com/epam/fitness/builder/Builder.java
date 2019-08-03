package com.epam.fitness.builder;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Identifiable;

import java.sql.ResultSet;

/**
 *  Designed to determine the behavior of the implementing class in the form of construction
 *  an object of type T with specified characteristics.
 *
 * @param <T> - type of object.
 */

public interface Builder<T extends Identifiable> {
    T build(ResultSet resultSet) throws RepositoryException;
}
