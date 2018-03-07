package com.google.common.collect;

import com.google.common.collect.Maps.EntrySet;
import com.google.common.collect.Maps.IteratorBasedAbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: camera */
class Maps$IteratorBasedAbstractMap$1 extends EntrySet<K, V> {
    final /* synthetic */ IteratorBasedAbstractMap f7483a;

    Maps$IteratorBasedAbstractMap$1(IteratorBasedAbstractMap iteratorBasedAbstractMap) {
        this.f7483a = iteratorBasedAbstractMap;
    }

    final Map<K, V> m13543a() {
        return this.f7483a;
    }

    public Iterator<Entry<K, V>> iterator() {
        return this.f7483a.d();
    }
}
