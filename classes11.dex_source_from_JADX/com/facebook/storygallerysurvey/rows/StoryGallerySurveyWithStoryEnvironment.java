package com.facebook.storygallerysurvey.rows;

import android.content.Context;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelperFactory;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: None */
public class StoryGallerySurveyWithStoryEnvironment extends BaseFeedEnvironment implements FeedEnvironment {
    private final FeedListType f12969m;
    private final BaseFeedStoryMenuHelper f12970n;

    @Inject
    public StoryGallerySurveyWithStoryEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted Runnable runnable, NewsFeedStoryMenuHelperFactory newsFeedStoryMenuHelperFactory) {
        super(context, runnable, HasScrollListenerSupportImpl.b);
        this.f12969m = feedListType;
        this.f12970n = newsFeedStoryMenuHelperFactory.a(this);
    }

    public final BaseFeedStoryMenuHelper m13697e() {
        return this.f12970n;
    }

    public final FeedListType m13696c() {
        return this.f12969m;
    }
}
