package com.facebook.ads.internal.view.video.support;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.View;
import android.widget.VideoView;

public class C2010g extends VideoView implements OnPreparedListener, C2007e {
    private View f14413a;
    private Uri f14414b;
    private C2005b f14415c;

    public C2010g(Context context) {
        super(context);
    }

    public final void mo743a(View view, Uri uri) {
        this.f14413a = view;
        this.f14414b = uri;
        setOnPreparedListener(this);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setLooping(true);
        mediaPlayer.setOnInfoListener(new C2006c(this.f14413a));
    }

    public void pause() {
        this.f14413a.setVisibility(0);
        stopPlayback();
    }

    public void setFrameVideoViewListener(C2005b c2005b) {
        this.f14415c = c2005b;
    }

    public void start() {
        setVideoURI(this.f14414b);
        super.start();
    }
}
