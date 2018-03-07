package com.facebook.video.engine.texview.exo;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec.CryptoException;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.SizeUtil;
import com.facebook.debug.log.BLog;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.StallTimeCalculation;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamRepresentationEventSource;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.analytics.VideoAnalytics.StreamingFormat;
import com.facebook.video.api.AsyncVideo.PlayPausedEvent;
import com.facebook.video.api.AsyncVideo.PlayRequestedEvent;
import com.facebook.video.api.AsyncVideo.PlayStartedEvent;
import com.facebook.video.api.UserReason;
import com.facebook.video.api.VideoEvents.StartingEvent;
import com.facebook.video.api.VideoMetadata;
import com.facebook.video.api.VideoReason;
import com.facebook.video.api.playersession.VideoPlayerSession;
import com.facebook.video.api.playersession.VideoPlayerSessionBase.SessionState;
import com.facebook.video.api.playersession.VideoPlayerSessionManager;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.ExoPlayerPreparer;
import com.facebook.video.engine.ExoPlayerPreparerBase;
import com.facebook.video.engine.NativePlayerPool;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoEngineUtils;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayer$VideoSourceType;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerViewProvider;
import com.facebook.video.engine.VideoRenderUtils;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.engine.texview.BaseVideoPlayer;
import com.facebook.video.engine.texview.BaseVideoPlayer.ReleaseCaller;
import com.facebook.video.engine.texview.BaseVideoPlayer.SurfaceState;
import com.facebook.video.engine.texview.InitializationSequenceLogger;
import com.facebook.video.engine.texview.VideoSurfaceTarget;
import com.facebook.video.engine.texview.VideoSurfaceTarget.3;
import com.facebook.video.engine.texview.VideoSurfaceTarget.SurfaceListener;
import com.facebook.video.server.BytesViewedLogger;
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
import com.facebook.video.view.exo.ExoPlayerStreamRendererBuilder.BuilderCallback;
import com.facebook.video.view.exo.ExoStreamRendererEventListener;
import com.facebook.video.view.exo.PlaybackPreferences;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.android.exoplayer.DummyTrackRenderer;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.ExoPlayer.Listener;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecTrackRenderer.DecoderInitializationException;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.MediaFormat;
import com.google.android.exoplayer.ParserException;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.audio.AudioTrack.InitializationException;
import com.google.android.exoplayer.audio.AudioTrack.WriteException;
import com.google.android.exoplayer.chunk.ChunkSampleSource.EventListener;
import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@TargetApi(16)
/* compiled from: composer_select_album_new */
public class ExoVideoPlayer extends BaseVideoPlayer implements BuilderCallback, ExoStreamRendererEventListener, Listener, EventListener {
    protected final boolean f18871V;
    private final int f18872W;
    private final InitializationSequenceLogger f18873X;
    public ExoPlayer f18874Y;
    public TrackRenderer f18875Z;
    private String aA;
    private String aB;
    private VideoSurfaceTarget aC;
    private final VideoSurfaceListener aD;
    private final PlaybackPreferences aE;
    private ExoPlayerPreparer aF;
    private int aG;
    private final boolean aH;
    private final boolean aI;
    private int aJ;
    private TrackRenderer aa;
    private int ab;
    private int ac;
    private float ad;
    private Uri ae;
    private Uri af;
    private Uri ag;
    private Uri ah;
    private String ai;
    private Uri aj;
    private Uri ak;
    private boolean al;
    private int am;
    private int an;
    private int ao;
    private VideoResolution ap;
    private int aq;
    public int ar;
    private int as;
    private VideoPlayerSessionManager at;
    private int au;
    private long av;
    private VideoExoplayerConfig aw;
    private int ax;
    private int ay;
    private int az;

    /* compiled from: composer_select_album_new */
    class C14064 implements Runnable {
        final /* synthetic */ ExoVideoPlayer f18867a;

        C14064(ExoVideoPlayer exoVideoPlayer) {
            this.f18867a = exoVideoPlayer;
        }

        public void run() {
            if (this.f18867a.i()) {
                ExoVideoPlayer.m27565c(this.f18867a);
            }
        }
    }

    /* compiled from: composer_select_album_new */
    /* synthetic */ class C14075 {
        static final /* synthetic */ int[] f18868a = new int[PlayerState.values().length];

        static {
            try {
                f18868a[PlayerState.STATE_PREPARING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18868a[PlayerState.STATE_IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: composer_select_album_new */
    class InternalSubtitleListener implements SubtitleListener {
        final /* synthetic */ ExoVideoPlayer f18869a;

        public InternalSubtitleListener(ExoVideoPlayer exoVideoPlayer) {
            this.f18869a = exoVideoPlayer;
        }

        public final void m27543a(SubtitleText subtitleText) {
            if (this.f18869a.i != null) {
                this.f18869a.i.a(subtitleText);
            }
        }
    }

    /* compiled from: composer_select_album_new */
    class VideoSurfaceListener implements SurfaceListener {
        final /* synthetic */ ExoVideoPlayer f18870a;

        public VideoSurfaceListener(ExoVideoPlayer exoVideoPlayer) {
            this.f18870a = exoVideoPlayer;
        }

        public final void m27545a(Surface surface) {
            this.f18870a.m27600a("ExoPlayer::VideoSurfaceTarget::onSurfaceAvailable", new Object[0]);
            this.f18870a.m27606b(surface);
            this.f18870a.T = SurfaceState.STATE_CREATED;
        }

        public final void m27546a(3 3) {
            this.f18870a.m27600a("ExoPlayer::VideoSurfaceTarget::onSurfaceUnavailable", new Object[0]);
            if (this.f18870a.i()) {
                this.f18870a.c(EventTriggerType.BY_PLAYER);
            }
            this.f18870a.m27616w();
            this.f18870a.m27589a(ReleaseCaller.FROM_DESTROY_SURFACE);
            this.f18870a.I = null;
            this.f18870a.T = SurfaceState.STATE_DESTROYED;
            3.a();
        }

        public final void m27544a() {
            this.f18870a.m27615v();
        }

        public final void m27547b() {
            this.f18870a.K = this.f18870a.m.now();
            if (this.f18870a.L) {
                this.f18870a.g.a(this.f18870a.y.value, this.f18870a.J.b, this.f18870a.w, this.f18870a.z.value, this.f18870a.m27614r());
                this.f18870a.L = false;
                this.f18870a.T = SurfaceState.STATE_UPDATED;
                if (this.f18870a.f != null) {
                    this.f18870a.f.c(this.f18870a.M);
                }
            }
        }
    }

    public ExoVideoPlayer(Context context, AttributeSet attributeSet, int i, VideoPlayerViewProvider videoPlayerViewProvider, VideoPlayerListener videoPlayerListener, VideoLoggingUtils videoLoggingUtils, ScheduledExecutorService scheduledExecutorService, Boolean bool, boolean z, AndroidThreadUtil androidThreadUtil, VideoPlayerSessionManager videoPlayerSessionManager, MonotonicClock monotonicClock, VideoExoplayerConfig videoExoplayerConfig, SubtitleAdapter subtitleAdapter, SubtitleMediaTimeProvider subtitleMediaTimeProvider, SubtitleListener subtitleListener, InitializationSequenceLogger initializationSequenceLogger, VideoEngineUtils videoEngineUtils, BytesViewedLogger bytesViewedLogger, Lazy<NativePlayerPool> lazy, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, boolean z2, boolean z3, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        super(context, attributeSet, i, videoPlayerViewProvider, lazy, videoPlayerListener, subtitleListener, subtitleAdapter, scheduledExecutorService, androidThreadUtil, bool, z, monotonicClock, initializationSequenceLogger, videoEngineUtils, bytesViewedLogger, videoLoggingUtils, qeAccessor, gatekeeperStore, videoLivePlaybackConfig);
        this.aq = 0;
        this.au = -1;
        this.av = -1;
        this.ax = 0;
        this.ay = 0;
        this.az = 0;
        this.aD = new VideoSurfaceListener(this);
        this.aG = -1;
        this.aH = false;
        this.I = null;
        this.f18874Y = null;
        this.aA = null;
        this.aB = null;
        this.ab = 1;
        this.ac = 1;
        this.aI = z2;
        this.f18872W = SizeUtil.a(this.b, 300.0f);
        this.ar = -1;
        this.J = VideoPlayerParams.newBuilder().m();
        this.at = videoPlayerSessionManager;
        this.N = new StallTimeCalculation(this.m);
        this.O = new StallTimeCalculation(this.m);
        a(this.D);
        b(this.E);
        this.aw = videoExoplayerConfig;
        this.f18871V = z3;
        this.h.a(subtitleMediaTimeProvider);
        this.h.a(new InternalSubtitleListener(this));
        this.f18873X = initializationSequenceLogger;
        this.f18873X.a(this.q);
        this.n.a(this.q);
        this.aE = new PlaybackPreferences();
        this.aJ = 1;
    }

    public static void m27565c(ExoVideoPlayer exoVideoPlayer) {
        exoVideoPlayer.m27600a("Initializing ExoPlayer", new Object[0]);
        exoVideoPlayer.a(PlayerState.STATE_IDLE);
        exoVideoPlayer.as = 0;
        boolean E;
        do {
            try {
                if (exoVideoPlayer.ae != null) {
                    exoVideoPlayer.m27600a("Set data source = %s", exoVideoPlayer.ae);
                    exoVideoPlayer.n.a(exoVideoPlayer.ae);
                    exoVideoPlayer.n.a(exoVideoPlayer.am);
                    exoVideoPlayer.m27556a(exoVideoPlayer.ae);
                    return;
                }
                exoVideoPlayer.m27600a("Data source is invalid. Try next one.", new Object[0]);
                E = exoVideoPlayer.m27549E();
                if (E) {
                    continue;
                } else {
                    exoVideoPlayer.m27600a("No data source!", new Object[0]);
                    if (exoVideoPlayer.f != null) {
                        exoVideoPlayer.f.a(exoVideoPlayer.G, VideoError.NO_SOURCE);
                        continue;
                    } else {
                        continue;
                    }
                }
            } catch (NullPointerException e) {
                exoVideoPlayer.m27600a("dataSourceNPE", new Object[0]);
                r1 = exoVideoPlayer.m27549E();
                boolean E2;
                if (E2) {
                    E = E2;
                    continue;
                } else {
                    throw e;
                }
            } catch (Throwable e2) {
                exoVideoPlayer.g.a(e2.getMessage(), exoVideoPlayer.y.value, exoVideoPlayer.J.b, exoVideoPlayer.ae, exoVideoPlayer.z.value, exoVideoPlayer.w, exoVideoPlayer.m27614r(), exoVideoPlayer.J, e2);
                exoVideoPlayer.m27600a("Caught IllegalStateException - Unable to open content %s", exoVideoPlayer.ae);
                exoVideoPlayer.m27558a(VideoError.UNKNOWN, e2);
                return;
            } catch (Throwable e22) {
                exoVideoPlayer.g.a(e22.getMessage(), exoVideoPlayer.y.value, exoVideoPlayer.J.b, exoVideoPlayer.ae, exoVideoPlayer.z.value, exoVideoPlayer.w, exoVideoPlayer.m27614r(), exoVideoPlayer.J, e22);
                exoVideoPlayer.m27600a("Caught NullPointerException - Unable to open content %s", exoVideoPlayer.ae);
                exoVideoPlayer.m27558a(VideoError.UNKNOWN, e22);
                return;
            }
        } while (E);
    }

    private void m27556a(Uri uri) {
        ExoPlayerPreparer exoPlayerPreparer;
        m27600a("prepareAsync", new Object[0]);
        a(PlayerState.STATE_PREPARING);
        if (this.f18874Y != null) {
            m27559a(this.f18874Y, m27550F());
        }
        m27600a("Allocate new ExoPlayer", new Object[0]);
        this.q.a(new AllocationBeginEvent());
        this.aE.a(false);
        this.aE.a(this.J.b);
        this.aE.c(this.J.s != null);
        boolean a = this.g.a(this.J.b, m27604b());
        if (this.al) {
            exoPlayerPreparer = (ExoPlayerPreparer) ((NativePlayerPool) this.j.get()).a(uri, null, null, this.aj, null, a);
        } else {
            exoPlayerPreparer = (ExoPlayerPreparer) ((NativePlayerPool) this.j.get()).a(uri, this.ah, this.ai, this.aj, this.aE, a);
        }
        this.aF = exoPlayerPreparer;
        this.P = this.aF.f18819l.a();
        this.f18873X.k = this.P.value;
        this.q.a(new PreparationBeginEvent());
        this.f18874Y = this.aF.f18818k;
        if (this.P == StreamingFormat.RTMP) {
            this.J.d = "rtmp";
        }
        exoPlayerPreparer = this.aF;
        exoPlayerPreparer.f18818k.b(exoPlayerPreparer.f18823p);
        exoPlayerPreparer.f18818k.a(this);
        exoPlayerPreparer.f18822o = this;
        this.f18875Z = this.aF.f18820m;
        this.aa = this.aF.f18821n;
        this.az = this.aF.f18814h;
        this.ay = this.aF.f18813g;
        this.aA = this.aF.f18811e;
        this.aB = this.aF.f18812f;
        this.ab = this.aF.f18809c;
        m27600a("NativePlayerPool returned player state=%s", ExoPlayerPreparerBase.m27529a(this.aF.f18810d));
        m27601a(this.f18874Y.b(), this.aF.f18810d);
        this.q.a(new AllocationEndEvent());
        if (this.f != null) {
            this.f.b();
        }
        VideoPlayerSession videoPlayerSession = new VideoPlayerSession(this, CallerContext.a(this.b));
        videoPlayerSession.c = this.J.r;
        videoPlayerSession.d = this.am;
        this.au = VideoServer.a(this.ae);
        this.at.a(this.au, videoPlayerSession);
    }

    public final void m27598a(Exception exception) {
        int i = 0;
        m27600a("Builder build threw exception: %s", exception);
        if (this.P == StreamingFormat.DASH) {
            i = 1;
        }
        if ((exception instanceof ParserException) && r0 != 0) {
            this.al = true;
        }
        m27558a(VideoError.MALFORMED, (Throwable) exception);
    }

    public final void m27594a(MediaCodecVideoTrackRenderer mediaCodecVideoTrackRenderer, MediaCodecAudioTrackRenderer mediaCodecAudioTrackRenderer) {
        if (mediaCodecVideoTrackRenderer == null) {
            mediaCodecVideoTrackRenderer = new DummyTrackRenderer();
        }
        this.f18875Z = mediaCodecVideoTrackRenderer;
        if (mediaCodecAudioTrackRenderer == null) {
            mediaCodecAudioTrackRenderer = new DummyTrackRenderer();
        }
        this.aa = mediaCodecAudioTrackRenderer;
        this.ab = 3;
        if (this.f18874Y == null) {
            BLog.b("[ExoVideoPlayer]", "null mExoPlayer in onRenderers");
            return;
        }
        this.f18874Y.a(new TrackRenderer[]{this.f18875Z, this.aa});
    }

    public final void m27611f() {
        m27589a(ReleaseCaller.EXTERNAL);
    }

    protected final void m27589a(ReleaseCaller releaseCaller) {
        this.G = "release";
        m27600a(this.G, new Object[0]);
        this.f18873X.a();
        this.aB = null;
        this.aA = null;
        this.F = null;
        this.h.d();
        m27548C();
    }

    private void m27548C() {
        this.at.a(this.au);
        this.au = -1;
        if (this.f18874Y != null) {
            m27600a("unprepare ExoPlayer", new Object[0]);
            m27559a(this.f18874Y, m27550F());
            a(PlayerState.STATE_IDLE);
            b(PlayerState.STATE_IDLE);
            this.ac = 1;
            this.ab = 1;
            this.as = 0;
            this.ar = -1;
        }
    }

    public final void m27582a(EventTriggerType eventTriggerType) {
        m27584a(eventTriggerType, PlayPosition.a);
    }

    public final void m27584a(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        int i = 1;
        this.G = "play";
        m27600a("%s, %s", this.G, eventTriggerType.value);
        this.at.a(VideoServer.a(this.ae), SessionState.START);
        this.q.a(new PlayRequestedEvent(playPosition.c, UserReason.b));
        if (playPosition.b()) {
            this.ar = playPosition.c;
        }
        if (this.E != PlayerState.STATE_PLAYING) {
            i = 0;
        }
        m27564c(eventTriggerType, playPosition);
        if (m27550F()) {
            m27562b(eventTriggerType, playPosition);
            m27557a(eventTriggerType, playPosition, false);
            return;
        }
        Object obj;
        if (i == 0) {
            m27562b(eventTriggerType, playPosition);
        }
        if (this.D == PlayerState.STATE_PREPARING || this.D == PlayerState.STATE_PREPARED) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            m27565c(this);
        }
    }

    private void m27562b(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        this.N.a();
        this.N.b();
        if (!m27569l(eventTriggerType)) {
            int i;
            VideoLoggingUtils videoLoggingUtils = this.g;
            ArrayNode arrayNode = this.J.e;
            String str = this.y.value;
            String str2 = eventTriggerType.value;
            if (playPosition != PlayPosition.a) {
                i = playPosition.c;
            } else {
                i = m27604b();
            }
            videoLoggingUtils.a(arrayNode, str, str2, i, this.S.value, this.J.b, this.w, null, this.z.value, m27614r(), this.x, this.J.f, this.J.d, this.J);
        }
    }

    private void m27564c(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        this.R = eventTriggerType;
        this.C = playPosition;
        b(PlayerState.STATE_PLAYING);
    }

    private void m27557a(EventTriggerType eventTriggerType, PlayPosition playPosition, boolean z) {
        Preconditions.checkNotNull(playPosition);
        Preconditions.checkArgument(this.E == PlayerState.STATE_PLAYING);
        m27600a("playNow", new Object[0]);
        this.L = true;
        this.M = eventTriggerType;
        this.K = -1;
        this.q.a(new StartingEvent(playPosition.c, UserReason.b));
        if (this.f != null) {
            this.f.a(eventTriggerType, true);
        }
        boolean z2 = this.ar != -1 && y();
        if (z2) {
            m27600a("Seek to: %d", Integer.valueOf(this.ar));
            this.f18874Y.a((long) this.ar);
        }
        if (!this.aI) {
            m27615v();
        }
        this.f18874Y.a(true);
        this.N.c();
        a(PlayerState.STATE_PLAYING);
        int b = z2 ? this.ar : m27604b();
        this.ar = -1;
        this.h.b();
        z2 = this.g.a(this.J.b, 0);
        if (m27569l(eventTriggerType)) {
            this.g.a(this.J.e, this.y.value, this.P.value, eventTriggerType.value, b, this.J.b, this.w, this.z.value, this.J.f);
        } else if (z2 || !z) {
            m27583a(eventTriggerType, b);
        } else {
            m27600a("InternalRetry, skip logging", new Object[0]);
        }
        this.N.a();
        this.q.a(new PlayStartedEvent(playPosition.c, b, UserReason.b));
        this.f18873X.a();
        if (playPosition.a()) {
            this.B = playPosition.d;
        } else if (!m27569l(eventTriggerType)) {
            this.B = b;
        }
        if (this.aG != -1) {
            this.aG = this.B;
        }
        this.av = this.m.now();
    }

    public final void m27607b(final EventTriggerType eventTriggerType) {
        this.G = "stop";
        m27600a("%s, %s", this.G, eventTriggerType.value);
        this.f18873X.a();
        if (this.D == PlayerState.STATE_PREPARING) {
            this.R = eventTriggerType;
            b(PlayerState.STATE_IDLE);
        } else if (m27550F()) {
            if (this.f != null) {
                this.f.c(eventTriggerType, true);
            }
            this.at.a(VideoServer.a(this.ae));
            m27566i(eventTriggerType);
            if (this.f != null) {
                this.l.a(new Runnable(this) {
                    final /* synthetic */ ExoVideoPlayer f18862b;

                    public void run() {
                        this.f18862b.f.a(eventTriggerType);
                    }
                });
            }
        }
        this.av = -1;
    }

    private void m27566i(EventTriggerType eventTriggerType) {
        m27600a("resetNow", new Object[0]);
        this.f18874Y.c();
        this.h.d();
        if (eventTriggerType != EventTriggerType.BY_AUTOPLAY) {
            this.g.b(this.J.e, this.y.value, this.P.value, eventTriggerType.value, m27604b(), this.B, this.J.b, this.w, this.z.value, this.J.f);
        }
        a(PlayerState.STATE_IDLE);
        b(PlayerState.STATE_IDLE);
        this.as = 0;
        this.av = -1;
        this.B = 0;
    }

    public final void m27608c(EventTriggerType eventTriggerType) {
        super.c(eventTriggerType);
        m27567j(eventTriggerType);
    }

    private void m27567j(EventTriggerType eventTriggerType) {
        this.f18873X.a();
        m27555M();
        if (this.u || this.as > 99) {
            this.ar = -1;
            m27568k(eventTriggerType);
        } else if (this.D == PlayerState.STATE_PREPARING) {
            m27600a("current state = %s, seek time = %d", this.D.value, Integer.valueOf(this.ar));
            if ((this.C != null ? 1 : null) != null) {
                this.B = this.C.d;
                this.ar = this.C.c;
                this.g.a(this.y.value, this.P.value, this.J.b, this.ar, m27551G(), this.w, this.z.value, this.U, StreamRepresentationEventSource.PAUSED);
                this.g.a(this.J.e, this.y.value, this.P.value, eventTriggerType.value, this.ar, this.B, this.J.b, this.w, this.z.value, m27614r(), this.J.f, null, this.J);
            }
            m27607b(eventTriggerType);
        } else {
            if (!eventTriggerType.value.equals(EventTriggerType.BY_ANDROID.value)) {
                this.ar = m27604b();
                if ((this.av != -1 && this.m.now() - this.av < 1000) || this.ar < this.B) {
                    this.ar = this.B;
                }
            }
            m27600a("stop-for-pause: %s, seek time = %d", eventTriggerType.value, Integer.valueOf(this.ar));
            if (!m27569l(eventTriggerType)) {
                this.g.a(this.y.value, this.P.value, this.J.b, this.ar, m27551G(), this.w, this.z.value, this.U, StreamRepresentationEventSource.PAUSED);
                this.g.a(this.J.e, this.y.value, this.P.value, eventTriggerType.value, this.ar, this.B, this.J.b, this.w, this.z.value, m27614r(), this.J.f, null, this.J);
            }
            this.q.a(new PlayPausedEvent(this.ar, UserReason.b));
            m27607b(eventTriggerType);
        }
        A();
        this.av = -1;
    }

    private void m27568k(EventTriggerType eventTriggerType) {
        this.G = "pause";
        m27600a("%s, %s", this.G, eventTriggerType.value);
        if (this.D == PlayerState.STATE_PAUSED) {
            b(PlayerState.STATE_PAUSED);
        } else if (this.D == PlayerState.STATE_PREPARING) {
            f(eventTriggerType);
        } else if (m27550F()) {
            if (this.f != null) {
                this.f.b(eventTriggerType, true);
            }
            m27612g(eventTriggerType);
            if (this.f != null) {
                this.f.b(eventTriggerType);
            }
        }
    }

    private static boolean m27569l(EventTriggerType eventTriggerType) {
        return BaseVideoPlayer.a.contains(eventTriggerType);
    }

    @VisibleForTesting
    protected final void m27612g(EventTriggerType eventTriggerType) {
        this.f18874Y.a(false);
        this.h.c();
        a(PlayerState.STATE_PAUSED);
        b(PlayerState.STATE_PAUSED);
        this.at.a(VideoServer.a(this.ae), SessionState.PAUSED);
        if (this.t.booleanValue() && eventTriggerType == EventTriggerType.BY_USER && this.f != null) {
            this.f.c();
            if (this.aC.d()) {
                n();
                double a = VideoRenderUtils.a(this.f18872W, this.aC.h(), this.aC.i());
                this.H = this.aC.a(a, a);
                this.f.a(this.H);
            }
        }
        int b = m27604b();
        this.O.d();
        if (m27569l(eventTriggerType)) {
            this.g.a(this.J.e, this.y.value, this.P.value, eventTriggerType.value, b, this.B, this.J.b, this.w, this.z.value, this.J.f);
        } else {
            m27600a(this.P.value, new Object[0]);
            this.g.b(this.y.value, this.P.value, this.J.b, b, m27551G(), this.w, this.z.value, this.U, StreamRepresentationEventSource.PAUSED);
            this.g.b(this.J.e, this.y.value, this.P.value, eventTriggerType.value, b, this.B, this.J.b, this.w, this.z.value, m27614r(), this.J.f, this.O, this.J);
            this.O.a();
        }
        this.q.a(new PlayPausedEvent(b, UserReason.b));
    }

    public final void m27577a(int i, EventTriggerType eventTriggerType) {
        boolean z = false;
        this.G = "seekTo (" + eventTriggerType + ")";
        m27600a(this.G, new Object[0]);
        PlaybackPreferences playbackPreferences = this.aE;
        if (eventTriggerType == EventTriggerType.BY_USER) {
            z = true;
        }
        playbackPreferences.b(z);
        this.B = i;
        switch (C14075.f18868a[this.D.ordinal()]) {
            case 1:
                this.ar = i;
                return;
            case 2:
                this.ar = i;
                return;
            default:
                if (m27550F() && y()) {
                    if (this.f18874Y != null) {
                        this.f18874Y.a((long) i);
                    }
                    this.h.a(i);
                    return;
                }
                return;
        }
    }

    public final void m27602a(boolean z, EventTriggerType eventTriggerType) {
        this.G = "mute";
        m27561b(z ? 0.0f : 1.0f);
    }

    private void m27561b(float f) {
        this.ad = Math.max(0.0f, Math.min(1.0f, f));
        if (this.f18874Y != null) {
            this.f18874Y.a(this.aa, 1, Float.valueOf(this.ad));
        }
    }

    public final void m27571a(float f) {
        this.G = "setVolume";
        m27561b(f);
    }

    public final void m27588a(VideoResolution videoResolution, EventTriggerType eventTriggerType) {
        this.G = "setVideoResolution";
        m27600a(this.G, new Object[0]);
        this.ap = videoResolution;
        Queue linkedList = new LinkedList();
        if (videoResolution == VideoResolution.HIGH_DEFINITION) {
            this.al = true;
            this.ae = this.ag;
            this.am = this.ao;
            linkedList.add(this.ag);
            linkedList.add(this.af);
        } else {
            this.al = false;
            this.ae = this.af;
            this.am = this.an;
            linkedList.add(this.af);
            linkedList.add(this.ag);
        }
        m27552J();
        if (this.f18874Y != null) {
            boolean z = PlayerState.STATE_PLAYING == this.D;
            if (z) {
                c(EventTriggerType.BY_PLAYER);
                this.ar = m27604b();
            }
            do {
                try {
                    if (!linkedList.isEmpty()) {
                        Uri uri = (Uri) linkedList.poll();
                        try {
                            this.f18874Y.c();
                            this.n.a(uri);
                            this.n.a(this.am);
                            m27556a(uri);
                            if (z) {
                                m27564c(EventTriggerType.BY_PLAYER, PlayPosition.a);
                                return;
                            } else {
                                m27568k(EventTriggerType.BY_PLAYER);
                                return;
                            }
                        } catch (NullPointerException e) {
                            if (linkedList.isEmpty()) {
                                throw e;
                            }
                        } catch (Throwable e2) {
                            this.g.a(e2.getMessage(), this.y.value, this.J.b, this.ae, this.z.value, this.w, m27614r(), this.J, e2);
                            m27600a("Caught IllegalStateException - Unable to open content %s", this.ae);
                            m27558a(VideoError.UNKNOWN, e2);
                            return;
                        }
                    }
                    return;
                } catch (Throwable e22) {
                    this.g.a(e22.getMessage(), this.y.value, this.J.b, this.ae, this.z.value, this.w, m27614r(), this.J, e22);
                    m27600a("Caught IllegalStateException - Unable to open content %s", this.ae);
                    m27558a(VideoError.UNKNOWN, e22);
                    return;
                } catch (Throwable e222) {
                    this.g.a(e222.getMessage(), this.y.value, this.J.b, this.ae, this.z.value, this.w, m27614r(), this.J, e222);
                    m27600a("Caught NullPointerException - Unable to open content %s", this.ae);
                    m27558a(VideoError.UNKNOWN, e222);
                    return;
                }
            } while (linkedList.isEmpty());
            throw e;
        }
    }

    public final void m27586a(VideoPlayer$VideoSourceType videoPlayer$VideoSourceType, String str, EventTriggerType eventTriggerType) {
        this.G = "switchPlayableUri";
        m27600a(this.G, new Object[0]);
        if (this.f18874Y != null) {
            int i;
            if (videoPlayer$VideoSourceType == VideoPlayer$VideoSourceType.VIDEO_SOURCE_RTMP) {
                if (str != null) {
                    if (!str.equals(this.ak.toString())) {
                        this.ak = Uri.parse(str);
                    } else {
                        return;
                    }
                }
                this.aj = this.ak;
            } else if (videoPlayer$VideoSourceType == VideoPlayer$VideoSourceType.VIDEO_SOURCE_HLS) {
                if (this.aj != null) {
                    this.aj = null;
                    if (str != null) {
                        Uri parse = Uri.parse(str);
                        if (!parse.equals(this.ae)) {
                            this.ae = parse;
                        } else {
                            return;
                        }
                    }
                }
                return;
            }
            if (PlayerState.STATE_PLAYING == this.D) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                c(EventTriggerType.BY_PLAYER);
                this.ar = m27604b();
            }
            this.f18874Y.c();
            this.ax = 0;
            m27556a(this.ae);
        }
    }

    public final VideoResolution m27610e() {
        return this.ap;
    }

    public final void m27587a(VideoPlayerParams videoPlayerParams) {
        this.G = "bindVideoSources";
        this.f18873X.a();
        this.an = this.J.p;
        this.ao = this.J.q;
        this.af = null;
        this.ag = null;
        this.aj = null;
        this.ak = null;
        this.ap = VideoResolution.STANDARD_DEFINITION;
        this.U = null;
        this.aG = -1;
        this.ax = 0;
        this.aJ = 1;
        if (this.aE != null) {
            this.aE.a(this.U);
        }
        this.J = videoPlayerParams;
        if (this.J.a.isEmpty()) {
            m27600a("bindVideoSources: No valid video paths", new Object[0]);
            m27589a(ReleaseCaller.FROM_BIND);
            this.aq = -1;
            this.ae = this.af;
            this.S = StreamSourceType.FROM_STREAM;
            return;
        }
        int i;
        this.aq = 0;
        VideoDataSource videoDataSource = (VideoDataSource) this.J.a.get(this.aq);
        if (!videoPlayerParams.j || videoDataSource == null || videoDataSource.c == null) {
            boolean z = false;
        } else {
            i = 1;
        }
        Uri uri = i != 0 ? videoDataSource.c : videoDataSource != null ? videoDataSource.b : this.af;
        if (videoDataSource == null || videoDataSource.b == null || !(this.ae == null || this.ae.equals(uri))) {
            m27589a(ReleaseCaller.FROM_BIND);
        }
        if (videoDataSource != null) {
            this.S = videoDataSource.g;
            this.af = videoDataSource.b;
            this.ag = videoDataSource.c;
            this.ai = videoDataSource.f;
            this.ah = videoDataSource.d;
            this.aj = videoDataSource.e;
            this.ak = this.aj;
        }
        this.ae = uri;
        this.am = i != 0 ? this.ao : this.an;
        this.ap = i != 0 ? VideoResolution.HIGH_DEFINITION : VideoResolution.STANDARD_DEFINITION;
        m27552J();
        m27600a("bindVideoSources: (%s): %s", this.S.value, this.ae);
        this.O.a();
        this.f18873X.i = this.J.r;
        this.f18873X.j = this.am;
        this.f18873X.b(this.J.b);
        this.al = false;
    }

    public final void m27585a(PlayerType playerType) {
        super.a(playerType);
        if (this.aE != null) {
            this.aE.a(playerType);
        }
    }

    protected final void m27615v() {
        if (this.aq < this.J.a.size()) {
            this.aC.a(VideoRenderUtils.a(this.aC.j(), this.aC.k(), (VideoDataSource) this.J.a.get(this.aq)));
        } else if (this.g != null) {
            this.g.a("Potential IndexOutOfBoundsException:mCurrentDataSourceIndex = " + this.aq + " but the size of the datastructure = " + this.J.a.size(), this.y.value, this.J.b, this.ae, this.z.value, this.w, m27614r(), this.J, null);
        }
    }

    protected final void m27606b(Surface surface) {
        if (this.f18874Y != null) {
            m27563c(surface);
        } else if (this.E == PlayerState.STATE_PLAYING) {
            m27565c(this);
        }
    }

    protected final void m27616w() {
        if (this.f18874Y != null) {
            m27600a("to VideoRenderer, MSG_SET_SURFACE to null", new Object[0]);
            this.f18874Y.b(this.f18875Z, 1, null);
        }
    }

    private boolean m27549E() {
        m27600a("moveToNextVideoSource: %d", Integer.valueOf(this.aq + 1));
        this.aq++;
        if (this.aq < 0) {
            this.aq = 0;
        }
        while (this.aq < this.J.a.size()) {
            VideoDataSource videoDataSource = (VideoDataSource) this.J.a.get(this.aq);
            if (videoDataSource == null || videoDataSource.b == null) {
                this.aq++;
            } else {
                this.ae = videoDataSource.b;
                this.S = videoDataSource.g;
                return true;
            }
        }
        return false;
    }

    public final boolean m27603a() {
        this.G = "isPlaying";
        if (m27550F() && this.f18874Y.b()) {
            return true;
        }
        return false;
    }

    public final View m27613k() {
        return this.aC == null ? null : this.aC.i;
    }

    public final int m27604b() {
        this.G = "getCurrentPosition";
        if (m27550F()) {
            int i;
            int f = (int) this.f18874Y.f();
            if (this.A > 0) {
                i = this.A;
            } else {
                i = 0;
            }
            return VideoEngineUtils.a(f, 0, i);
        } else if (this.ar != -1) {
            return this.ar;
        } else {
            return 0;
        }
    }

    public final void m27591a(Subtitles subtitles) {
        CustomSubtitleAdapter customSubtitleAdapter = this.h;
        if (subtitles == null) {
            subtitles = null;
        }
        customSubtitleAdapter.a(subtitles);
    }

    public final void m27609d() {
        m27600a("prepare", new Object[0]);
        this.R = EventTriggerType.BY_PREPARER;
        this.E = PlayerState.STATE_PREPARED;
        m27565c(this);
    }

    public final void m27590a(VideoSurfaceTarget videoSurfaceTarget) {
        this.aC = videoSurfaceTarget;
        this.aC.j = this.aD;
        if (this.aC.d()) {
            this.aD.m27545a(this.aC.h);
        }
    }

    private void m27559a(final ExoPlayer exoPlayer, boolean z) {
        if (z) {
            exoPlayer.c();
        }
        this.k.schedule(new Runnable(this) {
            final /* synthetic */ ExoVideoPlayer f18864b;

            public void run() {
                exoPlayer.d();
            }
        }, (long) this.aw.d, TimeUnit.MILLISECONDS);
        this.f18874Y.b(this);
        this.f18874Y = null;
        this.aa = null;
        this.f18875Z = null;
        this.aF.f18822o = null;
        this.aF = null;
    }

    private boolean m27550F() {
        if (this.f18874Y == null) {
            return false;
        }
        if (this.D == PlayerState.STATE_PREPARED || this.D == PlayerState.STATE_PLAYING || this.D == PlayerState.STATE_PAUSED || this.D == PlayerState.STATE_PLAYBACK_COMPLETED) {
            return true;
        }
        return false;
    }

    public final void m27576a(int i, long j, int i2, int i3) {
    }

    public final void m27574a(int i, int i2, int i3, long j, long j2) {
    }

    public final void m27605b(int i, long j) {
    }

    public final void m27579a(int i, IOException iOException) {
    }

    public final void m27573a(int i, int i2, int i3) {
    }

    public final void m27578a(int i, Format format, int i2, int i3) {
        if (!(this.U == null || format == null || format.a.equals(this.U.a))) {
            this.g.b(this.y.value, this.P.value, this.J.b, m27604b(), m27551G(), this.w, this.z.value, this.U, StreamRepresentationEventSource.STREAM_SWITCH);
        }
        this.U = format;
        this.aG = m27604b();
        if (this.aE != null) {
            this.aE.a(this.U);
        }
        this.F.g = x();
        if (this.f != null) {
            this.f.a(x());
        }
        m27600a("onDownstreamFormatChanged: %s, sourceId: %d, trigger: %d, mediaTimeMs: %d", x(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private int m27551G() {
        return this.aG == -1 ? this.B : this.aG;
    }

    private void m27563c(final Surface surface) {
        m27600a("sendSurfaceToVideoRenderer: %s", surface);
        ExecutorDetour.a(this.k, new Runnable(this) {
            final /* synthetic */ ExoVideoPlayer f18866b;

            public void run() {
                if (this.f18866b.f18874Y == null) {
                    this.f18866b.m27600a("Player already released when attach surface", new Object[0]);
                } else {
                    this.f18866b.f18874Y.b(this.f18866b.f18875Z, 1, surface);
                }
            }
        }, 1909422216);
    }

    protected final void m27570B() {
        m27600a("onCompletion", new Object[0]);
        this.O.c();
        this.g.a(this.y.value, this.P.value, this.J.b, this.J.c, m27551G(), this.w, this.z.value, this.U, StreamRepresentationEventSource.COMPLETED);
        z();
        this.O.a();
        this.A = m27554L();
        this.B = 0;
        A();
        if (!this.J.i || (this.J.n != -1 && this.aJ >= this.J.n)) {
            if (this.D == PlayerState.STATE_PLAYING) {
                this.q.a(new PlayPausedEvent(this.A, VideoReason.a));
            }
            a(PlayerState.STATE_PLAYBACK_COMPLETED);
            b(PlayerState.STATE_PLAYBACK_COMPLETED);
            this.ar = -1;
            n();
            m27589a(ReleaseCaller.FROM_ONCOMPLETE);
            if (this.f != null) {
                this.f.a(this.A);
                return;
            }
            return;
        }
        m27562b(EventTriggerType.BY_AUTOPLAY, new PlayPosition(0, 0));
        this.ar = 0;
        m27564c(EventTriggerType.BY_AUTOPLAY, new PlayPosition(0, 0));
        m27557a(EventTriggerType.BY_AUTOPLAY, new PlayPosition(0, 0), false);
        this.aJ++;
    }

    protected final void m27583a(EventTriggerType eventTriggerType, int i) {
        this.g.b(this.J.e, this.y.value, this.P.value, eventTriggerType.value, i, this.S.value, this.J.b, this.w, null, this.z.value, m27614r(), this.x, this.J.f, this.N, this.J);
    }

    private void m27558a(VideoError videoError, Throwable th) {
        m27600a("handleError %s; exception: %s", videoError, th.getMessage());
        if ((videoError == VideoError.ERROR_IO || videoError == VideoError.MALFORMED) && this.ax < 3) {
            this.ax++;
            m27600a("Re-init ExoPlayer after malformed/io errors, try #%d", Integer.valueOf(this.ax));
            this.h.c();
            if (this.ab == 3 && this.D == PlayerState.STATE_PLAYING) {
                this.g.a(this.y.value, this.P.value, this.J.b, m27604b(), m27551G(), this.w, this.z.value, this.U, StreamRepresentationEventSource.PAUSED);
                this.g.a(this.J.e, this.y.value, this.P.value, EventTriggerType.BY_PLAYER_INTERNAL_ERROR.value, m27604b(), this.B, this.J.b, this.w, this.z.value, m27614r(), this.J.f, null, this.J);
            }
            if (m27560a(videoError, this.ax)) {
                this.ae = VideoServer.e(this.ae);
            }
            this.l.a(new C14064(this), (long) VideoExoplayerConfig.a(this.ax));
            return;
        }
        a(PlayerState.STATE_ERROR);
        b(PlayerState.STATE_ERROR);
        m27589a(ReleaseCaller.FROM_ERROR);
        Throwable th2 = th;
        BLog.b("[ExoVideoPlayer]", th2, "playback failed: %s", new Object[]{videoError});
        this.g.a(StringFormatUtil.formatStrLocaleSafe("ExoPlayer Error: %s, exception: %s", videoError, th), this.y.value, this.J.b, this.ae, this.z.value, this.w, m27614r(), this.J, null);
        if (this.f != null) {
            this.f.a(this.G, videoError);
        }
    }

    private boolean m27560a(VideoError videoError, int i) {
        return (videoError == VideoError.ERROR_IO || videoError == VideoError.MALFORMED) && i == 3 && VideoServer.f(this.ae);
    }

    private void m27552J() {
        if (this.f != null) {
            this.f.a(this.ap);
        }
    }

    private void m27553K() {
        m27600a("onPrepared for %s", this.ae);
        a(PlayerState.STATE_PREPARED);
        this.A = m27554L();
        this.at.a(VideoServer.a(this.ae), this.A);
        this.T = SurfaceState.STATE_UNKNOWN;
        if (this.aC != null && this.aC.d()) {
            this.T = SurfaceState.STATE_CREATED;
            m27563c(this.aC.h);
        }
        m27561b(this.ad);
        if (this.f != null) {
            this.f.a();
        }
        this.F = new VideoMetadata(this.A, this.ay, this.az, this.aA, this.aB, this.P.value, x());
        boolean z = this.ax > 0;
        this.ax = 0;
        this.q.a(new PreparationEndEvent());
        if (this.E == PlayerState.STATE_PLAYING) {
            m27557a(this.R, this.C, z);
        } else if (!this.f18871V) {
            if (this.E == PlayerState.STATE_PAUSED) {
                c(this.R);
            } else if (this.E == PlayerState.STATE_IDLE) {
                m27607b(this.R);
            }
        }
    }

    private int m27554L() {
        Preconditions.checkArgument(this.f18874Y != null);
        long e = this.f18874Y.e();
        if (e < 0 || e > 18000000) {
            return this.J.c;
        }
        return (int) e;
    }

    private void m27555M() {
        if (this.f18874Y != null) {
            int i = this.f18874Y.i();
            if (i > this.as) {
                m27600a("BufferingUpdate: from %d to %d, sid=%d", Integer.valueOf(this.as), Integer.valueOf(i), Integer.valueOf(VideoServer.a(this.ae)));
                this.as = i;
                if (this.f != null) {
                    this.f.b(this.as);
                }
            }
        }
    }

    protected final void m27600a(String str, Object... objArr) {
        Object[] objArr2 = new Object[]{StringFormatUtil.a(str, objArr), this.D.value, this.E.value, ExoPlayerPreparerBase.m27529a(this.ac), this.J.b};
    }

    public final String m27614r() {
        return "old_api_exo_deprecated";
    }

    public final void m27601a(boolean z, int i) {
        m27600a("PlayerStateChanged: playWhenReady=%s playbackState=%s", Boolean.valueOf(z), ExoPlayerPreparerBase.m27529a(i));
        if (i != this.ac) {
            int i2 = this.ac;
            this.ac = i;
            if (this.D == PlayerState.STATE_PREPARING && (i == 3 || i == 4)) {
                m27600a("ExoPlayer prepared: %s, %s", this.aA, this.aB);
                m27553K();
            }
            if (m27550F() && z && i == 3) {
                m27600a("onStartBuffering", new Object[0]);
                if (this.f != null) {
                    this.f.e();
                }
                if (i2 == 4) {
                    this.O.a((long) m27604b());
                }
            }
            if (i2 == 3 && i == 4) {
                m27600a("onStopBuffering", new Object[0]);
                if (this.f != null) {
                    this.f.f();
                }
                this.O.c();
            }
            if (i == 5) {
                m27600a("Playback complete, sid=%s", Integer.valueOf(VideoServer.a(this.ae)));
                m27570B();
            }
        }
        m27555M();
    }

    public final void m27592a(ExoPlaybackException exoPlaybackException) {
        this.ab = 1;
        m27558a(VideoError.ERROR_IO, (Throwable) exoPlaybackException);
    }

    public final void m27575a(int i, long j) {
    }

    public final void m27572a(int i, int i2, float f) {
        m27600a("onVideoSizeChanged: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.ay = i;
        this.az = i2;
        if (this.f != null) {
            this.f.a(i, i2);
        }
    }

    public final void m27581a(Surface surface) {
        m27600a("DrawToSurface", new Object[0]);
    }

    public final void m27596a(InitializationException initializationException) {
        m27558a(VideoError.MALFORMED, (Throwable) initializationException);
    }

    public final void m27597a(WriteException writeException) {
    }

    public final void m27593a(DecoderInitializationException decoderInitializationException) {
        m27558a(VideoError.MALFORMED, (Throwable) decoderInitializationException);
    }

    public final void m27580a(CryptoException cryptoException) {
    }

    public final void m27599a(String str, long j, long j2) {
    }

    public final void m27595a(MediaFormat mediaFormat) {
        if (mediaFormat != null && mediaFormat.a != null) {
            if (MimeTypes.b(mediaFormat.a)) {
                this.aA = mediaFormat.a;
            }
            if (MimeTypes.a(mediaFormat.a)) {
                this.aB = mediaFormat.a;
            }
        }
    }
}
