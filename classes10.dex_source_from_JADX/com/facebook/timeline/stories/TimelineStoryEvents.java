package com.facebook.timeline.stories;

import android.os.ParcelUuid;
import com.facebook.timeline.event.TimelineStoryEvent;
import com.facebook.timeline.event.TimelineStoryEventSubscriber;

/* compiled from: extra_is_selecting_second_date */
public class TimelineStoryEvents {

    /* compiled from: extra_is_selecting_second_date */
    public abstract class RedirectToPermalinkEventSubscriber extends TimelineStoryEventSubscriber<RedirectToPermalinkEvent> {
        public RedirectToPermalinkEventSubscriber(ParcelUuid parcelUuid) {
        }

        public final Class<RedirectToPermalinkEvent> m12683a() {
            return RedirectToPermalinkEvent.class;
        }
    }

    /* compiled from: extra_is_selecting_second_date */
    public class RedirectToPermalinkEvent extends TimelineStoryEvent {
        public final String f12735a;

        public RedirectToPermalinkEvent(ParcelUuid parcelUuid, String str) {
            this.f12735a = str;
        }
    }
}
