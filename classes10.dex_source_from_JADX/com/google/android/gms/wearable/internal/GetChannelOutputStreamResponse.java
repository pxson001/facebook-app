package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetChannelOutputStreamResponse implements SafeParcelable {
    public static final Creator<GetChannelOutputStreamResponse> CREATOR = new zzal();
    public final int f13261a;
    public final int f13262b;
    public final ParcelFileDescriptor f13263c;

    GetChannelOutputStreamResponse(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.f13261a = i;
        this.f13262b = i2;
        this.f13263c = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13261a);
        zzb.a(parcel, 2, this.f13262b);
        zzb.a(parcel, 3, this.f13263c, i, false);
        zzb.c(parcel, a);
    }
}
