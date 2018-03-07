package com.facebook.tagging.logging;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import javax.inject.Inject;

/* compiled from: deltaThreadFolder */
public class MentionsAutoCompleteAnalyticHelper {
    private final AnalyticsLogger f17520a;

    @Inject
    public MentionsAutoCompleteAnalyticHelper(AnalyticsLogger analyticsLogger) {
        this.f17520a = analyticsLogger;
    }

    public final void m25506a(boolean z) {
        HoneyClientEventFast a = m25504a("reply_to_mention_submit");
        if (a.a()) {
            a.a("shortened", z);
            a.b();
        }
    }

    public final void m25505a() {
        HoneyClientEventFast a = m25504a("reply_to_mention_clicked");
        if (a.a()) {
            a.b();
        }
    }

    private HoneyClientEventFast m25504a(String str) {
        return this.f17520a.a(str, false);
    }
}
