package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final int f6663a;
    public StreetViewPanoramaCamera f6664b;
    public String f6665c;
    public LatLng f6666d;
    public Integer f6667e;
    public Boolean f6668f;
    public Boolean f6669g;
    public Boolean f6670h;
    public Boolean f6671i;
    public Boolean f6672j;

    public StreetViewPanoramaOptions() {
        this.f6668f = Boolean.valueOf(true);
        this.f6669g = Boolean.valueOf(true);
        this.f6670h = Boolean.valueOf(true);
        this.f6671i = Boolean.valueOf(true);
        this.f6663a = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.f6668f = Boolean.valueOf(true);
        this.f6669g = Boolean.valueOf(true);
        this.f6670h = Boolean.valueOf(true);
        this.f6671i = Boolean.valueOf(true);
        this.f6663a = i;
        this.f6664b = streetViewPanoramaCamera;
        this.f6666d = latLng;
        this.f6667e = num;
        this.f6665c = str;
        this.f6668f = zza.m9577a(b);
        this.f6669g = zza.m9577a(b2);
        this.f6670h = zza.m9577a(b3);
        this.f6671i = zza.m9577a(b4);
        this.f6672j = zza.m9577a(b5);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6663a);
        zzb.a(parcel, 2, this.f6664b, i, false);
        zzb.a(parcel, 3, this.f6665c, false);
        zzb.a(parcel, 4, this.f6666d, i, false);
        Integer num = this.f6667e;
        if (num != null) {
            zzb.b(parcel, 5, 4);
            parcel.writeInt(num.intValue());
        } else if (null != null) {
            zzb.b(parcel, 5, 0);
        }
        zzb.a(parcel, 6, zza.m9576a(this.f6668f));
        zzb.a(parcel, 7, zza.m9576a(this.f6669g));
        zzb.a(parcel, 8, zza.m9576a(this.f6670h));
        zzb.a(parcel, 9, zza.m9576a(this.f6671i));
        zzb.a(parcel, 10, zza.m9576a(this.f6672j));
        zzb.c(parcel, a);
    }
}
