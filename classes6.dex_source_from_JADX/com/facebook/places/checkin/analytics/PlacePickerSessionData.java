package com.facebook.places.checkin.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: friend_list_update_members */
public class PlacePickerSessionData implements Parcelable {
    public static final Creator<PlacePickerSessionData> CREATOR = new C09351();
    public String f14612a;
    public String f14613b;
    public long f14614c;

    /* compiled from: friend_list_update_members */
    final class C09351 implements Creator<PlacePickerSessionData> {
        C09351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlacePickerSessionData(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlacePickerSessionData[i];
        }
    }

    public PlacePickerSessionData(String str, String str2, long j) {
        this.f14612a = str;
        this.f14613b = str2;
        this.f14614c = j;
    }

    protected PlacePickerSessionData(Parcel parcel) {
        this.f14612a = parcel.readString();
        this.f14613b = parcel.readString();
        this.f14614c = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14612a);
        parcel.writeString(this.f14613b);
        parcel.writeLong(this.f14614c);
    }

    public String toString() {
        return "PlacePickerSessionData{placePickerSessionId=" + this.f14612a + ", composerSessionId=" + this.f14613b + ", placePickerStartTime=" + this.f14614c + "}";
    }
}
