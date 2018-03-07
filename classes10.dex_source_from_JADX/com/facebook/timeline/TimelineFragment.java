package com.facebook.timeline;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.IRefreshableFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.perftest.PerfTestConfig;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.debug.dumpsys.DumpsysDumpable;
import com.facebook.debug.dumpsys.DumpsysDumper;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.feed.ui.GenericNotificationBanner;
import com.facebook.feed.ui.GenericNotificationBanner.NotificationBannerType;
import com.facebook.feed.util.FeedNetworkConnectivityReceiver;
import com.facebook.feed.util.composer.ComposerActivityReceiver;
import com.facebook.feed.util.composer.OfflinePostLoader;
import com.facebook.feed.util.composer.OptimisticPostStoryBuilder;
import com.facebook.feed.viewstate.UnseenStoryManager;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEventSubscriber;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.graphql.calls.UserMarkProfileVisitedInputData;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.event.LifeEventUploadEvent.LifeEventUploadEventSubscriber;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.profile.api.RelationshipType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.quickpromotion.ui.QuickPromotionFragment.QuickPromotionFragmentHost;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.api.GraphSearchQueryProvider;
import com.facebook.search.interfaces.GraphSearchTitleSupport;
import com.facebook.search.titlebar.GraphSearchIntentLauncher;
import com.facebook.tablet.abtest.SideshowCompatibleContainer;
import com.facebook.timeline.ProfileNuxModalRunnableHelper.C14991;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.actionbar.TimelineActionBarController;
import com.facebook.timeline.actionbar.TimelineActionBarControllerImpl;
import com.facebook.timeline.actionbar.TimelineActionBarControllerImplProvider;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.contextual.TimelineContextualInfoController;
import com.facebook.timeline.contextual.TimelineContextualInfoControllerImpl;
import com.facebook.timeline.contextual.TimelineContextualInfoControllerImplProvider;
import com.facebook.timeline.contextual.TimelineContextualInfoData;
import com.facebook.timeline.contextual.TimelineContextualInfoDataFactory;
import com.facebook.timeline.controllers.TimelineContactCacheController;
import com.facebook.timeline.controllers.TimelineContactCacheController.Listener;
import com.facebook.timeline.controllers.TimelineVisitedEventController;
import com.facebook.timeline.controllers.TimelineVisitedEventController.C15241;
import com.facebook.timeline.controllers.TimelineVisitedEventControllerProvider;
import com.facebook.timeline.cursor.TimelineAllSectionsCursor;
import com.facebook.timeline.cursor.TimelineCursorHelper;
import com.facebook.timeline.data.NeedsFragmentCleanup;
import com.facebook.timeline.data.TimelineHeaderRenderState;
import com.facebook.timeline.datafetcher.FetchContactCacheTask;
import com.facebook.timeline.datafetcher.HeaderFetchFutures;
import com.facebook.timeline.datafetcher.TimelineDataFetcher;
import com.facebook.timeline.datafetcher.TimelineDataFetcherProvider;
import com.facebook.timeline.datafetcher.TimelineEarlyFetchFutures;
import com.facebook.timeline.datafetcher.TimelineEarlyFetcher;
import com.facebook.timeline.datafetcher.TimelineFetchIdentifier;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.datafetcher.TimelineVisitedController;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.delegate.TimelineFragmentErrorBannerDelegate;
import com.facebook.timeline.delegate.TimelineFragmentHeaderFetchCallbackDelegate;
import com.facebook.timeline.delegate.TimelineFragmentScrollDelegate;
import com.facebook.timeline.delegate.TimelineFragmentScrollDelegateProvider;
import com.facebook.timeline.environment.TimelineEnvironmentGenerated;
import com.facebook.timeline.environment.TimelineEnvironmentGeneratedProvider;
import com.facebook.timeline.event.HeaderDataEvents.AdapterDataChangedEventSubscriber;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.event.TimelineVisitedEvent;
import com.facebook.timeline.event.TimelineVisitedEventBus;
import com.facebook.timeline.event.TimelineVisitedEventSubscriber;
import com.facebook.timeline.feed.events.ProtilesActionEventProcessor;
import com.facebook.timeline.feed.events.ProtilesActionEventProcessor.C16151;
import com.facebook.timeline.feed.events.ProtilesActionEventProcessorProvider;
import com.facebook.timeline.header.TimelineHeaderDataInitializer;
import com.facebook.timeline.header.TimelineHeaderDataLogger;
import com.facebook.timeline.header.TimelineHeaderDataLoggerProvider;
import com.facebook.timeline.header.TimelineHeaderMultiAdapter;
import com.facebook.timeline.header.TimelineHeaderPerfController;
import com.facebook.timeline.header.TimelineHeaderPerfControllerImplProvider;
import com.facebook.timeline.header.TimelineHeaderUpdateDispatcher;
import com.facebook.timeline.header.TimelineIntroCardAdapter.Part;
import com.facebook.timeline.header.TimelineLoggingViewportListener;
import com.facebook.timeline.header.TimelineLoggingViewportListenerProvider;
import com.facebook.timeline.header.controllers.TimelineCoverPhotoController;
import com.facebook.timeline.header.controllers.TimelineCoverPhotoControllerImpl;
import com.facebook.timeline.header.controllers.TimelineCoverPhotoControllerImplProvider;
import com.facebook.timeline.header.controllers.TimelineProfileImageController;
import com.facebook.timeline.header.controllers.TimelineProfileImageControllerImplProvider;
import com.facebook.timeline.header.data.TimelineHeaderData.GetNotifiedState;
import com.facebook.timeline.header.data.TimelineHeaderData.InitializeState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.editphotohelper.ProfilePictureActionFlowLauncherProvider;
import com.facebook.timeline.header.editphotohelper.TimelineEditPhotoHelper;
import com.facebook.timeline.header.editphotohelper.TimelineEditPhotoHelperProvider;
import com.facebook.timeline.header.menus.TimelineFriendingClient;
import com.facebook.timeline.header.menus.TimelineFriendingClientProvider;
import com.facebook.timeline.header.menus.TimelineFriendingController;
import com.facebook.timeline.header.menus.TimelineFriendingController.C17157;
import com.facebook.timeline.header.menus.TimelineFriendingControllerProvider;
import com.facebook.timeline.header.util.TimelineHeaderViewHelper;
import com.facebook.timeline.intent.ModelBundleGraphQLInterfaces.ModelBundleProfileGraphQL;
import com.facebook.timeline.listview.TimelineAdapter;
import com.facebook.timeline.listview.TimelineAdapterFactory;
import com.facebook.timeline.listview.TimelineScrollingViewProxyFactory;
import com.facebook.timeline.logging.CoverPhotoSource;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.model.TimelineStorySnapshot;
import com.facebook.timeline.navtiles.TimelineNavtileController;
import com.facebook.timeline.navtiles.TimelineNavtileControllerImplProvider;
import com.facebook.timeline.prefetch.TimelineMultiRowImagePrefetcherFactory;
import com.facebook.timeline.prefs.TimelineConfig;
import com.facebook.timeline.prefs.TimelinePreferencesKeys;
import com.facebook.timeline.profilemedia.optimistic.OptimisticProfileMediaStore;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams.QueryType;
import com.facebook.timeline.protiles.events.ProtilesActionEvent;
import com.facebook.timeline.protiles.model.ProtilesData;
import com.facebook.timeline.protiles.model.TimelinePromptData;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderUserFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.UserTimelineSelfQueryFieldsModel;
import com.facebook.timeline.protocol.ResultSource;
import com.facebook.timeline.protocol.TimelineVisitedMutation.TimelineVisitedMutationString;
import com.facebook.timeline.publisher.PublisherData;
import com.facebook.timeline.publisher.TimelinePublishController;
import com.facebook.timeline.publisher.TimelinePublishControllerImplProvider;
import com.facebook.timeline.qp.TimelineQpController;
import com.facebook.timeline.qp.TimelineQpControllerProvider;
import com.facebook.timeline.rows.TimelineFeedType;
import com.facebook.timeline.search.SearchAwarenessProfilePillController;
import com.facebook.timeline.search.SearchAwarenessProfilePillControllerProvider;
import com.facebook.timeline.search.TimelineGraphSearchQueryFactory;
import com.facebook.timeline.search.TimelineGraphSearchQueryFactoryProvider;
import com.facebook.timeline.searchbootstrap.TimelineBootstrapEntitiesManager;
import com.facebook.timeline.service.ProfileLoaderService;
import com.facebook.timeline.stories.TimelineStoriesController;
import com.facebook.timeline.stories.TimelineStoriesControllerProvider;
import com.facebook.timeline.survey.TimelineStructuredSurveyController;
import com.facebook.timeline.survey.TimelineStructuredSurveyController.C17861;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.ui.TimelineErrorViewBinder;
import com.facebook.timeline.ui.TimelineFragmentView;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.timeline.units.model.TimelineSectionData;
import com.facebook.timeline.units.model.TimelineSectionLoadState;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.IsPreventOnScrollEnabled;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.titlebar.FadingContentFragmentController;
import com.facebook.widget.titlebar.FadingContentView;
import com.facebook.widget.titlebar.FadingFbTitleBar;
import com.facebook.widget.titlebar.FadingTitlebarContent;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Provider;

@UriMatchPatterns(fragment = ContentFragmentType.NATIVE_TIMELINE_FRAGMENT)
@GraphSearchTitleSupport
/* compiled from: groups_seeds_composer_create_poll */
public class TimelineFragment extends BaseTimelineFragment<TimelineAdapter> implements AnalyticsFragmentWithExtraData, IRefreshableFragment, DumpsysDumpable, DialtoneStateChangedListener, QuickPromotionFragmentHost, GraphSearchQueryProvider, SideshowCompatibleContainer, ProfileController, Listener {
    public static final CallerContext br = CallerContext.a(TimelineFragment.class, "timeline");
    private static int cn = 0;
    @Inject
    TimelineVisitedEventControllerProvider aA;
    @Inject
    Provider<TimelineContactCacheController> aB;
    @Inject
    TimelineHeaderEventBus aC;
    @Inject
    FriendingEventBus aD;
    @Inject
    MediaUploadEventBus aE;
    @Inject
    TimelineVisitedEventBus aF;
    @Inject
    TimelineHeaderRenderState aG;
    @Inject
    TimelineAllSectionsData aH;
    @Inject
    TimelineAllSectionsCursor aI;
    @Inject
    public PublisherData aJ;
    @Inject
    @LoggedInUserId
    public String aK;
    @Inject
    TimelineAnalyticsLogger aL;
    @Inject
    public Provider<TimelineFragmentHeaderFetchCallbackDelegate> aM;
    @Inject
    TimelineFragmentScrollDelegateProvider aN;
    @Inject
    UnseenStoryManager aO;
    @Inject
    TimelineActivityResultHandlerProvider aP;
    @Inject
    SearchAwarenessProfilePillControllerProvider aQ;
    @Inject
    public GraphSearchIntentLauncher aR;
    @Inject
    public FbTitleBarSupplier aS;
    @Inject
    TimelineAdapterFactory aT;
    @Inject
    TimelineScrollingViewProxyFactory aU;
    @Inject
    Provider<FbNetworkManager> aV;
    @Inject
    Provider<ReactionSessionManager> aW;
    @Inject
    TimelineLoggingViewportListenerProvider aX;
    @Inject
    TimelineHeaderDataInitializer aY;
    @Inject
    TimelineHeaderDataLoggerProvider aZ;
    @Inject
    volatile Provider<TimelineConfig> al = UltralightRuntime.a;
    @Inject
    TimelineStructuredSurveyController am;
    @Inject
    TimelineFriendingClientProvider an;
    @Inject
    TimelineEditPhotoHelperProvider ao;
    @Inject
    ComposerActivityReceiver ap;
    @Inject
    TimelineCursorHelper aq;
    @Inject
    TimelineActionBarControllerImplProvider ar;
    @Inject
    TimelineContextualInfoControllerImplProvider as;
    @Inject
    TimelineNavtileControllerImplProvider at;
    @Inject
    TimelineHeaderPerfControllerImplProvider au;
    @Inject
    TimelinePublishControllerImplProvider av;
    @Inject
    TimelineFriendingControllerProvider aw;
    @Inject
    TimelineCoverPhotoControllerImplProvider ax;
    @Inject
    TimelineProfileImageControllerImplProvider ay;
    @Inject
    TimelineStoriesControllerProvider az;
    private boolean bA = false;
    private boolean bB = false;
    public TimelineAdapter bC;
    public TimelineDataFetcher bD;
    @Inject
    private TimelineEarlyFetcher bE;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<TimelineVisitedController> bF = UltralightRuntime.b;
    private TimelineFriendingClient bG;
    public Supplier<TimelineEditPhotoHelper> bH;
    public FeedNetworkConnectivityReceiver bI;
    public FadingFbTitleBar bJ;
    private boolean bK = true;
    public DataFreshnessResult bL = DataFreshnessResult.NO_DATA;
    public DataFreshnessResult bM = DataFreshnessResult.NO_DATA;
    private FadingContentFragmentController bN;
    @Nullable
    private TimelineProfileImageController bO;
    @Nullable
    private TimelineCoverPhotoController bP;
    @Nullable
    private TimelineActionBarControllerImpl bQ;
    @Nullable
    private TimelineContextualInfoControllerImpl bR;
    @Nullable
    private TimelineNavtileController bS;
    @Nullable
    private TimelinePublishController bT;
    public boolean bU = false;
    @Nullable
    public HeaderFetchFutures bV;
    @Nullable
    private FirstUnitsObservables bW;
    @Nullable
    private FetchContactCacheTask bX;
    public boolean bY = true;
    public boolean bZ = false;
    @Inject
    OfflinePostLoader ba;
    @Inject
    TimelineDataFetcherProvider bb;
    @Inject
    Provider<GraphQLCacheManager> bc;
    @Inject
    PerfTestConfig bd;
    @Inject
    ProtilesActionEventProcessorProvider be;
    @Inject
    TimelineEnvironmentGeneratedProvider bf;
    @Inject
    @LocalBroadcast
    BaseFbBroadcastManager bg;
    @Inject
    @ForUiThread
    Handler bh;
    @Inject
    ProfilePictureActionFlowLauncherProvider bi;
    @Inject
    DialtoneController bj;
    @Inject
    public ProfileControllerDelegate bk;
    @Inject
    TimelineMultiRowImagePrefetcherFactory bl;
    @Inject
    TimelineGraphSearchQueryFactoryProvider bm;
    @Inject
    TimelineErrorViewBinder bn;
    @Inject
    TimelineQpControllerProvider bo;
    @Inject
    OptimisticProfileMediaStore bp;
    @Inject
    FbSharedPreferences bq;
    private final Rect bs = new Rect();
    public TimelineFragmentView bt;
    public SwipeRefreshLayout bu;
    public ScrollingViewProxy bv;
    public LazyView<GenericNotificationBanner> bw;
    @Nullable
    public LazyView<View> bx;
    private boolean by = false;
    private boolean bz = false;
    private SelfRegistrableReceiverImpl cA;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<TimelineBootstrapEntitiesManager> cB = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ViewAccessibilityHelper> cC = UltralightRuntime.b;
    private MultiRowImagePrefetcherWrapper cD;
    private TimelineGraphSearchQueryFactory cE;
    private TimelineQpController cF;
    private TimelineEnvironmentGenerated cG;
    private FriendingEventSubscriber<FriendshipStatusChangedEvent> cH;
    private TimelineVisitedEventSubscriber cI;
    public LifeEventUploadEventSubscriber cJ;
    private boolean ca = false;
    @Nullable
    public TimelineHeaderPerfController cb;
    public FbEventSubscriberListManager cc;
    private FbEventSubscriberListManager cd;
    public FbEventSubscriberListManager ce;
    public TimelineUserContext cf;
    public TimelineHeaderUserData cg;
    private TimelineTaggedMediaSetData ch;
    private TimelinePromptData ci;
    private TimelineContextualInfoData cj;
    private TimelineConfig ck;
    private TimelineStorySnapshot cl;
    public TimelinePerformanceLogger cm;
    private CoverPhotoSource co;
    private TimelineFragmentScrollDelegate cp;
    @Nullable
    private Supplier<TimelineActivityResultHandler> cq;
    private SearchAwarenessProfilePillController cr;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ImagePipeline> cs = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbErrorReporter> ct = UltralightRuntime.b;
    private Supplier<TimelineLoggingViewportListener> cu;
    public TimelineHeaderDataLogger cv;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<DumpsysDumper> cw = UltralightRuntime.b;
    private TimelineFeedType cx;
    private ProtilesActionEventProcessor cy;
    private SelfRegistrableReceiverImpl cz;
    @Inject
    public volatile Provider<TimelineFetchFutures> f10234d = UltralightRuntime.a;
    @Inject
    volatile Provider<TimelineHeaderUpdateDispatcher> f10235e = UltralightRuntime.a;
    @Inject
    volatile Provider<ProfileNuxModalRunnableHelper> f10236f = UltralightRuntime.a;
    @Inject
    @IsPreventOnScrollEnabled
    volatile Provider<Boolean> f10237g = UltralightRuntime.a;
    @Inject
    public volatile Provider<QeAccessor> f10238h = UltralightRuntime.a;
    @Inject
    volatile Provider<AnalyticsTagger> f10239i = UltralightRuntime.a;

    /* compiled from: groups_seeds_composer_create_poll */
    class C15042 implements Runnable {
        final /* synthetic */ TimelineFragment f10226a;

        C15042(TimelineFragment timelineFragment) {
            this.f10226a = timelineFragment;
        }

        public void run() {
            if (this.f10226a.cg != null && this.f10226a.cg.e != InitializeState.FINAL_DATA && ((QeAccessor) this.f10226a.f10238h.get()).a(ExperimentsForTimelineAbTestModule.ap, false)) {
                this.f10226a.cg.a(GetNotifiedState.ASK);
                this.f10226a.mo_();
            }
        }
    }

    /* compiled from: groups_seeds_composer_create_poll */
    class C15053 implements Supplier<TimelineEditPhotoHelper> {
        final /* synthetic */ TimelineFragment f10227a;

        C15053(TimelineFragment timelineFragment) {
            this.f10227a = timelineFragment;
        }

        public Object get() {
            return this.f10227a.ao.a(Long.valueOf(this.f10227a.cf.b), this.f10227a, 1);
        }
    }

    /* compiled from: groups_seeds_composer_create_poll */
    class C15064 implements Supplier<TimelineActivityResultHandler> {
        final /* synthetic */ TimelineFragment f10228a;

        C15064(TimelineFragment timelineFragment) {
            this.f10228a = timelineFragment;
        }

        public Object get() {
            return this.f10228a.aP.m10266a(this.f10228a, this.f10228a.cf, this.f10228a.cg, this.f10228a.bH, this.f10228a.bD);
        }
    }

    /* compiled from: groups_seeds_composer_create_poll */
    class C15075 implements OnRefreshListener {
        final /* synthetic */ TimelineFragment f10229a;

        C15075(TimelineFragment timelineFragment) {
            this.f10229a = timelineFragment;
        }

        public final void m10284a() {
            this.f10229a.bu.setRefreshing(true);
            this.f10229a.mo470e();
            this.f10229a.aL.c(this.f10229a.cf.b, "1", RelationshipType.getRelationshipType(this.f10229a.cf.i(), this.f10229a.cg.B(), this.f10229a.cg.C()));
        }
    }

    /* compiled from: groups_seeds_composer_create_poll */
    class C15086 implements Runnable {
        final /* synthetic */ TimelineFragment f10230a;

        C15086(TimelineFragment timelineFragment) {
            this.f10230a = timelineFragment;
        }

        public void run() {
            this.f10230a.aC();
        }
    }

    /* compiled from: groups_seeds_composer_create_poll */
    public class C15097 {
        public final /* synthetic */ TimelineFragment f10231a;

        C15097(TimelineFragment timelineFragment) {
            this.f10231a = timelineFragment;
        }
    }

    /* compiled from: groups_seeds_composer_create_poll */
    public class C15108 {
        public final /* synthetic */ TimelineFragment f10232a;

        C15108(TimelineFragment timelineFragment) {
            this.f10232a = timelineFragment;
        }
    }

    private static <T extends InjectableComponentWithContext> void m10289a(Class<T> cls, T t) {
        m10290a((Object) t, t.getContext());
    }

    private static void m10290a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((TimelineFragment) obj).m10292a(IdBasedSingletonScopeProvider.a(injectorLike, 11121), IdBasedSingletonScopeProvider.a(injectorLike, 11254), IdBasedProvider.a(injectorLike, 11119), IdBasedProvider.a(injectorLike, 4375), IdBasedSingletonScopeProvider.a(injectorLike, 3219), IdBasedSingletonScopeProvider.a(injectorLike, 484), IdBasedSingletonScopeProvider.a(injectorLike, 11298), TimelineEarlyFetcher.m10575a(injectorLike), IdBasedLazy.a(injectorLike, 11190), TimelineStructuredSurveyController.m12685a(injectorLike), (TimelineFriendingClientProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineFriendingClientProvider.class), (TimelineEditPhotoHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineEditPhotoHelperProvider.class), ComposerActivityReceiver.a(injectorLike), TimelineCursorHelper.m10500a(injectorLike), (TimelineActionBarControllerImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineActionBarControllerImplProvider.class), (TimelineContextualInfoControllerImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineContextualInfoControllerImplProvider.class), (TimelineNavtileControllerImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineNavtileControllerImplProvider.class), (TimelineHeaderPerfControllerImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineHeaderPerfControllerImplProvider.class), (TimelinePublishControllerImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelinePublishControllerImplProvider.class), (TimelineFriendingControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineFriendingControllerProvider.class), (TimelineCoverPhotoControllerImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineCoverPhotoControllerImplProvider.class), (TimelineProfileImageControllerImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineProfileImageControllerImplProvider.class), (TimelineStoriesControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineStoriesControllerProvider.class), (TimelineVisitedEventControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineVisitedEventControllerProvider.class), IdBasedProvider.a(injectorLike, 11165), TimelineHeaderEventBus.a(injectorLike), FriendingEventBus.a(injectorLike), MediaUploadEventBus.a(injectorLike), TimelineVisitedEventBus.a(injectorLike), TimelineHeaderRenderState.a(injectorLike), TimelineAllSectionsData.m12706a(injectorLike), TimelineAllSectionsCursor.m10495a(injectorLike), PublisherData.m12450a(injectorLike), String_LoggedInUserIdMethodAutoProvider.a(injectorLike), TimelineAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 11192), (TimelineFragmentScrollDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineFragmentScrollDelegateProvider.class), UnseenStoryManager.a(injectorLike), (TimelineActivityResultHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineActivityResultHandlerProvider.class), (SearchAwarenessProfilePillControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SearchAwarenessProfilePillControllerProvider.class), GraphSearchIntentLauncher.a(injectorLike), (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(injectorLike), TimelineAdapterFactory.m12063a(injectorLike), TimelineScrollingViewProxyFactory.m12066a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 585), IdBasedSingletonScopeProvider.b(injectorLike, 2309), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedSingletonScopeProvider.a(injectorLike, 9836), (TimelineLoggingViewportListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineLoggingViewportListenerProvider.class), TimelineHeaderDataInitializer.m11427a(injectorLike), (TimelineHeaderDataLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineHeaderDataLoggerProvider.class), OfflinePostLoader.a(injectorLike), (TimelineDataFetcherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineDataFetcherProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 5454), IdBasedSingletonScopeProvider.a(injectorLike, 2179), PerfTestConfig.a(injectorLike), (ProtilesActionEventProcessorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProtilesActionEventProcessorProvider.class), (TimelineEnvironmentGeneratedProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineEnvironmentGeneratedProvider.class), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedLazy.a(injectorLike, 11378), IdBasedSingletonScopeProvider.b(injectorLike, 101), Handler_ForUiThreadMethodAutoProvider.a(injectorLike), (ProfilePictureActionFlowLauncherProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ProfilePictureActionFlowLauncherProvider.class), (DialtoneController) DialtoneControllerImpl.a(injectorLike), ProfileControllerDelegate.m10751a(injectorLike), TimelineMultiRowImagePrefetcherFactory.m12085a(injectorLike), (TimelineGraphSearchQueryFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineGraphSearchQueryFactoryProvider.class), TimelineErrorViewBinder.m12695a(injectorLike), (TimelineQpControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineQpControllerProvider.class), OptimisticProfileMediaStore.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    private void m10292a(Provider<TimelineFetchFutures> provider, Provider<TimelineHeaderUpdateDispatcher> provider2, Provider<ProfileNuxModalRunnableHelper> provider3, Provider<Boolean> provider4, Provider<QeAccessor> provider5, Provider<AnalyticsTagger> provider6, Provider<TimelineConfig> provider7, TimelineEarlyFetcher timelineEarlyFetcher, com.facebook.inject.Lazy<TimelineVisitedController> lazy, TimelineStructuredSurveyController timelineStructuredSurveyController, TimelineFriendingClientProvider timelineFriendingClientProvider, TimelineEditPhotoHelperProvider timelineEditPhotoHelperProvider, ComposerActivityReceiver composerActivityReceiver, TimelineCursorHelper timelineCursorHelper, TimelineActionBarControllerImplProvider timelineActionBarControllerImplProvider, TimelineContextualInfoControllerImplProvider timelineContextualInfoControllerImplProvider, TimelineNavtileControllerImplProvider timelineNavtileControllerImplProvider, TimelineHeaderPerfControllerImplProvider timelineHeaderPerfControllerImplProvider, TimelinePublishControllerImplProvider timelinePublishControllerImplProvider, TimelineFriendingControllerProvider timelineFriendingControllerProvider, TimelineCoverPhotoControllerImplProvider timelineCoverPhotoControllerImplProvider, TimelineProfileImageControllerImplProvider timelineProfileImageControllerImplProvider, TimelineStoriesControllerProvider timelineStoriesControllerProvider, TimelineVisitedEventControllerProvider timelineVisitedEventControllerProvider, Provider<TimelineContactCacheController> provider8, TimelineHeaderEventBus timelineHeaderEventBus, FriendingEventBus friendingEventBus, MediaUploadEventBus mediaUploadEventBus, TimelineVisitedEventBus timelineVisitedEventBus, TimelineHeaderRenderState timelineHeaderRenderState, TimelineAllSectionsData timelineAllSectionsData, TimelineAllSectionsCursor timelineAllSectionsCursor, PublisherData publisherData, String str, TimelineAnalyticsLogger timelineAnalyticsLogger, Provider<TimelineFragmentHeaderFetchCallbackDelegate> provider9, TimelineFragmentScrollDelegateProvider timelineFragmentScrollDelegateProvider, UnseenStoryManager unseenStoryManager, TimelineActivityResultHandlerProvider timelineActivityResultHandlerProvider, SearchAwarenessProfilePillControllerProvider searchAwarenessProfilePillControllerProvider, GraphSearchIntentLauncher graphSearchIntentLauncher, FbTitleBarSupplier fbTitleBarSupplier, TimelineAdapterFactory timelineAdapterFactory, TimelineScrollingViewProxyFactory timelineScrollingViewProxyFactory, Provider<FbNetworkManager> provider10, com.facebook.inject.Lazy<ImagePipeline> lazy2, com.facebook.inject.Lazy<FbErrorReporter> lazy3, Provider<ReactionSessionManager> provider11, TimelineLoggingViewportListenerProvider timelineLoggingViewportListenerProvider, TimelineHeaderDataInitializer timelineHeaderDataInitializer, TimelineHeaderDataLoggerProvider timelineHeaderDataLoggerProvider, OfflinePostLoader offlinePostLoader, TimelineDataFetcherProvider timelineDataFetcherProvider, com.facebook.inject.Lazy<DumpsysDumper> lazy4, Provider<GraphQLCacheManager> provider12, PerfTestConfig perfTestConfig, ProtilesActionEventProcessorProvider protilesActionEventProcessorProvider, TimelineEnvironmentGeneratedProvider timelineEnvironmentGeneratedProvider, FbBroadcastManager fbBroadcastManager, com.facebook.inject.Lazy<TimelineBootstrapEntitiesManager> lazy5, com.facebook.inject.Lazy<ViewAccessibilityHelper> lazy6, Handler handler, ProfilePictureActionFlowLauncherProvider profilePictureActionFlowLauncherProvider, DialtoneController dialtoneController, ProfileControllerDelegate profileControllerDelegate, TimelineMultiRowImagePrefetcherFactory timelineMultiRowImagePrefetcherFactory, TimelineGraphSearchQueryFactoryProvider timelineGraphSearchQueryFactoryProvider, TimelineErrorViewBinder timelineErrorViewBinder, TimelineQpControllerProvider timelineQpControllerProvider, OptimisticProfileMediaStore optimisticProfileMediaStore, FbSharedPreferences fbSharedPreferences) {
        this.f10234d = provider;
        this.f10235e = provider2;
        this.f10236f = provider3;
        this.f10237g = provider4;
        this.f10238h = provider5;
        this.f10239i = provider6;
        this.al = provider7;
        this.bE = timelineEarlyFetcher;
        this.bF = lazy;
        this.am = timelineStructuredSurveyController;
        this.an = timelineFriendingClientProvider;
        this.ao = timelineEditPhotoHelperProvider;
        this.ap = composerActivityReceiver;
        this.aq = timelineCursorHelper;
        this.ar = timelineActionBarControllerImplProvider;
        this.as = timelineContextualInfoControllerImplProvider;
        this.at = timelineNavtileControllerImplProvider;
        this.au = timelineHeaderPerfControllerImplProvider;
        this.av = timelinePublishControllerImplProvider;
        this.aw = timelineFriendingControllerProvider;
        this.ax = timelineCoverPhotoControllerImplProvider;
        this.ay = timelineProfileImageControllerImplProvider;
        this.az = timelineStoriesControllerProvider;
        this.aA = timelineVisitedEventControllerProvider;
        this.aB = provider8;
        this.aC = timelineHeaderEventBus;
        this.aD = friendingEventBus;
        this.aE = mediaUploadEventBus;
        this.aF = timelineVisitedEventBus;
        this.aG = timelineHeaderRenderState;
        this.aH = timelineAllSectionsData;
        this.aI = timelineAllSectionsCursor;
        this.aJ = publisherData;
        this.aK = str;
        this.aL = timelineAnalyticsLogger;
        this.aM = provider9;
        this.aN = timelineFragmentScrollDelegateProvider;
        this.aO = unseenStoryManager;
        this.aP = timelineActivityResultHandlerProvider;
        this.aQ = searchAwarenessProfilePillControllerProvider;
        this.aR = graphSearchIntentLauncher;
        this.aS = fbTitleBarSupplier;
        this.aT = timelineAdapterFactory;
        this.aU = timelineScrollingViewProxyFactory;
        this.aV = provider10;
        this.cs = lazy2;
        this.ct = lazy3;
        this.aW = provider11;
        this.aX = timelineLoggingViewportListenerProvider;
        this.aY = timelineHeaderDataInitializer;
        this.aZ = timelineHeaderDataLoggerProvider;
        this.ba = offlinePostLoader;
        this.bb = timelineDataFetcherProvider;
        this.cw = lazy4;
        this.bc = provider12;
        this.bd = perfTestConfig;
        this.be = protilesActionEventProcessorProvider;
        this.bf = timelineEnvironmentGeneratedProvider;
        this.bg = fbBroadcastManager;
        this.cB = lazy5;
        this.cC = lazy6;
        this.bh = handler;
        this.bi = profilePictureActionFlowLauncherProvider;
        this.bj = dialtoneController;
        this.bk = profileControllerDelegate;
        this.bl = timelineMultiRowImagePrefetcherFactory;
        this.bm = timelineGraphSearchQueryFactoryProvider;
        this.bn = timelineErrorViewBinder;
        this.bo = timelineQpControllerProvider;
        this.bp = optimisticProfileMediaStore;
        this.bq = fbSharedPreferences;
    }

    public final void mo469c(@Nullable Bundle bundle) {
        FbInjector an = an();
        TracerDetour.a("TimelineFragment.onFragmentCreate.getPerformanceLogger", 2070551337);
        try {
            this.cm = TimelinePerformanceLogger.a(an);
            Bundle mt_ = mt_();
            TracerDetour.a("TimelineFragment.onFragmentCreate.startInitialLogging", -452086797);
            try {
                if (D()) {
                    TimelinePerformanceLogger timelinePerformanceLogger = this.cm;
                    String string = mt_.getString("navigation_source");
                    int i = cn;
                    cn = i + 1;
                    timelinePerformanceLogger.a(string, i == 0);
                }
                TracerDetour.a(-511639121);
                super.mo469c(bundle);
                this.cm.b();
                TracerDetour.a("TimelineFragment.onFragmentCreate.injectMe", -6538358);
                try {
                    long parseLong;
                    ParcelUuid parcelUuid;
                    m10289a(TimelineFragment.class, (InjectableComponentWithContext) this);
                    this.bk.m10753a(new WeakReference(this));
                    this.cm.c();
                    this.cD = this.bl.m12087a();
                    this.am.m12692a("search_typeahead".equals(mt_.getString("navigation_source")));
                    this.am.m12694b(bh());
                    this.bj.a(this);
                    try {
                        parseLong = Long.parseLong(this.aK);
                    } catch (NumberFormatException e) {
                        parseLong = -1;
                        m10287a(this, "timeline_invalid_meuser", "logged in user: " + this.aK);
                    }
                    long j = mt_.getLong("com.facebook.katana.profile.id");
                    if (j < 0) {
                        j = parseLong;
                    }
                    String str = (String) Preconditions.checkNotNull(mt_().getString("session_id"));
                    this.cu = Suppliers.memoize(new Supplier<TimelineLoggingViewportListener>(this) {
                        final /* synthetic */ TimelineFragment f10222b;

                        public Object get() {
                            TracerDetour.a("TimelineFragment.onFragmentCreate.getViewportListener", 59989554);
                            try {
                                Object a = this.f10222b.aX.m11575a(Long.valueOf(j), this.f10222b.bC, this.f10222b.aH);
                                return a;
                            } finally {
                                TracerDetour.a(-997156289);
                            }
                        }
                    });
                    if (bundle != null) {
                        parcelUuid = (ParcelUuid) bundle.getParcelable("fragment_uuid");
                        Preconditions.checkNotNull(parcelUuid);
                    } else {
                        parcelUuid = new ParcelUuid(SafeUUIDGenerator.a());
                    }
                    this.cf = TimelineUserContext.a(parseLong, j, str, parcelUuid, FriendRequestMakeRef.from(mt_.getSerializable("timeline_friend_request_ref")), Optional.fromNullable(mt_.getString("timeline_context_item_type")), aX());
                    this.cx = new TimelineFeedType(this.cf);
                    this.aO.a(aY());
                    TracerDetour.a("TimelineFragment.onFragmentCreate.createTimelineConfig", 376867117);
                    try {
                        this.ck = (TimelineConfig) this.al.get();
                        TracerDetour.a("TimelineFragment.onFragmentCreate.createDataObjects", -1511517193);
                        try {
                            this.cg = new TimelineHeaderUserData(this.cf);
                            if (this.cf.i()) {
                                this.cg.a(this.bp.a());
                            }
                            if (bq()) {
                                this.cg.a(GetNotifiedState.GET_NOTIFIED);
                            } else {
                                HandlerDetour.b(this.bh, new C15042(this), 5000, -1948028121);
                            }
                            this.ch = new TimelineTaggedMediaSetData();
                            this.ci = new TimelinePromptData();
                            this.cj = TimelineContextualInfoDataFactory.m10471a();
                            this.cv = this.aZ.m11444a(str, Long.valueOf(j), this.cg);
                            TracerDetour.a("TimelineFragment.onFragmentCreate.getDataFetcher", 567320549);
                            try {
                                this.bD = this.bb.m10572a(getContext(), this, this.cf, QueryType.USER, this.aH, this.aI, this.ch, this.ci, this.cm, br);
                                ModelBundleProfileGraphQL modelBundleProfileGraphQL = (ModelBundleProfileGraphQL) FlatBufferModelHelper.a(mt_, "graphql_profile");
                                m10286a(j, modelBundleProfileGraphQL);
                                TracerDetour.a("TimelineFragment.onFragmentCreate.setPreliminaryProfile", -517005740);
                                try {
                                    this.aY.m11430a(modelBundleProfileGraphQL, this.cf, this.cg);
                                    if (TimelineHeaderViewHelper.a(this.cg.P())) {
                                        this.co = CoverPhotoSource.PRELIMINARY_DATA;
                                    }
                                    if (this.bX != null) {
                                        ((TimelineContactCacheController) this.aB.get()).m10480a(this.bX, this);
                                    }
                                    TracerDetour.a(-2063827740);
                                    this.bH = Suppliers.memoize(new C15053(this));
                                    this.cq = Suppliers.memoize(new C15064(this));
                                    TracerDetour.a("TimelineFragment.onFragmentCreate.getTimelineFriendingClient", 374445329);
                                    try {
                                        this.bG = this.an.m11960a(this.cf, this.cg, this.bD, this);
                                        TracerDetour.a("TimelineFragment.onFragmentCreate.setupSubControllers", 983482675);
                                        try {
                                            this.cb = this.au.m11468a(this.cv);
                                            this.cb.mo524a(this);
                                            TracerDetour.a("TimelineFragment.onFragmentCreate.setupEventHandlers", 1594057267);
                                            try {
                                                bu();
                                                if (this.cd != null) {
                                                    this.cd.a(this.aD);
                                                }
                                                if (this.ce != null) {
                                                    this.ce.a(this.aE);
                                                }
                                                TracerDetour.a(-634800149);
                                                bt();
                                                ((TimelineEditPhotoHelper) this.bH.get()).a(mt_);
                                                mt_.remove(EditGalleryIpcBundle.a);
                                                mt_.remove("extra_profile_pic_expiration");
                                                mt_.remove("profile_photo_method_extra");
                                                Serializable serializable = mt_.getSerializable("extra_action_on_fragment_create");
                                                if (serializable instanceof GraphQLProfilePictureActionLinkType) {
                                                    this.bi.a(this.bH).a((GraphQLProfilePictureActionLinkType) serializable);
                                                }
                                                aT();
                                                aV();
                                            } catch (Throwable th) {
                                                TracerDetour.a(1478074451);
                                            }
                                        } finally {
                                            TracerDetour.a(968007048);
                                        }
                                    } finally {
                                        TracerDetour.a(1313949686);
                                    }
                                } catch (Throwable th2) {
                                    TracerDetour.a(-501934168);
                                }
                            } finally {
                                TracerDetour.a(1287378373);
                            }
                        } finally {
                            TracerDetour.a(-1446230443);
                        }
                    } finally {
                        TracerDetour.a(-2123244380);
                    }
                } finally {
                    TracerDetour.a(-1847244300);
                }
            } catch (Throwable th3) {
                TracerDetour.a(-2070100370);
            }
        } finally {
            TracerDetour.a(1187143741);
        }
    }

    private boolean aX() {
        return this.s.getBoolean("timeline_has_unseen_section");
    }

    protected final void mo468b(int i, int i2, int i3) {
        if (!this.aq.m10502a(this.cf)) {
            super.mo468b(i, i2, i3);
        } else if (i3 < aF()) {
            this.bD.m10567f();
        }
    }

    private void m10286a(long j, ModelBundleProfileGraphQL modelBundleProfileGraphQL) {
        if (!bq()) {
            TracerDetour.a("TimelineFragment.onFragmentCreate.fetchTimeline", -1945628573);
            try {
                bg();
                TimelineEarlyFetchFutures timelineEarlyFetchFutures = (TimelineEarlyFetchFutures) this.bE.b(new TimelineFetchIdentifier(j));
                if (timelineEarlyFetchFutures != null) {
                    this.cm.a(this.bE.d());
                }
                m10288a(timelineEarlyFetchFutures, modelBundleProfileGraphQL);
                boolean p = PerfTestConfigBase.p();
                this.bW = timelineEarlyFetchFutures != null ? timelineEarlyFetchFutures.f10455c : null;
                this.bD.m10558a(this.bW, p);
            } finally {
                TracerDetour.a(-578605104);
            }
        }
    }

    private void bm() {
        if (this.y && !this.cg.j()) {
            this.aL.a(this.cf.b, RelationshipType.getRelationshipType(this.cf.i(), this.cg.B(), this.cg.C()));
        }
    }

    private void aT() {
        if (o().getIntent().getExtras().getBoolean("extra_action_on_fragment_create_create_profile_video")) {
            this.bk.mo473l().mo549c();
        }
    }

    private void aV() {
        if ("intro_card".equals(o().getIntent().getStringExtra("intro_card")) && this.cg != null) {
            this.cg.c = true;
        }
    }

    private boolean aY() {
        return this.cf.d();
    }

    private boolean aZ() {
        if (this.cg == null || this.cg.l == null || !this.cg.l.b() || !this.bq.a(TimelinePreferencesKeys.b, true)) {
            return false;
        }
        return true;
    }

    private void m10288a(@Nullable TimelineEarlyFetchFutures timelineEarlyFetchFutures, @Nullable ModelBundleProfileGraphQL modelBundleProfileGraphQL) {
        TimelineDataFetcher timelineDataFetcher = this.bD;
        TimelineEarlyFetchFutures a = timelineDataFetcher.m10555a().m10612a(timelineEarlyFetchFutures, modelBundleProfileGraphQL, br);
        this.bV = a.f10453a;
        this.bX = a.f10454b;
    }

    public static void m10287a(TimelineFragment timelineFragment, String str, String str2) {
        if (timelineFragment.cf != null) {
            ((AbstractFbErrorReporter) timelineFragment.ct.get()).c("native_timeline_profile", String.valueOf(timelineFragment.cf.b));
        }
        ((AbstractFbErrorReporter) timelineFragment.ct.get()).a(str, str2);
    }

    public final ContentFragmentType m10311d() {
        return ContentFragmentType.TIMELINE_COVERPHOTO_FRAGMENT;
    }

    public final void m10313e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("fragment_uuid", this.cf.d);
    }

    public final View m10298a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1548619012);
        this.bt = new TimelineFragmentView(getContext());
        ((AnalyticsTagger) this.f10239i.get()).a(this.bt, am_(), this);
        this.bu = (FbSwipeRefreshLayout) this.bt.findViewById(2131562210);
        layoutInflater.inflate(2130907451, this.bu, true);
        this.bu.e = new C15075(this);
        this.bv = this.aU.m12069a(this.bt);
        this.cG = this.bf.m11146a(getContext(), this.cx, new C15086(this), null, HasScrollListenerSupportImpl.a(this.bv), this.cD, this.cf, this.cg != null ? this.cg.N() : null);
        this.bC = this.aT.m12065a(this.cf, this.cj, this.cg, this.ch, this.cv, this.by, this.cG, this.bv);
        TimelineScrollingViewProxyFactory.m12067a(this.bv, this.bC, this.bt);
        this.cD.a(this.bC.f());
        this.bw = TimelineFragmentErrorBannerDelegate.m10762a(this.bt);
        this.cr = this.aQ.m12594a(((QeAccessor) this.f10238h.get()).a(ExperimentsForSearchAbTestModule.aD, false) ? new LazyView((ViewStub) this.bt.findViewById(2131567257)) : new LazyView((ViewStub) this.bt.findViewById(2131567258)), new C15097(this));
        this.bt.f12750a = new C15108(this);
        this.bI = new FeedNetworkConnectivityReceiver(this, getContext()) {
            final /* synthetic */ TimelineFragment f10233a;

            public final void m10285a(Context context, Intent intent) {
                if (this.f10233a.cg != null && this.f10233a.aH != null && this.f10233a.bI == this) {
                    boolean d = ((FbNetworkManager) this.f10233a.aV.get()).d();
                    TimelineErrorViewBinder timelineErrorViewBinder = this.f10233a.bn;
                    if (!TimelineErrorViewBinder.m12697a(this.f10233a.bx) && d) {
                        LazyView lazyView = this.f10233a.bw;
                        if (lazyView.b()) {
                            ((GenericNotificationBanner) lazyView.a()).a();
                        }
                        if (!this.f10233a.bZ && this.f10233a.aH.m12710a() < 20) {
                            if (this.f10233a.cg.e != InitializeState.FINAL_DATA || (this.f10233a.bL != DataFreshnessResult.FROM_SERVER && this.f10233a.bM != DataFreshnessResult.FROM_SERVER)) {
                                this.f10233a.bZ = true;
                                this.f10233a.mo470e();
                            }
                        }
                    }
                }
            }
        };
        this.cp = this.aN.m10786a(this.cf.g(), this.bv, this.bC, this.ck, this.cm, this.cu, this.cv, bw());
        this.bx = TimelineErrorViewBinder.m12696a(this.bt);
        TimelineFragmentView timelineFragmentView = this.bt;
        LogUtils.f(-343178756, a);
        return timelineFragmentView;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 463445242);
        super.mi_();
        this.bv.e(((Boolean) this.f10237g.get()).booleanValue());
        this.bv.a(this);
        if (this.bK) {
            this.ba.a(new OfflinePostLoader.Listener(this) {
                final /* synthetic */ TimelineFragment f10210a;

                {
                    this.f10210a = r1;
                }

                public final void m10274a() {
                }

                public final void m10276b() {
                    this.f10210a.aI();
                }

                public final boolean m10275a(long j, GraphQLStory graphQLStory) {
                    return TimelineFragment.m10293a(this.f10210a, j, graphQLStory);
                }
            }, this.aH.f12767f);
            this.bK = false;
        }
        if (this.aS != null) {
            this.bJ = (FadingFbTitleBar) this.aS.get();
            if (this.bJ != null) {
                this.bJ.a(new C17861(this.am, this.cg, this.cf));
            }
        }
        this.bG.f11913n = false;
        if (!bq()) {
            ((TimelineFragmentHeaderFetchCallbackDelegate) this.aM.get()).m10778a(this.bV, this);
        }
        if (!(this.bJ == null || this.by)) {
            this.bU = true;
            bx();
        }
        ba();
        this.cA.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 405452382, a);
    }

    private void ba() {
        this.bt.setPadding(0, this.bt.getPaddingTop(), 0, this.bt.getPaddingBottom());
    }

    public final void mo453G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1815228453);
        if (this.bI != null) {
            this.bI.a();
        }
        super.mo453G();
        if (this.cc != null) {
            this.cc.a(this.aC);
        }
        if (this.bA) {
            bb();
            this.bA = false;
        }
        this.cy = this.be.m11300a(this.cg, this.ch, this.cf, this.aL);
        ProtilesActionEventProcessor protilesActionEventProcessor = this.cy;
        if (protilesActionEventProcessor.f11158j == null) {
            protilesActionEventProcessor.f11158j = protilesActionEventProcessor.f11150b.a(ProtilesActionEvent.class, new C16151(protilesActionEventProcessor));
        }
        this.bD.m10566e();
        bc();
        this.cm.c.b("TimelineFragmentCreate");
        bm();
        this.cp.m10781a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1480754748, a);
    }

    private void bb() {
        ScrollingViewProxy n = m10320n();
        if (n != null) {
            this.cD.a(n);
            n.b(this.cD.a());
        }
    }

    private void bc() {
        String N;
        if (this.cg != null) {
            N = this.cg.N();
        } else {
            N = null;
        }
        if (!Strings.isNullOrEmpty(N)) {
            Object obj;
            if (this.bJ != null) {
                obj = 1;
            } else if (this.aS == null || this.aS.get() == null) {
                obj = null;
            } else {
                this.bJ = (FadingFbTitleBar) this.aS.get();
                int i = 1;
            }
            if (obj != null) {
                HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
                if (hasTitleBar != null) {
                    hasTitleBar.a_(N);
                } else if (this.bJ != null) {
                    this.bJ.setTitle(N);
                }
            }
        }
    }

    public final void mo454H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1261044342);
        if (this.bI != null) {
            this.bI.b();
        }
        this.cm.a();
        if (this.cc != null) {
            this.cc.b(this.aC);
        }
        if (this.cy != null) {
            ProtilesActionEventProcessor protilesActionEventProcessor = this.cy;
            Preconditions.checkState(protilesActionEventProcessor.f11158j != null, "Trying to stop TimelineScrubberClickEventProcessor that was not started");
            protilesActionEventProcessor.f11150b.a(protilesActionEventProcessor.f11158j);
            protilesActionEventProcessor.f11158j = null;
        }
        TimelineFragmentScrollDelegate timelineFragmentScrollDelegate = this.cp;
        ScrollingViewProxy scrollingViewProxy = this.bv;
        if (timelineFragmentScrollDelegate.f10762n) {
            ((FrameRateLogger) timelineFragmentScrollDelegate.f10755g.get()).b();
        }
        ((ViewportMonitor) timelineFragmentScrollDelegate.f10756h.get()).c(scrollingViewProxy);
        timelineFragmentScrollDelegate.f10757i.m11442a(false);
        FeedLoggingViewportEventListener feedLoggingViewportEventListener = (FeedLoggingViewportEventListener) timelineFragmentScrollDelegate.f10750a.get();
        feedLoggingViewportEventListener.a("unknown");
        feedLoggingViewportEventListener.a(null);
        if (this.bz && m10320n() != null) {
            this.cD.b();
            m10320n().c(this.cD.a());
            this.bA = true;
        }
        this.cr.m12592h();
        super.mo454H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -965992570, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1800403898);
        super.mj_();
        TimelineDataFetcher timelineDataFetcher = this.bD;
        timelineDataFetcher.m10555a().m10616b();
        timelineDataFetcher.m10562b().m10724c();
        ((TimelineFragmentHeaderFetchCallbackDelegate) this.aM.get()).m10777a();
        if (this.cA != null) {
            this.cA.c();
        }
        if (this.bv != null) {
            this.bv.a(null);
        }
        this.cm.a();
        this.bG.f11913n = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2018493858, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1804031028);
        TimelineAdapter timelineAdapter = this.bC;
        TimelineHeaderMultiAdapter timelineHeaderMultiAdapter = timelineAdapter.f12030c;
        for (NeedsFragmentCleanup needsFragmentCleanup : timelineHeaderMultiAdapter.f11402c) {
            if (needsFragmentCleanup != null) {
                if (!(needsFragmentCleanup instanceof View)) {
                    needsFragmentCleanup.c();
                } else if (((View) needsFragmentCleanup).getParent() == null) {
                    needsFragmentCleanup.c();
                }
            }
        }
        timelineHeaderMultiAdapter.f11402c.clear();
        timelineAdapter.f12034g.jc_();
        timelineAdapter.f12031d.jc_();
        if (timelineAdapter.f12032e != null) {
            timelineAdapter.f12032e.jc_();
        }
        if (timelineAdapter.f12033f != null) {
            timelineAdapter.f12033f.jc_();
        }
        this.cg.c();
        this.ci.c();
        this.cj.c();
        super.mY_();
        this.cp = null;
        TimelineErrorViewBinder.m12698b(this.bx);
        if (this.bv != null) {
            this.bv.a(null);
            this.bv.y();
        }
        if (this.bI != null) {
            this.bI.b();
            this.bI = null;
        }
        this.bt = null;
        if (this.cF != null) {
            TimelineQpController timelineQpController = this.cF;
            if (timelineQpController.f12579d != null) {
                timelineQpController.f12579d.setVisibility(8);
            }
        }
        this.bv = null;
        this.bC = null;
        this.bw = null;
        this.bx = null;
        if (this.bu != null) {
            this.bu.e = null;
            this.bu = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -991038129, a);
    }

    public final void mo455I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -537459577);
        if (this.ap != null) {
            this.ap.b();
        }
        if (this.cz != null && this.cz.a()) {
            this.cz.c();
        }
        if (this.cd != null) {
            this.cd.b(this.aD);
        }
        if (this.ce != null) {
            this.ce.b(this.aE);
        }
        TimelineFragmentHeaderFetchCallbackDelegate.m10773a(this.bY, this.bV, this.bX);
        this.bV = null;
        this.bX = null;
        if (this.bD != null) {
            this.bD.m10565c();
        }
        this.bj.b(this);
        this.cg.p();
        TimelinePromptData timelinePromptData = this.ci;
        timelinePromptData.b = null;
        timelinePromptData.d = 0;
        timelinePromptData.a = 0;
        TimelineContextualInfoData timelineContextualInfoData = this.cj;
        timelineContextualInfoData.b = null;
        timelineContextualInfoData.d = 0;
        timelineContextualInfoData.a = 0;
        this.bH = null;
        if (this.bQ != null) {
            this.bQ.m10414b();
            this.bQ = null;
        }
        if (this.cb != null) {
            this.cb.mo524a(null);
            this.cb = null;
        }
        this.bD = null;
        this.cg = null;
        this.ci = null;
        this.cj = null;
        this.ap = null;
        this.cz = null;
        this.cA = null;
        this.ar = null;
        this.as = null;
        this.at = null;
        this.av = null;
        this.aw = null;
        this.ax = null;
        this.az = null;
        this.cJ = null;
        super.mo455I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1721298786, a);
    }

    public final void m10299a(int i, int i2, Intent intent) {
        if (this.cq != null) {
            ((TimelineActivityResultHandler) this.cq.get()).m10265a(i, i2, intent);
        }
    }

    public final void m10316h(final int i) {
        if (this.bv != null && this.bC != null) {
            HandlerDetour.b(this.bh, new Runnable(this) {
                final /* synthetic */ TimelineFragment f10212b;

                public void run() {
                    this.f10212b.bv.c(i, this.f10212b.bU ? this.f10212b.bJ.getHeight() : 0);
                }
            }, 0, -831015397);
        }
    }

    public final void mo470e() {
        m10294i(1);
    }

    public static boolean be(TimelineFragment timelineFragment) {
        if (!timelineFragment.hn_()) {
            return false;
        }
        timelineFragment.m10294i(0);
        return true;
    }

    private void m10294i(int i) {
        this.aH.m12721a(TimelineSectionLoadState.LOADING);
        aC();
        if (this.bD != null) {
            this.bD.m10556a(i);
        }
        ((ViewAccessibilityHelper) this.cC.get()).a(this.bt, b(2131233428));
    }

    public final void aI() {
        LazyView lazyView = this.bw;
        if (lazyView != null && lazyView.b()) {
            ((GenericNotificationBanner) lazyView.a()).a();
        }
        aC();
        if (this.bu != null) {
            this.bu.setRefreshing(false);
        }
        bc();
    }

    private void bf() {
        if (!TimelineErrorViewBinder.m12697a(this.bx)) {
            FbNetworkManager fbNetworkManager = (FbNetworkManager) this.aV.get();
            LazyView lazyView = this.bw;
            if (lazyView != null && fbNetworkManager.d()) {
                ((GenericNotificationBanner) lazyView.a()).a(NotificationBannerType.FETCH_TIMELINE_FAILED);
            }
        }
        if (this.bu != null) {
            this.bu.setRefreshing(false);
        }
    }

    private void bg() {
        if (this.cj != null) {
            this.cj.g();
        }
        aC();
    }

    public final void m10305a(Object obj, DataFreshnessResult dataFreshnessResult, ResultSource resultSource) {
        TimelineHeaderUserFieldsModel timelineHeaderUserFieldsModel = null;
        if (obj instanceof UserTimelineSelfQueryFieldsModel) {
            timelineHeaderUserFieldsModel = ((UserTimelineSelfQueryFieldsModel) obj).a();
        } else if (obj instanceof TimelineHeaderUserFieldsModel) {
            timelineHeaderUserFieldsModel = (TimelineHeaderUserFieldsModel) obj;
        }
        if (timelineHeaderUserFieldsModel == null) {
            bs();
        } else if (this.cg != null && this.cf != null && this.bD != null) {
            Object obj2;
            TimelineHeaderUserData timelineHeaderUserData = this.cg;
            if (timelineHeaderUserData.a == null || !timelineHeaderUserData.a.x()) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                bs();
                return;
            }
            TimelineErrorViewBinder.m12698b(this.bx);
            this.aY.m11429a(this.cg, timelineHeaderUserFieldsModel.o());
            m10291a(obj, dataFreshnessResult);
            RelationshipType relationshipType = RelationshipType.getRelationshipType(this.cf.i(), this.cg.B(), this.cg.C());
            ((TimelineLoggingViewportListener) this.cu.get()).f11539l = relationshipType;
            this.cv.f11375j = relationshipType;
            this.cp.m10782a(relationshipType);
            QeAccessor qeAccessor = (QeAccessor) this.f10238h.get();
            if (aZ() && qeAccessor.a(ExperimentsForTimelineAbTestModule.aC, false) && !this.ca) {
                this.ca = true;
                HandlerDetour.b(this.bh, new C14991((ProfileNuxModalRunnableHelper) this.f10236f.get(), ao(), this.cg, String.valueOf(this.cf.b)), 1500, 271108695);
            }
            TimelineFriendingClient timelineFriendingClient = this.bG;
            timelineFriendingClient.f11911l = timelineFriendingClient.f11903d.C();
            timelineFriendingClient.f11912m = timelineFriendingClient.f11903d.D();
            String y = this.cg.y();
            this.cG.f11015s.f10995b = y;
            if (y == null) {
                y = this.cg.N();
            }
            this.cG.f11015s.f10994a = y;
            bm();
            if (bh()) {
                this.cv.m11443i();
            }
            if (this.co == null) {
                this.co = TimelineHeaderViewHelper.b(this.cg.P()) ? CoverPhotoSource.GRAPHQL_MAIN_REQUEST : CoverPhotoSource.NO_PHOTO;
            }
            this.cm.a(bh(), resultSource, relationshipType, this.co);
            if (this.aG.i()) {
                bj();
            }
        }
    }

    private boolean bh() {
        return o().getIntent().hasExtra("is_from_get_notified_notification");
    }

    private void bi() {
        if (this.cF == null) {
            TimelineQpControllerProvider timelineQpControllerProvider = this.bo;
            TimelineUserContext timelineUserContext = this.cf;
            TimelineHeaderUserData timelineHeaderUserData = this.cg;
            FragmentManager s = s();
            this.cF = new TimelineQpController(timelineUserContext, timelineHeaderUserData, s, FindViewUtil.b(this.bt, 2131567929), IdBasedSingletonScopeProvider.a(timelineQpControllerProvider, 2360), IdBasedSingletonScopeProvider.a(timelineQpControllerProvider, 9822));
        }
        this.cF.m12562a();
    }

    public final void aJ() {
        bj();
        if (this.bD != null) {
            this.bD.m10563b(this.bW, PerfTestConfigBase.f);
        }
        if (this.cg.c && this.bv != null && this.bC != null) {
            TimelineAdapter timelineAdapter = this.bC;
            Part part = Part.MEGAPHONE;
            int count = timelineAdapter.getCount();
            int i = 0;
            while (i < count) {
                if (timelineAdapter.getItem(i) == part) {
                    break;
                }
                i++;
            }
            i = -1;
            int i2 = i;
            if (i2 != -1) {
                m10316h(i2);
            }
        }
    }

    private void bj() {
        this.aJ.f12417a.f12428a = TimelineHeaderViewHelper.a(this.cf, this.cg.T());
        aC();
    }

    public final void aK() {
        bl();
        bi();
        this.am.m12693b(this.cf, this.cg);
    }

    private void bl() {
        if (!this.bz) {
            if (!((QeAccessor) this.f10238h.get()).a(ExperimentsForTimelineAbTestModule.at, false)) {
                aD();
            }
            aE();
            bb();
            this.bz = true;
        }
    }

    public final void c_(boolean z) {
        if (z && this.cF != null) {
            this.cF.m12563c();
        }
    }

    private void m10291a(Object obj, DataFreshnessResult dataFreshnessResult) {
        ((TimelineHeaderUpdateDispatcher) this.f10235e.get()).m11488a(obj, dataFreshnessResult, this.cf, this.cg, this.cj);
        this.bL = dataFreshnessResult;
        aI();
    }

    public final void aL() {
        if (this.cj != null) {
            this.cj.h();
        }
        aC();
        if (this.cg != null && this.cg.e == InitializeState.UNINITIALIZED) {
            int i;
            if (((FbNetworkManager) this.aV.get()).d()) {
                i = 2131230798;
            } else {
                i = 2131230763;
            }
            this.bn.m12699a(this.bx, i, true);
        }
        TimelinePerformanceLogger timelinePerformanceLogger = this.cm;
        timelinePerformanceLogger.c.d("TimelineLoadHeader");
        if (!timelinePerformanceLogger.E) {
            timelinePerformanceLogger.E = true;
            timelinePerformanceLogger.f.b = true;
        }
        bl();
        if (this.bD != null) {
            this.bD.m10563b(this.bW, PerfTestConfigBase.f);
        }
        bf();
    }

    public final void mq_() {
        if (this.bV != null && ((TimelineFetchFutures) this.f10234d.get()).m10272a(this.cf.b, this.bV.f10417b)) {
            ((TimelineFragmentHeaderFetchCallbackDelegate) this.aM.get()).m10777a();
            this.bD.m10555a().f10536p = true;
            av().m10723b();
            this.bY = false;
            Intent intent = new Intent(getContext(), ProfileLoaderService.class);
            intent.putExtras(o().getIntent());
            String str = "com.facebook.katana.profile.id";
            if (!intent.hasExtra(str)) {
                intent.putExtra(str, Long.parseLong(this.aK));
            }
            intent.putExtra("profile_name", this.cg.N());
            o().startService(intent);
            if (((QeAccessor) this.f10238h.get()).a(ExperimentsForTimelineAbTestModule.aq, false)) {
                new FbAlertDialogBuilder(getContext()).a(2131235077).b(2131235078).a(2131230756, new OnClickListener(this) {
                    final /* synthetic */ TimelineFragment f10213a;

                    {
                        this.f10213a = r1;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        this.f10213a.o().finish();
                    }
                }).a().show();
            }
        }
    }

    private boolean bq() {
        return ((TimelineFetchFutures) this.f10234d.get()).m10273b(this.cf.b) == 1;
    }

    public final void aM() {
        if (this.bv != null && this.bC != null && this.aH != null) {
            try {
                int q = this.bv.q();
                if (q >= this.bC.m12061d()) {
                    this.cl = this.aH.m12713a(mo472g(q), this.bC.h(q));
                    if (this.cl != null) {
                        this.cl.m12070a(this.bv.f(0).getTop());
                    }
                }
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) this.ct.get()).b("TimelineFragment", "Illegal index in onBeforeDataChanged", e);
            }
        }
    }

    public final void aN() {
        if (this.cg != null) {
            if (!(this.cl == null || this.bv == null || this.bC == null || this.aH == null)) {
                int g = this.bC.m12062g();
                TimelineAllSectionsData timelineAllSectionsData = this.aH;
                TimelineStorySnapshot timelineStorySnapshot = this.cl;
                int i = 0;
                if (timelineStorySnapshot != null) {
                    int i2 = 0;
                    for (TimelineSectionData timelineSectionData : timelineAllSectionsData.f12765d) {
                        if (timelineSectionData.f12793f.equals(timelineStorySnapshot.f12057a)) {
                            String b = timelineSectionData.m12750b(timelineStorySnapshot.f12058b);
                            if (timelineStorySnapshot.f12060d == null || !timelineStorySnapshot.f12060d.equals(b)) {
                                int i3;
                                int i4;
                                b = timelineStorySnapshot.f12060d;
                                if (b == null) {
                                    i3 = -1;
                                } else {
                                    i3 = 0;
                                    while (i3 < timelineSectionData.m12748b()) {
                                        if (b.equals(timelineSectionData.m12750b(i3))) {
                                            break;
                                        }
                                        i3++;
                                    }
                                    i3 = -1;
                                }
                                i = i3;
                                if (i < 0) {
                                    if ("PLACEHOLDER_ID".equals(timelineStorySnapshot.f12060d)) {
                                        i3 = timelineSectionData.m12748b() - 1;
                                    } else {
                                        i3 = Math.min(timelineStorySnapshot.f12058b, timelineSectionData.m12748b() - 1);
                                    }
                                    i4 = i3;
                                } else {
                                    i4 = i;
                                }
                                i = (i4 + i2) + 1;
                            } else {
                                i = (timelineStorySnapshot.f12058b + i2) + 1;
                            }
                        } else {
                            i2 = timelineSectionData.m12748b() + i2;
                        }
                    }
                }
                this.bv.d(this.bC.t_(g + i) + this.cl.f12059c, this.cl.f12061e);
                this.cl = null;
            }
            ((TimelineBootstrapEntitiesManager) this.cB.get()).m12595a(this.cf, this.cg, this.s.getString("navigation_source"));
        }
    }

    public final void m10301a(DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j) {
        if (this.cg != null && this.cf != null) {
            br();
            TimelineVisitedController timelineVisitedController = (TimelineVisitedController) this.bF.get();
            TimelineUserContext timelineUserContext = this.cf;
            Object obj = 1;
            Object obj2 = (this.cg.B() == GraphQLFriendshipStatus.ARE_FRIENDS || timelineUserContext.i()) ? 1 : null;
            if (timelineVisitedController.f10688c || obj2 == null) {
                obj = null;
            }
            if (obj != null) {
                String valueOf = String.valueOf(timelineUserContext.b);
                timelineVisitedController.f10687b.a(new TimelineVisitedEvent(timelineUserContext.d, valueOf));
                UserMarkProfileVisitedInputData userMarkProfileVisitedInputData = new UserMarkProfileVisitedInputData();
                userMarkProfileVisitedInputData.a("profile_id", valueOf);
                timelineVisitedController.f10686a.a(GraphQLRequest.a((TimelineVisitedMutationString) new TimelineVisitedMutationString().a("input", userMarkProfileVisitedInputData)));
                timelineVisitedController.f10688c = true;
            }
            this.cm.a(dataFreshnessResult, resultSource, RelationshipType.getRelationshipType(this.cf.i(), this.cg.B(), this.cg.C()));
            this.aL.a(dataFreshnessResult, j);
        }
    }

    public final void m10302a(TimelineSectionFetchParams timelineSectionFetchParams, DataFreshnessResult dataFreshnessResult, long j) {
        if (this.cg != null && this.cf != null && this.bD != null) {
            br();
            this.bM = dataFreshnessResult;
            aI();
            if (timelineSectionFetchParams.f10704h) {
                this.aL.a(dataFreshnessResult, j);
            }
            TimelinePerformanceLogger timelinePerformanceLogger = this.cm;
            String str = timelineSectionFetchParams.f10697a;
            if (timelinePerformanceLogger.u) {
                timelinePerformanceLogger.u = false;
                long now = timelinePerformanceLogger.e.now();
                if (!timelinePerformanceLogger.C.contains(str)) {
                    timelinePerformanceLogger.C.add(str);
                    timelinePerformanceLogger.b.markerStart(1703957, str.hashCode(), now);
                }
                timelinePerformanceLogger.b.markerEnd(1703957, str.hashCode(), (short) 2, now);
                timelinePerformanceLogger.C.remove(str);
                timelinePerformanceLogger.b.b(1703968, str.hashCode(), (short) 2);
            }
            timelinePerformanceLogger.b.b(1703969, str.hashCode(), (short) 2);
        }
    }

    public final void m10308b(TimelineSectionFetchParams timelineSectionFetchParams) {
        br();
        if (timelineSectionFetchParams.f10703g) {
            this.cm.l();
        }
        if (this.aH != null) {
            this.aH.m12719a(timelineSectionFetchParams, TimelineSectionLoadState.FAILED);
        }
        TimelinePerformanceLogger timelinePerformanceLogger = this.cm;
        String str = timelineSectionFetchParams.f10697a;
        Preconditions.checkNotNull(str);
        timelinePerformanceLogger.b.b(1703968, str.hashCode(), (short) 3);
        timelinePerformanceLogger.C.remove(str);
        timelinePerformanceLogger.b.b(1703957, str.hashCode(), (short) 3);
        timelinePerformanceLogger.b.b(1703969, str.hashCode(), (short) 3);
        bf();
        aC();
    }

    private void br() {
        if (!this.bB && this.az != null) {
            TimelineStoriesControllerProvider timelineStoriesControllerProvider = this.az;
            m10242a(new TimelineStoriesController(this.cf, aw(), (Context) timelineStoriesControllerProvider.getInstance(Context.class), FbUriIntentHandler.a(timelineStoriesControllerProvider)));
            this.bB = true;
        }
    }

    private void bs() {
        this.bn.m12699a(this.bx, 2131230803, false);
    }

    public final void aQ() {
        this.cm.c.d("TimelineFetchProfilePicUri");
    }

    public final void mo456a(ScrollingViewProxy scrollingViewProxy, int i) {
        super.mo456a(scrollingViewProxy, i);
        this.cp.m10783a(scrollingViewProxy, i);
        SearchAwarenessProfilePillController searchAwarenessProfilePillController = this.cr;
        if (searchAwarenessProfilePillController.f12638e) {
            if (i == 0 || (i == 1 && searchAwarenessProfilePillController.f12643j == 2)) {
                searchAwarenessProfilePillController.f12642i++;
            }
            searchAwarenessProfilePillController.f12643j = i;
            HandlerDetour.a(searchAwarenessProfilePillController.f12640g, searchAwarenessProfilePillController.f12641h);
            HandlerDetour.b(searchAwarenessProfilePillController.f12640g, searchAwarenessProfilePillController.f12641h, 500, -1995113872);
        }
    }

    public final void mo457a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        super.mo457a(scrollingViewProxy, i, i2, i3);
        this.cp.m10784a(scrollingViewProxy, i, i2, i3);
    }

    private void bt() {
        this.ap.a(new ComposerActivityReceiver.Listener(this) {
            final /* synthetic */ TimelineFragment f10214a;

            {
                this.f10214a = r1;
            }

            public final boolean m10279a(long j, GraphQLStory graphQLStory) {
                return TimelineFragment.m10293a(this.f10214a, j, graphQLStory);
            }

            public final void m10278a(GraphQLStory graphQLStory) {
                this.f10214a.aC();
            }

            public final void m10281b(GraphQLStory graphQLStory) {
                if (graphQLStory.l() != null) {
                    int a;
                    TimelineAllSectionsData at = this.f10214a.at();
                    String g = graphQLStory.g();
                    String j = graphQLStory.l().j();
                    for (TimelineSectionData a2 : at.f12765d) {
                        a = a2.m12742a(g, j);
                        if (a != -1) {
                            break;
                        }
                    }
                    a = -1;
                    if (a != -1) {
                        this.f10214a.at().f12767f.c(graphQLStory.c());
                        this.f10214a.at().m12716a((FeedUnit) graphQLStory);
                        m10280b();
                    }
                }
                this.f10214a.aI();
            }

            public final void m10277a() {
                this.f10214a.aC();
                TimelineFragment.m10287a(this.f10214a, "timeline_optimistic_post_failed", "Failed to post to profile " + this.f10214a.cf.b);
                this.f10214a.mo470e();
            }

            public final void m10280b() {
                this.f10214a.mo470e();
            }
        }, this.aH.f12767f);
        this.cz = this.bg.a().a("com.facebook.intent.action.COVER_PHOTO_UPDATED", new ActionReceiver(this) {
            final /* synthetic */ TimelineFragment f10218a;

            {
                this.f10218a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 469154120);
                if (this.f10218a.bD == null || this.f10218a.bD.m10555a() == null || this.f10218a.cg == null) {
                    Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1831979714, a);
                    return;
                }
                this.f10218a.bD.m10555a().m10618d();
                this.f10218a.cg.g();
                Set hashSet = new HashSet();
                hashSet.add("CoverImageRequest");
                ((GraphQLCacheManager) this.f10218a.bc.get()).a(hashSet);
                this.f10218a.aC();
                LogUtils.e(-760062738, a);
            }
        }).a("com.facebook.intent.action.ACTION_OPTIMISTIC_COVER_PHOTO_UPDATED", new ActionReceiver(this) {
            final /* synthetic */ TimelineFragment f10217a;

            {
                this.f10217a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 962972287);
                TimelineHeaderUserData timelineHeaderUserData = this.f10217a.cg;
                timelineHeaderUserData.g.e = UriUtil.a(this.f10217a.bp.c.a(OptimisticProfileMediaStore.b, null));
                timelineHeaderUserData.k();
                this.f10217a.mo_();
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 440690955, a);
            }
        }).a("com.facebook.intent.action.ACTION_OPTIMISTIC_PROFILE_PIC_UPDATED", new ActionReceiver(this) {
            final /* synthetic */ TimelineFragment f10216a;

            {
                this.f10216a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1274343763);
                this.f10216a.cg.a(this.f10216a.bp.a());
                this.f10216a.mo_();
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1197278786, a);
            }
        }).a("com.facebook.intent.action.ACTION_REFRESH_TIMELINE", new ActionReceiver(this) {
            final /* synthetic */ TimelineFragment f10215a;

            {
                this.f10215a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2088873985);
                this.f10215a.mo470e();
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 258130416, a);
            }
        }).a();
        this.cz.b();
        this.cA = this.bg.a().a("com.facebook.intent.action.ACTION_GET_NOTIFIED_PROFILE_LOADED", new ActionReceiver(this) {
            final /* synthetic */ TimelineFragment f10219a;

            {
                this.f10219a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1635234718);
                long longExtra = intent.getLongExtra("com.facebook.katana.profile.id", -1);
                if (this.f10219a.cf != null && this.f10219a.cf.b == longExtra) {
                    TimelineFragment.be(this.f10219a);
                }
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -2105611897, a);
            }
        }).a();
    }

    public static boolean m10293a(TimelineFragment timelineFragment, long j, GraphQLStory graphQLStory) {
        return j == timelineFragment.cf.b || (OptimisticPostStoryBuilder.a(graphQLStory) && timelineFragment.cf.b == Long.parseLong(timelineFragment.aK) && (Strings.isNullOrEmpty(OptimisticPostStoryBuilder.b(graphQLStory)) || OptimisticPostStoryBuilder.b(graphQLStory).equals(timelineFragment.aK)));
    }

    private void bu() {
        this.cc = new FbEventSubscriberListManager();
        this.cc.a(new AdapterDataChangedEventSubscriber(this) {
            final /* synthetic */ TimelineFragment f10220a;

            {
                this.f10220a = r1;
            }

            public final void m10282b(FbEvent fbEvent) {
                this.f10220a.aC();
            }
        });
        this.cd = new FbEventSubscriberListManager();
        TimelineFriendingController a = this.aw.m11971a(this.cf, this.bD, this, this.cg, this.bG);
        a.m11970a(this.cd);
        a.m11970a(this.cc);
        FriendingEventBus friendingEventBus = this.aD;
        C17157 c17157 = new C17157(a);
        friendingEventBus.a(c17157);
        this.cH = c17157;
        InjectorLike injectorLike = this.aA;
        TimelineVisitedEventController timelineVisitedEventController = new TimelineVisitedEventController(this.cf, this.aH, ProtilesData.m12116a(injectorLike), ProfileControllerDelegate.m10751a(injectorLike));
        TimelineVisitedEventBus timelineVisitedEventBus = this.aF;
        C15241 c15241 = new C15241(timelineVisitedEventController, timelineVisitedEventController.f10355a.d);
        timelineVisitedEventBus.a(c15241);
        this.cI = c15241;
        this.ce = new FbEventSubscriberListManager();
    }

    public final String am_() {
        return br.c();
    }

    private static String bw() {
        return "timeline";
    }

    protected final TimelineAllSectionsData at() {
        return this.aH;
    }

    @Nullable
    protected final ViewportMonitor ay() {
        return this.cp != null ? (ViewportMonitor) this.cp.f10756h.get() : null;
    }

    @Nullable
    public final TimelineStoriesDataFetcher av() {
        return this.bD != null ? this.bD.m10562b() : null;
    }

    public final ScrollingViewProxy m10320n() {
        return this.bv;
    }

    protected final /* synthetic */ BasicAdapter ax() {
        return this.bC;
    }

    protected final FriendingClient az() {
        return this.bG.m11956a();
    }

    protected final TimelineContext aA() {
        return this.cf;
    }

    protected final String aB() {
        return "timeline_ufi";
    }

    protected final int mo472g(int i) {
        if (i < this.bC.m12061d()) {
            return -1;
        }
        return this.bC.s_(i) - this.bC.m12062g();
    }

    public final void m10306a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.bC != null) {
            m10300a(new DumpsysContext(str, fileDescriptor, printWriter, strArr, (DumpsysDumper) this.cw.get()));
        }
    }

    public final void m10300a(DumpsysContext dumpsysContext) {
        ((DumpsysDumper) this.cw.get()).a(this.bC, dumpsysContext);
    }

    public final Map<String, Object> m10309c() {
        long j;
        TimelineUserContext timelineUserContext = this.cf;
        GraphQLFriendshipStatus B = this.cg.B();
        Bundle bundle = this.s;
        if (timelineUserContext != null) {
            j = timelineUserContext.b;
        } else {
            j = bundle.getLong("com.facebook.katana.profile.id");
        }
        ImmutableMap b = j < 0 ? null : (timelineUserContext == null || !FriendRequestMakeRef.isProfileShareMakeRef(timelineUserContext.a)) ? ImmutableBiMap.b("profile_id", Long.valueOf(j)) : ImmutableMap.of("profile_id", Long.valueOf(j), "uri_source", timelineUserContext.a.name(), "friendship_status", B);
        return b;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bC.a(configuration);
    }

    private void bx() {
        FadingTitlebarContent fadingTitlebarContent = (FadingTitlebarContent) a(FadingTitlebarContent.class);
        if (this.bN == null && fadingTitlebarContent != null) {
            this.bN = new FadingContentFragmentController();
            this.bN.a(this, this.bJ, this.bv, fadingTitlebarContent, true, true);
        }
        ba();
    }

    @Nullable
    public final FadingContentView m10317j() {
        QeAccessor qeAccessor = (QeAccessor) this.f10238h.get();
        if (!aZ() || qeAccessor.a(ExperimentsForTimelineAbTestModule.aC, false)) {
            FadingContentView fadingContentView;
            if (this.bv.f(0) instanceof FadingContentView) {
                fadingContentView = (FadingContentView) this.bv.f(0);
            } else {
                if (this.bv.f(0) instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) this.bv.f(0);
                    if (viewGroup.getChildAt(0) instanceof FadingContentView) {
                        fadingContentView = (FadingContentView) viewGroup.getChildAt(0);
                    } else if (viewGroup.getChildAt(0) instanceof ViewGroup) {
                        viewGroup = (ViewGroup) viewGroup.getChildAt(0);
                        if (viewGroup.getChildAt(0) instanceof FadingContentView) {
                            fadingContentView = (FadingContentView) viewGroup.getChildAt(0);
                        }
                    }
                }
                fadingContentView = null;
            }
            return fadingContentView;
        }
        this.by = true;
        return null;
    }

    public final boolean mk_() {
        return m10317j() != null && ((View) m10317j()).getGlobalVisibleRect(this.bs);
    }

    public final int ml_() {
        Integer num = (Integer) this.bv.A().get(Long.valueOf(this.bv.i(0)));
        return num == null ? 0 : num.intValue();
    }

    public final void m10321p() {
        this.by = true;
    }

    public final GraphSearchQuery m10322q() {
        GraphSearchQuery a;
        if (this.cE == null) {
            this.cE = new TimelineGraphSearchQueryFactory(this.cg.N(), Long.valueOf(this.cf.b), GatekeeperStoreImplMethodAutoProvider.a(this.bm));
        }
        TimelineGraphSearchQueryFactory timelineGraphSearchQueryFactory = this.cE;
        if (timelineGraphSearchQueryFactory.f12648c.a(SearchAbTestGatekeepers.r).asBoolean(false)) {
            a = GraphSearchQuery.a(ScopedEntityType.USER, timelineGraphSearchQueryFactory.f12647b, timelineGraphSearchQueryFactory.f12646a, ScopedSearchStyle.TAB, true);
        } else {
            a = GraphSearchQuery.a(ScopedEntityType.USER, timelineGraphSearchQueryFactory.f12647b, timelineGraphSearchQueryFactory.f12646a, null, true);
        }
        return a;
    }

    public final void iw_() {
    }

    public final void b_(boolean z) {
        if (!z) {
            mo_();
        }
    }

    @Nullable
    public final TimelineHeaderDataLogger mo471f() {
        return this.cv;
    }

    public final TimelineProfileImageController mo473l() {
        if (this.bO == null) {
            this.bO = this.ay.m11707a(ao(), this.aL, this.cf, this.bH, this.cg);
        }
        return this.bO;
    }

    public final TimelineContextualInfoController mo482r() {
        if (this.bR == null) {
            this.bR = this.as.m10467a(getContext(), this.aL, this.cf, this.cj, this.bD, this.cg);
        }
        return this.bR;
    }

    public final TimelineNavtileController mm_() {
        if (this.bS == null) {
            this.bS = this.at.m12083a(getContext(), this.aL, this.cf, this.ch, this.cg);
        }
        return this.bS;
    }

    public final TimelineActionBarController mo474m() {
        if (this.bQ == null) {
            this.bQ = this.ar.m10427a(getContext(), this.aL, this.cf, this.bG, this.cg, this.s.getString("group_commerce_sell_options_id"));
        }
        return this.bQ;
    }

    public final TimelineCoverPhotoController mo483t() {
        if (this.bP == null) {
            this.bP = new TimelineCoverPhotoControllerImpl(this.bH);
        }
        return this.bP;
    }

    public final TimelineHeaderPerfController mo484u() {
        return this.cb;
    }

    public final TimelinePublishController mo485v() {
        if (this.bT == null) {
            this.bT = this.av.m12468a(ao(), this.aL, this.cf, this.cg, aw());
        }
        return this.bT;
    }

    public final void mn_() {
        if (this.bD != null) {
            this.bD.m10555a().m10618d();
        }
    }

    public final void mo_() {
        aC();
    }

    public final void mp_() {
        ao().onBackPressed();
    }
}
