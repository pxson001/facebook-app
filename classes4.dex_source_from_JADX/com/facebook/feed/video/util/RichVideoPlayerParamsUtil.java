package com.facebook.feed.video.util;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.video.player.RichVideoPlayerParams;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: persistent_mqtt */
public class RichVideoPlayerParamsUtil {
    @Nullable
    public static GraphQLMedia m5428a(RichVideoPlayerParams richVideoPlayerParams) {
        FeedProps g = m5432g(richVideoPlayerParams);
        if (g == null) {
            return null;
        }
        GraphQLStory graphQLStory = (GraphQLStory) g.a;
        if (graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null) {
            return null;
        }
        return StoryAttachmentHelper.o(graphQLStory).r();
    }

    public static boolean m5430d(RichVideoPlayerParams richVideoPlayerParams) {
        return m5429a(m5428a(richVideoPlayerParams));
    }

    public static boolean m5429a(GraphQLMedia graphQLMedia) {
        return graphQLMedia != null && graphQLMedia.aq() && graphQLMedia.bv();
    }

    public static FeedProps<GraphQLStory> m5431f(RichVideoPlayerParams richVideoPlayerParams) {
        if (richVideoPlayerParams.m5356a()) {
            return null;
        }
        FeedProps g = m5432g(richVideoPlayerParams);
        if (g == null) {
            return null;
        }
        GraphQLStory graphQLStory = (GraphQLStory) g.a;
        if (graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).z() == null || StoryAttachmentHelper.o(graphQLStory).r() == null || !StoryAttachmentHelper.o(graphQLStory).r().ao()) {
            return null;
        }
        graphQLStory = StoryProps.d(g);
        if (graphQLStory.as() == null || graphQLStory.as().m() == GraphQLSavedState.NOT_SAVABLE || graphQLStory.as().m() == GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return null;
        }
        return FeedProps.c(graphQLStory);
    }

    public static FeedProps<GraphQLStory> m5432g(RichVideoPlayerParams richVideoPlayerParams) {
        if (richVideoPlayerParams.f4963b == null || !richVideoPlayerParams.f4963b.containsKey("GraphQLStoryProps")) {
            return null;
        }
        Object obj = richVideoPlayerParams.f4963b.get("GraphQLStoryProps");
        Preconditions.checkArgument(obj instanceof FeedProps);
        return (FeedProps) obj;
    }
}
