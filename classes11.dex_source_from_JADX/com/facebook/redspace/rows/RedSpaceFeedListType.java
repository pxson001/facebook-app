package com.facebook.redspace.rows;

import com.facebook.feed.rows.core.FeedListName;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.rows.AbstractTimelineFeedType;

/* compiled from: PageCreateToFirstCardLoad */
public class RedSpaceFeedListType extends AbstractTimelineFeedType {
    private final TimelineContext f12187a;

    public RedSpaceFeedListType(TimelineContext timelineContext) {
        super(timelineContext);
        this.f12187a = timelineContext;
    }

    public final FeedListName m12654a() {
        return this.f12187a.i() ? FeedListName.REDSPACE_SELF : FeedListName.REDSPACE_OTHER;
    }
}
