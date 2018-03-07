package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class CameraPosition implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final LatLng f6720a;
    public final float f6721b;
    public final float f6722c;
    public final float f6723d;
    public final int f6724e;

    CameraPosition(int i, LatLng latLng, float f, float f2, float f3) {
        zzx.a(latLng, "null camera target");
        boolean z = 0.0f <= f2 && f2 <= 90.0f;
        zzx.b(z, "Tilt needs to be between 0 and 90 inclusive: %s", new Object[]{Float.valueOf(f2)});
        this.f6724e = i;
        this.f6720a = latLng;
        this.f6721b = f;
        this.f6722c = f2 + 0.0f;
        if (((double) f3) <= 0.0d) {
            f3 = (f3 % 360.0f) + 360.0f;
        }
        this.f6723d = f3 % 360.0f;
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        this(1, latLng, f, f2, f3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f6720a.equals(cameraPosition.f6720a) && Float.floatToIntBits(this.f6721b) == Float.floatToIntBits(cameraPosition.f6721b) && Float.floatToIntBits(this.f6722c) == Float.floatToIntBits(cameraPosition.f6722c) && Float.floatToIntBits(this.f6723d) == Float.floatToIntBits(cameraPosition.f6723d);
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f6720a, Float.valueOf(this.f6721b), Float.valueOf(this.f6722c), Float.valueOf(this.f6723d)});
    }

    public final String toString() {
        return zzw.a(this).a("target", this.f6720a).a("zoom", Float.valueOf(this.f6721b)).a("tilt", Float.valueOf(this.f6722c)).a("bearing", Float.valueOf(this.f6723d)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6724e);
        zzb.a(parcel, 2, this.f6720a, i, false);
        zzb.a(parcel, 3, this.f6721b);
        zzb.a(parcel, 4, this.f6722c);
        zzb.a(parcel, 5, this.f6723d);
        zzb.c(parcel, a);
    }
}
