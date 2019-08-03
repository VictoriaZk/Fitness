package com.epam.fitness.repository.database.constants;

/**
 * The enum Exercise table constants.
 */
public enum ExerciseTableConstants {

    /**
     * Id exercise table constants.
     */
    ID("id_exercise"),
    /**
     * Name exercise table constants.
     */
    NAME("name"),
    /**
     * Description exercise table constants.
     */
    DESCRIPTION("description"),
    /**
     * Image exercise table constants.
     */
    IMAGE("image");

    private String fieldName;
    private ExerciseTableConstants(String fieldName) {
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


