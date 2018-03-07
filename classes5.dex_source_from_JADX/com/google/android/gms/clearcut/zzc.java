package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzc implements Creator<LogEventParcelable> {
    public static LogEventParcelable m12124a(Parcel parcel) {
        int b = zza.m12210b(parcel);
        byte[] bArr = null;
        PlayLoggerContext playLoggerContext = null;
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    playLoggerContext = (PlayLoggerContext) zza.m12207a(parcel, a, PlayLoggerContext.CREATOR);
                    break;
                case 3:
                    bArr = zza.m12227q(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    iArr = zza.m12229s(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LogEventParcelable(i, playLoggerContext, bArr, iArr);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12124a(parcel);
    }

    public Object[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
