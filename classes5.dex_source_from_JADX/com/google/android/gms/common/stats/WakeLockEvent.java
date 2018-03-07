package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public final class WakeLockEvent extends zzf implements SafeParcelable {
    public static final Creator<WakeLockEvent> CREATOR = new zzh();
    public final int f6644a;
    private final long f6645b;
    private int f6646c;
    public final String f6647d;
    public final int f6648e;
    public final List<String> f6649f;
    public final String f6650g;
    public final long f6651h;
    public int f6652i;
    public final String f6653j;
    public final String f6654k;
    public final float f6655l;
    public final long f6656m;
    private long f6657n = -1;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3) {
        this.f6644a = i;
        this.f6645b = j;
        this.f6646c = i2;
        this.f6647d = str;
        this.f6653j = str3;
        this.f6648e = i3;
        this.f6649f = list;
        this.f6650g = str2;
        this.f6651h = j2;
        this.f6652i = i4;
        this.f6654k = str4;
        this.f6655l = f;
        this.f6656m = j3;
    }

    public final long mo803a() {
        return this.f6645b;
    }

    public final int mo804b() {
        return this.f6646c;
    }

    public final int describeContents() {
        return 0;
    }

    public final long mo805i() {
        return this.f6657n;
    }

    public final String mo806l() {
        return "\t" + this.f6647d + "\t" + this.f6648e + "\t" + (this.f6649f == null ? "" : TextUtils.join(",", this.f6649f)) + "\t" + this.f6652i + "\t" + (this.f6653j == null ? "" : this.f6653j) + "\t" + (this.f6654k == null ? "" : this.f6654k) + "\t" + this.f6655l;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6644a);
        zzb.m12242a(parcel, 2, mo803a());
        zzb.m12247a(parcel, 4, this.f6647d, false);
        zzb.m12241a(parcel, 5, this.f6648e);
        zzb.m12257b(parcel, 6, this.f6649f, false);
        zzb.m12242a(parcel, 8, this.f6651h);
        zzb.m12247a(parcel, 10, this.f6653j, false);
        zzb.m12241a(parcel, 11, mo804b());
        zzb.m12247a(parcel, 12, this.f6650g, false);
        zzb.m12247a(parcel, 13, this.f6654k, false);
        zzb.m12241a(parcel, 14, this.f6652i);
        zzb.m12240a(parcel, 15, this.f6655l);
        zzb.m12242a(parcel, 16, this.f6656m);
        zzb.m12258c(parcel, a);
    }
}
