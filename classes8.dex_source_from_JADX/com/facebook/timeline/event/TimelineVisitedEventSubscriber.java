package com.facebook.timeline.event;

import android.os.ParcelUuid;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import javax.annotation.Nullable;

/* compiled from: mUserDeletedAppProvidedHashtag */
public abstract class TimelineVisitedEventSubscriber extends FbEventSubscriber<TimelineVisitedEvent> {
    @Nullable
    private final ParcelUuid f9163a;

    public final boolean m10938a(FbEvent fbEvent) {
        return this.f9163a == null || !this.f9163a.equals(((TimelineVisitedEvent) fbEvent).f9160a);
    }

    public TimelineVisitedEventSubscriber() {
        this.f9163a = null;
    }

    public TimelineVisitedEventSubscriber(ParcelUuid parcelUuid) {
        this.f9163a = parcelUuid;
    }

    public final Class<TimelineVisitedEvent> m10937a() {
        return TimelineVisitedEvent.class;
    }
}
