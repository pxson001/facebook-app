package com.facebook.friendsharing.suggestedcoverphotos.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: moderate */
public class SuggestedCoverPhotosLogger {
    public final AnalyticsLogger f13371a;

    public static SuggestedCoverPhotosLogger m19697b(InjectorLike injectorLike) {
        return new SuggestedCoverPhotosLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public SuggestedCoverPhotosLogger(AnalyticsLogger analyticsLogger) {
        this.f13371a = analyticsLogger;
    }

    public final void m19698a(String str, int i) {
        this.f13371a.mo526a(m19696a(str, Action.CLICK_PHOTO_PREVIEW.name()).m5083a("position", i));
    }

    public final void m19699g(String str) {
        this.f13371a.mo526a(m19696a(str, Action.CANCEL_EDITOR.name()));
    }

    public static HoneyClientEvent m19696a(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("suggested_cover_photos_prompt");
        honeyClientEvent.f3102f = str;
        return honeyClientEvent.m5090b("action", str2);
    }
}
