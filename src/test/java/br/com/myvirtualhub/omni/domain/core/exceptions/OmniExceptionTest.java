/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.exceptions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class OmniExceptionTest {

    @Test
    void constructorWithMessageShouldSetMessageCorrectly() {
        String testMessage = "Test message";
        OmniException exception = new OmniException(testMessage);

        assertEquals(testMessage, exception.getMessage());
        assertNull(exception.getCause());
        assertNull(exception.getThrowableCause());
    }

    @Test
    void constructorWithMessageAndCauseShouldSetBothCorrectly() {
        String testMessage = "Test message";
        Throwable testCause = new RuntimeException("Test cause");
        OmniException exception = new OmniException(testMessage, testCause);

        assertEquals(testMessage, exception.getMessage());
        assertEquals(testCause, exception.getCause());
        assertNull(exception.getThrowableCause());
    }

    @Test
    void constructorWithMessageAndThrowableCauseShouldSetBothCorrectly() {
        String testMessage = "Test message";
        String testThrowableCause = "Test throwable cause";
        OmniException exception = new OmniException(testMessage, testThrowableCause);

        assertEquals(testMessage, exception.getMessage());
        assertNull(exception.getCause());
        assertEquals(testThrowableCause, exception.getThrowableCause());
    }

    @Test
    void toStringShouldReturnCorrectFormat() {
        String testMessage = "Test message";
        OmniException exception = new OmniException(testMessage);

        String expectedString = "OmniException{Exception.toString()=br.com.myvirtualhub.omni.domain.core.exceptions.OmniException: Test message, throwableCause=null}";
        assertEquals(expectedString, exception.toString());
    }
}
