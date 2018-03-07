package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import java.util.List;

public class zza implements Creator<ApplicationMetadata> {
    public Object createFromParcel(Parcel parcel) {
        Uri uri = null;
        int b = com.google.android.gms.common.internal.safeparcel.zza.b(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.a(a)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.e(parcel, a);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 4:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.c(parcel, a, WebImage.CREATOR);
                    break;
                case 5:
                    list = com.google.android.gms.common.internal.safeparcel.zza.A(parcel, a);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.n(parcel, a);
                    break;
                case 7:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a, Uri.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new ApplicationMetadata[i];
    }
}
