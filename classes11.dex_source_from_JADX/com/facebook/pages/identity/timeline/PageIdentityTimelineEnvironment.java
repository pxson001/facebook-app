package com.facebook.pages.identity.timeline;

import android.content.Context;
import android.support.annotation.Nullable;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl.Delegate;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.pages.identity.timeline.storymenu.PagesTimelineMenuProvider;
import com.facebook.timeline.environment.HasProfileNameImpl;
import com.facebook.timeline.environment.TimelineEnvironment;
import javax.inject.Inject;

/* compiled from: page_identity_unfollow_fail */
public class PageIdentityTimelineEnvironment extends BaseFeedEnvironment implements TimelineEnvironment {
    private final FeedListType f4207m;
    private final PagesTimelineMenuProvider f4208n;
    private final TimelineContext f4209o;
    private final HasProfileNameImpl f4210p = new HasProfileNameImpl(null);

    @Inject
    public PageIdentityTimelineEnvironment(@Assisted Context context, @Assisted FeedListType feedListType, @Assisted TimelineContext timelineContext, @Assisted Runnable runnable, @Assisted Delegate delegate, PagesTimelineMenuProvider pagesTimelineMenuProvider) {
        super(context, runnable, delegate);
        this.f4207m = feedListType;
        this.f4208n = pagesTimelineMenuProvider;
        this.f4209o = timelineContext;
    }

    public final BaseFeedStoryMenuHelper m5193e() {
        return this.f4208n.m5215a(this.f4207m, this);
    }

    public final FeedListType m5192c() {
        return this.f4207m;
    }

    @Nullable
    public final String m5194l() {
        return this.f4210p.l();
    }
}
