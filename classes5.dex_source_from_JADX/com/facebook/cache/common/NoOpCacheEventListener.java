package com.facebook.cache.common;

/* compiled from: subject */
public class NoOpCacheEventListener implements CacheEventListener {
    private static NoOpCacheEventListener f2470a = null;

    private NoOpCacheEventListener() {
    }

    public static synchronized NoOpCacheEventListener m3590f() {
        NoOpCacheEventListener noOpCacheEventListener;
        synchronized (NoOpCacheEventListener.class) {
            if (f2470a == null) {
                f2470a = new NoOpCacheEventListener();
            }
            noOpCacheEventListener = f2470a;
        }
        return noOpCacheEventListener;
    }

    public final void m3591a() {
    }

    public final void m3593b() {
    }

    public final void m3594c() {
    }

    public final void m3595d() {
    }

    public final void m3596e() {
    }

    public final void m3592a(CacheEventListener$EvictionReason cacheEventListener$EvictionReason, int i, long j) {
    }
}
