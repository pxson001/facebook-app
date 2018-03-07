package com.facebook.feed.fragment.controllercallbacks;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.api.feedtype.FeedType;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.FbFragmentController;
import com.facebook.common.appstate.AppBackgroundFragmentController;
import com.facebook.common.appstate.AppBackgroundFragmentController.C04792;
import com.facebook.common.appstate.AppBackgroundFragmentController.C04801;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.appstate.OnBackgroundForegroundCallback;
import com.facebook.common.perftest.base.PerfTestConfigBase;
import com.facebook.common.viewport.ViewportEventListener;
import com.facebook.controllercallbacks.api.BaseDispatcher;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.api.SetUp;
import com.facebook.controllercallbacks.api.TearDown;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.controllercallbacks.fragment.ConfigurationChangedCallback;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.OnSaveInstanceStateCallback;
import com.facebook.controllercallbacks.fragment.OnUserVisibleHintCallback;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.controllercallbacks.fragment.StartStopCallbacks;
import com.facebook.controllercallbacks.fragment.ViewCreatedDestroyedCallbacks;
import com.facebook.debug.components.ComponentsConversionController;
import com.facebook.debug.connection.ConnectionViewController;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.animation.AnimationCallback;
import com.facebook.feed.data.FeedDataLoadedCallbacks;
import com.facebook.feed.data.FeedDataLoadedCallbacks.ErrorType;
import com.facebook.feed.data.FeedDataLoadedCallbacks.Location;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.fragment.NewsFeedFragmentDsmController;
import com.facebook.feed.fragment.NewsFeedFragmentOfflineController;
import com.facebook.feed.fragment.controllercallbacks.ErrorViewController.1;
import com.facebook.feed.fragment.controllercallbacks.ErrorViewController.Callback;
import com.facebook.feed.fragment.controllercallbacks.NewsFeedDispatcherFactory.NewsFeedControllerCallbacks;
import com.facebook.feed.fragment.debug.FreshFeedDebugViewController;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerMultiRowInjectedFeedAdapter;
import com.facebook.feed.inlinecomposer.multirow.ScrollAwayComposerNewsfeedController;
import com.facebook.feed.loader.StoryRankingTimeTracker;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.facebook.feed.megaphone.MegaphoneController;
import com.facebook.feed.rows.MultiRowAdapterController;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.ui.PerfTestNewsFeedScrollController;
import com.facebook.feed.ui.controllers.SeeMoreFragmentController;
import com.facebook.feed.util.ConnectivityChangedCallback;
import com.facebook.feed.util.ConnectivityController;
import com.facebook.feed.util.HScrollAutoScrollController;
import com.facebook.feedplugins.storyset.StorySetsViewportEventListener;
import com.facebook.feedplugins.storyset.experiment.ExperimentsForStorySetsExperimentModule;
import com.facebook.goodwill.abtest.ExperimentsForGoodwillAbTestModule;
import com.facebook.goodwill.dailydialogue.adapter.DailyDialogueInjectedFeedAdapter;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.infer.annotation.NoAllocation;
import com.facebook.infer.annotation.PerformanceCritical;
import com.facebook.places.checkin.launcher.PlacePickerResultHandler;
import com.facebook.platformattribution.result.PlatformAttributionResultController;
import com.facebook.privacy.audience.PostPrivacyUpsellDialogFragmentController;
import com.facebook.productionprompts.common.PromptActivityResultHandler;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.rapidfeedback.RapidFeedbackFragmentController;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeViewportEventListener;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.facebook.widget.listview.BasicAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.controllercallbacks.AdapterDataChangedCallback;
import com.facebook.widget.listview.controllercallbacks.ScrollCallback;
import com.facebook.widget.listview.controllercallbacks.ScrollController;
import com.facebook.widget.listview.controllercallbacks.ScrollingFragmentViewHolder;
import javax.annotation.Nullable;

/* compiled from: onBind received unknown action */
public class NewsFeedControllerCallbacksDispatcher extends BaseDispatcher implements OnBackgroundForegroundCallback, ViewportEventListener, ActivityResultCallback, ConfigurationChangedCallback, FragmentCreateDestroyCallbacks, OnSaveInstanceStateCallback, OnUserVisibleHintCallback, ResumePauseCallbacks, StartStopCallbacks, ViewCreatedDestroyedCallbacks, AnimationCallback, FeedDataLoadedCallbacks, Callback, SwipeRefreshController.Callback, TailLoaderController.Callback, AdapterCreatedCallback, ConnectivityChangedCallback, AdapterDataChangedCallback, ScrollCallback {
    private AppBackgroundFragmentController f11147A;
    private ComponentsConversionController f11148B;
    private ComposerActivityController f11149C;
    private ConnectionViewController f11150D;
    private FollowUpUnitController f11151E;
    private NewsFeedFragmentOfflineController f11152F;
    public ViewportMonitorFragmentController<NewsFeedControllerCallbacks> f11153G;
    private StorySetsViewportEventListener f11154H;
    private RedSpaceOptimisticBadgeViewportEventListener f11155I;
    private HScrollAutoScrollController f11156J;
    private AppInstallController<NewsFeedControllerCallbacks> f11157K;
    private RapidFeedbackFragmentController f11158L;
    private PlacePickerResultHandler f11159M;
    private PostPrivacyUpsellDialogFragmentController f11160N;
    private ScrollController<NewsFeedControllerCallbacks> f11161O;
    private NewsFeedFragment f11162P;
    private NewsFeedScreenshotController f11163Q;
    private FeedUnitCollectionController f11164R;
    private MultiRowAdapterController<NewsFeedControllerCallbacks> f11165S;
    private TailLoaderController<NewsFeedControllerCallbacks> f11166T;
    private NativeInjectionLoggerController f11167U;
    private NewsFeedFragmentDsmController f11168V;
    private TopicCustomizationHeaderController f11169W;
    private NewsFeedAdapterConfiguration f11170X;
    private GoodFriendsCustomizationHeaderController f11171Y;
    private ScrollAwayComposerNewsfeedController f11172Z;
    private FbFragmentController<NewsFeedControllerCallbacks> f11173a;
    private NewsFeedViewController f11174b;
    private ProgressBarExperimentsController f11175c;
    private ConnectivityController<NewsFeedControllerCallbacks> f11176d;
    private PerfTestNewsFeedScrollController f11177e;
    private ErrorViewController<NewsFeedControllerCallbacks> f11178f;
    private FreshFeedDebugViewController f11179g;
    private PlatformAttributionResultController f11180h;
    private ReviewComposerResultController f11181i;
    private SwipeRefreshController<NewsFeedControllerCallbacks> f11182j;
    private DataSetUpdatedEventSubscriberController f11183k;
    private PromptActivityResultHandler f11184l;
    private SeeMoreFragmentController f11185m;
    private MenuButtonTooltipTriggerController f11186n;
    public FeedNuxBubbleController f11187o;
    private MegaphoneController f11188p;
    private ImagePrefetcherController f11189q;
    private StoryRankingTimeTracker f11190r;
    private FeedRefreshTriggerController f11191s;
    private DailyDialogueInjectedFeedAdapter f11192t;
    private InlineComposerMultiRowInjectedFeedAdapter f11193u;
    private PreloadingController f11194v;
    private FeedLoggingViewportController f11195w;
    private NewsFeedEventLoggerController f11196x;
    private ProfilePictureRefetcherController f11197y;
    private DeleteStoryController f11198z;

    public NewsFeedControllerCallbacksDispatcher(FbFragmentController<NewsFeedControllerCallbacks> fbFragmentController, NewsFeedViewController newsFeedViewController, ProgressBarExperimentsController progressBarExperimentsController, ConnectivityController<NewsFeedControllerCallbacks> connectivityController, PerfTestNewsFeedScrollController perfTestNewsFeedScrollController, ErrorViewController<NewsFeedControllerCallbacks> errorViewController, FreshFeedDebugViewController freshFeedDebugViewController, PlatformAttributionResultController platformAttributionResultController, ReviewComposerResultController reviewComposerResultController, SwipeRefreshController<NewsFeedControllerCallbacks> swipeRefreshController, DataSetUpdatedEventSubscriberController dataSetUpdatedEventSubscriberController, PromptActivityResultHandler promptActivityResultHandler, SeeMoreFragmentController seeMoreFragmentController, MenuButtonTooltipTriggerController menuButtonTooltipTriggerController, FeedNuxBubbleController feedNuxBubbleController, MegaphoneController megaphoneController, ImagePrefetcherController imagePrefetcherController, StoryRankingTimeTracker storyRankingTimeTracker, FeedRefreshTriggerController feedRefreshTriggerController, DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter, InlineComposerMultiRowInjectedFeedAdapter inlineComposerMultiRowInjectedFeedAdapter, PreloadingController preloadingController, FeedLoggingViewportController feedLoggingViewportController, NewsFeedEventLoggerController newsFeedEventLoggerController, ProfilePictureRefetcherController profilePictureRefetcherController, DeleteStoryController deleteStoryController, AppBackgroundFragmentController appBackgroundFragmentController, ComponentsConversionController componentsConversionController, ComposerActivityController composerActivityController, ConnectionViewController connectionViewController, FollowUpUnitController followUpUnitController, NewsFeedFragmentOfflineController newsFeedFragmentOfflineController, ViewportMonitorFragmentController<NewsFeedControllerCallbacks> viewportMonitorFragmentController, StorySetsViewportEventListener storySetsViewportEventListener, RedSpaceOptimisticBadgeViewportEventListener redSpaceOptimisticBadgeViewportEventListener, HScrollAutoScrollController hScrollAutoScrollController, AppInstallController<NewsFeedControllerCallbacks> appInstallController, RapidFeedbackFragmentController rapidFeedbackFragmentController, PlacePickerResultHandler placePickerResultHandler, PostPrivacyUpsellDialogFragmentController postPrivacyUpsellDialogFragmentController, ScrollController<NewsFeedControllerCallbacks> scrollController, NewsFeedFragment newsFeedFragment, NewsFeedScreenshotController newsFeedScreenshotController, FeedUnitCollectionController feedUnitCollectionController, MultiRowAdapterController<NewsFeedControllerCallbacks> multiRowAdapterController, TailLoaderController<NewsFeedControllerCallbacks> tailLoaderController, NativeInjectionLoggerController nativeInjectionLoggerController, NewsFeedFragmentDsmController newsFeedFragmentDsmController, TopicCustomizationHeaderController topicCustomizationHeaderController, NewsFeedAdapterConfiguration newsFeedAdapterConfiguration, GoodFriendsCustomizationHeaderController goodFriendsCustomizationHeaderController, ScrollAwayComposerNewsfeedController scrollAwayComposerNewsfeedController) {
        this.f11173a = fbFragmentController;
        this.f11174b = newsFeedViewController;
        this.f11175c = progressBarExperimentsController;
        this.f11176d = connectivityController;
        this.f11177e = perfTestNewsFeedScrollController;
        this.f11178f = errorViewController;
        this.f11179g = freshFeedDebugViewController;
        this.f11180h = platformAttributionResultController;
        this.f11181i = reviewComposerResultController;
        this.f11182j = swipeRefreshController;
        this.f11183k = dataSetUpdatedEventSubscriberController;
        this.f11184l = promptActivityResultHandler;
        this.f11185m = seeMoreFragmentController;
        this.f11186n = menuButtonTooltipTriggerController;
        this.f11187o = feedNuxBubbleController;
        this.f11188p = megaphoneController;
        this.f11189q = imagePrefetcherController;
        this.f11190r = storyRankingTimeTracker;
        this.f11191s = feedRefreshTriggerController;
        this.f11192t = dailyDialogueInjectedFeedAdapter;
        this.f11193u = inlineComposerMultiRowInjectedFeedAdapter;
        this.f11194v = preloadingController;
        this.f11195w = feedLoggingViewportController;
        this.f11196x = newsFeedEventLoggerController;
        this.f11197y = profilePictureRefetcherController;
        this.f11198z = deleteStoryController;
        this.f11147A = appBackgroundFragmentController;
        this.f11148B = componentsConversionController;
        this.f11149C = composerActivityController;
        this.f11150D = connectionViewController;
        this.f11151E = followUpUnitController;
        this.f11152F = newsFeedFragmentOfflineController;
        this.f11153G = viewportMonitorFragmentController;
        this.f11154H = storySetsViewportEventListener;
        this.f11155I = redSpaceOptimisticBadgeViewportEventListener;
        this.f11156J = hScrollAutoScrollController;
        this.f11157K = appInstallController;
        this.f11158L = rapidFeedbackFragmentController;
        this.f11159M = placePickerResultHandler;
        this.f11160N = postPrivacyUpsellDialogFragmentController;
        this.f11161O = scrollController;
        this.f11162P = newsFeedFragment;
        this.f11163Q = newsFeedScreenshotController;
        this.f11164R = feedUnitCollectionController;
        this.f11165S = multiRowAdapterController;
        this.f11166T = tailLoaderController;
        this.f11167U = nativeInjectionLoggerController;
        this.f11168V = newsFeedFragmentDsmController;
        this.f11169W = topicCustomizationHeaderController;
        this.f11170X = newsFeedAdapterConfiguration;
        this.f11171Y = goodFriendsCustomizationHeaderController;
        this.f11172Z = scrollAwayComposerNewsfeedController;
    }

    public final void m16515g() {
        NewsFeedViewController newsFeedViewController;
        ProgressBarExperimentsController progressBarExperimentsController;
        ConnectivityController connectivityController;
        ErrorViewController errorViewController;
        FreshFeedDebugViewController freshFeedDebugViewController;
        PlatformAttributionResultController platformAttributionResultController;
        ReviewComposerResultController reviewComposerResultController;
        SwipeRefreshController swipeRefreshController;
        DataSetUpdatedEventSubscriberController dataSetUpdatedEventSubscriberController;
        PromptActivityResultHandler promptActivityResultHandler;
        SeeMoreFragmentController seeMoreFragmentController;
        MenuButtonTooltipTriggerController menuButtonTooltipTriggerController;
        FeedNuxBubbleController feedNuxBubbleController;
        MegaphoneController megaphoneController;
        ImagePrefetcherController imagePrefetcherController;
        FeedRefreshTriggerController feedRefreshTriggerController;
        InlineComposerMultiRowInjectedFeedAdapter inlineComposerMultiRowInjectedFeedAdapter;
        PreloadingController preloadingController;
        FeedLoggingViewportController feedLoggingViewportController;
        NewsFeedEventLoggerController newsFeedEventLoggerController;
        ProfilePictureRefetcherController profilePictureRefetcherController;
        DeleteStoryController deleteStoryController;
        AppBackgroundFragmentController appBackgroundFragmentController;
        ComponentsConversionController componentsConversionController;
        ComposerActivityController composerActivityController;
        ConnectionViewController connectionViewController;
        FollowUpUnitController followUpUnitController;
        NewsFeedFragmentOfflineController newsFeedFragmentOfflineController;
        ViewportMonitorFragmentController viewportMonitorFragmentController;
        StorySetsViewportEventListener storySetsViewportEventListener;
        RedSpaceOptimisticBadgeViewportEventListener redSpaceOptimisticBadgeViewportEventListener;
        HScrollAutoScrollController hScrollAutoScrollController;
        AppInstallController appInstallController;
        RapidFeedbackFragmentController rapidFeedbackFragmentController;
        PlacePickerResultHandler placePickerResultHandler;
        PostPrivacyUpsellDialogFragmentController postPrivacyUpsellDialogFragmentController;
        ScrollController scrollController;
        NewsFeedFragment newsFeedFragment;
        NewsFeedScreenshotController newsFeedScreenshotController;
        FeedUnitCollectionController feedUnitCollectionController;
        MultiRowAdapterController multiRowAdapterController;
        TailLoaderController tailLoaderController;
        NativeInjectionLoggerController nativeInjectionLoggerController;
        NewsFeedFragmentDsmController newsFeedFragmentDsmController;
        TopicCustomizationHeaderController topicCustomizationHeaderController;
        NewsFeedAdapterConfiguration newsFeedAdapterConfiguration;
        GoodFriendsCustomizationHeaderController goodFriendsCustomizationHeaderController;
        ScrollAwayComposerNewsfeedController scrollAwayComposerNewsfeedController = null;
        this.f11173a = this.f11173a.kJ_() ? this.f11173a : null;
        if (this.f11174b.kJ_()) {
            newsFeedViewController = this.f11174b;
        } else {
            newsFeedViewController = null;
        }
        this.f11174b = newsFeedViewController;
        if (this.f11175c.kJ_()) {
            progressBarExperimentsController = this.f11175c;
        } else {
            progressBarExperimentsController = null;
        }
        this.f11175c = progressBarExperimentsController;
        if (this.f11176d.kJ_()) {
            connectivityController = this.f11176d;
        } else {
            connectivityController = null;
        }
        this.f11176d = connectivityController;
        PerfTestNewsFeedScrollController perfTestNewsFeedScrollController = this.f11177e;
        if (PerfTestConfigBase.m2938a()) {
            perfTestNewsFeedScrollController = this.f11177e;
        } else {
            perfTestNewsFeedScrollController = null;
        }
        this.f11177e = perfTestNewsFeedScrollController;
        if (this.f11178f.kJ_()) {
            errorViewController = this.f11178f;
        } else {
            errorViewController = null;
        }
        this.f11178f = errorViewController;
        if (this.f11179g.kJ_()) {
            freshFeedDebugViewController = this.f11179g;
        } else {
            freshFeedDebugViewController = null;
        }
        this.f11179g = freshFeedDebugViewController;
        if (this.f11180h.kJ_()) {
            platformAttributionResultController = this.f11180h;
        } else {
            platformAttributionResultController = null;
        }
        this.f11180h = platformAttributionResultController;
        if (this.f11181i.kJ_()) {
            reviewComposerResultController = this.f11181i;
        } else {
            reviewComposerResultController = null;
        }
        this.f11181i = reviewComposerResultController;
        if (this.f11182j.kJ_()) {
            swipeRefreshController = this.f11182j;
        } else {
            swipeRefreshController = null;
        }
        this.f11182j = swipeRefreshController;
        if (this.f11183k.kJ_()) {
            dataSetUpdatedEventSubscriberController = this.f11183k;
        } else {
            dataSetUpdatedEventSubscriberController = null;
        }
        this.f11183k = dataSetUpdatedEventSubscriberController;
        if (this.f11184l.kJ_()) {
            promptActivityResultHandler = this.f11184l;
        } else {
            promptActivityResultHandler = null;
        }
        this.f11184l = promptActivityResultHandler;
        if (this.f11185m.kJ_()) {
            seeMoreFragmentController = this.f11185m;
        } else {
            seeMoreFragmentController = null;
        }
        this.f11185m = seeMoreFragmentController;
        if (this.f11186n.kJ_()) {
            menuButtonTooltipTriggerController = this.f11186n;
        } else {
            menuButtonTooltipTriggerController = null;
        }
        this.f11186n = menuButtonTooltipTriggerController;
        if (this.f11187o.kJ_()) {
            feedNuxBubbleController = this.f11187o;
        } else {
            feedNuxBubbleController = null;
        }
        this.f11187o = feedNuxBubbleController;
        if (this.f11188p.kJ_()) {
            megaphoneController = this.f11188p;
        } else {
            megaphoneController = null;
        }
        this.f11188p = megaphoneController;
        if (this.f11189q.kJ_()) {
            imagePrefetcherController = this.f11189q;
        } else {
            imagePrefetcherController = null;
        }
        this.f11189q = imagePrefetcherController;
        StoryRankingTimeTracker storyRankingTimeTracker = this.f11190r;
        boolean z = false;
        if (!FeedType.f5039b.equals(storyRankingTimeTracker.f10424g) || !storyRankingTimeTracker.f10421d.mo596a(ExperimentsForNewsFeedAbTestModule.f5083J, false)) {
            z = storyRankingTimeTracker.f10421d.mo596a(ExperimentsForNewsFeedAbTestModule.f5092S, false);
        } else if (storyRankingTimeTracker.f10422e.m9084c(false) && storyRankingTimeTracker.f10422e.m9083b(false)) {
            z = true;
        }
        if (z) {
            storyRankingTimeTracker = this.f11190r;
        } else {
            storyRankingTimeTracker = null;
        }
        this.f11190r = storyRankingTimeTracker;
        if (this.f11191s.kJ_()) {
            feedRefreshTriggerController = this.f11191s;
        } else {
            feedRefreshTriggerController = null;
        }
        this.f11191s = feedRefreshTriggerController;
        DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter = this.f11192t;
        z = false;
        if (dailyDialogueInjectedFeedAdapter.f10239o.mo596a(ExperimentsForGoodwillAbTestModule.f10261a, false) || dailyDialogueInjectedFeedAdapter.f10239o.mo596a(ExperimentsForGoodwillAbTestModule.f10264d, false)) {
            z = true;
        }
        if (z) {
            dailyDialogueInjectedFeedAdapter = this.f11192t;
        } else {
            dailyDialogueInjectedFeedAdapter = null;
        }
        this.f11192t = dailyDialogueInjectedFeedAdapter;
        if (1 != 0) {
            inlineComposerMultiRowInjectedFeedAdapter = this.f11193u;
        } else {
            inlineComposerMultiRowInjectedFeedAdapter = null;
        }
        this.f11193u = inlineComposerMultiRowInjectedFeedAdapter;
        if (this.f11194v.kJ_()) {
            preloadingController = this.f11194v;
        } else {
            preloadingController = null;
        }
        this.f11194v = preloadingController;
        if (this.f11195w.kJ_()) {
            feedLoggingViewportController = this.f11195w;
        } else {
            feedLoggingViewportController = null;
        }
        this.f11195w = feedLoggingViewportController;
        if (this.f11196x.kJ_()) {
            newsFeedEventLoggerController = this.f11196x;
        } else {
            newsFeedEventLoggerController = null;
        }
        this.f11196x = newsFeedEventLoggerController;
        if (this.f11197y.kJ_()) {
            profilePictureRefetcherController = this.f11197y;
        } else {
            profilePictureRefetcherController = null;
        }
        this.f11197y = profilePictureRefetcherController;
        if (this.f11198z.kJ_()) {
            deleteStoryController = this.f11198z;
        } else {
            deleteStoryController = null;
        }
        this.f11198z = deleteStoryController;
        if (this.f11147A.kJ_()) {
            appBackgroundFragmentController = this.f11147A;
        } else {
            appBackgroundFragmentController = null;
        }
        this.f11147A = appBackgroundFragmentController;
        if (this.f11148B.kJ_()) {
            componentsConversionController = this.f11148B;
        } else {
            componentsConversionController = null;
        }
        this.f11148B = componentsConversionController;
        if (this.f11149C.kJ_()) {
            composerActivityController = this.f11149C;
        } else {
            composerActivityController = null;
        }
        this.f11149C = composerActivityController;
        if (this.f11150D.kJ_()) {
            connectionViewController = this.f11150D;
        } else {
            connectionViewController = null;
        }
        this.f11150D = connectionViewController;
        if (this.f11151E.kJ_()) {
            followUpUnitController = this.f11151E;
        } else {
            followUpUnitController = null;
        }
        this.f11151E = followUpUnitController;
        if (this.f11152F.kJ_()) {
            newsFeedFragmentOfflineController = this.f11152F;
        } else {
            newsFeedFragmentOfflineController = null;
        }
        this.f11152F = newsFeedFragmentOfflineController;
        if (1 != 0) {
            viewportMonitorFragmentController = this.f11153G;
        } else {
            viewportMonitorFragmentController = null;
        }
        this.f11153G = viewportMonitorFragmentController;
        if (this.f11154H.f10086b.f10088a.mo593a(Liveness.Live, ExposureLogging.Off, ExperimentsForStorySetsExperimentModule.f11318a, false)) {
            storySetsViewportEventListener = this.f11154H;
        } else {
            storySetsViewportEventListener = null;
        }
        this.f11154H = storySetsViewportEventListener;
        if (this.f11155I.m15189a()) {
            redSpaceOptimisticBadgeViewportEventListener = this.f11155I;
        } else {
            redSpaceOptimisticBadgeViewportEventListener = null;
        }
        this.f11155I = redSpaceOptimisticBadgeViewportEventListener;
        if (1 != 0) {
            hScrollAutoScrollController = this.f11156J;
        } else {
            hScrollAutoScrollController = null;
        }
        this.f11156J = hScrollAutoScrollController;
        if (this.f11157K.kJ_()) {
            appInstallController = this.f11157K;
        } else {
            appInstallController = null;
        }
        this.f11157K = appInstallController;
        if (this.f11158L.kJ_()) {
            rapidFeedbackFragmentController = this.f11158L;
        } else {
            rapidFeedbackFragmentController = null;
        }
        this.f11158L = rapidFeedbackFragmentController;
        if (this.f11159M.kJ_()) {
            placePickerResultHandler = this.f11159M;
        } else {
            placePickerResultHandler = null;
        }
        this.f11159M = placePickerResultHandler;
        if (this.f11160N.kJ_()) {
            postPrivacyUpsellDialogFragmentController = this.f11160N;
        } else {
            postPrivacyUpsellDialogFragmentController = null;
        }
        this.f11160N = postPrivacyUpsellDialogFragmentController;
        if (this.f11161O.kJ_()) {
            scrollController = this.f11161O;
        } else {
            scrollController = null;
        }
        this.f11161O = scrollController;
        if (1 != 0) {
            newsFeedFragment = this.f11162P;
        } else {
            newsFeedFragment = null;
        }
        this.f11162P = newsFeedFragment;
        if (this.f11163Q.kJ_()) {
            newsFeedScreenshotController = this.f11163Q;
        } else {
            newsFeedScreenshotController = null;
        }
        this.f11163Q = newsFeedScreenshotController;
        if (this.f11164R.kJ_()) {
            feedUnitCollectionController = this.f11164R;
        } else {
            feedUnitCollectionController = null;
        }
        this.f11164R = feedUnitCollectionController;
        if (this.f11165S.kJ_()) {
            multiRowAdapterController = this.f11165S;
        } else {
            multiRowAdapterController = null;
        }
        this.f11165S = multiRowAdapterController;
        if (this.f11166T.kJ_()) {
            tailLoaderController = this.f11166T;
        } else {
            tailLoaderController = null;
        }
        this.f11166T = tailLoaderController;
        if (this.f11167U.kJ_()) {
            nativeInjectionLoggerController = this.f11167U;
        } else {
            nativeInjectionLoggerController = null;
        }
        this.f11167U = nativeInjectionLoggerController;
        if (this.f11168V.kJ_()) {
            newsFeedFragmentDsmController = this.f11168V;
        } else {
            newsFeedFragmentDsmController = null;
        }
        this.f11168V = newsFeedFragmentDsmController;
        if (this.f11169W.kJ_()) {
            topicCustomizationHeaderController = this.f11169W;
        } else {
            topicCustomizationHeaderController = null;
        }
        this.f11169W = topicCustomizationHeaderController;
        if (this.f11170X.kJ_()) {
            newsFeedAdapterConfiguration = this.f11170X;
        } else {
            newsFeedAdapterConfiguration = null;
        }
        this.f11170X = newsFeedAdapterConfiguration;
        if (this.f11171Y.kJ_()) {
            goodFriendsCustomizationHeaderController = this.f11171Y;
        } else {
            goodFriendsCustomizationHeaderController = null;
        }
        this.f11171Y = goodFriendsCustomizationHeaderController;
        if (this.f11172Z.kJ_()) {
            scrollAwayComposerNewsfeedController = this.f11172Z;
        }
        this.f11172Z = scrollAwayComposerNewsfeedController;
    }

    public final void m16489a(NewsFeedControllerCallbacksDispatcher newsFeedControllerCallbacksDispatcher) {
        if (this.f11173a != null) {
            this.f11173a.f11200a = newsFeedControllerCallbacksDispatcher;
        }
        if (this.f11176d != null) {
            this.f11176d.f9891c = newsFeedControllerCallbacksDispatcher;
        }
        if (this.f11178f != null) {
            this.f11178f.f9915e = newsFeedControllerCallbacksDispatcher;
        }
        if (this.f11182j != null) {
            this.f11182j.f10154f = newsFeedControllerCallbacksDispatcher;
        }
        if (this.f11147A != null) {
            this.f11147A.f9831c = newsFeedControllerCallbacksDispatcher;
        }
        if (this.f11153G != null) {
            this.f11153G.f10057f = newsFeedControllerCallbacksDispatcher;
        }
        if (this.f11157K != null) {
            this.f11157K.f9917b = newsFeedControllerCallbacksDispatcher;
        }
        if (this.f11161O != null) {
            this.f11161O.f11212c = newsFeedControllerCallbacksDispatcher;
        }
        if (this.f11165S != null) {
            this.f11165S.f11219g = newsFeedControllerCallbacksDispatcher;
        }
        if (this.f11166T != null) {
            this.f11166T.f10387c = newsFeedControllerCallbacksDispatcher;
        }
    }

    public final void mo1951a(BasicAdapter basicAdapter) {
        if (this.f11148B != null) {
            this.f11148B.mo1951a(basicAdapter);
        }
        if (this.f11153G != null) {
            this.f11153G.mo1951a(basicAdapter);
        }
        if (this.f11164R != null) {
            this.f11164R.mo1951a(basicAdapter);
        }
        if (this.f11167U != null) {
            this.f11167U.mo1951a(basicAdapter);
        }
    }

    public final void mo1900b(boolean z) {
        if (this.f11178f != null) {
            this.f11178f.mo1900b(z);
        }
        if (this.f11182j != null) {
            this.f11182j.mo1900b(z);
        }
        if (this.f11162P != null) {
            this.f11162P.mo1900b(z);
        }
    }

    @SetUp
    public final void mo1264c() {
        if (this.f11179g != null) {
            this.f11179g.mo1264c();
        }
        if (this.f11185m != null) {
            this.f11185m.mo1264c();
        }
        if (this.f11189q != null) {
            this.f11189q.mo1264c();
        }
        if (this.f11191s != null) {
            this.f11191s.mo1264c();
        }
        if (this.f11192t != null) {
            this.f11192t.mo1264c();
        }
        if (this.f11193u != null) {
            this.f11193u.mo1264c();
        }
        if (this.f11194v != null) {
            this.f11194v.mo1264c();
        }
        if (this.f11195w != null) {
            this.f11195w.mo1264c();
        }
        if (this.f11196x != null) {
            this.f11196x.mo1264c();
        }
        if (this.f11198z != null) {
            this.f11198z.mo1264c();
        }
        if (this.f11148B != null) {
            this.f11148B.mo1264c();
        }
        if (this.f11149C != null) {
            this.f11149C.mo1264c();
        }
        if (this.f11150D != null) {
            this.f11150D.mo1264c();
        }
        if (this.f11151E != null) {
            this.f11151E.mo1264c();
        }
        if (this.f11152F != null) {
            this.f11152F.mo1264c();
        }
        if (this.f11153G != null) {
            this.f11153G.mo1264c();
        }
        if (this.f11157K != null) {
            this.f11157K.mo1264c();
        }
        if (this.f11163Q != null) {
            this.f11163Q.mo1264c();
        }
        if (this.f11165S != null) {
            this.f11165S.mo1264c();
        }
        if (this.f11168V != null) {
            this.f11168V.mo1264c();
        }
    }

    @TearDown
    public final void mo1265d() {
        if (this.f11168V != null) {
            this.f11168V.mo1265d();
        }
        if (this.f11165S != null) {
            this.f11165S.mo1265d();
        }
        if (this.f11163Q != null) {
            this.f11163Q.mo1265d();
        }
        if (this.f11157K != null) {
            this.f11157K.mo1265d();
        }
        if (this.f11153G != null) {
            this.f11153G.mo1265d();
        }
        if (this.f11152F != null) {
            this.f11152F.mo1265d();
        }
        if (this.f11151E != null) {
            this.f11151E.mo1265d();
        }
        if (this.f11150D != null) {
            this.f11150D.mo1265d();
        }
        if (this.f11149C != null) {
            this.f11149C.mo1265d();
        }
        if (this.f11148B != null) {
            this.f11148B.mo1265d();
        }
        if (this.f11198z != null) {
            this.f11198z.mo1265d();
        }
        if (this.f11196x != null) {
            this.f11196x.mo1265d();
        }
        if (this.f11195w != null) {
            this.f11195w.mo1265d();
        }
        if (this.f11194v != null) {
            this.f11194v.mo1265d();
        }
        if (this.f11193u != null) {
            this.f11193u.mo1265d();
        }
        if (this.f11192t != null) {
            this.f11192t.mo1265d();
        }
        if (this.f11191s != null) {
            this.f11191s.mo1265d();
        }
        if (this.f11189q != null) {
            this.f11189q.mo1265d();
        }
        if (this.f11185m != null) {
            this.f11185m.mo1265d();
        }
        if (this.f11179g != null) {
            this.f11179g.mo1265d();
        }
    }

    @SetUp
    public final void mo2119e() {
        if (this.f11161O != null) {
            this.f11161O.mo2119e();
        }
    }

    @TearDown
    public final void mo2120f() {
        if (this.f11161O != null) {
            this.f11161O.mo2120f();
        }
    }

    public final void mo1948a(boolean z) {
        if (this.f11187o != null) {
            this.f11187o.mo1948a(z);
        }
        if (this.f11195w != null) {
            this.f11195w.mo1948a(z);
        }
        if (this.f11153G != null) {
            this.f11153G.mo1948a(z);
        }
    }

    public final void mo2118a(Bundle bundle) {
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (this.f11177e != null) {
            this.f11177e.mo1262a(scrollingViewProxy, i);
        }
        if (this.f11187o != null) {
            this.f11187o.mo1262a(scrollingViewProxy, i);
        }
        if (this.f11189q != null) {
            this.f11189q.mo1262a(scrollingViewProxy, i);
        }
        if (this.f11152F != null) {
            this.f11152F.mo1262a(scrollingViewProxy, i);
        }
        if (this.f11153G != null) {
            this.f11153G.mo1262a(scrollingViewProxy, i);
        }
        if (this.f11165S != null) {
            this.f11165S.mo1262a(scrollingViewProxy, i);
        }
        if (this.f11168V != null) {
            this.f11168V.mo1262a(scrollingViewProxy, i);
        }
        if (this.f11162P != null) {
            this.f11162P.mo1262a(scrollingViewProxy, i);
        }
    }

    @NoAllocation
    @PerformanceCritical
    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        if (this.f11177e != null) {
            this.f11177e.mo1263a(scrollingViewProxy, i, i2, i3);
        }
        if (this.f11187o != null) {
            this.f11187o.mo1263a(scrollingViewProxy, i, i2, i3);
        }
        if (this.f11189q != null) {
            this.f11189q.mo1263a(scrollingViewProxy, i, i2, i3);
        }
        if (this.f11152F != null) {
            this.f11152F.mo1263a(scrollingViewProxy, i, i2, i3);
        }
        if (this.f11153G != null) {
            this.f11153G.mo1263a(scrollingViewProxy, i, i2, i3);
        }
        if (this.f11165S != null) {
            this.f11165S.mo1263a(scrollingViewProxy, i, i2, i3);
        }
        if (this.f11168V != null) {
            this.f11168V.mo1263a(scrollingViewProxy, i, i2, i3);
        }
        if (this.f11162P != null) {
            this.f11162P.mo1263a(scrollingViewProxy, i, i2, i3);
        }
    }

    @SetUp
    public final void m16481a(Fragment fragment, @Nullable Bundle bundle) {
        if (this.f11173a != null) {
            this.f11173a.m16520a(fragment);
        }
        if (this.f11194v != null) {
            PreloadingController preloadingController = this.f11194v;
            preloadingController.f9788f = preloadingController.f9785c.m14816a(VideoPrefetchLocation.NEWSFEED);
        }
        if (this.f11196x != null) {
            NewsFeedEventLoggerController newsFeedEventLoggerController = this.f11196x;
            newsFeedEventLoggerController.f9800b = fragment;
            newsFeedEventLoggerController.f9799a.m4409a(newsFeedEventLoggerController.f9800b, Event.FRAGMENT_CREATED);
        }
        if (this.f11197y != null) {
            ProfilePictureRefetcherController profilePictureRefetcherController = this.f11197y;
            profilePictureRefetcherController.f9801a.m14832a(profilePictureRefetcherController.f9803c);
        }
        if (this.f11147A != null) {
            AppBackgroundFragmentController appBackgroundFragmentController = this.f11147A;
            appBackgroundFragmentController.f9830b = appBackgroundFragmentController.f9829a.m2951a().mo506a(AppStateManager.f1111c, new C04792(appBackgroundFragmentController)).mo506a(AppStateManager.f1110b, new C04801(appBackgroundFragmentController)).mo503a();
            appBackgroundFragmentController.f9830b.m3296b();
        }
        if (this.f11149C != null) {
            ComposerActivityController composerActivityController = this.f11149C;
            composerActivityController.f9852g.mo1953a(1756, ((FbFragment) composerActivityController.f9853h.f10429a).ao());
        }
        if (this.f11150D != null) {
            this.f11150D.f9887j = fragment;
        }
        if (this.f11153G != null) {
            ViewportMonitorFragmentController viewportMonitorFragmentController = this.f11153G;
            viewportMonitorFragmentController.f10052a.m15147a(viewportMonitorFragmentController.f10057f);
        }
    }

    @TearDown
    public final void mo1949b() {
        if (this.f11153G != null) {
            this.f11153G.mo1949b();
        }
        if (this.f11150D != null) {
            this.f11150D.mo1949b();
        }
        if (this.f11149C != null) {
            this.f11149C.mo1949b();
        }
        if (this.f11147A != null) {
            this.f11147A.mo1949b();
        }
        if (this.f11197y != null) {
            this.f11197y.mo1949b();
        }
        if (this.f11196x != null) {
            this.f11196x.mo1949b();
        }
        if (this.f11194v != null) {
            this.f11194v.mo1949b();
        }
        if (this.f11176d != null) {
            this.f11176d.mo1949b();
        }
        if (this.f11173a != null) {
            this.f11173a.mo1949b();
        }
    }

    @SetUp
    public final void mo1886a(View view) {
        if (this.f11174b != null) {
            this.f11174b.mo1886a(view);
        }
        if (this.f11175c != null) {
            this.f11175c.mo1886a(view);
        }
        if (this.f11176d != null) {
            this.f11176d.mo1886a(view);
        }
        if (this.f11178f != null) {
            this.f11178f.mo1886a(view);
        }
        if (this.f11182j != null) {
            this.f11182j.mo1886a(view);
        }
        if (this.f11187o != null) {
            this.f11187o.mo1886a(view);
        }
        if (this.f11191s != null) {
            this.f11191s.mo1886a(view);
        }
        if (this.f11193u != null) {
            this.f11193u.mo1886a(view);
        }
        if (this.f11196x != null) {
            this.f11196x.mo1886a(view);
        }
        if (this.f11157K != null) {
            this.f11157K.mo1886a(view);
        }
        if (this.f11160N != null) {
            this.f11160N.mo1886a(view);
        }
        if (this.f11165S != null) {
            this.f11165S.mo1886a(view);
        }
        if (this.f11170X != null) {
            this.f11170X.mo1886a(view);
        }
        if (this.f11172Z != null) {
            this.f11172Z.mo1886a(view);
        }
        if (this.f11162P != null) {
            this.f11162P.mo1886a(view);
        }
    }

    @TearDown
    public final void kG_() {
        if (this.f11162P != null) {
            this.f11162P.kG_();
        }
        if (this.f11172Z != null) {
            this.f11172Z.kG_();
        }
        if (this.f11170X != null) {
            this.f11170X.kG_();
        }
        if (this.f11165S != null) {
            this.f11165S.kG_();
        }
        if (this.f11160N != null) {
            this.f11160N.kG_();
        }
        if (this.f11157K != null) {
            this.f11157K.kG_();
        }
        if (this.f11196x != null) {
            this.f11196x.kG_();
        }
        if (this.f11193u != null) {
            this.f11193u.kG_();
        }
        if (this.f11191s != null) {
            this.f11191s.kG_();
        }
        if (this.f11187o != null) {
            this.f11187o.kG_();
        }
        if (this.f11182j != null) {
            this.f11182j.kG_();
        }
        if (this.f11178f != null) {
            this.f11178f.kG_();
        }
        if (this.f11176d != null) {
            this.f11176d.kG_();
        }
        if (this.f11175c != null) {
            this.f11175c.kG_();
        }
        if (this.f11174b != null) {
            this.f11174b.kG_();
        }
    }

    @SetUp
    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        if (this.f11179g != null) {
            this.f11179g.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11181i != null) {
            this.f11181i.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11183k != null) {
            this.f11183k.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11185m != null) {
            this.f11185m.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11186n != null) {
            this.f11186n.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11188p != null) {
            this.f11188p.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11189q != null) {
            this.f11189q.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11191s != null) {
            this.f11191s.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11194v != null) {
            this.f11194v.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11198z != null) {
            this.f11198z.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11164R != null) {
            this.f11164R.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11169W != null) {
            this.f11169W.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
        if (this.f11162P != null) {
            this.f11162P.mo1889a(hasMultiRow, scrollingViewProxy, feedEnvironment);
        }
    }

    @TearDown
    public final void kF_() {
        if (this.f11162P != null) {
            this.f11162P.kF_();
        }
        if (this.f11169W != null) {
            this.f11169W.kF_();
        }
        if (this.f11164R != null) {
            this.f11164R.kF_();
        }
        if (this.f11198z != null) {
            this.f11198z.kF_();
        }
        if (this.f11194v != null) {
            this.f11194v.kF_();
        }
        if (this.f11191s != null) {
            this.f11191s.kF_();
        }
        if (this.f11189q != null) {
            this.f11189q.kF_();
        }
        if (this.f11188p != null) {
            this.f11188p.kF_();
        }
        if (this.f11186n != null) {
            this.f11186n.kF_();
        }
        if (this.f11185m != null) {
            this.f11185m.kF_();
        }
        if (this.f11183k != null) {
            this.f11183k.kF_();
        }
        if (this.f11181i != null) {
            this.f11181i.kF_();
        }
        if (this.f11179g != null) {
            this.f11179g.kF_();
        }
    }

    public final void mo1947a(Configuration configuration) {
        if (this.f11187o != null) {
            this.f11187o.mo1947a(configuration);
        }
        if (this.f11194v != null) {
            this.f11194v.mo1947a(configuration);
        }
        if (this.f11161O != null) {
            this.f11161O.mo1947a(configuration);
        }
        if (this.f11165S != null) {
            this.f11165S.mo1947a(configuration);
        }
    }

    public final void mo1899b(View view) {
        if (this.f11157K != null) {
            this.f11157K.mo1899b(view);
        }
        if (this.f11162P != null) {
            this.f11162P.mo1899b(view);
        }
    }

    public final void mo1968a(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        if (this.f11190r != null) {
            this.f11190r.mo1968a(scrollingViewProxy, obj, i);
        }
        if (this.f11192t != null) {
            this.f11192t.mo1968a(scrollingViewProxy, obj, i);
        }
        if (this.f11193u != null) {
            this.f11193u.mo1968a(scrollingViewProxy, obj, i);
        }
        if (this.f11195w != null) {
            this.f11195w.mo1968a(scrollingViewProxy, obj, i);
        }
        if (this.f11154H != null) {
            this.f11154H.mo1968a(scrollingViewProxy, obj, i);
        }
        if (this.f11155I != null) {
            this.f11155I.mo1968a(scrollingViewProxy, obj, i);
        }
        if (this.f11156J != null) {
            this.f11156J.mo1968a(scrollingViewProxy, obj, i);
        }
    }

    public final void mo1970a(Object obj) {
        if (this.f11190r != null) {
            this.f11190r.mo1970a(obj);
        }
        if (this.f11192t != null) {
            this.f11192t.mo1970a(obj);
        }
        if (this.f11193u != null) {
            this.f11193u.mo1970a(obj);
        }
        if (this.f11195w != null) {
            this.f11195w.mo1970a(obj);
        }
        if (this.f11154H != null) {
            this.f11154H.mo1970a(obj);
        }
        if (this.f11155I != null) {
            this.f11155I.mo1970a(obj);
        }
        if (this.f11156J != null) {
            this.f11156J.mo1970a(obj);
        }
    }

    public final void mo1969a(ScrollingViewProxy scrollingViewProxy, Object obj, int i, int i2) {
        if (this.f11190r != null) {
            this.f11190r.mo1969a(scrollingViewProxy, obj, i, i2);
        }
        if (this.f11192t != null) {
            this.f11192t.mo1969a(scrollingViewProxy, obj, i, i2);
        }
        if (this.f11193u != null) {
            this.f11193u.mo1969a(scrollingViewProxy, obj, i, i2);
        }
        if (this.f11195w != null) {
            this.f11195w.mo1969a(scrollingViewProxy, obj, i, i2);
        }
        if (this.f11154H != null) {
            this.f11154H.mo1969a(scrollingViewProxy, obj, i, i2);
        }
        if (this.f11155I != null) {
            this.f11155I.mo1969a(scrollingViewProxy, obj, i, i2);
        }
        if (this.f11156J != null) {
            this.f11156J.mo1969a(scrollingViewProxy, obj, i, i2);
        }
    }

    public final void mo1973b(Object obj) {
        if (this.f11190r != null) {
            this.f11190r.mo1973b(obj);
        }
        if (this.f11192t != null) {
            this.f11192t.mo1973b(obj);
        }
        if (this.f11193u != null) {
            this.f11193u.mo1973b(obj);
        }
        if (this.f11195w != null) {
            this.f11195w.mo1973b(obj);
        }
        if (this.f11154H != null) {
            this.f11154H.mo1973b(obj);
        }
        if (this.f11155I != null) {
            this.f11155I.mo1973b(obj);
        }
        if (this.f11156J != null) {
            this.f11156J.mo1973b(obj);
        }
    }

    public final void mo1972b(ScrollingViewProxy scrollingViewProxy, Object obj, int i) {
        if (this.f11190r != null) {
            this.f11190r.mo1972b(scrollingViewProxy, obj, i);
        }
        if (this.f11192t != null) {
            this.f11192t.mo1972b(scrollingViewProxy, obj, i);
        }
        if (this.f11193u != null) {
            this.f11193u.mo1972b(scrollingViewProxy, obj, i);
        }
        if (this.f11195w != null) {
            this.f11195w.mo1972b(scrollingViewProxy, obj, i);
        }
        if (this.f11154H != null) {
            this.f11154H.mo1972b(scrollingViewProxy, obj, i);
        }
        if (this.f11155I != null) {
            this.f11155I.mo1972b(scrollingViewProxy, obj, i);
        }
        if (this.f11156J != null) {
            this.f11156J.mo1972b(scrollingViewProxy, obj, i);
        }
    }

    public final void mo1967a(ScrollingViewProxy scrollingViewProxy) {
        if (this.f11190r != null) {
            this.f11190r.mo1967a(scrollingViewProxy);
        }
        if (this.f11192t != null) {
            this.f11192t.mo1967a(scrollingViewProxy);
        }
        if (this.f11193u != null) {
            this.f11193u.mo1967a(scrollingViewProxy);
        }
        if (this.f11195w != null) {
            this.f11195w.mo1967a(scrollingViewProxy);
        }
        if (this.f11154H != null) {
            this.f11154H.mo1967a(scrollingViewProxy);
        }
        if (this.f11155I != null) {
            this.f11155I.mo1967a(scrollingViewProxy);
        }
        if (this.f11156J != null) {
            this.f11156J.mo1967a(scrollingViewProxy);
        }
    }

    public final void mo1971b(ScrollingViewProxy scrollingViewProxy) {
        if (this.f11190r != null) {
            this.f11190r.mo1971b(scrollingViewProxy);
        }
        if (this.f11192t != null) {
            this.f11192t.mo1971b(scrollingViewProxy);
        }
        if (this.f11193u != null) {
            this.f11193u.mo1971b(scrollingViewProxy);
        }
        if (this.f11195w != null) {
            this.f11195w.mo1971b(scrollingViewProxy);
        }
        if (this.f11154H != null) {
            this.f11154H.mo1971b(scrollingViewProxy);
        }
        if (this.f11155I != null) {
            this.f11155I.mo1971b(scrollingViewProxy);
        }
        if (this.f11156J != null) {
            this.f11156J.mo1971b(scrollingViewProxy);
        }
    }

    public final void mo1966a(SimpleArrayMap<Object, Object> simpleArrayMap) {
        if (this.f11190r != null) {
            this.f11190r.mo1966a((SimpleArrayMap) simpleArrayMap);
        }
        if (this.f11192t != null) {
            this.f11192t.mo1966a((SimpleArrayMap) simpleArrayMap);
        }
        if (this.f11193u != null) {
            this.f11193u.mo1966a((SimpleArrayMap) simpleArrayMap);
        }
        if (this.f11195w != null) {
            this.f11195w.mo1966a((SimpleArrayMap) simpleArrayMap);
        }
        if (this.f11154H != null) {
            this.f11154H.mo1966a((SimpleArrayMap) simpleArrayMap);
        }
        if (this.f11155I != null) {
            this.f11155I.mo1966a((SimpleArrayMap) simpleArrayMap);
        }
        if (this.f11156J != null) {
            this.f11156J.mo1966a((SimpleArrayMap) simpleArrayMap);
        }
    }

    public final void kH_() {
        if (this.f11162P != null) {
            this.f11162P.kH_();
        }
    }

    public final void kI_() {
        if (this.f11162P != null) {
            this.f11162P.kI_();
        }
    }

    public final void mo1941a(int i, int i2, Intent intent) {
        if (this.f11180h != null) {
            this.f11180h.mo1941a(i, i2, intent);
        }
        if (this.f11181i != null) {
            this.f11181i.mo1941a(i, i2, intent);
        }
        if (this.f11184l != null) {
            this.f11184l.mo1941a(i, i2, intent);
        }
        if (this.f11149C != null) {
            this.f11149C.mo1941a(i, i2, intent);
        }
        if (this.f11158L != null) {
            this.f11158L.mo1941a(i, i2, intent);
        }
        if (this.f11159M != null) {
            this.f11159M.mo1941a(i, i2, intent);
        }
        if (this.f11160N != null) {
            this.f11160N.mo1941a(i, i2, intent);
        }
        if (this.f11169W != null) {
            this.f11169W.mo1941a(i, i2, intent);
        }
        if (this.f11171Y != null) {
            this.f11171Y.mo1941a(i, i2, intent);
        }
    }

    public final void m16485a(FeedType feedType) {
        if (this.f11190r != null) {
            this.f11190r.f10424g = feedType;
        }
        if (this.f11193u != null) {
            this.f11193u.f10183t = feedType;
        }
        if (this.f11170X != null) {
            this.f11170X.f11110r = feedType;
        }
    }

    public final void aw() {
        if (this.f11162P != null) {
            this.f11162P.aw();
        }
    }

    public final void m16498a(ScrollingFragmentViewHolder scrollingFragmentViewHolder) {
        if (this.f11153G != null) {
            this.f11153G.f10056e = scrollingFragmentViewHolder;
        }
        if (this.f11161O != null) {
            this.f11161O.f11211b = scrollingFragmentViewHolder;
        }
        if (this.f11165S != null) {
            this.f11165S.f11217e = scrollingFragmentViewHolder;
        }
    }

    public final void m16490a(NewsFeedViewController newsFeedViewController) {
        if (this.f11163Q != null) {
            this.f11163Q.f9901j = newsFeedViewController;
        }
        if (this.f11162P != null) {
            this.f11162P.f9009h = newsFeedViewController;
        }
    }

    public final void m16486a(Holder<ListItemCollection<FeedEdge>> holder) {
        if (this.f11181i != null) {
            this.f11181i.f9707b = holder;
        }
        if (this.f11163Q != null) {
            this.f11163Q.f9900i = holder;
        }
        if (this.f11164R != null) {
            this.f11164R.f9904b = holder;
        }
        if (this.f11169W != null) {
            this.f11169W.f10163e = holder;
        }
        if (this.f11170X != null) {
            this.f11170X.f11111s = holder;
        }
    }

    public final void m16505b(Holder<LegacyFeedUnitUpdater> holder) {
        if (this.f11185m != null) {
            this.f11185m.f9719e = holder;
        }
        if (this.f11198z != null) {
            this.f11198z.f9839h = holder;
        }
        if (this.f11149C != null) {
            this.f11149C.f9854i = holder;
        }
        if (this.f11151E != null) {
            this.f11151E.f9943h = holder;
        }
        if (this.f11169W != null) {
            this.f11169W.f10162d = holder;
        }
        if (this.f11171Y != null) {
            this.f11171Y.f10384h = holder;
        }
    }

    public final void m16511c(Holder<FbFragment> holder) {
        if (this.f11173a != null) {
            this.f11173a.f11201b = holder;
        }
        if (this.f11179g != null) {
            this.f11179g.f9737c = holder;
        }
        if (this.f11148B != null) {
            this.f11148B.f9845c = holder;
        }
        if (this.f11149C != null) {
            this.f11149C.f9853h = holder;
        }
        if (this.f11152F != null) {
            this.f11152F.f10050j = holder;
        }
        if (this.f11157K != null) {
            this.f11157K.f9918c = holder;
        }
        if (this.f11158L != null) {
            this.f11158L.f10080b = holder;
        }
        if (this.f11168V != null) {
            this.f11168V.f4768g = holder;
        }
        if (this.f11170X != null) {
            this.f11170X.f11114v = holder;
        }
    }

    public final void m16478a(Context context) {
        if (this.f11193u != null) {
            this.f11193u.f10182s = context;
        }
        if (this.f11151E != null) {
            this.f11151E.f9942g = context;
        }
        if (this.f11163Q != null) {
            this.f11163Q.f9899h = context;
        }
        if (this.f11166T != null) {
            this.f11166T.f10388d = context;
        }
        if (this.f11170X != null) {
            this.f11170X.f11112t = context;
        }
        if (this.f11171Y != null) {
            this.f11171Y.f10382f = context;
        }
    }

    public final void m16500a(String str) {
        if (this.f11195w != null) {
            this.f11195w.f10036b = str;
        }
    }

    public final void av() {
        if (this.f11162P != null) {
            this.f11162P.av();
        }
    }

    public final void m16484a(FetchFeedCause fetchFeedCause, Location location) {
        if (this.f11182j != null) {
            SwipeRefreshController swipeRefreshController = this.f11182j;
            if (fetchFeedCause.isManual()) {
                swipeRefreshController.f10152d.f10158c.m4410a("NewsFeedFragment", Event.LOADING_INDICATOR_SHOWN);
                if (swipeRefreshController.f10153e != null) {
                    swipeRefreshController.f10153e.setRefreshing(true);
                } else {
                    swipeRefreshController.f10151c.m4410a(SwipeRefreshController.f10149a.toString(), Event.SWIPE_LAYOUT_NULL);
                }
            }
        }
        if (this.f11192t != null) {
            this.f11192t.m15327a(location);
        }
        if (this.f11166T != null) {
            TailLoaderController tailLoaderController = this.f11166T;
            if (Location.TAIL.equals(location)) {
                tailLoaderController.f10385a.m15483a();
            }
        }
    }

    public final void m16502a(boolean z, boolean z2) {
        if (this.f11178f != null) {
            ErrorViewController errorViewController = this.f11178f;
            if (errorViewController.f9912b != null) {
                errorViewController.f9912b.setVisibility(8);
            }
        }
        if (this.f11182j != null) {
            this.f11182j.m15250a(z, z2);
        }
        if (this.f11166T != null) {
            TailLoaderController tailLoaderController = this.f11166T;
            if (!z) {
                tailLoaderController.f10385a.m15487b();
            }
        }
    }

    public final void m16487a(ErrorType errorType) {
        if (this.f11178f != null) {
            ErrorViewController errorViewController = this.f11178f;
            if (errorType == ErrorType.EMPTY_DATASET) {
                if (errorViewController.f9912b == null) {
                    errorViewController.f9912b = ((ViewStub) errorViewController.f9913c.findViewById(2131560226)).inflate();
                    errorViewController.f9914d = errorViewController.f9912b.findViewById(2131561897);
                    errorViewController.f9914d.setOnClickListener(new 1(errorViewController));
                }
                ((TextView) errorViewController.f9912b.findViewById(2131561899)).setText(errorViewController.f9911a.m3828d() ? 2131233504 : 2131230763);
                errorViewController.f9912b.setVisibility(0);
            }
        }
        if (this.f11182j != null) {
            this.f11182j.m15251b();
        }
        if (this.f11166T != null) {
            TailLoaderController tailLoaderController = this.f11166T;
            tailLoaderController.f10385a.m15486a(tailLoaderController.f10388d.getString(2131230811), tailLoaderController.f10386b);
        }
    }

    public final void au() {
        if (this.f11162P != null) {
            this.f11162P.au();
        }
    }

    public final void m16488a(NewsFeedFragment newsFeedFragment) {
        if (this.f11169W != null) {
            this.f11169W.f10160b = newsFeedFragment;
        }
        if (this.f11171Y != null) {
            this.f11171Y.f10383g = newsFeedFragment;
        }
    }

    public final void mo2117a() {
        this.f11173a = null;
        this.f11174b = null;
        this.f11175c = null;
        this.f11176d = null;
        this.f11177e = null;
        this.f11178f = null;
        this.f11179g = null;
        this.f11180h = null;
        this.f11181i = null;
        this.f11182j = null;
        this.f11183k = null;
        this.f11184l = null;
        this.f11185m = null;
        this.f11186n = null;
        this.f11187o = null;
        this.f11188p = null;
        this.f11189q = null;
        this.f11190r = null;
        this.f11191s = null;
        this.f11192t = null;
        this.f11193u = null;
        this.f11194v = null;
        this.f11195w = null;
        this.f11196x = null;
        this.f11197y = null;
        this.f11198z = null;
        this.f11147A = null;
        this.f11148B = null;
        this.f11149C = null;
        this.f11150D = null;
        this.f11151E = null;
        this.f11152F = null;
        this.f11153G = null;
        this.f11154H = null;
        this.f11155I = null;
        this.f11156J = null;
        this.f11157K = null;
        this.f11158L = null;
        this.f11159M = null;
        this.f11160N = null;
        this.f11161O = null;
        this.f11162P = null;
        this.f11163Q = null;
        this.f11164R = null;
        this.f11165S = null;
        this.f11166T = null;
        this.f11167U = null;
        this.f11168V = null;
        this.f11169W = null;
        this.f11170X = null;
        this.f11171Y = null;
        this.f11172Z = null;
        super.mo2117a();
    }
}
