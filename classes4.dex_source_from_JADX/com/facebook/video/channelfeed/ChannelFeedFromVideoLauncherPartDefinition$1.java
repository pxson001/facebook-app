package com.facebook.video.channelfeed;

import com.facebook.graphql.model.GraphQLStory;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: photosync */
class ChannelFeedFromVideoLauncherPartDefinition$1 implements Function<GraphQLStory, Boolean> {
    final /* synthetic */ ChannelFeedFromVideoLauncherPartDefinition f5075a;

    ChannelFeedFromVideoLauncherPartDefinition$1(ChannelFeedFromVideoLauncherPartDefinition channelFeedFromVideoLauncherPartDefinition) {
        this.f5075a = channelFeedFromVideoLauncherPartDefinition;
    }

    public Object apply(@Nullable Object obj) {
        return Boolean.valueOf(((GraphQLStory) obj).L() != null);
    }

    public boolean equals(@Nullable Object obj) {
        return false;
    }
}
