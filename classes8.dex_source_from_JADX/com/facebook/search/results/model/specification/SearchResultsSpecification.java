package com.facebook.search.results.model.specification;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.search.results.model.specification.matchers.DisplayStyleMatcher;
import com.google.common.collect.ImmutableSet;
import com.google.inject.TypeLiteral;

/* compiled from: RichDocumentDelegateImpl.onStartupUITasksComplete */
public class SearchResultsSpecification<F extends FeedUnit> {
    public final ImmutableSet<GraphQLGraphSearchResultRole> f23403b;
    public final DisplayStyleMatcher f23404c;
    public final TypeLiteral<F> f23405d;

    public SearchResultsSpecification(ImmutableSet<GraphQLGraphSearchResultRole> immutableSet, DisplayStyleMatcher displayStyleMatcher, TypeLiteral<F> typeLiteral) {
        this.f23403b = immutableSet;
        this.f23404c = displayStyleMatcher;
        this.f23405d = typeLiteral;
    }

    public SearchResultsSpecification(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, DisplayStyleMatcher displayStyleMatcher, TypeLiteral<F> typeLiteral) {
        this.f23403b = ImmutableSet.of(graphQLGraphSearchResultRole);
        this.f23404c = displayStyleMatcher;
        this.f23405d = typeLiteral;
    }
}
