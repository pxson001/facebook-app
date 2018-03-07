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
import com.facebook.graphql.enums.GraphQLGroupAdminType;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.groups.feed.controller.GroupsFeedController;
import com.facebook.groups.feed.controller.GroupsFeedControllerResponder;
import com.facebook.groups.feed.controller.GroupsFeedPager;
import com.facebook.groups.feed.controller.GroupsFeedPager.PagerListener;
import com.facebook.groups.feed.controller.GroupsFeedPagerProtocol;
import com.facebook.groups.feed.data.GroupsFeedApproveStoryController;
import com.facebook.groups.feed.data.GroupsFeedConsistencySync;
import com.facebook.groups.feed.data.GroupsFeedConsistencySyncProvider;
import com.facebook.groups.feed.data.GroupsOnDataChangeListener;
import com.facebook.groups.feed.data.ViewerStatusCache;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLInterfaces.GroupViewerStatus;
import com.facebook.groups.feed.protocol.FetchGroupsFeedPendingIdsMethodProvider;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams.GroupsFeedTypes;
import com.facebook.groups.feed.rows.BaseGroupsMultiRowAdapterFactory;
import com.facebook.groups.feed.rows.GroupsPendingFeedListType;
import com.facebook.groups.feed.rows.partdefinitions.HideApprovedStoryPartDefinition;
import com.facebook.groups.feed.ui.GroupsEnvironment.MenuType;
import com.facebook.groups.feed.ui.partdefinitions.FB4AGroupsFeedRootPartDefinitionFactory;
import com.facebook.groups.feed.ui.partdefinitions.GroupsGraphQLStorySelectorPartDefinition;
import com.facebook.groups.feed.ui.partdefinitions.ModerationGroupPartDefinition;
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

/* compiled from: TimelineFragment.onFragmentCreate.createTimelineConfig */
public class GroupPendingPostsFragment extends GroupsFeedSearchQueryFragment implements AnalyticsFragment, GroupsFeedControllerResponder {
    @Inject
    GroupsFeedPagerProtocol f22041a;
    @Inject
    Lazy<GroupsGraphQLStorySelectorPartDefinition> al;
    @Inject
    Lazy<HideApprovedStoryPartDefinition> am;
    @Inject
    Lazy<ModerationGroupPartDefinition> an;
    @Inject
    GroupsEnvironmentProvider ao;
    private GroupViewerStatus aq;
    private FeedType ar;
    public MultiRowAdapter as;
    public GroupsFeedConsistencySync at;
    private boolean au;
    @Inject
    FetchGroupsFeedPendingIdsMethodProvider f22042b;
    @Inject
    GroupsFeedConsistencySyncProvider f22043c;
    @Inject
    GroupsFeedApproveStoryController f22044d;
    @Inject
    public GroupsFeedController f22045e;
    @Inject
    GroupsFeedPager f22046f;
    @Inject
    ViewerStatusCache f22047g;
    @Inject
    BaseGroupsMultiRowAdapterFactory f22048h;
    @Inject
    FB4AGroupsFeedRootPartDefinitionFactory f22049i;

    /* compiled from: TimelineFragment.onFragmentCreate.createTimelineConfig */
    class C31591 implements PagerListener {
        final /* synthetic */ GroupPendingPostsFragment f22038a;

        C31591(GroupPendingPostsFragment groupPendingPostsFragment) {
            this.f22038a = groupPendingPostsFragment;
        }

        public final void m23182a() {
            this.f22038a.f22045e.h();
        }

        public final void m23184b() {
            this.f22038a.f22045e.f();
        }

        public final void m23185b(boolean z) {
            this.f22038a.at.a(z);
        }

        public final void m23183a(boolean z) {
            this.f22038a.f22045e.b(z);
        }
    }

    /* compiled from: TimelineFragment.onFragmentCreate.createTimelineConfig */
    public class C31602 implements GroupsOnDataChangeListener {
        public final /* synthetic */ GroupPendingPostsFragment f22039a;

        C31602(GroupPendingPostsFragment groupPendingPostsFragment) {
            this.f22039a = groupPendingPostsFragment;
        }

        public final void m23186b() {
            this.f22039a.as.notifyDataSetChanged();
        }
    }

    /* compiled from: TimelineFragment.onFragmentCreate.createTimelineConfig */
    class C31613 implements Runnable {
        final /* synthetic */ GroupPendingPostsFragment f22040a;

        C31613(GroupPendingPostsFragment groupPendingPostsFragment) {
            this.f22040a = groupPendingPostsFragment;
        }

        public void run() {
            this.f22040a.as.notifyDataSetChanged();
        }
    }

    public static void m23188a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupPendingPostsFragment) obj).m23187a(GroupsFeedPagerProtocol.b(fbInjector), (FetchGroupsFeedPendingIdsMethodProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FetchGroupsFeedPendingIdsMethodProvider.class), (GroupsFeedConsistencySyncProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsFeedConsistencySyncProvider.class), GroupsFeedApproveStoryController.b(fbInjector), GroupsFeedController.b(fbInjector), GroupsFeedPager.b(fbInjector), ViewerStatusCache.a(fbInjector), BaseGroupsMultiRowAdapterFactory.b(fbInjector), FB4AGroupsFeedRootPartDefinitionFactory.m23506a(fbInjector), IdBasedLazy.a(fbInjector, 7002), IdBasedLazy.a(fbInjector, 6985), IdBasedLazy.a(fbInjector, 7009), (GroupsEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsEnvironmentProvider.class));
    }

    public final MultiRowAdapter m23191a(ListItemCollection<FeedEdge> listItemCollection, FeedEnvironment feedEnvironment) {
        GroupsPendingFeedListType groupsPendingFeedListType = GroupsPendingFeedListType.a;
        if (this.au) {
            this.as = this.f22048h.a(listItemCollection, this.f22049i.m23508a(this.an, this.am), feedEnvironment, this.f22046f);
        } else {
            this.as = this.f22048h.a(listItemCollection, this.f22049i.m23508a(this.al, this.am), feedEnvironment, this.f22046f);
        }
        return this.as;
    }

    public final void mo973c(Bundle bundle) {
        super.mo973c(bundle);
        Class cls = GroupPendingPostsFragment.class;
        m23188a((Object) this, getContext());
        this.aq = aw();
        boolean z = true;
        if (aw() != null) {
            if (!(GraphQLGroupAdminType.ADMIN == aw().n() || GraphQLGroupAdminType.MODERATOR == aw().n())) {
                z = false;
            }
        } else if (this.s.containsKey("group_is_viewer_admin")) {
            z = this.s.getBoolean("group_is_viewer_admin");
        }
        this.au = z;
        this.f22047g.a(av(), this.aq);
        this.ar = new FeedType(new GroupsFeedTypeValueParams(av(), GroupsFeedTypes.PendingPosts), Name.u);
        this.f22041a.a(this.ar, 10, 3);
    }

    public final View m23189a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1034045311);
        View view = (ViewGroup) layoutInflater.inflate(2130904711, viewGroup, false);
        this.f22046f.a(this.f22041a, new C31591(this), 1000, 5, null);
        FeedUnitCollection e = this.f22046f.e();
        GroupsFeedController groupsFeedController = this.f22045e;
        GroupsFeedPager groupsFeedPager = this.f22046f;
        GroupsPendingFeedListType.b();
        groupsFeedController.a(view, groupsFeedPager, e, this, this, true, null);
        C31602 c31602 = new C31602(this);
        this.f22044d.a(e.b(), c31602, true);
        this.at = this.f22043c.a(this.ar, this.f22042b.a(this.ar), e, c31602);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1463066691, a);
        return view;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 100831198);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131237993);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1302140130, a);
    }

    public final FeedEnvironment m23190a(BetterListView betterListView) {
        return this.ao.m23223a(MenuType.PENDING, getContext(), GroupsPendingFeedListType.a, new C31613(this), HasScrollListenerSupportImpl.a(betterListView), null);
    }

    private void m23187a(GroupsFeedPagerProtocol groupsFeedPagerProtocol, FetchGroupsFeedPendingIdsMethodProvider fetchGroupsFeedPendingIdsMethodProvider, GroupsFeedConsistencySyncProvider groupsFeedConsistencySyncProvider, GroupsFeedApproveStoryController groupsFeedApproveStoryController, GroupsFeedController groupsFeedController, GroupsFeedPager groupsFeedPager, ViewerStatusCache viewerStatusCache, BaseGroupsMultiRowAdapterFactory baseGroupsMultiRowAdapterFactory, FB4AGroupsFeedRootPartDefinitionFactory fB4AGroupsFeedRootPartDefinitionFactory, Lazy<GroupsGraphQLStorySelectorPartDefinition> lazy, Lazy<HideApprovedStoryPartDefinition> lazy2, Lazy<ModerationGroupPartDefinition> lazy3, GroupsEnvironmentProvider groupsEnvironmentProvider) {
        this.f22041a = groupsFeedPagerProtocol;
        this.f22042b = fetchGroupsFeedPendingIdsMethodProvider;
        this.f22043c = groupsFeedConsistencySyncProvider;
        this.f22044d = groupsFeedApproveStoryController;
        this.f22045e = groupsFeedController;
        this.f22046f = groupsFeedPager;
        this.f22047g = viewerStatusCache;
        this.f22048h = baseGroupsMultiRowAdapterFactory;
        this.f22049i = fB4AGroupsFeedRootPartDefinitionFactory;
        this.al = lazy;
        this.am = lazy2;
        this.an = lazy3;
        this.ao = groupsEnvironmentProvider;
    }

    @Nullable
    public final FbBaseAdapter m23201l() {
        return null;
    }

    @Nullable
    public final FbBaseAdapter m23202m() {
        return null;
    }

    public final void m23197b(boolean z) {
    }

    public final void m23200f() {
    }

    public final boolean m23196a(FbNetworkManager fbNetworkManager, GenericNotificationBanner genericNotificationBanner) {
        return false;
    }

    public final void nt_() {
        this.f22045e.h();
    }

    public final void m23203r() {
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1062508026);
        super.mY_();
        GroupsFeedApproveStoryController groupsFeedApproveStoryController = this.f22044d;
        groupsFeedApproveStoryController.a.b(groupsFeedApproveStoryController.b);
        this.at.a();
        this.f22046f.g();
        this.as.jc_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1625363650, a);
    }

    public final void m23193a(View view) {
        FbTextView fbTextView = (FbTextView) view.findViewById(2131561172);
        fbTextView.setVisibility(8);
        fbTextView.setText(jW_().getText(2131237996));
    }

    public final void m23195a(boolean z, boolean z2) {
    }

    public final void m23199e() {
        this.f22045e.i();
    }

    public final void m23192a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        this.f22045e.b(i, i2, intent);
    }

    public final void m23194a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f22045e.a(str, fileDescriptor, printWriter, strArr);
    }

    public final String am_() {
        return "pending_posts_admin";
    }
}
