package com.facebook.nearby.v2.resultlist.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: datetaken >  */
public class NearbyPlacesResultListFilterMask implements Parcelable {
    public static final Creator<NearbyPlacesResultListFilterMask> CREATOR = new C16961();
    public int f15860a;

    /* compiled from: datetaken >  */
    final class C16961 implements Creator<NearbyPlacesResultListFilterMask> {
        C16961() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesResultListFilterMask(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesResultListFilterMask[i];
        }
    }

    public NearbyPlacesResultListFilterMask(int i) {
        this.f15860a = i;
    }

    protected NearbyPlacesResultListFilterMask(Parcel parcel) {
        this.f15860a = parcel.readInt();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NearbyPlacesResultListFilterMask)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.f15860a == ((NearbyPlacesResultListFilterMask) obj).f15860a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f15860a + 31;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15860a);
    }

    public int describeContents() {
        return 0;
    }
}
