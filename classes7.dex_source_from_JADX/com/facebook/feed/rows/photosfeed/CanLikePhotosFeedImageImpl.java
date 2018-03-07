package com.facebook.feed.rows.photosfeed;

import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedback.ui.FeedbackControllerParams;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import java.util.concurrent.Callable;

/* compiled from: activity_id */
public class CanLikePhotosFeedImageImpl implements CanLikePhotosFeedImage {
    private static final String f20010a = CanLikePhotosFeedImageImpl.class.getSimpleName();
    private final FeedbackControllerProvider f20011b;
    private Callable<FeedProps<GraphQLStory>> f20012c;
    private AbstractFbErrorReporter f20013d;

    public CanLikePhotosFeedImageImpl(FeedbackControllerProvider feedbackControllerProvider, Callable<FeedProps<GraphQLStory>> callable, FbErrorReporter fbErrorReporter) {
        this.f20011b = feedbackControllerProvider;
        this.f20012c = callable;
        this.f20013d = fbErrorReporter;
    }

    public final void mo1485a(GraphQLFeedback graphQLFeedback) {
        try {
            this.f20011b.m5074a(FeedbackControllerParams.f4498a).m5067a(graphQLFeedback, new Builder().b("photos_feed").a("photos_feed_ufi").a(TrackableFeedProps.a((FeedProps) this.f20012c.call())).a());
        } catch (Throwable e) {
            this.f20013d.b(f20010a, "mStoryCallable threw an exception", e);
        }
    }
}
