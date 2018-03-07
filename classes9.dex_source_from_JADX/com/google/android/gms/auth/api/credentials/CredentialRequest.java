package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;

public final class CredentialRequest implements SafeParcelable {
    public static final Creator<CredentialRequest> CREATOR = new zzc();
    public final int f3603a;
    public final boolean f3604b;
    public final String[] f3605c;
    public final CredentialPickerConfig f3606d;
    public final CredentialPickerConfig f3607e;

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.f3603a = i;
        this.f3604b = z;
        this.f3605c = (String[]) zzx.a(strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new Builder().m3373a();
        }
        this.f3606d = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new Builder().m3373a();
        }
        this.f3607e = credentialPickerConfig2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3604b);
        zzb.a(parcel, 1000, this.f3603a);
        zzb.a(parcel, 2, this.f3605c, false);
        zzb.a(parcel, 3, this.f3606d, i, false);
        zzb.a(parcel, 4, this.f3607e, i, false);
        zzb.c(parcel, a);
    }
}
