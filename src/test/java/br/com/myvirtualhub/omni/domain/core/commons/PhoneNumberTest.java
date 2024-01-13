/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.commons;

import static org.junit.jupiter.api.Assertions.*;

import br.com.myvirtualhub.omni.domain.core.exceptions.PhoneNumberException;
import br.com.myvirtualhub.omni.domain.core.validator.PhoneNumberIsValidValidatorHandler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;

class PhoneNumberTest {

    private PhoneNumberIsValidValidatorHandler validator;

    @BeforeEach
    void setUp() {
        validator = Mockito.mock(PhoneNumberIsValidValidatorHandler.class);
        PhoneNumberIsValidValidatorHandler.Builder builder =
                Mockito.mock(PhoneNumberIsValidValidatorHandler.Builder.class);
        Mockito.when(builder.build()).thenReturn(validator);
    }

    @Test
    void constructorShouldValidatePhoneNumber() throws PhoneNumberException {
        String validPhoneNumber = "+1234567890";
        Mockito.doNothing().when(validator).validate(validPhoneNumber);

        assertDoesNotThrow(() -> new PhoneNumber(validPhoneNumber));
    }

    @Test
    void constructorShouldThrowExceptionForInvalidPhoneNumber() throws PhoneNumberException {
        String invalidPhoneNumber = "invalid";
        Mockito.doThrow(PhoneNumberException.class).when(validator).validate(invalidPhoneNumber);

        assertThrows(PhoneNumberException.class, () -> new PhoneNumber(invalidPhoneNumber));
    }

    @Test
    void getContentShouldReturnCorrectContent() throws PhoneNumberException {
        String phoneNumberContent = "+1234567890";
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberContent);

        assertEquals(phoneNumberContent, phoneNumber.getContent());
    }

    @Test
    void setContentShouldUpdateContent() throws PhoneNumberException {
        String initialContent = "+1234567890";
        String newContent = "+0987654321";
        PhoneNumber phoneNumber = new PhoneNumber(initialContent);

        phoneNumber.setContent(newContent);

        assertEquals(newContent, phoneNumber.getContent());
    }

    @Test
    void equalsAndHashCodeShouldBeConsistent() throws PhoneNumberException {
        String phoneNumberContent = "+1234567890";
        PhoneNumber phoneNumber1 = new PhoneNumber(phoneNumberContent);
        PhoneNumber phoneNumber2 = new PhoneNumber(phoneNumberContent);

        assertEquals(phoneNumber1, phoneNumber2);
        assertEquals(phoneNumber1.hashCode(), phoneNumber2.hashCode());
    }

    @Test
    void toStringShouldReturnCorrectFormat() throws PhoneNumberException {
        String phoneNumberContent = "+1234567890";
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberContent);

        String expectedString = "PhoneNumber{content='" + phoneNumberContent + "'}";
        assertEquals(expectedString, phoneNumber.toString());
    }
}
