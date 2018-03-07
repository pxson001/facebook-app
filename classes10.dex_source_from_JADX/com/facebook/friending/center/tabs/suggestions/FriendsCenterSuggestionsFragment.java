package com.facebook.friending.center.tabs.suggestions;

import android.content.Context;
import android.os.Bundle;
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
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.ListViewConnectionListener;
import com.facebook.debug.log.BLog;
import com.facebook.friending.center.connectioncontroller.FriendsCenterConnectionControllerManager;
import com.facebook.friending.center.constants.FriendsCenterTabType;
import com.facebook.friending.center.fetcher.FriendsCenterSuggestionsFetcher;
import com.facebook.friending.center.logging.FriendsCenterAnalyticsLogger;
import com.facebook.friending.center.logging.FriendsCenterPerfLogger;
import com.facebook.friending.center.logging.FriendsCenterPerfLoggerProvider;
import com.facebook.friending.center.model.FriendsCenterListItemModel;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel.MutualFriendsModel;
import com.facebook.friending.center.ui.FriendsCenterBaseAdapter;
import com.facebook.friending.center.ui.FriendsCenterBaseAdapter.C28581;
import com.facebook.friending.center.ui.FriendsCenterConnectionAdapter;
import com.facebook.friending.center.ui.FriendsCenterListAdapter;
import com.facebook.friending.common.list.model.FriendListItemModel;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEventSubscriber;
import com.facebook.friends.logging.PYMKImpressionLogger;
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
import com.facebook.widget.listview.ScrollingViewProxy.OnItemClickListener;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: add_services */
public class FriendsCenterSuggestionsFragment extends FbListFragment implements AnalyticsFragment, ScrollableListContainer {
    private static final Class<?> aw = FriendsCenterSuggestionsFragment.class;
    public static final CallerContext ax = CallerContext.a(FriendsCenterSuggestionsFragment.class);
    private final PYMKBlacklistedEventSubscriber aA = new C28513(this);
    public final List<FriendsCenterListItemModel> aB = new ArrayList();
    public Map<Long, FriendListItemModel> aC;
    private FriendsCenterPerfLogger aD = null;
    private boolean aE = false;
    private boolean aF = false;
    private boolean aG = false;
    public String aH;
    private boolean aI = false;
    private ScrollingViewProxy aJ;
    public ProgressBar aK;
    public TextView aL;
    public ConnectionController<FriendsCenterDefaultNodeModel, Void> aM;
    public FriendsCenterBaseAdapter aN;
    @Inject
    public FbUriIntentHandler al;
    @Inject
    FriendingEventBus am;
    @Inject
    FriendsCenterAnalyticsLogger an;
    @Inject
    Provider<FriendsCenterListAdapter> ao;
    @Inject
    Provider<FriendsCenterConnectionAdapter> ap;
    @Inject
    FriendsCenterPerfLoggerProvider aq;
    @Inject
    FriendsCenterSuggestionsFetcher ar;
    @Inject
    PYMKImpressionLogger as;
    @Inject
    TasksManager at;
    @Inject
    ViewportMonitor au;
    @Inject
    public FriendsCenterConnectionControllerManager av;
    private final OnClickListener ay = new C28481(this);
    private final FriendshipStatusChangedEventSubscriber az = new C28492(this);
    @Inject
    Clock f20121i;

    /* compiled from: add_services */
    class C28481 implements OnClickListener {
        final /* synthetic */ FriendsCenterSuggestionsFragment f20110a;

        C28481(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
            this.f20110a = friendsCenterSuggestionsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -428789701);
            this.f20110a.ar.m20153b();
            FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment = this.f20110a;
            friendsCenterSuggestionsFragment.aK.setVisibility(0);
            friendsCenterSuggestionsFragment.aL.setVisibility(8);
            friendsCenterSuggestionsFragment.aL.setOnClickListener(null);
            FriendsCenterSuggestionsFragment.ao(this.f20110a);
            Logger.a(2, EntryType.UI_INPUT_END, 426223567, a);
        }
    }

    /* compiled from: add_services */
    class C28492 extends FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ FriendsCenterSuggestionsFragment f20111a;

        C28492(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
            this.f20111a = friendsCenterSuggestionsFragment;
        }

        public final void m20429b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null && friendshipStatusChangedEvent.b != null && !friendshipStatusChangedEvent.c) {
                FriendListItemModel friendListItemModel = (FriendListItemModel) this.f20111a.aC.get(Long.valueOf(friendshipStatusChangedEvent.a));
                if (friendListItemModel != null && friendListItemModel.f() != friendshipStatusChangedEvent.b) {
                    friendListItemModel.b(friendshipStatusChangedEvent.b);
                    AdapterDetour.a(this.f20111a.aN, -633183841);
                }
            }
        }
    }

    /* compiled from: add_services */
    class C28513 extends PYMKBlacklistedEventSubscriber {
        final /* synthetic */ FriendsCenterSuggestionsFragment f20114a;

        C28513(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
            this.f20114a = friendsCenterSuggestionsFragment;
        }

        public final void m20430b(FbEvent fbEvent) {
            final PYMKBlacklistedEvent pYMKBlacklistedEvent = (PYMKBlacklistedEvent) fbEvent;
            if (pYMKBlacklistedEvent != null) {
                if (this.f20114a.aM != null) {
                    this.f20114a.aM.a(Long.toString(pYMKBlacklistedEvent.a), new Predicate<FriendsCenterDefaultNodeModel>(this) {
                        final /* synthetic */ C28513 f20113b;

                        public boolean apply(Object obj) {
                            return Long.parseLong(((FriendsCenterDefaultNodeModel) obj).m20200k()) == pYMKBlacklistedEvent.a;
                        }
                    });
                } else if (this.f20114a.aC.get(Long.valueOf(pYMKBlacklistedEvent.a)) != null) {
                    this.f20114a.aC.remove(Long.valueOf(pYMKBlacklistedEvent.a));
                    Preconditions.checkState(this.f20114a.aN instanceof FriendsCenterListAdapter);
                    FriendsCenterListAdapter friendsCenterListAdapter = (FriendsCenterListAdapter) this.f20114a.aN;
                    int a = friendsCenterListAdapter.mo899a(pYMKBlacklistedEvent.a);
                    if (a != -1) {
                        friendsCenterListAdapter.f20172c.remove(a);
                        AdapterDetour.a(friendsCenterListAdapter, -2143686744);
                    }
                } else {
                    return;
                }
                FriendsCenterSuggestionsFragment.at(this.f20114a);
            }
        }
    }

    /* compiled from: add_services */
    class C28524 extends BaseViewportEventListener {
        final /* synthetic */ FriendsCenterSuggestionsFragment f20115a;

        C28524(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
            this.f20115a = friendsCenterSuggestionsFragment;
        }

        public final void m20431a(Object obj) {
            if (obj instanceof FriendsCenterListItemModel) {
                FriendsCenterListItemModel friendsCenterListItemModel = (FriendsCenterListItemModel) obj;
                if (!friendsCenterListItemModel.f20008h) {
                    if (this.f20115a.D()) {
                        this.f20115a.as.a(friendsCenterListItemModel.m20172a(), PeopleYouMayKnowLocation.FRIENDS_CENTER, this.f20115a.aH);
                        friendsCenterListItemModel.m20182m();
                        return;
                    }
                    this.f20115a.aB.add(friendsCenterListItemModel);
                }
            }
        }
    }

    /* compiled from: add_services */
    class C28535 implements OnScrollListener {
        final /* synthetic */ FriendsCenterSuggestionsFragment f20116a;

        C28535(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
            this.f20116a = friendsCenterSuggestionsFragment;
        }

        public final void m20432a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m20433a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            if (((i + i2) + 3 >= i3 ? 1 : null) != null && !this.f20116a.aN.isEmpty()) {
                FriendsCenterSuggestionsFragment.ao(this.f20116a);
            }
        }
    }

    /* compiled from: add_services */
    class C28546 implements OnItemClickListener {
        final /* synthetic */ FriendsCenterSuggestionsFragment f20117a;

        C28546(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
            this.f20117a = friendsCenterSuggestionsFragment;
        }

        public final void m20434a(int i) {
            FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment = this.f20117a;
            FriendsCenterListItemModel friendsCenterListItemModel = (FriendsCenterListItemModel) friendsCenterSuggestionsFragment.aN.getItem(i);
            String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, Long.valueOf(friendsCenterListItemModel.m20172a()));
            Bundle bundle = new Bundle();
            bundle.putSerializable("timeline_friend_request_ref", FriendRequestMakeRef.FRIENDS_CENTER);
            ModelBundle.a(bundle, String.valueOf(friendsCenterListItemModel.m20172a()), friendsCenterListItemModel.m20177d(), friendsCenterListItemModel.m20174b(), null, null);
            friendsCenterSuggestionsFragment.al.a(friendsCenterSuggestionsFragment.getContext(), formatStrLocaleSafe, bundle);
        }
    }

    /* compiled from: add_services */
    public class C28557 extends ListViewConnectionListener {
        final /* synthetic */ FriendsCenterSuggestionsFragment f20118a;

        public C28557(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
            this.f20118a = friendsCenterSuggestionsFragment;
        }

        public final void m20435a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f20118a.aN.m20459a(true);
        }

        public final void m20438b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f20118a.aN.m20459a(false);
        }

        public final void m20436a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
            FriendsCenterSuggestionsFragment.m20442a(this.f20118a, th);
        }

        public final void m20437a(boolean z) {
            FriendsCenterSuggestionsFragment.aq(this.f20118a);
            ConnectionState d = this.f20118a.aM.d();
            Preconditions.checkState(this.f20118a.aN instanceof FriendsCenterConnectionAdapter);
            ((FriendsCenterConnectionAdapter) this.f20118a.aN).m20484a(d);
        }
    }

    /* compiled from: add_services */
    class C28568 implements Callable<ListenableFuture<ImmutableList<FriendsCenterDefaultNodeModel>>> {
        final /* synthetic */ FriendsCenterSuggestionsFragment f20119a;

        C28568(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
            this.f20119a = friendsCenterSuggestionsFragment;
        }

        public Object call() {
            return this.f20119a.ar.m20151a(FriendsCenterSuggestionsFragment.ax, 20, FriendingLocation.FRIENDS_CENTER_SUGGESTIONS.peopleYouMayKnowLocation);
        }
    }

    /* compiled from: add_services */
    class C28579 extends AbstractDisposableFutureCallback<ImmutableList<FriendsCenterDefaultNodeModel>> {
        final /* synthetic */ FriendsCenterSuggestionsFragment f20120a;

        C28579(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
            this.f20120a = friendsCenterSuggestionsFragment;
        }

        protected final void m20439a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            FriendsCenterSuggestionsFragment.aq(this.f20120a);
            if (!this.f20120a.ar.m20152a()) {
                this.f20120a.aN.m20459a(false);
            }
            if (immutableList.isEmpty()) {
                FriendsCenterSuggestionsFragment.ao(this.f20120a);
                return;
            }
            Builder builder = new Builder();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                FriendsCenterDefaultNodeModel friendsCenterDefaultNodeModel = (FriendsCenterDefaultNodeModel) immutableList.get(i);
                long parseLong = Long.parseLong(friendsCenterDefaultNodeModel.m20200k());
                if (!this.f20120a.aC.containsKey(Long.valueOf(parseLong))) {
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
                    builder3.f19997e = FriendingLocation.FRIENDS_CENTER_SUGGESTIONS;
                    builder3 = builder3;
                    builder3.f19998f = friendsCenterDefaultNodeModel.m20199j();
                    FriendsCenterListItemModel b2 = builder3.mo892b();
                    this.f20120a.aC.put(Long.valueOf(parseLong), b2);
                    builder.c(b2);
                }
            }
            Preconditions.checkState(this.f20120a.aN instanceof FriendsCenterListAdapter);
            ((FriendsCenterListAdapter) this.f20120a.aN).m20488a(builder.b());
        }

        protected final void m20440a(Throwable th) {
            FriendsCenterSuggestionsFragment.m20442a(this.f20120a, th);
        }
    }

    public static void m20443a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendsCenterSuggestionsFragment) obj).m20441a((Clock) SystemClockMethodAutoProvider.a(injectorLike), FbUriIntentHandler.a(injectorLike), FriendingEventBus.a(injectorLike), FriendsCenterAnalyticsLogger.m20155a(injectorLike), IdBasedProvider.a(injectorLike, 6654), IdBasedProvider.a(injectorLike, 6653), (FriendsCenterPerfLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsCenterPerfLoggerProvider.class), FriendsCenterSuggestionsFetcher.m20149b(injectorLike), PYMKImpressionLogger.a(injectorLike), TasksManager.b(injectorLike), ViewportMonitor.b(injectorLike), FriendsCenterConnectionControllerManager.m20129a(injectorLike));
    }

    public final void m20449a(Bundle bundle) {
        ConnectionController a;
        int a2 = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 926538742);
        super.a(bundle);
        Class cls = FriendsCenterSuggestionsFragment.class;
        m20443a((Object) this, getContext());
        this.aC = new HashMap();
        FriendsCenterConnectionControllerManager friendsCenterConnectionControllerManager = this.av;
        friendsCenterConnectionControllerManager.f19960d.a();
        if (friendsCenterConnectionControllerManager.f19958b.m20125b()) {
            a = friendsCenterConnectionControllerManager.f19961e.m20126a();
        } else {
            a = null;
        }
        ConnectionController connectionController = a;
        if (connectionController == null) {
            connectionController = null;
        } else {
            connectionController.a(new C28557(this));
        }
        this.aM = connectionController;
        if (this.aM != null) {
            this.aN = (FriendsCenterBaseAdapter) this.ap.get();
        } else {
            this.aN = (FriendsCenterBaseAdapter) this.ao.get();
        }
        this.aD = this.aq.m20168a(am_(), Integer.valueOf(3080203), "FriendCenterSuggestionsTabTTI");
        if (D() && !this.aF) {
            this.aD.m20165a(false);
            this.aF = true;
        }
        this.au.a(new C28524(this));
        LogUtils.f(-128335647, a2);
    }

    public final View m20448a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1776660957);
        View inflate = layoutInflater.inflate(2130904520, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2045326932, a);
        return inflate;
    }

    public final void m20450a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.aH = String.valueOf(this.f20121i.a());
        FriendsCenterBaseAdapter friendsCenterBaseAdapter = this.aN;
        friendsCenterBaseAdapter.f20125b = true;
        friendsCenterBaseAdapter.f20126c.f20169m = new C28581(friendsCenterBaseAdapter);
        this.aJ = new ListViewProxy((BetterListView) a());
        this.aJ.a(this.aN);
        this.aJ.a(new C28535(this));
        this.aJ.b(this.au);
        this.aJ.a(new C28546(this));
        this.aK = (ProgressBar) e(2131562324);
        this.aL = (TextView) e(2131562325);
        if (this.aM != null) {
            this.aM.a(20, null);
        } else {
            ap();
        }
    }

    public final void m20445G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1786994578);
        super.G();
        this.aI = true;
        if (D()) {
            as();
        }
        if (this.aM == null) {
            this.am.a(this.az);
        }
        this.am.a(this.aA);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 889789745, a);
    }

    public final void m20446H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1880970510);
        this.aI = false;
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1451456970, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 864796588);
        if (this.aM != null) {
            FriendsCenterConnectionControllerManager friendsCenterConnectionControllerManager = this.av;
            friendsCenterConnectionControllerManager.f19960d.a();
            friendsCenterConnectionControllerManager.f19961e.m20127b();
        } else {
            this.at.c();
        }
        this.aN.m20460c();
        this.aJ.a(null);
        this.aJ.a(null);
        this.aJ.c(this.au);
        this.aJ = null;
        this.aK = null;
        this.aL = null;
        super.mY_();
        LogUtils.f(1625494823, a);
    }

    public final void m20447I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -24040163);
        if (this.aG) {
            this.an.m20163d(this.aN.f20127d);
        }
        if (this.aM == null) {
            this.am.b(this.az);
        }
        this.am.b(this.aA);
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1579554931, a);
    }

    public final void m20451g(boolean z) {
        boolean D = D();
        super.g(z);
        if (z) {
            as();
            this.aG = true;
        }
        if (!D && z) {
            if (!(this.aF || this.aD == null)) {
                this.aD.m20165a(false);
                this.aF = true;
            }
            for (FriendsCenterListItemModel friendsCenterListItemModel : this.aB) {
                this.as.a(friendsCenterListItemModel.m20172a(), PeopleYouMayKnowLocation.FRIENDS_CENTER, this.aH);
                friendsCenterListItemModel.m20182m();
            }
            this.aB.clear();
        }
        if (z && this.aE && this.aD != null) {
            this.aD.m20164a();
        }
    }

    public final void gB_() {
        this.aJ.h(0);
    }

    public final boolean gC_() {
        return this.aJ.q() == 0;
    }

    @Nullable
    public final ScrollingViewProxy m20452n() {
        return this.aJ;
    }

    public final String am_() {
        return FriendsCenterTabType.SUGGESTIONS.analyticsTag;
    }

    public static void ao(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
        if (friendsCenterSuggestionsFragment.aM != null) {
            if (friendsCenterSuggestionsFragment.aM.d().c().d) {
                friendsCenterSuggestionsFragment.aM.b(20, null);
                return;
            }
        } else if (!friendsCenterSuggestionsFragment.at.a()) {
            if (friendsCenterSuggestionsFragment.ar.m20152a()) {
                friendsCenterSuggestionsFragment.ap();
                return;
            }
        } else {
            return;
        }
        at(friendsCenterSuggestionsFragment);
    }

    private void ap() {
        this.aN.m20459a(true);
        this.at.a("FETCH_SUGGESTIONS", new C28568(this), new C28579(this));
    }

    private void m20441a(Clock clock, FbUriIntentHandler fbUriIntentHandler, FriendingEventBus friendingEventBus, FriendsCenterAnalyticsLogger friendsCenterAnalyticsLogger, Provider<FriendsCenterListAdapter> provider, Provider<FriendsCenterConnectionAdapter> provider2, FriendsCenterPerfLoggerProvider friendsCenterPerfLoggerProvider, FriendsCenterSuggestionsFetcher friendsCenterSuggestionsFetcher, PYMKImpressionLogger pYMKImpressionLogger, TasksManager tasksManager, ViewportMonitor viewportMonitor, FriendsCenterConnectionControllerManager friendsCenterConnectionControllerManager) {
        this.f20121i = clock;
        this.al = fbUriIntentHandler;
        this.am = friendingEventBus;
        this.an = friendsCenterAnalyticsLogger;
        this.ao = provider;
        this.ap = provider2;
        this.aq = friendsCenterPerfLoggerProvider;
        this.ar = friendsCenterSuggestionsFetcher;
        this.as = pYMKImpressionLogger;
        this.at = tasksManager;
        this.au = viewportMonitor;
        this.av = friendsCenterConnectionControllerManager;
    }

    public static void aq(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
        if (!friendsCenterSuggestionsFragment.aE) {
            friendsCenterSuggestionsFragment.aE = true;
            if (friendsCenterSuggestionsFragment.D() && friendsCenterSuggestionsFragment.aD != null) {
                friendsCenterSuggestionsFragment.aD.m20164a();
            }
        }
    }

    public static void m20442a(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment, Throwable th) {
        if (friendsCenterSuggestionsFragment.aM != null) {
            if (friendsCenterSuggestionsFragment.aM.d().d() == 0) {
                friendsCenterSuggestionsFragment.m20444a(friendsCenterSuggestionsFragment.b(2131230761));
            }
        } else if (friendsCenterSuggestionsFragment.aC.isEmpty()) {
            friendsCenterSuggestionsFragment.m20444a(friendsCenterSuggestionsFragment.b(2131230761));
        }
        BLog.b(aw, th, "Failed: %s", new Object[]{"FETCH_SUGGESTIONS"});
    }

    private void m20444a(String str) {
        this.aK.setVisibility(8);
        this.aL.setVisibility(0);
        this.aL.setText(str);
        this.aL.setOnClickListener(this.ay);
    }

    private void as() {
        if (this.aI) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(b(2131233242));
                hasTitleBar.c(true);
                hasTitleBar.a(null);
            }
        }
    }

    public static void at(FriendsCenterSuggestionsFragment friendsCenterSuggestionsFragment) {
        if (friendsCenterSuggestionsFragment.aM != null) {
            if (friendsCenterSuggestionsFragment.aM.d().d() == 0) {
                friendsCenterSuggestionsFragment.m20444a(friendsCenterSuggestionsFragment.b(2131239335));
            }
        } else if (friendsCenterSuggestionsFragment.aC.isEmpty()) {
            friendsCenterSuggestionsFragment.m20444a(friendsCenterSuggestionsFragment.b(2131239335));
        }
    }
}
