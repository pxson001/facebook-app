package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ProxyGrpcRequest implements SafeParcelable {
    public static final Creator<ProxyGrpcRequest> CREATOR = new zza();
    public final int f3635a;
    public final String f3636b;
    public final int f3637c;
    public final long f3638d;
    public final byte[] f3639e;
    public final String f3640f;

    ProxyGrpcRequest(int i, String str, int i2, long j, byte[] bArr, String str2) {
        this.f3635a = i;
        this.f3636b = str;
        this.f3637c = i2;
        this.f3638d = j;
        this.f3639e = bArr;
        this.f3640f = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3636b, false);
        zzb.a(parcel, 1000, this.f3635a);
        zzb.a(parcel, 2, this.f3637c);
        zzb.a(parcel, 3, this.f3638d);
        zzb.a(parcel, 4, this.f3639e, false);
        zzb.a(parcel, 5, this.f3640f, false);
        zzb.c(parcel, a);
    }
}
