package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zze implements Creator<Asset> {
    public Object createFromParcel(Parcel parcel) {
        Uri uri = null;
        int b = zza.b(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    bArr = zza.q(parcel, a);
                    break;
                case 3:
                    str = zza.n(parcel, a);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.a(parcel, a, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    uri = (Uri) zza.a(parcel, a, Uri.CREATOR);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new Asset[i];
    }
}
