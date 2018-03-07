package com.facebook.pages.common.util;

import com.facebook.cache.TrackedLruCache;
import com.facebook.cache.TrackedLruCache.Factory;
import com.facebook.common.time.Clock;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: extra_uid */
public class BasePagesTrackedLruCache<K, V> {
    @GuardedBy("this")
    protected final TrackedLruCache<K, PagesCacheEntry<V>> f12425a;
    public final int f12426b;
    private Clock f12427c;

    public BasePagesTrackedLruCache(Factory factory, Clock clock, int i) {
        this.f12426b = i;
        this.f12425a = factory.b(this.f12426b, "Pages");
        this.f12427c = clock;
    }

    public final synchronized V m13132a(K k, long j) {
        V v;
        PagesCacheEntry pagesCacheEntry = (PagesCacheEntry) this.f12425a.a(k);
        if (pagesCacheEntry == null) {
            v = null;
        } else if (pagesCacheEntry.b() > j) {
            v = pagesCacheEntry.a();
        } else {
            this.f12425a.b(k);
            v = null;
        }
        return v;
    }

    public final synchronized V m13138b(K k, long j) {
        return m13132a((Object) k, this.f12427c.a() - j);
    }

    public final synchronized PagesCacheEntry<V> m13131a(K k) {
        return (PagesCacheEntry) this.f12425a.a(k);
    }

    public final synchronized V m13137b(K k) {
        V v;
        PagesCacheEntry pagesCacheEntry = (PagesCacheEntry) this.f12425a.a(k);
        if (pagesCacheEntry == null) {
            v = null;
        } else {
            v = pagesCacheEntry.a();
        }
        return v;
    }

    public final synchronized V m13133a(K k, V v) {
        return m13134a(k, v, this.f12427c.a());
    }

    public final synchronized V m13134a(K k, V v, long j) {
        V a;
        PagesCacheEntry pagesCacheEntry = (PagesCacheEntry) this.f12425a.a(k, new PagesCacheEntry(v, j));
        if (pagesCacheEntry != null) {
            a = pagesCacheEntry.a();
        } else {
            a = null;
        }
        return a;
    }

    public final synchronized void m13139c(K k) {
        this.f12425a.b(k);
    }

    public final synchronized void m13135a() {
        this.f12425a.a();
    }

    public final synchronized int m13136b() {
        return this.f12425a.b();
    }
}
