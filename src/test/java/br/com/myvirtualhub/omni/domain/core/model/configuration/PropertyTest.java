/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.configuration;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PropertyTest {

    @Test
    void testConstructorAndGetters() {
        Property property = new Property("key", "value");
        assertEquals("key", property.getName());
        assertEquals("value", property.getValue());
    }

    @Test
    void testSetters() {
        Property property = new Property("key", "value");
        property.setName("newKey");
        property.setValue("newValue");

        assertEquals("newKey", property.getName());
        assertEquals("newValue", property.getValue());
    }

    @Test
    void testEquals() {
        Property property1 = new Property("key", "value");
        Property property2 = new Property("key", "value");
        Property property3 = new Property("differentKey", "value");

        assertEquals(property1, property2);
        assertNotEquals(property1, property3);
    }

    @Test
    void testHashCode() {
        Property property1 = new Property("key", "value");
        Property property2 = new Property("key", "value");

        assertEquals(property1.hashCode(), property2.hashCode());
    }

    @Test
    void testToString() {
        Property property = new Property("key", "value");
        String expectedString = "Property{name='key', value='value'}";

        assertEquals(expectedString, property.toString());
    }

    @Test
    void testCopy() {
        Property original = new Property("key", "value");
        Property copy = original.copy();

        assertNotSame(original, copy);
        assertEquals(original, copy);
    }

    @Test
    void testNullName() {
        assertThrows(NullPointerException.class, () -> new Property(null, "value"));
    }

    @Test
    void testNullValue() {
        assertThrows(NullPointerException.class, () -> new Property("key", null));
    }

    @Test
    void testSetNullName() {
        Property property = new Property("key", "value");
        assertThrows(NullPointerException.class, () -> property.setName(null));
    }

    @Test
    void testSetNullValue() {
        Property property = new Property("key", "value");
        assertThrows(NullPointerException.class, () -> property.setValue(null));
    }
}
