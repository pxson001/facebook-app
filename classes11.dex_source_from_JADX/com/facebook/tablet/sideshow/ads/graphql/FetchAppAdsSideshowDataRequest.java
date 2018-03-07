package com.facebook.tablet.sideshow.ads.graphql;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: onTextInputCapture */
public class FetchAppAdsSideshowDataRequest {
    private static volatile FetchAppAdsSideshowDataRequest f4640c;
    public final GraphQLQueryExecutor f4641a;
    public final ListeningExecutorService f4642b;

    /* compiled from: onTextInputCapture */
    public class C06331 implements FutureCallback<GraphQLResult<GraphQLViewer>> {
        final /* synthetic */ FutureCallback f4638a;
        final /* synthetic */ FetchAppAdsSideshowDataRequest f4639b;

        public C06331(FetchAppAdsSideshowDataRequest fetchAppAdsSideshowDataRequest, FutureCallback futureCallback) {
            this.f4639b = fetchAppAdsSideshowDataRequest;
            this.f4638a = futureCallback;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f4638a != null) {
                this.f4638a.onSuccess(graphQLResult);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f4638a != null) {
                this.f4638a.onFailure(th);
            }
        }
    }

    public static com.facebook.tablet.sideshow.ads.graphql.FetchAppAdsSideshowDataRequest m5853a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4640c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tablet.sideshow.ads.graphql.FetchAppAdsSideshowDataRequest.class;
        monitor-enter(r1);
        r0 = f4640c;	 Catch:{ all -> 0x003a }
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
        r0 = m5854b(r0);	 Catch:{ all -> 0x0035 }
        f4640c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4640c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tablet.sideshow.ads.graphql.FetchAppAdsSideshowDataRequest.a(com.facebook.inject.InjectorLike):com.facebook.tablet.sideshow.ads.graphql.FetchAppAdsSideshowDataRequest");
    }

    private static FetchAppAdsSideshowDataRequest m5854b(InjectorLike injectorLike) {
        return new FetchAppAdsSideshowDataRequest(GraphQLQueryExecutor.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FetchAppAdsSideshowDataRequest(GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService) {
        this.f4641a = graphQLQueryExecutor;
        this.f4642b = listeningExecutorService;
    }
}
