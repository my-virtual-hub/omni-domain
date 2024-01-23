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
 * @author Marco Quiçula
 * @version 1.0
 * @since 2024-01-08
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