package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public final class LargeAssetEnqueueRequest implements SafeParcelable {
    public static final Creator<LargeAssetEnqueueRequest> CREATOR = new zzbd();
    public final int f13295a;
    public final String f13296b;
    public final String f13297c;
    public final Uri f13298d;
    public final String f13299e;
    public final boolean f13300f;
    public final boolean f13301g;
    public final boolean f13302h;

    LargeAssetEnqueueRequest(int i, String str, String str2, Uri uri, String str3, boolean z, boolean z2, boolean z3) {
        this.f13295a = i;
        this.f13296b = (String) zzx.a(str);
        this.f13297c = (String) zzx.a(str2);
        this.f13298d = (Uri) zzx.a(uri);
        this.f13299e = (String) zzx.a(str3);
        this.f13300f = z;
        this.f13301g = z2;
        this.f13302h = z3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LargeAssetEnqueueRequest)) {
            return false;
        }
        LargeAssetEnqueueRequest largeAssetEnqueueRequest = (LargeAssetEnqueueRequest) obj;
        return this.f13295a == largeAssetEnqueueRequest.f13295a && this.f13296b.equals(largeAssetEnqueueRequest.f13296b) && this.f13297c.equals(largeAssetEnqueueRequest.f13297c) && this.f13298d.equals(largeAssetEnqueueRequest.f13298d) && this.f13299e.equals(largeAssetEnqueueRequest.f13299e) && this.f13300f == largeAssetEnqueueRequest.f13300f && this.f13301g == largeAssetEnqueueRequest.f13301g && this.f13302h == largeAssetEnqueueRequest.f13302h;
    }

    public final int hashCode() {
        int i = 1;
        int hashCode = ((this.f13301g ? 1 : 0) + (((this.f13300f ? 1 : 0) + (((((((((this.f13295a * 31) + this.f13296b.hashCode()) * 31) + this.f13297c.hashCode()) * 31) + this.f13298d.hashCode()) * 31) + this.f13299e.hashCode()) * 31)) * 31)) * 31;
        if (!this.f13302h) {
            i = 0;
        }
        return hashCode + i;
    }

    public final String toString() {
        return "LargeAssetEnqueueRequest{, nodeId='" + this.f13296b + "', path='" + this.f13297c + "', destinationUri='" + this.f13298d + "', destinationCanonicalPath='" + this.f13299e + "', append=" + this.f13300f + (this.f13301g ? ", allowedOverMetered=true" : "") + (this.f13302h ? ", allowedWithLowBattery=true" : "") + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13295a);
        zzb.a(parcel, 2, this.f13296b, false);
        zzb.a(parcel, 3, this.f13297c, false);
        zzb.a(parcel, 4, this.f13298d, i, false);
        zzb.a(parcel, 5, this.f13299e, false);
        zzb.a(parcel, 6, this.f13300f);
        zzb.a(parcel, 7, this.f13301g);
        zzb.a(parcel, 8, this.f13302h);
        zzb.c(parcel, a);
    }
}
