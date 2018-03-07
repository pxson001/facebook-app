package com.facebook.events.feed.ui.environment;

import com.facebook.events.feed.ui.EventFeedStoryMenuHelper;
import com.facebook.events.feed.ui.EventFeedStoryMenuHelperProvider;
import com.facebook.feed.environment.CanPinAndUnpinPosts;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.inject.Assisted;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import javax.inject.Inject;

/* compiled from: com.android.providers.media.documents */
public class HasEventFeedMenuButtonProviderImpl implements HasMenuButtonProvider {
    private final Supplier<EventFeedStoryMenuHelper> f17480a;

    @Inject
    public HasEventFeedMenuButtonProviderImpl(@Assisted final CanPinAndUnpinPosts canPinAndUnpinPosts, @Assisted final FeedEnvironment feedEnvironment, final EventFeedStoryMenuHelperProvider eventFeedStoryMenuHelperProvider) {
        this.f17480a = Suppliers.memoize(new Supplier<EventFeedStoryMenuHelper>(this) {
            final /* synthetic */ HasEventFeedMenuButtonProviderImpl f17479d;

            public Object get() {
                return eventFeedStoryMenuHelperProvider.m17785a(canPinAndUnpinPosts, feedEnvironment);
            }
        });
    }

    public final BaseFeedStoryMenuHelper m17842e() {
        return (BaseFeedStoryMenuHelper) this.f17480a.get();
    }
}
