package com.facebook.video.engine.texview;

import android.graphics.SurfaceTexture;

/* compiled from: composer_selectable_privacy_pill_clicked */
class VideoSurfaceTarget$1 implements Runnable {
    final /* synthetic */ SurfaceTexture f18857a;
    final /* synthetic */ VideoSurfaceTarget f18858b;

    VideoSurfaceTarget$1(VideoSurfaceTarget videoSurfaceTarget, SurfaceTexture surfaceTexture) {
        this.f18858b = videoSurfaceTarget;
        this.f18857a = surfaceTexture;
    }

    public void run() {
        this.f18858b.d.a(this.f18857a);
    }
}
