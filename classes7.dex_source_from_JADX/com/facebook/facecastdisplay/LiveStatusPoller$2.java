package com.facebook.facecastdisplay;

/* compiled from: audio/vnd.dts.hd;profile=lbr */
class LiveStatusPoller$2 implements Runnable {
    final /* synthetic */ LiveStatusPoller f18922a;

    LiveStatusPoller$2(LiveStatusPoller liveStatusPoller) {
        this.f18922a = liveStatusPoller;
    }

    public void run() {
        LiveStatusPoller.b(this.f18922a, false);
    }
}
