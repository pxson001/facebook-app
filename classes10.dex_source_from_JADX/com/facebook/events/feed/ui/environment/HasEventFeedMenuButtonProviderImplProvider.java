package com.facebook.events.feed.ui.environment;

import com.facebook.events.feed.ui.EventFeedStoryMenuHelperProvider;
import com.facebook.feed.environment.CanPinAndUnpinPosts;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: com.android.providers.downloads.documents */
public class HasEventFeedMenuButtonProviderImplProvider extends AbstractAssistedProvider<HasEventFeedMenuButtonProviderImpl> {
    public final HasEventFeedMenuButtonProviderImpl m17843a(CanPinAndUnpinPosts canPinAndUnpinPosts, FeedEnvironment feedEnvironment) {
        return new HasEventFeedMenuButtonProviderImpl(canPinAndUnpinPosts, feedEnvironment, (EventFeedStoryMenuHelperProvider) getOnDemandAssistedProviderForStaticDi(EventFeedStoryMenuHelperProvider.class));
    }
}
