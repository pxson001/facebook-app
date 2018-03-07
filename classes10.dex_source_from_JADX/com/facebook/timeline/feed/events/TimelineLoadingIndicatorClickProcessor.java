package com.facebook.timeline.feed.events;

import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.inject.Assisted;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friends_nearby_fetch_failed */
public class TimelineLoadingIndicatorClickProcessor {
    @Nullable
    public final TimelineStoriesDataFetcher f11161a;
    public final EventsStream f11162b;
    public Subscription f11163c;

    /* compiled from: friends_nearby_fetch_failed */
    public class C16171 implements Action<TimelineLoadingIndicatorClickEvent> {
        final /* synthetic */ TimelineLoadingIndicatorClickProcessor f11160a;

        public C16171(TimelineLoadingIndicatorClickProcessor timelineLoadingIndicatorClickProcessor) {
            this.f11160a = timelineLoadingIndicatorClickProcessor;
        }

        public final void m11302a(Object obj) {
            TimelineLoadingIndicatorClickEvent timelineLoadingIndicatorClickEvent = (TimelineLoadingIndicatorClickEvent) obj;
            if (this.f11160a.f11161a != null) {
                TimelineStoriesDataFetcher timelineStoriesDataFetcher = this.f11160a.f11161a;
                LoadingIndicator loadingIndicator = timelineLoadingIndicatorClickEvent.f11159a;
                if (loadingIndicator.f12776a != null) {
                    timelineStoriesDataFetcher.m10720a(loadingIndicator.f12776a);
                } else {
                    timelineStoriesDataFetcher.m10726e();
                }
            }
        }
    }

    @Inject
    public TimelineLoadingIndicatorClickProcessor(@Assisted TimelineStoriesDataFetcher timelineStoriesDataFetcher, EventsStream eventsStream) {
        this.f11161a = timelineStoriesDataFetcher;
        this.f11162b = eventsStream;
    }

    public final void m11303a() {
        if (this.f11163c == null) {
            this.f11163c = this.f11162b.a(TimelineLoadingIndicatorClickEvent.class, new C16171(this));
        }
    }
}
