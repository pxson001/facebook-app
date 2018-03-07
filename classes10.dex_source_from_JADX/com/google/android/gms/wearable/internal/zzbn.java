package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbn implements Creator<MessageEventParcelable> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = zza.b(parcel);
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i2 = zza.e(parcel, a);
                    break;
                case 2:
                    i = zza.e(parcel, a);
                    break;
                case 3:
                    str2 = zza.n(parcel, a);
                    break;
                case 4:
                    bArr = zza.q(parcel, a);
                    break;
                case 5:
                    str = zza.n(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new MessageEventParcelable(i2, i, str2, bArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new MessageEventParcelable[i];
    }
}
