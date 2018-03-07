package com.facebook.push.mqtt.service.response;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.service.ClientSubscriptionManager;
import com.facebook.push.mqtt.service.response.JsonMqttResponseProcessor.Callback;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mLines */
public class MqttResponseManager {
    private static volatile MqttResponseManager f15528f;
    private final BaseFbBroadcastManager f15529a;
    private final ClientSubscriptionManager f15530b;
    private final ObjectMapper f15531c;
    private final AbstractFbErrorReporter f15532d;
    private final MonotonicClock f15533e;

    public static com.facebook.push.mqtt.service.response.MqttResponseManager m22141a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15528f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.push.mqtt.service.response.MqttResponseManager.class;
        monitor-enter(r1);
        r0 = f15528f;	 Catch:{ all -> 0x003a }
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
        r0 = m22142b(r0);	 Catch:{ all -> 0x0035 }
        f15528f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15528f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.push.mqtt.service.response.MqttResponseManager.a(com.facebook.inject.InjectorLike):com.facebook.push.mqtt.service.response.MqttResponseManager");
    }

    private static MqttResponseManager m22142b(InjectorLike injectorLike) {
        return new MqttResponseManager(LocalFbBroadcastManager.m2946a(injectorLike), ClientSubscriptionManager.m9396a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public MqttResponseManager(BaseFbBroadcastManager baseFbBroadcastManager, ClientSubscriptionManager clientSubscriptionManager, ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter, MonotonicClock monotonicClock) {
        this.f15529a = baseFbBroadcastManager;
        this.f15530b = clientSubscriptionManager;
        this.f15531c = objectMapper;
        this.f15532d = abstractFbErrorReporter;
        this.f15533e = monotonicClock;
    }

    public final <T> MqttResponseProcessor<T> m22143a(String str, Callback<T> callback) {
        return new JsonMqttResponseProcessor(str, this.f15529a, this.f15533e, this.f15530b, this.f15531c, this.f15532d, callback);
    }

    public final <T> MqttResponseProcessor<T> m22144a(String str, ThriftMqttResponseProcessor.Callback<T> callback) {
        return new ThriftMqttResponseProcessor(str, this.f15529a, this.f15533e, this.f15530b, callback);
    }
}
