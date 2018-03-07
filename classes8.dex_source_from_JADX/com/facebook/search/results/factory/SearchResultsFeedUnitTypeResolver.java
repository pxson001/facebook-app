package com.facebook.search.results.factory;

import com.facebook.common.build.BuildConstants;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.specification.SearchResultsSpecification;
import com.facebook.search.results.model.specification.matchers.DisplayStyleMatcher;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.inject.TypeLiteral;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SYNC */
public class SearchResultsFeedUnitTypeResolver {
    private final Multimap<GraphQLGraphSearchResultRole, DisplayStyleMatcher> f22726a;
    private final Map<SearchResultsAttributeKey, TypeLiteral<? extends FeedUnit>> f22727b = new HashMap();
    private final TypeLiteral<? extends FeedUnit> f22728c;

    @Inject
    public SearchResultsFeedUnitTypeResolver(@Assisted ImmutableSet<SearchResultsSpecification> immutableSet, @Assisted TypeLiteral<? extends FeedUnit> typeLiteral) {
        this.f22728c = typeLiteral;
        Builder builder = new Builder();
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            SearchResultsSpecification searchResultsSpecification = (SearchResultsSpecification) it.next();
            Iterator it2 = searchResultsSpecification.f23403b.iterator();
            while (it2.hasNext()) {
                GraphQLGraphSearchResultRole graphQLGraphSearchResultRole = (GraphQLGraphSearchResultRole) it2.next();
                builder.a(graphQLGraphSearchResultRole, searchResultsSpecification.f23404c);
                this.f22727b.put(new SearchResultsAttributeKey(graphQLGraphSearchResultRole, searchResultsSpecification.f23404c), searchResultsSpecification.f23405d);
            }
        }
        this.f22726a = builder.a();
        if (BuildConstants.i) {
            m26277a();
        }
    }

    public final TypeLiteral<? extends FeedUnit> m26278a(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
        for (Predicate predicate : this.f22726a.c(graphQLGraphSearchResultRole)) {
            if (predicate.apply(graphQLGraphSearchResultsDisplayStyle)) {
                return (TypeLiteral) this.f22727b.get(new SearchResultsAttributeKey(graphQLGraphSearchResultRole, predicate));
            }
        }
        return this.f22728c;
    }

    private void m26277a() {
        for (GraphQLGraphSearchResultRole graphQLGraphSearchResultRole : this.f22726a.p()) {
            ImmutableList copyOf = ImmutableList.copyOf(this.f22726a.c(graphQLGraphSearchResultRole));
            for (int i = 0; i < copyOf.size(); i++) {
                for (int i2 = i + 1; i2 < copyOf.size(); i2++) {
                    if (((DisplayStyleMatcher) copyOf.get(i)).mo1323a((DisplayStyleMatcher) copyOf.get(i2))) {
                        throw new IllegalArgumentException("Overlapping display style matchers for role: " + graphQLGraphSearchResultRole);
                    }
                }
            }
        }
    }
}
