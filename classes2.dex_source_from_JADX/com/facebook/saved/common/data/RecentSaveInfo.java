package com.facebook.saved.common.data;

import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.common.graphql.FetchRecentSaveInfoGraphQL.FetchRecentSaveInfoGraphQLString;
import com.facebook.saved.gating.feature.SaverInfoXConfig;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: network_info_signal_dbm */
public class RecentSaveInfo {
    private static volatile RecentSaveInfo f12484h;
    private Integer f12485a = null;
    public RecentSaveTimeframe f12486b = null;
    private long f12487c;
    private XConfigReader f12488d;
    private final ListeningExecutorService f12489e;
    private final GraphQLQueryExecutor f12490f;
    private final MonotonicClock f12491g;

    public static com.facebook.saved.common.data.RecentSaveInfo m18557a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12484h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved.common.data.RecentSaveInfo.class;
        monitor-enter(r1);
        r0 = f12484h;	 Catch:{ all -> 0x003a }
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
        r0 = m18559b(r0);	 Catch:{ all -> 0x0035 }
        f12484h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12484h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.common.data.RecentSaveInfo.a(com.facebook.inject.InjectorLike):com.facebook.saved.common.data.RecentSaveInfo");
    }

    private static RecentSaveInfo m18559b(InjectorLike injectorLike) {
        return new RecentSaveInfo(XConfigReader.m2681a(injectorLike), C0055x2995691a.m1881a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public RecentSaveInfo(XConfigReader xConfigReader, ListeningExecutorService listeningExecutorService, GraphQLQueryExecutor graphQLQueryExecutor, MonotonicClock monotonicClock) {
        this.f12488d = xConfigReader;
        this.f12489e = listeningExecutorService;
        this.f12490f = graphQLQueryExecutor;
        this.f12491g = monotonicClock;
    }

    public final void m18564c() {
        TypedGraphQlQueryString fetchRecentSaveInfoGraphQLString = new FetchRecentSaveInfoGraphQLString();
        fetchRecentSaveInfoGraphQLString.m11315a("query_type", "ALL_SAVES");
        Futures.m2458a(this.f12490f.m10446a(GraphQLRequest.m11587a(fetchRecentSaveInfoGraphQLString)), new 1(this), this.f12489e);
    }

    public final int m18562a() {
        if (this.f12485a == null || m18561e()) {
            m18560d();
        }
        return this.f12485a.intValue();
    }

    public final RecentSaveTimeframe m18563b() {
        if (this.f12486b == null || m18561e()) {
            m18560d();
        }
        return this.f12486b;
    }

    public static synchronized void m18558a(RecentSaveInfo recentSaveInfo, int i, RecentSaveTimeframe recentSaveTimeframe) {
        synchronized (recentSaveInfo) {
            recentSaveInfo.f12485a = Integer.valueOf(i);
            recentSaveInfo.f12486b = recentSaveTimeframe;
            recentSaveInfo.f12487c = recentSaveInfo.f12491g.now();
        }
    }

    private void m18560d() {
        m18558a(this, this.f12488d.m2683a(SaverInfoXConfig.f14997e, 0), RecentSaveTimeframe.convertString(this.f12488d.m2685a(SaverInfoXConfig.f14998f, null)));
    }

    private boolean m18561e() {
        return this.f12491g.now() - this.f12487c > 21600000;
    }
}
