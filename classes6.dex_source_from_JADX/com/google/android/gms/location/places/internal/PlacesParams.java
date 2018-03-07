package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class PlacesParams implements SafeParcelable {
    public static final zzt CREATOR = new zzt();
    public static final PlacesParams f6551a = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
    public final int f6552b;
    public final String f6553c;
    public final String f6554d;
    public final String f6555e;
    public final String f6556f;
    public final int f6557g;
    public final int f6558h;

    public PlacesParams(int i, String str, String str2, String str3, String str4, int i2, int i3) {
        this.f6552b = i;
        this.f6553c = str;
        this.f6554d = str2;
        this.f6555e = str3;
        this.f6556f = str4;
        this.f6557g = i2;
        this.f6558h = i3;
    }

    private PlacesParams(String str, Locale locale, String str2) {
        this(3, str, locale.toString(), str2, null, GoogleApiAvailability.a, 0);
    }

    public PlacesParams(String str, Locale locale, String str2, String str3, int i) {
        this(3, str, locale.toString(), str2, str3, GoogleApiAvailability.a, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PlacesParams)) {
            return false;
        }
        PlacesParams placesParams = (PlacesParams) obj;
        return this.f6557g == placesParams.f6557g && this.f6558h == placesParams.f6558h && this.f6554d.equals(placesParams.f6554d) && this.f6553c.equals(placesParams.f6553c) && zzw.a(this.f6555e, placesParams.f6555e) && zzw.a(this.f6556f, placesParams.f6556f);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f6553c, this.f6554d, this.f6555e, this.f6556f, Integer.valueOf(this.f6557g), Integer.valueOf(this.f6558h)});
    }

    public String toString() {
        return zzw.a(this).a("clientPackageName", this.f6553c).a("locale", this.f6554d).a("accountName", this.f6555e).a("gCoreClientName", this.f6556f).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6553c, false);
        zzb.a(parcel, 1000, this.f6552b);
        zzb.a(parcel, 2, this.f6554d, false);
        zzb.a(parcel, 3, this.f6555e, false);
        zzb.a(parcel, 4, this.f6556f, false);
        zzb.a(parcel, 6, this.f6557g);
        zzb.a(parcel, 7, this.f6558h);
        zzb.c(parcel, a);
    }
}
