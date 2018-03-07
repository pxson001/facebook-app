package com.facebook.feedback.ui.environment;

import android.content.Context;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.feedback.ui.BaseCommentNavigationDelegate;
import com.facebook.feedback.ui.CommentView.NavigationListener;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;

/* compiled from: ridge_tooltip_nux_impression_count */
public class CommentNavigationDelegateListener implements NavigationListener {
    private final BaseCommentNavigationDelegate f4817a;
    private GraphQLFeedback f4818b;

    public final void mo198a(Object obj) {
        this.f4818b = (GraphQLFeedback) obj;
    }

    public CommentNavigationDelegateListener(BaseCommentNavigationDelegate baseCommentNavigationDelegate) {
        this.f4817a = baseCommentNavigationDelegate;
    }

    public final void mo266a(GraphQLComment graphQLComment) {
        this.f4817a.m4709a(graphQLComment, this.f4818b);
    }

    public final void mo268a(GraphQLComment graphQLComment, FeedbackLoggingParams feedbackLoggingParams) {
        this.f4817a.mo225a(graphQLComment, this.f4818b, feedbackLoggingParams);
    }

    public final void mo271b(GraphQLComment graphQLComment, FeedbackLoggingParams feedbackLoggingParams) {
        this.f4817a.mo227b(graphQLComment, this.f4818b, feedbackLoggingParams);
    }

    public final void mo269a(GraphQLComment graphQLComment, GraphQLComment graphQLComment2, FeedbackLoggingParams feedbackLoggingParams) {
        this.f4817a.mo224a(graphQLComment, graphQLComment2, this.f4818b, feedbackLoggingParams);
    }

    public final void mo270b(GraphQLComment graphQLComment) {
        this.f4817a.m4707a(graphQLComment);
    }

    public final void mo272c(GraphQLComment graphQLComment) {
        this.f4817a.mo226b(graphQLComment);
    }

    public final void mo267a(GraphQLComment graphQLComment, Context context, String str, String str2) {
        this.f4817a.mo223a(context, str, str2);
    }
}
