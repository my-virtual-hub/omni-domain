/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.provider;

import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

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
public class Provider implements Model {

    private String name;
    private List<ProviderChannel> providerChannels;

    public Provider(String name, List<ProviderChannel> providerChannels) {
        setName(name);
        setChannels(providerChannels);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name, "Provider name cannot be null");
        this.name = name;
    }

    public List<ProviderChannel> getChannels() {
        return providerChannels;
    }

    public void setChannels(List<ProviderChannel> providerChannels) {
        Objects.requireNonNull(providerChannels, "Provider providerChannels cannot be null");
        this.providerChannels = providerChannels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provider provider)) return false;
        return Objects.equals(getName(), provider.getName()) && Objects.equals(getChannels(), provider.getChannels());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getChannels());
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", providerChannels=" + providerChannels +
                '}';
    }
}