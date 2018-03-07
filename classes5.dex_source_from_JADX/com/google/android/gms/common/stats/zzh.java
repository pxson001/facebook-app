package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzh implements Creator<WakeLockEvent> {
    private static WakeLockEvent m12452a(Parcel parcel) {
        int b = zza.m12210b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        List list = null;
        String str2 = null;
        long j2 = 0;
        int i4 = 0;
        String str3 = null;
        String str4 = null;
        float f = 0.0f;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    j = zza.m12218g(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    str = zza.m12224n(parcel, a);
                    break;
                case 5:
                    i3 = zza.m12217e(parcel, a);
                    break;
                case 6:
                    list = zza.m12201A(parcel, a);
                    break;
                case 8:
                    j2 = zza.m12218g(parcel, a);
                    break;
                case 10:
                    str3 = zza.m12224n(parcel, a);
                    break;
                case 11:
                    i2 = zza.m12217e(parcel, a);
                    break;
                case 12:
                    str2 = zza.m12224n(parcel, a);
                    break;
                case 13:
                    str4 = zza.m12224n(parcel, a);
                    break;
                case 14:
                    i4 = zza.m12217e(parcel, a);
                    break;
                case 15:
                    f = zza.m12221j(parcel, a);
                    break;
                case 16:
                    j3 = zza.m12218g(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new WakeLockEvent(i, j, i2, str, i3, list, str2, j2, i4, str3, str4, f, j3);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12452a(parcel);
    }

    public Object[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
