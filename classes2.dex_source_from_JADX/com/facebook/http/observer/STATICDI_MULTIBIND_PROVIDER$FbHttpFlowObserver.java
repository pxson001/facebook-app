package com.facebook.http.observer;

import com.facebook.analytics.AnalyticsHttpDataLogger;
import com.facebook.analytics.AnalyticsHttpErrorReporter;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NetworkDataLogger;
import com.facebook.analytics.StaticMapFlowLogger;
import com.facebook.analytics.throttling.TimeWindowThrottlingPolicy;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.protocol.AccessTokenHttpObserver;
import com.facebook.checkpoint.CheckpointBroadcaster;
import com.facebook.checkpoint.CheckpointHttpObserver;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.hardware.NetworkActivityBroadcastManager;
import com.facebook.common.network.ServerConnectionQualityFlowObserver;
import com.facebook.common.network.ServerConnectionQualityManager;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.debug.http.DebugHttpFlowObserver;
import com.facebook.debug.http.STATICDI_MULTIBIND_PROVIDER$DebugHttpFlowReporter;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.http.common.HttpFlightRecorderRequestSupplier;
import com.facebook.http.common.HttpFlightRecordingFlowObserver;
import com.facebook.http.common.NetworkDataLogUtils;
import com.facebook.http.debug.NetworkStats;
import com.facebook.http.debug.NetworkStatsFlowObserver;
import com.facebook.http.debug.NetworkTimeStats;
import com.facebook.http.performancelistener.HttpReliabilityLogger;
import com.facebook.http.performancelistener.HttpReliabilityObserver;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.logging.cdn.CdnLoggerFlowObserver;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.powermanagement.NetworkActivityFbHttpClientObserver;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.systrace.http.SystraceHttpFlowObserver;
import com.facebook.zero.datacheck.ZeroDataChecker;
import com.facebook.zero.datacheck.ZeroDataCheckerState;
import com.facebook.zero.logging.ZeroHttpObserver;
import com.facebook.zero.token.response.ZeroTokenHeaderResponseManager;
import com.facebook.zero.token.response.ZeroTokenHttpResponseObserver;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FbHttpFlowObserver implements MultiBindIndexedProvider<FbHttpFlowObserver>, Provider<Set<FbHttpFlowObserver>> {
    private final InjectorLike f7819a;

    private STATICDI_MULTIBIND_PROVIDER$FbHttpFlowObserver(InjectorLike injectorLike) {
        this.f7819a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f7819a.getScopeAwareInjector(), this);
    }

    public static Provider<Set<FbHttpFlowObserver>> m12365a(InjectorLike injectorLike) {
        return new STATICDI_MULTIBIND_PROVIDER$FbHttpFlowObserver(injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 16;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new AnalyticsHttpDataLogger(NetworkDataLogger.m17732a((InjectorLike) injector));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new AnalyticsHttpErrorReporter(AnalyticsLoggerMethodAutoProvider.m3509a(injector), ConnectivityManagerMethodAutoProvider.m3847b(injector), TimeWindowThrottlingPolicy.m15990a(injector));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new StaticMapFlowLogger(GatekeeperStoreImplMethodAutoProvider.m2131a(injector).m2185a(1033), AnalyticsLoggerMethodAutoProvider.m3509a(injector));
            case 3:
                return new AccessTokenHttpObserver(LoggedInUserSessionManager.m2511a((InjectorLike) injector));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new CheckpointHttpObserver(CheckpointBroadcaster.m8842a((InjectorLike) injector));
            case 5:
                return new ServerConnectionQualityFlowObserver(ServerConnectionQualityManager.m4095a((InjectorLike) injector));
            case 6:
                return new DebugHttpFlowObserver(new MultiBinderSet(injector.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$DebugHttpFlowReporter(injector)));
            case 7:
                return new HttpFlightRecordingFlowObserver(NetworkDataLogUtils.m15995a((InjectorLike) injector), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injector), HttpFlightRecorderRequestSupplier.m17818a(injector), IdBasedSingletonScopeProvider.m1810b(injector, 572), PerfTestConfig.m2936a(injector));
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return new NetworkStatsFlowObserver(NetworkStats.m13560a((InjectorLike) injector), NetworkTimeStats.m17836a(injector), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injector));
            case 9:
                return new HttpReliabilityObserver(HttpReliabilityLogger.m17843a(injector));
            case 10:
                return new CdnLoggerFlowObserver(DelegatingPerformanceLogger.m2803a((InjectorLike) injector));
            case 11:
                return new NetworkActivityFbHttpClientObserver(NetworkActivityBroadcastManager.m17855a(injector));
            case 12:
                return new SystraceHttpFlowObserver();
            case 13:
                return new ZeroDataChecker(ZeroDataCheckerState.m8439a((InjectorLike) injector), IdBasedProvider.m1811a(injector, 4442), IdBasedProvider.m1811a(injector, 4392), (FbAppType) injector.getInstance(FbAppType.class));
            case 14:
                return new ZeroHttpObserver(AnalyticsLoggerMethodAutoProvider.m3509a(injector), FbSharedPreferencesImpl.m1826a((InjectorLike) injector), IdBasedProvider.m1811a(injector, 815), IdBasedProvider.m1811a(injector, 3759));
            case 15:
                return new ZeroTokenHttpResponseObserver(GatekeeperStoreImplMethodAutoProvider.m2131a(injector), ZeroTokenHeaderResponseManager.m8015a(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
