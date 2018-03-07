package com.facebook.quicklog.module;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.samplingpolicy.AnalyticsLoggingPolicy;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.dalvikgc.DalvikGcInstrumentation;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.DebugAndTestConfig;
import com.facebook.quicklog.HoneyClientLogger;
import com.facebook.quicklog.HoneySamplingPolicy;
import com.facebook.quicklog.PerformanceLoggingEventVisitor;
import com.facebook.quicklog.QuickEventListener;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.QuickPerformanceLoggerImpl;
import com.facebook.quicklog.QuickPerformanceLoggerProvider;
import com.facebook.quicklog.StatsLogger;
import com.facebook.quicklog.driver.analytics1.DefaultHoneyClientLogger;
import com.facebook.quicklog.driver.analytics1.DefaultHoneySamplingPolicy;
import com.facebook.quicklog.driver.analytics1.DefaultStatsLogger;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: use_system_sound */
public class QuickPerformanceLoggerModule extends AbstractLibraryModule {

    /* compiled from: use_system_sound */
    final class C01121 implements ActionReceiver {
        final /* synthetic */ QuickPerformanceLogger f1640a;

        C01121(QuickPerformanceLogger quickPerformanceLogger) {
            this.f1640a = quickPerformanceLogger;
        }

        public final void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 437518155);
            this.f1640a.mo436a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -283229198, a);
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static DefaultHoneySamplingPolicy m2923a(AnalyticsLoggingPolicy analyticsLoggingPolicy) {
        return new DefaultHoneySamplingPolicy(analyticsLoggingPolicy);
    }

    @ProviderMethod
    @Singleton
    static HoneyClientLogger m2922a(Lazy<AnalyticsLogger> lazy, Lazy<FbDataConnectionManager> lazy2, Lazy<FbNetworkManager> lazy3) {
        return new DefaultHoneyClientLogger(lazy, lazy2, lazy3);
    }

    @ProviderMethod
    @Singleton
    static DefaultStatsLogger m2924a(LocalStatsLoggerImpl localStatsLoggerImpl) {
        return new DefaultStatsLogger(localStatsLoggerImpl);
    }

    @ProviderMethod
    @Singleton
    static QuickPerformanceLogger m2921a(Lazy<HoneyClientLogger> lazy, HoneySamplingPolicy honeySamplingPolicy, Lazy<StatsLogger> lazy2, MonotonicClock monotonicClock, Clock clock, AppStateManager appStateManager, ExecutorService executorService, DalvikGcInstrumentation dalvikGcInstrumentation, DebugAndTestConfig debugAndTestConfig, ScheduledExecutorService scheduledExecutorService, FbBroadcastManager fbBroadcastManager, Set<PerformanceLoggingEventVisitor> set, Set<QuickEventListener> set2) {
        Lazy<HoneyClientLogger> lazy3 = lazy;
        DefaultHoneySamplingPolicy defaultHoneySamplingPolicy = honeySamplingPolicy;
        Lazy<StatsLogger> lazy4 = lazy2;
        MonotonicClock monotonicClock2 = monotonicClock;
        Clock clock2 = clock;
        StandardDebugAndTestConfig standardDebugAndTestConfig = debugAndTestConfig;
        QuickPerformanceLogger quickPerformanceLoggerImpl = new QuickPerformanceLoggerImpl(lazy3, defaultHoneySamplingPolicy, lazy4, monotonicClock2, clock2, standardDebugAndTestConfig, new StandardAppStates(appStateManager), new SimpleBackgroundExecutor(executorService, scheduledExecutorService), (QuickEventListener[]) set2.toArray(new QuickEventListener[set2.size()]), (PerformanceLoggingEventVisitor[]) set.toArray(new PerformanceLoggingEventVisitor[set.size()]), new DalvikGcInfo(dalvikGcInstrumentation));
        QuickPerformanceLoggerProvider.m3286a(quickPerformanceLoggerImpl);
        m2925a(quickPerformanceLoggerImpl, fbBroadcastManager);
        return quickPerformanceLoggerImpl;
    }

    private static void m2925a(QuickPerformanceLogger quickPerformanceLogger, BaseFbBroadcastManager baseFbBroadcastManager) {
        baseFbBroadcastManager.m2951a().mo506a(AppStateManager.f1111c, new C01121(quickPerformanceLogger)).mo503a().m3296b();
    }
}
