package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Maps.IteratorBasedAbstractMap;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: logged_in_after_last_auth */
public final class HashBiMap<K, V> extends IteratorBasedAbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private transient BiEntry<K, V>[] f16186a;
    private transient BiEntry<K, V>[] f16187b;
    public transient BiEntry<K, V> f16188c;
    private transient BiEntry<K, V> f16189d;
    public transient int f16190e;
    private transient int f16191f;
    public transient int f16192g;
    private transient BiMap<V, K> f16193h;

    /* compiled from: logged_in_after_last_auth */
    final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;
        @Nullable
        BiEntry<K, V> nextInKToVBucket;
        @Nullable
        BiEntry<K, V> nextInKeyInsertionOrder;
        @Nullable
        BiEntry<K, V> nextInVToKBucket;
        @Nullable
        BiEntry<K, V> prevInKeyInsertionOrder;
        final int valueHash;

        BiEntry(K k, int i, V v, int i2) {
            super(k, v);
            this.keyHash = i;
            this.valueHash = i2;
        }
    }

    public final /* synthetic */ Collection values() {
        return mo67c();
    }

    public static <K, V> HashBiMap<K, V> m23019a() {
        return m23020a(16);
    }

    public static <K, V> HashBiMap<K, V> m23020a(int i) {
        return new HashBiMap(i);
    }

    private HashBiMap(int i) {
        m23026b(i);
    }

    private void m23026b(int i) {
        CollectPreconditions.m615a(i, "expectedSize");
        int a = Hashing.m654a(i, 1.0d);
        this.f16186a = new BiEntry[a];
        this.f16187b = new BiEntry[a];
        this.f16188c = null;
        this.f16189d = null;
        this.f16190e = 0;
        this.f16191f = a - 1;
        this.f16192g = 0;
    }

    public static void m23022a(HashBiMap hashBiMap, BiEntry biEntry) {
        BiEntry biEntry2;
        BiEntry biEntry3 = null;
        int i = biEntry.keyHash & hashBiMap.f16191f;
        BiEntry biEntry4 = null;
        for (biEntry2 = hashBiMap.f16186a[i]; biEntry2 != biEntry; biEntry2 = biEntry2.nextInKToVBucket) {
            biEntry4 = biEntry2;
        }
        if (biEntry4 == null) {
            hashBiMap.f16186a[i] = biEntry.nextInKToVBucket;
        } else {
            biEntry4.nextInKToVBucket = biEntry.nextInKToVBucket;
        }
        int i2 = hashBiMap.f16191f & biEntry.valueHash;
        for (biEntry2 = hashBiMap.f16187b[i2]; biEntry2 != biEntry; biEntry2 = biEntry2.nextInVToKBucket) {
            biEntry3 = biEntry2;
        }
        if (biEntry3 == null) {
            hashBiMap.f16187b[i2] = biEntry.nextInVToKBucket;
        } else {
            biEntry3.nextInVToKBucket = biEntry.nextInVToKBucket;
        }
        if (biEntry.prevInKeyInsertionOrder == null) {
            hashBiMap.f16188c = biEntry.nextInKeyInsertionOrder;
        } else {
            biEntry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = biEntry.nextInKeyInsertionOrder;
        }
        if (biEntry.nextInKeyInsertionOrder == null) {
            hashBiMap.f16189d = biEntry.prevInKeyInsertionOrder;
        } else {
            biEntry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = biEntry.prevInKeyInsertionOrder;
        }
        hashBiMap.f16190e--;
        hashBiMap.f16192g++;
    }

    public static void m23023a(HashBiMap hashBiMap, @Nullable BiEntry biEntry, BiEntry biEntry2) {
        int i = biEntry.keyHash & hashBiMap.f16191f;
        biEntry.nextInKToVBucket = hashBiMap.f16186a[i];
        hashBiMap.f16186a[i] = biEntry;
        i = biEntry.valueHash & hashBiMap.f16191f;
        biEntry.nextInVToKBucket = hashBiMap.f16187b[i];
        hashBiMap.f16187b[i] = biEntry;
        if (biEntry2 == null) {
            biEntry.prevInKeyInsertionOrder = hashBiMap.f16189d;
            biEntry.nextInKeyInsertionOrder = null;
            if (hashBiMap.f16189d == null) {
                hashBiMap.f16188c = biEntry;
            } else {
                hashBiMap.f16189d.nextInKeyInsertionOrder = biEntry;
            }
            hashBiMap.f16189d = biEntry;
        } else {
            biEntry.prevInKeyInsertionOrder = biEntry2.prevInKeyInsertionOrder;
            if (biEntry.prevInKeyInsertionOrder == null) {
                hashBiMap.f16188c = biEntry;
            } else {
                biEntry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = biEntry;
            }
            biEntry.nextInKeyInsertionOrder = biEntry2.nextInKeyInsertionOrder;
            if (biEntry.nextInKeyInsertionOrder == null) {
                hashBiMap.f16189d = biEntry;
            } else {
                biEntry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = biEntry;
            }
        }
        hashBiMap.f16190e++;
        hashBiMap.f16192g++;
    }

    public static BiEntry m23018a(@Nullable HashBiMap hashBiMap, Object obj, int i) {
        BiEntry biEntry = hashBiMap.f16186a[hashBiMap.f16191f & i];
        while (biEntry != null) {
            if (i == biEntry.keyHash && Objects.equal(obj, biEntry.key)) {
                return biEntry;
            }
            biEntry = biEntry.nextInKToVBucket;
        }
        return null;
    }

    public static BiEntry m23024b(@Nullable HashBiMap hashBiMap, Object obj, int i) {
        BiEntry biEntry = hashBiMap.f16187b[hashBiMap.f16191f & i];
        while (biEntry != null) {
            if (i == biEntry.valueHash && Objects.equal(obj, biEntry.value)) {
                return biEntry;
            }
            biEntry = biEntry.nextInVToKBucket;
        }
        return null;
    }

    public final boolean containsKey(@Nullable Object obj) {
        return m23018a(this, obj, Hashing.m655a(obj)) != null;
    }

    public final boolean containsValue(@Nullable Object obj) {
        return m23024b(this, obj, Hashing.m655a(obj)) != null;
    }

    @Nullable
    public final V get(@Nullable Object obj) {
        Entry a = m23018a(this, obj, Hashing.m655a(obj));
        return a == null ? null : a.getValue();
    }

    public final V put(@Nullable K k, @Nullable V v) {
        return m23021a((Object) k, (Object) v, false);
    }

    public final V mo65a(@Nullable K k, @Nullable V v) {
        return m23021a((Object) k, (Object) v, true);
    }

    private V m23021a(@Nullable K k, @Nullable V v, boolean z) {
        int a = Hashing.m655a((Object) k);
        int a2 = Hashing.m655a((Object) v);
        BiEntry a3 = m23018a(this, (Object) k, a);
        if (a3 != null && a2 == a3.valueHash && Objects.equal(v, a3.value)) {
            return v;
        }
        BiEntry b = m23024b(this, v, a2);
        if (b != null) {
            if (z) {
                m23022a(this, b);
            } else {
                throw new IllegalArgumentException("value already present: " + v);
            }
        }
        b = new BiEntry(k, a, v, a2);
        if (a3 != null) {
            m23022a(this, a3);
            m23023a(this, b, a3);
            a3.prevInKeyInsertionOrder = null;
            a3.nextInKeyInsertionOrder = null;
            m23027e();
            return a3.value;
        }
        m23023a(this, b, null);
        m23027e();
        return null;
    }

    @Nullable
    public static Object m23025b(@Nullable HashBiMap hashBiMap, @Nullable Object obj, Object obj2, boolean z) {
        int a = Hashing.m655a(obj);
        int a2 = Hashing.m655a(obj2);
        Entry b = m23024b(hashBiMap, obj, a);
        if (b != null && a2 == b.keyHash && Objects.equal(obj2, b.key)) {
            return obj2;
        }
        BiEntry a3 = m23018a(hashBiMap, obj2, a2);
        if (a3 != null) {
            if (z) {
                m23022a(hashBiMap, a3);
            } else {
                throw new IllegalArgumentException("value already present: " + obj2);
            }
        }
        if (b != null) {
            m23022a(hashBiMap, (BiEntry) b);
        }
        m23023a(hashBiMap, new BiEntry(obj2, a2, obj, a), a3);
        if (a3 != null) {
            a3.prevInKeyInsertionOrder = null;
            a3.nextInKeyInsertionOrder = null;
        }
        hashBiMap.m23027e();
        return Maps.m830b(b);
    }

    private void m23027e() {
        BiEntry[] biEntryArr = this.f16186a;
        if (Hashing.m656a(this.f16190e, biEntryArr.length, 1.0d)) {
            int length = biEntryArr.length * 2;
            this.f16186a = new BiEntry[length];
            this.f16187b = new BiEntry[length];
            this.f16191f = length - 1;
            this.f16190e = 0;
            for (BiEntry biEntry = this.f16188c; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
                m23023a(this, biEntry, biEntry);
            }
            this.f16192g++;
        }
    }

    public final V remove(@Nullable Object obj) {
        BiEntry a = m23018a(this, obj, Hashing.m655a(obj));
        if (a == null) {
            return null;
        }
        m23022a(this, a);
        a.prevInKeyInsertionOrder = null;
        a.nextInKeyInsertionOrder = null;
        return a.value;
    }

    public final void clear() {
        this.f16190e = 0;
        Arrays.fill(this.f16186a, null);
        Arrays.fill(this.f16187b, null);
        this.f16188c = null;
        this.f16189d = null;
        this.f16192g++;
    }

    public final int size() {
        return this.f16190e;
    }

    public final Set<K> keySet() {
        return new KeySet(this);
    }

    public final Set<V> mo67c() {
        return a_().keySet();
    }

    final Iterator<Entry<K, V>> mo2921d() {
        return new 1(this);
    }

    public final BiMap<V, K> a_() {
        if (this.f16193h != null) {
            return this.f16193h;
        }
        Inverse inverse = new Inverse(this);
        this.f16193h = inverse;
        return inverse;
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.a(this, objectOutputStream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        m23026b(16);
        Serialization.a(this, objectInputStream, Serialization.a(objectInputStream));
    }
}
