package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feedtype.FeedType;
import com.facebook.base.fragment.FbFragmentController;
import com.facebook.common.appstate.AppBackgroundFragmentController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.debug.components.ComponentsConversionController;
import com.facebook.debug.connection.ConnectionViewController;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.fragment.NewsFeedFragmentDsmController;
import com.facebook.feed.fragment.NewsFeedFragmentOfflineController;
import com.facebook.feed.fragment.debug.FreshFeedDebugViewController;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerMultiRowInjectedFeedAdapter;
import com.facebook.feed.inlinecomposer.multirow.ScrollAwayComposerNewsfeedController;
import com.facebook.feed.loader.StoryRankingTimeTracker;
import com.facebook.feed.megaphone.MegaphoneController;
import com.facebook.feed.rows.MultiRowAdapterControllerProvider;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.feed.topicfeeds.customization.TopicCustomizationHeaderAdapterFactoryMethodAutoProvider;
import com.facebook.feed.topicfeeds.customization.TopicFeedsCustomizationModule.C04411;
import com.facebook.feed.ui.PerfTestNewsFeedScrollController;
import com.facebook.feed.ui.controllers.SeeMoreFragmentController;
import com.facebook.feed.util.ConnectivityController;
import com.facebook.feed.util.HScrollAutoScrollController;
import com.facebook.feedplugins.placetips.PlaceTipsInjectedFeedAdapter;
import com.facebook.feedplugins.storyset.StorySetsViewportEventListener;
import com.facebook.goodwill.dailydialogue.adapter.DailyDialogueInjectedFeedAdapter;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.launcher.PlacePickerResultHandler;
import com.facebook.platformattribution.result.PlatformAttributionResultController;
import com.facebook.privacy.audience.PostPrivacyUpsellDialogController$EntryPoint;
import com.facebook.privacy.audience.PostPrivacyUpsellDialogFragmentControllerProvider;
import com.facebook.productionprompts.common.PromptActivityResultHandler;
import com.facebook.rapidfeedback.RapidFeedbackFragmentController;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeViewportEventListener;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.controllercallbacks.ScrollController;

/* compiled from: platform_native_share_photo_gallery */
public class NewsFeedDispatcherFactory {
    @Inject
    private FeedLoggingViewportController f9605A;
    @Inject
    private NewsFeedFragmentOfflineController f9606B;
    @Inject
    private ViewportMonitorFragmentController f9607C;
    @Inject
    private RapidFeedbackFragmentController f9608D;
    @Inject
    private PlacePickerResultHandler f9609E;
    @Inject
    private PostPrivacyUpsellDialogFragmentControllerProvider f9610F;
    @Inject
    private StorySetsViewportEventListener f9611G;
    @Inject
    private RedSpaceOptimisticBadgeViewportEventListener f9612H;
    @Inject
    private HScrollAutoScrollController f9613I;
    @Inject
    private NativeInjectionLoggerController f9614J;
    @Inject
    private SwipeRefreshController f9615K;
    @Inject
    private NewsFeedFragmentDsmController f9616L;
    @Inject
    private TopicCustomizationHeaderController f9617M;
    @Inject
    private InlineComposerMultiRowInjectedFeedAdapter f9618N;
    @Inject
    private DailyDialogueInjectedFeedAdapter f9619O;
    @Inject
    private MegaphoneController f9620P;
    @Inject
    private C04411 f9621Q;
    @Inject
    private PlaceTipsInjectedFeedAdapter f9622R;
    @Inject
    private GoodFriendsCustomizationHeaderController f9623S;
    @Inject
    private TailLoaderController f9624T;
    @Inject
    private NewsFeedViewController f9625U;
    @Inject
    private MultiRowImagePrefetcherFactory f9626V;
    @Inject
    private NewsFeedAdapterConfigurationProvider f9627W;
    @Inject
    private ScrollAwayComposerNewsfeedController f9628X;
    @Inject
    private ProgressBarExperimentsController f9629a;
    @Inject
    private PerfTestNewsFeedScrollController f9630b;
    @Inject
    private PlatformAttributionResultController f9631c;
    @Inject
    private ReviewComposerResultController f9632d;
    @Inject
    private DataSetUpdatedEventSubscriberController f9633e;
    @Inject
    private PromptActivityResultHandler f9634f;
    @Inject
    private SeeMoreFragmentController f9635g;
    @Inject
    private FreshFeedDebugViewController f9636h;
    @Inject
    private MenuButtonTooltipTriggerController f9637i;
    @Inject
    private FeedNuxBubbleController f9638j;
    @Inject
    private FeedRefreshTriggerController f9639k;
    @Inject
    private PreloadingController f9640l;
    @Inject
    private NewsFeedEventLoggerController f9641m;
    @Inject
    private ProfilePictureRefetcherController f9642n;
    @Inject
    private AppBackgroundFragmentController f9643o;
    @Inject
    private MultiRowAdapterControllerProvider f9644p;
    @Inject
    private DeleteStoryController f9645q;
    @Inject
    private ComponentsConversionController f9646r;
    @Inject
    private ComposerActivityController f9647s;
    @Inject
    private ConnectionViewController f9648t;
    @Inject
    private ConnectivityController f9649u;
    @Inject
    private NewsFeedScreenshotController f9650v;
    @Inject
    private FeedUnitCollectionController f9651w;
    @Inject
    private ErrorViewController f9652x;
    @Inject
    private AppInstallController f9653y;
    @Inject
    private FollowUpUnitController f9654z;

    private static NewsFeedDispatcherFactory m14661b(InjectorLike injectorLike) {
        NewsFeedDispatcherFactory newsFeedDispatcherFactory = new NewsFeedDispatcherFactory();
        newsFeedDispatcherFactory.m14660a(ProgressBarExperimentsController.m14663a(injectorLike), PerfTestNewsFeedScrollController.m14668a(injectorLike), PlatformAttributionResultController.m14671a(injectorLike), ReviewComposerResultController.m14717a(injectorLike), DataSetUpdatedEventSubscriberController.m14721a(injectorLike), PromptActivityResultHandler.m14725a(injectorLike), SeeMoreFragmentController.m14731a(injectorLike), FreshFeedDebugViewController.m14743a(injectorLike), MenuButtonTooltipTriggerController.m14750a(injectorLike), FeedNuxBubbleController.m14757a(injectorLike), FeedRefreshTriggerController.m14788a(injectorLike), PreloadingController.m14802a(injectorLike), NewsFeedEventLoggerController.m14823a(injectorLike), ProfilePictureRefetcherController.m14828a(injectorLike), AppBackgroundFragmentController.m14855a(injectorLike), (MultiRowAdapterControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MultiRowAdapterControllerProvider.class), DeleteStoryController.m14858a(injectorLike), ComponentsConversionController.m14871a(injectorLike), ComposerActivityController.m14876a(injectorLike), ConnectionViewController.m14919a(injectorLike), ConnectivityController.m14923a(injectorLike), NewsFeedScreenshotController.m14926a(injectorLike), FeedUnitCollectionController.m14931a(injectorLike), ErrorViewController.m14944a(injectorLike), AppInstallController.m14947a(injectorLike), FollowUpUnitController.m14967a(injectorLike), FeedLoggingViewportController.m15084a(injectorLike), NewsFeedFragmentOfflineController.m15125a(injectorLike), ViewportMonitorFragmentController.m15131a(injectorLike), RapidFeedbackFragmentController.m15166a(injectorLike), PlacePickerResultHandler.m15168a(injectorLike), (PostPrivacyUpsellDialogFragmentControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PostPrivacyUpsellDialogFragmentControllerProvider.class), StorySetsViewportEventListener.m15174a(injectorLike), RedSpaceOptimisticBadgeViewportEventListener.m15186a(injectorLike), HScrollAutoScrollController.m15203a(injectorLike), NativeInjectionLoggerController.m15241a(injectorLike), SwipeRefreshController.m15247a(injectorLike), NewsFeedFragmentDsmController.m8592a(injectorLike), TopicCustomizationHeaderController.m15259a(injectorLike), InlineComposerMultiRowInjectedFeedAdapter.m15262a(injectorLike), DailyDialogueInjectedFeedAdapter.m15323a(injectorLike), MegaphoneController.m15348a(injectorLike), TopicCustomizationHeaderAdapterFactoryMethodAutoProvider.m15468a(injectorLike), PlaceTipsInjectedFeedAdapter.m15471a(injectorLike), GoodFriendsCustomizationHeaderController.m15473a(injectorLike), TailLoaderController.m15476a(injectorLike), NewsFeedViewController.m15488a(injectorLike), MultiRowImagePrefetcherFactory.m15494a(injectorLike), (NewsFeedAdapterConfigurationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(NewsFeedAdapterConfigurationProvider.class), ScrollAwayComposerNewsfeedController.m15500a(injectorLike));
        return newsFeedDispatcherFactory;
    }

    private void m14660a(ProgressBarExperimentsController progressBarExperimentsController, PerfTestNewsFeedScrollController perfTestNewsFeedScrollController, PlatformAttributionResultController platformAttributionResultController, ReviewComposerResultController reviewComposerResultController, DataSetUpdatedEventSubscriberController dataSetUpdatedEventSubscriberController, PromptActivityResultHandler promptActivityResultHandler, SeeMoreFragmentController seeMoreFragmentController, FreshFeedDebugViewController freshFeedDebugViewController, MenuButtonTooltipTriggerController menuButtonTooltipTriggerController, FeedNuxBubbleController feedNuxBubbleController, FeedRefreshTriggerController feedRefreshTriggerController, PreloadingController preloadingController, NewsFeedEventLoggerController newsFeedEventLoggerController, ProfilePictureRefetcherController profilePictureRefetcherController, AppBackgroundFragmentController appBackgroundFragmentController, MultiRowAdapterControllerProvider multiRowAdapterControllerProvider, DeleteStoryController deleteStoryController, ComponentsConversionController componentsConversionController, ComposerActivityController composerActivityController, ConnectionViewController connectionViewController, ConnectivityController connectivityController, NewsFeedScreenshotController newsFeedScreenshotController, FeedUnitCollectionController feedUnitCollectionController, ErrorViewController errorViewController, AppInstallController appInstallController, FollowUpUnitController followUpUnitController, FeedLoggingViewportController feedLoggingViewportController, NewsFeedFragmentOfflineController newsFeedFragmentOfflineController, ViewportMonitorFragmentController viewportMonitorFragmentController, RapidFeedbackFragmentController rapidFeedbackFragmentController, PlacePickerResultHandler placePickerResultHandler, PostPrivacyUpsellDialogFragmentControllerProvider postPrivacyUpsellDialogFragmentControllerProvider, StorySetsViewportEventListener storySetsViewportEventListener, RedSpaceOptimisticBadgeViewportEventListener redSpaceOptimisticBadgeViewportEventListener, HScrollAutoScrollController hScrollAutoScrollController, NativeInjectionLoggerController nativeInjectionLoggerController, SwipeRefreshController swipeRefreshController, NewsFeedFragmentDsmController newsFeedFragmentDsmController, TopicCustomizationHeaderController topicCustomizationHeaderController, InlineComposerMultiRowInjectedFeedAdapter inlineComposerMultiRowInjectedFeedAdapter, DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter, MegaphoneController megaphoneController, C04411 c04411, PlaceTipsInjectedFeedAdapter placeTipsInjectedFeedAdapter, GoodFriendsCustomizationHeaderController goodFriendsCustomizationHeaderController, TailLoaderController tailLoaderController, NewsFeedViewController newsFeedViewController, MultiRowImagePrefetcherFactory multiRowImagePrefetcherFactory, NewsFeedAdapterConfigurationProvider newsFeedAdapterConfigurationProvider, ScrollAwayComposerNewsfeedController scrollAwayComposerNewsfeedController) {
        this.f9629a = progressBarExperimentsController;
        this.f9630b = perfTestNewsFeedScrollController;
        this.f9631c = platformAttributionResultController;
        this.f9632d = reviewComposerResultController;
        this.f9633e = dataSetUpdatedEventSubscriberController;
        this.f9634f = promptActivityResultHandler;
        this.f9635g = seeMoreFragmentController;
        this.f9636h = freshFeedDebugViewController;
        this.f9637i = menuButtonTooltipTriggerController;
        this.f9638j = feedNuxBubbleController;
        this.f9639k = feedRefreshTriggerController;
        this.f9640l = preloadingController;
        this.f9641m = newsFeedEventLoggerController;
        this.f9642n = profilePictureRefetcherController;
        this.f9643o = appBackgroundFragmentController;
        this.f9644p = multiRowAdapterControllerProvider;
        this.f9645q = deleteStoryController;
        this.f9646r = componentsConversionController;
        this.f9647s = composerActivityController;
        this.f9648t = connectionViewController;
        this.f9649u = connectivityController;
        this.f9650v = newsFeedScreenshotController;
        this.f9651w = feedUnitCollectionController;
        this.f9652x = errorViewController;
        this.f9653y = appInstallController;
        this.f9654z = followUpUnitController;
        this.f9605A = feedLoggingViewportController;
        this.f9606B = newsFeedFragmentOfflineController;
        this.f9607C = viewportMonitorFragmentController;
        this.f9608D = rapidFeedbackFragmentController;
        this.f9609E = placePickerResultHandler;
        this.f9610F = postPrivacyUpsellDialogFragmentControllerProvider;
        this.f9611G = storySetsViewportEventListener;
        this.f9612H = redSpaceOptimisticBadgeViewportEventListener;
        this.f9613I = hScrollAutoScrollController;
        this.f9614J = nativeInjectionLoggerController;
        this.f9615K = swipeRefreshController;
        this.f9616L = newsFeedFragmentDsmController;
        this.f9617M = topicCustomizationHeaderController;
        this.f9618N = inlineComposerMultiRowInjectedFeedAdapter;
        this.f9619O = dailyDialogueInjectedFeedAdapter;
        this.f9620P = megaphoneController;
        this.f9621Q = c04411;
        this.f9622R = placeTipsInjectedFeedAdapter;
        this.f9623S = goodFriendsCustomizationHeaderController;
        this.f9624T = tailLoaderController;
        this.f9625U = newsFeedViewController;
        this.f9626V = multiRowImagePrefetcherFactory;
        this.f9627W = newsFeedAdapterConfigurationProvider;
        this.f9628X = scrollAwayComposerNewsfeedController;
    }

    public static NewsFeedDispatcherFactory m14659a(InjectorLike injectorLike) {
        return m14661b(injectorLike);
    }

    public final NewsFeedControllerCallbacksDispatcher m14662a(NewsFeedFragment newsFeedFragment, StoryRankingTimeTracker storyRankingTimeTracker, Holder<LegacyFeedUnitUpdater> holder, Holder<ListItemCollection<FeedEdge>> holder2, FeedType feedType) {
        MultiRowImagePrefetcherWrapper a = this.f9626V.m15496a();
        NewsFeedAdapterConfiguration a2 = this.f9627W.m15499a(this.f9618N, this.f9619O, this.f9620P, this.f9621Q, this.f9622R, this.f9623S, this.f9624T, this.f9625U, a);
        NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher = new NewsFeedControllerCallbacksDispatcher(new FbFragmentController(), this.f9625U, this.f9629a, this.f9649u, this.f9630b, this.f9652x, this.f9636h, this.f9631c, this.f9632d, this.f9615K, this.f9633e, this.f9634f, this.f9635g, this.f9637i, this.f9638j, this.f9620P, new ImagePrefetcherController(a), storyRankingTimeTracker, this.f9639k, this.f9619O, this.f9618N, this.f9640l, this.f9605A, this.f9641m, this.f9642n, this.f9645q, this.f9643o, this.f9646r, this.f9647s, this.f9648t, this.f9654z, this.f9606B, this.f9607C, this.f9611G, this.f9612H, this.f9613I, this.f9653y, this.f9608D, this.f9609E, this.f9610F.m15173a(PostPrivacyUpsellDialogController$EntryPoint.NEWSFEED), new ScrollController(), newsFeedFragment, this.f9650v, this.f9651w, this.f9644p.m14857a(a2), this.f9624T, this.f9614J, this.f9616L, this.f9617M, a2, this.f9623S, this.f9628X);
        newsFeedControllerCallbacksDispatcher.m16511c(new Holder());
        newsFeedControllerCallbacksDispatcher.m16485a(feedType);
        newsFeedControllerCallbacksDispatcher.m16488a(newsFeedFragment);
        newsFeedControllerCallbacksDispatcher.m16505b((Holder) holder);
        newsFeedControllerCallbacksDispatcher.m16498a(this.f9625U);
        newsFeedControllerCallbacksDispatcher.m16489a(newsFeedControllerCallbacksDispatcher);
        newsFeedControllerCallbacksDispatcher.m16478a(newsFeedFragment.getContext());
        newsFeedControllerCallbacksDispatcher.m16490a(this.f9625U);
        newsFeedControllerCallbacksDispatcher.m16500a("native_newsfeed");
        newsFeedControllerCallbacksDispatcher.m16486a((Holder) holder2);
        newsFeedControllerCallbacksDispatcher.m16515g();
        return newsFeedControllerCallbacksDispatcher;
    }
}
