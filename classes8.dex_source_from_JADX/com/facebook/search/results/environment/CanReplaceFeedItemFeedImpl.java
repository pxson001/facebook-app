package com.facebook.search.results.environment;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsEntityUnit;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: System-Bold */
public class CanReplaceFeedItemFeedImpl implements CanReplaceFeedItem {
    private final SearchResultsFeedCollection f22536a;

    @Inject
    public CanReplaceFeedItemFeedImpl(@Assisted SearchResultsFeedCollection searchResultsFeedCollection) {
        this.f22536a = searchResultsFeedCollection;
    }

    public final void mo1241a(Object obj, Object obj2) {
        if ((obj instanceof FeedUnit) && (obj2 instanceof FeedUnit)) {
            this.f22536a.m27059a((FeedUnit) obj, (FeedUnit) obj2);
        } else if ((obj instanceof GraphQLNode) || (obj2 instanceof GraphQLNode)) {
            GraphQLNode graphQLNode = (GraphQLNode) obj;
            GraphQLNode graphQLNode2 = (GraphQLNode) obj2;
            Optional a = this.f22536a.m27057a((Object) graphQLNode);
            if (a.isPresent()) {
                this.f22536a.m27059a((FeedUnit) a.get(), SearchResultsCollectionUnit.m27147a((SearchResultsCollectionUnit) a.get(), graphQLNode, graphQLNode2));
                return;
            }
            a = this.f22536a.m27056a(graphQLNode);
            if (a.isPresent()) {
                this.f22536a.m27059a((FeedUnit) a.get(), new SearchResultsEntityUnit(graphQLNode2, ((SearchResultsEntityUnit) a.get()).mo1322l()));
            }
        } else {
            throw new IllegalArgumentException("Trying to replace item of unsupported type: " + obj);
        }
    }
}
