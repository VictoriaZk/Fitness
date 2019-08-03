package com.epam.fitness.command;

import com.epam.fitness.utils.page.Page;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Designed to provide home page
 */
public class HomePageCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)  {
        return new CommandResult(Page.HOME_PAGE.getPage(), false);
    }
}
