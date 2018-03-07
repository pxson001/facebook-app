package com.facebook.localcontent.menus.structured;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.FindViewUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.localcontent.menus.structured.StructuredMenuListLoader.C16501;
import com.facebook.localcontent.menus.structured.list.StructuredMenuItemController;
import com.facebook.localcontent.menus.structured.list.StructuredMenuListAdapter;
import com.facebook.localcontent.protocol.graphql.FetchStructuredMenuList.StructuredMenuListDataString;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: e482bef3b53627dcdb2b059d1b5ac3a3 */
public class StructuredMenuListFragment extends FbFragment {
    @Inject
    public StructuredMenuListAdapter f15118a;
    @Inject
    public StructuredMenuListLoader f15119b;
    public EmptyListViewItem f15120c;
    private BetterListView f15121d;

    public static void m17565a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        StructuredMenuListFragment structuredMenuListFragment = (StructuredMenuListFragment) obj;
        StructuredMenuListAdapter structuredMenuListAdapter = new StructuredMenuListAdapter(new StructuredMenuItemController((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector), TasksManager.b(fbInjector), Toaster.b(fbInjector), IdBasedProvider.a(fbInjector, 3736)));
        StructuredMenuListLoader a = StructuredMenuListLoader.m17571a(fbInjector);
        structuredMenuListFragment.f15118a = structuredMenuListAdapter;
        structuredMenuListFragment.f15119b = a;
    }

    public final void m17568c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = StructuredMenuListFragment.class;
        m17565a((Object) this, getContext());
    }

    public final View m17566a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -750816783);
        View inflate = layoutInflater.inflate(2130907288, viewGroup, false);
        this.f15120c = (EmptyListViewItem) FindViewUtil.b(inflate, 2131567735);
        this.f15121d = (BetterListView) FindViewUtil.b(inflate, 2131567734);
        this.f15121d.setEmptyView(this.f15120c);
        View view = new View(getContext());
        view.setMinimumHeight(this.s.getInt("local_content_padding_top"));
        this.f15121d.addHeaderView(view);
        this.f15121d.setAdapter(this.f15118a);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -757084866, a);
        return inflate;
    }

    public final void m17567a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        String string = this.s.getString("local_content_menu_id");
        Preconditions.checkNotNull(string);
        StructuredMenuListLoader structuredMenuListLoader = this.f15119b;
        GraphQlQueryString structuredMenuListDataString = new StructuredMenuListDataString();
        structuredMenuListDataString.a("node_id", string).a("sublist_count", Integer.valueOf(1000)).a("items_count", Integer.valueOf(1000));
        structuredMenuListLoader.f15127b.a("task_key_fetch_structured_menu" + string, structuredMenuListLoader.f15126a.a(GraphQLRequest.a(structuredMenuListDataString)), new C16501(structuredMenuListLoader, this));
        this.f15120c.a(true);
    }
}
