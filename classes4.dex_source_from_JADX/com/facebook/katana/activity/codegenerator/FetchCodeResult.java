package com.facebook.katana.activity.codegenerator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: short_term_cache_key */
public class FetchCodeResult implements Parcelable {
    public static final Creator<FetchCodeResult> CREATOR = new C01161();
    public final String f2212a;
    public final String f2213b;

    /* compiled from: short_term_cache_key */
    final class C01161 implements Creator<FetchCodeResult> {
        C01161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchCodeResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchCodeResult[i];
        }
    }

    public FetchCodeResult(String str, String str2) {
        this.f2212a = str;
        this.f2213b = str2;
    }

    public FetchCodeResult(Parcel parcel) {
        this.f2212a = parcel.readString();
        this.f2213b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2212a);
        parcel.writeString(this.f2213b);
    }
}
