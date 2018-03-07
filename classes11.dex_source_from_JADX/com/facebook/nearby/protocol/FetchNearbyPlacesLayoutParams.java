package com.facebook.nearby.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: typeahead_place */
public class FetchNearbyPlacesLayoutParams implements Parcelable {
    public static Creator<FetchNearbyPlacesLayoutParams> f521a = new C00801();

    /* compiled from: typeahead_place */
    final class C00801 implements Creator<FetchNearbyPlacesLayoutParams> {
        C00801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchNearbyPlacesLayoutParams((byte) 0);
        }

        public final Object[] newArray(int i) {
            return new FetchNearbyPlacesLayoutParams[i];
        }
    }

    public FetchNearbyPlacesLayoutParams(byte b) {
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public int describeContents() {
        return 0;
    }
}
