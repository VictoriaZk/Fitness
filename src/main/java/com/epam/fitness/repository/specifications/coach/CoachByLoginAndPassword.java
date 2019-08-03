package com.epam.fitness.repository.specifications.coach;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The type Coach by login and password.
 */
public class CoachByLoginAndPassword implements SqlSpecification {

    private String login;
    private String password;

    /**
     * Instantiates a new Coach by login and password.
     *
     * @param login    the login
     * @param password the password
     */
    public CoachByLoginAndPassword(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String getSql() {
        return " where login = (?) and password = (?)";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(login, password);
    }
}
