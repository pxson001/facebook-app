package com.facebook.inject;

import android.content.Context;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.ForwardingLoadingCache;
import com.google.common.cache.LoadingCache;

/* compiled from: zero_get_recommended_promo */
public class ContextKeyedLoadingCache<T> extends ForwardingLoadingCache<Context, T> {
    public final CacheLoader<Context, T> f541a;
    private LoadingCache<Context, T> f542b = CacheBuilder.newBuilder().m1138g().m1140i().m1122a(16).m1127a(this.f541a);

    protected final /* synthetic */ Cache mo104d() {
        return mo106f();
    }

    protected final /* synthetic */ Object mo105e() {
        return mo106f();
    }

    public ContextKeyedLoadingCache(CacheLoader<Context, T> cacheLoader) {
        this.f541a = cacheLoader;
    }

    protected final LoadingCache<Context, T> mo106f() {
        return this.f542b;
    }
}
