package com.epam.fitness.command.nutrition;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.command.session.SessionAttributes;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Nutrition;
import com.epam.fitness.model.UserRole;
import com.epam.fitness.service.NutritionService;
import com.epam.fitness.utils.CurrentMembershipValidChecker;
import com.epam.fitness.utils.page.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static com.epam.fitness.command.comment.constant.TextConstants.MAX_NUMBER_SYMBOLS_ATTRIBUTE;
import static com.epam.fitness.command.comment.constant.TextConstants.MAX_NUMBER_SYMBOLS_VALUE;
import static com.epam.fitness.command.nutrition.constant.TextConstans.*;

/**
 * Designed to represent nutrition
 */
public class ShowClientNutritionCommand implements Command {

    private CurrentMembershipValidChecker membershipValidChecker = new CurrentMembershipValidChecker();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        String role = String.valueOf(session.getAttribute(SessionAttributes.ROLE));
        request.setAttribute(MAX_NUMBER_SYMBOLS_ATTRIBUTE,MAX_NUMBER_SYMBOLS_VALUE);
        Long clientId;
        if(role.equals(UserRole.COACH)){
            if(session.getAttribute(COACH_CLIENT_ID)==null){
                request.setAttribute(NO_ACCESS_PAGE_ERROR,true);
                return new CommandResult(Page.HOME_PAGE.getPage(),false);
            }
            clientId = getClientIdForAppropriateCoach(session,request);
        }
        else{
            clientId = (Long) session.getAttribute(SessionAttributes.ID);
            if(!membershipValidChecker.isCurrentMembershipValid(clientId)){
                request.setAttribute(IS_MEMBERSHIP_VALID, false);
                return new CommandResult(Page.CLIENT_NUTRITION_PAGE.getPage(),false);
            }else {
                request.setAttribute(IS_MEMBERSHIP_VALID, true);
            }
        }

        NutritionService nutritionService = new NutritionService();
        Optional<Nutrition> nutritionOptional = nutritionService.findByClientId(clientId);
        nutritionOptional.ifPresent(nutrition -> request.setAttribute(NUTRITION,nutrition));
        return new CommandResult(Page.CLIENT_NUTRITION_PAGE.getPage(),false);
    }

    private Long getClientIdForAppropriateCoach(HttpSession session,HttpServletRequest request){
        String clientIdString = request.getParameter(COACH_CLIENT_ID);
        Long clientId;
        if(clientIdString==null){
            clientId= (Long) session.getAttribute(COACH_CLIENT_ID);
        }else{
            clientId= Long.valueOf(request.getParameter(COACH_CLIENT_ID));
            session.setAttribute(COACH_CLIENT_ID,clientId);
        }
        return clientId;
    }
}
