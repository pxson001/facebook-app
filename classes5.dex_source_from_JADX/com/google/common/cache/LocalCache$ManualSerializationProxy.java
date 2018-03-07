package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.cache.CacheBuilder.OneWeigher;
import com.google.common.cache.LocalCache.Strength;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/* compiled from: campaign_title */
public class LocalCache$ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
    transient Cache<K, V> f7200b;
    final int concurrencyLevel;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final Equivalence<Object> keyEquivalence;
    final Strength keyStrength;
    final CacheLoader<? super K, V> loader;
    final long maxWeight;
    final RemovalListener<? super K, ? super V> removalListener;
    final Ticker ticker;
    final Equivalence<Object> valueEquivalence;
    final Strength valueStrength;
    final Weigher<K, V> weigher;

    protected final /* synthetic */ Object m13156e() {
        return m13155d();
    }

    LocalCache$ManualSerializationProxy(LocalCache<K, V> localCache) {
        this(localCache.h, localCache.i, localCache.f, localCache.g, localCache.m, localCache.l, localCache.j, localCache.k, localCache.e, localCache.p, localCache.q, localCache.t);
    }

    private LocalCache$ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, long j3, Weigher<K, V> weigher, int i, RemovalListener<? super K, ? super V> removalListener, Ticker ticker, CacheLoader<? super K, V> cacheLoader) {
        this.keyStrength = strength;
        this.valueStrength = strength2;
        this.keyEquivalence = equivalence;
        this.valueEquivalence = equivalence2;
        this.expireAfterWriteNanos = j;
        this.expireAfterAccessNanos = j2;
        this.maxWeight = j3;
        this.weigher = weigher;
        this.concurrencyLevel = i;
        this.removalListener = removalListener;
        if (ticker == Ticker.systemTicker() || ticker == CacheBuilder.d) {
            ticker = null;
        }
        this.ticker = ticker;
        this.loader = cacheLoader;
    }

    final CacheBuilder<K, V> m13157f() {
        CacheBuilder b = CacheBuilder.newBuilder().a(this.keyStrength).b(this.valueStrength);
        Equivalence equivalence = this.keyEquivalence;
        Preconditions.checkState(b.p == null, "key equivalence was already set to %s", new Object[]{b.p});
        b.p = (Equivalence) Preconditions.checkNotNull(equivalence);
        CacheBuilder<K, V> a = b.b(this.valueEquivalence).b(this.concurrencyLevel).a(this.removalListener);
        a.e = false;
        if (this.expireAfterWriteNanos > 0) {
            a.a(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
        }
        if (this.expireAfterAccessNanos > 0) {
            a.b(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
        }
        if (this.weigher != OneWeigher.INSTANCE) {
            a.a(this.weigher);
            if (this.maxWeight != -1) {
                a.b(this.maxWeight);
            }
        } else if (this.maxWeight != -1) {
            a.a(this.maxWeight);
        }
        if (this.ticker != null) {
            Ticker ticker = this.ticker;
            Preconditions.checkState(a.s == null);
            a.s = (Ticker) Preconditions.checkNotNull(ticker);
        }
        return a;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f7200b = m13157f().q();
    }

    private Object readResolve() {
        return this.f7200b;
    }

    protected final Cache<K, V> m13155d() {
        return this.f7200b;
    }
}
