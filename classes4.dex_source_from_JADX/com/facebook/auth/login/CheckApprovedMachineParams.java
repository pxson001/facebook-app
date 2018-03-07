package com.facebook.auth.login;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: trace_time_sec */
public class CheckApprovedMachineParams implements Parcelable {
    public static final Creator<CheckApprovedMachineParams> CREATOR = new 1();
    public long f788a;
    public String f789b;

    public CheckApprovedMachineParams(long j, String str) {
        this.f788a = j;
        this.f789b = str;
    }

    public CheckApprovedMachineParams(Parcel parcel) {
        this.f788a = parcel.readLong();
        this.f789b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f788a);
        parcel.writeString(this.f789b);
    }

    public int describeContents() {
        return 0;
    }
}
