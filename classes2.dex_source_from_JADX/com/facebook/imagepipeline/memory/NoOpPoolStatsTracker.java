package com.facebook.imagepipeline.memory;

/* compiled from: page/%s/reaction */
public class NoOpPoolStatsTracker implements PoolStatsTracker {
    private static NoOpPoolStatsTracker f10581a = null;

    private NoOpPoolStatsTracker() {
    }

    public static synchronized NoOpPoolStatsTracker m15750a() {
        NoOpPoolStatsTracker noOpPoolStatsTracker;
        synchronized (NoOpPoolStatsTracker.class) {
            if (f10581a == null) {
                f10581a = new NoOpPoolStatsTracker();
            }
            noOpPoolStatsTracker = f10581a;
        }
        return noOpPoolStatsTracker;
    }

    public final void mo2006a(BasePool basePool) {
    }

    public final void mo2004a(int i) {
    }

    public final void mo2008b() {
    }

    public final void ak_() {
    }

    public final void mo2009b(int i) {
    }

    public final void mo2010c(int i) {
    }

    public final void mo2011d(int i) {
    }
}
