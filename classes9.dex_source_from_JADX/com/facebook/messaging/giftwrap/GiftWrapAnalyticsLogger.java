package com.facebook.messaging.giftwrap;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: mSendPaymentResultExtra */
public class GiftWrapAnalyticsLogger {
    public final AnalyticsLogger f11106a;

    public static GiftWrapAnalyticsLogger m11491a(InjectorLike injectorLike) {
        return new GiftWrapAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GiftWrapAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f11106a = analyticsLogger;
    }

    public static HoneyClientEvent m11492c(String str) {
        return new HoneyClientEvent("messenger_valentines_2016").b("event_type", str);
    }
}
