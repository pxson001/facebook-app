package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoPlayerView;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.feed.ui.imageloader.FeedImageLoader.FeedImageType;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.feedplugins.attachments.video.FeedAnalyticsUtil;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.ClickTarget;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.analytics.VideoAnalyticsRequiredInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.player.FullScreenVideoListener;
import com.facebook.video.player.VideoTransitionNode;
import com.facebook.video.videohome.environment.HasVideoHomePersistentState;
import com.facebook.video.videohome.environment.VideoHomeStoryPersistentState;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.facebook.video.videohome.logging.VideoHomeStoryLoggingData.Builder;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: skewed_timestamp */
public class VideoHomePlayFullscreenVideoPartDefinition<V extends View & VideoPlayerView & VideoTransitionNode, E extends HasVideoHomePersistentState & HasFeedListType> extends BaseSinglePartDefinition<Props, Void, E, V> {
    private static VideoHomePlayFullscreenVideoPartDefinition f3132f;
    private static final Object f3133g = new Object();
    public final FeedImageLoader f3134a;
    private final Lazy<VideoZeroDialogPartDefinition> f3135b;
    private final VideoHomeSessionManager f3136c;
    private final VideoLoggingUtils f3137d;
    private final VideoHomeLoggingUtils f3138e;

    /* compiled from: skewed_timestamp */
    public final class Props {
        public final FeedProps<GraphQLStoryAttachment> f3118a;
        public final String f3119b;
        public final int f3120c;
        public final String f3121d;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, String str, int i, String str2) {
            this.f3118a = feedProps;
            this.f3119b = str;
            this.f3120c = i;
            this.f3121d = str2;
        }
    }

    /* compiled from: skewed_timestamp */
    public class VideoPlayerOnClickListener implements OnClickListener {
        public final FeedFullScreenParams f3124a;
        private final FeedProps<GraphQLStory> f3125b;
        private final String f3126c;
        public final VideoHomeSessionManager f3127d;
        public final VideoHomeStoryPersistentState f3128e;
        public final VideoLoggingUtils f3129f;
        private final VideoHomeLoggingUtils f3130g;
        private final int f3131h;

        public VideoPlayerOnClickListener(FeedFullScreenParams feedFullScreenParams, FeedProps<GraphQLStory> feedProps, String str, VideoHomeSessionManager videoHomeSessionManager, VideoHomeStoryPersistentState videoHomeStoryPersistentState, VideoLoggingUtils videoLoggingUtils, VideoHomeLoggingUtils videoHomeLoggingUtils, int i) {
            this.f3124a = feedFullScreenParams;
            this.f3125b = feedProps;
            this.f3126c = str;
            this.f3127d = videoHomeSessionManager;
            this.f3128e = videoHomeStoryPersistentState;
            this.f3129f = videoLoggingUtils;
            this.f3130g = videoHomeLoggingUtils;
            this.f3131h = i;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -7195733);
            Preconditions.checkArgument(view instanceof VideoPlayerView);
            VideoPlayerView videoPlayerView = (VideoPlayerView) view;
            FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a(view.getContext(), FullScreenVideoPlayerHost.class);
            if (fullScreenVideoPlayerHost != null) {
                Object obj;
                ClickTarget clickTarget;
                final ImmersiveVideoPlayer k = fullScreenVideoPlayerHost.k();
                k.setAllowLooping(true);
                k.setLogExitingPauseEvent(true);
                k.a(new FullScreenVideoListener(this) {
                    final /* synthetic */ VideoPlayerOnClickListener f3123b;

                    public final void m2985a(EventTriggerType eventTriggerType) {
                        if (!k.g()) {
                            this.f3123b.f3129f.b(this.f3123b.f3124a.m(), PlayerType.INLINE_PLAYER.value, eventTriggerType.value, this.f3123b.f3124a.j(), this.f3123b.f3124a.r(), this.f3123b.f3124a.d.b, this.f3123b.f3124a.o(), this.f3123b.f3124a);
                        }
                    }

                    public final void m2986a(EventTriggerType eventTriggerType, ExitFullScreenResult exitFullScreenResult) {
                        this.f3123b.f3128e.m2793a(exitFullScreenResult.c);
                        AutoplayStateManager b = this.f3123b.f3128e.m2794b();
                        if (b != null) {
                            b.a(exitFullScreenResult.b, exitFullScreenResult.a);
                        }
                        if (!k.g()) {
                            this.f3123b.f3129f.a(this.f3123b.f3124a.m(), PlayerType.INLINE_PLAYER.value, eventTriggerType.value, exitFullScreenResult.c, this.f3123b.f3124a.r(), this.f3123b.f3124a.d.b, this.f3123b.f3124a.o(), this.f3123b.f3124a);
                        }
                        if (this.f3123b.f3127d.g() && this.f3123b.f3127d.i()) {
                            this.f3123b.f3127d.c();
                        }
                    }
                });
                AutoplayStateManager b = this.f3128e.m2794b();
                if (b != null) {
                    b.a();
                    b.h();
                }
                if (this.f3127d.g() && !this.f3127d.i()) {
                    this.f3127d.b();
                }
                int seekPosition = videoPlayerView.getSeekPosition();
                this.f3124a.b(seekPosition);
                this.f3124a.a(seekPosition);
                Preconditions.checkArgument(view instanceof VideoTransitionNode);
                this.f3124a.h = (VideoTransitionNode) view;
                k.a(this.f3124a);
                VideoHomeLoggingUtils videoHomeLoggingUtils = this.f3130g;
                PlayerOrigin playerOrigin = PlayerOrigin.VIDEO_HOME;
                GraphQLVideo graphQLVideo = this.f3124a.a;
                if (graphQLVideo == null || !graphQLVideo.ae()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    clickTarget = ClickTarget.LIVE_VIDEO;
                } else {
                    clickTarget = ClickTarget.FULLSCREEN_VIDEO;
                }
                Builder builder = new Builder();
                builder.a = ((GraphQLStory) this.f3125b.a).c();
                Builder builder2 = builder;
                builder2.b = TrackableFeedProps.a(this.f3125b);
                builder2 = builder2;
                builder2.c = this.f3126c;
                builder2 = builder2;
                builder2.d = this.f3131h;
                videoHomeLoggingUtils.a(playerOrigin, clickTarget, builder2.a());
            }
            LogUtils.a(-1497394955, a);
        }
    }

    private static VideoHomePlayFullscreenVideoPartDefinition m2989b(InjectorLike injectorLike) {
        return new VideoHomePlayFullscreenVideoPartDefinition(FeedImageLoader.a(injectorLike), IdBasedLazy.a(injectorLike, 1817), VideoHomeSessionManager.a(injectorLike), VideoLoggingUtils.a(injectorLike), VideoHomeLoggingUtils.a(injectorLike));
    }

    public final Object m2990a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasVideoHomePersistentState hasVideoHomePersistentState = (HasVideoHomePersistentState) anyEnvironment;
        FeedProps feedProps = props.f3118a;
        FeedFullScreenParams a = m2987a(feedProps, hasVideoHomePersistentState);
        FeedProps e = AttachmentProps.e(feedProps);
        subParts.a((SinglePartDefinition) this.f3135b.get(), new com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition.Props(new VideoPlayerOnClickListener(a, e, props.f3119b, this.f3136c, hasVideoHomePersistentState.a(e, props.f3121d), this.f3137d, this.f3138e, props.f3120c)));
        return null;
    }

    public static VideoHomePlayFullscreenVideoPartDefinition m2988a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomePlayFullscreenVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3133g) {
                VideoHomePlayFullscreenVideoPartDefinition videoHomePlayFullscreenVideoPartDefinition;
                if (a2 != null) {
                    videoHomePlayFullscreenVideoPartDefinition = (VideoHomePlayFullscreenVideoPartDefinition) a2.a(f3133g);
                } else {
                    videoHomePlayFullscreenVideoPartDefinition = f3132f;
                }
                if (videoHomePlayFullscreenVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2989b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3133g, b3);
                        } else {
                            f3132f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomePlayFullscreenVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoHomePlayFullscreenVideoPartDefinition(FeedImageLoader feedImageLoader, Lazy<VideoZeroDialogPartDefinition> lazy, VideoHomeSessionManager videoHomeSessionManager, VideoLoggingUtils videoLoggingUtils, VideoHomeLoggingUtils videoHomeLoggingUtils) {
        this.f3134a = feedImageLoader;
        this.f3135b = lazy;
        this.f3136c = videoHomeSessionManager;
        this.f3137d = videoLoggingUtils;
        this.f3138e = videoHomeLoggingUtils;
    }

    private FeedFullScreenParams m2987a(FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        GraphQLVideo b = GraphQLMediaConversionHelper.b(graphQLStoryAttachment.r());
        PlayerOrigin a = FeedAnalyticsUtil.a(((HasFeedListType) e).c());
        ArrayNode a2 = TrackableFeedProps.a(feedProps);
        FeedProps e2 = AttachmentProps.e(feedProps);
        Preconditions.checkNotNull(e2);
        boolean p = StoryProps.p(e2);
        VideoFeedStoryInfo.Builder builder = new VideoFeedStoryInfo.Builder(a2);
        builder.d = p;
        VideoFeedStoryInfo a3 = builder.a();
        FeedFullScreenParams feedFullScreenParams = new FeedFullScreenParams(new VideoAnalyticsRequiredInfo.Builder(b.J()).a(), a3, this.f3134a.a(graphQLStoryAttachment.r(), FeedImageType.Video), b, feedProps);
        feedFullScreenParams.a(a);
        return feedFullScreenParams;
    }
}
