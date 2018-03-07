package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

public final class zzj$zzi extends zzj$zza {
    final /* synthetic */ zzj f6581e;

    public zzj$zzi(zzj com_google_android_gms_common_internal_zzj, int i, Bundle bundle) {
        this.f6581e = com_google_android_gms_common_internal_zzj;
        super(com_google_android_gms_common_internal_zzj, i, bundle);
    }

    protected final void mo746a(ConnectionResult connectionResult) {
        this.f6581e.k.b(connectionResult);
        this.f6581e.a(connectionResult);
    }

    protected final boolean mo747a() {
        this.f6581e.k.b(ConnectionResult.a);
        return true;
    }
}
