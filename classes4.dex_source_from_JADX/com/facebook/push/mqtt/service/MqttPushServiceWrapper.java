package com.facebook.push.mqtt.service;

import android.os.RemoteException;
import com.facebook.inject.InjectorLike;
import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.push.mqtt.service.MqttPushServiceClient.MqttPublishListener;
import com.fasterxml.jackson.databind.JsonNode;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ff7aa03673acb04c81ded20491b7e949 */
public class MqttPushServiceWrapper {
    private static volatile MqttPushServiceWrapper f11623b;
    private final MqttPushServiceClientManagerImpl f11624a;

    public static com.facebook.push.mqtt.service.MqttPushServiceWrapper m12138a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11623b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.service.MqttPushServiceWrapper.class;
        monitor-enter(r1);
        r0 = f11623b;	 Catch:{ all -> 0x003a }
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
        r0 = m12139b(r0);	 Catch:{ all -> 0x0035 }
        f11623b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11623b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.service.MqttPushServiceWrapper.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.service.MqttPushServiceWrapper");
    }

    private static MqttPushServiceWrapper m12139b(InjectorLike injectorLike) {
        return new MqttPushServiceWrapper(MqttPushServiceClientManagerImpl.a(injectorLike));
    }

    @Inject
    public MqttPushServiceWrapper(MqttPushServiceClientManagerImpl mqttPushServiceClientManagerImpl) {
        this.f11624a = mqttPushServiceClientManagerImpl;
    }

    public final int m12140a(String str, JsonNode jsonNode, MqttQOSLevel mqttQOSLevel, @Nullable MqttPublishListener mqttPublishListener) {
        try {
            MqttPushServiceClient a = this.f11624a.a();
            try {
                int a2 = a.mo855a(str, jsonNode, mqttQOSLevel, mqttPublishListener);
                return a2;
            } finally {
                a.mo870f();
            }
        } catch (RemoteException e) {
            return -1;
        }
    }

    public final int m12141a(String str, byte[] bArr, MqttQOSLevel mqttQOSLevel, @Nullable MqttPublishListener mqttPublishListener) {
        try {
            MqttPushServiceClient a = this.f11624a.a();
            try {
                int a2 = a.mo856a(str, bArr, mqttQOSLevel, mqttPublishListener);
                return a2;
            } finally {
                a.mo870f();
            }
        } catch (RemoteException e) {
            return -1;
        }
    }
}
