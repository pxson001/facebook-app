package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class SaveRequest implements SafeParcelable {
    public static final Creator<SaveRequest> CREATOR = new zzj();
    public final int f3633a;
    public final Credential f3634b;

    SaveRequest(int i, Credential credential) {
        this.f3633a = i;
        this.f3634b = credential;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3634b, i, false);
        zzb.a(parcel, 1000, this.f3633a);
        zzb.c(parcel, a);
    }
}
