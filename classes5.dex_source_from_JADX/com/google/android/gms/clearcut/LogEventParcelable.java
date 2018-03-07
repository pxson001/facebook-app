package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.zza.zzb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zztp.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;
import java.util.Iterator;

public class LogEventParcelable implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final int f6439a;
    public PlayLoggerContext f6440b;
    public byte[] f6441c;
    public int[] f6442d;
    public final zzd f6443e = null;
    public final zzb f6444f = null;
    public final zzb f6445g = null;

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr) {
        this.f6439a = i;
        this.f6440b = playLoggerContext;
        this.f6441c = bArr;
        this.f6442d = iArr;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.f6439a == logEventParcelable.f6439a && zzw.a(this.f6440b, logEventParcelable.f6440b) && Arrays.equals(this.f6441c, logEventParcelable.f6441c) && Arrays.equals(this.f6442d, logEventParcelable.f6442d) && zzw.a(this.f6443e, logEventParcelable.f6443e) && zzw.a(this.f6444f, logEventParcelable.f6444f) && zzw.a(this.f6445g, logEventParcelable.f6445g);
    }

    public int hashCode() {
        return zzw.a(new Object[]{Integer.valueOf(this.f6439a), this.f6440b, this.f6441c, this.f6442d, this.f6443e, this.f6444f, this.f6445g});
    }

    public String toString() {
        String str = null;
        StringBuilder stringBuilder = new StringBuilder("LogEventParcelable[");
        stringBuilder.append(this.f6439a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6440b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6441c == null ? null : new String(this.f6441c));
        stringBuilder.append(", ");
        if (this.f6442d != null) {
            zzv com_google_android_gms_common_internal_zzv = new zzv(", ");
            Iterable asList = Arrays.asList(new int[][]{this.f6442d});
            StringBuilder stringBuilder2 = new StringBuilder();
            Iterator it = asList.iterator();
            if (it.hasNext()) {
                stringBuilder2.append(zzv.m12401a(it.next()));
                while (it.hasNext()) {
                    stringBuilder2.append(com_google_android_gms_common_internal_zzv.f6589a);
                    stringBuilder2.append(zzv.m12401a(it.next()));
                }
            }
            str = stringBuilder2.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6443e);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6444f);
        stringBuilder.append(", ");
        stringBuilder.append(this.f6445g);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = com.google.android.gms.common.internal.safeparcel.zzb.m12237a(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.m12241a(parcel, 1, this.f6439a);
        com.google.android.gms.common.internal.safeparcel.zzb.m12245a(parcel, 2, this.f6440b, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.m12250a(parcel, 3, this.f6441c, false);
        com.google.android.gms.common.internal.safeparcel.zzb.m12251a(parcel, 4, this.f6442d, false);
        com.google.android.gms.common.internal.safeparcel.zzb.m12258c(parcel, a);
    }
}
