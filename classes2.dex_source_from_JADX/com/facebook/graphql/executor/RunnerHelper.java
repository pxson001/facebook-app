package com.facebook.graphql.executor;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock;
import com.facebook.graphql.executor.GraphQLResult.Builder;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: messenger_chat_heads_android */
public class RunnerHelper {
    private static final Class<?> f14138a = RunnerHelper.class;

    protected static final <T> com.facebook.graphql.executor.GraphQLResult<T> m20472a(com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent r8, com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor<T> r9, com.facebook.quicklog.QuickPerformanceLogger r10, int r11, int r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r6 = 0;
        r7 = 23;
        r0 = "RunnerHelper.fetchFromDBCache";
        r1 = 89683114; // 0x55874aa float:1.0177699E-35 double:4.43093456E-316;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = r9.mo2682a(r8);	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        r1 = "local_db_read";	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        r2 = r8;	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        r3 = r10;	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        r4 = r11;	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        r5 = r12;	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        m20478a(r0, r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        if (r0 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x003a, all -> 0x004f }
    L_0x001a:
        r1 = com.facebook.graphql.executor.GraphQLQueryExecutor.f6237a;	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        if (r0 != r1) goto L_0x0029;
    L_0x001e:
        r0 = -180546060; // 0xfffffffff53d15f4 float:-2.3969467E32 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r10.mo445a(r11, r12, r7);
        r0 = r6;
    L_0x0028:
        return r0;
    L_0x0029:
        r2 = r0.m10405b();	 Catch:{  }
        r8.mo1461a(r2);	 Catch:{  }
        r1 = -601190050; // 0xffffffffdc2a915e float:-1.92042316E17 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        r10.mo445a(r11, r12, r7);
        goto L_0x0028;
    L_0x003a:
        r1 = move-exception;
        r0 = "local_db_read";	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        r2 = r8;	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        r3 = r10;	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        r4 = r11;	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        r5 = r12;	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        m20480a(r0, r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x003a, all -> 0x004f }
        r0 = 1168122213; // 0x45a02165 float:5124.1743 double:5.771290556E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r10.mo445a(r11, r12, r7);
        r0 = r6;
        goto L_0x0028;
    L_0x004f:
        r0 = move-exception;
        r1 = 999785212; // 0x3b9782fc float:0.004623769 double:4.939595265E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        r10.mo445a(r11, r12, r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.RunnerHelper.a(com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent, com.facebook.graphql.executor.GraphQLQueryExecutor$CacheProcessor, com.facebook.quicklog.QuickPerformanceLogger, int, int):com.facebook.graphql.executor.GraphQLResult<T>");
    }

    protected static final <T> GraphQLResult<T> m20471a(GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, GenericGraphQLMethod genericGraphQLMethod, GraphQLRequest<T> graphQLRequest, SingleMethodRunner singleMethodRunner, QuickPerformanceLogger quickPerformanceLogger, int i, int i2) {
        TracerDetour.a("RunnerHelper.fetchFromNetwork", -1635819020);
        try {
            GraphQLResult<T> graphQLResult = (GraphQLResult) singleMethodRunner.m11746a(genericGraphQLMethod, graphQLRequest, null, GraphQLRequest.m11584a(graphQLRequest.f7088f, graphQLRequest.m11614n()));
            m20479a("network", graphQLQueryAnalyticsEvent, quickPerformanceLogger, i, i2);
            if (graphQLResult == GraphQLQueryExecutor.f6237a) {
                graphQLResult = null;
            }
            TracerDetour.a(-1213619261);
            quickPerformanceLogger.mo445a(i, i2, (short) 16);
            return graphQLResult;
        } catch (Exception e) {
            m20480a("network", e, graphQLQueryAnalyticsEvent, quickPerformanceLogger, i, i2);
            throw e;
        } catch (Throwable th) {
            TracerDetour.a(-1330629215);
            quickPerformanceLogger.mo445a(i, i2, (short) 16);
        }
    }

    protected static <T> void m20473a(GraphQLRequestLock graphQLRequestLock, GraphQLResult<T> graphQLResult, GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, SettableFuture<GraphQLResult<T>> settableFuture, QuickPerformanceLogger quickPerformanceLogger, int i, int i2) {
        TracerDetour.a("RunnerHelper.mutateResult", -332384797);
        try {
            GraphQLResult b = graphQLRequestLock.m20453b(Builder.m21595a((GraphQLResult) graphQLResult).m21597a(graphQLRequestLock).m21600a(), quickPerformanceLogger, i, i2);
            quickPerformanceLogger.mo445a(i, i2, (short) 20);
            graphQLQueryAnalyticsEvent.mo1470b("return_to_caller");
            FutureDetour.a(settableFuture, b, 1123214992);
            quickPerformanceLogger.mo445a(i, i2, (short) 155);
        } finally {
            TracerDetour.a(-1603675779);
        }
    }

    protected static <T> void m20476a(GraphQLRequest<T> graphQLRequest, GraphQLResult graphQLResult) {
        try {
            if (graphQLRequest.f7093k != null) {
                graphQLRequest.f7093k.m26911a(graphQLResult);
            }
        } catch (Throwable e) {
            BLog.b(f14138a, "Failed to subscribe request", e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static <T> void m20475a(com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock r7, @javax.annotation.Nullable com.facebook.graphql.executor.iface.ConsistencyMemoryCache r8, com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent r9, java.util.Set<com.facebook.graphql.executor.iface.ConsistentMemoryCache> r10, com.facebook.quicklog.QuickPerformanceLogger r11, int r12, int r13) {
        /*
        r6 = 17;
        r0 = "RunnerHelper.updateMemoryFromNetwork";
        r1 = -1994042651; // 0xffffffff892552e5 float:-1.990013E-33 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r7.m20456c();	 Catch:{ Exception -> 0x002d }
        if (r8 == 0) goto L_0x0046;
    L_0x000f:
        r0 = r8.b();	 Catch:{ Exception -> 0x002d }
        if (r0 != 0) goto L_0x0046;
    L_0x0015:
        r1 = r8.d();	 Catch:{ Exception -> 0x002d }
        r2 = r10.iterator();	 Catch:{ Exception -> 0x002d }
    L_0x001d:
        r0 = r2.hasNext();	 Catch:{ Exception -> 0x002d }
        if (r0 == 0) goto L_0x0041;
    L_0x0023:
        r0 = r2.next();	 Catch:{ Exception -> 0x002d }
        r0 = (com.facebook.api.feedcache.memory.FeedUnitCache) r0;	 Catch:{ Exception -> 0x002d }
        r0.m10556a(r1);	 Catch:{ Exception -> 0x002d }
        goto L_0x001d;
    L_0x002d:
        r1 = move-exception;
        r0 = "local_memory_write";
        r2 = r9;
        r3 = r11;
        r4 = r12;
        r5 = r13;
        m20480a(r0, r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0050 }
        r0 = 821957363; // 0x30fe12f3 float:1.8486318E-9 double:4.061008954E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r11.mo445a(r12, r13, r6);
    L_0x0040:
        return;
    L_0x0041:
        r0 = "local_memory_write";
        m20479a(r0, r9, r11, r12, r13);	 Catch:{  }
    L_0x0046:
        r0 = -2081790484; // 0xffffffff83ea65ec float:-1.3776684E-36 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r11.mo445a(r12, r13, r6);
        goto L_0x0040;
    L_0x0050:
        r0 = move-exception;
        r1 = -99607148; // 0xfffffffffa101d94 float:-1.8707267E35 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        r11.mo445a(r12, r13, r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.RunnerHelper.a(com.facebook.graphql.executor.GraphQLQueryScheduler$GraphQLRequestLock, com.facebook.graphql.executor.iface.ConsistencyMemoryCache, com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent, java.util.Set, com.facebook.quicklog.QuickPerformanceLogger, int, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static <T> void m20474a(com.facebook.graphql.executor.GraphQLQueryScheduler.GraphQLRequestLock r7, com.facebook.graphql.executor.GraphQLResult r8, @javax.annotation.Nullable com.facebook.graphql.executor.iface.ConsistencyMemoryCache r9, com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent r10, com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor<T> r11, com.facebook.graphql.executor.GraphQLRequest<T> r12, com.facebook.quicklog.QuickPerformanceLogger r13, int r14, int r15) {
        /*
        r6 = 30;
        r0 = "RunnerHelper.updateDBFromNetwork";
        r1 = 32284107; // 0x1ec9dcb float:8.691913E-38 double:1.5950468E-316;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r7.m20457d();	 Catch:{ Exception -> 0x0032 }
        if (r9 == 0) goto L_0x0017;
    L_0x000f:
        r9.c();	 Catch:{ Exception -> 0x0032 }
        r0 = 19;
        r13.mo445a(r14, r15, r0);	 Catch:{ Exception -> 0x0032 }
    L_0x0017:
        r0 = r12.f7083a;	 Catch:{ Exception -> 0x0032 }
        r0 = r0.f7116h;	 Catch:{ Exception -> 0x0032 }
        if (r0 == 0) goto L_0x0028;
    L_0x001d:
        r0 = r11.mo2683a(r8);	 Catch:{ Exception -> 0x0032 }
        if (r0 == 0) goto L_0x0028;
    L_0x0023:
        r0 = "local_db_write";
        m20479a(r0, r10, r13, r14, r15);	 Catch:{ Exception -> 0x0032 }
    L_0x0028:
        r0 = 1828773994; // 0x6d00e06a float:2.4928363E27 double:9.035344044E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r13.mo445a(r14, r15, r6);
    L_0x0031:
        return;
    L_0x0032:
        r1 = move-exception;
        r0 = "local_db_write";
        r2 = r10;
        r3 = r13;
        r4 = r14;
        r5 = r15;
        m20480a(r0, r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0046 }
        r0 = 640522720; // 0x262d99e0 float:6.022997E-16 double:3.164602713E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r13.mo445a(r14, r15, r6);
        goto L_0x0031;
    L_0x0046:
        r0 = move-exception;
        r1 = -1385975532; // 0xffffffffad63b114 float:-1.2942775E-11 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        r13.mo445a(r14, r15, r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.executor.RunnerHelper.a(com.facebook.graphql.executor.GraphQLQueryScheduler$GraphQLRequestLock, com.facebook.graphql.executor.GraphQLResult, com.facebook.graphql.executor.iface.ConsistencyMemoryCache, com.facebook.graphql.executor.GraphQLQueryAnalyticsEvent, com.facebook.graphql.executor.GraphQLQueryExecutor$CacheProcessor, com.facebook.graphql.executor.GraphQLRequest, com.facebook.quicklog.QuickPerformanceLogger, int, int):void");
    }

    public static void m20477a(GraphQLResult graphQLResult, ConsistencyMemoryCache consistencyMemoryCache) {
        TracerDetour.a("RunnerHelper.writeResultToConsistencyCache", -1238748425);
        try {
            if (graphQLResult.m10400d() instanceof GraphQLVisitableModel) {
                consistencyMemoryCache.a((GraphQLVisitableModel) graphQLResult.m10400d());
            } else if (graphQLResult.m10400d() instanceof Map) {
                consistencyMemoryCache.a((Map) graphQLResult.m10400d());
            }
            TracerDetour.a(1703732863);
        } catch (Throwable th) {
            TracerDetour.a(-2081987633);
        }
    }

    private static <T> void m20478a(@Nullable GraphQLResult<T> graphQLResult, String str, GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, QuickPerformanceLogger quickPerformanceLogger, int i, int i2) {
        if (graphQLResult == GraphQLQueryExecutor.f6237a) {
            return;
        }
        if (graphQLResult == null) {
            quickPerformanceLogger.mo465b(i, i2, str, "miss");
            graphQLQueryAnalyticsEvent.mo1466a(str, "miss");
            return;
        }
        quickPerformanceLogger.mo465b(i, i2, str, "hit");
        graphQLQueryAnalyticsEvent.mo1466a(str, "hit");
    }

    static void m20479a(String str, GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, QuickPerformanceLogger quickPerformanceLogger, int i, int i2) {
        graphQLQueryAnalyticsEvent.mo1466a(str, "success");
        quickPerformanceLogger.mo465b(i, i2, str, "success");
    }

    static void m20480a(String str, Exception exception, GraphQLQueryAnalyticsEvent graphQLQueryAnalyticsEvent, QuickPerformanceLogger quickPerformanceLogger, int i, int i2) {
        graphQLQueryAnalyticsEvent.mo1467a(str, (Throwable) exception);
        quickPerformanceLogger.mo465b(i, i2, str, "error");
    }
}
