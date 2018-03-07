package com.facebook.profile.inforequest.event;

import android.os.ParcelUuid;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriber;
import com.google.common.base.Preconditions;

/* compiled from: localBroadcastManager */
public abstract class InfoRequestEventSubscriber<T extends InfoRequestEvent> extends FbEventSubscriber<T> {
    public final ParcelUuid f8570a;

    public final boolean m8478a(FbEvent fbEvent) {
        return this.f8570a.equals(((InfoRequestEvent) fbEvent).f8568a);
    }

    public InfoRequestEventSubscriber(ParcelUuid parcelUuid) {
        this.f8570a = (ParcelUuid) Preconditions.checkNotNull(parcelUuid);
    }
}
