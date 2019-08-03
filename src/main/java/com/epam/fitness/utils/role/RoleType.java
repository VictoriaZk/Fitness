package com.epam.fitness.utils.role;

/**
 * The enum Role type.
 */
public enum RoleType {

    /**
     * Client role type.
     */
    CLIENT("client"),
    /**
     * Coach role type.
     */
    COACH("coach");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
