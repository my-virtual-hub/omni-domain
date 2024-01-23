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
import java.util.Arrays;
import java.util.List;

class ProviderChannelTest {

    @Test
    void constructorShouldInitializeFieldsCorrectly() {
        ChannelType type = ChannelType.SMS; // Substitua conforme necessário
        List<ProviderProperty> providerProperties = Arrays.asList(new ProviderProperty("name1", "desc1", true), new ProviderProperty("name2", "desc2", false));

        ProviderChannel providerChannel = new ProviderChannel(type, providerProperties);

        assertAll(
                () -> assertEquals(type, providerChannel.getType()),
                () -> assertEquals(providerProperties, providerChannel.getProviderProperties())
        );
    }

    @Test
    void settersShouldUpdateFieldsCorrectly() {
        ChannelType initialType = ChannelType.SMS;
        List<ProviderProperty> initialProperties = List.of(new ProviderProperty("name1", "desc1", true));
        ProviderChannel providerChannel = new ProviderChannel(initialType, initialProperties);

        ChannelType updatedType = ChannelType.SMS;
        List<ProviderProperty> updatedProperties = List.of(new ProviderProperty("name2", "desc2", false));
        providerChannel.setType(updatedType);
        providerChannel.setProviderProperties(updatedProperties);

        assertAll(
                () -> assertEquals(updatedType, providerChannel.getType()),
                () -> assertEquals(updatedProperties, providerChannel.getProviderProperties())
        );
    }

    @Test
    void equalsAndHashCodeShouldBeConsistent() {
        ChannelType type = ChannelType.SMS; // Substitua conforme necessário
        List<ProviderProperty> providerProperties = Arrays.asList(new ProviderProperty("name1", "desc1", true), new ProviderProperty("name2", "desc2", false));

        ProviderChannel providerChannel1 = new ProviderChannel(type, providerProperties);
        ProviderChannel providerChannel2 = new ProviderChannel(type, providerProperties);

        assertEquals(providerChannel1, providerChannel2);
        assertEquals(providerChannel1.hashCode(), providerChannel2.hashCode());
    }

    @Test
    void toStringShouldReturnCorrectFormat() {
        ChannelType type = ChannelType.SMS;
        List<ProviderProperty> providerProperties = Arrays.asList(new ProviderProperty("name1", "desc1", true), new ProviderProperty("name2", "desc2", false));

        ProviderChannel providerChannel = new ProviderChannel(type, providerProperties);

        String expectedString = "ProviderChannel{" +
                "type=" + type +
                ", providerProperties=" + providerProperties +
                '}';
        assertEquals(expectedString, providerChannel.toString());
    }

    @Test
    void testCopy() throws PhoneNumberException {
        ChannelType type = ChannelType.SMS;
        List<ProviderProperty> providerProperties = Arrays.asList(new ProviderProperty("name1", "desc1", true), new ProviderProperty("name2", "desc2", false));

        ProviderChannel original = new ProviderChannel(type, providerProperties);
        ProviderChannel copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }
}
