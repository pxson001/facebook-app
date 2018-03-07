package com.facebook.timeline.rows;

import com.facebook.feed.rows.core.FeedListName;
import com.facebook.ipc.profile.TimelineContext;

/* compiled from: extras_event */
public class TimelineFeedType extends AbstractTimelineFeedType {
    public TimelineFeedType(TimelineContext timelineContext) {
        super(timelineContext);
    }

    public final FeedListName m12568a() {
        if (this.f12583a.e.isPageTimeline()) {
            return FeedListName.PAGE_TIMELINE;
        }
        return this.f12583a.i() ? FeedListName.MY_TIMELINE : FeedListName.OTHER_PERSON_TIMELINE;
    }
}
