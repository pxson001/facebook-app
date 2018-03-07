package com.facebook.timeline.feed.events;

import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.widget.listview.BasicAdapter;

/* compiled from: friends_nearby_dashboard_timeline */
public class TimelineScrubberClickEventProcessorProvider extends AbstractAssistedProvider<TimelineScrubberClickEventProcessor> {
    public final TimelineScrubberClickEventProcessor m11308a(TimelineAllSectionsData timelineAllSectionsData, TimelineStoriesDataFetcher timelineStoriesDataFetcher, TimelineContext timelineContext, BasicAdapter basicAdapter) {
        return new TimelineScrubberClickEventProcessor(timelineAllSectionsData, timelineStoriesDataFetcher, timelineContext, basicAdapter, IdBasedSingletonScopeProvider.b(this, 134), IdBasedSingletonScopeProvider.b(this, 11217), EventsStream.a(this));
    }
}
