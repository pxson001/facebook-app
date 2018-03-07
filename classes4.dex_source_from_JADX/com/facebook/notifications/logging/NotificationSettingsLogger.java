package com.facebook.notifications.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: experiment group */
public class NotificationSettingsLogger {
    public final AnalyticsLogger f12615a;

    public static NotificationSettingsLogger m13424b(InjectorLike injectorLike) {
        return new NotificationSettingsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NotificationSettingsLogger(AnalyticsLogger analyticsLogger) {
        this.f12615a = analyticsLogger;
    }

    public final void m13425a(Surface surface) {
        this.f12615a.a(m13423a("native_settings_launched", surface));
    }

    public final void m13426a(Surface surface, String str) {
        m13427a(surface, str, null);
    }

    public final void m13427a(Surface surface, String str, @Nullable String str2) {
        HoneyClientEvent b = m13423a("native_settings_row_clicked", surface).b("notif_option_id", str);
        if (!Strings.isNullOrEmpty(str2)) {
            b.b("object_id", str2);
        }
        this.f12615a.a(b);
    }

    public static HoneyClientEvent m13423a(String str, Surface surface) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "notifications";
        return honeyClientEvent.b("surface", surface.name());
    }
}
