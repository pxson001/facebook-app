package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public final class IdpTokenType implements SafeParcelable {
    public static final Creator<IdpTokenType> CREATOR = new zzi();
    public static final IdpTokenType f3662a = new IdpTokenType("accessToken");
    public static final IdpTokenType f3663b = new IdpTokenType("idToken");
    public final int f3664c;
    public final String f3665d;

    IdpTokenType(int i, String str) {
        this.f3664c = i;
        this.f3665d = zzx.a(str);
    }

    private IdpTokenType(String str) {
        this(1, str);
    }

    public final String m3383a() {
        return this.f3665d;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.f3665d.equals(((IdpTokenType) obj).m3383a());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public final int hashCode() {
        return this.f3665d.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3664c);
        zzb.a(parcel, 2, this.f3665d, false);
        zzb.c(parcel, a);
    }
}
