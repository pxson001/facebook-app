package com.facebook.pages.app.data.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: supported_client_interfaces */
public class FetchPageNewLikesParams implements Parcelable {
    public static final Creator<FetchPageNewLikesParams> CREATOR = new C01641();
    private String f1211a;
    private long f1212b;

    /* compiled from: supported_client_interfaces */
    final class C01641 implements Creator<FetchPageNewLikesParams> {
        C01641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchPageNewLikesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchPageNewLikesParams[i];
        }
    }

    public FetchPageNewLikesParams(Parcel parcel) {
        this.f1211a = parcel.readString();
        this.f1212b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1211a);
        parcel.writeLong(this.f1212b);
    }
}
