package com.facebook.events.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: supportsWebWorkers */
public enum PrivacyKind implements Parcelable {
    PRIVATE,
    PUBLIC;
    
    public static final Creator<PrivacyKind> CREATOR = null;

    /* compiled from: supportsWebWorkers */
    final class C02371 implements Creator<PrivacyKind> {
        C02371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return PrivacyKind.valueOf(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new PrivacyKind[i];
        }
    }

    static {
        CREATOR = new C02371();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
