package com.facebook.search.results.model.specification.matchers;

import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;

/* compiled from: Review context without average rating for entity  */
public class DisplayStyleMatchers {
    public static final DisplayStyleMatcher f23447a = new AnyDisplayStyleMatcher();

    public static DisplayStyleMatcher m27129a(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        return new SingleDisplayStyleMatcher(graphQLGraphSearchResultsDisplayStyle);
    }
}
