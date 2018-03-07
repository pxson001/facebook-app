package com.facebook.nearby.analytics;

import android.location.Location;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Joiner;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: user_location_longitude */
public class NearbyBrowseAnalytics {
    public final AnalyticsLogger f297a;

    /* compiled from: user_location_longitude */
    public enum LocationFixSource {
        TIMEOUT("timeout"),
        BEFORE_TIMEOUT("before_timeout"),
        LOCATION_SERVICES_OFF("location_services_off");
        
        public String mValue;

        private LocationFixSource(String str) {
            this.mValue = str;
        }
    }

    /* compiled from: user_location_longitude */
    public enum TTIAmountOfTileInCache {
        ALL_TILES_IN_CACHE("all_tiles_in_cache"),
        ALL_TILES_IN_CACHE_SOME_ARE_STALE("all_tiles_in_cache_some_are_stale"),
        NOT_ALL_TILES_IN_CACHE("not_all_tiles_in_cache");
        
        private String analyticsAttributeValue;

        private TTIAmountOfTileInCache(String str) {
            this.analyticsAttributeValue = str;
        }

        public final String getAttributeValue() {
            return this.analyticsAttributeValue;
        }
    }

    public static NearbyBrowseAnalytics m376b(InjectorLike injectorLike) {
        return new NearbyBrowseAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NearbyBrowseAnalytics(AnalyticsLogger analyticsLogger) {
        this.f297a = analyticsLogger;
    }

    public final void m383a(String str, String str2, String str3, double d, double d2, float f, List<String> list) {
        HoneyClientEventFast a = this.f297a.a("page_selected", true);
        if (a.a()) {
            a.a("places_recommendations").a("page_id", str).a("session_id", str2).a("page_session_id", str3).a("latitude", d).a("longitude", d2).a("accuracy", (double) f).a("results_seen", Joiner.on(", ").join(list));
            a.b();
        }
    }

    public final void m384a(String str, String str2, String str3, List<String> list) {
        HoneyClientEventFast a = this.f297a.a("page_selected", true);
        if (a.a()) {
            a.a("places_recommendations").a("page_id", str).a("session_id", str2).a("page_session_id", str3).a("results_seen", Joiner.on(", ").join(list));
            a.b();
        }
    }

    public final void m378a(long j, long j2) {
        HoneyClientEventFast a = this.f297a.a("response_received", true);
        if (a.a()) {
            a.a("places_recommendations").a("request_time", (double) (((float) j) / 1000.0f)).a("response_received_time", (double) (((float) j2) / 1000.0f));
            a.b();
        }
    }

    public final void m385a(String str, boolean z, String str2) {
        HoneyClientEventFast a = this.f297a.a("tap_result_in_list", true);
        if (a.a()) {
            a.a("places_recommendations").a("page_id", str).a("has_friend_context", z).a("session_id", str2);
            a.b();
        }
    }

    public final void m377a() {
        HoneyClientEventFast a = this.f297a.a("recommendation_request_cancelled", true);
        if (a.a()) {
            a.a("places_recommendations");
            a.b();
        }
    }

    public final void m381a(String str) {
        HoneyClientEventFast a = this.f297a.a("results_error", true);
        if (a.a()) {
            a.a("places_recommendations").a("error", str);
            a.b();
        }
    }

    public final void m386a(List<Long> list, GraphQLGeoRectangle graphQLGeoRectangle, float f) {
        HoneyClientEventFast a = this.f297a.a("request_sent", true);
        if (a.a()) {
            a.a("places_recommendations").a("category", list.toString()).a("map_region", m375a(graphQLGeoRectangle)).a("zoom", (double) f);
            a.b();
        }
    }

    public final void m387a(boolean z, int i, List<Long> list, GraphQLGeoRectangle graphQLGeoRectangle, double d, int i2) {
        HoneyClientEventFast a = this.f297a.a("results_loaded_from_cache", true);
        if (a.a()) {
            a.a("places_recommendations").a("tiles_cover_map", z).a("tiles_count", i).a("category", list.toString()).a("map_region", m375a(graphQLGeoRectangle)).a("zoom", d).a("result_count", i2);
            a.b();
        }
    }

    public final void m379a(@Nullable Location location, LocationFixSource locationFixSource, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("location_fix");
        honeyClientEvent.c = "places_recommendations";
        honeyClientEvent = honeyClientEvent.b("source", locationFixSource.mValue).a("time_since_register", (double) (((float) j) / 1000.0f));
        if (location != null) {
            honeyClientEvent.a("accuracy", (double) location.getAccuracy()).a("latitude", location.getLatitude()).a("longitude", location.getLongitude());
        }
        this.f297a.c(honeyClientEvent);
    }

    public final void m382a(String str, GraphQLGeoRectangle graphQLGeoRectangle, GraphQLGeoRectangle graphQLGeoRectangle2) {
        HoneyClientEventFast a = this.f297a.a("map_region_changed", true);
        if (a.a()) {
            a.a("places_recommendations").a("session_id", str).a("map_region_before", m375a(graphQLGeoRectangle)).a("map_region_after", m375a(graphQLGeoRectangle2));
            a.b();
        }
    }

    public final void m380a(TTIAmountOfTileInCache tTIAmountOfTileInCache, long j) {
        HoneyClientEventFast a = this.f297a.a("map_time_to_interaction", true);
        if (a.a()) {
            a.a("places_recommendations").a("source", tTIAmountOfTileInCache.getAttributeValue()).a("elapsed_time_to_interaction", (double) (((float) j) / 1000.0f));
            a.b();
        }
    }

    private static String m375a(GraphQLGeoRectangle graphQLGeoRectangle) {
        if (graphQLGeoRectangle == null) {
            return "";
        }
        return "{N: " + graphQLGeoRectangle.j() + " S: " + graphQLGeoRectangle.k() + " E: " + graphQLGeoRectangle.a() + " W: " + graphQLGeoRectangle.l() + "}";
    }
}
