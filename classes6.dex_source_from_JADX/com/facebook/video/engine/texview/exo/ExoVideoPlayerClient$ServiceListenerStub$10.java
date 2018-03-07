package com.facebook.video.engine.texview.exo;

import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.ServiceListenerStub;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$ServiceListenerStub$10 implements Runnable {
    final /* synthetic */ int f18887a;
    final /* synthetic */ ExoVideoPlayerClient f18888b;
    final /* synthetic */ ServiceListenerStub f18889c;

    public void run() {
        String str = ExoVideoPlayerClient.aQ;
        Integer.valueOf(this.f18887a);
        this.f18888b.e(EventTriggerType.BY_LIVE_STREAM_EOF);
    }

    ExoVideoPlayerClient$ServiceListenerStub$10(ServiceListenerStub serviceListenerStub, int i, ExoVideoPlayerClient exoVideoPlayerClient) {
        this.f18889c = serviceListenerStub;
        this.f18887a = i;
        this.f18888b = exoVideoPlayerClient;
    }
}
