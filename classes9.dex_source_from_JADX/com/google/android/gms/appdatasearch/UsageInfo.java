package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    public final int f20580a;
    public final DocumentId f20581b;
    public final long f20582c;
    public int f20583d;
    public final String f20584e;
    public final DocumentContents f20585f;
    public final boolean f20586g;
    public int f20587h;
    public int f20588i;

    UsageInfo(int i, DocumentId documentId, long j, int i2, String str, DocumentContents documentContents, boolean z, int i3, int i4) {
        this.f20580a = i;
        this.f20581b = documentId;
        this.f20582c = j;
        this.f20583d = i2;
        this.f20584e = str;
        this.f20585f = documentContents;
        this.f20586g = z;
        this.f20587h = i3;
        this.f20588i = i4;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.f20581b, Long.valueOf(this.f20582c), Integer.valueOf(this.f20583d), Integer.valueOf(this.f20588i)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f20581b, i, false);
        zzb.a(parcel, 1000, this.f20580a);
        zzb.a(parcel, 2, this.f20582c);
        zzb.a(parcel, 3, this.f20583d);
        zzb.a(parcel, 4, this.f20584e, false);
        zzb.a(parcel, 5, this.f20585f, i, false);
        zzb.a(parcel, 6, this.f20586g);
        zzb.a(parcel, 7, this.f20587h);
        zzb.a(parcel, 8, this.f20588i);
        zzb.c(parcel, a);
    }
}
