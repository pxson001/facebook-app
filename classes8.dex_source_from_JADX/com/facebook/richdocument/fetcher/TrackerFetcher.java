package com.facebook.richdocument.fetcher;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQl.RichDocumentTrackerBlockQueryString;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTrackerModel;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: preloadedItemId */
public class TrackerFetcher {
    private static volatile TrackerFetcher f5228c;
    private final GraphQLQueryExecutor f5229a;
    private final Executor f5230b;

    public static com.facebook.richdocument.fetcher.TrackerFetcher m5168a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5228c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.richdocument.fetcher.TrackerFetcher.class;
        monitor-enter(r1);
        r0 = f5228c;	 Catch:{ all -> 0x003a }
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
        r0 = m5169b(r0);	 Catch:{ all -> 0x0035 }
        f5228c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5228c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.fetcher.TrackerFetcher.a(com.facebook.inject.InjectorLike):com.facebook.richdocument.fetcher.TrackerFetcher");
    }

    private static TrackerFetcher m5169b(InjectorLike injectorLike) {
        return new TrackerFetcher(GraphQLQueryExecutor.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TrackerFetcher(GraphQLQueryExecutor graphQLQueryExecutor, Executor executor) {
        this.f5229a = graphQLQueryExecutor;
        this.f5230b = executor;
    }

    public final void m5170a(String str, String str2, DisposableFutureCallback<GraphQLResult<RichDocumentTrackerModel>> disposableFutureCallback) {
        GraphQLRequest a = GraphQLRequest.a((RichDocumentTrackerBlockQueryString) new RichDocumentTrackerBlockQueryString().a("ia_tracker_node_id", str).a("ia_webview_share_url", str2)).a(604800000);
        a.b = true;
        Futures.a(this.f5229a.a(a.a(RequestPriority.INTERACTIVE).a(GraphQLCachePolicy.a)), disposableFutureCallback, this.f5230b);
    }
}
