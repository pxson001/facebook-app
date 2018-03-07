package com.facebook.feedback.ui;

import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.AbstractAssistedProvider;
import com.google.common.base.Function;

/* compiled from: routeName */
public class NestedFeedbackEventSubscriberProvider extends AbstractAssistedProvider<NestedFeedbackEventSubscriber> {
    public final NestedFeedbackEventSubscriber m5173a(Function<GraphQLFeedback, Void> function, CommentAdapter commentAdapter, CommentListScrollStateController commentListScrollStateController, FeedbackNewCommentsPillController feedbackNewCommentsPillController, FeedbackTypingPillController feedbackTypingPillController) {
        return new NestedFeedbackEventSubscriber(function, commentAdapter, commentListScrollStateController, feedbackNewCommentsPillController, feedbackTypingPillController, (RootFeedbackEventSubscriberProvider) getOnDemandAssistedProviderForStaticDi(RootFeedbackEventSubscriberProvider.class), (CommentFeedbackEventSubscriberProvider) getOnDemandAssistedProviderForStaticDi(CommentFeedbackEventSubscriberProvider.class), FeedbackMutator.a(this));
    }
}
