package com.facebook.pages.identity.fragments.about;

import android.animation.LayoutTransition;
import android.animation.LayoutTransition.TransitionListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelUuid;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.ManualAnalyticsNavigationActivity;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.analytics.tagging.AnalyticsObjectProvider;
import com.facebook.analytics.tagging.AnalyticsObjectProvider.ObjectType;
import com.facebook.api.feed.FetchFollowUpFeedUnitParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.commerce.publishing.event.CommercePublishingEventBus;
import com.facebook.commerce.publishing.event.CommerceShopMutationEvent.CommerceShopMutationEventSubscriber;
import com.facebook.commerce.publishing.event.ProductItemMutationEvent.ProductItemMutationEventSubscriber;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.futures.FutureUtils;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.postactionvote.PostActionVoteController;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.nux.FeedNuxBubbleManager;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.feed.ui.GenericNotificationBanner.NotificationBannerType;
import com.facebook.feedplugins.pyml.controllers.HScrollFeedUnitView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.pages.PageViewReferrer;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.common.abtest.qe.ExperimentsForPagesCommonAbTestModule;
import com.facebook.pages.common.abtest.qe.PagesManagerLazyTabExperimentUtil;
import com.facebook.pages.common.constants.PagesAsyncTaskType;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.ScrollToReviewsCardEventSubscriber;
import com.facebook.pages.common.eventbus.PageEvents.UpdatePageDataEvent;
import com.facebook.pages.common.eventbus.PageEvents.UpdatePageDataEventSubscriber;
import com.facebook.pages.common.eventbus.subscribers.OverallStarRatingUpdatedSubscriber;
import com.facebook.pages.common.job_sequencer.PagesJobSequencer;
import com.facebook.pages.common.job_sequencer.SequencerSignal;
import com.facebook.pages.common.logging.analytics.NetworkFailureEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.PagesInternalAnalyticsLogger;
import com.facebook.pages.common.resulthandlers.ActivityResultHandlerResolver;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.NeedToShowSuggestedPagesEventSubscriber;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent.HeaderPerfLoggingEventType;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEventSubscriber;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageTimelineFirstLoadEventSubscriber;
import com.facebook.pages.common.sequencelogger.PageFirstStoriesSequenceLoggerHelper;
import com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper;
import com.facebook.pages.common.sequencelogger.PagesManagerStartupSequences;
import com.facebook.pages.common.sequencelogger.PagesManagerStartupSequencesHelper;
import com.facebook.pages.common.sequencelogger.PagesSequenceLoggerHelper;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionButton;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageHeaderCardView;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.common.surface.fragments.common.PagesFragmentWithUuid;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController.PageDataFetchType;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController.PageHeaderDataListener;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherControllerProvider;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderView;
import com.facebook.pages.common.util.PagesQuickPromotionUtils;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageGeneralDataModel.RedirectionInfoModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.fb4a.abtest.PagesFb4aAbTestGatekeepers;
import com.facebook.pages.identity.batching.PageCardsBatchingFetcher;
import com.facebook.pages.identity.batching.PageCardsBatchingFetcherProvider;
import com.facebook.pages.identity.cards.actionbar.PageMessageButtonNuxInterstitialController;
import com.facebook.pages.identity.cards.actionbar.PagesActionBar;
import com.facebook.pages.identity.cards.actionbar.PagesActionBarItemFactory.PageActionType;
import com.facebook.pages.identity.cards.actionbar.PagesActionBarSpecification;
import com.facebook.pages.identity.cards.chainsuggestions.PageIdentityPageSuggestionCardView;
import com.facebook.pages.identity.cards.contextitems.PageIdentityContextItemsHeaderCardSpecification;
import com.facebook.pages.identity.common.FbAndroidPageSurfaceConfigurationProvider;
import com.facebook.pages.identity.common.PageCardSpecifications.FetchType;
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.facebook.pages.identity.common.PageCardSpecifications.PageHeaderCardSpecification;
import com.facebook.pages.identity.common.PageCardSpecifications.PageIdentityCardSpecification;
import com.facebook.pages.identity.common.PageSurfaceConfigurationProvider;
import com.facebook.pages.identity.common.PageViewPlaceHolder;
import com.facebook.pages.identity.fragments.identity.PageIdentityFragment;
import com.facebook.pages.identity.fragments.identity.PageIdentityFragment.PageIdentityPagerAdapter.C05431;
import com.facebook.pages.identity.fragments.identity.PageIdentityFragment.PageIdentityPagerAdapter.C05442;
import com.facebook.pages.identity.timeline.PageIdentityInfinitePostsTimelineFragment;
import com.facebook.pages.identity.timeline.PageProfilePermissionsProviderImpl;
import com.facebook.pages.identity.timeline.PagesManagerProfilePicUpdateListener;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEvent;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.ui.QuickPromotionFooterController;
import com.facebook.quickpromotion.ui.QuickPromotionFooterFragment;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;
import com.facebook.quickpromotion.ui.QuickPromotionFragment.QuickPromotionFragmentHost;
import com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.reviews.event.ReviewEventBus;
import com.facebook.reviews.event.ReviewEvents;
import com.facebook.reviews.event.ReviewEvents.ViewerReviewEventSubscriber;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.api.GraphSearchQueryPlaceModifier;
import com.facebook.search.api.GraphSearchQueryProvider;
import com.facebook.timeline.profilepiccoverphotoupload.ProfilePicCoverPhotoUploadReceiver;
import com.facebook.timeline.profilepiccoverphotoupload.ProfilePicCoverPhotoUploadReceiver.ProfilePicCoverPhotoCallback;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.futures.FuturesManager;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ListScrollStateSnapshot;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.ScrollableListContainer;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.titlebar.FadingContentFragmentController;
import com.facebook.widget.titlebar.FadingContentView;
import com.facebook.widget.titlebar.FadingContentViewProvider;
import com.facebook.widget.titlebar.FadingFbTitleBar;
import com.facebook.widget.titlebar.FadingTitlebarContent;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: pending_privacy_edits */
public class PageAboutFragment extends FbFragment implements ManualAnalyticsNavigationActivity, AnalyticsFragment, AnalyticsFragmentWithExtraData, AnalyticsObjectProvider, PagesFragmentWithUuid, PageHeaderDataListener, QuickPromotionFragmentHost, GraphSearchQueryProvider, ScrollableListContainer, FadingContentViewProvider {
    public static final InterstitialTrigger aT = new InterstitialTrigger(Action.PAGE_ADMIN_TIMELINE_VIEW);
    public static final InterstitialTrigger aU = new InterstitialTrigger(Action.PAGE_ACTIONBAR);
    private static int aV;
    @Inject
    AdminedPagesRamCache f3929a;
    @Inject
    public PostActionVoteController aA;
    @Inject
    ProfilePicCoverPhotoUploadReceiver aB;
    @Inject
    Provider<FbEventSubscriberListManager> aC;
    @Inject
    ReviewEventBus aD;
    @Inject
    CommercePublishingEventBus aE;
    @Inject
    public TasksManager aF;
    @Inject
    public RapidFeedbackController aG;
    @Inject
    PageCallToActionUtil aH;
    @Inject
    GatekeeperStoreImpl aI;
    @Inject
    PagesJobSequencer aJ;
    @Inject
    PagesQuickPromotionUtils aK;
    @Inject
    PagesManagerLazyTabExperimentUtil aL;
    @Inject
    public Lazy<AndroidThreadUtil> aM;
    @Inject
    Lazy<BlueServiceOperationFactory> aN;
    @Inject
    public Lazy<FbErrorReporter> aO;
    @Inject
    public Lazy<InterstitialManager> aP;
    @Inject
    Lazy<QuickPromotionFragmentFactory> aQ;
    @Inject
    Lazy<PagesManagerProfilePicUpdateListener> aR;
    @Inject
    Lazy<ActivityResultHandlerResolver> aS;
    private final DeletePhotoEventSubscriber aW = new DeletePhotoEventSubscriber(this);
    private View aX;
    public PageIdentityInfinitePostsTimelineFragment aY;
    public ListViewProxy aZ;
    @Inject
    public FuturesManager al;
    @Inject
    InteractionLogger am;
    @Inject
    MonotonicClock an;
    @Inject
    OverallStarRatingUpdatedSubscriber ao;
    @Inject
    PageCardsBatchingFetcherProvider ap;
    @Inject
    PageEventBus aq;
    @Inject
    public PageFirstStoriesSequenceLoggerHelper ar;
    @Inject
    PageHeaderFetcherControllerProvider as;
    @Inject
    public PageHeaderSequenceLoggerHelper at;
    @Inject
    PagesAnalytics au;
    @Inject
    PagesInternalAnalyticsLogger av;
    @Inject
    PageScopedEventBus aw;
    @Inject
    PagesManagerStartupSequencesHelper ax;
    @Inject
    public PagesSequenceLoggerHelper ay;
    @Inject
    public FbAndroidPageSurfaceConfigurationProvider az;
    @Inject
    DefaultAppChoreographer f3930b;
    private PageCardType bA;
    private ListScrollStateSnapshot bB;
    private boolean bC = false;
    public TriState bD = TriState.UNSET;
    public ParcelUuid bE;
    public String bF;
    public int bG;
    private int bH;
    public Map<String, String> bI;
    private PageFragmentScopedHeaderPerfLoggingEventSubscriber bJ;
    private boolean bK;
    private PageFragmentScopedHeaderPerfLoggingEvent bL;
    public HeaderPerfLoggingEventType bM;
    private PageTimelineFirstLoadEventSubscriber bN;
    public boolean bO;
    public boolean bP;
    public boolean bQ = false;
    @Nullable
    private PageProfilePermissionsProviderImpl bR;
    private FbEventSubscriberListManager bS;
    private FbEventSubscriberListManager bT;
    private FbEventSubscriberListManager bU;
    private int bV;
    public FadingContentFragmentController bW;
    public C05431 bX;
    public C05442 bY;
    public List<View> bZ = Lists.b();
    public SwipeRefreshLayout ba;
    public FadingFbTitleBar bb;
    @Nullable
    public CaspianPagesHeaderView bc;
    public PageCallToActionButton bd;
    public DialogBasedProgressIndicator be;
    public View bf;
    public View bg;
    public View bh;
    private ViewGroup bi;
    public LinearLayout bj;
    private GenericNotificationBanner bk;
    private View bl;
    private QuickPromotionFooterFragment bm;
    public PageHeaderFetcherController bn;
    public PageCardsBatchingFetcher bo;
    private LayoutInflater bp;
    public boolean bq;
    public long br;
    private PageViewReferrer bs;
    public boolean bt = true;
    public Location bu;
    public PageHeaderData bv;
    private PageLoadingState bw = PageLoadingState.LOADING_NO_UNITS;
    public boolean bx = false;
    public boolean by = false;
    private long bz;
    @Inject
    AppStateManager f3931c;
    public final Map<PageCardType, PageIdentityCardSpecification> ca = Maps.c();
    public final Map<PageCardType, PageHeaderCardView> cb = Maps.c();
    public final Map<PageCardType, PageSecondaryCardView> cc = Maps.c();
    public final Map<PageCardType, PageViewPlaceHolder> cd = Maps.c();
    public final Handler ce = new Handler(Looper.getMainLooper());
    private final SettableFuture<Void> cf = SettableFuture.f();
    public Runnable cg = new C05281(this);
    public int ch = 0;
    public Runnable ci = new C05292(this);
    public ListenableFuture<Boolean> cj;
    public boolean ck = false;
    public PageDataFetchType cl = PageDataFetchType.DEFAULT;
    private Optional<View> cm = Absent.INSTANCE;
    private Optional<View> cn = Absent.INSTANCE;
    @Inject
    public ComposerLauncher f3932d;
    @Inject
    ConsumptionPhotoEventBus f3933e;
    @Inject
    FbAppType f3934f;
    @Inject
    FbNetworkManager f3935g;
    @Inject
    FbTitleBarSupplier f3936h;
    @Inject
    FeedNuxBubbleManager f3937i;

    /* compiled from: pending_privacy_edits */
    class C05281 implements Runnable {
        final /* synthetic */ PageAboutFragment f3912a;

        C05281(PageAboutFragment pageAboutFragment) {
            this.f3912a = pageAboutFragment;
        }

        public void run() {
            if (this.f3912a.hn_() && !this.f3912a.aZ.n()) {
                this.f3912a.aZ.e(0);
                HandlerDetour.b(this.f3912a.ce, this.f3912a.cg, 200, 546341349);
            }
        }
    }

    /* compiled from: pending_privacy_edits */
    class C05292 implements Runnable {
        final /* synthetic */ PageAboutFragment f3917a;

        C05292(PageAboutFragment pageAboutFragment) {
            this.f3917a = pageAboutFragment;
        }

        public void run() {
            if (this.f3917a.hn_()) {
                this.f3917a.bf.getLocationOnScreen(new int[2]);
                PageAboutFragment pageAboutFragment = this.f3917a;
                pageAboutFragment.ch++;
                HandlerDetour.b(this.f3917a.ce, this.f3917a.ci, 10, 317111543);
            }
        }
    }

    /* compiled from: pending_privacy_edits */
    class C05303 implements ProfilePicCoverPhotoCallback {
        final /* synthetic */ PageAboutFragment f3918a;

        C05303(PageAboutFragment pageAboutFragment) {
            this.f3918a = pageAboutFragment;
        }

        public final void m4813a() {
            this.f3918a.bn.m3465a(PageDataFetchType.FORCED_BY_USER);
            if (this.f3918a.getContext() != null) {
                PagesManagerProfilePicUpdateListener pagesManagerProfilePicUpdateListener = (PagesManagerProfilePicUpdateListener) this.f3918a.aR.get();
                this.f3918a.getContext();
                pagesManagerProfilePicUpdateListener.f4223a.a("com.facebook.intent.action.PROFILE_PIC_UPDATED");
            }
        }
    }

    /* compiled from: pending_privacy_edits */
    class C05336 implements OnRefreshListener {
        final /* synthetic */ PageAboutFragment f3921a;

        C05336(PageAboutFragment pageAboutFragment) {
            this.f3921a = pageAboutFragment;
        }

        public final void m4816a() {
            this.f3921a.bQ = true;
            this.f3921a.bn.m3465a(PageDataFetchType.FORCED_BY_USER);
        }
    }

    /* compiled from: pending_privacy_edits */
    class C05347 implements OnClickListener {
        final /* synthetic */ PageAboutFragment f3922a;

        C05347(PageAboutFragment pageAboutFragment) {
            this.f3922a = pageAboutFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1963885547);
            if (!this.f3922a.bv.c()) {
                this.f3922a.bg.setVisibility(0);
                this.f3922a.bh.setVisibility(8);
                this.f3922a.bn.m3465a(PageDataFetchType.FORCED_BY_USER);
            } else if (!this.f3922a.bq) {
                PageAboutFragment.m4829a(this.f3922a, PageDataFetchType.FORCED_BY_USER);
            }
            LogUtils.a(1294317892, a);
        }
    }

    /* compiled from: pending_privacy_edits */
    class C05358 implements Runnable {
        final /* synthetic */ PageAboutFragment f3923a;

        C05358(PageAboutFragment pageAboutFragment) {
            this.f3923a = pageAboutFragment;
        }

        public void run() {
            boolean z = false;
            if (!this.f3923a.bO && this.f3923a.ao() != null && !this.f3923a.ao().isFinishing() && this.f3923a.s() != null && !this.f3923a.s().g()) {
                int top = this.f3923a.bj.getTop();
                PageAboutFragment.aA(this.f3923a);
                if (this.f3923a.bv.e.y()) {
                    if (!this.f3923a.aY.mx_()) {
                        this.f3923a.s().b();
                        this.f3923a.aZ.a.scrollTo(0, -top);
                    }
                    this.f3923a.aY.m5143e();
                    PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment = this.f3923a.aY;
                    if (!this.f3923a.bq && this.f3923a.bv.e.y()) {
                        z = true;
                    }
                    pageIdentityInfinitePostsTimelineFragment.m5140b(z);
                    this.f3923a.aY.aI();
                }
            }
        }
    }

    /* compiled from: pending_privacy_edits */
    class C05389 extends UpdatePageDataEventSubscriber {
        final /* synthetic */ PageAboutFragment f3927a;

        /* compiled from: pending_privacy_edits */
        class C05372 extends AbstractDisposableFutureCallback {
            final /* synthetic */ C05389 f3926a;

            C05372(C05389 c05389) {
                this.f3926a = c05389;
            }

            protected final void m4817a(Object obj) {
            }

            protected final void m4818a(Throwable th) {
            }
        }

        C05389(PageAboutFragment pageAboutFragment) {
            this.f3927a = pageAboutFragment;
        }

        public final void m4819b(FbEvent fbEvent) {
            UpdatePageDataEvent updatePageDataEvent = (UpdatePageDataEvent) fbEvent;
            final Builder builder = new Builder();
            ImmutableList a = updatePageDataEvent.f1617a.mo40a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                PageCardType pageCardType = (PageCardType) a.get(i);
                if (this.f3927a.ca.containsKey(pageCardType)) {
                    PageIdentityCardSpecification pageIdentityCardSpecification = (PageIdentityCardSpecification) this.f3927a.ca.get(pageCardType);
                    if (pageIdentityCardSpecification != null) {
                        if (pageIdentityCardSpecification.mo80c() != FetchType.PRIMARY && pageIdentityCardSpecification.mo80c() != FetchType.EXTRA) {
                            builder.c((PageBatchFetchingCardSpecification) pageIdentityCardSpecification);
                        } else if (pageIdentityCardSpecification instanceof PageHeaderCardSpecification) {
                            PageAboutFragment.m4830a(this.f3927a, (PageHeaderCardSpecification) pageIdentityCardSpecification);
                            PageAboutFragment.aE(this.f3927a);
                        }
                    } else {
                        return;
                    }
                }
            }
            if (!builder.b().isEmpty() && this.f3927a.bo != null) {
                this.f3927a.aF.a(PagesAsyncTaskType.REFRESH_PAGE_CARDS, new Callable<ListenableFuture>(this) {
                    final /* synthetic */ C05389 f3925b;

                    public Object call() {
                        return this.f3925b.f3927a.bo.m4239a(this.f3925b.f3927a.bv, builder.b(), GraphQLCachePolicy.d, this.f3925b.f3927a);
                    }
                }, new C05372(this));
            }
        }
    }

    /* compiled from: pending_privacy_edits */
    class DeletePhotoEventSubscriber extends com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEventSubscriber {
        final /* synthetic */ PageAboutFragment f3928a;

        public DeletePhotoEventSubscriber(PageAboutFragment pageAboutFragment) {
            this.f3928a = pageAboutFragment;
        }

        public final void m4820b(FbEvent fbEvent) {
            DeletePhotoEvent deletePhotoEvent = (DeletePhotoEvent) fbEvent;
            if (this.f3928a.bv.e.u() != null && this.f3928a.bv.e.u().j() != null && Objects.equal(this.f3928a.bv.e.u().j().l(), String.valueOf(deletePhotoEvent.c))) {
                this.f3928a.bc.m3552g();
            }
        }
    }

    /* compiled from: pending_privacy_edits */
    enum PageLoadingState {
        LOADING_NO_UNITS,
        LOADING_BINDING_UNITS,
        LOADING_UNITS_PRESENT,
        LOADED,
        ERROR
    }

    public static void m4832a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PageAboutFragment) obj).m4821a(AdminedPagesRamCache.a(injectorLike), DefaultAppChoreographer.a(injectorLike), AppStateManager.a(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ConsumptionPhotoEventBus.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), FbNetworkManager.a(injectorLike), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), FeedNuxBubbleManager.a(injectorLike), FuturesManager.a(injectorLike), InteractionLogger.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), OverallStarRatingUpdatedSubscriber.m2441a(injectorLike), (PageCardsBatchingFetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PageCardsBatchingFetcherProvider.class), PageEventBus.m2423a(injectorLike), PageFirstStoriesSequenceLoggerHelper.a(injectorLike), (PageHeaderFetcherControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PageHeaderFetcherControllerProvider.class), PageHeaderSequenceLoggerHelper.a(injectorLike), PagesAnalytics.a(injectorLike), PagesInternalAnalyticsLogger.a(injectorLike), PageScopedEventBus.a(injectorLike), PagesManagerStartupSequencesHelper.a(injectorLike), PagesSequenceLoggerHelper.a(injectorLike), FbAndroidPageSurfaceConfigurationProvider.m4754a(injectorLike), PostActionVoteController.a(injectorLike), ProfilePicCoverPhotoUploadReceiver.a(injectorLike), IdBasedProvider.a(injectorLike, 973), ReviewEventBus.a(injectorLike), CommercePublishingEventBus.a(injectorLike), TasksManager.a(injectorLike), RapidFeedbackController.a(injectorLike), PageCallToActionUtil.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), PagesJobSequencer.m2443a(injectorLike), PagesQuickPromotionUtils.a(injectorLike), PagesManagerLazyTabExperimentUtil.a(injectorLike), IdBasedLazy.a(injectorLike, 517), IdBasedLazy.a(injectorLike, 1144), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 2360), IdBasedSingletonScopeProvider.b(injectorLike, 9822), IdBasedSingletonScopeProvider.b(injectorLike, 9105), IdBasedLazy.a(injectorLike, 8972));
    }

    private void m4821a(AdminedPagesRamCache adminedPagesRamCache, AppChoreographer appChoreographer, AppStateManager appStateManager, ComposerLauncher composerLauncher, ConsumptionPhotoEventBus consumptionPhotoEventBus, FbAppType fbAppType, FbNetworkManager fbNetworkManager, FbTitleBarSupplier fbTitleBarSupplier, FeedNuxBubbleManager feedNuxBubbleManager, FuturesManager futuresManager, InteractionLogger interactionLogger, MonotonicClock monotonicClock, OverallStarRatingUpdatedSubscriber overallStarRatingUpdatedSubscriber, PageCardsBatchingFetcherProvider pageCardsBatchingFetcherProvider, PageEventBus pageEventBus, PageFirstStoriesSequenceLoggerHelper pageFirstStoriesSequenceLoggerHelper, PageHeaderFetcherControllerProvider pageHeaderFetcherControllerProvider, PageHeaderSequenceLoggerHelper pageHeaderSequenceLoggerHelper, PagesAnalytics pagesAnalytics, PagesInternalAnalyticsLogger pagesInternalAnalyticsLogger, PageScopedEventBus pageScopedEventBus, PagesManagerStartupSequencesHelper pagesManagerStartupSequencesHelper, PagesSequenceLoggerHelper pagesSequenceLoggerHelper, PageSurfaceConfigurationProvider pageSurfaceConfigurationProvider, PostActionVoteController postActionVoteController, ProfilePicCoverPhotoUploadReceiver profilePicCoverPhotoUploadReceiver, Provider<FbEventSubscriberListManager> provider, ReviewEventBus reviewEventBus, CommercePublishingEventBus commercePublishingEventBus, TasksManager tasksManager, RapidFeedbackController rapidFeedbackController, PageCallToActionUtil pageCallToActionUtil, GatekeeperStore gatekeeperStore, PagesJobSequencer pagesJobSequencer, PagesQuickPromotionUtils pagesQuickPromotionUtils, PagesManagerLazyTabExperimentUtil pagesManagerLazyTabExperimentUtil, Lazy<AndroidThreadUtil> lazy, Lazy<BlueServiceOperationFactory> lazy2, Lazy<FbErrorReporter> lazy3, Lazy<InterstitialManager> lazy4, Lazy<QuickPromotionFragmentFactory> lazy5, Lazy<PagesManagerProfilePicUpdateListener> lazy6, Lazy<ActivityResultHandlerResolver> lazy7) {
        this.f3929a = adminedPagesRamCache;
        this.f3930b = appChoreographer;
        this.f3931c = appStateManager;
        this.f3932d = composerLauncher;
        this.f3933e = consumptionPhotoEventBus;
        this.f3934f = fbAppType;
        this.f3935g = fbNetworkManager;
        this.f3936h = fbTitleBarSupplier;
        this.f3937i = feedNuxBubbleManager;
        this.al = futuresManager;
        this.am = interactionLogger;
        this.an = monotonicClock;
        this.ao = overallStarRatingUpdatedSubscriber;
        this.ap = pageCardsBatchingFetcherProvider;
        this.aq = pageEventBus;
        this.ar = pageFirstStoriesSequenceLoggerHelper;
        this.as = pageHeaderFetcherControllerProvider;
        this.at = pageHeaderSequenceLoggerHelper;
        this.au = pagesAnalytics;
        this.av = pagesInternalAnalyticsLogger;
        this.aw = pageScopedEventBus;
        this.ax = pagesManagerStartupSequencesHelper;
        this.ay = pagesSequenceLoggerHelper;
        this.az = pageSurfaceConfigurationProvider;
        this.aA = postActionVoteController;
        this.aB = profilePicCoverPhotoUploadReceiver;
        this.aC = provider;
        this.aD = reviewEventBus;
        this.aE = commercePublishingEventBus;
        this.aF = tasksManager;
        this.aG = rapidFeedbackController;
        this.aH = pageCallToActionUtil;
        this.aI = gatekeeperStore;
        this.aJ = pagesJobSequencer;
        this.aK = pagesQuickPromotionUtils;
        this.aL = pagesManagerLazyTabExperimentUtil;
        this.aM = lazy;
        this.aN = lazy2;
        this.aO = lazy3;
        this.aP = lazy4;
        this.aQ = lazy5;
        this.aR = lazy6;
        this.aS = lazy7;
    }

    public final void m4855c(@Nullable Bundle bundle) {
        Object obj;
        boolean z = false;
        super.c(bundle);
        if (!(ao() == null || ao().getTheme() == null)) {
            ao().getTheme().applyStyle(2131625518, true);
        }
        Class cls = PageAboutFragment.class;
        m4832a((Object) this, getContext());
        this.f3930b.a(this.cf);
        Bundle bundle2 = this.s;
        this.br = bundle2.getLong("com.facebook.katana.profile.id", -1);
        Preconditions.checkArgument(this.br > 0, "Invalid page id: " + this.br);
        this.bu = (Location) bundle2.getParcelable("extra_user_location");
        this.bP = bundle2.getBoolean("extra_in_admin_container_frag", false);
        if (bundle2.containsKey("page_view_referrer")) {
            this.bs = (PageViewReferrer) bundle2.getSerializable("page_view_referrer");
        } else {
            this.bs = PageViewReferrer.UNKNOWN;
        }
        this.au.c(this.br, this.bs);
        this.bE = (ParcelUuid) bundle2.getParcelable("page_fragment_uuid");
        if (this.bE == null) {
            ((AbstractFbErrorReporter) this.aO.get()).b(getClass().getName(), "queryInterface returns null for mPageFragmentUuid ");
        } else {
            this.bF = this.bE.toString();
        }
        if (this.f3934f.j == Product.PAA) {
            z = true;
        }
        this.bq = z;
        this.bD = this.bq ? TriState.YES : TriState.UNSET;
        if (!this.bq) {
            this.f3932d.a(1756, ao());
        }
        this.bB = new ListScrollStateSnapshot();
        aq();
        this.bp = LayoutInflater.from(getContext());
        this.bv = new PageHeaderData(this.br, this.bu);
        this.bn = this.as.m3467a(this, Long.valueOf(this.br), this.bs, this.bF);
        this.bn.m3465a(PageDataFetchType.DEFAULT);
        this.bz = this.an.now();
        this.am.a(true);
        this.aB.a(new C05303(this));
        aB();
        if (this.f3933e != null) {
            this.f3933e.a(this.aW);
        }
        PagesManagerStartupSequencesHelper pagesManagerStartupSequencesHelper = this.ax;
        if (pagesManagerStartupSequencesHelper.a.e(PagesManagerStartupSequences.a) == null && pagesManagerStartupSequencesHelper.a.e(PagesManagerStartupSequences.b) == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            if (this.f3931c.V || this.f3931c.U) {
                this.ax.a.d(PagesManagerStartupSequences.a);
            } else {
                this.ax.a.d(PagesManagerStartupSequences.b);
            }
        }
        if (!this.bq) {
            this.bN = new PageTimelineFirstLoadEventSubscriber(this, this.bE) {
                final /* synthetic */ PageAboutFragment f3919b;

                public final void m4814b(FbEvent fbEvent) {
                    PageAboutFragment pageAboutFragment = this.f3919b;
                    Object obj = 1;
                    Preconditions.checkState(pageAboutFragment.bv.c());
                    PageMessageButtonNuxInterstitialController pageMessageButtonNuxInterstitialController = (PageMessageButtonNuxInterstitialController) ((InterstitialManager) pageAboutFragment.aP.get()).a(PageAboutFragment.aU, PageMessageButtonNuxInterstitialController.class);
                    if (pageMessageButtonNuxInterstitialController != null) {
                        Object obj2;
                        PageHeaderData pageHeaderData = pageAboutFragment.bv;
                        if (pageHeaderData == null || pageHeaderData.e == null || pageHeaderData.e.E() == null || !pageHeaderData.e.E().a()) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        if (obj2 != null) {
                            Object obj3;
                            if (pageAboutFragment.aZ.d().j != 0) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            View findViewById = ((PagesActionBar) pageAboutFragment.cb.get(PageCardType.ACTION_BAR)).findViewById(PageActionType.MESSAGE.ordinal());
                            Rect rect = new Rect();
                            if (!(findViewById != null && findViewById.getGlobalVisibleRect(rect) && rect.height() == findViewById.getHeight())) {
                                obj = null;
                            }
                            if (obj3 == null && r4 != null) {
                                Tooltip tooltip = new Tooltip(pageAboutFragment.getContext(), 2);
                                tooltip.a(Position.ABOVE);
                                tooltip.t = -1;
                                tooltip.b(2131235537);
                                tooltip.f(findViewById);
                                pageMessageButtonNuxInterstitialController.d();
                            }
                        }
                    }
                }
            };
            this.aw.a(this.bN);
        }
        if (bundle != null) {
            this.bu = (Location) bundle.getParcelable("extra_user_location");
            this.bt = bundle.getBoolean("extra_should_show_qp_for_admin");
            this.bD = TriState.fromDbValue(bundle.getInt("extra_is_admin"));
        }
        ax();
        int i = aV + 1;
        aV = i;
        this.bV = i;
    }

    private void aq() {
        this.bH = (((1 << HeaderPerfLoggingEventType.HEADER_DISPATCH_DRAW_HAS_DATA.ordinal()) | (1 << HeaderPerfLoggingEventType.COVER_PHOTO_COMPLETE.ordinal())) | (1 << HeaderPerfLoggingEventType.PROFILE_PHOTO_COMPLETE.ordinal())) | (1 << HeaderPerfLoggingEventType.CONTEXT_ITEMS_DISPATCH_DRAW.ordinal());
        if (!this.bq) {
            this.bH |= 1 << HeaderPerfLoggingEventType.IS_ADMIN_KNOWN.ordinal();
        }
        this.bL = new PageFragmentScopedHeaderPerfLoggingEvent(this.bE, HeaderPerfLoggingEventType.IS_ADMIN_KNOWN, Absent.INSTANCE);
        this.bJ = new PageFragmentScopedHeaderPerfLoggingEventSubscriber(this, this.bE) {
            final /* synthetic */ PageAboutFragment f3920b;

            public final void m4815b(FbEvent fbEvent) {
                PageFragmentScopedHeaderPerfLoggingEvent pageFragmentScopedHeaderPerfLoggingEvent = (PageFragmentScopedHeaderPerfLoggingEvent) fbEvent;
                if (this.f3920b.bI == null) {
                    this.f3920b.bI = Maps.c();
                }
                this.f3920b.bM = pageFragmentScopedHeaderPerfLoggingEvent.c;
                if (pageFragmentScopedHeaderPerfLoggingEvent.c == HeaderPerfLoggingEventType.CONTEXT_ITEMS_DISPATCH_DRAW) {
                    this.f3920b.ax.b("ContainerFragmentOnCreateToContextItemsRendered");
                    this.f3920b.at.c("ContainerFragmentOnCreateToContextItemsRendered", this.f3920b.bF, null);
                }
                if (pageFragmentScopedHeaderPerfLoggingEvent.b.isPresent()) {
                    this.f3920b.bI.put(pageFragmentScopedHeaderPerfLoggingEvent.c.perfTagName, pageFragmentScopedHeaderPerfLoggingEvent.b.toString());
                }
                if (pageFragmentScopedHeaderPerfLoggingEvent.d != null) {
                    this.f3920b.bI.putAll(pageFragmentScopedHeaderPerfLoggingEvent.d);
                }
                PageAboutFragment pageAboutFragment = this.f3920b;
                pageAboutFragment.bG |= 1 << pageFragmentScopedHeaderPerfLoggingEvent.c.ordinal();
                PageAboutFragment.aP(this.f3920b);
                PageAboutFragment.aQ(this.f3920b);
            }
        };
        if (ar()) {
            this.aw.a(this.bJ);
        }
        if (!this.bq && !this.bP) {
            this.ar.a();
            this.ay.b(PageSequences.f);
            this.ay.a("PageCreateToFetchCards", PageSequences.f);
            this.ay.a("PageCreateToFirstCardLoad", PageSequences.f);
            this.at.a(this.bF).d(this.bF);
        }
    }

    private boolean ar() {
        return this.bF != null;
    }

    private void at() {
        if (this.aY == null) {
            this.aY = (PageIdentityInfinitePostsTimelineFragment) s().a("page_timeline_fragment_tag");
        }
        if (this.aY != null) {
            this.aY.m5138a(this.aZ);
            this.aY.az = aG();
        }
    }

    public final View m4846a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1326012556);
        super.a(this.bp, viewGroup, bundle);
        this.aX = this.bp.inflate(2130904437, viewGroup, false);
        View view = this.aX;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1081619688, a);
        return view;
    }

    public final void m4849a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.ba = (FbSwipeRefreshLayout) this.aX.findViewById(2131561342);
        this.aZ = new ListViewProxy((BetterListView) e(2131562192));
        this.bk = (GenericNotificationBanner) e(2131562193);
        LayoutInflater layoutInflater = this.bp;
        FbAndroidPageSurfaceConfigurationProvider fbAndroidPageSurfaceConfigurationProvider = this.az;
        this.bj = (LinearLayout) layoutInflater.inflate(2130906009, this.aZ.a, false);
        this.bj.setLayoutParams(new LayoutParams(-1, -2));
        this.aZ.d(this.bj);
        this.aZ.f(null);
        this.bh = FindViewUtil.b(this.bj, 2131565479);
        this.bg = FindViewUtil.b(this.bj, 2131565478);
        this.ba.e = new C05336(this);
        this.aZ.a(new ArrayAdapter(getContext(), 0));
        this.aZ.d(true);
        this.bh.setOnClickListener(new C05347(this));
        this.bc = (CaspianPagesHeaderView) FindViewUtil.b(this.bj, 2131565442);
        this.bc.setFragmentUuidForLogging(mo55h());
        this.bc.f2591t.mo64a(s());
        this.bd = (PageCallToActionButton) FindViewUtil.b(this.bj, 2131565443);
        this.bf = FindViewUtil.b(this.bj, 2131565480);
        this.bl = e(2131562194);
        Iterator it = this.az.f3787a.iterator();
        while (it.hasNext()) {
            PageIdentityCardSpecification pageIdentityCardSpecification = (PageIdentityCardSpecification) it.next();
            if (pageIdentityCardSpecification.mo77a()) {
                PageCardType b = pageIdentityCardSpecification.mo79b();
                Preconditions.checkNotNull(b);
                Optional a = FindViewUtil.a(this.bj, b.viewStubId);
                if (a.isPresent()) {
                    this.ca.put(b, pageIdentityCardSpecification);
                    this.cd.put(b, a.get());
                } else {
                    ((AbstractFbErrorReporter) this.aO.get()).b("page_identity_placeholder_missing_in_layout", b.toString());
                }
            }
        }
        at();
        if (this.bv.c()) {
            m4837b(PageDataFetchType.DEFAULT);
            if (this.bX != null) {
                Object b2;
                C05431 c05431 = this.bX;
                ImmutableList af = this.bv.e.af();
                if (this.bv.e.N() != null) {
                    b2 = this.bv.e.N().b();
                } else {
                    b2 = null;
                }
                c05431.m4870a(af, Optional.of(b2));
            }
            aT();
        } else if (this.bv.d()) {
            this.bc.setPageHeaderData(this.bv);
        }
        aw();
        m4827a(this.bw);
        this.ax.b("ContainerFragmentOnCreateToPageViewCreated");
        this.at.c("ContainerFragmentOnCreateToPageViewCreated", this.bF, null);
    }

    public final void m4852a(PageCardType pageCardType) {
        if (this.y) {
            m4841d(pageCardType);
        } else {
            this.bA = pageCardType;
        }
    }

    private void aw() {
        PageHeaderData pageHeaderData = this.bv;
        boolean z = false;
        if (pageHeaderData != null && pageHeaderData.d()) {
            if (this.bq) {
                z = pageHeaderData.a(Permission.CREATE_CONTENT);
            } else if (pageHeaderData.c() || pageHeaderData.a(Permission.BASIC_ADMIN)) {
                z = true;
            }
        }
        boolean z2 = z;
        if (((PagesActionBarSpecification) this.ca.get(PageCardType.ACTION_BAR)) != null) {
            PageHeaderCardView pageHeaderCardView = (PageHeaderCardView) this.cb.get(PageCardType.ACTION_BAR);
            if (pageHeaderCardView == null) {
                pageHeaderCardView = PagesActionBarSpecification.m4436a(getContext());
                this.cb.put(PageCardType.ACTION_BAR, pageHeaderCardView);
            }
            if (z2) {
                PageViewPlaceHolder pageViewPlaceHolder = (PageViewPlaceHolder) this.cd.get(PageCardType.ACTION_BAR);
                if (pageViewPlaceHolder == null) {
                    throw new IllegalStateException("Placeholder not found for card " + PageCardType.ACTION_BAR);
                }
                if (!m4834a(pageViewPlaceHolder)) {
                    pageViewPlaceHolder.m4758a((View) pageHeaderCardView);
                    ((View) pageHeaderCardView).setVisibility(0);
                }
                pageHeaderCardView.setParentFragment(this);
                pageHeaderCardView.mo29a(this.bv);
            }
        }
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 881872459);
        super.mi_();
        if (this.f3936h != null && (this.f3936h.get() instanceof FadingFbTitleBar)) {
            this.bb = (FadingFbTitleBar) this.f3936h.get();
        }
        if (!(this.bb == null || this.bq || this.bC)) {
            FadingTitlebarContent fadingTitlebarContent = (FadingTitlebarContent) a(FadingTitlebarContent.class);
            if (this.bW == null && fadingTitlebarContent != null) {
                this.bW = new FadingContentFragmentController();
                this.bW.a(this, this.bb, this.aZ, fadingTitlebarContent, true, true);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 179442483, a);
    }

    private void m4826a(FetchType fetchType, PageDataFetchType pageDataFetchType) {
        boolean z = true;
        switch (fetchType) {
            case PRIMARY:
                if (pageDataFetchType != PageDataFetchType.FORCED_SERVER_AFTER_CACHE_HIT) {
                    if (this.bq) {
                        m4827a(PageLoadingState.LOADED);
                    } else {
                        m4827a(PageLoadingState.LOADING_UNITS_PRESENT);
                    }
                    ay();
                    if (this.bq) {
                        aA(this);
                        return;
                    }
                    return;
                }
                return;
            case SECONDARY:
                PageIdentityInfinitePostsTimelineFragment pageIdentityInfinitePostsTimelineFragment;
                if (this.bq) {
                    if (this.aY != null && !pageDataFetchType.equals(PageDataFetchType.FORCED_SERVER_AFTER_CACHE_HIT)) {
                        s().b();
                        this.aY.m5143e();
                        pageIdentityInfinitePostsTimelineFragment = this.aY;
                        if (this.bq || !this.bv.e.y()) {
                            z = false;
                        }
                        pageIdentityInfinitePostsTimelineFragment.m5140b(z);
                        this.aY.aI();
                        return;
                    }
                    return;
                } else if (pageDataFetchType == PageDataFetchType.DEFAULT && this.aY != null && !this.aY.mx_()) {
                    HandlerDetour.a(this.ce, new C05358(this), 1351232310);
                    return;
                } else if (this.aY != null && this.aY.mx_() && !pageDataFetchType.equals(PageDataFetchType.FORCED_SERVER_AFTER_CACHE_HIT)) {
                    this.aY.m5143e();
                    pageIdentityInfinitePostsTimelineFragment = this.aY;
                    if (this.bq || !this.bv.e.y()) {
                        z = false;
                    }
                    pageIdentityInfinitePostsTimelineFragment.m5140b(z);
                    this.aY.aI();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ax() {
        /*
        r9 = this;
        r1 = 0;
        r2 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$FetchPageHeaderQueryModel$Builder;
        r2.<init>();
        r8 = r9.s;
        r0 = r8;
        r3 = "model_bundle_page_id";
        r3 = r0.getString(r3);
        r4 = "model_bundle_page_name";
        r4 = r0.getString(r4);
        r5 = "model_bundle_page_profile_pic_uri";
        r0 = r0.getString(r5);
        r5 = com.facebook.common.util.StringUtil.a(r3);
        if (r5 != 0) goto L_0x00c3;
    L_0x0021:
        r6 = r9.br;
        r5 = java.lang.String.valueOf(r6);
        r3 = r5.equals(r3);
        if (r3 == 0) goto L_0x00c3;
    L_0x002d:
        r3 = com.facebook.common.util.StringUtil.a(r4);
        if (r3 != 0) goto L_0x0035;
    L_0x0033:
        r2.v = r4;
    L_0x0035:
        r3 = com.facebook.common.util.StringUtil.a(r0);
        if (r3 != 0) goto L_0x00c3;
    L_0x003b:
        r3 = r9.f3929a;
        r4 = r9.br;
        r4 = java.lang.String.valueOf(r4);
        r3 = r3.b(r4);
        if (r3 == 0) goto L_0x0093;
    L_0x0049:
        r8 = r3.a;
        r4 = r8;
        if (r4 == 0) goto L_0x0093;
    L_0x004e:
        r5 = r4.d();
        r2.v = r5;
        if (r0 != 0) goto L_0x0067;
    L_0x0056:
        r5 = r4.km_();
        if (r5 == 0) goto L_0x0067;
    L_0x005c:
        r8 = r3.a;
        r0 = r8;
        r0 = r0.km_();
        r0 = r0.a();
    L_0x0067:
        r3 = r4.g();
        if (r3 == 0) goto L_0x00ac;
    L_0x006d:
        r3 = r4.g();
        r3 = com.google.common.collect.ImmutableList.copyOf(r3);
        r2.X = r3;
    L_0x0077:
        r3 = r4.b();
        if (r3 == 0) goto L_0x0093;
    L_0x007d:
        r3 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageAdminInfoBaseDataModel$Builder;
        r3.<init>();
        r4 = r4.b();
        r4 = r4.a();
        r3.a = r4;
        r3 = r3;
        r3 = r3.a();
        r2.d = r3;
    L_0x0093:
        r3 = com.facebook.common.util.StringUtil.a(r0);
        if (r3 != 0) goto L_0x00b9;
    L_0x0099:
        r3 = r9.at;
        r4 = "TimeToLowResProfilePicUri";
        r5 = r9.bF;
        r3.d(r4, r5, r1);
    L_0x00a2:
        r1 = r9.bv;
        r2 = r2.a();
        r1.a(r2, r0);
        return;
    L_0x00ac:
        r3 = com.facebook.ipc.pages.ProfilePermissions.Permission.BASIC_ADMIN;
        r3 = r3.name();
        r3 = com.google.common.collect.ImmutableList.of(r3);
        r2.X = r3;
        goto L_0x0077;
    L_0x00b9:
        r1 = r9.at;
        r3 = "TimeToLowResProfilePicUri";
        r4 = r9.bF;
        r1.a(r3, r4);
        goto L_0x00a2;
    L_0x00c3:
        r0 = r1;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.identity.fragments.about.PageAboutFragment.ax():void");
    }

    private void ay() {
        if (this.aY == null && this.bv.c() && this.bv.g().y()) {
            TracerDetour.a("maybeCreateTimelineFragment", -1259902687);
            try {
                this.aY = (PageIdentityInfinitePostsTimelineFragment) s().a("page_timeline_fragment_tag");
                if (this.aY != null) {
                    this.aY.m5138a(this.aZ);
                    this.aY.m5135a(aG());
                    return;
                }
                ProfilePermissions profilePermissions = null;
                if (!(this.bv == null || this.bv.g() == null)) {
                    profilePermissions = new ProfilePermissions(this.bv.g().af());
                }
                this.bR = new PageProfilePermissionsProviderImpl(profilePermissions, this.aO);
                this.aY = PageIdentityInfinitePostsTimelineFragment.m5125a(this.br, "page_only", this.bR, this.bE);
                this.aY.m5138a(this.aZ);
                this.aY.m5135a(aG());
                TracerDetour.a(-5859825);
            } finally {
                TracerDetour.a(-326346217);
            }
        }
    }

    public static boolean aA(PageAboutFragment pageAboutFragment) {
        if (!pageAboutFragment.bv.c()) {
            return false;
        }
        if (pageAboutFragment.bv.c() && !pageAboutFragment.bv.e.y()) {
            return false;
        }
        if (pageAboutFragment.bR != null) {
            pageAboutFragment.bR.f4220a = new ProfilePermissions(pageAboutFragment.bv.e.af());
        }
        if (pageAboutFragment.aY.mx_()) {
            return false;
        }
        if (!(pageAboutFragment.aY == null || pageAboutFragment.aY.mx_())) {
            pageAboutFragment.s().a().a(pageAboutFragment.aY, "page_timeline_fragment_tag").c();
        }
        return true;
    }

    private void aB() {
        this.bT = (FbEventSubscriberListManager) this.aC.get();
        this.bS = (FbEventSubscriberListManager) this.aC.get();
        this.bU = (FbEventSubscriberListManager) this.aC.get();
        this.bS.a(new ViewerReviewEventSubscriber(this) {
            final /* synthetic */ PageAboutFragment f3913a;

            {
                this.f3913a = r1;
            }

            public final void m4812a(String str, @Nullable ReviewWithFeedback reviewWithFeedback, @Nullable GraphQLStory graphQLStory) {
                if (!str.equals(String.valueOf(this.f3913a.br))) {
                    return;
                }
                if (this.f3913a.y) {
                    this.f3913a.aq.a(UpdatePageDataEvent.m2435b());
                } else {
                    this.f3913a.bx = true;
                }
            }

            public final void m4811a(String str) {
                if (str.equals(String.valueOf(this.f3913a.br))) {
                    this.f3913a.aq.a(UpdatePageDataEvent.m2436c());
                }
            }
        });
        this.bS.a(this.ao);
        this.bS.a(this.aD);
        this.bT.a(new C05389(this));
        this.aw.a(new NeedToShowSuggestedPagesEventSubscriber(this, this.bE) {
            final /* synthetic */ PageAboutFragment f3894b;

            /* compiled from: pending_privacy_edits */
            class C05261 extends OperationResultFutureCallback {
                final /* synthetic */ AnonymousClass10 f3893a;

                C05261(AnonymousClass10 anonymousClass10) {
                    this.f3893a = anonymousClass10;
                }

                protected final void m4801a(Object obj) {
                    FeedUnit feedUnit = (FeedUnit) ((OperationResult) obj).k();
                    if (feedUnit != null && (feedUnit instanceof GraphQLPagesYouMayLikeFeedUnit)) {
                        PageAboutFragment pageAboutFragment = this.f3893a.f3894b;
                        GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit = (GraphQLPagesYouMayLikeFeedUnit) feedUnit;
                        PageViewPlaceHolder pageViewPlaceHolder = (PageViewPlaceHolder) FindViewUtil.b(pageAboutFragment.bj, 2131565446);
                        PageIdentityPageSuggestionCardView pageIdentityPageSuggestionCardView = new PageIdentityPageSuggestionCardView(pageAboutFragment.getContext());
                        pageViewPlaceHolder.m4758a(pageIdentityPageSuggestionCardView);
                        if (pageIdentityPageSuggestionCardView.f3315b == null) {
                            pageIdentityPageSuggestionCardView.f3315b = graphQLPagesYouMayLikeFeedUnit;
                            View a = pageIdentityPageSuggestionCardView.a();
                            if (a != null) {
                                int id = pageIdentityPageSuggestionCardView.getId();
                                pageIdentityPageSuggestionCardView.setId(-1);
                                a.setId(id);
                                ((HScrollFeedUnitView) a).a(pageIdentityPageSuggestionCardView.f3315b, false);
                            }
                        }
                        pageIdentityPageSuggestionCardView.setVisibility(0);
                    }
                }

                protected final void m4800a(ServiceException serviceException) {
                    ((AbstractFbErrorReporter) this.f3893a.f3894b.aO.get()).b("page_fetch_feed_follup_fail", serviceException);
                }
            }

            public final void m4802b(FbEvent fbEvent) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("fetchFollowUpFeedUnitParamsKey", new FetchFollowUpFeedUnitParams(String.valueOf(this.f3894b.br), null, GraphQLFollowUpFeedUnitActionType.PAGE_LIKE));
                this.f3894b.aF.a(PagesAsyncTaskType.FETCH_FEED_FOLLOWUP_UNIT, BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) this.f3894b.aN.get(), "feed_fetch_followup_feed_unit", bundle, -1266110635).a(), new C05261(this));
            }
        });
        this.bT.a(new ScrollToReviewsCardEventSubscriber(this) {
            final /* synthetic */ PageAboutFragment f3895a;

            {
                this.f3895a = r1;
            }

            public final void m4803b(FbEvent fbEvent) {
                this.f3895a.m4852a(PageCardType.REVIEWS);
            }
        });
        this.bU.a(new ProductItemMutationEventSubscriber(this) {
            final /* synthetic */ PageAboutFragment f3896a;

            {
                this.f3896a = r1;
            }

            public final void m4804b(FbEvent fbEvent) {
                PageAboutFragment.aO(this.f3896a);
            }
        });
        this.bU.a(new CommerceShopMutationEventSubscriber(this) {
            final /* synthetic */ PageAboutFragment f3897a;

            {
                this.f3897a = r1;
            }

            public final void m4805b(FbEvent fbEvent) {
                PageAboutFragment.aO(this.f3897a);
            }
        });
        this.bU.a(this.aE);
    }

    private void m4825a(FetchPageHeaderQueryModel fetchPageHeaderQueryModel, PageDataFetchType pageDataFetchType, DataFreshnessResult dataFreshnessResult) {
        if (fetchPageHeaderQueryModel == null) {
            ((AbstractFbErrorReporter) this.aO.get()).b("page_identity_data_graphql_returned_null", "Page header model is null: is from network == " + (dataFreshnessResult.equals(DataFreshnessResult.FROM_SERVER) ? "true" : "false"));
            ba();
            return;
        }
        this.bv.a(fetchPageHeaderQueryModel, dataFreshnessResult);
        m4824a(pageDataFetchType, true);
    }

    private void m4824a(PageDataFetchType pageDataFetchType, boolean z) {
        if (new ProfilePermissions(this.bv.e.af()).a(Permission.BASIC_ADMIN)) {
            this.bD = TriState.YES;
        } else {
            this.bD = TriState.NO;
        }
        this.aw.a(this.bL);
        if (pageDataFetchType.equals(PageDataFetchType.DEFAULT)) {
            if (this.bD.asBoolean(false) && !this.bq) {
                if (z) {
                    this.at.a("FetchPageAdminDataFromServer", this.bF);
                    this.at.c("FetchPageAdminDataFromCache", this.bF, null);
                } else {
                    this.at.c("FetchPageAdminDataFromServer", this.bF, null);
                    this.at.a("FetchPageAdminDataFromCache", this.bF);
                }
            }
            m4827a(PageLoadingState.LOADING_BINDING_UNITS);
        }
        m4837b(pageDataFetchType);
        if (this.bX != null) {
            Object b;
            C05431 c05431 = this.bX;
            ImmutableList af = this.bv.e.af();
            if (this.bv.e.N() != null) {
                b = this.bv.e.N().b();
            } else {
                b = null;
            }
            c05431.m4870a(af, Optional.of(b));
        }
        aT();
        if (this.bq) {
            this.ba.setRefreshing(false);
            m4827a(PageLoadingState.LOADED);
            m4842d(pageDataFetchType);
        } else if (pageDataFetchType != PageDataFetchType.FORCED_SERVER_AFTER_CACHE_HIT) {
            m4829a(this, pageDataFetchType);
        }
    }

    public final void mo53a(GraphQLResult<FetchPageHeaderQueryModel> graphQLResult, PageDataFetchType pageDataFetchType) {
        if (graphQLResult.freshness == DataFreshnessResult.FROM_SERVER && graphQLResult.e != null) {
            Object obj;
            CharSequence charSequence;
            if (((FetchPageHeaderQueryModel) graphQLResult.e).af() == null || !new ProfilePermissions(((FetchPageHeaderQueryModel) graphQLResult.e).af()).a(Permission.BASIC_ADMIN)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (((FetchPageHeaderQueryModel) graphQLResult.e).N() == null || StringUtil.a(((FetchPageHeaderQueryModel) graphQLResult.e).N().b())) {
                charSequence = null;
            } else {
                charSequence = ((FetchPageHeaderQueryModel) graphQLResult.e).N().b();
            }
            if (obj == null) {
                this.f3929a.a(String.valueOf(this.br));
            } else {
                Boolean valueOf;
                Optional optional;
                AdminedPagesRamCache adminedPagesRamCache = this.f3929a;
                String valueOf2 = String.valueOf(this.br);
                String D = ((FetchPageHeaderQueryModel) graphQLResult.e).D();
                ImmutableList af = ((FetchPageHeaderQueryModel) graphQLResult.e).af();
                if (((FetchPageHeaderQueryModel) graphQLResult.e).l() != null) {
                    valueOf = Boolean.valueOf(((FetchPageHeaderQueryModel) graphQLResult.e).l().a());
                } else {
                    valueOf = null;
                }
                if (StringUtil.a(charSequence)) {
                    optional = Absent.INSTANCE;
                } else {
                    optional = Optional.of(charSequence);
                }
                adminedPagesRamCache.a(valueOf2, D, af, null, valueOf, optional);
            }
        }
        if (m4833a((GraphQLResult) graphQLResult)) {
            m4835b((GraphQLResult) graphQLResult);
        } else if (m4840c((GraphQLResult) graphQLResult)) {
            aS();
        } else {
            m4825a((FetchPageHeaderQueryModel) graphQLResult.e, pageDataFetchType, graphQLResult.freshness);
            if (graphQLResult.e != null) {
                Fragment fragment = this.G;
                if (fragment != null && (fragment instanceof PageHeaderDataListener)) {
                    ((PageHeaderDataListener) fragment).mo53a(graphQLResult, pageDataFetchType);
                }
            }
        }
    }

    public final void mo54a(Throwable th) {
        m4827a(PageLoadingState.ERROR);
        if (!(this.f3935g.d() || this.bk == null)) {
            this.bk.a(NotificationBannerType.NO_CONNECTION);
        }
        this.au.a(NetworkFailureEvent.EVENT_PAGE_DETAILS_LOAD_ERROR, this.br);
        this.ax.a();
        bb();
        ((AbstractFbErrorReporter) this.aO.get()).a("page_identity_data_fetch_fail", th.getMessage());
    }

    public static void aC(PageAboutFragment pageAboutFragment) {
        pageAboutFragment.ba.setRefreshing(false);
        pageAboutFragment.m4827a(PageLoadingState.LOADED);
        pageAboutFragment.m4842d(PageDataFetchType.DEFAULT);
    }

    public static void m4829a(PageAboutFragment pageAboutFragment, PageDataFetchType pageDataFetchType) {
        pageAboutFragment.ay.b("PageCreateToFetchCards", PageSequences.f);
        pageAboutFragment.ay.a("PageFetchCardsData", PageSequences.f);
        pageAboutFragment.ay.a("PageLoadFirstCard", PageSequences.f);
        pageAboutFragment.ay.a("PageLoadLastCard", PageSequences.f);
        if (pageAboutFragment.bo == null) {
            pageAboutFragment.bo = pageAboutFragment.ap.m4240a(pageAboutFragment.getContext(), pageAboutFragment.bp, Long.valueOf(pageAboutFragment.br), pageAboutFragment.cd);
        }
        pageAboutFragment.ck = false;
        pageAboutFragment.cl = pageDataFetchType;
        pageAboutFragment.cj = pageAboutFragment.bo.m4238a(pageAboutFragment.bv, pageAboutFragment.aY, pageDataFetchType == PageDataFetchType.DEFAULT ? GraphQLCachePolicy.a : GraphQLCachePolicy.d, (FbFragment) pageAboutFragment);
        pageAboutFragment.f3930b.a(pageAboutFragment.cj);
        pageAboutFragment.aF.a(PagesAsyncTaskType.FETCH_PAGE_IDENTITY_SECONDARY_DATA_BATCHING, new Callable<ListenableFuture>(pageAboutFragment) {
            final /* synthetic */ PageAboutFragment f3898a;

            {
                this.f3898a = r1;
            }

            public Object call() {
                return this.f3898a.cj;
            }
        }, new AbstractDisposableFutureCallback(pageAboutFragment) {
            final /* synthetic */ PageAboutFragment f3899a;

            {
                this.f3899a = r1;
            }

            protected final void m4806a(Object obj) {
                this.f3899a.ck = true;
                this.f3899a.ay.b("PageFetchCardsData", PageSequences.f);
                PageAboutFragment.aC(this.f3899a);
            }

            protected final void m4807a(Throwable th) {
                this.f3899a.ck = true;
                PageAboutFragment.m4831a(this.f3899a, th.getMessage());
            }
        });
    }

    public static void m4831a(PageAboutFragment pageAboutFragment, String str) {
        pageAboutFragment.m4827a(PageLoadingState.ERROR);
        if (!(pageAboutFragment.f3935g.d() || pageAboutFragment.bk == null)) {
            pageAboutFragment.bk.a(NotificationBannerType.NO_CONNECTION);
        }
        ((AbstractFbErrorReporter) pageAboutFragment.aO.get()).a("page_identity_data_fetch_fail", str);
        pageAboutFragment.ay.c(PageSequences.f);
    }

    private void m4837b(PageDataFetchType pageDataFetchType) {
        Preconditions.checkNotNull(this.bv);
        Preconditions.checkArgument(this.bv.c());
        if (mx_() && this.aX != null) {
            if (this.bY != null) {
                C05442 c05442 = this.bY;
                PageIdentityFragment.m4879a(c05442.f3943a.f3945a, this.bv.e.D());
            }
            if (!(this.bq || this.bP || StringUtil.a(this.bv.e.D()))) {
                HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
                if (hasTitleBar != null) {
                    hasTitleBar.setCustomTitle(null);
                    hasTitleBar.kg_();
                    hasTitleBar.a_(this.bv.e.D());
                }
            }
            this.bc.setPageHeaderData(this.bv);
            if (!(this.bb == null || this.bq || this.bW == null || this.bc.a())) {
                this.bW.a();
            }
            m4839c(pageDataFetchType);
            if (this.bv.e.K().equals(GraphQLPlaceType.CITY)) {
                this.aG.a("667920690005633", getContext());
            }
        }
    }

    private void m4839c(PageDataFetchType pageDataFetchType) {
        this.bZ.clear();
        FetchType fetchType = FetchType.PRIMARY;
        PageCardType[] values = PageCardType.values();
        int length = values.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            PageIdentityCardSpecification pageIdentityCardSpecification = (PageIdentityCardSpecification) this.ca.get(values[i]);
            if (pageIdentityCardSpecification != null && (fetchType.ordinal() <= pageIdentityCardSpecification.mo80c().ordinal() || r2 != null)) {
                if (fetchType.ordinal() < pageIdentityCardSpecification.mo80c().ordinal()) {
                    break;
                }
                obj = 1;
                if (fetchType == FetchType.PRIMARY && (pageIdentityCardSpecification instanceof PageHeaderCardSpecification)) {
                    m4830a(this, (PageHeaderCardSpecification) pageIdentityCardSpecification);
                }
            }
            i++;
            obj = obj;
        }
        if (PageCallToActionUtil.a(this.bv)) {
            this.bd.a(this.bv);
            this.bd.setVisibility(0);
        } else {
            this.bd.setVisibility(8);
        }
        aE(this);
        m4826a(FetchType.PRIMARY, pageDataFetchType);
    }

    private void m4842d(PageDataFetchType pageDataFetchType) {
        if (mx_() && this.aX != null) {
            m4826a(FetchType.SECONDARY, pageDataFetchType);
            m4827a(PageLoadingState.LOADED);
            if (this.bq) {
                PagesManagerLazyTabExperimentUtil pagesManagerLazyTabExperimentUtil = this.aL;
                int i = -1;
                if (pagesManagerLazyTabExperimentUtil.b.j == Product.PAA) {
                    i = pagesManagerLazyTabExperimentUtil.a.a(ExperimentsForPagesCommonAbTestModule.a, -1);
                }
                if (i > 0) {
                    this.aJ.m2450a("pma_" + this.br, ImmutableSet.of(SequencerSignal.PMA_ABOUT_FRAGMENT_ALL_CARDS_LOADED));
                    return;
                }
                return;
            }
            this.ay.b("PageLoadLastCard", PageSequences.f);
        }
    }

    public static void aE(PageAboutFragment pageAboutFragment) {
        for (View visibility : pageAboutFragment.bZ) {
            visibility.setVisibility(0);
        }
        pageAboutFragment.bZ.clear();
    }

    public static void m4830a(PageAboutFragment pageAboutFragment, PageHeaderCardSpecification pageHeaderCardSpecification) {
        boolean mx_ = pageAboutFragment.mx_();
        boolean z = pageAboutFragment.L;
        if (pageHeaderCardSpecification == null || pageHeaderCardSpecification.mo79b() == null || !pageAboutFragment.cd.containsKey(pageHeaderCardSpecification.mo79b())) {
            ((AbstractFbErrorReporter) pageAboutFragment.aO.get()).a("page_identity_placeholder_missing", pageHeaderCardSpecification.mo79b().toString());
        } else if (pageHeaderCardSpecification.mo78a(pageAboutFragment.bv)) {
            PageViewPlaceHolder pageViewPlaceHolder = (PageViewPlaceHolder) pageAboutFragment.cd.get(pageHeaderCardSpecification.mo79b());
            if (pageViewPlaceHolder == null) {
                throw new IllegalStateException("Placeholder not found for card " + pageHeaderCardSpecification.mo79b() + "; Page ID: " + pageAboutFragment.bv.a + "; Fragment added: " + mx_ + "; Fragment detached: " + z);
            }
            PageHeaderCardView pageHeaderCardView;
            if (pageAboutFragment.cb.containsKey(pageHeaderCardSpecification.mo79b())) {
                pageHeaderCardView = (PageHeaderCardView) pageAboutFragment.cb.get(pageHeaderCardSpecification.mo79b());
            } else {
                PageHeaderCardView pageHeaderCardView2 = (PageHeaderCardView) pageHeaderCardSpecification.mo76a(pageAboutFragment.bp, pageAboutFragment.getContext());
                pageAboutFragment.cb.put(pageHeaderCardSpecification.mo79b(), pageHeaderCardView2);
                pageHeaderCardView = pageHeaderCardView2;
            }
            if (pageHeaderCardView instanceof PagesActionBar) {
                ((PagesActionBar) pageHeaderCardView).setLoggingUuid(pageAboutFragment.bE);
            }
            if (!pageAboutFragment.m4834a(pageViewPlaceHolder)) {
                pageViewPlaceHolder.m4758a((View) pageHeaderCardView);
                pageAboutFragment.au.h(pageAboutFragment.bv.a, pageHeaderCardSpecification.mo79b().name());
                ((View) pageHeaderCardView).setVisibility(8);
            }
            pageHeaderCardView.setParentFragment(pageAboutFragment);
            pageHeaderCardView.mo29a(pageAboutFragment.bv);
            pageAboutFragment.bZ.add((View) pageHeaderCardView);
        } else {
            if (pageAboutFragment.cb.containsKey(pageHeaderCardSpecification.mo79b())) {
                ((View) pageAboutFragment.cb.get(pageHeaderCardSpecification.mo79b())).setVisibility(8);
            }
            if (pageHeaderCardSpecification instanceof PageIdentityContextItemsHeaderCardSpecification) {
                pageAboutFragment.bH &= (1 << HeaderPerfLoggingEventType.CONTEXT_ITEMS_DISPATCH_DRAW.ordinal()) ^ -1;
                pageAboutFragment.ax.e("ContainerFragmentOnCreateToContextItemsRendered");
                pageAboutFragment.at.a("ContainerFragmentOnCreateToContextItemsRendered", pageAboutFragment.bF);
                aP(pageAboutFragment);
                aQ(pageAboutFragment);
            }
        }
    }

    private boolean m4834a(PageViewPlaceHolder pageViewPlaceHolder) {
        return this.bj.findViewById(pageViewPlaceHolder.f3788a) != null;
    }

    public static void aF(PageAboutFragment pageAboutFragment) {
        if (pageAboutFragment.be != null) {
            if (pageAboutFragment.bz != 0) {
                pageAboutFragment.am.a(pageAboutFragment.an.now() - pageAboutFragment.bz);
                pageAboutFragment.bz = 0;
            }
            pageAboutFragment.be.b();
        }
    }

    public final void m4848a(int i, int i2, Intent intent) {
        Object obj;
        if (this.bT != null) {
            this.bT.a(this.aq);
        }
        if (i == 22805) {
            this.aA.a(getContext(), CrowdEntryPoint.POST_CALL, this.bv.a);
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            if (i2 == -1) {
                ActivityResultHandler a = ((ActivityResultHandlerResolver) this.aS.get()).m3200a(i);
                if (a != null) {
                    m4822a(a, intent, i);
                } else if (this.aY != null) {
                    this.aY.a(i, i2, intent);
                }
            } else if (i2 != 0) {
            } else {
                if (i == 10107 || i == 10108) {
                    this.aD.a(ReviewEvents.a(String.valueOf(this.br)));
                }
            }
        }
    }

    private void m4822a(final ActivityResultHandler activityResultHandler, Intent intent, int i) {
        ProfilePermissions profilePermissions;
        this.be = activityResultHandler.mo45a();
        if (this.be != null) {
            this.bz = this.an.now();
            this.am.a(true);
            this.be.a();
        }
        long j = this.br;
        if (this.bv.e != null) {
            profilePermissions = new ProfilePermissions(this.bv.e.af());
        } else {
            profilePermissions = null;
        }
        final ListenableFuture a = activityResultHandler.mo46a(j, profilePermissions, this, intent, i);
        if (a != null) {
            AnonymousClass16 anonymousClass16 = new OperationResultFutureCallback(this) {
                final /* synthetic */ PageAboutFragment f3902c;

                public final void m4809a(Object obj) {
                    OperationResult operationResult = (OperationResult) obj;
                    this.f3902c.al.a(a);
                    PageAboutFragment.aF(this.f3902c);
                    if (activityResultHandler.mo49b()) {
                        this.f3902c.bn.m3465a(PageDataFetchType.FORCED_BY_USER);
                    }
                    activityResultHandler.mo47a(operationResult);
                }

                protected final void m4808a(ServiceException serviceException) {
                    this.f3902c.al.a(a);
                    PageAboutFragment.aF(this.f3902c);
                    activityResultHandler.mo48a(serviceException);
                }

                protected final void m4810a(CancellationException cancellationException) {
                    super.a(cancellationException);
                    this.f3902c.al.a(a);
                    PageAboutFragment.aF(this.f3902c);
                }
            };
            ((DefaultAndroidThreadUtil) this.aM.get()).a(a, anonymousClass16);
            this.al.a(FutureAndCallbackHolder.a(a, anonymousClass16));
        }
    }

    private AnonymousClass17 aG() {
        return new Object(this) {
            public final /* synthetic */ PageAboutFragment f3903a;

            {
                this.f3903a = r1;
            }
        };
    }

    public final void m4857e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("extra_user_location", this.bu);
        bundle.putBoolean("extra_should_show_qp_for_admin", this.bt);
        bundle.putInt("extra_is_admin", this.bD.getDbValue());
    }

    public final ParcelUuid mo55h() {
        if (this.bE == null && this.s != null) {
            this.bE = (ParcelUuid) this.s.getParcelable("page_fragment_uuid");
        }
        return this.bE;
    }

    public final void m4843G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1343585629);
        super.G();
        this.bn.m3466b();
        if (this.cj != null) {
            if (this.cj.isCancelled()) {
                m4829a(this, this.cl);
            } else if (this.cj.isDone() && !this.ck) {
                this.aF.c(PagesAsyncTaskType.FETCH_PAGE_IDENTITY_SECONDARY_DATA_BATCHING);
                if (((Boolean) FutureUtils.a(this.cj)) != null) {
                    this.ck = true;
                    aC(this);
                } else {
                    m4829a(this, this.cl);
                }
            }
        }
        if (this.bT != null) {
            this.bT.a(this.aq);
        }
        if (this.bx) {
            this.aq.a(UpdatePageDataEvent.m2435b());
            this.bx = false;
        }
        if (this.bA != null) {
            m4841d(this.bA);
            this.bA = null;
        } else {
            this.aZ.d().b(this.bB);
        }
        if (this.by) {
            this.aq.a(UpdatePageDataEvent.m2437d());
            this.by = false;
        }
        aU();
        this.ax.b("ContainerFragmentOnCreateToPageAboutOnResume");
        this.at.c("ContainerFragmentOnCreateToPageAboutOnResume", this.bF, null);
        this.av.a(getContext(), this.br, GraphQLPagePresenceTabType.HOME);
        LogUtils.f(1531098856, a);
    }

    public final void m4844H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1247238258);
        super.H();
        aZ();
        this.aZ.d().a(this.bB);
        this.aA.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1457744571, a);
    }

    public final void m4845I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -212710469);
        if (this.aF != null) {
            this.aF.c();
        }
        this.bn.m3464a();
        super.I();
        this.aB.a();
        if (this.f3933e != null) {
            this.f3933e.b(this.aW);
        }
        this.aw.b(this.bJ);
        if (this.bS != null) {
            this.bS.b(this.aD);
        }
        if (this.bU != null) {
            this.bU.b(this.aE);
        }
        if (this.ba != null) {
            this.ba.e = null;
            this.ba = null;
        }
        this.aJ.m2451b(Long.toString(this.br), null);
        this.bO = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -911552655, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1700618222);
        super.mY_();
        this.cb.clear();
        this.cc.clear();
        this.cd.clear();
        this.ca.clear();
        if (this.f3937i != null) {
            this.f3937i.a(this.bi);
        }
        if (this.aZ != null) {
            this.aZ.a(null);
        }
        this.aZ = null;
        if (this.bc != null) {
            this.bc.m3551b();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -321287204, a);
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1191855322);
        super.dE_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1087579787, a);
    }

    private void m4827a(PageLoadingState pageLoadingState) {
        this.bw = pageLoadingState;
        if (this.bj != null) {
            switch (this.bw) {
                case LOADING_NO_UNITS:
                    this.bg.setVisibility(0);
                    this.bh.setVisibility(8);
                    return;
                case LOADING_BINDING_UNITS:
                    this.bg.setVisibility(8);
                    this.bh.setVisibility(8);
                    aK();
                    return;
                case LOADING_UNITS_PRESENT:
                    this.bg.setVisibility(0);
                    this.bh.setVisibility(8);
                    return;
                case ERROR:
                    if (this.bv.c()) {
                        this.bg.setVisibility(8);
                        this.bh.setVisibility(0);
                        aK();
                        return;
                    }
                    this.bg.setVisibility(8);
                    this.bh.setVisibility(0);
                    return;
                case LOADED:
                    this.bg.setVisibility(8);
                    this.bh.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    private void aK() {
        if (this.bz != 0 && this.am.a(this.an.now() - this.bz, this.bg)) {
            this.bz = 0;
        }
    }

    private void aL() {
        this.f3937i.b = 0;
        this.f3937i.a = jW_().getDimensionPixelSize(2131428115);
    }

    public final String am_() {
        return "pages_public_view";
    }

    public final Map<String, Object> m4854c() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("profile_id", Long.valueOf(this.br));
        return hashMap;
    }

    public final ObjectType m4847a() {
        return ObjectType.PAGES;
    }

    public final String m4856d() {
        return String.valueOf(this.br);
    }

    public final void m4850a(ViewGroup viewGroup) {
        this.bi = viewGroup;
        if (this.f3937i != null) {
            this.f3937i.a(this.bi, new InterstitialTrigger(Action.PAGE_STORY));
            aL();
        }
    }

    public final void m4858g(boolean z) {
        super.g(z);
        if (z && this.f3937i != null) {
            this.f3937i.a(this.bi, new InterstitialTrigger(Action.PAGE_STORY));
            aL();
        }
    }

    @TargetApi(11)
    private void m4823a(final PageSecondaryCardView pageSecondaryCardView) {
        Preconditions.checkArgument(pageSecondaryCardView.getParent() instanceof ViewGroup, "The card's parent must be a ViewGroup to access the LayoutTransition object");
        final LayoutTransition layoutTransition = ((ViewGroup) pageSecondaryCardView.getParent()).getLayoutTransition();
        if (layoutTransition == null || !layoutTransition.isRunning()) {
            m4836b(pageSecondaryCardView);
        } else {
            layoutTransition.addTransitionListener(new TransitionListener(this) {
                final /* synthetic */ PageAboutFragment f3908c;
                private boolean f3909d = false;

                public void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i) {
                }

                public void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i) {
                    if (!this.f3909d) {
                        if (i == 1 || i == 2) {
                            this.f3908c.m4836b(pageSecondaryCardView);
                            this.f3909d = true;
                            ((DefaultAndroidThreadUtil) this.f3908c.aM.get()).b(new Runnable(this) {
                                final /* synthetic */ AnonymousClass18 f3905b;

                                public void run() {
                                    layoutTransition.removeTransitionListener(this);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    private void m4836b(PageSecondaryCardView pageSecondaryCardView) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        pageSecondaryCardView.getLocationOnScreen(iArr);
        this.aZ.a(iArr2);
        this.aZ.a(iArr[1] - iArr2[1], 1000);
    }

    public final void gB_() {
        if (this.aZ != null) {
            HandlerDetour.b(this.ce, this.cg, 0, 1459094735);
        }
    }

    public final ScrollingViewProxy m4861n() {
        return this.aZ;
    }

    public final boolean gC_() {
        if (this.aZ == null) {
            return false;
        }
        return this.aZ.n();
    }

    private void m4841d(PageCardType pageCardType) {
        if (this.bj != null) {
            final PageSecondaryCardView pageSecondaryCardView = (PageSecondaryCardView) this.cc.get(pageCardType);
            if (pageSecondaryCardView != null && pageSecondaryCardView.getParent() != null) {
                DefaultAndroidThreadUtil defaultAndroidThreadUtil = (DefaultAndroidThreadUtil) this.aM.get();
                HandlerDetour.a(new Handler(), new Runnable(this) {
                    final /* synthetic */ PageAboutFragment f3911b;

                    public void run() {
                        if (VERSION.SDK_INT >= 11) {
                            this.f3911b.m4823a(pageSecondaryCardView);
                        } else {
                            this.f3911b.m4836b(pageSecondaryCardView);
                        }
                    }
                }, 1111028867);
            }
        }
    }

    public static void aO(PageAboutFragment pageAboutFragment) {
        if (pageAboutFragment.o() != null) {
            pageAboutFragment.o().runOnUiThread(new Runnable(pageAboutFragment) {
                final /* synthetic */ PageAboutFragment f3914a;

                {
                    this.f3914a = r1;
                }

                public void run() {
                    if (this.f3914a.o() != null && !this.f3914a.o().isFinishing()) {
                        if (this.f3914a.y) {
                            this.f3914a.aq.a(UpdatePageDataEvent.m2437d());
                        } else {
                            this.f3914a.by = true;
                        }
                    }
                }
            });
        }
    }

    public static void aP(PageAboutFragment pageAboutFragment) {
        Object obj;
        PagesManagerStartupSequencesHelper pagesManagerStartupSequencesHelper = pageAboutFragment.ax;
        if (pagesManagerStartupSequencesHelper.a.e(PagesManagerStartupSequences.c) == null && pagesManagerStartupSequencesHelper.a.e(PagesManagerStartupSequences.a) == null && pagesManagerStartupSequencesHelper.a.e(PagesManagerStartupSequences.b) == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null && !pageAboutFragment.bK && (pageAboutFragment.bH & pageAboutFragment.bG) == pageAboutFragment.bH) {
            if (pageAboutFragment.bI == null) {
                pageAboutFragment.bI = Maps.c();
            }
            if (pageAboutFragment.bM != null) {
                pageAboutFragment.bI.put("LastEvent", pageAboutFragment.bM.toString());
            }
            pageAboutFragment.bI.put("FirstTimeVisitPage", String.valueOf(pageAboutFragment.bV == 1));
            pageAboutFragment.bI.put("IsLazyTabsEnabled", pageAboutFragment.aR());
            pageAboutFragment.bI.put("TabsPreloadNumber", String.valueOf(pageAboutFragment.aL.c()));
            pageAboutFragment.ax.a(ImmutableMap.copyOf(pageAboutFragment.bI));
            pageAboutFragment.bK = true;
        }
    }

    public static void aQ(PageAboutFragment pageAboutFragment) {
        boolean z = true;
        if ((pageAboutFragment.bH & pageAboutFragment.bG) == pageAboutFragment.bH && pageAboutFragment.ar()) {
            pageAboutFragment.at.a(pageAboutFragment.bD == TriState.YES, null);
            if (!pageAboutFragment.at.c(pageAboutFragment.bF)) {
                return;
            }
            if (pageAboutFragment.bq || pageAboutFragment.bD != TriState.UNSET) {
                Map map;
                String str;
                boolean z2;
                if (pageAboutFragment.bI == null) {
                    pageAboutFragment.bI = Maps.c();
                }
                if (pageAboutFragment.bv.c()) {
                    Object obj;
                    map = pageAboutFragment.bI;
                    str = "IsOwned";
                    if (pageAboutFragment.bv.e.y()) {
                        obj = "true";
                    } else {
                        obj = "false";
                    }
                    map.put(str, obj);
                    map = pageAboutFragment.bI;
                    str = "SuperCategoryType";
                    if (pageAboutFragment.bv.e == null || pageAboutFragment.bv.e.Z() == null) {
                        obj = "unknown";
                    } else {
                        obj = pageAboutFragment.bv.e.Z().name();
                    }
                    map.put(str, obj);
                }
                if (pageAboutFragment.bM != null) {
                    pageAboutFragment.bI.put("LastEvent", pageAboutFragment.bM.toString());
                }
                map = pageAboutFragment.bI;
                str = "FirstTimeVisitPage";
                if (pageAboutFragment.bV == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                map.put(str, String.valueOf(z2));
                pageAboutFragment.bI.put("IsInAdminContainer", pageAboutFragment.bP ? "1" : "0");
                pageAboutFragment.bI.put("Referrer", pageAboutFragment.bs.loggingName);
                pageAboutFragment.bI.put("PageCardsSchedulingEnabled", pageAboutFragment.aI.a(PagesFb4aAbTestGatekeepers.d, false) ? "1" : "0");
                pageAboutFragment.bI.put("UserPTR", pageAboutFragment.bQ ? "1" : "0");
                if (pageAboutFragment.bq) {
                    pageAboutFragment.bI.put("IsLazyTabsEnabled", pageAboutFragment.aR());
                    pageAboutFragment.bI.put("TabsPreloadNumber", String.valueOf(pageAboutFragment.aL.c()));
                }
                FutureDetour.a(pageAboutFragment.cf, null, 1199357015);
                PageHeaderSequenceLoggerHelper pageHeaderSequenceLoggerHelper = pageAboutFragment.at;
                String str2 = pageAboutFragment.bF;
                if (pageAboutFragment.bD != TriState.YES) {
                    z = false;
                }
                pageHeaderSequenceLoggerHelper.a(str2, z, ImmutableMap.copyOf(pageAboutFragment.bI));
                return;
            }
            ((AbstractFbErrorReporter) pageAboutFragment.aO.get()).b(pageAboutFragment.getClass().getName(), "IsAdmin not set when stop header sequence in fb4a");
            pageAboutFragment.bb();
        }
    }

    private String aR() {
        PagesManagerLazyTabExperimentUtil pagesManagerLazyTabExperimentUtil = this.aL;
        boolean z = false;
        if (pagesManagerLazyTabExperimentUtil.b.j == Product.PAA && pagesManagerLazyTabExperimentUtil.a.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForPagesCommonAbTestModule.b, false)) {
            z = true;
        }
        return z ? "true" : "false";
    }

    private boolean m4833a(GraphQLResult<FetchPageHeaderQueryModel> graphQLResult) {
        if (graphQLResult.e == null) {
            return false;
        }
        ImmutableList R = ((FetchPageHeaderQueryModel) graphQLResult.e).R();
        if (R == null || R.isEmpty() || R.get(0) == null || ((RedirectionInfoModel) R.get(0)).a() == null) {
            return false;
        }
        return Long.parseLong(((RedirectionInfoModel) R.get(0)).a().j()) != this.br;
    }

    private void m4835b(GraphQLResult<FetchPageHeaderQueryModel> graphQLResult) {
        if (graphQLResult == null || graphQLResult.e == null || ((FetchPageHeaderQueryModel) graphQLResult.e).R().isEmpty() || ((FetchPageHeaderQueryModel) graphQLResult.e).R().get(0) == null || ((RedirectionInfoModel) ((FetchPageHeaderQueryModel) graphQLResult.e).R().get(0)).a() == null || ((RedirectionInfoModel) ((FetchPageHeaderQueryModel) graphQLResult.e).R().get(0)).a().j() == null) {
            ((AbstractFbErrorReporter) this.aO.get()).b(getClass().getName(), "No global redirection_info");
            return;
        }
        this.au.a(this.br, Long.parseLong(((RedirectionInfoModel) ((FetchPageHeaderQueryModel) graphQLResult.e).R().get(0)).a().j()));
        PageAboutFragment pageAboutFragment = new PageAboutFragment();
        Bundle bundle = this.s;
        bundle.putParcelable("page_fragment_uuid", new ParcelUuid(SafeUUIDGenerator.a()));
        bundle.putLong("com.facebook.katana.profile.id", Long.parseLong(((RedirectionInfoModel) ((FetchPageHeaderQueryModel) graphQLResult.e).R().get(0)).a().j()));
        pageAboutFragment.g(bundle);
        aZ();
        kO_().a().b(2131558429, pageAboutFragment).c();
    }

    private boolean m4840c(GraphQLResult<FetchPageHeaderQueryModel> graphQLResult) {
        boolean z;
        if (graphQLResult == null || graphQLResult.e == null || !new ProfilePermissions(((FetchPageHeaderQueryModel) graphQLResult.e).af()).a(Permission.BASIC_ADMIN)) {
            z = false;
        } else {
            z = true;
        }
        if (this.bq) {
            return false;
        }
        if (z) {
            if (this.bP) {
                return false;
            }
            ((AbstractFbErrorReporter) this.aO.get()).a(SoftError.b(getClass().getName(), "admin redirection"));
            if (this.T == null || this.T.getParent() == null || this.bO) {
                return false;
            }
            return true;
        } else if (!this.bP) {
            return false;
        } else {
            ((AbstractFbErrorReporter) this.aO.get()).a(getClass().getName(), "Non-admin ends up in admin container fragment");
            return false;
        }
    }

    private void aS() {
        PageIdentityFragment pageIdentityFragment = new PageIdentityFragment();
        Bundle bundle = this.s;
        bundle.putBoolean("extra_has_been_redirected", true);
        bundle.putParcelable("page_fragment_uuid", new ParcelUuid(SafeUUIDGenerator.a()));
        pageIdentityFragment.g(bundle);
        aZ();
        kO_().a().b(2131558429, pageIdentityFragment).c();
    }

    private void aT() {
        if (!this.bt || !this.bD.equals(TriState.YES)) {
            return;
        }
        if (this.aK.a(aT, getContext())) {
            this.bt = false;
            return;
        }
        QuickPromotionController quickPromotionController = (QuickPromotionController) ((InterstitialManager) this.aP.get()).a(aT, QuickPromotionController.class);
        if (quickPromotionController != null) {
            Intent a = PagesQuickPromotionUtils.a(quickPromotionController, getContext());
            if (a != null) {
                QuickPromotionFragment a2 = ((QuickPromotionFragmentFactory) this.aQ.get()).a(a);
                if (a2 instanceof QuickPromotionFooterFragment) {
                    this.bt = false;
                    this.bm = (QuickPromotionFooterFragment) a2;
                    s().a().b(2131562194, this.bm).b();
                    this.bl.setVisibility(0);
                }
            }
        }
    }

    private void aU() {
        if (this.bm != null) {
            Intent intent;
            QuickPromotionFragment quickPromotionFragment = null;
            QuickPromotionFooterController quickPromotionFooterController = (QuickPromotionFooterController) ((InterstitialManager) this.aP.get()).a(aT, QuickPromotionFooterController.class);
            if (quickPromotionFooterController == null) {
                intent = null;
            } else {
                intent = quickPromotionFooterController.a(getContext());
            }
            Intent intent2 = intent;
            if (intent2 != null && this.bm.mx_() && this.bm.b(intent2)) {
                this.bm.ay();
                return;
            }
            if (intent2 != null) {
                quickPromotionFragment = ((QuickPromotionFragmentFactory) this.aQ.get()).a(intent2);
            }
            if (quickPromotionFragment instanceof QuickPromotionFooterFragment) {
                this.bm = (QuickPromotionFooterFragment) quickPromotionFragment;
                s().a().b(2131562194, this.bm).b();
                this.bl.setVisibility(0);
                return;
            }
            aV();
        }
    }

    private void aV() {
        if (this.bm != null) {
            s().a().a(this.bm).b();
            this.bm = null;
        }
        this.bl.setVisibility(8);
    }

    public final void c_(boolean z) {
        if (z) {
            aV();
        }
    }

    public final FadingContentView m4860j() {
        if (this.aZ.f(0) instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) this.aZ.f(0);
            if (viewGroup.getChildAt(0) instanceof FadingContentView) {
                return (FadingContentView) viewGroup.getChildAt(0);
            }
        }
        return null;
    }

    public final boolean mk_() {
        if (m4860j() != null) {
            return true;
        }
        return false;
    }

    public final int ml_() {
        Integer valueOf = Integer.valueOf(((ViewGroup) this.aZ.f(0)).getTop());
        return valueOf == null ? 0 : valueOf.intValue();
    }

    public final void m4862p() {
        this.bC = true;
    }

    public final GraphSearchQuery m4863q() {
        if (this.bv == null || this.bv.e == null) {
            return GraphSearchQuery.e;
        }
        boolean z;
        FetchPageHeaderQueryModel fetchPageHeaderQueryModel = this.bv.e;
        String D = fetchPageHeaderQueryModel.D();
        ScopedSearchStyle scopedSearchStyle = this.aI.a(SearchAbTestGatekeepers.q, false) ? ScopedSearchStyle.TAB : ScopedSearchStyle.SINGLE_STATE;
        ScopedEntityType scopedEntityType = ScopedEntityType.PAGE;
        String valueOf = String.valueOf(this.bv.a);
        if (ScopedSearchStyle.TAB == scopedSearchStyle) {
            z = true;
        } else {
            z = false;
        }
        GraphSearchQuery a = GraphSearchQuery.a(scopedEntityType, valueOf, D, scopedSearchStyle, z);
        GraphQLPlaceType K = fetchPageHeaderQueryModel.K();
        if (!(K == null || K == GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
            String str;
            ImmutableList s = fetchPageHeaderQueryModel.s();
            ModifierKeys modifierKeys = ModifierKeys.PLACE;
            GraphSearchQueryPlaceModifier.Builder builder = new GraphSearchQueryPlaceModifier.Builder();
            builder.a = K;
            builder = builder;
            if (s.isEmpty()) {
                str = null;
            } else {
                str = (String) s.get(0);
            }
            builder.b = str;
            a.a(modifierKeys, builder.a());
        }
        return a;
    }

    private void aZ() {
        if (this.aF != null) {
            this.aF.c();
        }
        if (this.al != null) {
            this.al.a();
        }
        if (this.be != null) {
            this.be.b();
        }
        if (this.bT != null) {
            this.bT.b(this.aq);
        }
        this.aw.b(this.bJ);
        this.aw.b(this.bN);
        ba();
    }

    private void ba() {
        this.ax.a();
        bb();
        this.ay.c(PageSequences.f);
        this.ar.b();
    }

    private void bb() {
        FutureDetour.a(this.cf, null, -1158158032);
        this.at.b(this.bF);
    }
}
