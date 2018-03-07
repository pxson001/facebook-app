package com.facebook.feed.rows.photosfeed;

import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import java.util.concurrent.Callable;

/* compiled from: active client bits */
public class CanReactToPhotosFeedImageImpl implements CanReactToPhotosFeeedImage {
    private static final String f20014a = CanReactToPhotosFeedImageImpl.class.getSimpleName();
    private final ReactionsMutationController f20015b;
    private final Callable<FeedProps<GraphQLStory>> f20016c;
    private final AbstractFbErrorReporter f20017d;

    public CanReactToPhotosFeedImageImpl(ReactionsMutationController reactionsMutationController, Callable<FeedProps<GraphQLStory>> callable, FbErrorReporter fbErrorReporter) {
        this.f20015b = reactionsMutationController;
        this.f20016c = callable;
        this.f20017d = fbErrorReporter;
    }

    public final void mo1486a(GraphQLFeedback graphQLFeedback, FeedbackReaction feedbackReaction, DisposableFutureCallback disposableFutureCallback) {
        try {
            this.f20015b.a(graphQLFeedback, feedbackReaction, new Builder().b("photos_feed").a("photos_feed_ufi").a(TrackableFeedProps.a((FeedProps) this.f20016c.call())).a(), disposableFutureCallback);
        } catch (Throwable e) {
            this.f20017d.b(f20014a, "mStoryCallable threw an exception", e);
        }
    }
}
