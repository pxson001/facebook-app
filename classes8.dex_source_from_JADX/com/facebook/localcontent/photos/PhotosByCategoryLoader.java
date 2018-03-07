package com.facebook.localcontent.photos;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.localcontent.protocol.graphql.FetchPhotosByCategoryGraphQLModels.AvailableCategoriesQueryModel;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: does not have an actor id in group */
public class PhotosByCategoryLoader {
    private static volatile PhotosByCategoryLoader f15194c;
    public final GraphQLQueryExecutor f15195a;
    public final TasksManager f15196b;

    /* compiled from: does not have an actor id in group */
    public class C16581 extends AbstractDisposableFutureCallback<GraphQLResult<AvailableCategoriesQueryModel>> {
        final /* synthetic */ PhotosByCategoryTabPagerFragment f15192a;
        final /* synthetic */ PhotosByCategoryLoader f15193b;

        public C16581(PhotosByCategoryLoader photosByCategoryLoader, PhotosByCategoryTabPagerFragment photosByCategoryTabPagerFragment) {
            this.f15193b = photosByCategoryLoader;
            this.f15192a = photosByCategoryTabPagerFragment;
        }

        protected final void m17643a(Object obj) {
            AvailableCategoriesQueryModel availableCategoriesQueryModel;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            PhotosByCategoryTabPagerFragment photosByCategoryTabPagerFragment = this.f15192a;
            if (graphQLResult == null) {
                availableCategoriesQueryModel = null;
            } else {
                availableCategoriesQueryModel = (AvailableCategoriesQueryModel) graphQLResult.e;
            }
            photosByCategoryTabPagerFragment.m17657a(availableCategoriesQueryModel);
        }

        protected final void m17644a(Throwable th) {
            this.f15192a.m17655a();
        }
    }

    public static com.facebook.localcontent.photos.PhotosByCategoryLoader m17645a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15194c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.localcontent.photos.PhotosByCategoryLoader.class;
        monitor-enter(r1);
        r0 = f15194c;	 Catch:{ all -> 0x003a }
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
        r0 = m17646b(r0);	 Catch:{ all -> 0x0035 }
        f15194c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15194c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.localcontent.photos.PhotosByCategoryLoader.a(com.facebook.inject.InjectorLike):com.facebook.localcontent.photos.PhotosByCategoryLoader");
    }

    private static PhotosByCategoryLoader m17646b(InjectorLike injectorLike) {
        return new PhotosByCategoryLoader(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public PhotosByCategoryLoader(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f15195a = graphQLQueryExecutor;
        this.f15196b = tasksManager;
    }
}
