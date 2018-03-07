package com.facebook.video.engine.texview.exo;

import com.facebook.video.engine.Constants.VideoError;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$2 implements Runnable {
    final /* synthetic */ ExoVideoPlayerClient f18886a;

    ExoVideoPlayerClient$2(ExoVideoPlayerClient exoVideoPlayerClient) {
        this.f18886a = exoVideoPlayerClient;
    }

    public void run() {
        this.f18886a.f.a(this.f18886a.G, VideoError.NO_SOURCE);
    }
}
