package com.facebook.feed.fragment.generatedenvironments;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelperFactory;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: new_connection */
public class HasMenuButtonProviderImpl implements HasMenuButtonProvider {
    private final BaseFeedStoryMenuHelper f12311a;

    @Inject
    public HasMenuButtonProviderImpl(@Assisted FeedEnvironment feedEnvironment, NewsFeedStoryMenuHelperFactory newsFeedStoryMenuHelperFactory) {
        this.f12311a = newsFeedStoryMenuHelperFactory.mo2464a(feedEnvironment);
    }

    public final BaseFeedStoryMenuHelper mo2448e() {
        return this.f12311a;
    }
}
