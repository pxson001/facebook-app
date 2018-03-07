package com.facebook.video.engine.texview.exo;

/* compiled from: composer_select_album_click */
class ExoVideoPlayerClient$23 implements Runnable {
    final /* synthetic */ String f18883a;
    final /* synthetic */ ExoVideoPlayerClient f18884b;

    ExoVideoPlayerClient$23(ExoVideoPlayerClient exoVideoPlayerClient, String str) {
        this.f18884b = exoVideoPlayerClient;
        this.f18883a = str;
    }

    public void run() {
        this.f18884b.f.a(this.f18883a);
    }
}
