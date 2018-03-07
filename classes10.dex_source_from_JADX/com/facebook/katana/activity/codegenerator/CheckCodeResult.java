package com.facebook.katana.activity.codegenerator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: user_pic */
public class CheckCodeResult implements Parcelable {
    public static final Creator<CheckCodeResult> CREATOR = new C01021();
    public final String f698a;
    public final String f699b;

    /* compiled from: user_pic */
    final class C01021 implements Creator<CheckCodeResult> {
        C01021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CheckCodeResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new CheckCodeResult[i];
        }
    }

    public CheckCodeResult(String str, String str2) {
        this.f698a = str;
        this.f699b = str2;
    }

    public CheckCodeResult(Parcel parcel) {
        this.f698a = parcel.readString();
        this.f699b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f698a);
        parcel.writeString(this.f699b);
    }
}
