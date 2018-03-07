package com.facebook.localcontent.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: ec_success */
public class LocalContentMenuLogger {
    public final AnalyticsLogger f14941a;

    public static LocalContentMenuLogger m17409b(InjectorLike injectorLike) {
        return new LocalContentMenuLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LocalContentMenuLogger(AnalyticsLogger analyticsLogger) {
        this.f14941a = analyticsLogger;
    }

    public final void m17412e(String str) {
        m17410d("upload_photo_menu_impression", str);
    }

    public final void m17413f(String str) {
        m17410d("upload_photo_menu_add_photos_button_click", str);
    }

    public final void m17414g(String str) {
        m17410d("upload_photo_menu_delete_photo_button_click", str);
    }

    private void m17410d(String str, String str2) {
        this.f14941a.a(m17411e(str, str2));
    }

    public static HoneyClientEvent m17411e(String str, String str2) {
        return m17408b("upload_photo_menu", str, str2);
    }

    public static HoneyClientEvent m17408b(String str, String str2, String str3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str2);
        honeyClientEvent.c = str;
        return honeyClientEvent.b("page_id", str3);
    }
}
