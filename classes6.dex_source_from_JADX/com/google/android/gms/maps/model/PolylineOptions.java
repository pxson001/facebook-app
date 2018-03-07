package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    public final int f6785a;
    public final List<LatLng> f6786b;
    public float f6787c;
    public int f6788d;
    public float f6789e;
    public boolean f6790f;
    public boolean f6791g;

    public PolylineOptions() {
        this.f6787c = 10.0f;
        this.f6788d = -16777216;
        this.f6789e = 0.0f;
        this.f6790f = true;
        this.f6791g = false;
        this.f6785a = 1;
        this.f6786b = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int i2, float f2, boolean z, boolean z2) {
        this.f6787c = 10.0f;
        this.f6788d = -16777216;
        this.f6789e = 0.0f;
        this.f6790f = true;
        this.f6791g = false;
        this.f6785a = i;
        this.f6786b = list;
        this.f6787c = f;
        this.f6788d = i2;
        this.f6789e = f2;
        this.f6790f = z;
        this.f6791g = z2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6785a);
        zzb.c(parcel, 2, this.f6786b, false);
        zzb.a(parcel, 3, this.f6787c);
        zzb.a(parcel, 4, this.f6788d);
        zzb.a(parcel, 5, this.f6789e);
        zzb.a(parcel, 6, this.f6790f);
        zzb.a(parcel, 7, this.f6791g);
        zzb.c(parcel, a);
    }
}
