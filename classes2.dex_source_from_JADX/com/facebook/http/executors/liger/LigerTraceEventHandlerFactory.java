package com.facebook.http.executors.liger;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.http.debug.NetworkStats;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.http.observer.DownloadBandwidthManager;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.http.performancelistener.CellTowerInfoHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.LigerSamplePolicy;
import com.facebook.proxygen.TraceEventHandler;
import com.facebook.proxygen.TraceEventHandlerFactory;
import com.facebook.push.connectionstatusbridge.MqttBridgeConnectionStatusProvider;
import com.facebook.push.mqtt.service.MqttBridgeConnectionStatusProviderImpl;
import javax.inject.Inject;
import org.apache.http.protocol.HttpContext;

/* compiled from: proxy */
public class LigerTraceEventHandlerFactory implements TraceEventHandlerFactory {
    private final AnalyticsLogger f8716a;
    private final DownloadBandwidthManager f8717b;
    private final FbDataConnectionManager f8718c;
    private final MonotonicClock f8719d;
    private final MqttBridgeConnectionStatusProvider f8720e;
    private final NetworkStats f8721f;

    public static LigerTraceEventHandlerFactory m13537a(InjectorLike injectorLike) {
        return new LigerTraceEventHandlerFactory(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), DownloadBandwidthManager.m4071a(injectorLike), FbDataConnectionManager.m3787a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), MqttBridgeConnectionStatusProviderImpl.m13538a(injectorLike), NetworkStats.m13560a(injectorLike));
    }

    public /* synthetic */ TraceEventHandler create(String str, HttpContext httpContext, ConnectionQuality connectionQuality, HttpFlowStatistics httpFlowStatistics, LigerSamplePolicy ligerSamplePolicy, CellTowerInfoHelper cellTowerInfoHelper, NetworkInfoCollector networkInfoCollector) {
        return m13536a(httpContext, connectionQuality, httpFlowStatistics, ligerSamplePolicy, cellTowerInfoHelper, networkInfoCollector);
    }

    @Inject
    public LigerTraceEventHandlerFactory(AnalyticsLogger analyticsLogger, DownloadBandwidthManager downloadBandwidthManager, FbDataConnectionManager fbDataConnectionManager, MonotonicClock monotonicClock, MqttBridgeConnectionStatusProvider mqttBridgeConnectionStatusProvider, NetworkStats networkStats) {
        this.f8716a = analyticsLogger;
        this.f8717b = downloadBandwidthManager;
        this.f8718c = fbDataConnectionManager;
        this.f8719d = monotonicClock;
        this.f8720e = mqttBridgeConnectionStatusProvider;
        this.f8721f = networkStats;
    }

    private LigerTraceEventHandler m13536a(HttpContext httpContext, ConnectionQuality connectionQuality, HttpFlowStatistics httpFlowStatistics, LigerSamplePolicy ligerSamplePolicy, CellTowerInfoHelper cellTowerInfoHelper, NetworkInfoCollector networkInfoCollector) {
        return new LigerTraceEventHandler(this.f8716a, httpFlowStatistics, httpContext, connectionQuality, ligerSamplePolicy, this.f8717b, this.f8718c, this.f8719d, cellTowerInfoHelper, networkInfoCollector, this.f8720e, this.f8721f);
    }
}
