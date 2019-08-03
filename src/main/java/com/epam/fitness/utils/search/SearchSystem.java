package com.epam.fitness.utils.search;

import java.util.List;

/**
 * The interface Search system.
 *
 * @param <T> the type parameter
 */
public interface SearchSystem<T> {
    /**
     * Find items appropriate to search argument list.
     *
     * @param itemsToCheck   the items to check
     * @param searchArgument the search argument
     * @return the list
     */
    List<T> findItemsAppropriateToSearchArgument(List<T> itemsToCheck, String searchArgument);
}
