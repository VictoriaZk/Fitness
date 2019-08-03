package com.epam.fitness.command;

import com.epam.fitness.exception.IncorrectInputDataException;
import com.epam.fitness.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Designed to determine the behavior of the implementing class in the form of command
 * to processing the request and form the response.
 */
public interface Command {
    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectInputDataException;
}
