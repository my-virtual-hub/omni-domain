/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
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
