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

import static org.junit.jupiter.api.Assertions.*;

import br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException;
import org.junit.jupiter.api.Test;

class ProviderPropertyTest {

    @Test
    void constructorShouldInitializeFieldsCorrectly() {
        String name = "propertyName";
        String description = "propertyDescription";
        boolean required = true;

        ProviderProperty providerProperty = new ProviderProperty(name, description, required);

        assertAll(
                () -> assertEquals(name, providerProperty.getName()),
                () -> assertEquals(description, providerProperty.getDescription()),
                () -> assertEquals(required, providerProperty.isRequired())
        );
    }

    @Test
    void settersShouldUpdateFieldsCorrectly() {
        String initialName = "initialName";
        String initialDescription = "initialDescription";
        boolean initialRequired = false;
        ProviderProperty providerProperty = new ProviderProperty(initialName, initialDescription, initialRequired);

        String updatedName = "updatedName";
        String updatedDescription = "updatedDescription";
        boolean updatedRequired = true;
        providerProperty.setName(updatedName);
        providerProperty.setDescription(updatedDescription);
        providerProperty.setRequired(updatedRequired);

        assertAll(
                () -> assertEquals(updatedName, providerProperty.getName()),
                () -> assertEquals(updatedDescription, providerProperty.getDescription()),
                () -> assertEquals(updatedRequired, providerProperty.isRequired())
        );
    }

    @Test
    void equalsAndHashCodeShouldBeConsistent() {
        String name = "propertyName";
        String description = "propertyDescription";
        boolean required = true;

        ProviderProperty providerProperty1 = new ProviderProperty(name, description, required);
        ProviderProperty providerProperty2 = new ProviderProperty(name, description, required);

        assertEquals(providerProperty1, providerProperty2);
        assertEquals(providerProperty1.hashCode(), providerProperty2.hashCode());
    }

    @Test
    void toStringShouldReturnCorrectFormat() {
        String name = "propertyName";
        String description = "propertyDescription";
        boolean required = true;

        ProviderProperty providerProperty = new ProviderProperty(name, description, required);

        String expectedString = "Property{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isRequired=" + required +
                '}';
        assertEquals(expectedString, providerProperty.toString());
    }

    @Test
    void testCopy() throws PhoneNumberException {
        String name = "propertyName";
        String description = "propertyDescription";
        boolean required = true;

        ProviderProperty original = new ProviderProperty(name, description, required);
        ProviderProperty copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }
}
