package com.facebook.rtc.fbwebrtc;

import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbtrace.FbTraceEvent;
import com.facebook.fbtrace.FbTraceEventAnnotations;
import com.facebook.fbtrace.FbTraceEventAnnotationsUtil;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.fbtrace.FbTracer;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.mqtt.model.thrift.PresenceChangeSubscribe;
import com.facebook.push.mqtt.service.MqttPushServiceClient.MqttPublishListener;
import com.facebook.push.mqtt.service.MqttPushServiceWrapper;
import com.facebook.rtc.interfaces.RtcAppSignalingHandler;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtc.models.thrift.WebrtcMessageServerExtension;
import com.facebook.rti.shared.skywalker.SkywalkerSubscriptionConnector;
import com.facebook.sync.model.thrift.MqttThriftHeader;
import com.facebook.thrift.TException;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.webrtc.ConferenceCall.Listener;
import com.facebook.webrtc.IWebrtcConfigInterface;
import com.facebook.webrtc.IWebrtcLoggingInterface;
import com.facebook.webrtc.IWebrtcSignalingMessageInterface;
import com.facebook.webrtc.IWebrtcUiInterface;
import com.facebook.webrtc.WebrtcManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: serialized_story_data */
public class WebrtcSignalingSender implements IWebrtcSignalingMessageInterface {
    public static final Class<?> f2588a = WebrtcSignalingSender.class;
    private static volatile WebrtcSignalingSender f2589m;
    private final WebrtcAppSignalingHandler f2590b;
    private final MqttPushServiceWrapper f2591c;
    private Provider<String> f2592d;
    public final FbTracer f2593e;
    public Provider<SkywalkerSubscriptionConnector> f2594f;
    public WebrtcManager f2595g;
    @DefaultExecutorService
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ListeningExecutorService> f2596h = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<WebrtcUiHandler> f2597i = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<WebrtcSignalingSender> f2598j = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<WebrtcLoggingHandler> f2599k = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<WebrtcConfigHandler> f2600l = UltralightRuntime.b;

    public static com.facebook.rtc.fbwebrtc.WebrtcSignalingSender m2872a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f2589m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.fbwebrtc.WebrtcSignalingSender.class;
        monitor-enter(r1);
        r0 = f2589m;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m2879b(r0);	 Catch:{ all -> 0x0035 }
        f2589m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2589m;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.WebrtcSignalingSender.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.WebrtcSignalingSender");
    }

    private static WebrtcSignalingSender m2879b(InjectorLike injectorLike) {
        WebrtcSignalingSender webrtcSignalingSender = new WebrtcSignalingSender(WebrtcAppSignalingHandler.m2884a(injectorLike), MqttPushServiceWrapper.m12138a(injectorLike), IdBasedProvider.a(injectorLike, 4442), IdBasedSingletonScopeProvider.a(injectorLike, 3363), FbTracer.a(injectorLike));
        webrtcSignalingSender.m2875a(IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedLazy.a(injectorLike, 10375), IdBasedSingletonScopeProvider.b(injectorLike, 3308), IdBasedSingletonScopeProvider.b(injectorLike, 3344), IdBasedSingletonScopeProvider.b(injectorLike, 3305));
        return webrtcSignalingSender;
    }

    private void m2875a(com.facebook.inject.Lazy<ListeningExecutorService> lazy, com.facebook.inject.Lazy<WebrtcUiHandler> lazy2, com.facebook.inject.Lazy<WebrtcSignalingSender> lazy3, com.facebook.inject.Lazy<WebrtcLoggingHandler> lazy4, com.facebook.inject.Lazy<WebrtcConfigHandler> lazy5) {
        this.f2596h = lazy;
        this.f2597i = lazy2;
        this.f2598j = lazy3;
        this.f2599k = lazy4;
        this.f2600l = lazy5;
    }

    @Inject
    private WebrtcSignalingSender(RtcAppSignalingHandler rtcAppSignalingHandler, MqttPushServiceWrapper mqttPushServiceWrapper, Provider<String> provider, Provider<SkywalkerSubscriptionConnector> provider2, FbTracer fbTracer) {
        this.f2590b = rtcAppSignalingHandler;
        this.f2591c = mqttPushServiceWrapper;
        this.f2592d = provider;
        this.f2594f = provider2;
        this.f2593e = fbTracer;
    }

    public void setWebrtcManager(WebrtcManager webrtcManager) {
        this.f2595g = webrtcManager;
    }

    private boolean m2876a(String str, long j, long j2, long j3, String str2) {
        JsonNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.a("to", j);
        objectNode.a("payload", str2);
        objectNode.a("id", j3);
        FbTraceNode a = m2870a(str);
        FbTraceEventAnnotations a2 = m2869a(a, j, j2, j3);
        this.f2593e.a(a, FbTraceEvent.REQUEST_RECEIVE, a2);
        FbTraceNode a3 = FbTracer.a(a);
        FbTraceEventAnnotations a4 = FbTraceEventAnnotationsUtil.m12132a(a3);
        a4.put("op", "mqtt_publish_send");
        a4.put("sender_topic", "/webrtc");
        objectNode.a("fbtrace_meta", a3.a());
        this.f2593e.a(a3, FbTraceEvent.REQUEST_SEND, a4);
        if (this.f2591c.m12140a("/webrtc", objectNode, MqttQOSLevel.ACKNOWLEDGED_DELIVERY, m2871a(j2, j3, a3, a4)) == -1) {
            m2880b(a, a3, a4, j, j2, j3);
            return false;
        }
        a2.put("success", "true");
        this.f2593e.a(a, FbTraceEvent.RESPONSE_SEND, a2);
        return true;
    }

    private boolean m2877a(String str, long j, long j2, long j3, byte[] bArr) {
        FbTraceNode a = m2870a(str);
        FbTraceEventAnnotations a2 = m2869a(a, j, j2, j3);
        this.f2593e.a(a, FbTraceEvent.REQUEST_RECEIVE, a2);
        FbTraceNode a3 = FbTracer.a(a);
        FbTraceEventAnnotations a4 = FbTraceEventAnnotationsUtil.m12132a(a3);
        a4.put("op", "mqtt_publish_send");
        a4.put("sender_topic", "/t_rtc");
        try {
            byte[] a5 = m2878a(new TSerializer(new Factory()).a(new MqttThriftHeader(a3 != FbTraceNode.a ? a3.a() : null)), bArr);
            this.f2593e.a(a3, FbTraceEvent.REQUEST_SEND, a4);
            if (this.f2591c.m12141a("/t_rtc", a5, MqttQOSLevel.ACKNOWLEDGED_DELIVERY, m2871a(j2, j3, a3, a4)) == -1) {
                m2880b(a, a3, a2, j, j2, j3);
                return false;
            }
            a2.put("success", "true");
            this.f2593e.a(a, FbTraceEvent.RESPONSE_SEND, a2);
            return true;
        } catch (TException e) {
            m2874a(a, a3, a2, j, j2, j3);
            return false;
        }
    }

    public final void m2883a(long j) {
        Long.valueOf(j);
        ((SkywalkerSubscriptionConnector) this.f2594f.get()).a("voip_camp_on/" + j, new 2(this));
        ((ListeningExecutorService) this.f2596h.get()).a(new 1(this, j));
    }

    public static boolean m2882d(WebrtcSignalingSender webrtcSignalingSender, long j) {
        List arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j));
        try {
            byte[] a = new TSerializer(new Factory()).a(new PresenceChangeSubscribe(arrayList));
            if (webrtcSignalingSender.f2591c.m12141a("/t_spc", m2878a(new byte[]{(byte) 0}, a), MqttQOSLevel.ACKNOWLEDGED_DELIVERY, new 3(webrtcSignalingSender)) != -1) {
                return true;
            }
            return false;
        } catch (TException e) {
            BLog.b(f2588a, "/t_spc serialization error", e);
            return false;
        }
    }

    private static void m2873a(FbTraceEventAnnotations fbTraceEventAnnotations, String str, long j, long j2, long j3) {
        fbTraceEventAnnotations.put("sender_id", str);
        fbTraceEventAnnotations.put("recipient_id", Long.valueOf(j));
        fbTraceEventAnnotations.put("call_id", Long.valueOf(j2));
        fbTraceEventAnnotations.put("msg_id", Long.valueOf(j3));
        fbTraceEventAnnotations.put("op", "webrtc_publish");
        fbTraceEventAnnotations.put("service", "sender_webrtc_application_layer");
    }

    private static byte[] m2878a(byte[] bArr, byte[] bArr2) {
        Object copyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, copyOf, bArr.length, bArr2.length);
        return copyOf;
    }

    public static void m2881b(WebrtcSignalingSender webrtcSignalingSender) {
        webrtcSignalingSender.f2595g.m9868a((IWebrtcUiInterface) webrtcSignalingSender.f2597i.get(), (Listener) webrtcSignalingSender.f2597i.get(), (WebrtcUiHandler) webrtcSignalingSender.f2597i.get(), (IWebrtcConfigInterface) webrtcSignalingSender.f2600l.get(), (IWebrtcLoggingInterface) webrtcSignalingSender.f2599k.get(), (IWebrtcSignalingMessageInterface) webrtcSignalingSender.f2598j.get());
    }

    private void m2874a(FbTraceNode fbTraceNode, FbTraceNode fbTraceNode2, FbTraceEventAnnotations fbTraceEventAnnotations, long j, long j2, long j3) {
        Long.valueOf(j);
        Long.valueOf(j3);
        if (this.f2595g != null) {
            m2881b(this);
            this.f2595g.m9869a(null, j2, j3, "thrift serialization error", -1, "client");
        }
        fbTraceEventAnnotations.put("success", "false");
        fbTraceEventAnnotations.put("error_code", "thrift_serialize_error");
        this.f2593e.a(fbTraceNode2, FbTraceEvent.RESPONSE_RECEIVE, fbTraceEventAnnotations);
        this.f2593e.a(fbTraceNode, FbTraceEvent.RESPONSE_SEND, fbTraceEventAnnotations);
    }

    private void m2880b(FbTraceNode fbTraceNode, FbTraceNode fbTraceNode2, FbTraceEventAnnotations fbTraceEventAnnotations, long j, long j2, long j3) {
        Long.valueOf(j);
        Long.valueOf(j3);
        if (this.f2595g != null) {
            m2881b(this);
            this.f2595g.m9869a(null, j2, j3, "Mqtt not available", -1, "MQTT");
        }
        fbTraceEventAnnotations.put("success", "false");
        fbTraceEventAnnotations.put("error_code", "mqtt_client_failure_1");
        this.f2593e.a(fbTraceNode2, FbTraceEvent.RESPONSE_RECEIVE, fbTraceEventAnnotations);
        this.f2593e.a(fbTraceNode, FbTraceEvent.RESPONSE_SEND, fbTraceEventAnnotations);
    }

    private MqttPublishListener m2871a(long j, long j2, FbTraceNode fbTraceNode, FbTraceEventAnnotations fbTraceEventAnnotations) {
        return new 4(this, fbTraceEventAnnotations, fbTraceNode, j, j2);
    }

    private FbTraceNode m2870a(String str) {
        FbTraceNode fbTraceNode = FbTraceNode.a;
        if (!Strings.isNullOrEmpty(str)) {
            fbTraceNode = this.f2593e.b(str);
        }
        fbTraceNode.a();
        return fbTraceNode;
    }

    private FbTraceEventAnnotations m2869a(FbTraceNode fbTraceNode, long j, long j2, long j3) {
        String str = !StringUtil.a((CharSequence) this.f2592d.get()) ? (String) this.f2592d.get() : "-1";
        FbTraceEventAnnotations a = FbTraceEventAnnotationsUtil.m12132a(fbTraceNode);
        m2873a(a, str, j, j2, j3);
        return a;
    }

    public boolean sendToPeer(String str, long j, long j2, long j3, String str2) {
        Long.valueOf(j);
        Long.valueOf(j3);
        return m2876a(str, j, j2, j3, str2);
    }

    public boolean sendToSelf(String str, long j, long j2, String str2) {
        Long.valueOf(j2);
        String str3 = (String) this.f2592d.get();
        if (StringUtil.a(str3)) {
            return false;
        }
        return m2876a(str, Long.parseLong(str3), j, j2, str2);
    }

    public boolean sendOfferToPeer(String str, long j, long j2, long j3, byte[] bArr) {
        byte[] a;
        if (this.f2590b != null) {
            WebrtcMessageServerExtension a2 = this.f2590b.m2886a();
            if (a2 != null) {
                try {
                    a = m2878a(bArr, new TSerializer(new Factory()).a(a2));
                    return sendThriftToPeer(str, j, j2, j3, a);
                } catch (TException e) {
                    FbTraceNode a3 = m2870a(str);
                    FbTraceEventAnnotations a4 = m2869a(a3, j, j2, j3);
                    FbTraceNode fbTraceNode = FbTraceNode.a;
                    this.f2593e.a(a3, FbTraceEvent.REQUEST_RECEIVE, a4);
                    m2874a(a3, fbTraceNode, a4, j, j2, j3);
                    return false;
                }
            }
        }
        a = bArr;
        return sendThriftToPeer(str, j, j2, j3, a);
    }

    public boolean sendThriftToPeer(String str, long j, long j2, long j3, byte[] bArr) {
        Long.valueOf(j);
        Long.valueOf(j3);
        Integer.valueOf(bArr.length);
        return m2877a(str, j, j2, j3, bArr);
    }

    public boolean sendThriftToSelf(String str, long j, long j2, byte[] bArr) {
        long j3 = 0;
        String str2 = (String) this.f2592d.get();
        if (!StringUtil.a(str2)) {
            j3 = Long.parseLong(str2);
        }
        Long.valueOf(j3);
        Long.valueOf(j2);
        Integer.valueOf(bArr.length);
        return m2877a(str, j3, j, j2, bArr);
    }

    public boolean sendMultiwaySignalingMessage(String str, String str2, String str3, byte[] bArr) {
        Integer.valueOf(bArr.length);
        try {
            if (this.f2591c.m12141a("/t_rtc_multi", m2878a(new TSerializer(new Factory()).a(new MqttThriftHeader("")), bArr), MqttQOSLevel.ACKNOWLEDGED_DELIVERY, new 5(this, str3, str2)) == -1) {
                return false;
            }
            return true;
        } catch (TException e) {
            return false;
        }
    }
}
