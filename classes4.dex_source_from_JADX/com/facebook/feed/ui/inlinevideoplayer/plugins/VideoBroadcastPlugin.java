package com.facebook.feed.ui.inlinevideoplayer.plugins;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.event.FbEvent;
import com.facebook.facecastdisplay.LiveStatusPoller;
import com.facebook.facecastdisplay.LiveStatusPoller.LiveStatusListener;
import com.facebook.facecastdisplay.LiveStatusView;
import com.facebook.facecastdisplay.LiveStatusView.VideoState;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoPlayer.VideoSourceType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPBroadcastStatusChangedEvent;
import com.facebook.video.player.events.RVPLoadingSpinnerStateEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPRequestSwitchPlayableUriEvent;
import com.facebook.video.player.events.RVPSeekBarStateEvent;
import com.facebook.video.player.events.RVPStreamDriedOutEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.StubbableRichVideoPlayerPlugin;
import com.facebook.video.util.VideoStoryMutationHelper;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: placeholder */
public class VideoBroadcastPlugin extends StubbableRichVideoPlayerPlugin implements LiveStatusListener {
    public static final String f4637b = VideoBroadcastPlugin.class.getName();
    private final Handler f4638c;
    @Inject
    LiveStatusPoller f4639d;
    @Inject
    Clock f4640l;
    @Inject
    FeedEventBus f4641m;
    @Inject
    DefaultAndroidThreadUtil f4642n;
    @Inject
    QeAccessor f4643o;
    @Inject
    VideoLivePlaybackConfig f4644p;
    @Inject
    VideoStoryMutationHelper f4645q;
    @Nullable
    protected LiveStatusView f4646r;
    @Nullable
    protected String f4647s;
    protected GraphQLVideoBroadcastStatus f4648t;
    @Nullable
    private GraphQLStory f4649u;
    @Nullable
    public View f4650v;
    public boolean f4651w;
    private final Runnable f4652x;
    private final Runnable f4653y;

    /* compiled from: placeholder */
    class C02061 implements Runnable {
        final /* synthetic */ VideoBroadcastPlugin f4654a;

        C02061(VideoBroadcastPlugin videoBroadcastPlugin) {
            this.f4654a = videoBroadcastPlugin;
        }

        public void run() {
            if (this.f4654a.f4644p.s) {
                this.f4654a.f4646r.a(VideoState.BROADCAST_PAUSED);
            } else {
                this.f4654a.f4646r.a(VideoState.PAUSED);
            }
            this.f4654a.f4650v.setVisibility(0);
        }
    }

    /* compiled from: placeholder */
    class C02072 implements Runnable {
        final /* synthetic */ VideoBroadcastPlugin f4655a;

        C02072(VideoBroadcastPlugin videoBroadcastPlugin) {
            this.f4655a = videoBroadcastPlugin;
        }

        public void run() {
            this.f4655a.f4646r.a(VideoState.PLAYBACK_STALLED);
            this.f4655a.f4650v.setVisibility(0);
        }
    }

    /* compiled from: placeholder */
    class StateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ VideoBroadcastPlugin f4673a;

        public final void m5152b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            boolean z = true;
            if (this.f4673a.f14153c) {
                String str = VideoBroadcastPlugin.f4637b;
                Object[] objArr = new Object[5];
                objArr[0] = rVPPlayerStateChangedEvent.f14079b;
                objArr[1] = this.f4673a.f4647s;
                objArr[2] = Boolean.valueOf(this.f4673a.f4651w);
                objArr[3] = this.f4673a.f4646r.getParent();
                if (this.f4673a.f4646r.getVisibility() != 0) {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                this.f4673a.m5132a(rVPPlayerStateChangedEvent.f14079b);
            }
        }

        public StateChangedEventSubscriber(VideoBroadcastPlugin videoBroadcastPlugin, RichVideoPlayerPlugin richVideoPlayerPlugin) {
            this.f4673a = videoBroadcastPlugin;
            super(richVideoPlayerPlugin);
        }

        public final Class<RVPPlayerStateChangedEvent> m5151a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: placeholder */
    class StreamDriedOutEventSubscriber extends RichVideoPlayerEventSubscriber<RVPStreamDriedOutEvent> {
        final /* synthetic */ VideoBroadcastPlugin f4674a;

        public StreamDriedOutEventSubscriber(VideoBroadcastPlugin videoBroadcastPlugin, RichVideoPlayerPlugin richVideoPlayerPlugin) {
            this.f4674a = videoBroadcastPlugin;
            super(richVideoPlayerPlugin);
        }

        public final void m5154b(FbEvent fbEvent) {
            if (this.f4674a.f14153c && this.f4674a.f4644p.s) {
                boolean z;
                String str = VideoBroadcastPlugin.f4637b;
                String str2 = this.f4674a.f4647s;
                Boolean.valueOf(this.f4674a.f4651w);
                if (this.f4674a.f4646r.getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                Boolean.valueOf(z);
                this.f4674a.m5127k();
            }
        }

        public final Class<RVPStreamDriedOutEvent> m5153a() {
            return RVPStreamDriedOutEvent.class;
        }
    }

    public static void m5124a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VideoBroadcastPlugin) obj).m5123a(LiveStatusPoller.m5140b(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector), FeedEventBus.a(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), VideoLivePlaybackConfig.a(fbInjector), VideoStoryMutationHelper.m5148b(fbInjector));
    }

    private void m5123a(LiveStatusPoller liveStatusPoller, Clock clock, FeedEventBus feedEventBus, DefaultAndroidThreadUtil defaultAndroidThreadUtil, QeAccessor qeAccessor, VideoLivePlaybackConfig videoLivePlaybackConfig, VideoStoryMutationHelper videoStoryMutationHelper) {
        this.f4639d = liveStatusPoller;
        this.f4640l = clock;
        this.f4641m = feedEventBus;
        this.f4642n = defaultAndroidThreadUtil;
        this.f4643o = qeAccessor;
        this.f4644p = videoLivePlaybackConfig;
        this.f4645q = videoStoryMutationHelper;
    }

    @DoNotStrip
    public VideoBroadcastPlugin(Context context) {
        this(context, null);
    }

    private VideoBroadcastPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Integer.valueOf(0));
    }

    public VideoBroadcastPlugin(Context context, AttributeSet attributeSet, Integer num) {
        super(context, attributeSet, num.intValue());
        this.f4652x = new C02061(this);
        this.f4653y = new C02072(this);
        Class cls = VideoBroadcastPlugin.class;
        m5124a((Object) this, getContext());
        this.f4638c = new Handler(Looper.getMainLooper());
        this.f14094f.add(new StateChangedEventSubscriber(this, this));
        this.f14094f.add(new StreamDriedOutEventSubscriber(this, this));
    }

    protected final boolean mo377a(RichVideoPlayerParams richVideoPlayerParams) {
        return this.f4651w;
    }

    protected int getLayoutToInflate() {
        return 2130907659;
    }

    protected void setupPlugin(RichVideoPlayerParams richVideoPlayerParams) {
    }

    protected void setupViews(View view) {
        this.f4646r = (LiveStatusView) view.findViewById(2131561693);
        this.f4646r.a();
        this.f4639d.f4662g = this;
        this.f4650v = view.findViewById(2131562404);
    }

    protected void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        this.f4649u = null;
        if (richVideoPlayerParams.f4963b != null && richVideoPlayerParams.f4963b.containsKey("GraphQLStoryProps")) {
            Object obj = richVideoPlayerParams.f4963b.get("GraphQLStoryProps");
            if (obj instanceof FeedProps) {
                this.f4649u = (GraphQLStory) ((FeedProps) obj).a;
            }
        }
        if (this.f4649u != null && StoryAttachmentHelper.o(this.f4649u) != null && StoryAttachmentHelper.o(this.f4649u).r() != null) {
            this.f4651w = StoryAttachmentHelper.o(this.f4649u).r().al();
            if (!m14963d()) {
                return;
            }
            if (this.f4647s == null || !this.f4647s.equals(StoryAttachmentHelper.o(this.f4649u).r().b())) {
                this.f4647s = StoryAttachmentHelper.o(this.f4649u).r().b();
                if (this.f4651w) {
                    m5132a(this.f14096h.f5115l);
                    this.f4639d.m5145a(this.f4647s);
                    return;
                }
                m5129m();
                return;
            }
            m5132a(this.f14096h.f5115l);
        }
    }

    protected final void m5132a(State state) {
        if (this.f4651w) {
            boolean z;
            m5128l();
            LiveStatusPoller liveStatusPoller = this.f4639d;
            if (state.isPlayingState()) {
                z = false;
            } else {
                z = true;
            }
            liveStatusPoller.f4666k = z;
            switch (3.a[state.ordinal()]) {
                case 1:
                case 2:
                    HandlerDetour.a(this.f4638c, this.f4652x);
                    HandlerDetour.a(this.f4638c, this.f4653y);
                    this.f4646r.a(VideoState.PLAYING);
                    this.f4650v.setVisibility(8);
                    return;
                case 3:
                    if (this.f4644p.s) {
                        HandlerDetour.a(this.f4638c, this.f4653y);
                        HandlerDetour.b(this.f4638c, this.f4653y, 2000, -146697216);
                        return;
                    }
                    HandlerDetour.a(this.f4638c, this.f4652x);
                    HandlerDetour.b(this.f4638c, this.f4652x, 2000, 99758303);
                    return;
            }
        }
        m5129m();
    }

    private void m5127k() {
        if (this.f4651w) {
            m5128l();
            HandlerDetour.a(this.f4638c, this.f4652x);
            HandlerDetour.a(this.f4638c, this.f4653y);
            HandlerDetour.a(this.f4638c, this.f4652x, 1827295770);
        }
    }

    public void mo378c() {
        this.f4647s = null;
        this.f4651w = false;
        if (this.f14153c) {
            this.f4639d.m5144a();
            m5129m();
        }
    }

    public final void mo404a(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus = this.f4648t;
        this.f4648t = videoBroadcastFragmentModel.d();
        if (this.f14095g != null) {
            if (this.f4648t != graphQLVideoBroadcastStatus) {
                this.f14095g.m14878a(new RVPBroadcastStatusChangedEvent(this.f4647s, this.f4648t));
            }
            if (!this.f4644p.P) {
                if (TextUtils.isEmpty(videoBroadcastFragmentModel.fm_())) {
                    this.f14095g.m14878a(new RVPRequestSwitchPlayableUriEvent(this.f4647s, EventTriggerType.BY_USER, VideoSourceType.VIDEO_SOURCE_HLS, null));
                } else {
                    this.f14095g.m14878a(new RVPRequestSwitchPlayableUriEvent(this.f4647s, EventTriggerType.BY_USER, VideoSourceType.VIDEO_SOURCE_RTMP, videoBroadcastFragmentModel.fm_()));
                }
            }
        }
    }

    public final void mo406b(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        m5129m();
        this.f4648t = videoBroadcastFragmentModel.d();
        if (this.f4651w) {
            this.f4651w = false;
            if (this.f14095g != null) {
                this.f14095g.m14878a(new RVPBroadcastStatusChangedEvent(this.f4647s, GraphQLVideoBroadcastStatus.VOD_READY));
            }
            m5125c(videoBroadcastFragmentModel);
        }
        this.f4639d.m5144a();
    }

    public final void mo405a(String str) {
        m5129m();
        this.f4651w = false;
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPBroadcastStatusChangedEvent(this.f4647s, GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE));
        }
        m5125c(null);
        this.f4639d.m5144a();
    }

    public final void r_(int i) {
        if (this.f4646r != null) {
            this.f4646r.setViewerCount(i);
        }
    }

    private void m5125c(@Nullable VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        this.f4642n.a();
        if (this.f4649u != null) {
            this.f4645q.m5149a(this.f4649u, videoBroadcastFragmentModel);
        }
    }

    private void m5128l() {
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPSeekBarStateEvent(RVPSeekBarStateEvent.State.ALWAYS_INVISIBLE));
            this.f14095g.m14878a(new RVPLoadingSpinnerStateEvent(RVPLoadingSpinnerStateEvent.State.HIDE));
        }
        this.f4646r.setVisibility(0);
    }

    private void m5129m() {
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPSeekBarStateEvent(RVPSeekBarStateEvent.State.DEFAULT));
            this.f14095g.m14878a(new RVPLoadingSpinnerStateEvent(RVPLoadingSpinnerStateEvent.State.DEFAULT));
        }
        HandlerDetour.a(this.f4638c, this.f4652x);
        this.f4646r.setVisibility(8);
        this.f4650v.setVisibility(8);
    }
}
