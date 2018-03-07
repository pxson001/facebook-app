package com.facebook.feed.permalink;

import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feedback.ui.RootFeedbackEventSubscriberProvider;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import com.google.common.base.Function;

/* compiled from: admin_tapped_video */
public class PermalinkSubstoryFeedbackEventSubscriberProvider extends AbstractAssistedProvider<PermalinkSubstoryFeedbackEventSubscriber> {
    public final PermalinkSubstoryFeedbackEventSubscriber m22915a(Function<GraphQLStory, Void> function) {
        return new PermalinkSubstoryFeedbackEventSubscriber(function, (RootFeedbackEventSubscriberProvider) getOnDemandAssistedProviderForStaticDi(RootFeedbackEventSubscriberProvider.class), FeedStoryMutator.b(this));
    }
}
