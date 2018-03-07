package com.facebook.katana.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: translatability_for_viewer */
public class LoginApprovalResendCodeParams implements Parcelable {
    public static final Creator<LoginApprovalResendCodeParams> CREATOR = new 1();
    public long f737a;
    public String f738b;

    public LoginApprovalResendCodeParams(long j, String str) {
        this.f737a = j;
        this.f738b = str;
    }

    public LoginApprovalResendCodeParams(Parcel parcel) {
        this.f737a = parcel.readLong();
        this.f738b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f737a);
        parcel.writeString(this.f738b);
    }

    public int describeContents() {
        return 0;
    }
}
