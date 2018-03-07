package com.facebook.friendsnearby.pingdialog;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: \n+ */
public class LocationPingDeleteParams implements Parcelable {
    public static final Creator<LocationPingDeleteParams> CREATOR = new C29351();
    public final String f20617a;

    /* compiled from: \n+ */
    final class C29351 implements Creator<LocationPingDeleteParams> {
        C29351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LocationPingDeleteParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new LocationPingDeleteParams[i];
        }
    }

    public LocationPingDeleteParams(String str) {
        this.f20617a = str;
    }

    public LocationPingDeleteParams(Parcel parcel) {
        this.f20617a = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f20617a);
    }

    public int describeContents() {
        return 0;
    }
}
