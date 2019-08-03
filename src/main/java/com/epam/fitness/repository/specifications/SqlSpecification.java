package com.epam.fitness.repository.specifications;

import java.util.List;

/**
 * The interface Sql specification.
 */
public interface SqlSpecification {
    /**
     * Gets sql.
     *
     * @return the sql
     */
    String getSql();

    /**
     * Gets parameters.
     *
     * @return the parameters
     */
    List<Object> getParameters();
}
