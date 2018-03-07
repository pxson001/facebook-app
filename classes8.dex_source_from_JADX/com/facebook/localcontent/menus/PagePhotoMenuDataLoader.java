package com.facebook.localcontent.menus;

import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLInterfaces.PhotoMenusData.PagePhotoMenus.Nodes.PagePhotoMenuPhotos;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLModels.PhotoMenusDataModel;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLModels.PhotoMenusDataModel.PagePhotoMenusModel.NodesModel;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLModels.PhotoMenusDataModel.PagePhotoMenusModel.NodesModel.PagePhotoMenuPhotosModel;
import com.facebook.localcontent.protocol.graphql.FetchPhotoMenusGraphQLModels.PhotoMenusDataModel.PagePhotoMenusModel.NodesModel.PagePhotoMenuPhotosModel.EdgesModel;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ec_final_data_available */
public class PagePhotoMenuDataLoader {
    private static volatile PagePhotoMenuDataLoader f14995d;
    public final ListeningExecutorService f14996a;
    public final GraphQLQueryExecutor f14997b;
    public final TasksManager<String> f14998c;

    /* compiled from: ec_final_data_available */
    public class C16231 extends AbstractDisposableFutureCallback<PagePhotoMenuPhotos> {
        final /* synthetic */ PagePhotoMenuFragment f14992a;
        final /* synthetic */ PagePhotoMenuDataLoader f14993b;

        public C16231(PagePhotoMenuDataLoader pagePhotoMenuDataLoader, PagePhotoMenuFragment pagePhotoMenuFragment) {
            this.f14993b = pagePhotoMenuDataLoader;
            this.f14992a = pagePhotoMenuFragment;
        }

        protected final void m17438a(Object obj) {
            PagePhotoMenuPhotosModel pagePhotoMenuPhotosModel = (PagePhotoMenuPhotosModel) obj;
            PagePhotoMenuFragment pagePhotoMenuFragment = this.f14992a;
            pagePhotoMenuFragment.f15007h.a(false);
            pagePhotoMenuFragment.f15007h.setMessage(pagePhotoMenuFragment.b(2131239097));
            if (pagePhotoMenuPhotosModel != null) {
                PagePhotoMenuAdapter pagePhotoMenuAdapter = pagePhotoMenuFragment.al;
                for (EdgesModel edgesModel : pagePhotoMenuPhotosModel.a()) {
                    if (edgesModel.a() != null) {
                        pagePhotoMenuAdapter.f14991d.add(edgesModel);
                    }
                }
                AdapterDetour.a(pagePhotoMenuAdapter, -1172259101);
            }
        }

        protected final void m17439a(Throwable th) {
            PagePhotoMenuFragment pagePhotoMenuFragment = this.f14992a;
            pagePhotoMenuFragment.f15007h.a(false);
            pagePhotoMenuFragment.f15007h.setMessage(pagePhotoMenuFragment.b(2131239095));
        }
    }

    /* compiled from: ec_final_data_available */
    public class C16242 implements Function<GraphQLResult<PhotoMenusDataModel>, PagePhotoMenuPhotos> {
        final /* synthetic */ PagePhotoMenuDataLoader f14994a;

        public C16242(PagePhotoMenuDataLoader pagePhotoMenuDataLoader) {
            this.f14994a = pagePhotoMenuDataLoader;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((PhotoMenusDataModel) graphQLResult.e).a() == null || ((PhotoMenusDataModel) graphQLResult.e).a().a().isEmpty()) {
                return null;
            }
            return ((NodesModel) ((PhotoMenusDataModel) graphQLResult.e).a().a().get(0)).a();
        }
    }

    public static com.facebook.localcontent.menus.PagePhotoMenuDataLoader m17440a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14995d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.localcontent.menus.PagePhotoMenuDataLoader.class;
        monitor-enter(r1);
        r0 = f14995d;	 Catch:{ all -> 0x003a }
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
        r0 = m17441b(r0);	 Catch:{ all -> 0x0035 }
        f14995d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14995d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.localcontent.menus.PagePhotoMenuDataLoader.a(com.facebook.inject.InjectorLike):com.facebook.localcontent.menus.PagePhotoMenuDataLoader");
    }

    private static PagePhotoMenuDataLoader m17441b(InjectorLike injectorLike) {
        return new PagePhotoMenuDataLoader(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public PagePhotoMenuDataLoader(ListeningExecutorService listeningExecutorService, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f14996a = listeningExecutorService;
        this.f14997b = graphQLQueryExecutor;
        this.f14998c = tasksManager;
    }
}
