package com.facebook.feed.rows.core.props;

import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.FeedAttachable;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import javax.annotation.Nullable;

/* compiled from: hits */
public class AttachmentProps {
    public static FeedProps<GraphQLStoryAttachment> m28711a(GraphQLStory graphQLStory) {
        return FeedProps.m19802c(graphQLStory).m19803a(StoryAttachmentHelper.m28042o(graphQLStory));
    }

    @Nullable
    public static GraphQLStory m28712a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory graphQLStory = null;
        for (FeedProps feedProps2 = feedProps.f13445b; feedProps2 != null; feedProps2 = feedProps2.f13445b) {
            if (feedProps2.f13444a instanceof GraphQLStory) {
                graphQLStory = (GraphQLStory) feedProps2.f13444a;
            }
        }
        return graphQLStory;
    }

    @Nullable
    public static GraphQLStory m28714c(FeedProps<GraphQLStoryAttachment> feedProps) {
        return m28713a(feedProps, 1);
    }

    @Nullable
    public static GraphQLStory m28713a(FeedProps<GraphQLStoryAttachment> feedProps, int i) {
        int i2 = 0;
        FeedProps feedProps2 = feedProps.f13445b;
        while (feedProps2 != null) {
            Flattenable flattenable = feedProps2.f13444a;
            if (flattenable instanceof GraphQLStory) {
                i2++;
                if (i2 == i) {
                    return (GraphQLStory) flattenable;
                }
            } else if (!(flattenable instanceof GraphQLStoryAttachment)) {
                return null;
            }
            int i3 = i2;
            feedProps2 = feedProps2.f13445b;
            i2 = i3;
        }
        return null;
    }

    @Nullable
    public static FeedUnit m28716f(FeedProps<GraphQLStoryAttachment> feedProps) {
        Flattenable c = feedProps.m19807c();
        if (c == null || !(c instanceof FeedUnit)) {
            return null;
        }
        return (FeedUnit) c;
    }

    @Nullable
    public static GraphQLComment m28718h(FeedProps<GraphQLStoryAttachment> feedProps) {
        Flattenable c = feedProps.m19807c();
        return (c == null || !(c instanceof GraphQLComment)) ? null : (GraphQLComment) c;
    }

    @Nullable
    public static FeedProps<GraphQLStory> m28715e(FeedProps<GraphQLStoryAttachment> feedProps) {
        for (FeedProps<GraphQLStory> feedProps2 = feedProps.f13445b; feedProps2 != null; feedProps2 = feedProps2.f13445b) {
            if (feedProps2.f13444a instanceof GraphQLStory) {
                return feedProps2;
            }
        }
        return null;
    }

    @Nullable
    public static FeedProps<? extends FeedAttachable> m28717g(FeedProps<GraphQLStoryAttachment> feedProps) {
        for (FeedProps<? extends FeedAttachable> feedProps2 = feedProps.f13445b; feedProps2 != null; feedProps2 = feedProps2.f13445b) {
            if (feedProps2.f13444a instanceof FeedAttachable) {
                return feedProps2;
            }
        }
        return null;
    }
}
