package com.facebook.timeline.contextual;

import com.facebook.timeline.data.TimelineDataSource;

/* compiled from: group_member_requests_page_size */
public class TimelineContextualInfoData extends TimelineDataSource<TimelineContextItemsData> {
    public final int f10338f;

    public TimelineContextualInfoData() {
        this.f10338f = 50;
    }

    public TimelineContextualInfoData(int i) {
        this.f10338f = i;
    }

    public final boolean m10470d() {
        return this.c == 3 || !(this.b == null || ((TimelineContextItemsData) this.b).f10311a.isEmpty());
    }

    public final void m10468a(TimelineContextItemsData timelineContextItemsData, int i) {
        super.a(timelineContextItemsData, i);
        if (i == 1 && d() && ((TimelineContextItemsData) this.b).f10311a.size() <= this.f10338f && ((TimelineContextItemsData) this.b).f10312b != null && !((TimelineContextItemsData) this.b).f10312b.a()) {
            this.d = 2;
        }
    }
}
