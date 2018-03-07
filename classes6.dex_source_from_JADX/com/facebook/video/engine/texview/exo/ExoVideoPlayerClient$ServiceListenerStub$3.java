package com.facebook.video.engine.texview.exo;

import com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.ServiceListenerStub;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$ServiceListenerStub$3 implements Runnable {
    final /* synthetic */ int f18910a;
    final /* synthetic */ ExoVideoPlayerClient f18911b;
    final /* synthetic */ int f18912c;
    final /* synthetic */ int f18913d;
    final /* synthetic */ float f18914e;
    final /* synthetic */ ServiceListenerStub f18915f;

    public void run() {
        String str = ExoVideoPlayerClient.aQ;
        Integer.valueOf(this.f18910a);
        ServiceListenerStub.b(this.f18911b, this.f18912c, this.f18913d, this.f18914e);
    }

    ExoVideoPlayerClient$ServiceListenerStub$3(ServiceListenerStub serviceListenerStub, int i, ExoVideoPlayerClient exoVideoPlayerClient, int i2, int i3, float f) {
        this.f18915f = serviceListenerStub;
        this.f18910a = i;
        this.f18911b = exoVideoPlayerClient;
        this.f18912c = i2;
        this.f18913d = i3;
        this.f18914e = f;
    }
}
