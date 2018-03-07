package com.facebook.feed.ui.inlinevideoplayer.plugins;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.facecastdisplay.LiveStatusPoller;
import com.facebook.facecastdisplay.LiveStatusPoller.LiveStatusListener;
import com.facebook.facecastdisplay.LiveVideoStatusMessage;
import com.facebook.facecastdisplay.LiveVideoStatusView;
import com.facebook.facecastdisplay.LiveVideoStatusView.IndicatorType;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.video.abtest.VideoLivePlaybackConfig;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoPlayer.VideoSourceType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPBroadcastStatusChangedEvent;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent;
import com.facebook.video.player.events.RVPRequestSwitchPlayableUriEvent;
import com.facebook.video.player.events.RVPSeekBarStateEvent;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPluginWithEnv;
import com.facebook.video.util.VideoStoryMutationHelper;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: perms */
public class LiveVideoStatusPlugin<E extends HasLiveStatusPoller> extends RichVideoPlayerPluginWithEnv<E> implements LiveStatusListener {
    public static final String f5076a = LiveVideoStatusPlugin.class.getName();
    public final View f5077b;
    public final LiveVideoStatusMessage f5078d;
    private final boolean f5079l;
    @Inject
    LiveStatusPoller f5080m;
    @Inject
    DefaultAndroidThreadUtil f5081n;
    @Inject
    @ForUiThread
    Handler f5082o;
    @Inject
    VideoLivePlaybackConfig f5083p;
    @Inject
    VideoHomeConfig f5084q;
    @Inject
    VideoStoryMutationHelper f5085r;
    public final LiveVideoStatusView f5086s;
    @Nullable
    protected String f5087t;
    protected GraphQLVideoBroadcastStatus f5088u;
    @Nullable
    protected GraphQLStory f5089v;
    public boolean f5090w;
    public boolean f5091x;
    public boolean f5092y;
    public final Runnable f5093z;

    public static void m5434a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((LiveVideoStatusPlugin) obj).m5433a(LiveStatusPoller.m5140b(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), Handler_ForUiThreadMethodAutoProvider.b(fbInjector), VideoLivePlaybackConfig.a(fbInjector), VideoHomeConfig.a(fbInjector), VideoStoryMutationHelper.m5148b(fbInjector));
    }

    private void m5433a(LiveStatusPoller liveStatusPoller, DefaultAndroidThreadUtil defaultAndroidThreadUtil, Handler handler, VideoLivePlaybackConfig videoLivePlaybackConfig, VideoHomeConfig videoHomeConfig, VideoStoryMutationHelper videoStoryMutationHelper) {
        this.f5080m = liveStatusPoller;
        this.f5081n = defaultAndroidThreadUtil;
        this.f5082o = handler;
        this.f5083p = videoLivePlaybackConfig;
        this.f5084q = videoHomeConfig;
        this.f5085r = videoStoryMutationHelper;
    }

    @DoNotStrip
    public LiveVideoStatusPlugin(Context context) {
        this(context, null);
    }

    private LiveVideoStatusPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveVideoStatusPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5079l = true;
        this.f5092y = true;
        this.f5093z = new 1(this);
        Class cls = LiveVideoStatusPlugin.class;
        m5434a((Object) this, getContext());
        setContentView(getLayout());
        this.f5086s = (LiveVideoStatusView) m14861a(2131561693);
        this.f5086s.a();
        this.f5080m.f4662g = this;
        this.f5077b = m14861a(2131562404);
        this.f5078d = (LiveVideoStatusMessage) m14861a(2131562405);
        this.f14094f.add(new StateChangedEventSubscriber(this, this));
        this.f14094f.add(new StreamDriedOutEventSubscriber(this, this));
        this.f14094f.add(new CommercialBreakStateChangeEventSubscriber(this));
    }

    protected int getLayout() {
        return 2130905100;
    }

    protected void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (richVideoPlayerParams.f4963b != null && richVideoPlayerParams.f4963b.containsKey("GraphQLStoryProps")) {
            Object obj = richVideoPlayerParams.f4963b.get("GraphQLStoryProps");
            if (obj instanceof FeedProps) {
                this.f5089v = (GraphQLStory) ((FeedProps) obj).a;
            }
        }
        if (richVideoPlayerParams.f4963b == null || !Boolean.TRUE.equals(richVideoPlayerParams.f4963b.get("IsSmallVideoKey")) || this.f14096h == null || this.f14096h.f5120q != PlayerType.INLINE_PLAYER) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f5090w = z2;
        GraphQLMedia a = RichVideoPlayerParamsUtil.m5428a(richVideoPlayerParams);
        if (a != null && a.aq()) {
            this.f5088u = a.br();
            this.f5087t = a.b();
            LiveVideoStatusView liveVideoStatusView = this.f5086s;
            if (this.f5088u == GraphQLVideoBroadcastStatus.LIVE) {
                z3 = true;
            }
            liveVideoStatusView.setIsLiveNow(z3);
            if (z) {
                this.f5086s.setViewerCount(a.av());
            }
            if (this.f5088u == GraphQLVideoBroadcastStatus.LIVE) {
                m5441m(this);
                if (z) {
                    m5437b(this.f5087t);
                }
                m5436b(this, this.f14096h.f5115l);
                return;
            } else if (this.f5088u == GraphQLVideoBroadcastStatus.LIVE_STOPPED || this.f5088u == GraphQLVideoBroadcastStatus.SEAL_STARTED) {
                if (z) {
                    m5437b(this.f5087t);
                }
                m5435a(this.f5087t, true);
            } else {
                m5442n();
                return;
            }
        }
        m5442n();
    }

    private void m5437b(String str) {
        if (this.f4500c instanceof HasLiveStatusPoller) {
            ((HasLiveStatusPoller) this.f4500c).a().a(str, this.f5088u, this);
        } else {
            this.f5080m.m5145a(str);
        }
    }

    private void m5439c(String str) {
        if (this.f4500c instanceof HasLiveStatusPoller) {
            ((HasLiveStatusPoller) this.f4500c).a().a(str);
            if (this.f5084q.b) {
                ((HasLiveStatusPoller) this.f4500c).a().b(str);
                return;
            }
            return;
        }
        this.f5080m.m5144a();
    }

    private void m5435a(String str, boolean z) {
        if (this.f4500c instanceof HasLiveStatusPoller) {
            ((HasLiveStatusPoller) this.f4500c).a().a(str, z);
        } else {
            this.f5080m.f4666k = z;
        }
    }

    protected void mo378c() {
        this.f5088u = GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        m5439c(this.f5087t);
        if (m5440l()) {
            this.f5086s.f.cancel();
            this.f5078d.a.cancel();
        }
        m5442n();
        this.f5087t = null;
        this.f5089v = null;
        this.f5091x = false;
    }

    private boolean m5440l() {
        PlayerOrigin playerOrigin;
        if (this.f14097i != null) {
            playerOrigin = this.f14097i.f14031x;
        } else {
            playerOrigin = null;
        }
        return (playerOrigin == PlayerOrigin.VIDEO_HOME && this.f5084q.d) ? false : true;
    }

    public final void mo404a(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus = this.f5088u;
        this.f5088u = videoBroadcastFragmentModel.d();
        if (this.f14095g != null) {
            if (this.f5088u != graphQLVideoBroadcastStatus) {
                this.f14095g.m14878a(new RVPBroadcastStatusChangedEvent(this.f5087t, this.f5088u));
            }
            if (!this.f5083p.P) {
                if (TextUtils.isEmpty(videoBroadcastFragmentModel.fm_())) {
                    this.f14095g.m14878a(new RVPRequestSwitchPlayableUriEvent(this.f5087t, EventTriggerType.BY_USER, VideoSourceType.VIDEO_SOURCE_HLS, null));
                } else {
                    this.f14095g.m14878a(new RVPRequestSwitchPlayableUriEvent(this.f5087t, EventTriggerType.BY_USER, VideoSourceType.VIDEO_SOURCE_RTMP, videoBroadcastFragmentModel.fm_()));
                }
            }
        }
        if (this.f14096h == null || this.f5088u != GraphQLVideoBroadcastStatus.LIVE) {
            m5442n();
        } else {
            m5441m(this);
            m5436b(this, this.f14096h.f5115l);
        }
        if (!FacecastUtil.a(graphQLVideoBroadcastStatus) && FacecastUtil.a(this.f5088u)) {
            m5438c(videoBroadcastFragmentModel);
        }
    }

    public final void mo406b(VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        m5442n();
        this.f5088u = videoBroadcastFragmentModel.d();
        if (this.f5088u == GraphQLVideoBroadcastStatus.VOD_READY) {
            if (this.f14095g != null) {
                this.f14095g.m14878a(new RVPBroadcastStatusChangedEvent(this.f5087t, this.f5088u));
            }
            m5438c(videoBroadcastFragmentModel);
        }
        m5439c(this.f5087t);
        String str = this.f5087t;
        if (this.f4500c instanceof HasLiveStatusPoller) {
            ((HasLiveStatusPoller) this.f4500c).a().b(str);
        }
    }

    public final void mo405a(String str) {
        m5442n();
        this.f5088u = GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPBroadcastStatusChangedEvent(this.f5087t, this.f5088u));
        }
        m5438c(null);
        m5439c(this.f5087t);
    }

    public final void r_(int i) {
        this.f5086s.setViewerCount(i);
    }

    private void m5438c(@Nullable VideoBroadcastFragmentModel videoBroadcastFragmentModel) {
        this.f5081n.a();
        if (this.f5089v != null) {
            if (!this.f5084q.b || this.f14096h == null || this.f14096h.m5485o() != PlayerOrigin.VIDEO_HOME) {
                this.f5089v = this.f5085r.m5149a(this.f5089v, videoBroadcastFragmentModel);
            }
        }
    }

    protected void m5446a(State state) {
        if (!m5440l()) {
            return;
        }
        if (state.isPlayingState()) {
            if (!this.f5086s.f.isStarted()) {
                this.f5086s.f.start();
                this.f5078d.a.start();
            }
        } else if (this.f5086s.f.isStarted()) {
            this.f5086s.f.cancel();
            this.f5078d.a.cancel();
        }
    }

    protected final void m5450d() {
        if (m5440l()) {
            this.f5086s.f.start();
            this.f5078d.a.start();
        }
    }

    public static void m5436b(LiveVideoStatusPlugin liveVideoStatusPlugin, State state) {
        int i = 0;
        if (liveVideoStatusPlugin.f5088u == GraphQLVideoBroadcastStatus.LIVE) {
            liveVideoStatusPlugin.m5435a(liveVideoStatusPlugin.f5087t, !state.isPlayingState());
            liveVideoStatusPlugin.m5446a(state);
            switch (2.a[state.ordinal()]) {
                case 1:
                    liveVideoStatusPlugin.m5442n();
                    return;
                case 2:
                    HandlerDetour.a(liveVideoStatusPlugin.f5082o, liveVideoStatusPlugin.f5093z);
                    break;
            }
            liveVideoStatusPlugin.f5077b.setVisibility(8);
            liveVideoStatusPlugin.f5078d.setVisibility(8);
            liveVideoStatusPlugin.f5086s.setIsSmall(liveVideoStatusPlugin.f5090w);
            LiveVideoStatusView liveVideoStatusView = liveVideoStatusPlugin.f5086s;
            if (!liveVideoStatusPlugin.f5092y) {
                i = 8;
            }
            liveVideoStatusView.setVisibility(i);
            return;
        }
        liveVideoStatusPlugin.m5442n();
    }

    public static void m5441m(LiveVideoStatusPlugin liveVideoStatusPlugin) {
        if (liveVideoStatusPlugin.f14095g != null) {
            liveVideoStatusPlugin.f14095g.m14878a(new RVPSeekBarStateEvent(RVPSeekBarStateEvent.State.ALWAYS_INVISIBLE));
        }
    }

    private void m5442n() {
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPSeekBarStateEvent(RVPSeekBarStateEvent.State.DEFAULT));
        }
        HandlerDetour.a(this.f5082o, this.f5093z);
        this.f5086s.setVisibility(8);
        this.f5077b.setVisibility(8);
        this.f5078d.setVisibility(8);
    }

    protected void m5445a(RVPCommercialBreakStateChangeEvent.State state) {
        switch (2.b[state.ordinal()]) {
            case 1:
                this.f5086s.setIndicatorType(IndicatorType.LIVE);
                return;
            case 2:
            case 3:
            case 4:
                this.f5086s.setIndicatorType(IndicatorType.LIVE);
                return;
            case 5:
                this.f5078d.setVisibility(8);
                this.f5086s.setIndicatorType(IndicatorType.VIEWER_COMMERCIAL_BREAK);
                return;
            default:
                return;
        }
    }
}
