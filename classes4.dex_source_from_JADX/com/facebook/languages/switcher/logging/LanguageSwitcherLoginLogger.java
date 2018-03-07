package com.facebook.languages.switcher.logging;

import android.telephony.TelephonyManager;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.locale.Locales;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.util.List;
import javax.inject.Inject;

/* compiled from: tracking_number */
public class LanguageSwitcherLoginLogger {
    public final AnalyticsLogger f763a;
    private final Locales f764b;
    public final TelephonyManager f765c;

    @Inject
    public LanguageSwitcherLoginLogger(AnalyticsLogger analyticsLogger, Locales locales, TelephonyManager telephonyManager) {
        this.f763a = analyticsLogger;
        this.f764b = locales;
        this.f765c = telephonyManager;
    }

    public static HoneyClientEvent m1113a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "language_switcher_login";
        return honeyClientEvent;
    }

    public final void m1115a(List<String> list) {
        HoneyClientEvent a = m1113a("language_switcher_login_suggestions_fetched");
        if (!(list == null || list.isEmpty())) {
            ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
            for (String h : list) {
                arrayNode.h(h);
            }
            a.a("locale_list", arrayNode).a("locale_list_count", list.size());
        }
        this.f763a.a(a);
    }

    public final void m1114a() {
        this.f763a.a(m1113a("language_switcher_login_no_suggestions"));
    }

    public final void m1116b() {
        this.f763a.a(m1113a("language_switcher_login_suggestions_failed"));
    }

    public final void m1117c() {
        this.f763a.a(m1113a("language_switcher_login_locale_clicked"));
    }
}
