package com.facebook.friending.center.tabs.requests;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbListFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.friending.center.FriendsCenterHomeFragment;
import com.facebook.friending.center.connectioncontroller.FriendsCenterConnectionControllerManager;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.friending.center.fetcher.FriendsCenterRequestsFetcher;
import com.facebook.friending.center.fetcher.FriendsCenterRequestsFetcher.C28091;
import com.facebook.friending.center.fetcher.FriendsCenterSuggestionsFetcher;
import com.facebook.friending.center.logging.FriendsCenterAnalyticsLogger;
import com.facebook.friending.center.logging.FriendsCenterPerfLogger;
import com.facebook.friending.center.logging.FriendsCenterPerfLoggerProvider;
import com.facebook.friending.center.model.FriendRequestModel;
import com.facebook.friending.center.model.FriendsCenterListItemModel.Builder;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel.MutualFriendsModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQL.FriendsCenterFetchRequestsQueryString;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLModels.FriendCenterRequestEdgeModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLModels.FriendCenterRequestEdgeModel.SuggestersModel;
import com.facebook.friending.center.protocol.FriendsCenterFetchRequestsGraphQLModels.FriendsCenterRequestNodeModel;
import com.facebook.friending.center.tabs.requests.items.FriendRequestItem;
import com.facebook.friending.center.tabs.requests.items.PeopleYouMayKnowItem;
import com.facebook.friending.common.list.model.FriendListItemModel;
import com.facebook.friending.common.list.model.FriendListUserCommonModel;
import com.facebook.friends.constants.FriendRequestResponseRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEventSubscriber;
import com.facebook.friends.logging.FriendRequestLogger;
import com.facebook.friends.logging.PYMKImpressionLogger;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.refreshableview.RefreshableListViewContainer;
import com.facebook.widget.refreshableview.RefreshableViewContainerLike.OnRefreshListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: admin_shop_adapter_data_provider_state_root.edited_intro_summary */
public class FriendsCenterRequestsFragment extends FbListFragment implements AnalyticsFragment, ScrollableListContainer {
    public static final CallerContext aA = CallerContext.a(FriendsCenterRequestsFragment.class);
    private static final Class<?> az = FriendsCenterRequestsFragment.class;
    private final OnClickListener aB = new C28291(this);
    private final FriendshipStatusChangedEventSubscriber aC = new C28302(this);
    private final PYMKBlacklistedEventSubscriber aD = new C28313(this);
    public final List<PeopleYouMayKnowItem> aE = new ArrayList();
    public final List<FriendRequestItem> aF = new ArrayList();
    public FriendsCenterHomeFragment aG;
    private ScrollingViewProxy aH;
    public ProgressBar aI;
    public TextView aJ;
    public RefreshableListViewContainer aK;
    public Map<Long, FriendListItemModel> aL;
    public List<FriendRequestItem> aM;
    public List<PeopleYouMayKnowItem> aN;
    public FriendsCenterPerfLogger aO = null;
    public boolean aP = false;
    private boolean aQ = false;
    private boolean aR = false;
    public String aS;
    private boolean aT = false;
    @Inject
    FbUriIntentHandler al;
    @Inject
    FriendingEventBus am;
    @Inject
    FriendsCenterAnalyticsLogger an;
    @Inject
    FriendsCenterPerfLoggerProvider ao;
    @Inject
    public FriendsCenterRequestsAdapter ap;
    @Inject
    FriendsCenterRequestsFetcher aq;
    @Inject
    FriendsCenterRequestsItemsFactory ar;
    @Inject
    public FriendsCenterSuggestionsFetcher as;
    @Inject
    GraphQLCacheManager at;
    @Inject
    FriendsCenterConnectionControllerManager au;
    @Inject
    PYMKImpressionLogger av;
    @Inject
    FriendRequestLogger aw;
    @Inject
    public TasksManager ax;
    @Inject
    ViewportMonitor ay;
    @Inject
    Clock f20087i;

    /* compiled from: admin_shop_adapter_data_provider_state_root.edited_intro_summary */
    class C28291 implements OnClickListener {
        final /* synthetic */ FriendsCenterRequestsFragment f20078a;

        C28291(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
            this.f20078a = friendsCenterRequestsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 422567445);
            this.f20078a.aq.m20146b();
            this.f20078a.as.m20153b();
            FriendsCenterRequestsFragment friendsCenterRequestsFragment = this.f20078a;
            friendsCenterRequestsFragment.aI.setVisibility(0);
            friendsCenterRequestsFragment.aJ.setVisibility(8);
            friendsCenterRequestsFragment.aJ.setOnClickListener(null);
            FriendsCenterRequestsFragment.aq(this.f20078a);
            Logger.a(2, EntryType.UI_INPUT_END, 1618344921, a);
        }
    }

    /* compiled from: admin_shop_adapter_data_provider_state_root.edited_intro_summary */
    class C28302 extends FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ FriendsCenterRequestsFragment f20079a;

        C28302(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
            this.f20079a = friendsCenterRequestsFragment;
        }

        public final void m20370b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null && friendshipStatusChangedEvent.b != null && !friendshipStatusChangedEvent.c) {
                FriendListItemModel friendListItemModel = (FriendListItemModel) this.f20079a.aL.get(Long.valueOf(friendshipStatusChangedEvent.a));
                if (friendListItemModel != null && friendListItemModel.f() != friendshipStatusChangedEvent.b) {
                    if (friendListItemModel instanceof FriendRequestModel) {
                        ((FriendRequestModel) friendListItemModel).f20012e = false;
                        if (this.f20079a.aG != null) {
                            this.f20079a.aG.aq();
                        }
                    }
                    friendListItemModel.b(friendshipStatusChangedEvent.b);
                    AdapterDetour.a(this.f20079a.ap, 1783468932);
                }
            }
        }
    }

    /* compiled from: admin_shop_adapter_data_provider_state_root.edited_intro_summary */
    class C28313 extends PYMKBlacklistedEventSubscriber {
        final /* synthetic */ FriendsCenterRequestsFragment f20080a;

        C28313(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
            this.f20080a = friendsCenterRequestsFragment;
        }

        public final void m20371b(FbEvent fbEvent) {
            PYMKBlacklistedEvent pYMKBlacklistedEvent = (PYMKBlacklistedEvent) fbEvent;
            if (pYMKBlacklistedEvent != null) {
                FriendListItemModel friendListItemModel = (FriendListItemModel) this.f20080a.aL.get(Long.valueOf(pYMKBlacklistedEvent.a));
                if (friendListItemModel != null && (friendListItemModel instanceof PeopleYouMayKnowItem)) {
                    this.f20080a.aL.remove(Long.valueOf(pYMKBlacklistedEvent.a));
                    FriendsCenterRequestsFragment friendsCenterRequestsFragment = this.f20080a;
                    long j = pYMKBlacklistedEvent.a;
                    int i = 0;
                    while (i < friendsCenterRequestsFragment.aN.size()) {
                        if (((PeopleYouMayKnowItem) friendsCenterRequestsFragment.aN.get(i)).m20172a() == j) {
                            break;
                        }
                        i++;
                    }
                    i = -1;
                    int i2 = i;
                    if (i2 != -1) {
                        boolean a = friendsCenterRequestsFragment.as.m20152a();
                        friendsCenterRequestsFragment.aN.remove(i2);
                        friendsCenterRequestsFragment.ap.m20360a(FriendsCenterRequestsItemsFactory.m20392a(friendsCenterRequestsFragment.aM, friendsCenterRequestsFragment.aN, a));
                        if (friendsCenterRequestsFragment.aL.isEmpty() && !a) {
                            FriendsCenterRequestsFragment.m20379a(friendsCenterRequestsFragment, friendsCenterRequestsFragment.b(2131233224));
                        }
                    }
                }
            }
        }
    }

    /* compiled from: admin_shop_adapter_data_provider_state_root.edited_intro_summary */
    class C28324 extends BaseViewportEventListener {
        final /* synthetic */ FriendsCenterRequestsFragment f20081a;

        C28324(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
            this.f20081a = friendsCenterRequestsFragment;
        }

        public final void m20372a(Object obj) {
            if (obj instanceof PeopleYouMayKnowItem) {
                PeopleYouMayKnowItem peopleYouMayKnowItem = (PeopleYouMayKnowItem) obj;
                if (!peopleYouMayKnowItem.f20008h) {
                    if (this.f20081a.D()) {
                        this.f20081a.av.a(peopleYouMayKnowItem.m20172a(), PeopleYouMayKnowLocation.FRIENDS_CENTER, this.f20081a.aS);
                        peopleYouMayKnowItem.m20182m();
                        return;
                    }
                    this.f20081a.aE.add(peopleYouMayKnowItem);
                }
            } else if (obj instanceof FriendRequestItem) {
                FriendRequestItem friendRequestItem = (FriendRequestItem) obj;
                if (this.f20081a.aw.a() && !friendRequestItem.f20008h) {
                    if (this.f20081a.D()) {
                        this.f20081a.aw.a(friendRequestItem.m20172a(), FriendRequestResponseRef.FRIENDS_CENTER_REQUESTS, this.f20081a.aS);
                        friendRequestItem.m20182m();
                        return;
                    }
                    this.f20081a.aF.add(friendRequestItem);
                }
            }
        }
    }

    /* compiled from: admin_shop_adapter_data_provider_state_root.edited_intro_summary */
    class C28335 extends OnRefreshListener {
        final /* synthetic */ FriendsCenterRequestsFragment f20082a;

        C28335(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
            this.f20082a = friendsCenterRequestsFragment;
        }

        public final void m20373b(boolean z) {
            if (z) {
                FriendsCenterRequestsFragment.an(this.f20082a);
                this.f20082a.aK.d();
                FriendsCenterRequestsFragment friendsCenterRequestsFragment = this.f20082a;
                friendsCenterRequestsFragment.ax.a("CLEAR_GRAPHQL_CACHE_TASK", new C28346(friendsCenterRequestsFragment), new C28357(friendsCenterRequestsFragment));
            }
        }
    }

    /* compiled from: admin_shop_adapter_data_provider_state_root.edited_intro_summary */
    public class C28346 implements Callable<ListenableFuture<Void>> {
        final /* synthetic */ FriendsCenterRequestsFragment f20083a;

        public C28346(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
            this.f20083a = friendsCenterRequestsFragment;
        }

        public Object call() {
            this.f20083a.au.m20132c();
            return this.f20083a.at.a(ImmutableSet.of("FC_REQUESTS_QUERY", "FC_SUGGESTIONS_QUERY"));
        }
    }

    /* compiled from: admin_shop_adapter_data_provider_state_root.edited_intro_summary */
    public class C28357 extends AbstractDisposableFutureCallback<Void> {
        final /* synthetic */ FriendsCenterRequestsFragment f20084a;

        public C28357(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
            this.f20084a = friendsCenterRequestsFragment;
        }

        protected final void m20374a(Object obj) {
            FriendsCenterRequestsFragment.ap(this.f20084a);
        }

        protected final void m20375a(Throwable th) {
        }
    }

    /* compiled from: admin_shop_adapter_data_provider_state_root.edited_intro_summary */
    class C28368 implements Callable<ListenableFuture<ImmutableList<FriendCenterRequestEdgeModel>>> {
        final /* synthetic */ FriendsCenterRequestsFragment f20085a;

        C28368(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
            this.f20085a = friendsCenterRequestsFragment;
        }

        public Object call() {
            FriendsCenterRequestsFetcher friendsCenterRequestsFetcher = this.f20085a.aq;
            CallerContext callerContext = FriendsCenterRequestsFragment.aA;
            Preconditions.checkNotNull(callerContext, "You must provide a caller context");
            GraphQlQueryString friendsCenterFetchRequestsQueryString = new FriendsCenterFetchRequestsQueryString();
            friendsCenterFetchRequestsQueryString.a("after_param", friendsCenterRequestsFetcher.f19974a.a()).a("first_param", String.valueOf(20));
            GraphQLRequest a = GraphQLRequest.a(friendsCenterFetchRequestsQueryString);
            GraphQLRequest a2 = a.a(GraphQLCachePolicy.a).a(600);
            a2.e = ImmutableSet.of("FC_REQUESTS_QUERY");
            a2 = a2;
            a2.f = callerContext;
            a2.b = true;
            return Futures.a(friendsCenterRequestsFetcher.f19975b.a(a), new C28091(friendsCenterRequestsFetcher), friendsCenterRequestsFetcher.f19976c);
        }
    }

    /* compiled from: admin_shop_adapter_data_provider_state_root.edited_intro_summary */
    class C28379 extends AbstractDisposableFutureCallback<ImmutableList<FriendCenterRequestEdgeModel>> {
        final /* synthetic */ FriendsCenterRequestsFragment f20086a;

        C28379(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
            this.f20086a = friendsCenterRequestsFragment;
        }

        protected final void m20376a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            this.f20086a.aK.f();
            if (!this.f20086a.aP) {
                this.f20086a.aP = true;
                if (this.f20086a.D() && this.f20086a.aO != null) {
                    this.f20086a.aO.m20164a();
                }
            }
            boolean a = this.f20086a.as.m20152a();
            if (!(this.f20086a.aq.m20145a() || a)) {
                this.f20086a.ap.m20361a(false);
            }
            if (this.f20086a.aM.isEmpty() && this.f20086a.aN.isEmpty()) {
                this.f20086a.aL.clear();
            }
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                FriendCenterRequestEdgeModel friendCenterRequestEdgeModel = (FriendCenterRequestEdgeModel) immutableList.get(i);
                FriendsCenterRequestNodeModel a2 = friendCenterRequestEdgeModel.m20244a();
                if (a2.m20271j() == GraphQLFriendshipStatus.INCOMING_REQUEST || !friendCenterRequestEdgeModel.m20246j().isEmpty()) {
                    long parseLong = Long.parseLong(a2.m20272k());
                    if (!this.f20086a.aL.containsKey(Long.valueOf(parseLong))) {
                        String b;
                        String str;
                        String a3;
                        DefaultImageFieldsModel m = a2.m20274m();
                        Builder builder = new FriendRequestItem.Builder();
                        builder.f19998f = a2.m20271j();
                        FriendRequestItem.Builder builder2 = (FriendRequestItem.Builder) builder;
                        builder2.f19993a = parseLong;
                        builder2 = builder2;
                        builder2.f19995c = a2.m20273l();
                        builder2 = builder2;
                        if (m != null) {
                            b = m.b();
                        } else {
                            b = null;
                        }
                        builder2.f19994b = b;
                        builder2 = builder2;
                        FriendsCenterRequestsFragment friendsCenterRequestsFragment = this.f20086a;
                        ImmutableList j = friendCenterRequestEdgeModel.m20246j();
                        if (j.isEmpty()) {
                            str = null;
                        } else {
                            str = ((SuggestersModel) j.get(0)).m20240a();
                        }
                        builder2.f19999a = str;
                        FriendRequestItem.Builder builder3 = builder2;
                        builder3.f19997e = FriendingLocation.FRIENDS_CENTER_REQUESTS;
                        builder3 = builder3;
                        if (a2.m20275n() != null) {
                            a3 = a2.m20275n().m20264a();
                        } else {
                            a3 = null;
                        }
                        builder3.f20000b = a3;
                        FriendRequestItem c = builder3.m20395c();
                        this.f20086a.aL.put(Long.valueOf(parseLong), c);
                        this.f20086a.aM.add(c);
                    }
                }
            }
            FriendsCenterRequestsAdapter friendsCenterRequestsAdapter = this.f20086a.ap;
            FriendsCenterRequestsItemsFactory friendsCenterRequestsItemsFactory = this.f20086a.ar;
            friendsCenterRequestsAdapter.m20360a(FriendsCenterRequestsItemsFactory.m20392a(this.f20086a.aM, this.f20086a.aN, a));
        }

        protected final void m20377a(Throwable th) {
            FriendsCenterRequestsFragment.m20380a(this.f20086a, th, "FETCH_REQUESTS");
        }
    }

    public static void m20381a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendsCenterRequestsFragment) obj).m20378a((Clock) SystemClockMethodAutoProvider.a(injectorLike), FbUriIntentHandler.a(injectorLike), FriendingEventBus.a(injectorLike), FriendsCenterAnalyticsLogger.m20155a(injectorLike), (FriendsCenterPerfLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsCenterPerfLoggerProvider.class), FriendsCenterRequestsAdapter.m20353b(injectorLike), FriendsCenterRequestsFetcher.m20143b(injectorLike), FriendsCenterRequestsItemsFactory.m20391a(injectorLike), FriendsCenterSuggestionsFetcher.m20149b(injectorLike), GraphQLCacheManager.a(injectorLike), FriendsCenterConnectionControllerManager.m20129a(injectorLike), PYMKImpressionLogger.a(injectorLike), FriendRequestLogger.a(injectorLike), TasksManager.b(injectorLike), ViewportMonitor.b(injectorLike));
    }

    public final void m20386a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 603003584);
        super.a(bundle);
        Class cls = FriendsCenterRequestsFragment.class;
        m20381a((Object) this, getContext());
        Fragment fragment = this.G;
        if (fragment instanceof FriendsCenterHomeFragment) {
            this.aG = (FriendsCenterHomeFragment) fragment;
        }
        this.ap.f20072j = this.aG;
        this.ay.a(new C28324(this));
        this.aO = this.ao.m20168a(am_(), Integer.valueOf(3080201), "FriendCenterRequestsTabTTI");
        if (D() && !this.aQ) {
            this.aO.m20165a(false);
            this.aQ = true;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1518392622, a);
    }

    public final View m20385a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1396441758);
        View inflate = layoutInflater.inflate(2130904518, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1104848330, a);
        return inflate;
    }

    public final void m20388a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.aH = new ListViewProxy((BetterListView) a());
        this.aH.a(this.ap);
        this.aH.a(new OnScrollListener(this) {
            final /* synthetic */ FriendsCenterRequestsFragment f20077a;

            {
                this.f20077a = r1;
            }

            public final void m20368a(ScrollingViewProxy scrollingViewProxy, int i) {
            }

            public final void m20369a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                if (((i + i2) + 3 >= i3 ? 1 : null) != null && !this.f20077a.ap.isEmpty()) {
                    FriendsCenterRequestsFragment.aq(this.f20077a);
                }
            }
        });
        this.aH.b(this.ay);
        this.aH.c(true);
        this.aH.k();
        this.aK = (RefreshableListViewContainer) e(2131562330);
        this.aK.setOnRefreshListener(new C28335(this));
        this.aI = (ProgressBar) e(2131562324);
        this.aJ = (TextView) e(2131562325);
        this.aL = new HashMap();
        this.aM = new ArrayList();
        this.aN = new ArrayList();
        ap(this);
    }

    public final void m20382G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -209982060);
        super.G();
        this.aT = true;
        if (D()) {
            av();
        }
        this.am.a(this.aC);
        this.am.a(this.aD);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1480900221, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1650895661);
        this.ax.c();
        FriendsCenterRequestsAdapter friendsCenterRequestsAdapter = this.ap;
        friendsCenterRequestsAdapter.f20068f.c();
        friendsCenterRequestsAdapter.f20065c.m20477a();
        this.aH.a(null);
        this.aH.a(null);
        this.aH.c(this.ay);
        this.aH = null;
        this.aI = null;
        this.aJ = null;
        this.aK = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 63951629, a);
    }

    public final void m20383H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -35646881);
        this.aT = false;
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1328496046, a);
    }

    public final void m20384I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -381774936);
        if (this.aR) {
            an(this);
        }
        this.am.b(this.aC);
        this.am.b(this.aD);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2096727120, a);
    }

    public final void m20389g(boolean z) {
        boolean D = D();
        super.g(z);
        if (z) {
            av();
            this.aR = true;
        }
        if (!D && z) {
            if (!(this.aQ || this.aO == null)) {
                this.aO.m20165a(false);
                this.aQ = true;
            }
            for (PeopleYouMayKnowItem peopleYouMayKnowItem : this.aE) {
                this.av.a(peopleYouMayKnowItem.m20172a(), PeopleYouMayKnowLocation.FRIENDS_CENTER, this.aS);
                peopleYouMayKnowItem.m20182m();
            }
            this.aE.clear();
            for (FriendRequestItem friendRequestItem : this.aF) {
                this.aw.a(friendRequestItem.m20172a(), FriendRequestResponseRef.FRIENDS_CENTER_REQUESTS, this.aS);
                friendRequestItem.m20182m();
            }
            this.aF.clear();
        }
        if (z && this.aP && this.aO != null) {
            this.aO.m20164a();
        }
    }

    public final void m20387a(View view, int i) {
        FriendListUserCommonModel friendListUserCommonModel = (FriendListUserCommonModel) this.ap.getItem(i);
        Bundle bundle = new Bundle();
        ModelBundle.a(bundle, String.valueOf(friendListUserCommonModel.a()), friendListUserCommonModel.d(), friendListUserCommonModel.b(), null, null);
        this.al.a(getContext(), StringFormatUtil.a(FBLinks.aX, new Object[]{Long.valueOf(friendListUserCommonModel.a())}), bundle);
    }

    public final void gB_() {
        this.aH.h(0);
    }

    public final boolean gC_() {
        return this.aH.q() == 0;
    }

    @Nullable
    public final ScrollingViewProxy m20390n() {
        return this.aH;
    }

    public final String am_() {
        return FriendsCenterTabType.REQUESTS.analyticsTag;
    }

    public static void an(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
        int size = friendsCenterRequestsFragment.aM.size();
        int i = friendsCenterRequestsFragment.ap.f20074l;
        int i2 = (i - size) - 1;
        FriendsCenterAnalyticsLogger friendsCenterAnalyticsLogger = friendsCenterRequestsFragment.an;
        if (size > i) {
            size = i - 1;
        }
        if (i2 <= 0) {
            i2 = 0;
        }
        friendsCenterAnalyticsLogger.m20158a(size, i2);
    }

    private void m20378a(Clock clock, FbUriIntentHandler fbUriIntentHandler, FriendingEventBus friendingEventBus, FriendsCenterAnalyticsLogger friendsCenterAnalyticsLogger, FriendsCenterPerfLoggerProvider friendsCenterPerfLoggerProvider, FriendsCenterRequestsAdapter friendsCenterRequestsAdapter, FriendsCenterRequestsFetcher friendsCenterRequestsFetcher, FriendsCenterRequestsItemsFactory friendsCenterRequestsItemsFactory, FriendsCenterSuggestionsFetcher friendsCenterSuggestionsFetcher, GraphQLCacheManager graphQLCacheManager, FriendsCenterConnectionControllerManager friendsCenterConnectionControllerManager, PYMKImpressionLogger pYMKImpressionLogger, FriendRequestLogger friendRequestLogger, TasksManager tasksManager, ViewportMonitor viewportMonitor) {
        this.f20087i = clock;
        this.al = fbUriIntentHandler;
        this.am = friendingEventBus;
        this.an = friendsCenterAnalyticsLogger;
        this.ao = friendsCenterPerfLoggerProvider;
        this.ap = friendsCenterRequestsAdapter;
        this.aq = friendsCenterRequestsFetcher;
        this.ar = friendsCenterRequestsItemsFactory;
        this.as = friendsCenterSuggestionsFetcher;
        this.at = graphQLCacheManager;
        this.au = friendsCenterConnectionControllerManager;
        this.av = pYMKImpressionLogger;
        this.aw = friendRequestLogger;
        this.ax = tasksManager;
        this.ay = viewportMonitor;
    }

    public static void ap(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
        friendsCenterRequestsFragment.aS = String.valueOf(friendsCenterRequestsFragment.f20087i.a());
        if (friendsCenterRequestsFragment.aG != null) {
            friendsCenterRequestsFragment.aG.aq();
        }
        friendsCenterRequestsFragment.ax.c();
        friendsCenterRequestsFragment.aq.m20146b();
        friendsCenterRequestsFragment.as.m20153b();
        friendsCenterRequestsFragment.aM.clear();
        friendsCenterRequestsFragment.aN.clear();
        friendsCenterRequestsFragment.ar();
    }

    public static void aq(FriendsCenterRequestsFragment friendsCenterRequestsFragment) {
        if (!friendsCenterRequestsFragment.ax.a()) {
            if (friendsCenterRequestsFragment.aq.m20145a()) {
                friendsCenterRequestsFragment.ar();
            } else if (friendsCenterRequestsFragment.as.m20152a()) {
                friendsCenterRequestsFragment.ap.m20361a(true);
                friendsCenterRequestsFragment.ax.a("FETCH_PYMK", new Callable<ListenableFuture<ImmutableList<FriendsCenterDefaultNodeModel>>>(friendsCenterRequestsFragment) {
                    final /* synthetic */ FriendsCenterRequestsFragment f20075a;

                    {
                        this.f20075a = r1;
                    }

                    public Object call() {
                        return this.f20075a.as.m20151a(FriendsCenterRequestsFragment.aA, 20, FriendingLocation.FRIENDS_CENTER_REQUESTS_PYMK.peopleYouMayKnowLocation);
                    }
                }, new AbstractDisposableFutureCallback<ImmutableList<FriendsCenterDefaultNodeModel>>(friendsCenterRequestsFragment) {
                    final /* synthetic */ FriendsCenterRequestsFragment f20076a;

                    {
                        this.f20076a = r1;
                    }

                    protected final void m20366a(Object obj) {
                        ImmutableList immutableList = (ImmutableList) obj;
                        this.f20076a.aK.f();
                        boolean a = this.f20076a.as.m20152a();
                        if (!a) {
                            this.f20076a.ap.m20361a(false);
                            if (this.f20076a.aL.isEmpty() && immutableList.isEmpty()) {
                                FriendsCenterRequestsFragment.m20379a(this.f20076a, this.f20076a.b(2131233224));
                            }
                        }
                        int size = immutableList.size();
                        for (int i = 0; i < size; i++) {
                            FriendsCenterDefaultNodeModel friendsCenterDefaultNodeModel = (FriendsCenterDefaultNodeModel) immutableList.get(i);
                            long parseLong = Long.parseLong(friendsCenterDefaultNodeModel.m20200k());
                            if (!this.f20076a.aL.containsKey(Long.valueOf(parseLong))) {
                                int a2;
                                String b;
                                DefaultImageFieldsModel n = friendsCenterDefaultNodeModel.m20203n();
                                MutualFriendsModel l = friendsCenterDefaultNodeModel.m20201l();
                                Builder builder = new PeopleYouMayKnowItem.Builder();
                                builder.f19998f = friendsCenterDefaultNodeModel.m20199j();
                                PeopleYouMayKnowItem.Builder builder2 = (PeopleYouMayKnowItem.Builder) builder;
                                builder2.f19993a = parseLong;
                                builder2 = builder2;
                                if (l != null) {
                                    a2 = l.m20188a();
                                } else {
                                    a2 = 0;
                                }
                                builder2.f19996d = a2;
                                builder2 = builder2;
                                builder2.f19995c = friendsCenterDefaultNodeModel.m20202m();
                                PeopleYouMayKnowItem.Builder builder3 = builder2;
                                if (n != null) {
                                    b = n.b();
                                } else {
                                    b = null;
                                }
                                builder3.f19994b = b;
                                builder3 = builder3;
                                builder3.f19997e = FriendingLocation.FRIENDS_CENTER_REQUESTS_PYMK;
                                PeopleYouMayKnowItem a3 = builder3.m20406a();
                                this.f20076a.aL.put(Long.valueOf(parseLong), a3);
                                this.f20076a.aN.add(a3);
                            }
                        }
                        FriendsCenterRequestsAdapter friendsCenterRequestsAdapter = this.f20076a.ap;
                        FriendsCenterRequestsItemsFactory friendsCenterRequestsItemsFactory = this.f20076a.ar;
                        friendsCenterRequestsAdapter.m20360a(FriendsCenterRequestsItemsFactory.m20392a(this.f20076a.aM, this.f20076a.aN, a));
                    }

                    protected final void m20367a(Throwable th) {
                        FriendsCenterRequestsFragment.m20380a(this.f20076a, th, "FETCH_PYMK");
                    }
                });
            }
        }
    }

    private void ar() {
        this.ap.m20361a(true);
        this.ax.a("FETCH_REQUESTS", new C28368(this), new C28379(this));
    }

    public static void m20380a(FriendsCenterRequestsFragment friendsCenterRequestsFragment, Throwable th, String str) {
        friendsCenterRequestsFragment.aK.g();
        friendsCenterRequestsFragment.ap.m20361a(false);
        if (friendsCenterRequestsFragment.aL.isEmpty()) {
            m20379a(friendsCenterRequestsFragment, friendsCenterRequestsFragment.b(2131230761));
            FriendsCenterRequestsAdapter friendsCenterRequestsAdapter = friendsCenterRequestsFragment.ap;
            friendsCenterRequestsAdapter.f20069g.clear();
            AdapterDetour.a(friendsCenterRequestsAdapter, 1962166567);
        }
        BLog.b(az, th, "Failed: %s", new Object[]{str});
    }

    public static void m20379a(FriendsCenterRequestsFragment friendsCenterRequestsFragment, String str) {
        friendsCenterRequestsFragment.aI.setVisibility(8);
        friendsCenterRequestsFragment.aJ.setVisibility(0);
        friendsCenterRequestsFragment.aJ.setText(str);
        friendsCenterRequestsFragment.aJ.setOnClickListener(friendsCenterRequestsFragment.aB);
    }

    private void av() {
        if (this.aT) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(b(2131233242));
                hasTitleBar.c(true);
                hasTitleBar.a(null);
            }
        }
    }
}
