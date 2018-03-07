package com.facebook.common.executors;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.executors.ExecutorsUserScopeHelper.C04514;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: web/ */
public class ExecutorsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    static {
        GuavaExecutionListHack.m1743a();
    }

    @ProviderMethod
    @Singleton
    static HandlerThread m1704a(FbHandlerThreadFactory fbHandlerThreadFactory) {
        HandlerThread a = fbHandlerThreadFactory.m3579a("BgHandler");
        a.start();
        return a;
    }

    @SharedThreadPool
    @ProviderMethod
    @Singleton
    static ThreadPoolExecutor m1716a(ThreadPoolFactory threadPoolFactory) {
        return threadPoolFactory.m1892b("Shared");
    }

    @DefaultExecutorService
    @ProviderMethod
    @Singleton
    static ListeningExecutorService m1711a(ThreadPoolExecutor threadPoolExecutor, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("DefaultExecutor", 8, 256, threadPoolExecutor, backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @Singleton
    @NormalNewExecutorService
    static ListeningExecutorService m1709a(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("NormalNewExecutor", threadPoolFactory.f930b, 256, threadPoolFactory.m1893c("Shared"), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @BackgroundExecutorService
    @Singleton
    static ListeningExecutorService m1718b(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("BackgroundExecutor", threadPoolFactory.f929a, 256, threadPoolFactory.m1891a("Shared"), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @Singleton
    @ForegroundExecutorService
    static ListeningExecutorService m1724c(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("ForegroundExecutor", threadPoolFactory.f931c, 256, threadPoolFactory.m1894d("Shared"), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @FeedFetchExecutorService
    @Singleton
    static ListeningExecutorService m1726d(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("FeedFetchExecutor", threadPoolFactory.f932d, 256, threadPoolFactory.m1895e("Shared"), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @SingleThreadedExecutorService
    static ScheduledExecutorService m1715a(ThreadPoolFactory threadPoolFactory, Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1940a((Provider) provider, threadPoolFactory.m1896g("SingleScheduled"));
    }

    @ProviderMethod
    @CpuSpinCheckerScheduledExecutor
    public static ScheduledExecutorService m1722b(ThreadPoolFactory threadPoolFactory, Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1940a((Provider) provider, threadPoolFactory.m1896g("CpuSpinDetector-"));
    }

    @ProviderMethod
    @ApplicationPollerScheduledExecutor
    @Singleton
    static ScheduledExecutorService m1725c(ThreadPoolFactory threadPoolFactory, Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1940a((Provider) provider, threadPoolFactory.m1896g("ApplicationPoller-"));
    }

    @ProviderMethod
    @Singleton
    @AnalyticsThreadExecutor
    static ExecutorService m1721b(ThreadPoolFactory threadPoolFactory) {
        return (FbThreadPoolExecutor) ExecutorTracker.m1908a(new FbThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("AnalyticsThread", ThreadPriority.BACKGROUND), threadPoolFactory.f933e));
    }

    @ProviderMethod
    @Singleton
    @VideoPerformanceExecutor
    static ListeningExecutorService m1723c(ThreadPoolFactory threadPoolFactory) {
        return MoreExecutors.m1814a(threadPoolFactory.m1890a(3, "video-perf-"));
    }

    @PhotoUploadSerialExecutorService
    @ProviderMethod
    @Singleton
    static ExecutorService m1727d(ThreadPoolFactory threadPoolFactory) {
        return threadPoolFactory.m1890a(1, "photos-upload-");
    }

    @DefaultExecutorService
    @ProviderMethod
    @Singleton
    static ScheduledExecutorService m1728d(ThreadPoolFactory threadPoolFactory, Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1940a((Provider) provider, (ScheduledExecutorService) (FbScheduledThreadPoolExecutor) ExecutorTracker.m1908a(new FbScheduledThreadPoolExecutor(2, new NamedThreadFactory("ScNorm_" + "Shared", ThreadPriority.NORMAL), threadPoolFactory.f933e)));
    }

    @ProviderMethod
    @BackgroundExecutorService
    @Singleton
    static ScheduledExecutorService m1731e(ThreadPoolFactory threadPoolFactory, Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1940a((Provider) provider, (ScheduledExecutorService) (FbScheduledThreadPoolExecutor) ExecutorTracker.m1908a(new FbScheduledThreadPoolExecutor(2, new NamedThreadFactory("ScBg_" + "Shared", ThreadPriority.BACKGROUND), threadPoolFactory.f933e)));
    }

    @ProviderMethod
    @MqttClientScheduledExecutorService
    public static ScheduledExecutorService m1733f(ThreadPoolFactory threadPoolFactory, Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1940a((Provider) provider, (ScheduledExecutorService) (FbScheduledThreadPoolExecutor) ExecutorTracker.m1908a(new FbScheduledThreadPoolExecutor(threadPoolFactory.f931c, new NamedThreadFactory("ScUg_" + "MqttClient", ThreadPriority.URGENT), threadPoolFactory.f933e)));
    }

    @DefaultExecutorService
    @ProviderMethod
    static DefaultSerialListeningExecutorService m1707a(ExecutorService executorService, BackgroundWorkLogger backgroundWorkLogger, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return new DefaultSerialListeningExecutorService(executorService, backgroundWorkLogger, constrainedExecutorsStatusController);
    }

    @MqttClientSingleThreadExecutorService
    @ProviderMethod
    public static ListeningExecutorService m1729e(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("MqttClientSingleThreadExecutorService", 1, 256, ThreadPoolFactory.m1889f("MqttClient"), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @WhistleSingleThreadExecutorService
    public static ScheduledExecutorService m1735g(ThreadPoolFactory threadPoolFactory, Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1940a((Provider) provider, threadPoolFactory.m1897h("whistle"));
    }

    @ProviderMethod
    @ForUiThread
    static Looper m1705a() {
        return Looper.getMainLooper();
    }

    @ProviderMethod
    @ForUiThread
    static Handler m1703a(Looper looper) {
        return new Handler(looper);
    }

    @ForNonUiThread
    @ProviderMethod
    static Looper m1706a(HandlerThread handlerThread) {
        return handlerThread.getLooper();
    }

    @ForNonUiThread
    @ProviderMethod
    static Handler m1717b(Looper looper) {
        return new Handler(looper);
    }

    @ProviderMethod
    @Singleton
    @ForUiThread
    static ListeningScheduledExecutorService m1714a(Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1939a((Provider) provider, new HandlerListeningExecutorServiceImpl(new Handler(Looper.getMainLooper())));
    }

    @ProviderMethod
    @ForNonUiThread
    @Singleton
    static ListeningScheduledExecutorService m1712a(Looper looper, Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1939a((Provider) provider, new HandlerListeningExecutorServiceImpl(new Handler(looper)));
    }

    @ProviderMethod
    @ForUiThreadImmediate
    @Singleton
    static ListeningScheduledExecutorService m1719b(Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1939a((Provider) provider, new HandlerImmediateListeningExecutorServiceImpl(new Handler(Looper.getMainLooper())));
    }

    @ProviderMethod
    @Singleton
    @ResourceNetworkRequestExecutor
    static ListeningExecutorService m1732f(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("ResourceFetch", 6, Integer.MAX_VALUE, threadPoolFactory.m1892b("ResourceFetch"), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @BrowserBackgroundRequestExecutor
    @Singleton
    static ListeningExecutorService m1734g(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("BrowserBackground", 6, Integer.MAX_VALUE, threadPoolFactory.m1891a("BrowserBackground"), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @ImageNetworkRequestExecutor
    @Singleton
    static ListeningExecutorService m1736h(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("ImageFetch", 3, Integer.MAX_VALUE, ThreadPoolFactory.m1886a("ImgFetch", 3), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ImageDecodeExecutorService
    @ProviderMethod
    static Integer m1720b() {
        return Integer.valueOf(Runtime.getRuntime().availableProcessors());
    }

    @ImageDecodeExecutorService
    @ProviderMethod
    @Singleton
    static ListeningExecutorService m1710a(Integer num, ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("ImageDecode", num.intValue(), Integer.MAX_VALUE, ThreadPoolFactory.m1886a("ImgDecode", num.intValue()), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @Singleton
    @ImageCacheRequestExecutor
    static PrioritizedExecutorService m1737i(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return new C04514(new FbPrioritizedThreadPoolExecutor("ImageCache", 2, ThreadPoolFactory.m1886a("ImgCache", 2), backgroundWorkLogger, constrainedExecutorsStatusController), provider);
    }

    @ImageTransformExecutorService
    @ProviderMethod
    @Singleton
    static ListeningExecutorService m1738j(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("ImageTransform", 3, Integer.MAX_VALUE, ThreadPoolFactory.m1886a("ImgTrans", 3), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ImageOffUiThreadExecutor
    @ProviderMethod
    @Singleton
    static ListeningExecutorService m1739k(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("ImageOffUiThread", 1, Integer.MAX_VALUE, ThreadPoolFactory.m1886a("ImgOffUI", 1), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @SearchRequestExecutor
    @ProviderMethod
    @Singleton
    static ListeningExecutorService m1740l(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("UberSearch", 30, Integer.MAX_VALUE, threadPoolFactory.m1894d("UberSearch"), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @SearchTypeaheadNetworkExecutor
    @Singleton
    static QueueingListeningExecutorService m1741m(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("TypeaheadSearch", 2, Integer.MAX_VALUE, threadPoolFactory.m1894d("TypeaheadSearch"), backgroundWorkLogger, constrainedExecutorsStatusController));
    }

    @ProviderMethod
    @Singleton
    @VideoServerHttpServiceExecutor
    static ExecutorService m1730e(ThreadPoolFactory threadPoolFactory) {
        return threadPoolFactory.m1892b("VideoServerThread");
    }

    @ProviderMethod
    @ForUiThreadWakeup
    @Singleton
    static ListeningScheduledExecutorService m1713a(WakingExecutorServiceProvider wakingExecutorServiceProvider, Provider<ViewerContextManager> provider) {
        return ExecutorsUserScopeHelper.m1939a((Provider) provider, wakingExecutorServiceProvider.a(null, null));
    }

    @ProviderMethod
    @Singleton
    @LightSharedPrefExecutorService
    static ListeningExecutorService m1708a(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return DefaultConstrainedListeningExecutorService.m1913a("LightSharedPrefExecutor", 2, 256, threadPoolFactory.m1893c("LightSP"), backgroundWorkLogger, constrainedExecutorsStatusController);
    }

    @ProviderMethod
    @StorylineMuxerExecutor
    @Singleton
    static ListeningExecutorService m1742n(ThreadPoolFactory threadPoolFactory, BackgroundWorkLogger backgroundWorkLogger, Provider<ViewerContextManager> provider, ConstrainedExecutorsStatusController constrainedExecutorsStatusController) {
        return ExecutorsUserScopeHelper.m1938a((Provider) provider, DefaultConstrainedListeningExecutorService.m1913a("StorylineMuxerExecutor", 1, 256, threadPoolFactory.m1897h("SlMuxer"), backgroundWorkLogger, constrainedExecutorsStatusController));
    }
}
