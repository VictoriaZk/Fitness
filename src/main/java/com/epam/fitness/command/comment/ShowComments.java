package com.epam.fitness.command.comment;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Client;
import com.epam.fitness.model.Comment;
import com.epam.fitness.service.ClientService;
import com.epam.fitness.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.epam.fitness.command.comment.constant.TextConstants.*;

/**
 * Designed to represent comments
 */
public class ShowComments implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        request.setAttribute(MAX_NUMBER_SYMBOLS_ATTRIBUTE,MAX_NUMBER_SYMBOLS_VALUE);
        Long coachId = (Long) session.getAttribute(SessionAttributes.ID);
        CommentService commentService = new CommentService();
        List<Comment> comments = commentService.findByCoachId(coachId);
        if(comments.size()!=0){
             Map<Comment,Client> commentClientMap = makeCommentMapForCoach(comments);
             request.setAttribute(COMMENTS,commentClientMap);
        }
        return new CommandResult(COACH_COMMENTS_PAGE,false);
    }

    private Map<Comment,Client> makeCommentMapForCoach(List<Comment> comments) throws ServiceException {
        Map<Comment,Client> commentClientMap = new HashMap<>();
        ClientService clientService = new ClientService();
        for(Comment comment : comments){
            Optional<Client> clientOptional = clientService.findById(comment.getClientId());
            clientOptional.ifPresent(client -> commentClientMap.put(comment,client));
        }
        return commentClientMap;
    }
}
