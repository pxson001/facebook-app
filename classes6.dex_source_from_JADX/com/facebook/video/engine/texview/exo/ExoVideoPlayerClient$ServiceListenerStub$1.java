package com.facebook.video.engine.texview.exo;

import com.facebook.exoplayer.ipc.VideoPlayerSession;
import com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.ServiceListenerStub;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$ServiceListenerStub$1 implements Runnable {
    final /* synthetic */ int f18897a;
    final /* synthetic */ ExoVideoPlayerClient f18898b;
    final /* synthetic */ VideoPlayerSession f18899c;
    final /* synthetic */ boolean f18900d;
    final /* synthetic */ int f18901e;
    final /* synthetic */ int f18902f;
    final /* synthetic */ ServiceListenerStub f18903g;

    public void run() {
        String str = ExoVideoPlayerClient.aQ;
        Integer.valueOf(this.f18897a);
        ServiceListenerStub.b(this.f18898b, this.f18899c, this.f18900d, this.f18901e, this.f18902f);
    }

    ExoVideoPlayerClient$ServiceListenerStub$1(ServiceListenerStub serviceListenerStub, int i, ExoVideoPlayerClient exoVideoPlayerClient, VideoPlayerSession videoPlayerSession, boolean z, int i2, int i3) {
        this.f18903g = serviceListenerStub;
        this.f18897a = i;
        this.f18898b = exoVideoPlayerClient;
        this.f18899c = videoPlayerSession;
        this.f18900d = z;
        this.f18901e = i2;
        this.f18902f = i3;
    }
}
