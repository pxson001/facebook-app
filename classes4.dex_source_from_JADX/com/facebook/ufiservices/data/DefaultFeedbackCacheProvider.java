package com.facebook.ufiservices.data;

import com.facebook.api.ufiservices.FetchFeedbackMethod;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FetchFeedbackParams;
import com.facebook.api.ufiservices.common.FetchFeedbackParams.FetchType;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.executor.GraphQLQueryExecutor.CacheProcessor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.GraphQLDiskCache;
import com.facebook.graphql.executor.cache.GraphQLDiskCacheImpl;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: platformParams */
public class DefaultFeedbackCacheProvider {
    private static volatile DefaultFeedbackCacheProvider f4609c;
    private final FetchFeedbackMethod f4610a;
    private final GraphQLDiskCache f4611b;

    public static com.facebook.ufiservices.data.DefaultFeedbackCacheProvider m5091a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4609c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ufiservices.data.DefaultFeedbackCacheProvider.class;
        monitor-enter(r1);
        r0 = f4609c;	 Catch:{ all -> 0x003a }
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
        r0 = m5092b(r0);	 Catch:{ all -> 0x0035 }
        f4609c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4609c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.data.DefaultFeedbackCacheProvider.a(com.facebook.inject.InjectorLike):com.facebook.ufiservices.data.DefaultFeedbackCacheProvider");
    }

    private static DefaultFeedbackCacheProvider m5092b(InjectorLike injectorLike) {
        return new DefaultFeedbackCacheProvider(FetchFeedbackMethod.b(injectorLike), (GraphQLDiskCache) GraphQLDiskCacheImpl.a(injectorLike));
    }

    @Inject
    public DefaultFeedbackCacheProvider(FetchFeedbackMethod fetchFeedbackMethod, GraphQLDiskCache graphQLDiskCache) {
        this.f4610a = fetchFeedbackMethod;
        this.f4611b = graphQLDiskCache;
    }

    public final CacheProcessor<GraphQLFeedback> m5094a(String str) {
        return this.f4610a.a(this.f4610a.a(m5093c(str)));
    }

    public final GraphQLFeedback m5095b(String str) {
        try {
            GraphQLResult b = this.f4611b.b(this.f4610a.a(m5093c(str)).a(false));
            if (b == null) {
                return null;
            }
            return (GraphQLFeedback) b.d();
        } catch (Throwable e) {
            BLog.b(getClass(), "Error while getting cached feedback", e);
            return null;
        }
    }

    private static FetchFeedbackParams m5093c(String str) {
        return new FetchFeedbackParams(str, 25, FetchType.COMPLETE, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, CommentOrderType.DEFAULT_ORDER, null, true, false, false);
    }
}
