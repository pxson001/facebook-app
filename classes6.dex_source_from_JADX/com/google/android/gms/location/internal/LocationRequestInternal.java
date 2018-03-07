package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    public static final List<ClientIdentity> f6359a = Collections.emptyList();
    public LocationRequest f6360b;
    public boolean f6361c;
    public boolean f6362d;
    public boolean f6363e;
    public List<ClientIdentity> f6364f;
    public String f6365g;
    public boolean f6366h;
    public final int f6367i;

    public LocationRequestInternal(int i, LocationRequest locationRequest, boolean z, boolean z2, boolean z3, List<ClientIdentity> list, String str, boolean z4) {
        this.f6367i = i;
        this.f6360b = locationRequest;
        this.f6361c = z;
        this.f6362d = z2;
        this.f6363e = z3;
        this.f6364f = list;
        this.f6365g = str;
        this.f6366h = z4;
    }

    @Deprecated
    public static LocationRequestInternal m8858a(LocationRequest locationRequest) {
        return new LocationRequestInternal(1, locationRequest, false, true, true, f6359a, null, false);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationRequestInternal)) {
            return false;
        }
        LocationRequestInternal locationRequestInternal = (LocationRequestInternal) obj;
        return zzw.a(this.f6360b, locationRequestInternal.f6360b) && this.f6361c == locationRequestInternal.f6361c && this.f6362d == locationRequestInternal.f6362d && this.f6363e == locationRequestInternal.f6363e && this.f6366h == locationRequestInternal.f6366h && zzw.a(this.f6364f, locationRequestInternal.f6364f);
    }

    public int hashCode() {
        return this.f6360b.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f6360b.toString());
        if (this.f6365g != null) {
            stringBuilder.append(" tag=").append(this.f6365g);
        }
        stringBuilder.append(" nlpDebug=").append(this.f6361c);
        stringBuilder.append(" trigger=").append(this.f6363e);
        stringBuilder.append(" restorePIListeners=").append(this.f6362d);
        stringBuilder.append(" hideAppOps=").append(this.f6366h);
        stringBuilder.append(" clients=").append(this.f6364f);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6360b, i, false);
        zzb.a(parcel, 1000, this.f6367i);
        zzb.a(parcel, 2, this.f6361c);
        zzb.a(parcel, 3, this.f6362d);
        zzb.a(parcel, 4, this.f6363e);
        zzb.c(parcel, 5, this.f6364f, false);
        zzb.a(parcel, 6, this.f6365g, false);
        zzb.a(parcel, 7, this.f6366h);
        zzb.c(parcel, a);
    }
}
