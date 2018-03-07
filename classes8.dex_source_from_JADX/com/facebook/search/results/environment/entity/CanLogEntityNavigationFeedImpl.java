package com.facebook.search.results.environment.entity;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.Assisted;
import com.facebook.search.common.errors.GraphSearchError;
import com.facebook.search.common.errors.GraphSearchErrorReporter;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsEntityUnit;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: SeeMoreBar */
public class CanLogEntityNavigationFeedImpl implements OldCanLogEntityNavigation {
    private final SearchResultsMutableContext f22672a;
    private final SearchResultsFeedCollection f22673b;
    private final SearchResultsLogger f22674c;
    private final GraphSearchErrorReporter f22675d;

    @Inject
    public CanLogEntityNavigationFeedImpl(@Assisted SearchResultsMutableContext searchResultsMutableContext, @Assisted SearchResultsFeedCollection searchResultsFeedCollection, SearchResultsLogger searchResultsLogger, GraphSearchErrorReporter graphSearchErrorReporter) {
        this.f22672a = searchResultsMutableContext;
        this.f22673b = searchResultsFeedCollection;
        this.f22674c = searchResultsLogger;
        this.f22675d = graphSearchErrorReporter;
    }

    public final void mo1251b(GraphQLNode graphQLNode) {
        GraphQLObjectType j = graphQLNode.j();
        String toLowerCase = j != null ? j.toString().toLowerCase() : null;
        Optional a = this.f22673b.m27057a((Object) graphQLNode);
        if (a.isPresent()) {
            this.f22674c.m25482a(this.f22672a, ((SearchResultsCollectionUnit) a.get()).mo1321k(), (String) ((SearchResultsCollectionUnit) a.get()).mo1322l().orNull(), this.f22673b.m27064b((FeedUnit) a.get()), ((SearchResultsCollectionUnit) a.get()).f23463d.indexOf(graphQLNode), ((SearchResultsCollectionUnit) a.get()).f23463d.size(), toLowerCase, graphQLNode.dp());
            return;
        }
        Optional a2 = this.f22673b.m27056a(graphQLNode);
        if (a2.isPresent()) {
            this.f22674c.m25482a(this.f22672a, ((SearchResultsEntityUnit) a2.get()).mo1321k(), (String) ((SearchResultsEntityUnit) a2.get()).mo1322l().orNull(), this.f22673b.m27064b((FeedUnit) a2.get()), 0, 1, toLowerCase, graphQLNode.dp());
        } else {
            this.f22675d.a(GraphSearchError.LOGGING_ILLEGAL_STATE, "Node = " + graphQLNode + "(" + toLowerCase + "), module.isPresent() = " + a.isPresent() + ", entityUnit.isPresent() = " + a2.isPresent() + ", mFeedCollection = " + this.f22673b, new IllegalStateException("No feed unit found for node: " + graphQLNode));
        }
    }
}
