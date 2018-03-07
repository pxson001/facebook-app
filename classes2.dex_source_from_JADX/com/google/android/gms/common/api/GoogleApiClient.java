package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzsc;
import com.google.android.gms.internal.zzsd;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    public static final Set<GoogleApiClient> f18960a = Collections.newSetFromMap(new WeakHashMap());

    public interface ConnectionCallbacks {
        void mo38a(int i);

        void mo39a(Bundle bundle);
    }

    public interface OnConnectionFailedListener {
        void mo40a(ConnectionResult connectionResult);
    }

    public final class Builder {
        private Account f17888a;
        public final Set<Scope> f17889b = new HashSet();
        public final Set<Scope> f17890c = new HashSet();
        private int f17891d;
        private View f17892e;
        private String f17893f;
        private String f17894g;
        private final Map<Api<?>, com.google.android.gms.common.internal.zzf.zza> f17895h = new ArrayMap();
        private final Context f17896i;
        public final Map<Api<?>, ApiOptions> f17897j = new ArrayMap();
        public FragmentActivity f17898k;
        private int f17899l = -1;
        private OnConnectionFailedListener f17900m;
        public Looper f17901n;
        private GoogleApiAvailability f17902o = GoogleApiAvailability.f56b;
        private com.google.android.gms.common.api.Api.zza<? extends zzsc, zzsd> f17903p = zzsa.f17927c;
        private final ArrayList<ConnectionCallbacks> f17904q = new ArrayList();
        private final ArrayList<OnConnectionFailedListener> f17905r = new ArrayList();
        private zzsd f17906s;

        public Builder(Context context) {
            this.f17896i = context;
            this.f17901n = context.getMainLooper();
            this.f17893f = context.getPackageName();
            this.f17894g = context.getClass().getName();
        }

        private static <C extends zzb, O> C m25132a(com.google.android.gms.common.api.Api.zza<C, O> com_google_android_gms_common_api_Api_zza_C__O, Object obj, Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return com_google_android_gms_common_api_Api_zza_C__O.mo2975a(context, looper, com_google_android_gms_common_internal_zzf, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private static <C extends zzd, O> zzad m25133a(zze<C, O> com_google_android_gms_common_api_Api_zze_C__O, Object obj, Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzad(context, looper, com_google_android_gms_common_api_Api_zze_C__O.c(), connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf, com_google_android_gms_common_api_Api_zze_C__O.a());
        }

        public static void m25134a(Builder builder, zzmr com_google_android_gms_internal_zzmr, GoogleApiClient googleApiClient) {
            int i = builder.f17899l;
            OnConnectionFailedListener onConnectionFailedListener = builder.f17900m;
            zzx.m105a((Object) googleApiClient, (Object) "GoogleApiClient instance cannot be null");
            zzx.m109a(com_google_android_gms_internal_zzmr.h.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
            com_google_android_gms_internal_zzmr.h.put(i, new com.google.android.gms.internal.zzmr.zza(com_google_android_gms_internal_zzmr, i, googleApiClient, onConnectionFailedListener));
            if (com_google_android_gms_internal_zzmr.b && !com_google_android_gms_internal_zzmr.c) {
                googleApiClient.mo3058c();
            }
        }

        private void m25135a(GoogleApiClient googleApiClient) {
            zzmr a = zzmr.a(this.f17898k);
            if (a == null) {
                HandlerDetour.a(new Handler(this.f17896i.getMainLooper()), new 1(this, googleApiClient), -1203429184);
            } else {
                m25134a(this, a, googleApiClient);
            }
        }

        private GoogleApiClient m25136c() {
            zzf a = m25140a();
            Api api = null;
            Map e = a.m25415e();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api2 = null;
            for (Api api3 : this.f17897j.keySet()) {
                Api api32;
                zzb a2;
                Api api4;
                Object obj = this.f17897j.get(api32);
                int i = 0;
                if (e.get(api32) != null) {
                    i = ((com.google.android.gms.common.internal.zzf.zza) e.get(api32)).b ? 1 : 2;
                }
                arrayMap.put(api32, Integer.valueOf(i));
                ConnectionCallbacks com_google_android_gms_internal_zzlz = new zzlz(api32, i);
                arrayList.add(com_google_android_gms_internal_zzlz);
                Api api5;
                if (api32.m25091d()) {
                    zze b = api32.m25089b();
                    api5 = b.b() == 1 ? api32 : api2;
                    a2 = m25133a(b, obj, this.f17896i, this.f17901n, a, com_google_android_gms_internal_zzlz, (OnConnectionFailedListener) com_google_android_gms_internal_zzlz);
                    api4 = api5;
                } else {
                    com.google.android.gms.common.api.Api.zza a3 = api32.m25088a();
                    api5 = com.google.android.gms.common.api.Api.zza.m25085a() == 1 ? api32 : api2;
                    a2 = m25132a(a3, obj, this.f17896i, this.f17901n, a, com_google_android_gms_internal_zzlz, (OnConnectionFailedListener) com_google_android_gms_internal_zzlz);
                    api4 = api5;
                }
                arrayMap2.put(api32.m25090c(), a2);
                if (!a2.mo3034d()) {
                    api32 = api;
                } else if (api != null) {
                    throw new IllegalStateException(api32.m25092e() + " cannot be used with " + api.m25092e());
                }
                api2 = api4;
                api = api32;
            }
            if (api != null) {
                if (api2 != null) {
                    throw new IllegalStateException(api.m25092e() + " cannot be used with " + api2.m25092e());
                }
                zzx.m110a(this.f17888a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.m25092e());
                zzx.m110a(this.f17889b.equals(this.f17890c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.m25092e());
                zzx.m110a(this.f17906s == null, "Must not call requestServerAuthCode in GoogleApiClient.Builder when using %s. Call requestServerAuthCode in GoogleSignInOptions.Builder instead.", api.m25092e());
            }
            return new zzmg(this.f17896i, new ReentrantLock(), this.f17901n, a, this.f17902o, this.f17903p, arrayMap, this.f17904q, this.f17905r, arrayMap2, this.f17899l, zzmg.m26607a(arrayMap2.values(), true), arrayList);
        }

        public final Builder m25137a(Api<? extends NotRequiredOptions> api) {
            zzx.m105a((Object) api, (Object) "Api must not be null");
            this.f17897j.put(api, null);
            api.m25088a();
            Collection b = com.google.android.gms.common.api.Api.zza.m25086b();
            this.f17890c.addAll(b);
            this.f17889b.addAll(b);
            return this;
        }

        public final Builder m25138a(ConnectionCallbacks connectionCallbacks) {
            zzx.m105a((Object) connectionCallbacks, (Object) "Listener must not be null");
            this.f17904q.add(connectionCallbacks);
            return this;
        }

        public final Builder m25139a(OnConnectionFailedListener onConnectionFailedListener) {
            zzx.m105a((Object) onConnectionFailedListener, (Object) "Listener must not be null");
            this.f17905r.add(onConnectionFailedListener);
            return this;
        }

        public final zzf m25140a() {
            if (this.f17897j.containsKey(zzsa.f17931g)) {
                zzx.m109a(this.f17906s == null, (Object) "SignIn.API can't be used in conjunction with requestServerAuthCode.");
                this.f17906s = (zzsd) this.f17897j.get(zzsa.f17931g);
            }
            return new zzf(this.f17888a, this.f17889b, this.f17895h, this.f17891d, this.f17892e, this.f17893f, this.f17894g, this.f17906s != null ? this.f17906s : zzsd.f18114a);
        }

        public final GoogleApiClient m25141b() {
            zzx.m113b(!this.f17897j.isEmpty(), "must call addApi() to add at least one API");
            GoogleApiClient c = m25136c();
            synchronized (GoogleApiClient.f18960a) {
                GoogleApiClient.f18960a.add(c);
            }
            if (this.f17899l >= 0) {
                m25135a(c);
            }
            return c;
        }
    }

    public interface zza {
        void mo3083a(ConnectionResult connectionResult);

        void mo3084b(ConnectionResult connectionResult);
    }

    public abstract ConnectionResult mo3045a(long j, TimeUnit timeUnit);

    public <C extends zzb> C mo3046a(zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, R extends Result, T extends com.google.android.gms.internal.zzlx.zza<R, A>> T mo3047a(T t) {
        throw new UnsupportedOperationException();
    }

    public void mo3048a(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo3051a(ConnectionCallbacks connectionCallbacks);

    public abstract void mo3052a(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void mo3053a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public boolean mo3054a(zzmp com_google_android_gms_internal_zzmp) {
        throw new UnsupportedOperationException();
    }

    public Looper mo3055b() {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, T extends com.google.android.gms.internal.zzlx.zza<? extends Result, A>> T mo3056b(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo3057b(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void mo3058c();

    public abstract ConnectionResult mo3060d();

    public abstract void mo3061e();

    public abstract boolean mo3062f();

    public abstract boolean mo3063g();
}
