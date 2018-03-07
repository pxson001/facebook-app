package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
import java.util.List;

public class zzc implements Creator<ScopeDetail> {
    public Object createFromParcel(Parcel parcel) {
        FACLData fACLData = null;
        int b = zza.m12210b(parcel);
        int i = 0;
        List arrayList = new ArrayList();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.m12206a(parcel);
            switch (zza.m12205a(a)) {
                case 1:
                    i = zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    str5 = zza.m12224n(parcel, a);
                    break;
                case 3:
                    str4 = zza.m12224n(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    str3 = zza.m12224n(parcel, a);
                    break;
                case 5:
                    str2 = zza.m12224n(parcel, a);
                    break;
                case 6:
                    str = zza.m12224n(parcel, a);
                    break;
                case 7:
                    arrayList = zza.m12201A(parcel, a);
                    break;
                case 8:
                    fACLData = (FACLData) zza.m12207a(parcel, a, FACLData.CREATOR);
                    break;
                default:
                    zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ScopeDetail(i, str5, str4, str3, str2, str, arrayList, fACLData);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ScopeDetail[i];
    }
}
