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
