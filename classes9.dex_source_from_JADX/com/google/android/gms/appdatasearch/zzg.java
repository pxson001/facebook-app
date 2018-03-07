package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzg implements Creator<GetRecentContextCall$Response> {
    public Object createFromParcel(Parcel parcel) {
        int b = zza.b(parcel);
        List list = null;
        Status status = null;
        int i = 0;
        String[] strArr = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    status = (Status) zza.a(parcel, a, Status.CREATOR);
                    break;
                case 2:
                    list = zza.c(parcel, a, UsageInfo.CREATOR);
                    break;
                case 3:
                    strArr = zza.y(parcel, a);
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
            return new GetRecentContextCall$Response(i, status, list, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new GetRecentContextCall$Response[i];
    }
}
