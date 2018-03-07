package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetFdForAssetResponse implements SafeParcelable {
    public static final Creator<GetFdForAssetResponse> CREATOR = new zzat();
    public final int f13286a;
    public final int f13287b;
    public final ParcelFileDescriptor f13288c;

    GetFdForAssetResponse(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.f13286a = i;
        this.f13287b = i2;
        this.f13288c = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = i | 1;
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13286a);
        zzb.a(parcel, 2, this.f13287b);
        zzb.a(parcel, 3, this.f13288c, i2, false);
        zzb.c(parcel, a);
    }
}
