package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc implements Creator<LogEvent> {
    public Object createFromParcel(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    j2 = zza.m12218g(parcel, a);
                    break;
                case 3:
                    str = zza.m12224n(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    bArr = zza.m12227q(parcel, a);
                    break;
                case 5:
                    bundle = zza.m12226p(parcel, a);
                    break;
                case 6:
                    j = zza.m12218g(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LogEvent(i, j2, j, str, bArr, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new LogEvent[i];
    }
}
