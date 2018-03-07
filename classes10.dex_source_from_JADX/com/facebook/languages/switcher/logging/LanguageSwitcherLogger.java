package com.facebook.languages.switcher.logging;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.locale.FBLocaleMapper;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.LocaleUtil;
import com.facebook.inject.InjectorLike;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: time_threshold_to_restart_geofence_ms */
public class LanguageSwitcherLogger {
    public final AnalyticsLogger f1418a;
    private final Locales f1419b;

    public static LanguageSwitcherLogger m1415b(InjectorLike injectorLike) {
        return new LanguageSwitcherLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), Locales.a(injectorLike));
    }

    @Inject
    public LanguageSwitcherLogger(AnalyticsLogger analyticsLogger, Locales locales) {
        this.f1418a = analyticsLogger;
        this.f1419b = locales;
    }

    public final void m1417a(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(LanguageSwitcherEventType.SWITCH.getAnalyticsName());
        honeyClientEvent.c = "language_switcher";
        this.f1418a.c(honeyClientEvent.b("current_app_locale", str).b("new_app_locale", str2).b("current_fb_locale", m1416b(str)).b("new_fb_locale", m1416b(str2)).b("system_locale", Locales.e().toString()));
    }

    public final void m1418b(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(LanguageSwitcherEventType.SWITCH_PROMO.getAnalyticsName());
        honeyClientEvent.c = "language_switcher";
        this.f1418a.c(honeyClientEvent.b("current_app_locale", str).b("new_app_locale", str2).b("current_fb_locale", m1416b(str)).b("new_fb_locale", m1416b(str2)).b("system_locale", Locales.e().toString()));
    }

    private String m1416b(String str) {
        Locale e;
        if ("device".equals(str)) {
            e = Locales.e();
        } else {
            e = LocaleUtil.a(str);
        }
        return FBLocaleMapper.a(this.f1419b.a(e));
    }
}
