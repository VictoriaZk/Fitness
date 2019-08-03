package com.epam.fitness.command.exercise.constant;

import com.epam.fitness.command.exercise.UpdateExerciseCommand;
import org.apache.log4j.Logger;

/**
 * The type Text constants.
 */
public class TextConstants {
    /**
     * The constant PROFILE_PAGE.
     */
    public final static String PROFILE_PAGE = "/controller?command=show_client_exercises";
    /**
     * The constant COACH_CLIENT_PAGE.
     */
    public final static String COACH_CLIENT_PAGE = "/controller?command=all_coach_clients";
    /**
     * The constant CLIENT_EXERCISE_PAGE.
     */
    public final static String CLIENT_EXERCISE_PAGE = "/controller?command=show_client_exercises";
    /**
     * The constant INCORRECT_INPUT_DATA_ERROR.
     */
    public final static String INCORRECT_INPUT_DATA_ERROR = "incorrect_input_data_error";
    /**
     * The constant REPEATS.
     */
    public static final String REPEATS = "repeats";
    /**
     * The constant SET_NUMBER.
     */
    public static final String SET_NUMBER = "set_number";
    /**
     * The constant TRAIN_DAY.
     */
    public static final String TRAIN_DAY = "trainDay";
    /**
     * The constant PROGRAM_ID.
     */
    public static final String PROGRAM_ID = "programId";
    /**
     * The constant EXERCISE_ID.
     */
    public static final String EXERCISE_ID = "exerciseId";
    /**
     * The constant COACH_CLIENT_ID.
     */
    public final static String COACH_CLIENT_ID = "coach_client_id";
    /**
     * The constant EXERCISE_DTO_ID.
     */
    public final static String EXERCISE_DTO_ID = "exerciseDtoId";
    /**
     * The constant INVALID_EXERCISE_ID_FORMAT.
     */
    public final static String INVALID_EXERCISE_ID_FORMAT = "invalid_exercise_id_format";
    /**
     * The constant NOT_EXIST_EXERCISE_ID.
     */
    public final static String NOT_EXIST_EXERCISE_ID = "not_exist_exercise_id";
    /**
     * The constant PROGRAM.
     */
    public final static String PROGRAM = "program";
    /**
     * The constant EXERCISE_PAGE.
     */
    public final static String EXERCISE_PAGE = "/WEB-INF/client/clientExercise.jsp";
    /**
     * The constant IS_MEMBERSHIP_VALID.
     */
    public final static String IS_MEMBERSHIP_VALID = "is_membership_valid";
    /**
     * The constant EXERCISES.
     */
    public final static String EXERCISES = "exercises";
    /**
     * The constant LOGGER.
     */
    public static final Logger LOGGER = Logger.getLogger(UpdateExerciseCommand.class.getName());
}
