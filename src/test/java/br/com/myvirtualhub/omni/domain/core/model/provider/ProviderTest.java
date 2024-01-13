/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.provider;

import static org.junit.jupiter.api.Assertions.*;

import br.com.myvirtualhub.omni.domain.core.enums.ChannelType;
import br.com.myvirtualhub.omni.domain.core.exceptions.PhoneNumberException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ProviderTest {

    @Test
    void constructorShouldInitializeFieldsCorrectly() {
        String name = "providerName";
        List<ProviderChannel> providerChannels = Arrays.asList(new ProviderChannel(ChannelType.SMS,new ArrayList<>()), new ProviderChannel(ChannelType.SMS,new ArrayList<>()));

        Provider provider = new Provider(name, providerChannels);

        assertAll(
                () -> assertEquals(name, provider.getName()),
                () -> assertEquals(providerChannels, provider.getProviderChannels())
        );
    }

    @Test
    void settersShouldUpdateFieldsCorrectly() {
        String initialName = "initialName";
        List<ProviderChannel> initialChannels = List.of(new ProviderChannel(ChannelType.SMS, new ArrayList<>()));
        Provider provider = new Provider(initialName, initialChannels);

        String updatedName = "updatedName";
        List<ProviderChannel> updatedChannels = List.of(new ProviderChannel(ChannelType.SMS, new ArrayList<>()));
        provider.setName(updatedName);
        provider.setProviderChannels(updatedChannels);

        assertAll(
                () -> assertEquals(updatedName, provider.getName()),
                () -> assertEquals(updatedChannels, provider.getProviderChannels())
        );
    }

    @Test
    void equalsAndHashCodeShouldBeConsistent() {
        String name = "providerName";
        List<ProviderChannel> providerChannels = Arrays.asList(new ProviderChannel(ChannelType.SMS,new ArrayList<>()), new ProviderChannel(ChannelType.SMS,new ArrayList<>()));

        Provider provider1 = new Provider(name, providerChannels);
        Provider provider2 = new Provider(name, providerChannels);

        assertEquals(provider1, provider2);
        assertEquals(provider1.hashCode(), provider2.hashCode());
    }

    @Test
    void toStringShouldReturnCorrectFormat() {
        String name = "providerName";
        List<ProviderChannel> providerChannels = Arrays.asList(new ProviderChannel(ChannelType.SMS,new ArrayList<>()), new ProviderChannel(ChannelType.SMS,new ArrayList<>()));

        Provider provider = new Provider(name, providerChannels);

        String expectedString = "Provider{" +
                "name='" + name + '\'' +
                ", providerChannels=" + providerChannels +
                '}';
        assertEquals(expectedString, provider.toString());
    }

    @Test
    void testCopy() throws PhoneNumberException {
        String name = "providerName";
        List<ProviderChannel> providerChannels = Arrays.asList(new ProviderChannel(ChannelType.SMS,new ArrayList<>()), new ProviderChannel(ChannelType.SMS,new ArrayList<>()));

        Provider original = new Provider(name, providerChannels);
        Provider copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }
}
