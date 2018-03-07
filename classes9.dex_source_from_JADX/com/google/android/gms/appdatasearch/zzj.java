package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzj implements Creator<UsageInfo> {
    public Object createFromParcel(Parcel parcel) {
        DocumentContents documentContents = null;
        int i = 0;
        int b = zza.b(parcel);
        long j = 0;
        int i2 = -1;
        boolean z = false;
        String str = null;
        int i3 = 0;
        DocumentId documentId = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    documentId = (DocumentId) zza.a(parcel, a, DocumentId.CREATOR);
                    break;
                case 2:
                    j = zza.g(parcel, a);
                    break;
                case 3:
                    i3 = zza.e(parcel, a);
                    break;
                case 4:
                    str = zza.n(parcel, a);
                    break;
                case 5:
                    documentContents = (DocumentContents) zza.a(parcel, a, DocumentContents.CREATOR);
                    break;
                case 6:
                    z = zza.b(parcel, a);
                    break;
                case 7:
                    i2 = zza.e(parcel, a);
                    break;
                case 8:
                    i = zza.e(parcel, a);
                    break;
                case 1000:
                    i4 = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new UsageInfo(i4, documentId, j, i3, str, documentContents, z, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new UsageInfo[i];
    }
}
