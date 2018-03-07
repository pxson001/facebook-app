package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
    public static final Creator<GeofencingRequest> CREATOR = new zza();
    public final int f6310a;
    public final List<ParcelableGeofence> f6311b;
    public final int f6312c;

    public final class Builder {
        private final List<ParcelableGeofence> f6308a = new ArrayList();
        private int f6309b = 5;

        public final Builder m8845a(Geofence geofence) {
            zzx.a(geofence, "geofence can't be null.");
            zzx.b(geofence instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
            this.f6308a.add((ParcelableGeofence) geofence);
            return this;
        }

        public final GeofencingRequest m8846a() {
            zzx.b(!this.f6308a.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.f6308a, this.f6309b);
        }
    }

    GeofencingRequest(int i, List<ParcelableGeofence> list, int i2) {
        this.f6310a = i;
        this.f6311b = list;
        this.f6312c = i2;
    }

    public GeofencingRequest(List<ParcelableGeofence> list, int i) {
        this(1, list, i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.c(parcel, 1, this.f6311b, false);
        zzb.a(parcel, 1000, this.f6310a);
        zzb.a(parcel, 2, this.f6312c);
        zzb.c(parcel, a);
    }
}
