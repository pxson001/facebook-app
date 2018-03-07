package com.facebook.tigon.httpclientadapter;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.http.DebugHttpFlowObserver;
import com.facebook.http.common.FbHttpParamsUtility;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.observer.FbHttpFlowObserver;
import com.facebook.http.observer.HttpFlowStatistics;
import com.facebook.http.observer.NetworkInfo;
import com.facebook.http.observer.RequestContext;
import com.facebook.http.observer.Stage;
import com.facebook.http.protocol.HttpWireCallback;
import com.facebook.push.connectionstatusbridge.MqttBridgeConnectionStatusProvider.MqttBridgeConnectionStatus;
import com.facebook.tigon.iface.FacebookLoggingRequestInfo;
import com.facebook.tigon.iface.TigonRequest;
import com.facebook.tigon.iface.TigonRequestLayers;
import com.facebook.tigon.tigonapi.TigonError;
import com.facebook.tigon.tigonapi.TigonFlowTimeDataInfoImpl;
import com.facebook.tigon.tigonapi.TigonHttpFlowStatsInfoImpl;
import com.facebook.tigon.tigonapi.TigonSummaryImpl;
import com.facebook.tigon.tigonapi.TigonSummaryLayers;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: num_collections */
public class FlowObserverRequestInfo implements HttpContext {
    public final TigonFlowStateController f4909a;
    private final HttpRequest f4910b;
    private final HttpWireCallback f4911c;
    private final HashMap<String, Object> f4912d;
    private int f4913e = 0;
    @Nullable
    public HttpFlowStatistics f4914f;
    @Nullable
    private Set<FbHttpFlowObserver> f4915g;
    @Nullable
    private HttpResponse f4916h;
    private boolean f4917i;

    public FlowObserverRequestInfo(TigonFlowStateController tigonFlowStateController, HttpUriRequest httpUriRequest, HttpWireCallback httpWireCallback) {
        this.f4909a = tigonFlowStateController;
        this.f4910b = httpUriRequest;
        this.f4911c = httpWireCallback;
        this.f4912d = new HashMap(2);
    }

    public final void m6212a(TigonRequest tigonRequest, int i) {
        CallerContext callerContext;
        FacebookLoggingRequestInfo facebookLoggingRequestInfo = (FacebookLoggingRequestInfo) tigonRequest.a(TigonRequestLayers.c);
        String requestPriority = RequestPriority.fromNumericValue(tigonRequest.d().a, RequestPriority.DEFAULT_PRIORITY).toString();
        if (facebookLoggingRequestInfo instanceof FacebookLoggingInfoWithCallerContext) {
            callerContext = ((FacebookLoggingInfoWithCallerContext) facebookLoggingRequestInfo).f4908b;
        } else {
            callerContext = CallerContext.a(FlowObserverRequestInfo.class, facebookLoggingRequestInfo != null ? facebookLoggingRequestInfo.logNamespace() : null);
        }
        new RequestContext(facebookLoggingRequestInfo != null ? facebookLoggingRequestInfo.logName() : "null", requestPriority, 0, i, callerContext, null).b(this);
        m6206a();
    }

    public final void m6211a(TigonRequest tigonRequest) {
        Preconditions.checkNotNull(this.f4914f);
        Preconditions.checkNotNull(this.f4915g);
        this.f4917i = true;
        this.f4914f.a = SystemClock.elapsedRealtime() - FbHttpParamsUtility.a(this.f4910b);
        this.f4914f.requestHeaderBytes.a = m6208b(tigonRequest);
        for (FbHttpFlowObserver a : this.f4915g) {
            a.a(this.f4910b, this);
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private static long m6208b(TigonRequest tigonRequest) {
        long j = 0;
        for (Entry entry : tigonRequest.c().entrySet()) {
            long length;
            j += (long) ((String) entry.getKey()).length();
            if (entry.getValue() != null) {
                length = ((long) ((String) entry.getValue()).length()) + j;
            } else {
                length = j;
            }
            j = length;
        }
        return j;
    }

    public final void m6216a(HttpResponse httpResponse) {
        Preconditions.checkNotNull(this.f4915g);
        this.f4916h = httpResponse;
        for (FbHttpFlowObserver a : this.f4915g) {
            a.a(this.f4916h, this);
        }
    }

    public final InputStream m6210a(InputStream inputStream) {
        Preconditions.checkNotNull(this.f4916h);
        Preconditions.checkNotNull(this.f4915g);
        for (FbHttpFlowObserver fbHttpFlowObserver : this.f4915g) {
            if (fbHttpFlowObserver instanceof DebugHttpFlowObserver) {
                inputStream = ((DebugHttpFlowObserver) fbHttpFlowObserver).a(inputStream);
            }
        }
        return inputStream;
    }

    public final void m6214a(@Nullable TigonSummaryImpl tigonSummaryImpl) {
        Preconditions.checkNotNull(this.f4916h);
        Preconditions.checkNotNull(this.f4915g);
        m6207a(tigonSummaryImpl, "done");
        for (FbHttpFlowObserver b : this.f4915g) {
            b.b(this.f4916h, this);
        }
    }

    public final void m6215a(@Nullable TigonSummaryImpl tigonSummaryImpl, IOException iOException) {
        Preconditions.checkNotNull(this.f4915g);
        m6207a(tigonSummaryImpl, m6205a(iOException));
        m6209b(iOException);
    }

    public final void m6213a(TigonError tigonError, TigonSummaryImpl tigonSummaryImpl, int i) {
        try {
            Preconditions.checkState(i == this.f4913e);
            m6207a(tigonSummaryImpl, m6204a(tigonError));
            m6209b(new TigonErrorException(tigonError));
        } catch (Throwable e) {
            this.f4909a.m6234b().a("Tigon retry state", String.format(Locale.US, "att:%d/%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.f4913e)}), e, 1);
        }
        this.f4913e++;
        this.f4916h = null;
        m6206a();
    }

    private void m6207a(TigonSummaryImpl tigonSummaryImpl, String str) {
        Preconditions.checkNotNull(this.f4914f);
        this.f4914f.i = str;
        if (tigonSummaryImpl != null) {
            Preconditions.checkNotNull(this.f4914f);
            Preconditions.checkNotNull(this.f4914f.i);
            TigonHttpFlowStatsInfoImpl tigonHttpFlowStatsInfoImpl = (TigonHttpFlowStatsInfoImpl) tigonSummaryImpl.m6345a(TigonSummaryLayers.f5065c);
            if (tigonHttpFlowStatsInfoImpl != null) {
                TigonFlowStateController tigonFlowStateController = this.f4909a;
                int i = tigonHttpFlowStatsInfoImpl.f5040f;
                tigonFlowStateController.f4945m.a((long) i, tigonHttpFlowStatsInfoImpl.f5041g);
                this.f4914f.requestHeaderBytes.a = (long) tigonHttpFlowStatsInfoImpl.f5037c;
                this.f4914f.requestBodyBytes.a = (long) tigonHttpFlowStatsInfoImpl.f5038d;
                this.f4914f.responseHeaderBytes.a = (long) tigonHttpFlowStatsInfoImpl.f5039e;
                this.f4914f.responseBodyBytes.a = (long) tigonHttpFlowStatsInfoImpl.f5040f;
                if (!StringUtil.a(tigonHttpFlowStatsInfoImpl.f5035a)) {
                    this.f4914f.e = tigonHttpFlowStatsInfoImpl.f5035a;
                }
                this.f4914f.b(tigonHttpFlowStatsInfoImpl.f5036b);
                this.f4914f.a(tigonHttpFlowStatsInfoImpl.f5042h);
            }
            TigonFlowTimeDataInfoImpl tigonFlowTimeDataInfoImpl = (TigonFlowTimeDataInfoImpl) tigonSummaryImpl.m6345a(TigonSummaryLayers.f5066d);
            if (tigonFlowTimeDataInfoImpl != null) {
                Map hashMap = new HashMap();
                hashMap.put("http_stack", this.f4914f.c);
                hashMap.put("connection_type", this.f4914f.g);
                hashMap.put("connection_subtype", this.f4914f.g + " " + this.f4914f.h);
                hashMap.put("request_queue_time_ms", Long.toString(this.f4914f.a));
                RequestContext a = RequestContext.a(this);
                hashMap.put("request_friendly_name", a.a);
                CallerContext callerContext = a.f;
                if (callerContext != null) {
                    hashMap.put("request_call_path", callerContext.b);
                    hashMap.put("request_analytics_tag", callerContext.c());
                    hashMap.put("request_module_analytics_tag", callerContext.d());
                    hashMap.put("request_feature_tag", callerContext.b());
                }
                FbDataConnectionManager fbDataConnectionManager = this.f4909a.f4938f;
                if (fbDataConnectionManager != null) {
                    hashMap.put("connqual", fbDataConnectionManager.c().name());
                    hashMap.put("conncls_bandwidth_qual", fbDataConnectionManager.b().name());
                    hashMap.put("conncls_bandwidth_bps", Long.toString((long) (fbDataConnectionManager.e() * 125.0d)));
                    hashMap.put("conncls_latency_qual", fbDataConnectionManager.d().name());
                    hashMap.put("conncls_latency_ms", Long.toString((long) fbDataConnectionManager.f()));
                }
                hashMap.put("weight", Integer.toString(this.f4909a.m6235f()));
                hashMap.put("request_status", this.f4914f.i);
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("mobile_http_flow");
                honeyClientEvent.c = "RequestStats";
                honeyClientEvent.a(hashMap);
                NetworkInfo a2 = this.f4909a.f4943k.a();
                if (a2 != null) {
                    honeyClientEvent.a(a2.c());
                }
                honeyClientEvent.a(tigonFlowTimeDataInfoImpl.f5034a);
                MqttBridgeConnectionStatus a3 = this.f4909a.f4944l.a();
                if (a3 != MqttBridgeConnectionStatus.UNAVAILABLE) {
                    honeyClientEvent.b("mqtt_status", a3.name());
                }
                this.f4909a.f4942j.a(honeyClientEvent);
            }
        }
    }

    private void m6206a() {
        TigonFlowStateController tigonFlowStateController = this.f4909a;
        HttpFlowStatistics httpFlowStatistics = new HttpFlowStatistics("Tigon", tigonFlowStateController.f4939g, tigonFlowStateController.f4940h, this.f4911c);
        httpFlowStatistics.g = tigonFlowStateController.f4937e.k();
        httpFlowStatistics.h = tigonFlowStateController.f4937e.l();
        httpFlowStatistics.f = tigonFlowStateController.f4937e.j();
        this.f4914f = httpFlowStatistics;
        this.f4917i = false;
        this.f4915g = (Set) this.f4909a.f4935c.get();
        for (FbHttpFlowObserver a : this.f4915g) {
            a.a(this.f4910b, this, this.f4914f);
        }
    }

    private String m6205a(IOException iOException) {
        if (iOException instanceof TigonErrorException) {
            return m6204a(((TigonErrorException) iOException).tigonError);
        }
        return "error";
    }

    private static String m6204a(TigonError tigonError) {
        return tigonError.f5030a == 1 ? "cancelled" : "error";
    }

    private void m6209b(IOException iOException) {
        Preconditions.checkNotNull(this.f4914f);
        Preconditions.checkNotNull(this.f4915g);
        if (this.f4917i) {
            for (FbHttpFlowObserver a : this.f4915g) {
                a.a(this.f4916h == null ? Stage.HTTP_CLIENT_EXECUTE : Stage.READ_RESPONSE_BODY, this.f4910b, this.f4916h, this, iOException);
            }
        }
    }

    public Object getAttribute(String str) {
        return this.f4912d.get(str);
    }

    public void setAttribute(String str, Object obj) {
        this.f4912d.put(str, obj);
    }

    public Object removeAttribute(String str) {
        return this.f4912d.remove(str);
    }
}
