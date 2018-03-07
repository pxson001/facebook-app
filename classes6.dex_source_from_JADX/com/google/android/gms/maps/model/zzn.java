package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzn implements Creator<Tile> {
    public static Tile m9940a(Parcel parcel) {
        int i = 0;
        int b = zza.b(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i3 = zza.e(parcel, a);
                    break;
                case 2:
                    i2 = zza.e(parcel, a);
                    break;
                case 3:
                    i = zza.e(parcel, a);
                    break;
                case 4:
                    bArr = zza.q(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9940a(parcel);
    }

    public Object[] newArray(int i) {
        return new Tile[i];
    }
}
