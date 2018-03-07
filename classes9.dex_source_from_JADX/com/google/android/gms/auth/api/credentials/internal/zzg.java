package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzg implements Creator<DeleteRequest> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        Credential credential = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    credential = (Credential) zza.a(parcel, a, Credential.CREATOR);
                    break;
                case 1000:
                    i = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new DeleteRequest(i, credential);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new DeleteRequest[i];
    }
}
