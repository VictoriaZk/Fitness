package com.epam.fitness.repository.database.constants;

/**
 * The enum Client table constants.
 */
public enum ClientTableConstants {

    /**
     * Id client table constants.
     */
    ID("id_client"),
    /**
     * Coach id client table constants.
     */
    COACH_ID("coach_id"),
    /**
     * Name client table constants.
     */
    NAME("name"),
    /**
     * Surname client table constants.
     */
    SURNAME("surname"),
    /**
     * Login client table constants.
     */
    LOGIN("login"),
    /**
     * Password client table constants.
     */
    PASSWORD("password"),
    /**
     * Membership purchased number client table constants.
     */
    MEMBERSHIP_PURCHASED_NUMBER("membership_purchased_number"),
    /**
     * Personal discount client table constants.
     */
    PERSONAL_DISCOUNT("personal_discount"),
    /**
     * Program id client table constants.
     */
    PROGRAM_ID("program_id");

    private String fieldName;
    private ClientTableConstants(String fieldName) {
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
