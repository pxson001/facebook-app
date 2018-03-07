package com.facebook.api.feedcache.memory.visitor;

import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: approximate_location */
public class AddCommentCacheVisitor extends PayloadVisitor<GraphQLComment> {
    private final FeedbackMutator f8830a;
    private final String f8831b;

    @Inject
    public AddCommentCacheVisitor(FeedbackMutator feedbackMutator, @Assisted GraphQLComment graphQLComment, @Assisted String str) {
        super(str, graphQLComment);
        this.f8830a = feedbackMutator;
        this.f8831b = str;
    }

    public final GraphQLFeedback m14706a(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null || !this.f8831b.equals(graphQLFeedback.j()) || GraphQLHelper.e(graphQLFeedback) || !GraphQLHelper.c(graphQLFeedback)) {
            return graphQLFeedback;
        }
        return this.f8830a.a(graphQLFeedback, (GraphQLComment) this.a);
    }
}
