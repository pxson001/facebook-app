package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzi implements Creator<PutDataRequest> {
    public Object createFromParcel(Parcel parcel) {
        byte[] bArr = null;
        int b = zza.b(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    uri = (Uri) zza.a(parcel, a, Uri.CREATOR);
                    break;
                case 4:
                    bundle = zza.p(parcel, a);
                    break;
                case 5:
                    bArr = zza.q(parcel, a);
                    break;
                case 6:
                    j = zza.g(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PutDataRequest(i, uri, bundle, bArr, j);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new PutDataRequest[i];
    }
}
