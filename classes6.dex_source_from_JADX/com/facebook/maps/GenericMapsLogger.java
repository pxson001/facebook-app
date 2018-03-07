package com.facebook.maps;

import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import javax.inject.Inject;

/* compiled from: with_tag_count */
public class GenericMapsLogger {
    private final BaseAnalyticsConfig f194a;
    private final AnalyticsLogger f195b;

    @Inject
    public GenericMapsLogger(BaseAnalyticsConfig baseAnalyticsConfig, AnalyticsLogger analyticsLogger) {
        this.f194a = baseAnalyticsConfig;
        this.f195b = analyticsLogger;
    }

    public final void m162a() {
        HoneyClientEventFast d = m161d("generic_map_my_location_button_impression");
        if (d != null) {
            d.b();
        }
    }

    public final void m164b() {
        HoneyClientEventFast d = m161d("generic_map_my_location_button_clicked");
        if (d != null) {
            d.b();
        }
    }

    public final void m163a(String str) {
        HoneyClientEventFast d = m161d("generic_map_ls_upsell_launched");
        if (d != null) {
            d.a("mechanism", str);
            d.b();
        }
    }

    public final void m165b(String str) {
        HoneyClientEventFast d = m161d("generic_map_ls_upsell_result");
        if (d != null) {
            d.a("result", str);
            d.b();
        }
    }

    public final void m166c(String str) {
        HoneyClientEventFast d = m161d("generic_map_runtime_permission_result");
        if (d != null) {
            d.a("result", str);
            d.b();
        }
    }

    private HoneyClientEventFast m161d(String str) {
        if (!this.f194a.a(str)) {
            return null;
        }
        HoneyClientEventFast a = this.f195b.a(str, false);
        if (!a.a()) {
            return null;
        }
        a.a("oxygen_map");
        return a;
    }
}
