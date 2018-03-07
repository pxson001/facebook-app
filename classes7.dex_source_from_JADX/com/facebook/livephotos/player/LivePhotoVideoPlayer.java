package com.facebook.livephotos.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.facebook.livephotos.LivePhotoView.PlaybackState;
import com.facebook.livephotos.OnPlaybackStateChanged;
import com.facebook.livephotos.exoplayer.ExoPlaybackException;
import com.facebook.livephotos.exoplayer.ExoPlayerImpl;
import com.facebook.livephotos.exoplayer.SampleSource;
import com.facebook.livephotos.exoplayer.TrackRenderer;
import com.facebook.livephotos.player.VideoCompositionRenderer.SurfaceParams;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nonnull;

@TargetApi(16)
/* compiled from: onTouchStart */
public class LivePhotoVideoPlayer implements Callback {
    private static final String f7757a = LivePhotoVideoPlayer.class.getSimpleName();
    private OnPlaybackStateChanged f7758b;
    private PlaybackState f7759c = PlaybackState.IDLE;
    private Context f7760d;
    public Handler f7761e;
    private SurfaceParams f7762f;
    public ExoPlayerImpl f7763g;
    public VideoCompositionRenderer f7764h;

    /* compiled from: onTouchStart */
    public class C06292 implements Runnable {
        final /* synthetic */ ExoPlaybackException f7755a;
        final /* synthetic */ LivePhotoVideoPlayer f7756b;

        public C06292(LivePhotoVideoPlayer livePhotoVideoPlayer, ExoPlaybackException exoPlaybackException) {
            this.f7756b = livePhotoVideoPlayer;
            this.f7755a = exoPlaybackException;
        }

        public void run() {
            LivePhotoVideoPlayer livePhotoVideoPlayer = this.f7756b;
            ExoPlaybackException exoPlaybackException = this.f7755a;
        }
    }

    public LivePhotoVideoPlayer(Context context, Handler handler, OnPlaybackStateChanged onPlaybackStateChanged) {
        this.f7760d = context;
        this.f7761e = handler;
        this.f7758b = onPlaybackStateChanged;
    }

    private void m9378a(PlaybackState playbackState) {
        this.f7759c = playbackState;
        this.f7758b.mo362a(playbackState);
    }

    private void m9380b(Uri uri) {
        this.f7763g = new ExoPlayerImpl(4, 0, 0);
        this.f7763g.f6711c.add(this);
        this.f7764h = new VideoCompositionRenderer(this.f7763g);
        Context context = this.f7760d;
        SampleSource a = TrackContext.m9395a(context, uri);
        TrackContext trackContext = new TrackContext(new PrerollTrackRenderer(context, a, null, null), new PrerollAudioTrackRenderer(a));
        TrackContext a2 = TrackContext.m9396a(uri, this.f7760d, this.f7761e, this.f7764h);
        TrackContext[] trackContextArr = new TrackContext[]{trackContext, a2};
        this.f7764h.f7785j = trackContextArr;
        this.f7763g.m8578a(trackContext.f7771e, a2.f7771e, trackContext.f7772f, this.f7764h);
        this.f7763g.m8577a(true);
        m9381c();
    }

    public final void m9383a(@Nonnull Uri uri) {
        if (this.f7759c == PlaybackState.IDLE) {
            m9378a(PlaybackState.PREPARING);
            m9380b(uri);
        }
    }

    public final void m9385b() {
        if (this.f7763g != null) {
            this.f7763g.f6711c.remove(this);
            this.f7763g.f6710b.f6717a.sendEmptyMessage(4);
            ExoPlayerImpl exoPlayerImpl = this.f7763g;
            exoPlayerImpl.f6710b.m8600b();
            exoPlayerImpl.f6709a.removeCallbacksAndMessages(null);
            this.f7763g = null;
            this.f7764h = null;
            m9378a(PlaybackState.IDLE);
        }
    }

    public synchronized void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public synchronized void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f7762f = new SurfaceParams(surfaceHolder, i2, i3);
        m9381c();
    }

    private void m9381c() {
        ExoPlayerImpl exoPlayerImpl = this.f7763g;
        TrackRenderer trackRenderer = this.f7764h;
        if (exoPlayerImpl != null && trackRenderer != null) {
            exoPlayerImpl.m8576a(trackRenderer, 2, this.f7762f);
        }
    }

    public synchronized void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f7762f = null;
        m9381c();
    }

    public final void m9384a(final boolean z, final int i) {
        if (m9382d()) {
            m9377a(i);
        } else {
            HandlerDetour.a(this.f7761e, new Runnable(this) {
                final /* synthetic */ LivePhotoVideoPlayer f7754c;

                public void run() {
                    this.f7754c.m9377a(i);
                }
            }, -492206032);
        }
    }

    private void m9377a(int i) {
        Integer.valueOf(i);
        switch (i) {
            case 4:
                m9378a(PlaybackState.PLAYING);
                return;
            case 5:
                m9385b();
                m9378a(PlaybackState.IDLE);
                return;
            default:
                return;
        }
    }

    public static boolean m9382d() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
