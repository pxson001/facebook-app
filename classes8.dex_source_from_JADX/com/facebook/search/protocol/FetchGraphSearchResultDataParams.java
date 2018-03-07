package com.facebook.search.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: next-slide */
public class FetchGraphSearchResultDataParams implements Parcelable {
    public static final Creator<FetchGraphSearchResultDataParams> CREATOR = new C09011();
    public final String f7940a;
    public final int f7941b;
    public final String f7942c;
    public final String f7943d;

    /* compiled from: next-slide */
    final class C09011 implements Creator<FetchGraphSearchResultDataParams> {
        C09011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchGraphSearchResultDataParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchGraphSearchResultDataParams[i];
        }
    }

    /* compiled from: next-slide */
    public class Builder {
        public String f7936a;
        public String f7937b;
        public String f7938c;
        public int f7939d;
    }

    public FetchGraphSearchResultDataParams(Builder builder) {
        this.f7940a = builder.f7936a;
        this.f7941b = builder.f7939d;
        this.f7942c = builder.f7937b;
        this.f7943d = builder.f7938c;
    }

    public FetchGraphSearchResultDataParams(Parcel parcel) {
        this.f7940a = parcel.readString();
        this.f7941b = parcel.readInt();
        this.f7942c = parcel.readString();
        this.f7943d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7940a);
        parcel.writeInt(this.f7941b);
        parcel.writeString(this.f7942c);
        parcel.writeString(this.f7943d);
    }
}
