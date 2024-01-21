/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.model;

import br.com.myvirtualhub.omni.commons.core.OmniPhoneNumber;
import br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmsRecipientTest {

    @Test
    void testCreateSmsRecipient() throws PhoneNumberException {
        OmniPhoneNumber omniPhoneNumber = new OmniPhoneNumber("+123456789");
        SmsRecipient recipient = new SmsRecipient(omniPhoneNumber);

        assertNotNull(recipient);
        assertEquals(omniPhoneNumber, recipient.getOmniPhoneNumber());
    }

    @Test
    void testEquals() throws PhoneNumberException {
        OmniPhoneNumber omniPhoneNumber = new OmniPhoneNumber("+123456789");
        SmsRecipient recipient1 = new SmsRecipient(omniPhoneNumber);
        SmsRecipient recipient2 = new SmsRecipient(omniPhoneNumber);
        SmsRecipient recipient3 = new SmsRecipient(new OmniPhoneNumber("987654321"));

        assertEquals(recipient1, recipient2);
        assertNotEquals(recipient1, recipient3);
    }

    @Test
    void testHashCode() throws PhoneNumberException {
        OmniPhoneNumber omniPhoneNumber = new OmniPhoneNumber("+123456789");
        SmsRecipient recipient1 = new SmsRecipient(omniPhoneNumber);
        SmsRecipient recipient2 = new SmsRecipient(omniPhoneNumber);

        assertEquals(recipient1.hashCode(), recipient2.hashCode());
    }

    @Test
    void testToString() throws PhoneNumberException {
        OmniPhoneNumber omniPhoneNumber = new OmniPhoneNumber("+123456789");
        SmsRecipient recipient = new SmsRecipient(omniPhoneNumber);

        String expectedString = "SmsRecipient{omniPhoneNumber=" + omniPhoneNumber + "}";
        assertEquals(expectedString, recipient.toString());
    }

    @Test
    void testCopy() throws PhoneNumberException {
        OmniPhoneNumber omniPhoneNumber = new OmniPhoneNumber("+123456789");

        SmsRecipient original = new SmsRecipient(omniPhoneNumber);
        SmsRecipient copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }
}
