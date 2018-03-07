package com.facebook.localcontent.menus.admin.manager;

import android.os.Parcelable;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Lazy;
import com.facebook.localcontent.analytics.LocalContentMenuLogger;
import com.facebook.localcontent.protocol.graphql.MenuManagementQuery.MenuManagementInfoString;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.inject.Inject;

/* compiled from: ec91c4ab6fe2994b14f9915984816e03 */
public class PageMenuManagementLoader {
    private final GraphQLQueryExecutor f15103a;
    public final TasksManager<String> f15104b;
    private final Lazy<ViewerContextUtil> f15105c;

    @Inject
    public PageMenuManagementLoader(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, Lazy<ViewerContextUtil> lazy) {
        this.f15103a = graphQLQueryExecutor;
        this.f15104b = tasksManager;
        this.f15105c = lazy;
    }

    private void m17536a(String str, final PageMenuManagementFragment pageMenuManagementFragment, final boolean z) {
        GraphQlQueryString menuManagementInfoString = new MenuManagementInfoString();
        menuManagementInfoString.a("page_id", str);
        GraphQLQueryFuture a = this.f15103a.a(GraphQLRequest.a(menuManagementInfoString));
        ListenableFuture a2 = z ? ((ViewerContextUtil) this.f15105c.get()).m20220a(str) : Futures.a(null);
        this.f15104b.a("task_key_load_menu_info" + str, Futures.a(new ListenableFuture[]{a, a2}), new AbstractDisposableFutureCallback<List<Parcelable>>(this) {
            final /* synthetic */ PageMenuManagementLoader f15102c;

            protected final void m17534a(Object obj) {
                MenuManagementInfoFieldsModel menuManagementInfoFieldsModel;
                List list = (List) obj;
                GraphQLResult graphQLResult = list.size() > 0 ? (GraphQLResult) list.get(0) : null;
                if (graphQLResult == null) {
                    menuManagementInfoFieldsModel = null;
                } else {
                    menuManagementInfoFieldsModel = (MenuManagementInfoFieldsModel) graphQLResult.e;
                }
                if (z) {
                    ViewerContext viewerContext = list.size() > 1 ? (ViewerContext) list.get(1) : null;
                    PageMenuManagementFragment pageMenuManagementFragment = pageMenuManagementFragment;
                    pageMenuManagementFragment.al = viewerContext;
                    pageMenuManagementFragment.m17531a(menuManagementInfoFieldsModel);
                    return;
                }
                pageMenuManagementFragment.m17531a(menuManagementInfoFieldsModel);
            }

            protected final void m17535a(Throwable th) {
                PageMenuManagementFragment pageMenuManagementFragment = pageMenuManagementFragment;
                pageMenuManagementFragment.f15093c.f14941a.a(LocalContentMenuLogger.m17408b("page_menu_management", "menu_management_load_failed", pageMenuManagementFragment.f15099i));
                pageMenuManagementFragment.am.dismiss();
                ((Toaster) pageMenuManagementFragment.f15096f.get()).a(new ToastBuilder(2131230758));
                pageMenuManagementFragment.ao().finish();
            }
        });
    }

    public final void m17537a(String str, PageMenuManagementFragment pageMenuManagementFragment) {
        m17536a(str, pageMenuManagementFragment, false);
    }

    public final void m17538b(String str, PageMenuManagementFragment pageMenuManagementFragment) {
        m17536a(str, pageMenuManagementFragment, true);
    }
}
