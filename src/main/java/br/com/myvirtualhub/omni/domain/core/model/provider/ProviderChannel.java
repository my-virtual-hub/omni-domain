/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.provider;

import br.com.myvirtualhub.omni.domain.core.enums.ChannelType;
import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

import java.util.List;
import java.util.Objects;

/**
 * Represents a ProviderChannel in the Provider class. Each ProviderChannel has a unique ChannelType,
 * a list of attribute names, attribute descriptions, data types, and a flag indicating
 * if the attribute is required or not.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-08
 */
public class ProviderChannel implements Model {

    private ChannelType type;
    private List<ProviderProperty> providerProperties;

    /**
     * Constructs a new ProviderChannel with the given type and provider properties.
     *
     * @param type               The type of the ProviderChannel. Cannot be null.
     * @param providerProperties The list of provider properties. Cannot be null.
     * @throws NullPointerException if either type or providerProperties is null.
     */
    public ProviderChannel(ChannelType type, List<ProviderProperty> providerProperties) {
        setType(type);
        setRequiredProperties(providerProperties);
    }

    /**
     * Retrieves the type of the ProviderChannel.
     *
     * @return The type of the ProviderChannel.
     */
    public ChannelType getType() {
        return type;
    }

    /**
     * Sets the type of the ProviderChannel.
     *
     * @param type The type of the ProviderChannel. Cannot be null.
     * @throws NullPointerException if the type is null.
     */
    public void setType(ChannelType type) {
        Objects.requireNonNull(type, "ProviderChannel type cannot be null");
        this.type = type;
    }

    /**
     * Retrieves the list of required properties for the ProviderChannel.
     *
     * @return The list of required properties for the ProviderChannel.
     */
    public List<ProviderProperty> getRequiredProperties() {
        return providerProperties;
    }

    /**
     * Sets the list of required properties for the ProviderChannel.
     *
     * @param providerProperties The list of required properties. Cannot be null.
     * @throws NullPointerException if providerProperties is null.
     */
    public void setRequiredProperties(List<ProviderProperty> providerProperties) {
        Objects.requireNonNull(providerProperties, "ProviderChannel attributes cannot be null");
        this.providerProperties = providerProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProviderChannel providerChannel)) return false;
        return getType() == providerChannel.getType() && Objects.equals(getRequiredProperties(), providerChannel.getRequiredProperties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getRequiredProperties());
    }

    @Override
    public String toString() {
        return "ProviderChannel{" +
                "type=" + type +
                ", providerProperties=" + providerProperties +
                '}';
    }
}