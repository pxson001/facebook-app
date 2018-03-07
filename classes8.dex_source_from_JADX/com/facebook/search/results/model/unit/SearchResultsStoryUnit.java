package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.contract.SearchResultsGraphQLStoryFeedUnit;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: Refresh Bootstrap Keywords */
public class SearchResultsStoryUnit extends SearchResultsBaseFeedUnit implements SearchResultsEntitiesTrackable, SearchResultsFeedImpressionTrackable, SearchResultsGraphQLStoryFeedUnit {
    private final GraphQLGraphSearchResultRole f23544a;
    private final GraphQLStory f23545b;
    public final Optional<String> f23546c;
    public final Optional<String> f23547d;
    private final Optional<String> f23548e;

    public SearchResultsStoryUnit(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, GraphQLStory graphQLStory, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.f23544a = (GraphQLGraphSearchResultRole) Preconditions.checkNotNull(graphQLGraphSearchResultRole);
        this.f23545b = (GraphQLStory) Preconditions.checkNotNull(graphQLStory);
        this.f23548e = Optional.fromNullable(str);
        this.f23546c = Optional.fromNullable(str2);
        this.f23547d = Optional.fromNullable(str3);
    }

    private SearchResultsStoryUnit(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, GraphQLStory graphQLStory, Optional<String> optional, Optional<String> optional2, Optional<String> optional3) {
        this.f23544a = (GraphQLGraphSearchResultRole) Preconditions.checkNotNull(graphQLGraphSearchResultRole);
        this.f23545b = (GraphQLStory) Preconditions.checkNotNull(graphQLStory);
        this.f23548e = (Optional) Preconditions.checkNotNull(optional);
        this.f23546c = (Optional) Preconditions.checkNotNull(optional2);
        this.f23547d = (Optional) Preconditions.checkNotNull(optional3);
    }

    public final SearchResultsGraphQLStoryFeedUnit mo1332a(GraphQLStory graphQLStory) {
        return new SearchResultsStoryUnit(this.f23544a, graphQLStory, this.f23548e, this.f23546c, this.f23547d);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return this.f23544a;
    }

    public final ImmutableList<String> mo1328a() {
        String g = this.f23545b.g();
        return g != null ? ImmutableList.of(g) : RegularImmutableList.a;
    }

    public final GraphQLStory mo1333f() {
        return this.f23545b;
    }

    public GraphQLObjectType getType() {
        return this.f23545b.getType();
    }

    public final Optional<String> mo1322l() {
        return this.f23548e;
    }
}
