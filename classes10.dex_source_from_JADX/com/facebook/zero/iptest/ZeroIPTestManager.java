package com.facebook.zero.iptest;

import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.ratelimiter.RateLimiter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.telephony.FbTelephonyManager;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQL.FetchZeroIPTestString;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLModels.ZeroIPTestSubmitMutationModel;
import com.facebook.zero.iptest.network.ZeroIPTestFetch;
import com.facebook.zero.iptest.network.ZeroIPTestReport;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: events_order_ride */
public class ZeroIPTestManager {
    private static volatile ZeroIPTestManager f13068g;
    public final FbNetworkManager f13069a;
    private final Lazy<ExecutorService> f13070b;
    private final ZeroIPTestFetch f13071c;
    private final ZeroIPTestReport f13072d;
    private final ZeroIPTestPlanRunner f13073e;
    public final RateLimiter f13074f;

    /* compiled from: events_order_ride */
    class C18231 implements FutureCallback<GraphQLResult<ZeroIPTestSubmitMutationModel>> {
        final /* synthetic */ ZeroIPTestManager f13067a;

        C18231(ZeroIPTestManager zeroIPTestManager) {
            this.f13067a = zeroIPTestManager;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            BLog.b(ZeroIPTestManager.class, "Error reporting results", th);
        }
    }

    public static com.facebook.zero.iptest.ZeroIPTestManager m13137a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13068g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.iptest.ZeroIPTestManager.class;
        monitor-enter(r1);
        r0 = f13068g;	 Catch:{ all -> 0x003a }
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
        r0 = m13138b(r0);	 Catch:{ all -> 0x0035 }
        f13068g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13068g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.iptest.ZeroIPTestManager.a(com.facebook.inject.InjectorLike):com.facebook.zero.iptest.ZeroIPTestManager");
    }

    private static ZeroIPTestManager m13138b(InjectorLike injectorLike) {
        return new ZeroIPTestManager(FbNetworkManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3832), new ZeroIPTestFetch(GraphQLQueryExecutor.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3832)), new ZeroIPTestReport(GraphQLQueryExecutor.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3832), FbTelephonyManager.b(injectorLike)), new ZeroIPTestPlanRunner(IdBasedSingletonScopeProvider.b(injectorLike, 3832)), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ZeroIPTestManager(FbNetworkManager fbNetworkManager, Lazy<ExecutorService> lazy, ZeroIPTestFetch zeroIPTestFetch, ZeroIPTestReport zeroIPTestReport, ZeroIPTestPlanRunner zeroIPTestPlanRunner, Clock clock) {
        this.f13069a = fbNetworkManager;
        this.f13070b = lazy;
        this.f13071c = zeroIPTestFetch;
        this.f13072d = zeroIPTestReport;
        this.f13073e = zeroIPTestPlanRunner;
        this.f13074f = new RateLimiter(clock, 1, 3600000);
    }

    public final void m13139b() {
        if (this.f13069a.d()) {
            ZeroIPTestFetch zeroIPTestFetch = this.f13071c;
            GraphQlQueryString fetchZeroIPTestString = new FetchZeroIPTestString();
            fetchZeroIPTestString.a("num_tests", Integer.valueOf(5));
            ListenableFuture a = Futures.a(zeroIPTestFetch.f13093a.a(GraphQLRequest.a(fetchZeroIPTestString).a(GraphQLCachePolicy.c)), zeroIPTestFetch.f13095c, (Executor) zeroIPTestFetch.f13094b.get());
            ZeroIPTestPlanRunner zeroIPTestPlanRunner = this.f13073e;
            a = Futures.a(a, zeroIPTestPlanRunner.f13079b, (Executor) zeroIPTestPlanRunner.f13078a.get());
            ZeroIPTestReport zeroIPTestReport = this.f13072d;
            Futures.a(Futures.b(a, zeroIPTestReport.f13100d, (Executor) zeroIPTestReport.f13098b.get()), new C18231(this), (Executor) this.f13070b.get());
        }
    }
}
