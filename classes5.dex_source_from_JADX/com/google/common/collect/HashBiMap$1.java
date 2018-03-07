package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashBiMap.BiEntry;
import java.util.Map.Entry;

/* compiled from: cached_feedback_age */
class HashBiMap$1 extends HashBiMap$Itr<Entry<K, V>> {
    final /* synthetic */ HashBiMap f7310a;

    /* compiled from: cached_feedback_age */
    class MapEntry extends AbstractMapEntry<K, V> {
        BiEntry<K, V> f7304a;
        final /* synthetic */ HashBiMap$1 f7305b;

        MapEntry(HashBiMap$1 hashBiMap$1, BiEntry<K, V> biEntry) {
            this.f7305b = hashBiMap$1;
            this.f7304a = biEntry;
        }

        public K getKey() {
            return this.f7304a.key;
        }

        public V getValue() {
            return this.f7304a.value;
        }

        public V setValue(V v) {
            V v2 = this.f7304a.value;
            int a = Hashing.a(v);
            if (a == this.f7304a.valueHash && Objects.equal(v, v2)) {
                return v;
            }
            Preconditions.checkArgument(HashBiMap.b(this.f7305b.f7310a, v, a) == null, "value already present: %s", new Object[]{v});
            HashBiMap.a(this.f7305b.f7310a, this.f7304a);
            BiEntry biEntry = new BiEntry(this.f7304a.key, this.f7304a.keyHash, v, a);
            HashBiMap.a(this.f7305b.f7310a, biEntry, this.f7304a);
            this.f7304a.prevInKeyInsertionOrder = null;
            this.f7304a.nextInKeyInsertionOrder = null;
            this.f7305b.d = this.f7305b.f7310a.g;
            if (this.f7305b.f7307c == this.f7304a) {
                this.f7305b.c = biEntry;
            }
            this.f7304a = biEntry;
            return v2;
        }
    }

    HashBiMap$1(HashBiMap hashBiMap) {
        this.f7310a = hashBiMap;
        super(hashBiMap);
    }

    final Object mo923a(BiEntry biEntry) {
        return new MapEntry(this, biEntry);
    }
}
