package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class zza implements Creator<ProxyGrpcRequest> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        long j = 0;
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                case 3:
                    j = com.google.android.gms.common.internal.safeparcel.zza.g(parcel, a);
                    break;
                case 4:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.q(parcel, a);
                    break;
                case 5:
                    str = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ProxyGrpcRequest(i2, str2, i, j, bArr, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ProxyGrpcRequest[i];
    }
}
