package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc implements Creator<CredentialRequest> {
    public Object createFromParcel(Parcel parcel) {
        boolean z = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int b = zza.b(parcel);
        CredentialPickerConfig credentialPickerConfig2 = null;
        String[] strArr = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    z = zza.b(parcel, a);
                    break;
                case 2:
                    strArr = zza.y(parcel, a);
                    break;
                case 3:
                    credentialPickerConfig2 = (CredentialPickerConfig) zza.a(parcel, a, CredentialPickerConfig.CREATOR);
                    break;
                case 4:
                    credentialPickerConfig = (CredentialPickerConfig) zza.a(parcel, a, CredentialPickerConfig.CREATOR);
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
            return new CredentialRequest(i, z, strArr, credentialPickerConfig2, credentialPickerConfig);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
