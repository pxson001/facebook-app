package com.google.common.collect;

import com.google.common.collect.HashBiMap.BiEntry;
import com.google.common.collect.Maps.KeySet;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: cached_feedback_age */
final class HashBiMap$KeySet extends KeySet<K, V> {
    final /* synthetic */ HashBiMap f7318a;

    /* compiled from: cached_feedback_age */
    class C08141 extends HashBiMap$Itr<K> {
        final /* synthetic */ HashBiMap$KeySet f7317a;

        C08141(HashBiMap$KeySet hashBiMap$KeySet) {
            this.f7317a = hashBiMap$KeySet;
            super(hashBiMap$KeySet.f7318a);
        }

        final K mo923a(BiEntry<K, V> biEntry) {
            return biEntry.key;
        }
    }

    HashBiMap$KeySet(HashBiMap hashBiMap) {
        this.f7318a = hashBiMap;
        super(hashBiMap);
    }

    public final Iterator<K> iterator() {
        return new C08141(this);
    }

    public final boolean remove(@Nullable Object obj) {
        BiEntry a = HashBiMap.a(this.f7318a, obj, Hashing.a(obj));
        if (a == null) {
            return false;
        }
        HashBiMap.a(this.f7318a, a);
        a.prevInKeyInsertionOrder = null;
        a.nextInKeyInsertionOrder = null;
        return true;
    }
}
