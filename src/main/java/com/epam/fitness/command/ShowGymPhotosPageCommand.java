package com.epam.fitness.command;

import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.utils.page.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Designed to provide page with fitness centre photos
 */
public class ShowGymPhotosPageCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return new CommandResult(Page.GYP_PHOTOS_PAGE.getPage(),false);
    }
}
