/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.configuration;

import static org.junit.jupiter.api.Assertions.*;

import br.com.myvirtualhub.omni.domain.core.enums.ChannelType;
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
