package com.facebook.graphql.executor;

import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.CacheVisitorAnalytics;
import com.google.common.base.Preconditions;
import java.util.Set;

/* compiled from: like_counts_stale */
public class DelegatingCacheVisitor implements CacheVisitorAnalytics {
    private final CacheVisitor f3196a;
    private final Set<String> f3197b;

    public DelegatingCacheVisitor(CacheVisitor cacheVisitor, Set<String> set) {
        this.f3196a = (CacheVisitor) Preconditions.checkNotNull(cacheVisitor, "null delegate");
        this.f3197b = (Set) Preconditions.checkNotNull(set, "null tags");
    }

    public final <T> T m6252a(T t) {
        return this.f3196a.a(t);
    }

    public final Set<String> m6253a() {
        return this.f3197b;
    }

    public final String m6254b() {
        return "Delegate[" + (this.f3196a instanceof CacheVisitorAnalytics ? ((CacheVisitorAnalytics) this.f3196a).b() : this.f3196a.getClass().getName()) + "]";
    }
}
