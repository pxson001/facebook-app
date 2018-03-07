package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: font_scale */
class AbstractMultimap$Entries extends Entries<K, V> {
    final /* synthetic */ AbstractMultimap f11492a;

    public AbstractMultimap$Entries(AbstractMultimap abstractMultimap) {
        this.f11492a = abstractMultimap;
    }

    final Multimap<K, V> mo850a() {
        return this.f11492a;
    }

    public Iterator<Entry<K, V>> iterator() {
        return this.f11492a.l();
    }
}
