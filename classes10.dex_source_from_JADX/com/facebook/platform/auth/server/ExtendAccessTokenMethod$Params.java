package com.facebook.platform.auth.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: location_required_not_working */
public class ExtendAccessTokenMethod$Params implements Parcelable {
    public static final Creator<ExtendAccessTokenMethod$Params> CREATOR = new C12621();
    public String f8463a;
    public String f8464b;

    /* compiled from: location_required_not_working */
    final class C12621 implements Creator<ExtendAccessTokenMethod$Params> {
        C12621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ExtendAccessTokenMethod$Params(parcel);
        }

        public final Object[] newArray(int i) {
            return new ExtendAccessTokenMethod$Params[i];
        }
    }

    public ExtendAccessTokenMethod$Params(String str, String str2) {
        this.f8463a = str;
        this.f8464b = str2;
    }

    public ExtendAccessTokenMethod$Params(Parcel parcel) {
        this.f8463a = parcel.readString();
        this.f8464b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8463a);
        parcel.writeString(this.f8464b);
    }
}
