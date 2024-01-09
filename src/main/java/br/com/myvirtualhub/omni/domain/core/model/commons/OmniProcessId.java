/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.commons;

import br.com.myvirtualhub.omni.domain.core.enums.ChannelType;
import br.com.myvirtualhub.omni.domain.core.model.interfaces.Model;

import java.util.Objects;
import java.util.UUID;

/**
 * An abstract representation of an Omni Process identifier.
 * An instance of this class encapsulates the unique identification data associated
 * with an Omni process, including the prefix, channel type, and a universally unique identifier.
 *
 *  @author  Marco Quiçula
 *  @version 1.0
 *  @since   2024-01-09
 */
public abstract class OmniProcessId implements Model {

    private final String prefix;

    private final ChannelType channelType;

    private final UUID omniProcessUUID;

    protected OmniProcessId(ChannelType channelType) {
        Objects.requireNonNull(channelType, "OmniProcessId channelType cannot be null");
        this.prefix = "omni";
        this.channelType = channelType;
        this.omniProcessUUID = UUID.randomUUID();
    }

    public String getPrefix() {
        return prefix;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public UUID getOmniProcessUUID() {
        return omniProcessUUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OmniProcessId that)) return false;
        return getPrefix().equals(that.getPrefix()) && getChannelType() == that.getChannelType() && getOmniProcessUUID().equals(that.getOmniProcessUUID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrefix(), getChannelType(), getOmniProcessUUID());
    }

    public final String getOmniProcessId() {
        return getPrefix() + ":" + getChannelType().toString() + ":" + getOmniProcessUUID().toString();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "prefix='" + prefix + '\'' +
                ", channelType=" + channelType +
                ", omniProcessUUID=" + omniProcessUUID +
                '}';
    }
}
