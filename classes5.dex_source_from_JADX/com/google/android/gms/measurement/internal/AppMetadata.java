package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public class AppMetadata implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final int f7034a;
    public final String f7035b;
    public final String f7036c;
    public final String f7037d;
    public final String f7038e;
    public final long f7039f;
    public final long f7040g;
    public final String f7041h;
    public final boolean f7042i;

    AppMetadata(int i, String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z) {
        this.f7034a = i;
        this.f7035b = str;
        this.f7036c = str2;
        this.f7037d = str3;
        this.f7038e = str4;
        this.f7039f = j;
        this.f7040g = j2;
        this.f7041h = str5;
        if (i >= 3) {
            this.f7042i = z;
        } else {
            this.f7042i = true;
        }
    }

    AppMetadata(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z) {
        zzx.a(str);
        this.f7034a = 3;
        this.f7035b = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        this.f7036c = str2;
        this.f7037d = str3;
        this.f7038e = str4;
        this.f7039f = j;
        this.f7040g = j2;
        this.f7041h = str5;
        this.f7042i = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f7034a);
        zzb.m12247a(parcel, 2, this.f7035b, false);
        zzb.m12247a(parcel, 3, this.f7036c, false);
        zzb.m12247a(parcel, 4, this.f7037d, false);
        zzb.m12247a(parcel, 5, this.f7038e, false);
        zzb.m12242a(parcel, 6, this.f7039f);
        zzb.m12242a(parcel, 7, this.f7040g);
        zzb.m12247a(parcel, 8, this.f7041h, false);
        zzb.m12249a(parcel, 9, this.f7042i);
        zzb.m12258c(parcel, a);
    }
}
