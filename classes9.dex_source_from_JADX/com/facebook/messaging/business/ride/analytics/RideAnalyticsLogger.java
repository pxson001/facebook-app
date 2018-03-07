package com.facebook.messaging.business.ride.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.model.threadkey.ThreadKey;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mqtt_back_to_back_attempt_number */
public class RideAnalyticsLogger {
    private final AnalyticsLogger f9055a;
    public final FunnelLoggerImpl f9056b;

    public static RideAnalyticsLogger m9362b(InjectorLike injectorLike) {
        return new RideAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FunnelLoggerImpl.a(injectorLike));
    }

    @Inject
    public RideAnalyticsLogger(AnalyticsLogger analyticsLogger, FunnelLoggerImpl funnelLoggerImpl) {
        this.f9055a = analyticsLogger;
        this.f9056b = funnelLoggerImpl;
    }

    public final void m9367a(RideServiceParams rideServiceParams, boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        HoneyClientEventFast c = m9363c("android_messenger_ride_request");
        if (c.a()) {
            long j;
            HoneyClientEventFast a = c.a("ride").a("provider_id", rideServiceParams.f9311d);
            String str4 = "thread_id";
            if (rideServiceParams.f9309b == null) {
                j = 0;
            } else {
                j = rideServiceParams.f9309b.i();
            }
            a.a(str4, Long.toString(j)).a("entry_point", rideServiceParams.f9308a).a("is_ride_requested", z).a("ride_type_id", str).a("origin_address", str2).a("dest_address", str3).a("request_tag", rideServiceParams.f9313f).b();
        }
    }

    public final void m9364a(RideServiceParams rideServiceParams) {
        HoneyClientEventFast c = m9363c("android_messenger_ride_bottom_sheet");
        if (c.a()) {
            c.a("ride").a("action", "ride_request_triggered").a("entry_point", rideServiceParams.f9308a).a("request_tag", rideServiceParams.f9313f).a("thread_id", m9361a(rideServiceParams.f9309b)).b();
        }
    }

    public final void m9368b(RideServiceParams rideServiceParams) {
        HoneyClientEventFast c = m9363c("android_messenger_ride_bottom_sheet");
        if (c.a()) {
            c.a("ride").a("action", "bottom_sheet_showed").a("entry_point", rideServiceParams.f9308a).a("request_tag", rideServiceParams.f9313f).a("thread_id", m9361a(rideServiceParams.f9309b)).b();
        }
    }

    public final void m9366a(RideServiceParams rideServiceParams, String str, boolean z) {
        HoneyClientEventFast c = m9363c("android_messenger_ride_bottom_sheet");
        if (c.a()) {
            c.a("ride").a("action", "bottom_sheet_item_clicked").a("entry_point", rideServiceParams.f9308a).a("request_tag", rideServiceParams.f9313f).a("provider_id", str).a("has_authorized", z).a("thread_id", m9361a(rideServiceParams.f9309b)).b();
        }
    }

    public final void m9365a(RideServiceParams rideServiceParams, String str, long j) {
        HoneyClientEventFast c = m9363c("android_messenger_ride_bottom_sheet");
        if (c.a()) {
            c.a("ride").a("action", "ride_provider_loaded").a("entry_point", rideServiceParams.f9308a).a("request_tag", rideServiceParams.f9313f).a("thread_id", m9361a(rideServiceParams.f9309b)).a("latency_ms", j).a("result", str).b();
        }
    }

    public final void m9369b(String str) {
        this.f9056b.b(FunnelRegistry.q, str);
    }

    @Nullable
    private static String m9361a(@Nullable ThreadKey threadKey) {
        return threadKey == null ? null : Long.toString(threadKey.i());
    }

    private HoneyClientEventFast m9363c(String str) {
        return this.f9055a.a(str, false);
    }
}
