package com.epam.fitness.repository.specifications.order;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Collections;
import java.util.List;

/**
 * The type Last order by client id.
 */
public class LastOrderByClientId implements SqlSpecification {

    private Long id;

    /**
     * Instantiates a new Last order by client id.
     *
     * @param id the id
     */
    public LastOrderByClientId(long id){
        this.id = id;
    }

    @Override
    public String getSql() {
        return " where client_id = (?) and membership_end_date >= current_date() order by membership_end_date desc limit 1";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(id);
    }
}