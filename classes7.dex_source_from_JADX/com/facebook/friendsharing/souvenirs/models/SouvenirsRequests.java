package com.facebook.friendsharing.souvenirs.models;

import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: RESULT */
public class SouvenirsRequests {
    private static volatile SouvenirsRequests f24081d;
    public final Lazy<GraphQLQueryExecutor> f24082a;
    public final Lazy<SizeAwareImageUtil> f24083b;
    public final Lazy<SouvenirsFormattedStringHelper> f24084c;

    /* compiled from: RESULT */
    public class TransformFunction implements AsyncFunction<GraphQLResult<SouvenirsDetailsFieldsModel>, SouvenirsFetchResult> {
        final /* synthetic */ SouvenirsRequests f24080a;

        public TransformFunction(SouvenirsRequests souvenirsRequests) {
            this.f24080a = souvenirsRequests;
        }

        public final ListenableFuture m26210a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                return null;
            }
            SouvenirsDetailsFieldsModel souvenirsDetailsFieldsModel = (SouvenirsDetailsFieldsModel) graphQLResult.e;
            return Futures.a(new SouvenirsFetchResult(souvenirsDetailsFieldsModel, ((SouvenirsFormattedStringHelper) this.f24080a.f24084c.get()).m26209a(souvenirsDetailsFieldsModel.m26307k())));
        }
    }

    public static com.facebook.friendsharing.souvenirs.models.SouvenirsRequests m26211a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24081d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsharing.souvenirs.models.SouvenirsRequests.class;
        monitor-enter(r1);
        r0 = f24081d;	 Catch:{ all -> 0x003a }
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
        r0 = m26212b(r0);	 Catch:{ all -> 0x0035 }
        f24081d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24081d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.models.SouvenirsRequests.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.models.SouvenirsRequests");
    }

    private static SouvenirsRequests m26212b(InjectorLike injectorLike) {
        return new SouvenirsRequests(IdBasedLazy.a(injectorLike, 2164), IdBasedSingletonScopeProvider.b(injectorLike, 2969), IdBasedSingletonScopeProvider.b(injectorLike, 6718));
    }

    @Inject
    public SouvenirsRequests(Lazy<GraphQLQueryExecutor> lazy, Lazy<SizeAwareImageUtil> lazy2, Lazy<SouvenirsFormattedStringHelper> lazy3) {
        this.f24082a = lazy;
        this.f24083b = lazy2;
        this.f24084c = lazy3;
    }
}
