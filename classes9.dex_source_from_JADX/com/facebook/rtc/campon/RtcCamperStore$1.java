package com.facebook.rtc.campon;

import java.util.List;

/* compiled from: audio_attachment_count */
class RtcCamperStore$1 implements Runnable {
    final /* synthetic */ List f19302a;
    final /* synthetic */ RtcCamperStore f19303b;

    RtcCamperStore$1(RtcCamperStore rtcCamperStore, List list) {
        this.f19303b = rtcCamperStore;
        this.f19302a = list;
    }

    public void run() {
        try {
            for (RtcCamperModel rtcCamperModel : this.f19302a) {
                if (!RtcCamperStore.a(this.f19303b, rtcCamperModel)) {
                    this.f19303b.a(rtcCamperModel.mPeerId);
                }
            }
            synchronized (this.f19303b) {
                RtcCamperStore.a(this.f19303b, true);
            }
        } catch (Throwable th) {
            synchronized (this.f19303b) {
                RtcCamperStore.a(this.f19303b, true);
            }
        }
    }
}
