package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.zzb;

public final class LargeAssetQueueEntryParcelable implements SafeParcelable, zzb {
    public static final Creator<LargeAssetQueueEntryParcelable> CREATOR = new zzbf();
    public final int f13306a;
    public final long f13307b;
    public final int f13308c;
    public final String f13309d;
    public final String f13310e;
    public final Uri f13311f;
    public final int f13312g;
    public final boolean f13313h;
    public final boolean f13314i;
    public final boolean f13315j;

    LargeAssetQueueEntryParcelable(int i, long j, int i2, String str, String str2, Uri uri, int i3, boolean z, boolean z2, boolean z3) {
        this.f13306a = i;
        this.f13307b = j;
        this.f13308c = i2;
        this.f13309d = (String) zzx.a(str, "path");
        this.f13310e = (String) zzx.a(str2, "nodeId");
        this.f13311f = (Uri) zzx.a(uri, "destinationUri");
        this.f13312g = i3;
        this.f13313h = z;
        this.f13314i = z2;
        this.f13315j = z3;
    }

    public LargeAssetQueueEntryParcelable(long j, int i, String str, String str2, Uri uri, int i2, boolean z, boolean z2, boolean z3) {
        this(1, j, i, str, str2, uri, i2, z, z2, z3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LargeAssetQueueEntryParcelable)) {
            return false;
        }
        LargeAssetQueueEntryParcelable largeAssetQueueEntryParcelable = (LargeAssetQueueEntryParcelable) obj;
        return this.f13306a == largeAssetQueueEntryParcelable.f13306a && this.f13307b == largeAssetQueueEntryParcelable.f13307b && this.f13308c == largeAssetQueueEntryParcelable.f13308c && this.f13309d.equals(largeAssetQueueEntryParcelable.f13309d) && this.f13310e.equals(largeAssetQueueEntryParcelable.f13310e) && this.f13311f.equals(largeAssetQueueEntryParcelable.f13311f) && this.f13313h == largeAssetQueueEntryParcelable.f13313h && this.f13314i == largeAssetQueueEntryParcelable.f13314i && this.f13315j == largeAssetQueueEntryParcelable.f13315j && this.f13312g == largeAssetQueueEntryParcelable.f13312g;
    }

    public final int hashCode() {
        int i = 1;
        int hashCode = ((this.f13314i ? 1 : 0) + (((this.f13313h ? 1 : 0) + (((((((((((this.f13306a * 31) + ((int) (this.f13307b ^ (this.f13307b >>> 32)))) * 31) + this.f13308c) * 31) + this.f13309d.hashCode()) * 31) + this.f13310e.hashCode()) * 31) + this.f13311f.hashCode()) * 31)) * 31)) * 31;
        if (!this.f13315j) {
            i = 0;
        }
        return ((hashCode + i) * 31) + this.f13312g;
    }

    public final String toString() {
        return "QueueEntry{versionCode=" + this.f13306a + ", transferId=" + this.f13307b + ", state=" + this.f13308c + ", path='" + this.f13309d + "', nodeId='" + this.f13310e + "', destinationUri='" + this.f13311f + "'" + (this.f13313h ? ", append=true" : "") + (this.f13314i ? ", allowedOverMetered=true" : "") + (this.f13315j ? ", allowedWithLowBattery=true" : "") + ", refuseErrorCode=" + this.f13312g + "}";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.zzb.a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 1, this.f13306a);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 2, this.f13307b);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 3, this.f13308c);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 4, this.f13309d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 5, this.f13310e, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 6, this.f13311f, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 8, this.f13312g);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 9, this.f13313h);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 10, this.f13314i);
        com.google.android.gms.common.internal.safeparcel.zzb.a(parcel, 11, this.f13315j);
        com.google.android.gms.common.internal.safeparcel.zzb.c(parcel, a);
    }
}
