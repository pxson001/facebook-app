package com.facebook.events.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: swipe_right */
public enum EventType implements Parcelable {
    NORMAL,
    QUICK_INVITE;
    
    public static final Creator<EventType> CREATOR = null;

    /* compiled from: swipe_right */
    final class C02351 implements Creator<EventType> {
        C02351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return EventType.valueOf(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new EventType[i];
        }
    }

    static {
        CREATOR = new C02351();
    }

    public final String getContentValue() {
        return name();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
