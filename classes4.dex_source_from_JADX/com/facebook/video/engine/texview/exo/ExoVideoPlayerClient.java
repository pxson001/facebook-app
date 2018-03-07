package com.facebook.video.engine.texview.exo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.eventbus.TypedEvent;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.SizeUtil;
import com.facebook.debug.log.BLog;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.exoplayer.Constants.ExoInternalError;
import com.facebook.exoplayer.ipc.ExoServiceRtmpStreamStats;
import com.facebook.exoplayer.ipc.MediaRenderer;
import com.facebook.exoplayer.ipc.RendererContext;
import com.facebook.exoplayer.ipc.VideoPlayerMediaChunk;
import com.facebook.exoplayer.ipc.VideoPlayerServiceApi;
import com.facebook.exoplayer.ipc.VideoPlayerServiceListener.Stub;
import com.facebook.exoplayer.ipc.VideoPlayerSession;
import com.facebook.exoplayer.ipc.VideoPlayerStreamEvaluation;
import com.facebook.exoplayer.ipc.VideoPlayerStreamFormat;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.abtest.VideoDashConfig.DashAbrPolicy;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.RtmpPlaybackInitPerfLogger;
import com.facebook.video.analytics.StallTimeCalculation;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalytics.StreamRepresentationEventSource;
import com.facebook.video.analytics.VideoAnalytics.StreamingFormat;
import com.facebook.video.api.AsyncVideo$PlayPausedEvent;
import com.facebook.video.api.AsyncVideo$PlayRequestedEvent;
import com.facebook.video.api.AsyncVideo$PlayStartedEvent;
import com.facebook.video.api.UserReason;
import com.facebook.video.api.VideoEvents$StartingEvent;
import com.facebook.video.api.VideoMetadata;
import com.facebook.video.api.VideoReason;
import com.facebook.video.api.playersession.VideoPlayerSessionBase;
import com.facebook.video.api.playersession.VideoPlayerSessionBase.SessionState;
import com.facebook.video.api.playersession.VideoPlayerSessionManager;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.ExoPlayerPreparerBase;
import com.facebook.video.engine.NativePlayerPool;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoEngineUtils;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayRequestBuilder;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.engine.VideoPlayer.VideoSourceType;
import com.facebook.video.engine.VideoPlayerListener;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerViewProvider;
import com.facebook.video.engine.VideoRenderUtils;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.engine.texview.BaseVideoPlayer;
import com.facebook.video.engine.texview.BaseVideoPlayer.ReleaseCaller;
import com.facebook.video.engine.texview.BaseVideoPlayer.VideoSurfaceListener;
import com.facebook.video.engine.texview.InitializationSequenceLogger;
import com.facebook.video.engine.texview.VideoSurfaceTarget;
import com.facebook.video.pubsub.LiveStreamingSubscriber.InterruptedMessage;
import com.facebook.video.pubsub.LiveStreamingSubscriberPool;
import com.facebook.video.server.BytesViewedLogger;
import com.facebook.video.server.VideoServer;
import com.facebook.video.subtitles.controller.SubtitleAdapter;
import com.facebook.video.subtitles.controller.SubtitleListener;
import com.facebook.video.subtitles.controller.SubtitleMediaTimeProvider;
import com.facebook.video.subtitles.controller.SubtitleText;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.video.subtitles.controller.compat.CustomSubtitleAdapter;
import com.facebook.video.view.ImplementationEvents.AllocationBeginEvent;
import com.facebook.video.view.ImplementationEvents.PreparationBeginEvent;
import com.facebook.video.view.ImplementationEvents.PreparationEndEvent;
import com.facebook.video.view.ImplementationEvents.RequestVideoServiceRestartEvent;
import com.facebook.video.view.ImplementationEvents.VideoServiceConnectedEvent;
import com.facebook.video.view.ImplementationEvents.VideoServiceConnectedEvent.Handler;
import com.facebook.video.view.ImplementationEvents.VideoServiceDisconnectedEvent;
import com.facebook.video.view.exo.DashCustomEvaluator;
import com.facebook.video.view.exo.FormatEvaluatorFactory;
import com.facebook.video.view.exo.PlaybackPreferences;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.android.exoplayer.chunk.FormatEvaluator;
import com.google.android.exoplayer.chunk.FormatEvaluator.Evaluation;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.inject.Provider;

@TargetApi(16)
/* compiled from: oxygen_map_static_map_render_time_ns */
public class ExoVideoPlayerClient extends BaseVideoPlayer implements Handler, VideoServiceDisconnectedEvent.Handler {
    public static final AtomicInteger f5609V = new AtomicInteger(0);
    public static final String aQ = ExoVideoPlayerClient.class.getSimpleName();
    public final InitializationSequenceLogger f5610W;
    private final int f5611X;
    private final Callback f5612Y;
    private final android.os.Handler f5613Z;
    private int aA;
    private VideoPlayerSessionManager aB;
    private long aC = -1;
    private long aD = -1;
    public VideoExoplayerConfig aE;
    private VideoDashConfig aF;
    private final DeviceConditionHelper aG;
    private final BandwidthMeter aH;
    private final FbDataConnectionManager aI;
    private final NetworkInfoCollector aJ;
    private FormatEvaluator aK = null;
    public int aL = 0;
    private int aM = 0;
    private int aN = 0;
    private String aO;
    private String aP;
    private VideoSurfaceTarget aR;
    private final VideoSurfaceListener aS = new VideoSurfaceListener(this);
    private final PlaybackPreferences aT;
    private final boolean aU;
    private final int aV;
    private int aW = -1;
    private final boolean aX;
    public Stub aY;
    public final ListeningExecutorService aZ;
    private final AbstractFbErrorReporter aa;
    public volatile VideoPlayerSession ab;
    public volatile Surface ac;
    @Nullable
    public VideoPlayerServiceApi ad;
    private Provider<VideoPlayerServiceApi> ae;
    private final TypedEventBus af;
    public MediaRenderer ag;
    public MediaRenderer ah;
    private int ai;
    private int aj;
    private float ak;
    private Uri al;
    private Uri am;
    private Uri an;
    private Uri ao;
    private String ap;
    private Uri aq;
    private Uri ar;
    private int as;
    private int at;
    private int au;
    private int av;
    public VideoResolution aw;
    private int ax = 0;
    public int ay;
    private int az;
    private final RtmpPlaybackInitPerfLogger ba;
    private VideoPlayRequestBuilder bb;
    private final int bc = -1;
    public int bd = -1;
    private boolean be = false;
    private final Object bf = new Object();
    private final boolean bg;
    private int bh;
    private EventTriggerType bi = EventTriggerType.UNSET;
    public boolean bj = false;
    public final LiveStreamingSubscriberPool bk;
    private final Object bl = new Object();

    /* compiled from: oxygen_map_static_map_render_time_ns */
    class InternalSubtitleListener implements SubtitleListener {
        final /* synthetic */ ExoVideoPlayerClient f5626a;

        public InternalSubtitleListener(ExoVideoPlayerClient exoVideoPlayerClient) {
            this.f5626a = exoVideoPlayerClient;
        }

        public final void mo482a(SubtitleText subtitleText) {
            if (this.f5626a.f5237i != null) {
                this.f5626a.f5237i.mo482a(subtitleText);
            }
        }
    }

    /* compiled from: oxygen_map_static_map_render_time_ns */
    class ExoServiceHandlerCallback implements Callback {
        final /* synthetic */ ExoVideoPlayerClient f5627a;

        public ExoServiceHandlerCallback(ExoVideoPlayerClient exoVideoPlayerClient) {
            this.f5627a = exoVideoPlayerClient;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean handleMessage(android.os.Message r9) {
            /*
            r8 = this;
            r2 = 1;
            r3 = 0;
            r0 = r8.f5627a;
            r0 = com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.m6010J(r0);
            if (r0 != 0) goto L_0x0014;
        L_0x000a:
            r0 = r8.f5627a;
            r1 = "Try handling message but no service connected";
            r3 = new java.lang.Object[r3];
            com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.m6051c(r0, r1, r3);
        L_0x0013:
            return r2;
        L_0x0014:
            r0 = r9.what;	 Catch:{ DeadObjectException -> 0x002d, RemoteException -> 0x0064 }
            switch(r0) {
                case 0: goto L_0x001a;
                case 1: goto L_0x006d;
                case 2: goto L_0x00a3;
                case 3: goto L_0x00d7;
                case 4: goto L_0x00e7;
                case 5: goto L_0x00fc;
                case 6: goto L_0x0109;
                case 7: goto L_0x0122;
                case 8: goto L_0x013f;
                case 9: goto L_0x0161;
                default: goto L_0x0019;
            };	 Catch:{ DeadObjectException -> 0x002d, RemoteException -> 0x0064 }
        L_0x0019:
            goto L_0x0013;
        L_0x001a:
            r0 = r8.f5627a;	 Catch:{ DeadObjectException -> 0x002d, RemoteException -> 0x0064 }
            r0 = com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.m6011K(r0);	 Catch:{ DeadObjectException -> 0x002d, RemoteException -> 0x0064 }
            if (r0 != 0) goto L_0x003f;
        L_0x0022:
            r0 = r8.f5627a;	 Catch:{ DeadObjectException -> 0x002d, RemoteException -> 0x0064 }
            r1 = "buildRenderers attempted but no session created. Aborting.";
            r4 = 0;
            r4 = new java.lang.Object[r4];	 Catch:{ DeadObjectException -> 0x002d, RemoteException -> 0x0064 }
            r0.mo484a(r1, r4);	 Catch:{ DeadObjectException -> 0x002d, RemoteException -> 0x0064 }
            goto L_0x0013;
        L_0x002d:
            r0 = move-exception;
            r1 = com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.aQ;
            r4 = "Service DeadObjectException";
            com.facebook.debug.log.BLog.b(r1, r4, r0);
            r0 = r8.f5627a;
            r1 = "Tried to process message";
            r3 = new java.lang.Object[r3];
            com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.m6051c(r0, r1, r3);
            goto L_0x0013;
        L_0x003f:
            r0 = r8.f5627a;	 Catch:{ RemoteException -> 0x004f, DeadObjectException -> 0x002d }
            r1 = r0.ad;	 Catch:{ RemoteException -> 0x004f, DeadObjectException -> 0x002d }
            r0 = r8.f5627a;	 Catch:{ RemoteException -> 0x004f, DeadObjectException -> 0x002d }
            r4 = r0.ab;	 Catch:{ RemoteException -> 0x004f, DeadObjectException -> 0x002d }
            r0 = r9.obj;	 Catch:{ RemoteException -> 0x004f, DeadObjectException -> 0x002d }
            r0 = (android.net.Uri) r0;	 Catch:{ RemoteException -> 0x004f, DeadObjectException -> 0x002d }
            r1.a(r4, r0);	 Catch:{ RemoteException -> 0x004f, DeadObjectException -> 0x002d }
            goto L_0x0013;
        L_0x004f:
            r0 = move-exception;
            r1 = r8.f5627a;	 Catch:{  }
            r4 = "Handle error during buildRenderers";
            r5 = 0;
            r5 = new java.lang.Object[r5];	 Catch:{  }
            r1.mo484a(r4, r5);	 Catch:{  }
            r1 = r8.f5627a;	 Catch:{  }
            r4 = com.facebook.video.engine.Constants.VideoError.PLAYERSERVICE_DEAD;	 Catch:{  }
            r6 = 0;
            com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.m6036a(r1, r4, r0, r6);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x0064:
            r0 = move-exception;
            r1 = com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.aQ;
            r3 = "Service RemoteException";
            com.facebook.debug.log.BLog.b(r1, r3, r0);
            goto L_0x0013;
        L_0x006d:
            r0 = r8.f5627a;	 Catch:{  }
            r0 = com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.m6011K(r0);	 Catch:{  }
            if (r0 != 0) goto L_0x0080;
        L_0x0075:
            r0 = r8.f5627a;	 Catch:{  }
            r1 = "addListener attempted but no session created. Aborting.";
            r4 = 0;
            r4 = new java.lang.Object[r4];	 Catch:{  }
            r0.mo484a(r1, r4);	 Catch:{  }
            goto L_0x0013;
        L_0x0080:
            r0 = r8.f5627a;	 Catch:{  }
            r0 = r0.aY;	 Catch:{  }
            if (r0 != 0) goto L_0x0092;
        L_0x0086:
            r0 = r8.f5627a;	 Catch:{  }
            r1 = new com.facebook.video.engine.texview.exo.ExoVideoPlayerClient$ServiceListenerStub;	 Catch:{  }
            r4 = r8.f5627a;	 Catch:{  }
            r1.<init>(r4);	 Catch:{  }
            r0.aY = r1;	 Catch:{  }
        L_0x0092:
            r0 = r8.f5627a;	 Catch:{  }
            r0 = r0.ad;	 Catch:{  }
            r1 = r8.f5627a;	 Catch:{  }
            r1 = r1.ab;	 Catch:{  }
            r4 = r8.f5627a;	 Catch:{  }
            r4 = r4.aY;	 Catch:{  }
            r0.a(r1, r4);	 Catch:{  }
            goto L_0x0013;
        L_0x00a3:
            r0 = r9.obj;	 Catch:{  }
            r0 = (com.facebook.exoplayer.ipc.VideoPlayRequest) r0;	 Catch:{  }
            r1 = r8.f5627a;	 Catch:{ RemoteException -> 0x00bb }
            r4 = r8.f5627a;	 Catch:{ RemoteException -> 0x00bb }
            r4 = r4.ad;	 Catch:{ RemoteException -> 0x00bb }
            r4 = r4.a(r0);	 Catch:{ RemoteException -> 0x00bb }
            r1.ab = r4;	 Catch:{ RemoteException -> 0x00bb }
            if (r0 == 0) goto L_0x0013;
        L_0x00b6:
            r0.close();	 Catch:{  }
            goto L_0x0013;
        L_0x00bb:
            r1 = move-exception;
            r4 = r8.f5627a;	 Catch:{ all -> 0x00d0 }
            r5 = "Handle error during registerSession";
            r6 = 0;
            r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x00d0 }
            r4.mo484a(r5, r6);	 Catch:{ all -> 0x00d0 }
            r4 = r8.f5627a;	 Catch:{ all -> 0x00d0 }
            r5 = com.facebook.video.engine.Constants.VideoError.PLAYERSERVICE_DEAD;	 Catch:{ all -> 0x00d0 }
            r6 = 0;
            com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.m6036a(r4, r5, r1, r6);	 Catch:{ all -> 0x00d0 }
            throw r1;	 Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r1 = move-exception;
            if (r0 == 0) goto L_0x00d6;
        L_0x00d3:
            r0.close();	 Catch:{  }
        L_0x00d6:
            throw r1;	 Catch:{  }
        L_0x00d7:
            r0 = r8.f5627a;	 Catch:{  }
            r0 = r0.ad;	 Catch:{  }
            r1 = r8.f5627a;	 Catch:{  }
            r1 = r1.ab;	 Catch:{  }
            r4 = r9.arg1;	 Catch:{  }
            r4 = (long) r4;	 Catch:{  }
            r0.a(r1, r4);	 Catch:{  }
            goto L_0x0013;
        L_0x00e7:
            r0 = r8.f5627a;	 Catch:{  }
            r1 = r0.ad;	 Catch:{  }
            r0 = r8.f5627a;	 Catch:{  }
            r4 = r0.ab;	 Catch:{  }
            r0 = r9.obj;	 Catch:{  }
            r0 = (java.lang.Boolean) r0;	 Catch:{  }
            r0 = r0.booleanValue();	 Catch:{  }
            r1.a(r4, r0);	 Catch:{  }
            goto L_0x0013;
        L_0x00fc:
            r0 = r8.f5627a;	 Catch:{  }
            r1 = r0.ad;	 Catch:{  }
            r0 = r9.obj;	 Catch:{  }
            r0 = (com.facebook.exoplayer.ipc.VideoPlayerSession) r0;	 Catch:{  }
            r1.c(r0);	 Catch:{  }
            goto L_0x0013;
        L_0x0109:
            r0 = r8.f5627a;	 Catch:{  }
            r1 = r0.ad;	 Catch:{  }
            r0 = r8.f5627a;	 Catch:{  }
            r4 = r0.ab;	 Catch:{  }
            r0 = r8.f5627a;	 Catch:{  }
            r5 = r0.ah;	 Catch:{  }
            r0 = r9.obj;	 Catch:{  }
            r0 = (java.lang.Float) r0;	 Catch:{  }
            r0 = r0.floatValue();	 Catch:{  }
            r1.a(r4, r5, r0);	 Catch:{  }
            goto L_0x0013;
        L_0x0122:
            r0 = r8.f5627a;	 Catch:{  }
            r0 = r0.aY;	 Catch:{  }
            if (r0 == 0) goto L_0x0013;
        L_0x0128:
            r0 = r8.f5627a;	 Catch:{  }
            r1 = r0.ad;	 Catch:{  }
            r0 = r9.obj;	 Catch:{  }
            r0 = (com.facebook.exoplayer.ipc.VideoPlayerSession) r0;	 Catch:{  }
            r4 = r8.f5627a;	 Catch:{  }
            r4 = r4.aY;	 Catch:{  }
            r1.b(r0, r4);	 Catch:{  }
            r0 = r8.f5627a;	 Catch:{  }
            r1 = 0;
            r0.aY = r1;	 Catch:{  }
            goto L_0x0013;
        L_0x013f:
            r0 = r8.f5627a;	 Catch:{  }
            r4 = r0.ad;	 Catch:{  }
            r0 = r9.obj;	 Catch:{  }
            r0 = (com.facebook.exoplayer.ipc.VideoPlayerSession) r0;	 Catch:{  }
            r1 = r9.arg1;	 Catch:{  }
            if (r1 != r2) goto L_0x015f;
        L_0x014b:
            r1 = r2;
        L_0x014c:
            r4.b(r0, r1);	 Catch:{  }
            r0 = r8.f5627a;	 Catch:{  }
            r0 = r0.ab;	 Catch:{  }
            r1 = r9.obj;	 Catch:{  }
            if (r0 != r1) goto L_0x0013;
        L_0x0157:
            r0 = r8.f5627a;	 Catch:{  }
            r1 = 0;
            r0.ab = r1;	 Catch:{  }
            goto L_0x0013;
        L_0x015f:
            r1 = r3;
            goto L_0x014c;
        L_0x0161:
            r0 = r9.obj;	 Catch:{  }
            r0 = (android.view.Surface) r0;	 Catch:{  }
            r1 = r8.f5627a;	 Catch:{  }
            r1 = r1.ac;	 Catch:{  }
            if (r1 == r0) goto L_0x0013;
        L_0x016b:
            r1 = r8.f5627a;	 Catch:{  }
            r1 = r1.ad;	 Catch:{  }
            r4 = r8.f5627a;	 Catch:{  }
            r4 = r4.ab;	 Catch:{  }
            r5 = r8.f5627a;	 Catch:{  }
            r5 = r5.ag;	 Catch:{  }
            r1.a(r4, r5, r0);	 Catch:{  }
            r1 = r8.f5627a;	 Catch:{  }
            r1.ac = r0;	 Catch:{  }
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.ExoServiceHandlerCallback.handleMessage(android.os.Message):boolean");
        }
    }

    /* compiled from: oxygen_map_static_map_render_time_ns */
    class C02353 implements Runnable {
        final /* synthetic */ ExoVideoPlayerClient f5628a;

        C02353(ExoVideoPlayerClient exoVideoPlayerClient) {
            this.f5628a = exoVideoPlayerClient;
        }

        public void run() {
            this.f5628a.f5610W.m5594a();
        }
    }

    /* compiled from: oxygen_map_static_map_render_time_ns */
    class C02361 implements Runnable {
        final /* synthetic */ ExoVideoPlayerClient f5632a;

        C02361(ExoVideoPlayerClient exoVideoPlayerClient) {
            this.f5632a = exoVideoPlayerClient;
        }

        public void run() {
            ExoVideoPlayerClient.m6014N(this.f5632a);
        }
    }

    /* compiled from: oxygen_map_static_map_render_time_ns */
    class ServiceListenerStub extends Stub {
        private final Object f5633a;
        private final WeakReference<ExoVideoPlayerClient> f5634b;
        private volatile ExecutorService f5635c;

        public final void m6125a(int i, int i2, int i3) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
        }

        public final void m6126a(int i, int i2, int i3, float f) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            ExoVideoPlayerClient f2 = m6119f();
            switch (i) {
                case 10:
                case 11:
                    m6115b(f2, i2, i3, f);
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 3(this, i, f2, i2, i3, f), -1515760587);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        public final void m6128a(int i, int i2, String str, String str2) {
            String str3 = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
        }

        public final void m6129a(int i, int i2, boolean z) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
        }

        public final void m6130a(int i, long j) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            ExoVideoPlayerClient f = m6119f();
            switch (i) {
                case 10:
                case 11:
                    ExoVideoPlayerClient.m6044b(f, j);
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 11(this, i, f, j), 234498445);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        public final void m6131a(int i, MediaRenderer mediaRenderer, MediaRenderer mediaRenderer2, RendererContext rendererContext) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            ExoVideoPlayerClient f = m6119f();
            switch (i) {
                case 10:
                case 11:
                    m6116b(f, mediaRenderer, mediaRenderer2, rendererContext);
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 2(this, i, f, mediaRenderer, mediaRenderer2, rendererContext), 1212303645);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        public final void m6132a(int i, VideoPlayerSession videoPlayerSession, boolean z, int i2, int i3) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            ExoVideoPlayerClient f = m6119f();
            switch (i) {
                case 10:
                case 11:
                    m6117b(f, videoPlayerSession, z, i2, i3);
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 1(this, i, f, videoPlayerSession, z, i2, i3), -1433028245);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        public final void m6146b(int i) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            ExoVideoPlayerClient f = m6119f();
            switch (i) {
                case 10:
                case 11:
                    f.m6058C();
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 6(this, i, f), 880672495);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        public final void m6147b(int i, int i2) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
        }

        public final void m6148b(int i, int i2, boolean z) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
        }

        public final void m6151c(int i) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            ExoVideoPlayerClient f = m6119f();
            switch (i) {
                case 10:
                case 11:
                    f.m6059D();
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 7(this, i, f), -1067366770);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        public final void m6152c(int i, int i2) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
        }

        public final void m6154d(int i) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            ExoVideoPlayerClient f = m6119f();
            switch (i) {
                case 10:
                case 11:
                    f.m6060E();
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 9(this, i, f), 293142468);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        public final void m6155e(int i) {
            String str = ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            BaseVideoPlayer f = m6119f();
            switch (i) {
                case 10:
                case 11:
                    f.mo503e(EventTriggerType.BY_LIVE_STREAM_EOF);
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 10(this, i, f), -1966137268);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        protected ServiceListenerStub(ExoVideoPlayerClient exoVideoPlayerClient) {
            this.f5633a = new Object();
            this.f5634b = new WeakReference(exoVideoPlayerClient);
            this.f5635c = null;
        }

        private ServiceListenerStub() {
            this.f5633a = new Object();
            this.f5634b = null;
            this.f5635c = null;
        }

        public final void m6141a(VideoPlayerSession videoPlayerSession, boolean z, int i, int i2) {
            m6132a(10, videoPlayerSession, z, i, i2);
        }

        public final void m6140a(MediaRenderer mediaRenderer, MediaRenderer mediaRenderer2, RendererContext rendererContext) {
            m6131a(10, mediaRenderer, mediaRenderer2, rendererContext);
        }

        public final void m6124a(int i, int i2, float f) {
            m6126a(10, i, i2, f);
        }

        public final void m6133a(int i, VideoPlayerStreamFormat videoPlayerStreamFormat, int i2, int i3, long j) {
            m6127a(10, i, videoPlayerStreamFormat, i2, i3, j);
        }

        public final void m6143a(String str, String str2, long j) {
            m6136a(10, str, str2, j);
        }

        public final void m6121a() {
            m6146b(10);
        }

        public final void m6145b() {
            m6151c(10);
        }

        public final void m6144a(List<VideoPlayerMediaChunk> list, long j, VideoPlayerStreamFormat[] videoPlayerStreamFormatArr, VideoPlayerStreamEvaluation videoPlayerStreamEvaluation) {
            m6137a(10, (List) list, j, videoPlayerStreamFormatArr, videoPlayerStreamEvaluation);
        }

        public final void m6150c() {
            m6154d(10);
        }

        public final void m6135a(int i, String str, String str2) {
            m6128a(10, i, str, str2);
        }

        public final void m6138a(int i, boolean z) {
            m6129a(10, i, z);
        }

        public final void m6123a(int i, int i2) {
            m6125a(10, i, i2);
        }

        public final void m6122a(int i) {
            m6152c(10, i);
        }

        public final void m6149b(int i, boolean z) {
            m6148b(10, i, z);
        }

        public final void m6153d() {
            m6155e(10);
        }

        public final void m6142a(String str, ExoServiceRtmpStreamStats exoServiceRtmpStreamStats) {
            m6134a(10, str, exoServiceRtmpStreamStats);
        }

        public final void m6139a(long j) {
            m6130a(10, j);
        }

        public static void m6117b(ExoVideoPlayerClient exoVideoPlayerClient, VideoPlayerSession videoPlayerSession, boolean z, int i, int i2) {
            try {
                exoVideoPlayerClient.m6066a(videoPlayerSession, z, i, i2);
            } catch (RemoteException e) {
                ExoVideoPlayerClient.aQ;
            }
        }

        public static void m6116b(ExoVideoPlayerClient exoVideoPlayerClient, MediaRenderer mediaRenderer, MediaRenderer mediaRenderer2, RendererContext rendererContext) {
            try {
                exoVideoPlayerClient.m6065a(mediaRenderer, mediaRenderer2, rendererContext);
            } catch (RemoteException e) {
                ExoVideoPlayerClient.aQ;
            }
        }

        public static void m6115b(ExoVideoPlayerClient exoVideoPlayerClient, int i, int i2, float f) {
            if (!ExoVideoPlayerClient.m6052c(null) || exoVideoPlayerClient.bd % 180 == 0) {
                exoVideoPlayerClient.m6062a(i, i2);
            } else {
                exoVideoPlayerClient.m6062a(i2, i);
            }
        }

        public final void m6127a(int i, int i2, VideoPlayerStreamFormat videoPlayerStreamFormat, int i3, int i4, long j) {
            ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            ExoVideoPlayerClient f = m6119f();
            switch (i) {
                case 10:
                case 11:
                    f.m6063a(i2, videoPlayerStreamFormat, i3, i4, j);
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 4(this, i, f, i2, videoPlayerStreamFormat, i3, i4, j), -1065830139);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        public final void m6136a(int i, String str, String str2, long j) {
            ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            ExoVideoPlayerClient f = m6119f();
            switch (i) {
                case 10:
                case 11:
                    f.m6078a(str, str2, j);
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 5(this, i, f, str, str2, j), -1603494770);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        public final void m6137a(int i, List<VideoPlayerMediaChunk> list, long j, VideoPlayerStreamFormat[] videoPlayerStreamFormatArr, VideoPlayerStreamEvaluation videoPlayerStreamEvaluation) {
            ExoVideoPlayerClient.aQ;
            Integer.valueOf(i);
            ExoVideoPlayerClient f = m6119f();
            switch (i) {
                case 10:
                case 11:
                    f.m6080a((List) list, j, videoPlayerStreamFormatArr, videoPlayerStreamEvaluation);
                    return;
                case 12:
                    ExecutorDetour.a(m6118e(), new 8(this, i, f, list, j, videoPlayerStreamFormatArr, videoPlayerStreamEvaluation), -921038015);
                    return;
                default:
                    m6120f(i);
                    return;
            }
        }

        private ExecutorService m6118e() {
            ExecutorService executorService = this.f5635c;
            if (executorService == null) {
                synchronized (this.f5633a) {
                    executorService = this.f5635c;
                    if (executorService != null) {
                    } else {
                        executorService = Executors.newSingleThreadExecutor(new 12(this));
                        this.f5635c = executorService;
                    }
                }
            }
            return executorService;
        }

        private ExoVideoPlayerClient m6119f() {
            ExoVideoPlayerClient exoVideoPlayerClient = (ExoVideoPlayerClient) this.f5634b.get();
            if (exoVideoPlayerClient != null) {
                return exoVideoPlayerClient;
            }
            throw new IllegalStateException("ExoVideoPlayerClient Weak Ref reclaimed");
        }

        private static void m6120f(int i) {
            throw new IllegalArgumentException("Call Option " + i + " not valid!");
        }

        public final void m6134a(int i, String str, ExoServiceRtmpStreamStats exoServiceRtmpStreamStats) {
        }
    }

    /* compiled from: oxygen_map_static_map_render_time_ns */
    class C02388 implements Runnable {
        final /* synthetic */ ExoVideoPlayerClient f5650a;

        C02388(ExoVideoPlayerClient exoVideoPlayerClient) {
            this.f5650a = exoVideoPlayerClient;
        }

        public void run() {
            ExoVideoPlayerClient.m6016Q(this.f5650a);
        }
    }

    public ExoVideoPlayerClient(Context context, AttributeSet attributeSet, int i, VideoPlayerViewProvider videoPlayerViewProvider, VideoPlayerListener videoPlayerListener, VideoLoggingUtils videoLoggingUtils, ListeningExecutorService listeningExecutorService, Boolean bool, boolean z, AndroidThreadUtil androidThreadUtil, VideoPlayerSessionManager videoPlayerSessionManager, MonotonicClock monotonicClock, VideoExoplayerConfig videoExoplayerConfig, SubtitleAdapter subtitleAdapter, SubtitleMediaTimeProvider subtitleMediaTimeProvider, SubtitleListener subtitleListener, InitializationSequenceLogger initializationSequenceLogger, VideoEngineUtils videoEngineUtils, BytesViewedLogger bytesViewedLogger, Lazy<NativePlayerPool> lazy, Provider<VideoPlayerServiceApi> provider, TypedEventBus typedEventBus, boolean z2, VideoDashConfig videoDashConfig, DeviceConditionHelper deviceConditionHelper, BandwidthMeter bandwidthMeter, FbDataConnectionManager fbDataConnectionManager, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, boolean z3, VideoPlayRequestBuilder videoPlayRequestBuilder, @Nullable Looper looper, RtmpPlaybackInitPerfLogger rtmpPlaybackInitPerfLogger, VideoLivePlaybackConfig videoLivePlaybackConfig, LiveStreamingSubscriberPool liveStreamingSubscriberPool, FbErrorReporter fbErrorReporter, NetworkInfoCollector networkInfoCollector) {
        super(context, attributeSet, i, videoPlayerViewProvider, lazy, videoPlayerListener, subtitleListener, subtitleAdapter, null, androidThreadUtil, bool, z, monotonicClock, initializationSequenceLogger, videoEngineUtils, bytesViewedLogger, videoLoggingUtils, qeAccessor, gatekeeperStore, videoLivePlaybackConfig);
        TracerDetour.a("ExoVideoPlayerClient.initVariables", -1537425186);
        try {
            android.os.Handler handler;
            this.ae = provider;
            this.af = typedEventBus;
            this.I = null;
            this.ac = null;
            this.aO = null;
            this.aP = null;
            this.ai = 1;
            this.aj = 1;
            this.aX = z2;
            this.aV = (int) (Math.random() * 2.147483647E9d);
            this.f5611X = SizeUtil.a(this.f5230b, 300.0f);
            this.aZ = listeningExecutorService;
            this.ay = -1;
            this.J = VideoPlayerParams.newBuilder().m5271m();
            this.aB = videoPlayerSessionManager;
            this.N = new StallTimeCalculation(this.f5241m);
            this.O = new StallTimeCalculation(this.f5241m);
            m5708a(this.f5212D);
            m5713b(this.f5213E);
            this.aE = videoExoplayerConfig;
            this.aF = videoDashConfig;
            this.aG = deviceConditionHelper;
            this.aH = bandwidthMeter;
            this.aI = fbDataConnectionManager;
            this.aU = z3;
            this.aJ = networkInfoCollector;
            this.f5236h.m5643a(subtitleMediaTimeProvider);
            this.f5236h.m5642a(new InternalSubtitleListener(this));
            this.bb = videoPlayRequestBuilder;
            this.aT = new PlaybackPreferences();
            this.f5612Y = new ExoServiceHandlerCallback(this);
            if (looper == null) {
                handler = new android.os.Handler(this.f5612Y);
            } else {
                handler = new android.os.Handler(looper, this.f5612Y);
            }
            this.f5613Z = handler;
            this.ba = rtmpPlaybackInitPerfLogger;
            this.bh = 1;
            this.bk = liveStreamingSubscriberPool;
            TracerDetour.a("ExoVideoPlayerClient.registerOn", 397032349);
            try {
                this.f5610W = initializationSequenceLogger;
                this.f5610W.m5595a(this.f5245q);
                this.f5242n.m5634a(this.f5245q);
                this.bg = videoExoplayerConfig.J;
                this.aa = fbErrorReporter;
            } finally {
                TracerDetour.a(2085426276);
            }
        } finally {
            TracerDetour.a(722286425);
        }
    }

    private void m6008H() {
        synchronized (this.bf) {
            if (!this.be) {
                this.be = true;
                this.ad = (VideoPlayerServiceApi) this.ae.get();
                this.af.a(VideoServiceConnectedEvent.class, this);
                this.af.a(VideoServiceDisconnectedEvent.class, this);
            }
        }
    }

    private void m6009I() {
        synchronized (this.bf) {
            if (this.be) {
                this.af.b(VideoServiceConnectedEvent.class, this);
                this.af.b(VideoServiceDisconnectedEvent.class, this);
                this.be = false;
            }
        }
    }

    public final void m6077a(VideoServiceConnectedEvent videoServiceConnectedEvent) {
        long uptimeMillis;
        mo484a("onVideoServiceConnected", new Object[0]);
        this.ad = (VideoPlayerServiceApi) videoServiceConnectedEvent.a;
        if (this.aC != -1) {
            uptimeMillis = SystemClock.uptimeMillis() - this.aC;
            this.aC = -1;
        } else {
            uptimeMillis = -1;
        }
        this.f5235g.a(this.f5253y.value, this.f5218J.f4833b, uptimeMillis);
        if (!m6019T() && mo506i()) {
            m6013M();
        }
    }

    public final void m6086c() {
        mo484a("onVideoServiceDisconnected", new Object[0]);
        this.f5235g.b(this.f5253y.value, this.f5218J.f4833b);
        if (this.aC == -1) {
            this.aC = SystemClock.uptimeMillis();
        }
        if (this.f5212D == PlayerState.STATE_PREPARING || this.f5212D == PlayerState.STATE_PREPARED || this.f5212D == PlayerState.STATE_PLAYING) {
            this.f5235g.a("ExoPlayer Error: video player service disconnected; current state: " + this.f5212D, this.f5253y.value, this.f5218J.f4833b, this.al, this.f5254z.value, this.f5251w, mo496r(), this.f5218J, null);
        }
        if (m6019T()) {
            mo484a("onVideoServiceDisconnected, notify paused", new Object[0]);
            this.f5245q.a(new AsyncVideo$PlayPausedEvent(0, UserReason.f5368b));
        }
        this.ai = 1;
        m5708a(PlayerState.STATE_IDLE);
        this.ab = null;
        this.ad = null;
        m6051c(this, "Service disconnected", new Object[0]);
    }

    public static boolean m6010J(ExoVideoPlayerClient exoVideoPlayerClient) {
        return exoVideoPlayerClient.ad != null;
    }

    public static boolean m6011K(ExoVideoPlayerClient exoVideoPlayerClient) {
        return m6010J(exoVideoPlayerClient) && exoVideoPlayerClient.ab != null;
    }

    private boolean m6012L() {
        return m6011K(this) && this.ai == 3;
    }

    private void m6028a(Uri uri) {
        boolean z = uri != null && m6010J(this);
        Preconditions.checkArgument(z);
        mo484a("startVideoSession for %s", uri);
        if (!(m6011K(this) && VideoDataSource.m5250a(uri, this.al))) {
            boolean z2;
            if (!VideoDataSource.m5250a(uri, this.al)) {
                this.al = uri;
            }
            String str = (this.f5253y.equals(PlayerType.CHANNEL_PLAYER) || this.f5253y.equals(PlayerType.FULL_SCREEN_PLAYER)) ? this.f5253y.value : null;
            if (this.aF.a(this.aG, this.aT.f()) < 0 || !this.f5235g.a(this.f5218J.f4833b, 0)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.bb.m6104a(this.ap) && this.aF.d() && ((this.aF.l == DashAbrPolicy.CUSTOM_ABR || this.aF.l == DashAbrPolicy.MANUAL) && this.aE.i)) {
                this.aK = FormatEvaluatorFactory.a(this.aF, this.aT, this.aH, z2, this.aG, this.aI, this.aJ);
            }
            m6029a(this.f5613Z.obtainMessage(2, this.bb.m6103a(this.f5218J.f4833b, str, uri, this.ao, this.ap)));
        }
        m6029a(this.f5613Z.obtainMessage(1));
        m6029a(this.f5613Z.obtainMessage(0, uri));
    }

    private void m6013M() {
        if (this.aE.j) {
            ExecutorDetour.a(this.aZ, new C02361(this), -1870620806);
        } else {
            m6014N(this);
        }
    }

    public static void m6014N(ExoVideoPlayerClient exoVideoPlayerClient) {
        exoVideoPlayerClient.mo484a("Initializing ExoPlayer", new Object[0]);
        exoVideoPlayerClient.m6008H();
        exoVideoPlayerClient.m5708a(PlayerState.STATE_IDLE);
        exoVideoPlayerClient.az = 0;
        boolean S;
        do {
            try {
                if (exoVideoPlayerClient.al != null) {
                    exoVideoPlayerClient.mo484a("Set data source = %s", exoVideoPlayerClient.al);
                    exoVideoPlayerClient.f5242n.m5633a(exoVideoPlayerClient.al);
                    exoVideoPlayerClient.f5242n.m5631a(exoVideoPlayerClient.as);
                    exoVideoPlayerClient.m6042b(exoVideoPlayerClient.al);
                    return;
                }
                exoVideoPlayerClient.mo484a("Data source is invalid. Try next one.", new Object[0]);
                S = exoVideoPlayerClient.m6018S();
                if (S) {
                    continue;
                } else {
                    exoVideoPlayerClient.mo484a("No data source!", new Object[0]);
                    if (exoVideoPlayerClient.f5234f != null) {
                        exoVideoPlayerClient.f5240l.b(new 2(exoVideoPlayerClient));
                        continue;
                    } else {
                        continue;
                    }
                }
            } catch (NullPointerException e) {
                exoVideoPlayerClient.mo484a("dataSourceNPE", new Object[0]);
                r1 = exoVideoPlayerClient.m6018S();
                boolean S2;
                if (S2) {
                    S = S2;
                    continue;
                } else {
                    throw e;
                }
            } catch (Throwable e2) {
                exoVideoPlayerClient.f5235g.a(e2.getMessage(), exoVideoPlayerClient.f5253y.value, exoVideoPlayerClient.f5218J.f4833b, exoVideoPlayerClient.al, exoVideoPlayerClient.f5254z.value, exoVideoPlayerClient.f5251w, exoVideoPlayerClient.mo496r(), exoVideoPlayerClient.f5218J, e2);
                exoVideoPlayerClient.mo484a("Caught IllegalStateException - Unable to open content %s", exoVideoPlayerClient.al);
                m6036a(exoVideoPlayerClient, VideoError.UNKNOWN, e2, 0);
                return;
            } catch (Throwable e22) {
                exoVideoPlayerClient.f5235g.a(e22.getMessage(), exoVideoPlayerClient.f5253y.value, exoVideoPlayerClient.f5218J.f4833b, exoVideoPlayerClient.al, exoVideoPlayerClient.f5254z.value, exoVideoPlayerClient.f5251w, exoVideoPlayerClient.mo496r(), exoVideoPlayerClient.f5218J, e22);
                exoVideoPlayerClient.mo484a("Caught NullPointerException - Unable to open content %s", exoVideoPlayerClient.al);
                m6036a(exoVideoPlayerClient, VideoError.UNKNOWN, e22, 0);
                return;
            }
        } while (S);
    }

    private void m6042b(Uri uri) {
        boolean z = false;
        mo484a("prepareAsync", new Object[0]);
        if (uri == null) {
            mo484a("Try prepareVideo but uri is null", new Object[0]);
        } else if (m6010J(this)) {
            m5708a(PlayerState.STATE_PREPARING);
            this.f5245q.a(new AllocationBeginEvent());
            this.aT.a(false);
            this.aT.a(this.f5218J.f4833b);
            PlaybackPreferences playbackPreferences = this.aT;
            if (this.f5218J.f4850s != null) {
                z = true;
            }
            playbackPreferences.c(z);
            m6028a(uri);
            this.f5245q.a(new PreparationBeginEvent());
            if (this.f5234f != null) {
                this.f5234f.mo460b();
            }
            VideoPlayerSessionBase videoPlayerSession = new com.facebook.video.api.playersession.VideoPlayerSession(this, CallerContext.a(this.f5230b));
            videoPlayerSession.m6160a(this.f5218J.f4849r);
            videoPlayerSession.m6162b(this.as);
            this.aA = VideoServer.a(this.al);
            this.aB.a(this.aA, videoPlayerSession);
            this.bd = -1;
            if (m6052c(null)) {
                synchronized (this.bl) {
                    m6017R();
                }
            }
        } else {
            m6051c(this, "Try prepareVideo but no service connected", new Object[0]);
        }
    }

    private void m6015O() {
        this.f5240l.a(new C02353(this));
    }

    public final void mo493f() {
        m6032a(ReleaseCaller.EXTERNAL, true);
    }

    protected final void mo480a(ReleaseCaller releaseCaller) {
        if (!ReleaseCaller.FROM_DESTROY_SURFACE.equals(releaseCaller) || (this.f5218J.f4839h && this.f5247s.O)) {
            m6032a(releaseCaller, true);
        } else {
            m6032a(releaseCaller, false);
        }
    }

    private void m6032a(ReleaseCaller releaseCaller, boolean z) {
        m6033a(releaseCaller, z, false);
    }

    private void m6033a(ReleaseCaller releaseCaller, boolean z, boolean z2) {
        this.G = "release";
        mo484a("%s, %s, right away? %s", this.f5215G, releaseCaller.value, Boolean.valueOf(z));
        m6015O();
        this.f5236h.m5647d();
        m6043b(releaseCaller, z, z2);
    }

    private void m6043b(ReleaseCaller releaseCaller, final boolean z, boolean z2) {
        mo484a("unprepare ExoPlayer from %s", releaseCaller.value);
        this.aB.a(this.aA);
        this.aA = -1;
        final boolean T = m6019T();
        if (m6011K(this)) {
            if (!this.aE.j || z) {
                m6035a(this, this.ab, T, z);
            } else {
                ExecutorDetour.a(this.aZ, new Runnable(this) {
                    final /* synthetic */ ExoVideoPlayerClient f5668c;

                    public void run() {
                        ExoVideoPlayerClient.m6035a(this.f5668c, this.f5668c.ab, T, z);
                    }
                }, -1118925619);
            }
        }
        m5708a(PlayerState.STATE_IDLE);
        this.aj = 1;
        this.ai = 1;
        if (!z2) {
            m5713b(PlayerState.STATE_IDLE);
        }
        this.aP = null;
        this.aO = null;
        this.F = null;
        this.az = 0;
        this.ay = -1;
        this.bj = false;
    }

    public final void mo474a(EventTriggerType eventTriggerType) {
        mo476a(eventTriggerType, PlayPosition.f5359a);
    }

    public final void mo476a(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        this.G = "play";
        this.bi = eventTriggerType;
        mo484a("%s, %s, posiiton: %s", this.f5215G, eventTriggerType.value, playPosition);
        if (this.f5213E == PlayerState.STATE_ERROR) {
            mo484a("This player enters final error target state, should not be used anymore", new Object[0]);
            return;
        }
        this.aB.a(this.aA, SessionState.START);
        this.f5245q.a(new AsyncVideo$PlayRequestedEvent(playPosition.f5361c, UserReason.f5368b));
        if (playPosition.m5853b()) {
            this.ay = playPosition.f5361c;
        }
        if (this.f5213E == PlayerState.STATE_PLAYING) {
            int i = 1;
        } else {
            boolean z = false;
        }
        m6050c(eventTriggerType, playPosition);
        if (m6019T()) {
            if (this.aR != null && this.aR.m14926d()) {
                m6049c(this.aR.f14117h);
            }
            if (this.f5217I != null) {
                m6049c(this.f5217I);
            }
            if (this.aY == null) {
                m6029a(this.f5613Z.obtainMessage(1));
            }
            m6045b(this, eventTriggerType, playPosition);
            m6037a(eventTriggerType, playPosition, false);
            return;
        }
        Object obj;
        if (i == 0) {
            m6045b(this, eventTriggerType, playPosition);
        }
        if (this.f5212D == PlayerState.STATE_PREPARING || this.f5212D == PlayerState.STATE_PREPARED || this.f5212D == PlayerState.STATE_PLAYING || this.f5212D == PlayerState.STATE_PAUSED) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            m6013M();
        } else if (this.aY == null) {
            m6029a(this.f5613Z.obtainMessage(1));
        }
    }

    public static void m6045b(ExoVideoPlayerClient exoVideoPlayerClient, EventTriggerType eventTriggerType, PlayPosition playPosition) {
        exoVideoPlayerClient.f5222N.a();
        exoVideoPlayerClient.f5222N.b();
        if (!m6056l(eventTriggerType)) {
            int b = playPosition != PlayPosition.f5359a ? playPosition.f5361c : exoVideoPlayerClient.mo487b();
            exoVideoPlayerClient.f5235g.a(exoVideoPlayerClient.f5218J.f4836e, exoVideoPlayerClient.f5253y.value, eventTriggerType.value, b, exoVideoPlayerClient.f5227S.value, exoVideoPlayerClient.f5218J.f4833b, exoVideoPlayerClient.f5251w, null, exoVideoPlayerClient.f5254z.value, exoVideoPlayerClient.mo496r(), exoVideoPlayerClient.f5252x, exoVideoPlayerClient.f5218J.f4837f, exoVideoPlayerClient.f5218J.f4835d, exoVideoPlayerClient.f5218J);
            exoVideoPlayerClient.ba.a(exoVideoPlayerClient.f5218J.f4839h, exoVideoPlayerClient.f5218J.f4833b, exoVideoPlayerClient.hashCode(), exoVideoPlayerClient.f5235g.a(exoVideoPlayerClient.f5218J.f4833b, b), exoVideoPlayerClient.f5251w.origin, exoVideoPlayerClient.f5253y.value);
        }
    }

    private void m6050c(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        this.R = eventTriggerType;
        this.C = playPosition;
        m5713b(PlayerState.STATE_PLAYING);
    }

    private boolean m6037a(final EventTriggerType eventTriggerType, final PlayPosition playPosition, boolean z) {
        Preconditions.checkNotNull(playPosition);
        if (this.f5213E != PlayerState.STATE_PLAYING) {
            m6047b(new Throwable("Cannot Play Now. In State: " + this.f5213E), "Cannot play now.  Require target state %s. In target state %s", PlayerState.STATE_PLAYING, this.f5213E);
            return false;
        }
        mo484a("playNow", new Object[0]);
        this.L = true;
        this.M = eventTriggerType;
        this.K = -1;
        m6030a(new VideoEvents$StartingEvent(playPosition.f5361c, UserReason.f5368b));
        if (this.f5234f != null) {
            this.f5240l.b(new Runnable(this) {
                final /* synthetic */ ExoVideoPlayerClient f5649b;

                public void run() {
                    this.f5649b.f5234f.mo449a(eventTriggerType, true);
                }
            });
        }
        boolean z2 = m6056l(eventTriggerType) && this.f5247s.v;
        Object obj = (this.ay == -1 || !m5711a(z2)) ? null : 1;
        if (obj != null) {
            mo484a("Seek to: %s", Integer.valueOf(this.ay));
            m6029a(this.f5613Z.obtainMessage(3, this.ay, 0));
        }
        if (!this.aX || m6052c(null)) {
            mo497v();
        }
        m6029a(this.f5613Z.obtainMessage(4, Boolean.valueOf(true)));
        this.f5222N.c();
        this.Q = 0;
        m5708a(PlayerState.STATE_PLAYING);
        final int b = obj != null ? this.ay : mo487b();
        this.f5236h.m5645b();
        z2 = this.f5235g.a(this.f5218J.f4833b, 0);
        if (m6056l(eventTriggerType)) {
            this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, this.f5224P.value, eventTriggerType.value, b, this.f5218J.f4833b, this.f5251w, this.f5254z.value, this.f5218J.f4837f);
        } else if (z2 || !z) {
            mo475a(eventTriggerType, b);
            this.ba.a(this.f5218J.f4839h, this.f5218J.f4833b, hashCode(), true, this.f5224P.value);
        } else {
            mo484a("InternalRetry, skip logging", new Object[0]);
        }
        this.f5222N.a();
        this.f5240l.b(new Runnable(this) {
            final /* synthetic */ ExoVideoPlayerClient f5653c;

            public void run() {
                this.f5653c.f5245q.a(new AsyncVideo$PlayStartedEvent(playPosition.f5361c, b, UserReason.f5368b));
                this.f5653c.f5610W.m5594a();
            }
        });
        if (playPosition.m5852a() && (!this.f5218J.f4839h || !this.f5247s.o)) {
            this.B = playPosition.f5362d;
        } else if (!m6056l(eventTriggerType)) {
            this.B = b;
        }
        if (this.aW != -1) {
            this.aW = this.f5210B;
        }
        this.aD = this.f5241m.now();
        return true;
    }

    public final void mo489b(final EventTriggerType eventTriggerType) {
        this.G = "stop";
        mo484a("%s, %s", this.f5215G, eventTriggerType.value);
        m6015O();
        if (this.f5212D == PlayerState.STATE_PREPARING) {
            this.f5226R = eventTriggerType;
            m5713b(PlayerState.STATE_IDLE);
        } else if (m6019T()) {
            if (this.f5234f != null) {
                this.f5240l.b(new Runnable(this) {
                    final /* synthetic */ ExoVideoPlayerClient f5895b;

                    public void run() {
                        this.f5895b.f5234f.mo464c(eventTriggerType, true);
                    }
                });
            }
            this.aB.a(this.aA);
            this.aA = -1;
            m6053i(eventTriggerType);
            if (this.f5234f != null) {
                this.f5240l.a(new Runnable(this) {
                    final /* synthetic */ ExoVideoPlayerClient f5897b;

                    public void run() {
                        this.f5897b.f5234f.mo448a(eventTriggerType);
                    }
                });
            }
        }
        this.aD = -1;
    }

    private void m6053i(EventTriggerType eventTriggerType) {
        mo484a("resetNow", new Object[0]);
        m6029a(this.f5613Z.obtainMessage(5, this.ab));
        this.f5236h.m5647d();
        if (eventTriggerType != EventTriggerType.BY_AUTOPLAY) {
            this.f5235g.b(this.f5218J.f4836e, this.f5253y.value, this.f5224P.value, eventTriggerType.value, mo487b(), this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, this.f5218J.f4837f);
        }
        m5708a(PlayerState.STATE_IDLE);
        m5713b(PlayerState.STATE_IDLE);
        this.az = 0;
        this.aD = -1;
        this.B = 0;
    }

    public final void mo490c(EventTriggerType eventTriggerType) {
        super.mo490c(eventTriggerType);
        m6054j(eventTriggerType);
    }

    private void m6054j(EventTriggerType eventTriggerType) {
        m6015O();
        aa();
        if (this.f5249u || this.az > 99) {
            this.ay = -1;
            m6055k(eventTriggerType);
        } else if (this.f5212D == PlayerState.STATE_PREPARING) {
            mo484a("seek time = %s", Integer.valueOf(this.ay));
            if ((this.f5211C != null ? 1 : null) != null) {
                this.B = this.f5211C.f5362d;
                this.ay = this.f5211C.f5361c;
                this.f5235g.a(this.f5253y.value, this.f5224P.value, this.f5218J.f4833b, this.ay, ab(), this.f5251w, this.f5254z.value, this.f5229U, StreamRepresentationEventSource.PAUSED);
                this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, this.f5224P.value, eventTriggerType.value, this.ay, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, mo496r(), this.f5218J.f4837f, null, this.f5218J);
            }
            mo489b(eventTriggerType);
        } else {
            if (!eventTriggerType.value.equals(EventTriggerType.BY_ANDROID.value)) {
                this.ay = mo487b();
                if ((this.aD != -1 && this.f5241m.now() - this.aD < 1000) || this.ay < this.f5210B) {
                    this.ay = this.f5210B;
                }
            }
            mo484a("stop-for-pause: %s , seek time = %s", eventTriggerType.value, Integer.valueOf(this.ay));
            if (!m6056l(eventTriggerType)) {
                this.f5235g.a(this.f5253y.value, this.f5224P.value, this.f5218J.f4833b, this.ay, ab(), this.f5251w, this.f5254z.value, this.f5229U, StreamRepresentationEventSource.PAUSED);
                this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, this.f5224P.value, eventTriggerType.value, this.ay - this.f5225Q, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, mo496r(), this.f5218J.f4837f, null, this.f5218J);
            }
            this.f5245q.a(new AsyncVideo$PlayPausedEvent(this.ay, UserReason.f5368b));
            mo489b(eventTriggerType);
        }
        m5702A();
        this.aD = -1;
        this.bj = false;
    }

    private void m6055k(EventTriggerType eventTriggerType) {
        this.G = "pause";
        mo484a("%s, %s", this.f5215G, eventTriggerType.value);
        if (this.f5212D == PlayerState.STATE_PAUSED) {
            m5713b(PlayerState.STATE_PAUSED);
        } else if (this.f5212D == PlayerState.STATE_PREPARING) {
            mo531f(eventTriggerType);
        } else if (m6019T()) {
            if (this.f5234f != null) {
                this.f5234f.mo462b(eventTriggerType, true);
            }
            mo494g(eventTriggerType);
            if (this.f5234f != null) {
                this.f5234f.mo454b(eventTriggerType);
            }
        }
    }

    protected final void mo531f(EventTriggerType eventTriggerType) {
        super.mo531f(eventTriggerType);
        this.ba.a(this.f5218J.f4839h, this.f5218J.f4833b, hashCode(), false, null);
    }

    private static boolean m6056l(EventTriggerType eventTriggerType) {
        return BaseVideoPlayer.f5208a.contains(eventTriggerType);
    }

    @VisibleForTesting
    protected final void mo494g(EventTriggerType eventTriggerType) {
        m6029a(this.f5613Z.obtainMessage(4, Boolean.valueOf(false)));
        this.f5236h.m5646c();
        m5708a(PlayerState.STATE_PAUSED);
        m5713b(PlayerState.STATE_PAUSED);
        this.aB.a(this.aA, SessionState.PAUSED);
        if (this.f5248t.booleanValue() && eventTriggerType == EventTriggerType.BY_USER && this.f5234f != null) {
            this.f5234f.mo463c();
            if (this.aR.m14926d()) {
                mo510n();
                double a = VideoRenderUtils.m6002a(this.f5611X, this.aR.m14928h(), this.aR.m14929i());
                this.H = this.aR.m14921a(a, a);
                this.f5234f.mo447a(this.f5216H);
            }
        }
        int b = mo487b();
        this.f5223O.d();
        if (m6056l(eventTriggerType)) {
            this.f5235g.a(this.f5218J.f4836e, this.f5253y.value, this.f5224P.value, eventTriggerType.value, b, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, this.f5218J.f4837f);
        } else {
            this.f5235g.b(this.f5253y.value, this.f5224P.value, this.f5218J.f4833b, b, ab(), this.f5251w, this.f5254z.value, this.f5229U, StreamRepresentationEventSource.PAUSED);
            this.f5235g.b(this.f5218J.f4836e, this.f5253y.value, this.f5224P.value, eventTriggerType.value, b - this.f5225Q, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, mo496r(), this.f5218J.f4837f, this.f5223O, this.f5218J);
            this.f5223O.a();
            this.Q = 0;
        }
        this.f5245q.a(new AsyncVideo$PlayPausedEvent(b, UserReason.f5368b));
    }

    public final void mo473a(int i, EventTriggerType eventTriggerType) {
        this.G = "seekTo";
        mo484a("seekTo %s (%s)", Integer.valueOf(i), eventTriggerType);
        this.B = i;
        switch (this.f5212D) {
            case STATE_PREPARING:
                this.ay = i;
                return;
            case STATE_IDLE:
                this.ay = i;
                return;
            default:
                if (m6019T() && m5735y()) {
                    m6041b(i);
                    return;
                }
                return;
        }
    }

    private void m6041b(int i) {
        if (m6012L()) {
            m6029a(this.f5613Z.obtainMessage(3, i, 0));
            this.f5236h.m5641a(i);
        }
    }

    public final void mo485a(boolean z, EventTriggerType eventTriggerType) {
        this.G = "mute";
        m6040b(z ? 0.0f : 1.0f);
    }

    private void m6040b(float f) {
        this.ak = Math.max(0.0f, Math.min(1.0f, f));
        if (m6012L() && this.ah != null) {
            m6029a(this.f5613Z.obtainMessage(6, Float.valueOf(this.ak)));
        }
    }

    public final void mo471a(float f) {
        this.G = "setVolume";
        m6040b(f);
    }

    public final void mo479a(VideoResolution videoResolution, EventTriggerType eventTriggerType) {
        this.G = "setVideoResolution";
        mo484a(this.f5215G, new Object[0]);
        this.aw = videoResolution;
        Queue linkedList = new LinkedList();
        if (videoResolution == VideoResolution.HIGH_DEFINITION) {
            this.as = this.au;
            linkedList.add(this.an);
            linkedList.add(this.am);
        } else {
            this.as = this.at;
            linkedList.add(this.am);
            linkedList.add(this.an);
        }
        m6021X();
        if (m6011K(this)) {
            Object obj = PlayerState.STATE_PLAYING == this.f5212D ? 1 : null;
            if (obj != null) {
                mo490c(EventTriggerType.BY_PLAYER);
                this.ay = mo487b();
            }
            while (!linkedList.isEmpty()) {
                Uri uri = (Uri) linkedList.poll();
                if (uri != null) {
                    mo484a("set video resolution with uri: %s", uri);
                    try {
                        m6032a(ReleaseCaller.FROM_SET_VIDEO_RESOLUTION, true);
                        this.f5242n.m5633a(uri);
                        this.f5242n.m5631a(this.as);
                        m6042b(uri);
                        if (obj != null) {
                            m6050c(EventTriggerType.BY_PLAYER, PlayPosition.f5359a);
                            return;
                        } else {
                            m6055k(EventTriggerType.BY_PLAYER);
                            return;
                        }
                    } catch (Throwable e) {
                        if (linkedList.isEmpty()) {
                            this.f5235g.a(e.getMessage(), this.f5253y.value, this.f5218J.f4833b, uri, this.f5254z.value, this.f5251w, mo496r(), this.f5218J, e);
                            mo484a("Caught NullPointerException - Unable to open content %s", this.al);
                            m6036a(this, VideoError.UNKNOWN, e, 0);
                            return;
                        }
                    } catch (Throwable e2) {
                        this.f5235g.a(e2.getMessage(), this.f5253y.value, this.f5218J.f4833b, uri, this.f5254z.value, this.f5251w, mo496r(), this.f5218J, e2);
                        mo484a("Caught IllegalStateException - Unable to open content %s", this.al);
                        m6036a(this, VideoError.UNKNOWN, e2, 0);
                        return;
                    }
                }
            }
        }
    }

    public final void mo477a(VideoSourceType videoSourceType, String str, EventTriggerType eventTriggerType) {
        int i = 1;
        this.G = "switchPlayableUri";
        if (this.f5247s.P) {
            mo484a("SwitchPlayableUri is disabled", new Object[0]);
        } else if (m6011K(this)) {
            Uri uri = this.al;
            Uri parse;
            if (videoSourceType == VideoSourceType.VIDEO_SOURCE_RTMP) {
                if (str != null) {
                    if (!str.equals(this.ar.toString())) {
                        parse = Uri.parse(str);
                        this.ar = parse;
                        this.al = parse;
                    } else {
                        return;
                    }
                }
                this.aq = this.ar;
            } else if (videoSourceType == VideoSourceType.VIDEO_SOURCE_HLS) {
                if (this.aq != null) {
                    this.aq = null;
                    if (str != null) {
                        parse = Uri.parse(str);
                        if (!parse.equals(this.al)) {
                            this.al = parse;
                        } else {
                            return;
                        }
                    }
                }
                return;
            }
            mo484a("SwitchPlayabaleUri, from %s to %s", uri, this.al);
            if (PlayerState.STATE_PLAYING != this.f5212D) {
                i = 0;
            }
            if (i != 0) {
                mo490c(EventTriggerType.BY_PLAYER);
                this.ay = mo487b();
            }
            m6029a(this.f5613Z.obtainMessage(5, this.ab));
            this.aL = 0;
            m6042b(this.al);
        }
    }

    public final VideoResolution mo492e() {
        return this.aw;
    }

    public final long mo515t() {
        if (!m6010J(this)) {
            return -1;
        }
        try {
            long e = this.ad.e(this.ab);
            long g = this.ad.g(this.ab);
            if (g == -1) {
                return -1;
            }
            return Math.min(Math.max(0, ((g - e) * 100) / (e == 0 ? (long) this.aE.o : (long) this.aE.p)), 100);
        } catch (Throwable e2) {
            m6047b(e2, "Failed to fetch video buffer position", new Object[0]);
            return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo478a(com.facebook.video.engine.VideoPlayerParams r10) {
        /*
        r9 = this;
        r4 = 0;
        r1 = 1;
        r2 = 0;
        r0 = "bindVideoSources";
        r9.G = r0;
        r9.m6015O();
        r0 = r9.f5218J;
        if (r0 == 0) goto L_0x0036;
    L_0x000e:
        r0 = r9.f5218J;
        r0 = r0.f4839h;
        if (r0 == 0) goto L_0x0036;
    L_0x0014:
        r0 = r10.f4839h;
        if (r0 != 0) goto L_0x0036;
    L_0x0018:
        r0 = r9.f5218J;
        r0 = r0.f4833b;
        r3 = r10.f4833b;
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0036;
    L_0x0024:
        r0 = "live->VOD transition occurred; clean up player state if necessary";
        r3 = new java.lang.Object[r2];
        r9.mo484a(r0, r3);
        r0 = r9.f5247s;
        r0 = r0.R;
        if (r0 == 0) goto L_0x0036;
    L_0x0031:
        r0 = com.facebook.video.analytics.VideoAnalytics.EventTriggerType.BY_LIVE_POLLER_TRANSITION;
        r9.mo503e(r0);
    L_0x0036:
        r0 = r9.f5218J;
        r0 = r0.f4847p;
        r9.at = r0;
        r0 = r9.f5218J;
        r0 = r0.f4848q;
        r9.au = r0;
        r9.av = r2;
        r9.am = r4;
        r9.an = r4;
        r9.aq = r4;
        r9.ar = r4;
        r0 = com.facebook.video.engine.VideoResolution.STANDARD_DEFINITION;
        r9.aw = r0;
        r9.U = r4;
        r9.aL = r2;
        r9.bh = r1;
        r0 = r9.aT;
        if (r0 == 0) goto L_0x0061;
    L_0x005a:
        r0 = r9.aT;
        r3 = r9.f5229U;
        r0.a(r3);
    L_0x0061:
        r9.J = r10;
        r0 = r10.f4834c;
        r9.A = r0;
        r0 = r9.f5218J;
        r0 = r0.f4832a;
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0090;
    L_0x0071:
        r0 = "bindVideoSources: No valid video paths";
        r3 = new java.lang.Object[r2];
        r9.mo484a(r0, r3);
        r3 = com.facebook.video.engine.texview.BaseVideoPlayer.ReleaseCaller.FROM_BIND;
        r0 = r9.bg;
        if (r0 != 0) goto L_0x008e;
    L_0x007e:
        r0 = r1;
    L_0x007f:
        r9.m6032a(r3, r0);
        r0 = -1;
        r9.ax = r0;
        r0 = r9.am;
        r9.al = r0;
        r0 = com.facebook.video.analytics.VideoAnalytics.StreamSourceType.FROM_STREAM;
        r9.S = r0;
    L_0x008d:
        return;
    L_0x008e:
        r0 = r2;
        goto L_0x007f;
    L_0x0090:
        r9.ax = r2;
        r0 = r9.f5218J;
        r0 = r0.f4832a;
        r3 = r9.ax;
        r0 = r0.get(r3);
        r0 = (com.facebook.video.engine.VideoDataSource) r0;
        r3 = r9.f5218J;
        r3 = r3.f4841j;
        if (r3 == 0) goto L_0x018b;
    L_0x00a4:
        if (r0 == 0) goto L_0x018b;
    L_0x00a6:
        r3 = r0.f4817c;
        if (r3 == 0) goto L_0x018b;
    L_0x00aa:
        r5 = r1;
    L_0x00ab:
        if (r5 == 0) goto L_0x018e;
    L_0x00ad:
        r3 = r0.f4817c;
    L_0x00af:
        r4 = r0.f4816b;
        if (r4 == 0) goto L_0x0198;
    L_0x00b3:
        r4 = r0.f4816b;
        r4 = r4.getScheme();
        if (r4 == 0) goto L_0x0198;
    L_0x00bb:
        r4 = r0.f4816b;
        r4 = r4.getScheme();
        r6 = "rtmps?";
        r4 = r4.matches(r6);
        if (r4 == 0) goto L_0x0198;
    L_0x00c9:
        r4 = r9.f5247s;
        r4 = r4.c;
        if (r4 == 0) goto L_0x0198;
    L_0x00cf:
        r3 = r0.f4816b;
    L_0x00d1:
        r4 = "BindVideoSource, uriToTry: %s";
        r6 = new java.lang.Object[r1];
        r6[r2] = r3;
        r9.mo484a(r4, r6);
        if (r3 == 0) goto L_0x00e4;
    L_0x00dc:
        r4 = r9.al;
        r4 = com.facebook.video.engine.VideoDataSource.m5250a(r4, r3);
        if (r4 != 0) goto L_0x00ee;
    L_0x00e4:
        r6 = com.facebook.video.engine.texview.BaseVideoPlayer.ReleaseCaller.FROM_BIND;
        r4 = r9.bg;
        if (r4 != 0) goto L_0x01df;
    L_0x00ea:
        r4 = r1;
    L_0x00eb:
        r9.m6032a(r6, r4);
    L_0x00ee:
        if (r0 == 0) goto L_0x0117;
    L_0x00f0:
        r4 = r0.f4821g;
        r9.S = r4;
        r4 = r0.f4816b;
        r9.am = r4;
        r4 = r0.f4817c;
        r9.an = r4;
        r4 = r0.f4820f;
        r9.ap = r4;
        r4 = r9.f5242n;
        r6 = r9.ap;
        r7 = r9.f5218J;
        r7 = r7.f4833b;
        r4.m5635a(r6, r7);
        r4 = r0.f4818d;
        r9.ao = r4;
        r0 = r0.f4819e;
        r9.aq = r0;
        r0 = r9.aq;
        r9.ar = r0;
    L_0x0117:
        r9.al = r3;
        if (r5 == 0) goto L_0x01e2;
    L_0x011b:
        r0 = r9.au;
    L_0x011d:
        r9.as = r0;
        if (r5 == 0) goto L_0x01e6;
    L_0x0121:
        r0 = com.facebook.video.engine.VideoResolution.HIGH_DEFINITION;
    L_0x0123:
        r9.aw = r0;
        r9.m6021X();
        r0 = "bindVideoSources: (%s): %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = r9.f5227S;
        r4 = r4.value;
        r3[r2] = r4;
        r4 = r9.al;
        r3[r1] = r4;
        r9.mo484a(r0, r3);
        r0 = r9.aE;
        r0 = r0.g;
        if (r0 == 0) goto L_0x0158;
    L_0x0140:
        r0 = r9.aG;
        r0 = r0.b();
        r3 = r10.f4842k;
        if (r3 != 0) goto L_0x0152;
    L_0x014a:
        if (r0 == 0) goto L_0x01ea;
    L_0x014c:
        r0 = r9.aE;
        r0 = r0.E;
        if (r0 == 0) goto L_0x0153;
    L_0x0152:
        r2 = r1;
    L_0x0153:
        if (r2 == 0) goto L_0x0158;
    L_0x0155:
        r9.m6013M();
    L_0x0158:
        r0 = r9.f5223O;
        r0.a();
        r0 = r9.f5610W;
        r1 = r9.f5218J;
        r1 = r1.f4849r;
        r0.f5161i = r1;
        r0 = r9.f5610W;
        r1 = r9.as;
        r0.f5162j = r1;
        r0 = r9.f5610W;
        r1 = r9.f5218J;
        r1 = r1.f4833b;
        r0.m5596b(r1);
        r0 = r9.f5218J;
        r0 = r0.f4839h;
        if (r0 == 0) goto L_0x008d;
    L_0x017a:
        r0 = r9.f5247s;
        r0 = r0.f;
        if (r0 == 0) goto L_0x008d;
    L_0x0180:
        r0 = r9.bk;
        r1 = r9.f5218J;
        r1 = r1.f4833b;
        r0.m6108a(r1);
        goto L_0x008d;
    L_0x018b:
        r5 = r2;
        goto L_0x00ab;
    L_0x018e:
        if (r0 == 0) goto L_0x0194;
    L_0x0190:
        r3 = r0.f4816b;
        goto L_0x00af;
    L_0x0194:
        r3 = r9.am;
        goto L_0x00af;
    L_0x0198:
        r4 = r0.f4819e;
        if (r4 == 0) goto L_0x00d1;
    L_0x019c:
        r4 = r0.f4819e;
        r4 = r4.getScheme();
        if (r4 != 0) goto L_0x01be;
    L_0x01a4:
        r4 = r9.aa;
        r6 = "bindVideoSources.invalid_rtmp_url";
        r7 = new java.lang.StringBuilder;
        r8 = "Uri: ";
        r7.<init>(r8);
        r8 = r0.f4819e;
        r7 = r7.append(r8);
        r7 = r7.toString();
        r4.a(r6, r7);
        goto L_0x00d1;
    L_0x01be:
        r4 = r0.f4819e;
        r4 = r4.getScheme();
        r6 = "rtmps?";
        r4 = r4.matches(r6);
        if (r4 == 0) goto L_0x00d1;
    L_0x01cc:
        r4 = r9.f5247s;
        r4 = r4.c;
        if (r4 == 0) goto L_0x00d1;
    L_0x01d2:
        r3 = r0.f4819e;
        r4 = "BindVideoSource, using videoRtmpUri: %s";
        r6 = new java.lang.Object[r1];
        r6[r2] = r3;
        r9.mo484a(r4, r6);
        goto L_0x00d1;
    L_0x01df:
        r4 = r2;
        goto L_0x00eb;
    L_0x01e2:
        r0 = r9.at;
        goto L_0x011d;
    L_0x01e6:
        r0 = com.facebook.video.engine.VideoResolution.STANDARD_DEFINITION;
        goto L_0x0123;
    L_0x01ea:
        r0 = r9.aE;
        r0 = r0.F;
        if (r0 == 0) goto L_0x0153;
    L_0x01f0:
        goto L_0x0152;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.texview.exo.ExoVideoPlayerClient.a(com.facebook.video.engine.VideoPlayerParams):void");
    }

    public final void mo501a(PlayerType playerType) {
        super.mo501a(playerType);
        if (this.aT != null) {
            this.aT.a(playerType);
        }
    }

    protected final void mo497v() {
        if (this.f5240l.c()) {
            m6016Q(this);
        } else {
            this.f5240l.a(new C02388(this));
        }
    }

    protected final void mo488b(Surface surface) {
        if (m6012L()) {
            m6049c(surface);
        } else if (this.f5213E == PlayerState.STATE_PLAYING) {
            m6013M();
        }
    }

    protected final void mo498w() {
        m6049c(null);
    }

    public static void m6016Q(ExoVideoPlayerClient exoVideoPlayerClient) {
        if (exoVideoPlayerClient.ax < exoVideoPlayerClient.f5218J.f4832a.size()) {
            Matrix a = VideoRenderUtils.m6003a(exoVideoPlayerClient.aR.m14930j(), exoVideoPlayerClient.aR.m14931k(), (VideoDataSource) exoVideoPlayerClient.f5218J.f4832a.get(exoVideoPlayerClient.ax));
            if (m6052c(exoVideoPlayerClient.al)) {
                synchronized (exoVideoPlayerClient.bl) {
                    exoVideoPlayerClient.m6027a(a);
                }
                return;
            }
            exoVideoPlayerClient.aR.m14923a(a);
        } else if (exoVideoPlayerClient.f5235g != null) {
            exoVideoPlayerClient.f5235g.a("Potential IndexOutOfBoundsException:mCurrentDataSourceIndex = " + exoVideoPlayerClient.ax + " but the size of the datastructure = " + exoVideoPlayerClient.f5218J.f4832a.size(), exoVideoPlayerClient.f5253y.value, exoVideoPlayerClient.f5218J.f4833b, exoVideoPlayerClient.al, exoVideoPlayerClient.f5254z.value, exoVideoPlayerClient.f5251w, exoVideoPlayerClient.mo496r(), exoVideoPlayerClient.f5218J, null);
        }
    }

    public static boolean m6052c(@Nullable Uri uri) {
        return uri == null || "file".equals(uri.getScheme());
    }

    private void m6027a(Matrix matrix) {
        if (this.bd == -1) {
            m6017R();
        }
        if (this.bd == 0 || this.bd == -1) {
            this.aR.m14923a(matrix);
            return;
        }
        Matrix matrix2 = new Matrix(matrix);
        int j = this.aR.m14930j();
        int k = this.aR.m14931k();
        int i = j / 2;
        int i2 = k / 2;
        matrix2.preRotate((float) this.bd, (float) i, (float) i2);
        if (this.bd % 180 != 0) {
            matrix2.postScale(((float) j) / ((float) k), ((float) k) / ((float) j), (float) i, (float) i2);
        }
        this.aR.m14923a(matrix2);
    }

    private void m6017R() {
        if (this.bd == -1 && this.al != null) {
            if ("file".equals(this.al.getScheme())) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.al.getPath());
                try {
                    this.bd = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                } catch (NumberFormatException e) {
                    this.bd = 0;
                }
                mediaMetadataRetriever.release();
                return;
            }
            this.bd = 0;
        }
    }

    private boolean m6018S() {
        mo484a("moveToNextVideoSource: %s", Integer.valueOf(this.ax + 1));
        this.ax++;
        if (this.ax < 0) {
            this.ax = 0;
        }
        while (this.ax < this.f5218J.f4832a.size()) {
            VideoDataSource videoDataSource = (VideoDataSource) this.f5218J.f4832a.get(this.ax);
            if (videoDataSource == null || videoDataSource.f4816b == null) {
                this.ax++;
            } else {
                this.al = videoDataSource.f4816b;
                this.S = videoDataSource.f4821g;
                return true;
            }
        }
        return false;
    }

    public final boolean mo486a() {
        try {
            this.G = "isPlaying";
            if (m6019T() && this.ad.b(this.ab)) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            m6047b(e, "Service RemoteException when getPlayWhenReady", new Object[0]);
            return false;
        }
    }

    public final View mo495k() {
        return this.aR == null ? null : this.aR.f14118i;
    }

    private int m6024a(long j) {
        if (j <= 0) {
            return 0;
        }
        if (j < ((long) this.f5218J.f4834c) || this.f5218J.f4834c == 0) {
            return (int) j;
        }
        return this.f5218J.f4834c;
    }

    public final int mo487b() {
        int i = 0;
        this.G = "getCurrentPosition";
        if (m6019T()) {
            try {
                return m6024a(this.ad.e(this.ab));
            } catch (Throwable e) {
                m6047b(e, "Service RemoteException when getCurrentPositionMs", new Object[i]);
                return i;
            }
        } else if (this.ay != -1) {
            return this.ay;
        } else {
            return i;
        }
    }

    public final int mo514s() {
        int i = 0;
        this.G = "getAbsolutePlaybackPosition";
        if (m6019T()) {
            try {
                return m6024a(this.ad.f(this.ab));
            } catch (Throwable e) {
                m6047b(e, "Service RemoteException when getInternalCurrentPositionMs", new Object[i]);
                return i;
            }
        } else if (this.ay != -1) {
            return this.ay;
        } else {
            return i;
        }
    }

    protected final void mo475a(EventTriggerType eventTriggerType, int i) {
        this.f5235g.b(this.f5218J.f4836e, this.f5253y.value, this.f5224P.value, eventTriggerType.value, i, this.f5227S.value, this.f5218J.f4833b, this.f5251w, null, this.f5254z.value, mo496r(), this.f5252x, this.f5218J.f4837f, this.f5222N, this.f5218J);
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
        m6013M();
    }

    public final void mo481a(VideoSurfaceTarget videoSurfaceTarget) {
        this.aR = videoSurfaceTarget;
        this.aR.f14119j = this.aS;
        if (this.aR.m14926d()) {
            this.aS.mo517a(this.aR.f14117h);
        }
    }

    public static void m6035a(ExoVideoPlayerClient exoVideoPlayerClient, VideoPlayerSession videoPlayerSession, boolean z, boolean z2) {
        if (m6011K(exoVideoPlayerClient)) {
            if (z) {
                exoVideoPlayerClient.m6029a(exoVideoPlayerClient.f5613Z.obtainMessage(5, videoPlayerSession));
            }
            exoVideoPlayerClient.m6029a(exoVideoPlayerClient.f5613Z.obtainMessage(7, videoPlayerSession));
            exoVideoPlayerClient.m6029a(exoVideoPlayerClient.f5613Z.obtainMessage(8, z2 ? 1 : 0, 0, videoPlayerSession));
            exoVideoPlayerClient.m6009I();
        }
    }

    private boolean m6019T() {
        if (!m6012L()) {
            return false;
        }
        if (this.f5212D == PlayerState.STATE_PREPARED || this.f5212D == PlayerState.STATE_PLAYING || this.f5212D == PlayerState.STATE_PAUSED || this.f5212D == PlayerState.STATE_PLAYBACK_COMPLETED) {
            return true;
        }
        return false;
    }

    public static void m6034a(ExoVideoPlayerClient exoVideoPlayerClient, Surface surface) {
        if (exoVideoPlayerClient.m6012L()) {
            exoVideoPlayerClient.m6029a(exoVideoPlayerClient.f5613Z.obtainMessage(9, surface));
        } else {
            exoVideoPlayerClient.mo484a("Player already released when attach surface", new Object[0]);
        }
    }

    private void m6049c(final Surface surface) {
        mo484a("sendSurfaceToVideoRenderer: %s", surface);
        if (!this.aE.j || surface == null) {
            m6034a(this, surface);
        } else {
            ExecutorDetour.a(this.aZ, new Runnable(this) {
                final /* synthetic */ ExoVideoPlayerClient f5644b;

                public void run() {
                    ExoVideoPlayerClient.m6034a(this.f5644b, surface);
                }
            }, 1862801579);
        }
    }

    protected final void mo470B() {
        mo484a("onCompletion", new Object[0]);
        this.f5223O.c();
        this.f5235g.a(this.f5253y.value, this.f5224P.value, this.f5218J.f4833b, this.f5218J.f4834c, ab(), this.f5251w, this.f5254z.value, this.f5229U, StreamRepresentationEventSource.COMPLETED);
        m5736z();
        this.f5223O.a();
        this.A = m6023Z();
        this.B = 0;
        m5702A();
        if (!this.f5218J.f4840i || (this.f5218J.f4845n != -1 && this.bh >= this.f5218J.f4845n)) {
            if (this.f5212D == PlayerState.STATE_PLAYING) {
                m6030a(new AsyncVideo$PlayPausedEvent(this.f5209A, VideoReason.f5597a));
            }
            m5708a(PlayerState.STATE_PLAYBACK_COMPLETED);
            m5713b(PlayerState.STATE_PLAYBACK_COMPLETED);
            this.ay = -1;
            this.bj = false;
            if (!this.f5218J.f4846o) {
                mo510n();
                m6032a(ReleaseCaller.FROM_ONCOMPLETE, true);
            }
            if (this.f5234f != null) {
                this.f5240l.a(new 11(this));
                return;
            }
            return;
        }
        m6045b(this, EventTriggerType.BY_AUTOPLAY, new PlayPosition(0, 0));
        this.ay = 0;
        m6050c(EventTriggerType.BY_AUTOPLAY, new PlayPosition(0, 0));
        if (m6037a(EventTriggerType.BY_AUTOPLAY, new PlayPosition(0, 0), false)) {
            this.bh++;
        }
    }

    public static void m6036a(ExoVideoPlayerClient exoVideoPlayerClient, VideoError videoError, Throwable th, long j) {
        exoVideoPlayerClient.m6031a(videoError, th.getMessage(), j);
    }

    private void m6031a(VideoError videoError, String str, long j) {
        m6046b("handleError %s; exception: %s", videoError, str);
        if ((videoError == VideoError.ERROR_IO || videoError == VideoError.MALFORMED) && this.aL < 3) {
            boolean z;
            Object obj;
            VideoLoggingUtils videoLoggingUtils;
            ArrayNode arrayNode;
            String str2;
            String str3;
            String str4;
            int a;
            this.aL++;
            m6046b("Re-init ExoPlayer after malformed/io errors, try #%s", Integer.valueOf(this.aL));
            this.f5236h.m5646c();
            if (str != null) {
                if (str.equals(ExoInternalError.BEHIND_LIVE_WINDOW_ERROR.value)) {
                    z = true;
                    obj = (this.f5247s.k || !this.f5218J.f4839h) ? null : 1;
                    if (m6012L() && (this.f5212D == PlayerState.STATE_PLAYING || z)) {
                        this.f5235g.a(this.f5253y.value, this.f5224P.value, this.f5218J.f4833b, obj == null ? m6024a(j) : mo487b(), ab(), this.f5251w, this.f5254z.value, this.f5229U, StreamRepresentationEventSource.PAUSED);
                        videoLoggingUtils = this.f5235g;
                        arrayNode = this.f5218J.f4836e;
                        str2 = this.f5253y.value;
                        str3 = this.f5224P.value;
                        str4 = EventTriggerType.BY_PLAYER_INTERNAL_ERROR.value;
                        if (obj == null) {
                            a = m6024a(j) - this.f5225Q;
                        } else {
                            a = mo487b() - this.f5225Q;
                        }
                        videoLoggingUtils.a(arrayNode, str2, str3, str4, a, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, mo496r(), this.f5218J.f4837f, null, this.f5218J);
                    }
                    if (m6038a(videoError, this.aL)) {
                        this.al = VideoServer.e(this.al);
                    }
                    this.ai = 1;
                    m5708a(PlayerState.STATE_IDLE);
                    this.f5240l.a(new 12(this, z), (long) VideoExoplayerConfig.a(this.aL));
                }
            }
            z = false;
            if (this.f5247s.k) {
            }
            if (obj == null) {
            }
            this.f5235g.a(this.f5253y.value, this.f5224P.value, this.f5218J.f4833b, obj == null ? m6024a(j) : mo487b(), ab(), this.f5251w, this.f5254z.value, this.f5229U, StreamRepresentationEventSource.PAUSED);
            videoLoggingUtils = this.f5235g;
            arrayNode = this.f5218J.f4836e;
            str2 = this.f5253y.value;
            str3 = this.f5224P.value;
            str4 = EventTriggerType.BY_PLAYER_INTERNAL_ERROR.value;
            if (obj == null) {
                a = mo487b() - this.f5225Q;
            } else {
                a = m6024a(j) - this.f5225Q;
            }
            videoLoggingUtils.a(arrayNode, str2, str3, str4, a, this.f5210B, this.f5218J.f4833b, this.f5251w, this.f5254z.value, mo496r(), this.f5218J.f4837f, null, this.f5218J);
            if (m6038a(videoError, this.aL)) {
                this.al = VideoServer.e(this.al);
            }
            this.ai = 1;
            m5708a(PlayerState.STATE_IDLE);
            this.f5240l.a(new 12(this, z), (long) VideoExoplayerConfig.a(this.aL));
        } else if (videoError != VideoError.PLAYERSERVICE_DEAD || this.aL >= 3) {
            m5708a(PlayerState.STATE_ERROR);
            m5713b(PlayerState.STATE_ERROR);
            m6033a(ReleaseCaller.FROM_ERROR, true, true);
            BLog.b(aQ, "playback failed: %s, exception: %s", new Object[]{videoError, str});
            this.f5235g.a("ExoPlayer Error: " + videoError + " exception: " + str, this.f5253y.value, this.f5218J.f4833b, this.al, this.f5254z.value, this.f5251w, mo496r(), this.f5218J, null);
            this.f5240l.b(new 14(this, videoError));
        } else {
            this.aL++;
            this.ai = 1;
            m5708a(PlayerState.STATE_IDLE);
            this.ab = null;
            ExecutorDetour.a(this.aZ, new 13(this), -1467823649);
        }
    }

    private boolean m6038a(VideoError videoError, int i) {
        return (videoError == VideoError.ERROR_IO || videoError == VideoError.MALFORMED) && i == 3 && VideoServer.f(this.al);
    }

    private void m6020U() {
        if (this.f5218J.f4839h && this.f5247s.f) {
            InterruptedMessage b = this.bk.m6109b(this.f5218J.f4833b);
            if (b != null) {
                if (Math.abs(((long) mo514s()) - b.d) < ((long) this.f5247s.u)) {
                    mo484a("StreamDriedOut is triggered, internal position %d, interrupted position %d", Integer.valueOf(mo514s()), Long.valueOf(b.d));
                    m6060E();
                }
            }
        }
        if (this.f5234f != null) {
            this.f5240l.b(new Runnable(this) {
                final /* synthetic */ ExoVideoPlayerClient f5851a;

                {
                    this.f5851a = r1;
                }

                public void run() {
                    this.f5851a.f5234f.mo457e();
                }
            });
            if (this.bj) {
                this.f5240l.b(new 16(this));
            }
        }
    }

    private void m6021X() {
        if (this.f5234f != null) {
            this.f5240l.b(new Runnable(this) {
                final /* synthetic */ ExoVideoPlayerClient f5629a;

                {
                    this.f5629a = r1;
                }

                public void run() {
                    this.f5629a.f5234f.mo451a(this.f5629a.aw);
                }
            });
        }
    }

    private void m6022Y() {
        mo484a("onPrepared for %s", this.al);
        m5708a(PlayerState.STATE_PREPARED);
        this.A = m6023Z();
        this.aB.a(VideoServer.a(this.al), this.f5209A);
        if (!this.aE.f) {
            if (this.aR != null) {
                mo484a("mVideoSurfaceTarget.isSurfaceAllocated()? %s", Boolean.valueOf(this.aR.m14926d()));
            }
            if (this.aR != null && this.aR.m14926d()) {
                m6049c(this.aR.f14117h);
            }
        }
        m6040b(this.ak);
        if (this.f5234f != null) {
            this.f5240l.b(new Runnable(this) {
                final /* synthetic */ ExoVideoPlayerClient f5645a;

                {
                    this.f5645a = r1;
                }

                public void run() {
                    this.f5645a.f5234f.mo444a();
                }
            });
        }
        this.F = new VideoMetadata(this.f5209A, this.aM, this.aN, this.aO, this.aP, this.f5224P.value, m5734x());
        boolean z = this.aL > 0 && !(this.f5218J.f4839h && this.f5247s.k);
        m6030a(new PreparationEndEvent());
        if (this.f5213E == PlayerState.STATE_PLAYING) {
            m6037a(this.f5226R, this.f5211C, z);
        } else if (!this.aU && this.f5213E == PlayerState.STATE_IDLE) {
            mo489b(this.f5226R);
        }
    }

    private int m6023Z() {
        if (m6011K(this)) {
            try {
                long d = this.ad.d(this.ab);
                if (d >= 0 && d < 18000000) {
                    return (int) d;
                }
            } catch (RemoteException e) {
                mo484a("Service RemoteException when getDurationUs: %s", e);
            }
        }
        return this.f5218J.f4834c;
    }

    private void aa() {
        if (m6012L()) {
            try {
                final int h = this.ad.h(this.ab);
                if (h > this.az) {
                    if (this.f5235g.a()) {
                        mo484a("BufferingUpdate: from %s to %s, sid=%s", Integer.valueOf(this.az), Integer.valueOf(h), Integer.valueOf(VideoServer.a(this.al)));
                    }
                    this.az = h;
                    if (this.f5234f != null) {
                        this.f5240l.b(new Runnable(this) {
                            final /* synthetic */ ExoVideoPlayerClient f5665b;

                            public void run() {
                                this.f5665b.f5234f.mo461b(h);
                            }
                        });
                    }
                }
            } catch (Throwable e) {
                m6047b(e, "Service RemoteException when getBufferedPercentage", new Object[0]);
            }
        }
    }

    private int ab() {
        return this.aW == -1 ? this.f5210B : this.aW;
    }

    private void m6030a(final TypedEvent typedEvent) {
        this.f5240l.a(new Runnable(this) {
            final /* synthetic */ ExoVideoPlayerClient f5647b;

            public void run() {
                this.f5647b.f5245q.a(typedEvent);
            }
        });
    }

    public final void mo484a(String str, Object... objArr) {
        m6047b(null, str, objArr);
    }

    private void m6046b(String str, Object... objArr) {
        m6047b(null, str, objArr);
    }

    private void m6047b(Throwable th, String str, Object... objArr) {
        if (this.f5235g.A) {
            Object[] objArr2 = new Object[]{Integer.valueOf(this.aV), StringFormatUtil.a(str, objArr), this.f5212D.value, this.f5213E.value, ExoPlayerPreparerBase.a(this.aj), Integer.valueOf(this.ai), this.f5218J.f4833b};
        }
    }

    public final String mo496r() {
        return "old_api_exo";
    }

    private void m6029a(Message message) {
        if (!this.aE.G || ((message.what == 8 && message.obj == Boolean.valueOf(true)) || (message.what == 9 && message.obj == null))) {
            this.f5612Y.handleMessage(message);
            message.recycle();
            return;
        }
        message.sendToTarget();
    }

    protected final void mo532u() {
        this.bj = false;
        super.mo532u();
    }

    public final void m6066a(VideoPlayerSession videoPlayerSession, boolean z, int i, int i2) {
        mo484a("PlayerStateChanged", new Object[0]);
        if (videoPlayerSession == null || this.ab == null || videoPlayerSession.hashCode() == this.ab.hashCode()) {
            if (i != this.aj) {
                int i3 = this.aj;
                this.aj = i;
                if (i == 4) {
                    this.aL = 0;
                    if (z) {
                        this.ay = -1;
                    }
                }
                m6048c(i);
                if (m6019T() && z && i == 3) {
                    m6046b("onStartBuffering", new Object[0]);
                    m6020U();
                    if (i3 == 4) {
                        this.f5223O.a((long) mo487b());
                    }
                }
                if (i3 == 3 && i == 4) {
                    this.bj = false;
                    if (this.f5234f != null) {
                        this.f5240l.b(new Runnable(this) {
                            final /* synthetic */ ExoVideoPlayerClient f5657a;

                            {
                                this.f5657a = r1;
                            }

                            public void run() {
                                this.f5657a.f5234f.mo458f();
                            }
                        });
                    }
                    this.f5223O.c();
                    m6046b("onStopBuffering, stall time %d ", Long.valueOf(this.f5223O.g()));
                }
                if (i == 5) {
                    mo484a("Playback complete, sid=%s", Integer.valueOf(VideoServer.a(this.al)));
                    mo470B();
                } else if (i == 1 && this.f5212D != PlayerState.STATE_ERROR) {
                    m5708a(PlayerState.STATE_IDLE);
                }
            } else if (this.aE.K) {
                m6048c(i);
            }
            if (this.f5234f != null) {
                this.f5234f.mo461b(i2);
            }
        }
    }

    private void m6048c(int i) {
        if (this.f5212D != PlayerState.STATE_PREPARING) {
            return;
        }
        if (i == 4 || (i == 3 && !this.aE.H)) {
            m6046b("ExoPlayer prepared: videoMime=%s, audioMime=%s", this.aO, this.aP);
            m6022Y();
        }
    }

    public final void m6065a(MediaRenderer mediaRenderer, MediaRenderer mediaRenderer2, RendererContext rendererContext) {
        String str;
        mo484a("Renderers built", new Object[0]);
        if (mediaRenderer != this.ag) {
            this.ac = null;
        }
        this.ag = mediaRenderer;
        this.ah = mediaRenderer2;
        this.av = rendererContext.b;
        this.P = StreamingFormat.valueOf(rendererContext.a);
        this.f5610W.f5163k = this.f5224P.value;
        RtmpPlaybackInitPerfLogger rtmpPlaybackInitPerfLogger = this.ba;
        boolean z = this.f5218J.f4839h;
        String str2 = this.f5218J.f4833b;
        int hashCode = hashCode();
        String str3 = this.f5224P.value;
        int i = rendererContext.c;
        int i2 = rendererContext.d;
        if (this.al == null) {
            str = "";
        } else {
            str = VideoServer.e(this.al).toString();
        }
        rtmpPlaybackInitPerfLogger.a(z, str2, hashCode, str3, i, i2, str);
        this.ai = 3;
        if (this.aE.f) {
            if (this.aR != null) {
                mo484a("mVideoSurfaceTarget.isSurfaceAllocated()? %s", Boolean.valueOf(this.aR.m14926d()));
            }
            if (this.aR == null || !this.aR.m14926d()) {
                mo484a("no surface to be used yet", new Object[0]);
            } else {
                m6049c(this.aR.f14117h);
            }
        }
    }

    public final void m6062a(final int i, final int i2) {
        if (this.aM != i || this.aN != i2) {
            mo484a("onVideoSizeChanged: w=%s, h=%s", Integer.valueOf(i), Integer.valueOf(i2));
            this.aM = i;
            this.aN = i2;
            if (this.f5234f != null) {
                this.f5240l.b(new Runnable(this) {
                    final /* synthetic */ ExoVideoPlayerClient f5656c;

                    public void run() {
                        this.f5656c.f5234f.mo446a(i, i2);
                    }
                });
            }
        }
    }

    public final void m6063a(int i, VideoPlayerStreamFormat videoPlayerStreamFormat, int i2, int i3, long j) {
        if (m6011K(this)) {
            int a = m6024a(j);
            if (!(this.f5229U == null || videoPlayerStreamFormat == null || videoPlayerStreamFormat.a.equals(this.f5229U.a))) {
                this.f5235g.b(this.f5253y.value, this.f5224P.value, this.f5218J.f4833b, a, ab(), this.f5251w, this.f5254z.value, this.f5229U, StreamRepresentationEventSource.STREAM_SWITCH);
            }
            this.U = videoPlayerStreamFormat;
            this.aW = a;
            if (this.aT != null) {
                this.aT.a(this.f5229U);
            }
            String x = m5734x();
            if (this.f5214F != null) {
                this.f5214F.m6000a(x);
            }
            if (this.f5234f != null) {
                this.f5240l.b(new 23(this, x));
            }
            this.f5242n.m5632a(videoPlayerStreamFormat.c + this.av, a);
            if (this.f5247s.p && i == 1001 && a >= 0 && this.f5210B != a) {
                this.B = a;
            }
            mo484a("onDownstreamFormatChanged: %s, sourceId: %s, trigger: %s, mediaTimeMs: %s, videoBitrate: %d, audioBitrate: %d", x, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(videoPlayerStreamFormat.c), Integer.valueOf(this.av));
        }
    }

    public final void m6078a(String str, String str2, long j) {
        m6031a(VideoError.valueOf(str), str2, j);
    }

    public final void m6058C() {
        if (this.aK != null) {
            this.aK.a();
        }
    }

    public final void m6059D() {
        if (this.aK != null) {
            this.aK.b();
        }
    }

    public final void m6080a(List<VideoPlayerMediaChunk> list, long j, VideoPlayerStreamFormat[] videoPlayerStreamFormatArr, VideoPlayerStreamEvaluation videoPlayerStreamEvaluation) {
        mo484a("onStreamEvaluate", new Object[0]);
        if (this.aK != null) {
            Evaluation evaluation = new Evaluation();
            evaluation.a = videoPlayerStreamEvaluation.a;
            evaluation.c = videoPlayerStreamEvaluation.c;
            if (this.aK instanceof DashCustomEvaluator) {
                ((DashCustomEvaluator) this.aK).b(list, j, videoPlayerStreamFormatArr, evaluation);
                videoPlayerStreamEvaluation.b = evaluation.b;
                videoPlayerStreamEvaluation.c = (VideoPlayerStreamFormat) evaluation.c;
                videoPlayerStreamEvaluation.a = evaluation.a;
                return;
            }
            videoPlayerStreamEvaluation.c = videoPlayerStreamFormatArr[0];
        }
    }

    public final void m6060E() {
        if (this.f5247s.s) {
            mo484a("onStreamInterrupted", new Object[0]);
            if (!this.bj) {
                mo484a("set streamdriedout", new Object[0]);
                if (m6019T()) {
                    this.f5223O.e();
                } else {
                    this.f5222N.e();
                }
                this.bj = true;
                if (this.aj == 3 || this.aj == 2) {
                    this.f5240l.b(new 24(this));
                }
            }
        }
    }

    public static void m6044b(ExoVideoPlayerClient exoVideoPlayerClient, long j) {
        if (exoVideoPlayerClient.f5247s.r) {
            exoVideoPlayerClient.Q = (int) (((long) exoVideoPlayerClient.f5225Q) + j);
        }
    }

    public static void m6051c(ExoVideoPlayerClient exoVideoPlayerClient, String str, Object... objArr) {
        if (str != null) {
            exoVideoPlayerClient.mo484a("Restarting player service, reason: " + str, objArr);
        }
        exoVideoPlayerClient.m6008H();
        exoVideoPlayerClient.af.a(RequestVideoServiceRestartEvent.a);
    }
}
