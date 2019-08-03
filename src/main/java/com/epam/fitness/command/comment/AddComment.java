package com.epam.fitness.command.comment;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Coach;
import com.epam.fitness.model.Comment;
import com.epam.fitness.service.CoachService;
import com.epam.fitness.service.CommentService;
import com.epam.fitness.utils.RequestParameterValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static com.epam.fitness.command.comment.constant.TextConstants.*;

/**
 * Designed to add comments by client
 */
public class AddComment implements Command {

    private static final Logger LOGGER = Logger.getLogger(AddComment.class.getName());
    private final RequestParameterValidator parameterValidator = new RequestParameterValidator();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String commentContent  = request.getParameter(COMMENT_CONTENT);
        request.setAttribute(MAX_NUMBER_SYMBOLS_ATTRIBUTE,MAX_NUMBER_SYMBOLS_VALUE);
        if(commentContent==null || !parameterValidator.isCommentContentValid(commentContent)){
            LOGGER.info("was received an invalid comment format");
            return forwardToCommentPageWithError(request,INCORRECT_INPUT_COMMENT_DATA_ERROR);
        }
        String coachIdString = request.getParameter(COACH_ID);
        if(coachIdString==null || !isCoachExist(coachIdString)){
            LOGGER.info("coach with id:" + coachIdString + " does't exist");
            return forwardToCommentPageWithError(request,NOT_EXIST_COACH_ID);
        }
        Long coachId = Long.valueOf(coachIdString);
        HttpSession session = request.getSession();
        Long clientId = (Long) session.getAttribute(SessionAttributes.ID);
        Comment comment = new Comment(clientId,coachId,commentContent);
        CommentService commentService = new CommentService();
        commentService.save(comment);
        LOGGER.info("comment of client with id:" + clientId + " was successfully saved");
        return new CommandResult(COACHES_PAGE,true);
    }


    private CommandResult forwardToCommentPageWithError(HttpServletRequest request,String error) {
        request.setAttribute(error, true);
        return new CommandResult(COACHES_PAGE,false);
    }

    private boolean isCoachExist(String coachIdString) throws ServiceException {
        Long coachId = Long.valueOf(coachIdString);
        CoachService coachService = new CoachService();
        Optional<Coach> coach = coachService.findById(coachId);
        return coach.isPresent();
    }
}
