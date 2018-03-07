package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlaceAliasResult implements Result, SafeParcelable {
    public static final Creator<PlaceAliasResult> CREATOR = new zzc();
    public final int f6600a;
    public final PlaceUserData f6601b;
    private final Status f6602c;

    PlaceAliasResult(int i, Status status, PlaceUserData placeUserData) {
        this.f6600a = i;
        this.f6602c = status;
        this.f6601b = placeUserData;
    }

    public final Status cp_() {
        return this.f6602c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, cp_(), i, false);
        zzb.a(parcel, 1000, this.f6600a);
        zzb.a(parcel, 2, this.f6601b, i, false);
        zzb.c(parcel, a);
    }
}
