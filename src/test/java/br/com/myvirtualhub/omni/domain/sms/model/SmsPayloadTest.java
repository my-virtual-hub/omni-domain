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

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class SmsPayloadTest {

    @Test
    void testSmsPayloadCreationAndGetters() throws PhoneNumberException {
        SmsRecipient recipient = new SmsRecipient(new OmniPhoneNumber("+123456789"));
        SmsMessage message = new SmsMessage("Test message", StandardCharsets.UTF_8);
        String clientMessageId = "client-123";

        SmsPayload payload = new SmsPayload(recipient, message, clientMessageId);

        assertNotNull(payload);
        assertEquals(recipient, payload.getRecipient());
        assertEquals(message, payload.getMessage());
        assertEquals(clientMessageId, payload.getClientMessageId());
    }

    @Test
    void testSetters() throws PhoneNumberException {
        SmsRecipient recipient = new SmsRecipient(new OmniPhoneNumber("+123456789"));
        SmsMessage message = new SmsMessage("Test message", StandardCharsets.UTF_8);
        String clientMessageId = "client-123";

        SmsPayload payload = new SmsPayload(recipient, message, clientMessageId);

        SmsRecipient newRecipient = new SmsRecipient(new OmniPhoneNumber("987654321"));
        SmsMessage newMessage = new SmsMessage("New test message", StandardCharsets.UTF_8);
        String newClientMessageId = "client-456";

        payload.setRecipient(newRecipient);
        payload.setMessage(newMessage);
        payload.setClientMessageId(newClientMessageId);

        assertEquals(newRecipient, payload.getRecipient());
        assertEquals(newMessage, payload.getMessage());
        assertEquals(newClientMessageId, payload.getClientMessageId());
    }

    @Test
    void testEqualsAndHashCode() throws PhoneNumberException {
        SmsRecipient recipient = new SmsRecipient(new OmniPhoneNumber("+123456789"));
        SmsMessage message = new SmsMessage("Test message", StandardCharsets.UTF_8);
        String clientMessageId = "client-123";

        SmsPayload payload1 = new SmsPayload(recipient, message, clientMessageId);

        SmsPayload payload2 = payload1.copy();

        assertEquals(payload1, payload2);
        assertEquals(payload1.hashCode(), payload2.hashCode());
    }

    @Test
    void testToString() throws PhoneNumberException {
        SmsRecipient recipient = new SmsRecipient(new OmniPhoneNumber("+123456789"));
        SmsMessage message = new SmsMessage("Test message", StandardCharsets.UTF_8);
        String clientMessageId = "client-123";

        SmsPayload payload = new SmsPayload(recipient, message, clientMessageId);

        String payloadString = payload.toString();

        assertTrue(payloadString.contains("recipient=" + recipient));
        assertTrue(payloadString.contains("message=" + message));
        assertTrue(payloadString.contains("clientMessageId=" + clientMessageId));
    }

    @Test
    void testCopy() throws PhoneNumberException {
        SmsRecipient recipient = new SmsRecipient(new OmniPhoneNumber("+123456789"));
        SmsMessage message = new SmsMessage("Test message", StandardCharsets.UTF_8);
        String clientMessageId = "client-123";

        SmsPayload original = new SmsPayload(recipient, message, clientMessageId);
        SmsPayload copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }
}
