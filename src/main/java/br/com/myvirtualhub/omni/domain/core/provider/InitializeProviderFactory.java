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

package br.com.myvirtualhub.omni.domain.core.provider;

import br.com.myvirtualhub.omni.domain.sms.factory.SmsInboundActionFactoryImpl;
import br.com.myvirtualhub.omni.ports.inbound.core.provider.InboundActionProviderFactory;
import br.com.myvirtualhub.omni.ports.inbound.sms.interfaces.SmsInboundAction;
import br.com.myvirtualhub.omni.ports.inbound.sms.interfaces.SmsInboundActionFactory;

/**
 * The InitializeProviderFactory class is a utility class used to initialize the provider factory.
 * It initializes the factory by adding a list of inbound action factories and initializing the InboundActionProviderFactory.
 */
public final class InitializeProviderFactory {

    private static final InitializeProviderFactory INSTANCE = new InitializeProviderFactory();

    /**
     * The InitializeProviderFactory class is a utility class used to initialize the provider factory.
     * It initializes the factory by adding a list of inbound action factories and initializing the InboundActionProviderFactory.
     * The initialization process is triggered by creating an instance of InitializeProviderFactory class,
     * which in turn calls the initialize() method.
     */
    private InitializeProviderFactory() {
        initialize();
    }

    private void initialize() {
        SmsInboundActionFactory<SmsInboundAction> factory = createSmsFactory();
        InboundActionProviderFactory<SmsInboundActionFactory<SmsInboundAction>, SmsInboundAction> providerFactory = InboundActionProviderFactory.getINSTANCE();
        providerFactory.charge(factory);
    }

    /**
     * Create a factory for SmsInboundAction objects.
     *
     * @return The SmsInboundActionFactory instance.
     */
    private SmsInboundActionFactory<SmsInboundAction> createSmsFactory() {
        return new SmsInboundActionFactoryImpl();
    }

    /**
     * Returns the singleton instance of the InitializeProviderFactory class.
     *
     * @return The InitializeProviderFactory instance.
     */
    public static InitializeProviderFactory getINSTANCE() {
        return INSTANCE;
    }

}
