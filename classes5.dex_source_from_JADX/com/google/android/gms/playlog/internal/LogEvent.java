package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class LogEvent implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final int f7136a;
    public final long f7137b;
    public final long f7138c;
    public final String f7139d;
    public final byte[] f7140e;
    public final Bundle f7141f;

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.f7136a = i;
        this.f7137b = j;
        this.f7138c = j2;
        this.f7139d = str;
        this.f7140e = bArr;
        this.f7141f = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.f7139d).append(",");
        stringBuilder.append("eventTime=").append(this.f7137b).append(",");
        stringBuilder.append("eventUptime=").append(this.f7138c).append(",");
        if (!(this.f7141f == null || this.f7141f.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.f7141f.keySet()) {
                stringBuilder.append("(").append(str).append(",");
                stringBuilder.append(this.f7141f.getString(str)).append(")");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f7136a);
        zzb.m12242a(parcel, 2, this.f7137b);
        zzb.m12247a(parcel, 3, this.f7139d, false);
        zzb.m12250a(parcel, 4, this.f7140e, false);
        zzb.m12243a(parcel, 5, this.f7141f, false);
        zzb.m12242a(parcel, 6, this.f7138c);
        zzb.m12258c(parcel, a);
    }
}
