package com.facebook.rtc.campon;

import com.facebook.inject.InjectableComponentWithoutContext;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: audio_download */
public class RtcCallCamper implements InjectableComponentWithoutContext {
    public final RtcCampOnManager f19246a;
    public final long f19247b;
    protected String f19248c;
    public String f19249d;
    protected final long f19250e;
    protected final long f19251f;
    public ListenableFuture<String> f19252g;

    public RtcCallCamper(RtcCampOnManager rtcCampOnManager, long j, long j2, long j3) {
        this.f19246a = rtcCampOnManager;
        this.f19247b = j;
        this.f19250e = j2;
        this.f19251f = j3;
    }

    public final long m19289a() {
        return this.f19247b;
    }

    final void m19290a(String str, String str2) {
        this.f19248c = str;
        this.f19249d = str2;
    }

    final ListenableFuture<String> m19291c() {
        return this.f19252g;
    }

    public final boolean m19292d() {
        if (this.f19251f > 0 && System.currentTimeMillis() - this.f19250e >= this.f19251f) {
            return true;
        }
        return false;
    }

    public boolean mo811e() {
        return true;
    }

    public static boolean m19288f() {
        return true;
    }

    public void mo812g() {
    }

    public void mo813h() {
    }

    public void mo814i() {
    }

    public void mo815j() {
    }

    public boolean mo816l() {
        return false;
    }
}
