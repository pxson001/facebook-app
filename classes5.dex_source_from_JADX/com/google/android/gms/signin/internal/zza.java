package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;

public class zza implements Creator<AuthAccountResult> {
    public Object createFromParcel(Parcel parcel) {
        int i = 0;
        int b = com.google.android.gms.common.internal.safeparcel.zza.m12210b(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.m12206a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.m12205a(a)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case 3:
                    intent = (Intent) com.google.android.gms.common.internal.safeparcel.zza.m12207a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountResult(i2, i, intent);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new AuthAccountResult[i];
    }
}
