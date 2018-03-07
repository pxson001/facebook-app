package com.facebook.search.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: nearby_places_tap */
public class GraphSearchFeedTypeValueParams implements Parcelable {
    public static final Creator<GraphSearchFeedTypeValueParams> CREATOR = new C09121();
    public final String f8100a;
    public final boolean f8101b;

    /* compiled from: nearby_places_tap */
    final class C09121 implements Creator<GraphSearchFeedTypeValueParams> {
        C09121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphSearchFeedTypeValueParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphSearchFeedTypeValueParams[i];
        }
    }

    public GraphSearchFeedTypeValueParams(Parcel parcel) {
        boolean z = true;
        this.f8100a = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f8101b = z;
    }

    public String toString() {
        return this.f8100a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8100a);
        parcel.writeInt(this.f8101b ? 1 : 0);
    }
}
