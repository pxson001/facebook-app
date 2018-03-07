package com.facebook.video.engine.texview.exo;

import com.facebook.exoplayer.ipc.VideoPlayerStreamFormat;
import com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.ServiceListenerStub;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$ServiceListenerStub$4 implements Runnable {
    final /* synthetic */ int f18916a;
    final /* synthetic */ ExoVideoPlayerClient f18917b;
    final /* synthetic */ int f18918c;
    final /* synthetic */ VideoPlayerStreamFormat f18919d;
    final /* synthetic */ int f18920e;
    final /* synthetic */ int f18921f;
    final /* synthetic */ long f18922g;
    final /* synthetic */ ServiceListenerStub f18923h;

    public void run() {
        String str = ExoVideoPlayerClient.aQ;
        Integer.valueOf(this.f18916a);
        this.f18917b.a(this.f18918c, this.f18919d, this.f18920e, this.f18921f, this.f18922g);
    }

    ExoVideoPlayerClient$ServiceListenerStub$4(ServiceListenerStub serviceListenerStub, int i, ExoVideoPlayerClient exoVideoPlayerClient, int i2, VideoPlayerStreamFormat videoPlayerStreamFormat, int i3, int i4, long j) {
        this.f18923h = serviceListenerStub;
        this.f18916a = i;
        this.f18917b = exoVideoPlayerClient;
        this.f18918c = i2;
        this.f18919d = videoPlayerStreamFormat;
        this.f18920e = i3;
        this.f18921f = i4;
        this.f18922g = j;
    }
}
