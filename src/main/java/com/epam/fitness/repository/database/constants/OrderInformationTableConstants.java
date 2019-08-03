package com.epam.fitness.repository.database.constants;

/**
 * The enum Order information table constants.
 */
public enum OrderInformationTableConstants {

    /**
     * Id order information table constants.
     */
    ID("id_order_information"),
    /**
     * Cost order information table constants.
     */
    COST("cost"),
    /**
     * Payment data order information table constants.
     */
    PAYMENT_DATA("payment_data"),
    /**
     * Membership end date order information table constants.
     */
    MEMBERSHIP_END_DATE("membership_end_date"),
    /**
     * Card number order information table constants.
     */
    CARD_NUMBER("card_number"),
    /**
     * Client id order information table constants.
     */
    CLIENT_ID("client_id");

    private String fieldName;
    private OrderInformationTableConstants(String fieldName) {
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




