package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: Reset Learning Nux State */
public class SearchResultsEmptyEntityUnit extends SearchResultsBaseFeedUnit implements SearchResultsFeedImpressionTrackable {
    public final String f23475a;
    public final GraphQLGraphSearchResultsDisplayStyle f23476b;
    private final Optional<String> f23477c;

    public SearchResultsEmptyEntityUnit(String str, GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle, @Nullable String str2) {
        this.f23475a = str;
        this.f23476b = graphQLGraphSearchResultsDisplayStyle;
        this.f23477c = Optional.fromNullable(str2);
    }

    @Nullable
    public final GraphQLGraphSearchResultRole mo1321k() {
        return GraphQLGraphSearchResultRole.EMPTY_ENTITY;
    }

    public final Optional<String> mo1322l() {
        return this.f23477c;
    }
}
