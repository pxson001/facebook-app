package com.facebook.timeline.feed.events;

import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;

/* compiled from: friends_nearby_error_button_handle_failed */
public class TimelineLoadingIndicatorClickProcessorProvider extends AbstractAssistedProvider<TimelineLoadingIndicatorClickProcessor> {
    public final TimelineLoadingIndicatorClickProcessor m11304a(TimelineStoriesDataFetcher timelineStoriesDataFetcher) {
        return new TimelineLoadingIndicatorClickProcessor(timelineStoriesDataFetcher, EventsStream.a(this));
    }
}
