package com.facebook.video.engine.texview.exo;

import com.facebook.exoplayer.ipc.VideoPlayerStreamEvaluation;
import com.facebook.exoplayer.ipc.VideoPlayerStreamFormat;
import com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.ServiceListenerStub;
import java.util.List;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$ServiceListenerStub$8 implements Runnable {
    final /* synthetic */ int f18936a;
    final /* synthetic */ ExoVideoPlayerClient f18937b;
    final /* synthetic */ List f18938c;
    final /* synthetic */ long f18939d;
    final /* synthetic */ VideoPlayerStreamFormat[] f18940e;
    final /* synthetic */ VideoPlayerStreamEvaluation f18941f;
    final /* synthetic */ ServiceListenerStub f18942g;

    public void run() {
        String str = ExoVideoPlayerClient.aQ;
        Integer.valueOf(this.f18936a);
        this.f18937b.a(this.f18938c, this.f18939d, this.f18940e, this.f18941f);
    }

    ExoVideoPlayerClient$ServiceListenerStub$8(ServiceListenerStub serviceListenerStub, int i, ExoVideoPlayerClient exoVideoPlayerClient, List list, long j, VideoPlayerStreamFormat[] videoPlayerStreamFormatArr, VideoPlayerStreamEvaluation videoPlayerStreamEvaluation) {
        this.f18942g = serviceListenerStub;
        this.f18936a = i;
        this.f18937b = exoVideoPlayerClient;
        this.f18938c = list;
        this.f18939d = j;
        this.f18940e = videoPlayerStreamFormatArr;
        this.f18941f = videoPlayerStreamEvaluation;
    }
}
