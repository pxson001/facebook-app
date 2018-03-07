package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<DocumentContents> {
    public Object createFromParcel(Parcel parcel) {
        boolean z = false;
        Account account = null;
        int b = zza.b(parcel);
        String str = null;
        DocumentSection[] documentSectionArr = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    documentSectionArr = (DocumentSection[]) zza.b(parcel, a, DocumentSection.CREATOR);
                    break;
                case 2:
                    str = zza.n(parcel, a);
                    break;
                case 3:
                    z = zza.b(parcel, a);
                    break;
                case 4:
                    account = (Account) zza.a(parcel, a, Account.CREATOR);
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
            return new DocumentContents(i, documentSectionArr, str, z, account);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new DocumentContents[i];
    }
}
