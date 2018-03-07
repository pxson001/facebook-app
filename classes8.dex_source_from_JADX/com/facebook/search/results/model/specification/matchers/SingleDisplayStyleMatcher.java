package com.facebook.search.results.model.specification.matchers;

import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import javax.annotation.Nullable;

/* compiled from: Returned intent does not contain PostReviewParams to post the review */
public class SingleDisplayStyleMatcher implements DisplayStyleMatcher {
    private final GraphQLGraphSearchResultsDisplayStyle f23449a;

    public boolean apply(@Nullable Object obj) {
        GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle = (GraphQLGraphSearchResultsDisplayStyle) obj;
        return graphQLGraphSearchResultsDisplayStyle != null && graphQLGraphSearchResultsDisplayStyle == this.f23449a;
    }

    public SingleDisplayStyleMatcher(GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        this.f23449a = graphQLGraphSearchResultsDisplayStyle;
    }

    public final boolean mo1323a(DisplayStyleMatcher displayStyleMatcher) {
        return displayStyleMatcher.apply(this.f23449a);
    }
}
