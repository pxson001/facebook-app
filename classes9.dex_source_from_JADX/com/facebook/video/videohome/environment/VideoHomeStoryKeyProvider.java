package com.facebook.video.videohome.environment;

import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.video.channelfeed.ChannelFeedDimmingControllerProvider;

/* compiled from: startSmsHandling */
public class VideoHomeStoryKeyProvider extends AbstractAssistedProvider<VideoHomeStoryKey> {
    public final VideoHomeStoryKey m2791a(FeedProps<GraphQLStory> feedProps, GraphQLVideo graphQLVideo, String str) {
        return new VideoHomeStoryKey(feedProps, graphQLVideo, str, (AutoplayStateManagerProvider) getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), (ChannelFeedDimmingControllerProvider) getOnDemandAssistedProviderForStaticDi(ChannelFeedDimmingControllerProvider.class));
    }
}
