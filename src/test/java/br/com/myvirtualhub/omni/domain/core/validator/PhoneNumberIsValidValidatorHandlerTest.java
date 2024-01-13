/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.validator;

import static org.junit.jupiter.api.Assertions.*;

import br.com.myvirtualhub.omni.domain.core.exceptions.PhoneNumberException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.NumberParseException;

class PhoneNumberIsValidValidatorHandlerTest {

    @Test
    void validateShouldThrowExceptionForInvalidPhoneNumber() throws NumberParseException {
        PhoneNumberUtil phoneNumberUtilMock = Mockito.mock(PhoneNumberUtil.class);
        PhoneNumberIsValidValidatorHandler handler = new PhoneNumberIsValidValidatorHandler();

        String invalidPhoneNumber = "invalid";

        Mockito.when(phoneNumberUtilMock.parse(invalidPhoneNumber, "BR")).thenThrow(new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "invalid"));

        assertThrows(PhoneNumberException.class, () -> handler.validate(invalidPhoneNumber));
    }




    @Test
    void setNextAndGetNextShouldWorkCorrectly() {
        PhoneNumberIsValidValidatorHandler handler = new PhoneNumberIsValidValidatorHandler();
        handler.setNext(handler);

        assertEquals(handler, handler.getNext());
    }
}
