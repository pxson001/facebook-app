package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<ConnectionResult> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        PendingIntent pendingIntent = null;
        int i = 0;
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    i2 = zza.e(parcel, a);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    i = zza.e(parcel, a);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) zza.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                    str = zza.n(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
