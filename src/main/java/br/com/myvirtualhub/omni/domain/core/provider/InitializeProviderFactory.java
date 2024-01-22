/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.provider;

import br.com.myvirtualhub.omni.domain.sms.factory.SmsInboundActionFactoryImpl;
import br.com.myvirtualhub.omni.ports.inbound.core.interfaces.InboudActionFactory;
import br.com.myvirtualhub.omni.ports.inbound.core.provider.InboundActionProviderFactory;

import java.util.List;

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

    /**
     * Initializes the provider factory by adding a list of inbound action factories
     * and initializing the InboundActionProviderFactory.
     */
    private void initialize() {
        List<? extends InboudActionFactory<?>> factoriesList = List.of(new SmsInboundActionFactoryImpl());
        InboundActionProviderFactory.getInstance().initialize(factoriesList);
    }

    /**
     * Returns the singleton instance of the InitializeProviderFactory class.
     *
     * @return The InitializeProviderFactory instance.
     */
    public static InitializeProviderFactory getInstance() {
        return INSTANCE;
    }
}
