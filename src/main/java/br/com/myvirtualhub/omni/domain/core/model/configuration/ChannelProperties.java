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

package br.com.myvirtualhub.omni.domain.core.model.configuration;

import br.com.myvirtualhub.omni.commons.enums.ChannelType;
import br.com.myvirtualhub.omni.commons.interfaces.Copyable;
import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is responsible for determining the active channels and the respective property
 * of a provider. The actual values of the keys that will be used by a provider are represented here.
 * Each instance of ChannelProperties manages the specific configurations needed for the active channels
 * of that provider.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-08
 */
public class ChannelProperties implements Model, Copyable<ChannelProperties> {

    private ChannelType channelType;

    private boolean active;

    private List<Property> properties;

    /**
     * Initializes a new instance of the {@code ChannelProperties} class.
     *
     * @param channelType The {@link ChannelType} of the channel.
     * @param active      A boolean value indicating whether the channel is active.
     * @param properties  A list of {@link Property} objects representing the specific configurations of the channel.
     *
     * @throws NullPointerException if {@code channelType} or {@code properties} is {@code null}.
     */
    public ChannelProperties(ChannelType channelType, boolean active, List<Property> properties) {
        setChannelType(channelType);
        setActive(active);
        setProperties(properties);
    }

    /**
     * Returns the ChannelType of the channel.
     *
     * @return The ChannelType of the channel.
     */
    public ChannelType getChannelType() {
        return channelType;
    }

    /**
     * Sets the channel type of the {@code ChannelProperties} instance.
     *
     * @param channelType The {@link ChannelType} to set as the channel type.
     * @throws NullPointerException if {@code channelType} is {@code null}.
     */
    public void setChannelType(ChannelType channelType) {
        Objects.requireNonNull(channelType, "ChannelProperties channelType cannot be null");
        this.channelType = channelType;
    }

    /**
     * Returns the active status of the channel.
     *
     * @return {@code true} if the channel is active, {@code false} otherwise.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the active status of the channel.
     *
     * @param active {@code true} if the channel is active, {@code false} otherwise.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Retrieves the list of properties.
     *
     * @return The list of properties.
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Sets the properties of the {@code ChannelProperties} instance.
     *
     * @param properties A list of {@link Property} objects representing the specific configurations of the channel.
     * @throws NullPointerException if {@code properties} is {@code null}.
     */
    public void setProperties(List<Property> properties) {
        Objects.requireNonNull(channelType, "ChannelProperties properties cannot be null");
        this.properties = properties;
    }

    @Override
    public ChannelProperties copy() {
        List<Property> clonedProperties = null;
        if (getProperties() != null) {
            clonedProperties = new ArrayList<>();
            for (Property property : getProperties()) {
                clonedProperties.add(property.copy());
            }
        }
        return new ChannelProperties(getChannelType(), isActive(), clonedProperties);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChannelProperties that)) return false;
        return isActive() == that.isActive() && getChannelType() == that.getChannelType() && Objects.equals(getProperties(), that.getProperties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChannelType(), isActive(), getProperties());
    }

    @Override
    public String toString() {
        return "ChannelProperties{" +
                "channelType=" + channelType +
                ", active=" + active +
                ", properties=" + properties +
                '}';
    }
}
