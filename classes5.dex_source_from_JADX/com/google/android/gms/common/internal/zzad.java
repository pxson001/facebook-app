package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api$zzd;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzad<T extends IInterface> extends zzj<T> {
    private final Api$zzd<T> f6566d;

    public zzad(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf, Api$zzd api$zzd) {
        super(context, looper, i, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.f6566d = api$zzd;
    }

    protected final T m12276a(IBinder iBinder) {
        return this.f6566d.m12130c();
    }

    protected final String m12277g() {
        return this.f6566d.m12128a();
    }

    protected final String m12278h() {
        return this.f6566d.m12129b();
    }
}
