package com.facebook.camera.analytics;

import android.os.SystemClock;

/* compiled from: amount_with_offset */
public class CameraUsageData {
    public int f10791a;
    public int f10792b;
    public int f10793c;
    public int f10794d;
    public long f10795e;
    public boolean f10796f = false;
    public long f10797g;
    private String f10798h;

    public CameraUsageData(String str) {
        this.f10798h = str;
        m18855a();
    }

    public final void m18855a() {
        this.f10791a = 0;
        this.f10792b = 0;
        this.f10793c = 0;
        this.f10794d = 0;
        this.f10795e = 0;
        this.f10797g = m18854m();
    }

    public final float m18856l() {
        long j = this.f10795e;
        if (this.f10796f) {
            j += m18854m() - this.f10797g;
        }
        return ((float) j) / 1000.0f;
    }

    public static long m18854m() {
        return SystemClock.uptimeMillis();
    }
}
