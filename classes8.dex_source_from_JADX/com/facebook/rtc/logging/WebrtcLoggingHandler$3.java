package com.facebook.rtc.logging;

/* compiled from: null and empty keys are not allowed */
class WebrtcLoggingHandler$3 implements Runnable {
    final /* synthetic */ long f7789a;
    final /* synthetic */ WebrtcLoggingHandler f7790b;

    WebrtcLoggingHandler$3(WebrtcLoggingHandler webrtcLoggingHandler, long j) {
        this.f7790b = webrtcLoggingHandler;
        this.f7789a = j;
    }

    public void run() {
        WebrtcLoggingHandler.a(this.f7790b, this.f7789a, this.f7790b.J).delete();
    }
}
