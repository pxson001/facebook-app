package com.facebook.friending.center;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator.OnTabClickListener;
import com.facebook.friending.center.abtest.FriendsCenterGateKeepers;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.friending.center.fetcher.FriendsCenterRequestsBadgeFetcher;
import com.facebook.friending.center.fetcher.FriendsCenterRequestsBadgeFetcher.C28081;
import com.facebook.friending.center.logging.FriendsCenterAnalyticsLogger;
import com.facebook.friends.protocol.FetchFriendRequestJewelCountGraphQL;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.listview.ScrollableListContainer;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import javax.inject.Provider;

/* compiled from: allowed_networks */
public class FriendsCenterHomeFragment extends FbFragment implements AnalyticsFragment {
    private static final CallerContext f19934g = CallerContext.a(FriendsCenterHomeFragment.class);
    @Inject
    public volatile Provider<RTLUtil> f19935a = UltralightRuntime.a;
    public ImmutableList<FriendsCenterTabType> al;
    @Inject
    private TasksManager am;
    @Inject
    private FriendsCenterRequestsBadgeFetcher an;
    @Inject
    public FriendsCenterAnalyticsLogger ao;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<PerformanceLogger> ap = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<NavigationLogger> aq = UltralightRuntime.b;
    @Inject
    private FriendsCenterBadgePagerAdapterProvider ar;
    @Inject
    private FriendsCenterHomeStatePagerAdapterProvider as;
    public FriendsCenterBadgePagerAdapter at;
    public PagerAdapter au;
    public boolean av = false;
    @Inject
    public volatile Provider<GraphQLCacheManager> f19936b = UltralightRuntime.a;
    @Inject
    public volatile Provider<JewelCounters> f19937c = UltralightRuntime.a;
    @Inject
    volatile Provider<FriendsCenterGateKeepers> f19938d = UltralightRuntime.a;
    @Inject
    volatile Provider<RuntimePermissionsUtil> f19939e = UltralightRuntime.a;
    @Inject
    volatile Provider<ContactUploadStatusHelper> f19940f = UltralightRuntime.a;
    public ViewPager f19941h;
    public FriendsCenterTabType f19942i;

    /* compiled from: allowed_networks */
    class C28031 implements OnTabClickListener {
        final /* synthetic */ FriendsCenterHomeFragment f19931a;

        C28031(FriendsCenterHomeFragment friendsCenterHomeFragment) {
            this.f19931a = friendsCenterHomeFragment;
        }

        public final void m20107a(int i, int i2) {
            if (i == i2) {
                Fragment fragment = (Fragment) ((FriendsCenterHomeStatePagerAdapter) this.f19931a.au).f19947d.get(i);
                if (fragment instanceof ScrollableListContainer) {
                    ((ScrollableListContainer) fragment).gB_();
                }
            }
        }
    }

    /* compiled from: allowed_networks */
    class C28042 implements OnPageChangeListener {
        final /* synthetic */ FriendsCenterHomeFragment f19932a;

        C28042(FriendsCenterHomeFragment friendsCenterHomeFragment) {
            this.f19932a = friendsCenterHomeFragment;
        }

        public final void m20108a(int i, float f, int i2) {
        }

        public final void e_(int i) {
            if (this.f19932a.av) {
                this.f19932a.ao.m20159a(((FriendsCenterTabType) this.f19932a.al.get(i)).analyticsTag.toString());
            }
            this.f19932a.av = true;
            ((PerformanceLogger) this.f19932a.ap.get()).a(((FriendsCenterTabType) this.f19932a.al.get(i)).analyticsTag);
            ((NavigationLogger) this.f19932a.aq.get()).a(this.f19932a, null);
        }

        public final void m20109b(int i) {
        }
    }

    /* compiled from: allowed_networks */
    class C28053 extends AbstractDisposableFutureCallback<Integer> {
        final /* synthetic */ FriendsCenterHomeFragment f19933a;

        C28053(FriendsCenterHomeFragment friendsCenterHomeFragment) {
            this.f19933a = friendsCenterHomeFragment;
        }

        protected final void m20110a(Object obj) {
            this.f19933a.at.m20106c(((Integer) obj).intValue());
        }

        protected final void m20111a(Throwable th) {
        }
    }

    /* compiled from: allowed_networks */
    enum Tasks {
        FETCH_REQUESTS_BADGE
    }

    public static void m20112a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendsCenterHomeFragment) obj).m20113a(IdBasedSingletonScopeProvider.a(injectorLike, 552), IdBasedSingletonScopeProvider.a(injectorLike, 2179), IdBasedSingletonScopeProvider.a(injectorLike, 2793), IdBasedProvider.a(injectorLike, 6641), IdBasedProvider.a(injectorLike, 3364), IdBasedProvider.a(injectorLike, 962), TasksManager.b(injectorLike), FriendsCenterRequestsBadgeFetcher.m20142b(injectorLike), FriendsCenterAnalyticsLogger.m20155a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2952), IdBasedSingletonScopeProvider.b(injectorLike, 137), (FriendsCenterBadgePagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsCenterBadgePagerAdapterProvider.class), (FriendsCenterHomeStatePagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsCenterHomeStatePagerAdapterProvider.class));
    }

    public final void m20118c(Bundle bundle) {
        boolean z;
        ImmutableList reverse;
        super.c(bundle);
        Class cls = FriendsCenterHomeFragment.class;
        m20112a((Object) this, getContext());
        this.f19942i = FriendsCenterTabType.fromString(this.s.getString("fc_tab"));
        this.ao.m20160a(this.f19942i.name(), this.s.getString("source_ref"));
        RuntimePermissionsUtil runtimePermissionsUtil = (RuntimePermissionsUtil) this.f19939e.get();
        FriendsCenterGateKeepers friendsCenterGateKeepers = (FriendsCenterGateKeepers) this.f19938d.get();
        if (((ContactUploadStatusHelper) this.f19940f.get()).a() && runtimePermissionsUtil.a("android.permission.READ_CONTACTS") && friendsCenterGateKeepers.f19952a.a(624, false)) {
            z = true;
        } else {
            z = false;
        }
        Builder builder = ImmutableList.builder();
        builder.b(new FriendsCenterTabType[]{FriendsCenterTabType.SUGGESTIONS, FriendsCenterTabType.SEARCH, FriendsCenterTabType.REQUESTS, FriendsCenterTabType.CONTACTS});
        if (z) {
            builder.c(FriendsCenterTabType.INVITES);
        }
        builder.c(FriendsCenterTabType.FRIENDS);
        if (((RTLUtil) this.f19935a.get()).a()) {
            reverse = builder.b().reverse();
        } else {
            reverse = builder.b();
        }
        this.al = reverse;
        this.at = new FriendsCenterBadgePagerAdapter(getContext(), this.al);
        this.au = FriendsCenterHomeStatePagerAdapterProvider.m20123a(s(), getContext(), this.at, this.al, z);
        aq();
        if (((JewelCounters) this.f19937c.get()).a(Jewel.FRIEND_REQUESTS) > 0) {
            ((GraphQLCacheManager) this.f19936b.get()).a(ImmutableSet.of("FC_REQUESTS_QUERY"));
        }
    }

    public final View m20116a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -682455759);
        View inflate = layoutInflater.inflate(2130904515, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1615616883, a);
        return inflate;
    }

    public final void m20117a(View view, Bundle bundle) {
        boolean z = true;
        super.a(view, bundle);
        this.f19941h = (ViewPager) e(2131562328);
        boolean z2 = bundle != null;
        ViewPager viewPager = this.f19941h;
        if (z2) {
            z = false;
        }
        viewPager.setOnlyCreatePagesImmediatelyOffscreen(z);
        this.f19941h.setOffscreenPageLimit(this.au.b() - 1);
        this.f19941h.setAdapter(this.au);
        TabbedViewPagerIndicator tabbedViewPagerIndicator = (TabbedViewPagerIndicator) e(2131562327);
        tabbedViewPagerIndicator.setViewPager(this.f19941h);
        tabbedViewPagerIndicator.m = new C28031(this);
        tabbedViewPagerIndicator.l = new C28042(this);
        int i = 0;
        while (i < this.al.size()) {
            if (this.al.get(i) != this.f19942i) {
                i++;
            } else if (i == 0) {
                this.av = true;
                return;
            } else {
                this.f19941h.setCurrentItem(i);
                return;
            }
        }
    }

    public final void m20114H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 408655461);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1922380387, a);
    }

    public final void m20115I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1657463055);
        this.am.c();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1886728784, a);
    }

    public final void m20119e() {
        FriendsCenterBadgePagerAdapter friendsCenterBadgePagerAdapter = this.at;
        friendsCenterBadgePagerAdapter.m20106c(friendsCenterBadgePagerAdapter.f19930c - 1);
    }

    public final void aq() {
        TasksManager tasksManager = this.am;
        String name = Tasks.FETCH_REQUESTS_BADGE.name();
        FriendsCenterRequestsBadgeFetcher friendsCenterRequestsBadgeFetcher = this.an;
        CallerContext callerContext = f19934g;
        Preconditions.checkNotNull(callerContext, "You must provide a caller context");
        GraphQLRequest a = GraphQLRequest.a(FetchFriendRequestJewelCountGraphQL.a());
        a.f = callerContext;
        tasksManager.a(name, Futures.a(friendsCenterRequestsBadgeFetcher.f19971a.a(a), new C28081(friendsCenterRequestsBadgeFetcher), friendsCenterRequestsBadgeFetcher.f19972b), new C28053(this));
    }

    private void m20113a(Provider<RTLUtil> provider, Provider<GraphQLCacheManager> provider2, Provider<JewelCounters> provider3, Provider<FriendsCenterGateKeepers> provider4, Provider<RuntimePermissionsUtil> provider5, Provider<ContactUploadStatusHelper> provider6, TasksManager tasksManager, FriendsCenterRequestsBadgeFetcher friendsCenterRequestsBadgeFetcher, FriendsCenterAnalyticsLogger friendsCenterAnalyticsLogger, com.facebook.inject.Lazy<PerformanceLogger> lazy, com.facebook.inject.Lazy<NavigationLogger> lazy2, FriendsCenterBadgePagerAdapterProvider friendsCenterBadgePagerAdapterProvider, FriendsCenterHomeStatePagerAdapterProvider friendsCenterHomeStatePagerAdapterProvider) {
        this.f19935a = provider;
        this.f19936b = provider2;
        this.f19937c = provider3;
        this.f19938d = provider4;
        this.f19939e = provider5;
        this.f19940f = provider6;
        this.am = tasksManager;
        this.an = friendsCenterRequestsBadgeFetcher;
        this.ao = friendsCenterAnalyticsLogger;
        this.ap = lazy;
        this.aq = lazy2;
        this.ar = friendsCenterBadgePagerAdapterProvider;
        this.as = friendsCenterHomeStatePagerAdapterProvider;
    }

    public final String am_() {
        return ((FriendsCenterTabType) this.al.get(this.f19941h.k)).analyticsTag;
    }
}
