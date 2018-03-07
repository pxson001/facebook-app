package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public final class HintRequest implements SafeParcelable {
    public static final Creator<HintRequest> CREATOR = new zzd();
    public final int f3608a;
    public final CredentialPickerConfig f3609b;
    public final boolean f3610c;
    public final boolean f3611d;
    public final String[] f3612e;

    HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr) {
        this.f3608a = i;
        this.f3609b = (CredentialPickerConfig) zzx.a(credentialPickerConfig);
        this.f3610c = z;
        this.f3611d = z2;
        this.f3612e = (String[]) zzx.a(strArr);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3609b, i, false);
        zzb.a(parcel, 1000, this.f3608a);
        zzb.a(parcel, 2, this.f3610c);
        zzb.a(parcel, 3, this.f3611d);
        zzb.a(parcel, 4, this.f3612e, false);
        zzb.c(parcel, a);
    }
}
