package com.facebook.profile.inforequest.event;

import android.os.ParcelUuid;
import com.facebook.content.event.FbEvent;
import com.google.common.base.Preconditions;

/* compiled from: local_contacts_param */
public abstract class InfoRequestEvent implements FbEvent {
    public final ParcelUuid f8568a;

    public InfoRequestEvent(ParcelUuid parcelUuid) {
        this.f8568a = (ParcelUuid) Preconditions.checkNotNull(parcelUuid);
    }
}
