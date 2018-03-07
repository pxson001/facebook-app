package com.facebook.places.create.home;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: card_number_input_controller_fragment_tag */
public class HomeActivityLogger {
    private final AnalyticsLogger f18297a;
    private final MonotonicClock f18298b;
    public HomeActivityModel f18299c;
    public String f18300d;
    public HomeActivityLoggerData f18301e;

    public static HomeActivityLogger m22238b(InjectorLike injectorLike) {
        return new HomeActivityLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    public static HomeActivityLogger m22237a(InjectorLike injectorLike) {
        return m22238b(injectorLike);
    }

    @Inject
    public HomeActivityLogger(AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock) {
        this.f18297a = analyticsLogger;
        this.f18298b = monotonicClock;
    }

    public final void m22242a(String str, String str2) {
        if (!this.f18301e.f18303b) {
            this.f18301e.f18303b = true;
            this.f18297a.c(m22236a(m22241c("home_creation_cell_shown", "home_creation"), str, str2));
        }
    }

    public final void m22244b(String str, String str2) {
        this.f18297a.c(m22236a(m22241c("home_creation_cell_tapped", "home_creation"), str, str2));
    }

    public final void m22243b() {
        HoneyClientEvent c = m22240c(m22239b("home_%s_init"));
        c.a("default_value", true);
        this.f18297a.c(c);
    }

    public final void m22245c() {
        this.f18297a.c(m22240c(m22239b("home_%s_backgrounded")));
    }

    public final void m22246d() {
        this.f18297a.c(m22240c(m22239b("home_%s_address_tapped")));
    }

    public final void m22247e() {
        this.f18297a.c(m22240c(m22239b("home_%s_address_updated")));
    }

    public final void m22248f() {
        this.f18297a.c(m22240c(m22239b("home_%s_name_tapped")));
    }

    public final void m22249g() {
        this.f18297a.c(m22240c(m22239b("home_%s_name_updated")));
    }

    public final void m22250h() {
        this.f18297a.c(m22240c(m22239b("home_%s_neighborhood_tapped")));
    }

    public final void m22251i() {
        this.f18297a.c(m22240c(m22239b("home_%s_neighborhood_updated")));
    }

    public final void m22252j() {
        this.f18297a.c(m22240c(m22239b("home_%s_city_tapped")));
    }

    public final void m22253k() {
        this.f18297a.c(m22240c(m22239b("home_%s_city_updated")));
    }

    public final void m22254l() {
        this.f18297a.c(m22240c(m22239b("home_%s_privacy_tapped")));
    }

    public final void m22255m() {
        this.f18297a.c(m22240c(m22239b("home_%s_privacy_updated")));
    }

    public final void m22256n() {
        this.f18297a.c(m22240c(m22239b("home_%s_camera_icon_tapped")));
    }

    public final void m22257o() {
        this.f18297a.c(m22240c(m22239b("home_%s_remove_camera_icon_tapped")));
    }

    public final void m22258p() {
        this.f18297a.c(m22240c(m22239b("home_%s_update_camera_icon_tapped")));
    }

    public final void m22259q() {
        this.f18297a.c(m22240c(m22239b("home_%s_photo_picker_picked")));
    }

    public final void m22260r() {
        this.f18297a.c(m22240c(m22239b("home_%s_photo_picker_cancelled")));
    }

    public final void m22261s() {
        this.f18297a.c(m22240c(m22239b("home_%s_cancelled")));
    }

    public final void m22262t() {
        this.f18297a.c(m22240c(m22239b("home_%s_done_tapped")));
    }

    public final void m22263u() {
        this.f18297a.c(m22240c(m22239b("home_%s_network_error")));
    }

    public final void m22264v() {
        HoneyClientEvent c = m22240c("home_creation_created");
        c.b("created_place_id", this.f18300d);
        this.f18297a.c(c);
    }

    public final void m22265w() {
        this.f18297a.c(m22240c("home_edit_updated"));
    }

    private String m22239b(String str) {
        switch (this.f18299c.f18318k) {
            case CREATE:
                return String.format(Locale.US, str, new Object[]{"creation"});
            case EDIT:
                return String.format(Locale.US, str, new Object[]{"edit"});
            default:
                return null;
        }
    }

    private HoneyClientEvent m22240c(String str) {
        HoneyClientEvent c = m22241c(str, m22239b("home_%s"));
        Preconditions.checkNotNull(this.f18299c);
        Preconditions.checkNotNull(this.f18301e.f18302a);
        c.b("name", this.f18299c.f18308a);
        c.b("city", this.f18299c.f18309b);
        c.b("address", this.f18299c.f18310c);
        c.b("neighborhood", this.f18299c.f18311d);
        if (this.f18299c.f18314g != null) {
            c.b("privacy", this.f18299c.f18314g.toString());
        }
        c.b("home_session_id", this.f18301e.f18302a);
        c.b("composer_session_id", this.f18301e.f18304c);
        c.b("entry_flow", this.f18301e.f18307f);
        return c;
    }

    private HoneyClientEvent m22241c(String str, String str2) {
        Preconditions.checkNotNull(this.f18301e);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f = this.f18301e.f18304c;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.c = str2;
        honeyClientEvent = honeyClientEvent;
        if (this.f18301e.f18306e != 0) {
            honeyClientEvent.a("place_picker_milliseconds_since_start", this.f18298b.now() - this.f18301e.f18306e);
        }
        return honeyClientEvent;
    }

    private HoneyClientEvent m22236a(HoneyClientEvent honeyClientEvent, String str, String str2) {
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(str);
        honeyClientEvent.b("query", str2);
        honeyClientEvent.b("results_list_id", str);
        honeyClientEvent.b("place_picker_session_id", this.f18301e.f18305d);
        honeyClientEvent.b("composer_session_id", this.f18301e.f18304c);
        return honeyClientEvent;
    }
}
