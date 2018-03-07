package com.google.common.cache;

import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: campaign_title */
final class LocalCache$WriteThroughEntry implements Entry<K, V> {
    final K f7236a;
    V f7237b;
    final /* synthetic */ LocalCache f7238c;

    LocalCache$WriteThroughEntry(LocalCache localCache, K k, V v) {
        this.f7238c = localCache;
        this.f7236a = k;
        this.f7237b = v;
    }

    public final K getKey() {
        return this.f7236a;
    }

    public final V getValue() {
        return this.f7237b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        if (this.f7236a.equals(entry.getKey()) && this.f7237b.equals(entry.getValue())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f7236a.hashCode() ^ this.f7237b.hashCode();
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
