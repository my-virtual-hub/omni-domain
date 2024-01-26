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

package br.com.myvirtualhub.omni.domain.sms.action;

import br.com.myvirtualhub.omni.ports.inbound.sms.dto.SmsPayloadDTO;
import br.com.myvirtualhub.omni.ports.inbound.sms.dto.SmsResultDTO;
import br.com.myvirtualhub.omni.ports.inbound.sms.interfaces.SmsInboundAction;
import org.slf4j.Logger;

/**
 * Implementation of the SmsInboundAction interface for sending inbound SMS.
 */
public class SmsInboundActionImplV1 implements SmsInboundAction {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SmsInboundActionImplV1.class);

    /**
     * Sends an SMS message using the given payload.
     * @param smsPayload The payload containing the SMS message details.
     * @return The result of sending the SMS message.
     */
    @Override
    public SmsResultDTO sendSms(SmsPayloadDTO smsPayload) {

        LOGGER.info("Sending SMS message...");
        //TODO: Implement this method
        return SmsResultDTO.queued();
    }
}
