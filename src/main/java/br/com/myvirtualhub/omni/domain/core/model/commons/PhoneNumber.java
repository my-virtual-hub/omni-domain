/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.commons;

import br.com.myvirtualhub.omni.domain.core.exceptions.PhoneNumberException;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

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
public class PhoneNumber {

    private String content;

    /**
     * Constructs a new PhoneNumber object. The phone number must be in the format
     * of "+" followed by digits, including the country code, with no formatting.
     *
     * @param content the phone number string as entered by the user
     */
    public PhoneNumber(String content) throws PhoneNumberException{
        Objects.requireNonNull(content, "PhoneNumber content cannot be null");
        if (!content.matches("\\+\\d+")) {
            throw new IllegalArgumentException("PhoneNumber content must be in the format of '+' followed by digits.");
        }
        setContent(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws PhoneNumberException {
        Objects.requireNonNull(content, "PhoneNumber content cannot be null");
        try {
            PhoneNumberUtil.getInstance().isValidNumber(PhoneNumberUtil.getInstance().parse(content, "BR"));
        } catch (NumberParseException e) {
            throw new PhoneNumberException("Invalid phone number", e.toString());
        }
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber phoneNumber)) return false;
        return getContent().equals(phoneNumber.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent());
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "content='" + content + '\'' +
                '}';
    }
}
