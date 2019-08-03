package com.epam.fitness.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Designed to change language.
 */
public class LanguageCommand implements Command {

    private static final String LANGUAGE = "language";
    private static final String RU = "RU";
    private static final String EN = "EN";
    private static final String UNKNOWN_LANGUAGE_MESSAGE = "Unknown language!";
    private static final String NEXT_LANGUAGE = "nextLanguage";

    private static final String CURRENT_PAGE = "currentPage";
    private static final String LOGIN_PAGE = "/WEB-INF/login.jsp";
    private static final String COMMAND = "controller?command=";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

        String language = request.getParameter(LANGUAGE);
        HttpSession session = request.getSession();
        session.setAttribute(LANGUAGE, language);

        String nextLanguage = getLanguage(language);
        request.setAttribute(NEXT_LANGUAGE,nextLanguage);
        session.setAttribute(NEXT_LANGUAGE, nextLanguage);

        String page = request.getParameter(CURRENT_PAGE);
        return  page == null || page.isEmpty() ?
                new CommandResult(LOGIN_PAGE, false) :
                new CommandResult(COMMAND + page, true);
    }

    private String getLanguage(String language) {
        String nextLanguage;
        switch (language) {
            case RU:
                nextLanguage = EN;
                break;
            case EN:
                nextLanguage = RU;
                break;
            default:
                throw new IllegalArgumentException(UNKNOWN_LANGUAGE_MESSAGE);
        }
        return nextLanguage;
    }
}
