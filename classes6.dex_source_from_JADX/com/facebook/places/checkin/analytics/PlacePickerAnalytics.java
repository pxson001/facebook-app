package com.facebook.places.checkin.analytics;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.models.SearchResults.ListType;
import com.facebook.places.common.MockDeps;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friend_lists */
public class PlacePickerAnalytics {
    private static PlacePickerAnalytics f14590u;
    private static final Object f14591v = new Object();
    private final AnalyticsLogger f14592a;
    private final MonotonicClock f14593b;
    private String f14594c = "";
    public String f14595d = "";
    public String f14596e = "";
    public SearchType f14597f = SearchType.CHECKIN;
    public SearchResults f14598g;
    private Location f14599h;
    public boolean f14600i;
    public int f14601j;
    public String f14602k;
    private HashSet<CheckinPlace> f14603l = Sets.a();
    private boolean f14604m = false;
    private boolean f14605n = false;
    private boolean f14606o = false;
    private boolean f14607p = false;
    private boolean f14608q = false;
    public boolean f14609r = false;
    private long f14610s;
    public List<String> f14611t;

    private static PlacePickerAnalytics m22182b(InjectorLike injectorLike) {
        return new PlacePickerAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    public static PlacePickerAnalytics m22181a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlacePickerAnalytics b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14591v) {
                PlacePickerAnalytics placePickerAnalytics;
                if (a2 != null) {
                    placePickerAnalytics = (PlacePickerAnalytics) a2.a(f14591v);
                } else {
                    placePickerAnalytics = f14590u;
                }
                if (placePickerAnalytics == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22182b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14591v, b3);
                        } else {
                            f14590u = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = placePickerAnalytics;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PlacePickerAnalytics(AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock) {
        this.f14592a = (AnalyticsLogger) MockDeps.m22224a(AnalyticsLogger.class, (Object) analyticsLogger);
        this.f14593b = (MonotonicClock) MockDeps.m22224a(MonotonicClock.class, (Object) monotonicClock);
    }

    public final void m22184a() {
        this.f14592a.c(m22180a(m22183h("place_picker_started")).a("device_orientation", this.f14601j));
    }

    public final void m22190b() {
        this.f14592a.c(m22180a(m22183h("place_picker_cancelled").a("results_seen", this.f14603l.size())));
    }

    public final void m22192b(boolean z) {
        this.f14592a.c(m22183h("place_picker_removed_place").a("close_out_explicit", z));
    }

    public final void m22193c() {
        this.f14592a.c(m22183h("place_picker_add_place_started"));
    }

    public final void m22189a(CheckinPlaceModel checkinPlaceModel) {
        this.f14592a.c(m22183h("place_picker_add_place_done").a("added_place", Long.parseLong(checkinPlaceModel.cf_())));
    }

    public final void m22195d() {
        if (!this.f14604m) {
            this.f14592a.c(m22180a(m22183h("place_picker_first_scroll")));
        }
        this.f14604m = true;
    }

    public final void m22187a(Location location) {
        if (!this.f14606o) {
            this.f14606o = true;
            this.f14599h = location;
            this.f14592a.c(m22180a(m22183h("place_picker_gps_loaded")));
        }
    }

    public final void m22198f() {
        this.f14609r = true;
        this.f14592a.c(m22183h("place_picker_location_failed"));
    }

    public final void m22185a(int i) {
        if (!this.f14607p) {
            this.f14592a.c(m22180a(m22183h("place_picker_results_loaded")));
            m22186a(0, i);
        }
        this.f14607p = true;
    }

    public final void m22200g() {
        this.f14609r = true;
        this.f14592a.c(m22180a(m22183h("place_picker_error_network_failure")));
    }

    public final void m22202h() {
        this.f14592a.c(m22183h("place_picker_minutiae_shown"));
    }

    public final void m22203i() {
        this.f14592a.c(m22180a(m22183h("place_picker_error_location_disabled")));
    }

    public final void m22196d(String str) {
        this.f14609r = true;
        if (!this.f14605n) {
            this.f14592a.c(m22183h("place_picker_first_keystroke").a("device_orientation", this.f14601j));
        }
        this.f14594c = str;
        this.f14605n = true;
    }

    public final void m22186a(int i, int i2) {
        if (i2 >= this.f14598g.f14666b.size()) {
            i2 = this.f14598g.f14666b.size() - 1;
        }
        while (i <= i2) {
            this.f14603l.add(this.f14598g.f14666b.get(i));
            i++;
        }
    }

    public final void m22197e(String str) {
        this.f14592a.a(m22183h("place_picker_phrase_row_shown").b("qe_group", str));
    }

    public final void m22199f(String str) {
        this.f14592a.a(m22183h("place_picker_phrase_row_selected").b("qe_group", str));
    }

    public final void m22204j() {
        this.f14592a.c(m22183h("place_picker_dragged_to_refresh"));
    }

    public final void m22191b(CheckinPlaceModel checkinPlaceModel) {
        if (this.f14598g == null) {
            throw new IllegalStateException("call onNearbyListChanged first");
        }
        this.f14592a.c(m22180a(m22183h("place_picker_place_picked").a("results_seen", this.f14603l.size()).a("selected_row", this.f14598g.f14666b.indexOf(checkinPlaceModel))));
    }

    public final void m22205k() {
        this.f14592a.a(m22183h("place_picker_long_click"));
    }

    public final void m22206l() {
        this.f14592a.c(m22183h("place_picker_nonintrusive_error_no_location"));
    }

    public final void m22207m() {
        this.f14592a.c(m22183h("place_picker_nonintrusive_error_no_wireless"));
    }

    public final void m22208n() {
        this.f14592a.c(m22183h("place_picker_nonintrusive_error_button_location_settings"));
    }

    public final void m22209o() {
        this.f14592a.c(m22183h("place_picker_nonintrusive_error_ls_settings_page_shown"));
    }

    public final void m22210p() {
        this.f14592a.c(m22183h("place_picker_nonintrusive_error_gms_upsell_shown"));
    }

    public final void m22201g(String str) {
        this.f14592a.c(m22183h("place_picker_nonintrusive_error_gms_upsell_result").b("gms_upsell_result", str));
    }

    public final void m22211q() {
        this.f14592a.c(m22183h("place_picker_nonintrusive_error_button_dismiss"));
    }

    public final void m22212r() {
        this.f14592a.c(m22183h("place_picker_people_to_place_start"));
    }

    public final void m22213s() {
        this.f14592a.c(m22183h("place_picker_minutiae_to_place_start"));
    }

    public final void m22214t() {
        this.f14592a.c(m22183h("place_picker_people_to_place_select"));
    }

    public final void m22215u() {
        this.f14592a.c(m22183h("place_picker_minutiae_to_place_select"));
    }

    public final void m22216v() {
        this.f14592a.c(m22183h("place_picker_people_to_place_skip"));
    }

    public final void m22217w() {
        this.f14592a.c(m22183h("place_picker_minutiae_to_place_skip"));
    }

    public final void m22218x() {
        this.f14592a.a(m22183h("place_picker_app_location_niem_retry"));
    }

    public final void m22194c(boolean z) {
        if (!this.f14608q) {
            this.f14592a.c(m22183h("place_picker_past_places_shown_in_main_list").a("is_most_visited", z));
        }
        this.f14608q = true;
    }

    public final Bundle m22219y() {
        this.f14592a.c(m22183h("place_picker_backgrounded"));
        Bundle bundle = new Bundle();
        bundle.putBoolean("has_saved_instance_state", true);
        bundle.putBoolean("has_results_loaded", this.f14607p);
        bundle.putBoolean("has_past_places_in_main_list_loaded", this.f14608q);
        bundle.putBoolean("has_location_been_received", this.f14606o);
        bundle.putBoolean("has_typed", this.f14605n);
        bundle.putBoolean("has_scrolled", this.f14604m);
        bundle.putBoolean("has_tti_error", this.f14609r);
        bundle.putString("query", this.f14594c);
        bundle.putString("composer_session_id", this.f14595d);
        bundle.putString("place_picker_session_id", this.f14596e);
        bundle.putLong("start_time", this.f14610s);
        bundle.putInt("device_orientation", this.f14601j);
        return bundle;
    }

    public final void m22188a(Bundle bundle) {
        if (bundle.getBoolean("has_saved_instance_state", false)) {
            this.f14607p = bundle.getBoolean("has_results_loaded");
            this.f14608q = bundle.getBoolean("has_past_places_in_main_list_loaded");
            this.f14606o = bundle.getBoolean("has_location_been_received");
            this.f14605n = bundle.getBoolean("has_typed");
            this.f14604m = bundle.getBoolean("has_scrolled");
            this.f14609r = bundle.getBoolean("has_tti_error");
            this.f14594c = bundle.getString("query");
            this.f14595d = bundle.getString("composer_session_id");
            this.f14596e = bundle.getString("place_picker_session_id");
            this.f14610s = bundle.getLong("start_time");
            this.f14601j = bundle.getInt("device_orientation");
        }
    }

    public final PlacePickerSessionData m22220z() {
        return new PlacePickerSessionData(this.f14596e, this.f14595d, this.f14610s);
    }

    private HoneyClientEvent m22183h(String str) {
        ArrayNode arrayNode;
        if (this.f14610s == 0) {
            this.f14610s = this.f14593b.now();
        }
        long now = this.f14593b.now() - this.f14610s;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f = this.f14595d;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.c = "place_picker";
        HoneyClientEvent a = honeyClientEvent.b("query", this.f14594c).b("search_type", this.f14597f.toLegacyString()).b("place_picker_session_id", this.f14596e).a("milliseconds_since_start", now).a("entry_from_checkin", this.f14600i).a("has_tti_error", this.f14609r);
        String str2 = "user_enabled_location_providers";
        List<String> list = this.f14611t;
        ArrayNode b = JsonNodeFactory.a.b();
        if (list == null) {
            arrayNode = b;
        } else {
            for (String h : list) {
                b.h(h);
            }
            arrayNode = b;
        }
        return a.a(str2, arrayNode).b("suggestion_mechanism", this.f14602k);
    }

    private HoneyClientEvent m22180a(HoneyClientEvent honeyClientEvent) {
        if (!(this.f14598g == null || this.f14598g.f14666b == null)) {
            boolean z;
            honeyClientEvent.b("results_list_id", this.f14598g.f14667c);
            honeyClientEvent.a("results_from_cache", this.f14598g.f14669e);
            String str = "results_fetched";
            List<CheckinPlaceModel> list = this.f14598g.f14666b;
            ArrayNode b = JsonNodeFactory.a.b();
            for (CheckinPlaceModel cf_ : list) {
                b.b(Long.parseLong(cf_.cf_()));
            }
            honeyClientEvent.a(str, b);
            String str2 = "is_historical_list";
            if (this.f14598g.f14671g == ListType.RECENT) {
                z = true;
            } else {
                z = false;
            }
            honeyClientEvent.a(str2, z);
            honeyClientEvent.a("list_type", this.f14598g.f14671g);
        }
        if (this.f14599h != null) {
            honeyClientEvent.a("user_longitude", this.f14599h.getLongitude());
            honeyClientEvent.a("user_latitude", this.f14599h.getLatitude());
            honeyClientEvent.a("location_accuracy", (double) this.f14599h.getAccuracy());
            honeyClientEvent.a("location_age_ms", System.currentTimeMillis() - this.f14599h.getTime());
        }
        return honeyClientEvent;
    }
}
