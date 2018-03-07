package com.facebook.pages.identity.cards.actionbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.ParcelUuid;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;
import com.facebook.adsmanager.deeplinking.AdsManagerDeepLinkingUtils;
import com.facebook.analytics.CurationMechanism;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionExtraFieldsModel;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.intent.HomeIntentHandlerHelper;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.shortcuts.InstallShortcutHelper;
import com.facebook.common.shortcuts.InstallShortcutHelper.IconStyle;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.util.ModernFeedbackGraphQLGenerator;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.events.common.ActionMechanism;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.menu.PopoverMenu.Callback;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.BookmarkAddToFavoritesInputData;
import com.facebook.graphql.calls.BookmarkAddToFavoritesInputData.Source;
import com.facebook.graphql.calls.BookmarkRemoveFromFavoritesInputData;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.nux.interstitial.SaveNuxBubbleDelegate;
import com.facebook.pages.common.abtest.PagesCommonAbTestGatekeepers;
import com.facebook.pages.common.actionbar.blueservice.PagesCommonActionBarDataMutator;
import com.facebook.pages.common.constants.PagesAsyncTaskType;
import com.facebook.pages.common.constants.PagesConstants.URL;
import com.facebook.pages.common.constants.ReportFlags;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.PageActionBarDrawnEvent;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.intent_builder.IPageIdentityIntentBuilder;
import com.facebook.pages.common.logging.analytics.AdminActionBarEvent;
import com.facebook.pages.common.logging.analytics.NetworkFailureEvent;
import com.facebook.pages.common.logging.analytics.NetworkSuccessEvent;
import com.facebook.pages.common.logging.analytics.PageAnalyticsEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.common.logging.analytics.ViewEvents;
import com.facebook.pages.common.models.bookmark_favorites.PageFavoriteBookmarksGraphQL.FBBookmarkAddToFavoritesMutationString;
import com.facebook.pages.common.models.bookmark_favorites.PageFavoriteBookmarksGraphQL.FBBookmarkRemoveFromFavoritesMutationString;
import com.facebook.pages.common.models.bookmark_favorites.PageFavoriteBookmarksGraphQLModels.FBBookmarkAddToFavoritesMutationModel;
import com.facebook.pages.common.models.bookmark_favorites.PageFavoriteBookmarksGraphQLModels.FBBookmarkRemoveFromFavoritesMutationModel;
import com.facebook.pages.common.pageviewercontext.ViewerContextWaiter;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.NeedToShowSuggestedPagesEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent.HeaderPerfLoggingEventType;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel.Builder;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageAdminInfoBaseDataModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.cards.actionbar.PagesActionBarItemFactory.PageActionType;
import com.facebook.pages.identity.intent.impl.FbAndroidPageSurfaceIntentBuilder;
import com.facebook.places.suggestions.PlaceSuggestionsIntentBuilder;
import com.facebook.places.suggestions.common.CrowdsourcingSource;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.util.PageReviewLoader;
import com.facebook.reviews.util.PageReviewLoader.LoadSingleReviewCallback;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindow;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindow.OnChangeListener;
import com.facebook.timeline.actionbar.seefirst.FollowSwitcherPopupWindowProvider;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.OnDispatchDrawListener;
import com.google.common.base.Absent;
import com.google.common.base.Predicate;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: privacy_checkup_write_request_queued */
public class PagesActionBarController {
    public Lazy<BookmarkManager> f3218A;
    private Lazy<ViewerContextUtil> f3219B;
    private Lazy<ViewerContextManager> f3220C;
    public Lazy<ModernFeedbackGraphQLGenerator> f3221D;
    private Lazy<GatekeeperStore> f3222E;
    public Provider<GraphQLActorCache> f3223F;
    private FbNetworkManager f3224G;
    private FollowSwitcherPopupWindowProvider f3225H;
    private FbAndroidPageSurfaceIntentBuilder f3226I;
    public PageScopedEventBus f3227J;
    private Product f3228K;
    private AdsManagerDeepLinkingUtils f3229L;
    public PageHeaderData f3230M;
    private boolean f3231N;
    public ParcelUuid f3232O;
    public boolean f3233P;
    public boolean f3234Q = false;
    private boolean f3235R = false;
    public boolean f3236S = false;
    public GraphQLSubscribeStatus f3237T;
    public GraphQLSecondarySubscribeStatus f3238U;
    public Context f3239a;
    private PagesActionBar f3240b;
    public Lazy<PagesAnalytics> f3241c;
    public Lazy<IPageIdentityIntentBuilder> f3242d;
    private Lazy<PlaceSuggestionsIntentBuilder> f3243e;
    private Lazy<UriIntentMapper> f3244f;
    public Lazy<FbErrorReporter> f3245g;
    private Lazy<ComposerIntentLauncher> f3246h;
    public Lazy<ComposerLauncher> f3247i;
    private Lazy<SecureContextHelper> f3248j;
    private Lazy<HomeIntentHandlerHelper> f3249k;
    private Lazy<InstallShortcutHelper> f3250l;
    private Lazy<Vibrator> f3251m;
    public Lazy<Toaster> f3252n;
    private Lazy<IFeedIntentBuilder> f3253o;
    private Lazy<PageReviewLoader> f3254p;
    private Lazy<TasksManager> f3255q;
    public Lazy<PageEventBus> f3256r;
    public Lazy<PagesCommonActionBarDataMutator> f3257s;
    private Lazy<SaveNuxBubbleDelegate> f3258t;
    private Lazy<SaveButtonUtils> f3259u;
    private Lazy<ComposerConfigurationFactory> f3260v;
    private Lazy<PagesFollowActionHelper> f3261w;
    private Lazy<Executor> f3262x;
    private Lazy<GraphQLQueryExecutor> f3263y;
    private Lazy<LoggedInUserAuthDataStore> f3264z;

    /* compiled from: privacy_checkup_write_request_queued */
    class C04321 implements OnDispatchDrawListener {
        final /* synthetic */ PagesActionBarController f3204a;

        C04321(PagesActionBarController pagesActionBarController) {
            this.f3204a = pagesActionBarController;
        }

        public final boolean m4267a() {
            if (!this.f3204a.f3233P || this.f3204a.f3232O == null) {
                return false;
            }
            this.f3204a.f3227J.a(new PageFragmentScopedHeaderPerfLoggingEvent(this.f3204a.f3232O, HeaderPerfLoggingEventType.ACTION_BAR_DISPATCH_DRAW_WITH_DATA, Absent.INSTANCE));
            ((PageEventBus) this.f3204a.f3256r.get()).a(new PageActionBarDrawnEvent());
            return true;
        }
    }

    /* compiled from: privacy_checkup_write_request_queued */
    class C04332 implements OnChangeListener {
        final /* synthetic */ PagesActionBarController f3206a;

        C04332(PagesActionBarController pagesActionBarController) {
            this.f3206a = pagesActionBarController;
        }

        public final void m4268a(boolean z, boolean z2) {
            if (z) {
                this.f3206a.f3237T = GraphQLSubscribeStatus.IS_SUBSCRIBED;
                if (z2) {
                    this.f3206a.f3238U = GraphQLSecondarySubscribeStatus.SEE_FIRST;
                } else {
                    this.f3206a.f3238U = GraphQLSecondarySubscribeStatus.REGULAR_FOLLOW;
                }
            } else {
                this.f3206a.f3237T = GraphQLSubscribeStatus.CAN_SUBSCRIBE;
                this.f3206a.f3238U = GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            }
            PagesActionBarController.m4319g(this.f3206a);
            this.f3206a.m4317f();
        }
    }

    /* compiled from: privacy_checkup_write_request_queued */
    class C04343 implements OnDismissListener {
        final /* synthetic */ PagesActionBarController f3207a;

        C04343(PagesActionBarController pagesActionBarController) {
            this.f3207a = pagesActionBarController;
        }

        public final boolean m4269a(PopoverWindow popoverWindow) {
            PageAnalyticsEvent pageAnalyticsEvent;
            if (!PagesActionBarController.m4319g(this.f3207a)) {
                pageAnalyticsEvent = TapEvent.EVENT_TAPPED_FOLLOW_SWITCHER_UNFOLLOW;
            } else if (this.f3207a.f3230M) {
                pageAnalyticsEvent = TapEvent.EVENT_TAPPED_FOLLOW_SWITCHER_SEE_FIRST;
            } else {
                pageAnalyticsEvent = TapEvent.EVENT_TAPPED_FOLLOW_SWITCHER_REGULAR;
            }
            ((PagesAnalytics) this.f3207a.f3241c.get()).a(pageAnalyticsEvent, this.f3207a.f3230M.a);
            this.f3207a.m4317f();
            return true;
        }
    }

    /* compiled from: privacy_checkup_write_request_queued */
    class C04365 implements Callback {
        final /* synthetic */ PagesActionBarController f3211a;

        C04365(PagesActionBarController pagesActionBarController) {
            this.f3211a = pagesActionBarController;
        }

        public final boolean m4270a(MenuItem menuItem) {
            if (menuItem.getItemId() == 0) {
                this.f3211a.m4289a(ReportFlags.OFFENSIVE);
            }
            if (menuItem.getItemId() == 1) {
                this.f3211a.m4289a(ReportFlags.NOT_PUBLIC);
            }
            if (menuItem.getItemId() == 2) {
                this.f3211a.f3221D;
            }
            if (menuItem.getItemId() == 3) {
                this.f3211a.m4289a(ReportFlags.CLOSED);
            }
            return true;
        }
    }

    /* compiled from: privacy_checkup_write_request_queued */
    class C04387 extends OperationResultFutureCallback {
        final /* synthetic */ PagesActionBarController f3214a;

        C04387(PagesActionBarController pagesActionBarController) {
            this.f3214a = pagesActionBarController;
        }

        protected final void m4272a(Object obj) {
            ((Toaster) this.f3214a.f3252n.get()).b(new ToastBuilder(2131235398));
            ((PagesAnalytics) this.f3214a.f3241c.get()).a(NetworkSuccessEvent.EVENT_PLACE_REPORT_SUCCESS, this.f3214a.f3230M.a);
        }

        protected final void m4271a(ServiceException serviceException) {
            ((Toaster) this.f3214a.f3252n.get()).b(new ToastBuilder(2131235399));
            ((PagesAnalytics) this.f3214a.f3241c.get()).a(NetworkFailureEvent.EVENT_PLACE_REPORT_ERROR, this.f3214a.f3230M.a);
            ((AbstractFbErrorReporter) this.f3214a.f3245g.get()).a("page_identity_report_fail", serviceException);
        }
    }

    /* compiled from: privacy_checkup_write_request_queued */
    class C04409 implements Predicate<ViewerContext> {
        final /* synthetic */ PagesActionBarController f3217a;

        C04409(PagesActionBarController pagesActionBarController) {
            this.f3217a = pagesActionBarController;
        }

        public boolean apply(Object obj) {
            this.f3217a.m4287a((ViewerContext) obj);
            return true;
        }
    }

    public static PagesActionBarController m4301b(InjectorLike injectorLike) {
        return new PagesActionBarController(IdBasedSingletonScopeProvider.b(injectorLike, 8930), IdBasedLazy.a(injectorLike, 9096), IdBasedSingletonScopeProvider.b(injectorLike, 9575), IdBasedSingletonScopeProvider.b(injectorLike, 2436), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedLazy.a(injectorLike, 2371), IdBasedSingletonScopeProvider.b(injectorLike, 849), IdBasedSingletonScopeProvider.b(injectorLike, 968), IdBasedLazy.a(injectorLike, 568), IdBasedLazy.a(injectorLike, 5162), IdBasedLazy.a(injectorLike, 52), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 2347), IdBasedSingletonScopeProvider.b(injectorLike, 10281), IdBasedLazy.a(injectorLike, 3561), IdBasedSingletonScopeProvider.b(injectorLike, 8920), IdBasedLazy.a(injectorLike, 8904), IdBasedLazy.a(injectorLike, 2848), IdBasedSingletonScopeProvider.b(injectorLike, 321), IdBasedLazy.a(injectorLike, 2369), IdBasedLazy.a(injectorLike, 9029), IdBasedSingletonScopeProvider.b(injectorLike, 3863), IdBasedLazy.a(injectorLike, 2164), IdBasedSingletonScopeProvider.b(injectorLike, 339), IdBasedSingletonScopeProvider.b(injectorLike, 4985), IdBasedLazy.a(injectorLike, 9011), IdBasedLazy.a(injectorLike, 375), IdBasedLazy.a(injectorLike, 997), IdBasedSingletonScopeProvider.b(injectorLike, 2128), IdBasedSingletonScopeProvider.a(injectorLike, 262), FbNetworkManager.a(injectorLike), (FollowSwitcherPopupWindowProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FollowSwitcherPopupWindowProvider.class), FbAndroidPageSurfaceIntentBuilder.m5073a(injectorLike), PageScopedEventBus.a(injectorLike), ProductMethodAutoProvider.a(injectorLike), AdsManagerDeepLinkingUtils.a(injectorLike));
    }

    public static PagesActionBarController m4285a(InjectorLike injectorLike) {
        return m4301b(injectorLike);
    }

    @Inject
    public PagesActionBarController(Lazy<PagesAnalytics> lazy, Lazy<IPageIdentityIntentBuilder> lazy2, Lazy<PlaceSuggestionsIntentBuilder> lazy3, Lazy<UriIntentMapper> lazy4, Lazy<FbErrorReporter> lazy5, Lazy<ComposerIntentLauncher> lazy6, Lazy<ComposerLauncher> lazy7, Lazy<SecureContextHelper> lazy8, Lazy<HomeIntentHandlerHelper> lazy9, Lazy<InstallShortcutHelper> lazy10, Lazy<Vibrator> lazy11, Lazy<Toaster> lazy12, Lazy<IFeedIntentBuilder> lazy13, Lazy<PageReviewLoader> lazy14, Lazy<TasksManager> lazy15, Lazy<PageEventBus> lazy16, Lazy<PagesCommonActionBarDataMutator> lazy17, Lazy<SaveNuxBubbleDelegate> lazy18, Lazy<SaveButtonUtils> lazy19, Lazy<ComposerConfigurationFactory> lazy20, Lazy<PagesFollowActionHelper> lazy21, Lazy<Executor> lazy22, Lazy<GraphQLQueryExecutor> lazy23, Lazy<LoggedInUserAuthDataStore> lazy24, Lazy<BookmarkManager> lazy25, Lazy<ViewerContextUtil> lazy26, Lazy<ViewerContextManager> lazy27, Lazy<ModernFeedbackGraphQLGenerator> lazy28, Lazy<GatekeeperStore> lazy29, Provider<GraphQLActorCache> provider, FbNetworkManager fbNetworkManager, FollowSwitcherPopupWindowProvider followSwitcherPopupWindowProvider, FbAndroidPageSurfaceIntentBuilder fbAndroidPageSurfaceIntentBuilder, PageScopedEventBus pageScopedEventBus, Product product, AdsManagerDeepLinkingUtils adsManagerDeepLinkingUtils) {
        this.f3241c = lazy;
        this.f3242d = lazy2;
        this.f3243e = lazy3;
        this.f3244f = lazy4;
        this.f3245g = lazy5;
        this.f3246h = lazy6;
        this.f3247i = lazy7;
        this.f3248j = lazy8;
        this.f3249k = lazy9;
        this.f3250l = lazy10;
        this.f3251m = lazy11;
        this.f3252n = lazy12;
        this.f3253o = lazy13;
        this.f3254p = lazy14;
        this.f3255q = lazy15;
        this.f3256r = lazy16;
        this.f3257s = lazy17;
        this.f3258t = lazy18;
        this.f3259u = lazy19;
        this.f3260v = lazy20;
        this.f3261w = lazy21;
        this.f3263y = lazy23;
        this.f3264z = lazy24;
        this.f3218A = lazy25;
        this.f3262x = lazy22;
        this.f3219B = lazy26;
        this.f3220C = lazy27;
        this.f3221D = lazy28;
        this.f3222E = lazy29;
        this.f3223F = provider;
        this.f3224G = fbNetworkManager;
        this.f3225H = followSwitcherPopupWindowProvider;
        this.f3226I = fbAndroidPageSurfaceIntentBuilder;
        this.f3227J = pageScopedEventBus;
        this.f3231N = ((GatekeeperStoreImpl) lazy29.get()).a(PagesCommonAbTestGatekeepers.b, false);
        this.f3228K = product;
        this.f3229L = adsManagerDeepLinkingUtils;
    }

    public final void m4356a(Context context, PagesActionBar pagesActionBar) {
        this.f3239a = (Context) ContextUtils.a(context, Activity.class);
        this.f3240b = pagesActionBar;
    }

    public final void m4359a(PageHeaderData pageHeaderData) {
        PageAdminInfoBaseDataModel l;
        boolean A;
        this.f3230M = pageHeaderData;
        if (this.f3230M != null) {
            this.f3233P = true;
        }
        if (this.f3230M.e != null) {
            l = this.f3230M.e.l();
        } else {
            l = null;
        }
        if (this.f3230M.e != null) {
            A = this.f3230M.e.A();
        } else {
            A = false;
        }
        if (l != null || A) {
            ComposerPageData a = ComposerPageData.newBuilder().setIsPageVerified(A).a();
            this.f3226I.a = a;
            ((DefaultPageSurfaceIntentBuilder) this.f3242d.get()).a = a;
        }
        m4302b();
    }

    private void m4302b() {
        boolean z;
        this.f3234Q = this.f3230M.e.v();
        if (this.f3230M.e.ag() == GraphQLSavedState.SAVED) {
            z = true;
        } else {
            z = false;
        }
        this.f3236S = z;
        this.f3237T = this.f3230M.e.Y();
        this.f3238U = this.f3230M.e.T();
    }

    public final void m4358a(MenuItem menuItem) {
        switch (PageActionType.values()[menuItem.getItemId()]) {
            case CHECKIN:
                m4309c();
                return;
            case LIKE:
                m4279E();
                return;
            case FOLLOW:
                m4315e();
                return;
            case CREATE_PAGE:
                m4326j();
                return;
            case GET_NOTIFICATION:
                m4327k();
                return;
            case CREATE_SHORTCUT:
                m4330l();
                return;
            case MANAGE_ADS:
                m4332m();
                return;
            case MESSAGE:
                m4334n();
                return;
            case SHARE_MESSAGE_SHORTLINK:
                m4336o();
                return;
            case PLACE_CLAIM:
                m4338p();
                return;
            case REPORT_GENERIC:
                m4340q();
                return;
            case REPORT_PLACE:
                m4342r();
                return;
            case REVIEW:
                m4343s();
                return;
            case SAVE:
                m4303b(menuItem);
                return;
            case SHARE:
                m4346t();
                return;
            case SUGGEST_EDIT:
                this.f3221D;
                return;
            case ADMIN_PHOTO:
                m4349v();
                return;
            case ADMIN_POST:
                m4351w();
                return;
            case ADMIN_EDIT_PAGE:
                m4352x();
                return;
            case ADMIN_SETTINGS:
                m4353y();
                return;
            case ADMIN_PROMOTE:
                m4354z();
                return;
            case COPY_LINK:
                m4282H();
                return;
            case ADMIN_ADD_TO_FAVORITES:
                m4275A();
                return;
            case ADMIN_REMOVE_FROM_FAVORITES:
                m4276B();
                return;
            case ADMIN_CREATE_EVENT:
                m4277C();
                return;
            default:
                return;
        }
    }

    public final void m4357a(ParcelUuid parcelUuid) {
        this.f3232O = parcelUuid;
    }

    public final OnDispatchDrawListener m4355a() {
        return new C04321(this);
    }

    private void m4309c() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_CHECKIN, this.f3230M.a);
        ((ComposerLauncher) this.f3247i.get()).a(null, ((DefaultPageSurfaceIntentBuilder) this.f3242d.get()).a(this.f3230M.a, this.f3230M.e.D()).a(), 10100, (Activity) this.f3239a);
    }

    private void m4313d() {
        m4279E();
    }

    private void m4315e() {
        if (this.f3230M.e == null || this.f3230M.e.Y() == GraphQLSubscribeStatus.IS_SUBSCRIBED) {
            m4286a(this.f3240b).e();
            ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_FOLLOW_SWITCHER, this.f3230M.a);
            return;
        }
        m4280F();
    }

    private FollowSwitcherPopupWindow m4286a(View view) {
        FollowSwitcherPopupWindow a = this.f3225H.a(view, Boolean.valueOf(m4321h()), Boolean.valueOf(this.f3230M), Boolean.valueOf(true));
        a.j = new C04332(this);
        a.a(new C04343(this));
        a.a();
        return a;
    }

    private void m4317f() {
        this.f3240b.mo29a(this.f3230M);
    }

    public static void m4319g(PagesActionBarController pagesActionBarController) {
        final GraphQLSubscribeStatus Y = pagesActionBarController.f3230M.e.Y();
        final GraphQLSecondarySubscribeStatus T = pagesActionBarController.f3230M.e.T();
        Futures.a(((PagesFollowActionHelper) pagesActionBarController.f3261w.get()).m4449a(pagesActionBarController.f3230M, pagesActionBarController.f3237T, pagesActionBarController.f3238U), new FutureCallback<Void>(pagesActionBarController) {
            final /* synthetic */ PagesActionBarController f3210c;

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                this.f3210c.f3237T = Y;
                this.f3210c.f3238U = T;
                this.f3210c.m4317f();
            }
        }, (Executor) pagesActionBarController.f3262x.get());
    }

    private boolean m4321h() {
        return GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(this.f3237T);
    }

    public static boolean m4324i(PagesActionBarController pagesActionBarController) {
        return GraphQLSecondarySubscribeStatus.SEE_FIRST.equals(pagesActionBarController.f3238U);
    }

    private void m4326j() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_CREATE_PAGE, this.f3230M.a);
        Intent a = ((DefaultPageSurfaceIntentBuilder) this.f3242d.get()).a();
        if (a == null) {
            ((AbstractFbErrorReporter) this.f3245g.get()).a("page_identity_create_page_fail", "Failed to resolve create page intent!");
        } else {
            ((SecureContextHelper) this.f3248j.get()).a(a, this.f3239a);
        }
    }

    private void m4327k() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_GET_NOTIFICATION, this.f3230M.a);
        if (this.f3230M.e.o()) {
            if (this.f3230M.e.Y() != GraphQLSubscribeStatus.IS_SUBSCRIBED) {
                ((Toaster) this.f3252n.get()).b(new ToastBuilder(2131235410));
                ((PagesAnalytics) this.f3241c.get()).a(ViewEvents.PAGE_EVENT_VIEW_GET_NOTIFICATION_ERROR, this.f3230M.a);
                return;
            }
        } else if (!this.f3230M.e.v()) {
            ((Toaster) this.f3252n.get()).b(new ToastBuilder(2131235409));
            ((PagesAnalytics) this.f3241c.get()).a(ViewEvents.PAGE_EVENT_VIEW_GET_NOTIFICATION_ERROR, this.f3230M.a);
            return;
        }
        Intent a = ((UriIntentMapper) this.f3244f.get()).a(this.f3239a, StringFormatUtil.formatStrLocaleSafe(URL.g, Long.valueOf(this.f3230M.a)));
        if (a == null) {
            ((AbstractFbErrorReporter) this.f3245g.get()).a("page_identity_get_notification_fail", "Failed to resolve get notification intent!");
        } else {
            ((SecureContextHelper) this.f3248j.get()).a(a, this.f3239a);
        }
    }

    private void m4330l() {
        Uri parse;
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_CREATE_SHORTCUT, this.f3230M.a);
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, Long.valueOf(this.f3230M.a));
        if (this.f3230M.e.N() != null) {
            parse = Uri.parse(this.f3230M.e.N().b());
        } else {
            parse = null;
        }
        ((InstallShortcutHelper) this.f3250l.get()).b(formatStrLocaleSafe, this.f3230M.e.D(), parse, IconStyle.ROUNDED);
        HomeIntentHandlerHelper homeIntentHandlerHelper = (HomeIntentHandlerHelper) this.f3249k.get();
        if (!homeIntentHandlerHelper.c() && !homeIntentHandlerHelper.e()) {
            ((Vibrator) this.f3251m.get()).vibrate(50);
            ((Toaster) this.f3252n.get()).b(new ToastBuilder(2131233825));
        }
    }

    private void m4332m() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_MANAGE_ADS, this.f3230M.a);
        Intent intent = null;
        if (this.f3229L.c()) {
            intent = AdsManagerDeepLinkingUtils.a("fb-ama://");
        }
        if (intent == null) {
            ((AbstractFbErrorReporter) this.f3245g.get()).a("admin_page_manage_ads", "Failed to resolve ads manager intent!");
        }
        if (intent == null) {
            intent = ((IFeedIntentBuilder) this.f3253o.get()).b(this.f3239a, FBLinks.m);
        }
        if (intent == null) {
            ((AbstractFbErrorReporter) this.f3245g.get()).a("admin_page_manage_ads", "Failed to resolve ads manager URI!");
        } else {
            ((SecureContextHelper) this.f3248j.get()).a(intent, this.f3239a);
        }
    }

    private void m4334n() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_MESSAGE, this.f3230M.a);
        Intent b = ((IFeedIntentBuilder) this.f3253o.get()).b(this.f3239a, StringFormatUtil.formatStrLocaleSafe(FBLinks.R, Long.valueOf(this.f3230M.a)));
        if (b == null) {
            ((AbstractFbErrorReporter) this.f3245g.get()).a("page_identity_message_fail", "Failed to resolve message compose URI!");
        } else {
            ((SecureContextHelper) this.f3248j.get()).b(b, this.f3239a);
        }
    }

    private void m4336o() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", this.f3230M.e.C());
        intent.setType("text/plain");
        ((SecureContextHelper) this.f3248j.get()).b(Intent.createChooser(intent, this.f3239a.getResources().getString(2131235404)), this.f3239a);
    }

    private void m4338p() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_PLACE_CLAIM, this.f3230M.a);
        FbAndroidPageSurfaceIntentBuilder fbAndroidPageSurfaceIntentBuilder = this.f3226I;
        Intent a = fbAndroidPageSurfaceIntentBuilder.f4134e.a(fbAndroidPageSurfaceIntentBuilder.f4132c, StringFormatUtil.formatStrLocaleSafe(FBLinks.aF, String.valueOf(this.f3230M.a)));
        if (a == null) {
            ((AbstractFbErrorReporter) this.f3245g.get()).a("page_identity_place_claim_fail", "Failed to resolve place claim intent!");
        } else {
            ((SecureContextHelper) this.f3248j.get()).a(a, 10111, (Activity) this.f3239a);
        }
    }

    private void m4340q() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_REPORT, this.f3230M.a);
        ((IFeedIntentBuilder) this.f3253o.get()).a(this.f3239a, StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, StringFormatUtil.formatStrLocaleSafe("/report/id/?fbid=%s", Long.valueOf(this.f3230M.a))));
    }

    private void m4342r() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_REPORT, this.f3230M.a);
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this.f3239a);
        PopoverMenu c = figPopoverMenuWindow.c();
        c.a(0, 0, this.f3239a.getResources().getString(2131235389));
        c.a(1, 1, this.f3239a.getResources().getString(2131235390));
        c.a(2, 2, this.f3239a.getResources().getString(2131235397));
        c.a(3, 3, this.f3239a.getResources().getString(2131235392));
        c.a(new C04365(this));
        figPopoverMenuWindow.a(this.f3240b);
    }

    private void m4289a(final ReportFlags reportFlags) {
        ((TasksManager) this.f3255q.get()).a(PagesAsyncTaskType.REPORT_PLACE, new Callable<ListenableFuture<OperationResult>>(this) {
            final /* synthetic */ PagesActionBarController f3213b;

            public Object call() {
                return ((PagesCommonActionBarDataMutator) this.f3213b.f3257s.get()).m1995a(reportFlags, this.f3213b.f3230M.a);
            }
        }, new C04387(this));
    }

    private void m4343s() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_REVIEW_IN_ACTION_BAR, this.f3230M.a);
        final ProgressDialog a = ProgressDialog.a(this.f3239a, null, this.f3239a.getResources().getString(2131235352), true, false);
        ((PageReviewLoader) this.f3254p.get()).a(String.valueOf(this.f3230M.a), new LoadSingleReviewCallback(this) {
            final /* synthetic */ PagesActionBarController f3216b;

            public final void m4274a(ReviewBasicFields reviewBasicFields) {
                a.dismiss();
                if (reviewBasicFields == null) {
                    ((ComposerLauncher) this.f3216b.f3247i.get()).a(null, ((DefaultPageSurfaceIntentBuilder) this.f3216b.f3242d.get()).a(this.f3216b.f3230M.e(), this.f3216b.f3230M.g().D(), null, CurationMechanism.ACTIONBAR_BUTTON, 0).a(), 10107, (Activity) this.f3216b.f3239a);
                } else {
                    ((ComposerLauncher) this.f3216b.f3247i.get()).a(null, ((DefaultPageSurfaceIntentBuilder) this.f3216b.f3242d.get()).a(this.f3216b.f3230M.g().D(), ReviewsGraphQLHelper.a(reviewBasicFields), ReviewsGraphQLHelper.b(reviewBasicFields), this.f3216b.f3230M.e(), ReviewsGraphQLHelper.c(reviewBasicFields), CurationMechanism.ACTIONBAR_BUTTON).a(), 10108, (Activity) this.f3216b.f3239a);
                }
            }

            public final void m4273a() {
                a.dismiss();
                ((Toaster) this.f3216b.f3252n.get()).b(new ToastBuilder(2131235356));
            }
        });
    }

    private void m4303b(MenuItem menuItem) {
        if (m4281G() == null) {
            return;
        }
        if (this.f3236S) {
            m4314d(menuItem);
        } else {
            m4310c(menuItem);
        }
    }

    private void m4346t() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_SHARE_PAGE, this.f3230M.a);
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_SHARE_PAGE_AS_POST, this.f3230M.a);
        ComposerLauncher composerLauncher = (ComposerLauncher) this.f3247i.get();
        this.f3260v.get();
        composerLauncher.a(null, ComposerConfigurationFactory.a(ComposerSourceType.PAGE, this.f3230M.a).setIsFireAndForget(true).a(), 10101, (Activity) this.f3239a);
    }

    public static void m4348u(PagesActionBarController pagesActionBarController) {
        ((PagesAnalytics) pagesActionBarController.f3241c.get()).a(TapEvent.EVENT_TAPPED_SUGGEST_EDIT, pagesActionBarController.f3230M.a);
        String str = "";
        if (pagesActionBarController.f3230M.e.N() != null) {
            str = pagesActionBarController.f3230M.e.N().b();
        }
        Intent a = ((PlaceSuggestionsIntentBuilder) pagesActionBarController.f3243e.get()).a(pagesActionBarController.f3230M.a, pagesActionBarController.f3230M.e.D(), str, CrowdsourcingSource.FINCH_EDIT, CrowdEntryPoint.PAGE_ACTION_MENU_SUGGEST_EDITS);
        if (a == null) {
            ((AbstractFbErrorReporter) pagesActionBarController.f3245g.get()).a("page_identity_suggest_edit_fail", "Failed to resolve suggest edits intent!");
        } else {
            ((SecureContextHelper) pagesActionBarController.f3248j.get()).a(a, 10102, (Activity) pagesActionBarController.f3239a);
        }
    }

    private void m4349v() {
        m4296a(new C04409(this));
    }

    private void m4287a(ViewerContext viewerContext) {
        ((PagesAnalytics) this.f3241c.get()).b(AdminActionBarEvent.EVENT_ADMIN_SHARE_PHOTO, this.f3230M.a);
        ((ComposerIntentLauncher) this.f3246h.get()).a(((DefaultPageSurfaceIntentBuilder) this.f3242d.get()).b(this.f3230M.a, this.f3230M.e.D(), this.f3230M.i(), viewerContext), 1756, (Activity) this.f3239a);
    }

    private void m4351w() {
        m4296a(new Predicate<ViewerContext>(this) {
            final /* synthetic */ PagesActionBarController f3182a;

            {
                this.f3182a = r1;
            }

            public boolean apply(Object obj) {
                this.f3182a.m4304b((ViewerContext) obj);
                return true;
            }
        });
    }

    private void m4304b(ViewerContext viewerContext) {
        ((PagesAnalytics) this.f3241c.get()).b(AdminActionBarEvent.EVENT_ADMIN_WRITE_POST, this.f3230M.a);
        ((ComposerLauncher) this.f3247i.get()).a(null, ((DefaultPageSurfaceIntentBuilder) this.f3242d.get()).a(this.f3230M.a, this.f3230M.e.D(), this.f3230M.i(), viewerContext).a(), 1756, (Activity) this.f3239a);
    }

    private void m4352x() {
        if (this.f3230M.e.K() == GraphQLPlaceType.RESIDENCE) {
            ((SecureContextHelper) this.f3248j.get()).a(((DefaultPageSurfaceIntentBuilder) this.f3242d.get()).b(this.f3230M.a, this.f3230M.e.D()), 10112, (Activity) this.f3239a);
            return;
        }
        ((PagesAnalytics) this.f3241c.get()).b(AdminActionBarEvent.EVENT_ADMIN_EDIT_PAGE, this.f3230M.a);
        ((SecureContextHelper) this.f3248j.get()).a(((UriIntentMapper) this.f3244f.get()).a(this.f3239a, StringFormatUtil.formatStrLocaleSafe(this.f3231N ? URL.d : URL.c, Long.valueOf(this.f3230M.a))), 10114, (Activity) this.f3239a);
    }

    private void m4353y() {
        ((PagesAnalytics) this.f3241c.get()).b(AdminActionBarEvent.EVENT_ADMIN_SETTINGS, this.f3230M.a);
        ((SecureContextHelper) this.f3248j.get()).a(((UriIntentMapper) this.f3244f.get()).a(this.f3239a, StringFormatUtil.formatStrLocaleSafe(URL.e, Long.valueOf(this.f3230M.a))), this.f3239a);
    }

    private void m4354z() {
        ((PagesAnalytics) this.f3241c.get()).b(AdminActionBarEvent.EVENT_ADMIN_PROMOTE, this.f3230M.a);
        Intent a = ((UriIntentMapper) this.f3244f.get()).a(this.f3239a, StringFormatUtil.formatStrLocaleSafe(URL.C, Long.valueOf(this.f3230M.a)));
        a.putExtra("titlebar_with_modal_done", true);
        ((SecureContextHelper) this.f3248j.get()).a(a, this.f3239a);
    }

    private void m4275A() {
        boolean z;
        ((PagesAnalytics) this.f3241c.get()).a(AdminActionBarEvent.EVENT_ADMIN_ADD_TO_FAVORITES, this.f3230M.a);
        BookmarkAddToFavoritesInputData bookmarkAddToFavoritesInputData = new BookmarkAddToFavoritesInputData();
        bookmarkAddToFavoritesInputData.a(((LoggedInUserSessionManager) this.f3264z.get()).c().a);
        bookmarkAddToFavoritesInputData.b(String.valueOf(this.f3230M.a));
        bookmarkAddToFavoritesInputData.a(Source.WILDE_PROFILE_MORE);
        MutationRequest a = GraphQLRequest.a((FBBookmarkAddToFavoritesMutationString) new FBBookmarkAddToFavoritesMutationString().a("input", bookmarkAddToFavoritesInputData));
        a.e = ((ViewerContextManager) this.f3220C.get()).a();
        ListenableFuture a2 = ((GraphQLQueryExecutor) this.f3263y.get()).a(a);
        if (this.f3230M.e == null || this.f3230M.e.l() == null) {
            z = false;
        } else {
            z = this.f3230M.e.l().j();
        }
        m4297a(true);
        Futures.a(a2, new FutureCallback<GraphQLResult<FBBookmarkAddToFavoritesMutationModel>>(this) {
            final /* synthetic */ PagesActionBarController f3184b;

            public void onSuccess(@Nullable Object obj) {
                ((BookmarkManager) this.f3184b.f3218A.get()).a();
                this.f3184b.m4290a(NetworkSuccessEvent.EVENT_PAGE_ADD_TO_FAVORITES_SUCCESS);
                ((Toaster) this.f3184b.f3252n.get()).b(new ToastBuilder(2131235117));
            }

            public void onFailure(Throwable th) {
                this.f3184b.m4290a(NetworkFailureEvent.EVENT_PAGE_ADD_TO_FAVORITES_ERROR);
                this.f3184b.m4297a(z);
            }
        }, (Executor) this.f3262x.get());
    }

    private void m4276B() {
        boolean z;
        ((PagesAnalytics) this.f3241c.get()).a(AdminActionBarEvent.EVENT_ADMIN_REMOVE_FROM_FAVORTIES, this.f3230M.a);
        BookmarkRemoveFromFavoritesInputData bookmarkRemoveFromFavoritesInputData = new BookmarkRemoveFromFavoritesInputData();
        bookmarkRemoveFromFavoritesInputData.a(((LoggedInUserSessionManager) this.f3264z.get()).c().a);
        bookmarkRemoveFromFavoritesInputData.b(String.valueOf(this.f3230M.a));
        bookmarkRemoveFromFavoritesInputData.a(BookmarkRemoveFromFavoritesInputData.Source.WILDE_PROFILE_MORE);
        MutationRequest a = GraphQLRequest.a((FBBookmarkRemoveFromFavoritesMutationString) new FBBookmarkRemoveFromFavoritesMutationString().a("input", bookmarkRemoveFromFavoritesInputData));
        a.e = ((ViewerContextManager) this.f3220C.get()).a();
        ListenableFuture a2 = ((GraphQLQueryExecutor) this.f3263y.get()).a(a);
        if (this.f3230M.e == null || this.f3230M.e.l() == null) {
            z = true;
        } else {
            z = this.f3230M.e.l().j();
        }
        m4297a(false);
        Futures.a(a2, new FutureCallback<GraphQLResult<FBBookmarkRemoveFromFavoritesMutationModel>>(this) {
            final /* synthetic */ PagesActionBarController f3186b;

            public void onSuccess(@Nullable Object obj) {
                ((BookmarkManager) this.f3186b.f3218A.get()).a();
                this.f3186b.m4290a(NetworkSuccessEvent.EVENT_PAGE_REMOVE_FROM_FAVORITES_SUCCESS);
                ((Toaster) this.f3186b.f3252n.get()).b(new ToastBuilder(2131235118));
            }

            public void onFailure(Throwable th) {
                this.f3186b.m4290a(NetworkFailureEvent.EVENT_PAGE_REMOVE_FROM_FAVORITES_ERROR);
                this.f3186b.m4297a(z);
            }
        }, (Executor) this.f3262x.get());
    }

    private void m4277C() {
        ((PagesAnalytics) this.f3241c.get()).b(AdminActionBarEvent.EVENT_ADMIN_ADD_EVENT, this.f3230M.a);
        if (this.f3228K == Product.PAA) {
            m4296a(new Predicate<ViewerContext>(this) {
                final /* synthetic */ PagesActionBarController f3187a;

                {
                    this.f3187a = r1;
                }

                public boolean apply(@Nullable Object obj) {
                    ViewerContext viewerContext = (ViewerContext) obj;
                    DefaultPageSurfaceIntentBuilder defaultPageSurfaceIntentBuilder = (DefaultPageSurfaceIntentBuilder) this.f3187a.f3242d.get();
                    String.valueOf(this.f3187a.f3230M.a);
                    defaultPageSurfaceIntentBuilder.b();
                    return true;
                }
            });
            return;
        }
        ((SecureContextHelper) this.f3248j.get()).a(((DefaultPageSurfaceIntentBuilder) this.f3242d.get()).a(this.f3230M.a, "pages_identity".toString(), ActionMechanism.PAGES_ACTION_BAR), this.f3239a);
    }

    private void m4296a(final Predicate<ViewerContext> predicate) {
        final DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(this.f3239a, 2131235433);
        ((ViewerContextUtil) this.f3219B.get()).a(String.valueOf(this.f3230M.a), new ViewerContextWaiter(this) {
            final /* synthetic */ PagesActionBarController f3190c;

            public final void m4258a(ViewerContext viewerContext) {
                predicate.apply(viewerContext);
            }

            public final void m4257a() {
                if (this.f3190c.f3239a != null) {
                    dialogBasedProgressIndicator.a();
                }
            }

            public final void m4260b(ViewerContext viewerContext) {
                if (this.f3190c.f3239a != null) {
                    dialogBasedProgressIndicator.b();
                    predicate.apply(viewerContext);
                }
            }

            public final void m4259b() {
                if (this.f3190c.f3239a != null) {
                    dialogBasedProgressIndicator.b();
                    ((Toaster) this.f3190c.f3252n.get()).a(new ToastBuilder(this.f3190c.f3239a.getResources().getString(2131235536)));
                }
            }
        }, (Executor) this.f3262x.get());
    }

    private void m4290a(PageAnalyticsEvent pageAnalyticsEvent) {
        ((PagesAnalytics) this.f3241c.get()).a(pageAnalyticsEvent, this.f3230M.a);
    }

    private void m4278D() {
        if (this.f3224G.d()) {
            this.f3235R = true;
            this.f3227J.a(new NeedToShowSuggestedPagesEvent(this.f3232O));
        }
    }

    private void m4279E() {
        GraphQLSubscribeStatus graphQLSubscribeStatus;
        this.f3234Q = !this.f3234Q;
        m4290a(this.f3234Q ? TapEvent.EVENT_TAPPED_LIKE : TapEvent.EVENT_TAPPED_UNLIKE);
        if (this.f3234Q && !this.f3235R) {
            m4278D();
        }
        GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.REGULAR_FOLLOW;
        if (this.f3230M.e != null && this.f3230M.e.Y() == GraphQLSubscribeStatus.IS_SUBSCRIBED) {
            graphQLSecondarySubscribeStatus = this.f3230M.e.T();
        }
        PageHeaderData pageHeaderData = this.f3230M;
        Builder a = Builder.a(this.f3230M.e);
        a.n = this.f3234Q;
        Builder builder = a;
        if (this.f3234Q) {
            graphQLSubscribeStatus = GraphQLSubscribeStatus.IS_SUBSCRIBED;
        } else {
            graphQLSubscribeStatus = GraphQLSubscribeStatus.CAN_SUBSCRIBE;
        }
        builder.Q = graphQLSubscribeStatus;
        a = builder;
        if (!this.f3234Q) {
            graphQLSecondarySubscribeStatus = GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        a.L = graphQLSecondarySubscribeStatus;
        pageHeaderData.a(a.a());
        this.f3240b.mo29a(this.f3230M);
        graphQLSubscribeStatus = this.f3230M.e.Y();
        final GraphQLSecondarySubscribeStatus T = this.f3230M.e.T();
        ((TasksManager) this.f3255q.get()).a(PagesAsyncTaskType.LIKE, new Callable<ListenableFuture>(this) {
            final /* synthetic */ PagesActionBarController f3191a;

            {
                this.f3191a = r1;
            }

            public Object call() {
                ModernFeedbackGraphQLGenerator modernFeedbackGraphQLGenerator = (ModernFeedbackGraphQLGenerator) this.f3191a.f3221D.get();
                TogglePageLikeParams.Builder a = TogglePageLikeParams.a();
                a.c = ((GraphQLActorCacheImpl) this.f3191a.f3223F.get()).a();
                TogglePageLikeParams.Builder builder = a;
                builder.b = this.f3191a.f3234Q;
                builder = builder;
                builder.a = String.valueOf(this.f3191a.f3230M.a);
                builder = builder;
                builder.e = "page_profile";
                builder = builder;
                FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
                builder2.c = "pages_identity";
                builder.d = builder2.a();
                return modernFeedbackGraphQLGenerator.a(builder.a());
            }
        }, new OperationResultFutureCallback(this) {
            final /* synthetic */ PagesActionBarController f3194c;

            protected final void m4261a(ServiceException serviceException) {
                if (serviceException.errorCode != ErrorCode.CANCELLED) {
                    boolean z;
                    this.f3194c.m4290a(this.f3194c.f3234Q ? NetworkFailureEvent.EVENT_LIKE_ERROR : NetworkFailureEvent.EVENT_UNLIKE_ERROR);
                    PagesActionBarController pagesActionBarController = this.f3194c;
                    if (this.f3194c.f3234Q) {
                        z = false;
                    } else {
                        z = true;
                    }
                    pagesActionBarController.f3234Q = z;
                    PageHeaderData pageHeaderData = this.f3194c.f3230M;
                    Builder a = Builder.a(this.f3194c.f3230M.e);
                    a.n = this.f3194c.f3234Q;
                    a = a;
                    a.Q = graphQLSubscribeStatus;
                    a = a;
                    a.L = T;
                    pageHeaderData.a(a.a());
                    this.f3194c.m4317f();
                    this.f3194c.m4288a(serviceException);
                }
            }

            protected final void m4262a(Object obj) {
                this.f3194c.m4290a(this.f3194c.f3234Q ? NetworkSuccessEvent.EVENT_LIKE_SUCCESS : NetworkSuccessEvent.EVENT_UNLIKE_SUCCESS);
            }
        });
    }

    private void m4297a(boolean z) {
        if (this.f3230M != null && this.f3230M.e != null && this.f3230M.e.l() != null) {
            PageHeaderData pageHeaderData = this.f3230M;
            Builder a = Builder.a(this.f3230M.e);
            PageAdminInfoBaseDataModel l = this.f3230M.e.l();
            PageAdminInfoBaseDataModel.Builder builder = new PageAdminInfoBaseDataModel.Builder();
            builder.a = l.a();
            builder.b = l.j();
            builder.c = l.k();
            PageAdminInfoBaseDataModel.Builder builder2 = builder;
            builder2.b = z;
            a.d = builder2.a();
            pageHeaderData.a(a.a());
            this.f3240b.mo29a(this.f3230M);
        }
    }

    private void m4288a(ServiceException serviceException) {
        int i;
        String str;
        if (this.f3234Q) {
            i = 2131235440;
            str = "page_identity_unlike_fail";
        } else {
            i = 2131235439;
            str = "page_identity_like_fail";
        }
        ((Toaster) this.f3252n.get()).b(new ToastBuilder(i));
        ((AbstractFbErrorReporter) this.f3245g.get()).a(str, serviceException);
    }

    private void m4280F() {
        GraphQLSubscribeStatus Y = this.f3230M.e.Y();
        m4290a(!GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(Y) ? TapEvent.EVENT_TAPPED_FOLLOW : TapEvent.EVENT_TAPPED_UNFOLLOW);
        SettableFuture a = ((PagesFollowActionHelper) this.f3261w.get()).m4449a(this.f3230M, !GraphQLSubscribeStatus.IS_SUBSCRIBED.equals(Y) ? GraphQLSubscribeStatus.IS_SUBSCRIBED : GraphQLSubscribeStatus.CAN_SUBSCRIBE, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        this.f3240b.mo29a(this.f3230M);
        Futures.a(a, new FutureCallback<Void>(this) {
            final /* synthetic */ PagesActionBarController f3195a;

            {
                this.f3195a = r1;
            }

            public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
            }

            public void onFailure(Throwable th) {
                if (!(th instanceof CancellationException)) {
                    this.f3195a.m4317f();
                }
            }
        }, (Executor) this.f3262x.get());
    }

    private void m4310c(final MenuItem menuItem) {
        PageAnalyticsEvent pageAnalyticsEvent;
        boolean z = true;
        final NetworkSuccessEvent b = m4300b(true);
        final NetworkFailureEvent c = m4307c(true);
        PageHeaderData pageHeaderData = this.f3230M;
        Builder a = Builder.a(this.f3230M.e);
        a.Y = GraphQLSavedState.SAVED;
        pageHeaderData.a(a.a());
        if (this.f3236S) {
            z = false;
        }
        this.f3236S = z;
        menuItem.setChecked(this.f3236S);
        ((SaveButtonUtils) this.f3259u.get()).a(this.f3239a);
        if (this.f3230M.e.w()) {
            pageAnalyticsEvent = TapEvent.EVENT_TAPPED_SAVE_PLACE;
        } else {
            pageAnalyticsEvent = TapEvent.PAGE_EVENT_TAPPED_SAVE_MEDIA_PAGE;
        }
        ((PagesAnalytics) this.f3241c.get()).a(pageAnalyticsEvent, this.f3230M.a);
        if (m4281G() != null) {
            ((TasksManager) this.f3255q.get()).a(PagesAsyncTaskType.SAVE, ((PagesCommonActionBarDataMutator) this.f3257s.get()).m1996a(Long.toString(this.f3230M.a), m4281G().b()), new OperationResultFutureCallback(this) {
                final /* synthetic */ PagesActionBarController f3199d;

                protected final void m4264a(Object obj) {
                    ((PagesAnalytics) this.f3199d.f3241c.get()).a(b, this.f3199d.f3230M.a);
                }

                protected final void m4263a(ServiceException serviceException) {
                    boolean z;
                    ((AbstractFbErrorReporter) this.f3199d.f3245g.get()).a("page_identity_save_fail", serviceException);
                    ((PagesAnalytics) this.f3199d.f3241c.get()).a(c, this.f3199d.f3230M.a);
                    ((Toaster) this.f3199d.f3252n.get()).b(new ToastBuilder(2131235380));
                    PageHeaderData pageHeaderData = this.f3199d.f3230M;
                    Builder a = Builder.a(this.f3199d.f3230M.e);
                    a.Y = GraphQLSavedState.NOT_SAVED;
                    pageHeaderData.a(a.a());
                    PagesActionBarController pagesActionBarController = this.f3199d;
                    if (this.f3199d.f3236S) {
                        z = false;
                    } else {
                        z = true;
                    }
                    pagesActionBarController.f3236S = z;
                    menuItem.setChecked(this.f3199d.f3236S);
                }
            });
        }
    }

    private void m4314d(final MenuItem menuItem) {
        PageAnalyticsEvent pageAnalyticsEvent;
        PageHeaderData pageHeaderData = this.f3230M;
        Builder a = Builder.a(this.f3230M.e);
        a.Y = GraphQLSavedState.NOT_SAVED;
        pageHeaderData.a(a.a());
        this.f3236S = !this.f3236S;
        menuItem.setChecked(this.f3236S);
        ((SaveNuxBubbleDelegate) this.f3258t.get()).b();
        if (this.f3230M.e.w()) {
            pageAnalyticsEvent = TapEvent.EVENT_TAPPED_UNSAVE_PLACE;
        } else {
            pageAnalyticsEvent = TapEvent.PAGE_EVENT_TAPPED_UNSAVE_MEDIA_PAGE;
        }
        ((PagesAnalytics) this.f3241c.get()).a(pageAnalyticsEvent, this.f3230M.a);
        final NetworkSuccessEvent b = m4300b(false);
        final NetworkFailureEvent c = m4307c(false);
        if (m4281G() != null) {
            ((TasksManager) this.f3255q.get()).a(PagesAsyncTaskType.UNSAVE, ((PagesCommonActionBarDataMutator) this.f3257s.get()).m1997b(Long.toString(this.f3230M.a), m4281G().b()), new OperationResultFutureCallback(this) {
                final /* synthetic */ PagesActionBarController f3203d;

                protected final void m4266a(Object obj) {
                    ((PagesAnalytics) this.f3203d.f3241c.get()).a(b, this.f3203d.f3230M.a);
                }

                protected final void m4265a(ServiceException serviceException) {
                    boolean z;
                    ((AbstractFbErrorReporter) this.f3203d.f3245g.get()).a("page_identity_unsave_fail", serviceException);
                    ((PagesAnalytics) this.f3203d.f3241c.get()).a(c, this.f3203d.f3230M.a);
                    ((Toaster) this.f3203d.f3252n.get()).b(new ToastBuilder(2131235381));
                    PageHeaderData pageHeaderData = this.f3203d.f3230M;
                    Builder a = Builder.a(this.f3203d.f3230M.e);
                    a.Y = GraphQLSavedState.SAVED;
                    pageHeaderData.a(a.a());
                    PagesActionBarController pagesActionBarController = this.f3203d;
                    if (this.f3203d.f3236S) {
                        z = false;
                    } else {
                        z = true;
                    }
                    pagesActionBarController.f3236S = z;
                    menuItem.setChecked(this.f3203d.f3236S);
                }
            });
        }
    }

    private NetworkSuccessEvent m4300b(boolean z) {
        if (!z) {
            return this.f3230M.e.w() ? NetworkSuccessEvent.EVENT_PLACE_UNSAVE_SUCCESS : NetworkSuccessEvent.EVENT_PAGE_UNSAVE_SUCCESS;
        } else {
            if (this.f3230M.e.w()) {
                return NetworkSuccessEvent.EVENT_PLACE_SAVE_SUCCESS;
            }
            return NetworkSuccessEvent.EVENT_PAGE_SAVE_SUCCESS;
        }
    }

    private NetworkFailureEvent m4307c(boolean z) {
        if (!z) {
            return this.f3230M.e.w() ? NetworkFailureEvent.EVENT_PLACE_UNSAVE_ERROR : NetworkFailureEvent.EVENT_PAGE_UNSAVE_ERROR;
        } else {
            if (this.f3230M.e.w()) {
                return NetworkFailureEvent.EVENT_PLACE_SAVE_ERROR;
            }
            return NetworkFailureEvent.EVENT_PAGE_SAVE_ERROR;
        }
    }

    private SavableTimelineAppCollectionExtraFieldsModel m4281G() {
        return this.f3230M.e.S();
    }

    private void m4282H() {
        ((PagesAnalytics) this.f3241c.get()).a(TapEvent.EVENT_TAPPED_COPY_LINK, this.f3230M.a);
        ClipboardUtil.a(this.f3239a, this.f3230M.e.ab());
        ((Toaster) this.f3252n.get()).b(new ToastBuilder(2131235454));
    }
}
