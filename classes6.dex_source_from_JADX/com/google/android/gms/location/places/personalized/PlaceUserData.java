package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public class PlaceUserData implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int f6603a;
    public final String f6604b;
    public final String f6605c;
    public final List<PlaceAlias> f6606d;

    PlaceUserData(int i, String str, String str2, List<PlaceAlias> list) {
        this.f6603a = i;
        this.f6604b = str;
        this.f6605c = str2;
        this.f6606d = list;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceUserData)) {
            return false;
        }
        PlaceUserData placeUserData = (PlaceUserData) obj;
        return this.f6604b.equals(placeUserData.f6604b) && this.f6605c.equals(placeUserData.f6605c) && this.f6606d.equals(placeUserData.f6606d);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f6604b, this.f6605c, this.f6606d});
    }

    public String toString() {
        return zzw.a(this).a("accountName", this.f6604b).a("placeId", this.f6605c).a("placeAliases", this.f6606d).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6604b, false);
        zzb.a(parcel, 1000, this.f6603a);
        zzb.a(parcel, 2, this.f6605c, false);
        zzb.c(parcel, 6, this.f6606d, false);
        zzb.c(parcel, a);
    }
}
