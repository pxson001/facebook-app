package com.facebook.http.executors.liger;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.http.debug.NetworkStats;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.http.observer.DownloadBandwidthManager;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.NetworkInfo;
import com.facebook.http.observer.NetworkInfoCollector;
import com.facebook.http.observer.RequestContext;
import com.facebook.http.observer.ResponseBandwidthManager;
import com.facebook.http.observer.TimeInfo;
import com.facebook.http.performancelistener.CellTowerInfoHelper;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.proxygen.HTTPFlowStats;
import com.facebook.proxygen.LigerSamplePolicy;
import com.facebook.proxygen.RequestStats;
import com.facebook.proxygen.TraceEvent;
import com.facebook.proxygen.TraceEventHandler;
import com.facebook.push.connectionstatusbridge.MqttBridgeConnectionStatusProvider;
import com.facebook.push.connectionstatusbridge.MqttBridgeConnectionStatusProvider.MqttBridgeConnectionStatus;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HttpContext;

/* compiled from: none */
public class LigerTraceEventHandler implements TraceEventHandler {
    private final AnalyticsLogger f12231a;
    private final HttpFlowStatistics f12232b;
    private final ResponseBandwidthManager f12233c;
    private final LigerSamplePolicy f12234d;
    private Map<String, String> f12235e = new HashMap();
    private final CellTowerInfoHelper f12236f;
    private final NetworkInfoCollector f12237g;
    private final MqttBridgeConnectionStatusProvider f12238h;
    private final NetworkStats f12239i;

    public LigerTraceEventHandler(AnalyticsLogger analyticsLogger, HttpFlowStatistics httpFlowStatistics, HttpContext httpContext, ConnectionQuality connectionQuality, LigerSamplePolicy ligerSamplePolicy, DownloadBandwidthManager downloadBandwidthManager, FbDataConnectionManager fbDataConnectionManager, MonotonicClock monotonicClock, CellTowerInfoHelper cellTowerInfoHelper, NetworkInfoCollector networkInfoCollector, MqttBridgeConnectionStatusProvider mqttBridgeConnectionStatusProvider, NetworkStats networkStats) {
        this.f12231a = analyticsLogger;
        this.f12235e.put("http_stack", String.valueOf(httpFlowStatistics.m17698g()));
        this.f12235e.put("connection_type", httpFlowStatistics.m17695d());
        this.f12235e.put("connection_subtype", httpFlowStatistics.m17695d() + " " + httpFlowStatistics.m17697e());
        this.f12235e.put("request_queue_time_ms", Long.toString(httpFlowStatistics.m17702l()));
        RequestContext a = RequestContext.m17674a(httpContext);
        this.f12234d = ligerSamplePolicy;
        this.f12235e.put("request_friendly_name", a.m17675a());
        this.f12235e.put("connqual", connectionQuality.name());
        CallerContext d = a.m17677d();
        if (d != null) {
            this.f12235e.put("request_call_path", d.m9066a());
            this.f12235e.put("request_analytics_tag", d.m9068c());
            this.f12235e.put("request_module_analytics_tag", d.m9069d());
            this.f12235e.put("request_feature_tag", d.m9067b());
        }
        if (fbDataConnectionManager != null) {
            this.f12235e.put("conncls_bandwidth_qual", fbDataConnectionManager.m3799b().name());
            this.f12235e.put("conncls_bandwidth_bps", Long.toString((long) (fbDataConnectionManager.m3803e() * 125.0d)));
            this.f12235e.put("conncls_latency_qual", fbDataConnectionManager.m3802d().name());
            this.f12235e.put("conncls_latency_ms", Long.toString((long) fbDataConnectionManager.m3804f()));
        }
        this.f12235e.put("request_method", (String) httpContext.getAttribute("request_method"));
        this.f12235e.put("weight", Integer.toString(this.f12234d.getFlowTimeWeight()));
        this.f12232b = httpFlowStatistics;
        if (downloadBandwidthManager == null || monotonicClock == null) {
            this.f12233c = null;
        } else {
            this.f12233c = new ResponseBandwidthManager(downloadBandwidthManager, monotonicClock);
        }
        this.f12236f = cellTowerInfoHelper;
        this.f12237g = networkInfoCollector;
        this.f12238h = mqttBridgeConnectionStatusProvider;
        this.f12239i = networkStats;
        if (this.f12234d.isFlowTimeSampled() || this.f12234d.isCellTowerSampled()) {
            NetworkInfo a2 = this.f12237g.mo495a();
            if (a2 != null) {
                this.f12235e.putAll(a2.m27418c());
            }
        }
    }

    public void decorateStatistics(RequestStats requestStats, long j) {
        if (requestStats != null) {
            int i;
            HoneyAnalyticsEvent honeyClientEvent;
            this.f12235e.put("request_status", this.f12232b.m17701k());
            HTTPFlowStats flowStats = requestStats.getFlowStats();
            m18117a(flowStats);
            if (flowStats.getIsNewConnection()) {
                i = 1;
            } else {
                i = 0;
            }
            LoomLogger.a(i, flowStats.getRequestHeaderCompressedBytes(), flowStats.getRequestBodyBytes(), flowStats.getResponseHeaderCompressedBytes(), flowStats.getResponseBodyCompressedBytes(), (int) flowStats.getDnsLatency(), (int) flowStats.getTcpLatency(), (int) flowStats.getTlsLatency(), (int) flowStats.getRspBodyBytesTime(), j);
            if (this.f12234d.shouldPrintTraceEvents()) {
                this.f12235e.get("request_friendly_name");
                for (TraceEvent toPrettyJson : requestStats.getTraceEvents()) {
                    new StringBuilder().append(toPrettyJson.toPrettyJson()).append("\n");
                }
            }
            if (flowStats != null) {
                this.f12232b.requestHeaderBytes.m17703a((long) flowStats.getRequestHeaderBytes());
                this.f12232b.requestBodyBytes.m17703a((long) flowStats.getRequestBodyBytes());
                this.f12232b.responseHeaderBytes.m17703a((long) flowStats.getResponseHeaderBytes());
                this.f12232b.responseBodyBytes.m17703a((long) flowStats.getResponseBodyBytes());
                if (flowStats.getServerAddress() != null) {
                    this.f12232b.m17689a(flowStats.getServerAddress().getHostAddress());
                }
                this.f12232b.m17693b(flowStats.getIsNewConnection());
                this.f12232b.m17690a(flowStats.isSpdy());
                this.f12239i.m13564a((String) this.f12235e.get("request_friendly_name"), flowStats.getRequestHeaderCompressedBytes(), flowStats.getRequestBodyBytes(), flowStats.getResponseHeaderCompressedBytes(), flowStats.getResponseBodyCompressedBytes(), flowStats.getIsNewConnection());
            }
            if (this.f12234d.isFlowTimeSampled()) {
                honeyClientEvent = new HoneyClientEvent("mobile_http_flow");
                honeyClientEvent.m5094g("RequestStats");
                honeyClientEvent.m5088a(this.f12235e);
                honeyClientEvent.m5088a(requestStats.getFlowTimeData());
                MqttBridgeConnectionStatus a = this.f12238h.mo1824a();
                if (a != MqttBridgeConnectionStatus.UNAVAILABLE) {
                    honeyClientEvent.m5090b("mqtt_status", a.name());
                }
                this.f12231a.mo533c(honeyClientEvent);
            }
            if (this.f12234d.isCertSampled()) {
                Map certificateVerificationData = requestStats.getCertificateVerificationData();
                if (!(certificateVerificationData == null || certificateVerificationData.isEmpty())) {
                    HoneyAnalyticsEvent honeyClientEvent2 = new HoneyClientEvent("cert_verification");
                    honeyClientEvent2.m5094g("RequestStats");
                    certificateVerificationData.put("weight", Long.toString(5000));
                    honeyClientEvent2.m5088a(certificateVerificationData);
                    TimeInfo b = this.f12237g.mo497b();
                    if (b != null) {
                        honeyClientEvent2.m5088a(b.m27420a());
                    }
                    this.f12231a.mo533c(honeyClientEvent2);
                }
            }
            if (this.f12234d.isCellTowerSampled()) {
                honeyClientEvent = new HoneyClientEvent("cell_tower_info");
                honeyClientEvent.m5094g("RequestStats");
                Map hashMap = new HashMap();
                this.f12236f.m13644a(hashMap);
                this.f12236f.m13645b(hashMap);
                honeyClientEvent.m5088a(hashMap);
                honeyClientEvent.m5088a(this.f12235e);
                if (flowStats != null) {
                    honeyClientEvent.m5083a("request_header_size", flowStats.getRequestHeaderCompressedBytes());
                    honeyClientEvent.m5083a("request_body_size", flowStats.getRequestBodyBytes());
                    honeyClientEvent.m5083a("response_header_size", flowStats.getResponseHeaderCompressedBytes());
                    honeyClientEvent.m5083a("response_body_size", flowStats.getResponseBodyCompressedBytes());
                }
                this.f12231a.mo526a(honeyClientEvent);
            }
        }
    }

    private void m18117a(HTTPFlowStats hTTPFlowStats) {
        if (hTTPFlowStats != null && this.f12233c != null) {
            this.f12233c.m17709a((long) hTTPFlowStats.mRspBodyBytes, hTTPFlowStats.mRspBodyBytesTime);
        }
    }
}
