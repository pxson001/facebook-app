package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;

public class zzq implements PlacePhotoMetadata {
    private final String f6587a;
    private final int f6588b;
    private final int f6589c;
    private final CharSequence f6590d;
    private int f6591e;

    public zzq(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.f6587a = str;
        this.f6588b = i;
        this.f6589c = i2;
        this.f6590d = charSequence;
        this.f6591e = i3;
    }

    public final Object m9106a() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq com_google_android_gms_location_places_internal_zzq = (zzq) obj;
        return com_google_android_gms_location_places_internal_zzq.f6588b == this.f6588b && com_google_android_gms_location_places_internal_zzq.f6589c == this.f6589c && zzw.a(com_google_android_gms_location_places_internal_zzq.f6587a, this.f6587a) && zzw.a(com_google_android_gms_location_places_internal_zzq.f6590d, this.f6590d);
    }

    public int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f6588b), Integer.valueOf(this.f6589c), this.f6587a, this.f6590d});
    }
}
