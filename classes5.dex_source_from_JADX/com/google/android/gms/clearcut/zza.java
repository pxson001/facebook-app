package com.google.android.gms.clearcut;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;

public final class zza {
    public static final zzc<zzlu> f6446a = new zzc();
    public static final com.google.android.gms.common.api.Api.zza<zzlu, Object> f6447b = new C05641();
    public static final Api<Object> f6448c = new Api("ClearcutLogger.API", f6447b, f6446a);
    public static final zzb f6449d = new zzlt();

    final class C05641 extends com.google.android.gms.common.api.Api.zza<zzlu, Object> {
        C05641() {
        }

        public final com.google.android.gms.common.api.Api.zzb m12123a(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzlu(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface zzb {
    }
}
