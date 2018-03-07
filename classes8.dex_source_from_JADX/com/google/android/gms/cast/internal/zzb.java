package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zza;

public abstract class zzb<R extends Result> extends zza<R, zze> {
    public zzb(GoogleApiClient googleApiClient) {
        super(zzk.f10173a, googleApiClient);
    }

    public final void m11741a(int i) {
        a(c(new Status(i)));
    }

    public final void m11742a(int i, String str) {
        a(c(new Status(i, str, null)));
    }
}
