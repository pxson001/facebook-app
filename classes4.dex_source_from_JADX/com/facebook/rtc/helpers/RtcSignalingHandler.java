package com.facebook.rtc.helpers;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbProcessBroadcast;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.random.InsecureRandom;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.inject.Assisted;
import com.facebook.push.mqtt.service.MqttPushServiceClientManager;
import com.facebook.rtc.fbwebrtc.WebrtcConfigHandler;
import com.facebook.rtc.fbwebrtc.WebrtcSignalingSender;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler;
import com.facebook.rtc.helpers.RtcCallHandler.C01231;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.sync.model.thrift.MqttThriftHeader;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.webrtc.ConferenceCall.Listener;
import com.facebook.webrtc.IWebrtcUiInterface;
import com.facebook.webrtc.WebrtcManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import java.util.Random;
import javax.inject.Provider;

/* compiled from: server did not return session cookie when asked. */
public class RtcSignalingHandler {
    @Inject
    private WebrtcManager f2575a;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbTracer> f2576b = UltralightRuntime.b;
    @CrossFbProcessBroadcast
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbBroadcastManager> f2577c = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MqttPushServiceClientManager> f2578d = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AndroidThreadUtil> f2579e = UltralightRuntime.b;
    @Inject
    private WebrtcSignalingSender f2580f;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ObjectMapper> f2581g = UltralightRuntime.b;
    @Inject
    private WebrtcLoggingHandler f2582h;
    @Inject
    private WebrtcConfigHandler f2583i;
    @Inject
    private Provider<WebrtcUiHandler> f2584j;
    @Inject
    @InsecureRandom
    private Random f2585k;
    private final Provider<Boolean> f2586l;
    private final C01231 f2587m;

    final void m2867a(WebrtcManager webrtcManager, com.facebook.inject.Lazy<FbTracer> lazy, com.facebook.inject.Lazy<FbBroadcastManager> lazy2, com.facebook.inject.Lazy<MqttPushServiceClientManager> lazy3, com.facebook.inject.Lazy<AndroidThreadUtil> lazy4, WebrtcSignalingSender webrtcSignalingSender, com.facebook.inject.Lazy<ObjectMapper> lazy5, WebrtcLoggingHandler webrtcLoggingHandler, WebrtcConfigHandler webrtcConfigHandler, Provider<WebrtcUiHandler> provider, Random random) {
        this.f2575a = webrtcManager;
        this.f2576b = lazy;
        this.f2577c = lazy2;
        this.f2578d = lazy3;
        this.f2579e = lazy4;
        this.f2580f = webrtcSignalingSender;
        this.f2581g = lazy5;
        this.f2582h = webrtcLoggingHandler;
        this.f2583i = webrtcConfigHandler;
        this.f2584j = provider;
        this.f2585k = random;
    }

    @Inject
    public RtcSignalingHandler(@Assisted Provider<Boolean> provider, @Assisted SignalingWakelockListener signalingWakelockListener) {
        this.f2586l = provider;
        this.f2587m = signalingWakelockListener;
    }

    private boolean m2862b() {
        return ((Boolean) this.f2586l.get()).booleanValue();
    }

    private void m2860a(String str, String str2) {
        if (!StringUtil.a(str)) {
            FbTraceNode b = ((FbTracer) this.f2576b.get()).b(str);
            FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.m12132a(b);
            a.put("op", "webrtc_application_receive");
            a.put("service", "receiver_webrtc_application_layer");
            a.put("from_notification", "true");
            ((FbTracer) this.f2576b.get()).a(b, FbTraceEvent.REQUEST_RECEIVE, a);
            a.put("error_code", str2);
            a.put("success", "false");
            ((FbTracer) this.f2576b.get()).a(b, FbTraceEvent.RESPONSE_SEND, a);
        }
    }

    public final void m2868a(JsonNode jsonNode) {
        String b = JSONUtil.b(jsonNode.b("trace_info"));
        String b2 = JSONUtil.b(jsonNode.b("topic"));
        if (StringUtil.a(b2)) {
            BLog.b("RtcSignalingHandler", "Missing topic type for gcm webrtc push message");
            m2860a(b, "push_missing_topic");
        } else if (JSONUtil.c(jsonNode.b("uid")) != 0 || "t_rtc_multi".equals(b2)) {
            int i = -1;
            switch (b2.hashCode()) {
                case -791789939:
                    if (b2.equals("webrtc")) {
                        i = 1;
                        break;
                    }
                    break;
                case 110071830:
                    if (b2.equals("t_rtc")) {
                        i = 0;
                        break;
                    }
                    break;
                case 1421860816:
                    if (b2.equals("t_rtc_multi")) {
                        i = 2;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    try {
                        m2859a(new MqttThriftHeader(b), jsonNode.b("payload").t(), true);
                        return;
                    } catch (Throwable e) {
                        BLog.b("RtcSignalingHandler", "Error reading gcm thrift payload", e);
                        m2860a(b, "push_missing_payload");
                        return;
                    }
                case 1:
                    if (Strings.isNullOrEmpty(JSONUtil.b(jsonNode.b("payload")))) {
                        BLog.b("RtcSignalingHandler", "No valid payload in gcm json payload");
                        m2860a(b, "push_missing_payload");
                        return;
                    }
                    return;
                case 2:
                    try {
                        JsonNode a = ((ObjectMapper) this.f2581g.get()).a(JSONUtil.b(jsonNode.b("payload")));
                        if ("rtc_multi_binary".equals(JSONUtil.b(a.b("type")))) {
                            byte[] t = a.b("binaryPayload").t();
                            MqttThriftHeader mqttThriftHeader = new MqttThriftHeader(b);
                            m2861a(t);
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        BLog.b("RtcSignalingHandler", "Error reading gcm multiway message", e2);
                        m2860a(b, "push_missing_multiway_payload");
                        return;
                    }
                default:
                    BLog.b("RtcSignalingHandler", "Invalid topic type: %s", new Object[]{b2});
                    m2860a(b, "push_invalid_topic");
                    return;
            }
        } else {
            BLog.b("RtcSignalingHandler", "No valid uid in gcm payload");
            m2860a(b, "push_missing_uid");
        }
    }

    private void m2859a(MqttThriftHeader mqttThriftHeader, byte[] bArr, boolean z) {
        FbTraceEventAnnotations fbTraceEventAnnotations;
        FbTraceNode fbTraceNode;
        FbTraceNode fbTraceNode2 = FbTraceNode.a;
        FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.m12132a(fbTraceNode2);
        if (Strings.isNullOrEmpty(mqttThriftHeader.traceInfo)) {
            fbTraceEventAnnotations = a;
            fbTraceNode = fbTraceNode2;
        } else {
            String str = mqttThriftHeader.traceInfo;
            FbTraceNode b = ((FbTracer) this.f2576b.get()).b(mqttThriftHeader.traceInfo);
            FbTraceEventAnnotations a2 = FbTraceEventAnnotationsUtil.m12132a(b);
            a2.put("op", z ? "webrtc_application_receive_gcm" : "webrtc_application_receive");
            a2.put("service", "receiver_webrtc_application_layer");
            if (z) {
                a2.put("from_notification", "true");
            }
            ((FbTracer) this.f2576b.get()).a(b, FbTraceEvent.REQUEST_RECEIVE, a2);
            fbTraceEventAnnotations = a2;
            fbTraceNode = b;
        }
        if (m2862b()) {
            m2863c();
            if (this.f2575a.m9873a()) {
                this.f2587m.m2858a();
                this.f2576b.get();
                fbTraceNode2 = FbTracer.a(fbTraceNode);
                FbTraceEventAnnotations a3 = FbTraceEventAnnotationsUtil.m12132a(fbTraceNode2);
                a3.put("op", "app_to_engine_receive");
                ((FbTracer) this.f2576b.get()).a(fbTraceNode2, FbTraceEvent.REQUEST_SEND, a3);
                this.f2575a.m9872a(fbTraceNode2 != FbTraceNode.a ? fbTraceNode2.a() : "", bArr, z);
                ((FbTracer) this.f2576b.get()).a(fbTraceNode2, FbTraceEvent.RESPONSE_RECEIVE, a3);
                fbTraceEventAnnotations.put("success", "true");
                ((FbTracer) this.f2576b.get()).a(fbTraceNode, FbTraceEvent.RESPONSE_SEND, fbTraceEventAnnotations);
                return;
            }
            this.f2582h.m9476a("Thrift_engineFailure", 0, 0, 0, "mqtt");
            fbTraceEventAnnotations.put("error_code", "engine_failure");
            fbTraceEventAnnotations.put("success", "false");
            ((FbTracer) this.f2576b.get()).a(fbTraceNode, FbTraceEvent.RESPONSE_SEND, fbTraceEventAnnotations);
            return;
        }
        fbTraceEventAnnotations.put("error_code", "voip_not_enabled");
        fbTraceEventAnnotations.put("success", "false");
        ((FbTracer) this.f2576b.get()).a(fbTraceNode, FbTraceEvent.RESPONSE_SEND, fbTraceEventAnnotations);
    }

    private void m2861a(byte[] bArr) {
        if (m2862b()) {
            m2863c();
            if (this.f2575a.m9873a()) {
                this.f2587m.m2858a();
                WebrtcManager webrtcManager = this.f2575a;
                String str = "";
                if (webrtcManager.m9873a()) {
                    webrtcManager.f9506w.handleMultiwaySignalingMessage(str, bArr);
                }
                return;
            }
            this.f2582h.m9476a("Thrift_engineFailure", 0, 0, 0, "mqtt");
        }
    }

    private void m2863c() {
        this.f2575a.m9868a((IWebrtcUiInterface) this.f2584j.get(), (Listener) this.f2584j.get(), (WebrtcUiHandler) this.f2584j.get(), this.f2583i, this.f2582h, this.f2580f);
    }

    public final void m2866a(long j) {
        m2863c();
        int nextInt = this.f2585k.nextInt(Integer.MAX_VALUE);
        long j2 = (long) nextInt;
        this.f2580f.sendToPeer("", j, 0, j2, "{\"type\":\"ping\",\"call_id\":0,\"msg_id\":" + Long.toString((long) nextInt) + ",\"version\":1}");
    }

    public final void m2865a() {
        ((DefaultAndroidThreadUtil) this.f2579e.get()).a(new 1(this), new Void[0]);
    }

    public static void m2864d(RtcSignalingHandler rtcSignalingHandler) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.rti.mqtt.intent.ACTION_WAKEUP");
        ((BaseFbBroadcastManager) rtcSignalingHandler.f2577c.get()).a(intent);
    }
}
