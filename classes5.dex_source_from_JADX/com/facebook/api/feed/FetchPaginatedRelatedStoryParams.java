package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: attribution_text */
public class FetchPaginatedRelatedStoryParams implements Parcelable {
    public static final Creator<FetchPaginatedRelatedStoryParams> CREATOR = new C09431();
    public final String f8702a;
    public final String f8703b;
    public final int f8704c;

    /* compiled from: attribution_text */
    final class C09431 implements Creator<FetchPaginatedRelatedStoryParams> {
        C09431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPaginatedRelatedStoryParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPaginatedRelatedStoryParams[i];
        }
    }

    public FetchPaginatedRelatedStoryParams(Parcel parcel) {
        this.f8702a = parcel.readString();
        this.f8703b = parcel.readString();
        this.f8704c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8702a);
        parcel.writeString(this.f8703b);
        parcel.writeInt(this.f8704c);
    }
}
