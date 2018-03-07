package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class zzj$zza extends zzj$zzc<Boolean> {
    public final int f6572a;
    public final Bundle f6573b;
    final /* synthetic */ zzj f6574c;

    protected zzj$zza(zzj com_google_android_gms_common_internal_zzj, int i, Bundle bundle) {
        this.f6574c = com_google_android_gms_common_internal_zzj;
        super(com_google_android_gms_common_internal_zzj, Boolean.valueOf(true));
        this.f6572a = i;
        this.f6573b = bundle;
    }

    protected abstract void mo746a(ConnectionResult connectionResult);

    protected final void mo743a(Object obj) {
        PendingIntent pendingIntent = null;
        if (((Boolean) obj) == null) {
            zzj.a(this.f6574c, 1, null);
            return;
        }
        switch (this.f6572a) {
            case 0:
                if (!mo747a()) {
                    zzj.a(this.f6574c, 1, null);
                    mo746a(new ConnectionResult(8, null));
                    return;
                }
                return;
            case 10:
                zzj.a(this.f6574c, 1, null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
                zzj.a(this.f6574c, 1, null);
                if (this.f6573b != null) {
                    pendingIntent = (PendingIntent) this.f6573b.getParcelable("pendingIntent");
                }
                mo746a(new ConnectionResult(this.f6572a, pendingIntent));
                return;
        }
    }

    protected abstract boolean mo747a();
}
