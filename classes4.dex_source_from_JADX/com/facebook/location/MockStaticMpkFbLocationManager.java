package com.facebook.location;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: is_pinned */
public class MockStaticMpkFbLocationManager extends BaseFbLocationManager {
    public static final String f9924a = MockStaticMpkFbLocationManager.class.getSimpleName();
    private ScheduledExecutorService f9925b;
    public Clock f9926c;
    public long f9927d;
    public final AtomicBoolean f9928e = new AtomicBoolean();
    private ScheduledFuture f9929f;

    public static MockStaticMpkFbLocationManager m10312b(InjectorLike injectorLike) {
        return new MockStaticMpkFbLocationManager(FbLocationStatusUtil.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3863), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbLocationCache.b(injectorLike), AppStateManager.a(injectorLike));
    }

    @Inject
    public MockStaticMpkFbLocationManager(FbLocationStatusUtil fbLocationStatusUtil, Clock clock, ScheduledExecutorService scheduledExecutorService, Provider<ExecutorService> provider, PerformanceLogger performanceLogger, AnalyticsLogger analyticsLogger, FbLocationCache fbLocationCache, AppStateManager appStateManager) {
        super(fbLocationStatusUtil, clock, scheduledExecutorService, provider, performanceLogger, analyticsLogger, fbLocationCache, appStateManager);
        this.f9925b = scheduledExecutorService;
        this.f9926c = clock;
    }

    protected final FbLocationImplementation m10313a() {
        return FbLocationImplementation.MOCK_MPK_STATIC;
    }

    protected final void m10314a(FbLocationManagerParams fbLocationManagerParams) {
        boolean z = true;
        if (this.f9928e.getAndSet(true)) {
            z = false;
        }
        Preconditions.checkState(z, "operation already running");
        this.f9927d = fbLocationManagerParams.e + 1;
        m10311a(this, 0);
    }

    public static void m10311a(MockStaticMpkFbLocationManager mockStaticMpkFbLocationManager, long j) {
        if (j >= 0) {
            mockStaticMpkFbLocationManager.f9929f = mockStaticMpkFbLocationManager.f9925b.schedule(new 1(mockStaticMpkFbLocationManager), j, TimeUnit.MILLISECONDS);
        }
    }

    protected final void m10315b() {
        if (this.f9928e.getAndSet(false) && this.f9929f != null) {
            this.f9929f.cancel(false);
            this.f9929f = null;
        }
    }
}
