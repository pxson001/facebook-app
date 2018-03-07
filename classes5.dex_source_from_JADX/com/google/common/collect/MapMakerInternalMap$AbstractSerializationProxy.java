package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMaker.RemovalListener;
import com.google.common.collect.MapMakerInternalMap.Strength;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* compiled from: bulk_claim_importer */
public abstract class MapMakerInternalMap$AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
    public transient ConcurrentMap<K, V> f7425a;
    public final int concurrencyLevel;
    public final long expireAfterAccessNanos;
    public final long expireAfterWriteNanos;
    public final Equivalence<Object> keyEquivalence;
    public final Strength keyStrength;
    public final int maximumSize;
    public final RemovalListener<? super K, ? super V> removalListener;
    final Equivalence<Object> valueEquivalence;
    public final Strength valueStrength;

    protected final /* synthetic */ Map mo877a() {
        return mo939b();
    }

    protected final /* synthetic */ Object mo880e() {
        return mo939b();
    }

    MapMakerInternalMap$AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> concurrentMap) {
        this.keyStrength = strength;
        this.valueStrength = strength2;
        this.keyEquivalence = equivalence;
        this.valueEquivalence = equivalence2;
        this.expireAfterWriteNanos = j;
        this.expireAfterAccessNanos = j2;
        this.maximumSize = i;
        this.concurrencyLevel = i2;
        this.removalListener = removalListener;
        this.f7425a = concurrentMap;
    }

    protected final ConcurrentMap<K, V> mo939b() {
        return this.f7425a;
    }

    final void m13511b(ObjectInputStream objectInputStream) {
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                this.f7425a.put(readObject, objectInputStream.readObject());
            } else {
                return;
            }
        }
    }
}
