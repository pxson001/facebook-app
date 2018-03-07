package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class PlayLoggerContext implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int f7142a;
    public final String f7143b;
    public final int f7144c;
    public final int f7145d;
    public final String f7146e;
    public final String f7147f;
    public final boolean f7148g;
    public final String f7149h;
    public final boolean f7150i;
    public final int f7151j;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.f7142a = i;
        this.f7143b = str;
        this.f7144c = i2;
        this.f7145d = i3;
        this.f7146e = str2;
        this.f7147f = str3;
        this.f7148g = z;
        this.f7149h = str4;
        this.f7150i = z2;
        this.f7151j = i4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.f7142a == playLoggerContext.f7142a && this.f7143b.equals(playLoggerContext.f7143b) && this.f7144c == playLoggerContext.f7144c && this.f7145d == playLoggerContext.f7145d && zzw.a(this.f7149h, playLoggerContext.f7149h) && zzw.a(this.f7146e, playLoggerContext.f7146e) && zzw.a(this.f7147f, playLoggerContext.f7147f) && this.f7148g == playLoggerContext.f7148g && this.f7150i == playLoggerContext.f7150i && this.f7151j == playLoggerContext.f7151j;
    }

    public int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f7142a), this.f7143b, Integer.valueOf(this.f7144c), Integer.valueOf(this.f7145d), this.f7149h, this.f7146e, this.f7147f, Boolean.valueOf(this.f7148g), Boolean.valueOf(this.f7150i), Integer.valueOf(this.f7151j)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.f7142a).append(',');
        stringBuilder.append("package=").append(this.f7143b).append(',');
        stringBuilder.append("packageVersionCode=").append(this.f7144c).append(',');
        stringBuilder.append("logSource=").append(this.f7145d).append(',');
        stringBuilder.append("logSourceName=").append(this.f7149h).append(',');
        stringBuilder.append("uploadAccount=").append(this.f7146e).append(',');
        stringBuilder.append("loggingId=").append(this.f7147f).append(',');
        stringBuilder.append("logAndroidId=").append(this.f7148g).append(',');
        stringBuilder.append("isAnonymous=").append(this.f7150i).append(',');
        stringBuilder.append("qosTier=").append(this.f7151j);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f7142a);
        zzb.m12247a(parcel, 2, this.f7143b, false);
        zzb.m12241a(parcel, 3, this.f7144c);
        zzb.m12241a(parcel, 4, this.f7145d);
        zzb.m12247a(parcel, 5, this.f7146e, false);
        zzb.m12247a(parcel, 6, this.f7147f, false);
        zzb.m12249a(parcel, 7, this.f7148g);
        zzb.m12247a(parcel, 8, this.f7149h, false);
        zzb.m12249a(parcel, 9, this.f7150i);
        zzb.m12241a(parcel, 10, this.f7151j);
        zzb.m12258c(parcel, a);
    }
}
