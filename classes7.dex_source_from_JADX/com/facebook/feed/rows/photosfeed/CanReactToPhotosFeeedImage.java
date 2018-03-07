package com.facebook.feed.rows.photosfeed;

import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.multirow.api.AnyEnvironment;

/* compiled from: activeScan */
public interface CanReactToPhotosFeeedImage extends AnyEnvironment {
    void mo1486a(GraphQLFeedback graphQLFeedback, FeedbackReaction feedbackReaction, DisposableFutureCallback disposableFutureCallback);
}
