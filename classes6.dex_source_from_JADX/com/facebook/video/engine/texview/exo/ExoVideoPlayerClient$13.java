package com.facebook.video.engine.texview.exo;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$13 implements Runnable {
    final /* synthetic */ ExoVideoPlayerClient f18879a;

    ExoVideoPlayerClient$13(ExoVideoPlayerClient exoVideoPlayerClient) {
        this.f18879a = exoVideoPlayerClient;
    }

    public void run() {
        ExoVideoPlayerClient.c(this.f18879a, "Try connect to service after unknown issue, #%s", new Object[]{Integer.valueOf(this.f18879a.aL)});
    }
}
