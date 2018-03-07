package com.facebook.search.results.factory;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.search.results.model.specification.SearchResultsSpecification;
import com.google.common.collect.ImmutableSet;
import com.google.inject.TypeLiteral;

/* compiled from: SWIPE_DOWN */
public class SearchResultsFeedUnitTypeResolverProvider extends AbstractAssistedProvider<SearchResultsFeedUnitTypeResolver> {
    public static SearchResultsFeedUnitTypeResolver m26279a(ImmutableSet<SearchResultsSpecification> immutableSet, TypeLiteral<? extends FeedUnit> typeLiteral) {
        return new SearchResultsFeedUnitTypeResolver(immutableSet, typeLiteral);
    }
}
