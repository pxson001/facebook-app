package com.facebook.messaging.forward;

import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: sms_contact_picker_progress_dialog */
public class MessageBroadcastHandler {
    private final DefaultBlueServiceOperationFactory f2378a;
    private final MessageForwardErrorReporter f2379b;

    private static MessageBroadcastHandler m2238b(InjectorLike injectorLike) {
        return new MessageBroadcastHandler(DefaultBlueServiceOperationFactory.b(injectorLike), MessageForwardErrorReporter.m2239b(injectorLike));
    }

    @Inject
    public MessageBroadcastHandler(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, MessageForwardErrorReporter messageForwardErrorReporter) {
        this.f2378a = defaultBlueServiceOperationFactory;
        this.f2379b = messageForwardErrorReporter;
    }
}
