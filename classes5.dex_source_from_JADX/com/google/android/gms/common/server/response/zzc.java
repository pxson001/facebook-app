package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import java.util.ArrayList;

public class zzc implements Creator<FieldMappingDictionary> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    arrayList = zza.m12215c(parcel, a, Entry.CREATOR);
                    break;
                case 3:
                    str = zza.m12224n(parcel, a);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new FieldMappingDictionary[i];
    }
}
