package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public final class DeleteRequest implements SafeParcelable {
    public static final Creator<DeleteRequest> CREATOR = new zzg();
    public final int f3631a;
    public final Credential f3632b;

    DeleteRequest(int i, Credential credential) {
        this.f3631a = i;
        this.f3632b = credential;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3632b, i, false);
        zzb.a(parcel, 1000, this.f3631a);
        zzb.c(parcel, a);
    }
}
