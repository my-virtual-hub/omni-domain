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

    public SmsRecipient getRecipient() {
        return recipient;
    }

    public void setRecipient(SmsRecipient recipient) {
        this.recipient = recipient;
    }

    public SmsMessage getMessage() {
        return message;
    }

    public void setMessage(SmsMessage message) {
        this.message = message;
    }

    public String getClientMessageId() {
        return clientMessageId;
    }

    public void setClientMessageId(String clientMessageId) {
        this.clientMessageId = clientMessageId;
    }

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
