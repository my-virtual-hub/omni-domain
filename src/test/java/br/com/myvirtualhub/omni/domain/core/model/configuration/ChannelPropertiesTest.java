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

import static org.junit.jupiter.api.Assertions.*;

import br.com.myvirtualhub.omni.commons.enums.ChannelType;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class ChannelPropertiesTest {

    @Test
    void constructorShouldInitializeFieldsCorrectly() {
        ChannelType channelType = ChannelType.SMS; // Use o tipo de canal adequado
        boolean active = true;
        List<Property> properties = Arrays.asList(new Property("key1", "value1"), new Property("key2", "value2"));

        ChannelProperties channelProperties = new ChannelProperties(channelType, active, properties);

        assertAll(
                () -> assertEquals(channelType, channelProperties.getChannelType()),
                () -> assertEquals(active, channelProperties.isActive()),
                () -> assertEquals(properties, channelProperties.getProperties())
        );
    }

    @Test
    void settersShouldUpdateFieldsCorrectly() {
        ChannelType initialType = ChannelType.SMS; // Use o tipo de canal adequado
        boolean initialActive = false;
        List<Property> initialProperties = List.of(new Property("key1", "value1"));

        ChannelProperties channelProperties = new ChannelProperties(initialType, initialActive, initialProperties);

        ChannelType newType = ChannelType.SMS; // Mude conforme necessário
        boolean newActive = true;
        List<Property> newProperties = List.of(new Property("key2", "value2"));

        channelProperties.setChannelType(newType);
        channelProperties.setActive(newActive);
        channelProperties.setProperties(newProperties);

        assertAll(
                () -> assertEquals(newType, channelProperties.getChannelType()),
                () -> assertEquals(newActive, channelProperties.isActive()),
                () -> assertEquals(newProperties, channelProperties.getProperties())
        );
    }

    @Test
    void equalsAndHashCodeShouldBeConsistent() {
        ChannelType channelType = ChannelType.SMS; // Use o tipo de canal adequado
        boolean active = true;
        List<Property> properties = List.of(new Property("key1", "value1"));

        ChannelProperties channelProperties1 = new ChannelProperties(channelType, active, properties);
        ChannelProperties channelProperties2 = new ChannelProperties(channelType, active, properties);

        assertEquals(channelProperties1, channelProperties2);
        assertEquals(channelProperties1.hashCode(), channelProperties2.hashCode());
    }

    @Test
    void toStringShouldReturnCorrectFormat() {
        ChannelType channelType = ChannelType.SMS; // Use o tipo de canal adequado
        boolean active = true;
        List<Property> properties = List.of(new Property("key1", "value1"));

        ChannelProperties channelProperties = new ChannelProperties(channelType, active, properties);

        String expectedString = "ChannelProperties{" +
                "channelType=" + channelType +
                ", active=" + active +
                ", properties=" + properties +
                '}';
        assertEquals(expectedString, channelProperties.toString());
    }

    @Test
    void testCopy() {
        ChannelType channelType = ChannelType.SMS; // Use o tipo de canal adequado
        boolean active = true;
        List<Property> properties = List.of(new Property("key1", "value1"));

        ChannelProperties original = new ChannelProperties(channelType, active, properties);
        ChannelProperties copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }
}
