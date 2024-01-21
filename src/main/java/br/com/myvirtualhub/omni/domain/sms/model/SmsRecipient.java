/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.model;

import br.com.myvirtualhub.omni.commons.core.OmniPhoneNumber;
import br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException;
import br.com.myvirtualhub.omni.commons.interfaces.Copyable;
import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

/**
 * Represents the recipient of an SMS message in the application.
 *
 * <p>Currently, this class only supports recipients identified by a {@link OmniPhoneNumber}.
 * Future implementations may extend support to other types of recipients.
 *
 * @author  Marco Quiçula
 * @version 1.0
 * @since   2024-01-09
 * @see     OmniPhoneNumber
 */
public class SmsRecipient implements Model, Copyable<SmsRecipient> {

    private final OmniPhoneNumber omniPhoneNumber;

    /**
     * Represents the recipient of an SMS message in the application.
     *
     * <p>Currently, this class only supports recipients identified by a {@link OmniPhoneNumber}.
     * Future implementations may extend support to other types of recipients.
     *
     * @param phoneNumber the phone number of the recipient
     * @see OmniPhoneNumber
     */
    public SmsRecipient(OmniPhoneNumber phoneNumber) {
        this.omniPhoneNumber = phoneNumber;
    }

    /**
     * Retrieves the phone number of the SmsRecipient.
     *
     * @return the phone number of the SmsRecipient
     * @see OmniPhoneNumber
     */
    public OmniPhoneNumber getOmniPhoneNumber() {
        return omniPhoneNumber;
    }

    /**
     * Creates a copy of the {@link SmsRecipient} object.
     *
     * @return a copy of the SmsRecipient object
     * @throws PhoneNumberException if there is an issue with the phone number
     * @see SmsRecipient
     */
    @Override
    public SmsRecipient copy() throws PhoneNumberException {
        return new SmsRecipient(omniPhoneNumber.copy());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsRecipient that)) return false;
        return omniPhoneNumber.equals(that.omniPhoneNumber);
    }

    @Override
    public int hashCode() {
        return omniPhoneNumber.hashCode();
    }

    @Override
    public String toString() {
        return "SmsRecipient{" +
                "omniPhoneNumber=" + omniPhoneNumber +
                '}';
    }
}
