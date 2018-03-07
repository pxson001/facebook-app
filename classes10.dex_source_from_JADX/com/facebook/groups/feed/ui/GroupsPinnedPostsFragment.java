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
import com.facebook.groups.feed.data.GroupsFeedPinStoryController;
import com.facebook.groups.feed.data.GroupsFeedPinStoryController.GroupsPinDataChangeListener;
import com.facebook.groups.feed.data.PinState;
import com.facebook.groups.feed.data.ViewerStatusCache;
import com.facebook.groups.feed.protocol.FetchGroupsFeedPinnedIdsMethodProvider;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams;
import com.facebook.groups.feed.protocol.GroupsFeedTypeValueParams.GroupsFeedTypes;
import com.facebook.groups.feed.rows.BaseGroupsMultiRowAdapterFactory;
import com.facebook.groups.feed.rows.GroupsPinnedFeedListType;
import com.facebook.groups.feed.rows.partdefinitions.HideUnpinnedStoryPartDefinition;
import com.facebook.groups.feed.ui.GroupsEnvironment.MenuType;
import com.facebook.groups.feed.ui.partdefinitions.FB4AGroupsFeedRootPartDefinitionFactory;
import com.facebook.groups.feed.ui.partdefinitions.GroupsGraphQLStorySelectorPartDefinition;
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

/* compiled from: ThreadViewMessagesFragment_QPBanner_MissingKey */
public class GroupsPinnedPostsFragment extends GroupsFeedSearchQueryFragment implements AnalyticsFragment, GroupsFeedControllerResponder {
    @Inject
    GroupsFeedPagerProtocol f22243a;
    @Inject
    Lazy<GroupsGraphQLStorySelectorPartDefinition> al;
    @Inject
    Lazy<HideUnpinnedStoryPartDefinition> am;
    @Inject
    GroupsEnvironmentProvider an;
    private FeedType ao;
    public MultiRowAdapter aq;
    public GroupsFeedConsistencySync ar;
    @Inject
    FetchGroupsFeedPinnedIdsMethodProvider f22244b;
    @Inject
    GroupsFeedConsistencySyncProvider f22245c;
    @Inject
    GroupsFeedPinStoryController f22246d;
    @Inject
    public GroupsFeedController f22247e;
    @Inject
    GroupsFeedPager f22248f;
    @Inject
    ViewerStatusCache f22249g;
    @Inject
    BaseGroupsMultiRowAdapterFactory f22250h;
    @Inject
    FB4AGroupsFeedRootPartDefinitionFactory f22251i;

    /* compiled from: ThreadViewMessagesFragment_QPBanner_MissingKey */
    class C32101 implements PagerListener {
        final /* synthetic */ GroupsPinnedPostsFragment f22240a;

        C32101(GroupsPinnedPostsFragment groupsPinnedPostsFragment) {
            this.f22240a = groupsPinnedPostsFragment;
        }

        public final void m23351a() {
            this.f22240a.f22247e.h();
        }

        public final void m23353b() {
            this.f22240a.f22247e.f();
        }

        public final void m23354b(boolean z) {
            this.f22240a.ar.a(z);
        }

        public final void m23352a(boolean z) {
            this.f22240a.f22247e.b(z);
        }
    }

    /* compiled from: ThreadViewMessagesFragment_QPBanner_MissingKey */
    class C32112 implements GroupsPinDataChangeListener {
        final /* synthetic */ GroupsPinnedPostsFragment f22241a;

        C32112(GroupsPinnedPostsFragment groupsPinnedPostsFragment) {
            this.f22241a = groupsPinnedPostsFragment;
        }

        public final void m23356b() {
            this.f22241a.aq.notifyDataSetChanged();
        }

        public final void m23355a() {
            this.f22241a.m23369e();
        }
    }

    /* compiled from: ThreadViewMessagesFragment_QPBanner_MissingKey */
    class C32123 implements Runnable {
        final /* synthetic */ GroupsPinnedPostsFragment f22242a;

        C32123(GroupsPinnedPostsFragment groupsPinnedPostsFragment) {
            this.f22242a = groupsPinnedPostsFragment;
        }

        public void run() {
            this.f22242a.aq.notifyDataSetChanged();
        }
    }

    public static void m23358a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupsPinnedPostsFragment) obj).m23357a(GroupsFeedPagerProtocol.b(fbInjector), (FetchGroupsFeedPinnedIdsMethodProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FetchGroupsFeedPinnedIdsMethodProvider.class), (GroupsFeedConsistencySyncProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsFeedConsistencySyncProvider.class), GroupsFeedPinStoryController.b(fbInjector), GroupsFeedController.b(fbInjector), GroupsFeedPager.b(fbInjector), ViewerStatusCache.a(fbInjector), BaseGroupsMultiRowAdapterFactory.b(fbInjector), FB4AGroupsFeedRootPartDefinitionFactory.m23506a(fbInjector), IdBasedLazy.a(fbInjector, 7002), IdBasedLazy.a(fbInjector, 6988), (GroupsEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsEnvironmentProvider.class));
    }

    public final MultiRowAdapter m23361a(ListItemCollection<FeedEdge> listItemCollection, FeedEnvironment feedEnvironment) {
        GroupsPinnedFeedListType groupsPinnedFeedListType = GroupsPinnedFeedListType.a;
        this.aq = this.f22250h.a(listItemCollection, this.f22251i.m23508a(this.al, this.am), feedEnvironment, this.f22248f);
        return this.aq;
    }

    public final void mo973c(Bundle bundle) {
        super.mo973c(bundle);
        Class cls = GroupsPinnedPostsFragment.class;
        m23358a((Object) this, getContext());
        this.f22249g.a(av(), aw());
        this.ao = new FeedType(new GroupsFeedTypeValueParams(av(), GroupsFeedTypes.PinnedPosts), Name.v);
        this.f22243a.a(this.ao, 10, 3);
    }

    public final View m23359a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 491700938);
        View view = (ViewGroup) layoutInflater.inflate(2130904711, viewGroup, false);
        this.f22248f.a(this.f22243a, new C32101(this), 1000, 5, null);
        FeedUnitCollection feedUnitCollection = this.f22248f.c;
        GroupsFeedController groupsFeedController = this.f22247e;
        GroupsFeedPager groupsFeedPager = this.f22248f;
        GroupsPinnedFeedListType.b();
        groupsFeedController.a(view, groupsFeedPager, feedUnitCollection, this, this, true, null);
        C32112 c32112 = new C32112(this);
        this.ar = this.f22245c.a(this.ao, this.f22244b.a(this.ao), feedUnitCollection, c32112);
        this.f22246d.a(feedUnitCollection.b(), c32112, PinState.Unpin);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1259064009, a);
        return view;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 562453210);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131237960);
            hasTitleBar.kg_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 93017421, a);
    }

    public final void m23365a(boolean z, boolean z2) {
    }

    public final FeedEnvironment m23360a(BetterListView betterListView) {
        return this.an.m23223a(MenuType.PINNED, getContext(), GroupsPinnedFeedListType.a, new C32123(this), HasScrollListenerSupportImpl.a(betterListView), null);
    }

    private void m23357a(GroupsFeedPagerProtocol groupsFeedPagerProtocol, FetchGroupsFeedPinnedIdsMethodProvider fetchGroupsFeedPinnedIdsMethodProvider, GroupsFeedConsistencySyncProvider groupsFeedConsistencySyncProvider, GroupsFeedPinStoryController groupsFeedPinStoryController, GroupsFeedController groupsFeedController, GroupsFeedPager groupsFeedPager, ViewerStatusCache viewerStatusCache, BaseGroupsMultiRowAdapterFactory baseGroupsMultiRowAdapterFactory, FB4AGroupsFeedRootPartDefinitionFactory fB4AGroupsFeedRootPartDefinitionFactory, Lazy<GroupsGraphQLStorySelectorPartDefinition> lazy, Lazy<HideUnpinnedStoryPartDefinition> lazy2, GroupsEnvironmentProvider groupsEnvironmentProvider) {
        this.f22243a = groupsFeedPagerProtocol;
        this.f22244b = fetchGroupsFeedPinnedIdsMethodProvider;
        this.f22245c = groupsFeedConsistencySyncProvider;
        this.f22246d = groupsFeedPinStoryController;
        this.f22247e = groupsFeedController;
        this.f22248f = groupsFeedPager;
        this.f22249g = viewerStatusCache;
        this.f22250h = baseGroupsMultiRowAdapterFactory;
        this.f22251i = fB4AGroupsFeedRootPartDefinitionFactory;
        this.al = lazy;
        this.am = lazy2;
        this.an = groupsEnvironmentProvider;
    }

    @Nullable
    public final FbBaseAdapter m23371l() {
        return null;
    }

    @Nullable
    public final FbBaseAdapter m23372m() {
        return null;
    }

    public final void m23370f() {
    }

    public final boolean m23366a(FbNetworkManager fbNetworkManager, GenericNotificationBanner genericNotificationBanner) {
        return false;
    }

    public final void nt_() {
        this.f22247e.h();
    }

    public final void m23363a(View view) {
        FbTextView fbTextView = (FbTextView) view.findViewById(2131561172);
        fbTextView.setVisibility(8);
        fbTextView.setText(jW_().getText(2131237995));
    }

    public final void m23369e() {
        this.f22247e.i();
    }

    public final void m23367b(boolean z) {
    }

    public final void m23373r() {
    }

    public final void m23362a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        this.f22247e.b(i, i2, intent);
    }

    public final String am_() {
        return "pinned_posts";
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 525400708);
        super.mY_();
        this.ar.a();
        this.f22248f.g();
        this.f22246d.a();
        if (this.aq != null) {
            this.aq.jc_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2133249267, a);
    }

    public final void m23364a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        this.f22247e.a(str, fileDescriptor, printWriter, strArr);
    }
}
