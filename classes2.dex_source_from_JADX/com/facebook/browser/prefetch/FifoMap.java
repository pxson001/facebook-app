package com.facebook.browser.prefetch;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: pp */
public class FifoMap<K, V> extends LinkedHashMap<K, V> {
    private int mMaxSize;

    public FifoMap(int i) {
        this.mMaxSize = i;
    }

    protected boolean removeEldestEntry(Entry entry) {
        return size() > this.mMaxSize;
    }

    public V put(K k, V v) {
        remove(k);
        super.put(k, v);
        return null;
    }
}
