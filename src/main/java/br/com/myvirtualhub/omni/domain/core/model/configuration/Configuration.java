/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.configuration;

import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

import java.util.List;
import java.util.Objects;

/**
 * Class that represents the configuration linking the apiToken to the configuration data.
 * This class serves as a data structure that combines authentication via an API token
 * with the respective service provider settings.
 * Through this class, the application can efficiently map the corresponding
 * configuration information for accessing a service provider through
 * a specific API token.
 *
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-08
 */
public class Configuration implements Model {

    private String apiToken;

    private String providerName;

    private List<ChannelProperties> channelProperties;

    /**
     * Creates a new instance of the Configuration class with the specified API token,
     * provider name, and channel properties.
     *
     * @param apiToken          The API token associated with the configuration.
     * @param providerName      The name of the service provider.
     * @param channelProperties The list of channel properties for the configuration.
     */
    public Configuration(String apiToken, String providerName, List<ChannelProperties> channelProperties) {
        setApiToken(apiToken);
        setProviderName(providerName);
        setChannelProperties(channelProperties);
    }

    /**
     * Retrieves the API token associated with the configuration.
     *
     * @return The API token as a string.
     */
    public String getApiToken() {
        return apiToken;
    }

    /**
     * Sets the API token associated with the configuration.
     *
     * @param apiToken The API token to set. Cannot be null.
     */
    public void setApiToken(String apiToken) {
        Objects.requireNonNull(apiToken, "Configuration apiToken cannot be null");
        this.apiToken = apiToken;
    }

    /**
     * Retrieves the name of the service provider.
     *
     * @return The name of the service provider as a string.
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the name of the service provider.
     *
     * @param providerName The name of the service provider to set. Cannot be null.
     */
    public void setProviderName(String providerName) {
        Objects.requireNonNull(providerName, "Configuration providerName cannot be null");
        this.providerName = providerName;
    }

    /**
     * Retrieves the list of channel properties associated with the configuration.
     *
     * @return The list of channel properties.
     */
    public List<ChannelProperties> getChannelProperties() {
        return channelProperties;
    }

    /**
     * Sets the list of channel properties for the configuration.
     *
     * @param channelProperties The list of channel properties to set. Cannot be null.
     */
    public void setChannelProperties(List<ChannelProperties> channelProperties) {
        Objects.requireNonNull(channelProperties, "Configuration channelProperties cannot be null");
        this.channelProperties = channelProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Configuration that)) return false;
        return getApiToken().equals(that.getApiToken()) && getProviderName().equals(that.getProviderName()) && getChannelProperties().equals(that.getChannelProperties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getApiToken(), getProviderName(), getChannelProperties());
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "apiToken='" + printSensitiveData(apiToken) + '\'' +
                ", providerName='" + providerName + '\'' +
                ", channelProperties=" + channelProperties +
                '}';
    }

}
