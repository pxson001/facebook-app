package com.facebook.pages.identity.fragments.surface;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;
import com.facebook.acra.ErrorReporter;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.caspian.ui.standardheader.ProfileVideoView;
import com.facebook.caspian.ui.standardheader.StandardHeaderViewHelper;
import com.facebook.commerce.publishing.event.CommercePublishingEventBus;
import com.facebook.commerce.publishing.event.CommerceShopMutationEvent.CommerceShopMutationEventSubscriber;
import com.facebook.commerce.publishing.event.ProductItemMutationEvent.ProductItemMutationEventSubscriber;
import com.facebook.commerce.storefront.fragments.StorefrontFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.device.ScreenUtil;
import com.facebook.events.common.ActionMechanism;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator.OnTabClickListener;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLPagePresenceTabContentType;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.interstitial.manager.InterstitialTriggerContext;
import com.facebook.ipc.pages.PageViewReferrer;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.common.abtest.PagesCommonAbTestGatekeepers;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.bugreport.PageIdCustomDataSupplier;
import com.facebook.pages.common.childlocations.PageChildLocationsListFragment;
import com.facebook.pages.common.context.TimelinePageContext.PageProfilePermissionsProvider;
import com.facebook.pages.common.eventbus.PageEvent;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.PageActionBarDrawnEventSubscriber;
import com.facebook.pages.common.eventbus.PageEvents.PagesSurfaceAddTabEvent;
import com.facebook.pages.common.eventbus.PageEvents.PagesSurfaceAddTabEventSubscriber;
import com.facebook.pages.common.eventbus.PageEvents.PagesSurfaceDeleteTabEvent;
import com.facebook.pages.common.eventbus.PageEvents.PagesSurfaceDeleteTabEventSubscriber;
import com.facebook.pages.common.eventbus.PageEvents.PagesSurfaceSwitchToTabEvent;
import com.facebook.pages.common.eventbus.PageEvents.PagesSurfaceSwitchToTabEventSubscriber;
import com.facebook.pages.common.eventbus.PageEvents.UpdatePageDataEventSubscriber;
import com.facebook.pages.common.eventbus.PageEvents.UpdatePageSurfaceTabEvent;
import com.facebook.pages.common.eventbus.PageEvents.UpdatePageSurfaceTabEvent.C02251;
import com.facebook.pages.common.eventbus.PageEvents.UpdatePageSurfaceTabEvent.UpdatePageSurfaceTabEventSubscriber;
import com.facebook.pages.common.job_sequencer.PagesJobSequencer;
import com.facebook.pages.common.job_sequencer.SequencerSignal;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.PagesInternalAnalyticsLogger;
import com.facebook.pages.common.logging.perflogger.PagesPerfLogger;
import com.facebook.pages.common.logging.perflogger.PagesPerfLogger.EntityHeaderState;
import com.facebook.pages.common.photos.PagesPhotosFragmentUtils;
import com.facebook.pages.common.resulthandlers.ActivityResultHandlerResolver;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.pages.common.reviews.PageSurfaceReviewsFeedFragment;
import com.facebook.pages.common.sequencelogger.PagesSurfaceFirstCardPerfLogger;
import com.facebook.pages.common.services.PagesServicesFragment;
import com.facebook.pages.common.surface.fragments.common.PagesFragmentWithUuid;
import com.facebook.pages.common.surface.fragments.reaction.PagesGenericReactionSurfaceTabFragment;
import com.facebook.pages.common.surface.fragments.reaction.PagesPhotosReactionSurfaceTabFragment;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController.PageDataFetchType;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherController.PageHeaderDataListener;
import com.facebook.pages.common.surface.protocol.headerfetcher.PageHeaderFetcherControllerProvider;
import com.facebook.pages.common.surface.tabs.tabbar.management.PagesSurfaceAddDeleteTabUtil;
import com.facebook.pages.common.surface.tabs.tabbar.management.PagesSurfaceAddDeleteTabUtil.C03384;
import com.facebook.pages.common.surface.tabs.tabbar.management.PagesSurfaceTabsUtil;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderView;
import com.facebook.pages.common.surface.ui.header.PagesProfileVideoViewportListener;
import com.facebook.pages.common.surfaceinterfaces.CanHandleCreateNewTab;
import com.facebook.pages.common.surfaceinterfaces.HasPageProfilePermissionsProvider;
import com.facebook.pages.common.surfaceinterfaces.HasPagesSurfaceTabs;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceHeaderDataListener;
import com.facebook.pages.common.surfaceinterfaces.PagesSurfaceTabFragment;
import com.facebook.pages.common.util.PagesQuickPromotionUtils;
import com.facebook.pages.common.util.PortraitOrientationController;
import com.facebook.pages.common.viewercontextutils.PageViewerContextLifecycleHelper;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageGeneralDataModel.RedirectionInfoModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageHeaderTabDataModel.TabsModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageSectionsCanAddDataModel.SectionsCanAddModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.data.model.pageheader.PageTabStateData;
import com.facebook.pages.fb4a.abtest.qe.ExperimentsForPagesFb4aAbTestModule;
import com.facebook.pages.fb4a.admintabs.PageIdentityAdminTabsView;
import com.facebook.pages.fb4a.events.eventslist.PageEventsListFragment;
import com.facebook.pages.fb4a.videohub.fragments.VideoHubPermalinkFragment;
import com.facebook.pages.fb4a.videohub.fragments.VideoTabAllVideosOptimizedFetchingFragment;
import com.facebook.pages.identity.cards.actionbar.PageMessageButtonNuxInterstitialController;
import com.facebook.pages.identity.cards.actionbar.PagesActionBarItemFactory.PageActionType;
import com.facebook.pages.identity.cards.actionbar.PagesActionBarItemFactoryModelProvider;
import com.facebook.pages.identity.fragments.identity.PageIdentityFragment;
import com.facebook.pages.identity.fragments.moreinformation.PageInformationFragment;
import com.facebook.pages.identity.fragments.surface.PagesSurfaceFragmentModel.Builder;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.ui.QuickPromotionFooterController;
import com.facebook.quickpromotion.ui.QuickPromotionFooterFragment;
import com.facebook.quickpromotion.ui.QuickPromotionFooterFragment.ActionButtonTheme;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;
import com.facebook.quickpromotion.ui.QuickPromotionFragment.QuickPromotionFragmentHost;
import com.facebook.quickpromotion.ui.QuickPromotionFragmentFactory;
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
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.facebook.widget.listview.ScrollListenerHolder;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.titlebar.FadingContentFragmentController;
import com.facebook.widget.titlebar.FadingContentView;
import com.facebook.widget.titlebar.FadingContentViewProvider;
import com.facebook.widget.titlebar.FadingFbTitleBar;
import com.facebook.widget.titlebar.FadingTitlebarContent;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.viewpager.ViewPagerWithCompositeOnPageChangeListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: page_videos_max_num */
public class PagesSurfaceFragment extends FbFragment implements CanHandleBackPressed, PagesFragmentWithUuid, PageHeaderDataListener, CanHandleCreateNewTab, HasPageProfilePermissionsProvider, HasPagesSurfaceTabs, QuickPromotionFragmentHost, GraphSearchQueryProvider, ScrollListenerHolder, FadingContentViewProvider {
    public static final GraphQLPagePresenceTabType aJ = GraphQLPagePresenceTabType.HOME;
    private static boolean aK;
    private static final InterstitialTrigger aL = new InterstitialTrigger(Action.PAGE_ADMIN_TIMELINE_VIEW);
    public static final InterstitialTrigger aM = new InterstitialTrigger(Action.PAGE_ACTIONBAR);
    @Inject
    PagesSurfaceFragmentController f4103a;
    @Inject
    Lazy<FbErrorReporter> aA;
    @Inject
    Lazy<GatekeeperStore> aB;
    @Inject
    Lazy<PagesProfileVideoViewportListener> aC;
    @Inject
    public Lazy<InterstitialManager> aD;
    @Inject
    Lazy<QuickPromotionFragmentFactory> aE;
    @Inject
    Lazy<FbUriIntentHandler> aF;
    @Inject
    public Lazy<PagesSurfaceAddDeleteTabUtil> aG;
    @Inject
    Lazy<ClickableToastBuilder> aH;
    boolean aI;
    private View aN;
    private QuickPromotionFragment aO;
    private LayoutInflater aP;
    private CustomFrameLayout aQ;
    private SwipeRefreshLayout aR;
    public ViewPagerWithCompositeOnPageChangeListener aS;
    public PagesHeaderContainer aT;
    public FadingFbTitleBar aU;
    public PagesSurfaceTabsUtil aV = new PagesSurfaceTabsUtil();
    private LazyView<PageIdentityAdminTabsView> aW;
    public PageIdentityAdminTabsView aX;
    public final Map<GraphQLPagePresenceTabType, PagesSurfaceTabFragmentWrapper> aY = new HashMap();
    private PagesSurfacePagerAdapter aZ;
    @Inject
    PageEventBus al;
    @Inject
    public CommercePublishingEventBus am;
    @Inject
    Product an;
    @Inject
    AdminedPagesRamCache ao;
    @Inject
    PagesSurfaceFirstCardPerfLogger ap;
    @Inject
    PagesInternalAnalyticsLogger aq;
    @Inject
    PageViewerContextLifecycleHelper ar;
    @Inject
    PagesActionBarItemFactoryModelProvider as;
    @Inject
    PagesJobSequencer at;
    @Inject
    PagesAnalytics au;
    @Inject
    PagesQuickPromotionUtils av;
    @Inject
    public Lazy<Toaster> aw;
    @Inject
    public Lazy<TasksManager> ax;
    @Inject
    Lazy<ActivityResultHandlerResolver> ay;
    @Inject
    Lazy<PagesPhotosFragmentUtils> az;
    @Inject
    ScreenUtil f4104b;
    public DialogBasedProgressIndicator bA = null;
    public final C05581 bB = new C05581(this);
    public PageHeaderFetcherController ba;
    private FadingContentFragmentController bb;
    public FbEventSubscriberListManager bc;
    public FbEventSubscriberListManager bd;
    public PageProfilePermissionsProvider be;
    private PortraitOrientationController bf;
    public PagesSurfaceFragmentModel bg;
    private int bh;
    public PageHeaderData bi;
    public PageTabStateData bj;
    private boolean bk = false;
    public boolean bl = true;
    public int bm = 0;
    private int bn = 0;
    public int bo = 0;
    private TabbedViewPagerIndicator bp;
    public int bq;
    private boolean br;
    private OnScrollListener bs;
    private GraphQLPagePresenceTabType bt;
    private boolean bu = false;
    public final List<PageEvent> bv = new ArrayList();
    @Nullable
    public String bw;
    @Nullable
    public String bx;
    public GraphQLPagePresenceTabType by = null;
    public DialogBasedProgressIndicator bz = null;
    @Inject
    PageHeaderFetcherControllerProvider f4105c;
    @Inject
    FbTitleBarSupplier f4106d;
    @Inject
    ProfilePicCoverPhotoUploadReceiver f4107e;
    @Inject
    PagesExperimentUtils f4108f;
    @Inject
    QeAccessor f4109g;
    @Inject
    public PagesPerfLogger f4110h;
    @Inject
    public Provider<FbEventSubscriberListManager> f4111i;

    /* compiled from: page_videos_max_num */
    public class C05581 {
        public final /* synthetic */ PagesSurfaceFragment f4080a;

        C05581(PagesSurfaceFragment pagesSurfaceFragment) {
            this.f4080a = pagesSurfaceFragment;
        }
    }

    /* compiled from: page_videos_max_num */
    /* synthetic */ class AnonymousClass23 {
        static final /* synthetic */ int[] f4086b = new int[GraphQLPagePresenceTabType.values().length];

        static {
            try {
                f4086b[GraphQLPagePresenceTabType.SERVICES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4086b[GraphQLPagePresenceTabType.ABOUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4086b[GraphQLPagePresenceTabType.EVENTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4086b[GraphQLPagePresenceTabType.LOCATIONS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4086b[GraphQLPagePresenceTabType.PHOTOS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4086b[GraphQLPagePresenceTabType.REVIEWS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4086b[GraphQLPagePresenceTabType.SHOP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f4086b[GraphQLPagePresenceTabType.VIDEOS.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            f4085a = new int[PresenceScrollType.values().length];
            try {
                f4085a[PresenceScrollType.SCROLL_TO_TAB.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f4085a[PresenceScrollType.SCROLL_TO_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f4085a[PresenceScrollType.NO_SCROLL.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* compiled from: page_videos_max_num */
    class C05592 implements ProfilePicCoverPhotoCallback {
        final /* synthetic */ PagesSurfaceFragment f4087a;

        C05592(PagesSurfaceFragment pagesSurfaceFragment) {
            this.f4087a = pagesSurfaceFragment;
        }

        public final void m4992a() {
            this.f4087a.ba.m3465a(PageDataFetchType.FORCED_BY_USER);
        }
    }

    /* compiled from: page_videos_max_num */
    class C05603 implements PageProfilePermissionsProvider {
        final /* synthetic */ PagesSurfaceFragment f4088a;
        private ImmutableList<String> f4089b = null;
        private ProfilePermissions f4090c;

        C05603(PagesSurfaceFragment pagesSurfaceFragment) {
            this.f4088a = pagesSurfaceFragment;
        }

        @Nullable
        public final ProfilePermissions mo28a() {
            if (this.f4088a.bi == null || this.f4088a.bi.e == null) {
                return null;
            }
            if (this.f4089b != this.f4088a.bi.e.af()) {
                this.f4089b = this.f4088a.bi.e.af();
                this.f4090c = new ProfilePermissions(this.f4089b);
            }
            return this.f4090c;
        }
    }

    /* compiled from: page_videos_max_num */
    public class C05614 implements OnDismissListener {
        final /* synthetic */ PageMessageButtonNuxInterstitialController f4091a;
        final /* synthetic */ PagesSurfaceFragment f4092b;

        public C05614(PagesSurfaceFragment pagesSurfaceFragment, PageMessageButtonNuxInterstitialController pageMessageButtonNuxInterstitialController) {
            this.f4092b = pagesSurfaceFragment;
            this.f4091a = pageMessageButtonNuxInterstitialController;
        }

        public final boolean m4994a(PopoverWindow popoverWindow) {
            this.f4091a.d();
            return true;
        }
    }

    /* compiled from: page_videos_max_num */
    public class C05625 extends UpdatePageDataEventSubscriber {
        final /* synthetic */ PagesSurfaceFragment f4093a;

        public C05625(PagesSurfaceFragment pagesSurfaceFragment) {
            this.f4093a = pagesSurfaceFragment;
        }

        public final void m4995b(FbEvent fbEvent) {
            PagesSurfaceFragment.aw(this.f4093a);
        }
    }

    /* compiled from: page_videos_max_num */
    public class C05636 extends UpdatePageSurfaceTabEventSubscriber {
        final /* synthetic */ PagesSurfaceFragment f4094a;

        public C05636(PagesSurfaceFragment pagesSurfaceFragment) {
            this.f4094a = pagesSurfaceFragment;
        }

        public final void m4996b(FbEvent fbEvent) {
            UpdatePageSurfaceTabEvent updatePageSurfaceTabEvent = (UpdatePageSurfaceTabEvent) fbEvent;
            this.f4094a.ba.m3465a(PageDataFetchType.FORCED_BY_USER);
            C02251 c02251 = updatePageSurfaceTabEvent.f1618a;
            ImmutableList of = ImmutableList.of(GraphQLPagePresenceTabType.HOME, GraphQLPagePresenceTabType.SHOP);
            int size = of.size();
            for (int i = 0; i < size; i++) {
                GraphQLPagePresenceTabType graphQLPagePresenceTabType = (GraphQLPagePresenceTabType) of.get(i);
                if (this.f4094a.aV.m3501a(graphQLPagePresenceTabType)) {
                    int b = this.f4094a.aV.m3504b(graphQLPagePresenceTabType);
                    if (b >= 0) {
                        PagesSurfaceFragment.m5025h(this.f4094a, b);
                    }
                }
            }
        }
    }

    /* compiled from: page_videos_max_num */
    public class C05647 extends PageActionBarDrawnEventSubscriber {
        final /* synthetic */ PagesSurfaceFragment f4095a;

        public C05647(PagesSurfaceFragment pagesSurfaceFragment) {
            this.f4095a = pagesSurfaceFragment;
        }

        public final void m4997b(FbEvent fbEvent) {
            PagesSurfaceFragment pagesSurfaceFragment = this.f4095a;
            if (pagesSurfaceFragment.bl && pagesSurfaceFragment.bi.c() && PagesActionBarItemFactoryModelProvider.m4430a(pagesSurfaceFragment.bi).m4420q()) {
                PageMessageButtonNuxInterstitialController pageMessageButtonNuxInterstitialController = (PageMessageButtonNuxInterstitialController) ((InterstitialManager) pagesSurfaceFragment.aD.get()).a(PagesSurfaceFragment.aM, PageMessageButtonNuxInterstitialController.class);
                if (pageMessageButtonNuxInterstitialController != null) {
                    View findViewById = pagesSurfaceFragment.aT.f4062f.findViewById(PageActionType.MESSAGE.ordinal());
                    Tooltip tooltip = new Tooltip(pagesSurfaceFragment.getContext(), 2);
                    tooltip.a(Position.ABOVE);
                    tooltip.t = -1;
                    tooltip.b(2131235537);
                    tooltip.f(findViewById);
                    tooltip.H = new C05614(pagesSurfaceFragment, pageMessageButtonNuxInterstitialController);
                }
            }
        }
    }

    /* compiled from: page_videos_max_num */
    public class C05658 extends PagesSurfaceAddTabEventSubscriber {
        final /* synthetic */ PagesSurfaceFragment f4096a;

        public C05658(PagesSurfaceFragment pagesSurfaceFragment) {
            this.f4096a = pagesSurfaceFragment;
        }

        public final void m4998b(FbEvent fbEvent) {
            PagesSurfaceFragment.m5026h(this.f4096a, ((PagesSurfaceAddTabEvent) fbEvent).f1614a);
        }
    }

    /* compiled from: page_videos_max_num */
    public class C05669 extends PagesSurfaceDeleteTabEventSubscriber {
        final /* synthetic */ PagesSurfaceFragment f4097a;

        public C05669(PagesSurfaceFragment pagesSurfaceFragment) {
            this.f4097a = pagesSurfaceFragment;
        }

        public final void m4999b(FbEvent fbEvent) {
            PagesSurfaceFragment.m5028i(this.f4097a, ((PagesSurfaceDeleteTabEvent) fbEvent).f1615a);
        }
    }

    /* compiled from: page_videos_max_num */
    public class PagesSurfacePagerAdapter extends FragmentPagerAdapter {
        final /* synthetic */ PagesSurfaceFragment f4098a;
        private final SparseArray<WeakReference<FbFragment>> f4099b;
        private PagesSurfaceFragment f4100c;
        private long f4101d;
        public boolean f4102e = false;

        public PagesSurfacePagerAdapter(PagesSurfaceFragment pagesSurfaceFragment, FragmentManager fragmentManager, long j, PagesSurfaceFragment pagesSurfaceFragment2) {
            this.f4098a = pagesSurfaceFragment;
            super(fragmentManager);
            this.f4101d = j;
            this.f4100c = pagesSurfaceFragment2;
            this.f4099b = new SparseArray();
        }

        public final Fragment m5004a(int i) {
            Fragment g = m5002g(i);
            if (i == PagesSurfaceFragment.aE(this.f4098a)) {
                return g;
            }
            PagesSurfaceTabFragmentWrapper k = PagesSurfaceFragment.m5030k(this.f4098a, i);
            if (k != null) {
                return k;
            }
            k = new PagesSurfaceTabFragmentWrapper();
            k.m5063a((PagesSurfaceTabFragment) g);
            this.f4098a.aY.put(this.f4098a.aV.m3500a(i).k(), k);
            return k;
        }

        private FbFragment m5002g(int i) {
            String D;
            FbFragment a;
            boolean z;
            if (this.f4098a.bi.e != null) {
                D = this.f4098a.bi.e.D();
            } else {
                D = null;
            }
            if (PagesSurfaceFragment.aC(this.f4098a)) {
                TabsModel a2 = this.f4098a.aV.m3500a(i);
                if (a2.a() == GraphQLPagePresenceTabContentType.REACTION_SURFACE) {
                    String str;
                    String str2;
                    boolean equals = a2.k().equals(GraphQLPagePresenceTabType.HOME);
                    long j = this.f4101d;
                    Surface a3 = PagesSurfaceTabsUtil.m3499a(a2);
                    if (equals) {
                        str = this.f4098a.bw;
                    } else {
                        str = null;
                    }
                    if (equals) {
                        str2 = this.f4098a.bx;
                    } else {
                        str2 = null;
                    }
                    a = PagesGenericReactionSurfaceTabFragment.m3377a(j, equals, equals, a3, str, str2, this.f4098a.be, this.f4098a.mo55h());
                    z = true;
                } else {
                    switch (AnonymousClass23.f4086b[a2.k().ordinal()]) {
                        case 1:
                            a = PagesServicesFragment.m3315a(Long.toString(this.f4101d), D, this.f4098a.bi.a(Permission.CREATE_CONTENT), null, true);
                            z = false;
                            break;
                        case 2:
                            a = PageInformationFragment.m4930a(this.f4101d, true);
                            z = false;
                            break;
                        case 3:
                            a = PageEventsListFragment.m3991a(this.f4101d, D, null, "pages_identity".toString(), ActionMechanism.PAGES_SURFACE_EVENTS_TAB.toString(), true);
                            z = false;
                            break;
                        case 4:
                            PageChildLocationsListFragment a4;
                            if (this.f4098a.bi == null) {
                                a4 = PageChildLocationsListFragment.m2005a(null, null, Long.toString(this.f4101d), null, true);
                            } else {
                                a4 = PageChildLocationsListFragment.m2005a(null, this.f4098a.bi.b, Long.toString(this.f4101d), D, true);
                            }
                            a = a4;
                            z = false;
                            break;
                        case 5:
                            Bundle a5 = m5000a(D);
                            if (!this.f4098a.f4109g.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.e, false)) {
                                this.f4098a.az.get();
                                a = PagesPhotosFragmentUtils.m2559a(a5);
                                z = false;
                                break;
                            }
                            a = PagesPhotosReactionSurfaceTabFragment.m3405a(this.f4101d, this.f4098a.mo55h());
                            z = false;
                            break;
                        case 6:
                            a = PageSurfaceReviewsFeedFragment.m3284a(this.f4101d, D, D, true);
                            z = false;
                            break;
                        case 7:
                            a = StorefrontFragment.a(Long.valueOf(this.f4101d), null, false, true);
                            z = false;
                            break;
                        case 8:
                            VideoHubPermalinkFragment a6;
                            if (this.f4098a.bj.a) {
                                a6 = VideoHubPermalinkFragment.m4082a(this.f4101d, true);
                            } else {
                                a6 = VideoTabAllVideosOptimizedFetchingFragment.m4133a(this.f4101d, true);
                            }
                            a = a6;
                            z = false;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid Pages Surface Tab Type: " + a2.k().name());
                    }
                }
            }
            a = PagesGenericReactionSurfaceTabFragment.m3377a(this.f4101d, true, true, Surface.ANDROID_PAGE_HOME, this.f4098a.bw, this.f4098a.bx, this.f4098a.be, this.f4098a.mo55h());
            z = true;
            if (z && (a instanceof PagesGenericReactionSurfaceTabFragment) && this.f4098a.aI) {
                ((PagesGenericReactionSurfaceTabFragment) a).m3391e();
            }
            if (a instanceof PagesSurfaceHeaderDataListener) {
                ((PagesSurfaceHeaderDataListener) a).mo52a(this.f4098a.bi);
            }
            return a;
        }

        private Bundle m5000a(String str) {
            if (this.f4098a.bi == null || this.f4098a.bi.e == null) {
                return ((PagesPhotosFragmentUtils) this.f4098a.az.get()).m2560a(Long.toString(this.f4101d), this.f4098a.mo55h(), null, null, null);
            }
            String b;
            if (this.f4098a.bi.e.N() != null) {
                b = this.f4098a.bi.e.N().b();
            } else {
                b = null;
            }
            return ((PagesPhotosFragmentUtils) this.f4098a.az.get()).m2560a(Long.toString(this.f4101d), this.f4098a.mo55h(), str, new ArrayList(this.f4098a.bi.e.af()), b);
        }

        public final int m5008b() {
            if (PagesSurfaceFragment.aC(this.f4098a)) {
                return this.f4098a.aV.m3503b();
            }
            return 1;
        }

        public final int m5003a(Object obj) {
            return this.f4102e ? -2 : super.a(obj);
        }

        public final long m5009b(int i) {
            return PagesSurfaceFragment.aC(this.f4098a) ? (long) this.f4098a.aV.m3500a(i).k().hashCode() : (long) i;
        }

        public final CharSequence J_(int i) {
            return PagesSurfaceFragment.aC(this.f4098a) ? this.f4098a.aV.m3500a(i).l().a() : "";
        }

        public final Object m5005a(ViewGroup viewGroup, int i) {
            Fragment fragment = (FbFragment) super.a(viewGroup, i);
            if (fragment instanceof PagesSurfaceTabFragmentWrapper) {
                Object obj;
                PagesSurfaceTabFragmentWrapper pagesSurfaceTabFragmentWrapper = (PagesSurfaceTabFragmentWrapper) fragment;
                if (!pagesSurfaceTabFragmentWrapper.f4127a || pagesSurfaceTabFragmentWrapper.f4129c == null) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    ((PagesSurfaceTabFragmentWrapper) fragment).m5063a((PagesSurfaceTabFragment) m5002g(i));
                    ((PagesSurfaceTabFragmentWrapper) fragment).aq();
                }
            }
            this.f4099b.put(i, new WeakReference(fragment));
            ((PagesSurfaceTabFragment) fragment).D_(this.f4098a.bo);
            ((PagesSurfaceTabFragment) fragment).a(this.f4100c);
            ((PagesSurfaceTabFragment) fragment).a(this.f4098a.aT);
            ((PagesSurfaceTabFragment) fragment).E_(this.f4098a.f4104b.d());
            ((PagesSurfaceTabFragment) fragment).a(this.f4098a.bB);
            if (i == PagesSurfaceFragment.aE(this.f4098a)) {
                m5001a(fragment);
            }
            return fragment;
        }

        @Nullable
        public final FbFragment m5011e(int i) {
            WeakReference weakReference = (WeakReference) this.f4099b.get(i);
            return weakReference != null ? (FbFragment) weakReference.get() : null;
        }

        public final void m5006a(ViewGroup viewGroup, int i, Object obj) {
            this.f4099b.remove(i);
            super.a(viewGroup, i, obj);
        }

        public final void m5010d() {
            for (int i = 0; i < this.f4099b.size(); i++) {
                WeakReference weakReference = (WeakReference) this.f4099b.get(this.f4099b.keyAt(i));
                if (weakReference != null) {
                    FbFragment fbFragment = (FbFragment) weakReference.get();
                    if (fbFragment instanceof PagesSurfaceHeaderDataListener) {
                        ((PagesSurfaceHeaderDataListener) fbFragment).mo52a(this.f4098a.bi);
                    }
                }
            }
        }

        public final void m5007a(boolean z) {
            for (int i = 0; i < this.f4099b.size(); i++) {
                int keyAt = this.f4099b.keyAt(i);
                WeakReference weakReference = (WeakReference) this.f4099b.get(keyAt);
                if (weakReference != null && (z || this.f4098a.aS.k != keyAt)) {
                    ((PagesSurfaceTabFragment) ((FbFragment) weakReference.get())).D_(this.f4098a.bo);
                }
            }
        }

        private void m5001a(Fragment fragment) {
            if (fragment instanceof PagesGenericReactionSurfaceTabFragment) {
                PagesSurfaceFragment pagesSurfaceFragment = this.f4098a;
                this.f4098a.ap.a("SuperCategoryType", PagesSurfaceFragment.m5012a(this.f4098a.bi));
                boolean aC = PagesSurfaceFragment.aC(this.f4098a);
                this.f4098a.ap.a("TabsEnabled", aC ? "true" : "false");
                if (aC) {
                    TabsModel a = this.f4098a.aV.m3500a(0);
                    if (!(a == null || a.k() == null)) {
                        this.f4098a.ap.a("FirstTabType", a.k().name());
                    }
                    if (this.f4098a.aV.m3503b() > 1) {
                        a = this.f4098a.aV.m3500a(1);
                        if (!(a == null || a.k() == null)) {
                            this.f4098a.ap.a("SecondTabType", a.k().name());
                        }
                    }
                }
                PagesGenericReactionSurfaceTabFragment pagesGenericReactionSurfaceTabFragment = (PagesGenericReactionSurfaceTabFragment) fragment;
                pagesGenericReactionSurfaceTabFragment.bc = true;
                pagesGenericReactionSurfaceTabFragment.aT = this.f4098a.ap;
                return;
            }
            ((AbstractFbErrorReporter) this.f4098a.aA.get()).a(getClass().getName(), "First card perf logging not supported by fragment " + fragment.getClass().getName());
        }
    }

    /* compiled from: page_videos_max_num */
    public enum PresenceScrollType {
        SCROLL_TO_TAB,
        SCROLL_TO_TOP,
        NO_SCROLL
    }

    public static void m5018a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PagesSurfaceFragment) obj).m5017a(PagesSurfaceFragmentController.m5053a(injectorLike), ScreenUtil.a(injectorLike), (PageHeaderFetcherControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PageHeaderFetcherControllerProvider.class), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), ProfilePicCoverPhotoUploadReceiver.a(injectorLike), PagesExperimentUtils.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), PagesPerfLogger.m2463a(injectorLike), IdBasedProvider.a(injectorLike, 973), PageEventBus.m2423a(injectorLike), CommercePublishingEventBus.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), AdminedPagesRamCache.a(injectorLike), PagesSurfaceFirstCardPerfLogger.a(injectorLike), PagesInternalAnalyticsLogger.a(injectorLike), PageViewerContextLifecycleHelper.a(injectorLike), (PagesActionBarItemFactoryModelProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PagesActionBarItemFactoryModelProvider.class), PagesJobSequencer.m2443a(injectorLike), PagesAnalytics.a(injectorLike), PagesQuickPromotionUtils.a(injectorLike), IdBasedLazy.a(injectorLike, 3588), IdBasedLazy.a(injectorLike, 3561), IdBasedLazy.a(injectorLike, 8972), IdBasedLazy.a(injectorLike, 8936), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.b(injectorLike, 2128), IdBasedLazy.a(injectorLike, 9003), IdBasedSingletonScopeProvider.b(injectorLike, 2360), IdBasedSingletonScopeProvider.b(injectorLike, 9822), IdBasedSingletonScopeProvider.b(injectorLike, 616), IdBasedLazy.a(injectorLike, 9000), IdBasedLazy.a(injectorLike, 3585));
    }

    public static String m5012a(PageHeaderData pageHeaderData) {
        return (pageHeaderData.e == null || pageHeaderData.e.Z() == null) ? "unknown" : pageHeaderData.e.Z().name();
    }

    private void m5014a(TriState triState, PageHeaderData pageHeaderData, PageViewReferrer pageViewReferrer) {
        Object obj;
        if (pageHeaderData.e == null || !pageHeaderData.e.y()) {
            obj = null;
        } else {
            obj = 1;
        }
        this.f4110h.f1661i = triState;
        this.f4110h.m2466a("IsOwned", obj != null ? "true" : "false");
        this.f4110h.m2466a("SuperCategoryType", m5012a(this.bi));
        this.f4110h.m2466a("Referrer", pageViewReferrer.loggingName);
        this.f4110h.m2466a("IsPresence", "true");
        this.f4110h.m2466a("TabsEnabled", aC(this) ? "true" : "false");
        this.f4110h.m2466a("SurfaceFirstCardFromEarlyFetcher", this.bw != null ? "true" : "false");
        this.f4110h.m2466a("SurfaceFirstCardCachedWithEarlyFetcher", this.bx != null ? "true" : "false");
    }

    private void m5017a(PagesSurfaceFragmentController pagesSurfaceFragmentController, ScreenUtil screenUtil, PageHeaderFetcherControllerProvider pageHeaderFetcherControllerProvider, FbTitleBarSupplier fbTitleBarSupplier, ProfilePicCoverPhotoUploadReceiver profilePicCoverPhotoUploadReceiver, PagesExperimentUtils pagesExperimentUtils, QeAccessor qeAccessor, PagesPerfLogger pagesPerfLogger, Provider<FbEventSubscriberListManager> provider, PageEventBus pageEventBus, CommercePublishingEventBus commercePublishingEventBus, Product product, AdminedPagesRamCache adminedPagesRamCache, PagesSurfaceFirstCardPerfLogger pagesSurfaceFirstCardPerfLogger, PagesInternalAnalyticsLogger pagesInternalAnalyticsLogger, PageViewerContextLifecycleHelper pageViewerContextLifecycleHelper, PagesActionBarItemFactoryModelProvider pagesActionBarItemFactoryModelProvider, PagesJobSequencer pagesJobSequencer, PagesAnalytics pagesAnalytics, PagesQuickPromotionUtils pagesQuickPromotionUtils, Lazy<Toaster> lazy, Lazy<TasksManager> lazy2, Lazy<ActivityResultHandlerResolver> lazy3, Lazy<PagesPhotosFragmentUtils> lazy4, Lazy<FbErrorReporter> lazy5, Lazy<GatekeeperStore> lazy6, Lazy<PagesProfileVideoViewportListener> lazy7, Lazy<InterstitialManager> lazy8, Lazy<QuickPromotionFragmentFactory> lazy9, Lazy<FbUriIntentHandler> lazy10, Lazy<PagesSurfaceAddDeleteTabUtil> lazy11, Lazy<ClickableToastBuilder> lazy12) {
        this.f4103a = pagesSurfaceFragmentController;
        this.f4104b = screenUtil;
        this.f4105c = pageHeaderFetcherControllerProvider;
        this.f4106d = fbTitleBarSupplier;
        this.f4107e = profilePicCoverPhotoUploadReceiver;
        this.f4108f = pagesExperimentUtils;
        this.f4109g = qeAccessor;
        this.f4110h = pagesPerfLogger;
        this.f4111i = provider;
        this.al = pageEventBus;
        this.am = commercePublishingEventBus;
        this.an = product;
        this.ao = adminedPagesRamCache;
        this.ap = pagesSurfaceFirstCardPerfLogger;
        this.aq = pagesInternalAnalyticsLogger;
        this.ar = pageViewerContextLifecycleHelper;
        this.as = pagesActionBarItemFactoryModelProvider;
        this.at = pagesJobSequencer;
        this.au = pagesAnalytics;
        this.av = pagesQuickPromotionUtils;
        this.aw = lazy;
        this.ax = lazy2;
        this.ay = lazy3;
        this.az = lazy4;
        this.aA = lazy5;
        this.aB = lazy6;
        this.aC = lazy7;
        this.aD = lazy8;
        this.aE = lazy9;
        this.aF = lazy10;
        this.aG = lazy11;
        this.aH = lazy12;
    }

    public final void m5045c(Bundle bundle) {
        boolean z;
        super.c(bundle);
        Class cls = PagesSurfaceFragment.class;
        m5018a((Object) this, getContext());
        PagesSurfaceFragmentController pagesSurfaceFragmentController = this.f4103a;
        Bundle bundle2 = this.s;
        Builder builder = new Builder();
        builder.f4113a = bundle2.getLong("com.facebook.katana.profile.id");
        if (bundle == null || !bundle.containsKey("extra_is_admin")) {
            builder.f4114b = TriState.UNSET;
        } else {
            builder.f4114b = TriState.fromDbValue(bundle.getInt("extra_is_admin"));
        }
        builder.f4115c = (ParcelUuid) bundle2.getParcelable("page_fragment_uuid");
        builder.f4116d = (Location) bundle2.getParcelable("extra_user_location");
        builder.f4117e = bundle2.getBoolean("extra_in_admin_container_frag", false);
        if (bundle2.containsKey("page_view_referrer")) {
            builder.f4118f = (PageViewReferrer) bundle2.getSerializable("page_view_referrer");
        } else {
            builder.f4118f = PageViewReferrer.UNKNOWN;
        }
        builder.f4119g = pagesSurfaceFragmentController.f4112a.a();
        this.bg = builder.m5056a();
        this.au.c(this.bg.f4120a, this.bg.f4125f);
        PagesExperimentUtils pagesExperimentUtils = this.f4108f;
        if (pagesExperimentUtils.c() || pagesExperimentUtils.d()) {
            z = true;
        } else {
            z = false;
        }
        this.f4110h.m2465a(Long.toString(this.bg.f4120a), this.bg.f4122c, new EntityHeaderState(z, this.f4108f.c(), this.f4108f.c(), false, this.f4108f.d()));
        this.ap.h();
        this.bi = new PageHeaderData(this.bg.f4120a, this.bg.f4123d);
        this.bj = new PageTabStateData();
        this.ba = this.f4105c.m3467a(this, Long.valueOf(this.bg.f4120a), this.bg.f4125f, this.bg.f4122c.toString());
        this.ba.m3465a(PageDataFetchType.DEFAULT);
        this.bw = this.ba.f2533s;
        this.bx = this.ba.f2532r;
        this.f4107e.a(new C05592(this));
        this.bc = (FbEventSubscriberListManager) this.f4111i.get();
        this.bd = (FbEventSubscriberListManager) this.f4111i.get();
        this.bc.a(new C05625(this));
        this.bc.a(new C05636(this));
        this.bc.a(new C05647(this));
        this.bc.a(new C05658(this));
        this.bc.a(new C05669(this));
        this.bc.a(new PagesSurfaceSwitchToTabEventSubscriber(this) {
            final /* synthetic */ PagesSurfaceFragment f4067a;

            {
                this.f4067a = r1;
            }

            public final void m4981b(FbEvent fbEvent) {
                PagesSurfaceSwitchToTabEvent pagesSurfaceSwitchToTabEvent = (PagesSurfaceSwitchToTabEvent) fbEvent;
                PagesSurfaceFragment pagesSurfaceFragment = this.f4067a;
                GraphQLPagePresenceTabType graphQLPagePresenceTabType = pagesSurfaceSwitchToTabEvent.f1616a;
                if (graphQLPagePresenceTabType != null && pagesSurfaceFragment.aV.m3501a(graphQLPagePresenceTabType)) {
                    pagesSurfaceFragment.mo100d(graphQLPagePresenceTabType);
                }
            }
        });
        this.bd.a(new ProductItemMutationEventSubscriber(this) {
            final /* synthetic */ PagesSurfaceFragment f4068a;

            {
                this.f4068a = r1;
            }

            public final void m4982b(FbEvent fbEvent) {
                PagesSurfaceFragment.m5015a(this.f4068a, UpdatePageSurfaceTabEvent.m2440b());
            }
        });
        this.bd.a(new CommerceShopMutationEventSubscriber(this) {
            final /* synthetic */ PagesSurfaceFragment f4069a;

            {
                this.f4069a = r1;
            }

            public final void m4983b(FbEvent fbEvent) {
                PagesSurfaceFragment.m5015a(this.f4069a, UpdatePageSurfaceTabEvent.m2440b());
            }
        });
        this.bd.a(this.am);
        if (this.f4108f.h()) {
            this.bo = (int) Math.round(-0.5d * ((double) StandardHeaderViewHelper.b(this.f4104b.c(), 1)));
        }
        this.be = new C05603(this);
        at();
        m5022b(aK);
        aK = true;
        this.bf = new PortraitOrientationController();
        a(this.bf);
        this.ar.a();
    }

    private void ar() {
        FadingTitlebarContent fadingTitlebarContent = (FadingTitlebarContent) a(FadingTitlebarContent.class);
        if (this.bb == null && fadingTitlebarContent != null) {
            this.bb = new FadingContentFragmentController();
            this.bb.a(this, this.aU, this, fadingTitlebarContent, true, true);
        }
    }

    private void m5013a(long j, boolean z, boolean z2, boolean z3) {
        if (z && z2 && !z3) {
            Map hashMap = new HashMap();
            hashMap.put("current_page_id", String.valueOf(j));
            QuickPromotionController quickPromotionController = (QuickPromotionController) ((InterstitialManager) this.aD.get()).a(new InterstitialTrigger(QuickPromotionFooterController.f, new InterstitialTriggerContext(hashMap)), QuickPromotionFooterController.class);
            if (quickPromotionController != null) {
                Intent a = quickPromotionController.a(getContext());
                if (a != null && this.aN != null && "1820".equals(quickPromotionController.b())) {
                    if (this.aO == null || !this.aO.b(a)) {
                        QuickPromotionFragment a2 = ((QuickPromotionFragmentFactory) this.aE.get()).a(a);
                        if (a2 instanceof QuickPromotionFooterFragment) {
                            this.aO = a2;
                            this.aO.s.putSerializable("ACTION_BUTTON_THEME_ARG", ActionButtonTheme.SPECIAL);
                            s().a().b(2131565653, this.aO).c();
                            this.aN.setVisibility(0);
                        }
                    } else if (this.aO.mx_()) {
                        this.aO.ay();
                    }
                }
            }
        }
    }

    public final View m5035a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2093792272);
        if (this.f4108f.c()) {
            this.aP = layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), 2131625417));
            this.aQ = (CustomFrameLayout) this.aP.inflate(2130906082, viewGroup, false);
        } else {
            this.aP = layoutInflater;
            this.aQ = (CustomFrameLayout) this.aP.inflate(2130906082, viewGroup, false);
        }
        CustomFrameLayout customFrameLayout = this.aQ;
        LogUtils.f(-470089559, a);
        return customFrameLayout;
    }

    public final void m5038a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.bh = jW_().getConfiguration().orientation;
        this.aR = (FbSwipeRefreshLayout) e(2131561342);
        this.aN = e(2131565653);
        this.aT = (PagesHeaderContainer) e(2131565650);
        this.aT.setLoggingUuid(mo55h());
        this.aT.f4063g.f2591t.mo64a(s());
        this.aW = new LazyView((ViewStub) e(2131565709), new OnInflateRunner<PageIdentityAdminTabsView>(this) {
            final /* synthetic */ PagesSurfaceFragment f4070a;

            {
                this.f4070a = r1;
            }

            public final void m4984a(View view) {
                ((PageIdentityAdminTabsView) view).setPrimaryTabsView(this.f4070a.aX);
            }
        });
        if (this.aX != null && aC(this)) {
            this.aW.a();
        }
        ViewTreeObserver viewTreeObserver = this.aT.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ PagesSurfaceFragment f4071a;

                {
                    this.f4071a = r1;
                }

                public void onGlobalLayout() {
                    Object obj = null;
                    if (this.f4071a.aT.getMeasuredHeight() != this.f4071a.bm) {
                        this.f4071a.bm = this.f4071a.aT.getMeasuredHeight();
                        obj = 1;
                    }
                    if (!(this.f4071a.aU == null || this.f4071a.aU.getHeight() == this.f4071a.bq)) {
                        this.f4071a.bq = this.f4071a.aU.getHeight();
                        obj = 1;
                    }
                    if (obj != null) {
                        PagesSurfaceFragment.m5027i(this.f4071a, this.f4071a.bo);
                    }
                }
            });
        }
        this.aR.e = new OnRefreshListener(this) {
            final /* synthetic */ PagesSurfaceFragment f4072a;

            {
                this.f4072a = r1;
            }

            public final void m4985a() {
                PagesSurfaceFragment.aw(this.f4072a);
            }
        };
        this.aS = (ViewPagerWithCompositeOnPageChangeListener) e(2131565651);
        this.aZ = new PagesSurfacePagerAdapter(this, s(), this.bg.f4120a, this);
        this.aS.setAdapter(this.aZ);
        if (bundle != null) {
            GraphQLPagePresenceTabType graphQLPagePresenceTabType = (GraphQLPagePresenceTabType) bundle.getSerializable("extra_starting_tab");
            if (graphQLPagePresenceTabType != null) {
                this.bt = graphQLPagePresenceTabType;
                this.bu = true;
            }
        }
        if (this.f4106d != null && (this.f4106d.get() instanceof FadingFbTitleBar)) {
            this.aU = (FadingFbTitleBar) this.f4106d.get();
            this.bq = this.aU.getHeight();
        }
        if (!(this.aU == null || this.bk)) {
            ar();
        }
        if (aC(this)) {
            this.bp = (TabbedViewPagerIndicator) e(2131565652);
            this.bp.setViewPager(this.aS);
            this.bp.m = new OnTabClickListener(this) {
                final /* synthetic */ PagesSurfaceFragment f4073a;

                {
                    this.f4073a = r1;
                }

                public final void m4986a(int i, int i2) {
                    PagesSurfaceFragment.m5016a(this.f4073a, PresenceScrollType.SCROLL_TO_TAB);
                    this.f4073a.f4110h.m2464a("TabClick");
                }
            };
            this.bp.l = new OnPageChangeListener(this) {
                final /* synthetic */ PagesSurfaceFragment f4074a;

                {
                    this.f4074a = r1;
                }

                public final void e_(int i) {
                    PagesSurfaceTabsUtil pagesSurfaceTabsUtil = this.f4074a.aV;
                    PagesSurfaceFragment pagesSurfaceFragment = this.f4074a;
                    if (i != pagesSurfaceTabsUtil.m3504b(PagesSurfaceFragment.aJ)) {
                        PagesSurfaceTabFragmentWrapper k = PagesSurfaceFragment.m5030k(this.f4074a, i);
                        if (k != null) {
                            k.aq();
                        }
                    }
                    this.f4074a.au.b(this.f4074a.bg.f4120a, this.f4074a.aV.m3500a(i).k());
                    this.f4074a.ap.e();
                    this.f4074a.f4110h.m2464a("TabSwitch");
                }

                public final void m4987a(int i, float f, int i2) {
                }

                public final void m4988b(int i) {
                }
            };
        }
        if (this.bi.d()) {
            this.aT.m4980a(this.bi, (FbFragment) this);
        } else if (this.bi.c()) {
            aF();
        }
        PagesPerfLogger pagesPerfLogger = this.f4110h;
        pagesPerfLogger.f1654b.c("TimeToSurfaceOnViewCreated", pagesPerfLogger.f1662j, null);
        pagesPerfLogger.f1655c.a(1245312, (short) 101);
    }

    public final void mo54a(Throwable th) {
        Fragment fragment = this.G;
        if (fragment != null && (fragment instanceof PageHeaderDataListener)) {
            ((PageHeaderDataListener) fragment).mo54a(th);
        }
        ((Toaster) this.aw.get()).a(new ToastBuilder(2131235436));
        if (this.aR != null) {
            this.aR.setRefreshing(false);
        }
        m5019a(true);
        this.by = null;
        if (this.bz != null) {
            this.bz.b();
        }
    }

    private static GraphQLPagePresenceTabType as() {
        return aJ;
    }

    public final void m5048e(Bundle bundle) {
        super.e(bundle);
        bundle.putInt("extra_is_admin", this.bg.f4121b.getDbValue());
        bundle.putSerializable("extra_starting_tab", aD());
    }

    public final void m5032G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2050048662);
        super.G();
        this.ba.m3466b();
        if (this.bc != null) {
            this.bc.a(this.al);
        }
        for (PageEvent a2 : this.bv) {
            this.al.a(a2);
        }
        this.bv.clear();
        this.aq.a(getContext(), this.bg.f4120a, aD());
        PagesPerfLogger pagesPerfLogger = this.f4110h;
        pagesPerfLogger.f1654b.c("TimeToSurfaceOnResume", pagesPerfLogger.f1662j, null);
        pagesPerfLogger.f1655c.a(1245312, (short) 42);
        ErrorReporter.getInstance().putLazyCustomData("Last Opened Page Id", new PageIdCustomDataSupplier(String.valueOf(this.bg.f4120a)));
        LogUtils.f(1656921270, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bh = jW_().getConfiguration().orientation;
    }

    public final void c_(boolean z) {
        if (z && this.aO != null) {
            s().a().a(this.aO).c();
            this.aO = null;
            if (this.aN != null) {
                this.aN.setVisibility(8);
            }
        }
    }

    public final PageProfilePermissionsProvider mo96a() {
        return this.be;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void at() {
        /*
        r13 = this;
        r2 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$FetchPageHeaderQueryModel$Builder;
        r2.<init>();
        r1 = 0;
        r8 = r13.s;
        r0 = r8;
        r3 = "model_bundle_page_id";
        r3 = r0.getString(r3);
        r4 = "model_bundle_page_name";
        r4 = r0.getString(r4);
        r5 = "model_bundle_page_profile_pic_uri";
        r0 = r0.getString(r5);
        r5 = com.facebook.common.util.StringUtil.a(r3);
        if (r5 != 0) goto L_0x00cc;
    L_0x0021:
        r5 = r13.bg;
        r8 = r5.f4120a;
        r6 = r8;
        r5 = java.lang.String.valueOf(r6);
        r3 = r5.equals(r3);
        if (r3 == 0) goto L_0x00cc;
    L_0x0030:
        r3 = com.facebook.common.util.StringUtil.a(r4);
        if (r3 != 0) goto L_0x0038;
    L_0x0036:
        r2.v = r4;
    L_0x0038:
        r3 = com.facebook.common.util.StringUtil.a(r0);
        if (r3 != 0) goto L_0x00cc;
    L_0x003e:
        r1 = r13.ao;
        r3 = r13.bg;
        r8 = r3.f4120a;
        r4 = r8;
        r3 = java.lang.String.valueOf(r4);
        r1 = r1.b(r3);
        if (r1 == 0) goto L_0x0099;
    L_0x004f:
        r8 = r1.a;
        r3 = r8;
        if (r3 == 0) goto L_0x0099;
    L_0x0054:
        r4 = r3.d();
        r2.v = r4;
        if (r0 != 0) goto L_0x006d;
    L_0x005c:
        r4 = r3.km_();
        if (r4 == 0) goto L_0x006d;
    L_0x0062:
        r8 = r1.a;
        r0 = r8;
        r0 = r0.km_();
        r0 = r0.a();
    L_0x006d:
        r1 = r3.g();
        if (r1 == 0) goto L_0x00bf;
    L_0x0073:
        r1 = r3.g();
        r1 = com.google.common.collect.ImmutableList.copyOf(r1);
        r2.X = r1;
    L_0x007d:
        r1 = r3.b();
        if (r1 == 0) goto L_0x0099;
    L_0x0083:
        r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageAdminInfoBaseDataModel$Builder;
        r1.<init>();
        r3 = r3.b();
        r3 = r3.a();
        r1.a = r3;
        r1 = r1;
        r1 = r1.a();
        r2.d = r1;
    L_0x0099:
        r8 = com.facebook.common.util.StringUtil.a(r0);
        if (r8 != 0) goto L_0x00cf;
    L_0x009f:
        r8 = r13.f4110h;
        r9 = r8.f1655c;
        r10 = 1245312; // 0x130080 float:1.745054E-39 double:6.15266E-318;
        r11 = "ProfilePicFromLowRes";
        r9.a(r10, r11);
        r9 = r8.f1654b;
        r10 = "TimeToLowResProfilePicUri";
        r11 = r8.f1662j;
        r12 = 0;
        r9.d(r10, r11, r12);
    L_0x00b5:
        r1 = r13.bi;
        r2 = r2.a();
        r1.a(r2, r0);
        return;
    L_0x00bf:
        r1 = com.facebook.ipc.pages.ProfilePermissions.Permission.BASIC_ADMIN;
        r1 = r1.name();
        r1 = com.google.common.collect.ImmutableList.of(r1);
        r2.X = r1;
        goto L_0x007d;
    L_0x00cc:
        r0 = r1;
        goto L_0x003e;
    L_0x00cf:
        r8 = r13.f4110h;
        r9 = r8.f1654b;
        r10 = "TimeToLowResProfilePicUri";
        r11 = r8.f1662j;
        r9.a(r10, r11);
        goto L_0x00b5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.identity.fragments.surface.PagesSurfaceFragment.at():void");
    }

    public final void m5037a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            if (i == 10114 && intent != null) {
                if (intent.hasExtra("extra_add_section_type")) {
                    m5026h(this, (GraphQLPagePresenceTabType) intent.getSerializableExtra("extra_add_section_type"));
                } else if (intent.hasExtra("extra_go_to_section_type")) {
                    GraphQLPagePresenceTabType graphQLPagePresenceTabType = (GraphQLPagePresenceTabType) intent.getSerializableExtra("extra_go_to_section_type");
                    if (graphQLPagePresenceTabType != null) {
                        if (mo99c(graphQLPagePresenceTabType)) {
                            mo100d(graphQLPagePresenceTabType);
                        } else {
                            m5031k(graphQLPagePresenceTabType);
                        }
                    }
                }
            }
            final ActivityResultHandler a = ((ActivityResultHandlerResolver) this.ay.get()).m3200a(i);
            if (a != null) {
                ProfilePermissions profilePermissions;
                final DialogBasedProgressIndicator a2 = a.mo45a();
                if (a2 != null) {
                    a2.a();
                }
                long j = this.bg.f4120a;
                if (this.bi.e != null) {
                    profilePermissions = new ProfilePermissions(this.bi.e.af());
                } else {
                    profilePermissions = null;
                }
                final ListenableFuture a3 = a.mo46a(j, profilePermissions, this, intent, i);
                if (a3 != null) {
                    ((TasksManager) this.ax.get()).a("pages_activity_result_handler", new Callable<ListenableFuture>(this) {
                        final /* synthetic */ PagesSurfaceFragment f4079b;

                        public Object call() {
                            return a3;
                        }
                    }, new OperationResultFutureCallback(this) {
                        final /* synthetic */ PagesSurfaceFragment f4077c;

                        public final void m4990a(Object obj) {
                            OperationResult operationResult = (OperationResult) obj;
                            if (a2 != null) {
                                a2.b();
                            }
                            if (a.mo49b()) {
                                PagesSurfaceFragment.aw(this.f4077c);
                            }
                            a.mo47a(operationResult);
                        }

                        protected final void m4989a(ServiceException serviceException) {
                            if (a2 != null) {
                                a2.b();
                            }
                            a.mo48a(serviceException);
                        }

                        protected final void m4991a(CancellationException cancellationException) {
                            super.a(cancellationException);
                            if (a2 != null) {
                                a2.b();
                            }
                        }
                    });
                }
            }
        }
    }

    public final boolean O_() {
        FbFragment e = this.aZ.m5011e(this.aS.k);
        if ((e instanceof CanHandleBackPressed) && ((CanHandleBackPressed) e).O_()) {
            return true;
        }
        if (aD() == aJ || ((GatekeeperStoreImpl) this.aB.get()).a(PagesCommonAbTestGatekeepers.e, false)) {
            return false;
        }
        mo100d(aJ);
        return true;
    }

    public static int au(PagesSurfaceFragment pagesSurfaceFragment) {
        int i = 0;
        int measuredHeight = pagesSurfaceFragment.bm - pagesSurfaceFragment.bp.getMeasuredHeight();
        if (!pagesSurfaceFragment.bg.f4121b.asBoolean(false)) {
            i = pagesSurfaceFragment.bq;
        }
        return (measuredHeight - i) * -1;
    }

    public static void m5016a(PagesSurfaceFragment pagesSurfaceFragment, PresenceScrollType presenceScrollType) {
        boolean z;
        switch (presenceScrollType) {
            case SCROLL_TO_TAB:
                pagesSurfaceFragment.bo = au(pagesSurfaceFragment);
                break;
            case SCROLL_TO_TOP:
                pagesSurfaceFragment.bo = 0;
                break;
        }
        m5027i(pagesSurfaceFragment, pagesSurfaceFragment.bo);
        pagesSurfaceFragment.m5024g(pagesSurfaceFragment.bo);
        if (pagesSurfaceFragment.bo > (-pagesSurfaceFragment.ay())) {
            z = true;
        } else {
            z = false;
        }
        pagesSurfaceFragment.bl = z;
        pagesSurfaceFragment.bn = Math.max(pagesSurfaceFragment.bo, -pagesSurfaceFragment.ay());
        pagesSurfaceFragment.aR.setEnabled(false);
        if (!(pagesSurfaceFragment.bs == null || presenceScrollType == PresenceScrollType.NO_SCROLL)) {
            pagesSurfaceFragment.bs.a(null, 0, 0, 0);
        }
        pagesSurfaceFragment.aZ.m5007a(true);
    }

    private void m5024g(int i) {
        this.aT.setTranslationY((float) i);
        if (this.f4108f.b()) {
            PagesProfileVideoViewportListener pagesProfileVideoViewportListener = (PagesProfileVideoViewportListener) this.aC.get();
            CaspianPagesHeaderView caspianPagesHeaderView = this.aT.f4063g;
            TriState triState = ay() > (-i) ? TriState.YES : TriState.NO;
            if (pagesProfileVideoViewportListener.f2654b == TriState.UNSET || pagesProfileVideoViewportListener.f2654b != triState) {
                ProfileVideoView profileVideoView;
                if (triState == TriState.YES) {
                    if (caspianPagesHeaderView != null && caspianPagesHeaderView.m3553h()) {
                        profileVideoView = caspianPagesHeaderView.getProfileVideoView();
                        if (profileVideoView != null) {
                            profileVideoView.a(EventTriggerType.BY_AUTOPLAY);
                        }
                    }
                } else if (caspianPagesHeaderView != null) {
                    profileVideoView = caspianPagesHeaderView.getProfileVideoView();
                    if (profileVideoView != null) {
                        profileVideoView.b(EventTriggerType.BY_AUTOPLAY);
                    }
                }
                pagesProfileVideoViewportListener.f2654b = triState;
            }
        }
    }

    public static void av(PagesSurfaceFragment pagesSurfaceFragment) {
        pagesSurfaceFragment.ba.m3465a(PageDataFetchType.FORCED_BY_USER);
    }

    public static void aw(PagesSurfaceFragment pagesSurfaceFragment) {
        av(pagesSurfaceFragment);
        m5025h(pagesSurfaceFragment, pagesSurfaceFragment.aS.k);
    }

    public static void m5023e(PagesSurfaceFragment pagesSurfaceFragment, GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        if (pagesSurfaceFragment.aV.m3501a(graphQLPagePresenceTabType)) {
            m5025h(pagesSurfaceFragment, pagesSurfaceFragment.aV.m3504b(graphQLPagePresenceTabType));
        }
    }

    public static void m5025h(PagesSurfaceFragment pagesSurfaceFragment, int i) {
        PagesSurfaceTabFragment pagesSurfaceTabFragment = (PagesSurfaceTabFragment) pagesSurfaceFragment.aZ.m5011e(i);
        if (pagesSurfaceTabFragment != null) {
            pagesSurfaceTabFragment.j();
        }
    }

    private int ay() {
        return StandardHeaderViewHelper.b(this.f4104b.c(), this.bh);
    }

    public final void m5044b(OnScrollListener onScrollListener) {
        this.bs = onScrollListener;
    }

    public final FadingContentView m5050j() {
        return this.aT.f4063g;
    }

    public final boolean mk_() {
        return this.bl;
    }

    public final int ml_() {
        return this.bn;
    }

    public final void m5051p() {
        this.bk = true;
    }

    public final void m5039a(ViewGroup viewGroup, int i) {
        if (i != 0) {
            m5024g(-this.bm);
            this.aR.setEnabled(false);
            this.bl = false;
            this.bn = -this.bm;
            m5027i(this, this.bn);
            return;
        }
        int top = viewGroup.getChildAt(0).getTop();
        if (viewGroup instanceof ScrollView) {
            top = viewGroup.getScrollY() * -1;
        }
        m5027i(this, top);
        int max = Math.max(top, -this.bm);
        m5024g(max);
        this.bl = max > (-ay());
        this.bn = Math.max(max, -ay());
        if (top == 0) {
            this.aR.setEnabled(true);
        } else {
            this.aR.setEnabled(false);
        }
        if (aC(this)) {
            top = this.bp.getMeasuredHeight();
            if (this.bm != 0) {
                this.bo = Math.max(max, ((this.bm - top) - (this.bg.f4121b.asBoolean(false) ? 0 : this.bq)) * -1);
            } else if (!this.f4108f.h()) {
                this.bo = max;
            }
        }
        if (this.bs != null) {
            this.bs.a(null, 0, 0, 0);
        }
        this.aZ.m5007a(false);
    }

    public static void m5027i(PagesSurfaceFragment pagesSurfaceFragment, int i) {
        int i2 = 0;
        if (aC(pagesSurfaceFragment)) {
            int measuredHeight = pagesSurfaceFragment.bp.getMeasuredHeight();
            if (!pagesSurfaceFragment.bg.f4121b.asBoolean(false)) {
                i2 = pagesSurfaceFragment.bq;
            }
            pagesSurfaceFragment.bp.setTranslationY((float) Math.max((pagesSurfaceFragment.bm - measuredHeight) + i, i2));
        }
    }

    public final void mo53a(GraphQLResult<FetchPageHeaderQueryModel> graphQLResult, PageDataFetchType pageDataFetchType) {
        FetchPageHeaderQueryModel fetchPageHeaderQueryModel = (FetchPageHeaderQueryModel) graphQLResult.d();
        DataFreshnessResult a = graphQLResult.a();
        if (fetchPageHeaderQueryModel == null) {
            ((AbstractFbErrorReporter) this.aA.get()).b("page_identity_data_graphql_returned_null", "Page header model is null: is from network == " + (graphQLResult.a().equals(DataFreshnessResult.FROM_SERVER) ? "true" : "false"));
            m5019a(true);
        } else if (m5020a((GraphQLResult) graphQLResult)) {
            m5021b((GraphQLResult) graphQLResult);
        } else {
            CharSequence charSequence;
            if (fetchPageHeaderQueryModel.N() == null || StringUtil.a(fetchPageHeaderQueryModel.N().b())) {
                charSequence = null;
            } else {
                charSequence = fetchPageHeaderQueryModel.N().b();
            }
            this.bg = PagesSurfaceFragmentController.m5054a(this.bg, fetchPageHeaderQueryModel);
            if (this.bg.m5058b() == TriState.YES && ProfilePermissions.b(fetchPageHeaderQueryModel.af())) {
                this.ar.a(Long.toString(this.bg.m5057a()));
            }
            if (a == DataFreshnessResult.FROM_SERVER) {
                if (this.bg.m5058b() == TriState.NO) {
                    this.ao.a(String.valueOf(this.bg.m5057a()));
                } else if (this.bg.m5058b() == TriState.YES) {
                    this.ao.a(String.valueOf(this.bg.m5057a()), fetchPageHeaderQueryModel.D(), fetchPageHeaderQueryModel.af(), null, fetchPageHeaderQueryModel.l() != null ? Boolean.valueOf(fetchPageHeaderQueryModel.l().a()) : null, StringUtil.a(charSequence) ? Absent.withType() : Optional.of(charSequence));
                }
            }
            if (aA()) {
                aB();
                return;
            }
            this.bi.a(fetchPageHeaderQueryModel, a);
            this.bj.a(fetchPageHeaderQueryModel);
            if (!(!aC(this) || fetchPageHeaderQueryModel.aa() == null || fetchPageHeaderQueryModel.aa().isEmpty())) {
                this.aZ.f4102e = this.aV.m3502a(fetchPageHeaderQueryModel.aa());
                this.aZ.kR_();
                this.bp.setVisibility(0);
                this.bp.b();
                if (pageDataFetchType == PageDataFetchType.DEFAULT) {
                    if (this.bu && this.aV.m3501a(this.bt)) {
                        this.aS.setCurrentItem(this.aV.m3504b(this.bt));
                        this.bu = false;
                    } else if (this.aV.m3501a(as())) {
                        this.aS.setCurrentItem(this.aV.m3504b(as()));
                    }
                }
            }
            m5014a(this.bg.m5058b(), this.bi, this.bg.m5059f());
            this.aT.m4980a(this.bi, (FbFragment) this);
            this.aZ.m5010d();
            this.aI = true;
            FbFragment e = this.aZ.m5011e(aE(this));
            if (e instanceof PagesGenericReactionSurfaceTabFragment) {
                ((PagesGenericReactionSurfaceTabFragment) e).m3391e();
            }
            az();
            Fragment mw_ = mw_();
            if (mw_ != null && (mw_ instanceof PageHeaderDataListener)) {
                ((PageHeaderDataListener) mw_).mo53a(graphQLResult, pageDataFetchType);
            }
            if (this.aR != null) {
                this.aR.setRefreshing(false);
            }
            m5013a(this.bg.m5057a(), fetchPageHeaderQueryModel.x(), ProfilePermissions.b(fetchPageHeaderQueryModel.af()), !GraphQLPageVerificationBadge.NOT_VERIFIED.equals(fetchPageHeaderQueryModel.ad()));
            aF();
            if (this.by != null) {
                if (mo99c(this.by)) {
                    mo100d(this.by);
                } else {
                    ((Toaster) this.aw.get()).a(new ToastBuilder(2131235444));
                }
                this.by = null;
                if (this.bz != null) {
                    this.bz.b();
                }
            }
            if (this.bA != null) {
                this.bA.b();
            }
        }
    }

    private boolean m5020a(GraphQLResult<FetchPageHeaderQueryModel> graphQLResult) {
        if (graphQLResult.e == null) {
            return false;
        }
        ImmutableList R = ((FetchPageHeaderQueryModel) graphQLResult.e).R();
        if (R == null || R.isEmpty() || R.get(0) == null || ((RedirectionInfoModel) R.get(0)).a() == null) {
            return false;
        }
        return Long.parseLong(((RedirectionInfoModel) R.get(0)).a().j()) != this.bg.f4120a;
    }

    private void m5021b(GraphQLResult<FetchPageHeaderQueryModel> graphQLResult) {
        Preconditions.checkArgument(m5020a((GraphQLResult) graphQLResult));
        if (graphQLResult == null || graphQLResult.e == null || ((FetchPageHeaderQueryModel) graphQLResult.e).R().isEmpty() || ((FetchPageHeaderQueryModel) graphQLResult.e).R().get(0) == null || ((RedirectionInfoModel) ((FetchPageHeaderQueryModel) graphQLResult.e).R().get(0)).a() == null || ((RedirectionInfoModel) ((FetchPageHeaderQueryModel) graphQLResult.e).R().get(0)).a().j() == null) {
            ((AbstractFbErrorReporter) this.aA.get()).b(getClass().getName(), "No global redirection_info");
            return;
        }
        this.au.a(this.bg.f4120a, Long.parseLong(((RedirectionInfoModel) ((FetchPageHeaderQueryModel) graphQLResult.e).R().get(0)).a().j()));
        PagesSurfaceFragment pagesSurfaceFragment = new PagesSurfaceFragment();
        Bundle bundle = this.s;
        bundle.putParcelable("page_fragment_uuid", new ParcelUuid(SafeUUIDGenerator.a()));
        bundle.putLong("com.facebook.katana.profile.id", Long.parseLong(((RedirectionInfoModel) ((FetchPageHeaderQueryModel) graphQLResult.e).R().get(0)).a().j()));
        pagesSurfaceFragment.g(bundle);
        m5019a(false);
        kO_().a().b(2131558429, pagesSurfaceFragment).c();
    }

    private void az() {
        if (!(this.aU == null || this.bb == null || this.aT.f4063g.a())) {
            this.bb.a();
        }
        if (!this.bg.f4124e && this.bi.e != null && !StringUtil.a(this.bi.e.D())) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.setCustomTitle(null);
                hasTitleBar.kg_();
                hasTitleBar.a_(this.bi.e.D());
            }
        }
    }

    public final ParcelUuid mo55h() {
        if (this.bg.f4122c == null && this.s != null) {
            ParcelUuid parcelUuid = (ParcelUuid) this.s.getParcelable("page_fragment_uuid");
            Builder a = Builder.m5055a(this.bg);
            a.f4115c = parcelUuid;
            PagesSurfaceFragmentModel a2 = a.m5056a();
        }
        return this.bg.f4122c;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1129238352);
        super.mY_();
        this.aI = false;
        if (this.aV.m3501a(aJ)) {
            FbFragment e = this.aZ.m5011e(this.aV.m3504b(aJ));
            if (e instanceof PagesGenericReactionSurfaceTabFragment) {
                ((PagesGenericReactionSurfaceTabFragment) e).ba = false;
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2115244632, a);
    }

    public final boolean mo99c(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        return aC(this) && this.aV.m3501a(graphQLPagePresenceTabType);
    }

    public final void mo100d(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        if (aC(this) && this.aV.m3501a(graphQLPagePresenceTabType)) {
            m5016a(this, PresenceScrollType.SCROLL_TO_TAB);
            this.aS.setCurrentItem(this.aV.m3504b(graphQLPagePresenceTabType));
        }
    }

    public final boolean mo97a(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        if (aC(this)) {
            FetchPageHeaderQueryModel fetchPageHeaderQueryModel;
            Object obj;
            PagesSurfaceTabsUtil pagesSurfaceTabsUtil = this.aV;
            if (this.bi != null) {
                fetchPageHeaderQueryModel = this.bi.e;
            } else {
                fetchPageHeaderQueryModel = null;
            }
            if (!(!PagesSurfaceAddDeleteTabUtil.f2550a.contains(graphQLPagePresenceTabType) || pagesSurfaceTabsUtil == null || pagesSurfaceTabsUtil.m3501a(graphQLPagePresenceTabType))) {
                Object obj2;
                if (fetchPageHeaderQueryModel == null) {
                    obj2 = null;
                } else {
                    ImmutableList U = fetchPageHeaderQueryModel.U();
                    int size = U.size();
                    for (int i = 0; i < size; i++) {
                        if (((SectionsCanAddModel) U.get(i)).a() == graphQLPagePresenceTabType) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                }
                if (obj2 != null) {
                    obj = 1;
                    if (obj != null) {
                        return true;
                    }
                }
            }
            obj = null;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final void mo98b(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        if (this.bz == null) {
            this.bz = new DialogBasedProgressIndicator(getContext(), 2131235446);
        }
        this.bz.a();
        ((PagesSurfaceAddDeleteTabUtil) this.aG.get()).m3497a(Long.toString(this.bi.a), graphQLPagePresenceTabType, new Object(this) {
            public final /* synthetic */ PagesSurfaceFragment f4081a;

            {
                this.f4081a = r1;
            }
        });
    }

    public static void m5026h(PagesSurfaceFragment pagesSurfaceFragment, GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        if (graphQLPagePresenceTabType != null && pagesSurfaceFragment.mo97a(graphQLPagePresenceTabType)) {
            pagesSurfaceFragment.mo98b(graphQLPagePresenceTabType);
        } else if (graphQLPagePresenceTabType == null || !pagesSurfaceFragment.mo99c(graphQLPagePresenceTabType)) {
            pagesSurfaceFragment.m5029j(2131235444);
        } else {
            pagesSurfaceFragment.mo100d(graphQLPagePresenceTabType);
        }
    }

    public static void m5028i(PagesSurfaceFragment pagesSurfaceFragment, GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        if (graphQLPagePresenceTabType != null) {
            Object obj;
            if (aC(pagesSurfaceFragment)) {
                FetchPageHeaderQueryModel fetchPageHeaderQueryModel;
                Object obj2;
                PagesSurfaceTabsUtil pagesSurfaceTabsUtil = pagesSurfaceFragment.aV;
                if (pagesSurfaceFragment.bi != null) {
                    fetchPageHeaderQueryModel = pagesSurfaceFragment.bi.e;
                } else {
                    fetchPageHeaderQueryModel = null;
                }
                if (PagesSurfaceAddDeleteTabUtil.f2550a.contains(graphQLPagePresenceTabType) && pagesSurfaceTabsUtil != null && pagesSurfaceTabsUtil.m3501a(graphQLPagePresenceTabType)) {
                    Object obj3 = null;
                    if (fetchPageHeaderQueryModel != null) {
                        switch (C03384.f2549a[graphQLPagePresenceTabType.ordinal()]) {
                            case 1:
                                obj3 = 1;
                                break;
                            default:
                                break;
                        }
                    }
                    if (obj3 != null) {
                        obj2 = 1;
                        if (obj2 != null) {
                            obj = 1;
                            if (obj != null) {
                                if (pagesSurfaceFragment.bA == null) {
                                    pagesSurfaceFragment.bA = new DialogBasedProgressIndicator(pagesSurfaceFragment.getContext(), 2131235447);
                                }
                                pagesSurfaceFragment.bA.a();
                                ((PagesSurfaceAddDeleteTabUtil) pagesSurfaceFragment.aG.get()).m3498a(Long.toString(pagesSurfaceFragment.bi.a), graphQLPagePresenceTabType, new Object(pagesSurfaceFragment) {
                                    public final /* synthetic */ PagesSurfaceFragment f4082a;

                                    {
                                        this.f4082a = r1;
                                    }
                                });
                                return;
                            }
                        }
                    }
                }
                obj2 = null;
                if (obj2 != null) {
                    obj = 1;
                    if (obj != null) {
                        if (pagesSurfaceFragment.bA == null) {
                            pagesSurfaceFragment.bA = new DialogBasedProgressIndicator(pagesSurfaceFragment.getContext(), 2131235447);
                        }
                        pagesSurfaceFragment.bA.a();
                        ((PagesSurfaceAddDeleteTabUtil) pagesSurfaceFragment.aG.get()).m3498a(Long.toString(pagesSurfaceFragment.bi.a), graphQLPagePresenceTabType, /* anonymous class already generated */);
                        return;
                    }
                }
            }
            obj = null;
            if (obj != null) {
                if (pagesSurfaceFragment.bA == null) {
                    pagesSurfaceFragment.bA = new DialogBasedProgressIndicator(pagesSurfaceFragment.getContext(), 2131235447);
                }
                pagesSurfaceFragment.bA.a();
                ((PagesSurfaceAddDeleteTabUtil) pagesSurfaceFragment.aG.get()).m3498a(Long.toString(pagesSurfaceFragment.bi.a), graphQLPagePresenceTabType, /* anonymous class already generated */);
                return;
            }
        }
        pagesSurfaceFragment.m5029j(2131235445);
    }

    private void m5031k(GraphQLPagePresenceTabType graphQLPagePresenceTabType) {
        String D;
        String valueOf = String.valueOf(this.bi.a);
        if (this.bi.e != null) {
            D = this.bi.e.D();
        } else {
            D = null;
        }
        switch (AnonymousClass23.f4086b[graphQLPagePresenceTabType.ordinal()]) {
            case 1:
                Bundle bundle = new Bundle();
                bundle.putString("com.facebook.katana.profile.id", valueOf);
                if (!Strings.isNullOrEmpty(D)) {
                    bundle.putString("profile_name", D);
                }
                ((FbUriIntentHandler) this.aF.get()).a(getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.ag, valueOf), bundle);
                return;
            default:
                return;
        }
    }

    private void m5029j(int i) {
        Snackbar.a(this.aQ, jW_().getString(i), 0).b();
    }

    public final void m5034I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1575316307);
        super.I();
        this.ba.m3464a();
        if (this.aR != null) {
            this.aR.e = null;
            this.aR = null;
        }
        if (this.bd != null) {
            this.bd.b(this.am);
        }
        this.f4110h.m2467e();
        this.f4107e.a();
        this.at.m2451b(Long.toString(this.bg.f4120a), null);
        this.ar.b();
        this.br = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -677114797, a);
    }

    public final void m5033H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1308323079);
        super.H();
        m5019a(false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 106354764, a);
    }

    public final GraphSearchQuery m5052q() {
        if (this.bi == null || this.bi.e == null) {
            return GraphSearchQuery.e;
        }
        GraphSearchQuery a;
        FetchPageHeaderQueryModel fetchPageHeaderQueryModel = this.bi.e;
        String D = fetchPageHeaderQueryModel.D();
        if (((GatekeeperStoreImpl) this.aB.get()).a(SearchAbTestGatekeepers.q, false)) {
            a = GraphSearchQuery.a(ScopedEntityType.PAGE, String.valueOf(this.bi.a), D, ScopedSearchStyle.TAB, true);
        } else {
            a = GraphSearchQuery.a(ScopedEntityType.PAGE, String.valueOf(this.bi.a), D, null, true);
        }
        GraphQLPlaceType K = fetchPageHeaderQueryModel.K();
        if (K == null || K == GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return a;
        }
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
        return a;
    }

    private boolean aA() {
        if (this.an.equals(Product.PAA)) {
            return false;
        }
        if (!this.bg.f4121b.asBoolean(false)) {
            if (this.bg.f4124e) {
                ((AbstractFbErrorReporter) this.aA.get()).a(getClass().getName(), "Non-admin ends up in admin container fragment");
            }
            return false;
        } else if (this.bg.f4124e) {
            return false;
        } else {
            ((AbstractFbErrorReporter) this.aA.get()).a(SoftError.b(getClass().getName(), "admin redirection"));
            if (this.T == null || this.T.getParent() == null || this.br) {
                return false;
            }
            return true;
        }
    }

    private void aB() {
        PageIdentityFragment pageIdentityFragment = new PageIdentityFragment();
        Bundle bundle = this.s;
        bundle.putBoolean("extra_has_been_redirected", true);
        bundle.putParcelable("page_fragment_uuid", new ParcelUuid(SafeUUIDGenerator.a()));
        pageIdentityFragment.g(bundle);
        m5019a(false);
        kO_().a().b(2131558429, pageIdentityFragment).c();
    }

    private void m5019a(boolean z) {
        ((TasksManager) this.ax.get()).c();
        if (this.bc != null) {
            this.bc.b(this.al);
        }
        PagesPerfLogger pagesPerfLogger = this.f4110h;
        pagesPerfLogger.f1654b.b(this.bg.f4122c.toString());
        if (z) {
            pagesPerfLogger.f1655c.b(1245312, pagesPerfLogger.f1662j.hashCode(), (short) 3);
        } else {
            pagesPerfLogger.f1655c.markerCancel(1245312, pagesPerfLogger.f1662j.hashCode());
        }
        pagesPerfLogger.f1656d.m2450a(pagesPerfLogger.f1660h, ImmutableSet.of(SequencerSignal.HEADER_PERF_LOGGING_STOPPED));
        this.f4110h.m2467e();
        if (z) {
            this.ap.f();
        } else {
            this.ap.e();
        }
        if (this.f4108f.b()) {
            ((PagesProfileVideoViewportListener) this.aC.get()).f2654b = TriState.UNSET;
        }
    }

    public static void m5015a(PagesSurfaceFragment pagesSurfaceFragment, final PageEvent pageEvent) {
        if (pagesSurfaceFragment.o() != null) {
            pagesSurfaceFragment.o().runOnUiThread(new Runnable(pagesSurfaceFragment) {
                final /* synthetic */ PagesSurfaceFragment f4084b;

                public void run() {
                    if (this.f4084b.o() != null && !this.f4084b.o().isFinishing()) {
                        if (this.f4084b.y) {
                            this.f4084b.al.a(pageEvent);
                        } else {
                            this.f4084b.bv.add(pageEvent);
                        }
                    }
                }
            });
        }
    }

    private void m5022b(boolean z) {
        this.f4110h.m2466a("FirstVisit", z ? "false" : "true");
        this.ap.a("FirstVisit", z ? "false" : "true");
    }

    public static boolean aC(PagesSurfaceFragment pagesSurfaceFragment) {
        return pagesSurfaceFragment.bg.f4126g;
    }

    private GraphQLPagePresenceTabType aD() {
        return (!aC(this) || this.aV.f2555a.isEmpty()) ? GraphQLPagePresenceTabType.HOME : this.aV.m3500a(this.aS.k).k();
    }

    @Nullable
    public static PagesSurfaceTabFragmentWrapper m5030k(PagesSurfaceFragment pagesSurfaceFragment, int i) {
        return (PagesSurfaceTabFragmentWrapper) pagesSurfaceFragment.aY.get(pagesSurfaceFragment.aV.m3500a(i).k());
    }

    public static int aE(PagesSurfaceFragment pagesSurfaceFragment) {
        return pagesSurfaceFragment.f4108f.a() ? pagesSurfaceFragment.aV.m3504b(aJ) : 0;
    }

    private void aF() {
        if (this.bg.f4121b.asBoolean(false)) {
            this.av.a(aL, getContext());
        }
    }
}
