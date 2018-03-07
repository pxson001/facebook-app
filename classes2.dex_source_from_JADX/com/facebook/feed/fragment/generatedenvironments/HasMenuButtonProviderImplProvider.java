package com.facebook.feed.fragment.generatedenvironments;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelperFactory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: new_user_notifications */
public class HasMenuButtonProviderImplProvider extends AbstractAssistedProvider<HasMenuButtonProviderImpl> {
    public final HasMenuButtonProviderImpl m18338a(FeedEnvironment feedEnvironment) {
        return new HasMenuButtonProviderImpl(feedEnvironment, NewsFeedStoryMenuHelperFactory.m18361a((InjectorLike) this));
    }
}
