/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.core.provider;

import br.com.myvirtualhub.omni.domain.sms.factory.SmsInboundActionFactoryImpl;
import br.com.myvirtualhub.omni.ports.inbound.core.exceptions.ProviderFactoryException;
import br.com.myvirtualhub.omni.ports.inbound.core.interfaces.InboudActionFactory;
import br.com.myvirtualhub.omni.ports.inbound.core.provider.InboundActionProviderFactory;
import br.com.myvirtualhub.omni.ports.inbound.sms.interfaces.SmsInboundActionFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InitializeProviderFactoryTest {

    @Test
    void testProviderFactoryInitialization() throws ProviderFactoryException {
        InitializeProviderFactory.getInstance();
        InboudActionFactory<?> factory = InboundActionProviderFactory.getInstance().getFactory(SmsInboundActionFactory.class.getSimpleName());
        assertNotNull(factory);
        assertSame(SmsInboundActionFactoryImpl.class, factory.getClass());
    }
}
