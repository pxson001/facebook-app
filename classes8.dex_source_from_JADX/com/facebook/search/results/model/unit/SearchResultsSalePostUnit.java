package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.contract.SearchResultsGraphQLStoryFeedUnit;
import com.facebook.search.results.model.specification.SearchResultsSupportDeclaration;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: RelativeLayout */
public class SearchResultsSalePostUnit extends SearchResultsBaseFeedUnit implements SearchResultsEntitiesTrackable, SearchResultsFeedImpressionTrackable, SearchResultsGraphQLStoryFeedUnit {
    private final GraphQLStory f23509a;
    private final Optional<String> f23510b;

    public SearchResultsSalePostUnit(GraphQLStory graphQLStory, @Nullable String str) {
        this.f23509a = graphQLStory;
        this.f23510b = Optional.fromNullable(str);
    }

    private SearchResultsSalePostUnit(GraphQLStory graphQLStory, Optional<String> optional) {
        this.f23509a = graphQLStory;
        this.f23510b = optional;
    }

    public final GraphQLStory mo1333f() {
        return this.f23509a;
    }

    public final Optional<String> mo1322l() {
        return this.f23510b;
    }

    public final SearchResultsGraphQLStoryFeedUnit mo1332a(GraphQLStory graphQLStory) {
        return new SearchResultsSalePostUnit(graphQLStory, this.f23510b);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return SearchResultsSupportDeclaration.f23434n.f23406a;
    }

    public final ImmutableList<String> mo1328a() {
        String g = this.f23509a.g();
        if (g != null) {
            return ImmutableList.of(g);
        }
        return RegularImmutableList.a;
    }
}
