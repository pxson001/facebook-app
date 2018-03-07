package com.facebook.feedback.ui.environment;

import android.content.Context;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.feedback.ui.CommentDelegate;
import com.facebook.feedback.ui.CommentView.ActionListener;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.ufiservices.ui.FbCommentView;

/* compiled from: ridge_tooltip_nux_impressions */
public class CommentDelegateActionListener implements ActionListener {
    public final CommentDelegate f4815a;
    public GraphQLFeedback f4816b;

    public CommentDelegateActionListener(CommentDelegate commentDelegate) {
        this.f4815a = commentDelegate;
    }

    public final void mo275a(GraphQLComment graphQLComment, FbCommentView fbCommentView) {
        this.f4815a.f4224a.a(graphQLComment.y(), fbCommentView);
    }

    public final void mo273a(GraphQLComment graphQLComment) {
        this.f4815a.m4852a(graphQLComment, this.f4816b);
    }

    public final void mo277b(GraphQLComment graphQLComment) {
        this.f4815a.m4855b(graphQLComment, this.f4816b);
    }

    public final void mo274a(GraphQLComment graphQLComment, Context context) {
        this.f4815a.m4853a(graphQLComment, this.f4816b, context);
    }

    public final void mo276a(String str, GraphQLComment graphQLComment, Context context) {
        this.f4815a.m4854a(str, graphQLComment, context);
    }

    public final void mo278b(GraphQLComment graphQLComment, Context context) {
        this.f4815a.m4851a(graphQLComment, context);
    }

    public final void m5349a(FeedbackLoggingParams feedbackLoggingParams) {
        this.f4815a.f4248y = feedbackLoggingParams;
    }
}
