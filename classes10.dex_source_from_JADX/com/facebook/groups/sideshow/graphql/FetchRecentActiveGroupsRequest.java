package com.facebook.groups.sideshow.graphql;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsDataQLModels.FetchRecentActiveGroupsQueryModel;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: website_promotion */
public class FetchRecentActiveGroupsRequest {
    private static volatile FetchRecentActiveGroupsRequest f336d;
    public final GraphQLQueryExecutor f337a;
    public final ListeningExecutorService f338b;
    public final String f339c;

    /* compiled from: website_promotion */
    public class C00591 implements FutureCallback<GraphQLResult<FetchRecentActiveGroupsQueryModel>> {
        final /* synthetic */ FutureCallback f334a;
        final /* synthetic */ FetchRecentActiveGroupsRequest f335b;

        public C00591(FetchRecentActiveGroupsRequest fetchRecentActiveGroupsRequest, FutureCallback futureCallback) {
            this.f335b = fetchRecentActiveGroupsRequest;
            this.f334a = futureCallback;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f334a != null) {
                this.f334a.onSuccess(graphQLResult);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f334a != null) {
                this.f334a.onFailure(th);
            }
        }
    }

    public static com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsRequest m473a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f336d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsRequest.class;
        monitor-enter(r1);
        r0 = f336d;	 Catch:{ all -> 0x003a }
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
        r0 = m474b(r0);	 Catch:{ all -> 0x0035 }
        f336d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f336d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsRequest.a(com.facebook.inject.InjectorLike):com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsRequest");
    }

    private static FetchRecentActiveGroupsRequest m474b(InjectorLike injectorLike) {
        return new FetchRecentActiveGroupsRequest(GraphQLQueryExecutor.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    @Inject
    public FetchRecentActiveGroupsRequest(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService, Provider<String> provider) {
        this.f337a = graphQLQueryExecutor;
        this.f338b = listeningExecutorService;
        this.f339c = (String) provider.get();
    }
}
