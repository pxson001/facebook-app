package com.facebook.languages.switcher.logging;

import android.telephony.TelephonyManager;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import javax.inject.Inject;

/* compiled from: time_until_reminder */
public class LanguageSwitcherActivityLogger {
    public final AnalyticsLogger f1416a;
    public final TelephonyManager f1417b;

    @Inject
    public LanguageSwitcherActivityLogger(AnalyticsLogger analyticsLogger, TelephonyManager telephonyManager) {
        this.f1416a = analyticsLogger;
        this.f1417b = telephonyManager;
    }

    public static HoneyClientEvent m1410a(LanguageSwitcherActivityEventType languageSwitcherActivityEventType) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(languageSwitcherActivityEventType.getAnalyticsName());
        honeyClientEvent.c = "language_switcher_activity";
        return honeyClientEvent;
    }

    public final void m1411a() {
        this.f1416a.a(m1410a(LanguageSwitcherActivityEventType.SUGGESTIONS_FETCHED));
    }

    public final void m1412b() {
        this.f1416a.a(m1410a(LanguageSwitcherActivityEventType.NO_SUGGESTIONS));
    }

    public final void m1414c() {
        this.f1416a.a(m1410a(LanguageSwitcherActivityEventType.SUGGESTIONS_FAILED));
    }

    public final void m1413b(String str) {
        this.f1416a.a(m1410a(LanguageSwitcherActivityEventType.OTHER_LANGUAGES_SELECTED).b("selected_locale", str));
    }
}
