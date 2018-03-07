package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzlx.zza;

public interface zzmh {
    <A extends zzb, R extends Result, T extends zza<R, A>> T mo3075a(T t);

    void mo3076a();

    void mo3077a(int i);

    void mo3078a(Bundle bundle);

    void mo3079a(ConnectionResult connectionResult, Api<?> api, int i);

    <A extends zzb, T extends zza<? extends Result, A>> T mo3080b(T t);

    void mo3081b();

    void mo3082c();
}
