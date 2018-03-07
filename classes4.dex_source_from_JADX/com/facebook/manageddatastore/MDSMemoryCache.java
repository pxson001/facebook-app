package com.facebook.manageddatastore;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: subtotal */
public class MDSMemoryCache<K, V> {
    private static long f1592b = -1;
    @GuardedBy("this")
    protected Map<K, MemoryStoreEntry<V>> f1593a = Maps.c();

    /* compiled from: subtotal */
    class MemoryStoreEntry<V> {
        V f2010a;
        long f2011b;

        MemoryStoreEntry(V v, long j) {
            this.f2010a = v;
            this.f2011b = j;
        }
    }

    final synchronized MemoryStoreEntry<V> m1830a(@Nullable K k) {
        return (MemoryStoreEntry) this.f1593a.get(k);
    }

    public final synchronized void m1833a(@Nullable K k, V v, long j) {
        this.f1593a.put(k, new MemoryStoreEntry(v, j));
    }

    final synchronized void m1834b(K k) {
        this.f1593a.remove(k);
    }

    final synchronized void m1831a() {
        this.f1593a.clear();
    }

    final synchronized void m1832a(long j) {
        long currentTimeMillis = System.currentTimeMillis() - (1000 * j);
        Iterator it = this.f1593a.entrySet().iterator();
        while (it.hasNext()) {
            if (((MemoryStoreEntry) ((Entry) it.next()).getValue()).f2011b < currentTimeMillis) {
                it.remove();
            }
        }
    }
}
