/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.action;

import br.com.myvirtualhub.omni.ports.inbound.sms.dto.SmsPayloadDTO;
import br.com.myvirtualhub.omni.ports.inbound.sms.dto.SmsResultDTO;
import br.com.myvirtualhub.omni.ports.inbound.sms.interfaces.SmsInboundAction;

/**
 * Implementation of the SmsInboundAction interface for sending inbound SMS.
 */
public class SmsInboundActionImplV1 implements SmsInboundAction {
    /**
     * Sends an SMS message using the given payload.
     * @param smsPayload The payload containing the SMS message details.
     * @return The result of sending the SMS message.
     */
    @Override
    public SmsResultDTO sendSms(SmsPayloadDTO smsPayload) {
        return null;
    }
}
