package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashBiMap.BiEntry;
import com.google.common.collect.HashBiMap.Inverse;
import com.google.common.collect.Maps.EntrySet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: cached_feedback_age */
class HashBiMap$Inverse$1 extends EntrySet<V, K> {
    final /* synthetic */ Inverse f7314a;

    /* compiled from: cached_feedback_age */
    class C08121 extends HashBiMap$Itr<Entry<V, K>> {
        final /* synthetic */ HashBiMap$Inverse$1 f7313a;

        /* compiled from: cached_feedback_age */
        class InverseEntry extends AbstractMapEntry<V, K> {
            BiEntry<K, V> f7311a;
            final /* synthetic */ C08121 f7312b;

            InverseEntry(C08121 c08121, BiEntry<K, V> biEntry) {
                this.f7312b = c08121;
                this.f7311a = biEntry;
            }

            public V getKey() {
                return this.f7311a.value;
            }

            public K getValue() {
                return this.f7311a.key;
            }

            public K setValue(K k) {
                K k2 = this.f7311a.key;
                int a = Hashing.a(k);
                if (a == this.f7311a.keyHash && Objects.equal(k, k2)) {
                    return k;
                }
                Preconditions.checkArgument(HashBiMap.a(this.f7312b.f7313a.f7314a.this$0, k, a) == null, "value already present: %s", new Object[]{k});
                HashBiMap.a(this.f7312b.f7313a.f7314a.this$0, this.f7311a);
                BiEntry biEntry = new BiEntry(k, a, this.f7311a.value, this.f7311a.valueHash);
                this.f7311a = biEntry;
                HashBiMap.a(this.f7312b.f7313a.f7314a.this$0, biEntry, null);
                this.f7312b.d = this.f7312b.f7313a.f7314a.this$0.g;
                return k2;
            }
        }

        C08121(HashBiMap$Inverse$1 hashBiMap$Inverse$1) {
            this.f7313a = hashBiMap$Inverse$1;
            super(hashBiMap$Inverse$1.f7314a.this$0);
        }

        final Object mo923a(BiEntry biEntry) {
            return new InverseEntry(this, biEntry);
        }
    }

    HashBiMap$Inverse$1(Inverse inverse) {
        this.f7314a = inverse;
    }

    final Map<V, K> m13350a() {
        return this.f7314a;
    }

    public Iterator<Entry<V, K>> iterator() {
        return new C08121(this);
    }
}
