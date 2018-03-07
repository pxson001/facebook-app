package com.facebook.appinvites.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appinvites.adapter.AppInvitesBlockedListAdapter;
import com.facebook.appinvites.adapter.AppInvitesBlockedListAdapterProvider;
import com.facebook.appinvites.data.AppInvitesBlockedListData;
import com.facebook.appinvites.data.AppInvitesBlockedListData.AppInvitesBlockedListDataEntry;
import com.facebook.appinvites.data.AppInvitesGraphqlMutationHelper;
import com.facebook.appinvites.protocol.FetchAppInvitesBlockedListQueries.AppInviteBlockedAppsQueryString;
import com.facebook.appinvites.protocol.FetchAppInvitesBlockedListQueries.AppInviteBlockedUsersQueryString;
import com.facebook.appinvites.protocol.FetchAppInvitesBlockedListQueriesModels.AppInviteBlockedAppsQueryModel;
import com.facebook.appinvites.protocol.FetchAppInvitesBlockedListQueriesModels.AppInviteBlockedAppsQueryModel.ApplicationRequestBlockedApplicationsModel.EdgesModel;
import com.facebook.appinvites.protocol.FetchAppInvitesBlockedListQueriesModels.AppInviteBlockedAppsQueryModel.ApplicationRequestBlockedApplicationsModel.EdgesModel.NodeModel;
import com.facebook.appinvites.protocol.FetchAppInvitesBlockedListQueriesModels.AppInviteBlockedUsersQueryModel;
import com.facebook.appinvites.protocol.FetchAppInvitesBlockedListQueriesModels.AppInviteBlockedUsersQueryModel.ApplicationRequestBlockedUsersModel;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: dracula_npe_11331948 */
public class AppInviteBlocksDialog extends AlertDialog {
    public static final Class<?> f14687b = AppInviteBlocksDialog.class;
    public final GraphQLQueryExecutor f14688c;
    private final TasksManager f14689d;
    private final AppInvitesBlockedListAdapterProvider f14690e;
    public LoadingIndicatorView f14691f;
    public ListView f14692g;
    public final int f14693h;
    public AppInvitesBlockedListData f14694i;
    public AppInvitesBlockedListAdapter f14695j;

    /* compiled from: dracula_npe_11331948 */
    public class C20521 extends AbstractDisposableFutureCallback<GraphQLResult> {
        final /* synthetic */ AppInviteBlocksDialog f14686a;

        /* compiled from: dracula_npe_11331948 */
        class C20511 implements RetryClickedListener {
            final /* synthetic */ C20521 f14685a;

            C20511(C20521 c20521) {
                this.f14685a = c20521;
            }

            public final void m15089a() {
                AppInviteBlocksDialog.m15093d(this.f14685a.f14686a);
            }
        }

        public C20521(AppInviteBlocksDialog appInviteBlocksDialog) {
            this.f14686a = appInviteBlocksDialog;
        }

        protected final void m15090a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f14686a.f14694i.f14563a.clear();
            ImmutableList a;
            int size;
            int i;
            if (this.f14686a.f14693h == 2) {
                AppInviteBlockedAppsQueryModel appInviteBlockedAppsQueryModel = (AppInviteBlockedAppsQueryModel) graphQLResult.e;
                Preconditions.checkNotNull(appInviteBlockedAppsQueryModel);
                a = appInviteBlockedAppsQueryModel.m14924a().m14920a();
                size = a.size();
                for (i = 0; i < size; i++) {
                    NodeModel a2 = ((EdgesModel) a.get(i)).m14915a();
                    this.f14686a.f14694i.m14738a(new AppInvitesBlockedListDataEntry(a2.m14909b(), a2.m14910c(), a2.m14911d().b(), true));
                }
            } else {
                AppInviteBlockedUsersQueryModel appInviteBlockedUsersQueryModel = (AppInviteBlockedUsersQueryModel) graphQLResult.e;
                Preconditions.checkNotNull(appInviteBlockedUsersQueryModel);
                a = appInviteBlockedUsersQueryModel.m14951a().m14947a();
                size = a.size();
                for (i = 0; i < size; i++) {
                    ApplicationRequestBlockedUsersModel.EdgesModel.NodeModel a3 = ((ApplicationRequestBlockedUsersModel.EdgesModel) a.get(i)).m14942a();
                    this.f14686a.f14694i.m14738a(new AppInvitesBlockedListDataEntry(a3.m14936b(), a3.m14937c(), a3.m14938d().b(), true));
                }
            }
            AdapterDetour.a(this.f14686a.f14695j, 682032506);
            this.f14686a.f14691f.setVisibility(8);
            this.f14686a.f14692g.setVisibility(0);
        }

        protected final void m15091a(Throwable th) {
            BLog.b(AppInviteBlocksDialog.f14687b, "Fetch block list failed", th);
            this.f14686a.f14691f.a(this.f14686a.getContext().getResources().getString(2131230811), new C20511(this));
        }
    }

    /* compiled from: dracula_npe_11331948 */
    enum AppInvitesBlockedListTask {
        FETCH_BLOCKED_APPS,
        FETCH_BLOCKED_USERS
    }

    @Inject
    public AppInviteBlocksDialog(GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, AppInvitesBlockedListAdapterProvider appInvitesBlockedListAdapterProvider, @Assisted Context context, @Assisted Integer num) {
        super(context);
        this.f14688c = graphQLQueryExecutor;
        this.f14689d = tasksManager;
        this.f14690e = appInvitesBlockedListAdapterProvider;
        this.f14693h = num.intValue();
        m15092c();
    }

    private void m15092c() {
        View inflate = LayoutInflater.from(getContext()).inflate(2130903275, null, false);
        a(inflate, 0, 0, 0, (int) getContext().getResources().getDimension(2131427416));
        TextView textView = (TextView) inflate.findViewById(2131559647);
        if (this.f14693h == 2) {
            textView.setText(2131241829);
        } else {
            textView.setText(2131241830);
        }
        this.f14691f = (LoadingIndicatorView) inflate.findViewById(2131559648);
        this.f14694i = new AppInvitesBlockedListData();
        AppInvitesBlockedListAdapterProvider appInvitesBlockedListAdapterProvider = this.f14690e;
        this.f14695j = new AppInvitesBlockedListAdapter(AppInvitesGraphqlMutationHelper.m14748a(appInvitesBlockedListAdapterProvider), Integer.valueOf(this.f14693h), this.f14694i);
        this.f14692g = (BetterListView) inflate.findViewById(2131559649);
        this.f14692g.setAdapter(this.f14695j);
        this.f14692g.setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(2131559650);
        TextView textView2 = (TextView) inflate.findViewById(2131559651);
        TextView textView3 = (TextView) inflate.findViewById(2131559652);
        if (this.f14693h == 2) {
            textView2.setText(2131241835);
            textView3.setText(2131241836);
        } else {
            textView2.setText(2131241833);
            textView3.setText(2131241834);
        }
        this.f14692g.setEmptyView(viewGroup);
        viewGroup.setVisibility(8);
        m15093d(this);
        this.f14691f.a();
    }

    public static void m15093d(AppInviteBlocksDialog appInviteBlocksDialog) {
        Object obj;
        GraphQLRequest a;
        TasksManager tasksManager = appInviteBlocksDialog.f14689d;
        if (appInviteBlocksDialog.f14693h == 1) {
            obj = AppInvitesBlockedListTask.FETCH_BLOCKED_USERS;
        } else {
            obj = AppInvitesBlockedListTask.FETCH_BLOCKED_APPS;
        }
        if (appInviteBlocksDialog.f14693h == 2) {
            a = GraphQLRequest.a((AppInviteBlockedAppsQueryString) new AppInviteBlockedAppsQueryString().a("settings_blocked_size", String.valueOf(2131434165)));
        } else {
            a = GraphQLRequest.a((AppInviteBlockedUsersQueryString) new AppInviteBlockedUsersQueryString().a("settings_blocked_size", String.valueOf(2131434165)));
        }
        a.a(GraphQLCachePolicy.c);
        tasksManager.a(obj, appInviteBlocksDialog.f14688c.a(a), new C20521(appInviteBlocksDialog));
    }

    public void dismiss() {
        this.f14689d.c();
        super.dismiss();
    }
}
