package com.epam.fitness.exception;

/**
 * The type Repository exception.
 */
public class RepositoryException extends Exception {

    /**
     * Instantiates a new Repository exception.
     *
     * @param message the message
     */
    public RepositoryException(String message){
        super(message);
    }

    /**
     * Instantiates a new Repository exception.
     */
    public RepositoryException(){ }

    /**
     * Instantiates a new Repository exception.
     *
     * @param th the th
     */
    public RepositoryException(Throwable th){
        super(th);
    }

    /**
     * Instantiates a new Repository exception.
     *
     * @param m  the m
     * @param th the th
     */
    public RepositoryException(String m, Throwable th){
        super(m,th);
    }
}
