/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.commons;

import br.com.myvirtualhub.omni.domain.core.exceptions.PhoneNumberException;
import br.com.myvirtualhub.omni.domain.core.model.interfaces.Copyable;
import br.com.myvirtualhub.omni.domain.core.validator.PhoneNumberIsValidValidatorHandler;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a phone number in an application.
 * This class stores a phone number string and provides validation
 * according to international phone number formatting standards.
 *
 * <p>This is an illustration and does not cover all aspects of a real-world
 * phone number class like proper validation, formatting, etc.
 *
 * @author  Your Name
 * @version 1.0
 * @since   YourProject 1.0
 */
public class PhoneNumber implements Serializable, Copyable<PhoneNumber> {

    /**
     * Represents the content of a variable.
     *
     * <p>This class stores the content of a variable as a string.
     */
    private String content;

    /**
     * Constructs a new PhoneNumber object. The phone number must be in the format
     * of "+" followed by digits, including the country code, with no formatting.
     *
     * @param content the phone number string as entered by the user
     * @throws PhoneNumberException if the phone number is invalid
     */
    public PhoneNumber(String content) throws PhoneNumberException{
        PhoneNumberIsValidValidatorHandler validator = new PhoneNumberIsValidValidatorHandler.Builder().build();
        validator.validate(content);
        setContent(content);
    }

    /**
     * Retrieves the content of the PhoneNumber object.
     *
     * @return the content of the PhoneNumber object as a String
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the PhoneNumber object.
     *
     * @param content the new content for the PhoneNumber object
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public PhoneNumber copy() throws PhoneNumberException {
        return new PhoneNumber(getContent());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber phoneNumber)) return false;
        return getContent().equals(phoneNumber.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getContent());
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "content='" + content + '\'' +
                '}';
    }
}
