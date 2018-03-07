package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: reset_per_action */
public class FetchAllContactsParams implements Parcelable {
    public static final Creator<FetchAllContactsParams> CREATOR = new C01561();
    public final int f3427a;
    public final String f3428b;
    private final long f3429c;

    /* compiled from: reset_per_action */
    final class C01561 implements Creator<FetchAllContactsParams> {
        C01561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchAllContactsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchAllContactsParams[i];
        }
    }

    private FetchAllContactsParams(int i, String str, long j) {
        this.f3427a = i;
        this.f3428b = str;
        this.f3429c = j;
    }

    public FetchAllContactsParams(Parcel parcel) {
        this.f3427a = parcel.readInt();
        this.f3428b = parcel.readString();
        this.f3429c = parcel.readLong();
    }

    public static FetchAllContactsParams m3643a(int i, String str) {
        return new FetchAllContactsParams(i, str, -1);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3427a);
        parcel.writeString(this.f3428b);
        parcel.writeLong(this.f3429c);
    }
}
