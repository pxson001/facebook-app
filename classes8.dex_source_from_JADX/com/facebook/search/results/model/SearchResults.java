package com.facebook.search.results.model;

import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import javax.annotation.Nullable;

/* compiled from: SCHEDULING_PLAY */
public class SearchResults {
    public final ImmutableList<? extends FeedUnit> f23327a;
    @Nullable
    public final DefaultPageInfoFields f23328b;
    private final ImmutableMap<String, GraphQLGraphSearchResultRole> f23329c;
    private final ImmutableMap<String, String> f23330d;

    public SearchResults(ImmutableList<? extends FeedUnit> immutableList, DefaultPageInfoFields defaultPageInfoFields) {
        this.f23327a = immutableList;
        this.f23328b = defaultPageInfoFields;
        this.f23329c = RegularImmutableBiMap.a;
        this.f23330d = RegularImmutableBiMap.a;
    }

    public SearchResults(ImmutableList<? extends FeedUnit> immutableList, DefaultPageInfoFields defaultPageInfoFields, ImmutableMap<String, GraphQLGraphSearchResultRole> immutableMap, ImmutableMap<String, String> immutableMap2) {
        this.f23327a = immutableList;
        this.f23328b = defaultPageInfoFields;
        this.f23329c = immutableMap;
        this.f23330d = immutableMap2;
    }

    public final ImmutableList<? extends FeedUnit> m27024a() {
        return this.f23327a;
    }

    @Nullable
    public final DefaultPageInfoFields m27025b() {
        return this.f23328b;
    }

    public final int m27026c() {
        return this.f23327a.size();
    }

    public final ImmutableMap<String, GraphQLGraphSearchResultRole> m27027d() {
        return this.f23329c;
    }

    public final ImmutableMap<String, String> m27028e() {
        return this.f23330d;
    }
}
