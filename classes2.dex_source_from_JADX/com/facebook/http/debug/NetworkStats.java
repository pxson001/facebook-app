package com.facebook.http.debug;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;

@DoNotStrip
@Singleton
/* compiled from: prompts/ */
public class NetworkStats {
    private static volatile NetworkStats f8735e;
    private final MonotonicClock f8736a;
    private long f8737b;
    @GuardedBy("this")
    private final Map<String, NetworkStatsHolder> f8738c = Maps.m838c();
    @GuardedBy("this")
    private final Map<String, NetworkStatsHolder> f8739d = Maps.m838c();

    public static com.facebook.http.debug.NetworkStats m13560a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8735e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.debug.NetworkStats.class;
        monitor-enter(r1);
        r0 = f8735e;	 Catch:{ all -> 0x003a }
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
        r0 = m13562b(r0);	 Catch:{ all -> 0x0035 }
        f8735e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8735e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.debug.NetworkStats.a(com.facebook.inject.InjectorLike):com.facebook.http.debug.NetworkStats");
    }

    private static NetworkStats m13562b(InjectorLike injectorLike) {
        return new NetworkStats(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public NetworkStats(MonotonicClock monotonicClock) {
        this.f8736a = monotonicClock;
        this.f8737b = monotonicClock.now();
    }

    public final synchronized void m13565a(HttpHost httpHost, @Nullable String str) {
        NetworkStatsHolder b = m13563b(httpHost, str);
        b.numConnections++;
    }

    public final synchronized void m13568a(HttpHost httpHost, @Nullable String str, HttpRequest httpRequest) {
        NetworkStatsHolder b = m13563b(httpHost, str);
        b.totalHttpFlows++;
        String method = httpRequest.getRequestLine().getMethod();
        if ("GET".equals(method)) {
            b.numGets++;
        } else if ("POST".equals(method)) {
            b.numPosts++;
        }
    }

    public final synchronized void m13567a(HttpHost httpHost, @Nullable String str, long j, long j2, long j3) {
        NetworkStatsHolder b = m13563b(httpHost, str);
        ByteTransferCounter byteTransferCounter = b.bytesHeaders;
        byteTransferCounter.sent += j;
        if (j2 >= 0) {
            byteTransferCounter = b.bytesPayload;
            byteTransferCounter.sent += j2;
        }
        ByteTransferCounter byteTransferCounter2 = b.bytesHeaders;
        byteTransferCounter2.recvd += j3;
    }

    public final synchronized void m13566a(HttpHost httpHost, @Nullable String str, long j) {
        ByteTransferCounter byteTransferCounter = m13563b(httpHost, str).bytesPayload;
        byteTransferCounter.recvd += j;
    }

    public final synchronized void m13564a(String str, int i, int i2, int i3, int i4, boolean z) {
        NetworkStatsHolder a = m13561a(str);
        ByteTransferCounter byteTransferCounter = a.bytesHeaders;
        byteTransferCounter.sent += (long) i;
        byteTransferCounter = a.bytesHeaders;
        byteTransferCounter.recvd += (long) i3;
        byteTransferCounter = a.bytesPayload;
        byteTransferCounter.sent += (long) i2;
        byteTransferCounter = a.bytesPayload;
        byteTransferCounter.recvd += (long) i4;
        if (z) {
            a.numConnections++;
        }
        a.numGets++;
    }

    private synchronized NetworkStatsHolder m13563b(HttpHost httpHost, @Nullable String str) {
        NetworkStatsHolder networkStatsHolder;
        if (str == null) {
            str = "<not-specified>";
        }
        networkStatsHolder = (NetworkStatsHolder) this.f8738c.get(str);
        if (networkStatsHolder == null) {
            networkStatsHolder = new NetworkStatsHolder(str);
            this.f8738c.put(str, networkStatsHolder);
        }
        networkStatsHolder.f12183a.add(httpHost);
        return networkStatsHolder;
    }

    private synchronized NetworkStatsHolder m13561a(@Nullable String str) {
        NetworkStatsHolder networkStatsHolder;
        if (str == null) {
            str = "<not-specified>";
        }
        networkStatsHolder = (NetworkStatsHolder) this.f8739d.get(str);
        if (networkStatsHolder == null) {
            networkStatsHolder = new NetworkStatsHolder(str);
            this.f8739d.put(str, networkStatsHolder);
        }
        return networkStatsHolder;
    }
}
