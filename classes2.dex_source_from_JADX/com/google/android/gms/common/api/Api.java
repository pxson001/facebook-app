package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {
    private final zza<?, O> f17872a;
    private final zze<?, O> f17873b = null;
    private final zzc<?> f17874c;
    private final zzf<?> f17875d;
    public final String f17876e;

    public final class zzc<C extends zzb> {
    }

    public abstract class zza<T extends zzb, O> {
        public static int m25085a() {
            return Integer.MAX_VALUE;
        }

        public static List<Scope> m25086b() {
            return Collections.emptyList();
        }

        public abstract T mo2975a(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);
    }

    public interface ApiOptions {

        public interface Optional extends HasOptions, NotRequiredOptions {
        }

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }
    }

    public interface zzb {
        void mo3022a();

        void mo3028a(com.google.android.gms.common.api.GoogleApiClient.zza com_google_android_gms_common_api_GoogleApiClient_zza);

        void mo3029a(zzp com_google_android_gms_common_internal_zzp);

        void mo3030a(zzp com_google_android_gms_common_internal_zzp, Set<Scope> set);

        void mo3031a(String str, PrintWriter printWriter);

        boolean mo3032b();

        boolean mo3033c();

        boolean mo3034d();

        Intent mo3035e();

        IBinder mo3036f();
    }

    public <C extends zzb> Api(String str, zza<C, O> com_google_android_gms_common_api_Api_zza_C__O, zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        zzx.m105a((Object) com_google_android_gms_common_api_Api_zza_C__O, (Object) "Cannot construct an Api with a null ClientBuilder");
        zzx.m105a((Object) com_google_android_gms_common_api_Api_zzc_C, (Object) "Cannot construct an Api with a null ClientKey");
        this.f17876e = str;
        this.f17872a = com_google_android_gms_common_api_Api_zza_C__O;
        this.f17874c = com_google_android_gms_common_api_Api_zzc_C;
        this.f17875d = null;
    }

    public final zza<?, O> m25088a() {
        zzx.m109a(this.f17872a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f17872a;
    }

    public final zze<?, O> m25089b() {
        zzx.m109a(this.f17873b != null, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return this.f17873b;
    }

    public final zzc<?> m25090c() {
        zzx.m109a(this.f17874c != null, (Object) "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.f17874c;
    }

    public final boolean m25091d() {
        return this.f17875d != null;
    }

    public final String m25092e() {
        return this.f17876e;
    }
}
