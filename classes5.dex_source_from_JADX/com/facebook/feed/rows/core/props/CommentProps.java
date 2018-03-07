package com.facebook.feed.rows.core.props;

import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: WWW_SEARCH_LOCAL_RECENT */
public class CommentProps {
    @Nullable
    public static GraphQLFeedback m20299b(FeedProps<GraphQLComment> feedProps) {
        ImmutableList d = feedProps.d();
        for (int i = 0; i < d.size(); i++) {
            Flattenable flattenable = (Flattenable) d.get(i);
            if (flattenable instanceof GraphQLFeedback) {
                return (GraphQLFeedback) flattenable;
            }
        }
        return null;
    }
}
