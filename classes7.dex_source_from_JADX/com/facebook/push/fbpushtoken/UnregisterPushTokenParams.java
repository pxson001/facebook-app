package com.facebook.push.fbpushtoken;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: height/ */
public class UnregisterPushTokenParams implements Parcelable {
    public static final Creator<UnregisterPushTokenParams> CREATOR = new C09951();
    public final String f11310a;

    /* compiled from: height/ */
    final class C09951 implements Creator<UnregisterPushTokenParams> {
        C09951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UnregisterPushTokenParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UnregisterPushTokenParams[i];
        }
    }

    public UnregisterPushTokenParams(String str) {
        this.f11310a = str;
    }

    public UnregisterPushTokenParams(Parcel parcel) {
        this.f11310a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11310a);
    }
}
