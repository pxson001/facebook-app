package com.facebook.messaging.payment.intents;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: initial_loading_done */
public class PaymentIntentHandler {
    private final Context f13006a;
    private final AbstractFbErrorReporter f13007b;
    private final AnalyticsLogger f13008c;

    private static PaymentIntentHandler m13304b(InjectorLike injectorLike) {
        return new PaymentIntentHandler((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PaymentIntentHandler(Context context, AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger) {
        this.f13006a = context;
        this.f13007b = abstractFbErrorReporter;
        this.f13008c = analyticsLogger;
    }
}
