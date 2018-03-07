package com.facebook.push.fbpushdata;

import android.content.Context;
import com.facebook.analytics.ReliabilityAnalyticsLogger;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.mqtt.model.thrift.AndroidNotificationPayload;
import com.facebook.mqtt.model.thrift.PushNotificationMessage;
import com.facebook.push.PushSource;
import com.facebook.push.externalcloud.PushPreferenceSelector;
import com.facebook.push.fbpushtoken.PushTokenHolder;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.facebook.push.mqtt.service.MqttPushServiceWrapper;
import com.facebook.push.registration.ServiceType;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.transport.TIOStreamTransport;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetchState */
public class FbPushDataOverMqttHandler implements MqttPushHandler {
    private static final Class<?> f11733a = FbPushDataOverMqttHandler.class;
    private static volatile FbPushDataOverMqttHandler f11734h;
    private final ObjectMapper f11735b;
    private final MqttPushServiceWrapper f11736c;
    private final PushTokenHolder f11737d;
    private final PushTokenHolder f11738e;
    private final ReliabilityAnalyticsLogger f11739f;
    private final Context f11740g;

    public static com.facebook.push.fbpushdata.FbPushDataOverMqttHandler m12272a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11734h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.fbpushdata.FbPushDataOverMqttHandler.class;
        monitor-enter(r1);
        r0 = f11734h;	 Catch:{ all -> 0x003a }
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
        r0 = m12276b(r0);	 Catch:{ all -> 0x0035 }
        f11734h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11734h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.fbpushdata.FbPushDataOverMqttHandler.a(com.facebook.inject.InjectorLike):com.facebook.push.fbpushdata.FbPushDataOverMqttHandler");
    }

    private static FbPushDataOverMqttHandler m12276b(InjectorLike injectorLike) {
        return new FbPushDataOverMqttHandler((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), MqttPushServiceWrapper.m12138a(injectorLike), PushPreferenceSelector.m10869a(injectorLike), ReliabilityAnalyticsLogger.m12278a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public FbPushDataOverMqttHandler(ObjectMapper objectMapper, MqttPushServiceWrapper mqttPushServiceWrapper, PushPreferenceSelector pushPreferenceSelector, ReliabilityAnalyticsLogger reliabilityAnalyticsLogger, Context context) {
        this.f11735b = objectMapper;
        this.f11736c = mqttPushServiceWrapper;
        this.f11739f = reliabilityAnalyticsLogger;
        this.f11740g = context;
        this.f11737d = pushPreferenceSelector.m10871a(ServiceType.GCM);
        this.f11738e = pushPreferenceSelector.m10871a(ServiceType.FBNS);
    }

    public void onMessage(String str, byte[] bArr) {
        if ("/t_push".equals(str)) {
            m12275a(bArr);
        } else if ("/push_notification".equals(str)) {
            m12277b(bArr);
        }
    }

    private void m12275a(byte[] bArr) {
        try {
            AndroidNotificationPayload androidNotificationPayload = PushNotificationMessage.b(new Factory().a(new TIOStreamTransport(new ByteArrayInputStream(bArr, 0, bArr.length)))).fbpushdata;
            ObjectNode a = this.f11735b.e().a("type", androidNotificationPayload.type).a("time", androidNotificationPayload.time).a("message", androidNotificationPayload.message).a("unread_count", androidNotificationPayload.unread_count).a("target_uid", androidNotificationPayload.target_uid).a("is_logged_out_push", androidNotificationPayload.is_logged_out_push);
            if (!StringUtil.a(androidNotificationPayload.href)) {
                a.a("href", androidNotificationPayload.href);
            }
            ObjectNode e = this.f11735b.e();
            for (Entry entry : androidNotificationPayload.params.entrySet()) {
                e.a((String) entry.getKey(), (String) entry.getValue());
            }
            a.c("params", e);
            FbPushDataHandlerService.a(this.f11740g, a.toString(), PushSource.MQTT_PUSH);
        } catch (Exception e2) {
            m12273a(e2, null);
        }
    }

    private void m12277b(byte[] bArr) {
        try {
            JsonNode a = this.f11735b.a(StringUtil.a(bArr));
            String b = JSONUtil.b(a.b("token"));
            String a2 = this.f11737d.m10910a();
            String a3 = this.f11738e.m10910a();
            if (!(Objects.equal(b, a2) || Objects.equal(b, a3))) {
                m12274a(b, a3);
            }
            b = a.b("fbpushnotif").s();
            try {
                FbPushDataHandlerService.a(this.f11740g, this.f11735b.a(b).toString(), PushSource.MQTT_PUSH);
            } catch (Exception e) {
                BLog.b(f11733a, "IOException", e);
                m12273a(e, b);
            }
        } catch (Exception e2) {
            m12273a(e2, null);
        }
    }

    private void m12273a(Exception exception, String str) {
        Map c = Maps.c();
        c.put("exception", exception.toString());
        if (!StringUtil.a(str)) {
            c.put("fbpushnotif", str);
        }
        this.f11739f.m12290a("messaging_push_notif_" + PushSource.MQTT_PUSH.toString(), "MqttParseException", c, null, null, null);
    }

    private void m12274a(String str, String str2) {
        Map c = Maps.c();
        c.put("registration_id", str);
        c.put("registration_fbns_id", str2);
        this.f11739f.m12290a("messaging_push_notif_" + PushSource.MQTT_PUSH.toString(), "mqtt_other_token", c, null, null, null);
    }
}
