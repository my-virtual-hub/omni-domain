/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.model;

import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

import java.nio.charset.Charset;
import java.util.Objects;

/**
 * A representation of an SMS message with encoding specification.
 * This is used to encapsulate the data of an SMS message and specify
 * its encoding format before it is sent or processed.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-09
 */
public class SmsMessage implements Model {

    private String content;

    private Charset encodingType;

    public SmsMessage(String content, Charset encodingType) {
        setContent(content);
        setEncodingType(encodingType);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        Objects.requireNonNull(content, "SmsMessage content cannot be null");
        this.content = content;
    }

    public Charset getEncodingType() {
        return encodingType;
    }

    public void setEncodingType(Charset encodingType) {
        Objects.requireNonNull(encodingType, "SmsMessage encodingType cannot be null");
        this.encodingType = encodingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsMessage smsMessage)) return false;
        return getContent().equals(smsMessage.getContent()) && getEncodingType().equals(smsMessage.getEncodingType());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getContent(), getEncodingType());
    }

    @Override
    public String toString() {
        return "SmsMessage{" +
                "content='" + content + '\'' +
                ", encodingType=" + encodingType +
                '}';
    }
}