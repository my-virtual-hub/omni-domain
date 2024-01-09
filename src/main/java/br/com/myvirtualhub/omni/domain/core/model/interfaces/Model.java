/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.model.interfaces;

/**
 * This is a standard interface for all business rule Model classes in the project.
 * It defines a contract that all Model classes are required to follow for maintaining
 * consistency and operational correctness.
 * <p>
 * Model classes in this context encapsulate business logic, controlling how data can
 * be accessed and modified. Using models helps to keep the code structured, reusable,
 * and easier to maintain.
 * <p>
 * Other classes in the project (like services and repositories) depend on these
 * Model interfaces for carrying out business processes effectively.
 *
 * @since 2023-08-01
 */
public interface Model {

    /**
     * Masks the sensitive data. If the sensitive data length is smaller than 5 or is null, the returned string will contain only asterisks.
     * If the length is equal or larger than 5, the first 20% of the characters will be visible and the remaining characters will be replaced by asterisks.
     *
     * @param sensitiveData The sensitive data in form of a string that should be masked.
     * @return The masked string. If sensitiveData is null, a single asterisk is returned.
     */
    default String printSensitiveData(String sensitiveData) {
        if (sensitiveData == null) {
            return "*";
        }
        else if (sensitiveData.length() < 5) {
            return "*".repeat(sensitiveData.length());
        }

        int visibleLength = (int)Math.ceil(sensitiveData.length() * 0.2);
        StringBuilder output = new StringBuilder(sensitiveData.length());

        output.append(sensitiveData, 0, visibleLength);
        while (output.length() < sensitiveData.length()) {
            output.append('*');
        }

        return output.toString();
    }
}