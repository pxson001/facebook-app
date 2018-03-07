package com.facebook.groups.feed.ui;

import android.content.Context;
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
import com.facebook.groups.feed.protocol.FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethodProvider;
import com.facebook.groups.feed.protocol.FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethodProvider;
import com.facebook.groups.feed.protocol.FetchGroupsFeedAuthoredSoldForSalePostsIdsMethodProvider;
import com.facebook.groups.feed.protocol.StoryInvalidaterFetchIdsMethod;
import com.facebook.groups.feed.rows.BaseGroupsMultiRowAdapterFactory;
import com.facebook.groups.feed.rows.GroupsFeedListType;
import com.facebook.groups.feed.ui.GroupsEnvironment.MenuType;
import com.facebook.groups.feed.ui.partdefinitions.FB4AGroupsFeedRootPartDefinitionFactory;
import com.facebook.groups.feed.ui.partdefinitions.GroupsYourPostsGraphQLStorySelectorPartDefinition;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.titlebar.HasTitleBar;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ThreadViewMessageFragment.onCreateThroughOnResume */
public class GroupsYourPostsFragment extends GroupsFeedSearchQueryFragment implements AnalyticsFragment, GroupsFeedControllerResponder {
    @Inject
    GroupsFeedPagerProtocol f22396a;
    @Inject
    FB4AGroupsFeedRootPartDefinitionFactory al;
    @Inject
    Lazy<GroupsYourPostsGraphQLStorySelectorPartDefinition> am;
    @Inject
    GroupsEnvironmentProvider an;
    private FeedType ao;
    public MultiRowAdapter aq;
    public GroupsFeedConsistencySync ar;
    @Inject
    FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethodProvider f22397b;
    @Inject
    FetchGroupsFeedAuthoredSoldForSalePostsIdsMethodProvider f22398c;
    @Inject
    FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethodProvider f22399d;
    @Inject
    GroupsFeedConsistencySyncProvider f22400e;
    @Inject
    public GroupsFeedController f22401f;
    @Inject
    GroupsFeedPager f22402g;
    @Inject
    ViewerStatusCache f22403h;
    @Inject
    BaseGroupsMultiRowAdapterFactory f22404i;

    /* compiled from: ThreadViewMessageFragment.onCreateThroughOnResume */
    class C32541 implements PagerListener {
        final /* synthetic */ GroupsYourPostsFragment f22393a;

        C32541(GroupsYourPostsFragment groupsYourPostsFragment) {
            this.f22393a = groupsYourPostsFragment;
        }

        public final void m23457a() {
            this.f22393a.f22401f.h();
        }

        public final void m23459b() {
            this.f22393a.f22401f.f();
        }

        public final void m23460b(boolean z) {
            this.f22393a.ar.a(z);
        }

        public final void m23458a(boolean z) {
            this.f22393a.f22401f.b(z);
        }
    }

    /* compiled from: ThreadViewMessageFragment.onCreateThroughOnResume */
    class C32552 implements GroupsOnDataChangeListener {
        final /* synthetic */ GroupsYourPostsFragment f22394a;

        C32552(GroupsYourPostsFragment groupsYourPostsFragment) {
            this.f22394a = groupsYourPostsFragment;
        }

        public final void m23461b() {
            this.f22394a.aq.notifyDataSetChanged();
        }
    }

    /* compiled from: ThreadViewMessageFragment.onCreateThroughOnResume */
    class C32563 implements Runnable {
        final /* synthetic */ GroupsYourPostsFragment f22395a;

        C32563(GroupsYourPostsFragment groupsYourPostsFragment) {
            this.f22395a = groupsYourPostsFragment;
        }

        public void run() {
            this.f22395a.aq.notifyDataSetChanged();
        }
    }

    public static void m23463a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupsYourPostsFragment) obj).m23462a(GroupsFeedPagerProtocol.b(fbInjector), (FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethodProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethodProvider.class), (FetchGroupsFeedAuthoredSoldForSalePostsIdsMethodProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FetchGroupsFeedAuthoredSoldForSalePostsIdsMethodProvider.class), (FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethodProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethodProvider.class), (GroupsFeedConsistencySyncProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsFeedConsistencySyncProvider.class), GroupsFeedController.b(fbInjector), GroupsFeedPager.b(fbInjector), ViewerStatusCache.a(fbInjector), BaseGroupsMultiRowAdapterFactory.b(fbInjector), FB4AGroupsFeedRootPartDefinitionFactory.m23506a(fbInjector), IdBasedLazy.a(fbInjector, 7008), (GroupsEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(GroupsEnvironmentProvider.class));
    }

    public final void mo973c(Bundle bundle) {
        super.mo973c(bundle);
        Class cls = GroupsYourPostsFragment.class;
        m23463a((Object) this, getContext());
        this.f22403h.a(av(), aw());
        this.ao = (FeedType) this.s.get("feed_type_arguments_key");
        this.f22396a.a(this.ao, 10, 3);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1447579148);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131237949);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1325147087, a);
    }

    public final View m23464a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        StoryInvalidaterFetchIdsMethod a;
        int a2 = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1440513635);
        View view = (ViewGroup) layoutInflater.inflate(2130904711, viewGroup, false);
        this.f22402g.a(this.f22396a, new C32541(this), 1000, 5, null);
        FeedUnitCollection feedUnitCollection = this.f22402g.c;
        GroupsFeedController groupsFeedController = this.f22401f;
        GroupsFeedPager groupsFeedPager = this.f22402g;
        GroupsFeedListType groupsFeedListType = GroupsFeedListType.a;
        groupsFeedController.a(view, groupsFeedPager, feedUnitCollection, this, this, true, null);
        C32552 c32552 = new C32552(this);
        if (au()) {
            a = this.f22397b.a(this.ao);
        } else if (ax()) {
            a = this.f22398c.a(this.ao);
        } else {
            a = this.f22399d.a(this.ao);
        }
        this.ar = this.f22400e.a(this.ao, a, feedUnitCollection, c32552);
        LogUtils.f(52268530, a2);
        return view;
    }

    public final void m23469a(boolean z, boolean z2) {
    }

    public final FeedEnvironment m23465a(BetterListView betterListView) {
        return this.an.m23223a(MenuType.NORMAL, getContext(), GroupsFeedListType.a, new C32563(this), HasScrollListenerSupportImpl.a(betterListView), null);
    }

    private void m23462a(GroupsFeedPagerProtocol groupsFeedPagerProtocol, FetchGroupsFeedAuthoredAvailableForSalePostsIdsMethodProvider fetchGroupsFeedAuthoredAvailableForSalePostsIdsMethodProvider, FetchGroupsFeedAuthoredSoldForSalePostsIdsMethodProvider fetchGroupsFeedAuthoredSoldForSalePostsIdsMethodProvider, FetchGroupsFeedAuthoredExpiredForSalePostsIdsMethodProvider fetchGroupsFeedAuthoredExpiredForSalePostsIdsMethodProvider, GroupsFeedConsistencySyncProvider groupsFeedConsistencySyncProvider, GroupsFeedController groupsFeedController, GroupsFeedPager groupsFeedPager, ViewerStatusCache viewerStatusCache, BaseGroupsMultiRowAdapterFactory baseGroupsMultiRowAdapterFactory, FB4AGroupsFeedRootPartDefinitionFactory fB4AGroupsFeedRootPartDefinitionFactory, Lazy<GroupsYourPostsGraphQLStorySelectorPartDefinition> lazy, GroupsEnvironmentProvider groupsEnvironmentProvider) {
        this.f22396a = groupsFeedPagerProtocol;
        this.f22397b = fetchGroupsFeedAuthoredAvailableForSalePostsIdsMethodProvider;
        this.f22398c = fetchGroupsFeedAuthoredSoldForSalePostsIdsMethodProvider;
        this.f22399d = fetchGroupsFeedAuthoredExpiredForSalePostsIdsMethodProvider;
        this.f22400e = groupsFeedConsistencySyncProvider;
        this.f22401f = groupsFeedController;
        this.f22402g = groupsFeedPager;
        this.f22403h = viewerStatusCache;
        this.f22404i = baseGroupsMultiRowAdapterFactory;
        this.al = fB4AGroupsFeedRootPartDefinitionFactory;
        this.am = lazy;
        this.an = groupsEnvironmentProvider;
    }

    public final MultiRowAdapter m23466a(ListItemCollection<FeedEdge> listItemCollection, FeedEnvironment feedEnvironment) {
        this.aq = this.f22404i.a(listItemCollection, this.al.m23508a(this.am, null), feedEnvironment, this.f22402g);
        return this.aq;
    }

    @Nullable
    public final FbBaseAdapter m23475l() {
        return null;
    }

    @Nullable
    public final FbBaseAdapter m23476m() {
        return null;
    }

    public final void m23474f() {
    }

    public final boolean m23470a(FbNetworkManager fbNetworkManager, GenericNotificationBanner genericNotificationBanner) {
        return false;
    }

    public final void nt_() {
        this.f22401f.h();
    }

    public final void m23467a(View view) {
        int i;
        if (au()) {
            i = 2131238014;
        } else if (ax()) {
            i = 2131238015;
        } else {
            i = 2131238016;
        }
        FbTextView fbTextView = (FbTextView) view.findViewById(2131561172);
        fbTextView.setVisibility(8);
        fbTextView.setText(jW_().getText(i));
    }

    public final void m23473e() {
        this.f22401f.i();
    }

    public final void m23471b(boolean z) {
    }

    public final void m23477r() {
    }

    public final String am_() {
        return "owner_authored_posts";
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -286106246);
        super.mY_();
        this.ar.a();
        this.f22402g.g();
        if (this.aq != null) {
            this.aq.jc_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1834871183, a);
    }

    public final void m23468a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        this.f22401f.a(str, fileDescriptor, printWriter, strArr);
    }

    private boolean au() {
        return this.ao.g.equals(Name.q);
    }

    private boolean ax() {
        return this.ao.g.equals(Name.r);
    }
}
