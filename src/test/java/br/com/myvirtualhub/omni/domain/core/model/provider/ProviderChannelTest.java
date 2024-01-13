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
