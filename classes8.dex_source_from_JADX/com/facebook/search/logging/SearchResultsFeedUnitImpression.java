package com.facebook.search.logging;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: The interstitial controller is broken and returning an invalid intent. */
public class SearchResultsFeedUnitImpression {
    public final int f21948a;
    public final long f21949b;
    public final long f21950c;
    public final ImmutableList<String> f21951d;
    public final GraphQLGraphSearchResultRole f21952e;
    public final GraphQLObjectType f21953f;
    public final String f21954g;

    public SearchResultsFeedUnitImpression(int i, long j, long j2, ImmutableList<String> immutableList, @Nullable GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str, @Nullable GraphQLObjectType graphQLObjectType) {
        this.f21948a = i;
        this.f21949b = j;
        this.f21950c = j2;
        this.f21951d = immutableList;
        this.f21952e = graphQLGraphSearchResultRole;
        this.f21954g = str;
        this.f21953f = graphQLObjectType;
    }

    public static SearchResultsFeedUnitImpression m25457a(int i, long j, long j2, FeedUnit feedUnit, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str) {
        ImmutableList of;
        if (feedUnit instanceof GraphQLStory) {
            of = feedUnit.g() != null ? ImmutableList.of(feedUnit.g()) : ImmutableList.of();
        } else if (feedUnit instanceof SearchResultsEntitiesTrackable) {
            of = ((SearchResultsEntitiesTrackable) feedUnit).mo1328a();
        } else {
            of = ImmutableList.of();
        }
        return new SearchResultsFeedUnitImpression(i, j, j2, of, graphQLGraphSearchResultRole, str, feedUnit.getType());
    }
}
