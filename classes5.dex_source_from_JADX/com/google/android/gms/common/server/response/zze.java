package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zze implements Creator<SafeParcelResponse> {
    public Object createFromParcel(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    parcel2 = zza.m12202B(parcel, a);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) zza.m12207a(parcel, a, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new SafeParcelResponse[i];
    }
}
