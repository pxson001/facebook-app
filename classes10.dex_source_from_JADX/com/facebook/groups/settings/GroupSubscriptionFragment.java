package com.facebook.groups.settings;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.navigation.DefaultGroupsNavigationHandler;
import com.facebook.groups.navigation.GroupsNavigationHandler;
import com.facebook.groups.settings.GroupSubscriptionInfoFetcher.C33471;
import com.facebook.groups.settings.GroupSubscriptionInfoFetcher.C33482;
import com.facebook.groups.settings.annotation.GroupSubscriptionsNavHandler;
import com.facebook.groups.widget.groupsettingsrow.protocol.GroupSettingsRowDataInterfaces.GroupSubscriptionData;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BetterListView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: THREAD_VIEW_ON_RESUME */
public class GroupSubscriptionFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    GroupSubscriptionAdapter f23162a;
    @Inject
    @GroupSubscriptionsNavHandler
    GroupsNavigationHandler f23163b;
    @Inject
    GroupSubscriptionInfoFetcherProvider f23164c;
    @Inject
    Lazy<Toaster> f23165d;
    @Inject
    Lazy<Resources> f23166e;
    public String f23167f;
    public BetterListView f23168g;
    private GroupSubscriptionInfoFetcher f23169h;

    /* compiled from: THREAD_VIEW_ON_RESUME */
    public class C33461 {
        public final /* synthetic */ GroupSubscriptionFragment f23161a;

        C33461(GroupSubscriptionFragment groupSubscriptionFragment) {
            this.f23161a = groupSubscriptionFragment;
        }

        public final void m24448a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null) {
                GroupSubscriptionFragment.m24451e(this.f23161a);
                return;
            }
            GroupSubscriptionData groupSubscriptionData = (GroupSubscriptionData) graphQLResult.e;
            this.f23161a.f23163b.a(this.f23161a, groupSubscriptionData.b(), null);
            GroupSubscriptionAdapter groupSubscriptionAdapter = this.f23161a.f23162a;
            String str = this.f23161a.f23167f;
            groupSubscriptionAdapter.f23152n = groupSubscriptionData;
            groupSubscriptionAdapter.f23153o = str;
            groupSubscriptionAdapter.f23145g = groupSubscriptionAdapter.f23152n.hd_().toString();
            groupSubscriptionAdapter.f23147i = groupSubscriptionAdapter.f23152n.hc_().toString();
            groupSubscriptionAdapter.f23148j = groupSubscriptionAdapter.f23152n.g();
            groupSubscriptionAdapter.f23149k = groupSubscriptionAdapter.f23152n.n() != null ? groupSubscriptionAdapter.f23152n.n() : GraphQLGroupAdminType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            GroupSubscriptionAdapter.m24439b(groupSubscriptionAdapter);
            ImmutableList a = groupSubscriptionAdapter.f23152n.d().a();
            ImmutableList a2 = groupSubscriptionAdapter.f23152n.c().a();
            groupSubscriptionAdapter.f23150l = a;
            groupSubscriptionAdapter.f23151m = a2;
            GroupSubscriptionAdapter.m24440c(groupSubscriptionAdapter);
            this.f23161a.f23168g.setAdapter(this.f23161a.f23162a);
        }
    }

    public static void m24450a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupSubscriptionFragment) obj).m24449a(new GroupSubscriptionAdapter(ResourcesMethodAutoProvider.a(fbInjector), DefaultGroupSubscriptionController.m24424b(fbInjector)), (GroupsNavigationHandler) DefaultGroupsNavigationHandler.a(fbInjector), (GroupSubscriptionInfoFetcherProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupSubscriptionInfoFetcherProvider.class), IdBasedLazy.a(fbInjector, 3588), IdBasedSingletonScopeProvider.b(fbInjector, 30));
    }

    private void m24449a(GroupSubscriptionAdapter groupSubscriptionAdapter, GroupsNavigationHandler groupsNavigationHandler, GroupSubscriptionInfoFetcherProvider groupSubscriptionInfoFetcherProvider, Lazy<Toaster> lazy, Lazy<Resources> lazy2) {
        this.f23162a = groupSubscriptionAdapter;
        this.f23163b = groupsNavigationHandler;
        this.f23164c = groupSubscriptionInfoFetcherProvider;
        this.f23165d = lazy;
        this.f23166e = lazy2;
    }

    public final void m24454c(Bundle bundle) {
        Class cls = GroupSubscriptionFragment.class;
        m24450a((Object) this, getContext());
        super.c(bundle);
    }

    public final View m24452a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1337695358);
        View inflate = layoutInflater.inflate(2130904697, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2099895263, a);
        return inflate;
    }

    public final void m24453a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f23167f = this.s.getString("group_feed_id");
        this.f23168g = (BetterListView) view.findViewById(2131562736);
        GroupSubscriptionInfoFetcherProvider groupSubscriptionInfoFetcherProvider = this.f23164c;
        this.f23169h = new GroupSubscriptionInfoFetcher(TasksManager.b(groupSubscriptionInfoFetcherProvider), GraphQLQueryExecutor.a(groupSubscriptionInfoFetcherProvider), this.f23167f, new C33461(this));
        GroupSubscriptionInfoFetcher groupSubscriptionInfoFetcher = this.f23169h;
        groupSubscriptionInfoFetcher.f23172a.a("fetch_group_settings_row", new C33471(groupSubscriptionInfoFetcher), new C33482(groupSubscriptionInfoFetcher));
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 57516286);
        super.mY_();
        this.f23169h.f23172a.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 575100936, a);
    }

    public final String am_() {
        return "group_notification_settings";
    }

    public static void m24451e(GroupSubscriptionFragment groupSubscriptionFragment) {
        ((Toaster) groupSubscriptionFragment.f23165d.get()).b(new ToastBuilder(((Resources) groupSubscriptionFragment.f23166e.get()).getString(2131237914)));
        groupSubscriptionFragment.o().onBackPressed();
    }
}
