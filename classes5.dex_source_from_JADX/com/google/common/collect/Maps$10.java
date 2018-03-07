package com.google.common.collect;

import java.util.Map.Entry;

/* compiled from: camera */
final class Maps$10 extends AbstractMapEntry<K, V2> {
    final /* synthetic */ Entry f7466a;
    final /* synthetic */ Maps$EntryTransformer f7467b;

    Maps$10(Entry entry, Maps$EntryTransformer maps$EntryTransformer) {
        this.f7466a = entry;
        this.f7467b = maps$EntryTransformer;
    }

    public final K getKey() {
        return this.f7466a.getKey();
    }

    public final V2 getValue() {
        return this.f7467b.m13527a(this.f7466a.getKey(), this.f7466a.getValue());
    }
}
