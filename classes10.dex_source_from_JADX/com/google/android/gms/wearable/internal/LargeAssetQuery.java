package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class LargeAssetQuery implements SafeParcelable {
    public static final Creator<LargeAssetQuery> CREATOR = new zzbe();
    public final int f13303a;
    public final int f13304b;
    public final Uri f13305c;

    LargeAssetQuery(int i, int i2, Uri uri) {
        this.f13303a = i;
        this.f13304b = i2;
        this.f13305c = uri;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "LargeAssetQuery{stateFlags=" + this.f13304b + ", destinationUri=" + this.f13305c + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13303a);
        zzb.a(parcel, 2, this.f13304b);
        zzb.a(parcel, 3, this.f13305c, i, false);
        zzb.c(parcel, a);
    }
}
