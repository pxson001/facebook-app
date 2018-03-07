package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class IdToken implements SafeParcelable {
    public static final Creator<IdToken> CREATOR = new zze();
    public final int f3613a;
    public final String f3614b;
    public final String f3615c;

    IdToken(int i, String str, String str2) {
        this.f3613a = i;
        this.f3614b = str;
        this.f3615c = str2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3614b, false);
        zzb.a(parcel, 1000, this.f3613a);
        zzb.a(parcel, 2, this.f3615c, false);
        zzb.c(parcel, a);
    }
}
