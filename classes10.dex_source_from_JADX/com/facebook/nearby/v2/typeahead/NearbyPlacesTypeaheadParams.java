package com.facebook.nearby.v2.typeahead;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: passing callback up from shim layer */
public class NearbyPlacesTypeaheadParams implements Parcelable {
    public static final Creator<NearbyPlacesTypeaheadParams> CREATOR = new C07331();
    public final double f5200a;
    public final double f5201b;
    public final String f5202c;

    /* compiled from: passing callback up from shim layer */
    final class C07331 implements Creator<NearbyPlacesTypeaheadParams> {
        C07331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesTypeaheadParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesTypeaheadParams[i];
        }
    }

    public NearbyPlacesTypeaheadParams(String str) {
        this(str, 0.0d, 0.0d);
    }

    public NearbyPlacesTypeaheadParams(String str, double d, double d2) {
        this.f5202c = str;
        this.f5200a = d;
        this.f5201b = d2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5202c);
        parcel.writeDouble(this.f5200a);
        parcel.writeDouble(this.f5201b);
    }

    public NearbyPlacesTypeaheadParams(Parcel parcel) {
        this.f5202c = parcel.readString();
        this.f5200a = parcel.readDouble();
        this.f5201b = parcel.readDouble();
    }
}
