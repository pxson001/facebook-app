package com.facebook.addresstypeahead.analytics;

import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.location.Coordinates;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sentByUser */
public class AddressTypeAheadAnalyticsLogger {
    private final AnalyticsLogger f3902a;

    @Inject
    public AddressTypeAheadAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f3902a = analyticsLogger;
    }

    public final void m3765a(String str, int i, String str2, String str3, String str4, @Nullable Coordinates coordinates, @Nullable Coordinates coordinates2) {
        HoneyClientEventFast a = m3764a("address_typeahead_select");
        if (a.a()) {
            a.a("input_string", str).a("selection_index", i).a("selection", str2).a("product_tag", str3).a("ta_provider", str4);
            if (coordinates != null) {
                a.a("input_latitude", coordinates.a);
                a.a("input_longitude", coordinates.b);
            }
            if (coordinates2 != null) {
                a.a("select_latitude", coordinates2.a);
                a.a("select_longitude", coordinates2.b);
            }
            a.b();
        }
    }

    public final void m3766a(String str, String str2, String str3, String str4) {
        HoneyClientEventFast a = m3764a("address_typeahead_drop");
        if (a.a()) {
            a.a("input_string", str).a("drop_type", str2).a("product_tag", str3).a("ta_provider", str4).b();
        }
    }

    private HoneyClientEventFast m3764a(String str) {
        return this.f3902a.a(str, false);
    }
}
