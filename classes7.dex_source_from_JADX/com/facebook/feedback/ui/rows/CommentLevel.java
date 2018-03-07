package com.facebook.feedback.ui.rows;

import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.google.common.collect.ImmutableList;

/* compiled from: ridge_opt_in_nux_activity_created */
public enum CommentLevel {
    TOP_LEVEL,
    THREADED;

    public static CommentLevel getCommentLevel(FeedProps<GraphQLComment> feedProps) {
        GraphQLComment graphQLComment;
        ImmutableList d = feedProps.d();
        for (int i = 0; i < d.size(); i++) {
            Flattenable flattenable = (Flattenable) d.get(i);
            if (flattenable instanceof GraphQLComment) {
                graphQLComment = (GraphQLComment) flattenable;
                break;
            }
        }
        graphQLComment = null;
        return graphQLComment != null ? THREADED : TOP_LEVEL;
    }

    public static CommentLevel getCommentLevelFromAttachment(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLComment h = AttachmentProps.h(feedProps);
        GraphQLComment graphQLComment = null;
        for (FeedProps feedProps2 = feedProps.b; feedProps2 != null; feedProps2 = feedProps2.b) {
            if (feedProps2.a instanceof GraphQLComment) {
                graphQLComment = (GraphQLComment) feedProps2.a;
            }
        }
        return h != graphQLComment ? THREADED : TOP_LEVEL;
    }
}
