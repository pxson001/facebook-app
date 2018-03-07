package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutocompleteFilter implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final int f6416a;
    public final boolean f6417b;
    public final List<Integer> f6418c;
    private final Set<Integer> f6419d;

    public AutocompleteFilter(int i, boolean z, Collection<Integer> collection) {
        this.f6416a = i;
        this.f6417b = z;
        this.f6418c = collection == null ? Collections.emptyList() : new ArrayList(collection);
        if (this.f6418c.isEmpty()) {
            this.f6419d = Collections.emptySet();
        } else {
            this.f6419d = Collections.unmodifiableSet(new HashSet(this.f6418c));
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
        return this.f6419d.equals(autocompleteFilter.f6419d) && this.f6417b == autocompleteFilter.f6417b;
    }

    public int hashCode() {
        return zzw.a(new Object[]{Boolean.valueOf(this.f6417b), this.f6419d});
    }

    public String toString() {
        zza a = zzw.a(this);
        if (!this.f6417b) {
            a.a("restrictedToPlaces", Boolean.valueOf(this.f6417b));
        }
        a.a("placeTypes", this.f6419d);
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6417b);
        zzb.a(parcel, 1000, this.f6416a);
        zzb.a(parcel, 2, this.f6418c, false);
        zzb.c(parcel, a);
    }
}
