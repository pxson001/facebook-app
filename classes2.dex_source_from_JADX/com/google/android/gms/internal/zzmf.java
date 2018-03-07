package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzlx.zza;
import java.util.Collections;

public class zzmf implements zzmh {
    private final zzmi f19090a;

    public zzmf(zzmi com_google_android_gms_internal_zzmi) {
        this.f19090a = com_google_android_gms_internal_zzmi;
    }

    public final <A extends zzb, R extends Result, T extends zza<R, A>> T mo3075a(T t) {
        this.f19090a.f19080g.f18931a.add(t);
        return t;
    }

    public final void mo3076a() {
        for (zzb a : this.f19090a.f19074a.values()) {
            a.mo3022a();
        }
        this.f19090a.f19080g.f18934d = Collections.emptySet();
    }

    public final void mo3077a(int i) {
    }

    public final void mo3078a(Bundle bundle) {
    }

    public final void mo3079a(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public final <A extends zzb, T extends zza<? extends Result, A>> T mo3080b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void mo3081b() {
        this.f19090a.f19080g.m26635i();
    }

    public final void mo3082c() {
        this.f19090a.m26803f();
    }
}
