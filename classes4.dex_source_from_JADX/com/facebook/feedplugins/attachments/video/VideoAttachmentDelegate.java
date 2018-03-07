package com.facebook.feedplugins.attachments.video;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.attachments.videos.ui.VideoPlayerAttachment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.ContextUtils;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneController.FeatureType;
import com.facebook.drawee.fbpipeline.DegradableDraweeController;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ui.fullscreenvideoplayer.FeedFullScreenVideoElapsedMonitor;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader$FeedImageType;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.model.conversion.GraphQLVideoConversionHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.video.analytics.ChannelEligibility;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo.Builder;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.player.BaseInlineVideoPlayer;
import com.facebook.video.player.VideoTransitionNode;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: photo_tagged_by_non_owner */
public class VideoAttachmentDelegate {
    private static final CallerContext f4870a = CallerContext.a(VideoAttachmentDelegate.class, "native_newsfeed");
    private DialtoneController f4871A;
    private ChannelEligibility f4872B = ChannelEligibility.UNSUPPORTED_LOCATION;
    private final FeedImageLoader f4873b;
    private final VideoSizer f4874c;
    public final FeedProps<GraphQLStoryAttachment> f4875d;
    public final GraphQLVideo f4876e;
    public final FeedEventBus f4877f;
    private final FbDraweeControllerBuilder f4878g;
    private final Optional<VideoSizeAndBackgroundOverride> f4879h;
    private final ChannelFeedEligibilityUtil f4880i;
    private ImageRequest f4881j;
    public PlayerOrigin f4882k;
    public int f4883l;
    public int f4884m;
    private int f4885n;
    private int f4886o;
    private int f4887p;
    private boolean f4888q;
    private float f4889r;
    public FeedFullScreenParams f4890s;
    public ImmersiveVideoPlayer f4891t;
    public FullscreenListener f4892u;
    private VideoFeedStoryInfo f4893v;
    @Nullable
    public FullscreenTransitionListener f4894w;
    public FeedFullScreenVideoElapsedMonitor f4895x;
    public VideoLoggingUtils f4896y;
    private boolean f4897z;

    @Inject
    public VideoAttachmentDelegate(@Assisted FeedProps<GraphQLStoryAttachment> feedProps, @Assisted Optional<VideoSizeAndBackgroundOverride> optional, FeedImageLoader feedImageLoader, FeedFullScreenVideoElapsedMonitor feedFullScreenVideoElapsedMonitor, VideoSizer videoSizer, FeedEventBus feedEventBus, VideoLoggingUtils videoLoggingUtils, FbDraweeControllerBuilder fbDraweeControllerBuilder, DialtoneController dialtoneController, ChannelFeedEligibilityUtil channelFeedEligibilityUtil) {
        TracerDetour.a("VideoAttachmentDelegate.init", -509915342);
        try {
            this.f4879h = optional;
            this.f4873b = feedImageLoader;
            this.f4874c = videoSizer;
            this.f4875d = feedProps;
            this.f4876e = (GraphQLVideo) Preconditions.checkNotNull(GraphQLMediaConversionHelper.b(((GraphQLStoryAttachment) this.f4875d.a()).r()));
            this.f4895x = feedFullScreenVideoElapsedMonitor;
            this.f4877f = feedEventBus;
            this.f4896y = videoLoggingUtils;
            this.f4878g = fbDraweeControllerBuilder;
            this.f4892u = new FullscreenListener(this);
            this.f4889r = 0.0f;
            this.f4888q = m5277a(this.f4875d);
            this.f4871A = dialtoneController;
            this.f4880i = channelFeedEligibilityUtil;
        } finally {
            TracerDetour.a(1806913344);
        }
    }

    @Deprecated
    public final void m5280a() {
        m5276a(PlayerOrigin.FEED, new VideoCoverPrefetcher());
    }

    public final <E extends HasPrefetcher & HasFeedListType> void m5288a(PlayerOrigin playerOrigin, E e) {
        this.f4872B = this.f4880i.a(this.f4875d, ((HasFeedListType) e).c().a());
        m5276a(playerOrigin, new EnvironmentCoverPrefetcher(e));
    }

    private void m5276a(PlayerOrigin playerOrigin, VideoCoverPrefetcher videoCoverPrefetcher) {
        if (!this.f4897z) {
            TracerDetour.a("VideoAttachmentDelegate.FeedImageLoader.createImageRequest", -986158821);
            try {
                this.f4881j = this.f4873b.a(GraphQLVideoConversionHelper.a(this.f4876e), FeedImageLoader$FeedImageType.Video);
                videoCoverPrefetcher.a(this.f4881j, f4870a);
                m5279g();
                m5275a(playerOrigin);
                this.f4897z = true;
            } finally {
                TracerDetour.a(966022503);
            }
        }
    }

    private static int m5272a(Optional<VideoSizeAndBackgroundOverride> optional, GraphQLStoryAttachment graphQLStoryAttachment) {
        if (optional.isPresent()) {
            return ((VideoSizeAndBackgroundOverride) optional.get()).c;
        }
        GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle = graphQLStoryAttachment.w().isEmpty() ? null : (GraphQLStoryAttachmentStyle) graphQLStoryAttachment.w().get(0);
        if (CallToActionUtil.k(graphQLStoryAttachment) || CallToActionUtil.h(graphQLStoryAttachment) || graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.AVATAR_WITH_VIDEO) {
            return 2130840298;
        }
        return 0;
    }

    public final void m5285a(VideoPlayerAttachment videoPlayerAttachment) {
        TracerDetour.a("VideoAttachmentDelegate.bindVideoPlayerAttachment", -1799082561);
        try {
            m5279g();
            videoPlayerAttachment.mo1001a(this.f4885n, this.f4871A.j() ? this.f4871A.e() : this.f4884m);
            videoPlayerAttachment.mo1002b(this.f4887p, this.f4886o);
            this.f4878g.a(f4870a).b(videoPlayerAttachment.getCoverController());
            this.f4878g.c(this.f4881j);
            FbPipelineDraweeController s = this.f4878g.s();
            if (s instanceof DegradableDraweeController) {
                ((DegradableDraweeController) s).m4727a(0, FeatureType.VIDEO);
            }
            videoPlayerAttachment.setCoverController(s);
            videoPlayerAttachment.setBackgroundResource(m5272a(this.f4879h, (GraphQLStoryAttachment) this.f4875d.a()));
        } finally {
            TracerDetour.a(-2146621389);
        }
    }

    public final void m5286a(FullscreenTransitionListener fullscreenTransitionListener) {
        Preconditions.checkNotNull(fullscreenTransitionListener, "listener already set");
        this.f4894w = fullscreenTransitionListener;
    }

    public final void m5281a(float f) {
        this.f4889r = f;
    }

    private void m5279g() {
        if (this.f4879h.isPresent()) {
            this.f4885n = ((VideoSizeAndBackgroundOverride) this.f4879h.get()).a;
            this.f4887p = ((VideoSizeAndBackgroundOverride) this.f4879h.get()).a;
            this.f4884m = ((VideoSizeAndBackgroundOverride) this.f4879h.get()).b;
            this.f4886o = ((VideoSizeAndBackgroundOverride) this.f4879h.get()).b;
            return;
        }
        VideoSizer$VideoSize b = this.f4874c.b(this.f4875d, this.f4889r);
        this.f4885n = b.f4898a;
        this.f4884m = b.f4899b;
        this.f4887p = b.f4900c;
        this.f4886o = b.f4901d;
        this.f4883l = b.f4902e;
    }

    private void m5275a(PlayerOrigin playerOrigin) {
        this.f4882k = playerOrigin;
        Builder builder = new Builder(TrackableFeedProps.a(this.f4875d));
        builder.d = this.f4888q;
        Builder builder2 = builder;
        builder2.c = this.f4872B;
        this.f4893v = builder2.a();
        this.f4890s = new FeedFullScreenParams(new VideoAnalyticsRequiredInfo.Builder(this.f4876e.J()).a(), this.f4893v, this.f4881j, this.f4876e, this.f4875d);
        this.f4890s.m5328a(this.f4882k);
    }

    public static boolean m5277a(FeedProps<GraphQLStoryAttachment> feedProps) {
        FeedProps e = AttachmentProps.e(feedProps);
        return e != null && StoryProps.p(e);
    }

    public final void m5289a(BaseInlineVideoPlayer baseInlineVideoPlayer, boolean z) {
        if (m5278a((Object) baseInlineVideoPlayer, z) && (baseInlineVideoPlayer instanceof VideoTransitionNode)) {
            this.f4890s.f4950h = (VideoTransitionNode) baseInlineVideoPlayer;
        }
    }

    public final void m5290a(VideoTransitionNode videoTransitionNode, boolean z) {
        if (m5278a((Object) videoTransitionNode, z)) {
            this.f4890s.f4950h = videoTransitionNode;
        }
    }

    private boolean m5278a(Object obj, boolean z) {
        if (this.f4890s == null) {
            return false;
        }
        boolean z2;
        if (this.f4891t != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        ImmersiveVideoPlayer immersiveVideoPlayer = this.f4891t;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        immersiveVideoPlayer.setLogEnteringStartEvent(z2);
        this.f4891t.setLogExitingPauseEvent(false);
        return true;
    }

    public final void m5284a(View view) {
        m5273a(view.getContext());
    }

    public final void m5291b(View view) {
        this.f4872B = ChannelEligibility.WRONG_STORY_TYPE;
        m5274a((FullScreenVideoPlayerHost) ContextUtils.a(view.getContext(), FullScreenVideoPlayerHost.class));
    }

    private void m5273a(Context context) {
        m5274a((FullScreenVideoPlayerHost) ContextUtils.a(context, FullScreenVideoPlayerHost.class));
    }

    private void m5274a(FullScreenVideoPlayerHost fullScreenVideoPlayerHost) {
        this.f4891t = fullScreenVideoPlayerHost.k();
        this.f4891t.setLogExitingPauseEvent(true);
        this.f4891t.setAllowLooping(true);
        this.f4891t.a(this.f4892u);
    }

    public final GraphQLVideo m5292c() {
        return this.f4876e;
    }

    public final PlayerOrigin m5294f() {
        return this.f4882k;
    }

    public final void m5282a(int i, int i2, boolean z) {
        m5283a(i, i2, z, null);
    }

    public final void m5283a(int i, int i2, boolean z, @Nullable ImmutableMap<String, Object> immutableMap) {
        if (this.f4890s != null) {
            this.f4890s.m5327a(i).m5330b(i2);
            if (z) {
                this.f4890s.f4952j = EventTriggerType.BY_INLINE_FULLSCREEN_TRANSITION;
            } else {
                this.f4890s.f4952j = EventTriggerType.BY_USER;
            }
            this.f4890s.f4949g = immutableMap;
            this.f4891t.a(this.f4890s);
        }
    }

    public final void m5287a(EventTriggerType eventTriggerType) {
        if (this.f4893v != null) {
            this.f4893v.b = eventTriggerType;
        }
    }

    public final boolean m5293c(View view) {
        boolean z = false;
        if (view.isShown()) {
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                float f = (float) (rect.bottom - rect.top);
                if (Math.max(f / ((float) this.f4884m), f / ((float) this.f4883l)) > Math.min(0.5f + 0.0f, 1.0f)) {
                    z = true;
                }
            }
        }
        return z;
    }
}
