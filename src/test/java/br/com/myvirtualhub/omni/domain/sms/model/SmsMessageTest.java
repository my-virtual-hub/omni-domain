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

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class SmsMessageTest {

    @Test
    void testConstructorWithValidArguments() {
        String content = "Test Message";
        Charset charset = StandardCharsets.UTF_8;

        SmsMessage sms = new SmsMessage(content, charset);

        assertEquals(content, sms.getContent());
        assertEquals(charset, sms.getEncodingType());
    }

    @Test
    void testConstructorWithNullContentThrowsException() {
        assertThrows(NullPointerException.class, () ->
                new SmsMessage(null, StandardCharsets.UTF_8)
        );
    }

    @Test
    void testConstructorWithNullEncodingTypeThrowsException() {
        assertThrows(NullPointerException.class, () ->
                new SmsMessage("Test Message", null)
        );
    }

    @Test
    void testEqualsAndHashCode() {
        String content = "Test Message";
        Charset charset = StandardCharsets.UTF_8;

        SmsMessage sms1 = new SmsMessage(content, charset);
        SmsMessage sms2 = new SmsMessage(content, charset);

        assertEquals(sms1, sms2);
        assertEquals(sms1.hashCode(), sms2.hashCode());
    }

    @Test
    void testToString() {
        String content = "Test Message";
        Charset charset = StandardCharsets.UTF_8;

        SmsMessage sms = new SmsMessage(content, charset);

        String expectedString = "SmsMessage{content='" + content + "', encodingType=" + charset + "}";
        assertEquals(expectedString, sms.toString());
    }

    @Test
    void testCopy() {
        String content = "Test Message";
        Charset charset = StandardCharsets.UTF_8;

        SmsMessage original = new SmsMessage(content, charset);
        SmsMessage copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }
}
