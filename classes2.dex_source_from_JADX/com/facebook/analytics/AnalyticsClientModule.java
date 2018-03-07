package com.facebook.analytics;

import com.facebook.analytics.annotations.DeviceStatusReporterInterval;
import com.facebook.analytics.counterlogger.CommunicationScheduler;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.analytics.session.AnalyticsBackgroundState;
import com.facebook.analytics2.logger.EventListener;
import com.facebook.analytics2.loggermodule.HighPriEventListener;
import com.facebook.analytics2.loggermodule.NormalPriEventListener;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.common.idleexecutor.DefaultProcessIdleExecutor;
import com.facebook.common.idleexecutor.IdleExecutorFactory;
import com.facebook.common.time.MonotonicClock;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.concurrent.ExecutorService;
import javax.inject.Singleton;

@DoNotStrip
@InjectorModule
/* compiled from: update_user_settings */
public class AnalyticsClientModule extends AbstractLibraryModule {

    /* compiled from: update_user_settings */
    final class C01981 implements EventListener {
        final /* synthetic */ Lazy f3140a;

        C01981(Lazy lazy) {
            this.f3140a = lazy;
        }

        public final void mo733a() {
            ((NewAnalyticsEventInjector) this.f3140a.get()).m5656a();
        }
    }

    /* compiled from: update_user_settings */
    final class C01992 implements EventListener {
        final /* synthetic */ Lazy f3142a;

        C01992(Lazy lazy) {
            this.f3142a = lazy;
        }

        public final void mo733a() {
            ((NewAnalyticsEventInjector) this.f3142a.get()).m5656a();
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DeviceStatusReporterInterval
    @ProviderMethod
    public static Long m3516a(FbSharedPreferences fbSharedPreferences) {
        return Long.valueOf(fbSharedPreferences.mo277a(AnalyticsPrefKeys.f4984f, 3600000));
    }

    @ProviderMethod
    @Singleton
    @AnalyticsThreadExecutorOnIdle
    static DefaultProcessIdleExecutor m3514a(ExecutorService executorService, IdleExecutorFactory idleExecutorFactory) {
        return idleExecutorFactory.m2728a(executorService);
    }

    @ProviderMethod
    @Singleton
    static AnalyticsLogger m3512a(GatekeeperStore gatekeeperStore, Lazy<DefaultAnalyticsLogger> lazy, Lazy<NewAnalyticsLogger> lazy2) {
        if (gatekeeperStore.m2189a(471, false)) {
            return (AnalyticsLogger) lazy2.get();
        }
        return (AnalyticsLogger) lazy.get();
    }

    @ProviderMethod
    @Singleton
    static CommunicationScheduler m3511a(BaseFbBroadcastManager baseFbBroadcastManager, AnalyticsLogger analyticsLogger, MonotonicClock monotonicClock) {
        return new CommunicationScheduler(baseFbBroadcastManager, analyticsLogger, monotonicClock);
    }

    @ProviderMethod
    @NormalPriEventListener
    @Singleton
    static EventListener m3513a(Lazy<NewAnalyticsEventInjector> lazy) {
        return new C01981(lazy);
    }

    @ProviderMethod
    @AnalyticsBackgroundState
    public static Boolean m3515a(NavigationLogger navigationLogger) {
        return Boolean.valueOf(navigationLogger.f3315z);
    }

    @ProviderMethod
    @Singleton
    @HighPriEventListener
    static EventListener m3517b(Lazy<NewAnalyticsEventInjector> lazy) {
        return new C01992(lazy);
    }

    @DoNotStrip
    public static AnalyticsLogger getInstanceForTest_AnalyticsLogger(FbInjector fbInjector) {
        return AnalyticsLoggerMethodAutoProvider.m3509a(fbInjector);
    }

    @DoNotStrip
    public static LoggingTestConfig getInstanceForTest_LoggingTestConfig(FbInjector fbInjector) {
        return LoggingTestConfig.a(fbInjector);
    }
}
