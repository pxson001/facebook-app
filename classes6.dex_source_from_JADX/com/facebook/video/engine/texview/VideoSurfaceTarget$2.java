package com.facebook.video.engine.texview;

import android.graphics.SurfaceTexture;

/* compiled from: composer_selectable_privacy_pill_clicked */
class VideoSurfaceTarget$2 implements Runnable {
    final /* synthetic */ SurfaceTexture f18859a;
    final /* synthetic */ VideoSurfaceTarget f18860b;

    VideoSurfaceTarget$2(VideoSurfaceTarget videoSurfaceTarget, SurfaceTexture surfaceTexture) {
        this.f18860b = videoSurfaceTarget;
        this.f18859a = surfaceTexture;
    }

    public void run() {
        this.f18859a.release();
    }
}
