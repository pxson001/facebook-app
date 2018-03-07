package com.facebook.timeline;

import com.facebook.common.errorreporting.memory.ClassInstancesToLog;
import com.facebook.timeline.header.UserTimelineHeaderView;
import com.facebook.timeline.units.model.TimelineSectionData;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: trimToNothing */
public class TimelineClassInstancesToLog implements ClassInstancesToLog {
    public final Set<Class> mo636a() {
        return Sets.m1315a(TimelineFragment.class, TimelineSectionData.class, UserTimelineHeaderView.class);
    }
}
