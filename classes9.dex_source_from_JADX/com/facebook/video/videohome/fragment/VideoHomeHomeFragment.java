package com.facebook.video.videohome.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.apptab.state.TabTag;
import com.facebook.apptab.ui.AppTabBarBroadcaster;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.composer.capability.ComposerFacecastCapability;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.debug.fps.FrameRateRecyclerViewScrollListener;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.MultiRowFeedLifecycleSubscribers;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.api.ListItemCollectionEndProvider;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.ui.DisabledFeedStoryMenuHelper;
import com.facebook.feed.ui.MultiRowAdapterRecyclerViewProxy;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitor;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitorProvider;
import com.facebook.feed.ui.inlinevideoplayer.plugins.LiveStatusTracker;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.RequestType;
import com.facebook.graphql.calls.VideoHomeVisitInputData.Event;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.PresenceManager.PresenceDownloadState;
import com.facebook.presence.PresenceManager.PresenceListener;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionListener;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.ReactionThemedContextHelper;
import com.facebook.reaction.common.ReactionAnalyticsParams;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeStore;
import com.facebook.redspace.badge.RedSpaceOptimisticBadgeViewportEventListener;
import com.facebook.resources.ui.FbTextView;
import com.facebook.search.abtest.VideoSearchExperimentHelper;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.GraphSearchQuery.ModifierKeys;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.api.GraphSearchQuery.ScopedSearchStyle;
import com.facebook.search.api.GraphSearchQueryProvider;
import com.facebook.search.api.GraphSearchQueryTabModifier.Builder;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.user.model.User;
import com.facebook.video.analytics.VideoAnalytics.CacheStatus;
import com.facebook.video.analytics.VideoAnalytics.ClickTarget;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.TTIType;
import com.facebook.video.analytics.VideoHomePerfLogger;
import com.facebook.video.exoserviceclient.ExoServiceClient.PrefetchOrigin;
import com.facebook.video.followvideos.nux.FollowVideosNuxBubbleController;
import com.facebook.video.prefetch.VideoPrefetchHelper;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.adapter.VideoHomeLiveStatusListener;
import com.facebook.video.videohome.audio.VideoHomeInlineAudioManager;
import com.facebook.video.videohome.autoplay.VideoHomeCenteredAutoplayManager;
import com.facebook.video.videohome.data.VideoHomeComposerItem;
import com.facebook.video.videohome.data.VideoHomeDataController;
import com.facebook.video.videohome.data.VideoHomeDataControllerProvider;
import com.facebook.video.videohome.environment.CanFetchHScrollSubComponentsImpl;
import com.facebook.video.videohome.environment.VideoHomeEnvironmentImpl;
import com.facebook.video.videohome.environment.VideoHomeEnvironmentImplProvider;
import com.facebook.video.videohome.environment.VideoHomeHScrollLoggingController;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.facebook.video.videohome.metadata.VideoHomeMetadataFetcher;
import com.facebook.video.videohome.pagination.VideoHomePaginationCoordinator;
import com.facebook.video.videohome.partdefinitions.VideoHomeRootPartDefinition;
import com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper;
import com.facebook.video.videohome.prefs.VideoHomePrefKeys;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager.SessionStatusListener;
import com.facebook.video.videohome.sessionmanager.session.VideoHomeSession;
import com.facebook.video.videohome.utils.VideoHomeLiveUpdatesHelper;
import com.facebook.video.videohome.views.VideoHomeComposerOnClickListenerProvider;
import com.facebook.video.videohome.views.VideoHomeComposerView;
import com.facebook.video.videohome.views.VideoHomePillUIController;
import com.facebook.video.videohome.views.VideoHomePillUIController.AnimationSpringListener;
import com.facebook.video.videohome.views.VideoHomePillUIController.AnimationState;
import com.facebook.video.videohome.views.VideoHomePillUIController.C03101;
import com.facebook.widget.FbSwipeRefreshLayout;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: spend_limit */
public class VideoHomeHomeFragment extends FbFragment implements AnalyticsFragment, ReactionSessionListener, GraphSearchQueryProvider, SessionStatusListener {
    private static final String aW = VideoHomeHomeFragment.class.getSimpleName();
    public static final Handler aX = new Handler(Looper.getMainLooper());
    private static final GraphSearchQuery aY;
    @Inject
    Fb4aTitleBarSupplier f2937a;
    @Inject
    public ReactionSessionManager aA;
    @Inject
    FollowVideosNuxBubbleController aB;
    @Inject
    VideoHomeLiveUpdatesHelper aC;
    @Inject
    Lazy<DisabledFeedStoryMenuHelper> aD;
    @Inject
    MultiRowFeedLifecycleSubscribers aE;
    @Inject
    FrameRateLoggerProvider aF;
    @Inject
    ReactionThemedContextHelper aG;
    @Inject
    RedSpaceOptimisticBadgeViewportEventListener aH;
    @Inject
    RedSpaceOptimisticBadgeStore aI;
    @Inject
    VideoHomeInlineAudioManager aJ;
    @Inject
    VideoHomeDataControllerProvider aK;
    @Inject
    LiveStatusTracker aL;
    @Inject
    VideoHomeLiveStatusListener aM;
    @Inject
    VideoHomeConfig aN;
    @Inject
    VideoHomeCenteredAutoplayManager aO;
    @Inject
    VideoHomeEnvironmentImplProvider aP;
    @Inject
    MultiRowAdapterBuilder aQ;
    @Inject
    Lazy<VideoHomeRootPartDefinition> aR;
    @Inject
    @LoggedInUser
    Provider<User> aS;
    @Inject
    ComposerFacecastCapability aT;
    @Inject
    VideoHomeComposerOnClickListenerProvider aU;
    @Inject
    DefaultPresenceManager aV;
    private final List<GraphQLStory> aZ = new LinkedList();
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager al;
    @Inject
    public VideoHomeLoggingUtils am;
    @Inject
    VideoHomeMetadataFetcher an;
    @Inject
    @Nullable
    public VideoHomePillUIController ao;
    @Inject
    MonotonicClock ap;
    @Inject
    MultipleRowsStoriesRecycleCallback aq;
    @Inject
    ViewportMonitor ar;
    @Inject
    FeedLoggingViewportEventListener as;
    @Inject
    public VideoHomePerfLogger at;
    @Inject
    VideoHomeHScrollLoggingController au;
    @Inject
    VideoPrefetchVisitorProvider av;
    @Inject
    FbEventSubscriberListManager aw;
    @Inject
    FeedEventBus ax;
    @Inject
    VideoSearchExperimentHelper ay;
    @Inject
    VideoPrefetchHelper az;
    @Inject
    QeAccessor f2938b;
    private boolean bA = false;
    public boolean bB = false;
    private VideoHomeDataController bC;
    private LiveVideoCollectionListener bD;
    private VideoHomeComposerItem bE;
    private VideoHomeEnvironmentImpl bF;
    public OnDrawListener bG;
    public PresenceListener bH;
    private TTIType ba = TTIType.INIT;
    public CacheStatus bb = CacheStatus.NOT_PREFETCHED;
    private long bc = -1;
    public View bd;
    private boolean be;
    private boolean bf;
    private boolean bg = false;
    private Fb4aTitleBar bh;
    private OnActionButtonClickListener bi;
    private OnActionButtonClickListener bj;
    private TitleBarButtonSpec bk;
    private TitleBarButtonSpec bl;
    private int bm;
    @Nullable
    public MultiRowRecyclerViewAdapter bn;
    @Nullable
    public SelfRegistrableReceiverImpl bo;
    private Parcelable bp;
    @Nullable
    private VideoPrefetchVisitor bq;
    private int br;
    public SwipeRefreshLayout bs;
    private View bt;
    private FrameRateLogger bu;
    public BetterLinearLayoutManager bv;
    public MultiRowAdapterRecyclerViewProxy bw;
    private ViewGroup bx;
    private ReactionAnalyticsParams by;
    public ReactionSession bz;
    @Inject
    public FbSharedPreferences f2939c;
    @Inject
    public VideoHomeReactionSessionHelper f2940d;
    @Inject
    Lazy<SecureContextHelper> f2941e;
    @Inject
    public ReactionSessionManager f2942f;
    @Inject
    public VideoHomeSessionManager f2943g;
    @Inject
    Lazy<UriIntentMapper> f2944h;
    @Inject
    AppTabBarBroadcaster f2945i;

    /* compiled from: spend_limit */
    public class C02751 implements OnDrawListener {
        final /* synthetic */ VideoHomeHomeFragment f2925a;

        public C02751(VideoHomeHomeFragment videoHomeHomeFragment) {
            this.f2925a = videoHomeHomeFragment;
        }

        public final boolean gD_() {
            this.f2925a.bG = null;
            VideoHomeHomeFragment.av(this.f2925a);
            return true;
        }
    }

    /* compiled from: spend_limit */
    public class C02762 {
        final /* synthetic */ VideoHomeHomeFragment f2926a;

        C02762(VideoHomeHomeFragment videoHomeHomeFragment) {
            this.f2926a = videoHomeHomeFragment;
        }

        public final void m2830a() {
            this.f2926a.bn.notifyDataSetChanged();
        }
    }

    /* compiled from: spend_limit */
    class C02773 implements Runnable {
        final /* synthetic */ VideoHomeHomeFragment f2927a;

        C02773(VideoHomeHomeFragment videoHomeHomeFragment) {
            this.f2927a = videoHomeHomeFragment;
        }

        public void run() {
            this.f2927a.bn.notifyDataSetChanged();
        }
    }

    /* compiled from: spend_limit */
    class C02784 implements ListItemCollectionEndProvider {
        final /* synthetic */ VideoHomeHomeFragment f2928a;

        C02784(VideoHomeHomeFragment videoHomeHomeFragment) {
            this.f2928a = videoHomeHomeFragment;
        }

        public final boolean m2831a() {
            return VideoHomeHomeFragment.as(this.f2928a);
        }
    }

    /* compiled from: spend_limit */
    public class C02806 implements OnClickListener {
        final /* synthetic */ VideoHomeHomeFragment f2931a;

        public C02806(VideoHomeHomeFragment videoHomeHomeFragment) {
            this.f2931a = videoHomeHomeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -827796352);
            this.f2931a.bs.setRefreshing(true);
            VideoHomeHomeFragment.aX(this.f2931a);
            Logger.a(2, EntryType.UI_INPUT_END, 2059570391, a);
        }
    }

    /* compiled from: spend_limit */
    public class C02817 implements OnClickListener {
        final /* synthetic */ VideoHomeHomeFragment f2932a;

        public C02817(VideoHomeHomeFragment videoHomeHomeFragment) {
            this.f2932a = videoHomeHomeFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1854932805);
            ((FbSwipeRefreshLayout) this.f2932a.e(2131561342)).setRefreshing(true);
            VideoHomeHomeFragment.aF(this.f2932a);
            VideoHomeHomeFragment.ay(this.f2932a);
            this.f2932a.am.a(PlayerOrigin.VIDEO_HOME, ClickTarget.NEW_ITEMS_PILL);
            this.f2932a.bb = CacheStatus.NOT_PREFETCHED;
            VideoHomeHomeFragment.m2843a(this.f2932a, TTIType.RELOAD);
            VideoHomeHomeFragment.aX(this.f2932a);
            Logger.a(2, EntryType.UI_INPUT_END, 1149951607, a);
        }
    }

    /* compiled from: spend_limit */
    class C02828 implements OnRefreshListener {
        final /* synthetic */ VideoHomeHomeFragment f2933a;

        C02828(VideoHomeHomeFragment videoHomeHomeFragment) {
            this.f2933a = videoHomeHomeFragment;
        }

        public final void m2834a() {
            this.f2933a.bs.setRefreshing(true);
            VideoHomeHomeFragment videoHomeHomeFragment = this.f2933a;
            videoHomeHomeFragment.bb = CacheStatus.NOT_PREFETCHED;
            VideoHomeHomeFragment.m2843a(videoHomeHomeFragment, TTIType.PULL_TO_REFRESH);
            videoHomeHomeFragment.am.a(PlayerOrigin.VIDEO_HOME);
            ReactionSession reactionSession = videoHomeHomeFragment.bz;
            if (reactionSession != null) {
                reactionSession.y.p = RequestType.PULL_TO_REFRESH;
            }
            reactionSession.q = false;
            VideoHomeHomeFragment.aX(this.f2933a);
        }
    }

    /* compiled from: spend_limit */
    public class C02839 implements ActionReceiver {
        final /* synthetic */ VideoHomeHomeFragment f2934a;

        public C02839(VideoHomeHomeFragment videoHomeHomeFragment) {
            this.f2934a = videoHomeHomeFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1368090999);
            AppTabBarBroadcaster appTabBarBroadcaster = this.f2934a.f2945i;
            Object a2 = AppTabBarBroadcaster.a(intent);
            if (!TextUtils.isEmpty(a2) && TabTag.VideoHome.equals(TabTag.fromName(a2))) {
                VideoHomeHomeFragment.aF(this.f2934a);
                VideoHomeHomeFragment videoHomeHomeFragment = this.f2934a;
                View c = videoHomeHomeFragment.bv.c(0);
                if (c != null && c.getTop() == 0) {
                    videoHomeHomeFragment.bs.setRefreshing(true);
                    VideoHomeHomeFragment.aX(videoHomeHomeFragment);
                }
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 301299835, a);
        }
    }

    /* compiled from: spend_limit */
    class FeedUnitMutatedEventSubscriber extends com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEventSubscriber {
        final /* synthetic */ VideoHomeHomeFragment f2935a;
        private final VideoHomeDataController f2936b;

        public final void m2835b(FbEvent fbEvent) {
            FeedUnitMutatedEvent feedUnitMutatedEvent = (FeedUnitMutatedEvent) fbEvent;
            if (feedUnitMutatedEvent.a instanceof GraphQLStory) {
                this.f2936b.m2696a((GraphQLStory) feedUnitMutatedEvent.a);
            }
        }

        public FeedUnitMutatedEventSubscriber(VideoHomeHomeFragment videoHomeHomeFragment, VideoHomeDataController videoHomeDataController) {
            this.f2935a = videoHomeHomeFragment;
            this.f2936b = videoHomeDataController;
        }
    }

    public static void m2845a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((VideoHomeHomeFragment) obj).m2841a(Fb4aTitleBarSupplier.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), VideoHomeReactionSessionHelper.m3130a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 968), ReactionSessionManager.a(injectorLike), VideoHomeSessionManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2436), AppTabBarBroadcaster.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), VideoHomeLoggingUtils.a(injectorLike), VideoHomeMetadataFetcher.a(injectorLike), VideoHomePillUIController.m3184a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), MultipleRowsStoriesRecycleCallback.a(injectorLike), ViewportMonitor.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), VideoHomePerfLogger.a(injectorLike), VideoHomeHScrollLoggingController.m2773a(injectorLike), (VideoPrefetchVisitorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoPrefetchVisitorProvider.class), FbEventSubscriberListManager.a(injectorLike), FeedEventBus.a(injectorLike), VideoSearchExperimentHelper.a(injectorLike), VideoPrefetchHelper.m2636a(injectorLike), ReactionSessionManager.a(injectorLike), FollowVideosNuxBubbleController.m2632a(injectorLike), VideoHomeLiveUpdatesHelper.m3155a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 6073), MultiRowFeedLifecycleSubscribers.a(injectorLike), (FrameRateLoggerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), ReactionThemedContextHelper.a(injectorLike), RedSpaceOptimisticBadgeViewportEventListener.a(injectorLike), RedSpaceOptimisticBadgeStore.a(injectorLike), VideoHomeInlineAudioManager.m2658a(injectorLike), (VideoHomeDataControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoHomeDataControllerProvider.class), LiveStatusTracker.a(injectorLike), VideoHomeLiveStatusListener.m2648a(injectorLike), VideoHomeConfig.a(injectorLike), VideoHomeCenteredAutoplayManager.m2669a(injectorLike), (VideoHomeEnvironmentImplProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoHomeEnvironmentImplProvider.class), MultiRowAdapterBuilder.a(injectorLike), IdBasedLazy.a(injectorLike, 11678), IdBasedProvider.a(injectorLike, 3595), ComposerFacecastCapability.a(injectorLike), (VideoHomeComposerOnClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoHomeComposerOnClickListenerProvider.class), DefaultPresenceManager.a(injectorLike));
    }

    static {
        GraphSearchQuery a = GraphSearchQuery.a(ScopedEntityType.VIDEO, "", "", ScopedSearchStyle.TAB, true);
        aY = a;
        ModifierKeys modifierKeys = ModifierKeys.SCOPED_TAB;
        Builder builder = new Builder();
        builder.a = true;
        a.a(modifierKeys, builder.a());
    }

    public final void m2862c(@Nullable Bundle bundle) {
        String str;
        Class cls = VideoHomeHomeFragment.class;
        m2845a((Object) this, getContext());
        this.f2943g.a(this);
        aq();
        super.c(bundle);
        bf();
        ReactionAnalyticsParams reactionAnalyticsParams = this.s == null ? null : (ReactionAnalyticsParams) this.s.getParcelable("extra_reaction_analytics_params");
        if (this.bz == null) {
            str = "unknown";
        } else {
            str = this.bz.c.name();
        }
        this.by = new ReactionAnalyticsParams(reactionAnalyticsParams, str, "unknown", null);
        this.bu = this.aF.a(Boolean.valueOf(false), "reaction_fragment_scroll_perf", Optional.of(String.valueOf(am_())));
        this.at.a.a(1900553, (short) 102);
        this.aA.a(this.bz.a, this);
        ba();
        this.bo = this.al.a().a("com.facebook.apptab.ui.TAB_BAR_ITEM_TAP", new C02839(this)).a();
        this.bo.b();
        this.an.a(this);
        m2840a(this.bz, this.f2938b.a(ExperimentsForVideoHomeAbTestModule.z, 2));
        this.at.a.a(1900553, (short) 78);
    }

    private void aq() {
        if (this.be && !this.f2943g.g()) {
            this.bb = au();
            this.f2943g.a(this.bb);
            m2843a(this, TTIType.INIT);
        }
    }

    public final View m2857a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -390006469);
        super.a(layoutInflater, viewGroup, bundle);
        Preconditions.checkNotNull(this.bz);
        View b = m2847b(viewGroup, this.bz);
        this.at.a.a(1900553, (short) 101);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 587088761, a);
        return b;
    }

    public static boolean as(VideoHomeHomeFragment videoHomeHomeFragment) {
        if (videoHomeHomeFragment.bz == null || !videoHomeHomeFragment.bC.f2812d.f2990b) {
            return false;
        }
        if (videoHomeHomeFragment.bC.f2812d.m2885c() || videoHomeHomeFragment.bz.p) {
            return true;
        }
        return false;
    }

    private View m2836a(ViewGroup viewGroup, ReactionSession reactionSession) {
        Context a = ReactionThemedContextHelper.a(getContext(), reactionSession.w());
        LayoutInflater from = LayoutInflater.from(a);
        ViewGroup a2 = m2837a(from, viewGroup);
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) FindViewUtil.b(a2, 16908298);
        this.bv = new LayoutManagerWithKeepAttachedHack(betterRecyclerView);
        betterRecyclerView.setLayoutManager(this.bv);
        this.bw = new MultiRowAdapterRecyclerViewProxy(betterRecyclerView);
        this.bC = this.aK.m2700a(new C02762(this));
        this.bF = this.aP.m2766a(a, aO(), (BaseFeedStoryMenuHelper) this.aD.get(), new C02773(this), this.by, this.bz.f(), bl(), this.bC.m2695a(), this.aL, new CanFetchHScrollSubComponentsImpl(this.bC, this.bz));
        if (this.bn == null) {
            this.bn = at();
            m2848b(from, a2);
            m2852c(from, a2);
        }
        this.bw.a(this.bn);
        bi();
        ImmutableList p = reactionSession.p();
        int size = p.size();
        for (int i = 0; i < size; i++) {
            this.bC.m2697a((ReactionStories) p.get(i));
        }
        if (!this.aN.b) {
            this.aL.a(this.aM);
        }
        this.bE = new VideoHomeComposerItem();
        this.bC.m2695a().a(0, this.bE);
        this.aw.a(new FeedUnitMutatedEventSubscriber(this, this.bC));
        bj();
        this.bB = true;
        return a2;
    }

    private MultiRowRecyclerViewAdapter at() {
        C02784 c02784 = new C02784(this);
        MultiRowAdapterBuilder.Builder a = this.aQ.a(this.aR, this.bC.f2811c);
        a.f = this.bF;
        return a.a(c02784).a(this.bw).d();
    }

    private View m2847b(ViewGroup viewGroup, ReactionSession reactionSession) {
        View view = (ViewGroup) m2836a(viewGroup, reactionSession);
        Button button = (Button) view.findViewById(2131568423);
        if (button != null) {
            button.setOnClickListener(new C02806(this));
        }
        m2851c(view);
        Preconditions.checkNotNull(this.ao);
        this.bd = view.findViewById(2131562157);
        ((FbTextView) view.findViewById(2131561943)).setText(2131237314);
        VideoHomePillUIController videoHomePillUIController = this.ao;
        videoHomePillUIController.f3359e = this.bd;
        videoHomePillUIController.f3361g = new AnimationSpringListener(videoHomePillUIController);
        videoHomePillUIController.f3360f = videoHomePillUIController.f3356b.a().a(0.0d).a(videoHomePillUIController.f3361g).a(VideoHomePillUIController.f3355a);
        videoHomePillUIController.f3359e.setOnTouchListener(new C03101(videoHomePillUIController));
        videoHomePillUIController.f3362h = AnimationState.HIDDEN;
        this.bd.setOnClickListener(new C02817(this));
        if (this.bz.z()) {
            if (this.bG != null) {
                this.bw.b(this.bG);
            }
            aI();
        }
        FollowVideosNuxBubbleController followVideosNuxBubbleController = this.aB;
        followVideosNuxBubbleController.f2742a = view;
        followVideosNuxBubbleController.f2743b.a(followVideosNuxBubbleController.f2742a, new InterstitialTrigger(Action.VIDEO_HOME_FEED));
        final MultiRowAdapterRecyclerViewProxy multiRowAdapterRecyclerViewProxy = this.bw;
        multiRowAdapterRecyclerViewProxy.a(this.aq.a());
        multiRowAdapterRecyclerViewProxy.a(new OnScrollListener(this) {
            final /* synthetic */ VideoHomeHomeFragment f2930b;

            public final void m2832a(ScrollingViewProxy scrollingViewProxy, int i) {
                if (i == 0) {
                    this.f2930b.ar.b(scrollingViewProxy);
                    this.f2930b.aO.f2798a.d();
                } else if (i == 2) {
                    this.f2930b.aO.f2798a.c();
                } else if (i == 1) {
                    this.f2930b.aO.f2798a.d();
                }
                this.f2930b.aB.m2634a(scrollingViewProxy, i);
            }

            public final void m2833a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
                this.f2930b.aB.m2635a(multiRowAdapterRecyclerViewProxy, i, i2, i3);
            }
        });
        multiRowAdapterRecyclerViewProxy.a(this.bn);
        return view;
    }

    public static void m2843a(VideoHomeHomeFragment videoHomeHomeFragment, TTIType tTIType) {
        if (videoHomeHomeFragment.be && videoHomeHomeFragment.bc <= 0) {
            videoHomeHomeFragment.ba = tTIType;
            videoHomeHomeFragment.bc = videoHomeHomeFragment.ap.now();
            videoHomeHomeFragment.bG = new C02751(videoHomeHomeFragment);
            VideoHomePerfLogger videoHomePerfLogger = videoHomeHomeFragment.at;
            CacheStatus cacheStatus = videoHomeHomeFragment.bb;
            TTIType tTIType2 = videoHomeHomeFragment.ba;
            videoHomePerfLogger.a.b(1900553);
            videoHomePerfLogger.a.a(1900553, "is_cached_" + cacheStatus);
            videoHomePerfLogger.a.a(1900553, "loading_type_" + tTIType2);
        }
    }

    private CacheStatus au() {
        Object obj = 1;
        if ((this.bz != null ? 1 : null) == null) {
            if (aV() == null) {
                obj = null;
            }
            if (obj == null) {
                return CacheStatus.NOT_PREFETCHED;
            }
            ReactionSession b = this.f2942f.b(aV());
            if (b == null || !b.A()) {
                return CacheStatus.PREFETCH_ONGOING;
            }
            return CacheStatus.PREFETCHED_NOT_LOADED;
        } else if (this.f2940d.m3144e()) {
            return CacheStatus.PREFETCHED_LOADED;
        } else {
            if (this.f2940d.f3308r) {
                return CacheStatus.STALED;
            }
            return CacheStatus.LOADED;
        }
    }

    public static void av(VideoHomeHomeFragment videoHomeHomeFragment) {
        if (videoHomeHomeFragment.be && videoHomeHomeFragment.bc >= 0) {
            videoHomeHomeFragment.am.a(PlayerOrigin.VIDEO_HOME, videoHomeHomeFragment.ba, videoHomeHomeFragment.bb, videoHomeHomeFragment.ap.now() - videoHomeHomeFragment.bc);
            videoHomeHomeFragment.bc = -1;
            VideoHomePerfLogger videoHomePerfLogger = videoHomeHomeFragment.at;
            if (videoHomePerfLogger.a.f(1900553)) {
                videoHomePerfLogger.a.b(1900553, (short) 2);
            }
        }
    }

    private String aV() {
        Bundle bundle = this.s;
        return bundle == null ? null : bundle.getString("reaction_session_id");
    }

    @Nullable
    private View m2851c(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(2131562959);
        if (linearLayout != null) {
            if (this.aT.a(TargetType.UNDIRECTED)) {
                aw();
            }
            int i = (int) (((double) jW_().getDisplayMetrics().widthPixels) / 1.0d);
            int i2 = (jW_().getDisplayMetrics().heightPixels / i) + 1;
            for (int i3 = 0; i3 < i2; i3++) {
                View view2 = new View(getContext());
                view2.setBackgroundResource(2131363380);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i);
                layoutParams.bottomMargin = (int) (((double) (4.0f * jW_().getDisplayMetrics().density)) + 0.5d);
                view2.setLayoutParams(layoutParams);
                linearLayout.addView(view2);
            }
        }
        return linearLayout;
    }

    private void aw() {
        User user = (User) this.aS.get();
        VideoHomeComposerView videoHomeComposerView = new VideoHomeComposerView(getContext());
        videoHomeComposerView.f3339a.a(UriUtil.a(user.x()), CallerContext.a(videoHomeComposerView.getClass()));
        videoHomeComposerView.f3340b.setText(user.e.g());
        videoHomeComposerView.setOnClickListener(this.aU.m3173a(o()));
        this.bx.addView(videoHomeComposerView, 0);
    }

    public static void ay(VideoHomeHomeFragment videoHomeHomeFragment) {
        if (videoHomeHomeFragment.ao != null) {
            VideoHomePillUIController videoHomePillUIController = videoHomeHomeFragment.ao;
            if (!AnimationState.HIDDEN.equals(videoHomePillUIController.f3362h) && !VideoHomePillUIController.m3191k(videoHomePillUIController)) {
                videoHomePillUIController.f3362h = AnimationState.HIDING;
                videoHomePillUIController.f3360f.b(0.0d);
            }
        }
    }

    private FrameLayout m2837a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(2130907722, viewGroup, false);
        this.bs = (FbSwipeRefreshLayout) FindViewUtil.b(frameLayout, 2131561342);
        this.bs.e = new C02828(this);
        this.bs.setEnabled(true);
        return frameLayout;
    }

    public final String am_() {
        return "video_home";
    }

    private LiveVideoCollectionListener aA() {
        if (this.bD == null) {
            this.bD = new LiveVideoCollectionListener(this.aM, this.aN, this.aL, this.aZ, bc());
        }
        return this.bD;
    }

    private void aB() {
        boolean z = false;
        View c = this.bv.c(0);
        SwipeRefreshLayout swipeRefreshLayout = this.bs;
        if (c != null && c.getTop() == 0) {
            z = true;
        }
        swipeRefreshLayout.setEnabled(z);
        aI();
        aJ();
        aC();
    }

    private void aC() {
        if (this.bn != null) {
            int n = this.bv.n();
            if (as(this) && n > 0) {
                n--;
            }
            if ((this.bn.aZ_() - 1) - n <= aD()) {
                this.bC.m2698a(this.bF, this.bn.s_(n), this.bz);
            }
        }
    }

    private int aD() {
        return this.f2938b.a(ExperimentsForVideoHomeAbTestModule.q, 25);
    }

    private static void m2840a(@Nullable ReactionSession reactionSession, int i) {
        if (reactionSession != null && reactionSession.y != null) {
            reactionSession.y.b = (long) i;
        }
    }

    public static void aF(VideoHomeHomeFragment videoHomeHomeFragment) {
        if (videoHomeHomeFragment.bw != null) {
            videoHomeHomeFragment.bw.e(0);
        }
    }

    private void aI() {
        if (this.bn != null && aN()) {
            this.bC.m2699e();
            aC();
        }
    }

    private void aJ() {
        int i = 1;
        if (this.bn != null) {
            int n = this.bv.n();
            if (n != this.br) {
                int i2 = this.br > n ? 1 : 0;
                this.br = n;
                if (i2 != 0) {
                    while (n - i >= 0 && i <= aK()) {
                        m2844a(this.bn.getItem(n - i));
                        i++;
                    }
                    return;
                }
                while (n + i < this.bn.aZ_() && i <= aK()) {
                    m2844a(this.bn.getItem(n + i));
                    i++;
                }
            }
        }
    }

    private void m2844a(@Nullable Object obj) {
        if (obj instanceof BoundedAdapter) {
            BoundedAdapter boundedAdapter = (BoundedAdapter) obj;
            if (boundedAdapter.c() instanceof ReactionUnitComponentNode) {
                ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) boundedAdapter.c();
                if (reactionUnitComponentNode.b != null) {
                    GraphQLStory ax = reactionUnitComponentNode.b.ax();
                    if (this.aZ.contains(ax)) {
                        GraphQLStoryAttachment o = StoryAttachmentHelper.o(ax);
                        if (!(o == null || o.r() == null)) {
                            this.az.m2640b(o, PrefetchOrigin.VIDEO_HOME);
                        }
                        this.aZ.remove(ax);
                    }
                }
            }
        }
    }

    private int aK() {
        return this.f2938b.a(ExperimentsForVideoHomeAbTestModule.u, 6);
    }

    public final void kQ_() {
        this.bB = false;
        bi();
        this.bC.f2811c.a(this.bE);
        m2839a(this.bz);
        be();
        bk(this);
        aL();
        aI();
        this.aC.m3165b(this.bz);
    }

    public final void kp_() {
        m2853h(false);
        be();
        this.bA = true;
        aL();
        this.at.a(false);
    }

    private void aL() {
        if (this.bs != null) {
            this.bs.setRefreshing(false);
        }
    }

    private void m2839a(@Nullable ReactionSession reactionSession) {
        if (reactionSession != null && reactionSession.A()) {
            this.bF.a(SystemClock.uptimeMillis());
            ImmutableList p = reactionSession.p();
            int size = p.size();
            for (int i = 0; i < size; i++) {
                this.bC.m2697a((ReactionStories) p.get(i));
            }
            m2853h(false);
            m2840a(reactionSession, this.f2938b.a(ExperimentsForVideoHomeAbTestModule.z, 2));
            this.bC.m2699e();
            aM();
            if (this.bG != null) {
                this.bw.b(this.bG);
            }
            if (this.be) {
                this.at.a.a(1900553, (short) 31);
            }
        }
    }

    private void aM() {
        if (this.be) {
            this.f2943g.b.a(Event.SAW_DATA);
        }
    }

    private boolean aN() {
        if (this.bn == null || this.bv.n() < (this.bn.aZ_() - aD()) - 1) {
            return false;
        }
        if ((!this.bC.f2812d.f2990b ? 1 : null) == null) {
            return true;
        }
        return false;
    }

    public final void m2860a(ReactionStories reactionStories) {
        if (this.bw.o() == null) {
            m2839a(this.bz);
            return;
        }
        this.bC.m2697a(reactionStories);
        aI();
    }

    private FeedListType aO() {
        return new FeedListType(this) {
            final /* synthetic */ VideoHomeHomeFragment f2917a;

            {
                this.f2917a = r1;
            }

            public final FeedListName m2824a() {
                return FeedListName.VIDEO_HOME;
            }
        };
    }

    public final GraphSearchQuery m2865q() {
        return this.ay.a() ? aY : GraphSearchQuery.e;
    }

    public final void m2855H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1092653947);
        super.H();
        MultiRowAdapterRecyclerViewProxy multiRowAdapterRecyclerViewProxy = this.bw;
        this.bp = multiRowAdapterRecyclerViewProxy.B();
        this.ar.c(multiRowAdapterRecyclerViewProxy);
        this.au.m2776a();
        this.at.a(true);
        if (bd()) {
            this.bC.f2811c.m2730b(aA());
        }
        if (this.ax != null) {
            this.aw.b(this.ax);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1544404143, a);
    }

    public final void m2854G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -868823737);
        super.G();
        if (this.aE != null) {
            this.aE.a();
        }
        if (this.bp != null) {
            this.bw.a(this.bp);
        }
        if (this.be) {
            this.as.a("video_home");
        }
        if (bd()) {
            this.bC.f2811c.m2729a(aA());
        }
        if (this.ax != null) {
            this.aw.a(this.ax);
        }
        if (this.f2940d.f3308r) {
            aS();
            aX(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -343533315, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 100108722);
        super.mi_();
        aP();
        Bundle bundle = this.s;
        if (bundle != null) {
            String string = bundle.getString("source_name");
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.a_(string);
            }
        }
        this.bh = this.f2937a.a;
        this.bw.b(this.ar);
        this.ar.a(this.as);
        if (bb()) {
            this.ar.a(this.aH);
        }
        this.aJ.m2660c();
        if (this.f2943g.g()) {
            if (this.bg) {
                if (this.f2943g.i()) {
                    this.f2943g.c();
                }
                this.bg = false;
            }
            if (this.f2943g.h()) {
                VideoHomeSessionManager videoHomeSessionManager = this.f2943g;
                videoHomeSessionManager.b.a(Event.RESUME);
                VideoHomeSession videoHomeSession = videoHomeSessionManager.d;
                if (videoHomeSession.d == null) {
                    videoHomeSession.b.b(videoHomeSession.a, "Foreground a session before session start.");
                } else if (!videoHomeSession.f) {
                    videoHomeSession.b.b(videoHomeSession.a, "Session is already in foreground.");
                    videoHomeSessionManager.c.a();
                }
                videoHomeSession.f = false;
                videoHomeSession.g = videoHomeSession.c.a();
                videoHomeSessionManager.c.a();
            }
            this.an.a(this);
            this.f2939c.edit().putBoolean(VideoHomePrefKeys.c, true).commit();
            LogUtils.f(2140314700, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 973266448, a);
    }

    private void aP() {
        if (bd() && this.be) {
            VideoPrefetchVisitor bc = bc();
            if (!bc.c()) {
                bc.a();
            }
            this.az.f2745b.b(PrefetchOrigin.VIDEO_HOME.toString());
        }
    }

    private void aQ() {
        VideoPrefetchVisitor bc = bc();
        if (bc.c()) {
            bc.b();
        }
        this.az.f2745b.a(PrefetchOrigin.VIDEO_HOME.toString());
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2035822341);
        super.mj_();
        aQ();
        this.bw.c(this.ar);
        this.ar.b(this.as);
        if (bb()) {
            this.ar.b(this.aH);
        }
        if (this.f2943g.g()) {
            if (this.f2943g.i()) {
                this.bg = false;
            } else {
                if (!this.f2943g.i()) {
                    this.f2943g.b();
                }
                this.bg = true;
            }
            if (!this.f2943g.h()) {
                VideoHomeSessionManager videoHomeSessionManager = this.f2943g;
                videoHomeSessionManager.b.a(Event.PAUSE);
                long g = videoHomeSessionManager.d.g();
                VideoHomeSession videoHomeSession = videoHomeSessionManager.d;
                if (videoHomeSession.d == null) {
                    videoHomeSession.b.b(videoHomeSession.a, "Background a session before session start.");
                } else if (videoHomeSession.f) {
                    videoHomeSession.b.b(videoHomeSession.a, "Session is already in background.");
                    videoHomeSessionManager.c.d(g);
                }
                videoHomeSession.f = true;
                videoHomeSession.g = 0;
                videoHomeSessionManager.c.d(g);
            }
            this.an.a(null);
            LogUtils.f(302527331, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 309151362, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1623681758);
        super.mY_();
        if (this.bs != null) {
            this.bs.e = null;
            this.bs = null;
        }
        FollowVideosNuxBubbleController followVideosNuxBubbleController = this.aB;
        followVideosNuxBubbleController.f2743b.a(followVideosNuxBubbleController.f2742a);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -517365626, a);
    }

    public final void m2856I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -275640399);
        if (this.bz != null) {
            this.aA.g(this.bz.a);
            this.bz = null;
        }
        this.aL.a();
        if (this.bn != null) {
            this.bn.jc_();
        }
        VideoHomeLiveStatusListener videoHomeLiveStatusListener = this.aM;
        for (String a2 : videoHomeLiveStatusListener.f2758c.keySet()) {
            videoHomeLiveStatusListener.f2757b.a(a2, videoHomeLiveStatusListener.f2756a);
        }
        if (this.bC != null) {
            VideoHomeDataController videoHomeDataController = this.bC;
            videoHomeDataController.f2809a.a();
            videoHomeDataController.f2811c.m2730b(videoHomeDataController.f2819k);
        }
        super.I();
        if (this.bo != null) {
            this.bo.c();
            this.bo = null;
        }
        if (this.ao != null) {
            VideoHomePillUIController videoHomePillUIController = this.ao;
            if (videoHomePillUIController.f3360f != null) {
                videoHomePillUIController.f3360f.a();
            }
            this.ao = null;
        }
        bc().d();
        if (this.f2943g.g()) {
            this.f2943g.a();
        }
        this.f2943g.b(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -749926347, a);
    }

    public final void m2864g(boolean z) {
        super.g(z);
        this.be = z;
        if (this.bf != z && this.f2943g != null) {
            this.bf = z;
            aq();
            if (z) {
                this.as.a("video_home");
                aP();
                this.aJ.m2660c();
            } else {
                this.as.a("unknown");
                aQ();
            }
            m2846a(z);
            m2850b(z);
            MultiRowAdapterRecyclerViewProxy multiRowAdapterRecyclerViewProxy = this.bw;
            if (multiRowAdapterRecyclerViewProxy != null) {
                if (z) {
                    this.ar.a(multiRowAdapterRecyclerViewProxy);
                } else {
                    this.ar.c(multiRowAdapterRecyclerViewProxy);
                }
            }
            if (!z) {
                this.at.a(true);
                this.f2943g.a();
                this.au.m2776a();
            }
            if (z && this.bb == CacheStatus.LOADED) {
                av(this);
            }
        }
    }

    private void m2846a(boolean z) {
        if (this.f2940d.f3308r) {
            if (z) {
                aT();
            } else {
                aS();
            }
        } else if (z && this.bz != null && this.bz.z()) {
            aM();
        }
    }

    private void aS() {
        if (this.bw != null) {
            MultiRowAdapterRecyclerViewProxy multiRowAdapterRecyclerViewProxy = this.bw;
            multiRowAdapterRecyclerViewProxy.c.scrollBy(0 - multiRowAdapterRecyclerViewProxy.c.getScrollX(), 0 - multiRowAdapterRecyclerViewProxy.c.getScrollY());
        }
        bi();
        this.bz.a();
        ay(this);
        m2853h(true);
    }

    private boolean aT() {
        this.bB = true;
        if (this.f2940d.m3144e()) {
            aS();
            bf();
            m2849b(this.bz);
        } else {
            this.f2942f.f(bh(this));
        }
        this.f2940d.m3141a(false);
        this.f2940d.m3143c();
        return true;
    }

    private void m2849b(ReactionSession reactionSession) {
        if (reactionSession != null && reactionSession.z()) {
            reactionSession.p = true;
            reactionSession.a(this);
            kQ_();
            aM();
        }
    }

    private String aU() {
        String b = this.f2940d.m3142b();
        if (b == null) {
            b = aV();
        } else {
            ReactionSession reactionSession = this.bz;
            if (reactionSession != null) {
                this.f2942f.g(reactionSession.a);
            }
        }
        if (b != null) {
            this.f2940d.m3141a(false);
        }
        return b;
    }

    public static void aX(VideoHomeHomeFragment videoHomeHomeFragment) {
        m2840a(videoHomeHomeFragment.bz, videoHomeHomeFragment.f2938b.a(ExperimentsForVideoHomeAbTestModule.A, 2));
        videoHomeHomeFragment.bc().d();
        videoHomeHomeFragment.bB = true;
        videoHomeHomeFragment.aA.f(bh(videoHomeHomeFragment));
        videoHomeHomeFragment.f2940d.m3141a(false);
    }

    public final void m2859a(int i, int i2, @Nullable Intent intent) {
        super.a(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.bb = CacheStatus.NOT_PREFETCHED;
                    m2843a(this, TTIType.RELOAD);
                    aX(this);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private boolean aZ() {
        return this.f2938b.a(ExperimentsForVideoHomeAbTestModule.n, false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.bn.a(configuration);
    }

    private void ba() {
        if (aZ()) {
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.g = getContext().getString(2131237306);
            this.bl = a.a();
            this.bj = new OnActionButtonClickListener(this) {
                final /* synthetic */ VideoHomeHomeFragment f2918a;

                {
                    this.f2918a = r1;
                }

                public final void m2825a(View view) {
                    Intent a = ((UriIntentMapper) this.f2918a.f2944h.get()).a(this.f2918a.getContext(), FBLinks.fF);
                    a.putExtra("guide_fragment_tti_marker_extra", this.f2918a.ap.now());
                    a.putExtra("reaction_session_id", VideoHomeHomeFragment.bh(this.f2918a));
                    this.f2918a.am.a(PlayerOrigin.VIDEO_HOME, ClickTarget.LIVE_TOIPICS_BUTON);
                    ((SecureContextHelper) this.f2918a.f2941e.get()).a(a, 1, this.f2918a);
                }
            };
        }
    }

    private void m2850b(boolean z) {
        if (this.bh != null && aZ()) {
            if (z) {
                TitleBarButtonSpec secondaryButtonSpec = this.bh.getSecondaryButtonSpec();
                if (secondaryButtonSpec != this.bl) {
                    int i;
                    this.bk = secondaryButtonSpec;
                    this.bi = this.bh.getSecondaryActionButtonOnClickListener();
                    if (this.bh.getBadgableSecondaryActionButtonView() != null) {
                        i = this.bh.getBadgableSecondaryActionButtonView().c;
                    } else {
                        i = 0;
                    }
                    this.bm = i;
                }
                this.bh.setSecondaryButton(this.bl);
                this.bh.setSecondaryActionButtonOnClickListener(this.bj);
                return;
            }
            this.bh.setSecondaryButton(this.bk);
            this.bh.setSecondaryActionButtonOnClickListener(this.bi);
            if (this.bm > 0 && this.bh.getBadgableSecondaryActionButtonView() != null) {
                if (bb()) {
                    this.bh.getBadgableSecondaryActionButtonView().setUnreadCount(this.aI.i);
                } else {
                    this.bh.getBadgableSecondaryActionButtonView().setUnreadCount(this.bm);
                }
            }
        }
    }

    private boolean bb() {
        return this.f2938b.a(ExperimentsForRedSpaceExperimentsModule.h, false) && this.f2938b.a(ExperimentsForRedSpaceExperimentsModule.c, true);
    }

    private VideoPrefetchVisitor bc() {
        if (this.bq == null) {
            this.bq = this.av.a(VideoPrefetchLocation.VIDEO_HOME, CallerContext.a(getClass()));
        }
        return this.bq;
    }

    private boolean bd() {
        return this.f2938b.a(ExperimentsForVideoHomeAbTestModule.o, true);
    }

    private void be() {
        boolean z;
        boolean z2 = true;
        if (this.bn == null || this.bn.aZ_() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            z2 = false;
        }
        m2838a(this.bt, z2);
    }

    private void m2853h(boolean z) {
        m2838a(this.bx, z);
    }

    private void bf() {
        ReactionSession b = this.aA.b(aU());
        if (b == null) {
            this.f2940d.m3141a(false);
            b = this.f2940d.m3137a();
        }
        this.bz = b;
    }

    private static void m2838a(@Nullable View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public static String bh(VideoHomeHomeFragment videoHomeHomeFragment) {
        return videoHomeHomeFragment.bz == null ? "NO_SESSION_ID" : videoHomeHomeFragment.bz.a;
    }

    public final boolean kq_() {
        return this.bB;
    }

    public final void m2861a(String str, Optional<PendingStory> optional) {
    }

    public final void kr_() {
        if (this.bn != null) {
            this.bn.notifyDataSetChanged();
        }
    }

    private void bi() {
        if (this.bF != null) {
            this.bF.g().m2734a();
            VideoHomeDataController videoHomeDataController = this.bC;
            VideoHomePaginationCoordinator videoHomePaginationCoordinator = videoHomeDataController.f2812d;
            videoHomePaginationCoordinator.f2989a.clear();
            videoHomePaginationCoordinator.f2990b = true;
            videoHomeDataController.f2811c.c();
            videoHomeDataController.f2817i.clear();
        }
    }

    private void m2848b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.bx = (ViewGroup) layoutInflater.inflate(2130907720, viewGroup, false);
        viewGroup.addView(this.bx);
        if (this.bA || (this.bz != null && this.bz.z())) {
            m2853h(false);
        }
    }

    private void m2852c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.bt = layoutInflater.inflate(2130907714, viewGroup, false);
        viewGroup.addView(this.bt);
        m2838a(this.bt, this.bA);
    }

    private void bj() {
        this.bw.c.setOnScrollListener(new FrameRateRecyclerViewScrollListener(this, this.bu) {
            final /* synthetic */ VideoHomeHomeFragment f2920a;

            public final void m2826a(RecyclerView recyclerView, int i, int i2) {
                this.f2920a.aB();
                VideoHomeHomeFragment.bk(this.f2920a);
            }
        });
    }

    public static void bk(VideoHomeHomeFragment videoHomeHomeFragment) {
        if (videoHomeHomeFragment.aN()) {
            VideoHomeDataController videoHomeDataController = videoHomeHomeFragment.bC;
            ReactionSession reactionSession = videoHomeHomeFragment.bz;
            if (reactionSession != null) {
                reactionSession.y.p = RequestType.NORMAL;
                boolean z = reactionSession.p;
                if (!videoHomeDataController.f2813e.a(reactionSession) && z != reactionSession.p) {
                    videoHomeDataController.f2810b.m2830a();
                }
            }
        }
    }

    private Delegate bl() {
        return new Delegate(this) {
            final /* synthetic */ VideoHomeHomeFragment f2923a;

            {
                this.f2923a = r1;
            }

            public final void m2828a(final HasScrollListenerSupportImpl hasScrollListenerSupportImpl) {
                this.f2923a.bw.c.a(new RecyclerView.OnScrollListener(this) {
                    final /* synthetic */ AnonymousClass14 f2922b;

                    public final void m2827a(RecyclerView recyclerView, int i, int i2) {
                        super.a(recyclerView, i, i2);
                        hasScrollListenerSupportImpl.b();
                    }
                });
            }
        };
    }

    private void m2841a(Fb4aTitleBarSupplier fb4aTitleBarSupplier, QeAccessor qeAccessor, FbSharedPreferences fbSharedPreferences, VideoHomeReactionSessionHelper videoHomeReactionSessionHelper, Lazy<SecureContextHelper> lazy, ReactionSessionManager reactionSessionManager, VideoHomeSessionManager videoHomeSessionManager, Lazy<UriIntentMapper> lazy2, AppTabBarBroadcaster appTabBarBroadcaster, FbBroadcastManager fbBroadcastManager, VideoHomeLoggingUtils videoHomeLoggingUtils, VideoHomeMetadataFetcher videoHomeMetadataFetcher, VideoHomePillUIController videoHomePillUIController, MonotonicClock monotonicClock, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, ViewportMonitor viewportMonitor, FeedLoggingViewportEventListener feedLoggingViewportEventListener, VideoHomePerfLogger videoHomePerfLogger, VideoHomeHScrollLoggingController videoHomeHScrollLoggingController, VideoPrefetchVisitorProvider videoPrefetchVisitorProvider, FbEventSubscriberListManager fbEventSubscriberListManager, FeedEventBus feedEventBus, VideoSearchExperimentHelper videoSearchExperimentHelper, VideoPrefetchHelper videoPrefetchHelper, ReactionSessionManager reactionSessionManager2, FollowVideosNuxBubbleController followVideosNuxBubbleController, VideoHomeLiveUpdatesHelper videoHomeLiveUpdatesHelper, Lazy<DisabledFeedStoryMenuHelper> lazy3, MultiRowFeedLifecycleSubscribers multiRowFeedLifecycleSubscribers, FrameRateLoggerProvider frameRateLoggerProvider, ReactionThemedContextHelper reactionThemedContextHelper, RedSpaceOptimisticBadgeViewportEventListener redSpaceOptimisticBadgeViewportEventListener, RedSpaceOptimisticBadgeStore redSpaceOptimisticBadgeStore, VideoHomeInlineAudioManager videoHomeInlineAudioManager, VideoHomeDataControllerProvider videoHomeDataControllerProvider, LiveStatusTracker liveStatusTracker, VideoHomeLiveStatusListener videoHomeLiveStatusListener, VideoHomeConfig videoHomeConfig, VideoHomeCenteredAutoplayManager videoHomeCenteredAutoplayManager, VideoHomeEnvironmentImplProvider videoHomeEnvironmentImplProvider, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<VideoHomeRootPartDefinition> lazy4, Provider<User> provider, ComposerFacecastCapability composerFacecastCapability, VideoHomeComposerOnClickListenerProvider videoHomeComposerOnClickListenerProvider, PresenceManager presenceManager) {
        this.f2937a = fb4aTitleBarSupplier;
        this.f2938b = qeAccessor;
        this.f2939c = fbSharedPreferences;
        this.f2940d = videoHomeReactionSessionHelper;
        this.f2941e = lazy;
        this.f2942f = reactionSessionManager;
        this.f2943g = videoHomeSessionManager;
        this.f2944h = lazy2;
        this.f2945i = appTabBarBroadcaster;
        this.al = fbBroadcastManager;
        this.am = videoHomeLoggingUtils;
        this.an = videoHomeMetadataFetcher;
        this.ao = videoHomePillUIController;
        this.ap = monotonicClock;
        this.aq = multipleRowsStoriesRecycleCallback;
        this.ar = viewportMonitor;
        this.as = feedLoggingViewportEventListener;
        this.at = videoHomePerfLogger;
        this.au = videoHomeHScrollLoggingController;
        this.av = videoPrefetchVisitorProvider;
        this.aw = fbEventSubscriberListManager;
        this.ax = feedEventBus;
        this.ay = videoSearchExperimentHelper;
        this.az = videoPrefetchHelper;
        this.aA = reactionSessionManager2;
        this.aB = followVideosNuxBubbleController;
        this.aC = videoHomeLiveUpdatesHelper;
        this.aD = lazy3;
        this.aE = multiRowFeedLifecycleSubscribers;
        this.aF = frameRateLoggerProvider;
        this.aG = reactionThemedContextHelper;
        this.aH = redSpaceOptimisticBadgeViewportEventListener;
        this.aI = redSpaceOptimisticBadgeStore;
        this.aJ = videoHomeInlineAudioManager;
        this.aK = videoHomeDataControllerProvider;
        this.aL = liveStatusTracker;
        this.aM = videoHomeLiveStatusListener;
        this.aN = videoHomeConfig;
        this.aO = videoHomeCenteredAutoplayManager;
        this.aP = videoHomeEnvironmentImplProvider;
        this.aQ = multiRowAdapterBuilder;
        this.aR = lazy4;
        this.aS = provider;
        this.aT = composerFacecastCapability;
        this.aU = videoHomeComposerOnClickListenerProvider;
        this.aV = presenceManager;
    }

    public final void m2858a() {
        this.bH = new PresenceListener(this) {
            final /* synthetic */ VideoHomeHomeFragment f2924a;

            {
                this.f2924a = r1;
            }

            public final void m2829a() {
                if (this.f2924a.aV.L == PresenceDownloadState.TP_FULL_LIST_RECEIVED && this.f2924a.aV.c().size() >= 3) {
                    this.f2924a.aV.b(this.f2924a);
                    if (this.f2924a.bH != null) {
                        this.f2924a.aV.b(this.f2924a.bH);
                    }
                }
            }
        };
        this.aV.a(this.bH);
        this.aV.a(this);
    }

    public final void kM_() {
    }

    public final void kN_() {
    }

    public final void m2863e() {
        this.aV.b(this);
        if (this.bH != null) {
            this.aV.b(this.bH);
        }
    }
}
