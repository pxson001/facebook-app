package com.facebook.video.channelfeed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.VideoSizer;
import com.facebook.feedplugins.attachments.video.VideoSizer.VideoSize;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.katana.app.module.Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.VideoSubtitlesListener;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.player.environment.CanOpenFullscreen;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: surface_location_sharing */
public class ChannelFeedVideoAttachmentView<E extends HasFullscreenPlayer & HasPlayerOrigin & HasMenuButtonProvider> extends CustomFrameLayout implements VideoSubtitlesListener, VideoTransitionNode, RecyclerViewKeepAttached {
    @Inject
    public VideoLoggingUtils f2517a;
    @Inject
    public ChannelFeedAdditionalRichVideoPlayerParamsBuilder f2518b;
    @Inject
    public VideoSizer f2519c;
    @Inject
    public ChannelInlineRichVideoPlayerPluginSelector f2520d;
    private final RichVideoPlayer f2521e;
    public RichVideoPlayer f2522f;
    public RichVideoPlayerParams f2523g;
    public String f2524h;
    public E f2525i;
    private Subtitles f2526j;

    /* compiled from: surface_location_sharing */
    class InlinePlayerEnvironment implements CanOpenFullscreen, HasFeedMenuHelper {
        final /* synthetic */ ChannelFeedVideoAttachmentView f2516a;

        public InlinePlayerEnvironment(ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView) {
            this.f2516a = channelFeedVideoAttachmentView;
        }

        @Nullable
        public final BaseFeedStoryMenuHelper m2448l() {
            return this.f2516a.f2525i != null ? ((HasMenuButtonProvider) this.f2516a.f2525i).e() : null;
        }

        @Nullable
        public final Function<RichVideoPlayerParams, Void> m2447a() {
            return this.f2516a.f2525i != null ? this.f2516a.f2525i.f2137q : null;
        }
    }

    public static void m2449a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ChannelFeedVideoAttachmentView channelFeedVideoAttachmentView = (ChannelFeedVideoAttachmentView) obj;
        VideoLoggingUtils a = VideoLoggingUtils.a(fbInjector);
        ChannelFeedAdditionalRichVideoPlayerParamsBuilder b = ChannelFeedAdditionalRichVideoPlayerParamsBuilder.m2099b(fbInjector);
        VideoSizer a2 = VideoSizer.a(fbInjector);
        ChannelInlineRichVideoPlayerPluginSelector channelInlineRichVideoPlayerPluginSelector = new ChannelInlineRichVideoPlayerPluginSelector((Context) fbInjector.getInstance(Context.class), Video360PlayerConfig.b(fbInjector), Boolean_IsVideoSpecDisplayEnabledMethodAutoProvider.b(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector));
        channelFeedVideoAttachmentView.f2517a = a;
        channelFeedVideoAttachmentView.f2518b = b;
        channelFeedVideoAttachmentView.f2519c = a2;
        channelFeedVideoAttachmentView.f2520d = channelInlineRichVideoPlayerPluginSelector;
    }

    public ChannelFeedVideoAttachmentView(Context context) {
        this(context, null);
    }

    private ChannelFeedVideoAttachmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ChannelFeedVideoAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ChannelFeedVideoAttachmentView.class;
        m2449a(this, getContext());
        setContentView(2130903547);
        this.f2522f = (RichVideoPlayer) c(2131560290);
        this.f2522f.setPlayerType(getPlayerType());
        this.f2522f.setChannelEligibility(ChannelEligibility.ELIGIBLE);
        this.f2521e = this.f2522f;
    }

    public final boolean gK_() {
        return true;
    }

    public final void m2451a() {
        if (m2450o()) {
            m2458i();
            this.f2522f = this.f2521e;
            this.f2522f.setVisibility(0);
        }
    }

    public /* bridge */ /* synthetic */ List getAdditionalPlugins() {
        return null;
    }

    public boolean hasTransientState() {
        if (m2450o()) {
            return false;
        }
        return super.hasTransientState();
    }

    public final void m2453a(VideoPlayerParams videoPlayerParams, int i, FeedProps<GraphQLStoryAttachment> feedProps, AutoplayStateManager autoplayStateManager, E e) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        boolean z = (videoPlayerParams == null || graphQLStoryAttachment == null || graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().j() == null || graphQLStoryAttachment.r().j().g() != 82650203) ? false : true;
        Preconditions.checkArgument(z);
        if (!videoPlayerParams.b.equals(this.f2524h)) {
            this.f2522f.g();
            this.f2524h = videoPlayerParams.b;
        }
        VideoSize a = this.f2519c.a(feedProps, 0.0f);
        int i2 = a.a;
        int i3 = a.b;
        LayoutParams layoutParams = this.f2522f.getLayoutParams();
        if (layoutParams == null || !(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = new FrameLayout.LayoutParams(i2, i3);
        }
        layoutParams.height = i3;
        layoutParams.width = i2;
        this.f2522f.setLayoutParams(layoutParams);
        ImmutableMap b = this.f2518b.m2100a(AttachmentProps.e(feedProps)).b("IsAutoplayKey", Boolean.valueOf(autoplayStateManager.j())).b("SeekPositionMsKey", Integer.valueOf(i)).b();
        Builder builder = new Builder();
        builder.a = videoPlayerParams;
        RichVideoPlayerParams b2 = builder.a(b).b();
        this.f2520d.a(this.f2522f, b2, new InlinePlayerEnvironment(this));
        this.f2522f.a(b2);
        this.f2523g = b2;
        this.f2525i = e;
        this.f2522f.a(false, EventTriggerType.BY_AUTOPLAY);
    }

    public final void m2452a(int i, EventTriggerType eventTriggerType, VideoResolution videoResolution) {
        Object obj;
        ChannelFeedEnvironment channelFeedEnvironment = this.f2525i;
        if (channelFeedEnvironment.f2138r == null || !channelFeedEnvironment.f2138r.f2203g) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            if (!m2450o()) {
                this.f2522f.a(i, EventTriggerType.BY_AUTOPLAY);
            }
            this.f2522f.setOriginalPlayReason(eventTriggerType);
            this.f2522f.a(videoResolution, EventTriggerType.BY_AUTOPLAY);
            this.f2522f.a(EventTriggerType.BY_AUTOPLAY);
        }
    }

    public final void m2456e() {
        this.f2522f.b(EventTriggerType.BY_AUTOPLAY);
    }

    public RichVideoPlayer getRichVideoPlayer() {
        return this.f2522f;
    }

    public final void m2454a(RichVideoPlayer richVideoPlayer) {
        if (this.f2522f != richVideoPlayer) {
            this.f2521e.setVisibility(8);
            this.f2522f = richVideoPlayer;
            this.f2524h = this.f2522f.getVideoId();
            if (richVideoPlayer.getParent() != null) {
                ((ViewGroup) richVideoPlayer.getParent()).removeView(richVideoPlayer);
            }
            attachViewToParent(richVideoPlayer, 0, richVideoPlayer.getLayoutParams());
            requestLayout();
        }
    }

    public final RichVideoPlayer m2458i() {
        if (this.f2522f.getParent() == this) {
            detachRecyclableViewFromParent(this.f2522f);
        }
        return this.f2522f;
    }

    private boolean m2450o() {
        return this.f2521e != this.f2522f;
    }

    public final RichVideoPlayer m2459j() {
        return this.f2521e;
    }

    public PlayerType getPlayerType() {
        return PlayerType.CHANNEL_PLAYER;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return getAlpha() < 1.0f;
    }

    public final void m2457g() {
        this.f2517a.b(this.f2523g.a.e, PlayerType.CHANNEL_PLAYER.value, EventTriggerType.BY_USER.value, this.f2522f.getCurrentPositionMs(), this.f2524h, this.f2525i.f2136p, this.f2523g.a.f, this.f2523g.a);
    }

    public final void m2455a(Subtitles subtitles) {
        if (this.f2526j != subtitles) {
            this.f2526j = subtitles;
            this.f2522f.a(subtitles);
            this.f2522f.a(subtitles != null);
        }
    }
}
