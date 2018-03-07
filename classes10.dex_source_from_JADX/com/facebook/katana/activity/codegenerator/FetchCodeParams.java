package com.facebook.katana.activity.codegenerator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: user_agent */
public class FetchCodeParams implements Parcelable {
    public static final Creator<FetchCodeParams> CREATOR = new C01101();
    public final String f727a;
    public final String f728b;
    public final boolean f729c;

    /* compiled from: user_agent */
    final class C01101 implements Creator<FetchCodeParams> {
        C01101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchCodeParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchCodeParams[i];
        }
    }

    public FetchCodeParams(String str, String str2, boolean z) {
        this.f727a = str;
        this.f728b = str2;
        this.f729c = z;
    }

    public FetchCodeParams(Parcel parcel) {
        this.f727a = parcel.readString();
        this.f728b = parcel.readString();
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f729c = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        parcel.writeString(this.f727a);
        parcel.writeString(this.f728b);
        if (this.f729c) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
