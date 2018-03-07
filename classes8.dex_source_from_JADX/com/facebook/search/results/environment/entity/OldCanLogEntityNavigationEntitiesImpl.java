package com.facebook.search.results.environment.entity;

import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.Assisted;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import javax.inject.Inject;

@Deprecated
/* compiled from: SearchResultsFeedCollection{ */
public class OldCanLogEntityNavigationEntitiesImpl implements OldCanLogEntityNavigation {
    private final HasSearchResultsContext f22702a;
    private final HasFeedItemPosition f22703b;
    private final SearchResultsLogger f22704c;

    @Inject
    public OldCanLogEntityNavigationEntitiesImpl(@Assisted HasSearchResultsContext hasSearchResultsContext, @Assisted HasFeedItemPosition hasFeedItemPosition, SearchResultsLogger searchResultsLogger) {
        this.f22702a = hasSearchResultsContext;
        this.f22703b = hasFeedItemPosition;
        this.f22704c = searchResultsLogger;
    }

    public final void mo1251b(GraphQLNode graphQLNode) {
        this.f22704c.m25476a(this.f22702a.mo1248s(), this.f22703b.mo1245a(graphQLNode), graphQLNode.dp());
    }
}
