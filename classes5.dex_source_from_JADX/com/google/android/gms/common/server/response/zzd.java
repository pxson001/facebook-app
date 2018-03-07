package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;
import java.util.ArrayList;

public class zzd implements Creator<Entry> {
    public Object createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str = zza.m12224n(parcel, a);
                    break;
                case 3:
                    arrayList = zza.m12215c(parcel, a, FieldMapPair.CREATOR);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Entry(i, str, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new Entry[i];
    }
}
