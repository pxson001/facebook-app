package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class PlaceAlias implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public static final PlaceAlias f6596a = new PlaceAlias(0, "Home");
    public static final PlaceAlias f6597b = new PlaceAlias(0, "Work");
    public final int f6598c;
    public final String f6599d;

    PlaceAlias(int i, String str) {
        this.f6598c = i;
        this.f6599d = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceAlias)) {
            return false;
        }
        return zzw.a(this.f6599d, ((PlaceAlias) obj).f6599d);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f6599d});
    }

    public String toString() {
        return zzw.a(this).a("alias", this.f6599d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6599d, false);
        zzb.a(parcel, 1000, this.f6598c);
        zzb.c(parcel, a);
    }
}
