package com.facebook.video.engine.texview;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.abtest.DirectPlayConfig;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.StallTimeCalculation;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.analytics.VideoAnalytics.StreamingFormat;
import com.facebook.video.api.AsyncVideo$PlayPausedEvent;
import com.facebook.video.api.AsyncVideo$PlayRequestedEvent;
import com.facebook.video.api.AsyncVideo$PlayStartedEvent;
import com.facebook.video.api.UserReason;
import com.facebook.video.api.VideoEvents$StartingEvent;
import com.facebook.video.api.VideoMetadata;
import com.facebook.video.api.VideoReason;
import com.facebook.video.api.playersession.MediaPlayerSession;
import com.facebook.video.api.playersession.VideoPlayerSessionManager;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.DelayedCompletionHandler;
import com.facebook.video.engine.DelayedCompletionHandler.DelayedCompletionListener;
import com.facebook.video.engine.DirectPlayMediaPlayer;
import com.facebook.video.engine.MediaPlayerWrapper;
import com.facebook.video.engine.NativePlayerPool;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoEngineUtils;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.engine.VideoPlayer.VideoSourceType;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerViewProvider;
import com.facebook.video.engine.VideoRenderUtils;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.engine.texview.BaseVideoPlayer.ReleaseCaller;
import com.facebook.video.engine.texview.BaseVideoPlayer.SurfaceState;
import com.facebook.video.engine.texview.VideoSurfaceTarget.C02403;
import com.facebook.video.engine.texview.VideoSurfaceTarget.SurfaceListener;
import com.facebook.video.server.BytesViewedLogger;
import com.facebook.video.server.VideoMimes;
import com.facebook.video.server.VideoResourceMetadata;
import com.facebook.video.server.VideoServer;
import com.facebook.video.subtitles.controller.SubtitleAdapter;
import com.facebook.video.subtitles.controller.SubtitleListener;
import com.facebook.video.subtitles.controller.SubtitleMediaTimeProvider;
import com.facebook.video.subtitles.controller.SubtitleText;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.video.subtitles.controller.compat.CustomSubtitleAdapter;
import com.facebook.video.view.ImplementationEvents.AllocationBeginEvent;
import com.facebook.video.view.ImplementationEvents.AllocationEndEvent;
import com.facebook.video.view.ImplementationEvents.PreparationBeginEvent;
import com.facebook.video.view.ImplementationEvents.PreparationEndEvent;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;

@TargetApi(14)
/* compiled from: pending_media_uploads. */
public class TextureViewVideoPlayer extends BaseVideoPlayer implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnSeekCompleteListener, OnVideoSizeChangedListener, DelayedCompletionListener, SubtitleListener {
    private static final Class f5203V = TextureViewVideoPlayer.class;
    private final DeviceConditionHelper f5204W;
    private final ListeningExecutorService f5205X;
    private final int f5206Y;
    private final DirectPlayConfig f5207Z;
    public MediaPlayer aa;
    private float ab;
    private Uri ac;
    private Uri ad;
    private Uri ae;
    private int af;
    private int ag;
    private int ah;
    private VideoResolution ai;
    private int aj = 0;
    public int ak;
    private int al;
    private VideoPlayerSessionManager am;
    private StallTimeCalculation an;
    private long ao = -1;
    private VideoSurfaceTarget ap;
    private final VideoSurfaceListener aq = new VideoSurfaceListener(this);
    private MediaPlayerWrapper ar;
    private final boolean as;
    private boolean at = false;
    private final DelayedCompletionHandler au = new DelayedCompletionHandler();
    private final GatekeeperStoreImpl av;
    private int aw;

    /* compiled from: pending_media_uploads. */
    class VideoSurfaceListener implements SurfaceListener {
        final /* synthetic */ TextureViewVideoPlayer f5269a;

        public VideoSurfaceListener(TextureViewVideoPlayer textureViewVideoPlayer) {
            this.f5269a = textureViewVideoPlayer;
        }

        public final void mo517a(Surface surface) {
            this.f5269a.mo484a("MediaPlayer::VideoSurfaceTarget::onSurfaceAvailable", new Object[0]);
            this.f5269a.I = surface;
            this.f5269a.mo488b(surface);
            this.f5269a.T = SurfaceState.STATE_CREATED;
        }

        public final void mo518a(C02403 c02403) {
            this.f5269a.mo484a("MediaPlayer::VideoSurfaceTarget::onSurfaceUnavailable", new Object[0]);
            if (this.f5269a.mo506i()) {
                this.f5269a.mo490c(EventTriggerType.BY_PLAYER);
            }
            this.f5269a.mo498w();
            this.f5269a.mo480a(ReleaseCaller.FROM_DESTROY_SURFACE);
            this.f5269a.I = null;
            this.f5269a.T = SurfaceState.STATE_DESTROYED;
            c02403.m6168a();
        }

        public final void mo516a() {
            this.f5269a.mo497v();
        }

        public final void mo519b() {
            this.f5269a.K = this.f5269a.f5241m.now();
            if (this.f5269a.f5220L) {
                this.f5269a.f5235g.a(this.f5269a.f5253y.value, this.f5269a.f5218J.f4833b, this.f5269a.f5251w, this.f5269a.f5254z.value, this.f5269a.mo496r());
                this.f5269a.L = false;
                if (this.f5269a.f5234f != null) {
                    this.f5269a.f5234f.mo456c(this.f5269a.f5221M);
                }
            }
            this.f5269a.T = SurfaceState.STATE_UPDATED;
        }
    }

    protected final void m5672C() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r1 = 1;
        r4 = 0;
        r0 = "Retry loading video: %s";
        r1 = new java.lang.Object[r1];
        r2 = r5.ac;
        r1[r4] = r2;
        r5.mo484a(r0, r1);
        r0 = r5.f5242n;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r1 = r5.ac;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r0.m5633a(r1);	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r0 = r5.f5242n;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r1 = r5.af;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r0.m5631a(r1);	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r0 = r5.ac;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r1 = r5.f5207Z;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r1 = r1.f5263g;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r5.m5656a(r0, r1);	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r5.at = r4;
    L_0x0026:
        return;
    L_0x0027:
        r0 = move-exception;
        r0 = "Caught IOException - Unable to open content %s";	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r1 = 1;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r1 = new java.lang.Object[r1];	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r2 = 0;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r3 = r5.ac;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r1[r2] = r3;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r5.mo484a(r0, r1);	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r0 = 0;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r5.at = r0;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r0 = r5.aa;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r1 = 1;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r2 = 0;	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r5.onError(r0, r1, r2);	 Catch:{ IOException -> 0x0027, all -> 0x0042 }
        r5.at = r4;
        goto L_0x0026;
    L_0x0042:
        r0 = move-exception;
        r5.at = r4;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.texview.TextureViewVideoPlayer.C():void");
    }

    public TextureViewVideoPlayer(Context context, AttributeSet attributeSet, int i, VideoPlayerViewProvider videoPlayerViewProvider, Lazy<NativePlayerPool> lazy, VideoPlayerListener videoPlayerListener, SubtitleListener subtitleListener, VideoLoggingUtils videoLoggingUtils, SubtitleAdapter subtitleAdapter, SubtitleMediaTimeProvider subtitleMediaTimeProvider, DeviceConditionHelper deviceConditionHelper, ScheduledExecutorService scheduledExecutorService, ListeningExecutorService listeningExecutorService, Boolean bool, boolean z, AndroidThreadUtil androidThreadUtil, VideoPlayerSessionManager videoPlayerSessionManager, MonotonicClock monotonicClock, InitializationSequenceLogger initializationSequenceLogger, BytesViewedLogger bytesViewedLogger, VideoEngineUtils videoEngineUtils, boolean z2, DirectPlayConfig directPlayConfig, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        super(context, attributeSet, i, videoPlayerViewProvider, lazy, videoPlayerListener, subtitleListener, subtitleAdapter, scheduledExecutorService, androidThreadUtil, bool, z, monotonicClock, initializationSequenceLogger, videoEngineUtils, bytesViewedLogger, videoLoggingUtils, qeAccessor, gatekeeperStore, videoLivePlaybackConfig);
        this.f5204W = deviceConditionHelper;
        this.f5205X = listeningExecutorService;
        this.f5206Y = SizeUtil.a(this.f5230b, 300.0f);
        this.f5207Z = directPlayConfig;
        this.f5236h.m5642a((SubtitleListener) this);
        this.f5236h.m5643a(subtitleMediaTimeProvider);
        this.ak = -1;
        this.J = VideoPlayerParams.newBuilder().m5271m();
        this.am = videoPlayerSessionManager;
        this.an = new StallTimeCalculation(this.f5241m);
        m5708a(this.f5212D);
        m5713b(this.f5213E);
        this.f5244p.m5595a(this.f5245q);
        this.f5242n.m5634a(this.f5245q);
        this.as = z2;
        this.av = gatekeeperStore;
        this.aw = 1;
    }

    private static void m5654a(MediaPlayer mediaPlayer, TextureViewVideoPlayer textureViewVideoPlayer) {
        mediaPlayer.setOnBufferingUpdateListener(textureViewVideoPlayer);
        mediaPlayer.setOnCompletionListener(textureViewVideoPlayer);
        mediaPlayer.setOnErrorListener(textureViewVideoPlayer);
        mediaPlayer.setOnInfoListener(textureViewVideoPlayer);
        mediaPlayer.setOnPreparedListener(textureViewVideoPlayer);
        mediaPlayer.setOnSeekCompleteListener(textureViewVideoPlayer);
        mediaPlayer.setOnVideoSizeChangedListener(textureViewVideoPlayer);
    }

    private void m5656a(Uri uri, boolean z) {
        this.f5245q.a(new AllocationBeginEvent());
        if (this.aa != null) {
            m5660a(ReleaseCaller.FROM_PREPARE, z);
        }
        mo484a("Allocate new media player", new Object[0]);
        boolean a = this.f5235g.a(this.f5218J.f4833b, this.ak);
        int i = ((this.f5207Z.f5264h || this.f5253y == PlayerType.INLINE_PLAYER) && ((this.f5207Z.f5266j || !this.f5218J.f4837f) && this.f5218J.f4850s == null)) ? 1 : 0;
        if (a && VideoServer.f(uri) && ((this.ak == -1 || this.ak == 0) && i != 0)) {
            a = true;
        } else {
            a = false;
        }
        VideoResourceMetadata videoResourceMetadata = new VideoResourceMetadata(uri, this.f5218J.f4833b);
        videoResourceMetadata.d = (long) this.f5218J.f4849r;
        videoResourceMetadata.e = (long) this.af;
        videoResourceMetadata.f = (long) this.f5218J.f4834c;
        String str = "Allocating media player to stream from %s";
        Object[] objArr = new Object[1];
        objArr[0] = a ? "file" : "http";
        mo484a(str, objArr);
        MediaPlayerWrapper a2 = ((NativePlayerPool) this.f5238j.get()).a(uri, videoResourceMetadata, a);
        this.ar = a2;
        this.aa = a2.mo522b();
        mo484a("Using MediaPlayer from pool, state (%s), prepared for (%s ms), uri (%s)", a2.mo523c(), Long.valueOf(this.f5241m.now() - a2.mo524d()), uri);
        m5708a(a2.mo523c());
        m5654a(this.aa, this);
        this.aa.setAudioStreamType(3);
        m5661b(this.ab);
        if (this.f5217I != null) {
            m5658a(this.f5217I, SurfaceState.STATE_CREATED);
        }
        this.al = 0;
        this.f5245q.a(new AllocationEndEvent());
        if (this.f5212D == PlayerState.STATE_PREPARED) {
            onPrepared(this.aa);
        }
    }

    private void m5659a(VideoError videoError) {
        this.f5234f.mo453a(this.f5215G, videoError);
    }

    private void m5649D() {
        if (this.av.a(VideoAbTestGatekeepers.e) != TriState.YES) {
            m5692c();
        } else {
            ExecutorDetour.a(this.f5239k, new 1(this), -455631779);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.google.common.annotations.VisibleForTesting
    final void m5692c() {
        /*
        r12 = this;
        r11 = 1;
        r10 = 0;
        r0 = r12.m5650E();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = "Initializing media player";
        r1 = new java.lang.Object[r10];
        r12.mo484a(r0, r1);
        r1 = r10;
    L_0x0011:
        r0 = r12.ac;	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        if (r0 == 0) goto L_0x0053;
    L_0x0015:
        r0 = "Set data source = %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r3 = 0;
        r4 = r12.ac;	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r2[r3] = r4;	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r12.mo484a(r0, r2);	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r0 = r12.f5242n;	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r2 = r12.ac;	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r0.m5633a(r2);	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r0 = r12.f5242n;	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r2 = r12.af;	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r0.m5631a(r2);	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r0 = r12.ac;	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        r2 = 0;
        r12.m5656a(r0, r2);	 Catch:{ IOException -> 0x0037, NullPointerException -> 0x006f, IllegalStateException -> 0x007f }
        goto L_0x0008;
    L_0x0037:
        r0 = move-exception;
        r2 = "dataSourceIoException";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ IllegalStateException -> 0x007f, IOException -> 0x00b8, NullPointerException -> 0x00ea }
        r12.mo484a(r2, r3);	 Catch:{ IllegalStateException -> 0x007f, IOException -> 0x00b8, NullPointerException -> 0x00ea }
        r2 = r12.ac;	 Catch:{ IllegalStateException -> 0x007f, IOException -> 0x00b8, NullPointerException -> 0x00ea }
        r2 = com.facebook.video.server.VideoServer.f(r2);	 Catch:{ IllegalStateException -> 0x007f, IOException -> 0x00b8, NullPointerException -> 0x00ea }
        if (r2 == 0) goto L_0x00b1;
    L_0x0048:
        r0 = r12.ac;	 Catch:{ IllegalStateException -> 0x007f, IOException -> 0x00b8, NullPointerException -> 0x00ea }
        r0 = com.facebook.video.server.VideoServer.e(r0);	 Catch:{ IllegalStateException -> 0x007f, IOException -> 0x00b8, NullPointerException -> 0x00ea }
        r12.ac = r0;	 Catch:{ IllegalStateException -> 0x007f, IOException -> 0x00b8, NullPointerException -> 0x00ea }
    L_0x0050:
        if (r1 != 0) goto L_0x0011;
    L_0x0052:
        goto L_0x0008;
    L_0x0053:
        r0 = "Data source is invalid. Try next one.";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{  }
        r12.mo484a(r0, r2);	 Catch:{  }
        r1 = r12.m5651F();	 Catch:{  }
        if (r1 != 0) goto L_0x0050;
    L_0x0061:
        r0 = "No data source!";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{  }
        r12.mo484a(r0, r2);	 Catch:{  }
        r0 = com.facebook.video.engine.Constants.VideoError.NO_SOURCE;	 Catch:{  }
        r12.m5659a(r0);	 Catch:{  }
        goto L_0x0050;
    L_0x006f:
        r0 = move-exception;
        r1 = "dataSourceNPE";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{  }
        r12.mo484a(r1, r2);	 Catch:{  }
        r1 = r12.m5651F();	 Catch:{  }
        if (r1 != 0) goto L_0x0050;
    L_0x007e:
        throw r0;	 Catch:{  }
    L_0x007f:
        r9 = move-exception;
        r0 = r12.f5235g;
        r1 = r9.getMessage();
        r2 = r12.f5253y;
        r2 = r2.value;
        r3 = r12.f5218J;
        r3 = r3.f4833b;
        r4 = r12.ac;
        r5 = r12.f5254z;
        r5 = r5.value;
        r6 = r12.f5251w;
        r7 = r12.mo496r();
        r8 = r12.f5218J;
        r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r0 = "Caught IllegalStateException - Unable to open content %s";
        r1 = new java.lang.Object[r11];
        r2 = r12.ac;
        r1[r10] = r2;
        r12.mo484a(r0, r1);
        r0 = r12.aa;
        r12.onError(r0, r11, r10);
        goto L_0x0008;
    L_0x00b1:
        r1 = r12.m5651F();	 Catch:{  }
        if (r1 != 0) goto L_0x0050;
    L_0x00b7:
        throw r0;	 Catch:{  }
    L_0x00b8:
        r9 = move-exception;
        r0 = r12.f5235g;
        r1 = r9.getMessage();
        r2 = r12.f5253y;
        r2 = r2.value;
        r3 = r12.f5218J;
        r3 = r3.f4833b;
        r4 = r12.ac;
        r5 = r12.f5254z;
        r5 = r5.value;
        r6 = r12.f5251w;
        r7 = r12.mo496r();
        r8 = r12.f5218J;
        r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r0 = "Caught IOException - Unable to open content %s";
        r1 = new java.lang.Object[r11];
        r2 = r12.ac;
        r1[r10] = r2;
        r12.mo484a(r0, r1);
        r0 = r12.aa;
        r12.onError(r0, r11, r10);
        goto L_0x0008;
    L_0x00ea:
        r9 = move-exception;
        r0 = r12.f5235g;
        r1 = r9.getMessage();
        r2 = r12.f5253y;
        r2 = r2.value;
        r3 = r12.f5218J;
        r3 = r3.f4833b;
        r4 = r12.ac;
        r5 = r12.f5254z;
        r5 = r5.value;
        r6 = r12.f5251w;
        r7 = r12.mo496r();
        r8 = r12.f5218J;
        r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        r0 = "Caught NullPointerException - Unable to open content %s";
        r1 = new java.lang.Object[r11];
        r2 = r12.ac;
        r1[r10] = r2;
        r12.mo484a(r0, r1);
        r0 = r12.aa;
        r12.onError(r0, r11, r10);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.texview.TextureViewVideoPlayer.c():void");
    }

    public final void mo493f() {
        mo480a(ReleaseCaller.EXTERNAL);
    }

    protected final void mo480a(ReleaseCaller releaseCaller) {
        m5660a(releaseCaller, false);
    }

    private void m5660a(ReleaseCaller releaseCaller, boolean z) {
        this.G = "release";
        mo484a("release: %s, preserveTarget=%s", releaseCaller, Boolean.valueOf(z));
        this.F = null;
        this.f5244p.m5594a();
        if (this.f5236h != null) {
            this.f5236h.m5647d();
        }
        if (this.aa != null) {
            m5708a(PlayerState.STATE_IDLE);
            if (!z) {
                m5713b(PlayerState.STATE_IDLE);
            }
            m5654a(this.aa, null);
            m5657a(null);
            m5655a(this.aa, m5653H());
            this.aa = null;
            this.al = 0;
            this.ak = -1;
        }
        if (this.ar != null) {
            this.ar.mo521a();
            this.ar = null;
        }
        this.au.removeMessages(DelayedCompletionHandler.f5270a);
    }

    public final void mo474a(EventTriggerType eventTriggerType) {
        mo476a(eventTriggerType, PlayPosition.f5359a);
    }

    public final void mo476a(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        int b = this.ak != -1 ? this.ak : mo487b();
        if (playPosition.m5853b()) {
            b = playPosition.f5362d;
        }
        this.f5245q.a(new AsyncVideo$PlayRequestedEvent(b, UserReason.f5368b));
        this.G = "play";
        mo484a("%s, %s", this.f5215G, eventTriggerType.value);
        if (playPosition.m5853b()) {
            this.ak = playPosition.f5361c;
        }
        b = this.f5213E == PlayerState.STATE_PLAYING ? 1 : 0;
        m5663c(eventTriggerType, playPosition);
        if (m5653H()) {
            m5662b(eventTriggerType, playPosition);
            m5664d(eventTriggerType, playPosition);
            return;
        }
        if (b == 0) {
            m5662b(eventTriggerType, playPosition);
        }
        m5649D();
    }

    private boolean m5650E() {
        return this.f5212D == PlayerState.STATE_PREPARING || this.f5212D == PlayerState.STATE_PREPARED;
    }

    private void m5662b(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        this.an.a();
        this.an.b();
        if (!m5670l(eventTriggerType)) {
            int i;
            VideoLoggingUtils videoLoggingUtils = this.f5235g;
            ArrayNode arrayNode = this.f5218J.f4836e;
            String str = this.f5253y.value;
            String str2 = eventTriggerType.value;
            if (playPosition != PlayPosition.f5359a) {
                i = playPosition.f5361c;
            } else {
                i = mo487b();
            }
            videoLoggingUtils.a(arrayNode, str, str2, i, this.f5227S.value, this.f5218J.f4833b, this.f5251w, null, this.f5254z.value, mo496r(), this.f5252x, this.f5218J.f4837f, this.f5218J.f4835d, this.f5218J);
        }
    }

    private void m5663c(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        this.R = eventTriggerType;
        this.C = playPosition;
        m5713b(PlayerState.STATE_PLAYING);
    }

    private void m5664d(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        int i;
        int b;
        Message obtainMessage;
        Preconditions.checkNotNull(playPosition);
        Preconditions.checkArgument(this.f5213E == PlayerState.STATE_PLAYING);
        this.L = true;
        this.M = eventTriggerType;
        this.T = SurfaceState.STATE_UNKNOWN;
        this.K = -1;
        this.f5245q.a(new VideoEvents$StartingEvent(playPosition.f5361c, UserReason.f5368b));
        this.f5234f.mo449a(eventTriggerType, true);
        if (m5735y()) {
            if (this.ak != -1) {
                mo484a("Seek to: %s", Integer.valueOf(this.ak));
                this.aa.seekTo(this.ak);
                i = this.ak;
            } else if (this.f5218J.f4843l > 0) {
                i = this.f5218J.f4843l + mo487b();
                mo484a("Seek to: %s", Integer.valueOf(i));
                this.aa.seekTo(i);
            }
            mo497v();
            this.aa.start();
            this.an.c();
            m5708a(PlayerState.STATE_PLAYING);
            if (this.f5236h != null) {
                this.f5236h.m5645b();
            }
            if (i != -1) {
                b = mo487b();
            } else {
                b = i;
            }
            if (this.f5218J.f4844m > 0 && this.f5218J.f4844m < this.aa.getDuration()) {
                obtainMessage = this.au.obtainMessage(DelayedCompletionHandler.f5270a);
                obtainMessage.obj = this;
                obtainMessage.arg1 = this.aa.hashCode();
                this.au.sendMessageDelayed(obtainMessage, (long) (this.f5218J.f4844m - b));
            }
            this.ak = -1;
            if (m5670l(eventTriggerType)) {
                mo475a(eventTriggerType, b);
            } else {
                this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, b, this.f5218J.f4833b, this.f5251w, this.f5254z.value, this.f5218J.f4837f);
            }
            this.f5245q.a(new AsyncVideo$PlayStartedEvent(b, b, UserReason.f5368b));
            this.f5244p.m5594a();
            this.an.a();
            if (playPosition.m5852a()) {
                this.B = playPosition.f5362d;
            } else if (!m5670l(eventTriggerType)) {
                this.B = b;
            }
            this.ao = this.f5241m.now();
        }
        i = -1;
        mo497v();
        this.aa.start();
        this.an.c();
        m5708a(PlayerState.STATE_PLAYING);
        if (this.f5236h != null) {
            this.f5236h.m5645b();
        }
        if (i != -1) {
            b = i;
        } else {
            b = mo487b();
        }
        obtainMessage = this.au.obtainMessage(DelayedCompletionHandler.f5270a);
        obtainMessage.obj = this;
        obtainMessage.arg1 = this.aa.hashCode();
        this.au.sendMessageDelayed(obtainMessage, (long) (this.f5218J.f4844m - b));
        this.ak = -1;
        if (m5670l(eventTriggerType)) {
            mo475a(eventTriggerType, b);
        } else {
            this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, b, this.f5218J.f4833b, this.f5251w, this.f5254z.value, this.f5218J.f4837f);
        }
        this.f5245q.a(new AsyncVideo$PlayStartedEvent(b, b, UserReason.f5368b));
        this.f5244p.m5594a();
        this.an.a();
        if (playPosition.m5852a()) {
            this.B = playPosition.f5362d;
        } else if (m5670l(eventTriggerType)) {
            this.B = b;
        }
        this.ao = this.f5241m.now();
    }

    public final void mo489b(EventTriggerType eventTriggerType) {
        this.f5244p.m5594a();
        this.G = "stop";
        mo484a("%s, %s", this.f5215G, eventTriggerType.value);
        if (this.ar != null) {
            this.ar.mo521a();
            this.ar = null;
        }
        if (this.f5212D == PlayerState.STATE_PREPARING) {
            this.f5226R = eventTriggerType;
            m5713b(PlayerState.STATE_IDLE);
        } else if (m5653H()) {
            this.f5234f.mo464c(eventTriggerType, true);
            this.am.a(VideoServer.a(this.ac));
            m5667i(eventTriggerType);
            this.f5234f.mo448a(eventTriggerType);
        }
        this.ao = -1;
    }

    private void m5667i(EventTriggerType eventTriggerType) {
        mo484a("resetNow: getting rid of the player in a separate thread", new Object[0]);
        m5654a(this.aa, null);
        m5655a(this.aa, m5653H());
        this.aa = null;
        if (this.ar != null) {
            this.ar.mo521a();
            this.ar = null;
        }
        mo484a("resetNow: MediaPlayer is null (and soon to be released)", new Object[0]);
        m5708a(PlayerState.STATE_IDLE);
        m5713b(PlayerState.STATE_IDLE);
        this.al = 0;
        this.ao = -1;
        if (this.f5236h != null) {
            this.f5236h.m5647d();
        }
        if (eventTriggerType != EventTriggerType.BY_AUTOPLAY) {
            this.f5235g.b(this.f5218J.f4836e, this.f5253y.value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, mo487b(), this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, this.f5218J.f4837f);
        }
        this.B = 0;
    }

    public final void mo490c(EventTriggerType eventTriggerType) {
        super.mo490c(eventTriggerType);
        m5668j(eventTriggerType);
    }

    private void m5668j(EventTriggerType eventTriggerType) {
        this.f5244p.m5594a();
        if (this.f5249u || this.al > 99) {
            this.ak = -1;
            m5669k(eventTriggerType);
        } else if (this.f5212D == PlayerState.STATE_PREPARING) {
            mo484a("current state = %s, seek time = %s", this.f5212D, Integer.valueOf(this.ak));
            if ((this.f5211C != null ? 1 : null) != null) {
                this.B = this.f5211C.f5362d;
                this.ak = this.f5211C.f5361c;
                this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, this.ak, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, mo496r(), this.f5218J.f4837f, null, this.f5218J);
            }
            mo489b(eventTriggerType);
        } else {
            if (!eventTriggerType.value.equals(EventTriggerType.BY_ANDROID.value)) {
                this.ak = mo487b();
                if ((this.ao != -1 && this.f5241m.now() - this.ao < 1000) || this.ak < this.f5210B) {
                    this.ak = this.f5210B;
                }
            }
            mo484a("stop-for-pause: %s, seek time = %s", eventTriggerType.value, Integer.valueOf(this.ak));
            if (!m5670l(eventTriggerType)) {
                this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, this.ak, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, mo496r(), this.f5218J.f4837f, null, this.f5218J);
            }
            this.f5245q.a(new AsyncVideo$PlayPausedEvent(this.ak, UserReason.f5368b));
            mo489b(eventTriggerType);
        }
        m5702A();
        this.ao = -1;
    }

    private void m5669k(EventTriggerType eventTriggerType) {
        this.G = "pause";
        mo484a("%s, %s", this.f5215G, eventTriggerType.value);
        if (this.f5212D == PlayerState.STATE_PAUSED) {
            m5713b(PlayerState.STATE_PAUSED);
        } else if (this.f5212D == PlayerState.STATE_PREPARING) {
            mo531f(eventTriggerType);
        } else if (m5653H()) {
            this.f5234f.mo462b(eventTriggerType, true);
            mo494g(eventTriggerType);
            this.f5234f.mo454b(eventTriggerType);
        }
    }

    private static boolean m5670l(EventTriggerType eventTriggerType) {
        return BaseVideoPlayer.f5208a.contains(eventTriggerType);
    }

    @VisibleForTesting
    protected final void mo494g(EventTriggerType eventTriggerType) {
        mo484a("pauseNow: %s", eventTriggerType.value);
        this.aa.pause();
        m5708a(PlayerState.STATE_PAUSED);
        m5713b(PlayerState.STATE_PAUSED);
        if (this.f5236h != null) {
            this.f5236h.m5646c();
        }
        if (this.f5248t.booleanValue() && eventTriggerType == EventTriggerType.BY_USER && this.f5234f != null) {
            this.f5234f.mo463c();
            if (this.ap.m14926d()) {
                mo510n();
                double a = VideoRenderUtils.m6002a(this.f5206Y, this.ap.m14928h(), this.ap.m14929i());
                this.H = this.ap.m14921a(a, a);
                this.f5234f.mo447a(this.f5216H);
            }
        }
        int b = mo487b();
        if (m5670l(eventTriggerType)) {
            this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, b, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, this.f5218J.f4837f);
        } else {
            this.f5235g.b(this.f5218J.f4836e, this.f5253y.value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, b, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, mo496r(), this.f5218J.f4837f, null, this.f5218J);
        }
        this.f5245q.a(new AsyncVideo$PlayPausedEvent(b, UserReason.f5368b));
        this.au.removeMessages(DelayedCompletionHandler.f5270a);
    }

    public final void mo473a(int i, EventTriggerType eventTriggerType) {
        this.G = "seekTo";
        mo484a("%s, %s", this.f5215G, eventTriggerType);
        this.B = i;
        switch (this.f5212D) {
            case STATE_PREPARING:
                this.ak = i;
                return;
            case STATE_IDLE:
                this.ak = i;
                return;
            default:
                if (m5653H() && m5735y()) {
                    if (this.aa != null) {
                        this.aa.seekTo(i);
                    }
                    if (this.f5236h != null) {
                        this.f5236h.m5641a(i);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public final void mo485a(boolean z, EventTriggerType eventTriggerType) {
        this.G = "mute";
        m5661b(z ? 0.0f : 1.0f);
    }

    public final void mo471a(float f) {
        this.G = "setVolume";
        m5661b(f);
    }

    private void m5661b(float f) {
        this.ab = Math.max(0.0f, Math.min(1.0f, f));
        if (this.aa != null) {
            this.aa.setVolume(this.ab, this.ab);
        }
    }

    public final void mo479a(VideoResolution videoResolution, EventTriggerType eventTriggerType) {
        this.G = "setVideoResolution";
        mo484a(this.f5215G, new Object[0]);
        this.ai = videoResolution;
        Queue linkedList = new LinkedList();
        if (videoResolution == VideoResolution.HIGH_DEFINITION) {
            this.ac = this.ae;
            this.af = this.ah;
            linkedList.add(this.ae);
            linkedList.add(this.ad);
        } else {
            this.ac = this.ad;
            this.af = this.ag;
            linkedList.add(this.ad);
            linkedList.add(this.ae);
        }
        if (this.aa != null) {
            boolean isPlaying = this.aa.isPlaying();
            if (isPlaying) {
                mo490c(EventTriggerType.BY_PLAYER);
                this.ak = mo487b();
            }
            while (!linkedList.isEmpty()) {
                try {
                    Uri uri = (Uri) linkedList.poll();
                    try {
                        this.aa.reset();
                        this.f5242n.m5633a(uri);
                        this.f5242n.m5631a(this.af);
                        this.aa.setDataSource(this.f5230b.getApplicationContext(), uri);
                        m5652G();
                        if (isPlaying) {
                            m5663c(EventTriggerType.BY_PLAYER, PlayPosition.f5359a);
                            return;
                        } else {
                            m5669k(EventTriggerType.BY_PLAYER);
                            return;
                        }
                    } catch (IOException e) {
                        if (linkedList.isEmpty()) {
                            throw e;
                        }
                    } catch (NullPointerException e2) {
                        if (linkedList.isEmpty()) {
                            throw e2;
                        }
                    } catch (Exception e3) {
                        this.f5235g.a(e3.getMessage(), this.f5253y.value, this.f5218J.f4833b, this.ac, this.f5254z.value, this.f5251w, mo496r(), this.f5218J, e3);
                        mo484a("Caught IllegalStateException - Unable to open content %s", this.ac);
                        onError(this.aa, 1, 0);
                        return;
                    }
                } catch (Exception e32) {
                    this.f5235g.a(e32.getMessage(), this.f5253y.value, this.f5218J.f4833b, this.ac, this.f5254z.value, this.f5251w, mo496r(), this.f5218J, e32);
                    mo484a("Caught IllegalStateException - Unable to open content %s", this.ac);
                    onError(this.aa, 1, 0);
                    return;
                } catch (Exception e322) {
                    this.f5235g.a(e322.getMessage(), this.f5253y.value, this.f5218J.f4833b, this.ac, this.f5254z.value, this.f5251w, mo496r(), this.f5218J, e322);
                    mo484a("Caught IOException - Unable to open content %s", this.ac);
                    onError(this.aa, 1, 0);
                    return;
                } catch (Exception e3222) {
                    this.f5235g.a(e3222.getMessage(), this.f5253y.value, this.f5218J.f4833b, this.ac, this.f5254z.value, this.f5251w, mo496r(), this.f5218J, e3222);
                    mo484a("Caught NullPointerException - Unable to open content %s", this.ac);
                    onError(this.aa, 1, 0);
                    return;
                }
            }
        }
    }

    public final void mo477a(VideoSourceType videoSourceType, String str, EventTriggerType eventTriggerType) {
    }

    public final VideoResolution mo492e() {
        return this.ai;
    }

    public final void mo478a(VideoPlayerParams videoPlayerParams) {
        this.G = "bindVideoSources";
        mo484a("bindVideoSources: %s", Integer.valueOf(videoPlayerParams.f4832a.size()));
        this.J = videoPlayerParams;
        this.ak = this.f5218J.f4843l;
        this.f5244p.m5594a();
        this.ag = this.f5218J.f4847p;
        this.ah = this.f5218J.f4848q;
        this.ad = null;
        this.ae = null;
        this.ai = VideoResolution.STANDARD_DEFINITION;
        this.aw = 1;
        if (this.f5218J.f4832a.isEmpty()) {
            mo484a("bindVideoSources: No valid video paths", new Object[0]);
            mo480a(ReleaseCaller.FROM_BIND);
            this.aj = -1;
            this.ac = null;
            this.S = StreamSourceType.FROM_STREAM;
            return;
        }
        this.aj = 0;
        VideoDataSource videoDataSource = (VideoDataSource) this.f5218J.f4832a.get(this.aj);
        int i = (!this.f5218J.f4841j || videoDataSource == null || videoDataSource.f4817c == null) ? 0 : 1;
        Object obj = i != 0 ? videoDataSource.f4817c : videoDataSource != null ? videoDataSource.f4816b : this.ad;
        if (videoDataSource == null || videoDataSource.f4816b == null || !(this.ac == null || this.ac.equals(r1))) {
            mo480a(ReleaseCaller.FROM_BIND);
        }
        if (videoDataSource != null) {
            this.S = videoDataSource.f4821g;
            this.ad = videoDataSource.f4816b;
            this.ae = videoDataSource.f4817c;
        }
        this.ac = i != 0 ? this.ae : this.ad;
        this.af = i != 0 ? this.ah : this.ag;
        this.ai = i != 0 ? VideoResolution.HIGH_DEFINITION : VideoResolution.STANDARD_DEFINITION;
        mo484a("Video source (%s): %s", this.f5227S, this.ac);
        this.f5244p.f5161i = this.f5218J.f4849r;
        this.f5244p.f5162j = this.af;
        this.f5244p.m5596b(this.f5218J.f4833b);
    }

    protected final void mo497v() {
        if (this.aj < this.f5218J.f4832a.size()) {
            this.ap.m14923a(VideoRenderUtils.m6003a(this.ap.m14930j(), this.ap.m14931k(), (VideoDataSource) this.f5218J.f4832a.get(this.aj)));
        } else if (this.f5235g != null) {
            this.f5235g.a("Potential IndexOutOfBoundsException:mCurrentDataSourceIndex = " + this.aj + " but the size of the datastructure = " + this.f5218J.f4832a.size(), this.f5253y.value, this.f5218J.f4833b, this.ac, this.f5254z.value, this.f5251w, mo496r(), this.f5218J, null);
        }
    }

    protected final void mo488b(Surface surface) {
        Preconditions.checkNotNull(surface);
        if (this.aa != null) {
            m5657a(surface);
            this.aa.setAudioStreamType(3);
        }
    }

    private void m5657a(Surface surface) {
        m5658a(surface, null);
    }

    private void m5658a(final Surface surface, final SurfaceState surfaceState) {
        ExecutorDetour.a(this.f5239k, new Runnable(this) {
            final /* synthetic */ TextureViewVideoPlayer f5391c;

            public void run() {
                this.f5391c.aa.setSurface(surface);
                if (surfaceState != null) {
                    this.f5391c.T = surfaceState;
                }
            }
        }, -316008357);
    }

    protected final void mo498w() {
    }

    private boolean m5651F() {
        mo484a("moveToNextVideoSource: %s", Integer.valueOf(this.aj + 1));
        this.aj++;
        if (this.aj < 0) {
            this.aj = 0;
        }
        while (this.aj < this.f5218J.f4832a.size()) {
            VideoDataSource videoDataSource = (VideoDataSource) this.f5218J.f4832a.get(this.aj);
            if (videoDataSource == null || videoDataSource.f4816b == null) {
                this.aj++;
            } else {
                this.ac = videoDataSource.f4816b;
                this.S = videoDataSource.f4821g;
                return true;
            }
        }
        return false;
    }

    public final boolean mo486a() {
        this.G = "isPlaying";
        if (this.aa != null && m5653H() && this.aa.isPlaying()) {
            return true;
        }
        return false;
    }

    public final View mo495k() {
        return this.ap == null ? null : this.ap.f14118i;
    }

    public final int mo487b() {
        this.G = "getCurrentPosition";
        if (m5653H()) {
            int currentPosition = this.aa.getCurrentPosition();
            int i = this.f5209A > 0 ? this.f5209A : 0;
            if (this.f5218J.f4843l > 0) {
                currentPosition -= this.f5218J.f4843l;
            }
            return VideoEngineUtils.a(currentPosition, 0, i);
        } else if (this.ak != -1) {
            return this.ak;
        } else {
            return 0;
        }
    }

    public final void mo483a(Subtitles subtitles) {
        CustomSubtitleAdapter customSubtitleAdapter = this.f5236h;
        if (subtitles == null) {
            subtitles = null;
        }
        customSubtitleAdapter.m5644a(subtitles);
    }

    public final void mo491d() {
        mo484a("prepare", new Object[0]);
        this.R = EventTriggerType.BY_PREPARER;
        this.E = PlayerState.STATE_PREPARED;
        m5649D();
    }

    public final void mo481a(VideoSurfaceTarget videoSurfaceTarget) {
        this.ap = videoSurfaceTarget;
        this.ap.f14119j = this.aq;
        if (this.ap.m14926d()) {
            this.aq.mo517a(this.ap.f14117h);
        }
    }

    private void m5652G() {
        mo484a("prepareAsync", new Object[0]);
        m5708a(PlayerState.STATE_PREPARING);
        if (this.f5234f != null) {
            this.f5234f.mo460b();
        }
        MediaPlayerSession mediaPlayerSession = new MediaPlayerSession(this.aa, CallerContext.a(this.f5230b));
        mediaPlayerSession.f5640c = this.f5218J.f4849r;
        mediaPlayerSession.f5641d = this.af;
        this.am.a(VideoServer.a(this.ac), mediaPlayerSession);
        this.f5245q.a(new PreparationBeginEvent());
        this.aa.prepareAsync();
    }

    private void m5655a(MediaPlayer mediaPlayer, final boolean z) {
        final WeakReference weakReference = new WeakReference(mediaPlayer);
        ExecutorDetour.a(this.f5239k, new Runnable(this) {
            final /* synthetic */ TextureViewVideoPlayer f5601c;

            public void run() {
                MediaPlayer mediaPlayer = (MediaPlayer) weakReference.get();
                if (mediaPlayer != null) {
                    if (z) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.release();
                }
            }
        }, 113307808);
    }

    private boolean m5653H() {
        if (this.aa == null) {
            return false;
        }
        if (this.f5212D == PlayerState.STATE_PREPARED || this.f5212D == PlayerState.STATE_PLAYING || this.f5212D == PlayerState.STATE_PAUSED || this.f5212D == PlayerState.STATE_PLAYBACK_COMPLETED) {
            return true;
        }
        return false;
    }

    protected final void mo475a(EventTriggerType eventTriggerType, int i) {
        this.f5235g.b(this.f5218J.f4836e, this.f5253y.value, StreamingFormat.PROGRESSIVE_DOWNLOAD.value, eventTriggerType.value, i, this.f5227S.value, this.f5218J.f4833b, this.f5251w, null, this.f5254z.value, mo496r(), this.f5252x, this.f5218J.f4837f, this.an, this.f5218J);
    }

    protected final void mo470B() {
        mo484a("onCompletion", new Object[0]);
        this.A = this.f5218J.f4834c;
        if (this.f5212D == PlayerState.STATE_PLAYING) {
            m5736z();
            this.f5245q.a(new AsyncVideo$PlayPausedEvent(this.f5209A, VideoReason.f5597a));
        }
        this.B = 0;
        m5702A();
        if (!this.f5218J.f4840i || (this.f5218J.f4845n != -1 && this.aw >= this.f5218J.f4845n)) {
            m5708a(PlayerState.STATE_PLAYBACK_COMPLETED);
            m5713b(PlayerState.STATE_PLAYBACK_COMPLETED);
            this.ak = -1;
            if (!this.f5218J.f4846o) {
                mo510n();
                mo480a(ReleaseCaller.FROM_ONCOMPLETE);
            }
            this.f5234f.mo445a(this.f5209A);
            return;
        }
        m5662b(EventTriggerType.BY_AUTOPLAY, new PlayPosition(0, 0));
        this.ak = 0;
        m5663c(EventTriggerType.BY_AUTOPLAY, new PlayPosition(0, 0));
        m5664d(EventTriggerType.BY_AUTOPLAY, new PlayPosition(0, 0));
        this.aw++;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.al = i;
        this.f5234f.mo461b(i);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        mo470B();
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        mo484a("MediaPlayerError: what=%s, extra=%s", Integer.valueOf(i), Integer.valueOf(i2));
        boolean z = this.ar instanceof DirectPlayMediaPlayer;
        if (z && this.at && this.f5207Z.f5263g) {
            mo484a("MediaPlayer in retry", new Object[0]);
        } else if (m5665d(i)) {
            this.at = true;
            if (z) {
                this.ak = mo487b();
            } else {
                this.ac = VideoServer.e(this.ac);
            }
            this.f5240l.b(new 4(this));
        } else {
            VideoError videoError;
            m5708a(PlayerState.STATE_ERROR);
            m5713b(PlayerState.STATE_ERROR);
            this.al = 0;
            this.ak = -1;
            VideoError videoError2 = VideoError.UNKNOWN;
            mo480a(ReleaseCaller.FROM_ERROR);
            if (VERSION.SDK_INT >= 17) {
                videoError2 = m5666e(i2);
                if (videoError2 == VideoError.UNKNOWN) {
                    videoError2 = m5666e(i);
                }
            }
            if (videoError2.value.equals(VideoError.UNKNOWN.value)) {
                switch (i) {
                    case 1:
                        mo484a("onError MEDIA_ERROR_UNKNOWN", new Object[0]);
                        videoError = videoError2;
                        break;
                    case 100:
                        mo484a("onError MEDIA_ERROR_SERVER_DIED", new Object[0]);
                        videoError = VideoError.SERVER_DIED;
                        break;
                    default:
                        mo484a("onError unknown with what=%s, extra=%s", Integer.valueOf(i), Integer.valueOf(i2));
                        break;
                }
            }
            videoError = videoError2;
            BLog.b(f5203V, "playback failed: %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (this.f5235g != null) {
                this.f5235g.a(StringFormatUtil.a("MediaPlayer Error: %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), this.f5253y.value, this.f5218J.f4833b, this.ac, this.f5254z.value, this.f5251w, mo496r(), this.f5218J, null);
            }
            this.f5234f.mo453a(this.f5215G, videoError);
        }
        return true;
    }

    private boolean m5665d(int i) {
        return (i == -1004 || i == -1007 || i == 1) && VideoServer.f(this.ac);
    }

    @TargetApi(17)
    private VideoError m5666e(int i) {
        Preconditions.checkArgument(VERSION.SDK_INT >= 17);
        switch (i) {
            case -1010:
                mo484a("onError MEDIA_ERROR_UNSUPPORTED", new Object[0]);
                return VideoError.UNSUPPORTED;
            case -1007:
                mo484a("onError MEDIA_ERROR_MALFORMED", new Object[0]);
                return VideoError.MALFORMED;
            case -1004:
                mo484a("onError MEDIA_ERROR_IO", new Object[0]);
                return VideoError.ERROR_IO;
            case -110:
                mo484a("onError MEDIA_ERROR_TIMED_OUT", new Object[0]);
                return VideoError.TIMED_OUT;
            default:
                return VideoError.UNKNOWN;
        }
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        switch (i) {
            case 1:
                mo484a("onInfo MEDIA_INFO_UNKNOWN", new Object[0]);
                break;
            case 700:
                mo484a("onInfo MEDIA_INFO_VIDEO_TRACK_LAGGING", new Object[0]);
                break;
            case 701:
                mo484a("onInfo MEDIA_INFO_BUFFERING_START", new Object[0]);
                break;
            case 702:
                mo484a("onInfo MEDIA_INFO_BUFFERING_END", new Object[0]);
                break;
            case 800:
                mo484a("onInfo MEDIA_INFO_BAD_INTERLEAVING", new Object[0]);
                break;
            case 801:
                mo484a("onInfo MEDIA_INFO_NOT_SEEKABLE", new Object[0]);
                break;
            case 802:
                mo484a("onInfo MEDIA_INFO_METADATA_UPDATE", new Object[0]);
                break;
            default:
                mo484a("onInfo unknown with codes what=%s, extra=%s", Integer.valueOf(i), Integer.valueOf(i2));
                break;
        }
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        mo484a("onPrepared", new Object[0]);
        m5708a(PlayerState.STATE_PREPARED);
        this.A = mediaPlayer.getDuration();
        this.am.a(VideoServer.a(this.ac), this.f5209A);
        this.f5234f.mo444a();
        this.f5245q.a(new PreparationEndEvent());
        this.F = new VideoMetadata(mediaPlayer.getDuration(), mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight(), VideoMimes.m6001a(VideoServer.e(this.ac)), null);
        if (this.as) {
            mediaPlayer.setLooping(this.f5218J.f4840i);
        }
        if (this.f5213E == PlayerState.STATE_PLAYING) {
            m5664d(this.f5226R, this.f5211C);
        } else if (this.f5213E == PlayerState.STATE_PAUSED) {
            mo490c(this.f5226R);
        } else if (this.f5213E == PlayerState.STATE_IDLE) {
            mo489b(this.f5226R);
        }
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        mo484a("onSeekComplete", new Object[0]);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        mo484a("onVideoSizeChanged: %sx%s", Integer.valueOf(i), Integer.valueOf(i2));
        if ((i == 0 || i2 == 0) && this.f5235g != null) {
            BLog.a(f5203V, "MediaPlayer.OnVideoSizeChanged with invalid width or height. Width: %d, Height: %d, PlayerType: %s, Video Id: %s, Source %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this.f5253y.value, this.f5218J.f4833b, this.ac});
        }
        this.f5234f.mo446a(i, i2);
    }

    public final void mo482a(SubtitleText subtitleText) {
        if (this.f5237i != null) {
            this.f5237i.mo482a(subtitleText);
        }
    }

    protected final void mo484a(String str, Object... objArr) {
    }

    public final String mo496r() {
        return "old_api_psr";
    }

    public final void mo472a(int i) {
        try {
            if (this.aa != null && this.aa.hashCode() == i) {
                if (this.aa.getCurrentPosition() >= this.f5218J.f4844m) {
                    onCompletion(this.aa);
                } else if (this.aa.isPlaying()) {
                    Message obtainMessage = this.au.obtainMessage(DelayedCompletionHandler.f5270a);
                    obtainMessage.obj = this;
                    obtainMessage.arg1 = i;
                    int currentPosition = this.f5218J.f4844m - this.aa.getCurrentPosition();
                    this.au.sendMessageDelayed(obtainMessage, currentPosition > 0 ? (long) currentPosition : 0);
                }
            }
        } catch (IllegalStateException e) {
        }
    }
}
