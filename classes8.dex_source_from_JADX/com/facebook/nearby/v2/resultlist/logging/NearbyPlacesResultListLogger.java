package com.facebook.nearby.v2.resultlist.logging;

import android.text.TextUtils;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.Assisted;
import com.facebook.nearby.v2.logging.NearbyPlacesSession;
import com.facebook.nearby.v2.logging.NearbyPlacesSession.EntryPoint;
import com.facebook.nearby.v2.model.NearbyPlacesFragmentModel;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataProvider;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListModel;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: dd5ddeeb61af92642c0867d3f07dc970 */
public class NearbyPlacesResultListLogger {
    private final AnalyticsLogger f15842a;
    public NearbyPlacesFragmentModel f15843b;
    public NearbyPlacesSearchDataProvider f15844c;
    public NearbyPlacesResultListModel f15845d;

    /* compiled from: dd5ddeeb61af92642c0867d3f07dc970 */
    public enum TapAction {
        CELL("cell"),
        REVIEW_RATING("review_rating"),
        PRICE_RATING("price_rating"),
        DISTANCE("distance"),
        LIKES("likes"),
        OPEN_NOW("open_now"),
        FRIENDS_WHO_VISITED("friends_who_visited"),
        FRIENDS_REVIEW("friends_review"),
        PHOTO_IN_COLLECTION("photo_in_collection");
        
        private final String actionName;

        private TapAction(String str) {
            this.actionName = str;
        }

        public final String toString() {
            return this.actionName;
        }
    }

    @Inject
    public NearbyPlacesResultListLogger(@Assisted NearbyPlacesFragmentModel nearbyPlacesFragmentModel, @Assisted NearbyPlacesSearchDataProvider nearbyPlacesSearchDataProvider, @Assisted NearbyPlacesResultListModel nearbyPlacesResultListModel, AnalyticsLogger analyticsLogger) {
        Preconditions.checkNotNull(nearbyPlacesFragmentModel);
        Preconditions.checkNotNull(nearbyPlacesSearchDataProvider);
        Preconditions.checkNotNull(nearbyPlacesResultListModel);
        this.f15843b = nearbyPlacesFragmentModel;
        this.f15844c = nearbyPlacesSearchDataProvider;
        this.f15845d = nearbyPlacesResultListModel;
        this.f15842a = analyticsLogger;
    }

    public final void m18690a() {
        this.f15842a.a(m18688a("view_result_list"));
    }

    public final void m18692b() {
        this.f15842a.a(m18688a("nearby_places_results_list_received_results"));
    }

    public final void m18693c() {
        this.f15842a.a(m18688a("nearby_places_scroll_results"));
    }

    public final void m18691a(String str, int i, int i2, boolean z, TapAction tapAction, @Nullable Integer num, @Nullable Integer num2, @Nullable String str2) {
        HoneyClientEvent a = m18688a("tap_result_in_list");
        if (!(num == null || num2 == null)) {
            a.a("photo_index", num).a("photo_results_count", num2);
        }
        if (!TextUtils.isEmpty(str2)) {
            a.b("results_seen", str2);
        }
        a.b("tap_action", tapAction.toString()).a("has_friend_context", z ? 1 : 0).a("result_index", i).a("results_count", i2).b("page_id", str).a("sort_applied", 0);
        this.f15842a.a(a);
    }

    private HoneyClientEvent m18688a(String str) {
        return m18689a(str, EntryPoint.SEARCH_SUGGESTION == this.f15843b.f15299a.f15291a ? "android_local_set_search_module" : "nearby_places_module");
    }

    private HoneyClientEvent m18689a(String str, String str2) {
        Preconditions.checkNotNull(this.f15845d);
        NearbyPlacesSession nearbyPlacesSession = this.f15843b.f15299a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f = nearbyPlacesSession.f15293c;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.c = str2;
        HoneyAnalyticsEvent honeyAnalyticsEvent = honeyClientEvent;
        honeyAnalyticsEvent.h = nearbyPlacesSession.f15293c;
        NearbyPlacesSession nearbyPlacesSession2 = this.f15843b.f15299a;
        honeyAnalyticsEvent.b("session_id", nearbyPlacesSession2.f15293c).b("user_has_location_services", Boolean.toString(this.f15844c.mo918c().m17760f())).b("ref", nearbyPlacesSession2.f15291a.getValue()).b("search_impression_source", nearbyPlacesSession2.f15292b.toString());
        SearchResultsMutableContext searchResultsMutableContext = this.f15843b.f15299a.f15294d;
        if (searchResultsMutableContext != null) {
            String b = searchResultsMutableContext.mo1212b();
            honeyAnalyticsEvent.b("search_source_type", searchResultsMutableContext.f23367b.toString()).b("search_semantic", b == null ? null : b.replace(" ", "+"));
            if (searchResultsMutableContext instanceof SearchResultsMutableContext) {
                SearchResultsMutableContext searchResultsMutableContext2 = searchResultsMutableContext;
                honeyAnalyticsEvent.b("search_query_string", searchResultsMutableContext2.mo1213c()).b("search_results_vertical", searchResultsMutableContext2.jH_());
            }
            SearchTypeaheadSession searchTypeaheadSession = searchResultsMutableContext.f23369d;
            if (searchTypeaheadSession != null) {
                honeyAnalyticsEvent.b("search_candidate_session_id", searchTypeaheadSession.c).b("search_typeahead_session_id", searchTypeaheadSession.b);
            }
        }
        if (this.f15845d.f15863c != null && this.f15845d.f15863c.m18709o()) {
            honeyAnalyticsEvent.b("result_list_id", this.f15845d.f15863c.f15859n).a("result_list_search_type", this.f15845d.f15863c.f15851f);
        }
        return honeyAnalyticsEvent;
    }
}
