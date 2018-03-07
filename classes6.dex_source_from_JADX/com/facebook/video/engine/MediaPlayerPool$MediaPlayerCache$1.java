package com.facebook.video.engine;

import android.media.MediaPlayer;
import com.facebook.video.engine.MediaPlayerPool.MediaPlayerCache;

/* compiled from: composer_video_tag_click */
class MediaPlayerPool$MediaPlayerCache$1 implements Runnable {
    final /* synthetic */ MediaPlayer f18825a;
    final /* synthetic */ MediaPlayerCache f18826b;

    MediaPlayerPool$MediaPlayerCache$1(MediaPlayerCache mediaPlayerCache, MediaPlayer mediaPlayer) {
        this.f18826b = mediaPlayerCache;
        this.f18825a = mediaPlayer;
    }

    public void run() {
        this.f18825a.release();
    }
}
