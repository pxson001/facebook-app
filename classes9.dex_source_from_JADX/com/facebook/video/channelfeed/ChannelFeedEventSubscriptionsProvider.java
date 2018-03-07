package com.facebook.video.channelfeed;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.google.common.base.Function;

/* compiled from: task_key_fetch_local_awareness_data */
public class ChannelFeedEventSubscriptionsProvider extends AbstractAssistedProvider<ChannelFeedEventSubscriptions> {
    public final ChannelFeedEventSubscriptions m2153a(Function<GraphQLStory, Void> function) {
        return new ChannelFeedEventSubscriptions(function, FeedStoryMutator.b(this), IdBasedSingletonScopeProvider.a(this, 262), (Clock) SystemClockMethodAutoProvider.a(this), ReactionsMutationController.a(this), FeedbackReactionsController.a(this));
    }
}
