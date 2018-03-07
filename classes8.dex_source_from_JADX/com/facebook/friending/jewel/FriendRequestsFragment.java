package com.facebook.friending.jewel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.apptab.state.TabTag;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.fragment.FbListFragment;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.common.viewport.BaseViewportEventListener;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.friending.common.list.model.FriendListCommonModel;
import com.facebook.friending.common.list.model.FriendListUserCommonModel;
import com.facebook.friending.jewel.abtest.ExperimentsForFriendingJewelExperimentModule;
import com.facebook.friending.jewel.adapter.FriendingJewelAdapter;
import com.facebook.friending.jewel.adapter.FriendingJewelAdapterProvider;
import com.facebook.friending.jewel.adapter.FriendingPYMKBinder;
import com.facebook.friending.jewel.entitycards.FriendRequestsEntityCardsLauncher;
import com.facebook.friending.jewel.gk.IsFabViewEnabled;
import com.facebook.friending.jewel.logging.FriendingJewelLogger;
import com.facebook.friending.jewel.model.ContactsSectionModel;
import com.facebook.friends.FriendingCacheHandler;
import com.facebook.friends.FriendingCacheHandlerProvider;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.FriendingClient.5;
import com.facebook.friends.FriendingStartOperationHelper;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendRequestResponseRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.controllers.FriendingButtonController;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEvent;
import com.facebook.friends.events.FriendingEvents.PYMKBlacklistedEventSubscriber;
import com.facebook.friends.events.FriendingEvents.UserBlockedEvent;
import com.facebook.friends.events.FriendingEvents.UserBlockedEventSubscriber;
import com.facebook.friends.logging.FriendRequestLogger;
import com.facebook.friends.logging.PYMKImpressionLogger;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.friends.protocol.FetchFriendsWhoUsedContactImporter;
import com.facebook.friends.protocol.FetchFriendsWhoUsedContactImporter.1;
import com.facebook.friends.protocol.FetchFriendsWhoUsedContactImporter.OrderBy;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQL.FriendsWhoUsedContactImporterQueryString;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLModels.FacepileFieldsModel;
import com.facebook.friends.protocol.FriendsWhoUsedContactImporterGraphQLModels.FacepileFriendsConnectionModel;
import com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod.Event;
import com.facebook.friends.protocol.UpdatePeopleYouMayKnowHistoryMethod.Params;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.megaphone.ui.QuickPromotionMegaphoneStoryView;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.notifications.common.JewelCounters.OnJewelCountChangeListener;
import com.facebook.nux.status.NuxStepListener;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.ui.QuickPromotionFooterController;
import com.facebook.quickpromotion.ui.QuickPromotionFooterFragment;
import com.facebook.quickpromotion.ui.QuickPromotionFooterFragment.ActionButtonTheme;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;
import com.facebook.quickpromotion.ui.QuickPromotionFragment.QuickPromotionFragmentHost;
import com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory;
import com.facebook.quickpromotion.ui.QuickPromotionMegaphoneController;
import com.facebook.quickpromotion.ui.QuickPromotionToastFooterController;
import com.facebook.quickpromotion.ui.QuickPromotionToastFooterFragment;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tablet.abtest.TabletColumnLayoutManager;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ClickableToast;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.uicontrib.fab.FabDrawable.FabType;
import com.facebook.uicontrib.fab.FabViewHost;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnItemClickListener;
import com.facebook.widget.listview.ScrollingViewProxyContainer;
import com.facebook.widget.listview.ScrollingViewUtils;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.refreshableview.ConnectionRetrySnackbarView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: first_unit_only */
public class FriendRequestsFragment extends FbListFragment implements AnalyticsFragment, QuickPromotionFragmentHost, ScrollableListContainer, ScrollingViewProxyContainer {
    private static final Class<?> aR;
    public static final CallerContext aS;
    private static final int aT = 2131233203;
    @Inject
    Lazy<FriendRequestsEntityCardsLauncher> aA;
    @Inject
    FriendRequestLogger aB;
    @Inject
    FriendRequestsPerfLogger aC;
    @Inject
    public InterstitialManager aD;
    @Inject
    JewelCounters aE;
    @Inject
    @LoggedInUserId
    Provider<String> aF;
    @Inject
    NavigationLogger aG;
    @Inject
    public NetworkMonitor aH;
    @Inject
    PYMKImpressionLogger aI;
    @Inject
    QeAccessor aJ;
    @Inject
    QuickPromotionFragmentFactory aK;
    @Inject
    TabletColumnLayoutManager aL;
    @Inject
    TabletExperimentConfiguration aM;
    @Inject
    public TasksManager aN;
    @Inject
    ClickableToastBuilder aO;
    @Inject
    Clock aP;
    @Inject
    @IsFabViewEnabled
    Provider<Boolean> aQ;
    private final FriendshipStatusChangedEventSubscriber aU = new C13731(this);
    private final UserBlockedEventSubscriber aV = new C13742(this);
    private final PYMKBlacklistedEventSubscriber aW = new C13753(this);
    private final OnSharedPreferenceChangeListener aX = new C13764(this);
    private OnClickListener aY;
    public SwipeRefreshLayout aZ;
    @Inject
    FriendingJewelSproutLauncherProvider al;
    @Inject
    FriendingCacheHandlerProvider am;
    @Inject
    ViewportMonitor an;
    @Inject
    FriendingJewelImagePreloaderProvider ao;
    @Inject
    public AnalyticsLogger ap;
    @Inject
    AnalyticsTagger aq;
    @Inject
    public DefaultAndroidThreadUtil ar;
    @Inject
    AppStateManager as;
    @Inject
    FbSharedPreferences at;
    @Inject
    public FbUriIntentHandler au;
    @Inject
    Lazy<FetchFriendsWhoUsedContactImporter> av;
    @Inject
    FriendingButtonController aw;
    @Inject
    public FriendingClient ax;
    @Inject
    FriendingEventBus ay;
    @Inject
    FriendingJewelLogger az;
    public boolean bA = false;
    public boolean bB = false;
    public boolean bC = false;
    public boolean bD;
    public ClickableToast ba;
    private View bb;
    private FbTextView bc;
    private LoadingIndicatorView bd;
    public LoadingIndicatorView be;
    private ScrollingViewProxy bf;
    public FriendingJewelAdapter bg;
    @Nullable
    private FriendingJewelImagePreloader bh;
    public FriendingJewelSproutLauncher bi;
    private FriendingCacheHandler bj;
    public SelfRegistrableReceiverImpl bk;
    private OnJewelCountChangeListener bl;
    private View bm;
    private QuickPromotionFragment bn;
    public QuickPromotionMegaphoneStoryView bo;
    public long bp;
    private boolean bq = false;
    public String br;
    public ListenableFuture<Void> bs;
    public int bt;
    public FriendingLocation bu = FriendingLocation.JEWEL;
    public boolean bv = true;
    public boolean bw = true;
    public boolean bx = true;
    public boolean by = true;
    private boolean bz = false;
    @Inject
    FriendingJewelAdapterProvider f13201i;

    /* compiled from: first_unit_only */
    public class C13731 extends FriendshipStatusChangedEventSubscriber {
        public final /* synthetic */ FriendRequestsFragment f13183a;

        C13731(FriendRequestsFragment friendRequestsFragment) {
            this.f13183a = friendRequestsFragment;
        }

        public final void m14830b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            Object obj = 1;
            if (friendshipStatusChangedEvent != null && this.f13183a.bg != null) {
                Object obj2;
                FriendingJewelAdapter friendingJewelAdapter = this.f13183a.bg;
                long j = friendshipStatusChangedEvent.a;
                if (friendingJewelAdapter.m14909a(j) || friendingJewelAdapter.m14917d(j)) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    FriendRequestsFragment friendRequestsFragment = this.f13183a;
                    if (friendRequestsFragment.getContext() instanceof NuxStepListener) {
                        ((NuxStepListener) friendRequestsFragment.getContext()).c("people_you_may_know");
                    }
                    if (this.f13183a.bg.m14917d(friendshipStatusChangedEvent.a)) {
                        this.f13183a.bg.m14906a(friendshipStatusChangedEvent.a, friendshipStatusChangedEvent.b);
                    } else if (this.f13183a.bg.m14909a(friendshipStatusChangedEvent.a)) {
                        j = friendshipStatusChangedEvent.a;
                        GraphQLFriendshipStatus graphQLFriendshipStatus = friendshipStatusChangedEvent.b;
                        boolean b = this.f13183a.bg.m14914b(j);
                        if ((!b && graphQLFriendshipStatus == GraphQLFriendshipStatus.ARE_FRIENDS) || (b && graphQLFriendshipStatus == GraphQLFriendshipStatus.OUTGOING_REQUEST)) {
                            this.f13183a.bg.mo829a(String.valueOf(j), FriendRequestState.ACCEPTED, false);
                        } else if (graphQLFriendshipStatus == GraphQLFriendshipStatus.CAN_REQUEST) {
                            this.f13183a.bg.mo829a(String.valueOf(j), FriendRequestState.REJECTED, false);
                        } else {
                            FriendRequestsFragment.m14848i(this.f13183a, false);
                        }
                    } else {
                        obj = null;
                    }
                    if (friendshipStatusChangedEvent.c && this.f13183a.D() && r0 != null) {
                        FriendRequestsFragment.aq(this.f13183a);
                    }
                }
            }
        }
    }

    /* compiled from: first_unit_only */
    class C13742 extends UserBlockedEventSubscriber {
        final /* synthetic */ FriendRequestsFragment f13193a;

        C13742(FriendRequestsFragment friendRequestsFragment) {
            this.f13193a = friendRequestsFragment;
        }

        public final void m14835b(FbEvent fbEvent) {
            UserBlockedEvent userBlockedEvent = (UserBlockedEvent) fbEvent;
            if (userBlockedEvent != null && this.f13193a.bg != null) {
                this.f13193a.bg.mo828a(String.valueOf(userBlockedEvent.a));
                this.f13193a.bg.m14915c(userBlockedEvent.a);
            }
        }
    }

    /* compiled from: first_unit_only */
    class C13753 extends PYMKBlacklistedEventSubscriber {
        final /* synthetic */ FriendRequestsFragment f13194a;

        C13753(FriendRequestsFragment friendRequestsFragment) {
            this.f13194a = friendRequestsFragment;
        }

        public final void m14836b(FbEvent fbEvent) {
            PYMKBlacklistedEvent pYMKBlacklistedEvent = (PYMKBlacklistedEvent) fbEvent;
            if (pYMKBlacklistedEvent != null && this.f13194a.bg != null) {
                this.f13194a.bg.m14915c(pYMKBlacklistedEvent.a);
            }
        }
    }

    /* compiled from: first_unit_only */
    class C13764 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ FriendRequestsFragment f13195a;

        C13764(FriendRequestsFragment friendRequestsFragment) {
            this.f13195a = friendRequestsFragment;
        }

        public final void m14837a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            if (this.f13195a.bg != null && this.f13195a.bw && this.f13195a.bg.m14921g() && fbSharedPreferences.a(prefKey, false)) {
                Object obj = this.f13195a.bg;
                obj.f13251j.m14979c();
                FriendingJewelAdapter.m14901l(obj);
                AdapterDetour.a(obj, 635314119);
            }
        }
    }

    /* compiled from: first_unit_only */
    class C13775 implements OnRefreshListener {
        final /* synthetic */ FriendRequestsFragment f13196a;

        C13775(FriendRequestsFragment friendRequestsFragment) {
            this.f13196a = friendRequestsFragment;
        }

        public final void m14838a() {
            if (this.f13196a.ba != null) {
                this.f13196a.ba.b();
            }
            FriendRequestsFragment.m14849j(this.f13196a, true);
        }
    }

    /* compiled from: first_unit_only */
    class C13786 implements OnClickListener {
        final /* synthetic */ FriendRequestsFragment f13197a;

        C13786(FriendRequestsFragment friendRequestsFragment) {
            this.f13197a = friendRequestsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1858830265);
            FriendRequestsFragment.m14849j(this.f13197a, true);
            Logger.a(2, EntryType.UI_INPUT_END, 1535745757, a);
        }
    }

    /* compiled from: first_unit_only */
    class C13797 extends BaseViewportEventListener {
        final /* synthetic */ FriendRequestsFragment f13198a;

        C13797(FriendRequestsFragment friendRequestsFragment) {
            this.f13198a = friendRequestsFragment;
        }

        public final void m14839a(Object obj) {
            if (obj instanceof PersonYouMayKnow) {
                PersonYouMayKnow personYouMayKnow = (PersonYouMayKnow) obj;
                if (!personYouMayKnow.h) {
                    this.f13198a.az.m14975a(personYouMayKnow);
                    this.f13198a.aI.a(personYouMayKnow.a(), PeopleYouMayKnowLocation.JEWEL, this.f13198a.br);
                    personYouMayKnow.i();
                }
            } else if (obj instanceof FriendRequest) {
                FriendRequest friendRequest = (FriendRequest) obj;
                if (this.f13198a.aB.a() && !friendRequest.k) {
                    this.f13198a.aB.a(friendRequest.a(), FriendRequestResponseRef.MOBILE_JEWEL, this.f13198a.br);
                    friendRequest.n();
                }
            }
        }
    }

    /* compiled from: first_unit_only */
    class C13808 extends OnJewelCountChangeListener {
        final /* synthetic */ FriendRequestsFragment f13199a;

        C13808(FriendRequestsFragment friendRequestsFragment) {
            this.f13199a = friendRequestsFragment;
        }

        public final void m14840a(Jewel jewel, int i) {
            if (jewel == Jewel.FRIEND_REQUESTS && i > this.f13199a.bt) {
                this.f13199a.bt = i;
                FriendRequestsFragment.m14848i(this.f13199a, false);
            }
        }
    }

    /* compiled from: first_unit_only */
    class C13819 implements OnClickListener {
        final /* synthetic */ FriendRequestsFragment f13200a;

        C13819(FriendRequestsFragment friendRequestsFragment) {
            this.f13200a = friendRequestsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -446946607);
            this.f13200a.bi.m14880a();
            Logger.a(2, EntryType.UI_INPUT_END, -701115272, a);
        }
    }

    public static void m14847a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FriendRequestsFragment) obj).m14846a((FriendingJewelAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendingJewelAdapterProvider.class), (FriendingJewelSproutLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendingJewelSproutLauncherProvider.class), (FriendingCacheHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendingCacheHandlerProvider.class), ViewportMonitor.a(injectorLike), (FriendingJewelImagePreloaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendingJewelImagePreloaderProvider.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), AnalyticsTagger.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), AppStateManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FbUriIntentHandler.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 6699), FriendingButtonController.a(injectorLike), FriendingClient.a(injectorLike), FriendingEventBus.a(injectorLike), FriendingJewelLogger.m14972a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 6664), FriendRequestLogger.a(injectorLike), FriendRequestsPerfLogger.m14864a(injectorLike), InterstitialManager.a(injectorLike), JewelCounters.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), NavigationLogger.a(injectorLike), NetworkMonitor.a(injectorLike), PYMKImpressionLogger.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), QuickPromotionFragmentFactory.m4679a(injectorLike), TabletColumnLayoutManager.a(injectorLike), TabletExperimentConfiguration.a(injectorLike), TasksManager.a(injectorLike), ClickableToastBuilder.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4012));
    }

    private void m14846a(FriendingJewelAdapterProvider friendingJewelAdapterProvider, FriendingJewelSproutLauncherProvider friendingJewelSproutLauncherProvider, FriendingCacheHandlerProvider friendingCacheHandlerProvider, ViewportMonitor viewportMonitor, FriendingJewelImagePreloaderProvider friendingJewelImagePreloaderProvider, AnalyticsLogger analyticsLogger, AnalyticsTagger analyticsTagger, AndroidThreadUtil androidThreadUtil, AppStateManager appStateManager, FbSharedPreferences fbSharedPreferences, FbUriIntentHandler fbUriIntentHandler, Lazy<FetchFriendsWhoUsedContactImporter> lazy, FriendingButtonController friendingButtonController, FriendingClient friendingClient, FriendingEventBus friendingEventBus, FriendingJewelLogger friendingJewelLogger, Lazy<FriendRequestsEntityCardsLauncher> lazy2, FriendRequestLogger friendRequestLogger, FriendRequestsPerfLogger friendRequestsPerfLogger, InterstitialManager interstitialManager, JewelCounters jewelCounters, Provider<String> provider, NavigationLogger navigationLogger, NetworkMonitor networkMonitor, PYMKImpressionLogger pYMKImpressionLogger, QeAccessor qeAccessor, QuickPromotionFragmentFactory quickPromotionFragmentFactory, TabletColumnLayoutManager tabletColumnLayoutManager, TabletExperimentConfiguration tabletExperimentConfiguration, TasksManager tasksManager, ClickableToastBuilder clickableToastBuilder, Clock clock, Provider<Boolean> provider2) {
        this.f13201i = friendingJewelAdapterProvider;
        this.al = friendingJewelSproutLauncherProvider;
        this.am = friendingCacheHandlerProvider;
        this.an = viewportMonitor;
        this.ao = friendingJewelImagePreloaderProvider;
        this.ap = analyticsLogger;
        this.aq = analyticsTagger;
        this.ar = androidThreadUtil;
        this.as = appStateManager;
        this.at = fbSharedPreferences;
        this.au = fbUriIntentHandler;
        this.av = lazy;
        this.aw = friendingButtonController;
        this.ax = friendingClient;
        this.ay = friendingEventBus;
        this.az = friendingJewelLogger;
        this.aA = lazy2;
        this.aB = friendRequestLogger;
        this.aC = friendRequestsPerfLogger;
        this.aD = interstitialManager;
        this.aE = jewelCounters;
        this.aF = provider;
        this.aG = navigationLogger;
        this.aH = networkMonitor;
        this.aI = pYMKImpressionLogger;
        this.aJ = qeAccessor;
        this.aK = quickPromotionFragmentFactory;
        this.aL = tabletColumnLayoutManager;
        this.aM = tabletExperimentConfiguration;
        this.aN = tasksManager;
        this.aO = clickableToastBuilder;
        this.aP = clock;
        this.aQ = provider2;
    }

    static {
        Class cls = FriendRequestsFragment.class;
        aR = cls;
        aS = CallerContext.a(cls, "friend_requests");
    }

    public final void m14857a(@Nullable Bundle bundle) {
        FragmentManager kO_;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -708387258);
        super.a(bundle);
        Class cls = FriendRequestsFragment.class;
        m14847a((Object) this, getContext());
        this.bw = this.bu == FriendingLocation.JEWEL;
        FriendingJewelSproutLauncherProvider friendingJewelSproutLauncherProvider = this.al;
        Context context = getContext();
        FabViewHost fabViewHost = (FabViewHost) a(FabViewHost.class);
        if (fabViewHost != null) {
            kO_ = fabViewHost.kO_();
        } else {
            kO_ = kO_();
        }
        this.bi = new FriendingJewelSproutLauncher(FbUriIntentHandler.a(friendingJewelSproutLauncherProvider), IdBasedLazy.a(friendingJewelSproutLauncherProvider, 3595), context, kO_);
        this.bj = this.am.a(this.aN);
        this.bq = true;
        if (D() && !this.bz) {
            this.bz = true;
            this.aC.m14866a(this.bu);
        }
        LogUtils.f(-1794733922, a);
    }

    public final View m14855a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 369199788);
        View inflate = layoutInflater.inflate(2130904490, viewGroup, false);
        this.aZ = (FbSwipeRefreshLayout) inflate.findViewById(2131561342);
        this.ay.a(this.aU);
        this.ay.a(this.aV);
        this.ay.a(this.aW);
        String str = (String) this.aF.get();
        if (str != null) {
            this.at.a(GrowthPrefKeys.a(str), this.aX);
        }
        this.aw.d = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2108141106, a);
        return inflate;
    }

    public final void m14858a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.aq.a(view, "jewel_popup_friend_requests", this);
        this.bb = e(16908292);
        this.bc = (FbTextView) e(2131562267);
        this.bd = (LoadingIndicatorView) e(2131562268);
        this.bm = e(2131562273);
        TypedValue typedValue = new TypedValue();
        view.getContext().getTheme().resolveAttribute(2130772382, typedValue, true);
        this.bb.setBackgroundResource(typedValue.resourceId);
        this.aZ.e = new C13775(this);
        this.bc.setOnClickListener(new C13786(this));
        this.bf = new ListViewProxy((BetterListView) a());
        this.bf.k();
        int dimension = ((int) jW_().getDimension(2131429779)) + FabType.BIG.getFullSize(jW_());
        this.be = (LoadingIndicatorView) LayoutInflater.from(view.getContext()).inflate(2130904487, a(), false);
        this.be.setPadding(0, 0, 0, dimension);
        this.bf.e(this.be);
        this.bk = this.aH.a(State.CONNECTED, new Runnable(this) {
            final /* synthetic */ FriendRequestsFragment f13186a;

            {
                this.f13186a = r1;
            }

            public void run() {
                if (this.f13186a.bC) {
                    this.f13186a.bC = false;
                    this.f13186a.be.a();
                    FriendRequestsFragment.av(this.f13186a);
                }
            }
        });
        aC();
    }

    public final void m14860d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1962636229);
        super.d(bundle);
        if (this.bg == null) {
            InjectorLike injectorLike = this.f13201i;
            this.bg = new FriendingJewelAdapter(FbUriIntentHandler.a(injectorLike), FriendingPYMKBinder.m14932b(injectorLike), (FriendRequestsActionControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendRequestsActionControllerProvider.class), getContext(), this.aN);
            this.bg.f13253l = this.bu;
            this.bg.f13254m = this.bw;
            this.bg.f13255n = this.bx;
            this.bg.f13256o = this.by;
        }
        this.bg.m14923j();
        this.an.a(new C13797(this));
        this.bf.a(this.bg);
        this.bh = this.ao.m14876a(aS, this.bf, this.bg, 3);
        if (this.bv) {
            this.bf.a(m14841a(this.bf));
        } else {
            this.bg.f13257p = true;
        }
        this.bf.d().setOnScrollListener(au());
        this.bf.d().setDivider(null);
        this.bf.d().setStickyHeaderEnabled(true);
        this.bf.b(0);
        this.bf.b(this.an);
        this.bl = new C13808(this);
        this.aE.a(this.bl);
        this.bt = this.aE.a(Jewel.FRIEND_REQUESTS);
        if (this.bt > 0) {
            m14848i(this, false);
        } else {
            m14851l(this, false);
        }
        LogUtils.f(1899461567, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -130266696);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(aT);
            hasTitleBar.kg_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1330940711, a);
    }

    public final void m14853G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1026608595);
        super.G();
        if (D()) {
            ap();
        }
        aA();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -126184201, a);
    }

    public final void m14854H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1766181878);
        this.aC.m14868b(this.bu);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1053277040, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 868753137);
        if (!(this.aE == null || this.bl == null)) {
            this.aE.b(this.bl);
        }
        if (this.bk != null) {
            this.bk.c();
            this.bk = null;
        }
        this.ay.b(this.aU);
        this.ay.b(this.aV);
        this.ay.b(this.aW);
        String str = (String) this.aF.get();
        if (str != null) {
            this.at.b(GrowthPrefKeys.a(str), this.aX);
        }
        this.bg.f13243b.m14942b();
        this.aw.d = true;
        if (this.bh != null) {
            this.bh.a();
            this.bh = null;
        }
        this.bf.a(null);
        this.bf.a(null);
        this.bf.c(this.an);
        if (this.aZ != null) {
            this.aZ.e = null;
            this.aZ = null;
        }
        FabViewHost fabViewHost = (FabViewHost) a(FabViewHost.class);
        if (fabViewHost != null) {
            fabViewHost.b(this);
        }
        this.aN.c();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1394802222, a);
    }

    public final void m14862g(boolean z) {
        boolean D = D();
        super.g(z);
        if (z && !D) {
            ap();
        }
        if (this.bq && !D && z && !this.bz) {
            this.bz = true;
            this.aC.m14866a(this.bu);
        }
        if (z && this.bA && this.bz) {
            this.aC.m14867a(this.bu, 0);
        }
        if (D && !z && this.bz) {
            this.aC.m14868b(this.bu);
        }
        aA();
        if (!z && this.ba != null) {
            this.ba.b();
        }
    }

    public final void gB_() {
        a().smoothScrollToPosition(0);
    }

    public final boolean gC_() {
        return a().getFirstVisiblePosition() == 0;
    }

    public final ScrollingViewProxy m14863n() {
        return this.bf;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aC();
        ScrollingViewUtils.a(this.bf);
    }

    public final void c_(boolean z) {
        if (z) {
            ar();
        }
    }

    public final boolean kS_() {
        boolean z;
        if (this.aQ == null || !((Boolean) this.aQ.get()).booleanValue()) {
            z = false;
        } else {
            z = true;
        }
        boolean z2;
        if (this.bn != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || r3) {
            return false;
        }
        return true;
    }

    public final OnClickListener m14861e() {
        if (this.aY == null) {
            this.aY = new C13819(this);
        }
        return this.aY;
    }

    public final CharSequence m14859d() {
        return b(2131233242);
    }

    private void ap() {
        if (this.bu == FriendingLocation.JEWEL) {
            QuickPromotionController quickPromotionController = (QuickPromotionController) this.aD.a(QuickPromotionFooterController.c, QuickPromotionController.class);
            if (quickPromotionController != null) {
                Intent a = quickPromotionController.a(getContext());
                if (a == null) {
                    return;
                }
                if (quickPromotionController.b().equals(QuickPromotionMegaphoneController.a)) {
                    final QuickPromotionDefinition quickPromotionDefinition = (QuickPromotionDefinition) a.getExtras().get("qp_definition");
                    Assertions.b(quickPromotionDefinition);
                    this.ar.a(new Runnable(this) {
                        final /* synthetic */ FriendRequestsFragment f13191b;

                        public void run() {
                            if (this.f13191b.bo == null) {
                                FriendRequestsFragment friendRequestsFragment = this.f13191b;
                                friendRequestsFragment.bo = new QuickPromotionMegaphoneStoryView(friendRequestsFragment.o());
                                ((ViewGroup) friendRequestsFragment.e(2131562271)).addView(friendRequestsFragment.bo, 0);
                            }
                            this.f13191b.bo.m1573a(quickPromotionDefinition, QuickPromotionMegaphoneController.a);
                        }
                    });
                } else if (quickPromotionController.b().equals("1820") && this.bm != null) {
                    if (this.bn == null || !this.bn.m4669b(a)) {
                        QuickPromotionFragment a2 = this.aK.m4681a(a);
                        if (a2 instanceof QuickPromotionFooterFragment) {
                            this.bn = a2;
                            this.bn.s.putSerializable("ACTION_BUTTON_THEME_ARG", ActionButtonTheme.SPECIAL);
                            s().a().b(2131562273, this.bn).c();
                            at();
                            this.bm.setVisibility(0);
                            return;
                        }
                        ar();
                    } else if (this.bn.mx_()) {
                        this.bn.ay();
                    }
                }
            }
        }
    }

    public static void aq(FriendRequestsFragment friendRequestsFragment) {
        if (friendRequestsFragment.bu == FriendingLocation.JEWEL) {
            Intent intent;
            QuickPromotionFragment quickPromotionFragment = null;
            QuickPromotionController quickPromotionController = (QuickPromotionController) friendRequestsFragment.aD.a(QuickPromotionToastFooterController.f4839a, QuickPromotionToastFooterController.class);
            if (quickPromotionController == null) {
                intent = null;
            } else {
                intent = quickPromotionController.a(friendRequestsFragment.getContext());
            }
            Intent intent2 = intent;
            if (intent2 != null) {
                if (friendRequestsFragment.bn == null || !friendRequestsFragment.bn.m4669b(intent2)) {
                    quickPromotionFragment = friendRequestsFragment.aK.m4681a(intent2);
                } else {
                    return;
                }
            }
            if (quickPromotionFragment instanceof QuickPromotionToastFooterFragment) {
                friendRequestsFragment.bn = quickPromotionFragment;
                friendRequestsFragment.at();
                friendRequestsFragment.bm.setVisibility(0);
                friendRequestsFragment.s().a().a(2130968645, 0).b(2131562273, friendRequestsFragment.bn).c();
            }
        }
    }

    private void ar() {
        if (this.bn instanceof QuickPromotionToastFooterFragment) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130968646);
            loadAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ FriendRequestsFragment f13164a;

                {
                    this.f13164a = r1;
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    FriendRequestsFragment.as(this.f13164a);
                }

                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.bm.startAnimation(loadAnimation);
            return;
        }
        as(this);
    }

    public static void as(FriendRequestsFragment friendRequestsFragment) {
        if (friendRequestsFragment.bn != null) {
            friendRequestsFragment.s().a().a(friendRequestsFragment.bn).c();
            friendRequestsFragment.bn = null;
        }
        friendRequestsFragment.bm.setVisibility(8);
        friendRequestsFragment.at();
    }

    private void at() {
        final FabViewHost fabViewHost = (FabViewHost) a(FabViewHost.class);
        View view = this.T;
        if (fabViewHost != null && view != null) {
            view.post(new Runnable(this) {
                final /* synthetic */ FriendRequestsFragment f13166b;

                public void run() {
                    fabViewHost.a(this.f13166b);
                }
            });
        }
    }

    public static void m14848i(FriendRequestsFragment friendRequestsFragment, final boolean z) {
        friendRequestsFragment.bj.b(new FutureCallback(friendRequestsFragment) {
            final /* synthetic */ FriendRequestsFragment f13168b;

            public void onSuccess(@Nullable Object obj) {
                FriendRequestsFragment.m14851l(this.f13168b, z);
            }

            public void onFailure(Throwable th) {
            }
        });
    }

    public static void m14849j(FriendRequestsFragment friendRequestsFragment, final boolean z) {
        friendRequestsFragment.bj.c(new FutureCallback(friendRequestsFragment) {
            final /* synthetic */ FriendRequestsFragment f13170b;

            public void onSuccess(@Nullable Object obj) {
                FriendRequestsFragment.m14851l(this.f13170b, z);
            }

            public void onFailure(Throwable th) {
            }
        });
    }

    private OnItemClickListener m14841a(final ScrollingViewProxy scrollingViewProxy) {
        return new OnItemClickListener(this) {
            final /* synthetic */ FriendRequestsFragment f13172b;

            public final void m14825a(int i) {
                Object g = scrollingViewProxy.g(i);
                if (g instanceof FriendListCommonModel) {
                    if (g instanceof PersonYouMayKnow) {
                        this.f13172b.az.m14977c((PersonYouMayKnow) g);
                    }
                    this.f13172b.bp = ((FriendListCommonModel) g).a();
                    this.f13172b.aG.a("tap_friends_jewel");
                    FriendRequestsFragment.m14842a(this.f13172b, (Parcelable) g);
                }
            }
        };
    }

    public final void m14856a(int i, int i2, @Nullable Intent intent) {
        super.a(i, i2, intent);
        switch (i) {
            case 3:
                Object obj = null;
                if (intent != null) {
                    obj = intent.getStringExtra("entity_cards_visible_id");
                }
                if (!StringUtil.a(obj)) {
                    Object obj2 = this.bg;
                    if (obj2.f13248g.contains(Long.valueOf(Long.parseLong(obj)))) {
                        AdapterDetour.a(obj2, 880463125);
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void m14842a(FriendRequestsFragment friendRequestsFragment, Object obj) {
        FriendRequestsEntityCardsLauncher friendRequestsEntityCardsLauncher = (FriendRequestsEntityCardsLauncher) friendRequestsFragment.aA.get();
        boolean a = friendRequestsFragment.aJ.a(ExperimentsForFriendingJewelExperimentModule.f13232a, true);
        if ((obj instanceof FriendRequest) && friendRequestsEntityCardsLauncher.m14959a() && a) {
            friendRequestsEntityCardsLauncher.m14957a(friendRequestsFragment.o(), friendRequestsFragment.bg, String.valueOf(friendRequestsFragment.bp), friendRequestsFragment.ax.f(), friendRequestsFragment.bu, friendRequestsFragment.jW_().getString(2131233203));
        } else if ((obj instanceof PersonYouMayKnow) && friendRequestsEntityCardsLauncher.m14959a() && a) {
            friendRequestsEntityCardsLauncher.m14958a(friendRequestsFragment.o(), friendRequestsFragment.bg, String.valueOf(friendRequestsFragment.bp), friendRequestsFragment.ax.g(), friendRequestsFragment.bu, friendRequestsFragment.jW_().getString(2131233210), 3);
        } else {
            FriendListUserCommonModel friendListUserCommonModel = (FriendListUserCommonModel) obj;
            Bundle bundle = new Bundle();
            bundle.putSerializable("timeline_friend_request_ref", FriendRequestMakeRef.PYMK_JEWEL);
            ModelBundle.a(bundle, String.valueOf(friendListUserCommonModel.a()), friendListUserCommonModel.d(), friendListUserCommonModel.b(), null, null);
            friendRequestsFragment.au.a(friendRequestsFragment.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, Long.valueOf(friendRequestsFragment.bp)), bundle);
        }
    }

    private OnScrollListener au() {
        return new OnScrollListener(this) {
            final /* synthetic */ FriendRequestsFragment f13173a;

            {
                this.f13173a = r1;
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if ((i + i2) + 3 >= i3 && !this.f13173a.bC) {
                    FriendRequestsFragment.av(this.f13173a);
                }
            }
        };
    }

    public static void av(FriendRequestsFragment friendRequestsFragment) {
        boolean z = false;
        if (!friendRequestsFragment.aN.a()) {
            if (friendRequestsFragment.ax.b()) {
                friendRequestsFragment.m14850k(false);
                return;
            }
            boolean a;
            String str = (String) friendRequestsFragment.aF.get();
            if (str != null) {
                a = friendRequestsFragment.at.a(GrowthPrefKeys.a(str), false);
            } else {
                a = false;
            }
            if (!friendRequestsFragment.bw || r0) {
                if (friendRequestsFragment.ax.c()) {
                    friendRequestsFragment.aw();
                }
            } else if (!friendRequestsFragment.bg.m14921g()) {
                a = friendRequestsFragment.ax.c();
                if (friendRequestsFragment.bg.m14922i() >= 100) {
                    z = true;
                }
                if (friendRequestsFragment.bD && (!a || r1)) {
                    Preconditions.checkArgument(friendRequestsFragment.bD);
                    friendRequestsFragment.bD = false;
                    friendRequestsFragment.aN.a("FETCH_CONTACTS_SECTION_TASK", new Callable<ListenableFuture<FacepileFriendsConnectionModel>>(friendRequestsFragment) {
                        final /* synthetic */ FriendRequestsFragment f13184a;

                        {
                            this.f13184a = r1;
                        }

                        public Object call() {
                            this.f13184a.be.a();
                            FetchFriendsWhoUsedContactImporter fetchFriendsWhoUsedContactImporter = (FetchFriendsWhoUsedContactImporter) this.f13184a.av.get();
                            int dimensionPixelSize = this.f13184a.jW_().getDimensionPixelSize(2131428711);
                            OrderBy orderBy = OrderBy.MUTUAL_IMPORTANCE;
                            GraphQlQueryString friendsWhoUsedContactImporterQueryString = new FriendsWhoUsedContactImporterQueryString();
                            friendsWhoUsedContactImporterQueryString.a("first", String.valueOf(6)).a("order_by", Lists.a(new String[]{orderBy.value})).a("picture_size", String.valueOf(dimensionPixelSize)).a("media_type", fetchFriendsWhoUsedContactImporter.b.b());
                            GraphQLRequest a = GraphQLRequest.a(friendsWhoUsedContactImporterQueryString);
                            a.a(GraphQLCachePolicy.a);
                            return Futures.a(fetchFriendsWhoUsedContactImporter.a.a(a), new 1(fetchFriendsWhoUsedContactImporter), fetchFriendsWhoUsedContactImporter.c);
                        }
                    }, new AbstractDisposableFutureCallback<FacepileFriendsConnectionModel>(friendRequestsFragment) {
                        final /* synthetic */ FriendRequestsFragment f13185a;

                        {
                            this.f13185a = r1;
                        }

                        protected final void m14831a(@Nullable Object obj) {
                            FacepileFriendsConnectionModel facepileFriendsConnectionModel = (FacepileFriendsConnectionModel) obj;
                            this.f13185a.be.b();
                            if (facepileFriendsConnectionModel != null) {
                                Builder builder = ImmutableList.builder();
                                Builder builder2 = ImmutableList.builder();
                                ImmutableList j = facepileFriendsConnectionModel.j();
                                int size = j.size();
                                for (int i = 0; i < size; i++) {
                                    FacepileFieldsModel facepileFieldsModel = (FacepileFieldsModel) j.get(i);
                                    builder.c(Uri.parse(facepileFieldsModel.b().a()));
                                    builder2.c(facepileFieldsModel.a());
                                }
                                Object obj2 = this.f13185a.bg;
                                ImmutableList b = builder.b();
                                ImmutableList b2 = builder2.b();
                                int a = facepileFriendsConnectionModel.a();
                                ContactsSectionModel contactsSectionModel = obj2.f13251j;
                                contactsSectionModel.f13328a.clear();
                                contactsSectionModel.f13328a.addAll(b);
                                contactsSectionModel.f13329b.clear();
                                contactsSectionModel.f13329b.addAll(b2);
                                contactsSectionModel.f13330c = a;
                                FriendingJewelAdapter.m14901l(obj2);
                                AdapterDetour.a(obj2, -1951967927);
                            }
                        }

                        protected final void m14832a(Throwable th) {
                            FriendRequestsFragment.m14843a(this.f13185a, th);
                        }
                    });
                    m14845a(friendRequestsFragment, friendRequestsFragment.bg.isEmpty(), friendRequestsFragment.aN.a());
                } else if (a) {
                    friendRequestsFragment.aw();
                }
            }
        }
    }

    private void m14850k(boolean z) {
        final boolean d = this.ax.d();
        final long a = this.aP.a();
        final boolean z2 = z;
        this.aN.a("FETCH_FRIEND_REQUESTS_TASK", new Callable<ListenableFuture<List<FriendRequest>>>(this) {
            final /* synthetic */ FriendRequestsFragment f13174a;

            {
                this.f13174a = r1;
            }

            public Object call() {
                return this.f13174a.ax.a(10, FriendRequestsFragment.aS);
            }
        }, new AbstractDisposableFutureCallback<List<FriendRequest>>(this) {
            final /* synthetic */ FriendRequestsFragment f13178d;

            protected final void m14826a(Object obj) {
                boolean z;
                List<FriendRequest> list = (List) obj;
                this.f13178d.bB = true;
                this.f13178d.bA = true;
                if (!z2 && d && this.f13178d.D()) {
                    this.f13178d.aC.m14867a(this.f13178d.bu, this.f13178d.aP.a() - a);
                }
                FriendRequestsFragment friendRequestsFragment = this.f13178d;
                if (list.isEmpty() || ((FriendRequest) list.get(0)).h) {
                    z = false;
                } else {
                    z = true;
                }
                FriendRequestsFragment.m14852m(friendRequestsFragment, z);
                FriendRequestsFragment.m14844a(this.f13178d, (List) list, d);
                if (d) {
                    FriendingJewelAdapter friendingJewelAdapter = this.f13178d.bg;
                    friendingJewelAdapter.f13249h.clear();
                    friendingJewelAdapter.f13247f.clear();
                    this.f13178d.bg.f13255n = this.f13178d.bx;
                    if (!list.isEmpty()) {
                        this.f13178d.bg.m14919e();
                        this.f13178d.bg.f13251j.m14979c();
                    }
                }
                if (!this.f13178d.ax.b()) {
                    this.f13178d.be.b();
                }
                Object obj2 = this.f13178d.bg;
                for (FriendRequest friendRequest : list) {
                    if (!(friendRequest == null || obj2.f13247f.contains(friendRequest.b))) {
                        obj2.f13249h.add(friendRequest);
                        obj2.f13247f.add(friendRequest.b);
                    }
                }
                FriendingJewelAdapter.m14901l(obj2);
                AdapterDetour.a(obj2, -2011802795);
                this.f13178d.aZ.setRefreshing(false);
                FriendRequestsFragment.m14845a(this.f13178d, this.f13178d.bg.isEmpty(), true);
                if (list.isEmpty()) {
                    FriendRequestsFragment.av(this.f13178d);
                } else {
                    this.f13178d.be.a();
                }
            }

            protected final void m14827a(Throwable th) {
                FriendRequestsPerfLogger friendRequestsPerfLogger = this.f13178d.aC;
                MarkerConfig markerConfig = (MarkerConfig) FriendRequestsPerfLogger.f13202a.get(this.f13178d.bu);
                if (markerConfig != null) {
                    friendRequestsPerfLogger.f13205c.d(markerConfig);
                }
                FriendRequestsFragment.m14843a(this.f13178d, th);
                this.f13178d.aZ.setRefreshing(false);
                FriendRequestsFragment.aD(this.f13178d);
                FriendRequestsFragment.m14845a(this.f13178d, this.f13178d.bg.isEmpty(), false);
            }
        });
        m14845a(this, this.bg.isEmpty(), this.aN.a());
    }

    private void aw() {
        final boolean e = this.ax.e();
        this.aP.a();
        this.aN.a("FETCH_PYMK_TASK", new Callable<ListenableFuture<List<PersonYouMayKnow>>>(this) {
            final /* synthetic */ FriendRequestsFragment f13180b;

            public Object call() {
                if ((!e || this.f13180b.bg.m14922i() == 0) && !this.f13180b.be.f()) {
                    this.f13180b.be.a();
                }
                return this.f13180b.ax.a(10, this.f13180b.bu.peopleYouMayKnowLocation, FriendRequestsFragment.aS);
            }
        }, new AbstractDisposableFutureCallback<List<PersonYouMayKnow>>(this) {
            final /* synthetic */ FriendRequestsFragment f13182b;

            protected final void m14828a(Object obj) {
                List list = (List) obj;
                FriendRequestsFragment friendRequestsFragment = this.f13182b;
                if (!list.isEmpty() && friendRequestsFragment.bg.m14922i() == 0) {
                    FriendingClient friendingClient = friendRequestsFragment.ax;
                    Collection subList = list.subList(0, Math.min(5, list.size()));
                    PeopleYouMayKnowLocation peopleYouMayKnowLocation = friendRequestsFragment.bu.peopleYouMayKnowLocation;
                    String str = "[" + Joiner.on(", ").join(Collections2.a(subList, new 5(friendingClient))) + "]";
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("updatePeopleYouMayKnowHistory", new Params(str, Event.IMPRESSION, peopleYouMayKnowLocation));
                    ListenableFuture a = Futures.a(FriendingStartOperationHelper.a(BlueServiceOperationFactoryDetour.a(friendingClient.f, "friending_update_people_you_may_know_history", bundle, 1300982985)), Functions.constant(null));
                }
                if (e) {
                    this.f13182b.bg.m14919e();
                }
                if (!this.f13182b.ax.c()) {
                    this.f13182b.be.b();
                }
                this.f13182b.bg.m14913b(list);
                this.f13182b.aZ.setRefreshing(false);
                FriendRequestsFragment.m14845a(this.f13182b, this.f13182b.bg.isEmpty(), false);
            }

            protected final void m14829a(Throwable th) {
                FriendRequestsFragment.m14843a(this.f13182b, th);
                this.f13182b.aZ.setRefreshing(false);
                FriendRequestsFragment.aD(this.f13182b);
            }
        });
        m14845a(this, this.bg.isEmpty(), this.aN.a());
    }

    public static void m14845a(FriendRequestsFragment friendRequestsFragment, boolean z, boolean z2) {
        if (friendRequestsFragment.T != null) {
            friendRequestsFragment.bb.setVisibility(z ? 0 : 8);
            if (!z) {
                return;
            }
            if (z2) {
                friendRequestsFragment.bc.setVisibility(8);
                friendRequestsFragment.bd.setVisibility(0);
                friendRequestsFragment.bd.a();
            } else if (friendRequestsFragment.bC) {
                friendRequestsFragment.bc.setVisibility(8);
                friendRequestsFragment.bd.setVisibility(0);
                friendRequestsFragment.bd.a(friendRequestsFragment.jW_().getString(2131230811), new RetryClickedListener(friendRequestsFragment) {
                    final /* synthetic */ FriendRequestsFragment f13187a;

                    {
                        this.f13187a = r1;
                    }

                    public final void m14833a() {
                        FriendRequestsFragment.m14849j(this.f13187a, false);
                    }
                });
            } else {
                friendRequestsFragment.bc.setVisibility(0);
                friendRequestsFragment.bd.setVisibility(8);
            }
        }
    }

    public static void m14851l(FriendRequestsFragment friendRequestsFragment, boolean z) {
        friendRequestsFragment.br = String.valueOf(friendRequestsFragment.aP.a());
        if (friendRequestsFragment.aN.a()) {
            friendRequestsFragment.aN.c();
        }
        friendRequestsFragment.bC = false;
        friendRequestsFragment.bD = true;
        friendRequestsFragment.ax.h();
        friendRequestsFragment.m14850k(z);
    }

    public static void m14843a(FriendRequestsFragment friendRequestsFragment, Throwable th) {
        if (friendRequestsFragment.mx_()) {
            friendRequestsFragment.bC = true;
            friendRequestsFragment.be.a(friendRequestsFragment.jW_().getString(2131230811), new RetryClickedListener(friendRequestsFragment) {
                final /* synthetic */ FriendRequestsFragment f13188a;

                {
                    this.f13188a = r1;
                }

                public final void m14834a() {
                    this.f13188a.bC = false;
                    FriendRequestsFragment.av(this.f13188a);
                }
            });
            BLog.b(aR, th.toString());
        }
    }

    public static void m14844a(FriendRequestsFragment friendRequestsFragment, List list, boolean z) {
        if (!list.isEmpty() && z) {
            int min = Math.min(5, list.size());
            for (int i = 0; i < min; i++) {
                FriendRequest friendRequest = (FriendRequest) list.get(i);
                if (friendRequest != null) {
                    if (!StringUtil.a(new CharSequence[]{friendRequest.i, "friending_possibilities_imp"})) {
                        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
                        arrayNode.h(r0);
                        friendRequestsFragment.ap.c(new HoneyClientEvent(r3).a("tracking", arrayNode));
                    }
                }
            }
        }
    }

    private void aA() {
        m14852m(this, false);
    }

    public static void m14852m(FriendRequestsFragment friendRequestsFragment, boolean z) {
        if (friendRequestsFragment.aE != null && friendRequestsFragment.as != null && friendRequestsFragment.bs == null && friendRequestsFragment.bB && !friendRequestsFragment.as.j() && friendRequestsFragment.D()) {
            if (friendRequestsFragment.aE.a(Jewel.FRIEND_REQUESTS) != 0 || z) {
                friendRequestsFragment.bs = friendRequestsFragment.ax.a();
                friendRequestsFragment.ar.a(friendRequestsFragment.bs, new FutureCallback<Void>(friendRequestsFragment) {
                    final /* synthetic */ FriendRequestsFragment f13189a;

                    {
                        this.f13189a = r1;
                    }

                    public void onSuccess(@Nullable Object obj) {
                        this.f13189a.bt = 0;
                        this.f13189a.aE.a(Jewel.FRIEND_REQUESTS, 0);
                        this.f13189a.bs = null;
                    }

                    public void onFailure(Throwable th) {
                        this.f13189a.bs = null;
                    }
                });
            }
        }
    }

    public final String am_() {
        return TabTag.FriendRequests.analyticsTag;
    }

    private void aC() {
        if (this.aM.a()) {
            this.aL.a(ContentFragmentType.FRIEND_REQUESTS_FRAGMENT, getContext(), this.aZ, 2130772382);
        }
    }

    public static void aD(FriendRequestsFragment friendRequestsFragment) {
        ConnectionRetrySnackbarView connectionRetrySnackbarView = new ConnectionRetrySnackbarView(friendRequestsFragment.getContext());
        connectionRetrySnackbarView.setRetryClickListener(new OnClickListener(friendRequestsFragment) {
            final /* synthetic */ FriendRequestsFragment f13192a;

            {
                this.f13192a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1558732989);
                this.f13192a.ba.b();
                FriendRequestsFragment.m14849j(this.f13192a, true);
                Logger.a(2, EntryType.UI_INPUT_END, 301946806, a);
            }
        });
        friendRequestsFragment.ba = friendRequestsFragment.aO.a(connectionRetrySnackbarView, 10000);
        friendRequestsFragment.ba.i = friendRequestsFragment.aZ;
        friendRequestsFragment.ba.a();
    }
}
