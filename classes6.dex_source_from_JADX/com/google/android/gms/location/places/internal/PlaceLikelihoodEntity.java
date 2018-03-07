package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlaceLikelihood;

public class PlaceLikelihoodEntity implements SafeParcelable, PlaceLikelihood {
    public static final Creator<PlaceLikelihoodEntity> CREATOR = new zzm();
    public final int f6542a;
    public final PlaceImpl f6543b;
    public final float f6544c;

    public PlaceLikelihoodEntity(int i, PlaceImpl placeImpl, float f) {
        this.f6542a = i;
        this.f6543b = placeImpl;
        this.f6544c = f;
    }

    public final Object m8998a() {
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceLikelihoodEntity)) {
            return false;
        }
        PlaceLikelihoodEntity placeLikelihoodEntity = (PlaceLikelihoodEntity) obj;
        return this.f6543b.equals(placeLikelihoodEntity.f6543b) && this.f6544c == placeLikelihoodEntity.f6544c;
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f6543b, Float.valueOf(this.f6544c)});
    }

    public String toString() {
        return zzw.a(this).a("place", this.f6543b).a("likelihood", Float.valueOf(this.f6544c)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6543b, i, false);
        zzb.a(parcel, 1000, this.f6542a);
        zzb.a(parcel, 2, this.f6544c);
        zzb.c(parcel, a);
    }
}
