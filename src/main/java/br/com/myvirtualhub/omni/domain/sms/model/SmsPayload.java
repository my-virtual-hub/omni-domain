/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.model;

import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

import java.util.Objects;

/**
 * Represents an SMS Payload message with details for sending and tracking.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-09
 */
public class SmsPayload implements Model {
    private SmsRecipient recipient;
    private SmsMessage message;
    private String clientMessageId;
    private final SmsOmniProcessId smsOmniProcessId;

    /**
     * Constructs a new SmsPayload.
     *
     * @param recipient       The phone number of the message recipient.
     * @param message         The text content of the message.
     * @param clientMessageId A unique identifier provided by the client for tracking.
     */
    public SmsPayload(SmsRecipient recipient, SmsMessage message, String clientMessageId) {
        this.recipient = recipient;
        this.message = message;
        this.clientMessageId = clientMessageId;
        this.smsOmniProcessId = new SmsOmniProcessId();
    }

    /**
     * Retrieves the recipient of the SMS payload.
     *
     * @return The recipient of the SMS payload as an instance of the SmsRecipient class.
     * @see SmsPayload
     * @see SmsRecipient
     */
    public SmsRecipient getRecipient() {
        return recipient;
    }

    /**
     * Sets the recipient of the SMS payload.
     *
     * @param recipient The recipient of the SMS payload as an instance of the SmsRecipient class.
     * @see SmsPayload
     * @see SmsRecipient
     */
    public void setRecipient(SmsRecipient recipient) {
        this.recipient = recipient;
    }

    /**
     * Retrieves the message of the SMS payload.
     *
     * @return The message of the SMS payload as an instance of the SmsMessage class.
     * @see SmsPayload
     * @see SmsMessage
     */
    public SmsMessage getMessage() {
        return message;
    }

    /**
     * Sets the message of the SMS payload.
     *
     * @param message The message of the SMS payload as an instance of the SmsMessage class.
     */
    public void setMessage(SmsMessage message) {
        this.message = message;
    }

    /**
     * Retrieves the client message ID associated with the SMS payload.
     *
     * @return The client message ID as a String.
     * @see SmsPayload
     * @since 2023-08-01
     */
    public String getClientMessageId() {
        return clientMessageId;
    }

    /**
     * Sets the client message ID associated with the SMS payload.
     *
     * This method sets the client message ID provided by the client for tracking purposes.
     * The client message ID is a unique identifier associated with the SMS payload.
     *
     * @param clientMessageId The client message ID as a String.
     * @see SmsPayload
     * @since 2023-08-01
     */
    public void setClientMessageId(String clientMessageId) {
        this.clientMessageId = clientMessageId;
    }

    /**
     * Retrieves the OmniMessageId associated with the SMS payload.
     *
     * @return The OmniMessageId of the SMS payload as an instance of the SmsOmniProcessId class.
     * @see SmsPayload
     * @see SmsOmniProcessId
     */
    public SmsOmniProcessId getOmniMessageId() {
        return smsOmniProcessId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsPayload that)) return false;
        return Objects.equals(getRecipient(), that.getRecipient()) && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getClientMessageId(), that.getClientMessageId()) && Objects.equals(smsOmniProcessId, that.smsOmniProcessId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipient(), getMessage(), getClientMessageId(), smsOmniProcessId);
    }

    @Override
    public String toString() {
        return "SmsPayload{" +
                "recipient=" + recipient +
                ", message=" + message +
                ", clientMessageId=" + clientMessageId +
                ", smsOmniProcessId=" + smsOmniProcessId +
                "}";
    }
}
