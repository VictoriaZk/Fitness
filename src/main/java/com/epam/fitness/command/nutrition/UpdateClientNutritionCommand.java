package com.epam.fitness.command.nutrition;

import com.epam.fitness.command.Command;
import com.epam.fitness.command.CommandResult;
import com.epam.fitness.exception.ServiceException;
import com.epam.fitness.model.Nutrition;
import com.epam.fitness.service.NutritionService;
import com.epam.fitness.utils.RequestParameterValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static com.epam.fitness.command.nutrition.constant.TextConstans.*;

/**
 * Designed to update nutrition
 */
public class UpdateClientNutritionCommand implements Command {


    private static final Logger LOGGER = Logger.getLogger(UpdateClientNutritionCommand.class.getName());
    private final RequestParameterValidator parameterValidator = new RequestParameterValidator();

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String newNutritionDescription = request.getParameter(NUTRITION_DESCRIPTION);
        if(newNutritionDescription==null || !parameterValidator.isNutritionDescriptionValid(newNutritionDescription)){
            LOGGER.info("incorrect nutrition description");
            return forwardToNutritionPageWithError(request,INCORRECT_INPUT_NUTRITION_DATA_ERROR);
        }
        String nutritionIdString = request.getParameter(NUTRITION_ID);
        if(nutritionIdString==null || !isNutritionExist(nutritionIdString)){
            LOGGER.info("nutrition with id:" + nutritionIdString + " doesn't exist");
            return forwardToNutritionPageWithError(request,NOT_EXIST_NUTRITION_ID);
        }
        Long nutritionId = Long.parseLong(request.getParameter(NUTRITION_ID));
        String nutritionTime = request.getParameter(NUTRITION_TIME);
        setNewNutrition(nutritionId,nutritionTime,newNutritionDescription);

        LOGGER.info("nutrition with id:" + nutritionIdString + " has been changed");
        return new CommandResult(PROFILE_PAGE,true);
    }

    private void setNewNutrition(Long nutritionId,String nutritionTime, String newNutritionDescription) throws ServiceException {
        NutritionService nutritionService = new NutritionService();
        Optional<Nutrition> nutritionOptional = nutritionService.findById(nutritionId);
        switch (nutritionTime){
            case MORNING : {
                nutritionOptional.ifPresent(nutrition -> nutrition.setMorningNutrition(newNutritionDescription));
                break;
            }
            case LUNCH : {
                nutritionOptional.ifPresent(nutrition -> nutrition.setLunchNutrition(newNutritionDescription));
                break;
            }
            case DINNER : {
                nutritionOptional.ifPresent(nutrition -> nutrition.setDinnerNutrition(newNutritionDescription));
                break;
            }
        }
        if(nutritionOptional.isPresent()){
            nutritionService.save(nutritionOptional.get());
        }
    }

    private CommandResult forwardToNutritionPageWithError(HttpServletRequest request,String error) {
        request.setAttribute(error, true);
        return new CommandResult(CLIENT_EXERCISE_PAGE,false);
    }

    private boolean isNutritionExist(String nutritionIdString) throws ServiceException {
        Long nutritionId = Long.valueOf(nutritionIdString);
        NutritionService nutritionService = new NutritionService();
        Optional<Nutrition> nutrition = nutritionService.findById(nutritionId);
        return nutrition.isPresent();
    }
}
