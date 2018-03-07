package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<AppMetadata> {
    public static AppMetadata m13076a(Parcel parcel) {
        long j = 0;
        boolean z = false;
        String str = null;
        int b = zza.m12210b(parcel);
        long j2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str5 = zza.m12224n(parcel, a);
                    break;
                case 3:
                    str4 = zza.m12224n(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    str3 = zza.m12224n(parcel, a);
                    break;
                case 5:
                    str2 = zza.m12224n(parcel, a);
                    break;
                case 6:
                    j2 = zza.m12218g(parcel, a);
                    break;
                case 7:
                    j = zza.m12218g(parcel, a);
                    break;
                case 8:
                    str = zza.m12224n(parcel, a);
                    break;
                case 9:
                    z = zza.m12212b(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AppMetadata(i, str5, str4, str3, str2, j2, j, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m13076a(parcel);
    }

    public Object[] newArray(int i) {
        return new AppMetadata[i];
    }
}
