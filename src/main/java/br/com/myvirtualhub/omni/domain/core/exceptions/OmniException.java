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

    private final String throwableCause;

    public OmniException(String message) {
        super(message);
        this.throwableCause = null;
    }

    public OmniException(String message, Throwable cause) {
        super(message, cause);
        this.throwableCause = null;
    }

    public OmniException( String message, String throwableCause) {
        super(message);
        this.throwableCause = throwableCause;
    }

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
