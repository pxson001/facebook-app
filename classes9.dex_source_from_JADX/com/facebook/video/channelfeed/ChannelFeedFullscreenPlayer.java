package com.facebook.video.channelfeed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.VideoFeedStoryMenuHelperProvider;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.feed.FeedVideoPlayerParamBuilderProvider;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.environment.CanHandleOnVideoDeleted;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import com.facebook.video.player.plugins.Video360Plugin;
import com.facebook.video.player.plugins.VideoPlugin.VideoPluginAlignment;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: targeted_nux */
public class ChannelFeedFullscreenPlayer extends CustomFrameLayout {
    @Inject
    VideoLoggingUtils f2212a;
    @Inject
    FeedVideoPlayerParamBuilderProvider f2213b;
    @Inject
    ChannelFeedAdditionalRichVideoPlayerParamsBuilder f2214c;
    @Inject
    ChannelFeedAutoscrollController f2215d;
    @Inject
    ChannelFullscreenRichVideoPlayerPluginSelector f2216e;
    @Inject
    FacecastUtil f2217f;
    @Inject
    VideoFeedStoryMenuHelperProvider f2218g;
    public final BaseFeedStoryMenuHelper f2219h;
    public RichVideoPlayer f2220i;
    public RichVideoPlayerParams f2221j;
    public PlayerOrigin f2222k;
    public Function<String, FeedProps<GraphQLStory>> f2223l;
    public Function<String, FeedProps<GraphQLStory>> f2224m;
    public Function<FeedProps<GraphQLStory>, Boolean> f2225n;

    /* compiled from: targeted_nux */
    public class FullscreenPlayerEnvironment implements AnyPlayerEnvironment, CanHandleOnVideoDeleted, HasFeedMenuHelper {
        final /* synthetic */ ChannelFeedFullscreenPlayer f2211a;

        public FullscreenPlayerEnvironment(ChannelFeedFullscreenPlayer channelFeedFullscreenPlayer) {
            this.f2211a = channelFeedFullscreenPlayer;
        }

        public final boolean m2224c() {
            m2217e();
            return this.f2211a.f2223l.apply(this.f2211a.getCurrentVideoId()) != null;
        }

        private void m2217e() {
            Preconditions.checkNotNull(this.f2211a.f2223l, "setNextStoryFinder(..) was not called");
        }

        public final boolean m2225d() {
            m2218f();
            return this.f2211a.f2224m.apply(this.f2211a.getCurrentVideoId()) != null;
        }

        private void m2218f() {
            Preconditions.checkNotNull(this.f2211a.f2224m, "setPreviousStoryFinder(..) was not called");
        }

        public final boolean m2222b() {
            if (this.f2211a.f2225n == null || this.f2211a.f2223l == null) {
                return false;
            }
            return ((Boolean) this.f2211a.f2225n.apply(this.f2211a.f2223l.apply(this.f2211a.getCurrentVideoId()))).booleanValue();
        }

        public final void m2221b(EventTriggerType eventTriggerType) {
            m2217e();
            m2215a(eventTriggerType, this.f2211a.f2223l);
            this.f2211a.f2215d.m2110d();
        }

        public final void m2223c(EventTriggerType eventTriggerType) {
            m2218f();
            m2215a(eventTriggerType, this.f2211a.f2224m);
            this.f2211a.f2215d.m2111e();
        }

        private void m2215a(EventTriggerType eventTriggerType, Function<String, FeedProps<GraphQLStory>> function) {
            FeedProps feedProps;
            if (function != null) {
                feedProps = (FeedProps) function.apply(this.f2211a.getCurrentVideoId());
            } else {
                feedProps = null;
            }
            if (feedProps != null && StoryAttachmentHelper.o((GraphQLStory) feedProps.a) != null) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
                VideoPlayerParams a = this.f2211a.f2213b.a(feedProps.a(o), GraphQLMediaConversionHelper.b(o.r())).a();
                Builder a2 = this.f2211a.f2214c.m2100a(feedProps);
                if (a2 != null) {
                    VideoResolution e;
                    RichVideoPlayerParams.Builder builder = new RichVideoPlayerParams.Builder();
                    builder.a = a;
                    RichVideoPlayerParams b = builder.a(a2.b()).b();
                    this.f2211a.f2220i.g();
                    if (this.f2211a.f2220i.u != null) {
                        e = this.f2211a.f2220i.u.e();
                    } else {
                        e = VideoResolution.STANDARD_DEFINITION;
                    }
                    this.f2211a.m2230a(b);
                    this.f2211a.f2221j = b;
                    this.f2211a.f2220i.a(b);
                    this.f2211a.f2220i.a(e, EventTriggerType.BY_AUTOPLAY);
                    m2216d(eventTriggerType);
                    if (e == VideoResolution.HIGH_DEFINITION) {
                        this.f2211a.f2212a.a(a.b, a.e, this.f2211a.f2220i.getCurrentPositionMs(), a.f);
                    }
                    this.f2211a.f2220i.a(eventTriggerType);
                }
            }
        }

        private void m2216d(EventTriggerType eventTriggerType) {
            this.f2211a.f2220i.a(false, eventTriggerType);
            this.f2211a.f2212a.b(this.f2211a.f2221j.a.e, PlayerType.FULL_SCREEN_PLAYER.value, eventTriggerType.value, this.f2211a.f2220i.getCurrentPositionMs(), this.f2211a.f2221j.a.b, this.f2211a.f2222k, this.f2211a.f2221j.a.f, this.f2211a.f2221j.a);
        }

        public final void m2220a(EventTriggerType eventTriggerType) {
            this.f2211a.f2220i.a(eventTriggerType);
            m2216d(eventTriggerType);
        }

        public final void m2219a() {
        }

        public final BaseFeedStoryMenuHelper m2226l() {
            return this.f2211a.f2219h;
        }
    }

    private static <T extends View> void m2231a(Class<T> cls, T t) {
        m2232a((Object) t, t.getContext());
    }

    private static void m2232a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ChannelFeedFullscreenPlayer) obj).m2229a(VideoLoggingUtils.a(injectorLike), (FeedVideoPlayerParamBuilderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedVideoPlayerParamBuilderProvider.class), ChannelFeedAdditionalRichVideoPlayerParamsBuilder.m2099b(injectorLike), ChannelFeedAutoscrollController.m2107a(injectorLike), ChannelFullscreenRichVideoPlayerPluginSelector.m2517b(injectorLike), FacecastUtil.b(injectorLike), (VideoFeedStoryMenuHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoFeedStoryMenuHelperProvider.class));
    }

    private void m2229a(VideoLoggingUtils videoLoggingUtils, FeedVideoPlayerParamBuilderProvider feedVideoPlayerParamBuilderProvider, ChannelFeedAdditionalRichVideoPlayerParamsBuilder channelFeedAdditionalRichVideoPlayerParamsBuilder, ChannelFeedAutoscrollController channelFeedAutoscrollController, ChannelFullscreenRichVideoPlayerPluginSelector channelFullscreenRichVideoPlayerPluginSelector, FacecastUtil facecastUtil, VideoFeedStoryMenuHelperProvider videoFeedStoryMenuHelperProvider) {
        this.f2212a = videoLoggingUtils;
        this.f2213b = feedVideoPlayerParamBuilderProvider;
        this.f2214c = channelFeedAdditionalRichVideoPlayerParamsBuilder;
        this.f2215d = channelFeedAutoscrollController;
        this.f2216e = channelFullscreenRichVideoPlayerPluginSelector;
        this.f2217f = facecastUtil;
        this.f2218g = videoFeedStoryMenuHelperProvider;
    }

    public ChannelFeedFullscreenPlayer(Context context) {
        this(context, null);
    }

    public ChannelFeedFullscreenPlayer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChannelFeedFullscreenPlayer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2222k = PlayerOrigin.UNKNOWN;
        m2231a(ChannelFeedFullscreenPlayer.class, (View) this);
        setContentView(2130904554);
        this.f2220i = new RichVideoPlayer(context);
        this.f2220i.setPlayerType(PlayerType.FULL_SCREEN_PLAYER);
        this.f2220i.setChannelEligibility(ChannelEligibility.ELIGIBLE);
        addView(this.f2220i);
        this.f2219h = this.f2218g.a(null, NegativeFeedbackExperienceLocation.VIDEO_CHANNEL, "video_channel_feed");
    }

    public final void m2241a(RichVideoPlayerParams richVideoPlayerParams, int i, int i2, boolean z, VideoResolution videoResolution) {
        this.f2220i.setPlayerOrigin(this.f2222k);
        m2230a(richVideoPlayerParams);
        this.f2220i.a(richVideoPlayerParams);
        this.f2221j = richVideoPlayerParams;
        if (richVideoPlayerParams.a.s != null) {
            Video360Plugin video360Plugin = (Video360Plugin) this.f2220i.a(Video360Plugin.class);
            if (video360Plugin != null) {
                video360Plugin.f();
            }
        }
        this.f2212a.a(richVideoPlayerParams.a.e, PlayerType.FULL_SCREEN_PLAYER.value, PlayerType.CHANNEL_PLAYER.value, richVideoPlayerParams.a.b, this.f2222k, EventTriggerType.BY_USER.value, i, i2, richVideoPlayerParams.a.f, richVideoPlayerParams.a, null, null);
        this.f2220i.a(false, EventTriggerType.BY_USER);
        this.f2220i.a(videoResolution, EventTriggerType.BY_USER);
        this.f2220i.a(i, EventTriggerType.BY_USER);
        if (z) {
            this.f2220i.a(EventTriggerType.BY_USER);
        }
        setVisibility(0);
    }

    public final void m2240a() {
        if (this.f2221j != null && this.f2221j.a != null) {
            int currentPositionMs = this.f2220i.getCurrentPositionMs();
            if (this.f2220i.o()) {
                this.f2220i.b(EventTriggerType.BY_USER);
            }
            if (!(this.f2220i.t == null || this.f2220i.t.a.s == null)) {
                Video360Plugin video360Plugin = (Video360Plugin) this.f2220i.a(Video360Plugin.class);
                if (video360Plugin != null) {
                    video360Plugin.k();
                }
            }
            this.f2212a.a(this.f2221j.a.e, PlayerType.CHANNEL_PLAYER.value, PlayerType.FULL_SCREEN_PLAYER.value, this.f2221j.a.b, this.f2222k, EventTriggerType.BY_USER.value, currentPositionMs, this.f2220i.getLastStartPosition(), this.f2221j.a.f, this.f2221j.a, null, null);
            this.f2220i.g();
            setVisibility(8);
        }
    }

    public String getCurrentVideoId() {
        if (this.f2221j == null) {
            return null;
        }
        return this.f2221j.a.b;
    }

    public void setPlayerOrigin(PlayerOrigin playerOrigin) {
        this.f2222k = playerOrigin;
    }

    public int getCurrentPositionMs() {
        return this.f2220i.getCurrentPositionMs();
    }

    public final boolean m2242b() {
        return this.f2220i.o();
    }

    @Nullable
    public VideoResolution getVideoResolution() {
        if (this.f2220i.u == null) {
            return null;
        }
        return this.f2220i.u.e();
    }

    public void setNextStoryFinder(Function<String, FeedProps<GraphQLStory>> function) {
        this.f2223l = function;
    }

    public void setPreviousStoryFinder(Function<String, FeedProps<GraphQLStory>> function) {
        this.f2224m = function;
    }

    public void setAutoplaySettingFinder(Function<FeedProps<GraphQLStory>, Boolean> function) {
        this.f2225n = function;
    }

    private void m2230a(RichVideoPlayerParams richVideoPlayerParams) {
        Object obj = null;
        this.f2216e.a(this.f2220i, richVideoPlayerParams, new FullscreenPlayerEnvironment(this));
        if (this.f2217f.h() && RichVideoPlayerParamsUtil.d(richVideoPlayerParams)) {
            obj = 1;
        }
        if (richVideoPlayerParams.a.h || r0 != null) {
            this.f2220i.setVideoPluginAlignment(VideoPluginAlignment.TOP);
        } else {
            this.f2220i.setVideoPluginAlignment(VideoPluginAlignment.CENTER);
        }
    }
}
