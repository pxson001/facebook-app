package com.facebook.tablet.sideshow.pyml.graphql;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowModels.FetchPagesYouMayLikeSideshowModel;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: onAttachmentEvent */
public class FetchPagesYouMayLikeSideshowDataRequest {
    private static volatile FetchPagesYouMayLikeSideshowDataRequest f4819c;
    public final GraphQLQueryExecutor f4820a;
    public final ListeningExecutorService f4821b;

    /* compiled from: onAttachmentEvent */
    public class C06531 implements FutureCallback<GraphQLResult<FetchPagesYouMayLikeSideshowModel>> {
        final /* synthetic */ FutureCallback f4817a;
        final /* synthetic */ FetchPagesYouMayLikeSideshowDataRequest f4818b;

        public C06531(FetchPagesYouMayLikeSideshowDataRequest fetchPagesYouMayLikeSideshowDataRequest, FutureCallback futureCallback) {
            this.f4818b = fetchPagesYouMayLikeSideshowDataRequest;
            this.f4817a = futureCallback;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f4817a != null) {
                this.f4817a.onSuccess(graphQLResult);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f4817a != null) {
                this.f4817a.onFailure(th);
            }
        }
    }

    public static com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowDataRequest m5997a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4819c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowDataRequest.class;
        monitor-enter(r1);
        r0 = f4819c;	 Catch:{ all -> 0x003a }
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
        r0 = m5998b(r0);	 Catch:{ all -> 0x0035 }
        f4819c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4819c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowDataRequest.a(com.facebook.inject.InjectorLike):com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowDataRequest");
    }

    private static FetchPagesYouMayLikeSideshowDataRequest m5998b(InjectorLike injectorLike) {
        return new FetchPagesYouMayLikeSideshowDataRequest(GraphQLQueryExecutor.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FetchPagesYouMayLikeSideshowDataRequest(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f4820a = graphQLQueryExecutor;
        this.f4821b = listeningExecutorService;
    }
}
