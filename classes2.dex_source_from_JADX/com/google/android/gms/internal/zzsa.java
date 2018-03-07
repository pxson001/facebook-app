package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.signin.internal.zzh;
import com.google.android.gms.signin.internal.zzi;
import java.util.concurrent.Executors;

public final class zzsa {
    public static final zzc<zzi> f17925a = new zzc();
    public static final zzc<zzi> f17926b = new zzc();
    public static final zza<zzi, zzsd> f17927c = new C07291();
    static final zza<zzi, zza> f17928d = new C07302();
    public static final Scope f17929e = new Scope("profile");
    public static final Scope f17930f = new Scope("email");
    public static final Api<zzsd> f17931g = new Api("SignIn.API", f17927c, f17925a);
    public static final Api<zza> f17932h = new Api("SignIn.INTERNAL_API", f17928d, f17926b);
    public static final zzsb f17933i = new zzh();

    final class C07291 extends zza<zzi, zzsd> {
        C07291() {
        }

        private static zzi m25407a(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zzsd com_google_android_gms_internal_zzsd, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzi(context, looper, true, com_google_android_gms_common_internal_zzf, com_google_android_gms_internal_zzsd == null ? zzsd.f18114a : com_google_android_gms_internal_zzsd, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
        }
    }

    final class C07302 extends zza<zzi, zza> {
        C07302() {
        }

        private static zzi m25409a(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zza com_google_android_gms_internal_zzsa_zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzi(context, looper, false, com_google_android_gms_common_internal_zzf, com_google_android_gms_internal_zzsa_zza.a, connectionCallbacks, onConnectionFailedListener);
        }
    }
}
