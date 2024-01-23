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

import br.com.myvirtualhub.omni.commons.enums.ChannelType;
import br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException;
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
