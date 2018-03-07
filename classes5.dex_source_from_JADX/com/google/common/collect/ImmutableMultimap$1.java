package com.google.common.collect;

import java.util.Map.Entry;

/* compiled from: bytes_downloaded */
class ImmutableMultimap$1 extends ImmutableMultimap$Itr<Entry<K, V>> {
    final /* synthetic */ ImmutableMultimap f7332a;

    ImmutableMultimap$1(ImmutableMultimap immutableMultimap) {
        this.f7332a = immutableMultimap;
        super(immutableMultimap);
    }

    final Object mo927a(Object obj, Object obj2) {
        return Maps.a(obj, obj2);
    }
}
