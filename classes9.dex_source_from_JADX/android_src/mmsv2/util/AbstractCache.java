package android_src.mmsv2.util;

import android.support.v4.util.SimpleArrayMap;

/* compiled from: serializeTheme */
public abstract class AbstractCache<K, V> {
    private final SimpleArrayMap<K, CacheEntry<V>> f3886a = new SimpleArrayMap();

    /* compiled from: serializeTheme */
    class CacheEntry<V> {
        int f3884a;
        V f3885b;
    }

    protected AbstractCache() {
    }

    public boolean mo126a(K k, V v) {
        if (this.f3886a.size() >= 500 || k == null) {
            return false;
        }
        CacheEntry cacheEntry = new CacheEntry();
        cacheEntry.f3885b = v;
        this.f3886a.put(k, cacheEntry);
        return true;
    }

    public final V m3736a(K k) {
        if (k != null) {
            CacheEntry cacheEntry = (CacheEntry) this.f3886a.get(k);
            if (cacheEntry != null) {
                cacheEntry.f3884a++;
                return cacheEntry.f3885b;
            }
        }
        return null;
    }

    public V mo127b(K k) {
        CacheEntry cacheEntry = (CacheEntry) this.f3886a.remove(k);
        return cacheEntry != null ? cacheEntry.f3885b : null;
    }

    public void mo125a() {
        this.f3886a.clear();
    }
}
