package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zze implements Creator<PlayLoggerContext> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int b = zza.m12210b(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i4 = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str4 = zza.m12224n(parcel, a);
                    break;
                case 3:
                    i3 = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    i2 = zza.m12217e(parcel, a);
                    break;
                case 5:
                    str3 = zza.m12224n(parcel, a);
                    break;
                case 6:
                    str2 = zza.m12224n(parcel, a);
                    break;
                case 7:
                    z = zza.m12212b(parcel, a);
                    break;
                case 8:
                    str = zza.m12224n(parcel, a);
                    break;
                case 9:
                    z2 = zza.m12212b(parcel, a);
                    break;
                case 10:
                    i = zza.m12217e(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new PlayLoggerContext[i];
    }
}
