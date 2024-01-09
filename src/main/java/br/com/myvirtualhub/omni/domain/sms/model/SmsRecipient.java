/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.model;

import br.com.myvirtualhub.omni.domain.core.model.commons.PhoneNumber;

/**
 * Represents the recipient of an SMS message in the application.
 *
 * <p>Currently, this class only supports recipients identified by a {@link PhoneNumber}.
 * Future implementations may extend support to other types of recipients.
 *
 * @author  Marco Quiçula
 * @version 1.0
 * @since   2024-01-09
 * @see     PhoneNumber
 */
public class SmsRecipient {

    private final PhoneNumber phoneNumber;

    public SmsRecipient(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsRecipient that)) return false;
        return phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }

    @Override
    public String toString() {
        return "SmsRecipient{" +
                "phoneNumber=" + phoneNumber +
                '}';
    }
}
