package com.epam.fitness.command.factory;


/**
 *  Storage of commands
 */
public enum CommandType{

    ALL_COACH_CLIENTS("all_coach_clients"),
    LOGIN("login"),
    MAIN("main"),
    PROFILE("profile"),
    COACHES("coaches"),
    SIGN_OUT("sign_out"),
    CLIENT_REGISTRATION("client_registration"),
    UPDATE_GYM_MEMBERSHIP("update_gym_membership"),
    CHOOSE_COACH("choose_coach"),
    GET_ORDER_PAGE("get_order_page"),
    SHOW_CLIENT_EXERCISES("show_client_exercises"),
    ADD_EXERCISE("add_exercise"),
    DELETE_EXERCISE("delete_exercise"),
    UPDATE_EXERCISE("update_exercise"),
    UPDATE_NUTRITION("update_nutrition"),
    SHOW_CLIENT_NUTRITION("show_client_nutrition"),
    ADD_COMMENT("add_comment"),
    SHOW_COACH_COMMENTS("show_coach_comments"),
    REJECT_COACH("reject_coach"),
    GYM_PHOTOS("gym_photos"),
    LOGIN_PAGE("login_page"),
    NO_ACCESS("no_access"),
    ORDERS("orders"),
    LANGUAGE("language");

    private String command;
    private CommandType(String command) {
        this.command = command;
    }
}
