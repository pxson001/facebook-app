package com.facebook.katana.activity.codegenerator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: user_sem_click_tracking */
public class ActivationCodeParams implements Parcelable {
    public static final Creator<ActivationCodeParams> CREATOR = new C01001();
    public final long f692a;
    public final String f693b;
    public final String f694c;

    /* compiled from: user_sem_click_tracking */
    final class C01001 implements Creator<ActivationCodeParams> {
        C01001() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ActivationCodeParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ActivationCodeParams[i];
        }
    }

    public ActivationCodeParams(long j, String str, String str2) {
        this.f692a = j;
        this.f693b = str;
        this.f694c = str2;
    }

    public ActivationCodeParams(Parcel parcel) {
        this.f692a = parcel.readLong();
        this.f693b = parcel.readString();
        this.f694c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f692a);
        parcel.writeString(this.f693b);
        parcel.writeString(this.f694c);
    }
}
