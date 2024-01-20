/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.configuration;

import br.com.myvirtualhub.omni.commons.interfaces.Copyable;
import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

import java.util.Objects;

/**
 * Represents the actual values of keys that will be used by a provider.
 * Each instance of Property serves as a model to store
 * specific configurations needed for that provider.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-08
 */
public class Property implements Model, Copyable<Property> {

    private String name;

    private String value;

    /**
     * Represents a property with a name and value.
     *
     * @param name The name of the property. Cannot be null.
     * @param value The value of the property. Cannot be null.
     */
    public Property(String name, String value) {
        setName(name);
        setValue(value);
    }

    /**
     * Retrieves the name of the property.
     *
     * @return The name of the property as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the property.
     *
     * @param name The name of the property. Cannot be null.
     */
    public void setName(String name) {
        Objects.requireNonNull(name, "Property name cannot be null");
        this.name = name;
    }

    /**
     * Retrieves the value of the property.
     *
     * @return The value of the property as a string.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the property.
     *
     * @param value The value to be set. Cannot be null.
     */
    public void setValue(String value) {
        Objects.requireNonNull(value, "Property value cannot be null");
        this.value = value;
    }

    /**
     * Creates a copy of the {@link Property} object.
     *
     * @return a new {@link Property} object with the same name and value as the original object
     */
    @Override
    public Property copy() {
        return new Property( this.getName(), this.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getValue());
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
