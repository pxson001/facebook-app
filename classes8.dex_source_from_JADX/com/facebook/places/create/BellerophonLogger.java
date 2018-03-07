package com.facebook.places.create;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: centered_in */
public class BellerophonLogger {
    public BellerophonLoggerData f18119a;
    private final AnalyticsLogger f18120b;
    private final MonotonicClock f18121c;

    public static BellerophonLogger m22100b(InjectorLike injectorLike) {
        return new BellerophonLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BellerophonLogger(AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock) {
        this.f18120b = analyticsLogger;
        this.f18121c = monotonicClock;
    }

    public final void m22102b() {
        this.f18120b.c(m22099b("bellerophon_start"));
    }

    public final void m22103c() {
        this.f18120b.c(m22099b("bellerophon_skip"));
    }

    public final void m22104d() {
        this.f18120b.c(m22099b("bellerophon_cancel"));
    }

    public final void m22101a(String str) {
        HoneyClientEvent b = m22099b("bellerophon_select");
        b.b("selected_place_id", str);
        this.f18120b.c(b);
    }

    public final void m22105e() {
        this.f18120b.c(m22099b("bellerophon_empty_result"));
    }

    public final void m22106f() {
        this.f18120b.c(m22099b("bellerophon_error"));
    }

    private HoneyClientEvent m22099b(String str) {
        Preconditions.checkNotNull(this.f18119a);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f = this.f18119a.f18122a.b;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.c = "bellerophon";
        honeyClientEvent = honeyClientEvent.b("place_picker_session_id", this.f18119a.f18122a.a).b("bellerophon_session_id", this.f18119a.f18123b);
        if (!(this.f18119a.m22108f() == null || this.f18119a.m22108f().isEmpty())) {
            Preconditions.checkNotNull(this.f18119a.f18124c);
            honeyClientEvent.a("result_list", this.f18119a.m22108f());
            honeyClientEvent.b("result_id", this.f18119a.f18124c);
        }
        if (this.f18119a.m22107d() != 0) {
            honeyClientEvent.a("place_picker_milliseconds_since_start", this.f18121c.now() - this.f18119a.m22107d());
        }
        return honeyClientEvent;
    }
}
