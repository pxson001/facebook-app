package com.facebook.search.model;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: fetchLoginData-batch */
public class CachedSuggestionList {
    public final ImmutableList<TypeaheadUnit> f11766a;
    private final long f11767b;
    public final DataFreshnessResult f11768c;

    public CachedSuggestionList(ImmutableList<TypeaheadUnit> immutableList, long j) {
        this(immutableList, j, DataFreshnessResult.FROM_CACHE_UP_TO_DATE);
    }

    public CachedSuggestionList(ImmutableList<TypeaheadUnit> immutableList, long j, DataFreshnessResult dataFreshnessResult) {
        this.f11766a = immutableList;
        this.f11767b = j;
        this.f11768c = dataFreshnessResult;
    }

    public final ImmutableList<TypeaheadUnit> m12343a() {
        return this.f11766a;
    }

    public final long m12344b() {
        return this.f11767b;
    }

    public final boolean m12345d() {
        return this.f11766a.isEmpty();
    }

    public final int m12346e() {
        return this.f11766a.size();
    }
}
