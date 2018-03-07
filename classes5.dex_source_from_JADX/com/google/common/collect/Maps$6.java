package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: camera */
public final class Maps$6 extends UnmodifiableIterator<Entry<K, V>> {
    final /* synthetic */ Iterator f7471a;

    public Maps$6(Iterator it) {
        this.f7471a = it;
    }

    public final boolean hasNext() {
        return this.f7471a.hasNext();
    }

    public final Object next() {
        return Maps.a((Entry) this.f7471a.next());
    }
}
