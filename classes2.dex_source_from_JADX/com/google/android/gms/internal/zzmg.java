package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public final class zzmg extends GoogleApiClient implements com.google.android.gms.internal.zzmm.zza {
    final Queue<com.google.android.gms.internal.zzlx.zza<?, ?>> f18931a = new LinkedList();
    public zzc f18932b;
    final Map<zzc<?>, zzb> f18933c;
    Set<Scope> f18934d = new HashSet();
    final zzf f18935e;
    final Map<Api<?>, Integer> f18936f;
    final com.google.android.gms.common.api.Api.zza<? extends zzsc, zzsd> f18937g;
    final Set<zze<?>> f18938h = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private final Lock f18939i;
    private final zzk f18940j;
    private zzmm f18941k = null;
    private final int f18942l;
    public final Context f18943m;
    private final Looper f18944n;
    public volatile boolean f18945o;
    public long f18946p = 120000;
    public long f18947q = 5000;
    public final zza f18948r;
    public final GoogleApiAvailability f18949s;
    private final Set<zzmn<?>> f18950t = Collections.newSetFromMap(new WeakHashMap());
    public com.google.android.gms.common.api.zza f18951u;
    private final ArrayList<zzlz> f18952v;
    private Integer f18953w = null;
    private final zzd f18954x = new C07561(this);
    private final com.google.android.gms.common.internal.zzk.zza f18955y = new C07572(this);

    class C07561 implements zzd {
        final /* synthetic */ zzmg f19051a;

        C07561(zzmg com_google_android_gms_internal_zzmg) {
            this.f19051a = com_google_android_gms_internal_zzmg;
        }

        public final void mo3064a(zze<?> com_google_android_gms_internal_zzmg_zze_) {
            this.f19051a.f18938h.remove(com_google_android_gms_internal_zzmg_zze_);
            if (com_google_android_gms_internal_zzmg_zze_.b() != null && this.f19051a.f18951u != null) {
                com.google.android.gms.common.api.zza com_google_android_gms_common_api_zza = this.f19051a.f18951u;
                com_google_android_gms_internal_zzmg_zze_.b().intValue();
                com_google_android_gms_common_api_zza.a();
            }
        }
    }

    interface zzd {
        void mo3064a(zze<?> com_google_android_gms_internal_zzmg_zze_);
    }

    class C07572 implements com.google.android.gms.common.internal.zzk.zza {
        final /* synthetic */ zzmg f19052a;

        C07572(zzmg com_google_android_gms_internal_zzmg) {
            this.f19052a = com_google_android_gms_internal_zzmg;
        }

        public final boolean mo3032b() {
            return this.f19052a.mo3062f();
        }

        public final Bundle mo3037p() {
            return null;
        }
    }

    final class zza extends Handler {
        final /* synthetic */ zzmg f19062a;

        zza(zzmg com_google_android_gms_internal_zzmg, Looper looper) {
            this.f19062a = com_google_android_gms_internal_zzmg;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    zzmg.m26615q(this.f19062a);
                    return;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    zzmg.m26614p(this.f19062a);
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    public zzmg(Context context, Lock lock, Looper looper, zzf com_google_android_gms_common_internal_zzf, GoogleApiAvailability googleApiAvailability, com.google.android.gms.common.api.Api.zza<? extends zzsc, zzsd> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd, Map<Api<?>, Integer> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<zzc<?>, zzb> map2, int i, int i2, ArrayList<zzlz> arrayList) {
        this.f18943m = context;
        this.f18939i = lock;
        this.f18940j = new zzk(looper, this.f18955y);
        this.f18944n = looper;
        this.f18948r = new zza(this, looper);
        this.f18949s = googleApiAvailability;
        this.f18942l = i;
        if (this.f18942l >= 0) {
            this.f18953w = Integer.valueOf(i2);
        }
        this.f18936f = map;
        this.f18933c = map2;
        this.f18952v = arrayList;
        for (ConnectionCallbacks a : list) {
            this.f18940j.m26775a(a);
        }
        for (OnConnectionFailedListener a2 : list2) {
            this.f18940j.m26776a(a2);
        }
        this.f18935e = com_google_android_gms_common_internal_zzf;
        this.f18937g = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd;
    }

    public static int m26607a(Iterable<zzb> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (zzb com_google_android_gms_common_api_Api_zzb : iterable) {
            if (com_google_android_gms_common_api_Api_zzb.mo3033c()) {
                i2 = 1;
            }
            i = com_google_android_gms_common_api_Api_zzb.mo3034d() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    private static void m26608a(zze<?> com_google_android_gms_internal_zzmg_zze_, com.google.android.gms.common.api.zza com_google_android_gms_common_api_zza, IBinder iBinder) {
        if (com_google_android_gms_internal_zzmg_zze_.g()) {
            com_google_android_gms_internal_zzmg_zze_.a(new zzb(com_google_android_gms_internal_zzmg_zze_, com_google_android_gms_common_api_zza, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            com_google_android_gms_internal_zzmg_zze_.a(null);
            com_google_android_gms_internal_zzmg_zze_.h();
            com_google_android_gms_internal_zzmg_zze_.b().intValue();
            com_google_android_gms_common_api_zza.a();
        } else {
            zzb com_google_android_gms_internal_zzmg_zzb = new zzb(com_google_android_gms_internal_zzmg_zze_, com_google_android_gms_common_api_zza, iBinder);
            com_google_android_gms_internal_zzmg_zze_.a(com_google_android_gms_internal_zzmg_zzb);
            try {
                iBinder.linkToDeath(com_google_android_gms_internal_zzmg_zzb, 0);
            } catch (RemoteException e) {
                com_google_android_gms_internal_zzmg_zze_.h();
                com_google_android_gms_internal_zzmg_zze_.b().intValue();
                com_google_android_gms_common_api_zza.a();
            }
        }
    }

    private void m26609b(int i) {
        if (this.f18953w == null) {
            this.f18953w = Integer.valueOf(i);
        } else if (this.f18953w.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + m26610c(i) + ". Mode was already set to " + m26610c(this.f18953w.intValue()));
        }
        if (this.f18941k == null) {
            Object obj = null;
            Object obj2 = null;
            for (zzb com_google_android_gms_common_api_Api_zzb : this.f18933c.values()) {
                if (com_google_android_gms_common_api_Api_zzb.mo3033c()) {
                    obj2 = 1;
                }
                obj = com_google_android_gms_common_api_Api_zzb.mo3034d() ? 1 : obj;
            }
            switch (this.f18953w.intValue()) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    if (obj2 != null) {
                        this.f18941k = new zzma(this.f18943m, this, this.f18939i, this.f18944n, this.f18949s, this.f18933c, this.f18935e, this.f18936f, this.f18937g, this.f18952v);
                        return;
                    }
                    break;
            }
            this.f18941k = new zzmi(this.f18943m, this, this.f18939i, this.f18944n, this.f18949s, this.f18933c, this.f18935e, this.f18936f, this.f18937g, this.f18952v, this);
        }
    }

    private static String m26610c(int i) {
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "SIGN_IN_MODE_REQUIRED";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void m26611m() {
        for (zze com_google_android_gms_internal_zzmg_zze : this.f18938h) {
            com_google_android_gms_internal_zzmg_zze.a(null);
            if (com_google_android_gms_internal_zzmg_zze.b() == null) {
                com_google_android_gms_internal_zzmg_zze.h();
            } else {
                com_google_android_gms_internal_zzmg_zze.d();
                m26608a(com_google_android_gms_internal_zzmg_zze, this.f18951u, mo3046a(com_google_android_gms_internal_zzmg_zze.c()).mo3036f());
            }
        }
        this.f18938h.clear();
        for (zzmn a : this.f18950t) {
            a.a();
        }
        this.f18950t.clear();
    }

    private boolean m26612n() {
        return this.f18945o;
    }

    private void m26613o() {
        this.f18940j.m26777b();
        this.f18941k.mo3067a();
    }

    public static void m26614p(zzmg com_google_android_gms_internal_zzmg) {
        com_google_android_gms_internal_zzmg.f18939i.lock();
        try {
            if (com_google_android_gms_internal_zzmg.m26612n()) {
                com_google_android_gms_internal_zzmg.m26613o();
            }
            com_google_android_gms_internal_zzmg.f18939i.unlock();
        } catch (Throwable th) {
            com_google_android_gms_internal_zzmg.f18939i.unlock();
        }
    }

    public static void m26615q(zzmg com_google_android_gms_internal_zzmg) {
        com_google_android_gms_internal_zzmg.f18939i.lock();
        try {
            if (com_google_android_gms_internal_zzmg.m26636j()) {
                com_google_android_gms_internal_zzmg.m26613o();
            }
            com_google_android_gms_internal_zzmg.f18939i.unlock();
        } catch (Throwable th) {
            com_google_android_gms_internal_zzmg.f18939i.unlock();
        }
    }

    public final ConnectionResult mo3045a(long j, TimeUnit timeUnit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzx.m109a(z, (Object) "blockingConnect must not be called on the UI thread");
        zzx.m105a((Object) timeUnit, (Object) "TimeUnit must not be null");
        this.f18939i.lock();
        try {
            if (this.f18953w == null) {
                this.f18953w = Integer.valueOf(m26607a(this.f18933c.values(), false));
            } else if (this.f18953w.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m26609b(this.f18953w.intValue());
            this.f18940j.m26777b();
            ConnectionResult a = this.f18941k.mo3065a(j, timeUnit);
            return a;
        } finally {
            this.f18939i.unlock();
        }
    }

    public final <C extends zzb> C mo3046a(zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        Object obj = (zzb) this.f18933c.get(com_google_android_gms_common_api_Api_zzc_C);
        zzx.m105a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public final <A extends zzb, R extends Result, T extends com.google.android.gms.internal.zzlx.zza<R, A>> T mo3047a(T t) {
        zzx.m113b(t.c() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.m113b(this.f18933c.containsKey(t.c()), "GoogleApiClient is not configured to use the API required for this call.");
        this.f18939i.lock();
        try {
            if (this.f18941k == null) {
                this.f18931a.add(t);
            } else {
                t = this.f18941k.mo3066a((com.google.android.gms.internal.zzlx.zza) t);
                this.f18939i.unlock();
            }
            return t;
        } finally {
            this.f18939i.unlock();
        }
    }

    public final void mo3048a(int i) {
        boolean z = true;
        this.f18939i.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            zzx.m113b(z, "Illegal sign-in mode: " + i);
            m26609b(i);
            m26613o();
        } finally {
            this.f18939i.unlock();
        }
    }

    public final void mo3049a(Bundle bundle) {
        while (!this.f18931a.isEmpty()) {
            mo3056b((com.google.android.gms.internal.zzlx.zza) this.f18931a.remove());
        }
        this.f18940j.m26773a(bundle);
    }

    public final void mo3050a(ConnectionResult connectionResult) {
        if (!GooglePlayServicesUtil.m162b(this.f18943m, connectionResult.f23273c)) {
            m26636j();
        }
        if (!this.f18945o) {
            this.f18940j.m26774a(connectionResult);
            this.f18940j.m26771a();
        }
    }

    public final void mo3051a(ConnectionCallbacks connectionCallbacks) {
        this.f18940j.m26778b(connectionCallbacks);
    }

    public final void mo3052a(OnConnectionFailedListener onConnectionFailedListener) {
        this.f18940j.m26776a(onConnectionFailedListener);
    }

    final <A extends zzb> void m26624a(zze<A> com_google_android_gms_internal_zzmg_zze_A) {
        this.f18938h.add(com_google_android_gms_internal_zzmg_zze_A);
        com_google_android_gms_internal_zzmg_zze_A.a(this.f18954x);
    }

    public final void mo3053a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f18943m);
        printWriter.append(str).append("mResuming=").print(this.f18945o);
        printWriter.append(" mWorkQueue.size()=").print(this.f18931a.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.f18938h.size());
        if (this.f18941k != null) {
            this.f18941k.mo3068a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final boolean mo3054a(zzmp com_google_android_gms_internal_zzmp) {
        return this.f18941k != null && this.f18941k.mo3069a(com_google_android_gms_internal_zzmp);
    }

    public final Looper mo3055b() {
        return this.f18944n;
    }

    public final <A extends zzb, T extends com.google.android.gms.internal.zzlx.zza<? extends Result, A>> T mo3056b(T t) {
        zzx.m113b(t.c() != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.f18939i.lock();
        try {
            if (this.f18941k == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (m26612n()) {
                this.f18931a.add(t);
                while (!this.f18931a.isEmpty()) {
                    zze com_google_android_gms_internal_zzmg_zze = (zze) this.f18931a.remove();
                    m26624a(com_google_android_gms_internal_zzmg_zze);
                    com_google_android_gms_internal_zzmg_zze.a(Status.f371c);
                }
            } else {
                t = this.f18941k.mo3071b(t);
                this.f18939i.unlock();
            }
            return t;
        } finally {
            this.f18939i.unlock();
        }
    }

    public final void mo3057b(OnConnectionFailedListener onConnectionFailedListener) {
        this.f18940j.m26779b(onConnectionFailedListener);
    }

    public final void mo3058c() {
        boolean z = false;
        this.f18939i.lock();
        try {
            if (this.f18942l >= 0) {
                if (this.f18953w != null) {
                    z = true;
                }
                zzx.m109a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f18953w == null) {
                this.f18953w = Integer.valueOf(m26607a(this.f18933c.values(), false));
            } else if (this.f18953w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            mo3048a(this.f18953w.intValue());
        } finally {
            this.f18939i.unlock();
        }
    }

    public final void c_(int i) {
        if (i == 1 && !this.f18945o) {
            this.f18945o = true;
            if (this.f18932b == null) {
                this.f18932b = (zzc) zzmk.a(this.f18943m.getApplicationContext(), new zzc(this), this.f18949s);
            }
            this.f18948r.sendMessageDelayed(this.f18948r.obtainMessage(1), this.f18946p);
            this.f18948r.sendMessageDelayed(this.f18948r.obtainMessage(2), this.f18947q);
        }
        for (zze b : this.f18938h) {
            b.b(new Status(8, "The connection to Google Play services was lost"));
        }
        this.f18940j.m26772a(i);
        this.f18940j.m26771a();
        if (i == 2) {
            m26613o();
        }
    }

    public final ConnectionResult mo3060d() {
        boolean z = true;
        zzx.m109a(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.f18939i.lock();
        try {
            if (this.f18942l >= 0) {
                if (this.f18953w == null) {
                    z = false;
                }
                zzx.m109a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f18953w == null) {
                this.f18953w = Integer.valueOf(m26607a(this.f18933c.values(), false));
            } else if (this.f18953w.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m26609b(this.f18953w.intValue());
            this.f18940j.m26777b();
            ConnectionResult b = this.f18941k.mo3070b();
            return b;
        } finally {
            this.f18939i.unlock();
        }
    }

    public final void mo3061e() {
        this.f18939i.lock();
        try {
            m26611m();
            if (this.f18941k == null) {
                m26635i();
                return;
            }
            m26636j();
            this.f18941k.mo3072c();
            this.f18940j.m26771a();
            this.f18939i.unlock();
        } finally {
            this.f18939i.unlock();
        }
    }

    public final boolean mo3062f() {
        return this.f18941k != null && this.f18941k.mo3073d();
    }

    public final boolean mo3063g() {
        return this.f18941k != null && this.f18941k.mo3074e();
    }

    final void m26635i() {
        for (zze com_google_android_gms_internal_zzmg_zze : this.f18931a) {
            com_google_android_gms_internal_zzmg_zze.a(null);
            com_google_android_gms_internal_zzmg_zze.h();
        }
        this.f18931a.clear();
    }

    final boolean m26636j() {
        if (!this.f18945o) {
            return false;
        }
        this.f18945o = false;
        this.f18948r.removeMessages(2);
        this.f18948r.removeMessages(1);
        if (this.f18932b != null) {
            this.f18932b.b();
            this.f18932b = null;
        }
        return true;
    }

    final String m26637k() {
        Writer stringWriter = new StringWriter();
        mo3053a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public final int m26638l() {
        return System.identityHashCode(this);
    }
}
