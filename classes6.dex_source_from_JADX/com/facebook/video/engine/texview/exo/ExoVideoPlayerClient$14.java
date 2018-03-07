package com.facebook.video.engine.texview.exo;

import com.facebook.video.engine.Constants.VideoError;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$14 implements Runnable {
    final /* synthetic */ VideoError f18880a;
    final /* synthetic */ ExoVideoPlayerClient f18881b;

    ExoVideoPlayerClient$14(ExoVideoPlayerClient exoVideoPlayerClient, VideoError videoError) {
        this.f18881b = exoVideoPlayerClient;
        this.f18880a = videoError;
    }

    public void run() {
        if (this.f18881b.f != null) {
            this.f18881b.f.a(this.f18881b.G, this.f18880a);
        }
    }
}
