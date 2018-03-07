package com.facebook.timeline.feed.events;

import com.facebook.feed.rows.core.events.KeyedEvent;
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;

/* compiled from: friends_nearby_highlight_section */
public class TimelineLoadingIndicatorClickEvent implements KeyedEvent<String> {
    public final LoadingIndicator f11159a;

    public TimelineLoadingIndicatorClickEvent(LoadingIndicator loadingIndicator) {
        this.f11159a = loadingIndicator;
    }

    public final Object m11301c() {
        return "PLACEHOLDER_ID";
    }
}
