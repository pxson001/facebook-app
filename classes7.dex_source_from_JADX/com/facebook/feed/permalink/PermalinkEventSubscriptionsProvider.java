package com.facebook.feed.permalink;

import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.ui.controllers.SeeMoreController;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.ui.CommentsHelper;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.notifications.provider.GraphQLNotificationsContentProviderHelper;
import com.google.common.base.Function;

/* compiled from: after_poll_option_voters */
public class PermalinkEventSubscriptionsProvider extends AbstractAssistedProvider<PermalinkEventSubscriptions> {
    public final PermalinkEventSubscriptions m22891a(Function<GraphQLStory, Void> function, CommentsHelper commentsHelper) {
        return new PermalinkEventSubscriptions(function, commentsHelper, FeedbackAnalyticsLogger.a(this), (FeedbackControllerProvider) getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), FeedStoryMutator.b(this), GraphQLNotificationsContentProviderHelper.a(this), PermalinkController.m22876b(this), SeeMoreController.a(this), IdBasedSingletonScopeProvider.a(this, 262), ReactionsMutationController.a(this));
    }
}
