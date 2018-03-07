package com.facebook.feed.ui.fullscreenvideoplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.facebook.attachments.videos.ui.Inline360VideoAttachmentView;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.content.event.FbEvent;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.feed.annotations.IsInNewPlayerNewUIClosedCaptioningGateKeeper;
import com.facebook.feed.annotations.IsInNewPlayerOldUIClosedCaptioningGateKeeper;
import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.feed.data.FeedStorySubscriber.OnStoryChangeListener;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.VideoFeedStoryMenuHelper;
import com.facebook.feed.ui.VideoFeedStoryMenuHelperProvider;
import com.facebook.feed.ui.fullscreenvideoplayer.InlineToFullscreenVideoTransitionManager.FullscreenType;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEventSubscriber;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feed.video.FeedFullScreenParams$AugmentedAnalyticsParams;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.feed.video.util.VideoUtils;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoPlaybackAnalyticsParams;
import com.facebook.video.analytics.VideoTransitionPerfLogger;
import com.facebook.video.chromecast.VideoCastManager;
import com.facebook.video.commercialbreak.CommercialBreakInfoTracker;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.FullScreenVideoListener;
import com.facebook.video.player.IsVideoSpecDisplayEnabled;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.player.environment.CanHandleOnVideoDeleted;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin.VideoPluginAlignment;
import com.facebook.widget.CustomRelativeLayout;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TopicClassificationQuery */
public class FeedFullScreenVideoPlayer extends CustomRelativeLayout implements ImmersiveVideoPlayer, VideoTransitionNode {
    private final Handler f21893A;
    private final FeedFullScreenVideoPlayerEnvironment f21894B;
    public RichVideoPlayer f21895C;
    public FeedFullScreenParams f21896D;
    public RichVideoPlayerParams f21897E;
    private VideoPlaybackAnalyticsParams f21898F;
    public ViewGroup f21899G;
    private LayoutParams f21900H;
    private FullScreenVideoListener f21901I;
    private DynamicSecureBroadcastReceiver f21902J;
    private long f21903K;
    private boolean f21904L;
    private boolean f21905M;
    private boolean f21906N;
    private boolean f21907O;
    private boolean f21908P;
    private boolean f21909Q;
    @Nullable
    public GraphQLStory f21910R;
    private int f21911S;
    public final VideoFeedStoryMenuHelper f21912T;
    private final OnStoryChangeListener f21913U;
    private final StoryVisibilityEventSubscriber f21914V;
    @Inject
    VideoTransitionPerfLogger f21915a;
    @Inject
    ErrorDialogs f21916b;
    @Inject
    Lazy<NetworkMonitor> f21917c;
    @Inject
    @IsInNewPlayerOldUIClosedCaptioningGateKeeper
    Provider<Boolean> f21918d;
    @Inject
    @IsInNewPlayerNewUIClosedCaptioningGateKeeper
    Provider<Boolean> f21919e;
    @Inject
    @IsVideoSpecDisplayEnabled
    Boolean f21920f;
    @Inject
    InlineToFullscreenVideoTransitionManager f21921g;
    @Inject
    GatekeeperStoreImpl f21922h;
    @Inject
    Lazy<VideoCastManager> f21923i;
    @Inject
    RapidFeedbackController f21924j;
    @Inject
    Clock f21925k;
    @Inject
    FeedVideoPlayerParamBuilderProvider f21926l;
    @Inject
    Video360PlayerConfig f21927m;
    @Inject
    WindowManager f21928n;
    @Inject
    VideoLoggingUtils f21929o;
    @Inject
    FacecastUtil f21930p;
    @Inject
    VideoLivePlaybackConfig f21931q;
    @Inject
    VideoFeedStoryMenuHelperProvider f21932r;
    @Inject
    FeedStorySubscriber f21933s;
    @Inject
    FeedEventBus f21934t;
    @Inject
    CommercialBreakConfig f21935u;
    @Inject
    CommercialBreakInfoTracker f21936v;
    private final RichVideoPlayerCallbackListener f21937w;
    private final RichVideoPlayer f21938x;
    private final AudioManager f21939y;
    private final Window f21940z;

    /* compiled from: TopicClassificationQuery */
    class C18561 implements RichVideoPlayerCallbackListener {
        final /* synthetic */ FeedFullScreenVideoPlayer f21886a;

        C18561(FeedFullScreenVideoPlayer feedFullScreenVideoPlayer) {
            this.f21886a = feedFullScreenVideoPlayer;
        }

        public final void m24470a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
            this.f21886a.mo1526b();
        }

        public final void m24468a() {
            this.f21886a.m24493a(true);
        }

        public final void m24469a(RVPErrorEvent rVPErrorEvent) {
            this.f21886a.f21916b.a(ErrorDialogParams.a(this.f21886a.getResources()).a(2131232761).b(((NetworkMonitor) this.f21886a.f21917c.get()).a() ? 2131232762 : 2131232763).l());
            this.f21886a.mo1526b();
        }
    }

    /* compiled from: TopicClassificationQuery */
    class C18572 implements OnStoryChangeListener {
        final /* synthetic */ FeedFullScreenVideoPlayer f21887a;

        C18572(FeedFullScreenVideoPlayer feedFullScreenVideoPlayer) {
            this.f21887a = feedFullScreenVideoPlayer;
        }

        public final void mo1522a(GraphQLStory graphQLStory) {
            if (this.f21887a.f21895C != null && graphQLStory != null) {
                Builder d = this.f21887a.f21897E.d();
                d.a("GraphQLStoryProps", FeedProps.c(graphQLStory));
                this.f21887a.f21895C.a(d.b());
            }
        }
    }

    /* compiled from: TopicClassificationQuery */
    class C18583 extends StoryVisibilityEventSubscriber {
        final /* synthetic */ FeedFullScreenVideoPlayer f21888a;

        C18583(FeedFullScreenVideoPlayer feedFullScreenVideoPlayer) {
            this.f21888a = feedFullScreenVideoPlayer;
        }

        public final void m24472b(FbEvent fbEvent) {
            StoryVisibilityEvent storyVisibilityEvent = (StoryVisibilityEvent) fbEvent;
            if (this.f21888a.f21910R != null && this.f21888a.f21910R.g() != null && this.f21888a.f21910R.g().equals(storyVisibilityEvent.a) && storyVisibilityEvent.d == StoryVisibility.HIDDEN) {
                this.f21888a.m24497b(false);
            }
        }
    }

    /* compiled from: TopicClassificationQuery */
    class C18594 implements Runnable {
        final /* synthetic */ FeedFullScreenVideoPlayer f21889a;

        C18594(FeedFullScreenVideoPlayer feedFullScreenVideoPlayer) {
            this.f21889a = feedFullScreenVideoPlayer;
        }

        public void run() {
            FeedFullScreenVideoPlayer.m24511l(this.f21889a);
        }
    }

    /* compiled from: TopicClassificationQuery */
    class C18605 implements ActionReceiver {
        final /* synthetic */ FeedFullScreenVideoPlayer f21890a;

        C18605(FeedFullScreenVideoPlayer feedFullScreenVideoPlayer) {
            this.f21890a = feedFullScreenVideoPlayer;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1530407984);
            if (intent.getIntExtra("state", 1) == 0 && !broadcastReceiverLike.isInitialStickyBroadcast() && this.f21890a.f21895C != null && this.f21890a.f21895C.h()) {
                this.f21890a.f21895C.b(EventTriggerType.BY_PLAYER);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 299980551, a);
        }
    }

    /* compiled from: TopicClassificationQuery */
    class C18616 implements Runnable {
        final /* synthetic */ FeedFullScreenVideoPlayer f21891a;

        C18616(FeedFullScreenVideoPlayer feedFullScreenVideoPlayer) {
            this.f21891a = feedFullScreenVideoPlayer;
        }

        public void run() {
            FeedFullScreenVideoPlayer.m24522w(this.f21891a);
        }
    }

    /* compiled from: TopicClassificationQuery */
    class FeedFullScreenVideoPlayerEnvironment implements CanHandleOnVideoDeleted, HasFeedMenuHelper {
        final /* synthetic */ FeedFullScreenVideoPlayer f21892a;

        public FeedFullScreenVideoPlayerEnvironment(FeedFullScreenVideoPlayer feedFullScreenVideoPlayer) {
            this.f21892a = feedFullScreenVideoPlayer;
        }

        public final void m24473a() {
            FeedProps feedProps;
            if (this.f21892a.f21896D.b != null) {
                feedProps = this.f21892a.f21896D.b.b;
            } else {
                feedProps = null;
            }
            if (feedProps != null) {
                this.f21892a.f21934t.a(new StoryDeleteEvent(feedProps));
            }
            if (this.f21892a.mo1525a()) {
                this.f21892a.m24497b(true);
            }
        }

        public final BaseFeedStoryMenuHelper m24474l() {
            return this.f21892a.f21912T;
        }
    }

    private static <T extends View> void m24491a(Class<T> cls, T t) {
        m24492a((Object) t, t.getContext());
    }

    private static void m24492a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FeedFullScreenVideoPlayer) obj).m24488a(VideoTransitionPerfLogger.a(injectorLike), ErrorDialogs.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 587), IdBasedProvider.a(injectorLike, 3985), IdBasedProvider.a(injectorLike, 3984), Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.a(injectorLike), InlineToFullscreenVideoTransitionManager.m24547a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 11613), RapidFeedbackController.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), Video360PlayerConfig.a(injectorLike), WindowManagerMethodAutoProvider.a(injectorLike), VideoLoggingUtils.a(injectorLike), FacecastUtil.m3105a(injectorLike), VideoLivePlaybackConfig.a(injectorLike), (VideoFeedStoryMenuHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoFeedStoryMenuHelperProvider.class), FeedStorySubscriber.m22695a(injectorLike), FeedEventBus.a(injectorLike), CommercialBreakConfig.a(injectorLike), CommercialBreakInfoTracker.a(injectorLike));
    }

    private void m24488a(VideoTransitionPerfLogger videoTransitionPerfLogger, ErrorDialogs errorDialogs, Lazy<NetworkMonitor> lazy, Provider<Boolean> provider, Provider<Boolean> provider2, Boolean bool, InlineToFullscreenVideoTransitionManager inlineToFullscreenVideoTransitionManager, GatekeeperStore gatekeeperStore, Lazy<VideoCastManager> lazy2, RapidFeedbackController rapidFeedbackController, Clock clock, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, Video360PlayerConfig video360PlayerConfig, WindowManager windowManager, VideoLoggingUtils videoLoggingUtils, FacecastUtil facecastUtil, VideoLivePlaybackConfig videoLivePlaybackConfig, VideoFeedStoryMenuHelperProvider videoFeedStoryMenuHelperProvider, FeedStorySubscriber feedStorySubscriber, FeedEventBus feedEventBus, CommercialBreakConfig commercialBreakConfig, CommercialBreakInfoTracker commercialBreakInfoTracker) {
        this.f21915a = videoTransitionPerfLogger;
        this.f21916b = errorDialogs;
        this.f21917c = lazy;
        this.f21918d = provider;
        this.f21919e = provider2;
        this.f21920f = bool;
        this.f21921g = inlineToFullscreenVideoTransitionManager;
        this.f21922h = gatekeeperStore;
        this.f21923i = lazy2;
        this.f21924j = rapidFeedbackController;
        this.f21925k = clock;
        this.f21926l = feedVideoPlayerParamBuilderProvider;
        this.f21927m = video360PlayerConfig;
        this.f21928n = windowManager;
        this.f21929o = videoLoggingUtils;
        this.f21930p = facecastUtil;
        this.f21931q = videoLivePlaybackConfig;
        this.f21932r = videoFeedStoryMenuHelperProvider;
        this.f21933s = feedStorySubscriber;
        this.f21934t = feedEventBus;
        this.f21935u = commercialBreakConfig;
        this.f21936v = commercialBreakInfoTracker;
    }

    private static boolean m24502c(FeedFullScreenParams feedFullScreenParams) {
        return feedFullScreenParams.h instanceof Inline360VideoAttachmentView;
    }

    public FeedFullScreenVideoPlayer(Context context) {
        this(context, null);
    }

    public FeedFullScreenVideoPlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedFullScreenVideoPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21937w = new C18561(this);
        this.f21908P = true;
        this.f21913U = new C18572(this);
        this.f21914V = new C18583(this);
        m24491a(FeedFullScreenVideoPlayer.class, (View) this);
        this.f21940z = getContext() instanceof Activity ? ((Activity) getContext()).getWindow() : null;
        this.f21939y = (AudioManager) context.getSystemService("audio");
        View.inflate(context, 2130906860, this);
        this.f21938x = (RichVideoPlayer) a(2131560290);
        this.f21938x.setVisibility(8);
        this.f21900H = new LayoutParams(-1, -1, 2, 16779144, -3);
        this.f21900H.gravity = 51;
        this.f21893A = new Handler(Looper.getMainLooper());
        this.f21894B = new FeedFullScreenVideoPlayerEnvironment(this);
        this.f21912T = this.f21932r.m24402a(null, NegativeFeedbackExperienceLocation.NEWSFEED, "video_fullscreen_player");
        this.f21933s.f19187d = this.f21913U;
    }

    public final boolean mo1525a() {
        return this.f21904L;
    }

    public final boolean mo1526b() {
        if (!mo1525a()) {
            return false;
        }
        m24497b(false);
        return true;
    }

    public final void u_(int i) {
        if (this.f21904L) {
            int currentVolume = getCurrentVolume();
            switch (i) {
                case 24:
                    m24515p();
                    this.f21895C.c(currentVolume);
                    m24501c(currentVolume);
                    return;
                case 25:
                    this.f21895C.c(currentVolume);
                    m24501c(currentVolume);
                    m24514o();
                    return;
                case 164:
                    this.f21895C.c(0);
                    m24501c(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void mo1527c() {
        m24519t();
    }

    public final void mo1528d() {
        this.f21906N = getCurrentVolume() == 0;
        m24503d(getResources().getConfiguration().orientation);
    }

    public final void mo1529e() {
        m24493a(false);
        if (this.f21895C != null && this.f21895C.h()) {
            this.f21895C.b(EventTriggerType.BY_USER);
        }
    }

    public final void mo1530f() {
        m24520u();
        m24513n();
    }

    public void setLogExitingPauseEvent(boolean z) {
        this.f21908P = z;
    }

    public void setLogEnteringStartEvent(boolean z) {
    }

    public final Object mo1523a(FullScreenVideoListener fullScreenVideoListener) {
        this.f21901I = fullScreenVideoListener;
        return this;
    }

    public FullScreenVideoListener getFullScreenListener() {
        return this.f21901I;
    }

    public final boolean mo1531g() {
        return getCurrentVolume() <= 0;
    }

    private RichVideoPlayerParams m24486a(FeedFullScreenParams feedFullScreenParams, boolean z) {
        boolean z2;
        Flattenable z3;
        FeedProps c;
        FeedProps e;
        boolean v;
        Object obj;
        Object a;
        boolean z4;
        FeedProps e2 = feedFullScreenParams.e();
        GraphQLStory c2 = e2 != null ? AttachmentProps.c(e2) : null;
        if (e2 == null || c2 == null || StoryAttachmentHelper.h(c2)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (feedFullScreenParams.d() != null) {
            z3 = feedFullScreenParams.d().z();
        } else {
            z3 = null;
        }
        if (z3 != null) {
            c = FeedProps.c(z3);
        } else {
            c = null;
        }
        if (z2) {
            e = AttachmentProps.e(e2);
        } else {
            e = c;
        }
        VideoPlayerParams a2 = this.f21926l.a(e2, feedFullScreenParams.d()).a(z, false);
        Double valueOf = Double.valueOf(1.7777777777777777d);
        ImmutableList.Builder builder = ImmutableList.builder();
        Double d;
        if (feedFullScreenParams.d() != null) {
            Double valueOf2;
            int bw = feedFullScreenParams.d().bw();
            int I = feedFullScreenParams.d().I();
            if (feedFullScreenParams.d().ai()) {
                valueOf2 = Double.valueOf(1.7777777910232544d);
                if (this.f21927m.o()) {
                    if (getContext().getResources().getConfiguration().orientation == 2) {
                        valueOf2 = Double.valueOf(1.7777777910232544d);
                    } else {
                        valueOf2 = Double.valueOf(0.5624999958090484d);
                    }
                }
            } else if (I <= 0 || bw <= 0) {
                valueOf2 = valueOf;
            } else {
                valueOf2 = Double.valueOf((1.0d * ((double) bw)) / ((double) I));
            }
            ImmutableList bo = feedFullScreenParams.d().bo();
            if (bo != null) {
                builder.b(bo);
            }
            boolean u = feedFullScreenParams.d().u();
            v = feedFullScreenParams.d().v();
            if (feedFullScreenParams.d().bF() != null) {
                obj = valueOf2;
                a = ImageRequest.a(feedFullScreenParams.d().bF().b());
                z4 = v;
                v = u;
            } else {
                z4 = v;
                v = u;
                d = valueOf2;
                a = null;
            }
        } else {
            d = valueOf;
            v = false;
            z4 = true;
            a = null;
        }
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder();
        builder2.b("CoverImageParamsKey", feedFullScreenParams.h()).b("VideoAspectRatioKey", obj).b("ShowDeleteOptionKey", Boolean.valueOf(v)).b("ShowReportOptionKey", Boolean.valueOf(z4)).b("SubtitlesLocalesKey", builder.b()).b("ShowLiveCommentDialogFragment", Boolean.valueOf(feedFullScreenParams.q()));
        if (a != null) {
            builder2.b("BlurredCoverImageParamsKey", a);
        }
        ImmutableMap f = feedFullScreenParams.f();
        if (m24494a(f)) {
            m24490a(builder2, f);
        } else if (e != null) {
            builder2.b("GraphQLStoryProps", e);
            this.f21910R = (GraphQLStory) e.a();
        }
        Builder builder3 = new Builder();
        builder3.a = a2;
        return builder3.a(builder2.b()).b();
    }

    private static boolean m24494a(ImmutableMap immutableMap) {
        return immutableMap != null && immutableMap.containsKey("MultiShareGraphQLSubStoryPropsKey") && immutableMap.containsKey("MultiShareGraphQLSubStoryIndexKey");
    }

    private static void m24490a(ImmutableMap.Builder<String, Object> builder, ImmutableMap immutableMap) {
        builder.b("MultiShareGraphQLSubStoryPropsKey", immutableMap.get("MultiShareGraphQLSubStoryPropsKey"));
        builder.b("MultiShareGraphQLSubStoryIndexKey", immutableMap.get("MultiShareGraphQLSubStoryIndexKey"));
    }

    private void m24509h() {
        if (this.f21940z == null) {
            return;
        }
        if (VERSION.SDK_INT < 16) {
            this.f21940z.addFlags(1024);
        } else {
            setSystemUiVisibility(1284);
        }
    }

    private void m24510k() {
        if (this.f21940z != null) {
            this.f21940z.clearFlags(128);
            if (VERSION.SDK_INT < 16) {
                this.f21940z.clearFlags(1024);
            } else {
                this.f21940z.getDecorView().setSystemUiVisibility(0);
            }
        }
    }

    public static void m24511l(FeedFullScreenVideoPlayer feedFullScreenVideoPlayer) {
        if (VERSION.SDK_INT < 16) {
            if ((feedFullScreenVideoPlayer.f21940z.getAttributes().flags & 1024) == 0) {
                feedFullScreenVideoPlayer.m24509h();
            }
        } else if ((feedFullScreenVideoPlayer.f21940z.getDecorView().getSystemUiVisibility() & 4) == 0) {
            feedFullScreenVideoPlayer.m24509h();
        }
        HandlerDetour.b(feedFullScreenVideoPlayer.f21893A, new C18594(feedFullScreenVideoPlayer), 2000, -653686884);
    }

    public final void m24528a(RichVideoPlayer richVideoPlayer) {
        this.f21895C = richVideoPlayer;
        attachRecyclableViewToParent(richVideoPlayer, 0, richVideoPlayer.getLayoutParams());
    }

    public final RichVideoPlayer m24536i() {
        detachRecyclableViewFromParent(this.f21895C);
        return this.f21895C;
    }

    public final RichVideoPlayer m24537j() {
        return this.f21938x;
    }

    public RichVideoPlayer getRichVideoPlayer() {
        return this.f21895C;
    }

    public PlayerType getPlayerType() {
        return PlayerType.FULL_SCREEN_PLAYER;
    }

    public ImmutableList<RichVideoPlayerPlugin> getAdditionalPlugins() {
        return null;
    }

    public final void mo1524a(FeedFullScreenParams feedFullScreenParams) {
        boolean z = false;
        if (!this.f21904L) {
            boolean z2;
            Map a = Maps.a(1);
            a.put("android.intent.action.HEADSET_PLUG", new C18605(this));
            this.f21902J = new DynamicSecureBroadcastReceiver(a);
            getContext().registerReceiver(this.f21902J, new IntentFilter("android.intent.action.HEADSET_PLUG"));
            this.f21896D = feedFullScreenParams;
            this.f21897E = m24486a(this.f21896D, this.f21907O);
            this.f21898F = new FeedFullScreenParams$AugmentedAnalyticsParams(this.f21896D, this.f21897E.a);
            this.f21905M = false;
            boolean d = m24505d(this.f21896D);
            m24519t();
            m24512m();
            this.f21915a.b(feedFullScreenParams.r(), d);
            this.f21915a.c(feedFullScreenParams.r(), true);
            this.f21903K = this.f21925k.a();
            GraphQLVideo graphQLVideo = this.f21896D.a;
            boolean z3 = this.f21930p.m3113h() && graphQLVideo.aj() && graphQLVideo.bG();
            this.f21895C = this.f21921g.m24549a(this.f21896D.h, this, this.f21897E, FullscreenType.FULLSCREEN, this.f21894B);
            this.f21895C.setOriginalPlayReason(feedFullScreenParams.l.b);
            this.f21895C.v = this.f21937w;
            this.f21904L = true;
            this.f21906N = getCurrentVolume() == 0;
            if (this.f21901I != null) {
                this.f21901I.a(EventTriggerType.BY_USER);
            }
            this.f21911S = getResources().getConfiguration().orientation;
            if (graphQLVideo.ae() || z3) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f21909Q = z2;
            if (!this.f21909Q || getResources().getConfiguration().orientation == 2) {
                this.f21895C.setVideoPluginAlignment(VideoPluginAlignment.CENTER);
            } else {
                this.f21895C.setVideoPluginAlignment(VideoPluginAlignment.TOP);
            }
            this.f21895C.a(this.f21897E);
            boolean n = this.f21895C.u.n();
            if (!d || (this.f21896D.a.ae() && this.f21896D.j == EventTriggerType.BY_USER && this.f21931q.D)) {
                this.f21895C.a(feedFullScreenParams.j(), EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION);
            }
            this.f21895C.setPlayerOrigin(this.f21896D.k());
            if (m24498b(this.f21896D)) {
                Video360Plugin video360Plugin;
                if (this.f21896D.h != null) {
                    video360Plugin = (Video360Plugin) this.f21896D.h.j().a(Video360Plugin.class);
                } else {
                    video360Plugin = (Video360Plugin) this.f21938x.a(Video360Plugin.class);
                }
                video360Plugin.f();
                video360Plugin.B = true;
                if (this.f21927m.r) {
                    Context context = getContext();
                    if (context != null && (context instanceof Activity)) {
                        ((Activity) context).setRequestedOrientation(1);
                    }
                }
            }
            z2 = m24518s();
            boolean a2 = VideoUtils.a(graphQLVideo.aj(), graphQLVideo.t());
            if (!(z2 || m24484A() || a2)) {
                this.f21895C.a(feedFullScreenParams.j, feedFullScreenParams.p());
            }
            if (m24484A()) {
                this.f21895C.a(this.f21897E, ImmutableList.of(CommercialBreakPlugin.class), true);
            }
            if (this.f21895C != null) {
                this.f21895C.a(false, EventTriggerType.BY_USER);
                if (graphQLVideo.aj() && this.f21930p.m3122w() && this.f21897E.b()) {
                    z = true;
                }
                this.f21895C.setShouldCropToFit(z);
                m24501c(getCurrentVolume());
                if (d && n) {
                    m24493a(true);
                }
                if (!z2) {
                    m24517r();
                }
            }
        }
    }

    private void m24512m() {
        if (this.f21910R != null && this.f21910R.c() != null) {
            this.f21933s.m22699a(this.f21910R, true);
            this.f21934t.a(this.f21914V);
        }
    }

    private void m24513n() {
        this.f21933s.m22697a();
        this.f21934t.b(this.f21914V);
    }

    private boolean m24498b(FeedFullScreenParams feedFullScreenParams) {
        boolean z;
        if (this.f21927m.e && feedFullScreenParams.a != null && feedFullScreenParams.a.ai()) {
            z = true;
        } else {
            z = false;
        }
        return m24502c(feedFullScreenParams) || z;
    }

    private static boolean m24505d(FeedFullScreenParams feedFullScreenParams) {
        VideoTransitionNode videoTransitionNode = feedFullScreenParams.h;
        if (videoTransitionNode == null) {
            return false;
        }
        RichVideoPlayer richVideoPlayer = videoTransitionNode.getRichVideoPlayer();
        if (richVideoPlayer == null || richVideoPlayer.l()) {
            return false;
        }
        return true;
    }

    public void setAllowLooping(boolean z) {
        this.f21907O = z;
    }

    private void m24493a(boolean z) {
        if (!this.f21905M) {
            this.f21905M = true;
            VideoTransitionPerfLogger videoTransitionPerfLogger = this.f21915a;
            int b = VideoTransitionPerfLogger.b(this.f21896D.r());
            if (videoTransitionPerfLogger.a.j(1900547, b)) {
                videoTransitionPerfLogger.a.b(1900547, b, z ? (short) 2 : (short) 3);
            }
        }
    }

    private void m24497b(boolean z) {
        if (this.f21902J != null) {
            try {
                getContext().unregisterReceiver(this.f21902J);
            } catch (IllegalArgumentException e) {
            }
            this.f21902J = null;
        }
        if (m24502c(this.f21896D)) {
            Video360Plugin video360Plugin = (Video360Plugin) this.f21896D.g().j().a(Video360Plugin.class);
            video360Plugin.k();
            video360Plugin.e();
            if (this.f21927m.o()) {
                Context context = getContext();
                if (context != null && (context instanceof Activity)) {
                    ((Activity) context).setRequestedOrientation(4);
                }
            }
        }
        m24493a(false);
        this.f21895C.a(true, EventTriggerType.BY_USER);
        ExitFullScreenResult c = m24500c(z);
        if (this.f21896D.d().ae() && this.f21925k.a() - this.f21903K > 10000) {
            this.f21924j.a("423369554524330", getContext());
        }
        RichVideoPlayer richVideoPlayer = this.f21895C;
        EventTriggerType eventTriggerType = (this.f21908P || !this.f21895C.m()) ? EventTriggerType.BY_USER : EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION;
        richVideoPlayer.b(eventTriggerType);
        this.f21921g.m24550a();
        if (!m24518s()) {
            m24489a(c);
        }
        this.f21895C = null;
        if (this.f21901I != null) {
            this.f21901I.a(EventTriggerType.BY_USER, c);
        }
        this.f21904L = false;
        m24520u();
    }

    private void m24514o() {
        int currentPositionMs = this.f21895C.getCurrentPositionMs();
        int currentVolume = getCurrentVolume();
        this.f21929o.a(this.f21896D.m(), PlayerType.FULL_SCREEN_PLAYER.value, EventTriggerType.BY_USER.value, currentPositionMs, currentVolume, this.f21896D.r(), this.f21896D.k(), this.f21898F);
        if (currentVolume == 0 && !this.f21906N) {
            this.f21906N = true;
            m24516q();
        }
    }

    private void m24515p() {
        int currentPositionMs = this.f21895C.getCurrentPositionMs();
        int currentVolume = getCurrentVolume();
        this.f21929o.b(this.f21896D.m(), PlayerType.FULL_SCREEN_PLAYER.value, EventTriggerType.BY_USER.value, currentPositionMs, getCurrentVolume(), this.f21896D.r(), this.f21896D.k(), this.f21898F);
        if (currentVolume > 0 && this.f21906N) {
            this.f21906N = false;
            m24516q();
        }
    }

    private void m24516q() {
        int currentPositionMs = this.f21895C.getCurrentPositionMs();
        ArrayNode m = this.f21896D.m();
        if (this.f21906N) {
            this.f21929o.a(m, PlayerType.FULL_SCREEN_PLAYER.value, EventTriggerType.BY_USER.value, currentPositionMs, this.f21896D.r(), this.f21896D.k(), this.f21896D.o(), this.f21898F);
        } else {
            this.f21929o.b(m, PlayerType.FULL_SCREEN_PLAYER.value, EventTriggerType.BY_USER.value, currentPositionMs, this.f21896D.r(), this.f21896D.k(), this.f21896D.o(), this.f21898F);
        }
    }

    private void m24517r() {
        int p;
        int j = this.f21896D.j() > 0 ? this.f21896D.j() : 0;
        if (this.f21896D.p() > 0) {
            p = this.f21896D.p();
        } else {
            p = 0;
        }
        this.f21929o.a(this.f21896D.m(), PlayerType.FULL_SCREEN_PLAYER.value, this.f21896D.d.a.value, this.f21896D.r(), this.f21896D.k(), this.f21896D.i().value, j, p, this.f21896D.o(), this.f21898F, this.f21896D.e, this.f21896D.f);
    }

    private boolean m24518s() {
        return m24525z() && ((VideoCastManager) this.f21923i.get()).a(this.f21896D.r());
    }

    private void m24489a(ExitFullScreenResult exitFullScreenResult) {
        this.f21929o.a(this.f21896D.m(), PlayerType.INLINE_PLAYER.value, PlayerType.FULL_SCREEN_PLAYER.value, this.f21896D.r(), this.f21896D.k(), this.f21896D.i().value, exitFullScreenResult.c, exitFullScreenResult.d, this.f21896D.o(), this.f21898F, this.f21896D.e, this.f21896D.u());
    }

    private void m24519t() {
        if (getParent() == null && this.f21899G != null) {
            m24509h();
            m24511l(this);
            m24521v();
            this.f21899G.addView(this);
        }
    }

    private void m24520u() {
        if (getParent() != null) {
            this.f21893A.removeCallbacksAndMessages(null);
            m24510k();
            if (getParent() == this.f21899G) {
                m24522w(this);
                this.f21899G.removeView(this);
                return;
            }
            this.f21928n.removeViewImmediate(this);
        }
    }

    private void m24521v() {
        ViewGroup.LayoutParams layoutParams = this.f21899G.getLayoutParams();
        layoutParams.height = this.f21899G.getBottom();
        this.f21899G.setLayoutParams(layoutParams);
        HandlerDetour.b(this.f21893A, new C18616(this), 300, 555699556);
    }

    public static void m24522w(FeedFullScreenVideoPlayer feedFullScreenVideoPlayer) {
        ViewGroup.LayoutParams layoutParams = feedFullScreenVideoPlayer.f21899G.getLayoutParams();
        if (layoutParams.height != -1) {
            layoutParams.height = -1;
            feedFullScreenVideoPlayer.f21899G.setLayoutParams(layoutParams);
        }
    }

    private ExitFullScreenResult m24500c(boolean z) {
        boolean z2 = true;
        int currentPositionMs = this.f21895C.getCurrentPositionMs();
        if (currentPositionMs < 0) {
            currentPositionMs = 0;
        }
        int lastStartPosition = this.f21895C.getLastStartPosition();
        if (lastStartPosition < 0) {
            lastStartPosition = 0;
        }
        if (lastStartPosition > currentPositionMs) {
            lastStartPosition = currentPositionMs;
        }
        boolean z3 = !this.f21895C.o();
        if (!(z || this.f21895C.p())) {
            z2 = false;
        }
        return new ExitFullScreenResult(z3, z2, currentPositionMs, lastStartPosition, false, null, EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION);
    }

    public void setParentView(ViewGroup viewGroup) {
        this.f21899G = viewGroup;
    }

    protected int getCurrentVolume() {
        return (this.f21939y.getStreamVolume(3) * 100) / this.f21939y.getStreamMaxVolume(3);
    }

    private boolean m24523x() {
        return ((Boolean) this.f21918d.get()).equals(Boolean.TRUE);
    }

    private boolean m24524y() {
        return ((Boolean) this.f21919e.get()).equals(Boolean.TRUE);
    }

    private void m24501c(int i) {
        if (!m24524y() && !m24523x()) {
            this.f21895C.a(i <= 0);
        }
    }

    private boolean m24525z() {
        return this.f21922h.a(VideoAbTestGatekeepers.d, false);
    }

    public void requestLayout() {
        super.requestLayout();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m24503d(configuration.orientation);
    }

    private void m24503d(int i) {
        if (this.f21911S != i) {
            this.f21911S = i;
            if (!this.f21909Q) {
                return;
            }
            if (i == 2) {
                this.f21895C.setVideoPluginAlignment(VideoPluginAlignment.CENTER);
            } else {
                this.f21895C.setVideoPluginAlignment(VideoPluginAlignment.TOP);
            }
        }
    }

    private boolean m24484A() {
        State e = this.f21936v.e(this.f21896D.r());
        return e == State.TRANSITION || e == State.STATIC_COUNTDOWN || e == State.WAIT_FOR_ADS || (this.f21935u.i && e == State.VIDEO_AD);
    }
}
