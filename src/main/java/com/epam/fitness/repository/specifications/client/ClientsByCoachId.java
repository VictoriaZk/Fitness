package com.epam.fitness.repository.specifications.client;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Collections;
import java.util.List;

/**
 * The type Clients by coach id.
 */
public class ClientsByCoachId implements SqlSpecification {

    private Long coachId;

    /**
     * Instantiates a new Clients by coach id.
     *
     * @param coachId the coach id
     */
    public ClientsByCoachId(long coachId){
        this.coachId = coachId;
    }
    @Override
    public String getSql() {
        return " where coach_id=(?)";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(coachId);
    }

}
