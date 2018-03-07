package com.facebook.identitygrowth.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: mGraphApiWriteId */
public class FetchProfileQuestionParams implements Parcelable {
    public static final Creator<FetchProfileQuestionParams> CREATOR = new C06871();
    public String f11099a;
    public String f11100b;
    public String f11101c;

    /* compiled from: mGraphApiWriteId */
    final class C06871 implements Creator<FetchProfileQuestionParams> {
        C06871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchProfileQuestionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchProfileQuestionParams[i];
        }
    }

    public FetchProfileQuestionParams(String str, String str2, String str3) {
        this.f11099a = str;
        this.f11100b = str2;
        this.f11101c = str3;
    }

    public FetchProfileQuestionParams(Parcel parcel) {
        this.f11099a = parcel.readString();
        this.f11100b = parcel.readString();
        this.f11101c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11099a);
        parcel.writeString(this.f11100b);
        parcel.writeString(this.f11101c);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("method", "FetchProfileQuestionMethod").add("ref", this.f11099a).add("surface", this.f11100b).add("session", this.f11101c).toString();
    }
}
