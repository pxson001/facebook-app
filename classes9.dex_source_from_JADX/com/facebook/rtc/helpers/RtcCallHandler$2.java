package com.facebook.rtc.helpers;

/* compiled from: application/vnd.wap.wmlscriptc */
class RtcCallHandler$2 implements Runnable {
    final /* synthetic */ RtcCallStartParams f19759a;
    final /* synthetic */ RtcCallHandler f19760b;

    RtcCallHandler$2(RtcCallHandler rtcCallHandler, RtcCallStartParams rtcCallStartParams) {
        this.f19760b = rtcCallHandler;
        this.f19759a = rtcCallStartParams;
    }

    public void run() {
        this.f19760b.A.a(this.f19759a.f19777a);
    }
}
