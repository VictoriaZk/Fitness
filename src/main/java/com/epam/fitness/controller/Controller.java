package com.epam.fitness.controller;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.factory.CommandFactory;
import com.epam.fitness.connection.ConnectionPool;
import com.epam.fitness.exception.IncorrectInputDataException;
import com.epam.fitness.exception.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {


    private static final String COMMAND = "command";
    private static final String ERROR_PAGE = "/WEB-INF/error/standardErrorPage.jsp";
    private static final String ERROR_MESSAGE = "error_message";
    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());


    @Override
    public void destroy() {
        ConnectionPool.getInstance().destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String command = request.getParameter(COMMAND);
        LOGGER.info(COMMAND + "= " + command);
        Command action = CommandFactory.create(command);

        CommandResult commandResult;
        try {
            commandResult = action.execute(request, response);
        } catch (ServiceException |IncorrectInputDataException e) {
            LOGGER.error(e.getMessage(), e);
            request.setAttribute(ERROR_MESSAGE,e.getMessage());
            commandResult = new CommandResult(ERROR_PAGE, false);
        }

        String page = commandResult.getPage();
        if (commandResult.isRedirect()) {
            sendRedirect(response, page);
        } else {
            dispatch(request, response, page);
        }
    }


    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }


    private void sendRedirect(HttpServletResponse response, String page) throws IOException {
        response.sendRedirect(page);
    }
}