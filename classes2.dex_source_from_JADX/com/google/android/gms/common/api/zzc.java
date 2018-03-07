package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc implements Creator<Scope> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    i = zza.e(parcel, a);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    str = zza.n(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Scope(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new Scope[i];
    }
}
