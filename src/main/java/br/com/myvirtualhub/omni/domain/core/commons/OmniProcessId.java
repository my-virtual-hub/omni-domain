/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.commons;

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

    /**
     * Constructs a new instance of OmniProcessId with the specified channel type.
     *
     * @param channelType the channel type for the OmniProcessId
     * @throws NullPointerException if the channelType is null
     */
    protected OmniProcessId(ChannelType channelType) {
        Objects.requireNonNull(channelType, "OmniProcessId channelType cannot be null");
        this.prefix = "omni";
        this.channelType = channelType;
        this.omniProcessUUID = UUID.randomUUID();
    }

    /**
     * Retrieves the prefix associated with the OmniProcessId.
     *
     * @return The prefix of the OmniProcessId.
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Retrieves the channel type associated with the OmniProcessId.
     *
     * @return The channel type of the OmniProcessId.
     */
    public ChannelType getChannelType() {
        return channelType;
    }

    /**
     * Retrieves the universally unique identifier (UUID) associated with the OmniProcessId.
     *
     * @return The UUID of the OmniProcessId.
     */
    public UUID getOmniProcessUUID() {
        return omniProcessUUID;
    }

    /**
     * Compares this OmniProcessId to the specified object for equality.
     *
     * @param o the object to compare to
     * @return {@code true} if the specified object is equal to this OmniProcessId, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OmniProcessId that)) return false;
        return getPrefix().equals(that.getPrefix()) && getChannelType() == that.getChannelType() && getOmniProcessUUID().equals(that.getOmniProcessUUID());
    }

    /**
     * Calculates the hash code value for this OmniProcessId object.
     *
     * The hash code is calculated by combining the hash codes of the prefix, channel type, and OmniProcessUUID
     * fields using the Objects.hash() method.
     *
     * @return The hash code value for this OmniProcessId object.
     *
     * @see Objects#hash(Object...)
     * @see #getPrefix()
     * @see #getChannelType()
     * @see #getOmniProcessUUID()
     */
    @Override
    public int hashCode() {
        return Objects.hash(getPrefix(), getChannelType(), getOmniProcessUUID());
    }

    /**
     * Retrieves the OmniProcess ID, which is a concatenation of the prefix, channel type,
     * and OmniProcess UUID associated with the OmniProcessId object.
     *
     * @return The OmniProcess ID in the format: prefix:channelType:omniProcessUUID
     */
    public final String getOmniProcessId() {
        return getPrefix() + ":" + getChannelType().toString() + ":" + getOmniProcessUUID().toString();
    }

    /**
     * Returns a string representation of the OmniProcessId object. The string representation
     * includes the class name, prefix, channelType, and omniProcessUUID.
     *
     * @return A string representation of the OmniProcessId object.
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
                "prefix='" + prefix + '\'' +
                ", channelType=" + channelType +
                ", omniProcessUUID=" + omniProcessUUID +
                '}';
    }
}
