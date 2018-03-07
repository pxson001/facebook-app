package com.facebook.common.banner;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.inject.InjectorLike;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_review_xout */
public class BannerNotificationAnalyticsHelper {
    private final Context f7687a;
    private final AnalyticsLogger f7688b;

    public static BannerNotificationAnalyticsHelper m11006b(InjectorLike injectorLike) {
        return new BannerNotificationAnalyticsHelper((Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BannerNotificationAnalyticsHelper(Context context, AnalyticsLogger analyticsLogger) {
        this.f7687a = context;
        this.f7688b = analyticsLogger;
    }

    public final void m11007a(String str, String str2, String str3) {
        m11008a(str, str2, str3, null);
    }

    public final void m11008a(String str, String str2, String str3, @Nullable Map<String, ?> map) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "MessengerBannerNotifications";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.d = str2;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.e = str3;
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        if (this.f7687a instanceof AnalyticsActivity) {
            honeyClientEvent2.b("NotificationLocationActivity", ((AnalyticsActivity) this.f7687a).am_());
        }
        if (map != null) {
            honeyClientEvent2.a(map);
        }
        this.f7688b.a(honeyClientEvent2);
    }
}
