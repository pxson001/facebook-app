package com.facebook.video.engine.texview.exo;

import com.facebook.exoplayer.ipc.MediaRenderer;
import com.facebook.exoplayer.ipc.RendererContext;
import com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.ServiceListenerStub;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$ServiceListenerStub$2 implements Runnable {
    final /* synthetic */ int f18904a;
    final /* synthetic */ ExoVideoPlayerClient f18905b;
    final /* synthetic */ MediaRenderer f18906c;
    final /* synthetic */ MediaRenderer f18907d;
    final /* synthetic */ RendererContext f18908e;
    final /* synthetic */ ServiceListenerStub f18909f;

    public void run() {
        String str = ExoVideoPlayerClient.aQ;
        Integer.valueOf(this.f18904a);
        ServiceListenerStub.b(this.f18905b, this.f18906c, this.f18907d, this.f18908e);
    }

    ExoVideoPlayerClient$ServiceListenerStub$2(ServiceListenerStub serviceListenerStub, int i, ExoVideoPlayerClient exoVideoPlayerClient, MediaRenderer mediaRenderer, MediaRenderer mediaRenderer2, RendererContext rendererContext) {
        this.f18909f = serviceListenerStub;
        this.f18904a = i;
        this.f18905b = exoVideoPlayerClient;
        this.f18906c = mediaRenderer;
        this.f18907d = mediaRenderer2;
        this.f18908e = rendererContext;
    }
}
