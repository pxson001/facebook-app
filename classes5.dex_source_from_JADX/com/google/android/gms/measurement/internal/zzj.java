package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzj implements Creator<EventParcel> {
    public static EventParcel m13080a(Parcel parcel) {
        String str = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str2 = zza.m12224n(parcel, a);
                    break;
                case 3:
                    eventParams = (EventParams) zza.m12207a(parcel, a, EventParams.CREATOR);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    str = zza.m12224n(parcel, a);
                    break;
                case 5:
                    j = zza.m12218g(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParcel(i, str2, eventParams, str, j);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m13080a(parcel);
    }

    public Object[] newArray(int i) {
        return new EventParcel[i];
    }
}
