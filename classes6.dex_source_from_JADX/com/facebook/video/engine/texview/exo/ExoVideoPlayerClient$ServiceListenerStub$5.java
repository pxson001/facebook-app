package com.facebook.video.engine.texview.exo;

import com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.ServiceListenerStub;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$ServiceListenerStub$5 implements Runnable {
    final /* synthetic */ int f18924a;
    final /* synthetic */ ExoVideoPlayerClient f18925b;
    final /* synthetic */ String f18926c;
    final /* synthetic */ String f18927d;
    final /* synthetic */ long f18928e;
    final /* synthetic */ ServiceListenerStub f18929f;

    public void run() {
        String str = ExoVideoPlayerClient.aQ;
        Integer.valueOf(this.f18924a);
        this.f18925b.a(this.f18926c, this.f18927d, this.f18928e);
    }

    ExoVideoPlayerClient$ServiceListenerStub$5(ServiceListenerStub serviceListenerStub, int i, ExoVideoPlayerClient exoVideoPlayerClient, String str, String str2, long j) {
        this.f18929f = serviceListenerStub;
        this.f18924a = i;
        this.f18925b = exoVideoPlayerClient;
        this.f18926c = str;
        this.f18927d = str2;
        this.f18928e = j;
    }
}
