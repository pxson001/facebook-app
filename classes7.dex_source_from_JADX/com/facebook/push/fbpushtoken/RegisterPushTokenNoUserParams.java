package com.facebook.push.fbpushtoken;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: heisman_composer_session_id */
public class RegisterPushTokenNoUserParams implements Parcelable {
    public static final Creator<RegisterPushTokenNoUserParams> CREATOR = new C09931();
    public final String f11304a;
    public final String f11305b;
    public final String f11306c;
    public final String f11307d;

    /* compiled from: heisman_composer_session_id */
    final class C09931 implements Creator<RegisterPushTokenNoUserParams> {
        C09931() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RegisterPushTokenNoUserParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new RegisterPushTokenNoUserParams[i];
        }
    }

    public RegisterPushTokenNoUserParams(String str, String str2, String str3, String str4) {
        this.f11304a = str;
        this.f11305b = str2;
        this.f11306c = str3;
        this.f11307d = str4;
    }

    public RegisterPushTokenNoUserParams(Parcel parcel) {
        this.f11304a = parcel.readString();
        this.f11305b = parcel.readString();
        this.f11306c = parcel.readString();
        this.f11307d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11304a);
        parcel.writeString(this.f11305b);
        parcel.writeString(this.f11306c);
        parcel.writeString(this.f11307d);
    }
}
