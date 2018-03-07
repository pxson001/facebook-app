package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzad implements Creator<UserAttributeParcel> {
    public static UserAttributeParcel m13075a(Parcel parcel) {
        String str = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str3 = zza.m12224n(parcel, a);
                    break;
                case 3:
                    j = zza.m12218g(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    l = zza.m12219h(parcel, a);
                    break;
                case 5:
                    Float f2;
                    int D = zza.m12204D(parcel, a);
                    if (D == 0) {
                        f2 = null;
                    } else {
                        zza.m12211b(parcel, D, 4);
                        f2 = Float.valueOf(parcel.readFloat());
                    }
                    f = f2;
                    break;
                case 6:
                    str2 = zza.m12224n(parcel, a);
                    break;
                case 7:
                    str = zza.m12224n(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new UserAttributeParcel(i, str3, j, l, f, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m13075a(parcel);
    }

    public Object[] newArray(int i) {
        return new UserAttributeParcel[i];
    }
}
