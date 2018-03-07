package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.support.v7.widget.LinearLayoutCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<BitmapTeleporter> {
    static void m12173a(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, bitmapTeleporter.f6462a);
        zzb.m12245a(parcel, 2, bitmapTeleporter.f6463b, i, false);
        zzb.m12241a(parcel, 3, bitmapTeleporter.f6464c);
        zzb.m12258c(parcel, a);
    }

    public Object createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.zza.m12210b(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = com.google.android.gms.common.internal.safeparcel.zza.m12206a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.m12205a(a)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.m12207a(parcel, a, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.m12217e(parcel, a);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.m12208a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new BitmapTeleporter(i, parcelFileDescriptor, i2);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new BitmapTeleporter[i];
    }
}
