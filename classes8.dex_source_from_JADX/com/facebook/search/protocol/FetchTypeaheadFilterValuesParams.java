package com.facebook.search.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: networkName */
public class FetchTypeaheadFilterValuesParams implements Parcelable {
    public static final Creator<FetchTypeaheadFilterValuesParams> CREATOR = new C09111();
    private final String f8072a;
    private final String f8073b;
    private final int f8074c;
    private final String f8075d;

    /* compiled from: networkName */
    final class C09111 implements Creator<FetchTypeaheadFilterValuesParams> {
        C09111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchTypeaheadFilterValuesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchTypeaheadFilterValuesParams[i];
        }
    }

    public FetchTypeaheadFilterValuesParams(Parcel parcel) {
        this.f8072a = parcel.readString();
        this.f8073b = parcel.readString();
        this.f8074c = parcel.readInt();
        this.f8075d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8072a);
        parcel.writeString(this.f8073b);
        parcel.writeString(this.f8075d);
    }
}
