/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.exceptions;

/**
 * This is the standard exception for all other exceptions
 * within the domain layer of the application.
 *
 * <p>It is used to encapsulate exceptions specific to the business logic
 * and entities of the domain. Derived exceptions should provide specific
 * details about the type of domain error condition they represent.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-09
 */
public class OmniException extends Exception {

    /**
     * Class representing an exception with a throwable cause in the domain layer of the application.
     * This exception is used to encapsulate exceptions specific to the business logic and entities of the domain.
     * Derived exceptions should provide specific details about the type of domain error condition they represent.
     */
    private final String throwableCause;

    /**
     * Constructs a new OmniException with the specified message.
     *
     * @param message the detail message for the exception
     */
    public OmniException(String message) {
        super(message);
        this.throwableCause = null;
    }

    /**
     * Constructs a new OmniException with the specified message and cause.
     *
     * @param message the detail message for the exception
     * @param cause   the cause of the exception (nullable)
     */
    public OmniException(String message, Throwable cause) {
        super(message, cause);
        this.throwableCause = null;
    }

    /**
     * Constructs a new OmniException with the specified message and throwableCause.
     *
     * @param message          the detail message for the exception
     * @param throwableCause  the cause of the exception as a string
     */
    public OmniException( String message, String throwableCause) {
        super(message);
        this.throwableCause = throwableCause;
    }

    /**
     * Returns the cause of this exception as a string.
     *
     * <p>If the cause of this exception is an instance of {@link OmniException},
     * the throwableCause string of the cause exception will be returned.
     * Otherwise, if the cause is not present or not an instance of OmniException,
     * null will be returned.
     *
     * @return the cause of this exception as a string, or null if not available
     */
    public String getThrowableCause() {
        return throwableCause;
    }

    @Override
    public String toString() {
        return "OmniException{" +
                "Exception.toString()=" + super.toString() +
               ", throwableCause=" + throwableCause +
               "}";
    }
}
