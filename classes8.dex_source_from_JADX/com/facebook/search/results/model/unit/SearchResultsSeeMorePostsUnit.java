package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: RegionTosRespondMutation */
public class SearchResultsSeeMorePostsUnit extends SearchResultsBaseFeedUnit implements SearchResultsFeedImpressionTrackable, SearchResultsSeeMoreFeedUnit {
    private final GraphQLGraphSearchResultRole f23511a;
    public final String f23512b;
    private final Optional<String> f23513c;
    private final Optional<String> f23514d;
    private final Optional<String> f23515e;
    private final GraphQLGraphSearchResultsDisplayStyle f23516f;

    public SearchResultsSeeMorePostsUnit(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, String str, @Nullable String str2, @Nullable String str3, String str4, GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        this.f23511a = (GraphQLGraphSearchResultRole) Preconditions.checkNotNull(graphQLGraphSearchResultRole);
        this.f23512b = str;
        this.f23515e = Optional.fromNullable(str2);
        this.f23513c = Optional.fromNullable(str3);
        this.f23514d = Optional.of(str4);
        this.f23516f = graphQLGraphSearchResultsDisplayStyle;
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return this.f23511a;
    }

    public final Optional<String> mo1322l() {
        return this.f23515e;
    }

    public final Optional<String> mo1329f() {
        return this.f23513c;
    }

    public final Optional<String> mo1330m() {
        return this.f23514d;
    }

    public final GraphQLGraphSearchResultsDisplayStyle mo1331n() {
        return this.f23516f;
    }
}
