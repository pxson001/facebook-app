package com.facebook.places.create.network;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: caption_title_large_style */
public enum PlacePinAppId implements Parcelable {
    CITY_CENTER,
    GEOCODED_ADDRESS;
    
    public static final Creator<PlacePinAppId> CREATOR = null;

    /* compiled from: caption_title_large_style */
    final class C20121 implements Creator<PlacePinAppId> {
        C20121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return PlacePinAppId.valueOf(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new PlacePinAppId[i];
        }
    }

    static {
        CREATOR = new C20121();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
