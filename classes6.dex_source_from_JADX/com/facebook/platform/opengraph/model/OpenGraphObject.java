package com.facebook.platform.opengraph.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: storage */
public class OpenGraphObject implements Parcelable {
    public static final Creator<OpenGraphObject> CREATOR = new C02261();
    public final String f4105a;
    public final String f4106b;
    public final String f4107c;

    /* compiled from: storage */
    final class C02261 implements Creator<OpenGraphObject> {
        C02261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new OpenGraphObject(parcel);
        }

        public final Object[] newArray(int i) {
            return new OpenGraphObject[i];
        }
    }

    public OpenGraphObject(String str, String str2, String str3) {
        this.f4106b = str;
        this.f4105a = str2;
        this.f4107c = str3;
    }

    public OpenGraphObject(Parcel parcel) {
        this.f4106b = parcel.readString();
        this.f4105a = parcel.readString();
        this.f4107c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4106b);
        parcel.writeString(this.f4105a);
        parcel.writeString(this.f4107c);
    }
}
