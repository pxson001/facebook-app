package com.facebook.video.commercialbreak.plugins;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.commercialbreak.CommercialBreakInfoTracker;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerBuilder;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPCommercialBreakPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RVPRequestPlayingEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.PlaybackController;
import com.facebook.video.player.plugins.StubbableRichVideoPlayerPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.video.player.plugins.VideoPlugin.VideoPluginAlignment;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: location_subtitle */
public class CommercialBreakVideoPluginNew extends StubbableRichVideoPlayerPlugin {
    private static final String f9766m = CommercialBreakVideoPluginNew.class.getSimpleName();
    @Inject
    public FeedVideoPlayerParamBuilderProvider f9767b;
    @Inject
    public CommercialBreakConfig f9768c;
    @Inject
    public CommercialBreakInfoTracker f9769d;
    @Inject
    public VideoLoggingUtils f9770l;
    @Nullable
    public String f9771n;
    public View f9772o;
    public RichVideoPlayer f9773p;
    public ProgressBar f9774q;
    public FbTextView f9775r;
    @Nullable
    public CommercialBreakCountdownTimer f9776s;
    private CommercialBreakRVPPlayerStateChangedEventSubscriber f9777t;

    /* compiled from: location_subtitle */
    /* synthetic */ class C10301 {
        static final /* synthetic */ int[] f9759a = new int[State.values().length];

        static {
            try {
                f9759a[State.LIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9759a[State.TRANSITION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9759a[State.WAIT_FOR_ADS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9759a[State.STATIC_COUNTDOWN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9759a[State.VIDEO_AD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: location_subtitle */
    class CommercialBreakCountdownTimer extends CountDownTimer {
        final /* synthetic */ CommercialBreakVideoPluginNew f9760a;
        private final long f9761b;

        private CommercialBreakCountdownTimer(CommercialBreakVideoPluginNew commercialBreakVideoPluginNew, long j, long j2) {
            this.f9760a = commercialBreakVideoPluginNew;
            super(j2, 42);
            this.f9761b = j;
        }

        public void onTick(long j) {
            this.f9760a.f9774q.setProgress(Math.min(Math.max(0, (int) (this.f9761b - j)), (int) this.f9761b));
            CharSequence valueOf = String.valueOf(j / 1000);
            if (!this.f9760a.f9775r.getText().equals(valueOf)) {
                this.f9760a.f9775r.setText(valueOf);
            }
        }

        public void onFinish() {
        }
    }

    /* compiled from: location_subtitle */
    class CommercialBreakRVPPlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ CommercialBreakVideoPluginNew f9762a;

        public CommercialBreakRVPPlayerStateChangedEventSubscriber(CommercialBreakVideoPluginNew commercialBreakVideoPluginNew) {
            this.f9762a = commercialBreakVideoPluginNew;
        }

        public final void m11448b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            long j = -1;
            PlaybackController playbackController = this.f9762a.f9773p.u;
            if (playbackController != null) {
                j = (long) playbackController.f();
            }
            if (rVPPlayerStateChangedEvent.b == PlaybackController.State.PAUSED && this.f9762a.f9769d != null) {
                CommercialBreakInfoTracker.o(this.f9762a.f9769d, this.f9762a.f9771n).f9726k = j;
            }
            if (this.f9762a.g != null) {
                this.f9762a.g.a(new RVPCommercialBreakPlayerStateChangedEvent(rVPPlayerStateChangedEvent.b));
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m11447a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: location_subtitle */
    class CommercialBreakStateChangeEventSubscriber extends RichVideoPlayerEventSubscriber<RVPCommercialBreakStateChangeEvent> {
        final /* synthetic */ CommercialBreakVideoPluginNew f9763a;

        public CommercialBreakStateChangeEventSubscriber(CommercialBreakVideoPluginNew commercialBreakVideoPluginNew) {
            this.f9763a = commercialBreakVideoPluginNew;
        }

        public final void m11450b(FbEvent fbEvent) {
            RVPCommercialBreakStateChangeEvent rVPCommercialBreakStateChangeEvent = (RVPCommercialBreakStateChangeEvent) fbEvent;
            switch (C10301.f9759a[rVPCommercialBreakStateChangeEvent.a.ordinal()]) {
                case 1:
                    CommercialBreakVideoPluginNew commercialBreakVideoPluginNew = this.f9763a;
                    if (commercialBreakVideoPluginNew.d()) {
                        commercialBreakVideoPluginNew.f9772o.setVisibility(8);
                        if (commercialBreakVideoPluginNew.f9776s != null) {
                            commercialBreakVideoPluginNew.f9776s.cancel();
                            commercialBreakVideoPluginNew.f9776s = null;
                        }
                        if (commercialBreakVideoPluginNew.f9773p != null) {
                            commercialBreakVideoPluginNew.f9773p.g();
                        }
                    }
                    return;
                case 2:
                case 3:
                case 4:
                    if (this.f9763a.f9772o != null) {
                        this.f9763a.f9772o.setVisibility(8);
                        return;
                    }
                    return;
                case 5:
                    this.f9763a.m11456a(rVPCommercialBreakStateChangeEvent.c.d, rVPCommercialBreakStateChangeEvent.c.e, this.f9763a.f9769d.j(this.f9763a.f9771n), rVPCommercialBreakStateChangeEvent.c.a);
                    return;
                default:
                    return;
            }
        }

        public final Class<RVPCommercialBreakStateChangeEvent> m11449a() {
            return RVPCommercialBreakStateChangeEvent.class;
        }
    }

    /* compiled from: location_subtitle */
    class RequestPausingEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestPausingEvent> {
        final /* synthetic */ CommercialBreakVideoPluginNew f9764a;

        public RequestPausingEventSubscriber(CommercialBreakVideoPluginNew commercialBreakVideoPluginNew) {
            this.f9764a = commercialBreakVideoPluginNew;
        }

        public final void m11452b(FbEvent fbEvent) {
            RVPRequestPausingEvent rVPRequestPausingEvent = (RVPRequestPausingEvent) fbEvent;
            if (this.f9764a.f9769d.e(this.f9764a.f9771n) == State.VIDEO_AD && this.f9764a.f9773p != null && rVPRequestPausingEvent.a == EventTriggerType.BY_AUTOPLAY) {
                this.f9764a.f9773p.b(EventTriggerType.BY_AUTOPLAY);
                if (this.f9764a.f9776s != null) {
                    this.f9764a.f9776s.cancel();
                }
            }
        }

        public final Class<RVPRequestPausingEvent> m11451a() {
            return RVPRequestPausingEvent.class;
        }
    }

    /* compiled from: location_subtitle */
    class RequestPlayingEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestPlayingEvent> {
        final /* synthetic */ CommercialBreakVideoPluginNew f9765a;

        public RequestPlayingEventSubscriber(CommercialBreakVideoPluginNew commercialBreakVideoPluginNew) {
            this.f9765a = commercialBreakVideoPluginNew;
        }

        public final void m11454b(FbEvent fbEvent) {
            RVPRequestPlayingEvent rVPRequestPlayingEvent = (RVPRequestPlayingEvent) fbEvent;
            if (this.f9765a.f9769d.e(this.f9765a.f9771n) == State.VIDEO_AD && this.f9765a.f9773p != null && rVPRequestPlayingEvent.a == EventTriggerType.BY_AUTOPLAY) {
                this.f9765a.f9773p.a(EventTriggerType.BY_AUTOPLAY);
                if (this.f9765a.f9776s != null) {
                    this.f9765a.f9776s.cancel();
                }
                this.f9765a.f9776s = new CommercialBreakCountdownTimer(this.f9765a.f9769d.j(this.f9765a.f9771n), this.f9765a.f9769d.j(this.f9765a.f9771n) - this.f9765a.f9769d.l(this.f9765a.f9771n));
                this.f9765a.f9776s.start();
            }
        }

        public final Class<RVPRequestPlayingEvent> m11453a() {
            return RVPRequestPlayingEvent.class;
        }
    }

    public static void m11458a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CommercialBreakVideoPluginNew commercialBreakVideoPluginNew = (CommercialBreakVideoPluginNew) obj;
        FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider = (FeedVideoPlayerParamBuilderProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class);
        CommercialBreakConfig a = CommercialBreakConfig.a(fbInjector);
        CommercialBreakInfoTracker a2 = CommercialBreakInfoTracker.a(fbInjector);
        VideoLoggingUtils a3 = VideoLoggingUtils.a(fbInjector);
        commercialBreakVideoPluginNew.f9767b = feedVideoPlayerParamBuilderProvider;
        commercialBreakVideoPluginNew.f9768c = a;
        commercialBreakVideoPluginNew.f9769d = a2;
        commercialBreakVideoPluginNew.f9770l = a3;
    }

    @DoNotStrip
    public CommercialBreakVideoPluginNew(Context context) {
        this(context, null);
    }

    private CommercialBreakVideoPluginNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CommercialBreakVideoPluginNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommercialBreakVideoPluginNew.class;
        m11458a((Object) this, getContext());
        this.f.add(new CommercialBreakStateChangeEventSubscriber(this));
        this.f.add(new RequestPlayingEventSubscriber(this));
        this.f.add(new RequestPausingEventSubscriber(this));
    }

    protected final void m11459a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        Integer.valueOf(System.identityHashCode(this));
        if (z && richVideoPlayerParams.a.h && this.f9768c.a) {
            this.f9771n = richVideoPlayerParams.a.b;
            if (this.f9769d.e(this.f9771n) == State.VIDEO_AD && d()) {
                PlayerType playerType;
                if (this.i.u != null) {
                    playerType = this.i.u.q;
                } else {
                    playerType = PlayerType.OTHERS;
                }
                m11456a(this.f9769d.b(this.f9771n), playerType, this.f9769d.j(this.f9771n), this.f9769d.j(this.f9771n) - this.f9769d.l(this.f9771n));
            }
        }
    }

    protected final void m11461c() {
        Integer.valueOf(System.identityHashCode(this));
        if (this.f9772o != null) {
            this.f9772o.setVisibility(8);
        }
        if (this.f9776s != null) {
            this.f9776s.cancel();
            this.f9776s = null;
        }
        if (this.f9773p != null) {
            this.f9773p.g();
        }
    }

    protected final boolean m11460a(RichVideoPlayerParams richVideoPlayerParams) {
        return true;
    }

    protected int getStubLayout() {
        return 2130903649;
    }

    protected int getLayoutToInflate() {
        return 2130903648;
    }

    protected void setupPlugin(RichVideoPlayerParams richVideoPlayerParams) {
    }

    protected void setupViews(View view) {
        PlayerOrigin playerOrigin;
        this.f9772o = view.findViewById(2131559223);
        this.f9773p = (RichVideoPlayer) view.findViewById(2131560483);
        if (this.i != null) {
            playerOrigin = this.i.x;
        } else {
            playerOrigin = PlayerOrigin.UNKNOWN;
        }
        RichVideoPlayerBuilder richVideoPlayerBuilder = new RichVideoPlayerBuilder();
        richVideoPlayerBuilder.a = playerOrigin;
        RichVideoPlayerBuilder richVideoPlayerBuilder2 = richVideoPlayerBuilder;
        Builder builder = new Builder();
        builder.c(new VideoPlugin(getContext()));
        builder.c(new LoadingSpinnerPlugin(getContext()));
        this.f9773p = richVideoPlayerBuilder2.a(builder.b()).a(this.f9773p);
        this.f9777t = new CommercialBreakRVPPlayerStateChangedEventSubscriber(this);
        this.f9773p.a(this.f9777t);
        this.f9774q = (ProgressBar) view.findViewById(2131559418);
        this.f9775r = (FbTextView) view.findViewById(2131560482);
    }

    private void m11456a(FeedProps<GraphQLStory> feedProps, PlayerType playerType, long j, long j2) {
        if (d()) {
            this.f9772o.setVisibility(0);
            if (playerType == PlayerType.INLINE_PLAYER) {
                this.f9772o.bringToFront();
            }
            if (!(this.f9773p == null || feedProps == null)) {
                m11455a((FeedProps) feedProps, playerType);
            }
            if (this.f9776s != null) {
                this.f9776s.cancel();
            }
            this.f9776s = new CommercialBreakCountdownTimer(j, j2);
            this.f9776s.start();
            this.f9774q.setMax((int) this.f9769d.j(this.f9771n));
        }
    }

    private void m11455a(FeedProps<GraphQLStory> feedProps, PlayerType playerType) {
        FeedProps i = StoryProps.i(feedProps);
        if (i != null) {
            VideoPlayerParams a = this.f9767b.a(i, GraphQLMediaConversionHelper.b(((GraphQLStoryAttachment) i.a).r())).a();
            RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
            builder.a = a;
            this.f9773p.a(builder.b());
            if (playerType == PlayerType.INLINE_PLAYER || playerType != PlayerType.FULL_SCREEN_PLAYER) {
                this.f9773p.a(true, EventTriggerType.BY_AUTOPLAY);
            } else {
                PlayerOrigin playerOrigin;
                this.f9773p.a(false, EventTriggerType.BY_AUTOPLAY);
                if (this.i != null) {
                    playerOrigin = this.i.x;
                } else {
                    playerOrigin = PlayerOrigin.UNKNOWN;
                }
                this.f9770l.b(a.e, playerType.value, EventTriggerType.BY_AUTOPLAY.value, 0, a.b, playerOrigin, a.f, a);
            }
            this.f9773p.setVideoPluginAlignment(VideoPluginAlignment.CENTER);
            this.f9773p.a(EventTriggerType.BY_AUTOPLAY);
        }
    }
}
