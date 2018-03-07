package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzh implements Creator<AncsNotificationParcelable> {
    private static AncsNotificationParcelable m13625a(Parcel parcel) {
        String str = null;
        byte b = (byte) 0;
        int b2 = zza.b(parcel);
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i2 = zza.e(parcel, a);
                    break;
                case 2:
                    i = zza.e(parcel, a);
                    break;
                case 3:
                    str6 = zza.n(parcel, a);
                    break;
                case 4:
                    str5 = zza.n(parcel, a);
                    break;
                case 5:
                    str4 = zza.n(parcel, a);
                    break;
                case 6:
                    str3 = zza.n(parcel, a);
                    break;
                case 7:
                    str2 = zza.n(parcel, a);
                    break;
                case 8:
                    str = zza.n(parcel, a);
                    break;
                case 9:
                    b5 = zza.c(parcel, a);
                    break;
                case 10:
                    b4 = zza.c(parcel, a);
                    break;
                case 11:
                    b3 = zza.c(parcel, a);
                    break;
                case 12:
                    b = zza.c(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b2) {
            return new AncsNotificationParcelable(i2, i, str6, str5, str4, str3, str2, str, b5, b4, b3, b);
        }
        throw new zza.zza("Overread allowed size end=" + b2, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m13625a(parcel);
    }

    public Object[] newArray(int i) {
        return new AncsNotificationParcelable[i];
    }
}
