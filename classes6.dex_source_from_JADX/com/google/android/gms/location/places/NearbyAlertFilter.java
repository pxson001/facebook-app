package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class NearbyAlertFilter extends zza implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public final int f6420a;
    public final List<String> f6421b;
    public final List<Integer> f6422c;
    public final List<UserDataType> f6423d;
    private final Set<String> f6424e;
    private final Set<Integer> f6425f;
    private final Set<UserDataType> f6426g;

    NearbyAlertFilter(int i, List<String> list, List<Integer> list2, List<UserDataType> list3) {
        this.f6420a = i;
        this.f6422c = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f6423d = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.f6421b = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f6425f = zza.m8962a(this.f6422c);
        this.f6426g = zza.m8962a(this.f6423d);
        this.f6424e = zza.m8962a(this.f6421b);
    }

    public static NearbyAlertFilter m8964a(Collection<String> collection) {
        if (collection != null && !collection.isEmpty()) {
            return new NearbyAlertFilter(0, zza.m8963c(collection), null, null);
        }
        throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace ID to match results with.");
    }

    public static NearbyAlertFilter m8965b(Collection<Integer> collection) {
        if (collection != null && !collection.isEmpty()) {
            return new NearbyAlertFilter(0, null, zza.m8963c(collection), null);
        }
        throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace type to match results with.");
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyAlertFilter)) {
            return false;
        }
        NearbyAlertFilter nearbyAlertFilter = (NearbyAlertFilter) obj;
        return this.f6425f.equals(nearbyAlertFilter.f6425f) && this.f6426g.equals(nearbyAlertFilter.f6426g) && this.f6424e.equals(nearbyAlertFilter.f6424e);
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f6425f, this.f6426g, this.f6424e});
    }

    public final String toString() {
        zza a = zzw.a(this);
        if (!this.f6425f.isEmpty()) {
            a.a("types", this.f6425f);
        }
        if (!this.f6424e.isEmpty()) {
            a.a("placeIds", this.f6424e);
        }
        if (!this.f6426g.isEmpty()) {
            a.a("requestedUserDataTypes", this.f6426g);
        }
        return a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.b(parcel, 1, this.f6421b, false);
        zzb.a(parcel, 1000, this.f6420a);
        zzb.a(parcel, 2, this.f6422c, false);
        zzb.c(parcel, 3, this.f6423d, false);
        zzb.c(parcel, a);
    }
}
