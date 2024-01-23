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

package br.com.myvirtualhub.omni.domain.core.model.provider;

import br.com.myvirtualhub.omni.commons.interfaces.Copyable;
import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

import java.util.Objects;

/**
 * Represents a Property in the ProviderChannel class. Each Property has a unique name,
 * a description, a data type, and a flag indicating if it's required or not.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-08
 */
public class ProviderProperty implements Model, Copyable<ProviderProperty> {
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

    /**
     * Creates a copy of the ProviderProperty object.
     *
     * @return A new ProviderProperty object with the same name, description, and required flag as the original.
     */
    @Override
    public ProviderProperty copy() {
        return new ProviderProperty(this.getName(), this.getDescription(), this.isRequired());
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
