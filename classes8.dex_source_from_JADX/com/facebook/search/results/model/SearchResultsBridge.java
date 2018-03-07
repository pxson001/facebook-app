package com.facebook.search.results.model;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: SAVING */
public class SearchResultsBridge extends SearchResultsBaseFeedUnit implements SearchResultsFeedImpressionTrackable {
    private final Optional<String> f23331a;
    public SearchResultUnit f23332b;

    private SearchResultsBridge(SearchResultsEdgeModel searchResultsEdgeModel, @Nullable String str) {
        this.f23332b = new SearchResultUnit(searchResultsEdgeModel);
        this.f23331a = Optional.fromNullable(str);
    }

    public static SearchResultsBridge m27031a(SearchResultsEdgeModel searchResultsEdgeModel, @Nullable String str) {
        return new SearchResultsBridge(searchResultsEdgeModel, str);
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return this.f23332b.f23326b;
    }

    public final Optional<String> mo1322l() {
        return this.f23331a;
    }
}
