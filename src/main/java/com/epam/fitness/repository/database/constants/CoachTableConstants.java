package com.epam.fitness.repository.database.constants;

/**
 * The enum Coach table constants.
 */
public enum CoachTableConstants {

    /**
     * Id coach table constants.
     */
    ID("id_coach"),
    /**
     * Name coach table constants.
     */
    NAME("name"),
    /**
     * Surname coach table constants.
     */
    SURNAME("surname"),
    /**
     * Login coach table constants.
     */
    LOGIN("login"),
    /**
     * Password coach table constants.
     */
    PASSWORD("password");

    private String fieldName;
    private CoachTableConstants(String fieldName) {
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
