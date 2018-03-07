package com.facebook.localcontent.menus;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.calls.CategoryInputCategoryName;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQL.PhotosQueryString;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLModels.PhotosQueryModel;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLModels.PhotosQueryModel.PhotosByCategoryModel.NodesModel;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ec_initial_card_context_rows_configured */
public class FoodPhotosHScrollLoader {
    private static volatile FoodPhotosHScrollLoader f14978e;
    private final GraphQLImageHelper f14979a;
    private final GraphQLQueryExecutor f14980b;
    private final Resources f14981c;
    private final TasksManager<String> f14982d;

    public static com.facebook.localcontent.menus.FoodPhotosHScrollLoader m17432a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14978e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.localcontent.menus.FoodPhotosHScrollLoader.class;
        monitor-enter(r1);
        r0 = f14978e;	 Catch:{ all -> 0x003a }
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
        r0 = m17433b(r0);	 Catch:{ all -> 0x0035 }
        f14978e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14978e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.localcontent.menus.FoodPhotosHScrollLoader.a(com.facebook.inject.InjectorLike):com.facebook.localcontent.menus.FoodPhotosHScrollLoader");
    }

    private static FoodPhotosHScrollLoader m17433b(InjectorLike injectorLike) {
        return new FoodPhotosHScrollLoader(GraphQLImageHelper.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public FoodPhotosHScrollLoader(GraphQLImageHelper graphQLImageHelper, GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, TasksManager tasksManager) {
        this.f14979a = graphQLImageHelper;
        this.f14980b = graphQLQueryExecutor;
        this.f14981c = resources;
        this.f14982d = tasksManager;
    }

    public final void m17434a(String str, String str2, final FoodPhotosHScrollController foodPhotosHScrollController) {
        GraphQlQueryString photosQueryString = new PhotosQueryString();
        photosQueryString.a("page_id", str);
        photosQueryString.a("afterCursor", str2);
        photosQueryString.a("category", CategoryInputCategoryName.FOOD);
        photosQueryString.a("image_size", GraphQLImageHelper.a(this.f14981c.getDimensionPixelSize(2131431423)));
        photosQueryString.a("count", Integer.valueOf(5));
        this.f14982d.a("task_key_load_photos" + str, this.f14980b.a(GraphQLRequest.a(photosQueryString)), new AbstractDisposableFutureCallback<GraphQLResult<PhotosQueryModel>>(this) {
            final /* synthetic */ FoodPhotosHScrollLoader f14977b;

            protected final void m17430a(Object obj) {
                PhotosQueryModel photosQueryModel;
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                FoodPhotosHScrollController foodPhotosHScrollController = foodPhotosHScrollController;
                if (graphQLResult == null) {
                    photosQueryModel = null;
                } else {
                    photosQueryModel = (PhotosQueryModel) graphQLResult.e;
                }
                foodPhotosHScrollController.f14973i = false;
                if (photosQueryModel != null && photosQueryModel.a() != null && !photosQueryModel.a().a().isEmpty()) {
                    FoodPhotosHScrollAdapter foodPhotosHScrollAdapter = foodPhotosHScrollController.f14970f;
                    ImmutableList a = photosQueryModel.a().a();
                    int size = foodPhotosHScrollAdapter.f14962f.size();
                    int size2 = a.size();
                    for (int i = 0; i < size2; i++) {
                        NodesModel nodesModel = (NodesModel) a.get(i);
                        if (!(nodesModel.c() == null || Strings.isNullOrEmpty(nodesModel.c().b()))) {
                            foodPhotosHScrollAdapter.f14962f.add(nodesModel);
                        }
                    }
                    foodPhotosHScrollAdapter.c(size, foodPhotosHScrollAdapter.f14962f.size() - size);
                    foodPhotosHScrollController.f14975k.setVisibility(0);
                    foodPhotosHScrollController.f14972h = photosQueryModel.a().b() != null ? photosQueryModel.a().b().a() : null;
                }
            }

            protected final void m17431a(Throwable th) {
                foodPhotosHScrollController.f14973i = false;
            }
        });
    }
}
