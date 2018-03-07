package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbd implements Creator<LargeAssetEnqueueRequest> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int b = zza.b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    str3 = zza.n(parcel, a);
                    break;
                case 3:
                    str2 = zza.n(parcel, a);
                    break;
                case 4:
                    uri = (Uri) zza.a(parcel, a, Uri.CREATOR);
                    break;
                case 5:
                    str = zza.n(parcel, a);
                    break;
                case 6:
                    z3 = zza.b(parcel, a);
                    break;
                case 7:
                    z2 = zza.b(parcel, a);
                    break;
                case 8:
                    z = zza.b(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LargeAssetEnqueueRequest(i, str3, str2, uri, str, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new LargeAssetEnqueueRequest[i];
    }
}
