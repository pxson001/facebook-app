package com.facebook.feedplugins.video;

import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.video.FeedFullScreenParams;
import com.facebook.feed.video.ImmersiveVideoPlayer;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.VideoSizer$VideoSize;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.video.abtest.AutoplayFeedRunnableConfig;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.RichVideoPlayerParams;
import java.util.HashSet;
import java.util.Set;

/* compiled from: pic */
public final class RichVideoPlayerPartDefinition$State {
    public RichVideoAttachmentView f4969a;
    public final GraphQLStoryAttachment f4970b;
    public final FeedProps<GraphQLStory> f4971c;
    public final boolean f4972d;
    public final GraphQLVideo f4973e;
    public final PlayerOrigin f4974f;
    public final VideoFeedStoryInfo f4975g;
    public final RichVideoPlayerParams f4976h;
    public final AutoplayStateManager f4977i;
    public final InlineVideoPersistentState f4978j;
    public final VideoDisplayedInfo f4979k = new VideoDisplayedInfo();
    public final Set<AutoPlayFailureReason> f4980l = new HashSet();
    public final RichVideoPlayerCallbackListener f4981m;
    public final ImageRequest f4982n;
    public final FeedFullScreenParams f4983o;
    public final VideoSizer$VideoSize f4984p;
    public boolean f4985q;
    public boolean f4986r;
    public AutoplayFeedRunnableConfig f4987s;
    public ImmersiveVideoPlayer f4988t;
    public RichVideoPlayerPartDefinition$FullscreenListener f4989u;

    public RichVideoPlayerPartDefinition$State(GraphQLStoryAttachment graphQLStoryAttachment, FeedProps<GraphQLStory> feedProps, GraphQLVideo graphQLVideo, boolean z, PlayerOrigin playerOrigin, VideoFeedStoryInfo videoFeedStoryInfo, RichVideoPlayerParams richVideoPlayerParams, AutoplayStateManager autoplayStateManager, InlineVideoPersistentState inlineVideoPersistentState, RichVideoPlayerCallbackListener richVideoPlayerCallbackListener, ImageRequest imageRequest, FeedFullScreenParams feedFullScreenParams, VideoSizer$VideoSize videoSizer$VideoSize, AutoplayFeedRunnableConfig autoplayFeedRunnableConfig) {
        this.f4970b = graphQLStoryAttachment;
        this.f4971c = feedProps;
        this.f4973e = graphQLVideo;
        this.f4972d = z;
        this.f4974f = playerOrigin;
        this.f4975g = videoFeedStoryInfo;
        this.f4976h = richVideoPlayerParams;
        this.f4977i = autoplayStateManager;
        this.f4978j = inlineVideoPersistentState;
        this.f4981m = richVideoPlayerCallbackListener;
        this.f4982n = imageRequest;
        this.f4983o = feedFullScreenParams;
        this.f4984p = videoSizer$VideoSize;
        this.f4987s = autoplayFeedRunnableConfig;
    }
}
