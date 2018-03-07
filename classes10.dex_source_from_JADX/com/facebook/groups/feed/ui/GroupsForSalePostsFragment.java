package com.facebook.groups.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.groups.feed.controller.GroupsFeedController;
import com.facebook.groups.feed.controller.GroupsFeedControllerResponder;
import com.facebook.groups.feed.controller.GroupsFeedPager;
import com.facebook.groups.feed.controller.GroupsFeedPager.PagerListener;
import com.facebook.groups.feed.controller.GroupsFeedPagerProtocol;
import com.facebook.groups.feed.data.GroupsFeedConsistencySync;
import com.facebook.groups.feed.data.GroupsFeedConsistencySyncProvider;
import com.facebook.groups.feed.data.GroupsOnDataChangeListener;
import com.facebook.groups.feed.data.ViewerStatusCache;
import com.facebook.groups.feed.protocol.FetchGroupsFeedAvailableForSalePostIdsMethodProvider;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams.GroupsFeedTypes;
import com.facebook.groups.feed.rows.BaseGroupsMultiRowAdapterFactory;
import com.facebook.groups.feed.rows.GroupsFeedListType;
import com.facebook.groups.feed.ui.GroupsEnvironment.MenuType;
import com.facebook.groups.feed.ui.partdefinitions.FB4AGroupsFeedRootPartDefinitionFactory;
import com.facebook.groups.feed.ui.partdefinitions.GroupsProductFeedGraphQLStorySelectorPartDefinition;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.titlebar.HasTitleBar;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ThreadsPreloadInitializer */
public class GroupsForSalePostsFragment extends GroupsFeedSearchQueryFragment implements AnalyticsFragment, GroupsFeedControllerResponder {
    @Inject
    GroupsFeedPagerProtocol f22174a;
    @Inject
    GroupsEnvironmentProvider al;
    private FeedType am;
    public MultiRowAdapter an;
    public GroupsFeedConsistencySync ao;
    @Inject
    FetchGroupsFeedAvailableForSalePostIdsMethodProvider f22175b;
    @Inject
    GroupsFeedConsistencySyncProvider f22176c;
    @Inject
    public GroupsFeedController f22177d;
    @Inject
    GroupsFeedPager f22178e;
    @Inject
    ViewerStatusCache f22179f;
    @Inject
    BaseGroupsMultiRowAdapterFactory f22180g;
    @Inject
    FB4AGroupsFeedRootPartDefinitionFactory f22181h;
    @Inject
    Lazy<GroupsProductFeedGraphQLStorySelectorPartDefinition> f22182i;

    /* compiled from: ThreadsPreloadInitializer */
    class C31971 implements PagerListener {
        final /* synthetic */ GroupsForSalePostsFragment f22171a;

        C31971(GroupsForSalePostsFragment groupsForSalePostsFragment) {
            this.f22171a = groupsForSalePostsFragment;
        }

        public final void m23307a() {
            this.f22171a.f22177d.h();
        }

        public final void m23309b() {
            this.f22171a.f22177d.f();
        }

        public final void m23310b(boolean z) {
            this.f22171a.ao.a(z);
        }

        public final void m23308a(boolean z) {
            this.f22171a.f22177d.b(z);
        }
    }

    /* compiled from: ThreadsPreloadInitializer */
    class C31982 implements GroupsOnDataChangeListener {
        final /* synthetic */ GroupsForSalePostsFragment f22172a;

        C31982(GroupsForSalePostsFragment groupsForSalePostsFragment) {
            this.f22172a = groupsForSalePostsFragment;
        }

        public final void m23311b() {
            this.f22172a.an.notifyDataSetChanged();
        }
    }

    /* compiled from: ThreadsPreloadInitializer */
    class C31993 implements Runnable {
        final /* synthetic */ GroupsForSalePostsFragment f22173a;

        C31993(GroupsForSalePostsFragment groupsForSalePostsFragment) {
            this.f22173a = groupsForSalePostsFragment;
        }

        public void run() {
            this.f22173a.an.notifyDataSetChanged();
        }
    }

    public static void m23313a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupsForSalePostsFragment) obj).m23312a(GroupsFeedPagerProtocol.b(fbInjector), (FetchGroupsFeedAvailableForSalePostIdsMethodProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FetchGroupsFeedAvailableForSalePostIdsMethodProvider.class), (GroupsFeedConsistencySyncProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsFeedConsistencySyncProvider.class), GroupsFeedController.b(fbInjector), GroupsFeedPager.b(fbInjector), ViewerStatusCache.a(fbInjector), BaseGroupsMultiRowAdapterFactory.b(fbInjector), FB4AGroupsFeedRootPartDefinitionFactory.m23506a(fbInjector), IdBasedLazy.a(fbInjector, 7006), (GroupsEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsEnvironmentProvider.class));
    }

    public final void mo973c(Bundle bundle) {
        super.mo973c(bundle);
        Class cls = GroupsForSalePostsFragment.class;
        m23313a((Object) this, getContext());
        this.f22179f.a(av(), aw());
        this.am = new FeedType(new GroupsFeedTypeValueParams(av(), GroupsFeedTypes.AvailableForSalePosts), Name.t);
        this.f22174a.a(this.am, 10, 3);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 560478643);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131237951);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1857411871, a);
    }

    public final View m23314a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2120600248);
        View view = (ViewGroup) layoutInflater.inflate(2130904711, viewGroup, false);
        this.f22178e.a(this.f22174a, new C31971(this), 1000, 5, null);
        FeedUnitCollection feedUnitCollection = this.f22178e.c;
        GroupsFeedController groupsFeedController = this.f22177d;
        GroupsFeedPager groupsFeedPager = this.f22178e;
        GroupsFeedListType.b();
        groupsFeedController.a(view, groupsFeedPager, feedUnitCollection, this, this, true, null);
        this.ao = this.f22176c.a(this.am, this.f22175b.a(this.am), feedUnitCollection, new C31982(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -412366128, a);
        return view;
    }

    public final void m23317a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        this.f22177d.b(i, i2, intent);
    }

    public final void m23320a(boolean z, boolean z2) {
    }

    public final FeedEnvironment m23315a(BetterListView betterListView) {
        return this.al.m23223a(MenuType.NORMAL, getContext(), GroupsFeedListType.a, new C31993(this), HasScrollListenerSupportImpl.a(betterListView), null);
    }

    public final MultiRowAdapter m23316a(ListItemCollection<FeedEdge> listItemCollection, FeedEnvironment feedEnvironment) {
        this.an = this.f22180g.a(listItemCollection, this.f22181h.m23508a(this.f22182i, null), feedEnvironment, this.f22178e);
        return this.an;
    }

    private void m23312a(GroupsFeedPagerProtocol groupsFeedPagerProtocol, FetchGroupsFeedAvailableForSalePostIdsMethodProvider fetchGroupsFeedAvailableForSalePostIdsMethodProvider, GroupsFeedConsistencySyncProvider groupsFeedConsistencySyncProvider, GroupsFeedController groupsFeedController, GroupsFeedPager groupsFeedPager, ViewerStatusCache viewerStatusCache, BaseGroupsMultiRowAdapterFactory baseGroupsMultiRowAdapterFactory, FB4AGroupsFeedRootPartDefinitionFactory fB4AGroupsFeedRootPartDefinitionFactory, Lazy<GroupsProductFeedGraphQLStorySelectorPartDefinition> lazy, GroupsEnvironmentProvider groupsEnvironmentProvider) {
        this.f22174a = groupsFeedPagerProtocol;
        this.f22175b = fetchGroupsFeedAvailableForSalePostIdsMethodProvider;
        this.f22176c = groupsFeedConsistencySyncProvider;
        this.f22177d = groupsFeedController;
        this.f22178e = groupsFeedPager;
        this.f22179f = viewerStatusCache;
        this.f22180g = baseGroupsMultiRowAdapterFactory;
        this.f22181h = fB4AGroupsFeedRootPartDefinitionFactory;
        this.f22182i = lazy;
        this.al = groupsEnvironmentProvider;
    }

    @Nullable
    public final FbBaseAdapter m23326l() {
        return null;
    }

    @Nullable
    public final FbBaseAdapter m23327m() {
        return null;
    }

    public final void m23325f() {
    }

    public final boolean m23321a(FbNetworkManager fbNetworkManager, GenericNotificationBanner genericNotificationBanner) {
        return false;
    }

    public final void nt_() {
        this.f22177d.h();
    }

    public final void m23328r() {
    }

    public final void m23318a(View view) {
        FbTextView fbTextView = (FbTextView) view.findViewById(2131561172);
        fbTextView.setVisibility(8);
        fbTextView.setText(jW_().getText(2131238016));
    }

    public final void m23324e() {
        this.f22177d.i();
    }

    public final void m23322b(boolean z) {
    }

    public final String am_() {
        return "group_for_sale_posts";
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1139803270);
        super.mY_();
        this.ao.a();
        this.f22178e.g();
        if (this.an != null) {
            this.an.jc_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -766615006, a);
    }

    public final void m23319a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        this.f22177d.a(str, fileDescriptor, printWriter, strArr);
    }
}
