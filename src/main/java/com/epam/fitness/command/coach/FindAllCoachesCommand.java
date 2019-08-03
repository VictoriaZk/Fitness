package com.epam.fitness.command.coach;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Coach;
import com.epam.fitness.service.CoachService;
import com.epam.fitness.utils.CurrentMembershipValidChecker;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

import static com.epam.fitness.command.coach.constant.ParameterConstants.*;
import static com.epam.fitness.command.comment.constant.TextConstants.MAX_NUMBER_SYMBOLS_ATTRIBUTE;
import static com.epam.fitness.command.comment.constant.TextConstants.MAX_NUMBER_SYMBOLS_VALUE;

/**
 * Designed to represent all available coaches
 */
public class FindAllCoachesCommand implements Command {

    private static final Logger LOGGER = Logger.getLogger(FindAllCoachesCommand.class.getName());
    private CurrentMembershipValidChecker membershipValidChecker = new CurrentMembershipValidChecker();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Long clientId = (Long) session.getAttribute(SessionAttributes.ID);
        CoachService coachService = new CoachService();
        List<Coach> coaches = coachService.findAll();
        request.setAttribute(COACHES,coaches);
        checkAndSetIfClientHasCoach(request,clientId);
        if(!membershipValidChecker.isCurrentMembershipValid(clientId)){
            LOGGER.info("Membership still not purchased");
            return new CommandResult(COACHES_PAGE,false);
        }else {
            request.setAttribute(MAX_NUMBER_SYMBOLS_ATTRIBUTE,MAX_NUMBER_SYMBOLS_VALUE);
            request.setAttribute(IS_MEMBERSHIP_VALID, true);
        }
        return new CommandResult(COACHES_PAGE, false);
    }

    private void checkAndSetIfClientHasCoach(HttpServletRequest request, Long clientId) throws ServiceException {
        CoachService coachService = new CoachService();
        Optional<Coach> coachOptional = coachService.findByClientId(clientId);
        coachOptional.ifPresent(coach -> request.setAttribute(ID_OF_CLIENT_COACH, coach.getId()));
    }


}

