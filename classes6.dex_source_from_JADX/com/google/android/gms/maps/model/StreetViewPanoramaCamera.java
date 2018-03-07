package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation.Builder;

public class StreetViewPanoramaCamera implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    public final float f6792a;
    public final float f6793b;
    public final float f6794c;
    public final int f6795d;
    private StreetViewPanoramaOrientation f6796e;

    StreetViewPanoramaCamera(int i, float f, float f2, float f3) {
        boolean z = -90.0f <= f2 && f2 <= 90.0f;
        zzx.b(z, "Tilt needs to be between -90 and 90 inclusive");
        this.f6795d = i;
        if (((double) f) <= 0.0d) {
            f = 0.0f;
        }
        this.f6792a = f;
        this.f6793b = f2 + 0.0f;
        this.f6794c = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        Builder builder = new Builder();
        builder.f6805b = f2;
        builder = builder;
        builder.f6804a = f3;
        builder = builder;
        this.f6796e = new StreetViewPanoramaOrientation(builder.f6805b, builder.f6804a);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f6792a) == Float.floatToIntBits(streetViewPanoramaCamera.f6792a) && Float.floatToIntBits(this.f6793b) == Float.floatToIntBits(streetViewPanoramaCamera.f6793b) && Float.floatToIntBits(this.f6794c) == Float.floatToIntBits(streetViewPanoramaCamera.f6794c);
    }

    public int hashCode() {
        return zzw.a(new Object[]{Float.valueOf(this.f6792a), Float.valueOf(this.f6793b), Float.valueOf(this.f6794c)});
    }

    public String toString() {
        return zzw.a(this).a("zoom", Float.valueOf(this.f6792a)).a("tilt", Float.valueOf(this.f6793b)).a("bearing", Float.valueOf(this.f6794c)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6795d);
        zzb.a(parcel, 2, this.f6792a);
        zzb.a(parcel, 3, this.f6793b);
        zzb.a(parcel, 4, this.f6794c);
        zzb.c(parcel, a);
    }
}
