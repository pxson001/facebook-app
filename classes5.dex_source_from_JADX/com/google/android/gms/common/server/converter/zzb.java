package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;
import java.util.ArrayList;

public class zzb implements Creator<StringToIntConverter> {
    public Object createFromParcel(Parcel parcel) {
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
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StringToIntConverter(i, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new StringToIntConverter[i];
    }
}
