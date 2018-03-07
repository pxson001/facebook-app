package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.specification.SearchResultsSupportDeclaration;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: Refresh & Reset */
public class SearchResultsVideoUnit extends SearchResultsBaseFeedUnit implements SearchResultsEntitiesTrackable, SearchResultsFeedImpressionTrackable {
    public final GraphQLStory f23550a;
    private final Optional<String> f23551b;

    public SearchResultsVideoUnit(GraphQLStory graphQLStory, @Nullable String str) {
        this.f23550a = graphQLStory;
        this.f23551b = Optional.fromNullable(str);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return SearchResultsSupportDeclaration.f23420N.f23406a;
    }

    public final Optional<String> mo1322l() {
        return this.f23551b;
    }

    public final ImmutableList<String> mo1328a() {
        String g = this.f23550a.g();
        return g != null ? ImmutableList.of(g) : RegularImmutableList.a;
    }
}
