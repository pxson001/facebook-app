package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public final class Scope implements SafeParcelable {
    public static final Creator<Scope> CREATOR = new zzc();
    public final int f18102a;
    public final String f18103b;

    Scope(int i, String str) {
        zzx.m107a(str, (Object) "scopeUri must not be null or empty");
        this.f18102a = i;
        this.f18103b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final String m25411a() {
        return this.f18103b;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.f18103b.equals(((Scope) obj).f18103b);
    }

    public final int hashCode() {
        return this.f18103b.hashCode();
    }

    public final String toString() {
        return this.f18103b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f18102a);
        zzb.a(parcel, 2, this.f18103b, false);
        zzb.c(parcel, a);
    }
}
