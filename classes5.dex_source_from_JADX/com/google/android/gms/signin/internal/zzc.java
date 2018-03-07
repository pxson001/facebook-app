package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzc implements Creator<CheckServerAuthResult> {
    public Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int b = zza.m12210b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    z = zza.m12212b(parcel, a);
                    break;
                case 3:
                    list = zza.m12215c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }
}
