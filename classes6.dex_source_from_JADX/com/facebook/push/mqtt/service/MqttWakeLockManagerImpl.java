package com.facebook.push.mqtt.service;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.facebook.common.android.PowerManagerMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.mqtt.MqttWakeLockType;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: slideshow-video-batch */
public class MqttWakeLockManagerImpl {
    private static volatile MqttWakeLockManagerImpl f4313c;
    private final Provider<Boolean> f4314a;
    private final Map<MqttWakeLockType, WakeLock> f4315b = Maps.e();

    public static com.facebook.push.mqtt.service.MqttWakeLockManagerImpl m6409a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4313c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.service.MqttWakeLockManagerImpl.class;
        monitor-enter(r1);
        r0 = f4313c;	 Catch:{ all -> 0x003a }
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
        r0 = m6410b(r0);	 Catch:{ all -> 0x0035 }
        f4313c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4313c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.service.MqttWakeLockManagerImpl.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.service.MqttWakeLockManagerImpl");
    }

    private static MqttWakeLockManagerImpl m6410b(InjectorLike injectorLike) {
        return new MqttWakeLockManagerImpl(PowerManagerMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 4290));
    }

    @Inject
    public MqttWakeLockManagerImpl(PowerManager powerManager, Provider<Boolean> provider) {
        this.f4314a = provider;
        for (MqttWakeLockType mqttWakeLockType : MqttWakeLockType.values()) {
            WakeLock newWakeLock = powerManager.newWakeLock(1, mqttWakeLockType.name());
            newWakeLock.setReferenceCounted(false);
            this.f4315b.put(mqttWakeLockType, newWakeLock);
        }
    }
}
