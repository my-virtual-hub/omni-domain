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

package br.com.myvirtualhub.omni.domain.core.initializer;

import br.com.myvirtualhub.omni.domain.sms.factory.SmsInboundActionFactoryImpl;
import br.com.myvirtualhub.omni.ports.inbound.core.provider.InboundActionProviderFactory;
import br.com.myvirtualhub.omni.ports.inbound.sms.interfaces.SmsInboundAction;
import br.com.myvirtualhub.omni.ports.inbound.sms.interfaces.SmsInboundActionFactory;

/**
 * The InitializerInboundActionProviderFactory class initializes the InboundActionProviderFactory by creating
 * and charging a SmsInboundActionFactory into it.
 * Usage:
 * - To initialize the provider factory, call the static method InitializerInboundActionProviderFactory.touch().
 */
public final class InitializerInboundActionProviderFactory {

    static {
        InitializerInboundActionProviderFactory.touch();
    }

    /**
     * The InitializerInboundActionProviderFactory class initializes the InboundActionProviderFactory by creating
     * and charging a SmsInboundActionFactory into it.
     * Usage:
     * - To initialize the provider factory, call the static method InitializerInboundActionProviderFactory.touch().
     */
    private InitializerInboundActionProviderFactory() {
        // private constructor to prevent instantiation of this class
    }

    /**
     * Resets the InboundActionProviderFactory and initializes it.
     * The touch method calls InboundActionProviderFactory.getINSTANCE().resetProviderFactory() to reset the factory,
     * then calls the private initialize() method to initialize it.
     */
    public static void touch() {
        InboundActionProviderFactory.getINSTANCE().resetProviderFactory();
        initialize();
    }
    /**
     * Initializes the InboundActionProviderFactory by creating and charging a SmsInboundActionFactory into it.
     * This method is private and can only be called within the containing class.
     */
    private static void initialize() {
         createSmsFactory();
    }

    /**
     * Creates a SmsInboundActionFactory instance and charges it into the InboundActionProviderFactory.
     * This method is private and can only be called within the containing class.
     */
    private static void createSmsFactory() {
        InboundActionProviderFactory<SmsInboundActionFactory<SmsInboundAction>, SmsInboundAction> providerFactory = InboundActionProviderFactory.getINSTANCE();
        SmsInboundActionFactory<SmsInboundAction> factory = new SmsInboundActionFactoryImpl();
        providerFactory.charge(factory);
    }
}
