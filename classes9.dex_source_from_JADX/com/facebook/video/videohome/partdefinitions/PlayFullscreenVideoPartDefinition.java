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
/* compiled from: snippet_cs */
public class PlayFullscreenVideoPartDefinition<V extends View & VideoPlayerView & VideoTransitionNode, E extends HasVideoHomePersistentState & HasFeedListType> extends BaseSinglePartDefinition<Props, Void, E, V> {
    private static PlayFullscreenVideoPartDefinition f3005f;
    private static final Object f3006g = new Object();
    public final FeedImageLoader f3007a;
    private final Lazy<VideoZeroDialogPartDefinition> f3008b;
    private final VideoHomeSessionManager f3009c;
    private final VideoLoggingUtils f3010d;
    private final VideoHomeLoggingUtils f3011e;

    /* compiled from: snippet_cs */
    public final class Props {
        public final FeedProps<GraphQLStoryAttachment> f2991a;
        public final String f2992b;
        public final int f2993c;
        public final String f2994d;
    }

    /* compiled from: snippet_cs */
    public class VideoPlayerOnClickListener implements OnClickListener {
        public final FeedFullScreenParams f2997a;
        private final FeedProps<GraphQLStory> f2998b;
        private final String f2999c;
        public final VideoHomeSessionManager f3000d;
        public final VideoHomeStoryPersistentState f3001e;
        public final VideoLoggingUtils f3002f;
        private final VideoHomeLoggingUtils f3003g;
        private final int f3004h;

        public VideoPlayerOnClickListener(FeedFullScreenParams feedFullScreenParams, FeedProps<GraphQLStory> feedProps, String str, VideoHomeSessionManager videoHomeSessionManager, VideoHomeStoryPersistentState videoHomeStoryPersistentState, VideoLoggingUtils videoLoggingUtils, VideoHomeLoggingUtils videoHomeLoggingUtils, int i) {
            this.f2997a = feedFullScreenParams;
            this.f2998b = feedProps;
            this.f2999c = str;
            this.f3000d = videoHomeSessionManager;
            this.f3001e = videoHomeStoryPersistentState;
            this.f3002f = videoLoggingUtils;
            this.f3003g = videoHomeLoggingUtils;
            this.f3004h = i;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -938191815);
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
                    final /* synthetic */ VideoPlayerOnClickListener f2996b;

                    public final void m2886a(EventTriggerType eventTriggerType) {
                        if (!k.g()) {
                            this.f2996b.f3002f.b(this.f2996b.f2997a.m(), PlayerType.INLINE_PLAYER.value, eventTriggerType.value, this.f2996b.f2997a.j(), this.f2996b.f2997a.r(), this.f2996b.f2997a.d.b, this.f2996b.f2997a.o(), this.f2996b.f2997a);
                        }
                    }

                    public final void m2887a(EventTriggerType eventTriggerType, ExitFullScreenResult exitFullScreenResult) {
                        this.f2996b.f3001e.m2793a(exitFullScreenResult.c);
                        AutoplayStateManager b = this.f2996b.f3001e.m2794b();
                        if (b != null) {
                            b.a(exitFullScreenResult.b, exitFullScreenResult.a);
                        }
                        if (!k.g()) {
                            this.f2996b.f3002f.a(this.f2996b.f2997a.m(), PlayerType.INLINE_PLAYER.value, eventTriggerType.value, exitFullScreenResult.c, this.f2996b.f2997a.r(), this.f2996b.f2997a.d.b, this.f2996b.f2997a.o(), this.f2996b.f2997a);
                        }
                        if (this.f2996b.f3000d.g() && this.f2996b.f3000d.i()) {
                            this.f2996b.f3000d.c();
                        }
                    }
                });
                AutoplayStateManager b = this.f3001e.m2794b();
                if (b != null) {
                    b.a();
                    b.h();
                }
                if (this.f3000d.g() && !this.f3000d.i()) {
                    this.f3000d.b();
                }
                int seekPosition = videoPlayerView.getSeekPosition();
                this.f2997a.b(seekPosition);
                this.f2997a.a(seekPosition);
                Preconditions.checkArgument(view instanceof VideoTransitionNode);
                this.f2997a.h = (VideoTransitionNode) view;
                k.a(this.f2997a);
                VideoHomeLoggingUtils videoHomeLoggingUtils = this.f3003g;
                PlayerOrigin playerOrigin = PlayerOrigin.VIDEO_HOME;
                GraphQLVideo graphQLVideo = this.f2997a.a;
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
                builder.a = ((GraphQLStory) this.f2998b.a).c();
                Builder builder2 = builder;
                builder2.b = TrackableFeedProps.a(this.f2998b);
                builder2 = builder2;
                builder2.c = this.f2999c;
                builder2 = builder2;
                builder2.d = this.f3004h;
                videoHomeLoggingUtils.a(playerOrigin, clickTarget, builder2.a());
            }
            LogUtils.a(-821562480, a);
        }
    }

    private static PlayFullscreenVideoPartDefinition m2890b(InjectorLike injectorLike) {
        return new PlayFullscreenVideoPartDefinition(FeedImageLoader.a(injectorLike), IdBasedLazy.a(injectorLike, 1817), VideoHomeSessionManager.a(injectorLike), VideoLoggingUtils.a(injectorLike), VideoHomeLoggingUtils.a(injectorLike));
    }

    public final Object m2891a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasVideoHomePersistentState hasVideoHomePersistentState = (HasVideoHomePersistentState) anyEnvironment;
        FeedProps feedProps = props.f2991a;
        FeedFullScreenParams a = m2888a(feedProps, hasVideoHomePersistentState);
        FeedProps e = AttachmentProps.e(feedProps);
        subParts.a((SinglePartDefinition) this.f3008b.get(), new com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition.Props(new VideoPlayerOnClickListener(a, e, props.f2992b, this.f3009c, hasVideoHomePersistentState.a(e, props.f2994d), this.f3010d, this.f3011e, props.f2993c)));
        return null;
    }

    public static PlayFullscreenVideoPartDefinition m2889a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlayFullscreenVideoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3006g) {
                PlayFullscreenVideoPartDefinition playFullscreenVideoPartDefinition;
                if (a2 != null) {
                    playFullscreenVideoPartDefinition = (PlayFullscreenVideoPartDefinition) a2.a(f3006g);
                } else {
                    playFullscreenVideoPartDefinition = f3005f;
                }
                if (playFullscreenVideoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2890b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3006g, b3);
                        } else {
                            f3005f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = playFullscreenVideoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PlayFullscreenVideoPartDefinition(FeedImageLoader feedImageLoader, Lazy<VideoZeroDialogPartDefinition> lazy, VideoHomeSessionManager videoHomeSessionManager, VideoLoggingUtils videoLoggingUtils, VideoHomeLoggingUtils videoHomeLoggingUtils) {
        this.f3007a = feedImageLoader;
        this.f3008b = lazy;
        this.f3009c = videoHomeSessionManager;
        this.f3010d = videoLoggingUtils;
        this.f3011e = videoHomeLoggingUtils;
    }

    private FeedFullScreenParams m2888a(FeedProps<GraphQLStoryAttachment> feedProps, E e) {
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
        FeedFullScreenParams feedFullScreenParams = new FeedFullScreenParams(new VideoAnalyticsRequiredInfo.Builder(b.J()).a(), a3, this.f3007a.a(graphQLStoryAttachment.r(), FeedImageType.Video), b, feedProps);
        feedFullScreenParams.a(a);
        return feedFullScreenParams;
    }
}
