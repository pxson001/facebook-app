package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: isNonAuthoritative */
public abstract class MessagingNotification implements Parcelable {
    public boolean f12646a;
    public final Type f12647j;

    public MessagingNotification(Type type) {
        this.f12647j = type;
    }

    protected MessagingNotification(Parcel parcel) {
        this.f12647j = (Type) parcel.readSerializable();
        this.f12646a = ParcelUtil.a(parcel);
    }

    public final void m13111i() {
        this.f12646a = true;
    }

    protected final void m13110a(Parcel parcel) {
        parcel.writeSerializable(this.f12647j);
        ParcelUtil.a(parcel, this.f12646a);
    }
}
