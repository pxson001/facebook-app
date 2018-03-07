package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: Reset Counters */
public class SearchResultsEntityUnit extends SearchResultsBaseFeedUnit implements SearchResultsEntitiesTrackable, SearchResultsFeedImpressionTrackable {
    public final GraphQLNode f23487a;
    private final Optional<String> f23488b;
    private GraphQLGraphSearchResultRole f23489c;

    public SearchResultsEntityUnit(GraphQLNode graphQLNode, @Nullable String str) {
        this.f23487a = graphQLNode;
        this.f23488b = Optional.fromNullable(str);
        this.f23489c = m27167a(graphQLNode);
    }

    public SearchResultsEntityUnit(GraphQLNode graphQLNode, Optional<String> optional) {
        this.f23487a = graphQLNode;
        this.f23488b = optional;
        this.f23489c = m27167a(graphQLNode);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return this.f23489c;
    }

    public final Optional<String> mo1322l() {
        return this.f23488b;
    }

    public final ImmutableList<String> mo1328a() {
        String dp = this.f23487a.dp();
        if (dp != null) {
            return ImmutableList.of(dp);
        }
        return RegularImmutableList.a;
    }

    private static GraphQLGraphSearchResultRole m27167a(GraphQLNode graphQLNode) {
        return (graphQLNode.j() == null || graphQLNode.j().g() != 514783620) ? GraphQLGraphSearchResultRole.CENTRAL : GraphQLGraphSearchResultRole.NAVIGATIONAL_LINKS;
    }
}
