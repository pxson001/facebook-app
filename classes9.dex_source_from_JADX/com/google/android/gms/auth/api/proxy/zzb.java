package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<ProxyRequest> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = zza.b(parcel);
        long j = 0;
        byte[] bArr = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    str = zza.n(parcel, a);
                    break;
                case 2:
                    i = zza.e(parcel, a);
                    break;
                case 3:
                    j = zza.g(parcel, a);
                    break;
                case 4:
                    bArr = zza.q(parcel, a);
                    break;
                case 5:
                    bundle = zza.p(parcel, a);
                    break;
                case 1000:
                    i2 = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ProxyRequest(i2, str, i, j, bArr, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
