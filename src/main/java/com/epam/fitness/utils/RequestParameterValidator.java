package com.epam.fitness.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Request parameter validator.
 */
public class RequestParameterValidator {

    private static final Pattern LOGIN_PATTERN = Pattern.compile("^[a-zA-Z][\\w-_.]{1,20}$");
    private static final Pattern NAME_SURNAME_PATTERN = Pattern.compile("^[a-zA-Z]{2,20}");
    private static final Pattern SET_NUMBER_REPEATS = Pattern.compile("^[1-9]{1,2}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("[\\w-_.]{3,20}$");
    private static final Pattern CARD_NUMBER_PATTERN = Pattern.compile("^[1-9]{16}");
    private static final Pattern INPUT_TEXT_PATTERN = Pattern.compile("^[A-Za-z0-9][A-Za-z,.()\\s0-9]{1,300}");
    private static final Pattern INPUT_IDENTIFIABLE_ID_PATTERN = Pattern.compile("[\\d]{1,20}");
    private static final Pattern COST_PATTERN = Pattern.compile("[\\d.]{1,20}");

    /**
     * Is login valid boolean.
     *
     * @param login the login
     * @return the boolean
     */
    public boolean isLoginValid(String login){
        Matcher matcher = LOGIN_PATTERN.matcher(login);
        return matcher.matches();
    }

    /**
     * Is name valid boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean isNameValid(String name){
        Matcher matcher = NAME_SURNAME_PATTERN.matcher(name);
        return matcher.matches();
    }

    /**
     * Is surname valid boolean.
     *
     * @param surname the surname
     * @return the boolean
     */
    public boolean isSurnameValid(String surname){
        Matcher matcher = NAME_SURNAME_PATTERN.matcher(surname);
        return matcher.matches();
    }

    /**
     * Is password valid boolean.
     *
     * @param password the password
     * @return the boolean
     */
    public boolean isPasswordValid(String password){
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    /**
     * Is set number valid boolean.
     *
     * @param setNumber the set number
     * @return the boolean
     */
    public boolean isSetNumberValid(String setNumber){
        Matcher matcher = SET_NUMBER_REPEATS.matcher(setNumber);
        return matcher.matches();
    }

    /**
     * Is repeats valid boolean.
     *
     * @param repeats the repeats
     * @return the boolean
     */
    public boolean isRepeatsValid(String repeats){
        Matcher matcher = SET_NUMBER_REPEATS.matcher(repeats);
        return matcher.matches();
    }

    /**
     * Is card number valid boolean.
     *
     * @param cardNumber the card number
     * @return the boolean
     */
    public boolean isCardNumberValid(String cardNumber){
        Matcher matcher = CARD_NUMBER_PATTERN.matcher(cardNumber);
        return matcher.matches();
    }

    /**
     * Is nutrition description valid boolean.
     *
     * @param description the description
     * @return the boolean
     */
    public boolean isNutritionDescriptionValid(String description){
        Matcher matcher = INPUT_TEXT_PATTERN.matcher(description);
        return matcher.matches();
    }

    /**
     * Is comment content valid boolean.
     *
     * @param commentContent the comment content
     * @return the boolean
     */
    public boolean isCommentContentValid(String commentContent){
        Matcher matcher = INPUT_TEXT_PATTERN.matcher(commentContent);
        return matcher.matches();
    }

    /**
     * Is identifiable id valid boolean.
     *
     * @param userId the user id
     * @return the boolean
     */
    public boolean isIdentifiableIdValid(String userId){
        Matcher matcher = INPUT_IDENTIFIABLE_ID_PATTERN.matcher(userId);
        return matcher.matches();
    }

    /**
     * Is cost valid boolean.
     *
     * @param cost the cost
     * @return the boolean
     */
    public boolean isCostValid(String cost){
        Matcher matcher = COST_PATTERN.matcher(cost);
        return matcher.matches();
    }

}
