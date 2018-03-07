package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzr.zza;

public final class zzj$zzd extends zza {
    private zzj f6575a;
    private final int f6576b;

    public zzj$zzd(zzj com_google_android_gms_common_internal_zzj, int i) {
        this.f6575a = com_google_android_gms_common_internal_zzj;
        this.f6576b = i;
    }

    private void m12291a() {
        this.f6575a = null;
    }

    public final void mo744a(int i, Bundle bundle) {
        zzx.a(this.f6575a, "onAccountValidationComplete can be called only once per call to validateAccount");
        zzj com_google_android_gms_common_internal_zzj = this.f6575a;
        com_google_android_gms_common_internal_zzj.a.sendMessage(com_google_android_gms_common_internal_zzj.a.obtainMessage(5, this.f6576b, -1, new zzj$zzi(com_google_android_gms_common_internal_zzj, i, bundle)));
        m12291a();
    }

    public final void mo745a(int i, IBinder iBinder, Bundle bundle) {
        zzx.a(this.f6575a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f6575a.a(i, iBinder, bundle, this.f6576b);
        m12291a();
    }
}
