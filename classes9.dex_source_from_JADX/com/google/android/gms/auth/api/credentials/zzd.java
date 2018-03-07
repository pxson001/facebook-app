package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzd implements Creator<HintRequest> {
    public Object createFromParcel(Parcel parcel) {
        String[] strArr = null;
        boolean z = false;
        int b = zza.b(parcel);
        boolean z2 = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    credentialPickerConfig = (CredentialPickerConfig) zza.a(parcel, a, CredentialPickerConfig.CREATOR);
                    break;
                case 2:
                    z2 = zza.b(parcel, a);
                    break;
                case 3:
                    z = zza.b(parcel, a);
                    break;
                case 4:
                    strArr = zza.y(parcel, a);
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
            return new HintRequest(i, credentialPickerConfig, z2, z, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new HintRequest[i];
    }
}
