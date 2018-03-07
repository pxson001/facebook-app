package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible
/* compiled from: only add to extra if the wakelock is being held */
public final class AtomicLongMap<K> {
    public final ConcurrentHashMap<K, AtomicLong> f11044a;

    public AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.f11044a = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public final long m16389b(K k) {
        return m16388a(k, 1);
    }

    public final long m16390c(K k) {
        return m16388a(k, -1);
    }

    private long m16388a(K k, long j) {
        AtomicLong atomicLong;
        do {
            atomicLong = (AtomicLong) this.f11044a.get(k);
            if (atomicLong == null) {
                atomicLong = (AtomicLong) this.f11044a.putIfAbsent(k, new AtomicLong(j));
                if (atomicLong == null) {
                    return j;
                }
            }
            while (true) {
                long j2 = atomicLong.get();
                if (j2 != 0) {
                    long j3 = j2 + j;
                    if (atomicLong.compareAndSet(j2, j3)) {
                        return j3;
                    }
                }
            }
        } while (!this.f11044a.replace(k, atomicLong, new AtomicLong(j)));
        return j;
    }

    public final long m16391d(K k) {
        AtomicLong atomicLong = (AtomicLong) this.f11044a.get(k);
        if (atomicLong == null) {
            return 0;
        }
        long j;
        do {
            j = atomicLong.get();
            if (j == 0) {
                break;
            }
        } while (!atomicLong.compareAndSet(j, 0));
        this.f11044a.remove(k, atomicLong);
        return j;
    }

    public final String toString() {
        return this.f11044a.toString();
    }
}
