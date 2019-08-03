package com.epam.fitness.repository.database.constants;

/**
 * The enum Program table constants.
 */
public enum ProgramTableConstants {

    /**
     * Id program table constants.
     */
    ID("id_program"),
    /**
     * Nutrition id program table constants.
     */
    NUTRITION_ID("nutrition_id"),
    /**
     * Trains per week program table constants.
     */
    TRAINS_PER_WEEK("trains_per_week");

    private String fieldName;
    private ProgramTableConstants(String fieldName) {
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




