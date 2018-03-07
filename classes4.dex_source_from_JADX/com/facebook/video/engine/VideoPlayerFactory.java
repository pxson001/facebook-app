package com.facebook.video.engine;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_VideoPerformanceExecutorMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.feed.quickcam.Boolean_IsPausedBitmapEnabledMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.abtest.DirectPlayConfig;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.engine.texview.InitializationSequenceLogger;
import com.facebook.video.engine.texview.TextureViewVideoPlayer;
import com.facebook.video.engine.texview.VideoSurfaceProvider;
import com.facebook.video.server.BytesViewedLogger;
import com.facebook.video.server.VideoPlayerSessionManagerMethodAutoProvider;
import com.facebook.video.subtitles.controller.SubtitleAdapterFactory;
import com.facebook.video.subtitles.controller.SubtitleListener;
import com.facebook.video.subtitles.controller.SubtitleMediaTimeProvider;
import com.facebook.video.subtitles.controller.compat.CustomSubtitleAdapter;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: percentile_25 */
public class VideoPlayerFactory {
    private static volatile VideoPlayerFactory f5173i;
    private final Lazy<VideoPlayerViewProvider> f5174a;
    private final MonotonicClock f5175b;
    private final VideoEngineUtils f5176c;
    private final Lazy<NativePlayerPool> f5177d;
    private final Provider<TriState> f5178e;
    private final QeAccessor f5179f;
    private final GatekeeperStoreImpl f5180g;
    private final VideoLivePlaybackConfig f5181h;

    public static com.facebook.video.engine.VideoPlayerFactory m5624a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f5173i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.VideoPlayerFactory.class;
        monitor-enter(r1);
        r0 = f5173i;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m5626b(r0);	 Catch:{ all -> 0x0035 }
        f5173i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5173i;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.VideoPlayerFactory.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.VideoPlayerFactory");
    }

    private static VideoPlayerFactory m5626b(InjectorLike injectorLike) {
        return new VideoPlayerFactory(IdBasedLazy.a(injectorLike, 3681), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), VideoEngineUtils.a(injectorLike), IdBasedProvider.a(injectorLike, 810), IdBasedSingletonScopeProvider.b(injectorLike, 3661), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), VideoLivePlaybackConfig.a(injectorLike));
    }

    @Inject
    public VideoPlayerFactory(Lazy<VideoPlayerViewProvider> lazy, MonotonicClock monotonicClock, VideoEngineUtils videoEngineUtils, Provider<TriState> provider, Lazy<NativePlayerPool> lazy2, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, VideoLivePlaybackConfig videoLivePlaybackConfig) {
        this.f5174a = lazy;
        this.f5175b = monotonicClock;
        this.f5176c = videoEngineUtils;
        this.f5177d = lazy2;
        this.f5178e = provider;
        this.f5179f = qeAccessor;
        this.f5180g = gatekeeperStore;
        this.f5181h = videoLivePlaybackConfig;
    }

    private boolean m5625a() {
        return !((TriState) this.f5178e.get()).asBoolean(true);
    }

    @TargetApi(14)
    public final VideoPlayer m5627a(Context context, AttributeSet attributeSet, int i, VideoPlayerListener videoPlayerListener, SubtitleListener subtitleListener, VideoLoggingUtils videoLoggingUtils, SubtitleAdapterFactory subtitleAdapterFactory, DefaultAndroidThreadUtil defaultAndroidThreadUtil, SubtitleMediaTimeProvider subtitleMediaTimeProvider, boolean z, InitializationSequenceLogger initializationSequenceLogger, BytesViewedLogger bytesViewedLogger) {
        TracerDetour.a("VideoPlayerFactory.allocateVideoPlayer", -255165662);
        try {
            FbInjector fbInjector = FbInjector.get(context);
            ScheduledExecutorService a = ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector);
            CustomSubtitleAdapter a2 = subtitleAdapterFactory.a();
            TracerDetour.a("VideoPlayerFactory.TextureViewVideoPlayer.init", -1938770382);
            int i2;
            try {
                i2 = context;
                VideoPlayer textureViewVideoPlayer = new TextureViewVideoPlayer(i2, attributeSet, i, (VideoSurfaceProvider) this.f5174a.get(), this.f5177d, videoPlayerListener, subtitleListener, videoLoggingUtils, a2, subtitleMediaTimeProvider, DeviceConditionHelper.a(fbInjector), a, ListeningExecutorService_VideoPerformanceExecutorMethodAutoProvider.a(fbInjector), Boolean_IsPausedBitmapEnabledMethodAutoProvider.a(fbInjector), z, defaultAndroidThreadUtil, VideoPlayerSessionManagerMethodAutoProvider.a(fbInjector), this.f5175b, initializationSequenceLogger, bytesViewedLogger, this.f5176c, m5625a(), new DirectPlayConfig(this.f5179f, this.f5180g), this.f5179f, this.f5180g, this.f5181h);
                TracerDetour.a(i2);
                return textureViewVideoPlayer;
            } finally {
                i2 = 213099332;
                TracerDetour.a(213099332);
            }
        } finally {
            TracerDetour.a(-1145755937);
        }
    }
}
