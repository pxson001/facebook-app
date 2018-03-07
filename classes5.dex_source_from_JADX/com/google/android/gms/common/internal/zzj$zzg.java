package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class zzj$zzg extends zzj$zza {
    public final IBinder f6578e;
    final /* synthetic */ zzj f6579f;

    public zzj$zzg(zzj com_google_android_gms_common_internal_zzj, int i, IBinder iBinder, Bundle bundle) {
        this.f6579f = com_google_android_gms_common_internal_zzj;
        super(com_google_android_gms_common_internal_zzj, i, bundle);
        this.f6578e = iBinder;
    }

    protected final void mo746a(ConnectionResult connectionResult) {
        if (this.f6579f.s != null) {
            this.f6579f.s.a(connectionResult);
        }
        this.f6579f.a(connectionResult);
    }

    protected final boolean mo747a() {
        try {
            String interfaceDescriptor = this.f6578e.getInterfaceDescriptor();
            if (this.f6579f.h().equals(interfaceDescriptor)) {
                IInterface a = this.f6579f.a(this.f6578e);
                if (a == null || !zzj.a(this.f6579f, 2, 3, a)) {
                    return false;
                }
                Bundle p = this.f6579f.p();
                if (this.f6579f.r != null) {
                    this.f6579f.r.a(p);
                }
                return true;
            }
            Log.e("GmsClient", "service descriptor mismatch: " + this.f6579f.h() + " vs. " + interfaceDescriptor);
            return false;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
