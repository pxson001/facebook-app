package com.facebook.video.server;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.facebook.analytics.DataUsageCounters;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.cache.DiskCacheManager;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.ConstrainedExecutorsStatusController;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultConstrainedListeningExecutorService;
import com.facebook.common.file.MoreFileUtils;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.qe.api.QeAccessor;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.ui.media.cache.ChunkedPartialFileStorage;
import com.facebook.ui.media.cache.PartialFileCache;
import com.facebook.ui.media.cache.PartialFileStorage;
import com.facebook.video.abtest.DirectPlayConfig;
import com.facebook.video.abtest.ExperimentsForVideoAbTestModule;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.abtest.VideoPrefetchExperimentHelper;
import com.facebook.video.analytics.VideoPerformanceTracking;
import com.facebook.video.api.playersession.VideoPlayerSessionManager;
import com.facebook.video.exoserviceclient.ExoServiceClient;
import com.facebook.video.server.VideoServer.VideoServerWorker;
import com.facebook.video.server.cache.PlayerReadableCache;
import com.facebook.video.server.prefetcher.DashVideoPrefetchParser;
import com.facebook.video.server.prefetcher.VideoPrefetchModel;
import com.facebook.video.server.prefetcher.VideoPrefetcher;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: previous_presence */
public class VideoServerModule extends AbstractLibraryModule {

    /* compiled from: previous_presence */
    final class C04733 implements Provider<File> {
        final /* synthetic */ DefaultAndroidThreadUtil f11382a;
        final /* synthetic */ Context f11383b;
        final /* synthetic */ String f11384c;

        C04733(DefaultAndroidThreadUtil defaultAndroidThreadUtil, Context context, String str) {
            this.f11382a = defaultAndroidThreadUtil;
            this.f11383b = context;
            this.f11384c = str;
        }

        public final Object get() {
            this.f11382a.m1655b();
            return new File(this.f11383b.getFilesDir(), this.f11384c);
        }
    }

    /* compiled from: previous_presence */
    public final class C04751 {
        final /* synthetic */ int f11414a;

        C04751(int i) {
            this.f11414a = i;
        }

        public final VideoCacheKey m16712a(Uri uri) {
            return new VideoCacheKey(uri, this.f11414a);
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static C04751 m13961a(QeAccessor qeAccessor) {
        return new C04751(qeAccessor.mo572a(ExperimentsForVideoAbTestModule.ae, 0));
    }

    @ProviderMethod
    @Singleton
    static VideoServerWorker m13959a(MonotonicClock monotonicClock, FbNetworkManager fbNetworkManager, Lazy<VideoPerformanceTracking> lazy, DataUsageCounters dataUsageCounters, PartialFileStorage partialFileStorage, AndroidThreadUtil androidThreadUtil, ScheduledExecutorService scheduledExecutorService, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor, FbHttpRequestProcessor fbHttpRequestProcessor, ThrottlingPolicyFactory throttlingPolicyFactory, VideoPlayerSessionManager videoPlayerSessionManager, FbDataConnectionManager fbDataConnectionManager, VideoKeyCreator videoKeyCreator, Lazy<VideoPrefetcher> lazy2, Provider<VideoDashConfig> provider, VideoExoplayerConfig videoExoplayerConfig, StatFsHelper statFsHelper, AnalyticsLogger analyticsLogger, LoggedInUserAuthDataStore loggedInUserAuthDataStore, ObjectMapper objectMapper, TimeoutStreamHelper timeoutStreamHelper) {
        return new VideoServerWorker(partialFileStorage, androidThreadUtil, new TypedEventBus(), fbErrorReporter, new 2(statFsHelper), new VideoServerLogger(monotonicClock, fbNetworkManager, lazy, dataUsageCounters, analyticsLogger), qeAccessor, lazy2, monotonicClock, videoPlayerSessionManager, videoKeyCreator, scheduledExecutorService, throttlingPolicyFactory, fbDataConnectionManager, new DefaultNetworkProcessor(fbHttpRequestProcessor), loggedInUserAuthDataStore, objectMapper, provider, videoExoplayerConfig.f6915b, timeoutStreamHelper);
    }

    @ProviderMethod
    @Singleton
    static VideoServer m13960a(MonotonicClock monotonicClock, FbNetworkManager fbNetworkManager, Lazy<VideoPerformanceTracking> lazy, DataUsageCounters dataUsageCounters, GatekeeperStore gatekeeperStore, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor, BackgroundWorkLogger backgroundWorkLogger, LoggedInUserAuthDataStore loggedInUserAuthDataStore, ExecutorService executorService, Lazy<VideoServerWorker> lazy2, AnalyticsLogger analyticsLogger, TimeoutStreamHelper timeoutStreamHelper, ExoServiceClient exoServiceClient) {
        return new VideoServer(fbErrorReporter, new VideoServerLogger(monotonicClock, fbNetworkManager, lazy, dataUsageCounters, analyticsLogger), gatekeeperStore, qeAccessor, backgroundWorkLogger, loggedInUserAuthDataStore, executorService, lazy2, timeoutStreamHelper, exoServiceClient);
    }

    @ProviderMethod
    @Singleton
    @VideoCache
    static PartialFileStorage m13958a(Context context, Clock clock, MoreFileUtils moreFileUtils, StatFsHelper statFsHelper, DiskCacheManager diskCacheManager, ObjectMapper objectMapper, QeAccessor qeAccessor, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        PartialFileStorage a = m13957a("video-cache", qeAccessor.mo575a(ExperimentsForVideoAbTestModule.ah, 104857600), context, clock, moreFileUtils, statFsHelper, objectMapper, diskCacheManager, defaultAndroidThreadUtil);
        if (!qeAccessor.mo596a(ExperimentsForVideoAbTestModule.af, false)) {
            return a;
        }
        return new ComposedPartialFileStorage(m13957a("video-cache-cb", qeAccessor.mo575a(ExperimentsForVideoAbTestModule.ag, 0), context, clock, moreFileUtils, statFsHelper, objectMapper, diskCacheManager, defaultAndroidThreadUtil), a);
    }

    @ProviderMethod
    @Singleton
    static PlayerReadableCache m13962a(Context context, DiskCacheManager diskCacheManager, QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        DiskTrimmable playerReadableCache = new PlayerReadableCache(new File(context.getFilesDir(), "video-player-readable-cache"), new DirectPlayConfig(qeAccessor, gatekeeperStoreImpl).e);
        diskCacheManager.mo1325a(playerReadableCache);
        return playerReadableCache;
    }

    private static PartialFileCache<VideoCacheKey> m13957a(String str, long j, Context context, Clock clock, MoreFileUtils moreFileUtils, StatFsHelper statFsHelper, ObjectMapper objectMapper, DiskCacheManager diskCacheManager, AndroidThreadUtil androidThreadUtil) {
        DiskTrimmable partialFileCache = new PartialFileCache(new ChunkedPartialFileStorage(new C04733(androidThreadUtil, context, str), clock, objectMapper, moreFileUtils), new VideoCacheSizePolicy(statFsHelper, j));
        diskCacheManager.mo1325a(partialFileCache);
        return partialFileCache;
    }

    @ProviderMethod
    @Singleton
    static DashVideoPrefetchParser m13963a(Handler handler, VideoDashConfig videoDashConfig, DeviceConditionHelper deviceConditionHelper) {
        return new DashVideoPrefetchParser(handler, videoDashConfig, deviceConditionHelper);
    }

    @ProviderMethod
    @Singleton
    static VideoPrefetcher m13965a(PartialFileStorage partialFileStorage, VideoPrefetchModel videoPrefetchModel, ExecutorService executorService, FbErrorReporter fbErrorReporter, DeviceConditionHelper deviceConditionHelper, VideoPrefetchExperimentHelper videoPrefetchExperimentHelper, Provider<Boolean> provider, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper, FbHttpRequestProcessor fbHttpRequestProcessor, Handler handler, VideoKeyCreator videoKeyCreator, BackgroundWorkLogger backgroundWorkLogger, Lazy<VideoPerformanceTracking> lazy, SequenceLogger sequenceLogger, MonotonicClock monotonicClock, ConstrainedExecutorsStatusController constrainedExecutorsStatusController, LoggedInUserAuthDataStore loggedInUserAuthDataStore, ObjectMapper objectMapper, ExoServiceClient exoServiceClient, TimeoutStreamHelper timeoutStreamHelper) {
        return new VideoPrefetcher(partialFileStorage, videoPrefetchModel, DefaultConstrainedListeningExecutorService.m1913a("VideoPrefetching", videoPrefetchExperimentHelper.f11401b, 256, executorService, backgroundWorkLogger, constrainedExecutorsStatusController), fbErrorReporter, deviceConditionHelper, videoPrefetchExperimentHelper, provider, fbZeroFeatureVisibilityHelper, handler, videoKeyCreator, lazy, new DefaultNetworkProcessor(fbHttpRequestProcessor), monotonicClock, sequenceLogger, loggedInUserAuthDataStore, objectMapper, exoServiceClient, timeoutStreamHelper);
    }

    @ProviderMethod
    @Singleton
    static VideoPlayerSessionManager m13966b(QeAccessor qeAccessor) {
        return new VideoPlayerSessionManager(qeAccessor.mo596a(ExperimentsForVideoAbTestModule.f6669o, false));
    }

    @ProviderMethod
    @Singleton
    static VideoPrefetchModel m13964a(FbErrorReporter fbErrorReporter, Lazy<VideoPrefetcher> lazy, Lazy<VideoPrefetchExperimentHelper> lazy2) {
        return new VideoPrefetchModel(fbErrorReporter, lazy, lazy2);
    }

    @VisibleForTesting
    public static PartialFileStorage<VideoCacheKey> getInstanceForTest_VideoCache(FbInjector fbInjector) {
        return PartialFileStorage_VideoCacheMethodAutoProvider.m16675a(fbInjector);
    }
}
