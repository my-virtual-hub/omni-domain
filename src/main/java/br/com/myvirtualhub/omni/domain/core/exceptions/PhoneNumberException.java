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
    public PhoneNumberException(String message) {
        super(message);
    }

    public PhoneNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneNumberException( String message , String throwableCause) {
        super(message, throwableCause);
    }
}
