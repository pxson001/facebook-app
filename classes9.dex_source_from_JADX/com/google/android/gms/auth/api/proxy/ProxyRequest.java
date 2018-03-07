package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ProxyRequest implements SafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new zzb();
    public static final int f3641a = 0;
    public static final int f3642b = 1;
    public static final int f3643c = 2;
    public static final int f3644d = 3;
    public static final int f3645e = 4;
    public static final int f3646f = 5;
    public static final int f3647g = 6;
    public static final int f3648h = 7;
    public static final int f3649i = 7;
    public final int f3650j;
    public final String f3651k;
    public final int f3652l;
    public final long f3653m;
    public final byte[] f3654n;
    public Bundle f3655o;

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.f3650j = i;
        this.f3651k = str;
        this.f3652l = i2;
        this.f3653m = j;
        this.f3654n = bArr;
        this.f3655o = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.f3651k + ", method: " + this.f3652l + " ]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3651k, false);
        zzb.a(parcel, 1000, this.f3650j);
        zzb.a(parcel, 2, this.f3652l);
        zzb.a(parcel, 3, this.f3653m);
        zzb.a(parcel, 4, this.f3654n, false);
        zzb.a(parcel, 5, this.f3655o, false);
        zzb.c(parcel, a);
    }
}
