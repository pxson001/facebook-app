package com.facebook.video.channelfeed;

import com.facebook.graphql.model.BaseFeedUnit;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: success_puback */
public class MultiShareChannelStoryUnit extends BaseFeedUnit {
    public final GraphQLStory f2635a;
    public Type f2636b;

    /* compiled from: success_puback */
    public enum Type {
        FIRST,
        LAST,
        NORMAL
    }

    public MultiShareChannelStoryUnit(GraphQLStory graphQLStory, Type type) {
        this.f2635a = graphQLStory;
        this.f2636b = type;
    }
}
