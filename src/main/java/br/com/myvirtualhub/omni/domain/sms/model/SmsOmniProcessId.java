/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.model;

import br.com.myvirtualhub.omni.commons.core.OmniProcessId;
import br.com.myvirtualhub.omni.commons.enums.ChannelType;

import java.util.UUID;

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

    /**
     * Constructs a new instance of SmsOmniProcessId with the SMS channel type.
     *
     * <p>This constructor initializes the SmsOmniProcessId with the specified channel type.
     * The channel type represents the communication channel used for SMS operations.
     *
     * @see OmniProcessId
     * @see ChannelType
     */
    public SmsOmniProcessId() {
        super(ChannelType.SMS);
    }

    private SmsOmniProcessId(String prefix, ChannelType channelType, UUID omniProcessUUID ) {
        super(prefix, channelType, omniProcessUUID);
    }

    /**
     * Creates a deep copy of the SmsOmniProcessId object.
     *
     * @return A deep copy of the SmsOmniProcessId object.
     */
    @Override
    public OmniProcessId copy() {
        return new SmsOmniProcessId( getPrefix(), getChannelType(), UUID.fromString(getOmniProcessUUID().toString()));
    }
}
