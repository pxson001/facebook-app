package com.facebook.deeplinking.logging;

import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: ph */
public class DeepLinkLoggingUtils {
    public final AnalyticsLogger f6630a;

    public static DeepLinkLoggingUtils m6945b(InjectorLike injectorLike) {
        return new DeepLinkLoggingUtils(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DeepLinkLoggingUtils(AnalyticsLogger analyticsLogger) {
        this.f6630a = analyticsLogger;
    }

    public final void m6946a(Uri uri, Uri uri2) {
        HoneyClientEventFast a = this.f6630a.a("successful_deeplink", true);
        if (a.a()) {
            a.a("incoming_uri", uri.toString());
            a.a("translated_uri", uri2.toString());
            Object queryParameter = uri.getQueryParameter("ref");
            if (!StringUtil.a(queryParameter)) {
                a.a("referral", queryParameter);
            }
            a.b();
        }
    }
}
