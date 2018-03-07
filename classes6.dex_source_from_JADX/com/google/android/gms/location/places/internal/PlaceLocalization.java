package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

@Deprecated
public final class PlaceLocalization implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    public final int f6545a;
    public final String f6546b;
    public final String f6547c;
    public final String f6548d;
    public final String f6549e;
    public final List<String> f6550f;

    public PlaceLocalization(int i, String str, String str2, String str3, String str4, List<String> list) {
        this.f6545a = i;
        this.f6546b = str;
        this.f6547c = str2;
        this.f6548d = str3;
        this.f6549e = str4;
        this.f6550f = list;
    }

    public static PlaceLocalization m8999a(String str, String str2, String str3, String str4, List<String> list) {
        return new PlaceLocalization(0, str, str2, str3, str4, list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceLocalization)) {
            return false;
        }
        PlaceLocalization placeLocalization = (PlaceLocalization) obj;
        return zzw.a(this.f6546b, placeLocalization.f6546b) && zzw.a(this.f6547c, placeLocalization.f6547c) && zzw.a(this.f6548d, placeLocalization.f6548d) && zzw.a(this.f6549e, placeLocalization.f6549e) && zzw.a(this.f6550f, placeLocalization.f6550f);
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f6546b, this.f6547c, this.f6548d, this.f6549e});
    }

    public final String toString() {
        return zzw.a(this).a("name", this.f6546b).a("address", this.f6547c).a("internationalPhoneNumber", this.f6548d).a("regularOpenHours", this.f6549e).a("attributions", this.f6550f).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6546b, false);
        zzb.a(parcel, 1000, this.f6545a);
        zzb.a(parcel, 2, this.f6547c, false);
        zzb.a(parcel, 3, this.f6548d, false);
        zzb.a(parcel, 4, this.f6549e, false);
        zzb.b(parcel, 5, this.f6550f, false);
        zzb.c(parcel, a);
    }
}
