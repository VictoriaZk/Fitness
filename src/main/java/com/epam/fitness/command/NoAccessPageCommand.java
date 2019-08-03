package com.epam.fitness.command;

import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.utils.page.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Designed for providing no access page
 */
public class NoAccessPageCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return new CommandResult(Page.NO_ACCESS_PAGE.getPage(),false);
    }
}
