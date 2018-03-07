package com.facebook.ads.internal.view.video.support;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;

@TargetApi(14)
public class C2008d extends TextureView implements OnBufferingUpdateListener, OnPreparedListener, SurfaceTextureListener, C2007e {
    private static final String f14401i = C2008d.class.getSimpleName();
    private View f14402a;
    private Uri f14403b;
    private C2005b f14404c;
    private Surface f14405d;
    private MediaPlayer f14406e;
    private boolean f14407f;
    private boolean f14408g;
    private int f14409h;

    public C2008d(Context context) {
        super(context);
    }

    private void m14497a() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(getContext(), this.f14403b);
            mediaPlayer.setSurface(this.f14405d);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnInfoListener(new C2006c(this.f14402a));
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setLooping(false);
            mediaPlayer.prepareAsync();
            this.f14406e = mediaPlayer;
        } catch (Exception e) {
            mediaPlayer.release();
            Log.e(f14401i, "Cannot prepare media player with SurfaceTexture: " + e);
        }
    }

    public final void mo743a(View view, Uri uri) {
        this.f14402a = view;
        this.f14403b = uri;
        setSurfaceTextureListener(this);
    }

    public int getCurrentPosition() {
        return this.f14406e != null ? this.f14406e.getCurrentPosition() : 0;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (this.f14408g) {
            mediaPlayer.start();
            this.f14408g = false;
        }
        if (this.f14409h > 0) {
            if (this.f14409h >= this.f14406e.getDuration()) {
                this.f14409h = 0;
            }
            this.f14406e.seekTo(this.f14409h);
            this.f14409h = 0;
        }
        this.f14407f = true;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f14405d = new Surface(surfaceTexture);
        m14497a();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setFrameVideoViewListener(C2005b c2005b) {
        this.f14404c = c2005b;
    }

    public void start() {
        if (this.f14407f) {
            this.f14406e.start();
        } else {
            this.f14408g = true;
        }
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }
}
