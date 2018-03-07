package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.WindowManager;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.events.LikeClicked;
import com.facebook.feed.ufi.FullscreenVideoFeedbackActionButtonBar;
import com.facebook.feed.ui.fullscreenvideoplayer.FeedFullScreenVideoPlayer;
import com.facebook.feed.ui.fullscreenvideoplayer.commentwithvideo.VideoFeedbackFragment;
import com.facebook.feed.ui.fullscreenvideoplayer.commentwithvideo.VideoFeedbackParams;
import com.facebook.feed.ui.fullscreenvideoplayer.commentwithvideo.VideoFeedbackPopoverLauncher;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.feedback.events.FeedbackEvents.UpdateLikeFeedbackEvent;
import com.facebook.feedback.ui.FeedbackController;
import com.facebook.feedback.ui.FeedbackControllerParams;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.model.Feedbackable;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnDismissEventSubscriber;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnResumeEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents.ShareStoryPublishEventSubscriber;
import com.facebook.video.abtest.VideoQEConfig;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPActivityDialogEvent;
import com.facebook.video.player.events.RVPDialogEvent;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RVPRequestSeekingEvent;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.widget.springbutton.TouchSpring;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TimelineHeaderTTI */
public abstract class FeedbackBasePlugin extends RichVideoPlayerPlugin {
    public View f22021A;
    private FullscreenVideoFeedbackActionButtonBar f22022B;
    public Subscription<UpdateLikeFeedbackEvent, String> f22023C;
    public RichVideoPlayerParams f22024D;
    public VideoFeedbackFragment f22025E;
    public boolean f22026F;
    private final OnClickListener f22027G;
    public final Action<UpdateLikeFeedbackEvent> f22028H;
    public final LikeUpdatedUIEventSubscriber f22029I;
    public final FlyoutOnResumeEventSubscriber f22030J;
    public final ShareStoryPublishEventSubscriber f22031K;
    public final FlyoutOnDismissEventSubscriber f22032L;
    public FeedProps<GraphQLStory> f22033a;
    protected ViewStub f22034b;
    @Inject
    public FeedEventBus f22035c;
    @Inject
    public FlyoutEventBus f22036d;
    @Inject
    public EventsStream f22037l;
    @Inject
    NumberTruncationUtil f22038m;
    @Inject
    Provider<TouchSpring> f22039n;
    @Inject
    FeedbackControllerProvider f22040o;
    @Inject
    WindowManager f22041p;
    @Inject
    Lazy<VideoQEConfig> f22042q;
    private final String f22043r;
    private final String f22044s;
    private FeedbackCustomPressStateButton f22045t;
    private FeedbackCustomPressStateButton f22046u;
    private FeedbackCustomPressStateButton f22047v;
    private View f22048w;
    private FbTextView f22049x;
    private FbTextView f22050y;
    public View f22051z;

    /* compiled from: TimelineHeaderTTI */
    class C18721 implements OnClickListener {
        final /* synthetic */ FeedbackBasePlugin f22013a;

        C18721(FeedbackBasePlugin feedbackBasePlugin) {
            this.f22013a = feedbackBasePlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1846366049);
            if (this.f22013a.h == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1239736579, a);
                return;
            }
            boolean isPlayingState = this.f22013a.h.l.isPlayingState();
            this.f22013a.g.a(new RVPDialogEvent(true));
            if (FeedbackBasePlugin.m24645l(this.f22013a)) {
                this.f22013a.f22026F = true;
                VideoFeedbackParams videoFeedbackParams = new VideoFeedbackParams(((GraphQLStory) this.f22013a.f22033a.a).l().z_(), this.f22013a.f22024D, this.f22013a.h.f(), isPlayingState, this.f22013a.h.o());
                if (((VideoQEConfig) this.f22013a.f22042q.get()).c) {
                    videoFeedbackParams.f21978f = FeedbackBasePlugin.getFullScreenVideoPlayer(this.f22013a);
                }
                this.f22013a.f22025E = VideoFeedbackPopoverLauncher.m24595a(this.f22013a.getContext(), videoFeedbackParams);
            } else {
                this.f22013a.f22051z.performClick();
            }
            LogUtils.a(1673841035, a);
        }
    }

    /* compiled from: TimelineHeaderTTI */
    class C18732 implements OnClickListener {
        final /* synthetic */ FeedbackBasePlugin f22014a;

        C18732(FeedbackBasePlugin feedbackBasePlugin) {
            this.f22014a = feedbackBasePlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1584187266);
            FeedProps feedProps = this.f22014a.f22033a;
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            GraphQLFeedback l = graphQLStory.l();
            if (!(l.z_() == null || l.j() == null)) {
                String str;
                FeedbackController a2 = this.f22014a.f22040o.m5074a(FeedbackControllerParams.f4498a);
                GraphQLFeedback l2 = graphQLStory.l();
                ArrayNode a3 = TrackableFeedProps.a(feedProps);
                String str2 = "newsfeed_ufi";
                if (this.f22014a.h.q == PlayerType.FULL_SCREEN_PLAYER) {
                    str = "video_fullscreen_player";
                } else {
                    str = "video";
                }
                a2.m5067a(l2, new FeedbackLoggingParams(a3, str2, str));
                this.f22014a.f22037l.a(new LikeClicked(feedProps, "video"));
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1945050987, a);
        }
    }

    /* compiled from: TimelineHeaderTTI */
    class C18743 implements OnClickListener {
        final /* synthetic */ FeedbackBasePlugin f22015a;

        C18743(FeedbackBasePlugin feedbackBasePlugin) {
            this.f22015a = feedbackBasePlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1868245891);
            this.f22015a.f22021A.performClick();
            Logger.a(2, EntryType.UI_INPUT_END, -668755099, a);
        }
    }

    /* compiled from: TimelineHeaderTTI */
    class C18754 implements Action<UpdateLikeFeedbackEvent> {
        final /* synthetic */ FeedbackBasePlugin f22016a;

        C18754(FeedbackBasePlugin feedbackBasePlugin) {
            this.f22016a = feedbackBasePlugin;
        }

        public final void m24634a(Object obj) {
            UpdateLikeFeedbackEvent updateLikeFeedbackEvent = (UpdateLikeFeedbackEvent) obj;
            if (updateLikeFeedbackEvent != null && updateLikeFeedbackEvent.a != null && updateLikeFeedbackEvent.a.z_() != null) {
                Builder a = Builder.a((GraphQLStory) this.f22016a.f22033a.a);
                a.D = updateLikeFeedbackEvent.a;
                GraphQLStory a2 = a.a();
                this.f22016a.f22033a = this.f22016a.f22033a.b(a2);
                this.f22016a.m24646a((Feedbackable) this.f22016a.f22033a.a);
            }
        }
    }

    /* compiled from: TimelineHeaderTTI */
    class C18765 extends LikeUpdatedUIEventSubscriber {
        final /* synthetic */ FeedbackBasePlugin f22017a;

        C18765(FeedbackBasePlugin feedbackBasePlugin) {
            this.f22017a = feedbackBasePlugin;
        }

        public final void m24635b(FbEvent fbEvent) {
            LikeUpdatedUIEvent likeUpdatedUIEvent = (LikeUpdatedUIEvent) fbEvent;
            GraphQLStory graphQLStory = (GraphQLStory) this.f22017a.f22033a.a;
            if (graphQLStory != null && graphQLStory.l() != null && likeUpdatedUIEvent.a != null && likeUpdatedUIEvent.a.equals(graphQLStory.l().j())) {
                this.f22017a.m24646a(FeedStoryMutator.b(graphQLStory, likeUpdatedUIEvent.b));
            }
        }
    }

    /* compiled from: TimelineHeaderTTI */
    class C18776 extends FlyoutOnResumeEventSubscriber {
        final /* synthetic */ FeedbackBasePlugin f22018a;

        C18776(FeedbackBasePlugin feedbackBasePlugin) {
            this.f22018a = feedbackBasePlugin;
        }

        public final void m24636b(FbEvent fbEvent) {
            this.f22018a.g.a(new RVPDialogEvent(true));
        }
    }

    /* compiled from: TimelineHeaderTTI */
    class C18787 extends ShareStoryPublishEventSubscriber {
        final /* synthetic */ FeedbackBasePlugin f22019a;

        C18787(FeedbackBasePlugin feedbackBasePlugin) {
            this.f22019a = feedbackBasePlugin;
        }

        public final void m24637b(FbEvent fbEvent) {
            this.f22019a.g.a(new RVPActivityDialogEvent());
        }
    }

    /* compiled from: TimelineHeaderTTI */
    class C18798 extends FlyoutOnDismissEventSubscriber {
        final /* synthetic */ FeedbackBasePlugin f22020a;

        C18798(FeedbackBasePlugin feedbackBasePlugin) {
            this.f22020a = feedbackBasePlugin;
        }

        public final void m24638b(FbEvent fbEvent) {
            if (this.f22020a.g != null) {
                this.f22020a.g.a(new RVPDialogEvent(false));
            }
            if (this.f22020a.f22026F && this.f22020a.g != null && this.f22020a.f22025E != null) {
                if (!this.f22020a.f22025E.aV) {
                    this.f22020a.g.a(new RVPRequestSeekingEvent(this.f22020a.f22025E.aL, EventTriggerType.BY_FLYOUT));
                }
                if (!this.f22020a.f22025E.aM) {
                    this.f22020a.g.a(new RVPRequestPausingEvent(EventTriggerType.BY_FLYOUT));
                }
                if (this.f22020a.f22025E.aT) {
                    FeedbackBasePlugin.getFullScreenVideoPlayer(this.f22020a).mo1526b();
                }
            }
        }
    }

    public static void m24640a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FeedbackBasePlugin) obj).m24639a(FeedEventBus.a(fbInjector), FlyoutEventBus.a(fbInjector), EventsStream.a(fbInjector), NumberTruncationUtil.a(fbInjector), IdBasedProvider.a(fbInjector, 3736), (FeedbackControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), WindowManagerMethodAutoProvider.b(fbInjector), IdBasedLazy.a(fbInjector, 11562));
    }

    protected abstract int getContentView();

    private void m24639a(FeedEventBus feedEventBus, FlyoutEventBus flyoutEventBus, EventsStream eventsStream, NumberTruncationUtil numberTruncationUtil, Provider<TouchSpring> provider, FeedbackControllerProvider feedbackControllerProvider, WindowManager windowManager, Lazy<VideoQEConfig> lazy) {
        this.f22035c = feedEventBus;
        this.f22036d = flyoutEventBus;
        this.f22037l = eventsStream;
        this.f22038m = numberTruncationUtil;
        this.f22039n = provider;
        this.f22040o = feedbackControllerProvider;
        this.f22041p = windowManager;
        this.f22042q = lazy;
    }

    public FeedbackBasePlugin(Context context) {
        this(context, null);
    }

    public FeedbackBasePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected FeedbackBasePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22026F = false;
        this.f22027G = new C18721(this);
        this.f22028H = new C18754(this);
        this.f22029I = new C18765(this);
        this.f22030J = new C18776(this);
        this.f22031K = new C18787(this);
        this.f22032L = new C18798(this);
        Class cls = FeedbackBasePlugin.class;
        m24640a((Object) this, getContext());
        setContentView(getContentView());
        this.f22043r = getResources().getString(2131233608);
        this.f22044s = getResources().getString(2131233607);
        this.f22045t = (FeedbackCustomPressStateButton) a(2131562066);
        this.f22047v = (FeedbackCustomPressStateButton) a(2131562068);
        this.f22046u = (FeedbackCustomPressStateButton) a(2131562067);
        this.f22045t.setSpring((TouchSpring) this.f22039n.get());
        this.f22046u.setSpring((TouchSpring) this.f22039n.get());
        this.f22047v.setSpring((TouchSpring) this.f22039n.get());
        this.f22048w = (View) b(2131562069).orNull();
        this.f22049x = (FbTextView) b(2131562071).orNull();
        this.f22050y = (FbTextView) b(2131562047).orNull();
        this.f22022B = (FullscreenVideoFeedbackActionButtonBar) a(2131559200);
        this.f22022B.f21694B = this.f22047v;
        this.f22051z = a(2131560944);
        this.f22021A = a(2131560945);
        this.f22045t.setOnClickListener(new C18732(this));
        this.f22047v.setOnClickListener(new C18743(this));
        this.f22046u.setOnClickListener(this.f22027G);
        if (this.f22048w != null) {
            this.f22048w.setOnClickListener(this.f22027G);
        }
    }

    protected void mo1540a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        this.f22024D = richVideoPlayerParams;
        if (z) {
            mo1542d();
        }
        if (richVideoPlayerParams.b != null && richVideoPlayerParams.b.containsKey("GraphQLStoryProps")) {
            Object obj;
            if (richVideoPlayerParams.b.containsKey("MultiShareGraphQLSubStoryPropsKey") && richVideoPlayerParams.b.containsKey("MultiShareGraphQLSubStoryIndexKey")) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                Object obj2 = richVideoPlayerParams.b.get("GraphQLStoryProps");
                Preconditions.checkArgument(obj2 instanceof FeedProps);
                Preconditions.checkArgument(((FeedProps) obj2).a instanceof GraphQLStory);
                this.f22033a = (FeedProps) obj2;
                if (((GraphQLStory) this.f22033a.a).l() != null) {
                    m24643e();
                    return;
                } else {
                    g();
                    return;
                }
            }
        }
        g();
    }

    protected void mo1541c() {
        m24644k();
    }

    private void m24643e() {
        m24646a((Feedbackable) this.f22033a.a);
        this.f22022B.m24305a(this.f22033a, StoryRenderContext.FULLSCREEN_VIDEO_PLAYER);
        m24644k();
        if (this.f22033a.a != null && ((GraphQLStory) this.f22033a.a).l() != null) {
            this.f22023C = this.f22037l.a(UpdateLikeFeedbackEvent.class, ((GraphQLStory) this.f22033a.a).l().z_(), this.f22028H);
            this.f22035c.a(this.f22029I);
            this.f22036d.a(this.f22030J);
            this.f22036d.a(this.f22032L);
            this.f22035c.a(this.f22031K);
        }
    }

    private void m24644k() {
        if (this.f22023C != null) {
            this.f22037l.a(this.f22023C);
            this.f22023C = null;
        }
        this.f22035c.b(this.f22029I);
        this.f22036d.b(this.f22030J);
        this.f22036d.b(this.f22032L);
        this.f22035c.b(this.f22031K);
    }

    protected void mo1542d() {
        this.f22045t.setVisibility(8);
        this.f22047v.setVisibility(8);
        this.f22046u.setVisibility(8);
        if (this.f22049x != null) {
            this.f22049x.setVisibility(8);
        }
        if (this.f22050y != null) {
            this.f22050y.setVisibility(8);
        }
    }

    protected final void m24646a(Feedbackable feedbackable) {
        int i;
        int i2 = 8;
        GraphQLStory graphQLStory = (GraphQLStory) this.f22033a.a;
        this.f22045t.setVisibility(graphQLStory.z() ? 0 : 8);
        this.f22045t.setDrawable(graphQLStory.B() ? 2130843899 : 2130843898);
        this.f22045t.setTextColor(getResources().getColor(graphQLStory.B() ? 2131362781 : 2131361864));
        this.f22045t.setContentDescription(graphQLStory.B() ? this.f22043r : this.f22044s);
        FeedbackCustomPressStateButton feedbackCustomPressStateButton = this.f22047v;
        if (StorySharingHelper.b(graphQLStory)) {
            i = 0;
        } else {
            i = 8;
        }
        feedbackCustomPressStateButton.setVisibility(i);
        FeedbackCustomPressStateButton feedbackCustomPressStateButton2 = this.f22046u;
        if (graphQLStory.A()) {
            i2 = 0;
        }
        feedbackCustomPressStateButton2.setVisibility(i2);
        CharSequence b = m24641b(feedbackable);
        if (this.f22049x != null && b != null) {
            this.f22049x.setText(b);
            this.f22049x.setVisibility(0);
        } else if (this.f22049x != null) {
            this.f22049x.setVisibility(4);
        }
        b = m24642c(feedbackable);
        if (this.f22050y != null && b != null) {
            this.f22050y.setText(b);
            this.f22050y.setVisibility(0);
        } else if (this.f22050y != null) {
            this.f22050y.setVisibility(4);
        }
    }

    private String m24641b(Feedbackable feedbackable) {
        int aa_ = feedbackable.aa_();
        if (aa_ <= 0) {
            return null;
        }
        return ResourceUtils.a(getResources(), 2131232777, 2131232778, aa_, new Object[]{this.f22038m.a(aa_, 1)});
    }

    private String m24642c(Feedbackable feedbackable) {
        int n = feedbackable.n();
        if (n <= 0) {
            return null;
        }
        return ResourceUtils.a(getResources(), 2131232779, 2131232780, n, new Object[]{this.f22038m.a(n, 1)});
    }

    public static boolean m24645l(FeedbackBasePlugin feedbackBasePlugin) {
        Display defaultDisplay = feedbackBasePlugin.f22041p.getDefaultDisplay();
        if (((Double) feedbackBasePlugin.f22024D.b.get("VideoAspectRatioKey")).doubleValue() > 0.5724999997764826d || defaultDisplay.getRotation() == 3 || defaultDisplay.getRotation() == 1) {
            Object obj = null;
        } else {
            int i = 1;
        }
        if (obj == null || !((VideoQEConfig) feedbackBasePlugin.f22042q.get()).a) {
            return false;
        }
        return true;
    }

    public static FeedFullScreenVideoPlayer getFullScreenVideoPlayer(FeedbackBasePlugin feedbackBasePlugin) {
        FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a(feedbackBasePlugin.getContext(), FullScreenVideoPlayerHost.class);
        Preconditions.checkNotNull(fullScreenVideoPlayerHost);
        return (FeedFullScreenVideoPlayer) fullScreenVideoPlayerHost.k();
    }
}
