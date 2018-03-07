package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: Reset All Force Modes to Default */
public class SearchResultsProductItemUnit extends SearchResultsBaseFeedUnit implements SearchResultsFeedImpressionTrackable {
    public final GraphQLNode f23494a;
    public final GraphQLGraphSearchResultRole f23495b;
    private final Optional<String> f23496c;

    public SearchResultsProductItemUnit(GraphQLNode graphQLNode, @Nullable String str) {
        this.f23494a = graphQLNode;
        this.f23495b = graphQLNode.jT() != null ? GraphQLGraphSearchResultRole.COMMERCE_C2C : GraphQLGraphSearchResultRole.COMMERCE_B2C;
        this.f23496c = Optional.fromNullable(str);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return this.f23495b;
    }

    public final Optional<String> mo1322l() {
        return this.f23496c;
    }
}
