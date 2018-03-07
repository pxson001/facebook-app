package com.facebook.imagepipeline.cache;

/* compiled from: TRANSPORTATION_CHECKIN_SUGGESTIFIER */
public class NoOpImageCacheStatsTracker implements ImageCacheStatsTracker {
    private static NoOpImageCacheStatsTracker f13682a = null;

    private NoOpImageCacheStatsTracker() {
    }

    public static synchronized NoOpImageCacheStatsTracker m22998l() {
        NoOpImageCacheStatsTracker noOpImageCacheStatsTracker;
        synchronized (NoOpImageCacheStatsTracker.class) {
            if (f13682a == null) {
                f13682a = new NoOpImageCacheStatsTracker();
            }
            noOpImageCacheStatsTracker = f13682a;
        }
        return noOpImageCacheStatsTracker;
    }

    public final void m22999a() {
    }

    public final void m23001b() {
    }

    public final void m23003c() {
    }

    public final void m23004d() {
    }

    public final void m23005e() {
    }

    public final void m23006f() {
    }

    public final void m23007g() {
    }

    public final void m23008h() {
    }

    public final void m23009i() {
    }

    public final void m23010j() {
    }

    public final void m23011k() {
    }

    public final void m23000a(CountingMemoryCache<?, ?> countingMemoryCache) {
    }

    public final void m23002b(CountingMemoryCache<?, ?> countingMemoryCache) {
    }
}
