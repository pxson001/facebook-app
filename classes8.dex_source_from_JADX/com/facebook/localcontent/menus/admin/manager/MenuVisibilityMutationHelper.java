package com.facebook.localcontent.menus.admin.manager;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PageMenuVisibilityEditInputData;
import com.facebook.graphql.calls.PageMenuVisibilityEditInputData.MenuType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.localcontent.protocol.graphql.PageMenuVisibilityMutation.PageMenuVisibilityMutationString;
import com.facebook.localcontent.protocol.graphql.PageMenuVisibilityMutationModels.PageMenuVisibilityMutationModel;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ec_card_scroll_wait_time */
public class MenuVisibilityMutationHelper {
    private static volatile MenuVisibilityMutationHelper f15070d;
    public final GraphQLQueryExecutor f15071a;
    public final TasksManager f15072b;
    public final Toaster f15073c;

    public static com.facebook.localcontent.menus.admin.manager.MenuVisibilityMutationHelper m17496a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15070d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.localcontent.menus.admin.manager.MenuVisibilityMutationHelper.class;
        monitor-enter(r1);
        r0 = f15070d;	 Catch:{ all -> 0x003a }
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
        r0 = m17497b(r0);	 Catch:{ all -> 0x0035 }
        f15070d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15070d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.localcontent.menus.admin.manager.MenuVisibilityMutationHelper.a(com.facebook.inject.InjectorLike):com.facebook.localcontent.menus.admin.manager.MenuVisibilityMutationHelper");
    }

    private static MenuVisibilityMutationHelper m17497b(InjectorLike injectorLike) {
        return new MenuVisibilityMutationHelper(GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    public MenuVisibilityMutationHelper(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, Toaster toaster) {
        this.f15071a = graphQLQueryExecutor;
        this.f15072b = tasksManager;
        this.f15073c = toaster;
    }

    public final void m17498a(final PageMenuManagementFragment pageMenuManagementFragment, String str, MenuType menuType) {
        final ProgressDialog a = ProgressDialog.a(pageMenuManagementFragment.getContext(), null, pageMenuManagementFragment.jW_().getString(2131239131), true, false);
        final C16431 c16431 = new Object(this) {
            public final /* synthetic */ MenuVisibilityMutationHelper f15067c;
        };
        PageMenuVisibilityEditInputData pageMenuVisibilityEditInputData = new PageMenuVisibilityEditInputData();
        pageMenuVisibilityEditInputData.a("page_id", str);
        GraphQlCallInput graphQlCallInput = pageMenuVisibilityEditInputData;
        graphQlCallInput.a("menu_type", menuType);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString pageMenuVisibilityMutationString = new PageMenuVisibilityMutationString();
        pageMenuVisibilityMutationString.a("input", graphQlCallInput);
        this.f15072b.a("task_key_mutate_menu_visibility" + str, this.f15071a.a(GraphQLRequest.a(pageMenuVisibilityMutationString), OfflineQueryBehavior.c), new AbstractDisposableFutureCallback<GraphQLResult<PageMenuVisibilityMutationModel>>(this) {
            final /* synthetic */ MenuVisibilityMutationHelper f15069b;

            protected final void m17494a(Object obj) {
                C16431 c16431 = c16431;
                c16431.f15065a.dismiss();
                c16431.f15066b.m17533e();
            }

            protected final void m17495a(Throwable th) {
                C16431 c16431 = c16431;
                c16431.f15065a.dismiss();
                c16431.f15067c.f15073c.a(new ToastBuilder(2131239132));
            }
        });
    }
}
