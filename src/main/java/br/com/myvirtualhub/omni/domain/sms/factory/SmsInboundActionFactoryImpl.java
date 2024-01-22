/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.domain.sms.factory;

import br.com.myvirtualhub.omni.domain.sms.action.SmsInboundActionImplV1;
import br.com.myvirtualhub.omni.ports.inbound.sms.interfaces.SmsInboundAction;
import br.com.myvirtualhub.omni.ports.inbound.sms.interfaces.SmsInboundActionFactory;

/**
 * Implementation of the SmsInboundActionFactory interface that creates an instance of the SmsInboundActionImplV1 class.
 */
public class SmsInboundActionFactoryImpl implements SmsInboundActionFactory<SmsInboundAction> {

    private static final SmsInboundActionImplV1 instance = new SmsInboundActionImplV1();

    /**
     * Creates an instance of SmsInboundAction.
     * @return An instance of SmsInboundAction.
     */
    @Override
    public SmsInboundAction create() {
        return instance;
    }
}
