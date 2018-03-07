package com.facebook.common.collect;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: ensureAlphabeticIndexLocaleUtils */
public class LruMap<A, B> extends LinkedHashMap<A, B> {
    private final int maxEntries;

    public LruMap(int i) {
        super(i + 1, 1.0f, true);
        this.maxEntries = i;
    }

    protected boolean removeEldestEntry(Entry<A, B> entry) {
        return size() > this.maxEntries;
    }
}
