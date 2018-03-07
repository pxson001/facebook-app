package com.facebook.friending.center.tabs.friends;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbListFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.ListViewConnectionListener;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.log.BLog;
import com.facebook.friending.center.abtest.ExperimentsForFriendsCenterABTestModule;
import com.facebook.friending.center.connectioncontroller.FriendsCenterConnectionControllerManager;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.friending.center.fetcher.FriendsCenterFriendsFetcher;
import com.facebook.friending.center.fetcher.FriendsCenterFriendsFetcher.C28071;
import com.facebook.friending.center.logging.FriendsCenterAnalyticsLogger;
import com.facebook.friending.center.logging.FriendsCenterPerfLogger;
import com.facebook.friending.center.logging.FriendsCenterPerfLoggerProvider;
import com.facebook.friending.center.model.FriendsCenterListItemModel;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel.MutualFriendsModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchFriendsGraphQL;
import com.facebook.friending.center.protocol.FriendsCenterFetchFriendsGraphQL.FriendsCenterFetchFriendsQueryString;
import com.facebook.friending.center.ui.FriendsCenterBaseAdapter;
import com.facebook.friending.center.ui.FriendsCenterConnectionAdapter;
import com.facebook.friending.center.ui.FriendsCenterListAdapter;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Absent;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ads/hype_ad */
public class FriendsCenterFriendsFragment extends FbListFragment implements AnalyticsFragment, ScrollableListContainer {
    private static final Class<?> au = FriendsCenterFriendsFragment.class;
    public static final CallerContext av = CallerContext.a(FriendsCenterFriendsFragment.class);
    public boolean aA = false;
    private boolean aB = false;
    public FriendsCenterPerfLogger aC = null;
    public FriendsCenterPerfLogger aD = null;
    public boolean aE = false;
    private boolean aF = false;
    private boolean aG = false;
    private BetterListView aH;
    public ProgressBar aI;
    public TextView aJ;
    public ConnectionController<FriendsCenterDefaultNodeModel, Void> aK;
    public FrameRateLogger aL;
    public FriendsCenterBaseAdapter aM;
    @Inject
    Provider<FriendsCenterListAdapter> al;
    @Inject
    Provider<FriendsCenterConnectionAdapter> am;
    @Inject
    TasksManager an;
    @Inject
    FriendingEventBus ao;
    @Inject
    FbUriIntentHandler ap;
    @Inject
    FriendsCenterPerfLoggerProvider aq;
    @Inject
    FriendsCenterAnalyticsLogger ar;
    @Inject
    public FriendsCenterConnectionControllerManager as;
    @Inject
    FrameRateLoggerProvider at;
    private final OnClickListener aw = new C28121(this);
    private final FriendshipStatusChangedEventSubscriber ax = new C28132(this);
    public Map<Long, FriendsCenterListItemModel> ay;
    public FriendsCenterPerfLogger az = null;
    @Inject
    public FriendsCenterFriendsFetcher f20048i;

    /* compiled from: ads/hype_ad */
    class C28121 implements OnClickListener {
        final /* synthetic */ FriendsCenterFriendsFragment f20041a;

        C28121(FriendsCenterFriendsFragment friendsCenterFriendsFragment) {
            this.f20041a = friendsCenterFriendsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -777147314);
            this.f20041a.f20048i.f19966a = FriendsCenterFriendsFetcher.m20140d();
            FriendsCenterFriendsFragment friendsCenterFriendsFragment = this.f20041a;
            friendsCenterFriendsFragment.aI.setVisibility(0);
            friendsCenterFriendsFragment.aJ.setVisibility(8);
            friendsCenterFriendsFragment.aJ.setOnClickListener(null);
            FriendsCenterFriendsFragment.ao(this.f20041a);
            Logger.a(2, EntryType.UI_INPUT_END, -1283693700, a);
        }
    }

    /* compiled from: ads/hype_ad */
    class C28132 extends FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ FriendsCenterFriendsFragment f20042a;

        C28132(FriendsCenterFriendsFragment friendsCenterFriendsFragment) {
            this.f20042a = friendsCenterFriendsFragment;
        }

        public final void m20320b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null && friendshipStatusChangedEvent.b != null && !friendshipStatusChangedEvent.c) {
                FriendsCenterListItemModel friendsCenterListItemModel = (FriendsCenterListItemModel) this.f20042a.ay.get(Long.valueOf(friendshipStatusChangedEvent.a));
                if (friendsCenterListItemModel != null && friendsCenterListItemModel.m20179f() != friendshipStatusChangedEvent.b) {
                    friendsCenterListItemModel.m20175b(friendshipStatusChangedEvent.b);
                    AdapterDetour.a(this.f20042a.aM, 1630920159);
                }
            }
        }
    }

    /* compiled from: ads/hype_ad */
    class C28143 implements OnScrollListener {
        final /* synthetic */ FriendsCenterFriendsFragment f20043a;

        C28143(FriendsCenterFriendsFragment friendsCenterFriendsFragment) {
            this.f20043a = friendsCenterFriendsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                this.f20043a.aL.b();
            } else {
                this.f20043a.aL.a();
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (((i + i2) + 3 >= i3 ? 1 : null) != null && !this.f20043a.aM.isEmpty()) {
                FriendsCenterFriendsFragment.ao(this.f20043a);
            }
        }
    }

    /* compiled from: ads/hype_ad */
    class C28154 implements OnItemClickListener {
        final /* synthetic */ FriendsCenterFriendsFragment f20044a;

        C28154(FriendsCenterFriendsFragment friendsCenterFriendsFragment) {
            this.f20044a = friendsCenterFriendsFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            FriendsCenterFriendsFragment.m20332f(this.f20044a, i);
        }
    }

    /* compiled from: ads/hype_ad */
    public class C28165 extends ListViewConnectionListener {
        final /* synthetic */ FriendsCenterFriendsFragment f20045a;

        public C28165(FriendsCenterFriendsFragment friendsCenterFriendsFragment) {
            this.f20045a = friendsCenterFriendsFragment;
        }

        public final void m20321a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f20045a.aM.m20459a(true);
        }

        public final void m20324b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            if (!this.f20045a.aK.d().c().d) {
                this.f20045a.aM.m20459a(false);
            }
        }

        public final void m20322a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
            FriendsCenterFriendsFragment.m20328a(this.f20045a, th);
        }

        public final void m20323a(boolean z) {
            FriendsCenterFriendsFragment.as(this.f20045a);
            FriendsCenterFriendsFragment.m20329a(this.f20045a, z);
            ConnectionState d = this.f20045a.aK.d();
            Preconditions.checkState(this.f20045a.aM instanceof FriendsCenterConnectionAdapter);
            ((FriendsCenterConnectionAdapter) this.f20045a.aM).m20484a(d);
        }
    }

    /* compiled from: ads/hype_ad */
    class C28176 implements Callable<ListenableFuture<ImmutableList<FriendsCenterDefaultNodeModel>>> {
        final /* synthetic */ FriendsCenterFriendsFragment f20046a;

        C28176(FriendsCenterFriendsFragment friendsCenterFriendsFragment) {
            this.f20046a = friendsCenterFriendsFragment;
        }

        public Object call() {
            FriendsCenterFriendsFetcher friendsCenterFriendsFetcher = this.f20046a.f20048i;
            CallerContext callerContext = FriendsCenterFriendsFragment.av;
            Preconditions.checkNotNull(callerContext, "You must provide a caller context");
            FriendsCenterFetchFriendsQueryString a = FriendsCenterFetchFriendsGraphQL.m20213a();
            a.a("after_param", friendsCenterFriendsFetcher.f19966a.a()).a("first_param", String.valueOf(20)).a("order_param", FriendsCenterFriendsFetcher.f19965b);
            GraphQLRequest a2 = GraphQLRequest.a(a);
            GraphQLRequest a3 = a2.a(GraphQLCachePolicy.a).a(600);
            a3.e = ImmutableSet.of("FC_FRIENDS_QUERY");
            a3 = a3;
            a3.f = callerContext;
            a3.b = true;
            return Futures.a(friendsCenterFriendsFetcher.f19967c.a(a2), new C28071(friendsCenterFriendsFetcher), friendsCenterFriendsFetcher.f19968d);
        }
    }

    /* compiled from: ads/hype_ad */
    class C28187 extends AbstractDisposableFutureCallback<ImmutableList<FriendsCenterDefaultNodeModel>> {
        final /* synthetic */ FriendsCenterFriendsFragment f20047a;

        C28187(FriendsCenterFriendsFragment friendsCenterFriendsFragment) {
            this.f20047a = friendsCenterFriendsFragment;
        }

        protected final void m20325a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            if (!this.f20047a.f20048i.m20141a()) {
                this.f20047a.aM.m20459a(false);
            }
            FriendsCenterFriendsFragment friendsCenterFriendsFragment = this.f20047a;
            FriendsCenterFriendsFragment.as(friendsCenterFriendsFragment);
            FriendsCenterFriendsFragment.m20329a(friendsCenterFriendsFragment, friendsCenterFriendsFragment.f20048i.f19969e.booleanValue());
            if (immutableList.isEmpty()) {
                FriendsCenterFriendsFragment.ao(friendsCenterFriendsFragment);
                return;
            }
            Builder builder = new Builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                FriendsCenterDefaultNodeModel friendsCenterDefaultNodeModel = (FriendsCenterDefaultNodeModel) immutableList.get(i);
                long parseLong = Long.parseLong(friendsCenterDefaultNodeModel.m20200k());
                if (!friendsCenterFriendsFragment.ay.containsKey(Long.valueOf(parseLong))) {
                    String b;
                    int a;
                    DefaultImageFieldsModel n = friendsCenterDefaultNodeModel.m20203n();
                    MutualFriendsModel l = friendsCenterDefaultNodeModel.m20201l();
                    FriendsCenterListItemModel.Builder builder2 = new FriendsCenterListItemModel.Builder();
                    builder2.f19993a = parseLong;
                    builder2 = builder2;
                    if (n != null) {
                        b = n.b();
                    } else {
                        b = null;
                    }
                    builder2.f19994b = b;
                    FriendsCenterListItemModel.Builder builder3 = builder2;
                    builder3.f19995c = friendsCenterDefaultNodeModel.m20202m();
                    builder2 = builder3;
                    if (l != null) {
                        a = l.m20188a();
                    } else {
                        a = 0;
                    }
                    builder2.f19996d = a;
                    builder3 = builder2;
                    builder3.f19997e = FriendingLocation.FRIENDS_CENTER_FRIENDS;
                    builder3 = builder3;
                    builder3.f19998f = friendsCenterDefaultNodeModel.m20199j();
                    FriendsCenterListItemModel b2 = builder3.mo892b();
                    friendsCenterFriendsFragment.ay.put(Long.valueOf(parseLong), b2);
                    builder.c(b2);
                }
            }
            Preconditions.checkState(friendsCenterFriendsFragment.aM instanceof FriendsCenterListAdapter);
            ((FriendsCenterListAdapter) friendsCenterFriendsFragment.aM).m20488a(builder.b());
        }

        protected final void m20326a(Throwable th) {
            FriendsCenterFriendsFragment.m20328a(this.f20047a, th);
        }
    }

    public static void m20330a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendsCenterFriendsFragment) obj).m20327a(FriendsCenterFriendsFetcher.m20139b(injectorLike), IdBasedProvider.a(injectorLike, 6654), IdBasedProvider.a(injectorLike, 6653), TasksManager.b(injectorLike), FriendingEventBus.a(injectorLike), FbUriIntentHandler.a(injectorLike), (FriendsCenterPerfLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsCenterPerfLoggerProvider.class), FriendsCenterAnalyticsLogger.m20155a(injectorLike), FriendsCenterConnectionControllerManager.m20129a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class));
    }

    public final void m20337a(Bundle bundle) {
        ConnectionController a;
        int a2 = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2125650949);
        super.a(bundle);
        Class cls = FriendsCenterFriendsFragment.class;
        m20330a((Object) this, getContext());
        this.ay = Maps.c();
        this.az = this.aq.m20168a(am_(), Integer.valueOf(3080200), "FriendCenterFriendsTabTTI");
        this.aC = this.aq.m20168a(am_(), Integer.valueOf(3080204), "FriendCenterFriendsTabDiskLOAD");
        this.aD = this.aq.m20168a(am_(), Integer.valueOf(3080205), "FriendCenterFriendsTabNetworkLOAD");
        if (D() && !this.aB) {
            this.az.m20165a(false);
            this.aB = true;
        }
        FriendsCenterConnectionControllerManager friendsCenterConnectionControllerManager = this.as;
        friendsCenterConnectionControllerManager.f19960d.a();
        if (friendsCenterConnectionControllerManager.f19959c.a(ExperimentsForFriendsCenterABTestModule.f19950b, false)) {
            a = friendsCenterConnectionControllerManager.f19962f.m20126a();
        } else {
            a = null;
        }
        ConnectionController connectionController = a;
        if (connectionController == null) {
            connectionController = null;
        } else {
            connectionController.a(new C28165(this));
        }
        this.aK = connectionController;
        if (this.aK != null) {
            this.aM = (FriendsCenterBaseAdapter) this.am.get();
        } else {
            this.aM = (FriendsCenterBaseAdapter) this.al.get();
        }
        this.aL = this.at.a(Boolean.valueOf(false), "fc_friends_scroll_perf", Absent.INSTANCE);
        LogUtils.f(925591027, a2);
    }

    public final View m20336a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 489421617);
        View inflate = layoutInflater.inflate(2130904514, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1678402223, a);
        return inflate;
    }

    public final void m20338a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.aH = (BetterListView) a();
        this.aH.setAdapter(this.aM);
        this.aH.setOnScrollListener(new C28143(this));
        this.aH.setOnItemClickListener(new C28154(this));
        this.aI = (ProgressBar) e(2131562324);
        this.aJ = (TextView) e(2131562325);
        if (this.aC != null) {
            this.aC.m20165a(false);
        }
        if (this.aD != null) {
            this.aD.m20165a(false);
        }
        if (this.aK != null) {
            this.aK.a(20, null);
        } else {
            ap();
        }
    }

    public final void m20333G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1146437537);
        super.G();
        this.aG = true;
        if (D()) {
            av();
        }
        if (this.aK == null) {
            this.ao.a(this.ax);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1907591086, a);
    }

    public final void m20334H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -542664715);
        this.aG = false;
        this.aL.b();
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1684715337, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 481444425);
        if (this.aK != null) {
            FriendsCenterConnectionControllerManager friendsCenterConnectionControllerManager = this.as;
            friendsCenterConnectionControllerManager.f19960d.a();
            friendsCenterConnectionControllerManager.f19962f.m20127b();
        } else {
            this.an.c();
        }
        this.aM.m20460c();
        this.aH.setOnItemClickListener(null);
        this.aH.setOnScrollListener(null);
        this.aH = null;
        this.aI = null;
        this.aJ = null;
        super.mY_();
        LogUtils.f(1409538099, a);
    }

    public final void m20335I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1528985818);
        if (this.aF) {
            this.ar.m20157a(this.aM.f20127d);
        }
        if (this.aK == null) {
            this.ao.b(this.ax);
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1061647318, a);
    }

    public final void m20339g(boolean z) {
        boolean D = D();
        super.g(z);
        if (z) {
            av();
            this.aF = true;
        }
        if (!(D || !z || this.aB || this.az == null)) {
            this.az.m20165a(false);
            this.aB = true;
        }
        if (z && this.aA && this.az != null) {
            this.az.m20164a();
        }
    }

    public final void gB_() {
        this.aH.setSelection(0);
    }

    public final boolean gC_() {
        return this.aH.getFirstVisiblePosition() == 0;
    }

    @Nullable
    public final ScrollingViewProxy m20340n() {
        return this.aH == null ? null : new ListViewProxy(this.aH);
    }

    public final String am_() {
        return FriendsCenterTabType.FRIENDS.analyticsTag;
    }

    public static void ao(FriendsCenterFriendsFragment friendsCenterFriendsFragment) {
        if (friendsCenterFriendsFragment.aK != null) {
            ConnectionState d = friendsCenterFriendsFragment.aK.d();
            if (d.c().d) {
                friendsCenterFriendsFragment.aK.b(20, null);
            } else if (d.d() == 0) {
                friendsCenterFriendsFragment.m20331a(friendsCenterFriendsFragment.b(2131239334));
            }
        } else if (!friendsCenterFriendsFragment.an.a()) {
            if (friendsCenterFriendsFragment.f20048i.m20141a()) {
                friendsCenterFriendsFragment.ap();
            } else if (friendsCenterFriendsFragment.ay.isEmpty()) {
                friendsCenterFriendsFragment.m20331a(friendsCenterFriendsFragment.b(2131239334));
            }
        }
    }

    private void ap() {
        this.aM.m20459a(true);
        this.an.a("FETCH_FRIENDS", new C28176(this), new C28187(this));
    }

    private void m20327a(FriendsCenterFriendsFetcher friendsCenterFriendsFetcher, Provider<FriendsCenterListAdapter> provider, Provider<FriendsCenterConnectionAdapter> provider2, TasksManager tasksManager, FriendingEventBus friendingEventBus, FbUriIntentHandler fbUriIntentHandler, FriendsCenterPerfLoggerProvider friendsCenterPerfLoggerProvider, FriendsCenterAnalyticsLogger friendsCenterAnalyticsLogger, FriendsCenterConnectionControllerManager friendsCenterConnectionControllerManager, FrameRateLoggerProvider frameRateLoggerProvider) {
        this.f20048i = friendsCenterFriendsFetcher;
        this.al = provider;
        this.am = provider2;
        this.an = tasksManager;
        this.ao = friendingEventBus;
        this.ap = fbUriIntentHandler;
        this.aq = friendsCenterPerfLoggerProvider;
        this.ar = friendsCenterAnalyticsLogger;
        this.as = friendsCenterConnectionControllerManager;
        this.at = frameRateLoggerProvider;
    }

    public static void m20329a(FriendsCenterFriendsFragment friendsCenterFriendsFragment, boolean z) {
        if (!friendsCenterFriendsFragment.aE) {
            if (z) {
                if (friendsCenterFriendsFragment.aC != null) {
                    friendsCenterFriendsFragment.aC.m20167c();
                }
                if (friendsCenterFriendsFragment.aD != null) {
                    friendsCenterFriendsFragment.aD.m20164a();
                }
            } else {
                if (friendsCenterFriendsFragment.aC != null) {
                    friendsCenterFriendsFragment.aC.m20164a();
                }
                if (friendsCenterFriendsFragment.aD != null) {
                    friendsCenterFriendsFragment.aD.m20167c();
                }
            }
            friendsCenterFriendsFragment.aE = true;
        }
    }

    public static void as(FriendsCenterFriendsFragment friendsCenterFriendsFragment) {
        if (!friendsCenterFriendsFragment.aA) {
            friendsCenterFriendsFragment.aA = true;
            if (friendsCenterFriendsFragment.D() && friendsCenterFriendsFragment.az != null) {
                friendsCenterFriendsFragment.az.m20164a();
            }
        }
    }

    public static void m20328a(FriendsCenterFriendsFragment friendsCenterFriendsFragment, Throwable th) {
        if (!friendsCenterFriendsFragment.aA) {
            friendsCenterFriendsFragment.aA = true;
            if (friendsCenterFriendsFragment.D() && friendsCenterFriendsFragment.az != null) {
                friendsCenterFriendsFragment.az.m20166b();
            }
        }
        if (!friendsCenterFriendsFragment.aE) {
            if (friendsCenterFriendsFragment.aC != null) {
                friendsCenterFriendsFragment.aC.m20166b();
            }
            if (friendsCenterFriendsFragment.aD != null) {
                friendsCenterFriendsFragment.aD.m20166b();
            }
            friendsCenterFriendsFragment.aE = true;
        }
        if (friendsCenterFriendsFragment.aK != null) {
            if (friendsCenterFriendsFragment.aK.d().d() == 0) {
                friendsCenterFriendsFragment.m20331a(friendsCenterFriendsFragment.b(2131230761));
            }
        } else if (friendsCenterFriendsFragment.ay.isEmpty()) {
            friendsCenterFriendsFragment.m20331a(friendsCenterFriendsFragment.b(2131230761));
        }
        BLog.b(au, th, "Failed: %s", new Object[]{"FETCH_FRIENDS"});
    }

    private void m20331a(String str) {
        this.aI.setVisibility(8);
        this.aJ.setVisibility(0);
        this.aJ.setText(str);
        this.aJ.setOnClickListener(this.aw);
    }

    public static void m20332f(FriendsCenterFriendsFragment friendsCenterFriendsFragment, int i) {
        FriendsCenterListItemModel friendsCenterListItemModel = (FriendsCenterListItemModel) friendsCenterFriendsFragment.aM.getItem(i);
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, Long.valueOf(friendsCenterListItemModel.m20172a()));
        Bundle bundle = new Bundle();
        ModelBundle.a(bundle, String.valueOf(friendsCenterListItemModel.m20172a()), friendsCenterListItemModel.m20177d(), friendsCenterListItemModel.m20174b(), null, null);
        friendsCenterFriendsFragment.ap.a(friendsCenterFriendsFragment.getContext(), formatStrLocaleSafe, bundle);
    }

    private void av() {
        if (this.aG) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(b(2131233242));
                hasTitleBar.c(true);
                hasTitleBar.a(null);
            }
        }
    }
}
