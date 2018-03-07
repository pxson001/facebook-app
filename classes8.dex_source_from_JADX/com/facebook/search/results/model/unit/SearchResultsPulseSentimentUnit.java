package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLEmotionalAnalysis;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.specification.SearchResultsSupportDeclaration;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: RequestTracker */
public class SearchResultsPulseSentimentUnit extends SearchResultsBaseFeedUnit implements SearchResultsFeedImpressionTrackable {
    @Nullable
    public final GraphQLEmotionalAnalysis f23499a;
    public final int f23500b;
    private final Optional<String> f23501c;

    public SearchResultsPulseSentimentUnit(@Nullable GraphQLEmotionalAnalysis graphQLEmotionalAnalysis, @Nullable String str, int i) {
        this.f23499a = graphQLEmotionalAnalysis;
        this.f23501c = Optional.fromNullable(str);
        this.f23500b = i;
    }

    public final boolean m27186n() {
        return (this.f23499a == null || this.f23499a.a() == null || this.f23499a.a().a().size() <= 1) ? false : true;
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return SearchResultsSupportDeclaration.f23445y.f23406a;
    }

    public final Optional<String> mo1322l() {
        return this.f23501c;
    }
}
