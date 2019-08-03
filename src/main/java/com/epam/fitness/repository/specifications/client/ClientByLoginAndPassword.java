package com.epam.fitness.repository.specifications.client;

import com.epam.fitness.repository.specifications.SqlSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The type Client by login and password.
 */
public class ClientByLoginAndPassword implements SqlSpecification {
    private String login;
    private String password;

    /**
     * Instantiates a new Client by login and password.
     *
     * @param login    the login
     * @param password the password
     */
    public ClientByLoginAndPassword(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String getSql() {
        return " where login=(?) and password=(?)";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(login, password);
    }


}
