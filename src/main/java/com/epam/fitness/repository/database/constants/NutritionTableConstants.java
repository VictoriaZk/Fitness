package com.epam.fitness.repository.database.constants;

/**
 * The enum Nutrition table constants.
 */
public enum NutritionTableConstants {

    /**
     * Id nutrition table constants.
     */
    ID("id_nutrition"),
    /**
     * Name nutrition table constants.
     */
    NAME("name"),
    /**
     * Morning nutrition nutrition table constants.
     */
    MORNING_NUTRITION("morning_nutrition"),
    /**
     * Lunch nutrition nutrition table constants.
     */
    LUNCH_NUTRITION("lunch_nutrition"),
    /**
     * Dinner nutrition nutrition table constants.
     */
    DINNER_NUTRITION("dinner_nutrition");

    private String fieldName;
    private NutritionTableConstants(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Get field name string.
     *
     * @return the string
     */
    public String getFieldName(){
        return fieldName;
    }
}



