package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker.RemovalListener;
import com.google.common.collect.MapMakerInternalMap.Strength;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/* compiled from: bulk_claim_importer */
final class MapMakerInternalMap$SerializationProxy<K, V> extends MapMakerInternalMap$AbstractSerializationProxy<K, V> {
    MapMakerInternalMap$SerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j, long j2, int i, int i2, RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> concurrentMap) {
        super(strength, strength2, equivalence, equivalence2, j, j2, i, i2, removalListener, concurrentMap);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f7425a.size());
        for (Entry entry : this.f7425a.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
        objectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        MapMaker b = new MapMaker().a(objectInputStream.readInt()).a(this.keyStrength).b(this.valueStrength);
        Equivalence equivalence = this.keyEquivalence;
        Preconditions.checkState(b.k == null, "key equivalence was already set to %s", new Object[]{b.k});
        b.k = (Equivalence) Preconditions.checkNotNull(equivalence);
        b.b = true;
        b = b.c(this.concurrencyLevel);
        RemovalListener removalListener = this.removalListener;
        Preconditions.checkState(b.a == null);
        b.a = (RemovalListener) Preconditions.checkNotNull(removalListener);
        b.b = true;
        if (this.expireAfterWriteNanos > 0) {
            b.a(this.expireAfterWriteNanos, TimeUnit.NANOSECONDS);
        }
        if (this.expireAfterAccessNanos > 0) {
            b.b(this.expireAfterAccessNanos, TimeUnit.NANOSECONDS);
        }
        if (this.maximumSize != -1) {
            b.b(this.maximumSize);
        }
        this.a = b.l();
        m13511b(objectInputStream);
    }

    private Object readResolve() {
        return this.f7425a;
    }
}
