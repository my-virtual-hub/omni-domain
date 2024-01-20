/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.model;

import br.com.myvirtualhub.omni.commons.enums.ChannelType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmsOmniProcessIdTest {

    @Test
    void testSmsOmniProcessIdInitializesWithSmsChannelType() {
        SmsOmniProcessId smsOmniProcessId = new SmsOmniProcessId();

        assertEquals(ChannelType.SMS, smsOmniProcessId.getChannelType(),
                "SmsOmniProcessId should initialize with the SMS channel type.");
    }

    @Test
    void testEqualsAndHashCode() {
        SmsOmniProcessId smsOmniProcessId1 = new SmsOmniProcessId();
        SmsOmniProcessId smsOmniProcessId2 = (SmsOmniProcessId)smsOmniProcessId1.copy();

        assertEquals(smsOmniProcessId1, smsOmniProcessId2);
        assertEquals(smsOmniProcessId1.hashCode(), smsOmniProcessId2.hashCode());
    }
}
