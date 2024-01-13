/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.model;

import br.com.myvirtualhub.omni.domain.core.commons.PhoneNumber;
import br.com.myvirtualhub.omni.domain.core.exceptions.PhoneNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmsRecipientTest {

    @Test
    void testCreateSmsRecipient() throws PhoneNumberException {
        PhoneNumber phoneNumber = new PhoneNumber("+123456789");
        SmsRecipient recipient = new SmsRecipient(phoneNumber);

        assertNotNull(recipient);
        assertEquals(phoneNumber, recipient.getPhoneNumber());
    }

    @Test
    void testEquals() throws PhoneNumberException {
        PhoneNumber phoneNumber = new PhoneNumber("+123456789");
        SmsRecipient recipient1 = new SmsRecipient(phoneNumber);
        SmsRecipient recipient2 = new SmsRecipient(phoneNumber);
        SmsRecipient recipient3 = new SmsRecipient(new PhoneNumber("987654321"));

        assertEquals(recipient1, recipient2);
        assertNotEquals(recipient1, recipient3);
    }

    @Test
    void testHashCode() throws PhoneNumberException {
        PhoneNumber phoneNumber = new PhoneNumber("+123456789");
        SmsRecipient recipient1 = new SmsRecipient(phoneNumber);
        SmsRecipient recipient2 = new SmsRecipient(phoneNumber);

        assertEquals(recipient1.hashCode(), recipient2.hashCode());
    }

    @Test
    void testToString() throws PhoneNumberException {
        PhoneNumber phoneNumber = new PhoneNumber("+123456789");
        SmsRecipient recipient = new SmsRecipient(phoneNumber);

        String expectedString = "SmsRecipient{phoneNumber=" + phoneNumber + "}";
        assertEquals(expectedString, recipient.toString());
    }

    @Test
    void testCopy() throws PhoneNumberException {
        PhoneNumber phoneNumber = new PhoneNumber("+123456789");

        SmsRecipient original = new SmsRecipient(phoneNumber);
        SmsRecipient copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }
}
