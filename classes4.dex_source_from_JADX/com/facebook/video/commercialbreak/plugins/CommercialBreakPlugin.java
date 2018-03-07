package com.facebook.video.commercialbreak.plugins;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.facecastdisplay.LiveEventsPlugin;
import com.facebook.feed.logging.impression.FeedUnitSponsoredImpressionLogger;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.qe.api.Liveness;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ui.futures.TasksManager;
import com.facebook.video.analytics.VideoAnalytics.CommercialBreakAnalyticsAttributes;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamingFormat;
import com.facebook.video.analytics.VideoLoggingPropertyBag;
import com.facebook.video.commercialbreak.CommercialBreakInfoTracker;
import com.facebook.video.commercialbreak.CommercialBreakInfoTracker.CommercialBreakInfo;
import com.facebook.video.commercialbreak.CommercialBreakVideoAdFetcher;
import com.facebook.video.commercialbreak.abtest.CommercialBreakConfig;
import com.facebook.video.commercialbreak.abtest.ExperimentsForCommercialBreakAbTestModule;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.CommercialBreakStateChangeEventExtraData;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPStreamDriedOutEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.LiveVideoControlsPlugin;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.lang.ref.WeakReference;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: playable_src */
public class CommercialBreakPlugin extends RichVideoPlayerPlugin {
    public static final String f4465q = CommercialBreakPlugin.class.getSimpleName();
    private static final ImmutableList<Class<? extends RichVideoPlayerPlugin>> f4466r = ImmutableList.of(VideoPlugin.class, LiveVideoControlsPlugin.class);
    private static final ImmutableList<Class<? extends RichVideoPlayerPlugin>> f4467s = ImmutableList.of(LiveEventsPlugin.class);
    @Nullable
    public CommercialBreakVideoAdImpression f4468A;
    @Nullable
    private CommercialBreakCountdownTimer f4469B;
    @Nullable
    private String f4470C;
    @Nullable
    private FeedProps<GraphQLStory> f4471D;
    @Inject
    FeedVideoPlayerParamBuilderProvider f4472a;
    @Inject
    public CommercialBreakInfoTracker f4473b;
    @Inject
    public CommercialBreakConfig f4474c;
    @Inject
    VideoLoggingPropertyBag f4475d;
    @Inject
    FeedUnitSponsoredImpressionLogger f4476l;
    @Inject
    FeedbackLoader f4477m;
    @Inject
    TasksManager f4478n;
    @Inject
    FeedStoryMutator f4479o;
    @Inject
    AbstractFbErrorReporter f4480p;
    public final CommercialBreakHandler f4481t;
    private final CommercialBreakInfoChangedListener f4482u;
    @Nullable
    private FeedProps<GraphQLStory> f4483v;
    @Nullable
    private RichVideoPlayerParams f4484w;
    @Nullable
    public String f4485x;
    @Nullable
    private RichVideoPlayerParams f4486y;
    @Nullable
    public String f4487z;

    /* compiled from: playable_src */
    public class CommercialBreakInfoChangedListener {
        public final /* synthetic */ CommercialBreakPlugin f4513a;

        public CommercialBreakInfoChangedListener(CommercialBreakPlugin commercialBreakPlugin) {
            this.f4513a = commercialBreakPlugin;
        }
    }

    /* compiled from: playable_src */
    class CommercialBreakHandler extends Handler {
        private final WeakReference<CommercialBreakPlugin> f4612a;

        public CommercialBreakHandler(CommercialBreakPlugin commercialBreakPlugin) {
            this.f4612a = new WeakReference(commercialBreakPlugin);
        }

        public void handleMessage(Message message) {
            CommercialBreakPlugin commercialBreakPlugin = (CommercialBreakPlugin) this.f4612a.get();
            if (commercialBreakPlugin != null) {
                switch (message.what) {
                    case 1:
                        Preconditions.checkNotNull(commercialBreakPlugin.f14096h);
                        commercialBreakPlugin.f4473b.m5030a(commercialBreakPlugin.f4485x, true);
                        if (Math.abs(commercialBreakPlugin.f4473b.m5032d(commercialBreakPlugin.f4485x) - ((long) commercialBreakPlugin.f14096h.m5478g())) < ((long) commercialBreakPlugin.f4474c.f4317b)) {
                            commercialBreakPlugin.f4481t.sendEmptyMessage(2);
                        } else {
                            commercialBreakPlugin.f4481t.sendEmptyMessageDelayed(1, 100);
                        }
                        return;
                    case 2:
                        CommercialBreakPlugin.m4974a(commercialBreakPlugin, message.obj == null ? commercialBreakPlugin.f4474c.f4319d : ((Long) message.obj).longValue());
                        return;
                    case 3:
                        CommercialBreakPlugin.m4982k(commercialBreakPlugin);
                        return;
                    case 4:
                        CommercialBreakPlugin.m4983l(commercialBreakPlugin);
                        return;
                    case 5:
                        CommercialBreakPlugin.m4984m(commercialBreakPlugin);
                        return;
                    case 6:
                        CommercialBreakPlugin.m4985n(commercialBreakPlugin);
                        return;
                    case 7:
                        CommercialBreakPlugin.m4986o(commercialBreakPlugin);
                        return;
                    case 8:
                        CommercialBreakPlugin.m4987p(commercialBreakPlugin);
                        return;
                    case 9:
                        CommercialBreakPlugin.m4988q(commercialBreakPlugin);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: playable_src */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ CommercialBreakPlugin f4613a;

        public PlayerStateChangedEventSubscriber(CommercialBreakPlugin commercialBreakPlugin) {
            this.f4613a = commercialBreakPlugin;
        }

        public final void m5097b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            int i = 1;
            if (this.f4613a.f4487z != null && this.f4613a.f4487z.equals(rVPPlayerStateChangedEvent.f14078a) && !this.f4613a.f4474c.f4324i) {
                switch (2.c[rVPPlayerStateChangedEvent.f14079b.ordinal()]) {
                    case 1:
                        if (this.f4613a.f4468A != null) {
                            this.f4613a.f4476l.m4675a(this.f4613a.f4468A);
                        }
                        this.f4613a.f4468A = null;
                        return;
                    case 2:
                        String str = CommercialBreakPlugin.f4465q;
                        this.f4613a.f4481t.sendEmptyMessage(4);
                        return;
                    default:
                        return;
                }
            } else if (this.f4613a.f4485x != null && this.f4613a.f4485x.equals(rVPPlayerStateChangedEvent.f14078a) && rVPPlayerStateChangedEvent.f14079b == State.ATTEMPT_TO_PLAY && this.f4613a.f4481t.hasMessages(1)) {
                if (this.f4613a.f14096h.m5487r() == null || !this.f4613a.f14096h.m5487r().toUpperCase(Locale.ENGLISH).equals(StreamingFormat.HLS.value)) {
                    i = 0;
                }
                if (i != 0) {
                    this.f4613a.f4481t.removeCallbacksAndMessages(null);
                    this.f4613a.f4481t.sendEmptyMessage(2);
                }
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m5096a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: playable_src */
    class StreamDriedOutEventSubscriber extends RichVideoPlayerEventSubscriber<RVPStreamDriedOutEvent> {
        final /* synthetic */ CommercialBreakPlugin f4614a;

        public StreamDriedOutEventSubscriber(CommercialBreakPlugin commercialBreakPlugin) {
            this.f4614a = commercialBreakPlugin;
        }

        public final void m5099b(FbEvent fbEvent) {
            if (this.f4614a.f4481t.hasMessages(1) && Math.abs(this.f4614a.f4473b.m5032d(this.f4614a.f4485x) - ((long) this.f4614a.f14096h.m5478g())) < this.f4614a.f4474c.f4323h) {
                this.f4614a.f4481t.removeCallbacksAndMessages(null);
                this.f4614a.f4481t.sendEmptyMessage(2);
            }
        }

        public final Class<RVPStreamDriedOutEvent> m5098a() {
            return RVPStreamDriedOutEvent.class;
        }
    }

    public static void m4978a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CommercialBreakPlugin) obj).m4975a((FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), CommercialBreakInfoTracker.m5025a(injectorLike), CommercialBreakConfig.m4866a(injectorLike), VideoLoggingPropertyBag.a(injectorLike), FeedUnitSponsoredImpressionLogger.m4665a(injectorLike), FeedbackLoader.m5046a(injectorLike), TasksManager.b(injectorLike), FeedStoryMutator.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @DoNotStrip
    public CommercialBreakPlugin(Context context) {
        this(context, null);
    }

    private CommercialBreakPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CommercialBreakPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4482u = new CommercialBreakInfoChangedListener(this);
        Class cls = CommercialBreakPlugin.class;
        m4978a((Object) this, getContext());
        this.f4481t = new CommercialBreakHandler(this);
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
        this.f14094f.add(new StreamDriedOutEventSubscriber(this));
        if (this.f4474c.f4324i) {
            this.f14094f.add(new CommercialBreakPlayerStateChangedEventSubscriber(this));
        }
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        Integer.valueOf(System.identityHashCode(this));
        Boolean.valueOf(z);
        if (z && richVideoPlayerParams.f4962a.f4839h && richVideoPlayerParams.f4963b != null && richVideoPlayerParams.f4963b.containsKey("GraphQLStoryProps")) {
            GraphQLStory graphQLStory;
            Object obj = richVideoPlayerParams.f4963b.get("GraphQLStoryProps");
            if (obj instanceof FeedProps) {
                this.f4483v = (FeedProps) obj;
            }
            if (this.f4483v != null) {
                graphQLStory = (GraphQLStory) this.f4483v.a;
            } else {
                graphQLStory = null;
            }
            if (graphQLStory != null && StoryAttachmentHelper.o(graphQLStory) != null && StoryAttachmentHelper.o(graphQLStory).r() != null) {
                GraphQLVideo b = GraphQLMediaConversionHelper.b(((GraphQLStoryAttachment) StoryProps.i(this.f4483v).a).r());
                if (b != null && b.bK()) {
                    this.f4474c.f4325j.a(Liveness.Live, ExperimentsForCommercialBreakAbTestModule.f4329c);
                    if (this.f4474c.f4316a) {
                        this.f4484w = richVideoPlayerParams;
                        this.f4485x = richVideoPlayerParams.f4962a.f4833b;
                        CommercialBreakInfoTracker commercialBreakInfoTracker = this.f4473b;
                        String str = this.f4485x;
                        CommercialBreakInfoChangedListener commercialBreakInfoChangedListener = this.f4482u;
                        commercialBreakInfoTracker.f4517c.m5037a(str, commercialBreakInfoTracker.f4525k);
                        commercialBreakInfoTracker.f4524j.put(str, commercialBreakInfoChangedListener);
                        m4981e();
                    }
                }
            }
        }
    }

    protected final void mo378c() {
        Integer.valueOf(System.identityHashCode(this));
        this.f4481t.removeCallbacksAndMessages(null);
        this.f4483v = null;
        CommercialBreakInfoTracker commercialBreakInfoTracker = this.f4473b;
        commercialBreakInfoTracker.f4524j.remove(this.f4485x);
        this.f4485x = null;
        this.f4486y = null;
        this.f4487z = null;
        if (this.f4469B != null) {
            this.f4469B.cancel();
        }
        if (this.f4470C != null) {
            this.f4478n.c(this.f4470C);
        }
        this.f4470C = null;
        this.f4471D = null;
    }

    private void m4981e() {
        RVPCommercialBreakStateChangeEvent.State state;
        RVPCommercialBreakStateChangeEvent.State e = this.f4473b.m5033e(this.f4485x);
        CommercialBreakInfoTracker commercialBreakInfoTracker = this.f4473b;
        CommercialBreakInfo commercialBreakInfo = (CommercialBreakInfo) commercialBreakInfoTracker.f4523i.get(this.f4485x);
        if (commercialBreakInfo == null) {
            state = RVPCommercialBreakStateChangeEvent.State.LIVE;
        } else {
            state = commercialBreakInfo.e;
        }
        RVPCommercialBreakStateChangeEvent.State state2 = state;
        if (e == RVPCommercialBreakStateChangeEvent.State.LIVE) {
            boolean z;
            CommercialBreakInfoTracker commercialBreakInfoTracker2 = this.f4473b;
            commercialBreakInfo = (CommercialBreakInfo) commercialBreakInfoTracker2.f4523i.get(this.f4485x);
            if (commercialBreakInfo == null) {
                z = false;
            } else {
                z = commercialBreakInfo.j;
            }
            if (z) {
                this.f4481t.sendEmptyMessage(1);
                return;
            }
            return;
        }
        m4980c(this.f4473b.m5034h(this.f4485x));
        CommercialBreakStateChangeEventExtraData commercialBreakStateChangeEventExtraData = new CommercialBreakStateChangeEventExtraData();
        switch (2.a[e.ordinal()]) {
            case 1:
                commercialBreakStateChangeEventExtraData.a = this.f4473b.m5034h(this.f4485x) - this.f4474c.f4320e;
                m4977a(e, commercialBreakStateChangeEventExtraData);
                this.f4481t.sendEmptyMessageDelayed(7, commercialBreakStateChangeEventExtraData.a);
                return;
            case 2:
                if (this.f4474c.f4324i) {
                    if (this.f4486y == null) {
                        this.f4486y = m4991t();
                    }
                    this.f14097i.m14822a(this.f4486y, f4467s, false);
                    this.f14097i.m14832b(EventTriggerType.BY_COMMERCIAL_BREAK);
                    commercialBreakStateChangeEventExtraData.a = this.f4473b.m5035j(this.f4485x) - this.f4473b.m5036l(this.f4485x);
                    commercialBreakStateChangeEventExtraData.d = this.f4473b.m5031b(this.f4485x);
                    commercialBreakStateChangeEventExtraData.e = this.f14096h.f5120q;
                } else {
                    commercialBreakStateChangeEventExtraData.a = this.f4473b.m5035j(this.f4485x) - ((long) this.f14096h.m5477f());
                }
                m4977a(e, commercialBreakStateChangeEventExtraData);
                return;
            case 3:
                if (state2 == RVPCommercialBreakStateChangeEvent.State.LIVE) {
                    this.f4481t.sendMessageAtFrontOfQueue(this.f4481t.obtainMessage(2, Long.valueOf(Math.max(0, this.f4474c.f4319d - (getCommercialBreakLengthMs() - this.f4473b.m5034h(this.f4485x))))));
                    return;
                }
                m4976a(e);
                this.f4481t.sendEmptyMessageDelayed(9, this.f4473b.m5034h(this.f4485x));
                return;
            default:
                commercialBreakStateChangeEventExtraData.a = this.f4473b.m5034h(this.f4485x);
                m4977a(e, commercialBreakStateChangeEventExtraData);
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m4974a(com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin r8, long r9) {
        /*
        r0 = new com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent$CommercialBreakStateChangeEventExtraData;
        r0.<init>();
        r1 = r8.f4473b;
        r2 = r8.f4485x;
        r7 = r1.f4523i;
        r7 = r7.get(r2);
        r7 = (com.facebook.video.commercialbreak.CommercialBreakInfoTracker.CommercialBreakInfo) r7;
        if (r7 != 0) goto L_0x0081;
    L_0x0013:
        r7 = com.facebook.video.commercialbreak.CommercialBreakVideoAdFetcher.State.IDLE;
    L_0x0015:
        r1 = r7;
        r2 = com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin.2.b;
        r1 = r1.ordinal();
        r1 = r2[r1];
        switch(r1) {
            case 1: goto L_0x0039;
            case 2: goto L_0x003d;
            case 3: goto L_0x0073;
            default: goto L_0x0021;
        };
    L_0x0021:
        m4979b(r8, r9);
    L_0x0024:
        r1 = r8.f4473b;
        r2 = r8.f4485x;
        r3 = 0;
        r1.m5030a(r2, r3);
        r2 = r8.getCommercialBreakLengthMs();
        r8.m4980c(r2);
        r1 = com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State.TRANSITION;
        r8.m4977a(r1, r0);
        return;
    L_0x0039:
        m4979b(r8, r9);
        goto L_0x0024;
    L_0x003d:
        r1 = r8.f4473b;
        r2 = r8.f4485x;
        r1 = r1.m5031b(r2);
        if (r1 == 0) goto L_0x0021;
    L_0x0047:
        m4989r(r8);
        r1 = r8.f4486y;
        r1 = r1.f4962a;
        r1 = r1.f4834c;
        r2 = (long) r1;
        r4 = r8.getCommercialBreakLengthMs();
        r2 = r4 - r2;
        r1 = r8.f4474c;
        r4 = r1.f4319d;
        r2 = r2 - r4;
        r1 = r8.f4474c;
        r4 = r1.f4320e;
        r2 = r2 - r4;
        r4 = 2;
        r2 = r2 / r4;
        r1 = 1;
        r0.b = r1;
        r4 = r9 + r2;
        r0.c = r4;
        r1 = r8.f4481t;
        r4 = 3;
        r2 = r2 + r9;
        r1.sendEmptyMessageDelayed(r4, r2);
        goto L_0x0024;
    L_0x0073:
        r1 = r8.f14096h;
        r2 = com.facebook.video.analytics.VideoAnalytics.EventTriggerType.BY_COMMERCIAL_BREAK;
        r1.m5463a(r2);
        r1 = r8.f4481t;
        r2 = 5;
        r1.sendEmptyMessageDelayed(r2, r9);
        goto L_0x0024;
    L_0x0081:
        r7 = r7.f;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin.a(com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin, long):void");
    }

    public static void m4982k(CommercialBreakPlugin commercialBreakPlugin) {
        commercialBreakPlugin.f14097i.m14822a(commercialBreakPlugin.f4486y, f4467s, false);
        long j = (long) commercialBreakPlugin.f4486y.f4962a.f4834c;
        CommercialBreakStateChangeEventExtraData commercialBreakStateChangeEventExtraData = new CommercialBreakStateChangeEventExtraData();
        commercialBreakStateChangeEventExtraData.a = j;
        if (commercialBreakPlugin.f4474c.f4324i) {
            commercialBreakStateChangeEventExtraData.d = commercialBreakPlugin.f4473b.m5031b(commercialBreakPlugin.f4485x);
            commercialBreakStateChangeEventExtraData.e = commercialBreakPlugin.f14096h.f5120q;
        }
        CommercialBreakInfoTracker.m5028o(commercialBreakPlugin.f4473b, commercialBreakPlugin.f4485x).i = j;
        if (commercialBreakPlugin.f4474c.f4324i) {
            commercialBreakPlugin.f14097i.m14832b(EventTriggerType.BY_COMMERCIAL_BREAK);
        } else {
            commercialBreakPlugin.f14097i.m14818a(EventTriggerType.BY_AUTOPLAY);
        }
        commercialBreakPlugin.m4977a(RVPCommercialBreakStateChangeEvent.State.VIDEO_AD, commercialBreakStateChangeEventExtraData);
    }

    public static void m4983l(CommercialBreakPlugin commercialBreakPlugin) {
        commercialBreakPlugin.m4990s();
        commercialBreakPlugin.m4976a(RVPCommercialBreakStateChangeEvent.State.TRANSITION);
        commercialBreakPlugin.f4481t.sendEmptyMessageDelayed(9, commercialBreakPlugin.f4473b.m5034h(commercialBreakPlugin.f4485x));
    }

    public static void m4984m(CommercialBreakPlugin commercialBreakPlugin) {
        commercialBreakPlugin.m4976a(RVPCommercialBreakStateChangeEvent.State.WAIT_FOR_ADS);
        commercialBreakPlugin.f4481t.sendEmptyMessageDelayed(6, commercialBreakPlugin.f4474c.f4322g);
    }

    public static void m4985n(CommercialBreakPlugin commercialBreakPlugin) {
        long h = commercialBreakPlugin.f4473b.m5034h(commercialBreakPlugin.f4485x) - commercialBreakPlugin.f4474c.f4320e;
        CommercialBreakStateChangeEventExtraData commercialBreakStateChangeEventExtraData = new CommercialBreakStateChangeEventExtraData();
        commercialBreakStateChangeEventExtraData.a = h;
        commercialBreakPlugin.m4977a(RVPCommercialBreakStateChangeEvent.State.STATIC_COUNTDOWN, commercialBreakStateChangeEventExtraData);
        commercialBreakPlugin.f4481t.sendEmptyMessageDelayed(7, h);
    }

    public static void m4986o(CommercialBreakPlugin commercialBreakPlugin) {
        commercialBreakPlugin.m4976a(RVPCommercialBreakStateChangeEvent.State.TRANSITION);
        commercialBreakPlugin.f4481t.sendEmptyMessageDelayed(9, commercialBreakPlugin.f4474c.f4320e);
    }

    public static void m4987p(CommercialBreakPlugin commercialBreakPlugin) {
        switch (2.a[commercialBreakPlugin.f4473b.m5033e(commercialBreakPlugin.f4485x).ordinal()]) {
            case 1:
            case 3:
                commercialBreakPlugin.f4481t.sendEmptyMessage(9);
                return;
            case 2:
                boolean z;
                CommercialBreakInfoTracker commercialBreakInfoTracker = commercialBreakPlugin.f4473b;
                CommercialBreakInfo commercialBreakInfo = (CommercialBreakInfo) commercialBreakInfoTracker.f4523i.get(commercialBreakPlugin.f4485x);
                if (commercialBreakInfo == null) {
                    z = false;
                } else {
                    z = commercialBreakInfo.h;
                }
                if (z) {
                    commercialBreakPlugin.f4481t.sendEmptyMessage(9);
                    return;
                }
                commercialBreakPlugin.f4481t.sendEmptyMessageDelayed(8, commercialBreakPlugin.f4474c.f4321f);
                CommercialBreakInfoTracker.m5028o(commercialBreakPlugin.f4473b, commercialBreakPlugin.f4485x).h = true;
                return;
            default:
                return;
        }
    }

    public static void m4988q(CommercialBreakPlugin commercialBreakPlugin) {
        commercialBreakPlugin.f4481t.removeCallbacksAndMessages(null);
        if (commercialBreakPlugin.f4473b.m5033e(commercialBreakPlugin.f4485x) == RVPCommercialBreakStateChangeEvent.State.VIDEO_AD) {
            commercialBreakPlugin.m4990s();
        }
        CommercialBreakInfoTracker commercialBreakInfoTracker = commercialBreakPlugin.f4473b;
        commercialBreakInfoTracker.f4523i.remove(commercialBreakPlugin.f4485x);
        if (commercialBreakPlugin.f4469B != null) {
            commercialBreakPlugin.f4469B.cancel();
        }
        commercialBreakPlugin.m4976a(RVPCommercialBreakStateChangeEvent.State.LIVE);
        commercialBreakPlugin.f14097i.m14818a(EventTriggerType.BY_COMMERCIAL_BREAK);
        CommercialBreakInfoTracker.m5028o(commercialBreakPlugin.f4473b, commercialBreakPlugin.f4485x).f = CommercialBreakVideoAdFetcher.State.IDLE;
    }

    public static void m4989r(CommercialBreakPlugin commercialBreakPlugin) {
        CommercialBreakVideoAdImpression commercialBreakVideoAdImpression;
        commercialBreakPlugin.f4486y = commercialBreakPlugin.m4991t();
        commercialBreakPlugin.f4475d.a(commercialBreakPlugin.f4487z, CommercialBreakAnalyticsAttributes.HOST_VIDEO_ID.value, commercialBreakPlugin.f4485x);
        FeedProps b = commercialBreakPlugin.f4473b.m5031b(commercialBreakPlugin.f4485x);
        if (b == null) {
            commercialBreakVideoAdImpression = null;
        } else {
            commercialBreakVideoAdImpression = new CommercialBreakVideoAdImpression(b);
        }
        commercialBreakPlugin.f4468A = commercialBreakVideoAdImpression;
        if (!commercialBreakPlugin.f4474c.f4324i) {
            commercialBreakPlugin.f14097i.m14822a(commercialBreakPlugin.f4486y, f4466r, true);
            commercialBreakPlugin.f14096h.m5467a(commercialBreakPlugin.f4486y.f4962a);
        }
    }

    private void m4990s() {
        this.f14097i.m14822a(this.f4484w, f4467s, false);
        if (!this.f4474c.f4324i) {
            this.f14097i.m14822a(this.f4484w, f4466r, true);
            this.f14096h.m5467a(this.f4484w.f4962a);
        }
    }

    public static void m4979b(CommercialBreakPlugin commercialBreakPlugin, long j) {
        commercialBreakPlugin.f14096h.m5463a(EventTriggerType.BY_COMMERCIAL_BREAK);
        commercialBreakPlugin.f4481t.sendEmptyMessageDelayed(6, j);
    }

    private long getCommercialBreakLengthMs() {
        long j;
        CommercialBreakInfoTracker commercialBreakInfoTracker = this.f4473b;
        CommercialBreakInfo commercialBreakInfo = (CommercialBreakInfo) commercialBreakInfoTracker.f4523i.get(this.f4485x);
        if (commercialBreakInfo == null) {
            j = -1;
        } else {
            j = commercialBreakInfo.b;
        }
        long j2 = j;
        if (j2 <= 0) {
            return 15000;
        }
        return j2;
    }

    @Nullable
    private RichVideoPlayerParams m4991t() {
        FeedProps b = this.f4473b.m5031b(this.f4485x);
        if (b == null) {
            return null;
        }
        FeedProps i = StoryProps.i(b);
        VideoPlayerParams a = this.f4472a.a(i, GraphQLMediaConversionHelper.b(((GraphQLStoryAttachment) i.a).r())).m5248a();
        this.f4487z = a.f4833b;
        ImmutableMap b2 = new Builder().b("GraphQLStoryProps", this.f4483v).b("InterstitialGraphQLStoryPropsKey", b).b();
        RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
        builder.f4958a = a;
        return builder.m5352a(b2).m5355b();
    }

    private void m4976a(RVPCommercialBreakStateChangeEvent.State state) {
        m4977a(state, new CommercialBreakStateChangeEventExtraData());
    }

    private void m4977a(RVPCommercialBreakStateChangeEvent.State state, CommercialBreakStateChangeEventExtraData commercialBreakStateChangeEventExtraData) {
        this.f14095g.m14878a(new RVPCommercialBreakStateChangeEvent(state, this.f4473b.m5033e(this.f4485x), commercialBreakStateChangeEventExtraData));
        CommercialBreakInfo o = CommercialBreakInfoTracker.m5028o(this.f4473b, this.f4485x);
        o.e = o.d;
        o.d = state;
    }

    private void m4980c(long j) {
        if (this.f4469B != null) {
            this.f4469B.cancel();
        }
        Long.valueOf(j);
        this.f4469B = new CommercialBreakCountdownTimer(this, j);
        this.f4469B.start();
    }

    private void m4975a(FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, CommercialBreakInfoTracker commercialBreakInfoTracker, CommercialBreakConfig commercialBreakConfig, VideoLoggingPropertyBag videoLoggingPropertyBag, FeedUnitSponsoredImpressionLogger feedUnitSponsoredImpressionLogger, FeedbackLoader feedbackLoader, TasksManager tasksManager, FeedStoryMutator feedStoryMutator, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f4472a = feedVideoPlayerParamBuilderProvider;
        this.f4473b = commercialBreakInfoTracker;
        this.f4474c = commercialBreakConfig;
        this.f4475d = videoLoggingPropertyBag;
        this.f4476l = feedUnitSponsoredImpressionLogger;
        this.f4477m = feedbackLoader;
        this.f4478n = tasksManager;
        this.f4479o = feedStoryMutator;
        this.f4480p = abstractFbErrorReporter;
    }
}
