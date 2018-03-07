package com.facebook.http.common;

import com.facebook.common.collect.RingBuffer;
import com.facebook.common.flightrecorder.FbHttpNetworkCustomDataSupplier;
import com.facebook.common.flightrecorder.FlightRecorderEvent;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.inject.Singleton;

@Singleton
/* compiled from: notifications/chat_heads */
public class HttpFlightRecorderRequestSupplier implements FbHttpNetworkCustomDataSupplier {
    private static volatile HttpFlightRecorderRequestSupplier f12101c;
    public final ConcurrentMap<HttpFlowFlightRecorderEvent, HttpFlowFlightRecorderEvent> f12102a = new MapMaker().m1483c(4).m1489l();
    private final RingBuffer<HttpFlowFlightRecorderEvent> f12103b = new RingBuffer(20);

    public static com.facebook.http.common.HttpFlightRecorderRequestSupplier m17818a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f12101c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.http.common.HttpFlightRecorderRequestSupplier.class;
        monitor-enter(r1);
        r0 = f12101c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x0039 }
        r3 = r2.m1503b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m17819b();	 Catch:{ all -> 0x0034 }
        f12101c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f12101c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.HttpFlightRecorderRequestSupplier.a(com.facebook.inject.InjectorLike):com.facebook.http.common.HttpFlightRecorderRequestSupplier");
    }

    private static HttpFlightRecorderRequestSupplier m17819b() {
        return new HttpFlightRecorderRequestSupplier();
    }

    public final void m17821b(HttpFlowFlightRecorderEvent httpFlowFlightRecorderEvent) {
        this.f12102a.remove(httpFlowFlightRecorderEvent);
        this.f12103b.m4065a((Object) httpFlowFlightRecorderEvent);
    }

    public final List<FlightRecorderEvent> mo559a() {
        List<FlightRecorderEvent> b = Lists.m1306b();
        b.addAll(this.f12103b.m4066b());
        b.addAll(this.f12102a.values());
        return b;
    }
}
