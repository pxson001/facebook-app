package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

class zzme$zzg implements ConnectionCallbacks, OnConnectionFailedListener {
    final /* synthetic */ zzme f6877a;

    public zzme$zzg(zzme com_google_android_gms_internal_zzme) {
        this.f6877a = com_google_android_gms_internal_zzme;
    }

    public final void m12837a(int i) {
    }

    public final void m12838a(Bundle bundle) {
        this.f6877a.l.mo867a(new zzme$zzb(this.f6877a));
    }

    public final void m12839a(ConnectionResult connectionResult) {
        this.f6877a.b.lock();
        try {
            if (zzme.c(this.f6877a, connectionResult)) {
                zzme.j(this.f6877a);
                zzme.h(this.f6877a);
            } else {
                zzme.d(this.f6877a, connectionResult);
            }
            this.f6877a.b.unlock();
        } catch (Throwable th) {
            this.f6877a.b.unlock();
        }
    }
}
