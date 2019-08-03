package com.epam.fitness.repository.specifications.coach;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The type Coach by client id.
 */
public class CoachByClientId implements SqlSpecification {

    private Long clientID;

    /**
     * Instantiates a new Coach by client id.
     *
     * @param clientID the client id
     */
    public CoachByClientId(Long clientID) {
        this.clientID = clientID;
    }

    @Override
    public String getSql() {
        return "  join client on client.coach_id = coach.id_coach where id_client = (?)";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(clientID);
    }

}
