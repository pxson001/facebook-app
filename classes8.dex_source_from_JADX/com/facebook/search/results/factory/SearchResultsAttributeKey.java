package com.facebook.search.results.factory;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.google.common.base.Predicate;

/* compiled from: SYSTEM_AUTOHIDE_CONTROLS */
public class SearchResultsAttributeKey {
    private final GraphQLGraphSearchResultRole f22724a;
    private final Predicate<GraphQLGraphSearchResultsDisplayStyle> f22725b;

    public SearchResultsAttributeKey(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, Predicate<GraphQLGraphSearchResultsDisplayStyle> predicate) {
        this.f22724a = graphQLGraphSearchResultRole;
        this.f22725b = predicate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchResultsAttributeKey)) {
            return false;
        }
        SearchResultsAttributeKey searchResultsAttributeKey = (SearchResultsAttributeKey) obj;
        if (this.f22724a == searchResultsAttributeKey.f22724a && this.f22725b.equals(searchResultsAttributeKey.f22725b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f22724a.hashCode() * this.f22725b.hashCode();
    }
}
