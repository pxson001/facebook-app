package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbf implements Creator<LargeAssetQueueEntryParcelable> {
    private static LargeAssetQueueEntryParcelable m13561a(Parcel parcel) {
        Uri uri = null;
        boolean z = false;
        int b = zza.b(parcel);
        long j = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        String str = null;
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i3 = zza.e(parcel, a);
                    break;
                case 2:
                    j = zza.g(parcel, a);
                    break;
                case 3:
                    i2 = zza.e(parcel, a);
                    break;
                case 4:
                    str2 = zza.n(parcel, a);
                    break;
                case 5:
                    str = zza.n(parcel, a);
                    break;
                case 6:
                    uri = (Uri) zza.a(parcel, a, Uri.CREATOR);
                    break;
                case 8:
                    i = zza.e(parcel, a);
                    break;
                case 9:
                    z3 = zza.b(parcel, a);
                    break;
                case 10:
                    z2 = zza.b(parcel, a);
                    break;
                case 11:
                    z = zza.b(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LargeAssetQueueEntryParcelable(i3, j, i2, str2, str, uri, i, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m13561a(parcel);
    }

    public Object[] newArray(int i) {
        return new LargeAssetQueueEntryParcelable[i];
    }
}
