/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.model.configuration;

import br.com.myvirtualhub.omni.domain.model.interfaces.Model;

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

    public Configuration(String apiToken, String providerName, List<ChannelProperties> channelProperties) {
        setApiToken(apiToken);
        setProviderName(providerName);
        setChannelProperties(channelProperties);
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        Objects.requireNonNull(apiToken, "Configuration apiToken cannot be null");
        this.apiToken = apiToken;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        Objects.requireNonNull(providerName, "Configuration providerName cannot be null");
        this.providerName = providerName;
    }

    public List<ChannelProperties> getChannelProperties() {
        return channelProperties;
    }

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
