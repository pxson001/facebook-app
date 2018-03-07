package com.facebook.video.engine;

import android.media.MediaCodec.CryptoException;
import android.net.Uri;
import android.view.Surface;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.Assisted;
import com.facebook.video.engine.texview.exo.ExoVideoPlayer;
import com.facebook.video.view.exo.ExoPlayerStreamRendererBuilder;
import com.facebook.video.view.exo.ExoPlayerStreamRendererBuilder.BuilderCallback;
import com.facebook.video.view.exo.ExoStreamRendererEventListener;
import com.facebook.video.view.exo.PlaybackPreferences;
import com.google.android.exoplayer.DummyTrackRenderer;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.ExoPlayer.Factory;
import com.google.android.exoplayer.ExoPlayer.Listener;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecTrackRenderer.DecoderInitializationException;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.audio.AudioTrack.InitializationException;
import com.google.android.exoplayer.audio.AudioTrack.WriteException;
import com.google.android.exoplayer.chunk.ChunkSampleSource.EventListener;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.util.MimeTypes;
import java.io.IOException;
import javax.inject.Inject;

/* compiled from: composite_control_node */
public class ExoPlayerPreparer extends ExoPlayerPreparerBase {
    public static final String f18817j = ExoPlayerPreparer.class.getSimpleName();
    public final ExoPlayer f18818k = Factory.a(2, 500, 2000);
    public final ExoPlayerStreamRendererBuilder f18819l;
    public TrackRenderer f18820m;
    public TrackRenderer f18821n;
    public ExoVideoPlayer f18822o;
    public final ExoPlayerEventListener f18823p = new ExoPlayerEventListener(this);
    private final BuilderCallback f18824q = new C14021(this);

    /* compiled from: composite_control_node */
    class C14021 implements BuilderCallback {
        final /* synthetic */ ExoPlayerPreparer f18800a;

        C14021(ExoPlayerPreparer exoPlayerPreparer) {
            this.f18800a = exoPlayerPreparer;
        }

        public final void m27511a(Exception exception) {
            if (this.f18800a.f18822o != null) {
                this.f18800a.f18822o.m27598a(exception);
            } else {
                this.f18800a.m27530a(exception);
            }
        }

        public final void m27510a(MediaCodecVideoTrackRenderer mediaCodecVideoTrackRenderer, MediaCodecAudioTrackRenderer mediaCodecAudioTrackRenderer) {
            if (this.f18800a.f18822o != null) {
                this.f18800a.f18822o.m27594a(mediaCodecVideoTrackRenderer, mediaCodecAudioTrackRenderer);
                return;
            }
            ExoPlayerPreparer exoPlayerPreparer = this.f18800a;
            if (mediaCodecVideoTrackRenderer == null) {
                mediaCodecVideoTrackRenderer = new DummyTrackRenderer();
            }
            exoPlayerPreparer.f18820m = mediaCodecVideoTrackRenderer;
            exoPlayerPreparer = this.f18800a;
            if (mediaCodecAudioTrackRenderer == null) {
                mediaCodecAudioTrackRenderer = new DummyTrackRenderer();
            }
            exoPlayerPreparer.f18821n = mediaCodecAudioTrackRenderer;
            this.f18800a.c = 3;
            this.f18800a.f18818k.a(false);
            this.f18800a.f18818k.a(new TrackRenderer[]{this.f18800a.f18820m, this.f18800a.f18821n});
        }
    }

    /* compiled from: composite_control_node */
    class ChunkSampleSourceEventListener implements EventListener {
        final /* synthetic */ ExoPlayerPreparer f18801a;
        private final Uri f18802b;

        public ChunkSampleSourceEventListener(ExoPlayerPreparer exoPlayerPreparer, Uri uri) {
            this.f18801a = exoPlayerPreparer;
            this.f18802b = uri;
        }

        public final void m27514a(int i, long j, int i2, int i3) {
        }

        public final void m27513a(int i, int i2, int i3, long j, long j2) {
        }

        public final void m27517b(int i, long j) {
        }

        public final void m27516a(int i, IOException iOException) {
        }

        public final void m27512a(int i, int i2, int i3) {
        }

        public final void m27515a(int i, Format format, int i2, int i3) {
            if (this.f18801a.f18822o != null) {
                this.f18801a.f18822o.m27578a(i, format, i2, i3);
            }
        }
    }

    /* compiled from: composite_control_node */
    class ExoPlayerEventListener implements Listener {
        final /* synthetic */ ExoPlayerPreparer f18803a;

        ExoPlayerEventListener(ExoPlayerPreparer exoPlayerPreparer) {
            this.f18803a = exoPlayerPreparer;
        }

        public final void m27519a(boolean z, int i) {
            this.f18803a.d = i;
            if (i == 3 || i == 4) {
                String str = ExoPlayerPreparer.f18817j;
                Long.valueOf(this.f18803a.f18807a.now() - this.f18803a.f18815i);
                ExoPlayerPreparerBase.m27529a(i);
                Uri uri = this.f18803a.f18808b;
            }
        }

        public final void m27518a(ExoPlaybackException exoPlaybackException) {
            this.f18803a.m27530a((Exception) exoPlaybackException);
        }
    }

    /* compiled from: composite_control_node */
    class StreamRendererEventListener implements ExoStreamRendererEventListener {
        final /* synthetic */ ExoPlayerPreparer f18804a;

        StreamRendererEventListener(ExoPlayerPreparer exoPlayerPreparer) {
            this.f18804a = exoPlayerPreparer;
        }

        public final void m27526a(InitializationException initializationException) {
            if (this.f18804a.f18822o != null) {
                this.f18804a.f18822o.m27596a(initializationException);
            } else {
                this.f18804a.m27530a((Exception) initializationException);
            }
        }

        public final void m27527a(WriteException writeException) {
            if (this.f18804a.f18822o != null) {
                this.f18804a.f18822o.m27597a(writeException);
            }
        }

        public final void m27521a(int i, long j) {
            if (this.f18804a.f18822o != null) {
                this.f18804a.f18822o.m27575a(i, j);
            }
        }

        public final void m27520a(int i, int i2, float f) {
            if (this.f18804a.f18822o != null) {
                this.f18804a.f18822o.m27572a(i, i2, f);
                return;
            }
            this.f18804a.g = i;
            this.f18804a.h = i2;
        }

        public final void m27523a(Surface surface) {
            if (this.f18804a.f18822o != null) {
                this.f18804a.f18822o.m27581a(surface);
            }
        }

        public final void m27524a(DecoderInitializationException decoderInitializationException) {
            if (this.f18804a.f18822o != null) {
                this.f18804a.f18822o.m27593a(decoderInitializationException);
            } else {
                this.f18804a.m27530a((Exception) decoderInitializationException);
            }
        }

        public final void m27522a(CryptoException cryptoException) {
            if (this.f18804a.f18822o != null) {
                this.f18804a.f18822o.m27580a(cryptoException);
            }
        }

        public final void m27528a(String str, long j, long j2) {
            if (this.f18804a.f18822o != null) {
                this.f18804a.f18822o.m27599a(str, j, j2);
            }
        }

        public final void m27525a(MediaFormat mediaFormat) {
            if (this.f18804a.f18822o != null) {
                this.f18804a.f18822o.m27595a(mediaFormat);
            } else if (mediaFormat != null && mediaFormat.a != null) {
                if (MimeTypes.b(mediaFormat.a)) {
                    this.f18804a.e = mediaFormat.a;
                }
                if (MimeTypes.a(mediaFormat.a)) {
                    this.f18804a.f = mediaFormat.a;
                }
            }
        }
    }

    @Inject
    public ExoPlayerPreparer(@Assisted Uri uri, @Assisted Uri uri2, @Assisted String str, @Assisted Uri uri3, @Assisted PlaybackPreferences playbackPreferences, @Assisted boolean z, ExoPlayerBuilder exoPlayerBuilder, MonotonicClock monotonicClock) {
        super(uri, monotonicClock);
        this.f18818k.a(this.f18823p);
        this.f18819l = exoPlayerBuilder.m27509a(uri, uri2, str, playbackPreferences, new StreamRendererEventListener(this), new ChunkSampleSourceEventListener(this, uri), z);
        this.f18819l.a(this.f18824q);
    }

    public final void mo1424e() {
        this.f18818k.b(this.f18823p);
        this.f18818k.d();
    }
}
