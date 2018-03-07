package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzme implements zzmh {
    public final zzmi f19091a;
    public final Lock f19092b;
    public final Context f19093c;
    public final GoogleApiAvailability f19094d;
    public ConnectionResult f19095e;
    public int f19096f;
    public int f19097g = 0;
    private boolean f19098h = false;
    public int f19099i;
    private final Bundle f19100j = new Bundle();
    private final Set<zzc> f19101k = new HashSet();
    public zzsc f19102l;
    private int f19103m;
    public boolean f19104n;
    public boolean f19105o;
    public zzp f19106p;
    public boolean f19107q;
    public boolean f19108r;
    private final zzf f19109s;
    private final Map<Api<?>, Integer> f19110t;
    private final zza<? extends zzsc, zzsd> f19111u;
    public ArrayList<Future<?>> f19112v = new ArrayList();

    class zzd implements GoogleApiClient.zza {
        private final WeakReference<zzme> f19113a;
        private final Api<?> f19114b;
        private final int f19115c;

        public zzd(zzme com_google_android_gms_internal_zzme, Api<?> api, int i) {
            this.f19113a = new WeakReference(com_google_android_gms_internal_zzme);
            this.f19114b = api;
            this.f19115c = i;
        }

        public final void mo3083a(ConnectionResult connectionResult) {
            boolean z = false;
            zzme com_google_android_gms_internal_zzme = (zzme) this.f19113a.get();
            if (com_google_android_gms_internal_zzme != null) {
                if (Looper.myLooper() == com_google_android_gms_internal_zzme.f19091a.f19080g.mo3055b()) {
                    z = true;
                }
                zzx.m109a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                com_google_android_gms_internal_zzme.f19092b.lock();
                try {
                    if (zzme.m26833b(com_google_android_gms_internal_zzme, 0)) {
                        if (!connectionResult.m31395b()) {
                            zzme.m26832b(com_google_android_gms_internal_zzme, connectionResult, this.f19114b, this.f19115c);
                        }
                        if (zzme.m26837d(com_google_android_gms_internal_zzme)) {
                            zzme.m26838e(com_google_android_gms_internal_zzme);
                        }
                        com_google_android_gms_internal_zzme.f19092b.unlock();
                    }
                } finally {
                    com_google_android_gms_internal_zzme.f19092b.unlock();
                }
            }
        }

        public final void mo3084b(ConnectionResult connectionResult) {
            boolean z = true;
            zzme com_google_android_gms_internal_zzme = (zzme) this.f19113a.get();
            if (com_google_android_gms_internal_zzme != null) {
                if (Looper.myLooper() != com_google_android_gms_internal_zzme.f19091a.f19080g.mo3055b()) {
                    z = false;
                }
                zzx.m109a(z, (Object) "onReportAccountValidation must be called on the GoogleApiClient handler thread");
                com_google_android_gms_internal_zzme.f19092b.lock();
                try {
                    if (zzme.m26833b(com_google_android_gms_internal_zzme, 1)) {
                        if (!connectionResult.m31395b()) {
                            zzme.m26832b(com_google_android_gms_internal_zzme, connectionResult, this.f19114b, this.f19115c);
                        }
                        if (zzme.m26837d(com_google_android_gms_internal_zzme)) {
                            zzme.m26839g(com_google_android_gms_internal_zzme);
                        }
                        com_google_android_gms_internal_zzme.f19092b.unlock();
                    }
                } finally {
                    com_google_android_gms_internal_zzme.f19092b.unlock();
                }
            }
        }
    }

    class zze extends zzi {
        final /* synthetic */ zzme f19121a;
        private final Map<zzb, GoogleApiClient.zza> f19122c;

        public zze(zzme com_google_android_gms_internal_zzme, Map<zzb, GoogleApiClient.zza> map) {
            this.f19121a = com_google_android_gms_internal_zzme;
            super(com_google_android_gms_internal_zzme);
            this.f19122c = map;
        }

        public final void mo3085a() {
            int a = GoogleApiAvailability.m148a(this.f19121a.f19093c);
            if (a != 0) {
                this.f19121a.f19091a.m26794a(new 1(this, this.f19121a, new ConnectionResult(a, null)));
                return;
            }
            if (this.f19121a.f19104n) {
                this.f19121a.f19102l.j();
            }
            for (zzb com_google_android_gms_common_api_Api_zzb : this.f19122c.keySet()) {
                com_google_android_gms_common_api_Api_zzb.mo3028a((GoogleApiClient.zza) this.f19122c.get(com_google_android_gms_common_api_Api_zzb));
            }
        }
    }

    abstract class zzi implements Runnable {
        final /* synthetic */ zzme f19123b;

        public zzi(zzme com_google_android_gms_internal_zzme) {
            this.f19123b = com_google_android_gms_internal_zzme;
        }

        protected abstract void mo3085a();

        public void run() {
            this.f19123b.f19092b.lock();
            try {
                if (!Thread.interrupted()) {
                    mo3085a();
                    this.f19123b.f19092b.unlock();
                }
            } catch (RuntimeException e) {
                this.f19123b.f19091a.m26795a(e);
            } finally {
                this.f19123b.f19092b.unlock();
            }
        }
    }

    public zzme(zzmi com_google_android_gms_internal_zzmi, zzf com_google_android_gms_common_internal_zzf, Map<Api<?>, Integer> map, GoogleApiAvailability googleApiAvailability, zza<? extends zzsc, zzsd> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd, Lock lock, Context context) {
        this.f19091a = com_google_android_gms_internal_zzmi;
        this.f19109s = com_google_android_gms_common_internal_zzf;
        this.f19110t = map;
        this.f19094d = googleApiAvailability;
        this.f19111u = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd;
        this.f19092b = lock;
        this.f19093c = context;
    }

    private void m26831a(boolean z) {
        if (this.f19102l != null) {
            if (this.f19102l.mo3032b() && z) {
                this.f19102l.o_();
            }
            this.f19102l.mo3022a();
            this.f19106p = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m26832b(com.google.android.gms.internal.zzme r9, com.google.android.gms.common.ConnectionResult r10, com.google.android.gms.common.api.Api r11, int r12) {
        /*
        r0 = 2;
        if (r12 == r0) goto L_0x001f;
    L_0x0003:
        r11.m25088a();
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r0 = r2;
        r3 = 1;
        r2 = 0;
        if (r12 != r3) goto L_0x002b;
    L_0x000e:
        r5 = 1;
        r6 = r10.m31394a();
        if (r6 == 0) goto L_0x0035;
    L_0x0015:
        r4 = r5;
        if (r4 != 0) goto L_0x002b;
    L_0x0018:
        r1 = r2;
        if (r1 == 0) goto L_0x001f;
    L_0x001b:
        r9.f19095e = r10;
        r9.f19096f = r0;
    L_0x001f:
        r0 = r9.f19091a;
        r0 = r0.f19075b;
        r1 = r11.m25090c();
        r0.put(r1, r10);
        return;
    L_0x002b:
        r4 = r9.f19095e;
        if (r4 == 0) goto L_0x0033;
    L_0x002f:
        r4 = r9.f19096f;
        if (r0 >= r4) goto L_0x0018;
    L_0x0033:
        r2 = r3;
        goto L_0x0018;
    L_0x0035:
        r6 = r9.f19094d;
        r8 = r10.f23273c;
        r7 = r8;
        r8 = 0;
        r8 = r6.m152a(r8, r7, r8);
        r6 = r8;
        if (r6 != 0) goto L_0x0015;
    L_0x0042:
        r5 = 0;
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzme.b(com.google.android.gms.internal.zzme, com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, int):void");
    }

    public static boolean m26833b(zzme com_google_android_gms_internal_zzme, int i) {
        if (com_google_android_gms_internal_zzme.f19097g == i) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", com_google_android_gms_internal_zzme.f19091a.f19080g.m26637k());
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + m26834c(com_google_android_gms_internal_zzme.f19097g) + " but received callback for step " + m26834c(i), new Exception());
        m26836d(com_google_android_gms_internal_zzme, new ConnectionResult(8, null));
        return false;
    }

    private static String m26834c(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "STEP_VALIDATING_ACCOUNT";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    public static boolean m26835c(zzme com_google_android_gms_internal_zzme, ConnectionResult connectionResult) {
        return com_google_android_gms_internal_zzme.f19103m != 2 ? com_google_android_gms_internal_zzme.f19103m == 1 && !connectionResult.m31394a() : true;
    }

    public static void m26836d(zzme com_google_android_gms_internal_zzme, ConnectionResult connectionResult) {
        com_google_android_gms_internal_zzme.m26843k();
        com_google_android_gms_internal_zzme.m26831a(!connectionResult.m31394a());
        com_google_android_gms_internal_zzme.f19091a.m26792a(connectionResult);
        if (!com_google_android_gms_internal_zzme.f19098h) {
            com_google_android_gms_internal_zzme.f19091a.f19081h.mo3050a(connectionResult);
        }
        com_google_android_gms_internal_zzme.f19098h = false;
    }

    public static boolean m26837d(zzme com_google_android_gms_internal_zzme) {
        com_google_android_gms_internal_zzme.f19099i--;
        if (com_google_android_gms_internal_zzme.f19099i > 0) {
            return false;
        }
        if (com_google_android_gms_internal_zzme.f19099i < 0) {
            Log.i("GoogleApiClientConnecting", com_google_android_gms_internal_zzme.f19091a.f19080g.m26637k());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m26836d(com_google_android_gms_internal_zzme, new ConnectionResult(8, null));
            return false;
        } else if (com_google_android_gms_internal_zzme.f19095e == null) {
            return true;
        } else {
            com_google_android_gms_internal_zzme.f19091a.f19079f = com_google_android_gms_internal_zzme.f19096f;
            m26836d(com_google_android_gms_internal_zzme, com_google_android_gms_internal_zzme.f19095e);
            return false;
        }
    }

    public static void m26838e(zzme com_google_android_gms_internal_zzme) {
        if (com_google_android_gms_internal_zzme.f19099i == 0) {
            if (!com_google_android_gms_internal_zzme.f19104n) {
                m26840h(com_google_android_gms_internal_zzme);
            } else if (com_google_android_gms_internal_zzme.f19105o) {
                ArrayList arrayList = new ArrayList();
                com_google_android_gms_internal_zzme.f19097g = 1;
                com_google_android_gms_internal_zzme.f19099i = com_google_android_gms_internal_zzme.f19091a.f19074a.size();
                for (zzc com_google_android_gms_common_api_Api_zzc : com_google_android_gms_internal_zzme.f19091a.f19074a.keySet()) {
                    if (!com_google_android_gms_internal_zzme.f19091a.f19075b.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                        arrayList.add(com_google_android_gms_internal_zzme.f19091a.f19074a.get(com_google_android_gms_common_api_Api_zzc));
                    } else if (m26837d(com_google_android_gms_internal_zzme)) {
                        m26839g(com_google_android_gms_internal_zzme);
                    }
                }
                if (!arrayList.isEmpty()) {
                    com_google_android_gms_internal_zzme.f19112v.add(ExecutorDetour.a(zzmj.f19116a, new zzh(com_google_android_gms_internal_zzme, arrayList), 800379171));
                }
            }
        }
    }

    public static void m26839g(zzme com_google_android_gms_internal_zzme) {
        com_google_android_gms_internal_zzme.f19097g = 2;
        com_google_android_gms_internal_zzme.f19091a.f19080g.f18934d = m26844l(com_google_android_gms_internal_zzme);
        com_google_android_gms_internal_zzme.f19112v.add(ExecutorDetour.a(zzmj.f19116a, new zzc(com_google_android_gms_internal_zzme), 1604504577));
    }

    public static void m26840h(zzme com_google_android_gms_internal_zzme) {
        ArrayList arrayList = new ArrayList();
        com_google_android_gms_internal_zzme.f19097g = 3;
        com_google_android_gms_internal_zzme.f19099i = com_google_android_gms_internal_zzme.f19091a.f19074a.size();
        for (zzc com_google_android_gms_common_api_Api_zzc : com_google_android_gms_internal_zzme.f19091a.f19074a.keySet()) {
            if (!com_google_android_gms_internal_zzme.f19091a.f19075b.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                arrayList.add(com_google_android_gms_internal_zzme.f19091a.f19074a.get(com_google_android_gms_common_api_Api_zzc));
            } else if (m26837d(com_google_android_gms_internal_zzme)) {
                com_google_android_gms_internal_zzme.m26841i();
            }
        }
        if (!arrayList.isEmpty()) {
            com_google_android_gms_internal_zzme.f19112v.add(ExecutorDetour.a(zzmj.f19116a, new zzf(com_google_android_gms_internal_zzme, arrayList), -1220938424));
        }
    }

    private void m26841i() {
        this.f19091a.m26804g();
        ExecutorDetour.a(zzmj.f19116a, new 1(this), -1451514367);
        if (this.f19102l != null) {
            if (this.f19107q) {
                this.f19102l.a(this.f19106p, this.f19108r);
            }
            m26831a(false);
        }
        for (zzc com_google_android_gms_common_api_Api_zzc : this.f19091a.f19075b.keySet()) {
            ((zzb) this.f19091a.f19074a.get(com_google_android_gms_common_api_Api_zzc)).mo3022a();
        }
        this.f19091a.f19081h.mo3049a(this.f19100j.isEmpty() ? null : this.f19100j);
        if (this.f19098h) {
            this.f19098h = false;
            mo3081b();
        }
    }

    public static void m26842j(zzme com_google_android_gms_internal_zzme) {
        com_google_android_gms_internal_zzme.f19104n = false;
        com_google_android_gms_internal_zzme.f19091a.f19080g.f18934d = Collections.emptySet();
        for (zzc com_google_android_gms_common_api_Api_zzc : com_google_android_gms_internal_zzme.f19101k) {
            if (!com_google_android_gms_internal_zzme.f19091a.f19075b.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                com_google_android_gms_internal_zzme.f19091a.f19075b.put(com_google_android_gms_common_api_Api_zzc, new ConnectionResult(17, null));
            }
        }
    }

    private void m26843k() {
        Iterator it = this.f19112v.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f19112v.clear();
    }

    public static Set m26844l(zzme com_google_android_gms_internal_zzme) {
        if (com_google_android_gms_internal_zzme.f19109s == null) {
            return Collections.emptySet();
        }
        Set hashSet = new HashSet(com_google_android_gms_internal_zzme.f19109s.f18105b);
        Map map = com_google_android_gms_internal_zzme.f19109s.f18107d;
        for (Api api : map.keySet()) {
            if (!com_google_android_gms_internal_zzme.f19091a.f19075b.containsKey(api.m25090c())) {
                hashSet.addAll(((zzf.zza) map.get(api)).a);
            }
        }
        return hashSet;
    }

    public final <A extends zzb, R extends Result, T extends zzlx.zza<R, A>> T mo3075a(T t) {
        this.f19091a.f19080g.f18931a.add(t);
        return t;
    }

    public final void mo3076a() {
        this.f19091a.f19075b.clear();
        this.f19098h = false;
        this.f19104n = false;
        this.f19095e = null;
        this.f19097g = 0;
        this.f19103m = 2;
        this.f19105o = false;
        this.f19107q = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (Api api : this.f19110t.keySet()) {
            zzb com_google_android_gms_common_api_Api_zzb = (zzb) this.f19091a.f19074a.get(api.m25090c());
            int intValue = ((Integer) this.f19110t.get(api)).intValue();
            api.m25088a();
            int i2 = (Integer.MAX_VALUE == 1 ? 1 : 0) | i;
            if (com_google_android_gms_common_api_Api_zzb.mo3033c()) {
                this.f19104n = true;
                if (intValue < this.f19103m) {
                    this.f19103m = intValue;
                }
                if (intValue != 0) {
                    this.f19101k.add(api.m25090c());
                }
            }
            hashMap.put(com_google_android_gms_common_api_Api_zzb, new zzd(this, api, intValue));
            i = i2;
        }
        if (i != 0) {
            this.f19104n = false;
        }
        if (this.f19104n) {
            this.f19109s.f18113j = Integer.valueOf(this.f19091a.f19080g.m26638l());
            zzg com_google_android_gms_internal_zzme_zzg = new zzg(this);
            this.f19102l = (zzsc) this.f19111u.mo2975a(this.f19093c, this.f19091a.f19080g.mo3055b(), this.f19109s, this.f19109s.f18112i, com_google_android_gms_internal_zzme_zzg, com_google_android_gms_internal_zzme_zzg);
        }
        this.f19099i = this.f19091a.f19074a.size();
        this.f19112v.add(ExecutorDetour.a(zzmj.f19116a, new zze(this, hashMap), -150211192));
    }

    public final void mo3077a(int i) {
        m26836d(this, new ConnectionResult(8, null));
    }

    public final void mo3078a(Bundle bundle) {
        if (m26833b(this, 3)) {
            if (bundle != null) {
                this.f19100j.putAll(bundle);
            }
            if (m26837d(this)) {
                m26841i();
            }
        }
    }

    public final void mo3079a(ConnectionResult connectionResult, Api<?> api, int i) {
        if (m26833b(this, 3)) {
            m26832b(this, connectionResult, api, i);
            if (m26837d(this)) {
                m26841i();
            }
        }
    }

    public final <A extends zzb, T extends zzlx.zza<? extends Result, A>> T mo3080b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void mo3081b() {
        Iterator it = this.f19091a.f19080g.f18931a.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.zzmg.zze com_google_android_gms_internal_zzmg_zze = (com.google.android.gms.internal.zzmg.zze) it.next();
            if (com_google_android_gms_internal_zzmg_zze.e() != 1) {
                com_google_android_gms_internal_zzmg_zze.h();
                it.remove();
            }
        }
        if (this.f19095e != null || this.f19091a.f19080g.f18931a.isEmpty()) {
            m26843k();
            m26831a(true);
            this.f19091a.m26792a(null);
            return;
        }
        this.f19098h = true;
    }

    public final void mo3082c() {
        this.f19098h = false;
    }
}
