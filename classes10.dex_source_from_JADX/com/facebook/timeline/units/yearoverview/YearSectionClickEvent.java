package com.facebook.timeline.units.yearoverview;

import android.os.ParcelUuid;
import com.facebook.timeline.event.TimelineStoryEvent;
import com.facebook.timeline.units.model.TimelineSectionData.Scrubber;

/* compiled from: extra_events_discovery_fragment_waiting_for_location_result */
public class YearSectionClickEvent extends TimelineStoryEvent {
    private final Scrubber f12830a;

    public YearSectionClickEvent(ParcelUuid parcelUuid, Scrubber scrubber) {
        this.f12830a = scrubber;
    }
}
