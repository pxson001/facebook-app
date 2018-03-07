package com.facebook.feedback.ui;

import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTopLevelCommentsConnection;
import com.facebook.inject.Assisted;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import javax.inject.Inject;

/* compiled from: selectedPublishMode */
public class CommentAdapter extends MultiAdapterListAdapter implements Bindable<FeedProps<GraphQLFeedback>> {
    public final SingleSegmentCommentAdapter f4169a;
    public final SingleSegmentCommentAdapter f4170b;
    private final TypingIndicatorAdapter f4171c;
    public final FeedbackMutator f4172d;
    public FeedProps<GraphQLFeedback> f4173e;
    public SingleSegmentCommentAdapter f4174f = this.f4170b;

    public final void mo198a(Object obj) {
        GraphQLFeedback graphQLFeedback;
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps == null) {
            this.f4173e = null;
        } else {
            GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection;
            if (this.f4173e == null) {
                graphQLTopLevelCommentsConnection = GraphQLHelper.f;
            } else {
                graphQLTopLevelCommentsConnection = ((GraphQLFeedback) this.f4173e.a).L();
            }
            Builder a = Builder.a((GraphQLFeedback) feedProps.a);
            a.L = graphQLTopLevelCommentsConnection;
            this.f4173e = feedProps.b(this.f4172d.c(a.a(), (GraphQLFeedback) feedProps.a));
        }
        if (feedProps != null) {
            graphQLFeedback = (GraphQLFeedback) feedProps.a;
        } else {
            graphQLFeedback = null;
        }
        if (CommentOrderType.getOrder(graphQLFeedback) == CommentOrderType.RANKED_ORDER) {
            this.f4169a.mo198a(this.f4173e);
            this.f4170b.mo198a(feedProps);
            this.f4174f = this.f4169a;
            return;
        }
        this.f4169a.mo198a(feedProps);
        this.f4170b.mo198a(this.f4173e);
        this.f4174f = this.f4170b;
    }

    @Inject
    public CommentAdapter(@Assisted SingleSegmentCommentAdapter singleSegmentCommentAdapter, @Assisted SingleSegmentCommentAdapter singleSegmentCommentAdapter2, @Assisted TypingIndicatorAdapter typingIndicatorAdapter, FeedbackMutator feedbackMutator) {
        super(false, new FbListAdapter[]{singleSegmentCommentAdapter, singleSegmentCommentAdapter2, typingIndicatorAdapter});
        this.f4169a = singleSegmentCommentAdapter;
        this.f4170b = singleSegmentCommentAdapter2;
        this.f4171c = typingIndicatorAdapter;
        this.f4172d = feedbackMutator;
        Builder builder = new Builder();
        builder.L = GraphQLHelper.f;
        this.f4173e = FeedProps.c(builder.a());
    }

    public final GraphQLComment m4796c(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        if (i < this.f4169a.getCount()) {
            return this.f4169a.mo205a(i);
        }
        return this.f4170b.mo205a(i - this.f4169a.getCount());
    }

    public final void m4797d(int i) {
        this.f4171c.m5323a(Integer.valueOf(i));
    }

    public final void m4793a(GraphQLComment graphQLComment) {
        if (graphQLComment != null) {
            m4795a(graphQLComment.y());
        }
    }

    public final void m4795a(String str) {
        this.f4169a.mo208a(str);
        this.f4170b.mo208a(str);
    }

    public final void m4792a(FeedbackLoggingParams feedbackLoggingParams) {
        this.f4169a.mo206a(feedbackLoggingParams);
        this.f4170b.mo206a(feedbackLoggingParams);
    }
}
