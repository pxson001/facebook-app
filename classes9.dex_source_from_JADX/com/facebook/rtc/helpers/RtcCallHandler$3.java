package com.facebook.rtc.helpers;

/* compiled from: application/vnd.wap.wmlscriptc */
class RtcCallHandler$3 implements Runnable {
    final /* synthetic */ RtcCallStartParams f19761a;
    final /* synthetic */ String f19762b;
    final /* synthetic */ RtcCallHandler f19763c;

    RtcCallHandler$3(RtcCallHandler rtcCallHandler, RtcCallStartParams rtcCallStartParams, String str) {
        this.f19763c = rtcCallHandler;
        this.f19761a = rtcCallStartParams;
        this.f19762b = str;
    }

    public void run() {
        if (this.f19763c.b()) {
            this.f19763c.e.a(this.f19761a.f19777a, this.f19761a.f19780d, this.f19762b, this.f19761a.f19782f, this.f19761a.f19782f, true, true, this.f19761a.f19785i);
        }
    }
}
