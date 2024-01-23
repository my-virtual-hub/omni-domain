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
