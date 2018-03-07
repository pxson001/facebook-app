package com.facebook.nearby.protocol;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: topic_feeds_customization_in_feed_unit */
public class SearchArea implements Parcelable {
    public static final Creator<SearchArea> CREATOR = new C00881();
    public final Location f658a;
    public final int f659b;

    /* compiled from: topic_feeds_customization_in_feed_unit */
    final class C00881 implements Creator<SearchArea> {
        C00881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SearchArea(parcel);
        }

        public final Object[] newArray(int i) {
            return new SearchArea[i];
        }
    }

    public SearchArea(Location location, int i) {
        this.f658a = location;
        this.f659b = i;
    }

    public SearchArea(Parcel parcel) {
        this.f658a = (Location) parcel.readParcelable(Location.class.getClassLoader());
        this.f659b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f658a, i);
        parcel.writeInt(this.f659b);
    }
}
