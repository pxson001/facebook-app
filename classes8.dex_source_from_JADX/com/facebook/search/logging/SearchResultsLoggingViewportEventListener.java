package com.facebook.search.logging;

import com.facebook.common.time.Clock;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultUnit;
import com.facebook.search.results.model.SearchResultsCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.protocol.SearchResultsEdgeInterfaces.SearchResultsEdge;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.SearchResultsEdgeUtil;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: The controller id must be passed in for logging */
public class SearchResultsLoggingViewportEventListener extends BaseViewportEventListener {
    private final Clock f21959a;
    private final SearchResultsLogger f21960b;
    private final SearchResultsMutableContext f21961c;
    private final SearchResultsCollection f21962d;
    private final List<SearchResultsFeedUnitImpression> f21963e = new ArrayList();
    private final Map<SearchResultUnit, Long> f21964f = new HashMap();

    @Inject
    public SearchResultsLoggingViewportEventListener(Clock clock, SearchResultsLogger searchResultsLogger, @Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted SearchResultsCollection searchResultsCollection) {
        this.f21959a = clock;
        this.f21960b = searchResultsLogger;
        this.f21961c = searchResultsMutableContext;
        this.f21962d = searchResultsCollection;
    }

    public final void m25492a(Object obj) {
        SearchResultUnit c = m25491c(obj);
        if (c != null) {
            this.f21964f.put(c, Long.valueOf(this.f21959a.a()));
        }
    }

    public final void m25494b(Object obj) {
        SearchResultUnit c = m25491c(obj);
        if (c != null) {
            Long l = (Long) this.f21964f.get(c);
            if (l != null) {
                this.f21964f.remove(c);
                long a = this.f21959a.a() - l.longValue();
                if (a >= 10) {
                    GraphQLGraphSearchResultRole graphQLGraphSearchResultRole = c.f23326b;
                    int indexOf = this.f21962d.f23338b.indexOf(c);
                    long longValue = l.longValue();
                    ImmutableList a2 = m25489a(c.f23325a);
                    SearchResultsEdgeModel searchResultsEdgeModel = c.f23325a;
                    GraphQLObjectType graphQLObjectType = null;
                    if (SearchResultsEdgeUtil.m9799a(searchResultsEdgeModel) == GraphQLGraphSearchResultRole.VIDEOS && searchResultsEdgeModel.m9770a() != null) {
                        graphQLObjectType = searchResultsEdgeModel.m9770a().m9745b();
                    }
                    this.f21963e.add(new SearchResultsFeedUnitImpression(indexOf, longValue, a, a2, graphQLGraphSearchResultRole, null, graphQLObjectType));
                    if (this.f21963e.size() >= 50) {
                        m25490a();
                    }
                }
            }
        }
    }

    public final void m25493b(ScrollingViewProxy scrollingViewProxy) {
        m25490a();
    }

    @Nullable
    private static SearchResultUnit m25491c(Object obj) {
        if (obj instanceof BoundedAdapter) {
            Object obj2 = ((BoundedAdapter) obj).a.b;
            if (obj2 instanceof SearchResultUnit) {
                return (SearchResultUnit) obj2;
            }
        }
        return null;
    }

    private void m25490a() {
        ImmutableList copyOf = ImmutableList.copyOf(this.f21963e);
        this.f21963e.clear();
        this.f21964f.clear();
        if (!copyOf.isEmpty()) {
            this.f21960b.m25485a(this.f21961c, copyOf);
        }
    }

    private static ImmutableList<String> m25489a(SearchResultsEdge searchResultsEdge) {
        GraphQLGraphSearchResultRole a = SearchResultsEdgeUtil.m9799a(searchResultsEdge);
        Builder builder;
        ImmutableList e;
        int size;
        int i;
        EdgesModel edgesModel;
        if (a == GraphQLGraphSearchResultRole.VIDEOS_LIVE) {
            builder = new Builder();
            e = SearchResultsEdgeUtil.m9803e(searchResultsEdge);
            size = e.size();
            for (i = 0; i < size; i++) {
                edgesModel = (EdgesModel) e.get(i);
                GraphQLStory p = edgesModel.m9699a() != null ? edgesModel.m9699a().mo591p() : null;
                if (p != null) {
                    builder.c(p.c());
                }
            }
            return builder.b();
        } else if (a == GraphQLGraphSearchResultRole.VIDEOS) {
            NodeModel a2 = searchResultsEdge.m9770a();
            Object C = a2 != null ? a2.mo572C() : null;
            if (C != null) {
                return ImmutableList.of(C);
            }
            return RegularImmutableList.a;
        } else if (a != GraphQLGraphSearchResultRole.VIDEOS_WEB && a != GraphQLGraphSearchResultRole.TOP_VIDEOS) {
            return RegularImmutableList.a;
        } else {
            builder = new Builder();
            e = SearchResultsEdgeUtil.m9803e(searchResultsEdge);
            size = e.size();
            for (i = 0; i < size; i++) {
                edgesModel = (EdgesModel) e.get(i);
                Object C2 = edgesModel.m9699a() != null ? edgesModel.m9699a().mo572C() : null;
                if (C2 != null) {
                    builder.c(C2);
                }
            }
            return builder.b();
        }
    }
}
