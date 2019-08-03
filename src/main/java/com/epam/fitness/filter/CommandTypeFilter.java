package com.epam.fitness.filter;

import com.epam.fitness.command.access.CommandAccess;
import com.epam.fitness.command.factory.CommandType;
import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.connection.ConnectionPool;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Designed to define available operations for each user.
 */
public class CommandTypeFilter implements Filter  {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);
    private static final String COMMAND = "command";
    private final static String NO_ACCESS_PAGE = "controller?command=no_access";
    private final static String ERROR_PAGE = "/WEB-INF/error/errorPage404.jsp";

    /**
     * Method of the Filter is called by the
     * container each time a request/response pair is passed through the
     * chain due to a client request for a resource at the end of the chain,
     * provide different commands for users depending on their role
     * if the user requests a page to which there is no access, it is sent to the appropriate no access page
     *
     * @param servletRequest  an {@link ServletRequest} object that contains client request
     * @param servletResponse an {@link ServletResponse} object that contains the response the servlet
     * @param filterChain an {@link FilterChain} object that allows the Filter to pass
     *                   on the request and response to the next entity in the chain.
     * @throws IOException Signals that an I/O exception of some sort has occurred.
     * @throws ServletException General exception a servlet can throw when it encounters difficulty.
     */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        Optional<String> userRole = getUserRoleByRequest(httpServletRequest);
        CommandAccess commandAccess = new CommandAccess();
        List<CommandType> commandTypes = commandAccess.getAvailableCommandTypesByUser(userRole);

        String command = servletRequest.getParameter(COMMAND);
        String commandUpper = command.toUpperCase();
        CommandType commandType;
        try {
             commandType = CommandType.valueOf(commandUpper);
        }catch (IllegalArgumentException exception){
            LOGGER.warn("Incorrect command was input.Command:" + commandUpper);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher(ERROR_PAGE);
            requestDispatcher.forward(servletRequest, servletResponse);
            return;
        }

        if (commandTypes.contains(commandType)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletRequest) servletRequest).getSession().invalidate();
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher(NO_ACCESS_PAGE);
            requestDispatcher.forward(servletRequest, servletResponse);
        }
    }

    private Optional<String> getUserRoleByRequest(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Optional<String> roleOptional;
        if (session == null) {
            roleOptional = Optional.empty();
        } else {
            String role = (String)session.getAttribute(SessionAttributes.ROLE);
            roleOptional = Optional.ofNullable(role);
        }
        return roleOptional;
    }

}
