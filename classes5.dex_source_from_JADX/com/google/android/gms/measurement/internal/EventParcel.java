package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class EventParcel implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    public final int f7047a;
    public final String f7048b;
    public final EventParams f7049c;
    public final String f7050d;
    public final long f7051e;

    EventParcel(int i, String str, EventParams eventParams, String str2, long j) {
        this.f7047a = i;
        this.f7048b = str;
        this.f7049c = eventParams;
        this.f7050d = str2;
        this.f7051e = j;
    }

    public EventParcel(String str, EventParams eventParams, String str2, long j) {
        this.f7047a = 1;
        this.f7048b = str;
        this.f7049c = eventParams;
        this.f7050d = str2;
        this.f7051e = j;
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "origin=" + this.f7050d + ",name=" + this.f7048b + ",params=" + this.f7049c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f7047a);
        zzb.m12247a(parcel, 2, this.f7048b, false);
        zzb.m12245a(parcel, 3, this.f7049c, i, false);
        zzb.m12247a(parcel, 4, this.f7050d, false);
        zzb.m12242a(parcel, 5, this.f7051e);
        zzb.m12258c(parcel, a);
    }
}
