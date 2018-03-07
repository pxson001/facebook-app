package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzmd implements zzmh {
    private final zzmi f6862a;

    public zzmd(zzmi com_google_android_gms_internal_zzmi) {
        this.f6862a = com_google_android_gms_internal_zzmi;
    }

    private <A extends zzb> void m12813a(zzmg$zze<A> com_google_android_gms_internal_zzmg_zze_A) {
        this.f6862a.g.a(com_google_android_gms_internal_zzmg_zze_A);
        zzb a = this.f6862a.g.a(com_google_android_gms_internal_zzmg_zze_A.mo832c());
        if (a.b() || !this.f6862a.b.containsKey(com_google_android_gms_internal_zzmg_zze_A.mo832c())) {
            com_google_android_gms_internal_zzmg_zze_A.mo828a(a);
        } else {
            com_google_android_gms_internal_zzmg_zze_A.mo829a(new Status(17));
        }
    }

    public final <A extends zzb, R extends Result, T extends zzlx$zza<R, A>> T m12814a(T t) {
        return m12819b(t);
    }

    public final void m12815a() {
    }

    public final void m12816a(int i) {
        this.f6862a.a(null);
        this.f6862a.h.c_(i);
    }

    public final void m12817a(Bundle bundle) {
    }

    public final void m12818a(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public final <A extends zzb, T extends zzlx$zza<? extends Result, A>> T m12819b(T t) {
        try {
            m12813a((zzmg$zze) t);
        } catch (DeadObjectException e) {
            this.f6862a.a(new zzmi$zza(this, this) {
                final /* synthetic */ zzmd f6861a;

                public final void mo836a() {
                    this.f6861a.m12816a(1);
                }
            });
        }
        return t;
    }

    public final void m12820b() {
        this.f6862a.a(null);
    }

    public final void m12821c() {
    }
}
