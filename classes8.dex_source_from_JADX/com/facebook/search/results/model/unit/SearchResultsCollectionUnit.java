package com.facebook.search.results.model.unit;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.search.model.SearchResultsBaseFeedUnit;
import com.facebook.search.results.model.contract.SearchResultsEntitiesTrackable;
import com.facebook.search.results.model.contract.SearchResultsFeedImpressionTrackable;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: Reset Tutorial Nux */
public class SearchResultsCollectionUnit<T> extends SearchResultsBaseFeedUnit implements SearchResultsEntitiesTrackable, SearchResultsFeedImpressionTrackable, SearchResultsSeeMoreFeedUnit {
    public final Optional<GraphQLGraphSearchResultsDisplayStyle> f23460a;
    private final GraphQLGraphSearchResultRole f23461b;
    public final Optional<String> f23462c;
    public final ImmutableList<T> f23463d;
    private final ImmutableList<String> f23464e;
    public final Optional<GraphQLObjectType> f23465f;
    private final Optional<String> f23466g;
    private final Optional<String> f23467h;
    public final Optional<Integer> f23468i;
    private final Optional<String> f23469j;

    public SearchResultsCollectionUnit(@Nullable GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, @Nullable String str, ImmutableList<T> immutableList, ImmutableList<String> immutableList2, @Nullable GraphQLObjectType graphQLObjectType, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4) {
        this.f23460a = Optional.fromNullable(graphQLGraphSearchResultsDisplayStyle);
        this.f23461b = (GraphQLGraphSearchResultRole) Preconditions.checkNotNull(graphQLGraphSearchResultRole);
        this.f23462c = Optional.fromNullable(str);
        this.f23463d = (ImmutableList) Preconditions.checkNotNull(immutableList);
        this.f23464e = (ImmutableList) Preconditions.checkNotNull(immutableList2);
        this.f23465f = Optional.fromNullable(graphQLObjectType);
        this.f23466g = Optional.fromNullable(str2);
        this.f23467h = Optional.fromNullable(str3);
        this.f23468i = Optional.fromNullable(num);
        this.f23469j = Optional.fromNullable(str4);
    }

    private SearchResultsCollectionUnit(Optional<GraphQLGraphSearchResultsDisplayStyle> optional, GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, Optional<String> optional2, ImmutableList<T> immutableList, ImmutableList<String> immutableList2, Optional<GraphQLObjectType> optional3, Optional<String> optional4, Optional<String> optional5, Optional<Integer> optional6, Optional<String> optional7) {
        this.f23460a = (Optional) Preconditions.checkNotNull(optional);
        this.f23461b = (GraphQLGraphSearchResultRole) Preconditions.checkNotNull(graphQLGraphSearchResultRole);
        this.f23462c = (Optional) Preconditions.checkNotNull(optional2);
        this.f23463d = (ImmutableList) Preconditions.checkNotNull(immutableList);
        this.f23464e = (ImmutableList) Preconditions.checkNotNull(immutableList2);
        this.f23465f = (Optional) Preconditions.checkNotNull(optional3);
        this.f23466g = (Optional) Preconditions.checkNotNull(optional4);
        this.f23467h = (Optional) Preconditions.checkNotNull(optional5);
        this.f23468i = optional6;
        this.f23469j = optional7;
    }

    public static <T> SearchResultsCollectionUnit<T> m27146a(SearchResultsCollectionUnit<T> searchResultsCollectionUnit, ImmutableList<T> immutableList) {
        return new SearchResultsCollectionUnit(searchResultsCollectionUnit.f23460a, searchResultsCollectionUnit.f23461b, searchResultsCollectionUnit.f23462c, (ImmutableList) immutableList, searchResultsCollectionUnit.f23464e, searchResultsCollectionUnit.f23465f, searchResultsCollectionUnit.f23466g, searchResultsCollectionUnit.f23467h, searchResultsCollectionUnit.f23468i, searchResultsCollectionUnit.f23469j);
    }

    public GraphQLObjectType getType() {
        return (GraphQLObjectType) this.f23465f.orNull();
    }

    public final Optional<GraphQLObjectType> m27155p() {
        return this.f23465f;
    }

    public final Optional<GraphQLGraphSearchResultsDisplayStyle> m27156q() {
        return this.f23460a;
    }

    public final GraphQLGraphSearchResultsDisplayStyle mo1331n() {
        return (GraphQLGraphSearchResultsDisplayStyle) this.f23460a.get();
    }

    public final GraphQLGraphSearchResultRole mo1321k() {
        return this.f23461b;
    }

    public static <T> SearchResultsCollectionUnit<T> m27147a(SearchResultsCollectionUnit<T> searchResultsCollectionUnit, T t, T t2) {
        ImmutableList immutableList = searchResultsCollectionUnit.f23463d;
        int indexOf = immutableList.indexOf(t);
        if (indexOf == -1) {
            return searchResultsCollectionUnit;
        }
        Builder builder = new Builder();
        int i = 0;
        while (i < immutableList.size()) {
            builder.c(i == indexOf ? t2 : immutableList.get(i));
            i++;
        }
        return new SearchResultsCollectionUnit(searchResultsCollectionUnit.f23460a, searchResultsCollectionUnit.f23461b, searchResultsCollectionUnit.f23462c, builder.b(), searchResultsCollectionUnit.f23464e, searchResultsCollectionUnit.f23465f, searchResultsCollectionUnit.f23466g, searchResultsCollectionUnit.f23467h, searchResultsCollectionUnit.f23468i, searchResultsCollectionUnit.f23469j);
    }

    public final Optional<? extends Class> m27154o() {
        if (this.f23463d.isEmpty()) {
            return Absent.INSTANCE;
        }
        return Optional.of(this.f23463d.get(0).getClass());
    }

    public final ImmutableList<T> m27157s() {
        return this.f23463d;
    }

    public final ImmutableList<String> mo1328a() {
        return this.f23464e;
    }

    public final Optional<String> mo1330m() {
        return this.f23466g;
    }

    public final Optional<String> mo1329f() {
        return this.f23467h;
    }

    public final Optional<String> mo1322l() {
        return this.f23469j;
    }

    public String toString() {
        return "SearchResultsCollectionUnit{mDisplayStyle=" + this.f23460a + ", mRole=" + this.f23461b + ", mTitle=" + this.f23462c + ", mCollection=" + this.f23463d + ", mEntityIds=" + this.f23464e + ", mCollectionGraphQLObjectType=" + this.f23465f + '}';
    }
}
