package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc implements Creator<ProxyResponse> {
    public Object createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int i = 0;
        int b = zza.b(parcel);
        Bundle bundle = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i2 = zza.e(parcel, a);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) zza.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 3:
                    i = zza.e(parcel, a);
                    break;
                case 4:
                    bundle = zza.p(parcel, a);
                    break;
                case 5:
                    bArr = zza.q(parcel, a);
                    break;
                case 1000:
                    i3 = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ProxyResponse(i3, i2, pendingIntent, i, bundle, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ProxyResponse[i];
    }
}
