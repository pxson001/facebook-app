package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class GetChannelInputStreamResponse implements SafeParcelable {
    public static final Creator<GetChannelInputStreamResponse> CREATOR = new zzak();
    public final int f13258a;
    public final int f13259b;
    public final ParcelFileDescriptor f13260c;

    GetChannelInputStreamResponse(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.f13258a = i;
        this.f13259b = i2;
        this.f13260c = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13258a);
        zzb.a(parcel, 2, this.f13259b);
        zzb.a(parcel, 3, this.f13260c, i, false);
        zzb.c(parcel, a);
    }
}
