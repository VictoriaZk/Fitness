package com.epam.fitness.builder;

import com.epam.fitness.exception.RepositoryException;
import com.epam.fitness.model.Nutrition;
import com.epam.fitness.repository.database.constants.NutritionTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Designed to build an object of type {@link com.epam.fitness.model.Nutrition} with specified characteristics.
 */
public class NutritionBuilder implements Builder<Nutrition> {

    @Override
    public Nutrition build(ResultSet resultSet) throws RepositoryException {
        try {
            Long idNutrition = resultSet.getLong(NutritionTableConstants.ID.getFieldName());
            String name = resultSet.getString(NutritionTableConstants.NAME.getFieldName());
            String morningNutrition = resultSet.getString(NutritionTableConstants.MORNING_NUTRITION.getFieldName());
            String lunchNutrition = resultSet.getString(NutritionTableConstants.LUNCH_NUTRITION.getFieldName());
            String dinnerNutrition = resultSet.getString(NutritionTableConstants.DINNER_NUTRITION.getFieldName());
            return new Nutrition(idNutrition,name,morningNutrition,lunchNutrition,dinnerNutrition);
        }catch (SQLException exception){
            throw new RepositoryException(exception.getMessage(),exception);
        }
    }
}
