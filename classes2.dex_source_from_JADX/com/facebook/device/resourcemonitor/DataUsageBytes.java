package com.facebook.device.resourcemonitor;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: set2 */
public class DataUsageBytes implements Parcelable {
    public static final DataUsageBytes f5369a = new DataUsageBytes(0, 0);
    public long f5370b;
    public long f5371c;

    public DataUsageBytes(long j, long j2) {
        this.f5370b = j;
        this.f5371c = j2;
    }

    public final DataUsageBytes m9249a(DataUsageBytes dataUsageBytes) {
        return new DataUsageBytes(this.f5370b - dataUsageBytes.f5370b, this.f5371c - dataUsageBytes.f5371c);
    }

    public final DataUsageBytes m9251b(DataUsageBytes dataUsageBytes) {
        return new DataUsageBytes(this.f5370b + dataUsageBytes.f5370b, this.f5371c + dataUsageBytes.f5371c);
    }

    public final long m9248a() {
        return this.f5370b;
    }

    public final long m9250b() {
        return this.f5371c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f5370b);
        parcel.writeLong(this.f5371c);
    }
}
