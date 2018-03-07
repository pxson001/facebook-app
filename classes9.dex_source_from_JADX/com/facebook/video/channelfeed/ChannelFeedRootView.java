package com.facebook.video.channelfeed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.viewport.ViewportMonitor;
import com.facebook.content.event.FbEvent;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.autoplay.CenteredVideoAutoplayManager;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator.VideoDisplayedChangedListener;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.data.FeedStorySubscriber.OnStoryChangeListener;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.FeedUnitPropsListItemComparator;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ui.MultiRowAdapterRecyclerViewProxy;
import com.facebook.feed.ui.VideoFeedStoryMenuHelperProvider;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitor;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitorProvider;
import com.facebook.feed.util.StoryEventSubscriberManager;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.FetchTimeMsHelper;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.GraphQLVideoChannelFeedEdge;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnDismissEventSubscriber;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnResumeEventSubscriber;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.analytics.FlattenedVideoPlaybackAnalyticsParams;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoChannelSessionManager;
import com.facebook.video.channelfeed.ChannelFeedVideoSectionController.C02363;
import com.facebook.video.channelfeed.ChannelFeedVideoSectionController.VideoChannelLoadedCallback;
import com.facebook.video.channelfeed.MultiShareChannelStoryUnit.Type;
import com.facebook.video.channelfeed.VideoChannelItemCollection.OnCollectionChangeListener;
import com.facebook.video.channelfeed.abtest.ChannelFeedConfig;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryModels.ChannelFeedVideoChannelFeedFragmentModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryModels.ChannelFeedVideoChannelFragmentModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEModels.ChannelFeedVideoChannelFeedFragmentQEModel;
import com.facebook.video.channelfeed.protocol.FetchVideoChannelQueryOptimizedFragmentsQEModels.ChannelFeedVideoChannelFragmentQEModel;
import com.facebook.video.chromecast.VideoCastManager;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.exoserviceclient.ExoServiceClient.PrefetchOrigin;
import com.facebook.video.player.FullScreenVideoListener;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.prefetch.VideoPrefetchHelper;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: syncWithDb */
public class ChannelFeedRootView extends CustomRelativeLayout implements ImmersiveVideoPlayer {
    private static final String f2432F = ChannelFeedRootView.class.getSimpleName();
    @Inject
    Clock f2433A;
    @Inject
    @ForUiThread
    Handler f2434B;
    @Inject
    VideoPrefetchHelper f2435C;
    @Inject
    public ChannelFeedConfig f2436D;
    @Inject
    ScreenUtil f2437E;
    private final UFIDialogOnResumeEventSubscriber f2438G;
    private final UFIDialogOnDismissEventSubscriber f2439H;
    public final ChannelFeedOverlayHeaderView f2440I;
    private final ChannelFeedFullscreenPlayer f2441J;
    private final LazyView<View> f2442K;
    private final AnonymousClass10 f2443L;
    private final VideoDisplayedChangedListener f2444M;
    public final ChannelFeedHeaderView f2445N;
    private final View f2446O;
    public final ScrollingViewProxy f2447P;
    public final ChannelFeedEnvironment f2448Q;
    private final ChannelFeedEventSubscriptions f2449R;
    public final Map<String, ChannelFeedVideoSectionController> f2450S;
    private final List<String> f2451T;
    private final Map<String, Integer> f2452U;
    public final ChannelFeedLoadingCard f2453V;
    private boolean f2454W;
    @Inject
    MultiRowAdapterBuilder f2455a;
    @Nullable
    public ChannelFeedParams aa;
    @Nullable
    public MultiRowAdapter ab;
    @Nullable
    private Parcelable ac;
    @Nullable
    private Context ad;
    @Nullable
    private Window ae;
    @Nullable
    public ViewGroup af;
    @Nullable
    public ChannelFeedMoreVideosPillController ag;
    @Nullable
    private FullScreenVideoListener ah;
    @Nullable
    private VideoPrefetchVisitor ai;
    @Nullable
    public String aj;
    private boolean ak;
    private boolean al;
    @Nullable
    private ChannelFeedStoryPersistentState am;
    private int an;
    public final List<GraphQLStory> ao;
    private int ap;
    @Inject
    Lazy<ChannelFeedRootPartDefinition> f2456b;
    @Inject
    public VideoChannelItemCollection f2457c;
    @Inject
    MultipleRowsStoriesRecycleCallback f2458d;
    @Inject
    ChannelFeedEnvironmentProvider f2459e;
    @Inject
    ChannelFeedStoryKeyProvider f2460f;
    @Inject
    FeedUnitPropsListItemComparator f2461g;
    @Inject
    ChannelFeedEventSubscriptionsProvider f2462h;
    @Inject
    StoryEventSubscriberManager f2463i;
    @Inject
    FeedStorySubscriber f2464j;
    @Inject
    ChannelFeedMoreVideosPillControllerProvider f2465k;
    @Inject
    VideoLoggingUtils f2466l;
    @Inject
    CenteredVideoAutoplayManager f2467m;
    @Inject
    ChannelFeedFocusDimmingManager f2468n;
    @Inject
    FlyoutEventBus f2469o;
    @Inject
    ChannelFeedAutoscrollController f2470p;
    @Inject
    ChannelFeedFullscreenManager f2471q;
    @Inject
    VideoPrefetchVisitorProvider f2472r;
    @Inject
    Lazy<VideoCastManager> f2473s;
    @Inject
    GatekeeperStoreImpl f2474t;
    @Inject
    GraphQLStoryUtil f2475u;
    @Inject
    ChannelFeedStoryUtil f2476v;
    @Inject
    public ChannelFeedVideoSectionControllerProvider f2477w;
    @Inject
    ViewportMonitor f2478x;
    @Inject
    FeedLoggingViewportEventListener f2479y;
    @Inject
    VideoChannelSessionManager f2480z;

    /* compiled from: syncWithDb */
    class C02181 implements OnScrollListener {
        final /* synthetic */ ChannelFeedRootView f2419a;

        C02181(ChannelFeedRootView channelFeedRootView) {
            this.f2419a = channelFeedRootView;
        }

        public final void m2363a(ScrollingViewProxy scrollingViewProxy, int i) {
            this.f2419a.f2468n.m2185a(i);
            this.f2419a.f2470p.f2092a.removeMessages(1);
            if (i == 0) {
                this.f2419a.f2478x.b(scrollingViewProxy);
            }
        }

        public final void m2364a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            ChannelFeedRootView.m2379a(this.f2419a, i, i2, i3);
        }
    }

    /* compiled from: syncWithDb */
    class C02192 implements Runnable {
        final /* synthetic */ ChannelFeedRootView f2422a;

        C02192(ChannelFeedRootView channelFeedRootView) {
            this.f2422a = channelFeedRootView;
        }

        public void run() {
            if (this.f2422a.ab != null) {
                this.f2422a.ab.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: syncWithDb */
    class C02203 implements Function<RichVideoPlayerParams, Void> {
        final /* synthetic */ ChannelFeedRootView f2423a;

        C02203(ChannelFeedRootView channelFeedRootView) {
            this.f2423a = channelFeedRootView;
        }

        public Object apply(@Nullable Object obj) {
            this.f2423a.f2471q.m2206a();
            return null;
        }
    }

    /* compiled from: syncWithDb */
    class C02214 implements Function<String, Void> {
        final /* synthetic */ ChannelFeedRootView f2424a;

        C02214(ChannelFeedRootView channelFeedRootView) {
            this.f2424a = channelFeedRootView;
        }

        public Object apply(Object obj) {
            ChannelFeedVideoSectionController channelFeedVideoSectionController = (ChannelFeedVideoSectionController) this.f2424a.f2450S.get((String) obj);
            if (channelFeedVideoSectionController != null) {
                String str = null;
                if (channelFeedVideoSectionController.f2587z || (channelFeedVideoSectionController.f2585x != null && channelFeedVideoSectionController.f2585x.b())) {
                    if (channelFeedVideoSectionController.f2585x != null) {
                        str = channelFeedVideoSectionController.f2585x.a();
                    }
                    GraphQLQueryFuture a = channelFeedVideoSectionController.f2575n.m2575a(channelFeedVideoSectionController.f2565d, channelFeedVideoSectionController.f2566e, str, 5, channelFeedVideoSectionController.f2568g);
                    Futures.a(a, new C02363(channelFeedVideoSectionController, a), channelFeedVideoSectionController.f2576o);
                }
            }
            return null;
        }
    }

    /* compiled from: syncWithDb */
    public class C02225 {
        public final /* synthetic */ ChannelFeedRootView f2425a;

        C02225(ChannelFeedRootView channelFeedRootView) {
            this.f2425a = channelFeedRootView;
        }
    }

    /* compiled from: syncWithDb */
    class C02236 implements OnCollectionChangeListener {
        final /* synthetic */ ChannelFeedRootView f2426a;

        C02236(ChannelFeedRootView channelFeedRootView) {
            this.f2426a = channelFeedRootView;
        }

        public final void mo76a(FeedUnit feedUnit) {
            if (feedUnit instanceof GraphQLStory) {
                GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
                this.f2426a.f2464j.a(graphQLStory);
                if (this.f2426a.f2475u.o(graphQLStory)) {
                    this.f2426a.f2445N.setBadgeText(this.f2426a.getResources().getString(2131237298));
                    if (this.f2426a.f2436D.p) {
                        this.f2426a.ao.add(graphQLStory);
                        return;
                    }
                    return;
                }
                ChannelFeedRootView.getVideoPrefetchVisitor(this.f2426a).a(graphQLStory);
            }
        }
    }

    /* compiled from: syncWithDb */
    class C02247 implements Function<String, FeedProps<GraphQLStory>> {
        final /* synthetic */ ChannelFeedRootView f2427a;

        C02247(ChannelFeedRootView channelFeedRootView) {
            this.f2427a = channelFeedRootView;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            FeedProps b = this.f2427a.f2457c.m2565b((String) obj);
            return b != null ? StoryProps.j(b) : null;
        }
    }

    /* compiled from: syncWithDb */
    class C02258 implements Function<String, FeedProps<GraphQLStory>> {
        final /* synthetic */ ChannelFeedRootView f2428a;

        C02258(ChannelFeedRootView channelFeedRootView) {
            this.f2428a = channelFeedRootView;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            FeedProps c = this.f2428a.f2457c.m2567c((String) obj);
            return c != null ? StoryProps.j(c) : null;
        }
    }

    /* compiled from: syncWithDb */
    class C02269 implements Function<FeedProps<GraphQLStory>, Boolean> {
        final /* synthetic */ ChannelFeedRootView f2429a;

        C02269(ChannelFeedRootView channelFeedRootView) {
            this.f2429a = channelFeedRootView;
        }

        public Object apply(@Nullable Object obj) {
            FeedProps feedProps = (FeedProps) obj;
            if (feedProps == null) {
                return Boolean.valueOf(false);
            }
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            return Boolean.valueOf(((ChannelFeedStoryPersistentState) this.f2429a.f2448Q.a(this.f2429a.f2460f.m2425a(feedProps, GraphQLMediaConversionHelper.b(StoryAttachmentHelper.o(graphQLStory).r())), graphQLStory)).m2434b().k());
        }
    }

    /* compiled from: syncWithDb */
    class UFIDialogOnDismissEventSubscriber extends FlyoutOnDismissEventSubscriber {
        final /* synthetic */ ChannelFeedRootView f2430a;

        public UFIDialogOnDismissEventSubscriber(ChannelFeedRootView channelFeedRootView) {
            this.f2430a = channelFeedRootView;
        }

        public final void m2375b(FbEvent fbEvent) {
            this.f2430a.f2471q.f2206j = false;
        }
    }

    /* compiled from: syncWithDb */
    class UFIDialogOnResumeEventSubscriber extends FlyoutOnResumeEventSubscriber {
        final /* synthetic */ ChannelFeedRootView f2431a;

        public UFIDialogOnResumeEventSubscriber(ChannelFeedRootView channelFeedRootView) {
            this.f2431a = channelFeedRootView;
        }

        public final void m2376b(FbEvent fbEvent) {
            this.f2431a.f2471q.f2206j = true;
        }
    }

    public static void m2383a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ChannelFeedRootView) obj).m2377a(MultiRowAdapterBuilder.a(injectorLike), IdBasedLazy.a(injectorLike, 11589), VideoChannelItemCollection.m2554a(injectorLike), MultipleRowsStoriesRecycleCallback.a(injectorLike), (ChannelFeedEnvironmentProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ChannelFeedEnvironmentProvider.class), (ChannelFeedStoryKeyProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ChannelFeedStoryKeyProvider.class), FeedUnitPropsListItemComparator.a(injectorLike), (ChannelFeedEventSubscriptionsProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ChannelFeedEventSubscriptionsProvider.class), StoryEventSubscriberManager.a(injectorLike), FeedStorySubscriber.a(injectorLike), (ChannelFeedMoreVideosPillControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ChannelFeedMoreVideosPillControllerProvider.class), VideoLoggingUtils.a(injectorLike), CenteredVideoAutoplayManager.a(injectorLike), ChannelFeedFocusDimmingManager.m2177a(injectorLike), FlyoutEventBus.a(injectorLike), ChannelFeedAutoscrollController.m2107a(injectorLike), ChannelFeedFullscreenManager.m2197a(injectorLike), (VideoPrefetchVisitorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoPrefetchVisitorProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 11613), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GraphQLStoryUtil.a(injectorLike), ChannelFeedStoryUtil.m2436a(injectorLike), (ChannelFeedVideoSectionControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ChannelFeedVideoSectionControllerProvider.class), ViewportMonitor.a(injectorLike), FeedLoggingViewportEventListener.a(injectorLike), VideoChannelSessionManager.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.a(injectorLike), VideoPrefetchHelper.m2636a(injectorLike), ChannelFeedConfig.a(injectorLike), ScreenUtil.a(injectorLike));
    }

    private void m2377a(MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<ChannelFeedRootPartDefinition> lazy, VideoChannelItemCollection videoChannelItemCollection, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, ChannelFeedEnvironmentProvider channelFeedEnvironmentProvider, ChannelFeedStoryKeyProvider channelFeedStoryKeyProvider, FeedUnitPropsListItemComparator feedUnitPropsListItemComparator, ChannelFeedEventSubscriptionsProvider channelFeedEventSubscriptionsProvider, StoryEventSubscriberManager storyEventSubscriberManager, FeedStorySubscriber feedStorySubscriber, ChannelFeedMoreVideosPillControllerProvider channelFeedMoreVideosPillControllerProvider, VideoLoggingUtils videoLoggingUtils, CenteredVideoAutoplayManager centeredVideoAutoplayManager, ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager, FlyoutEventBus flyoutEventBus, ChannelFeedAutoscrollController channelFeedAutoscrollController, ChannelFeedFullscreenManager channelFeedFullscreenManager, VideoPrefetchVisitorProvider videoPrefetchVisitorProvider, Lazy<VideoCastManager> lazy2, GatekeeperStore gatekeeperStore, GraphQLStoryUtil graphQLStoryUtil, ChannelFeedStoryUtil channelFeedStoryUtil, ChannelFeedVideoSectionControllerProvider channelFeedVideoSectionControllerProvider, ViewportMonitor viewportMonitor, FeedLoggingViewportEventListener feedLoggingViewportEventListener, VideoChannelSessionManager videoChannelSessionManager, Clock clock, Handler handler, VideoPrefetchHelper videoPrefetchHelper, ChannelFeedConfig channelFeedConfig, ScreenUtil screenUtil) {
        this.f2455a = multiRowAdapterBuilder;
        this.f2456b = lazy;
        this.f2457c = videoChannelItemCollection;
        this.f2458d = multipleRowsStoriesRecycleCallback;
        this.f2459e = channelFeedEnvironmentProvider;
        this.f2460f = channelFeedStoryKeyProvider;
        this.f2461g = feedUnitPropsListItemComparator;
        this.f2462h = channelFeedEventSubscriptionsProvider;
        this.f2463i = storyEventSubscriberManager;
        this.f2464j = feedStorySubscriber;
        this.f2465k = channelFeedMoreVideosPillControllerProvider;
        this.f2466l = videoLoggingUtils;
        this.f2467m = centeredVideoAutoplayManager;
        this.f2468n = channelFeedFocusDimmingManager;
        this.f2469o = flyoutEventBus;
        this.f2470p = channelFeedAutoscrollController;
        this.f2471q = channelFeedFullscreenManager;
        this.f2472r = videoPrefetchVisitorProvider;
        this.f2473s = lazy2;
        this.f2474t = gatekeeperStore;
        this.f2475u = graphQLStoryUtil;
        this.f2476v = channelFeedStoryUtil;
        this.f2477w = channelFeedVideoSectionControllerProvider;
        this.f2478x = viewportMonitor;
        this.f2479y = feedLoggingViewportEventListener;
        this.f2480z = videoChannelSessionManager;
        this.f2433A = clock;
        this.f2434B = handler;
        this.f2435C = videoPrefetchHelper;
        this.f2436D = channelFeedConfig;
        this.f2437E = screenUtil;
    }

    public ChannelFeedRootView(Context context) {
        this(context, null);
    }

    private ChannelFeedRootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ChannelFeedRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2438G = new UFIDialogOnResumeEventSubscriber(this);
        this.f2439H = new UFIDialogOnDismissEventSubscriber(this);
        this.f2450S = new HashMap();
        this.f2451T = new ArrayList();
        this.f2452U = new HashMap();
        this.an = -1;
        this.ao = new LinkedList();
        Class cls = ChannelFeedRootView.class;
        m2383a((Object) this, getContext());
        LayoutInflater.from(getContextThemeWrapper()).inflate(2130903545, this);
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) a(2131560285);
        betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
        this.f2447P = new MultiRowAdapterRecyclerViewProxy(betterRecyclerView);
        this.f2447P.a(this.f2458d.a());
        this.f2447P.a(new C02181(this));
        this.f2447P.b(this.f2478x);
        this.f2478x.a(this.f2479y);
        ChannelFeedEnvironmentProvider channelFeedEnvironmentProvider = this.f2459e;
        this.f2448Q = new ChannelFeedEnvironment(getContextThemeWrapper(), ChannelFeedListType.f2350a, new C02192(this), CenteredVideoAutoplayManager.a(channelFeedEnvironmentProvider), (VideoFeedStoryMenuHelperProvider) channelFeedEnvironmentProvider.getOnDemandAssistedProviderForStaticDi(VideoFeedStoryMenuHelperProvider.class));
        this.f2448Q.f2138r = this.f2471q;
        this.f2448Q.f2137q = new C02203(this);
        this.f2448Q.f2141u = new C02214(this);
        this.f2441J = (ChannelFeedFullscreenPlayer) a(2131560289);
        this.f2471q.m2208a(this.f2441J);
        this.f2471q.f2201e = new C02225(this);
        this.ae = getContext() instanceof Activity ? ((Activity) context).getWindow() : null;
        this.f2471q.f2198b = this.ae;
        this.f2457c.f2658d = new C02236(this);
        this.f2441J.f2223l = new C02247(this);
        this.f2441J.f2224m = new C02258(this);
        this.f2441J.f2225n = new C02269(this);
        this.f2442K = new LazyView((ViewStub) a(2131560288));
        this.f2443L = new Object(this) {
            public final /* synthetic */ ChannelFeedRootView f2406a;

            {
                this.f2406a = r1;
            }
        };
        this.f2446O = a(2131560287);
        this.f2440I = (ChannelFeedOverlayHeaderView) a(2131560286);
        this.f2468n.m2186a(this.f2440I);
        this.f2445N = new ChannelFeedHeaderView(getContextThemeWrapper());
        this.f2468n.m2186a(this.f2445N);
        this.f2444M = new VideoDisplayedChangedListener<ChannelFeedVideoAttachmentView>(this) {
            final /* synthetic */ ChannelFeedRootView f2407a;

            {
                this.f2407a = r1;
            }

            public final void m2352a(View view, View view2) {
                ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView = (ChannelFeedVideoAttachmentView) view2;
                if (channelFeedVideoAttachmentView == null || !channelFeedVideoAttachmentView.f2524h.equals(this.f2407a.aj)) {
                    this.f2407a.f2440I.m2325c();
                } else {
                    this.f2407a.f2440I.m2326d();
                }
            }
        };
        this.f2453V = new ChannelFeedLoadingCard(getContextThemeWrapper());
        this.f2468n.m2186a(this.f2453V);
        this.f2449R = this.f2462h.m2153a(new Function<GraphQLStory, Void>(this) {
            final /* synthetic */ ChannelFeedRootView f2408a;

            {
                this.f2408a = r1;
            }

            public Object apply(@Nullable Object obj) {
                this.f2408a.f2457c.m2563a((GraphQLStory) obj);
                if (this.f2408a.ab != null) {
                    this.f2408a.ab.notifyDataSetChanged();
                }
                return null;
            }
        });
        this.f2449R.f2151g = this.f2457c;
        this.f2463i.a(this.f2449R.m2152a());
        this.f2464j.d = new OnStoryChangeListener(this) {
            final /* synthetic */ ChannelFeedRootView f2409a;

            {
                this.f2409a = r1;
            }

            public final void m2353a(GraphQLStory graphQLStory) {
                this.f2409a.f2457c.m2563a(graphQLStory);
                if (this.f2409a.ab != null) {
                    this.f2409a.ab.notifyDataSetChanged();
                }
            }
        };
    }

    public final void m2403a(ChannelFeedParams channelFeedParams) {
        if (!this.f2454W) {
            GraphQLStory graphQLStory;
            Activity activity = (Activity) getContext();
            this.an = activity.getRequestedOrientation();
            activity.setRequestedOrientation(-1);
            Preconditions.checkNotNull(channelFeedParams);
            boolean z = (channelFeedParams.a == null && channelFeedParams.c == null) ? false : true;
            Preconditions.checkState(z, "Either story or videoChannelIds must be provided");
            Preconditions.checkNotNull(channelFeedParams.h);
            Preconditions.checkNotNull(channelFeedParams.d);
            Preconditions.checkNotNull(channelFeedParams.g);
            this.aa = channelFeedParams;
            if (channelFeedParams.c != null) {
                for (String str : channelFeedParams.c) {
                    if (str != null) {
                        this.f2451T.add(str);
                    }
                }
            }
            this.f2448Q.f2136p = this.aa.g;
            this.f2448Q.f2139s = this.aa.i;
            Builder a = this.f2455a.a(this.f2456b, this.f2457c);
            a.f = this.f2448Q;
            a = a;
            a.e = this.f2461g;
            this.ab = a.e();
            this.f2447P.a(this.ab);
            if (this.aa.a != null) {
                FeedProps j = StoryProps.j(this.aa.a);
                graphQLStory = (GraphQLStory) j.a;
                if (!(StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).r() == null)) {
                    this.am = (ChannelFeedStoryPersistentState) this.f2448Q.a(this.f2460f.m2425a(j, GraphQLMediaConversionHelper.b(StoryAttachmentHelper.o(graphQLStory).r())), graphQLStory);
                    this.am.m2433a(this.aa.e);
                    this.am.m2434b().v = true;
                    this.am.f2507i = this.aa.h;
                }
            }
            if (this.aa.a != null && this.aa.b == null) {
                graphQLStory = (GraphQLStory) this.aa.a.a;
                this.aj = this.f2476v.m2439a(graphQLStory);
                this.ak = this.f2476v.m2440b(graphQLStory);
                this.al = this.f2476v.m2441c(graphQLStory);
                FeedProps feedProps = this.aa.a;
                VideoChannelItemCollection videoChannelItemCollection = this.f2457c;
                videoChannelItemCollection.f2658d.mo76a((FeedUnit) feedProps.a);
                videoChannelItemCollection.f2656a.add(0, feedProps);
                this.ab.notifyDataSetChanged();
            }
            if (this.aa.b != null) {
                m2393o();
            } else {
                m2388i();
            }
            m2395q();
            if (this.f2474t.a(VideoAbTestGatekeepers.c, false)) {
                ((VideoCastManager) this.f2473s.get()).e();
                HandlerDetour.b(this.f2434B, new Runnable(this) {
                    final /* synthetic */ ChannelFeedRootView f2410a;

                    {
                        this.f2410a = r1;
                    }

                    public void run() {
                        this.f2410a.f2466l.a(((VideoCastManager) this.f2410a.f2473s.get()).q(), PlayerType.CHANNEL_PLAYER);
                    }
                }, 5000, -439656353);
            }
            Integer.valueOf(this.aa.e);
            this.f2441J.f2222k = this.aa.g;
            this.ag = this.f2465k.m2319a(this.f2442K, this.f2443L);
            this.f2467m.a.a(this.f2444M);
            m2385a(PlayerType.CHANNEL_PLAYER.value, PlayerType.INLINE_PLAYER.value, this.aa.e, this.aa.f);
            if (VERSION.SDK_INT >= 21) {
                this.ap = activity.getWindow().getStatusBarColor();
                activity.getWindow().setStatusBarColor(ContextCompat.b(activity, 2131362144));
            }
            m2396r();
            this.f2454W = true;
            ChannelFeedAutoscrollController channelFeedAutoscrollController = this.f2470p;
            VideoDisplayedCoordinator videoDisplayedCoordinator = this.f2467m.a;
            videoDisplayedCoordinator.a(channelFeedAutoscrollController.f2096e);
            videoDisplayedCoordinator.m.add(channelFeedAutoscrollController.f2097f);
            this.f2470p.f2099h = new Object(this) {
                final /* synthetic */ ChannelFeedRootView f2411a;

                {
                    this.f2411a = r1;
                }

                public final void m2354a(int i) {
                    this.f2411a.f2447P.a(i, 1000);
                }
            };
            this.f2470p.f2101j = new Function<String, GraphQLStory>(this) {
                final /* synthetic */ ChannelFeedRootView f2412a;

                {
                    this.f2412a = r1;
                }

                @Nullable
                public Object apply(@Nullable Object obj) {
                    FeedProps b = this.f2412a.f2457c.m2565b((String) obj);
                    return b == null ? null : (GraphQLStory) b.a;
                }
            };
            m2398t();
            getVideoPrefetchVisitor(this).a();
            m2387h();
        }
    }

    private void m2385a(String str, String str2, int i, int i2) {
        boolean z;
        boolean z2;
        String str3;
        VideoLoggingUtils videoLoggingUtils = this.f2466l;
        JsonNode trackingCodes = getTrackingCodes();
        String str4 = this.aj;
        PlayerOrigin playerOrigin = this.aa.g;
        String str5 = EventTriggerType.BY_USER.value;
        if (this.aa.a == null || !((GraphQLStory) this.aa.a.a()).u()) {
            z = false;
        } else {
            z = true;
        }
        if (this.aa.a == null || !((GraphQLStory) this.aa.a.a()).u()) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z3 = this.ak;
        if (this.al) {
            str3 = "CUBEMAP";
        } else {
            str3 = "";
        }
        videoLoggingUtils.a(trackingCodes, str, str2, str4, playerOrigin, str5, i, i2, z, new FlattenedVideoPlaybackAnalyticsParams(z2, z3, false, str3), this.aa.l, this.aa.m);
    }

    private void m2387h() {
        if (this.aa != null && this.aa.a != null && this.aa.a.a != null && this.aa.b != null) {
            int i = 0;
            while (i < this.f2457c.m2559a()) {
                FeedUnit feedUnit = (FeedUnit) this.f2457c.m2564b(i).a;
                String g = ((GraphQLStory) this.aa.a.a).g();
                if (g == null || g.equals(feedUnit.g())) {
                    break;
                }
                i++;
            }
            if (i != 0 && i != this.f2457c.m2559a()) {
                HandlerDetour.b(this.f2434B, new Runnable(this) {
                    final /* synthetic */ ChannelFeedRootView f2414b;

                    public void run() {
                        ChannelFeedRootView channelFeedRootView = this.f2414b;
                        int g = channelFeedRootView.ab.g(i);
                        if (g != channelFeedRootView.ab.getCount() - 1) {
                            g++;
                        }
                        channelFeedRootView.f2447P.e(g);
                    }
                }, 100, -68987862);
            }
        }
    }

    private void m2386d(int i) {
        if (this.f2447P != null && this.ab != null) {
            this.f2447P.d(this.ab.t_(i), 0);
            String str = null;
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(((MultiShareChannelStoryUnit) this.f2457c.m2564b(i).a).f2635a);
            if (!(o == null || o.r() == null)) {
                GraphQLVideo b = GraphQLMediaConversionHelper.b(o.r());
                if (b != null) {
                    str = b.J();
                }
            }
            final String str2 = str;
            final BetterRecyclerView betterRecyclerView = (BetterRecyclerView) this.f2447P.ix_();
            betterRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ ChannelFeedRootView f2417c;

                public void onGlobalLayout() {
                    if (VERSION.SDK_INT < 16) {
                        betterRecyclerView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        betterRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    for (int i = 0; i < betterRecyclerView.getChildCount(); i++) {
                        View childAt = betterRecyclerView.getChildAt(i);
                        if (childAt instanceof ChannelFeedVideoAttachmentView) {
                            ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView = (ChannelFeedVideoAttachmentView) childAt;
                            if (str2.equals(channelFeedVideoAttachmentView.f2524h)) {
                                i = this.f2417c.f2437E.d();
                                this.f2417c.f2447P.a(((channelFeedVideoAttachmentView.getBottom() + channelFeedVideoAttachmentView.getTop()) / 2) - (i / 2), 0);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    public static void m2379a(ChannelFeedRootView channelFeedRootView, int i, int i2, int i3) {
        if (channelFeedRootView.ab != null && i2 > 0 && i3 > 0) {
            int s_ = channelFeedRootView.ab.s_((i + i2) - 1);
            int min = Math.min(channelFeedRootView.f2436D.f, channelFeedRootView.f2457c.m2559a() - s_);
            for (int i4 = 0; i4 < min; i4++) {
                channelFeedRootView.m2378a((FeedUnit) channelFeedRootView.f2457c.m2564b(s_ + i4).a);
            }
        }
    }

    private void m2378a(@Nullable FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
            if (this.ao.contains(graphQLStory)) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
                if (!(o == null || o.r() == null)) {
                    this.f2435C.m2640b(o, PrefetchOrigin.FEED);
                }
                this.ao.remove(graphQLStory);
            }
        }
    }

    private void m2388i() {
        Preconditions.checkNotNull(this.aa);
        if (MultiShareNoLinkUtil.a(this.aa.b)) {
            Preconditions.checkNotNull(this.aa);
            String str = (this.aa.c == null || this.aa.c.isEmpty()) ? null : (String) this.aa.c.get(0);
            this.f2450S.put(str, this.f2477w.m2498a(str, this.aj, this.aa.d, this.aa.j, true, this.f2447P, this.f2457c, this.ab, new VideoChannelLoadedCallback(this) {
                final /* synthetic */ ChannelFeedRootView f2421a;

                {
                    this.f2421a = r1;
                }

                public final void mo73a(ChannelFeedVideoChannelFragmentQEModel channelFeedVideoChannelFragmentQEModel) {
                }

                public final void mo72a(ChannelFeedVideoChannelFragmentModel channelFeedVideoChannelFragmentModel) {
                }

                public final void mo75a(String str, ChannelFeedVideoChannelFeedFragmentQEModel channelFeedVideoChannelFeedFragmentQEModel) {
                    ChannelFeedRootView.m2382a(this.f2421a, str, (Object) channelFeedVideoChannelFeedFragmentQEModel);
                }

                public final void mo74a(String str, ChannelFeedVideoChannelFeedFragmentModel channelFeedVideoChannelFeedFragmentModel) {
                    ChannelFeedRootView.m2382a(this.f2421a, str, (Object) channelFeedVideoChannelFeedFragmentModel);
                }
            }, this.f2453V, true));
        } else if (this.aa.c == null || this.aa.c.size() <= 1) {
            m2390k();
        } else {
            m2389j();
        }
    }

    private void m2389j() {
        Preconditions.checkNotNull(this.aa);
        this.f2448Q.f2140t = true;
        for (String str : this.f2451T) {
            this.f2452U.put(str, Integer.valueOf(this.aj != null ? 1 : 0));
            this.f2450S.put(str, this.f2477w.m2498a(str, this.aj, this.aa.d, this.aa.j, false, this.f2447P, this.f2457c, this.ab, new VideoChannelLoadedCallback(this) {
                final /* synthetic */ ChannelFeedRootView f2418a;

                {
                    this.f2418a = r1;
                }

                public final void mo72a(ChannelFeedVideoChannelFragmentModel channelFeedVideoChannelFragmentModel) {
                    ChannelFeedRootView.m2381a(this.f2418a, (Object) channelFeedVideoChannelFragmentModel, true);
                    this.f2418a.f2447P.b(this.f2418a.f2453V);
                    ChannelFeedRootView.m2391m(this.f2418a);
                }

                public final void mo73a(ChannelFeedVideoChannelFragmentQEModel channelFeedVideoChannelFragmentQEModel) {
                    ChannelFeedRootView.m2381a(this.f2418a, (Object) channelFeedVideoChannelFragmentQEModel, true);
                    this.f2418a.f2447P.b(this.f2418a.f2453V);
                    ChannelFeedRootView.m2391m(this.f2418a);
                }

                public final void mo74a(String str, ChannelFeedVideoChannelFeedFragmentModel channelFeedVideoChannelFeedFragmentModel) {
                    ChannelFeedRootView.m2382a(this.f2418a, str, (Object) channelFeedVideoChannelFeedFragmentModel);
                }

                public final void mo75a(String str, ChannelFeedVideoChannelFeedFragmentQEModel channelFeedVideoChannelFeedFragmentQEModel) {
                    ChannelFeedRootView.m2382a(this.f2418a, str, (Object) channelFeedVideoChannelFeedFragmentQEModel);
                }
            }, null, false));
        }
        this.f2447P.e(this.f2453V);
    }

    private void m2390k() {
        Preconditions.checkNotNull(this.aa);
        Object obj = (this.aa.c == null || this.aa.c.isEmpty()) ? null : (String) this.aa.c.get(0);
        ChannelFeedVideoSectionController a = this.f2477w.m2498a(obj, this.aj, this.aa.d, this.aa.j, true, this.f2447P, this.f2457c, this.ab, new VideoChannelLoadedCallback(this) {
            final /* synthetic */ ChannelFeedRootView f2420a;

            {
                this.f2420a = r1;
            }

            public final void mo73a(ChannelFeedVideoChannelFragmentQEModel channelFeedVideoChannelFragmentQEModel) {
                int i;
                ChannelFeedRootView.m2380a(this.f2420a, (Object) channelFeedVideoChannelFragmentQEModel);
                if (channelFeedVideoChannelFragmentQEModel.k() == null || channelFeedVideoChannelFragmentQEModel.k().a() == null) {
                    i = 0;
                } else {
                    i = channelFeedVideoChannelFragmentQEModel.k().a().size();
                }
                if (this.f2420a.ag != null) {
                    this.f2420a.ag.m2317a(i);
                }
                ChannelFeedRootView.m2381a(this.f2420a, (Object) channelFeedVideoChannelFragmentQEModel, false);
                ChannelFeedRootView.m2391m(this.f2420a);
            }

            public final void mo72a(ChannelFeedVideoChannelFragmentModel channelFeedVideoChannelFragmentModel) {
                int i;
                ChannelFeedRootView.m2380a(this.f2420a, (Object) channelFeedVideoChannelFragmentModel);
                if (channelFeedVideoChannelFragmentModel.k() == null || channelFeedVideoChannelFragmentModel.k().a() == null) {
                    i = 0;
                } else {
                    i = channelFeedVideoChannelFragmentModel.k().a().size();
                }
                if (this.f2420a.ag != null) {
                    this.f2420a.ag.m2317a(i);
                }
                ChannelFeedRootView.m2381a(this.f2420a, (Object) channelFeedVideoChannelFragmentModel, false);
                ChannelFeedRootView.m2391m(this.f2420a);
            }

            public final void mo75a(String str, ChannelFeedVideoChannelFeedFragmentQEModel channelFeedVideoChannelFeedFragmentQEModel) {
            }

            public final void mo74a(String str, ChannelFeedVideoChannelFeedFragmentModel channelFeedVideoChannelFeedFragmentModel) {
            }
        }, this.f2453V, false);
        if (obj == null) {
            obj = this.aj;
        }
        this.f2450S.put(obj, a);
    }

    public static void m2380a(ChannelFeedRootView channelFeedRootView, Object obj) {
        DefaultTextWithEntitiesFieldsModel l;
        String str = "";
        if (obj instanceof ChannelFeedVideoChannelFragmentModel) {
            l = ((ChannelFeedVideoChannelFragmentModel) obj).l();
        } else if (obj instanceof ChannelFeedVideoChannelFragmentQEModel) {
            l = ((ChannelFeedVideoChannelFragmentQEModel) obj).l();
        } else {
            return;
        }
        if (!(l == null || l.a() == null)) {
            str = l.a();
        }
        channelFeedRootView.f2440I.setTitle(str);
    }

    public static void m2391m(ChannelFeedRootView channelFeedRootView) {
        int i;
        int i2 = 0;
        for (ChannelFeedVideoSectionController channelFeedVideoSectionController : channelFeedRootView.f2450S.values()) {
            if (channelFeedVideoSectionController.f2571j) {
                i = 0;
                break;
            }
        }
        i = 1;
        View view = channelFeedRootView.f2446O;
        i = (channelFeedRootView.f2457c.m2559a() != 0 || i == 0) ? 8 : 0;
        view.setVisibility(i);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) channelFeedRootView.f2446O.getLayoutParams();
        if (channelFeedRootView.f2445N.isShown()) {
            i2 = channelFeedRootView.f2445N.getHeight() / 2;
        }
        marginLayoutParams.topMargin = i2;
        channelFeedRootView.f2446O.setLayoutParams(marginLayoutParams);
    }

    public static synchronized void m2381a(ChannelFeedRootView channelFeedRootView, Object obj, boolean z) {
        synchronized (channelFeedRootView) {
            String str;
            DefaultPageInfoFields defaultPageInfoFields;
            ImmutableList immutableList;
            String str2 = "";
            ImmutableList immutableList2 = null;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel = null;
            String j;
            if (obj instanceof ChannelFeedVideoChannelFragmentModel) {
                ChannelFeedVideoChannelFragmentModel channelFeedVideoChannelFragmentModel = (ChannelFeedVideoChannelFragmentModel) obj;
                j = channelFeedVideoChannelFragmentModel.j();
                if (!(channelFeedVideoChannelFragmentModel.l() == null || channelFeedVideoChannelFragmentModel.l().a() == null)) {
                    str2 = channelFeedVideoChannelFragmentModel.l().a();
                }
                ChannelFeedVideoChannelFeedFragmentModel k = channelFeedVideoChannelFragmentModel.k();
                if (k != null) {
                    immutableList2 = k.a();
                    defaultPageInfoFieldsModel = k.j();
                }
                str = j;
                defaultPageInfoFields = defaultPageInfoFieldsModel;
                immutableList = immutableList2;
                Object obj2 = str2;
            } else {
                if (obj instanceof ChannelFeedVideoChannelFragmentQEModel) {
                    ChannelFeedVideoChannelFragmentQEModel channelFeedVideoChannelFragmentQEModel = (ChannelFeedVideoChannelFragmentQEModel) obj;
                    j = channelFeedVideoChannelFragmentQEModel.j();
                    if (!(channelFeedVideoChannelFragmentQEModel.l() == null || channelFeedVideoChannelFragmentQEModel.l().a() == null)) {
                        str2 = channelFeedVideoChannelFragmentQEModel.l().a();
                    }
                    ChannelFeedVideoChannelFeedFragmentQEModel k2 = channelFeedVideoChannelFragmentQEModel.k();
                    if (k2 != null) {
                        immutableList2 = k2.a();
                        defaultPageInfoFieldsModel = k2.j();
                    }
                    str = j;
                    defaultPageInfoFields = defaultPageInfoFieldsModel;
                    immutableList = immutableList2;
                    String str3 = str2;
                }
            }
            if (!(immutableList == null || immutableList.isEmpty())) {
                Object obj3;
                int i;
                long a = channelFeedRootView.f2433A.a();
                List arrayList = new ArrayList();
                int i2 = channelFeedRootView.aj != null ? 1 : 0;
                if (channelFeedRootView.f2452U.containsKey(str)) {
                    i2 = ((Integer) channelFeedRootView.f2452U.get(str)).intValue();
                } else {
                    channelFeedRootView.f2452U.put(str, Integer.valueOf(i2));
                    channelFeedRootView.f2451T.add(str);
                }
                if (i2 <= 0 || !z || TextUtils.isEmpty(obj2)) {
                    obj3 = null;
                    i = i2;
                } else {
                    i = i2 + 1;
                    channelFeedRootView.f2457c.m2562a(i2, FeedProps.c(new ChannelFeedVideoSectionHeader(obj2)));
                    obj3 = 1;
                }
                int size = immutableList.size();
                int i3 = 0;
                while (i3 < size) {
                    int i4;
                    FeedUnit a2 = ((GraphQLVideoChannelFeedEdge) immutableList.get(i3)).a();
                    if (a2 instanceof GraphQLStory) {
                        GraphQLStory graphQLStory = (GraphQLStory) a2;
                        FetchTimeMsHelper.a(graphQLStory, a);
                        String a3 = channelFeedRootView.f2476v.m2439a(graphQLStory);
                        if (a3 != null) {
                            i2 = i + 1;
                            channelFeedRootView.f2457c.m2562a(i, FeedProps.c(graphQLStory));
                            channelFeedRootView.f2464j.a(graphQLStory);
                            arrayList.add(a3);
                            i4 = i2;
                            i3++;
                            i = i4;
                        }
                    }
                    i4 = i;
                    i3++;
                    i = i4;
                }
                Object obj4 = null;
                Object obj5;
                if (defaultPageInfoFields == null || !defaultPageInfoFields.b()) {
                    obj5 = null;
                } else {
                    obj5 = 1;
                }
                boolean equals = ((String) channelFeedRootView.f2451T.get(channelFeedRootView.f2451T.size() - 1)).equals(str);
                if (!(!z || r5 == null || equals || TextUtils.isEmpty(obj2))) {
                    channelFeedRootView.f2457c.m2562a(i, FeedProps.c(new ChannelFeedVideoSectionSeeMore(obj2, str)));
                    obj4 = 1;
                }
                channelFeedRootView.m2384a(str, (obj4 != null ? 1 : 0) + (arrayList.size() + (obj3 != null ? 1 : 0)));
                if (channelFeedRootView.aj != null) {
                    channelFeedRootView.f2480z.a(channelFeedRootView.aj, arrayList);
                }
                if (channelFeedRootView.ab != null) {
                    channelFeedRootView.ab.notifyDataSetChanged();
                }
                Integer.valueOf(immutableList.size());
            }
        }
    }

    public static void m2382a(ChannelFeedRootView channelFeedRootView, String str, Object obj) {
        if (obj != null) {
            ImmutableList a;
            if (obj instanceof ChannelFeedVideoChannelFeedFragmentModel) {
                a = ((ChannelFeedVideoChannelFeedFragmentModel) obj).a();
            } else if (obj instanceof ChannelFeedVideoChannelFeedFragmentQEModel) {
                a = ((ChannelFeedVideoChannelFeedFragmentQEModel) obj).a();
            } else {
                a = null;
            }
            if (a != null && !a.isEmpty()) {
                long a2 = channelFeedRootView.f2433A.a();
                List arrayList = new ArrayList();
                int intValue = ((Integer) channelFeedRootView.f2452U.get(str)).intValue() - 1;
                channelFeedRootView.m2392n();
                int size = a.size();
                int i = 0;
                while (i < size) {
                    int i2;
                    FeedUnit a3 = ((GraphQLVideoChannelFeedEdge) a.get(i)).a();
                    if (a3 instanceof GraphQLStory) {
                        GraphQLStory graphQLStory = (GraphQLStory) a3;
                        FetchTimeMsHelper.a(graphQLStory, a2);
                        String a4 = channelFeedRootView.f2476v.m2439a(graphQLStory);
                        if (a4 != null) {
                            int i3 = intValue + 1;
                            channelFeedRootView.f2457c.m2562a(intValue, FeedProps.c(graphQLStory));
                            channelFeedRootView.f2464j.a(graphQLStory);
                            arrayList.add(a4);
                            i2 = i3;
                            i++;
                            intValue = i2;
                        }
                    }
                    i2 = intValue;
                    i++;
                    intValue = i2;
                }
                channelFeedRootView.m2384a(str, arrayList.size());
                if (channelFeedRootView.aj != null) {
                    channelFeedRootView.f2480z.a(channelFeedRootView.aj, arrayList);
                }
                if (channelFeedRootView.ab != null) {
                    channelFeedRootView.ab.notifyDataSetChanged();
                }
                Integer.valueOf(a.size());
            }
        }
    }

    private void m2392n() {
        Object obj = (this.aa == null || this.aa.b == null || !MultiShareNoLinkUtil.a(this.aa.b)) ? null : 1;
        if (obj != null && (((FeedUnit) this.f2457c.m2564b(this.f2457c.m2559a() - 1).a) instanceof ChannelFeedVideoSectionSeeMore)) {
            VideoChannelItemCollection videoChannelItemCollection = this.f2457c;
            int a = this.f2457c.m2559a() - 1;
            if (a >= 0 && a < videoChannelItemCollection.f2656a.size()) {
                FeedProps feedProps = (FeedProps) videoChannelItemCollection.f2656a.remove(a);
            }
        }
    }

    private void m2384a(String str, int i) {
        int indexOf = this.f2451T.indexOf(str);
        Preconditions.checkState(indexOf >= 0, "insertedIndex should be non negative");
        for (String str2 : this.f2452U.keySet()) {
            boolean z;
            int indexOf2 = this.f2451T.indexOf(str2);
            if (indexOf2 >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "index should be non negative");
            if (indexOf2 >= indexOf) {
                this.f2452U.put(str2, Integer.valueOf(((Integer) this.f2452U.get(str2)).intValue() + i));
            }
        }
    }

    private void m2393o() {
        List arrayList = new ArrayList();
        int size = this.aa.b.size();
        boolean a = MultiShareNoLinkUtil.a(this.aa.b);
        for (int i = 0; i < size; i++) {
            Flattenable flattenable = (GraphQLStory) ((FeedProps) this.aa.b.get(i)).a;
            String a2 = this.f2476v.m2439a((GraphQLStory) flattenable);
            if (a2 != null) {
                if (a) {
                    Type type;
                    if (i == 0) {
                        type = Type.FIRST;
                    } else if (i == size - 1) {
                        type = Type.LAST;
                    } else {
                        type = Type.NORMAL;
                    }
                    flattenable = new MultiShareChannelStoryUnit(flattenable, type);
                }
                this.f2457c.m2566b(FeedProps.c(flattenable));
                arrayList.add(a2);
            }
        }
        if (a) {
            String str;
            List<FeedProps> list = this.aa.b;
            if (list == null || list.isEmpty()) {
                str = null;
            } else {
                for (FeedProps feedProps : list) {
                    GraphQLActor b = StoryActorHelper.b((GraphQLStory) feedProps.a);
                    if (b != null && b.aa() != null) {
                        str = b.aa();
                        break;
                    }
                }
                str = null;
            }
            String str2 = str;
            String str3 = null;
            if (this.aa.c != null && this.aa.c.size() > 0) {
                str3 = (String) this.aa.c.get(0);
            }
            if (!(str2 == null || str3 == null)) {
                this.f2457c.m2566b(FeedProps.c(new ChannelFeedVideoSectionSeeMore(str2, str3, true)));
                m2388i();
                this.f2452U.put(str3, Integer.valueOf(arrayList.size() + 1));
            }
        }
        if (m2394p()) {
            this.f2480z.b(((GraphQLStorySet) this.aa.a.b()).g(), arrayList);
        } else if (this.aj != null) {
            this.f2480z.a(this.aj, arrayList);
        }
        this.ab.notifyDataSetChanged();
        int i2 = this.aa.n;
        if (i2 >= 0) {
            m2386d(i2);
        }
    }

    private boolean m2394p() {
        if (this.aa == null) {
            return false;
        }
        boolean z = this.aa.g != null && this.aa.g.subOrigin.equals(PlayerOrigin.VIDEO_SETS.subOrigin);
        boolean z2;
        if (this.aa.a == null || this.aa.a.b() == null || !(this.aa.a.b() instanceof GraphQLStorySet)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }

    private void m2395q() {
        ChannelFeedHeaderParams channelFeedHeaderParams = this.aa.k;
        if (channelFeedHeaderParams != null) {
            this.f2445N.m2298a(channelFeedHeaderParams);
            this.f2447P.d(this.f2445N);
            this.f2447P.a(this.f2447P.h(), 0, this.f2447P.i(), this.f2447P.f());
            this.f2440I.setVisibility(8);
            return;
        }
        this.f2447P.a(this.f2447P.h(), getResources().getDimensionPixelSize(2131431496), this.f2447P.i(), this.f2447P.f());
        this.f2440I.setVisibility(0);
    }

    private void m2396r() {
        if (getParent() == null && this.af != null) {
            this.af.addView(this);
        }
    }

    private void m2397s() {
        if (getParent() == this.af) {
            this.af.removeView(this);
        }
    }

    private JsonNode getTrackingCodes() {
        if (this.aa.a == null) {
            return new ArrayNode(JsonNodeFactory.a);
        }
        FeedProps b = StoryProps.b(this.aa.a);
        if (b != null) {
            return TrackableFeedProps.a(b);
        }
        return TrackableFeedProps.a(this.aa.a);
    }

    public static VideoPrefetchVisitor getVideoPrefetchVisitor(ChannelFeedRootView channelFeedRootView) {
        if (channelFeedRootView.ai == null) {
            channelFeedRootView.ai = channelFeedRootView.f2472r.a(VideoPrefetchLocation.CHANNEL, CallerContext.a(channelFeedRootView.getClass()));
        }
        return channelFeedRootView.ai;
    }

    public final boolean m2404a() {
        return this.f2454W;
    }

    public final void u_(int i) {
    }

    @SuppressLint({"WrongConstant"})
    public final boolean m2405b() {
        if (!m2404a()) {
            return false;
        }
        Activity activity = (Activity) getContext();
        activity.setRequestedOrientation(this.an);
        if (this.f2471q.m2210b()) {
            return true;
        }
        int a;
        this.f2478x.c(this.f2447P);
        this.f2478x.a(false, this.f2447P);
        this.f2467m.a.b();
        String str = PlayerType.INLINE_PLAYER.value;
        String str2 = PlayerType.CHANNEL_PLAYER.value;
        int a2 = this.am != null ? this.am.m2432a() : 0;
        if (this.am != null) {
            a = this.am.m2432a();
        } else {
            a = 0;
        }
        m2385a(str, str2, a2, a);
        if (this.aa.i != null) {
            InlineToChannelFeedTransitionManager inlineToChannelFeedTransitionManager = this.aa.i;
            ViewParent parent = inlineToChannelFeedTransitionManager.f2613f.getParent();
            if (parent instanceof VideoTransitionNode) {
                ((VideoTransitionNode) parent).i();
            }
            if (inlineToChannelFeedTransitionManager.f2612e.getRichVideoPlayer() == inlineToChannelFeedTransitionManager.f2613f) {
                inlineToChannelFeedTransitionManager.f2613f.k();
                for (RichVideoPlayerPlugin a3 : inlineToChannelFeedTransitionManager.f2614g) {
                    inlineToChannelFeedTransitionManager.f2613f.a(a3);
                }
                inlineToChannelFeedTransitionManager.f2612e.a(inlineToChannelFeedTransitionManager.f2613f);
                inlineToChannelFeedTransitionManager.f2613f.a(inlineToChannelFeedTransitionManager.f2616i);
                inlineToChannelFeedTransitionManager.f2613f.setShouldCropToFit(true);
                inlineToChannelFeedTransitionManager.f2613f.setPlayerType(inlineToChannelFeedTransitionManager.f2612e.getPlayerType());
                inlineToChannelFeedTransitionManager.f2613f.v = inlineToChannelFeedTransitionManager.f2615h;
                inlineToChannelFeedTransitionManager.f2618k = false;
                inlineToChannelFeedTransitionManager.f2612e = null;
                inlineToChannelFeedTransitionManager.f2613f = null;
                inlineToChannelFeedTransitionManager.f2616i = null;
                inlineToChannelFeedTransitionManager.f2614g = null;
                inlineToChannelFeedTransitionManager.f2615h = null;
                inlineToChannelFeedTransitionManager.f2617j = null;
            }
        }
        if (VERSION.SDK_INT >= 21) {
            if (this.ap != 0) {
                activity.getWindow().setStatusBarColor(this.ap);
            } else {
                activity.getWindow().setStatusBarColor(ContextUtils.c(activity, 2130772558, 0));
            }
        }
        ExitFullScreenResult exitFullScreenResult = getExitFullScreenResult();
        if (!(this.ah == null || exitFullScreenResult == null)) {
            this.ah.a(EventTriggerType.BY_USER, exitFullScreenResult);
        }
        m2399u();
        m2400v();
        this.f2454W = false;
        m2397s();
        return true;
    }

    public final void m2402a(FeedFullScreenParams feedFullScreenParams) {
    }

    public final void m2406c() {
        m2396r();
    }

    public final void m2407d() {
        m2398t();
        if (this.ac != null) {
            this.f2447P.a(this.ac);
        }
    }

    public final void m2408e() {
        m2399u();
        this.f2470p.f2092a.removeMessages(1);
        this.ac = this.f2447P.B();
    }

    public final void m2409f() {
        m2397s();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.ab != null) {
            this.ab.a(configuration);
        }
        this.f2447P.a(0, 0);
        this.f2471q.m2207a(configuration.orientation);
    }

    public void setLogExitingPauseEvent(boolean z) {
    }

    public void setLogEnteringStartEvent(boolean z) {
    }

    public final Object m2401a(FullScreenVideoListener fullScreenVideoListener) {
        this.ah = fullScreenVideoListener;
        return this;
    }

    public FullScreenVideoListener getFullScreenListener() {
        return this.ah;
    }

    public final boolean m2410g() {
        return false;
    }

    public void setAllowLooping(boolean z) {
        throw new UnsupportedOperationException("Looping is not supported");
    }

    private void m2398t() {
        this.f2478x.a(true, this.f2447P);
        this.f2463i.b();
        this.f2469o.a(this.f2438G);
        this.f2469o.a(this.f2439H);
        onConfigurationChanged(getResources().getConfiguration());
    }

    private void m2399u() {
        this.f2478x.c(this.f2447P);
        this.f2478x.a(false, this.f2447P);
        StoryEventSubscriberManager storyEventSubscriberManager = this.f2463i;
        storyEventSubscriberManager.a.b(storyEventSubscriberManager.b);
        this.f2469o.b(this.f2438G);
        this.f2469o.b(this.f2439H);
    }

    private void m2400v() {
        this.aj = null;
        this.ak = false;
        this.al = false;
        for (ChannelFeedVideoSectionController channelFeedVideoSectionController : this.f2450S.values()) {
            channelFeedVideoSectionController.f2572k.c(channelFeedVideoSectionController.f2577p);
            ChannelFeedVideoSectionController.m2497f(channelFeedVideoSectionController);
            if (channelFeedVideoSectionController.f2584w != null) {
                channelFeedVideoSectionController.f2584w.cancel(false);
                channelFeedVideoSectionController.f2584w = null;
            }
        }
        this.f2450S.clear();
        this.f2451T.clear();
        this.f2452U.clear();
        this.f2446O.setVisibility(8);
        this.f2440I.m2326d();
        this.f2440I.setTitle("");
        this.f2447P.a(this.f2445N);
        this.f2447P.b(this.f2453V);
        this.f2447P.a(this.f2447P.h(), this.f2447P.g(), this.f2447P.i(), 0);
        this.f2448Q.f2136p = null;
        this.f2448Q.f2139s = null;
        this.f2448Q.f2140t = false;
        this.f2457c.f2656a.clear();
        this.f2447P.a(null);
        if (this.ab != null) {
            this.ab.jc_();
            this.ab = null;
        }
        this.am = null;
        this.ah = null;
        this.aa = null;
        ChannelFeedMoreVideosPillController channelFeedMoreVideosPillController = this.ag;
        ChannelFeedMoreVideosPillController.m2315i(channelFeedMoreVideosPillController);
        channelFeedMoreVideosPillController.f2358c = null;
        channelFeedMoreVideosPillController.f2359d = null;
        this.ag = null;
        ChannelFeedAutoscrollController channelFeedAutoscrollController = this.f2470p;
        VideoDisplayedCoordinator videoDisplayedCoordinator = this.f2467m.a;
        if (videoDisplayedCoordinator != null) {
            videoDisplayedCoordinator.b(channelFeedAutoscrollController.f2096e);
            videoDisplayedCoordinator.m.remove(channelFeedAutoscrollController.f2097f);
        }
        channelFeedAutoscrollController.f2099h = null;
        channelFeedAutoscrollController.f2101j = null;
        this.f2467m.a.b(this.f2444M);
        this.f2464j.b();
        ChannelFeedFullscreenManager channelFeedFullscreenManager = this.f2471q;
        channelFeedFullscreenManager.f2198b = null;
        channelFeedFullscreenManager.f2199c = null;
        channelFeedFullscreenManager.f2200d = null;
        channelFeedFullscreenManager.f2202f = 1;
        channelFeedFullscreenManager.f2203g = false;
        channelFeedFullscreenManager.f2204h = false;
        channelFeedFullscreenManager.f2205i = false;
        channelFeedFullscreenManager.f2206j = false;
        ((GraphQLSubscriptionHolder) this.f2445N.f2332a.get()).b();
        this.f2471q.m2208a(this.f2441J);
        this.f2471q.f2198b = this.ae;
        getVideoPrefetchVisitor(this).d();
        getVideoPrefetchVisitor(this).b();
    }

    private Context getContextThemeWrapper() {
        if (this.ad == null) {
            this.ad = new ContextThemeWrapper(getContext(), 2131625866);
        }
        return this.ad;
    }

    @Nullable
    private ExitFullScreenResult getExitFullScreenResult() {
        boolean z;
        if (this.am != null) {
            z = this.am.f2504f;
        } else {
            z = true;
        }
        return new ExitFullScreenResult(z, this.am != null ? this.am.f2505g : false, this.am != null ? this.am.m2432a() : 0, this.am != null ? this.am.m2432a() : 0, false, null, EventTriggerType.BY_INLINE_CHANNEL_FEED_TRANSITION);
    }
}
