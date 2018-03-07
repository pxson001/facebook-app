package com.google.common.collect;

import com.google.common.collect.Multimaps.Keys;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: build_num */
class Multimaps$Keys$1 extends TransformedIterator<Entry<K, Collection<V>>, Multiset.Entry<K>> {
    final /* synthetic */ Keys f7518a;

    Multimaps$Keys$1(Keys keys, Iterator it) {
        this.f7518a = keys;
        super(it);
    }

    final Object m13590a(Object obj) {
        final Entry entry = (Entry) obj;
        return new Multisets$AbstractEntry<K>(this) {
            final /* synthetic */ Multimaps$Keys$1 f7517b;

            public final K mo889a() {
                return entry.getKey();
            }

            public final int mo890b() {
                return ((Collection) entry.getValue()).size();
            }
        };
    }
}
