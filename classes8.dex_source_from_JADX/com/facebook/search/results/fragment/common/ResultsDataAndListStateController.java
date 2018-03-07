package com.facebook.search.results.fragment.common;

import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.graphql.model.GraphQLGraphSearchModulesConnection;
import com.facebook.graphql.model.GraphQLGraphSearchQuery;
import com.facebook.graphql.model.GraphQLGraphSearchResultsEdge;
import com.facebook.inject.Assisted;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.perf.GraphSearchPerformanceLogger;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.results.fragment.entities.SearchResultsEntitiesFragment;
import com.facebook.search.results.model.SearchResultsEntitiesCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.widget.resultspage.SearchResultsPage$NearEndOfResultsListener;
import com.facebook.search.widget.resultspage.SearchResultsPage.State;
import com.facebook.search.widget.resultspage.SearchResultsPageView;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SHOW_TOP */
public class ResultsDataAndListStateController implements SearchResultsPage$NearEndOfResultsListener, OnDrawListener {
    public final ResultDataFetcher f22980a;
    private final GraphSearchPerformanceLogger f22981b;
    private final SearchResultsLogger f22982c;
    private final MultipleRowsStoriesRecycleCallback f22983d;
    @Nullable
    public SearchResultsPageView f22984e;
    @Nullable
    private State f22985f;
    private SearchResultsMutableContext f22986g;
    private FbListAdapter f22987h;
    public SearchResultsEntitiesFragment f22988i;
    public OnDrawListener f22989j;
    public GraphQLGraphSearchQuery f22990k;
    private int f22991l;
    private boolean f22992m = false;
    private boolean f22993n = false;

    @Inject
    public ResultsDataAndListStateController(@Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted FbListAdapter fbListAdapter, ResultDataFetcher resultDataFetcher, GraphSearchPerformanceLogger graphSearchPerformanceLogger, SearchResultsLogger searchResultsLogger, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback) {
        this.f22986g = searchResultsMutableContext;
        this.f22987h = fbListAdapter;
        this.f22980a = resultDataFetcher;
        this.f22981b = graphSearchPerformanceLogger;
        this.f22982c = searchResultsLogger;
        this.f22983d = multipleRowsStoriesRecycleCallback;
    }

    public final boolean gD_() {
        if (this.f22989j != null && this.f22989j.gD_()) {
            this.f22989j = null;
        }
        return false;
    }

    public final void m26619a(SearchResultsPageView searchResultsPageView) {
        this.f22984e = searchResultsPageView;
        m26613a(this.f22985f != null ? this.f22985f : State.LOADING);
        this.f22984e.setNearEndOfResultsListener(this);
        ScrollingViewProxy scrollingViewProxy = searchResultsPageView.k;
        scrollingViewProxy.a(this.f22987h);
        scrollingViewProxy.a(this.f22983d.a());
        scrollingViewProxy.b(this);
    }

    public final void m26618a(GraphSearchQuerySpec graphSearchQuerySpec) {
        this.f22981b.m25560a(graphSearchQuerySpec.mo1215f());
        this.f22990k = null;
        m26613a(State.LOADING);
        m26614a(null);
    }

    public final void m26617a(GraphQLGraphSearchQuery graphQLGraphSearchQuery, boolean z) {
        String o;
        int i;
        boolean z2;
        State state;
        this.f22993n = false;
        this.f22990k = graphQLGraphSearchQuery;
        GraphQLGraphSearchModulesConnection l = this.f22990k.l();
        this.f22986g.m27092c(l != null ? l.m() : null);
        if (l != null) {
            o = l.o();
        } else {
            o = null;
        }
        this.f22986g.m27090b(o);
        this.f22986g.m27093d(this.f22990k.p());
        if (graphQLGraphSearchQuery.s() == null || graphQLGraphSearchQuery.s().j() == null) {
            i = 0;
        } else {
            i = graphQLGraphSearchQuery.s().j().size();
        }
        if (i > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f22992m = z2;
        SearchResultsLogger searchResultsLogger = this.f22982c;
        SearchResultsMutableContext searchResultsMutableContext = this.f22986g;
        int i2 = this.f22991l;
        this.f22991l = i2 + 1;
        searchResultsLogger.m25470a(searchResultsMutableContext, i2, i, null, null);
        if (this.f22988i != null) {
            ImmutableList j;
            SearchResultsEntitiesFragment searchResultsEntitiesFragment = this.f22988i;
            searchResultsEntitiesFragment.aq.f22989j = searchResultsEntitiesFragment.ao;
            if (graphQLGraphSearchQuery.s() != null) {
                j = graphQLGraphSearchQuery.s().j();
            } else {
                j = RegularImmutableList.a;
            }
            SearchResultsEntitiesCollection searchResultsEntitiesCollection = searchResultsEntitiesFragment.am;
            int size = j.size();
            for (int i3 = 0; i3 < size; i3++) {
                searchResultsEntitiesCollection.f23341a.add((GraphQLGraphSearchResultsEdge) j.get(i3));
            }
            searchResultsEntitiesFragment.ar.notifyDataSetChanged();
            searchResultsEntitiesFragment.as = true;
        }
        if (i > 0) {
            state = State.LOADING_MORE;
        } else if (z) {
            state = State.EMPTY;
        } else {
            state = State.LOADING_FINISHED;
        }
        m26613a(state);
        m26615h();
    }

    public final void m26620b() {
        this.f22993n = false;
        m26613a(State.ERROR);
        m26615h();
    }

    public final void m26621c() {
        this.f22993n = false;
        m26613a(State.ERROR_LOADING_MORE);
        m26615h();
    }

    public final void m26622e() {
        this.f22993n = false;
        m26615h();
    }

    public final void mo1293a() {
        if (this.f22992m && !this.f22993n) {
            String str;
            if (this.f22990k == null || this.f22990k.s() == null || this.f22990k.s().l() == null) {
                str = null;
            } else {
                str = this.f22990k.s().l().a();
            }
            String str2 = str;
            if (str2 != null) {
                this.f22981b.m25562b(this.f22990k.t());
                m26614a(str2);
            }
        }
    }

    private void m26613a(State state) {
        this.f22985f = state;
        if (this.f22984e != null) {
            this.f22984e.setState(state);
        }
    }

    private void m26614a(String str) {
        this.f22993n = true;
        this.f22980a.m26611a(this.f22986g, str, this);
    }

    private void m26615h() {
        if (this.f22989j == null) {
            this.f22981b.m25564e();
        }
    }
}
