package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ValidateAccountRequest implements SafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR = new zzae();
    public final int f6554a;
    public final IBinder f6555b;
    public final int f6556c;
    public final Scope[] f6557d;
    public final Bundle f6558e;
    public final String f6559f;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f6554a = i;
        this.f6556c = i2;
        this.f6555b = iBinder;
        this.f6557d = scopeArr;
        this.f6558e = bundle;
        this.f6559f = str;
    }

    public ValidateAccountRequest(zzp com_google_android_gms_common_internal_zzp, Scope[] scopeArr, String str, Bundle bundle) {
        this(1, GoogleApiAvailability.a, com_google_android_gms_common_internal_zzp == null ? null : com_google_android_gms_common_internal_zzp.asBinder(), scopeArr, bundle, str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6554a);
        zzb.m12241a(parcel, 2, this.f6556c);
        zzb.m12244a(parcel, 3, this.f6555b, false);
        zzb.m12252a(parcel, 4, (Parcelable[]) this.f6557d, i, false);
        zzb.m12243a(parcel, 5, this.f6558e, false);
        zzb.m12247a(parcel, 6, this.f6559f, false);
        zzb.m12258c(parcel, a);
    }
}
