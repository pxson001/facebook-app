package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class Tile implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    public final int f6809a;
    public final int f6810b;
    public final byte[] f6811c;
    public final int f6812d;

    Tile(int i, int i2, int i3, byte[] bArr) {
        this.f6812d = i;
        this.f6809a = i2;
        this.f6810b = i3;
        this.f6811c = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6812d);
        zzb.a(parcel, 2, this.f6809a);
        zzb.a(parcel, 3, this.f6810b);
        zzb.a(parcel, 4, this.f6811c, false);
        zzb.c(parcel, a);
    }
}
