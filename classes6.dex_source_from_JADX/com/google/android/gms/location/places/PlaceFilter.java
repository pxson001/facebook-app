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

public final class PlaceFilter extends zza implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    public final int f6437a;
    public final List<Integer> f6438b;
    public final boolean f6439c;
    public final List<UserDataType> f6440d;
    public final List<String> f6441e;
    public final Set<Integer> f6442f;
    private final Set<UserDataType> f6443g;
    public final Set<String> f6444h;

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int i, List<Integer> list, boolean z, List<String> list2, List<UserDataType> list3) {
        this.f6437a = i;
        this.f6438b = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f6439c = z;
        this.f6440d = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.f6441e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f6442f = zza.m8962a(this.f6438b);
        this.f6443g = zza.m8962a(this.f6440d);
        this.f6444h = zza.m8962a(this.f6441e);
    }

    private PlaceFilter(Collection<Integer> collection, boolean z, Collection<String> collection2, Collection<UserDataType> collection3) {
        this(0, zza.m8963c(collection), z, zza.m8963c(collection2), zza.m8963c(collection3));
    }

    private PlaceFilter(boolean z, Collection<String> collection) {
        this(null, z, collection, null);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.f6442f.equals(placeFilter.f6442f) && this.f6439c == placeFilter.f6439c && this.f6443g.equals(placeFilter.f6443g) && this.f6444h.equals(placeFilter.f6444h);
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f6442f, Boolean.valueOf(this.f6439c), this.f6443g, this.f6444h});
    }

    public final String toString() {
        zza a = zzw.a(this);
        if (!this.f6442f.isEmpty()) {
            a.a("types", this.f6442f);
        }
        a.a("requireOpenNow", Boolean.valueOf(this.f6439c));
        if (!this.f6444h.isEmpty()) {
            a.a("placeIds", this.f6444h);
        }
        if (!this.f6443g.isEmpty()) {
            a.a("requestedUserDataTypes", this.f6443g);
        }
        return a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6438b, false);
        zzb.a(parcel, 1000, this.f6437a);
        zzb.a(parcel, 3, this.f6439c);
        zzb.c(parcel, 4, this.f6440d, false);
        zzb.b(parcel, 6, this.f6441e, false);
        zzb.c(parcel, a);
    }
}
