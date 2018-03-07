package com.facebook.search.results.model.specification;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.search.results.model.specification.matchers.DisplayStyleMatcher;
import com.google.inject.TypeLiteral;

/* compiled from: RichDocumentDelegateImpl.maybePreinflateUfiAndTextAnnotations */
public class SearchResultsSingleRoleSpecification<T extends FeedUnit> extends SearchResultsSpecification<T> {
    public final GraphQLGraphSearchResultRole f23406a;

    public SearchResultsSingleRoleSpecification(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, DisplayStyleMatcher displayStyleMatcher, TypeLiteral<T> typeLiteral) {
        super(graphQLGraphSearchResultRole, displayStyleMatcher, (TypeLiteral) typeLiteral);
        this.f23406a = graphQLGraphSearchResultRole;
    }
}
