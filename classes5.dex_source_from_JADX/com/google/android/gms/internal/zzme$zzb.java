package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzt.zza;
import java.lang.ref.WeakReference;

class zzme$zzb extends zza {
    private final WeakReference<zzme> f6871a;

    zzme$zzb(zzme com_google_android_gms_internal_zzme) {
        this.f6871a = new WeakReference(com_google_android_gms_internal_zzme);
    }

    public final void mo793a(final ResolveAccountResponse resolveAccountResponse) {
        final zzme com_google_android_gms_internal_zzme = (zzme) this.f6871a.get();
        if (com_google_android_gms_internal_zzme != null) {
            com_google_android_gms_internal_zzme.a.a(new zzmi$zza(this, com_google_android_gms_internal_zzme) {
                final /* synthetic */ zzme$zzb f6870c;

                public final void mo836a() {
                    zzme com_google_android_gms_internal_zzme = com_google_android_gms_internal_zzme;
                    ResolveAccountResponse resolveAccountResponse = resolveAccountResponse;
                    if (zzme.b(com_google_android_gms_internal_zzme, 0)) {
                        ConnectionResult connectionResult = resolveAccountResponse.f6547c;
                        if (connectionResult.b()) {
                            com_google_android_gms_internal_zzme.p = resolveAccountResponse.m12200a();
                            com_google_android_gms_internal_zzme.o = true;
                            com_google_android_gms_internal_zzme.q = resolveAccountResponse.f6548d;
                            com_google_android_gms_internal_zzme.r = resolveAccountResponse.f6549e;
                            zzme.e(com_google_android_gms_internal_zzme);
                        } else if (zzme.c(com_google_android_gms_internal_zzme, connectionResult)) {
                            zzme.j(com_google_android_gms_internal_zzme);
                            zzme.e(com_google_android_gms_internal_zzme);
                        } else {
                            zzme.d(com_google_android_gms_internal_zzme, connectionResult);
                        }
                    }
                }
            });
        }
    }
}
