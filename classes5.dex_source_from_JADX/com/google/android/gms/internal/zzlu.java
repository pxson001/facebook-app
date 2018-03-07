package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzlu extends zzj<zzlw> {
    public zzlu(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected final IInterface m12739a(IBinder iBinder) {
        zzlw com_google_android_gms_internal_zzlw;
        if (iBinder == null) {
            com_google_android_gms_internal_zzlw = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            com_google_android_gms_internal_zzlw = (queryLocalInterface == null || !(queryLocalInterface instanceof zzlw)) ? new zzlw$zza$zza(iBinder) : (zzlw) queryLocalInterface;
        }
        return com_google_android_gms_internal_zzlw;
    }

    protected final String m12740g() {
        return "com.google.android.gms.clearcut.service.START";
    }

    protected final String m12741h() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
