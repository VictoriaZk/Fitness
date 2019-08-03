package com.epam.fitness.repository.specifications.coach;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The type Coach by login.
 */
public class CoachByLogin implements SqlSpecification {

    private String login;

    /**
     * Instantiates a new Coach by login.
     *
     * @param login the login
     */
    public CoachByLogin(String login) {
        this.login = login;
    }

    @Override
    public String getSql() {
        return " where login = (?)";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(login);
    }
}

