package com.facebook.nearby.analytics;

import android.location.Location;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.inject.InjectorLike;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: user_location_latitude */
public class NearbySearchAnalytics {
    public final AnalyticsLogger f298a;

    /* compiled from: user_location_latitude */
    public enum SearchSelectionType {
        HISTORY_SUGGESTION("history_suggestion"),
        TYPEAHEAD_SUGGESTION("typeahead_suggestion"),
        CATEGORY_PRESET("category_preset"),
        PAGE("page");
        
        public final String mValue;

        private SearchSelectionType(String str) {
            this.mValue = str;
        }
    }

    public static NearbySearchAnalytics m389b(InjectorLike injectorLike) {
        return new NearbySearchAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NearbySearchAnalytics(AnalyticsLogger analyticsLogger) {
        this.f298a = analyticsLogger;
    }

    public final void m391a(String str, SearchSelectionType searchSelectionType, List<Long> list, String str2, String str3, @Nullable Integer num, @Nullable Location location, @Nullable GraphQLGeoRectangle graphQLGeoRectangle) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("search_result_user_selection");
        honeyClientEvent.c = "places_search";
        honeyClientEvent = honeyClientEvent.b("search_query_string", str).b("selection_type", searchSelectionType.mValue).b("selection_id", list.toString()).b("session_id", str3);
        if (location != null) {
            honeyClientEvent.a("accuracy", (double) location.getAccuracy()).a("latitude", location.getLatitude()).a("longitude", location.getLongitude());
        }
        if (num != null) {
            honeyClientEvent.a("selection_rank", num);
        }
        if (str2 != null) {
            honeyClientEvent.b("page_session_id", str2);
        }
        if (graphQLGeoRectangle != null) {
            honeyClientEvent.b("selection_region", m388a(graphQLGeoRectangle));
        }
        this.f298a.c(honeyClientEvent);
    }

    public final void m390a(float f) {
        HoneyClientEventFast a = this.f298a.a("search_time_to_interaction", true);
        if (a.a()) {
            a.a("places_search").a("source", "string_query").a("elapsed_time_to_interaction", (double) (f / 1000.0f));
            a.b();
        }
    }

    private static String m388a(GraphQLGeoRectangle graphQLGeoRectangle) {
        return "N" + graphQLGeoRectangle.j() + "S" + graphQLGeoRectangle.k() + "E" + graphQLGeoRectangle.a() + "W" + graphQLGeoRectangle.l();
    }
}
