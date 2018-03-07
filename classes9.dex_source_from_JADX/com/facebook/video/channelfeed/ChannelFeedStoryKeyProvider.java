package com.facebook.video.channelfeed;

import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: surge_user_input_threshold */
public class ChannelFeedStoryKeyProvider extends AbstractAssistedProvider<ChannelFeedStoryKey> {
    public final ChannelFeedStoryKey m2425a(FeedProps<GraphQLStory> feedProps, GraphQLVideo graphQLVideo) {
        return new ChannelFeedStoryKey(feedProps, graphQLVideo, (AutoplayStateManagerProvider) getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), (ChannelFeedVideoControllerProvider) getOnDemandAssistedProviderForStaticDi(ChannelFeedVideoControllerProvider.class), (ChannelFeedDimmingControllerProvider) getOnDemandAssistedProviderForStaticDi(ChannelFeedDimmingControllerProvider.class));
    }
}
