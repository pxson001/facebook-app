package com.facebook.video.engine;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.facebook.common.time.MonotonicClock;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.abtest.DirectPlayConfig;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.VideoServer;
import com.facebook.video.server.cache.PlayerReadableCache;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: config_updated_time */
public class DirectPlayMediaPlayer implements MediaPlayerWrapper {
    public static final String f18752a = DirectPlayMediaPlayer.class.getSimpleName();
    private final VideoResourceMetadata f18753b;
    public final MediaPlayer f18754c;
    private final VideoServer f18755d;
    public final Context f18756e;
    public final Uri f18757f;
    private final MonotonicClock f18758g;
    private final long f18759h;
    private final DirectPlayConfig f18760i;
    private final PlayerReadableCache f18761j;
    public final ListeningExecutorService f18762k;
    public AtomicBoolean f18763l = new AtomicBoolean(false);
    public boolean f18764m = false;

    /* compiled from: config_updated_time */
    public class C13971 implements Runnable {
        final /* synthetic */ DirectPlayMediaPlayer f18749a;

        public void run() {
            String str = DirectPlayMediaPlayer.f18752a;
            Long.valueOf(Thread.currentThread().getId());
            DirectPlayMediaPlayer.m27496a(this.f18749a, this.f18749a.f18754c, this.f18749a.f18757f);
            str = DirectPlayMediaPlayer.f18752a;
            Long.valueOf(Thread.currentThread().getId());
        }

        public C13971(DirectPlayMediaPlayer directPlayMediaPlayer) {
            this.f18749a = directPlayMediaPlayer;
        }
    }

    public DirectPlayMediaPlayer(VideoResourceMetadata videoResourceMetadata, MediaPlayer mediaPlayer, VideoServer videoServer, Context context, Uri uri, MonotonicClock monotonicClock, DirectPlayConfig directPlayConfig, PlayerReadableCache playerReadableCache, ListeningExecutorService listeningExecutorService) {
        this.f18758g = monotonicClock;
        this.f18764m = false;
        this.f18753b = videoResourceMetadata;
        this.f18754c = mediaPlayer;
        this.f18755d = videoServer;
        this.f18756e = context;
        this.f18757f = uri;
        this.f18759h = this.f18758g.now();
        this.f18760i = directPlayConfig;
        this.f18761j = playerReadableCache;
        this.f18762k = listeningExecutorService;
        if (this.f18763l.compareAndSet(false, true)) {
            this.f18764m = false;
            ExecutorDetour.a(this.f18762k, new C13971(this), 1601008724);
        }
    }

    public final void m27497a() {
        this.f18764m = true;
    }

    public static void m27496a(DirectPlayMediaPlayer directPlayMediaPlayer, MediaPlayer mediaPlayer, Uri uri) {
        Uri d = VideoServer.f(uri) ? VideoServer.d(uri) : uri;
        final MediaPlayer mediaPlayer2 = mediaPlayer;
        directPlayMediaPlayer.f18755d.a(d, 0, -1, VideoServer.g(uri), VideoServer.a(uri), new DirectPlayAsyncWriterHandler(directPlayMediaPlayer, directPlayMediaPlayer.f18761j, directPlayMediaPlayer.f18760i, directPlayMediaPlayer.f18758g.now() + "_" + Math.abs(d.hashCode()) + ".mp4", directPlayMediaPlayer.f18753b) {
            final /* synthetic */ DirectPlayMediaPlayer f18751b;

            protected final void mo1421a(String str) {
                String str2 = DirectPlayMediaPlayer.f18752a;
                mediaPlayer2.setDataSource(str);
                mediaPlayer2.prepareAsync();
            }

            protected final boolean mo1422a() {
                return this.f18751b.f18764m;
            }

            protected final void mo1423b() {
                this.f18751b.f18754c.setDataSource(this.f18751b.f18756e, this.f18751b.f18757f);
                this.f18751b.f18754c.prepareAsync();
            }
        });
        directPlayMediaPlayer.f18761j.ai_();
        directPlayMediaPlayer.f18763l.set(false);
    }

    public final MediaPlayer m27498b() {
        return this.f18754c;
    }

    public final PlayerState m27499c() {
        return PlayerState.STATE_PREPARING;
    }

    public final long m27500d() {
        return this.f18759h;
    }
}
