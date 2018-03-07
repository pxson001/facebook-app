package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: page_grid_photo_card */
public class FetchDeltaContactsParams implements Parcelable {
    public static final Creator<FetchDeltaContactsParams> CREATOR = new C05411();
    public final int f8448a;
    public final String f8449b;

    /* compiled from: page_grid_photo_card */
    final class C05411 implements Creator<FetchDeltaContactsParams> {
        C05411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchDeltaContactsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchDeltaContactsParams[i];
        }
    }

    public FetchDeltaContactsParams(int i, String str) {
        this.f8448a = i;
        this.f8449b = str;
    }

    public FetchDeltaContactsParams(Parcel parcel) {
        this.f8448a = parcel.readInt();
        this.f8449b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8448a);
        parcel.writeString(this.f8449b);
    }
}
