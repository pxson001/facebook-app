package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public class zza implements Creator<Credential> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        List list = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a)) {
                case 1:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 2:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 3:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a, Uri.CREATOR);
                    break;
                case 4:
                    list = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a, IdToken.CREATOR);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 7:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Credential(i, str6, str5, uri, list, str4, str3, str2, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new Credential[i];
    }
}
