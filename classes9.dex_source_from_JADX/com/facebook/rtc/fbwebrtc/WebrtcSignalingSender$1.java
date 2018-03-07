package com.facebook.rtc.fbwebrtc;

/* compiled from: audio service is not available */
class WebrtcSignalingSender$1 implements Runnable {
    final /* synthetic */ long f19409a;
    final /* synthetic */ WebrtcSignalingSender f19410b;

    WebrtcSignalingSender$1(WebrtcSignalingSender webrtcSignalingSender, long j) {
        this.f19410b = webrtcSignalingSender;
        this.f19409a = j;
    }

    public void run() {
        WebrtcSignalingSender.d(this.f19410b, this.f19409a);
    }
}
