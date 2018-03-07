package com.facebook.mqtt.debug;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.http.debug.ByteTransferCounter;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: format */
public class MqttStats {
    private static volatile MqttStats f23382d;
    private final MonotonicClock f23383a;
    private long f23384b;
    @GuardedBy("this")
    private final Map<String, MqttStatsHolder> f23385c = Maps.m838c();

    public static com.facebook.mqtt.debug.MqttStats m31660a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23382d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.mqtt.debug.MqttStats.class;
        monitor-enter(r1);
        r0 = f23382d;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m31662b(r0);	 Catch:{ all -> 0x0035 }
        f23382d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23382d;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.mqtt.debug.MqttStats.a(com.facebook.inject.InjectorLike):com.facebook.mqtt.debug.MqttStats");
    }

    private static MqttStats m31662b(InjectorLike injectorLike) {
        return new MqttStats(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public MqttStats(MonotonicClock monotonicClock) {
        this.f23383a = monotonicClock;
        this.f23384b = monotonicClock.now();
    }

    public final synchronized void m31663a(@Nullable String str, long j, boolean z) {
        if (str == null) {
            str = "<not-specified>";
        }
        MqttStatsHolder a = m31661a(str);
        ByteTransferCounter byteTransferCounter;
        if (z) {
            byteTransferCounter = a.data;
            byteTransferCounter.sent += j;
        } else {
            byteTransferCounter = a.data;
            byteTransferCounter.recvd += j;
        }
        a.count++;
    }

    private synchronized MqttStatsHolder m31661a(@Nullable String str) {
        MqttStatsHolder mqttStatsHolder;
        if (str == null) {
            str = "<not-specified>";
        }
        mqttStatsHolder = (MqttStatsHolder) this.f23385c.get(str);
        if (mqttStatsHolder == null) {
            mqttStatsHolder = new MqttStatsHolder(str);
            this.f23385c.put(str, mqttStatsHolder);
        }
        return mqttStatsHolder;
    }
}
