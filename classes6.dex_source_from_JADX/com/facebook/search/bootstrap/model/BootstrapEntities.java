package com.facebook.search.bootstrap.model;

import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: existing_album_id */
public class BootstrapEntities {
    private long f15749a;
    private boolean f15750b;
    private final ImmutableList<BootstrapEntity> f15751c;
    private final ImmutableList<String> f15752d;

    public BootstrapEntities(long j, boolean z, ImmutableList<BootstrapEntity> immutableList, ImmutableList<String> immutableList2) {
        this.f15749a = j;
        this.f15750b = z;
        this.f15751c = immutableList;
        this.f15752d = immutableList2;
    }

    public final long m23434a() {
        return this.f15749a;
    }

    public final boolean m23435b() {
        return this.f15750b;
    }

    public final ImmutableList<BootstrapEntity> m23436c() {
        return this.f15751c;
    }

    public final ImmutableList<String> m23437d() {
        return this.f15752d;
    }
}
