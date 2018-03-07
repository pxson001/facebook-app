package com.facebook.feed.rows.photosfeed;

import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import com.google.common.base.Function;

/* compiled from: aTexCoord */
public class PhotosFeedEventSubscriptionsProvider extends AbstractAssistedProvider<PhotosFeedEventSubscriptions> {
    public final PhotosFeedEventSubscriptions m23347a(Function<GraphQLStory, Void> function) {
        return new PhotosFeedEventSubscriptions(function, (FeedbackControllerProvider) getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), ReactionsMutationController.a(this));
    }
}
