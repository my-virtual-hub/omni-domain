/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.interfaces;

import br.com.myvirtualhub.omni.domain.core.exceptions.OmniException;

/**
 * The ValidatorHandler interface defines the contract for classes that handle validation of a given value.
 *
 * @param <V> the type of value to be validated
 * @param <E> the type of exception to be thrown in case of validation failure
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-11
 */
public interface ValidatorHandler<V, E extends OmniException> {

    /**
     * Performs the handling of a request by validating the given value and passing it to the next
     * handler if one exists.
     *
     * @param value the value to be validated and processed
     * @throws E if the validation fails, and the specific exception type provided in the generic
     *           declaration of the ValidatorHandler interface
     */
    default void handleRequest(V value) throws E {
        validate(value);
        if (getNext() != null) {
            getNext().handleRequest(value);
        }
    }

    /**
     * Validates the given value.
     *
     * @param value the value to be validated
     * @throws E if the validation fails and the specific exception type provided in the generic declaration is thrown
     */
    void validate(V value) throws E;

    /**
     * Retrieves the next ValidatorHandler in the chain.
     *
     * @return the next ValidatorHandler in the chain, or null if there is no next handler
     */
    ValidatorHandler<V, E> getNext();

    /**
     * Sets the next ValidatorHandler in the chain.
     *
     * @param next the next ValidatorHandler in the chain
     */
    void setNext(ValidatorHandler<V, E> next);
}
