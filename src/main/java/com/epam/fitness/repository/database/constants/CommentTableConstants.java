package com.epam.fitness.repository.database.constants;

/**
 * The enum Comment table constants.
 */
public enum CommentTableConstants {

    /**
     * Id comment table constants.
     */
    ID("id_comment"),
    /**
     * Coach id comment table constants.
     */
    COACH_ID("coach_id"),
    /**
     * Client id comment table constants.
     */
    CLIENT_ID("client_id"),
    /**
     * Comment content comment table constants.
     */
    COMMENT_CONTENT("comment_content"),
    /**
     * Password comment table constants.
     */
    PASSWORD("password");

    private String fieldName;
    private CommentTableConstants(String fieldName) {
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
