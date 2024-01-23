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

package br.com.myvirtualhub.omni.domain.sms.model;

import br.com.myvirtualhub.omni.commons.interfaces.Copyable;
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
public class SmsMessage implements Model, Copyable<SmsMessage> {

    private String content;

    private Charset encodingType;

    /**
     * Constructs a new SmsMessage object with the given content and encoding type.
     *
     * @param content      The content of the SMS message as a string.
     * @param encodingType The encoding type of the SMS message.
     *
     * @throws NullPointerException if the content or encodingType is null
     */
    public SmsMessage(String content, Charset encodingType) {
        setContent(content);
        setEncodingType(encodingType);
    }

    /**
     * Retrieves the content of the SMS message.
     *
     * @return The content of the SMS message as a string.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the SMS message.
     *
     * @param content The content of the SMS message as a string.
     */
    public void setContent(String content) {
        Objects.requireNonNull(content, "SmsMessage content cannot be null");
        this.content = content;
    }

    /**
     * Retrieves the encoding type of the SMS message.
     *
     * @return The encoding type of the SMS message.
     */
    public Charset getEncodingType() {
        return encodingType;
    }

    /**
     * Sets the encoding type of the SMS message.
     *
     * @param encodingType The encoding type of the SMS message.
     * @throws NullPointerException if the encodingType is null
     */
    public void setEncodingType(Charset encodingType) {
        Objects.requireNonNull(encodingType, "SmsMessage encodingType cannot be null");
        this.encodingType = encodingType;
    }

    /**
     * Copies an SmsMessage object.
     * <p>
     * This method creates a new SmsMessage object with the same content and encoding type
     * as the current SmsMessage object. The content is copied as a new string object, and
     * the encoding type is referenced. The new SmsMessage object is then returned.
     *
     * @return A copy of the SmsMessage object.
     */
    @Override
    public SmsMessage copy() {
        return new SmsMessage(this.getContent(), this.getEncodingType());
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
