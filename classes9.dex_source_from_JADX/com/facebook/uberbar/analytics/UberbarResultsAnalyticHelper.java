package com.facebook.uberbar.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.SearchTypeaheadResult;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: trackingCodes */
public class UberbarResultsAnalyticHelper {
    @Nullable
    public String f1404a;
    public List<SearchClickEvent> f1405b;
    public int f1406c;
    public int f1407d;
    public boolean f1408e;
    public boolean f1409f;
    public final AnalyticsLogger f1410g;
    private final InteractionLogger f1411h;
    private final MonotonicClock f1412i;

    @VisibleForTesting
    /* compiled from: trackingCodes */
    public enum SessionEndReason {
        APP_BACKGROUNDED,
        BACK_PRESSED,
        SEARCH_EXIT_PRESSED,
        USER_CLICKED_INLINE_CALL,
        USER_CLICKED_RESULT
    }

    public static UberbarResultsAnalyticHelper m1527b(InjectorLike injectorLike) {
        return new UberbarResultsAnalyticHelper(AnalyticsLoggerMethodAutoProvider.a(injectorLike), InteractionLogger.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public UberbarResultsAnalyticHelper(AnalyticsLogger analyticsLogger, InteractionLogger interactionLogger, MonotonicClock monotonicClock) {
        this.f1410g = analyticsLogger;
        this.f1411h = interactionLogger;
        this.f1412i = monotonicClock;
    }

    public final void m1529a(SearchTypeaheadResult searchTypeaheadResult, String str, int i, List<SearchTypeaheadResult> list) {
        m1526a("click", str, searchTypeaheadResult, i, list);
    }

    public final void m1530a(SearchTypeaheadResult searchTypeaheadResult, String str, List<SearchTypeaheadResult> list, int i) {
        m1526a("inline_friend_request", str, searchTypeaheadResult, i, list);
    }

    public final void m1531b(SearchTypeaheadResult searchTypeaheadResult, String str, List<SearchTypeaheadResult> list, int i) {
        m1526a("call_quick_action", str, searchTypeaheadResult, i, list);
    }

    public final void m1533c(SearchTypeaheadResult searchTypeaheadResult, String str, List<SearchTypeaheadResult> list, int i) {
        m1526a("inline_page_like_request", str, searchTypeaheadResult, i, list);
    }

    public final void m1532b(String str) {
        this.f1406c = 0;
        this.f1407d = 0;
        m1528b("clear", str, null, -1, null);
    }

    private void m1526a(String str, String str2, SearchTypeaheadResult searchTypeaheadResult, int i, List<SearchTypeaheadResult> list) {
        m1528b(str, str2, searchTypeaheadResult, i, list);
        this.f1411h.c.a("tap_search_result");
    }

    private void m1528b(String str, String str2, SearchTypeaheadResult searchTypeaheadResult, int i, List<SearchTypeaheadResult> list) {
        this.f1405b.add(new SearchClickEvent(str, searchTypeaheadResult, i, str2, list, this.f1412i.now()));
    }
}
