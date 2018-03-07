package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Collection;

public class zzc implements Creator<AutocompleteFilter> {
    public static AutocompleteFilter m9129a(Parcel parcel) {
        boolean z = false;
        int b = zza.b(parcel);
        Collection collection = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    z = zza.b(parcel, a);
                    break;
                case 2:
                    collection = zza.z(parcel, a);
                    break;
                case 1000:
                    i = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AutocompleteFilter(i, z, collection);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9129a(parcel);
    }

    public Object[] newArray(int i) {
        return new AutocompleteFilter[i];
    }
}
