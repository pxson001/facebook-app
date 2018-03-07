package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ProxyResponse implements SafeParcelable {
    public static final Creator<ProxyResponse> CREATOR = new zzc();
    public final int f3656a;
    public final int f3657b;
    public final PendingIntent f3658c;
    public final int f3659d;
    public final Bundle f3660e;
    public final byte[] f3661f;

    ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.f3656a = i;
        this.f3657b = i2;
        this.f3659d = i3;
        this.f3660e = bundle;
        this.f3661f = bArr;
        this.f3658c = pendingIntent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3657b);
        zzb.a(parcel, 1000, this.f3656a);
        zzb.a(parcel, 2, this.f3658c, i, false);
        zzb.a(parcel, 3, this.f3659d);
        zzb.a(parcel, 4, this.f3660e, false);
        zzb.a(parcel, 5, this.f3661f, false);
        zzb.c(parcel, a);
    }
}
