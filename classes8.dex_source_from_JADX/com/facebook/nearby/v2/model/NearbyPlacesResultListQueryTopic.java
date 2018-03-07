package com.facebook.nearby.v2.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;

/* compiled from: did_not_finish */
public class NearbyPlacesResultListQueryTopic implements Parcelable {
    public static final Creator<NearbyPlacesResultListQueryTopic> CREATOR = new C16781();
    public String f15302a;
    public String f15303b;

    /* compiled from: did_not_finish */
    final class C16781 implements Creator<NearbyPlacesResultListQueryTopic> {
        C16781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NearbyPlacesResultListQueryTopic(parcel);
        }

        public final Object[] newArray(int i) {
            return new NearbyPlacesResultListQueryTopic[i];
        }
    }

    public NearbyPlacesResultListQueryTopic(String str, String str2) {
        Preconditions.checkNotNull(str);
        this.f15302a = str;
        this.f15303b = str2;
    }

    public NearbyPlacesResultListQueryTopic(NearbyPlacesResultListQueryTopic nearbyPlacesResultListQueryTopic) {
        Preconditions.checkNotNull(nearbyPlacesResultListQueryTopic);
        this.f15302a = nearbyPlacesResultListQueryTopic.f15302a;
        this.f15303b = nearbyPlacesResultListQueryTopic.f15303b;
    }

    protected NearbyPlacesResultListQueryTopic(Parcel parcel) {
        this.f15302a = parcel.readString();
        this.f15303b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15302a);
        parcel.writeString(this.f15303b);
    }
}
