package com.facebook.adspayments.protocol;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: UPPER_CASE */
public class VerifyBrazilianTaxIdParams implements Parcelable {
    public final String f23717a;
    public final String f23718b;

    public VerifyBrazilianTaxIdParams(String str, String str2) {
        this.f23717a = str;
        this.f23718b = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f23717a);
        parcel.writeString(this.f23718b);
    }
}
