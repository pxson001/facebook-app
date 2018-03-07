package com.facebook.search.logging;

import android.view.View;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: The wrapper of ComposerTextEdit must be put in a ScrollView */
public class SearchResultsFeedHeightLoggingEventListener extends BaseViewportEventListener {
    private final SearchResultsPerformanceLogger f21935a;

    public static SearchResultsFeedHeightLoggingEventListener m25448a(InjectorLike injectorLike) {
        return new SearchResultsFeedHeightLoggingEventListener(SearchResultsPerformanceLogger.m25495a(injectorLike));
    }

    @Inject
    public SearchResultsFeedHeightLoggingEventListener(SearchResultsPerformanceLogger searchResultsPerformanceLogger) {
        this.f21935a = searchResultsPerformanceLogger;
    }

    public final void m25449a(ScrollingViewProxy scrollingViewProxy, @Nullable Object obj, int i, int i2) {
        View c = scrollingViewProxy.c(i2);
        if (c != null) {
            FeedUnit a = FeedUnitHelper.a(obj);
            if (a != null) {
                this.f21935a.m25505a(a, c);
            }
        }
    }
}
