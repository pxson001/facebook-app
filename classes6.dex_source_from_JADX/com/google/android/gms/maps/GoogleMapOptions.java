package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final int f6635a;
    public Boolean f6636b;
    public Boolean f6637c;
    public int f6638d;
    public CameraPosition f6639e;
    public Boolean f6640f;
    public Boolean f6641g;
    public Boolean f6642h;
    public Boolean f6643i;
    public Boolean f6644j;
    public Boolean f6645k;
    public Boolean f6646l;
    public Boolean f6647m;
    public Boolean f6648n;

    public GoogleMapOptions() {
        this.f6638d = -1;
        this.f6635a = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11) {
        this.f6638d = -1;
        this.f6635a = i;
        this.f6636b = zza.m9577a(b);
        this.f6637c = zza.m9577a(b2);
        this.f6638d = i2;
        this.f6639e = cameraPosition;
        this.f6640f = zza.m9577a(b3);
        this.f6641g = zza.m9577a(b4);
        this.f6642h = zza.m9577a(b5);
        this.f6643i = zza.m9577a(b6);
        this.f6644j = zza.m9577a(b7);
        this.f6645k = zza.m9577a(b8);
        this.f6646l = zza.m9577a(b9);
        this.f6647m = zza.m9577a(b10);
        this.f6648n = zza.m9577a(b11);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6635a);
        zzb.a(parcel, 2, zza.m9576a(this.f6636b));
        zzb.a(parcel, 3, zza.m9576a(this.f6637c));
        zzb.a(parcel, 4, this.f6638d);
        zzb.a(parcel, 5, this.f6639e, i, false);
        zzb.a(parcel, 6, zza.m9576a(this.f6640f));
        zzb.a(parcel, 7, zza.m9576a(this.f6641g));
        zzb.a(parcel, 8, zza.m9576a(this.f6642h));
        zzb.a(parcel, 9, zza.m9576a(this.f6643i));
        zzb.a(parcel, 10, zza.m9576a(this.f6644j));
        zzb.a(parcel, 11, zza.m9576a(this.f6645k));
        zzb.a(parcel, 12, zza.m9576a(this.f6646l));
        zzb.a(parcel, 14, zza.m9576a(this.f6647m));
        zzb.a(parcel, 15, zza.m9576a(this.f6648n));
        zzb.c(parcel, a);
    }
}
