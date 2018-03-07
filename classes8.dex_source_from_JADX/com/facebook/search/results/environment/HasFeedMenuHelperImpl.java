package com.facebook.search.results.environment;

import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.inject.Assisted;
import com.facebook.video.player.environment.HasFeedMenuHelper;
import javax.inject.Inject;

/* compiled from: Subscribe page id is null */
public class HasFeedMenuHelperImpl implements HasFeedMenuHelper {
    private final FeedMenuHelperReference f22544a;

    @Inject
    public HasFeedMenuHelperImpl(@Assisted FeedMenuHelperReference feedMenuHelperReference) {
        this.f22544a = feedMenuHelperReference;
    }

    public final BaseFeedStoryMenuHelper m26025l() {
        return this.f22544a.f22541a;
    }
}
