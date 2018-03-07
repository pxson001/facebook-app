package com.facebook.zero.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: www.internet.org */
public class SendZeroHeaderRequestParams implements Parcelable {
    public static final Creator<SendZeroHeaderRequestParams> CREATOR = new C00311();
    public final String f217a;
    public final String f218b;
    public final String f219c;
    public final String f220d;

    /* compiled from: www.internet.org */
    final class C00311 implements Creator<SendZeroHeaderRequestParams> {
        C00311() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SendZeroHeaderRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SendZeroHeaderRequestParams[i];
        }
    }

    public SendZeroHeaderRequestParams(String str, String str2, String str3, String str4) {
        this.f217a = str;
        this.f218b = str2;
        this.f219c = str3;
        this.f220d = str4;
    }

    public SendZeroHeaderRequestParams(Parcel parcel) {
        this.f217a = parcel.readString();
        this.f218b = parcel.readString();
        this.f219c = parcel.readString();
        this.f220d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f217a);
        parcel.writeString(this.f218b);
        parcel.writeString(this.f219c);
        parcel.writeString(this.f220d);
    }

    public String toString() {
        return Objects.toStringHelper(SendZeroHeaderRequestParams.class).add("encryptedUId", this.f217a).add("nonce", this.f218b).add("headerAppId", this.f219c).add("encryptedMachineId", this.f220d).toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SendZeroHeaderRequestParams)) {
            return false;
        }
        SendZeroHeaderRequestParams sendZeroHeaderRequestParams = (SendZeroHeaderRequestParams) obj;
        if (Objects.equal(this.f217a, sendZeroHeaderRequestParams.f217a) && Objects.equal(this.f218b, sendZeroHeaderRequestParams.f218b) && Objects.equal(this.f219c, sendZeroHeaderRequestParams.f219c) && Objects.equal(this.f220d, sendZeroHeaderRequestParams.f220d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f217a, this.f218b, this.f219c});
    }
}
