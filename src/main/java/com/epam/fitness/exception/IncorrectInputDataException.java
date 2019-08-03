package com.epam.fitness.exception;

/**
 * The type Incorrect input data exception.
 */
public class IncorrectInputDataException extends Exception {
    /**
     * Instantiates a new Incorrect input data exception.
     *
     * @param message the message
     */
    public IncorrectInputDataException(String message){
        super(message);
    }

    /**
     * Instantiates a new Incorrect input data exception.
     */
    public IncorrectInputDataException(){ }

    /**
     * Instantiates a new Incorrect input data exception.
     *
     * @param th the th
     */
    public IncorrectInputDataException(Throwable th){
        super(th);
    }

    /**
     * Instantiates a new Incorrect input data exception.
     *
     * @param m  the m
     * @param th the th
     */
    public IncorrectInputDataException(String m, Throwable th){
        super(m,th);
    }
}
