package com.facebook.timeline.feed.events;

import com.facebook.analytics.InteractionLogger;
import com.facebook.feed.rows.core.events.Action;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.rows.core.events.Subscription;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams.Builder;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.timeline.logging.TimelinePerformanceLogger.UnitsFetchTrigger;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.timeline.units.model.TimelineSectionData;
import com.facebook.timeline.units.model.TimelineSectionData.Scrubber;
import com.facebook.timeline.units.model.TimelineSectionData.TimelineSectionLabel;
import com.facebook.timeline.units.yearoverview.YearSectionClickEvent;
import com.facebook.widget.listview.BasicAdapter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friends_nearby_dashboard_upsell_turn_on */
public class TimelineScrubberClickEventProcessor {
    public final TimelineAllSectionsData f11166a;
    @Nullable
    public final TimelineStoriesDataFetcher f11167b;
    public final TimelineContext f11168c;
    public final BasicAdapter f11169d;
    public final Lazy<InteractionLogger> f11170e;
    public final Lazy<TimelineStoryEventBus> f11171f;
    public final EventsStream f11172g;
    public Subscription f11173h;

    /* compiled from: friends_nearby_dashboard_upsell_turn_on */
    public class C16181 implements Action<TimelineScrubberClickEvent> {
        final /* synthetic */ TimelineScrubberClickEventProcessor f11165a;

        public C16181(TimelineScrubberClickEventProcessor timelineScrubberClickEventProcessor) {
            this.f11165a = timelineScrubberClickEventProcessor;
        }

        public final void m11306a(Object obj) {
            Scrubber scrubber = ((TimelineScrubberClickEvent) obj).f11164a;
            if (scrubber instanceof TimelineSectionLabel) {
                Object obj2;
                TimelineSectionData a = this.f11165a.f11166a.m12714a(scrubber.f12781a);
                if (a == null || !a.f12795h) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    return;
                }
            }
            ((InteractionLogger) this.f11165a.f11170e.get()).a(false);
            if (!this.f11165a.f11168c.e.isPageTimeline()) {
                ((TimelineStoryEventBus) this.f11165a.f11171f.get()).a(new YearSectionClickEvent(this.f11165a.f11168c.d, scrubber));
            }
            if (this.f11165a.f11167b != null) {
                TimelineStoriesDataFetcher timelineStoriesDataFetcher = this.f11165a.f11167b;
                String str = scrubber.f12781a;
                Builder b = new Builder().m10742a(str).m10744b(scrubber.f12782b);
                b.f10689a = UnitsFetchTrigger.MANUAL_SECTION_HEADER;
                b = b;
                b.f10695g = 2;
                timelineStoriesDataFetcher.m10720a(b.m10745b());
            }
            this.f11165a.f11169d.notifyDataSetChanged();
        }
    }

    @Inject
    public TimelineScrubberClickEventProcessor(@Assisted TimelineAllSectionsData timelineAllSectionsData, @Assisted TimelineStoriesDataFetcher timelineStoriesDataFetcher, @Assisted TimelineContext timelineContext, @Assisted BasicAdapter basicAdapter, Lazy<InteractionLogger> lazy, Lazy<TimelineStoryEventBus> lazy2, EventsStream eventsStream) {
        this.f11166a = timelineAllSectionsData;
        this.f11167b = timelineStoriesDataFetcher;
        this.f11168c = timelineContext;
        this.f11169d = basicAdapter;
        this.f11170e = lazy;
        this.f11171f = lazy2;
        this.f11172g = eventsStream;
    }

    public final void m11307a() {
        if (this.f11173h == null) {
            this.f11173h = this.f11172g.a(TimelineScrubberClickEvent.class, new C16181(this));
        }
    }
}
