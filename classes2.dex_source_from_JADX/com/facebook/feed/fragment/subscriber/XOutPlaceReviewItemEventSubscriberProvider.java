package com.facebook.feed.fragment.subscriber;

import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;

/* compiled from: png */
public class XOutPlaceReviewItemEventSubscriberProvider extends AbstractAssistedProvider<XOutPlaceReviewItemEventSubscriber> {
    public final XOutPlaceReviewItemEventSubscriber m14510a(NewsFeedFragment newsFeedFragment) {
        return new XOutPlaceReviewItemEventSubscriber(DefaultBlueServiceOperationFactory.m3782b(this), FeedEventBus.m4573a(this), FeedStoryMutator.m10586b((InjectorLike) this), TasksManager.m14550b((InjectorLike) this), newsFeedFragment);
    }
}
