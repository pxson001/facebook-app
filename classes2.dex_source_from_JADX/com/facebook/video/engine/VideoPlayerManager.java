package com.facebook.video.engine;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.util.LruCache;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.C0109x696ccb0c;
import com.facebook.common.executors.C0403x70bd9621;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.exoplayer.ipc.VideoPlayerServiceApi;
import com.facebook.feed.quickcam.Boolean_IsPausedBitmapEnabledMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.common.CachedNetworkInfoCollector;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.spherical.SphericalMediaTextureView;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.abtest.VideoQEConfig;
import com.facebook.video.analytics.RtmpPlaybackInitPerfLogger;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.api.playersession.VideoPlayerSessionManager;
import com.facebook.video.downloadmanager.DownloadManager;
import com.facebook.video.engine.texview.InitializationSequenceLogger;
import com.facebook.video.engine.texview.ProxyActivityListener;
import com.facebook.video.engine.texview.VideoSurfaceProvider;
import com.facebook.video.engine.texview.VideoSurfaceTarget;
import com.facebook.video.engine.texview.exo.ExoVideoPlayer;
import com.facebook.video.engine.texview.exo.ExoVideoPlayerClient;
import com.facebook.video.exoserviceclient.ExoServiceClient;
import com.facebook.video.exoserviceclient.ExoServiceClient.Listener;
import com.facebook.video.exoserviceclient.ExoServiceClientMethodAutoProvider;
import com.facebook.video.pubsub.LiveStreamingSubscriberPool;
import com.facebook.video.server.BytesViewedLogger;
import com.facebook.video.server.VideoPlayerSessionManagerMethodAutoProvider;
import com.facebook.video.server.VideoServer;
import com.facebook.video.server.prefetcher.VideoPrefetcher;
import com.facebook.video.subtitles.controller.SubtitleAdapterFactory;
import com.facebook.video.subtitles.controller.SubtitleListener;
import com.facebook.video.view.ImplementationEvents.RequestVideoServiceRestartEvent;
import com.facebook.video.view.ImplementationEvents.RequestVideoServiceRestartEvent.Handler;
import com.facebook.video.view.ImplementationEvents.VideoServiceConnectedEvent;
import com.facebook.video.view.ImplementationEvents.VideoServiceDisconnectedEvent;
import com.google.android.exoplayer.upstream.BandwidthMeter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@SuppressLint({"BadMethodUse-java.lang.String.length"})
/* compiled from: primary_scrambling_code */
public class VideoPlayerManager implements MemoryTrimmable, Listener {
    private static volatile VideoPlayerManager f9021X;
    private WeakReference<VideoManagerPlayer> f9022A;
    private int f9023B = 0;
    private boolean f9024C = false;
    private boolean f9025D = false;
    private MonotonicClock f9026E;
    private VideoPlayerSessionManager f9027F;
    private Boolean f9028G;
    private final VideoSurfaceProvider f9029H;
    @GuardedBy("this")
    private boolean f9030I = false;
    public final Lazy<NativePlayerPool> f9031J;
    @Nullable
    private final Looper f9032K;
    public ExoServiceClient f9033L;
    public VideoPlayerServiceApi f9034M = null;
    private final TypedEventBus f9035N;
    private final DeviceConditionHelper f9036O;
    private final FbDataConnectionManager f9037P;
    private final GatekeeperStoreImpl f9038Q;
    public final LruCache<String, Boolean> f9039R = new LruCache(3);
    public final Lazy<VideoPlayRequestBuilder> f9040S;
    private final RtmpPlaybackInitPerfLogger f9041T;
    private final Lazy<LiveStreamingSubscriberPool> f9042U;
    private final NetworkInfoCollector f9043V;
    public final Lazy<DownloadManager> f9044W;
    public final List<WeakReference<VideoManagerPlayer>> f9045a = Lists.m1296a();
    private final List<WeakReference<VideoManagerPlayer>> f9046b = Lists.m1296a();
    public final List<WeakReference<VideoManagerPlayer>> f9047c = Lists.m1296a();
    private final List<WeakReference<View>> f9048d = Lists.m1296a();
    public final List<WeakReference<VideoSurfaceTarget>> f9049e = Lists.m1296a();
    private final Lazy<VideoPlayerFactory> f9050f;
    private final SubtitleAdapterFactory f9051g;
    private final DefaultAndroidThreadUtil f9052h;
    public final VideoPlayerDefaultLimitsProvider f9053i;
    private final AudioManager f9054j;
    private final AudioFocusHandler f9055k;
    private final Lazy<VideoServer> f9056l;
    private final Lazy<VideoPrefetcher> f9057m;
    private final SequenceLogger f9058n;
    public final VideoExoplayerConfig f9059o;
    private final VideoDashConfig f9060p;
    public final ScheduledExecutorService f9061q;
    private final ListeningExecutorService f9062r;
    public final QeAccessor f9063s;
    private final Lazy<VideoQEConfig> f9064t;
    private final Provider<BytesViewedLogger> f9065u;
    private final VideoEngineUtils f9066v;
    private final VideoLivePlaybackConfig f9067w;
    private final AbstractFbErrorReporter f9068x;
    private TypedEventBus f9069y;
    private VideoManagerPlayer f9070z = null;

    /* compiled from: primary_scrambling_code */
    class AudioFocusHandler implements OnAudioFocusChangeListener {
        final /* synthetic */ VideoPlayerManager f9187a;
        private final WeakReference<VideoPlayerManager> f9188b;

        public AudioFocusHandler(VideoPlayerManager videoPlayerManager, VideoPlayerManager videoPlayerManager2) {
            this.f9187a = videoPlayerManager;
            this.f9188b = new WeakReference(videoPlayerManager2);
        }

        public void onAudioFocusChange(int i) {
        }
    }

    /* compiled from: primary_scrambling_code */
    public class ActivityListener extends AbstractFbActivityListener {
        final /* synthetic */ VideoPlayerManager f9189a;

        public ActivityListener(VideoPlayerManager videoPlayerManager) {
            this.f9189a = videoPlayerManager;
        }

        public final void mo263c(Activity activity) {
            this.f9189a.f9033L.m14060a(false);
            this.f9189a.m13942e();
        }

        public final void mo242d(Activity activity) {
            this.f9189a.f9033L.m14060a(true);
            this.f9189a.m13943f();
        }
    }

    /* compiled from: primary_scrambling_code */
    class C04051 implements Handler {
        final /* synthetic */ VideoPlayerManager f9195a;

        C04051(VideoPlayerManager videoPlayerManager) {
            this.f9195a = videoPlayerManager;
        }

        public final void m14084a() {
            VideoPlayerManager.m13915h(this.f9195a);
        }
    }

    public static com.facebook.video.engine.VideoPlayerManager m13903a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f9021X;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.VideoPlayerManager.class;
        monitor-enter(r1);
        r0 = f9021X;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13905b(r0);	 Catch:{ all -> 0x0035 }
        f9021X = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9021X;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.VideoPlayerManager.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.VideoPlayerManager");
    }

    private static VideoPlayerManager m13905b(InjectorLike injectorLike) {
        return new VideoPlayerManager(IdBasedSingletonScopeProvider.m1810b(injectorLike, 3666), SubtitleAdapterFactory.m13946a(injectorLike), DefaultAndroidThreadUtil.m1645a(injectorLike), VideoPlayerDefaultLimitsProvider.m13949a(injectorLike), AudioManagerMethodAutoProvider.m13951a(injectorLike), C0109x696ccb0c.m2944a(injectorLike), C0403x70bd9621.m13953a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3695), VideoPlayerSessionManagerMethodAutoProvider.m13955a(injectorLike), SequenceLoggerImpl.m3464a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3637), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedLazy.m1808a(injectorLike, 11562), Boolean_IsPausedBitmapEnabledMethodAutoProvider.m13973a(injectorLike), ProxyActivityListener.m13093a(injectorLike), VideoSurfaceProvider.m13975a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3690), VideoEngineUtils.m13007a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3661), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3698), IdBasedSingletonScopeProvider.m1809a(injectorLike, 3635), DeviceConditionHelper.m5526a(injectorLike), FbDataConnectionManager.m3787a(injectorLike), MemoryManager.m9807a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3664), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), ExoServiceClientMethodAutoProvider.m14000a(injectorLike), RtmpPlaybackInitPerfLogger.a(injectorLike), VideoLivePlaybackConfig.m14002a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3689), FbErrorReporterImpl.m2317a(injectorLike), CachedNetworkInfoCollector.m3227a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11622));
    }

    @Inject
    public VideoPlayerManager(Lazy<VideoPlayerFactory> lazy, SubtitleAdapterFactory subtitleAdapterFactory, AndroidThreadUtil androidThreadUtil, VideoPlayerLimitsProvider videoPlayerLimitsProvider, AudioManager audioManager, ScheduledExecutorService scheduledExecutorService, ListeningExecutorService listeningExecutorService, MonotonicClock monotonicClock, Lazy<VideoServer> lazy2, VideoPlayerSessionManager videoPlayerSessionManager, SequenceLogger sequenceLogger, Provider<VideoExoplayerConfig> provider, QeAccessor qeAccessor, Lazy<VideoQEConfig> lazy3, Boolean bool, ProxyActivityListener proxyActivityListener, VideoPlayerViewProvider videoPlayerViewProvider, Provider<BytesViewedLogger> provider2, VideoEngineUtils videoEngineUtils, Lazy<NativePlayerPool> lazy4, Lazy<VideoPrefetcher> lazy5, Provider<VideoDashConfig> provider3, DeviceConditionHelper deviceConditionHelper, FbDataConnectionManager fbDataConnectionManager, MemoryTrimmableRegistry memoryTrimmableRegistry, Lazy<VideoPlayRequestBuilder> lazy6, GatekeeperStore gatekeeperStore, ExoServiceClient exoServiceClient, RtmpPlaybackInitPerfLogger rtmpPlaybackInitPerfLogger, VideoLivePlaybackConfig videoLivePlaybackConfig, Lazy<LiveStreamingSubscriberPool> lazy7, FbErrorReporter fbErrorReporter, NetworkInfoCollector networkInfoCollector, Lazy<DownloadManager> lazy8) {
        this.f9050f = lazy;
        this.f9051g = subtitleAdapterFactory;
        this.f9052h = androidThreadUtil;
        this.f9053i = videoPlayerLimitsProvider;
        this.f9054j = audioManager;
        this.f9031J = lazy4;
        this.f9040S = lazy6;
        this.f9055k = new AudioFocusHandler(this, this);
        this.f9061q = scheduledExecutorService;
        this.f9062r = listeningExecutorService;
        this.f9059o = (VideoExoplayerConfig) provider.get();
        this.f9060p = (VideoDashConfig) provider3.get();
        this.f9036O = deviceConditionHelper;
        this.f9037P = fbDataConnectionManager;
        this.f9063s = qeAccessor;
        this.f9064t = lazy3;
        this.f9065u = provider2;
        this.f9043V = networkInfoCollector;
        this.f9028G = bool;
        this.f9026E = monotonicClock;
        this.f9056l = lazy2;
        this.f9057m = lazy5;
        this.f9027F = videoPlayerSessionManager;
        this.f9058n = sequenceLogger;
        this.f9066v = videoEngineUtils;
        this.f9038Q = gatekeeperStore;
        this.f9025D = proxyActivityListener.m13097a();
        proxyActivityListener.m13096a(new ActivityListener(this));
        this.f9029H = videoPlayerViewProvider;
        this.f9044W = lazy8;
        this.f9033L = exoServiceClient;
        this.f9034M = this.f9033L.m14062b();
        this.f9035N = new TypedEventBus();
        this.f9035N.m14080a(RequestVideoServiceRestartEvent.class, new C04051(this));
        this.f9033L.m14057a((Listener) this);
        if (memoryTrimmableRegistry != null && this.f9059o.f6930q) {
            memoryTrimmableRegistry.mo1390a(this);
        }
        if (this.f9059o.f6907G) {
            HandlerThread handlerThread = new HandlerThread("VideoPlayerServiceThread");
            handlerThread.start();
            this.f9032K = handlerThread.getLooper();
        } else {
            this.f9032K = null;
        }
        this.f9041T = rtmpPlaybackInitPerfLogger;
        this.f9067w = videoLivePlaybackConfig;
        this.f9042U = lazy7;
        this.f9068x = fbErrorReporter;
    }

    private synchronized TypedEventBus m13913g() {
        if (this.f9069y == null) {
            VideoServer videoServer;
            if (this.f9056l != null) {
                videoServer = (VideoServer) this.f9056l.get();
            } else {
                videoServer = null;
            }
            this.f9069y = videoServer == null ? null : videoServer.m27013a();
        }
        return this.f9069y;
    }

    public final synchronized VideoPlayer m13923a(Context context, AttributeSet attributeSet, int i, VideoPlayerListener videoPlayerListener, SubtitleListener subtitleListener, VideoLoggingUtils videoLoggingUtils, boolean z, boolean z2, boolean z3, boolean z4, PlayerOrigin playerOrigin) {
        return m13922a(context, attributeSet, i, videoPlayerListener, subtitleListener, videoLoggingUtils, z, z2, z4, playerOrigin);
    }

    public static void m13915h(VideoPlayerManager videoPlayerManager) {
        if (videoPlayerManager.f9059o.m11521b()) {
            videoPlayerManager.f9033L.m14054a();
        }
    }

    public final synchronized VideoPlayer m13922a(Context context, AttributeSet attributeSet, int i, VideoPlayerListener videoPlayerListener, SubtitleListener subtitleListener, VideoLoggingUtils videoLoggingUtils, boolean z, boolean z2, boolean z3, PlayerOrigin playerOrigin) {
        VideoManagerPlayer videoManagerPlayer;
        boolean z4;
        Object obj;
        Preconditions.checkNotNull(this.f9056l);
        VideoServer videoServer = (VideoServer) this.f9056l.get();
        m13915h(this);
        Object obj2 = (videoServer == null || PlayerOrigin.BACKSTAGE_VIDEOS.equals(playerOrigin) || PlayerOrigin.ACTOR_PROFILE_VIDEO.equals(playerOrigin) || !this.f9059o.m11521b() || (z3 && !this.f9059o.f6932s)) ? null : 1;
        if (obj2 == null || this.f9034M != null) {
            z4 = false;
            obj = obj2;
        } else {
            videoLoggingUtils.m27084b();
            z4 = this.f9059o.m11522c();
            obj = null;
        }
        TracerDetour.a("VideoPlayerManager.createVideoPlayer.initSharedParams", 1814425091);
        int i2;
        try {
            VideoPlayer exoVideoPlayerClient;
            VideoPlayerListener videoManagerPlayerListener = new VideoManagerPlayerListener(this, videoPlayerListener);
            MediaTimeProvider mediaTimeProvider = new MediaTimeProvider(this);
            SequenceLogger sequenceLogger = this.f9058n;
            TypedEventBus g = m13913g();
            String str = (z4 || obj != null) ? "old_api_exo" : "old_api";
            i2 = (VideoPrefetcher) this.f9057m.get();
            InitializationSequenceLogger initializationSequenceLogger = new InitializationSequenceLogger(sequenceLogger, g, str, i2);
            TracerDetour.a(i2);
            boolean asBoolean = this.f9038Q.m2185a(VideoAbTestGatekeepers.f18914b).asBoolean(false);
            boolean asBoolean2 = this.f9038Q.m2185a(VideoAbTestGatekeepers.f18913a).asBoolean(false);
            if (obj != null) {
                TracerDetour.a("ExoplayerServiceApi.setVideoServerBaseUri", 1773767298);
                try {
                    this.f9034M.a(videoServer.m27015b());
                    TracerDetour.a(455196110);
                } catch (RemoteException e) {
                    TracerDetour.a(-610033242);
                } catch (Throwable th) {
                    TracerDetour.a(1580636016);
                }
                TracerDetour.a("ExoVideoPlayerClient.init", -1426917904);
                try {
                    TracerDetour.a("ExoVideoPlayerClient.initArgs", -2009944572);
                    try {
                        BytesViewedLogger bytesViewedLogger = (BytesViewedLogger) this.f9065u.get();
                        BandwidthMeter c = videoServer.m27016c();
                        TracerDetour.a(videoServer);
                        exoVideoPlayerClient = new ExoVideoPlayerClient(context, attributeSet, i, this.f9029H, videoManagerPlayerListener, videoLoggingUtils, this.f9062r, this.f9028G, z, this.f9052h, this.f9027F, this.f9026E, this.f9059o, this.f9051g.m13948a(), mediaTimeProvider, subtitleListener, initializationSequenceLogger, this.f9066v, bytesViewedLogger, this.f9031J, this.f9033L, this.f9035N, asBoolean, this.f9060p, this.f9036O, c, this.f9037P, this.f9063s, this.f9038Q, asBoolean2, (VideoPlayRequestBuilder) this.f9040S.get(), this.f9032K, this.f9041T, this.f9067w, (LiveStreamingSubscriberPool) this.f9042U.get(), this.f9068x, this.f9043V);
                        TracerDetour.a(-256361327);
                    } finally {
                        TracerDetour.a(811367118);
                    }
                } finally {
                    TracerDetour.a(1829166784);
                }
            } else {
                exoVideoPlayerClient = z4 ? new ExoVideoPlayer(context, attributeSet, i, this.f9029H, videoManagerPlayerListener, videoLoggingUtils, this.f9061q, this.f9028G, z, this.f9052h, this.f9027F, this.f9026E, this.f9059o, this.f9051g.m13948a(), mediaTimeProvider, subtitleListener, initializationSequenceLogger, this.f9066v, (BytesViewedLogger) this.f9065u.get(), this.f9031J, this.f9063s, this.f9038Q, asBoolean, asBoolean2, this.f9067w) : null;
            }
            if (exoVideoPlayerClient == null) {
                exoVideoPlayerClient = ((VideoPlayerFactory) this.f9050f.get()).a(context, attributeSet, i, videoManagerPlayerListener, subtitleListener, videoLoggingUtils, this.f9051g, this.f9052h, mediaTimeProvider, z, initializationSequenceLogger, (BytesViewedLogger) this.f9065u.get());
            }
            videoManagerPlayer = new VideoManagerPlayer(new WeakReference(this), exoVideoPlayerClient, videoManagerPlayerListener, m13916i());
            mediaTimeProvider.a(videoManagerPlayer);
            WeakReference weakReference = new WeakReference(videoManagerPlayer);
            if (z2) {
                this.f9045a.add(weakReference);
            }
        } finally {
            i2 = 1686148244;
            TracerDetour.a(1686148244);
        }
        return videoManagerPlayer;
    }

    private int m13916i() {
        int i = this.f9023B;
        this.f9023B = i + 1;
        return i;
    }

    public final String m13934b() {
        boolean z = false;
        int i = 0;
        int i2 = 0;
        for (WeakReference weakReference : this.f9049e) {
            int i3;
            VideoSurfaceTarget videoSurfaceTarget = (VideoSurfaceTarget) weakReference.get();
            if (videoSurfaceTarget == null || !videoSurfaceTarget.b()) {
                i3 = i;
            } else {
                Object obj;
                if (videoSurfaceTarget.i == null || !(videoSurfaceTarget.i instanceof SphericalMediaTextureView)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    i2++;
                } else {
                    i3 = i + 1;
                }
            }
            i = i3;
        }
        StringBuilder append = new StringBuilder("num_players=").append(this.f9045a.size()).append("\nnum_allocated_players=").append(this.f9046b.size()).append("\nnum_paused_frames=").append(this.f9047c.size()).append("\nnum_texture_views=").append(this.f9048d.size()).append("\nnum_360_video_surface_targets=").append(i2).append("\nnum_regular_video_surface_targets=").append(i).append("\nhas_active_player=");
        if (this.f9070z != null) {
            z = true;
        }
        return append.append(z).append("\nin_fullscreen=").append(this.f9024C).append("\napi_config=").append(this.f9070z != null ? this.f9070z.r() : "unknown").append("\n").toString();
    }

    public final synchronized void m13929a(VideoManagerPlayer videoManagerPlayer) {
        Preconditions.checkNotNull(videoManagerPlayer);
        new Object[1][0] = Integer.valueOf(videoManagerPlayer.c());
        videoManagerPlayer.f(EventTriggerType.BY_MANAGER);
        m13910e(videoManagerPlayer);
    }

    private boolean m13910e(VideoManagerPlayer videoManagerPlayer) {
        Iterator it = this.f9045a.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                it.remove();
            } else if (weakReference.get() == videoManagerPlayer) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    private boolean m13911f(VideoManagerPlayer videoManagerPlayer) {
        for (WeakReference weakReference : this.f9045a) {
            if (weakReference.get() == videoManagerPlayer) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void m13937b(VideoManagerPlayer videoManagerPlayer) {
        new Object[1][0] = Integer.valueOf(videoManagerPlayer.c());
        if (m13912g(videoManagerPlayer) == -1) {
            long a = this.f9053i.m13950a();
            VideoEngineUtils.m13008a(this.f9046b);
            if (((long) this.f9046b.size()) >= a) {
                m13904a(0);
            }
            this.f9046b.add(new WeakReference(videoManagerPlayer));
        }
    }

    private void m13904a(int i) {
        VideoManagerPlayer videoManagerPlayer = (VideoManagerPlayer) ((WeakReference) this.f9046b.get(i)).get();
        new Object[1][0] = Integer.valueOf(videoManagerPlayer.c);
        this.f9046b.remove(i);
        videoManagerPlayer.b(EventTriggerType.BY_MANAGER);
        m13918j(this, videoManagerPlayer);
        if (this.f9022A != null && this.f9022A.get() == videoManagerPlayer) {
            m13919k();
        }
        if (videoManagerPlayer.d != null) {
            videoManagerPlayer.d.f();
        }
    }

    public final void m13939c() {
        if (this.f9054j != null) {
            synchronized (this.f9054j) {
                this.f9054j.requestAudioFocus(this.f9055k, 3, 1);
            }
        }
    }

    public final void m13941d() {
        if (this.f9054j != null) {
            synchronized (this.f9054j) {
                this.f9054j.abandonAudioFocus(this.f9055k);
            }
        }
    }

    public final void m13925a(View view) {
        if (view != null) {
            int i = 0;
            while (i < this.f9048d.size()) {
                if (((View) ((WeakReference) this.f9048d.get(i)).get()) == view) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i >= 0) {
                this.f9048d.remove(i);
            }
        }
        VideoEngineUtils.m13008a(this.f9048d);
    }

    public final void m13935b(View view) {
        this.f9048d.add(new WeakReference(view));
    }

    private void m13908d(EventTriggerType eventTriggerType) {
        if (this.f9070z != null) {
            m13906c(this.f9070z, eventTriggerType);
            this.f9070z.g(eventTriggerType);
        }
        this.f9070z = null;
    }

    private void m13909e(EventTriggerType eventTriggerType) {
        if (this.f9070z != null) {
            m13906c(this.f9070z, eventTriggerType);
            this.f9070z.f(eventTriggerType);
        }
        this.f9070z = null;
    }

    private void m13917i(VideoManagerPlayer videoManagerPlayer) {
        this.f9070z = videoManagerPlayer;
        m13919k();
    }

    public static void m13918j(VideoPlayerManager videoPlayerManager, VideoManagerPlayer videoManagerPlayer) {
        if (videoPlayerManager.f9070z == videoManagerPlayer) {
            videoPlayerManager.f9070z = null;
        }
    }

    private void m13919k() {
        this.f9022A = null;
    }

    private void m13906c(VideoManagerPlayer videoManagerPlayer, EventTriggerType eventTriggerType) {
        Object obj;
        if (eventTriggerType.value.equals(EventTriggerType.BY_FLYOUT.value) || eventTriggerType.value.equals(EventTriggerType.BY_BOOKMARK.value) || eventTriggerType.value.equals(EventTriggerType.BY_DIALOG.value) || eventTriggerType.value.equals(EventTriggerType.BY_DIVEBAR.value) || eventTriggerType.value.equals(EventTriggerType.BY_MANAGER.value) || eventTriggerType.value.equals(EventTriggerType.BY_NEWSFEED_OCCLUSION.value)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.f9022A = new WeakReference(videoManagerPlayer);
        } else {
            m13919k();
        }
    }

    public final synchronized void m13933a(boolean z) {
        this.f9030I = z;
    }

    public final synchronized void m13928a(EventTriggerType eventTriggerType) {
        m13908d(eventTriggerType);
    }

    public final synchronized void m13936b(EventTriggerType eventTriggerType) {
        m13909e(eventTriggerType);
    }

    public final synchronized void m13932a(VideoManagerPlayer videoManagerPlayer, EventTriggerType eventTriggerType, PlayPosition playPosition) {
        if (m13911f(videoManagerPlayer)) {
            Object obj = (!this.f9025D || ((this.f9030I && !((VideoQEConfig) this.f9064t.get()).a) || m13914g(eventTriggerType) || m13920l())) ? 1 : null;
            if (obj != null && this.f9070z != null) {
                videoManagerPlayer.b.a(eventTriggerType, this.f9070z == videoManagerPlayer);
            } else if (videoManagerPlayer != this.f9070z) {
                m13908d(EventTriggerType.BY_MANAGER);
                m13917i(videoManagerPlayer);
            }
        }
        videoManagerPlayer.b(eventTriggerType, playPosition);
    }

    private boolean m13920l() {
        return this.f9070z != null && this.f9070z.h();
    }

    private boolean m13914g(EventTriggerType eventTriggerType) {
        return eventTriggerType == EventTriggerType.BY_AUTOPLAY && this.f9070z != null && this.f9070z.a();
    }

    public final synchronized void m13930a(VideoManagerPlayer videoManagerPlayer, EventTriggerType eventTriggerType) {
        if (this.f9070z == videoManagerPlayer) {
            m13906c(videoManagerPlayer, eventTriggerType);
        }
        m13918j(this, videoManagerPlayer);
        videoManagerPlayer.f(eventTriggerType);
    }

    public final synchronized void m13938b(VideoManagerPlayer videoManagerPlayer, EventTriggerType eventTriggerType) {
        if (this.f9070z == videoManagerPlayer) {
            m13906c(videoManagerPlayer, eventTriggerType);
        }
        m13918j(this, videoManagerPlayer);
        videoManagerPlayer.g(eventTriggerType);
    }

    public final synchronized void m13931a(VideoManagerPlayer videoManagerPlayer, EventTriggerType eventTriggerType, int i) {
        videoManagerPlayer.a(eventTriggerType, i);
    }

    public final synchronized int m13940d(VideoManagerPlayer videoManagerPlayer) {
        int i;
        if (videoManagerPlayer == null) {
            i = 0;
        } else {
            i = videoManagerPlayer.b();
        }
        return i;
    }

    public final void mo1395a(MemoryTrimType memoryTrimType) {
        Integer.valueOf(this.f9045a.size());
        m13921m();
    }

    private synchronized void m13921m() {
        int i = 0;
        for (WeakReference weakReference : new ArrayList(this.f9045a)) {
            if (weakReference.get() == this.f9070z) {
                i++;
            } else {
                weakReference.get();
                m13904a(i);
            }
        }
    }

    public final synchronized void mo1911a(VideoPlayerServiceApi videoPlayerServiceApi) {
        this.f9034M = videoPlayerServiceApi;
        this.f9035N.m14078a(new VideoServiceConnectedEvent(this.f9034M));
    }

    public final synchronized void mo1910a() {
        this.f9034M = null;
        this.f9035N.m14078a(new VideoServiceDisconnectedEvent());
    }

    @VisibleForTesting
    private int m13912g(VideoManagerPlayer videoManagerPlayer) {
        int i = videoManagerPlayer.c;
        for (int i2 = 0; i2 < this.f9046b.size(); i2++) {
            VideoManagerPlayer videoManagerPlayer2 = (VideoManagerPlayer) ((WeakReference) this.f9046b.get(i2)).get();
            if (videoManagerPlayer2 != null && videoManagerPlayer2.c == i) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean m13907c(EventTriggerType eventTriggerType) {
        return eventTriggerType.value.equals(EventTriggerType.BY_DIVEBAR.value) || eventTriggerType.value.equals(EventTriggerType.BY_DIALOG.value) || eventTriggerType.value.equals(EventTriggerType.BY_FLYOUT.value) || eventTriggerType.value.equals(EventTriggerType.BY_BOOKMARK.value);
    }

    public final void m13942e() {
        this.f9025D = true;
    }

    public final void m13943f() {
        this.f9025D = false;
        Iterator it = this.f9045a.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == null) {
                it.remove();
            }
        }
        for (int i = 0; i < this.f9045a.size(); i++) {
            VideoManagerPlayer videoManagerPlayer = (VideoManagerPlayer) ((WeakReference) this.f9045a.get(i)).get();
            if (videoManagerPlayer != null) {
                videoManagerPlayer.u();
            }
        }
        m13908d(EventTriggerType.BY_MANAGER);
    }
}
