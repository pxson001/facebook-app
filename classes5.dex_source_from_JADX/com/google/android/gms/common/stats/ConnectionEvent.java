package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class ConnectionEvent extends zzf implements SafeParcelable {
    public static final Creator<ConnectionEvent> CREATOR = new zza();
    public final int f6632a;
    private final long f6633b;
    private int f6634c;
    public final String f6635d;
    public final String f6636e;
    public final String f6637f;
    public final String f6638g;
    public final String f6639h;
    public final String f6640i;
    public final long f6641j;
    public final long f6642k;
    private long f6643l;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.f6632a = i;
        this.f6633b = j;
        this.f6634c = i2;
        this.f6635d = str;
        this.f6636e = str2;
        this.f6637f = str3;
        this.f6638g = str4;
        this.f6643l = -1;
        this.f6639h = str5;
        this.f6640i = str6;
        this.f6641j = j2;
        this.f6642k = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public final long mo803a() {
        return this.f6633b;
    }

    public final int mo804b() {
        return this.f6634c;
    }

    public final int describeContents() {
        return 0;
    }

    public final long mo805i() {
        return this.f6643l;
    }

    public final String mo806l() {
        return "\t" + this.f6635d + "/" + this.f6636e + "\t" + this.f6637f + "/" + this.f6638g + "\t" + (this.f6639h == null ? "" : this.f6639h) + "\t" + this.f6642k;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6632a);
        zzb.m12242a(parcel, 2, mo803a());
        zzb.m12247a(parcel, 4, this.f6635d, false);
        zzb.m12247a(parcel, 5, this.f6636e, false);
        zzb.m12247a(parcel, 6, this.f6637f, false);
        zzb.m12247a(parcel, 7, this.f6638g, false);
        zzb.m12247a(parcel, 8, this.f6639h, false);
        zzb.m12242a(parcel, 10, this.f6641j);
        zzb.m12242a(parcel, 11, this.f6642k);
        zzb.m12241a(parcel, 12, mo804b());
        zzb.m12247a(parcel, 13, this.f6640i, false);
        zzb.m12258c(parcel, a);
    }
}
