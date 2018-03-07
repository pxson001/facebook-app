package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class ConnectionConfiguration implements SafeParcelable {
    public static final Creator<ConnectionConfiguration> CREATOR = new zzg();
    public final int f13133a;
    public final String f13134b;
    public final String f13135c;
    public final int f13136d;
    public final int f13137e;
    public final boolean f13138f;
    public boolean f13139g;
    public String f13140h;
    public boolean f13141i;
    public String f13142j;

    ConnectionConfiguration(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, String str3, boolean z3, String str4) {
        this.f13133a = i;
        this.f13134b = str;
        this.f13135c = str2;
        this.f13136d = i2;
        this.f13137e = i3;
        this.f13138f = z;
        this.f13139g = z2;
        this.f13140h = str3;
        this.f13141i = z3;
        this.f13142j = str4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        return zzw.a(Integer.valueOf(this.f13133a), Integer.valueOf(connectionConfiguration.f13133a)) && zzw.a(this.f13134b, connectionConfiguration.f13134b) && zzw.a(this.f13135c, connectionConfiguration.f13135c) && zzw.a(Integer.valueOf(this.f13136d), Integer.valueOf(connectionConfiguration.f13136d)) && zzw.a(Integer.valueOf(this.f13137e), Integer.valueOf(connectionConfiguration.f13137e)) && zzw.a(Boolean.valueOf(this.f13138f), Boolean.valueOf(connectionConfiguration.f13138f)) && zzw.a(Boolean.valueOf(this.f13141i), Boolean.valueOf(connectionConfiguration.f13141i));
    }

    public int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f13133a), this.f13134b, this.f13135c, Integer.valueOf(this.f13136d), Integer.valueOf(this.f13137e), Boolean.valueOf(this.f13138f), Boolean.valueOf(this.f13141i)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.f13134b);
        stringBuilder.append(", mAddress=" + this.f13135c);
        stringBuilder.append(", mType=" + this.f13136d);
        stringBuilder.append(", mRole=" + this.f13137e);
        stringBuilder.append(", mEnabled=" + this.f13138f);
        stringBuilder.append(", mIsConnected=" + this.f13139g);
        stringBuilder.append(", mPeerNodeId=" + this.f13140h);
        stringBuilder.append(", mBtlePriority=" + this.f13141i);
        stringBuilder.append(", mNodeId=" + this.f13142j);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13133a);
        zzb.a(parcel, 2, this.f13134b, false);
        zzb.a(parcel, 3, this.f13135c, false);
        zzb.a(parcel, 4, this.f13136d);
        zzb.a(parcel, 5, this.f13137e);
        zzb.a(parcel, 6, this.f13138f);
        zzb.a(parcel, 7, this.f13139g);
        zzb.a(parcel, 8, this.f13140h, false);
        zzb.a(parcel, 9, this.f13141i);
        zzb.a(parcel, 10, this.f13142j, false);
        zzb.c(parcel, a);
    }
}
