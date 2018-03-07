package com.facebook.spherical.photo;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: hi_res_photo_upload_pref */
public class SphericalPhotoAnalyticsLogger {
    private final AnalyticsLogger f21103a;

    public static SphericalPhotoAnalyticsLogger m28846b(InjectorLike injectorLike) {
        return new SphericalPhotoAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    @Inject
    public SphericalPhotoAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f21103a = analyticsLogger;
    }

    public final void m28847a() {
        m28845a("tap_360_photo_view_in_vr", null, "photo_360");
    }

    public final void m28848b() {
        m28845a("show_360_photo_view_in_vr", null, "photo_360");
    }

    public final void m28849c() {
        m28845a("tap_360_photo_feed_to_fullscreen", null, "photo_360");
    }

    public final void m28850d() {
        m28845a("phone_pan_animation_360_photo", null, "photo_360");
    }

    public final void m28851e() {
        m28845a("tap_360_photo_heading_indicator", null, "photo_360");
    }

    private void m28845a(String str, Map<String, String> map, String str2) {
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = str2;
        if (map == null) {
            map = new HashMap();
        }
        for (Entry entry : r6.entrySet()) {
            honeyClientEvent.m5090b((String) entry.getKey(), (String) entry.getValue());
        }
        this.f21103a.mo526a(honeyClientEvent);
    }
}
