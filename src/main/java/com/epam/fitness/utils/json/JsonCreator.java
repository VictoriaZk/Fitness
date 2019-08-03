package com.epam.fitness.utils.json;

import java.util.List;

/**
 * The interface Json creator.
 *
 * @param <T> the type parameter
 */
public interface JsonCreator<T> {
    /**
     * Make json string.
     *
     * @param items the items
     * @return the string
     */
    String makeJSON(List<T> items);
}
