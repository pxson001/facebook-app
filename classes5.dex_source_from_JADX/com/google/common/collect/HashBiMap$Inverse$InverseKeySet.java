package com.google.common.collect;

import com.google.common.collect.HashBiMap.BiEntry;
import com.google.common.collect.HashBiMap.Inverse;
import com.google.common.collect.Maps.KeySet;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: cached_feedback_age */
final class HashBiMap$Inverse$InverseKeySet extends KeySet<V, K> {
    final /* synthetic */ Inverse f7316a;

    /* compiled from: cached_feedback_age */
    class C08131 extends HashBiMap$Itr<V> {
        final /* synthetic */ HashBiMap$Inverse$InverseKeySet f7315a;

        C08131(HashBiMap$Inverse$InverseKeySet hashBiMap$Inverse$InverseKeySet) {
            this.f7315a = hashBiMap$Inverse$InverseKeySet;
            super(hashBiMap$Inverse$InverseKeySet.f7316a.this$0);
        }

        final V mo923a(BiEntry<K, V> biEntry) {
            return biEntry.value;
        }
    }

    HashBiMap$Inverse$InverseKeySet(Inverse inverse) {
        this.f7316a = inverse;
        super(inverse);
    }

    public final boolean remove(@Nullable Object obj) {
        BiEntry b = HashBiMap.b(this.f7316a.this$0, obj, Hashing.a(obj));
        if (b == null) {
            return false;
        }
        HashBiMap.a(this.f7316a.this$0, b);
        return true;
    }

    public final Iterator<V> iterator() {
        return new C08131(this);
    }
}
