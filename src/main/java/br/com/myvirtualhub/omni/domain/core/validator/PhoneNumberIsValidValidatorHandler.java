/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.validator;

import br.com.myvirtualhub.omni.domain.core.exceptions.PhoneNumberException;
import br.com.myvirtualhub.omni.domain.core.interfaces.ValidatorHandler;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import java.util.Objects;

/**
 * The PhoneNumberIsValidValidatorHandler class is responsible for validating a phone number string
 * according to international phone number formatting standards.
 * It implements the ValidatorHandler interface.
 *
 */
public class PhoneNumberIsValidValidatorHandler implements ValidatorHandler<String, PhoneNumberException> {
    private final PhoneNumberUtil phoneNumberUtil;
    private ValidatorHandler<String, PhoneNumberException> next;

    /**
     * The PhoneNumberIsValidValidatorHandler class is responsible for validating a phone number string
     * according to international phone number formatting standards.
     * It implements the ValidatorHandler interface.
     *
     */
    public PhoneNumberIsValidValidatorHandler() {
        this.phoneNumberUtil = PhoneNumberUtil.getInstance();
    }

    /**
     * Validates a phone number string according to international phone number formatting standards.
     *
     * @param value the phone number string to be validated
     * @throws PhoneNumberException if the phone number is invalid
     */
    @Override
    public void validate(String value) throws PhoneNumberException {
        Objects.requireNonNull(value, "PhoneNumberIsValidValidatorHandler value cannot be null");
        try {
            phoneNumberUtil.parse(value, "BR");
        } catch (NumberParseException e) {
            throw new PhoneNumberException("Invalid phone number", e);
        }
    }

    /**
     * Retrieves the next ValidatorHandler in the chain.
     *
     * @return the next ValidatorHandler in the chain, or null if there is no next handler
     */
    @Override
    public ValidatorHandler<String, PhoneNumberException> getNext() {
        return next;
    }

    /**
     * Sets the next ValidatorHandler in the chain.
     *
     * @param next the next ValidatorHandler in the chain
     */
    @Override
    public void setNext(ValidatorHandler<String, PhoneNumberException> next) {
        this.next = next;
    }

    /**
     * The Builder class is responsible for building instances of PhoneNumberIsValidValidatorHandler.
     */
    public static class Builder {
        private ValidatorHandler<String, PhoneNumberException> nextBuilder;

        /**
         * Sets the next ValidatorHandler in the chain.
         *
         * @param next the next ValidatorHandler in the chain
         * @return the next ValidatorHandler in the chain
         */
        public Builder withNext(ValidatorHandler<String, PhoneNumberException> next) {
            this.nextBuilder = next;
            return this;
        }

        /**
         * Builds an instance of PhoneNumberIsValidValidatorHandler.
         * The PhoneNumberIsValidValidatorHandler class is responsible for validating a phone number string
         * according to international phone number formatting standards.
         *
         * @return an instance of PhoneNumberIsValidValidatorHandler
         */
        public PhoneNumberIsValidValidatorHandler build() {
            PhoneNumberIsValidValidatorHandler handler = new PhoneNumberIsValidValidatorHandler();
            handler.setNext(nextBuilder);
            return handler;
        }
    }
}
