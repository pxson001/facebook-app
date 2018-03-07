package com.facebook.pages.identity.timeline.storymenu;

import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.timeline.rows.AbstractTimelineFeedType;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: page_identity_placeholder_missing */
public class PagesTimelineMenuProvider {
    private final PagesTimelineFeedStoryMenuHelperProvider f4236a;

    @Inject
    public PagesTimelineMenuProvider(PagesTimelineFeedStoryMenuHelperProvider pagesTimelineFeedStoryMenuHelperProvider) {
        this.f4236a = pagesTimelineFeedStoryMenuHelperProvider;
    }

    public final BaseFeedStoryMenuHelper m5215a(FeedListType feedListType, BaseFeedEnvironment baseFeedEnvironment) {
        Preconditions.checkArgument(feedListType instanceof AbstractTimelineFeedType);
        return this.f4236a.m5214a(((AbstractTimelineFeedType) feedListType).a, baseFeedEnvironment);
    }
}
