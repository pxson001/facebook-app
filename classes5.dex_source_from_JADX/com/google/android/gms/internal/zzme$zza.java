package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.internal.AuthAccountResult;
import com.google.android.gms.signin.internal.zzb;
import java.lang.ref.WeakReference;

class zzme$zza extends zzb {
    private final WeakReference<zzme> f6867a;

    zzme$zza(zzme com_google_android_gms_internal_zzme) {
        this.f6867a = new WeakReference(com_google_android_gms_internal_zzme);
    }

    public final void mo837a(final ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
        final zzme com_google_android_gms_internal_zzme = (zzme) this.f6867a.get();
        if (com_google_android_gms_internal_zzme != null) {
            com_google_android_gms_internal_zzme.a.a(new zzmi$zza(this, com_google_android_gms_internal_zzme) {
                final /* synthetic */ zzme$zza f6866c;

                public final void mo836a() {
                    zzme com_google_android_gms_internal_zzme = com_google_android_gms_internal_zzme;
                    ConnectionResult connectionResult = connectionResult;
                    if (!zzme.b(com_google_android_gms_internal_zzme, 2)) {
                        return;
                    }
                    if (connectionResult.b()) {
                        zzme.h(com_google_android_gms_internal_zzme);
                    } else if (zzme.c(com_google_android_gms_internal_zzme, connectionResult)) {
                        zzme.j(com_google_android_gms_internal_zzme);
                        zzme.h(com_google_android_gms_internal_zzme);
                    } else {
                        zzme.d(com_google_android_gms_internal_zzme, connectionResult);
                    }
                }
            });
        }
    }
}
