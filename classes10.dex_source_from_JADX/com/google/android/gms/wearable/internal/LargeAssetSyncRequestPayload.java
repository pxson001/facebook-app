package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public class LargeAssetSyncRequestPayload implements SafeParcelable {
    public static final Creator<LargeAssetSyncRequestPayload> CREATOR = new zzbk();
    public final int f13329a;
    public final String f13330b;
    public final long f13331c;

    public LargeAssetSyncRequestPayload(int i, String str, long j) {
        this.f13329a = i;
        this.f13330b = (String) zzx.a(str, "path");
        this.f13331c = j;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "LargeAssetSyncRequestPayload{path='" + this.f13330b + "', offset=" + this.f13331c + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13329a);
        zzb.a(parcel, 2, this.f13330b, false);
        zzb.a(parcel, 3, this.f13331c);
        zzb.c(parcel, a);
    }
}
