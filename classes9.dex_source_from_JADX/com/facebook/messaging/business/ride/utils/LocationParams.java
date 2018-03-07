package com.facebook.messaging.business.ride.utils;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;

/* compiled from: mobile_location_type */
public class LocationParams implements Parcelable {
    public static final Creator<LocationParams> CREATOR = new C10721();
    @Nullable
    public Location f9292a;
    @Nullable
    public String f9293b;
    @Nullable
    public String f9294c;

    /* compiled from: mobile_location_type */
    final class C10721 implements Creator<LocationParams> {
        C10721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LocationParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new LocationParams[i];
        }
    }

    public LocationParams(Parcel parcel) {
        this.f9292a = (Location) parcel.readParcelable(LocationParams.class.getClassLoader());
        this.f9293b = parcel.readString();
        this.f9294c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f9292a, i);
        parcel.writeString(this.f9293b);
        parcel.writeString(this.f9294c);
    }
}
