package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class ClientIdentity implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final int f6353a;
    public final String f6354b;
    public final int f6355c;

    ClientIdentity(int i, int i2, String str) {
        this.f6355c = i;
        this.f6353a = i2;
        this.f6354b = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f6353a == this.f6353a && zzw.a(clientIdentity.f6354b, this.f6354b);
    }

    public int hashCode() {
        return this.f6353a;
    }

    public String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.f6353a), this.f6354b});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6353a);
        zzb.a(parcel, 1000, this.f6355c);
        zzb.a(parcel, 2, this.f6354b, false);
        zzb.c(parcel, a);
    }
}
