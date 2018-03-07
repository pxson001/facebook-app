package com.facebook.feedback.ui;

import android.content.Context;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.feedback.ui.CommentView.NavigationListener;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: right_value */
public class ThreadedParentCommentNavigationDelegate implements NavigationListener {
    private final BaseCommentNavigationDelegate f4776a;
    private final CommentsHelper f4777b;
    private GraphQLFeedback f4778c;

    public final void mo198a(Object obj) {
        this.f4778c = (GraphQLFeedback) obj;
    }

    @Inject
    public ThreadedParentCommentNavigationDelegate(@Assisted BaseCommentNavigationDelegate baseCommentNavigationDelegate, @Assisted CommentsHelper commentsHelper) {
        this.f4776a = baseCommentNavigationDelegate;
        this.f4777b = commentsHelper;
    }

    public final void mo268a(GraphQLComment graphQLComment, FeedbackLoggingParams feedbackLoggingParams) {
        this.f4777b.m4971f();
    }

    public final void mo271b(GraphQLComment graphQLComment, FeedbackLoggingParams feedbackLoggingParams) {
    }

    public final void mo269a(GraphQLComment graphQLComment, GraphQLComment graphQLComment2, FeedbackLoggingParams feedbackLoggingParams) {
    }

    public final void mo266a(GraphQLComment graphQLComment) {
        this.f4776a.m4709a(graphQLComment, this.f4778c);
    }

    public final void mo270b(GraphQLComment graphQLComment) {
        this.f4776a.m4707a(graphQLComment);
    }

    public final void mo272c(GraphQLComment graphQLComment) {
        this.f4776a.mo226b(graphQLComment);
    }

    public final void mo267a(GraphQLComment graphQLComment, Context context, String str, String str2) {
        this.f4776a.mo223a(context, str, str2);
    }
}
