package com.epam.fitness.command;

import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.utils.page.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Designed for providing login page
 */
public class LoginPageCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        System.out.println("LOGIN PAGE");
        return new CommandResult(Page.LOGIN.getPage(),false);
    }
}
