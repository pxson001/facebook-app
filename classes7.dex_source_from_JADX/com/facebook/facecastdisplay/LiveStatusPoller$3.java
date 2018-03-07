package com.facebook.facecastdisplay;

/* compiled from: audio/vnd.dts.hd;profile=lbr */
class LiveStatusPoller$3 implements Runnable {
    final /* synthetic */ LiveStatusPoller f18923a;

    LiveStatusPoller$3(LiveStatusPoller liveStatusPoller) {
        this.f18923a = liveStatusPoller;
    }

    public void run() {
        LiveStatusPoller.f(this.f18923a);
    }
}
