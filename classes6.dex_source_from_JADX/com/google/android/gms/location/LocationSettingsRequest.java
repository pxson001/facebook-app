package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest implements SafeParcelable {
    public static final Creator<LocationSettingsRequest> CREATOR = new zzf();
    public final int f6339a;
    public final List<LocationRequest> f6340b;
    public final boolean f6341c;
    public final boolean f6342d;

    public final class Builder {
        public final ArrayList<LocationRequest> f6336a = new ArrayList();
        public boolean f6337b = false;
        public boolean f6338c = false;

        public final LocationSettingsRequest m8855a() {
            return new LocationSettingsRequest(this.f6336a, this.f6337b, this.f6338c);
        }
    }

    LocationSettingsRequest(int i, List<LocationRequest> list, boolean z, boolean z2) {
        this.f6339a = i;
        this.f6340b = list;
        this.f6341c = z;
        this.f6342d = z2;
    }

    public LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2) {
        this(3, list, z, z2);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.c(parcel, 1, Collections.unmodifiableList(this.f6340b), false);
        zzb.a(parcel, 1000, this.f6339a);
        zzb.a(parcel, 2, this.f6341c);
        zzb.a(parcel, 3, this.f6342d);
        zzb.c(parcel, a);
    }
}
