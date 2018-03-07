package com.facebook.messaging.forward;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: sms promo enable readonly */
public class MessageForwardErrorReporter {
    private final AbstractFbErrorReporter f2380a;

    public static MessageForwardErrorReporter m2239b(InjectorLike injectorLike) {
        return new MessageForwardErrorReporter((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public MessageForwardErrorReporter(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f2380a = abstractFbErrorReporter;
    }
}
