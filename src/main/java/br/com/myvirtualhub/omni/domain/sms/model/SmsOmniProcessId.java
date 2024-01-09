/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.model;

import br.com.myvirtualhub.omni.domain.core.enums.ChannelType;
import br.com.myvirtualhub.omni.domain.core.model.commons.OmniProcessId;

/**
 * A specialized type of OmniProcessId that represents an SMS process within the application.
 *
 * <p>This class extends the {@link OmniProcessId} class to represent a unique identification for
 * an SMS process within the application. It provides additional context and functionality
 * catered towards processes related to SMS operations while inheriting the standard behaviour
 * of an Omni process.
 *
 * @author  Marco Quiçula
 * @version 1.0
 * @since   2024-01-09
 * @see     OmniProcessId
 */
public class SmsOmniProcessId extends OmniProcessId {

    public SmsOmniProcessId() {
        super(ChannelType.SMS);
    }
}
