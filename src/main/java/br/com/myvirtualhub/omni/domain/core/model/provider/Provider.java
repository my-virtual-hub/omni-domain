/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.provider;

import br.com.myvirtualhub.omni.domain.core.exceptions.PhoneNumberException;
import br.com.myvirtualhub.omni.domain.core.model.interfaces.Copyable;
import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Provider in the system, containing all necessary information
 * for the system to effectively communicate and identify each Provider.
 * Each Provider has a unique name and a list of supported Channels
 * along with their requisite attributes.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-08
 */
public class Provider implements Model, Copyable<Provider> {

    private String name;
    private List<ProviderChannel> providerChannels;

    /**
     * Creates a new Provider object with the specified name and list of provider channels.
     *
     * @param name             the name of the provider (must not be null)
     * @param providerChannels the list of provider channels (must not be null)
     */
    public Provider(String name, List<ProviderChannel> providerChannels) {
        setName(name);
        setProviderChannels(providerChannels);
    }

    /**
     * Retrieves the name of the provider.
     *
     * @return The name of the provider.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the provider.
     *
     * @param name the name of the provider (must not be null)
     * @throws NullPointerException if the name is null
     */
    public void setName(String name) {
        Objects.requireNonNull(name, "Provider name cannot be null");
        this.name = name;
    }

    /**
     * Retrieves the list of ProviderChannels associated with this Provider.
     *
     * @return The list of ProviderChannels.
     */
    public List<ProviderChannel> getProviderChannels() {
        return providerChannels;
    }

    /**
     * Sets the list of ProviderChannels associated with this Provider.
     *
     * @param providerChannels the list of ProviderChannels (must not be null)
     * @throws NullPointerException if providerChannels is null
     */
    public void setProviderChannels(List<ProviderChannel> providerChannels) {
        Objects.requireNonNull(providerChannels, "Provider providerChannels cannot be null");
        this.providerChannels = providerChannels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provider provider)) return false;
        return Objects.equals(getName(), provider.getName()) && Objects.equals(getProviderChannels(), provider.getProviderChannels());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getProviderChannels());
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", providerChannels=" + providerChannels +
                '}';
    }

    @Override
    public Provider copy() throws PhoneNumberException {
        final List<ProviderChannel> providerChannelsClone = new ArrayList<>();
        for(ProviderChannel providerChannel : getProviderChannels()) {
            providerChannelsClone.add(providerChannel.copy());
        }
        return new Provider(this.getName(), providerChannelsClone);
    }
}