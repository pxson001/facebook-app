package com.facebook.push.mqttkick;

import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.push.PushProperty;
import com.facebook.push.PushSource;
import com.facebook.push.fbpushdata.FbPushDataHandler;
import com.fasterxml.jackson.databind.JsonNode;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: header_style */
public class MqttKickFbPushDataHandler implements FbPushDataHandler {
    private static final Class<?> f11311a = MqttKickFbPushDataHandler.class;
    private static volatile MqttKickFbPushDataHandler f11312c;
    private final BaseFbBroadcastManager f11313b;

    public static com.facebook.push.mqttkick.MqttKickFbPushDataHandler m13193a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11312c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqttkick.MqttKickFbPushDataHandler.class;
        monitor-enter(r1);
        r0 = f11312c;	 Catch:{ all -> 0x003a }
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
        r0 = m13194b(r0);	 Catch:{ all -> 0x0035 }
        f11312c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11312c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqttkick.MqttKickFbPushDataHandler.a(com.facebook.inject.InjectorLike):com.facebook.push.mqttkick.MqttKickFbPushDataHandler");
    }

    private static MqttKickFbPushDataHandler m13194b(InjectorLike injectorLike) {
        return new MqttKickFbPushDataHandler((BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(injectorLike));
    }

    @Inject
    public MqttKickFbPushDataHandler(BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f11313b = baseFbBroadcastManager;
    }

    public final void mo617a(JsonNode jsonNode, PushProperty pushProperty) {
        if (PushSource.C2DM.equals(pushProperty.f11217a)) {
            String b = JSONUtil.b(jsonNode.b("type"));
            if (!"webrtc_voip_call".equals(b)) {
                Intent intent = new Intent();
                intent.setAction("com.facebook.rti.mqtt.intent.ACTION_WAKEUP");
                if ("wakeup_mqtt".equals(b)) {
                    JsonNode b2 = jsonNode.b("params").b("exp_mqtt_sid");
                    if (b2 != null) {
                        intent.putExtra("EXPIRED_SESSION", Long.parseLong(b2.s()));
                    }
                }
                this.f11313b.a(intent);
            }
        }
    }
}
