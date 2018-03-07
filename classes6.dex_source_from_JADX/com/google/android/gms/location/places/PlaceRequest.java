package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import java.util.concurrent.TimeUnit;

public final class PlaceRequest implements SafeParcelable {
    public static final Creator<PlaceRequest> CREATOR = new zzk();
    static final long f6461a = TimeUnit.HOURS.toMillis(1);
    public final int f6462b;
    public final PlaceFilter f6463c;
    public final long f6464d;
    public final int f6465e;
    public final long f6466f;

    public PlaceRequest(int i, PlaceFilter placeFilter, long j, int i2, long j2) {
        this.f6462b = i;
        this.f6463c = placeFilter;
        this.f6464d = j;
        this.f6465e = i2;
        this.f6466f = j2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceRequest)) {
            return false;
        }
        PlaceRequest placeRequest = (PlaceRequest) obj;
        return zzw.a(this.f6463c, placeRequest.f6463c) && this.f6464d == placeRequest.f6464d && this.f6465e == placeRequest.f6465e && this.f6466f == placeRequest.f6466f;
    }

    public final int hashCode() {
        return zzw.a(new Object[]{this.f6463c, Long.valueOf(this.f6464d), Integer.valueOf(this.f6465e), Long.valueOf(this.f6466f)});
    }

    public final String toString() {
        return zzw.a(this).a("filter", this.f6463c).a("interval", Long.valueOf(this.f6464d)).a("priority", Integer.valueOf(this.f6465e)).a("expireAt", Long.valueOf(this.f6466f)).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1000, this.f6462b);
        zzb.a(parcel, 2, this.f6463c, i, false);
        zzb.a(parcel, 3, this.f6464d);
        zzb.a(parcel, 4, this.f6465e);
        zzb.a(parcel, 5, this.f6466f);
        zzb.c(parcel, a);
    }
}
