package com.facebook.feed.storypermalink;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.RecyclerListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.permalink.PermalinkEventsBuilder;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.api.story.FetchSingleStoryParams.FetchType;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackDisplayType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.NotificationSource;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.internal.Sets;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEventSubscriber;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.debug.fps.FrameRateListViewScrollListener;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.annotations.ForPermalink;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.data.FeedStorySubscriber.OnStoryChangeListener;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.LazyListViewDelegate;
import com.facebook.feed.menu.permalink.PermalinkFeedStoryMenuHelperFactory;
import com.facebook.feed.permalink.PermalinkCommentNavigationDelegate;
import com.facebook.feed.permalink.PermalinkCommentNavigationDelegateProvider;
import com.facebook.feed.permalink.PermalinkController;
import com.facebook.feed.permalink.PermalinkEnvironmentProvider;
import com.facebook.feed.permalink.PermalinkEventSubscriptions;
import com.facebook.feed.permalink.PermalinkEventSubscriptions.CommentButtonClickSubscriber;
import com.facebook.feed.permalink.PermalinkEventSubscriptions.FeedUnitMutatedEventSubscriber;
import com.facebook.feed.permalink.PermalinkEventSubscriptions.LikeClickSubscriber;
import com.facebook.feed.permalink.PermalinkEventSubscriptions.ReactionUpdatedEventSubscriber;
import com.facebook.feed.permalink.PermalinkEventSubscriptions.SetNotifyMeSubscriber;
import com.facebook.feed.permalink.PermalinkEventSubscriptions.StoryDeleteSubscriber;
import com.facebook.feed.permalink.PermalinkEventSubscriptions.StoryVisibilitySubscriber;
import com.facebook.feed.permalink.PermalinkEventSubscriptionsProvider;
import com.facebook.feed.permalink.PermalinkFeedListType;
import com.facebook.feed.permalink.PermalinkInterstitialAdapter;
import com.facebook.feed.permalink.PermalinkParams;
import com.facebook.feed.permalink.PermalinkPerformanceLogger;
import com.facebook.feed.permalink.PermalinkPerformanceLogger.1;
import com.facebook.feed.permalink.PermalinkRenderUtils;
import com.facebook.feed.permalink.PermalinkSubstoryFeedbackEventSubscriber;
import com.facebook.feed.permalink.PermalinkSubstoryFeedbackEventSubscriberProvider;
import com.facebook.feed.rows.FeedAdapterFactory;
import com.facebook.feed.rows.MultiRowFeedLifecycleSubscribers;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.permalink.StoryPermalinkAdapter;
import com.facebook.feed.ui.FeedLifecycleSubscribers;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.util.StoryEventSubscriberManager;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.feedback.prefetcher.FeedbackPrefetchingExperiments;
import com.facebook.feedback.reactions.ui.FloatingReactionsLauncher;
import com.facebook.feedback.ui.Bindable;
import com.facebook.feedback.ui.CommentAdapter;
import com.facebook.feedback.ui.CommentAdapterFactory;
import com.facebook.feedback.ui.CommentListScrollStateController.ScrollingProxy;
import com.facebook.feedback.ui.CommentsHelper;
import com.facebook.feedback.ui.CommentsHelperProvider;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironment;
import com.facebook.feedback.ui.environment.BaseCommentsEnvironmentProvider;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.feed.StoryPermalinkParamsType;
import com.facebook.ipc.feed.StoryPermalinkUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.notifications.abtest.Notifications2gImprovementsExperimentController;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.places.checkin.launcher.PlacePickerResultHandler;
import com.facebook.privacy.audience.PostPrivacyUpsellDialogController;
import com.facebook.privacy.audience.PostPrivacyUpsellDialogController.EntryPoint;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore;
import com.facebook.reviews.event.ReviewEventBus;
import com.facebook.reviews.event.ReviewEvents;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler.PostReviewCallbackBase;
import com.facebook.reviews.util.intent.StoryReviewComposerLauncherAndHandler;
import com.facebook.timeline.intent.TimelineIntentFactory;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.ListViewProxy;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxyContainer;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorController;
import com.facebook.widget.loadingindicator.LoadingIndicatorState;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TWENTY_EIGHT_DAYS */
public class StoryPermalinkFragment extends FbFragment implements AnalyticsFragment, AnalyticsFragmentWithExtraData, CanHandleBackPressed, FragmentWithDebugInfo, Bindable<FeedUnit>, ScrollingViewProxyContainer {
    private BetterListView f24502a;
    @Inject
    PermalinkInterstitialAdapter aA;
    @Inject
    PermalinkEnvironmentProvider aB;
    @Inject
    StoryEventSubscriberManager aC;
    @Inject
    BaseCommentsEnvironmentProvider aD;
    @Inject
    TimelineIntentFactory aE;
    @Inject
    Provider<SecureContextHelper> aF;
    @Inject
    Notifications2gImprovementsExperimentController aG;
    @Inject
    QeAccessor aH;
    @Inject
    RedSpaceOptimisticBadgeStore aI;
    @Inject
    FeedStorySubscriber aJ;
    @Inject
    ControllerMutationGatekeepers aK;
    @Inject
    PermalinkFeedStoryMenuHelperFactory aL;
    @Inject
    public FloatingReactionsLauncher aM;
    @Inject
    FeedbackPrefetchingExperiments aN;
    @Inject
    FeedUnitDataController aO;
    @Inject
    InlineReplyExpansionExperimentUtil aP;
    @Inject
    FeedbackLoader aQ;
    @Inject
    @ForUiThread
    Executor aR;
    private LoadingIndicatorView aS;
    public ViewGroup aT;
    private Context aU;
    private BaseCommentsEnvironment aV;
    public CommentAdapter aW;
    public CommentsHelper aX;
    private StoryPermalinkAdapter aY;
    private PermalinkEventSubscriptions aZ;
    @Inject
    FeedStoryMutator al;
    @Inject
    FrameRateLoggerProvider am;
    @Inject
    GraphQLStoryUtil an;
    @Inject
    Lazy<PostPrivacyUpsellDialogController> ao;
    @Inject
    public Lazy<ReviewEventBus> ap;
    @Inject
    ObjectMapper aq;
    @Inject
    PermalinkController ar;
    @Inject
    PermalinkEventsBuilder as;
    @Inject
    PermalinkEventSubscriptionsProvider at;
    @Inject
    @ForPermalink
    FeedLifecycleSubscribers au;
    @Inject
    MultipleRowsStoriesRecycleCallback av;
    @Inject
    PermalinkCommentNavigationDelegateProvider aw;
    @Inject
    PermalinkPerformanceLogger ax;
    @Inject
    public StoryReviewComposerLauncherAndHandler ay;
    @Inject
    PlacePickerResultHandler az;
    public FbSwipeRefreshLayout f24503b;
    public MultiAdapterListAdapter ba;
    public PermalinkParams bb;
    private Set<Bindable<FeedProps<GraphQLFeedback>>> bc;
    public final RetryClickedListener bd = new RetryTrigger(this);
    private LoadingIndicatorState be;
    public LoadingIndicatorController bf;
    public boolean bg;
    public GraphQLStory bh;
    private FrameRateLogger bi;
    private PermalinkSubstoryFeedbackEventSubscriber bj;
    private GraphQLComment bk;
    private LazyListViewDelegate bl;
    public boolean bm;
    private boolean bn;
    public boolean bo;
    public boolean bp;
    private boolean bq;
    @Inject
    AnalyticsLogger f24504c;
    @Inject
    CommentsHelperProvider f24505d;
    @Inject
    CommentAdapterFactory f24506e;
    @Inject
    ComposerPublishServiceHelper f24507f;
    @Inject
    FeedAdapterFactory f24508g;
    @Inject
    PermalinkSubstoryFeedbackEventSubscriberProvider f24509h;
    @Inject
    FeedImageLoader f24510i;

    /* compiled from: TWENTY_EIGHT_DAYS */
    class C29441 implements Runnable {
        final /* synthetic */ StoryPermalinkFragment f24520a;

        C29441(StoryPermalinkFragment storyPermalinkFragment) {
            this.f24520a = storyPermalinkFragment;
        }

        public void run() {
            AdapterDetour.a(this.f24520a.ba, -1345988837);
        }
    }

    /* compiled from: TWENTY_EIGHT_DAYS */
    class C29452 implements ScrollingProxy {
        final /* synthetic */ StoryPermalinkFragment f24521a;

        C29452(StoryPermalinkFragment storyPermalinkFragment) {
            this.f24521a = storyPermalinkFragment;
        }

        public final int m26434a() {
            return this.f24521a.ba.a(this.f24521a.aW);
        }
    }

    /* compiled from: TWENTY_EIGHT_DAYS */
    class C29463 implements Function<GraphQLFeedback, Void> {
        final /* synthetic */ StoryPermalinkFragment f24522a;

        C29463(StoryPermalinkFragment storyPermalinkFragment) {
            this.f24522a = storyPermalinkFragment;
        }

        public Object apply(@Nullable Object obj) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
            FeedStoryMutator feedStoryMutator = this.f24522a.al;
            this.f24522a.mo1148a(FeedStoryMutator.a(this.f24522a.bh, graphQLFeedback));
            return null;
        }
    }

    /* compiled from: TWENTY_EIGHT_DAYS */
    class C29474 implements Function<GraphQLStory, Void> {
        final /* synthetic */ StoryPermalinkFragment f24523a;

        C29474(StoryPermalinkFragment storyPermalinkFragment) {
            this.f24523a = storyPermalinkFragment;
        }

        public Object apply(@Nullable Object obj) {
            FeedUnit feedUnit = (GraphQLStory) obj;
            GraphQLStory a = StoryPermalinkFragment.m26395a(this.f24523a, (GraphQLStory) feedUnit);
            if (a != null) {
                String g = a.g();
                if (this.f24523a.bh == null || (g != null && g.equals(this.f24523a.bh.g()))) {
                    this.f24523a.mo1148a(feedUnit);
                }
            }
            return null;
        }
    }

    /* compiled from: TWENTY_EIGHT_DAYS */
    class C29485 implements Function<GraphQLStory, Void> {
        final /* synthetic */ StoryPermalinkFragment f24524a;

        C29485(StoryPermalinkFragment storyPermalinkFragment) {
            this.f24524a = storyPermalinkFragment;
        }

        public Object apply(@Nullable Object obj) {
            this.f24524a.mo1148a((GraphQLStory) obj);
            return null;
        }
    }

    /* compiled from: TWENTY_EIGHT_DAYS */
    class C29496 implements OnStoryChangeListener {
        final /* synthetic */ StoryPermalinkFragment f24525a;

        C29496(StoryPermalinkFragment storyPermalinkFragment) {
            this.f24525a = storyPermalinkFragment;
        }

        public final void m26435a(GraphQLStory graphQLStory) {
            this.f24525a.mo1148a((FeedUnit) graphQLStory);
        }
    }

    /* compiled from: TWENTY_EIGHT_DAYS */
    class C29507 implements RecyclerListener {
        final /* synthetic */ StoryPermalinkFragment f24526a;

        C29507(StoryPermalinkFragment storyPermalinkFragment) {
            this.f24526a = storyPermalinkFragment;
        }

        public void onMovedToScrapHeap(View view) {
            MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback = this.f24526a.av;
            MultipleRowsStoriesRecycleCallback.a(view);
        }
    }

    /* compiled from: TWENTY_EIGHT_DAYS */
    class C29518 implements OnRefreshListener {
        final /* synthetic */ StoryPermalinkFragment f24527a;

        C29518(StoryPermalinkFragment storyPermalinkFragment) {
            this.f24527a = storyPermalinkFragment;
        }

        public final void m26436a() {
            this.f24527a.ar();
        }
    }

    /* compiled from: TWENTY_EIGHT_DAYS */
    class C29529 extends AbstractDisposableFutureCallback<GraphQLStory> {
        final /* synthetic */ StoryPermalinkFragment f24528a;

        C29529(StoryPermalinkFragment storyPermalinkFragment) {
            this.f24528a = storyPermalinkFragment;
        }

        public final void m26437a(@Nullable Object obj) {
            FeedUnit feedUnit = (GraphQLStory) obj;
            this.f24528a.m26414a(feedUnit, feedUnit != null ? TrackableFeedProps.a(FeedProps.c(feedUnit)) : null);
            StoryPermalinkFragment.ax(this.f24528a);
            StoryPermalinkFragment.aA(this.f24528a);
        }

        public final void m26438a(Throwable th) {
        }
    }

    /* compiled from: TWENTY_EIGHT_DAYS */
    class RetryTrigger implements RetryClickedListener {
        final /* synthetic */ StoryPermalinkFragment f24529a;

        public RetryTrigger(StoryPermalinkFragment storyPermalinkFragment) {
            this.f24529a = storyPermalinkFragment;
        }

        public final void m26439a() {
            this.f24529a.ar();
        }
    }

    public static void m26401a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StoryPermalinkFragment) obj).m26396a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), (CommentsHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CommentsHelperProvider.class), CommentAdapterFactory.a(fbInjector), ComposerPublishServiceHelper.a(fbInjector), FeedAdapterFactory.a(fbInjector), (PermalinkSubstoryFeedbackEventSubscriberProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PermalinkSubstoryFeedbackEventSubscriberProvider.class), FeedImageLoader.a(fbInjector), FeedStoryMutator.a(fbInjector), (FrameRateLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), GraphQLStoryUtil.a(fbInjector), IdBasedLazy.a(fbInjector, 9686), IdBasedSingletonScopeProvider.b(fbInjector, 10265), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(fbInjector), PermalinkController.a(fbInjector), PermalinkEventsBuilder.a(fbInjector), (PermalinkEventSubscriptionsProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PermalinkEventSubscriptionsProvider.class), (FeedLifecycleSubscribers) MultiRowFeedLifecycleSubscribers.a(fbInjector), MultipleRowsStoriesRecycleCallback.a(fbInjector), (PermalinkCommentNavigationDelegateProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PermalinkCommentNavigationDelegateProvider.class), PermalinkPerformanceLogger.a(fbInjector), StoryReviewComposerLauncherAndHandler.a(fbInjector), PlacePickerResultHandler.a(fbInjector), PermalinkInterstitialAdapter.a(fbInjector), (PermalinkEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PermalinkEnvironmentProvider.class), StoryEventSubscriberManager.a(fbInjector), (BaseCommentsEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(BaseCommentsEnvironmentProvider.class), TimelineIntentFactory.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 968), Notifications2gImprovementsExperimentController.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), RedSpaceOptimisticBadgeStore.a(fbInjector), FeedStorySubscriber.a(fbInjector), ControllerMutationGatekeepers.a(fbInjector), PermalinkFeedStoryMenuHelperFactory.a(fbInjector), FloatingReactionsLauncher.a(fbInjector), FeedbackPrefetchingExperiments.a(fbInjector), FeedUnitDataController.a(fbInjector), InlineReplyExpansionExperimentUtil.a(fbInjector), FeedbackLoader.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    private void m26396a(AnalyticsLogger analyticsLogger, CommentsHelperProvider commentsHelperProvider, CommentAdapterFactory commentAdapterFactory, ComposerPublishServiceHelper composerPublishServiceHelper, FeedAdapterFactory feedAdapterFactory, PermalinkSubstoryFeedbackEventSubscriberProvider permalinkSubstoryFeedbackEventSubscriberProvider, FeedImageLoader feedImageLoader, FeedStoryMutator feedStoryMutator, FrameRateLoggerProvider frameRateLoggerProvider, GraphQLStoryUtil graphQLStoryUtil, Lazy<PostPrivacyUpsellDialogController> lazy, Lazy<ReviewEventBus> lazy2, ObjectMapper objectMapper, PermalinkController permalinkController, PermalinkEventsBuilder permalinkEventsBuilder, PermalinkEventSubscriptionsProvider permalinkEventSubscriptionsProvider, FeedLifecycleSubscribers feedLifecycleSubscribers, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, PermalinkCommentNavigationDelegateProvider permalinkCommentNavigationDelegateProvider, PermalinkPerformanceLogger permalinkPerformanceLogger, StoryReviewComposerLauncherAndHandler storyReviewComposerLauncherAndHandler, PlacePickerResultHandler placePickerResultHandler, PermalinkInterstitialAdapter permalinkInterstitialAdapter, PermalinkEnvironmentProvider permalinkEnvironmentProvider, StoryEventSubscriberManager storyEventSubscriberManager, BaseCommentsEnvironmentProvider baseCommentsEnvironmentProvider, TimelineIntentFactory timelineIntentFactory, Provider<SecureContextHelper> provider, Notifications2gImprovementsExperimentController notifications2gImprovementsExperimentController, QeAccessor qeAccessor, RedSpaceOptimisticBadgeStore redSpaceOptimisticBadgeStore, FeedStorySubscriber feedStorySubscriber, ControllerMutationGatekeepers controllerMutationGatekeepers, PermalinkFeedStoryMenuHelperFactory permalinkFeedStoryMenuHelperFactory, FloatingReactionsLauncher floatingReactionsLauncher, FeedbackPrefetchingExperiments feedbackPrefetchingExperiments, FeedUnitDataController feedUnitDataController, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil, FeedbackLoader feedbackLoader, Executor executor) {
        this.f24504c = analyticsLogger;
        this.f24505d = commentsHelperProvider;
        this.f24506e = commentAdapterFactory;
        this.f24507f = composerPublishServiceHelper;
        this.f24508g = feedAdapterFactory;
        this.f24509h = permalinkSubstoryFeedbackEventSubscriberProvider;
        this.f24510i = feedImageLoader;
        this.al = feedStoryMutator;
        this.am = frameRateLoggerProvider;
        this.an = graphQLStoryUtil;
        this.ao = lazy;
        this.ap = lazy2;
        this.aq = objectMapper;
        this.ar = permalinkController;
        this.as = permalinkEventsBuilder;
        this.at = permalinkEventSubscriptionsProvider;
        this.au = feedLifecycleSubscribers;
        this.av = multipleRowsStoriesRecycleCallback;
        this.aw = permalinkCommentNavigationDelegateProvider;
        this.ax = permalinkPerformanceLogger;
        this.ay = storyReviewComposerLauncherAndHandler;
        this.az = placePickerResultHandler;
        this.aA = permalinkInterstitialAdapter;
        this.aB = permalinkEnvironmentProvider;
        this.aC = storyEventSubscriberManager;
        this.aD = baseCommentsEnvironmentProvider;
        this.aE = timelineIntentFactory;
        this.aF = provider;
        this.aG = notifications2gImprovementsExperimentController;
        this.aH = qeAccessor;
        this.aI = redSpaceOptimisticBadgeStore;
        this.aJ = feedStorySubscriber;
        this.aK = controllerMutationGatekeepers;
        this.aL = permalinkFeedStoryMenuHelperFactory;
        this.aM = floatingReactionsLauncher;
        this.aN = feedbackPrefetchingExperiments;
        this.aO = feedUnitDataController;
        this.aP = inlineReplyExpansionExperimentUtil;
        this.aQ = feedbackLoader;
        this.aR = executor;
    }

    public void mo1153c(Bundle bundle) {
        super.c(bundle);
        Class cls = StoryPermalinkFragment.class;
        m26401a((Object) this, getContext());
        if (D()) {
            PermalinkPerformanceLogger permalinkPerformanceLogger = this.ax;
            if (!(permalinkPerformanceLogger.c.h(655368, "NNF_PermalinkFromFeedLoad") || permalinkPerformanceLogger.c.h(655408, "NNF_PermalinkNotificationLoad") || permalinkPerformanceLogger.c.h(655412, "NNF_PermalinkFromAndroidNotificationColdLoad") || permalinkPerformanceLogger.c.h(655409, "NNF_PermalinkFromAndroidNotificationWarmLoad"))) {
                permalinkPerformanceLogger.c.d(655407, "PermalinkFromOnCreateToLoadIfNoNavigationalMetrics");
            }
            permalinkPerformanceLogger.c.d(655370, "PermalinkFromOnCreateToLoad");
            permalinkPerformanceLogger.c.d(3473416, "NotifPermalinkRefreshStoryTime");
        }
        if (bundle == null) {
            bundle = this.s;
        }
        if (bundle != null) {
            this.bb = (PermalinkParams) bundle.getParcelable("permalink_params");
            this.be = (LoadingIndicatorState) bundle.getParcelable("loading_indicator_state");
        }
        Runnable c29441 = new C29441(this);
        this.bo = this.bb.o;
        this.bl = HasScrollListenerSupportImpl.a();
        this.aY = this.f24508g.a(PermalinkEnvironmentProvider.a(au(), PermalinkFeedListType.a, this.bl, this.aL, c29441));
        PermalinkCommentNavigationDelegate a = this.aw.a(au());
        this.aV = this.aD.a(au(), a, c29441);
        this.aW = this.f24506e.a(a, this.aV, null);
        Builder builder = ImmutableList.builder();
        builder.c(this.aA);
        builder.c((FbListAdapter) this.aY).c(this.aW);
        this.ba = MultiAdapterListAdapter.a(builder.b());
        this.bf = new LoadingIndicatorController(this.be, this.bd);
        this.aX = this.f24505d.a(this, this.aW, this.aV, new C29452(this), new C29463(this));
        this.aZ = this.at.a(new C29474(this), this.aX);
        this.bj = this.f24509h.a(new C29485(this));
        FeedbackLoggingParams feedbackLoggingParams = this.bb.q;
        if (feedbackLoggingParams == null) {
            ArrayNode a2 = this.bh != null ? TrackableFeedProps.a(FeedProps.c(this.bh)) : null;
            this.bq = false;
            m26400a(a2);
            this.aX.a(false);
        } else {
            this.bq = true;
            m26397a(feedbackLoggingParams);
            this.aX.a(true);
        }
        this.bc = Sets.a(new Bindable[]{this.aX});
        this.bi = this.am.a(Boolean.valueOf(false), "new_permalink_scroll_perf", Absent.INSTANCE);
        this.bk = this.bb.l;
        this.bn = this.aK.a();
        if (this.bn) {
            this.aJ.d = new C29496(this);
        }
        if (!this.bg) {
            aw();
            ar();
        }
    }

    private Context au() {
        if (this.aU == null) {
            this.aU = new ContextThemeWrapper(getContext(), this.bo ? 2131626111 : 2131626110);
        }
        return this.aU;
    }

    public final View m26410a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1627280310);
        LayoutInflater from = LayoutInflater.from(au());
        this.aT = viewGroup;
        View inflate = from.inflate(2130906173, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -527505012, a);
        return inflate;
    }

    public final void m26412a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f24502a = (BetterListView) e(2131558482);
        this.f24503b = (FbSwipeRefreshLayout) e(2131565839);
        this.f24503b.setColorSchemeResources(new int[]{2131361916});
        this.aS = (LoadingIndicatorView) e(2131565840);
        this.f24502a.setAdapter(this.ba);
        this.f24502a.setRecyclerListener(new C29507(this));
        this.f24502a.setEmptyView(this.aS);
        this.f24502a.setOnScrollListener(new FrameRateListViewScrollListener(this.bi));
        this.f24503b.e = new C29518(this);
        this.bf.a(this.aS);
        this.aX.a(view, new ListViewProxy(this.f24502a));
        this.bl.a(this.f24502a);
        aq();
        aA(this);
    }

    protected void aq() {
        mo1148a(this.bh);
    }

    public final void m26411a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1756:
                case 1758:
                    this.f24507f.c(intent);
                    return;
                case 1759:
                    int i3 = i2;
                    Intent intent2 = intent;
                    this.ay.a(i3, intent2, "story_view", Optional.of(new PostReviewCallbackBase(this) {
                        final /* synthetic */ StoryPermalinkFragment f24519a;

                        {
                            this.f24519a = r1;
                        }

                        public final void m26433a(OperationResult operationResult) {
                            String str;
                            this.f24519a.ar();
                            StoryPermalinkFragment storyPermalinkFragment = this.f24519a;
                            ReviewWithFeedback reviewWithFeedback = (ReviewWithFeedback) operationResult.h();
                            GraphQLStoryActionLink a = ActionLinkHelper.a(storyPermalinkFragment.bh.E(), -1160597742);
                            if (a == null || a.ak() == null || a.ak().v() == null) {
                                str = null;
                            } else {
                                str = a.ak().v().H();
                            }
                            String str2 = str;
                            if (str2 != null) {
                                ((ReviewEventBus) storyPermalinkFragment.ap.get()).a(ReviewEvents.a(str2, reviewWithFeedback));
                            }
                        }
                    }), Optional.of(getContext()));
                    return;
                case 1856:
                    GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) FlatBufferModelHelper.a(intent, "privacy_option_to_upsell");
                    if (graphQLPrivacyOption != null) {
                        ((PostPrivacyUpsellDialogController) this.ao.get()).a(getContext(), this.aT, graphQLPrivacyOption, EntryPoint.PERMALINK);
                    }
                    ar();
                    return;
                case 5002:
                    if (this.bh != null) {
                        intent.putExtra("story_for_social_search", this.bh);
                    }
                    this.az.a(intent);
                    return;
                case 9915:
                    m26403b(i2, intent);
                    return;
                default:
                    this.aX.a(i, i2, intent);
                    return;
            }
        }
    }

    public final void m26407G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1371773151);
        super.G();
        this.au.a();
        this.aC.b();
        this.f24502a.a(new 1(this.ax));
        this.f24510i.a();
        this.aX.d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1743487196, a);
    }

    public final void m26408H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1067794132);
        super.H();
        StoryEventSubscriberManager storyEventSubscriberManager = this.aC;
        storyEventSubscriberManager.a.b(storyEventSubscriberManager.b);
        PermalinkPerformanceLogger permalinkPerformanceLogger = this.ax;
        for (MarkerConfig a2 : PermalinkPerformanceLogger.a) {
            permalinkPerformanceLogger.c.a(a2);
        }
        this.bi.b();
        this.aX.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1424759361, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -131435974);
        super.mY_();
        this.aX.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1884820508, a);
    }

    public void mo1147I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -579820525);
        super.I();
        this.aY.jc_();
        this.aX.b();
        this.aW.jc_();
        this.aZ.b.a();
        this.ar.i.c();
        this.bj.a();
        if (this.bn) {
            this.aJ.a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1253287198, a);
    }

    public final void m26420e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("permalink_params", this.bb);
        bundle.putParcelable("loading_indicator_state", this.be);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f24510i.a();
        this.aY.a(configuration);
    }

    public void mo1148a(FeedUnit feedUnit) {
        this.bh = m26395a(this, (GraphQLStory) feedUnit);
        if (this.aH.a(ExperimentsForRedSpaceExperimentsModule.h, false) && this.aH.a(ExperimentsForRedSpaceExperimentsModule.c, true)) {
            this.aI.a(this.bh);
        }
        this.aA.a(this.bh);
        m26416b(this.bh);
        this.bj.a(this.bh);
        this.aZ.a(this.bh);
        if (!this.aC.c) {
            StoryEventSubscriberManager storyEventSubscriberManager = this.aC;
            PermalinkEventSubscriptions permalinkEventSubscriptions = this.aZ;
            storyEventSubscriberManager.a(new FbEventSubscriber[]{new LikeClickSubscriber(permalinkEventSubscriptions), new CommentButtonClickSubscriber(permalinkEventSubscriptions), new SetNotifyMeSubscriber(permalinkEventSubscriptions), new StoryVisibilitySubscriber(permalinkEventSubscriptions), new StoryDeleteSubscriber(permalinkEventSubscriptions), new FeedUnitMutatedEventSubscriber(permalinkEventSubscriptions), permalinkEventSubscriptions.h.b, new ReactionUpdatedEventSubscriber(permalinkEventSubscriptions)});
        }
        if (this.bn && this.bh != null) {
            this.aJ.a(this.bh, true);
        }
        if (hn_()) {
            PermalinkRenderUtils.a((HasTitleBar) a(HasTitleBar.class), this.bh, this.aO);
            if (!(this.bp || this.bb == null || this.bb.p != 11)) {
                this.aM.a(this.aT);
                this.bp = true;
            }
        }
        if (this.aX != null && GraphQLStoryUtil.q(this.bh)) {
            this.aX.a(Long.valueOf(Long.parseLong(this.bh.aJ().b())));
        }
        m26399a(CommentsHelper.a(GraphQLHelper.f(this.bh), this.bb.e, this.bk, this.aG));
    }

    private void m26399a(GraphQLFeedback graphQLFeedback) {
        Object a;
        GraphQLFeedback a2 = this.aX.a(graphQLFeedback);
        if (a2 != null) {
            a = this.bh != null ? FeedProps.c(this.bh).a(a2) : FeedProps.c(a2);
        } else {
            a = null;
        }
        for (Bindable a3 : this.bc) {
            a3.a(a);
        }
    }

    protected final void m26416b(FeedUnit feedUnit) {
        ((Bindable) this.aY).a(feedUnit);
    }

    public final String am_() {
        return "story_view";
    }

    public final ScrollingViewProxy m26421n() {
        if (this.f24502a == null) {
            return null;
        }
        return new ListViewProxy(this.f24502a);
    }

    public final boolean O_() {
        return this.aX != null && this.aX.a(getContext());
    }

    private void aw() {
        PermalinkController permalinkController = this.ar;
        PermalinkParams permalinkParams = this.bb;
        C29529 c29529 = new C29529(this);
        StoryPermalinkParamsType storyPermalinkParamsType = permalinkParams.a;
        if (!storyPermalinkParamsType.isJsonType()) {
            if (storyPermalinkParamsType.isNotificationType()) {
                GraphQLStory c = permalinkController.f.c(permalinkParams.c);
                if (c != null) {
                    c29529.onSuccess(c);
                } else {
                    permalinkController.i.a("fetch_single_notification_from_db " + permalinkParams.b, permalinkController.g.a(permalinkParams.b, permalinkParams.c), c29529);
                }
                return;
            }
            GraphQLStory a = permalinkController.e.a(permalinkParams.b, FetchType.GRAPHQL_FEEDBACK_DETAILS, permalinkParams.c, CommentOrderType.DEFAULT_ORDER, permalinkParams.i);
            if (a != null) {
                c29529.onSuccess(a);
            }
        }
    }

    public static void ax(StoryPermalinkFragment storyPermalinkFragment) {
        if (storyPermalinkFragment.bh != null && storyPermalinkFragment.bh.l() != null && storyPermalinkFragment.aD()) {
            Boolean valueOf = Boolean.valueOf(GraphQLHelper.o(storyPermalinkFragment.bh));
            PermalinkController permalinkController = storyPermalinkFragment.ar;
            CharSequence z_ = storyPermalinkFragment.bh.l().z_();
            boolean z = valueOf.booleanValue() && storyPermalinkFragment.aN.a();
            valueOf = Boolean.valueOf(z);
            AnonymousClass10 anonymousClass10 = new AbstractDisposableFutureCallback<GraphQLFeedback>(storyPermalinkFragment) {
                final /* synthetic */ StoryPermalinkFragment f24514a;

                {
                    this.f24514a = r1;
                }

                protected final void m26429a(@Nullable Object obj) {
                    this.f24514a.m26406b((GraphQLFeedback) obj);
                }

                protected final void m26430a(Throwable th) {
                }
            };
            Preconditions.checkArgument(!StringUtil.a(z_));
            permalinkController.i.a("fetch_cached_feedback_permalink", permalinkController.e.a(z_, DataFreshnessParam.DO_NOT_CHECK_SERVER, CommentOrderType.DEFAULT_ORDER, false, null, valueOf.booleanValue(), CallerContext.a), anonymousClass10);
        }
    }

    protected void ar() {
        at();
        this.ar.a(this.bb, new FutureCallback<GraphQLStory>(this) {
            final /* synthetic */ StoryPermalinkFragment f24518a;

            {
                this.f24518a = r1;
            }

            public void onSuccess(@Nullable Object obj) {
                final FeedUnit feedUnit = (GraphQLStory) obj;
                this.f24518a.bm = true;
                final ArrayNode a = feedUnit != null ? TrackableFeedProps.a(FeedProps.c(feedUnit)) : null;
                GraphQLFeedback f = GraphQLHelper.f(StoryPermalinkFragment.m26395a(this.f24518a, (GraphQLStory) feedUnit));
                if (CommentOrderType.getOrder(f).equals(CommentOrderType.RANKED_ORDER) && this.f24518a.aP.b()) {
                    Futures.a(this.f24518a.aQ.a(f), new AbstractDisposableFutureCallback<GraphQLFeedback>(this) {
                        final /* synthetic */ AnonymousClass11 f24517c;

                        protected final void m26431a(Object obj) {
                            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                            this.f24517c.f24518a.m26414a(feedUnit, a);
                            this.f24517c.f24518a.m26399a(graphQLFeedback);
                            this.f24517c.f24518a.aX.a(this.f24517c.f24518a.bb.e);
                            StoryPermalinkFragment.aB(this.f24517c.f24518a);
                        }

                        protected final void m26432a(Throwable th) {
                        }
                    }, this.f24518a.aR);
                    return;
                }
                this.f24518a.m26414a(feedUnit, a);
                this.f24518a.aX.a(this.f24518a.bb.e);
                StoryPermalinkFragment.aB(this.f24518a);
            }

            public void onFailure(Throwable th) {
                this.f24518a.bm = true;
                this.f24518a.ax.c();
                if (this.f24518a.hn_()) {
                    this.f24518a.bf.a(this.f24518a.b(2131230811), this.f24518a.bd);
                    if (this.f24518a.f24503b != null) {
                        this.f24518a.f24503b.setRefreshing(false);
                    }
                    StoryPermalinkFragment.aB(this.f24518a);
                    if (this.f24518a.bg && this.f24518a.aG.b()) {
                        this.f24518a.aX.a(this.f24518a.bb.e);
                    }
                }
            }
        });
    }

    protected final void at() {
        this.bf.a();
    }

    protected final void m26414a(FeedUnit feedUnit, ArrayNode arrayNode) {
        mo1148a(feedUnit);
        m26405b(feedUnit, arrayNode);
        if (!this.bq) {
            m26400a(arrayNode);
        }
        if (!(feedUnit == null || !this.bb.n || this.aX == null)) {
            boolean f = this.aX.f();
            PermalinkParams.Builder builder = new PermalinkParams.Builder();
            PermalinkParams permalinkParams = this.bb;
            PermalinkParams.Builder builder2 = new PermalinkParams.Builder();
            builder2.a = permalinkParams.a;
            builder2.b = permalinkParams.b;
            builder2.c = permalinkParams.c;
            builder2.d = permalinkParams.d;
            builder2.e = permalinkParams.e;
            builder2.f = permalinkParams.f;
            builder2.h = permalinkParams.h;
            builder2.i = permalinkParams.i;
            builder2.k = permalinkParams.k;
            builder2.l = permalinkParams.l;
            builder2.m = permalinkParams.m;
            builder2.n = permalinkParams.n;
            builder2.o = permalinkParams.o;
            builder2.p = permalinkParams.p;
            builder2.q = permalinkParams.q;
            builder = builder2;
            if (f) {
                f = false;
            } else {
                f = true;
            }
            builder.n = f;
            this.bb = builder.a();
        }
        if (this.f24503b != null) {
            this.f24503b.setRefreshing(false);
        }
        this.bf.b();
        this.bg = true;
    }

    private void m26406b(@Nullable GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback != null && this.bh != null && graphQLFeedback.v() >= this.bh.T_()) {
            m26399a(graphQLFeedback);
            aA(this);
        }
    }

    private void m26405b(FeedUnit feedUnit, ArrayNode arrayNode) {
        if (feedUnit != null) {
            HoneyClientEvent honeyClientEvent;
            GraphQLProfile a = feedUnit instanceof GraphQLStory ? StoryPermalinkUtil.a((GraphQLStory) feedUnit) : null;
            PermalinkEventsBuilder permalinkEventsBuilder = this.as;
            String str = "story_view";
            String a2 = StoryPermalinkUtil.a(a, 67338874);
            String a3 = StoryPermalinkUtil.a(a);
            if (arrayNode == null || arrayNode.e() == 0) {
                honeyClientEvent = null;
            } else {
                honeyClientEvent = new HoneyClientEvent("story_permalink_opened").a("tracking", arrayNode);
                honeyClientEvent.c = str;
                honeyClientEvent = honeyClientEvent;
                if (!Strings.isNullOrEmpty(a2)) {
                    honeyClientEvent.b("event_id", a2);
                }
                PermalinkEventsBuilder.a(honeyClientEvent, a3);
            }
            this.f24504c.a(honeyClientEvent);
        }
    }

    public static GraphQLStory m26395a(StoryPermalinkFragment storyPermalinkFragment, GraphQLStory graphQLStory) {
        return GraphQLStoryUtil.m(m26402b(graphQLStory));
    }

    @VisibleForTesting
    private static GraphQLStory m26402b(GraphQLStory graphQLStory) {
        if (graphQLStory == null || !StoryHierarchyHelper.e(graphQLStory)) {
            return graphQLStory;
        }
        return GraphQLStory.Builder.a(graphQLStory.L()).a();
    }

    private void m26397a(FeedbackLoggingParams feedbackLoggingParams) {
        this.aZ.k = feedbackLoggingParams;
        this.aX.a(feedbackLoggingParams);
        if (this.bb != null) {
            this.aX.a(this.bb.k);
        }
    }

    private void m26400a(ArrayNode arrayNode) {
        NotificationSource notificationSource;
        if (this.bb != null) {
            notificationSource = this.bb.j;
        } else {
            notificationSource = NotificationSource.UNKNOWN;
        }
        FeedbackLoggingParams.Builder builder = new FeedbackLoggingParams.Builder();
        builder.c = "story_view";
        builder = builder;
        builder.b = "permalink_ufi";
        builder = builder;
        builder.a = arrayNode;
        builder = builder;
        builder.d = FeedbackDisplayType.STORY_PERMALINK;
        builder = builder;
        builder.e = notificationSource;
        FeedbackLoggingParams a = builder.a();
        this.aZ.k = a;
        this.aX.a(a);
        if (this.bb != null) {
            this.aX.a(this.bb.k);
        }
    }

    private void m26403b(int i, Intent intent) {
        if (i == -1) {
            Intent a = this.aE.a((EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a), null, intent.getLongExtra("extra_profile_pic_expiration", 0), intent.getStringExtra("staging_ground_photo_caption"), "existing");
            a.putExtra("force_create_new_activity", true);
            ((SecureContextHelper) this.aF.get()).a(a, getContext());
        }
    }

    public Map<String, Object> mo1152c() {
        Map<String, Object> hashMap = new HashMap();
        if (this.bh != null) {
            String a = StoryPermalinkUtil.a(StoryPermalinkUtil.a(this.bh));
            if (a != null) {
                hashMap.put("source_group_id", a);
            }
            if (this.bh.c() != null) {
                hashMap.put("story_id", this.bh.c());
            }
            GraphQLActor b = StoryActorHelper.b(this.bh);
            if (!(b == null || b.H() == null)) {
                hashMap.put("author_id", b.H());
            }
        }
        return hashMap;
    }

    public Map<String, String> getDebugInfo() {
        return m26418c(this.bh);
    }

    protected final Map<String, String> m26418c(FeedUnit feedUnit) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("Permalink Params", this.bb.r());
        hashMap.put("Has Fetched Story: ", this.bg ? "True" : "False");
        if (this.bh != null) {
            try {
                hashMap.put("Permalink Story", this.aq.g().a().a(feedUnit));
            } catch (IOException e) {
            }
        }
        return hashMap;
    }

    public static void aA(StoryPermalinkFragment storyPermalinkFragment) {
        if (!storyPermalinkFragment.bm && storyPermalinkFragment.bh != null && !StoryActorHelper.a(storyPermalinkFragment.bh) && storyPermalinkFragment.aC()) {
            storyPermalinkFragment.aX.g();
        }
    }

    public static void aB(StoryPermalinkFragment storyPermalinkFragment) {
        if (storyPermalinkFragment.bm && storyPermalinkFragment.aC()) {
            storyPermalinkFragment.aX.h();
        }
    }

    private boolean aC() {
        if (this.bb.a.isNotificationType() || !this.aH.a(ExperimentsForFeedbackTestModule.F, false)) {
            return false;
        }
        return true;
    }

    private boolean aD() {
        return (StoryActorHelper.a(this.bh) && aC()) ? false : true;
    }
}
