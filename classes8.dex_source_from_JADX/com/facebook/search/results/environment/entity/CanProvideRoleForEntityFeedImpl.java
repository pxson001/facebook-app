package com.facebook.search.results.environment.entity;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsFeedCollection;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.unit.SearchResultsEntityUnit;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SearchWaterfall */
public class CanProvideRoleForEntityFeedImpl implements CanProvideRoleForEntity {
    private final SearchResultsFeedCollection f22676a;

    @Inject
    public CanProvideRoleForEntityFeedImpl(@Assisted SearchResultsFeedCollection searchResultsFeedCollection) {
        this.f22676a = searchResultsFeedCollection;
    }

    @Nullable
    public final GraphQLGraphSearchResultRole mo1252c(GraphQLNode graphQLNode) {
        SearchResultsFeedImpressionTrackable a = m26235a(graphQLNode);
        return a != null ? a.mo1321k() : null;
    }

    @Nullable
    public final String mo1253d(GraphQLNode graphQLNode) {
        SearchResultsFeedImpressionTrackable a = m26235a(graphQLNode);
        return a != null ? (String) a.mo1322l().orNull() : null;
    }

    @Nullable
    private SearchResultsFeedImpressionTrackable m26235a(GraphQLNode graphQLNode) {
        Optional a = this.f22676a.m27057a((Object) graphQLNode);
        if (a.isPresent()) {
            return (SearchResultsFeedImpressionTrackable) a.get();
        }
        a = this.f22676a.m27056a(graphQLNode);
        return a.isPresent() ? (SearchResultsEntityUnit) a.get() : null;
    }
}
