package com.facebook.growth.contactimporter;

import android.os.SystemClock;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import javax.inject.Inject;

/* compiled from: paymentPinProtectionsParams */
public class SendInviteLogger {
    public final AnalyticsLogger f7114a;

    @Inject
    public SendInviteLogger(AnalyticsLogger analyticsLogger) {
        this.f7114a = analyticsLogger;
    }

    public final void m7396a(int i) {
        this.f7114a.a(new FindFriendsAnalyticsEvent("invite").m7381o("opened").m7380a(i));
    }

    public final void m7397a(int i, int i2, String str, long j) {
        AnalyticsLogger analyticsLogger = this.f7114a;
        FindFriendsAnalyticsEvent o = new FindFriendsAnalyticsEvent("invite").m7381o("submitted");
        o.a("delta_t", SystemClock.uptimeMillis() - j);
        o = o.m7380a(i2);
        o.a("invites_sent", i);
        HoneyClientEvent honeyClientEvent = o;
        honeyClientEvent.b("submit_type", str);
        analyticsLogger.a(honeyClientEvent);
    }
}
