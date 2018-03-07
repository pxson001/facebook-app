package com.facebook.messaging.forward;

import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: slideshow_element_end */
public class MessageMontageHandler {
    private final DefaultBlueServiceOperationFactory f2395a;
    private final MessageForwardErrorReporter f2396b;

    private static MessageMontageHandler m2246b(InjectorLike injectorLike) {
        return new MessageMontageHandler(DefaultBlueServiceOperationFactory.b(injectorLike), MessageForwardErrorReporter.m2239b(injectorLike));
    }

    @Inject
    public MessageMontageHandler(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, MessageForwardErrorReporter messageForwardErrorReporter) {
        this.f2395a = defaultBlueServiceOperationFactory;
        this.f2396b = messageForwardErrorReporter;
    }
}
