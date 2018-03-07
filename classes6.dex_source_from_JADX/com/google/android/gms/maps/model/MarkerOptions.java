package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.dynamic.zzd.zza;

public final class MarkerOptions implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public final int f6757a;
    public LatLng f6758b;
    public String f6759c;
    public String f6760d;
    public BitmapDescriptor f6761e;
    public float f6762f;
    public float f6763g;
    public boolean f6764h;
    public boolean f6765i;
    public boolean f6766j;
    public float f6767k;
    public float f6768l;
    public float f6769m;
    public float f6770n;

    public MarkerOptions() {
        this.f6762f = 0.5f;
        this.f6763g = 1.0f;
        this.f6765i = true;
        this.f6766j = false;
        this.f6767k = 0.0f;
        this.f6768l = 0.5f;
        this.f6769m = 0.0f;
        this.f6770n = 1.0f;
        this.f6757a = 1;
    }

    MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6) {
        this.f6762f = 0.5f;
        this.f6763g = 1.0f;
        this.f6765i = true;
        this.f6766j = false;
        this.f6767k = 0.0f;
        this.f6768l = 0.5f;
        this.f6769m = 0.0f;
        this.f6770n = 1.0f;
        this.f6757a = i;
        this.f6758b = latLng;
        this.f6759c = str;
        this.f6760d = str2;
        this.f6761e = iBinder == null ? null : new BitmapDescriptor(zza.a(iBinder));
        this.f6762f = f;
        this.f6763g = f2;
        this.f6764h = z;
        this.f6765i = z2;
        this.f6766j = z3;
        this.f6767k = f3;
        this.f6768l = f4;
        this.f6769m = f5;
        this.f6770n = f6;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6757a);
        zzb.a(parcel, 2, this.f6758b, i, false);
        zzb.a(parcel, 3, this.f6759c, false);
        zzb.a(parcel, 4, this.f6760d, false);
        zzb.a(parcel, 5, this.f6761e == null ? null : this.f6761e.f6718a.asBinder(), false);
        zzb.a(parcel, 6, this.f6762f);
        zzb.a(parcel, 7, this.f6763g);
        zzb.a(parcel, 8, this.f6764h);
        zzb.a(parcel, 9, this.f6765i);
        zzb.a(parcel, 10, this.f6766j);
        zzb.a(parcel, 11, this.f6767k);
        zzb.a(parcel, 12, this.f6768l);
        zzb.a(parcel, 13, this.f6769m);
        zzb.a(parcel, 14, this.f6770n);
        zzb.c(parcel, a);
    }
}
