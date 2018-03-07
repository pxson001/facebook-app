package com.facebook.search.logging;

import com.facebook.common.time.Clock;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: The view is not audio annotation aware */
public class SearchResultsFeedLoggingViewportEventListener extends BaseViewportEventListener {
    private final Clock f21936a;
    private final SearchResultsLogger f21937b;
    private final SearchResultsMutableContext f21938c;
    private final SearchResultsFeedCollection f21939d;
    private final List<SearchResultsFeedUnitImpression> f21940e = new ArrayList();
    private final Map<FeedUnit, Long> f21941f = new HashMap();

    @Inject
    public SearchResultsFeedLoggingViewportEventListener(Clock clock, SearchResultsLogger searchResultsLogger, @Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted SearchResultsFeedCollection searchResultsFeedCollection) {
        this.f21936a = clock;
        this.f21937b = searchResultsLogger;
        this.f21938c = searchResultsMutableContext;
        this.f21939d = searchResultsFeedCollection;
    }

    public final void m25452a(Object obj) {
        FeedUnit a = FeedUnitHelper.a(obj);
        if (a != null && m25451a(a)) {
            this.f21941f.put(a, Long.valueOf(this.f21936a.a()));
        }
    }

    public final void m25454b(Object obj) {
        String str = null;
        FeedUnit a = FeedUnitHelper.a(obj);
        if (a != null && m25451a(a)) {
            Long l = (Long) this.f21941f.get(a);
            if (l != null) {
                this.f21941f.remove(a);
                long a2 = this.f21936a.a() - l.longValue();
                if (a2 >= 10) {
                    GraphQLGraphSearchResultRole a3;
                    if (a instanceof GraphQLStory) {
                        a3 = this.f21939d.m27054a((GraphQLStory) a);
                        str = this.f21939d.m27066b((GraphQLStory) a);
                    } else if (a instanceof SearchResultsFeedImpressionTrackable) {
                        a3 = ((SearchResultsFeedImpressionTrackable) a).mo1321k();
                        str = (String) ((SearchResultsFeedImpressionTrackable) a).mo1322l().orNull();
                    } else {
                        a3 = null;
                    }
                    this.f21940e.add(SearchResultsFeedUnitImpression.m25457a(this.f21939d.m27064b(a), l.longValue(), a2, a, a3, str));
                    if (this.f21940e.size() >= 50) {
                        m25450a();
                    }
                }
            }
        }
    }

    public final void m25453b(ScrollingViewProxy scrollingViewProxy) {
        m25450a();
    }

    private void m25450a() {
        ImmutableList copyOf = ImmutableList.copyOf(this.f21940e);
        this.f21940e.clear();
        this.f21941f.clear();
        if (!copyOf.isEmpty()) {
            this.f21937b.m25485a(this.f21938c, copyOf);
        }
    }

    private static boolean m25451a(FeedUnit feedUnit) {
        return (feedUnit instanceof SearchResultsFeedImpressionTrackable) || (feedUnit instanceof GraphQLStory);
    }
}
