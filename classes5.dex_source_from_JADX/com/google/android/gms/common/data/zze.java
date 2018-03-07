package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zze implements Creator<DataHolder> {
    public static DataHolder m12180a(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int b = zza.m12210b(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    strArr = zza.m12235y(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    cursorWindowArr = (CursorWindow[]) zza.m12213b(parcel, a, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    bundle = zza.m12226p(parcel, a);
                    break;
                case 1000:
                    i2 = zza.m12217e(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() != b) {
            throw new zza.zza("Overread allowed size end=" + b, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.m12163a();
        return dataHolder;
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12180a(parcel);
    }

    public Object[] newArray(int i) {
        return new DataHolder[i];
    }
}
