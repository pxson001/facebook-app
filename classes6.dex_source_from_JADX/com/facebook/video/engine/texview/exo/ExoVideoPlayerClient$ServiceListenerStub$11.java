package com.facebook.video.engine.texview.exo;

import com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.ServiceListenerStub;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$ServiceListenerStub$11 implements Runnable {
    final /* synthetic */ int f18890a;
    final /* synthetic */ ExoVideoPlayerClient f18891b;
    final /* synthetic */ long f18892c;
    final /* synthetic */ ServiceListenerStub f18893d;

    public void run() {
        String str = ExoVideoPlayerClient.aQ;
        Integer.valueOf(this.f18890a);
        ExoVideoPlayerClient.b(this.f18891b, this.f18892c);
    }

    ExoVideoPlayerClient$ServiceListenerStub$11(ServiceListenerStub serviceListenerStub, int i, ExoVideoPlayerClient exoVideoPlayerClient, long j) {
        this.f18893d = serviceListenerStub;
        this.f18890a = i;
        this.f18891b = exoVideoPlayerClient;
        this.f18892c = j;
    }
}
