package com.facebook.timeline.feed.events;

import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.timeline.units.model.TimelineSectionData.Scrubber;

/* compiled from: friends_nearby_divebar_msg */
public class TimelineScrubberClickEvent implements KeyedEvent<String> {
    public final Scrubber f11164a;

    public TimelineScrubberClickEvent(Scrubber scrubber) {
        this.f11164a = scrubber;
    }

    public final Object m11305c() {
        return this.f11164a.f12781a;
    }
}
