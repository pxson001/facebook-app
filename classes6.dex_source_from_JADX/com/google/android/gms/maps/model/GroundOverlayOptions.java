package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.dynamic.zzd.zza;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final int f6734a;
    public BitmapDescriptor f6735b;
    public LatLng f6736c;
    public float f6737d;
    public float f6738e;
    public LatLngBounds f6739f;
    public float f6740g;
    public float f6741h;
    public boolean f6742i;
    public float f6743j;
    public float f6744k;
    public float f6745l;

    public GroundOverlayOptions() {
        this.f6742i = true;
        this.f6743j = 0.0f;
        this.f6744k = 0.5f;
        this.f6745l = 0.5f;
        this.f6734a = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.f6742i = true;
        this.f6743j = 0.0f;
        this.f6744k = 0.5f;
        this.f6745l = 0.5f;
        this.f6734a = i;
        this.f6735b = new BitmapDescriptor(zza.a(iBinder));
        this.f6736c = latLng;
        this.f6737d = f;
        this.f6738e = f2;
        this.f6739f = latLngBounds;
        this.f6740g = f3;
        this.f6741h = f4;
        this.f6742i = z;
        this.f6743j = f5;
        this.f6744k = f6;
        this.f6745l = f7;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6734a);
        zzb.a(parcel, 2, this.f6735b.f6718a.asBinder(), false);
        zzb.a(parcel, 3, this.f6736c, i, false);
        zzb.a(parcel, 4, this.f6737d);
        zzb.a(parcel, 5, this.f6738e);
        zzb.a(parcel, 6, this.f6739f, i, false);
        zzb.a(parcel, 7, this.f6740g);
        zzb.a(parcel, 8, this.f6741h);
        zzb.a(parcel, 9, this.f6742i);
        zzb.a(parcel, 10, this.f6743j);
        zzb.a(parcel, 11, this.f6744k);
        zzb.a(parcel, 12, this.f6745l);
        zzb.c(parcel, a);
    }
}
