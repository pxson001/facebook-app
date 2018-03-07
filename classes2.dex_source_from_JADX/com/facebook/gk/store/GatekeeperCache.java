package com.facebook.gk.store;

import com.facebook.common.preconditions.Preconditions;
import com.facebook.common.util.TriState;

/* compiled from: video_upload_in_progress_waterfallid */
public class GatekeeperCache {
    public final TriState[] f1087a;
    private final TriState[] f1088b;
    private final TriState[] f1089c;

    public GatekeeperCache(int i) {
        this.f1087a = m2198g(i);
        this.f1088b = m2198g(i);
        this.f1089c = m2198g(i);
    }

    private static TriState[] m2198g(int i) {
        TriState[] triStateArr = new TriState[i];
        for (int i2 = 0; i2 < i; i2++) {
            triStateArr[i2] = TriState.UNSET;
        }
        return triStateArr;
    }

    public final synchronized TriState m2200a(int i) {
        return this.f1089c[i];
    }

    public final synchronized TriState m2204b(int i) {
        return this.f1087a[i];
    }

    public final synchronized TriState m2207c(int i) {
        return this.f1088b[i];
    }

    public final synchronized boolean m2209d(int i) {
        return !TriState.UNSET.equals(this.f1089c[i]);
    }

    private static TriState m2197a(TriState triState, TriState triState2) {
        return TriState.UNSET.equals(triState2) ? triState : triState2;
    }

    private void m2199h(int i) {
        this.f1089c[i] = m2197a(this.f1087a[i], this.f1088b[i]);
    }

    public final synchronized void m2202a(int i, boolean z) {
        this.f1087a[i] = TriState.valueOf(z);
        m2199h(i);
    }

    public final synchronized void m2206b(int i, boolean z) {
        this.f1088b[i] = TriState.valueOf(z);
        m2199h(i);
    }

    public final synchronized void m2210e(int i) {
        this.f1087a[i] = TriState.UNSET;
        m2199h(i);
    }

    public final synchronized void m2211f(int i) {
        this.f1088b[i] = TriState.UNSET;
        m2199h(i);
    }

    public final void m2201a() {
        int length = this.f1087a.length;
        for (int i = 0; i < length; i++) {
            m2210e(i);
        }
    }

    public final void m2205b() {
        int length = this.f1087a.length;
        for (int i = 0; i < length; i++) {
            m2211f(i);
        }
    }

    public final void m2203a(GatekeeperCache gatekeeperCache) {
        boolean z;
        int i = 0;
        if (gatekeeperCache.f1087a.length == this.f1087a.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.m2017b(z);
        int length = this.f1087a.length;
        while (i < length) {
            this.f1087a[i] = gatekeeperCache.f1087a[i];
            this.f1088b[i] = gatekeeperCache.f1088b[i];
            this.f1089c[i] = gatekeeperCache.f1089c[i];
            i++;
        }
    }

    public final synchronized boolean m2208c() {
        boolean z = false;
        synchronized (this) {
            int length = this.f1087a.length;
            for (int i = 0; i < length; i++) {
                if (m2209d(i)) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }
}
