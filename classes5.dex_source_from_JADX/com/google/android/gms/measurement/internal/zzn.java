package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.measurement.internal.zzl.zza;

public class zzn extends zzj<zzl> {
    public zzn(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 93, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    public final IInterface m13092a(IBinder iBinder) {
        return zza.m13091a(iBinder);
    }

    protected final String m13093g() {
        return "com.google.android.gms.measurement.START";
    }

    protected final String m13094h() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
