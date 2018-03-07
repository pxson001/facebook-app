package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzo implements Creator<ParcelableGeofence> {
    public static ParcelableGeofence m8953a(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    str = zza.n(parcel, a);
                    break;
                case 2:
                    j = zza.g(parcel, a);
                    break;
                case 3:
                    s = zza.d(parcel, a);
                    break;
                case 4:
                    d = zza.l(parcel, a);
                    break;
                case 5:
                    d2 = zza.l(parcel, a);
                    break;
                case 6:
                    f = zza.j(parcel, a);
                    break;
                case 7:
                    i2 = zza.e(parcel, a);
                    break;
                case 8:
                    i3 = zza.e(parcel, a);
                    break;
                case 9:
                    i4 = zza.e(parcel, a);
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
            return new ParcelableGeofence(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8953a(parcel);
    }

    public Object[] newArray(int i) {
        return new ParcelableGeofence[i];
    }
}
