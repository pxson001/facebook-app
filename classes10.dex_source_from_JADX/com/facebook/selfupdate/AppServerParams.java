package com.facebook.selfupdate;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: high_score_message */
public class AppServerParams implements Parcelable {
    public static final Creator<AppServerParams> CREATOR = new C14741();
    public final String f9938a;
    public final int f9939b;
    public final String f9940c;

    /* compiled from: high_score_message */
    final class C14741 implements Creator<AppServerParams> {
        C14741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AppServerParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new AppServerParams[i];
        }
    }

    public AppServerParams(String str, int i, String str2) {
        this.f9938a = str;
        this.f9939b = i;
        this.f9940c = str2;
    }

    public AppServerParams(Parcel parcel) {
        this.f9938a = parcel.readString();
        this.f9939b = parcel.readInt();
        this.f9940c = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9938a);
        parcel.writeInt(this.f9939b);
        parcel.writeString(this.f9940c);
    }

    public int describeContents() {
        return 0;
    }
}
