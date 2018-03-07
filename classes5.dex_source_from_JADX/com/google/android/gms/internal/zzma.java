package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmm.zza;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class zzma implements zzmm {
    private final Context f6846a;
    private final zzmg f6847b;
    private final Looper f6848c;
    public final zzmi f6849d;
    public final zzmi f6850e;
    private final Map<zzc<?>, zzmi> f6851f = new ArrayMap();
    private final Set<zzmp> f6852g = Collections.newSetFromMap(new WeakHashMap());
    private final zzb f6853h;
    private Bundle f6854i;
    public ConnectionResult f6855j = null;
    public ConnectionResult f6856k = null;
    private final AtomicInteger f6857l = new AtomicInteger(0);
    public final Lock f6858m;
    private int f6859n = 0;

    class C07881 implements zza {
        final /* synthetic */ zzma f6844a;

        C07881(zzma com_google_android_gms_internal_zzma) {
            this.f6844a = com_google_android_gms_internal_zzma;
        }

        public final void m12783a(Bundle bundle) {
            this.f6844a.f6858m.lock();
            try {
                zzma.m12789a(this.f6844a, bundle);
                this.f6844a.f6855j = ConnectionResult.a;
                zzma.m12795h(this.f6844a);
            } finally {
                this.f6844a.f6858m.unlock();
            }
        }

        public final void m12784a(ConnectionResult connectionResult) {
            this.f6844a.f6858m.lock();
            try {
                this.f6844a.f6855j = connectionResult;
                zzma.m12795h(this.f6844a);
            } finally {
                this.f6844a.f6858m.unlock();
            }
        }

        public final void c_(int i) {
            this.f6844a.f6858m.lock();
            try {
                zzma.m12790a(this.f6844a, this.f6844a.f6850e, i);
            } finally {
                this.f6844a.f6858m.unlock();
            }
        }
    }

    class C07892 implements zza {
        final /* synthetic */ zzma f6845a;

        C07892(zzma com_google_android_gms_internal_zzma) {
            this.f6845a = com_google_android_gms_internal_zzma;
        }

        public final void m12785a(Bundle bundle) {
            this.f6845a.f6858m.lock();
            try {
                this.f6845a.f6856k = ConnectionResult.a;
                zzma.m12795h(this.f6845a);
            } finally {
                this.f6845a.f6858m.unlock();
            }
        }

        public final void m12786a(ConnectionResult connectionResult) {
            this.f6845a.f6858m.lock();
            try {
                this.f6845a.f6856k = connectionResult;
                zzma.m12795h(this.f6845a);
            } finally {
                this.f6845a.f6858m.unlock();
            }
        }

        public final void c_(int i) {
            this.f6845a.f6858m.lock();
            try {
                zzma.m12790a(this.f6845a, this.f6845a.f6849d, i);
            } finally {
                this.f6845a.f6858m.unlock();
            }
        }
    }

    public zzma(Context context, zzmg com_google_android_gms_internal_zzmg, Lock lock, Looper looper, GoogleApiAvailability googleApiAvailability, Map<zzc<?>, zzb> map, zzf com_google_android_gms_common_internal_zzf, Map<Api<?>, Integer> map2, Api.zza<? extends zzsc, zzsd> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd, ArrayList<zzlz> arrayList) {
        this.f6846a = context;
        this.f6847b = com_google_android_gms_internal_zzmg;
        this.f6858m = lock;
        this.f6848c = looper;
        zzb com_google_android_gms_common_api_Api_zzb = null;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        for (zzc com_google_android_gms_common_api_Api_zzc : map.keySet()) {
            zzb com_google_android_gms_common_api_Api_zzb2 = (zzb) map.get(com_google_android_gms_common_api_Api_zzc);
            if (com_google_android_gms_common_api_Api_zzb2.d()) {
                com_google_android_gms_common_api_Api_zzb = com_google_android_gms_common_api_Api_zzb2;
            }
            if (com_google_android_gms_common_api_Api_zzb2.c()) {
                arrayMap.put(com_google_android_gms_common_api_Api_zzc, com_google_android_gms_common_api_Api_zzb2);
            } else {
                arrayMap2.put(com_google_android_gms_common_api_Api_zzc, com_google_android_gms_common_api_Api_zzb2);
            }
        }
        this.f6853h = com_google_android_gms_common_api_Api_zzb;
        if (arrayMap.isEmpty()) {
            throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        }
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api api : map2.keySet()) {
            zzc c = api.c();
            if (arrayMap.containsKey(c)) {
                arrayMap3.put(api, map2.get(api));
            } else if (arrayMap2.containsKey(c)) {
                arrayMap4.put(api, map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzlz com_google_android_gms_internal_zzlz = (zzlz) it.next();
            if (arrayMap3.containsKey(com_google_android_gms_internal_zzlz.a)) {
                arrayList2.add(com_google_android_gms_internal_zzlz);
            } else if (arrayMap4.containsKey(com_google_android_gms_internal_zzlz.a)) {
                arrayList3.add(com_google_android_gms_internal_zzlz);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        Context context2 = context;
        this.f6849d = new zzmi(context2, this.f6847b, lock, looper, googleApiAvailability, arrayMap2, null, arrayMap4, null, arrayList3, new C07881(this));
        Context context3 = context;
        this.f6850e = new zzmi(context3, this.f6847b, lock, looper, googleApiAvailability, arrayMap, com_google_android_gms_common_internal_zzf, arrayMap3, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd, arrayList2, new C07892(this));
        for (zzc com_google_android_gms_common_api_Api_zzc2 : arrayMap2.keySet()) {
            this.f6851f.put(com_google_android_gms_common_api_Api_zzc2, this.f6849d);
        }
        for (zzc com_google_android_gms_common_api_Api_zzc22 : arrayMap.keySet()) {
            this.f6851f.put(com_google_android_gms_common_api_Api_zzc22, this.f6850e);
        }
    }

    private void m12788a(ConnectionResult connectionResult) {
        switch (this.f6859n) {
            case 1:
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                this.f6847b.a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m12797j();
        this.f6859n = 0;
    }

    public static void m12789a(zzma com_google_android_gms_internal_zzma, Bundle bundle) {
        if (com_google_android_gms_internal_zzma.f6854i == null) {
            com_google_android_gms_internal_zzma.f6854i = bundle;
        } else if (bundle != null) {
            com_google_android_gms_internal_zzma.f6854i.putAll(bundle);
        }
    }

    public static void m12790a(zzma com_google_android_gms_internal_zzma, zzmi com_google_android_gms_internal_zzmi, int i) {
        if (com_google_android_gms_internal_zzma.f6857l.getAndIncrement() % 2 == 1) {
            com_google_android_gms_internal_zzma.f6847b.c_(i);
        }
        com_google_android_gms_internal_zzmi.a(i);
        com_google_android_gms_internal_zzma.f6856k = null;
        com_google_android_gms_internal_zzma.f6855j = null;
    }

    private static boolean m12792b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.b();
    }

    private boolean m12793c(zzlx$zza<? extends Result, ? extends zzb> com_google_android_gms_internal_zzlx_zza__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb) {
        zzc c = com_google_android_gms_internal_zzlx_zza__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb.mo832c();
        zzx.b(this.f6851f.containsKey(c), "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzmi) this.f6851f.get(c)).equals(this.f6850e);
    }

    private boolean m12794f() {
        return this.f6850e.d();
    }

    public static void m12795h(zzma com_google_android_gms_internal_zzma) {
        if (m12792b(com_google_android_gms_internal_zzma.f6855j)) {
            if (m12792b(com_google_android_gms_internal_zzma.f6856k) || com_google_android_gms_internal_zzma.m12798k()) {
                com_google_android_gms_internal_zzma.m12796i();
            } else if (com_google_android_gms_internal_zzma.f6856k == null) {
            } else {
                if (com_google_android_gms_internal_zzma.f6859n == 1) {
                    com_google_android_gms_internal_zzma.m12797j();
                    return;
                }
                com_google_android_gms_internal_zzma.m12788a(com_google_android_gms_internal_zzma.f6856k);
                com_google_android_gms_internal_zzma.f6849d.c();
            }
        } else if (com_google_android_gms_internal_zzma.f6855j != null && m12792b(com_google_android_gms_internal_zzma.f6856k)) {
            com_google_android_gms_internal_zzma.f6850e.c();
            com_google_android_gms_internal_zzma.m12788a(com_google_android_gms_internal_zzma.f6855j);
        } else if (com_google_android_gms_internal_zzma.f6855j != null && com_google_android_gms_internal_zzma.f6856k != null) {
            ConnectionResult connectionResult = com_google_android_gms_internal_zzma.f6855j;
            if (com_google_android_gms_internal_zzma.f6850e.f < com_google_android_gms_internal_zzma.f6849d.f) {
                connectionResult = com_google_android_gms_internal_zzma.f6856k;
            }
            com_google_android_gms_internal_zzma.m12788a(connectionResult);
        }
    }

    private void m12796i() {
        switch (this.f6859n) {
            case 1:
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                this.f6847b.a(this.f6854i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CALLBACK_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m12797j();
        this.f6859n = 0;
    }

    private void m12797j() {
        for (zzmp kT_ : this.f6852g) {
            kT_.kT_();
        }
        this.f6852g.clear();
    }

    private boolean m12798k() {
        return this.f6856k != null && this.f6856k.c == 4;
    }

    private PendingIntent m12799l() {
        return this.f6853h == null ? null : PendingIntent.getActivity(this.f6846a, this.f6847b.l(), this.f6853h.e(), 134217728);
    }

    public final ConnectionResult m12800a(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final <A extends zzb, R extends Result, T extends zzlx$zza<R, A>> T m12801a(T t) {
        if (t.mo834e() == 1) {
            throw new IllegalStateException("ReportingServices.getReportingState is not supported with SIGN_IN_MODE_OPTIONAL.");
        } else if (!m12793c(t)) {
            return this.f6849d.a(t);
        } else {
            if (!m12798k()) {
                return this.f6850e.a(t);
            }
            t.mo829a(new Status(4, null, m12799l()));
            return t;
        }
    }

    public final void m12802a() {
        this.f6859n = 2;
        this.f6856k = null;
        this.f6855j = null;
        this.f6849d.a();
        this.f6850e.a();
    }

    public final void m12803a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f6850e.a(str + "  ", fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("unauthClient").println(":");
        this.f6849d.a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean m12804a(zzmp com_google_android_gms_internal_zzmp) {
        this.f6858m.lock();
        try {
            if ((m12809e() || m12808d()) && !m12794f()) {
                this.f6852g.add(com_google_android_gms_internal_zzmp);
                if (this.f6859n == 0) {
                    this.f6859n = 1;
                }
                this.f6856k = null;
                this.f6850e.a();
                return true;
            }
            this.f6858m.unlock();
            return false;
        } finally {
            this.f6858m.unlock();
        }
    }

    public final ConnectionResult m12805b() {
        throw new UnsupportedOperationException();
    }

    public final <A extends zzb, T extends zzlx$zza<? extends Result, A>> T m12806b(T t) {
        if (!m12793c(t)) {
            return this.f6849d.b(t);
        }
        if (!m12798k()) {
            return this.f6850e.b(t);
        }
        t.mo829a(new Status(4, null, m12799l()));
        return t;
    }

    public final void m12807c() {
        this.f6856k = null;
        this.f6855j = null;
        this.f6859n = 0;
        this.f6849d.c();
        this.f6850e.c();
        m12797j();
    }

    public final boolean m12808d() {
        boolean z = true;
        this.f6858m.lock();
        try {
            if (!(this.f6849d.d() && (m12794f() || m12798k() || this.f6859n == 1))) {
                z = false;
            }
            this.f6858m.unlock();
            return z;
        } catch (Throwable th) {
            this.f6858m.unlock();
        }
    }

    public final boolean m12809e() {
        this.f6858m.lock();
        try {
            boolean z = this.f6849d.e() || (this.f6850e.e() && this.f6859n == 2);
            this.f6858m.unlock();
            return z;
        } catch (Throwable th) {
            this.f6858m.unlock();
        }
    }
}
