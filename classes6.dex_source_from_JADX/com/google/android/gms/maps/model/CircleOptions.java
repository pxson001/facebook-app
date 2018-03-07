package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class CircleOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final int f6726a;
    public LatLng f6727b;
    public double f6728c;
    public float f6729d;
    public int f6730e;
    public int f6731f;
    public float f6732g;
    public boolean f6733h;

    public CircleOptions() {
        this.f6727b = null;
        this.f6728c = 0.0d;
        this.f6729d = 10.0f;
        this.f6730e = -16777216;
        this.f6731f = 0;
        this.f6732g = 0.0f;
        this.f6733h = true;
        this.f6726a = 1;
    }

    CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z) {
        this.f6727b = null;
        this.f6728c = 0.0d;
        this.f6729d = 10.0f;
        this.f6730e = -16777216;
        this.f6731f = 0;
        this.f6732g = 0.0f;
        this.f6733h = true;
        this.f6726a = i;
        this.f6727b = latLng;
        this.f6728c = d;
        this.f6729d = f;
        this.f6730e = i2;
        this.f6731f = i3;
        this.f6732g = f2;
        this.f6733h = z;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6726a);
        zzb.a(parcel, 2, this.f6727b, i, false);
        zzb.a(parcel, 3, this.f6728c);
        zzb.a(parcel, 4, this.f6729d);
        zzb.a(parcel, 5, this.f6730e);
        zzb.a(parcel, 6, this.f6731f);
        zzb.a(parcel, 7, this.f6732g);
        zzb.a(parcel, 8, this.f6733h);
        zzb.c(parcel, a);
    }
}
