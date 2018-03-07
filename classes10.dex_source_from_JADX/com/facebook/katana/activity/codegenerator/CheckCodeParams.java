package com.facebook.katana.activity.codegenerator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: user_public_create_dialog */
public class CheckCodeParams implements Parcelable {
    public static final Creator<CheckCodeParams> CREATOR = new C01011();
    public final String f695a;
    public final String f696b;
    public final String f697c;

    /* compiled from: user_public_create_dialog */
    final class C01011 implements Creator<CheckCodeParams> {
        C01011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CheckCodeParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CheckCodeParams[i];
        }
    }

    public CheckCodeParams(String str, String str2, String str3) {
        this.f695a = str;
        this.f696b = str2;
        this.f697c = str3;
    }

    public CheckCodeParams(Parcel parcel) {
        this.f695a = parcel.readString();
        this.f696b = parcel.readString();
        this.f697c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f695a);
        parcel.writeString(this.f696b);
        parcel.writeString(this.f697c);
    }
}
