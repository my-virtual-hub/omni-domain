/*
 * Copyright 2024 My Virtual Hub
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
