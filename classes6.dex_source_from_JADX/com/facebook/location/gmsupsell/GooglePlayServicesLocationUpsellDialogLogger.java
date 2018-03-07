package com.facebook.location.gmsupsell;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: {group} */
public class GooglePlayServicesLocationUpsellDialogLogger {
    private final BaseAnalyticsConfig f104a;
    private final AnalyticsLogger f105b;

    @Inject
    public GooglePlayServicesLocationUpsellDialogLogger(BaseAnalyticsConfig baseAnalyticsConfig, AnalyticsLogger analyticsLogger) {
        this.f104a = baseAnalyticsConfig;
        this.f105b = analyticsLogger;
    }

    public final void m76a(String str, String str2) {
        HoneyClientEventFast a = m75a("gms_ls_upsell_requested");
        if (a != null) {
            a.a("surface", str);
            a.a("mechanism", str2);
            a.b();
        }
    }

    public final void m77a(String str, String str2, String str3) {
        HoneyClientEventFast a = m75a("gms_ls_upsell_result");
        if (a != null) {
            a.a("surface", str);
            a.a("mechanism", str2);
            a.a("result", str3);
            a.b();
        }
    }

    @Nullable
    private HoneyClientEventFast m75a(String str) {
        if (!this.f104a.a(str)) {
            return null;
        }
        HoneyClientEventFast a = this.f105b.a(str, false);
        if (!a.a()) {
            return null;
        }
        a.a("gms_ls_upsell");
        return a;
    }
}
