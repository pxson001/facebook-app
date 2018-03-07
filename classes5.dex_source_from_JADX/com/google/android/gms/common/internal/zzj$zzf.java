package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.zza;

public class zzj$zzf implements zza {
    final /* synthetic */ zzj f6577a;

    public zzj$zzf(zzj com_google_android_gms_common_internal_zzj) {
        this.f6577a = com_google_android_gms_common_internal_zzj;
    }

    public final void m12294a(ConnectionResult connectionResult) {
        if (connectionResult.b()) {
            this.f6577a.a(null, this.f6577a.p);
        } else if (this.f6577a.s != null) {
            this.f6577a.s.a(connectionResult);
        }
    }

    public final void m12295b(ConnectionResult connectionResult) {
        throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
    }
}
