package com.facebook.timeline.environment;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.inject.Assisted;
import com.facebook.timeline.rows.TimelineMenuProvider;
import javax.inject.Inject;

/* compiled from: gdpv4_nux_enabled */
public class HasMenuButtonProviderImpl implements HasMenuButtonProvider {
    private final BaseFeedStoryMenuHelper f10993a;

    @Inject
    public HasMenuButtonProviderImpl(@Assisted FeedEnvironment feedEnvironment, TimelineMenuProvider timelineMenuProvider) {
        this.f10993a = timelineMenuProvider.m12582a(feedEnvironment);
    }

    public final BaseFeedStoryMenuHelper m11104e() {
        return this.f10993a;
    }
}
