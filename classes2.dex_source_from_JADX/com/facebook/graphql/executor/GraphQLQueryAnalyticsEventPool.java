package com.facebook.graphql.executor;

import android.support.v4.util.Pools$Pool;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.analytics.BaseAnalyticsConfig;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: save_bookmark_nux_force */
public class GraphQLQueryAnalyticsEventPool {
    static final GraphQLQueryAnalyticsEvent f6284a = new GraphQLQueryAnaltyicsEventNoOp();
    private static volatile GraphQLQueryAnalyticsEventPool f6285f;
    private final MonotonicClock f6286b;
    private final Clock f6287c;
    private final BaseAnalyticsConfig f6288d;
    @GuardedBy("this")
    private Pools$Pool<GraphQLQueryAnalyticsEventImpl> f6289e;

    /* compiled from: save_bookmark_nux_force */
    public class GraphQLQueryAnaltyicsEventNoOp implements GraphQLQueryAnalyticsEvent {
        public final void mo1465a(String str) {
        }

        public final void mo1461a(long j) {
        }

        public final void mo1470b(String str) {
        }

        public final void mo1468a(boolean z) {
        }

        public final void mo1466a(String str, String str2) {
        }

        @Nullable
        public final HoneyClientEvent mo1460a() {
            return null;
        }

        public final void mo1467a(String str, Throwable th) {
        }

        public final void mo1464a(Exception exception) {
        }

        public final void mo1463a(GraphQLRequest graphQLRequest, Exception exception) {
        }

        public final void mo1462a(GraphQLRequest graphQLRequest) {
        }

        public final void mo1469b() {
        }

        public final void mo1471c() {
        }

        public final void mo1472d() {
        }
    }

    public static com.facebook.graphql.executor.GraphQLQueryAnalyticsEventPool m10495a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6285f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.executor.GraphQLQueryAnalyticsEventPool.class;
        monitor-enter(r1);
        r0 = f6285f;	 Catch:{ all -> 0x003a }
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
        r0 = m10496b(r0);	 Catch:{ all -> 0x0035 }
        f6285f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6285f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.GraphQLQueryAnalyticsEventPool.a(com.facebook.inject.InjectorLike):com.facebook.graphql.executor.GraphQLQueryAnalyticsEventPool");
    }

    private static GraphQLQueryAnalyticsEventPool m10496b(InjectorLike injectorLike) {
        return new GraphQLQueryAnalyticsEventPool(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike), FbAnalyticsConfig.m3559a(injectorLike));
    }

    @Inject
    public GraphQLQueryAnalyticsEventPool(MonotonicClock monotonicClock, Clock clock, BaseAnalyticsConfig baseAnalyticsConfig) {
        this.f6286b = monotonicClock;
        this.f6287c = clock;
        this.f6288d = baseAnalyticsConfig;
    }

    public final synchronized GraphQLQueryAnalyticsEvent m10497a(String str, @Nullable String str2, boolean z, boolean z2) {
        GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent;
        if (this.f6288d.m3563a(z ? "batch_cache_access" : "cache_access")) {
            graphQLQueryAnalyticsEvent = (GraphQLQueryAnalyticsEventImpl) m10494a().mo740a();
            if (graphQLQueryAnalyticsEvent == null) {
                graphQLQueryAnalyticsEvent = new GraphQLQueryAnalyticsEventImpl(this.f6287c, this.f6286b, this);
            }
            graphQLQueryAnalyticsEvent.m11679a(str, str2, z, z2);
        } else {
            graphQLQueryAnalyticsEvent = f6284a;
        }
        return graphQLQueryAnalyticsEvent;
    }

    final synchronized void m10498a(GraphQLQueryAnalyticsEventImpl graphQLQueryAnalyticsEventImpl) {
        m10494a().mo741a(graphQLQueryAnalyticsEventImpl);
    }

    private synchronized Pools$Pool<GraphQLQueryAnalyticsEventImpl> m10494a() {
        if (this.f6289e == null) {
            this.f6289e = new Pools$SynchronizedPool(5);
        }
        return this.f6289e;
    }
}
