/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.interfaces;

import br.com.myvirtualhub.omni.domain.core.exceptions.PhoneNumberException;

/**
 * Copyable is an interface that defines the contract for creating a copy of an object.
 * Classes implementing this interface should provide an implementation for the {@link #copy()} method
 * which returns a copy of the object.
 *
 * @param <T> the type of object that this Copyable interface can create a copy of
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-13
 */
public interface Copyable<T> {
    /**
     * Creates a copy of the object.
     *
     * @return a copy of the object
     * @throws PhoneNumberException if there is an issue with phone number operations while creating the copy
     */
    T copy() throws PhoneNumberException;
}