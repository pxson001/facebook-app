package com.facebook.search.api;

import android.net.Uri;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.search.api.model.GraphSearchQueryFragment;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: extra_picked_category */
public class SearchTypeaheadResultBuilder {
    @Nullable
    public String f15509a;
    @Nullable
    public GraphQLFriendshipStatus f15510b;
    @Nullable
    public Uri f15511c;
    @Nullable
    public Uri f15512d;
    @Nullable
    public Uri f15513e;
    @Nullable
    public Uri f15514f;
    @Nullable
    public String f15515g;
    @Nullable
    public String f15516h;
    @Nullable
    public String f15517i;
    @Nullable
    public String f15518j;
    public String f15519k;
    public Type f15520l;
    public long f15521m;
    public boolean f15522n;
    @Nullable
    public GraphQLPageVerificationBadge f15523o;
    public boolean f15524p;
    @Nullable
    public List<String> f15525q;
    @Nullable
    public ImmutableList<String> f15526r;
    public String f15527s;
    public ImmutableList<GraphSearchQueryFragment> f15528t;
    public int f15529u;
    public int f15530v;
    public boolean f15531w = false;

    public final SearchTypeaheadResult m23132a() {
        return new SearchTypeaheadResult(this);
    }

    public final SearchTypeaheadResultBuilder m23143a(boolean z) {
        this.f15531w = z;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23148b(boolean z) {
        this.f15522n = z;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23137a(GraphQLPageVerificationBadge graphQLPageVerificationBadge) {
        this.f15523o = graphQLPageVerificationBadge;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23141a(@Nullable String str) {
        this.f15509a = str;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23135a(@Nullable Uri uri) {
        this.f15511c = uri;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23136a(@Nullable GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f15510b = graphQLFriendshipStatus;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23145b(@Nullable Uri uri) {
        this.f15512d = uri;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23149c(@Nullable Uri uri) {
        this.f15513e = uri;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23151d(@Nullable Uri uri) {
        this.f15514f = uri;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23147b(@Nullable String str) {
        this.f15515g = str;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23150c(@Nullable String str) {
        this.f15516h = str;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23152d(@Nullable String str) {
        this.f15517i = str;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23153e(@Nullable String str) {
        this.f15518j = str;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23154f(String str) {
        this.f15519k = str;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23138a(Type type) {
        this.f15520l = type;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23134a(long j) {
        this.f15521m = j;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23142a(@Nullable List<String> list) {
        this.f15525q = list;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23140a(Boolean bool) {
        this.f15524p = bool.booleanValue();
        return this;
    }

    public final SearchTypeaheadResultBuilder m23133a(int i) {
        this.f15529u = i;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23144b(int i) {
        this.f15530v = i;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23139a(@Nullable ImmutableList<String> immutableList) {
        this.f15526r = immutableList;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23155g(String str) {
        this.f15527s = str;
        return this;
    }

    public final SearchTypeaheadResultBuilder m23146b(ImmutableList<GraphSearchQueryFragment> immutableList) {
        this.f15528t = immutableList;
        return this;
    }
}
