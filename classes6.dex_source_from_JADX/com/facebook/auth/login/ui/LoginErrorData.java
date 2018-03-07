package com.facebook.auth.login.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: product_item_price */
public class LoginErrorData implements Parcelable {
    public static final Creator<LoginErrorData> CREATOR = new C04421();
    private static final Class<?> f7384d = LoginErrorData.class;
    long f7385a;
    String f7386b;
    String f7387c;

    /* compiled from: product_item_price */
    final class C04421 implements Creator<LoginErrorData> {
        C04421() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LoginErrorData(parcel);
        }

        public final Object[] newArray(int i) {
            return new LoginErrorData[i];
        }
    }

    public LoginErrorData(Parcel parcel) {
        this.f7385a = parcel.readLong();
        this.f7386b = parcel.readString();
        this.f7387c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f7385a);
        parcel.writeString(this.f7386b);
        parcel.writeString(this.f7387c);
    }
}
