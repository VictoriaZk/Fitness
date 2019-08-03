package com.epam.fitness.repository.database.constants;

/**
 * The enum Exercise dto table constants.
 */
public enum ExerciseDtoTableConstants {

    /**
     * Id exercise dto table constants.
     */
    ID("id_exercise_program"),
    /**
     * Program id exercise dto table constants.
     */
    PROGRAM_ID("program_id"),
    /**
     * Exercise id exercise dto table constants.
     */
    EXERCISE_ID("exercise_id"),
    /**
     * Repeat number exercise dto table constants.
     */
    REPEAT_NUMBER("repeat_number"),
    /**
     * Set number exercise dto table constants.
     */
    SET_NUMBER("set_number"),
    /**
     * Number train day exercise dto table constants.
     */
    NUMBER_TRAIN_DAY("number_train_day");

    private String fieldName;
    private ExerciseDtoTableConstants(String fieldName) {
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

