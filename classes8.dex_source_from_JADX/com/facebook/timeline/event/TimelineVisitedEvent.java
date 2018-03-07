package com.facebook.timeline.event;

import android.os.ParcelUuid;
import com.facebook.content.event.FbEvent;
import com.google.common.base.Preconditions;

/* compiled from: magic-move */
public class TimelineVisitedEvent implements FbEvent {
    public final ParcelUuid f9160a;
    public final String f9161b;

    public TimelineVisitedEvent(ParcelUuid parcelUuid, String str) {
        this.f9160a = (ParcelUuid) Preconditions.checkNotNull(parcelUuid);
        this.f9161b = str;
    }
}
