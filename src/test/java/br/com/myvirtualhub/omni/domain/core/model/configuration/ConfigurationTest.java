/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.configuration;

import static org.junit.jupiter.api.Assertions.*;

import br.com.myvirtualhub.omni.commons.enums.ChannelType;
import org.junit.jupiter.api.Test;

import java.util.List;

class ConfigurationTest {

    @Test
    void constructorShouldInitializeFieldsCorrectly() {
        String apiToken = "token123";
        String providerName = "Provider";
        List<ChannelProperties> channelProperties = List.of(new ChannelProperties(ChannelType.SMS, true, null)); // Substitua conforme necessário

        Configuration configuration = new Configuration(apiToken, providerName, channelProperties);

        assertAll(
                () -> assertEquals(apiToken, configuration.getApiToken()),
                () -> assertEquals(providerName, configuration.getProviderName()),
                () -> assertEquals(channelProperties, configuration.getChannelProperties())
        );
    }

    @Test
    void settersShouldUpdateFieldsCorrectly() {
        String initialApiToken = "token123";
        String initialProviderName = "Provider";
        List<ChannelProperties> initialChannelProperties = List.of(new ChannelProperties(ChannelType.SMS, true, null)); // Substitua conforme necessário

        Configuration configuration = new Configuration(initialApiToken, initialProviderName, initialChannelProperties);

        String newApiToken = "newToken123";
        String newProviderName = "NewProvider";
        List<ChannelProperties> newChannelProperties = List.of(new ChannelProperties(ChannelType.SMS, false, null)); // Substitua conforme necessário

        configuration.setApiToken(newApiToken);
        configuration.setProviderName(newProviderName);
        configuration.setChannelProperties(newChannelProperties);

        assertAll(
                () -> assertEquals(newApiToken, configuration.getApiToken()),
                () -> assertEquals(newProviderName, configuration.getProviderName()),
                () -> assertEquals(newChannelProperties, configuration.getChannelProperties())
        );
    }

    @Test
    void equalsAndHashCodeShouldBeConsistent() {
        String apiToken = "token123";
        String providerName = "Provider";
        List<ChannelProperties> channelProperties = List.of(new ChannelProperties(ChannelType.SMS, true, null)); // Substitua conforme necessário

        Configuration configuration1 = new Configuration(apiToken, providerName, channelProperties);
        Configuration configuration2 = new Configuration(apiToken, providerName, channelProperties);

        assertEquals(configuration1, configuration2);
        assertEquals(configuration1.hashCode(), configuration2.hashCode());
    }

    @Test
    void toStringShouldReturnCorrectFormat() {
        String apiToken = "token123";
        String apiTokenSentitiveData = "to******";
        String providerName = "Provider";
        List<ChannelProperties> channelProperties = List.of(new ChannelProperties(ChannelType.SMS, true, null)); // Substitua conforme necessário

        Configuration configuration = new Configuration(apiToken, providerName, channelProperties);

        String expectedString = "Configuration{" +
                "apiToken='" + apiTokenSentitiveData + '\'' +
                ", providerName='" + providerName + '\'' +
                ", channelProperties=" + channelProperties +
                '}';
        assertEquals(expectedString, configuration.toString());
    }

    @Test
    void testCopy() {
        String apiToken = "token123";
        String providerName = "Provider";
        List<ChannelProperties> channelProperties = List.of(new ChannelProperties(ChannelType.SMS, true, null)); // Substitua conforme necessário

        Configuration original = new Configuration(apiToken, providerName, channelProperties);
        Configuration copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }
}
