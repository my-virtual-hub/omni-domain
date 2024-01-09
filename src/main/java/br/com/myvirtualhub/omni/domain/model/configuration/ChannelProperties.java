/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.model.configuration;

import br.com.myvirtualhub.omni.domain.enums.ChannelType;
import br.com.myvirtualhub.omni.domain.model.interfaces.Model;

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
public class ChannelProperties implements Model {

    private ChannelType channelType;

    private boolean active;

    private List<Property> properties;

    public ChannelProperties(ChannelType channelType, boolean active, List<Property> properties) {
        setChannelType(channelType);
        setActive(active);
        setProperties(properties);
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        Objects.requireNonNull(channelType, "ChannelProperties channelType cannot be null");
        this.channelType = channelType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        Objects.requireNonNull(channelType, "ChannelProperties properties cannot be null");
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChannelProperties that)) return false;
        return isActive() == that.isActive() && getChannelType() == that.getChannelType() && getProperties().equals(that.getProperties());
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
