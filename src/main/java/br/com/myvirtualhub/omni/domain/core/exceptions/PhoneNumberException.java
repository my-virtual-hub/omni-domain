/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.exceptions;

/**
 * Exception used to indicate issues with phone number operations.
 *
 * <p>This is a specific type of {@link OmniException}. It should be used
 * for exceptional conditions related to phone number processing such as
 * validation, formatting, parsing, or other phone number related errors.
 *
 * @author  Marco Quiçula
 * @version 1.0
 * @since   2024-01-09
 */
public class PhoneNumberException extends OmniException{
    /**
     * Constructs a new PhoneNumberException with the specified message.
     *
     * @param message the detail message for the exception
     */
    public PhoneNumberException(String message) {
        super(message);
    }

    /**
     * Constructs a new PhoneNumberException with the specified message and cause.
     *
     * @param message the detail message for the exception
     * @param cause   the cause of the exception
     * @throws NullPointerException if the message is null
     */
    public PhoneNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Exception used to indicate issues with phone number operations.
     *
     * <p>This is a specific type of {@link OmniException}. It should be used
     * for exceptional conditions related to phone number processing such as
     * validation, formatting, parsing, or other phone number related errors.
     *
     * @param message          the detail message for the exception
     * @param throwableCause  the cause of the exception as a string
     */
    public PhoneNumberException( String message , String throwableCause) {
        super(message, throwableCause);
    }
}
