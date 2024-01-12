/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.provider;

import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

import java.util.Objects;

/**
 * Represents an Property in the ProviderChannel class. Each Property has a unique name,
 * a description, a data type, and a flag indicating if it's required or not.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-08
 */
public class ProviderProperty implements Model {
    private String name;
    private String description;
    private boolean required;

    /**
     * Constructs a new ProviderProperty with the given name, description, and required flag.
     *
     * @param name The name of the property. Cannot be null.
     * @param description The description of the property. Cannot be null.
     * @param required A flag indicating if the property is required or not.
     */
    public ProviderProperty(String name, String description, boolean required) {
        setName(name);
        setDescription(description);
        setRequired(required);
    }

    /**
     * Returns the name of the ProviderProperty.
     *
     * @return The name of the ProviderProperty. Returns null if the name is not set.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the ProviderProperty.
     *
     * @param name The name of the ProviderProperty. Cannot be null.
     */
    public void setName(String name) {
        Objects.requireNonNull(name, "ProviderProperty name cannot be null");
        this.name = name;
    }

    /**
     * Returns the description of the ProviderProperty.
     *
     * @return The description of the ProviderProperty. Returns null if the description is not set.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the ProviderProperty.
     *
     * @param description The description of the ProviderProperty. Cannot be null.
     */
    public void setDescription(String description) {
        Objects.requireNonNull(description, "ProviderProperty description cannot be null");
        this.description = description;
    }

    /**
     * Checks if the ProviderProperty is required.
     *
     * @return true if the ProviderProperty is required, false otherwise.
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * Sets the required flag of the ProviderProperty.
     *
     * @param required A flag indicating if the property is required or not.
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProviderProperty providerProperty)) return false;
        return isRequired() == providerProperty.isRequired() && Objects.equals(getName(), providerProperty.getName()) && Objects.equals(getDescription(), providerProperty.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), isRequired());
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isRequired=" + required +
                '}';
    }
}
