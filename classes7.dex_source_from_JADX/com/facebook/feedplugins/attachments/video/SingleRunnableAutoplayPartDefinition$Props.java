package com.facebook.feedplugins.attachments.video;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.VideoPlayerParams;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: TEXT_ENTRY */
public final class SingleRunnableAutoplayPartDefinition$Props {
    public final InlineVideoStoryKey f22840a;
    public final GraphQLStory f22841b;
    public final VideoDisplayedInfo f22842c;
    public final VideoPlayerParams f22843d;
    public final VideoFeedStoryInfo f22844e;
    public final PlayerOrigin f22845f;
    public final SingleRunnableAutoplayPartDefinition$VideoViewControllerProvider f22846g;

    public SingleRunnableAutoplayPartDefinition$Props(InlineVideoStoryKey inlineVideoStoryKey, GraphQLStory graphQLStory, VideoDisplayedInfo videoDisplayedInfo, VideoPlayerParams videoPlayerParams, VideoFeedStoryInfo videoFeedStoryInfo, PlayerOrigin playerOrigin, SingleRunnableAutoplayPartDefinition$VideoViewControllerProvider singleRunnableAutoplayPartDefinition$VideoViewControllerProvider) {
        this.f22840a = inlineVideoStoryKey;
        this.f22841b = graphQLStory;
        this.f22842c = videoDisplayedInfo;
        this.f22843d = videoPlayerParams;
        this.f22844e = videoFeedStoryInfo;
        this.f22845f = playerOrigin;
        this.f22846g = singleRunnableAutoplayPartDefinition$VideoViewControllerProvider;
    }
}
