package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzmi implements zzmm {
    public final Map<zzc<?>, com.google.android.gms.common.api.Api.zzb> f19074a;
    public final Map<zzc<?>, ConnectionResult> f19075b = new HashMap();
    final zzf f19076c;
    final Map<Api<?>, Integer> f19077d;
    final zza<? extends zzsc, zzsd> f19078e;
    int f19079f;
    final zzmg f19080g;
    final zzmm.zza f19081h;
    public final Lock f19082i;
    private final Condition f19083j;
    private final Context f19084k;
    private final GoogleApiAvailability f19085l;
    private final zzb f19086m;
    public volatile zzmh f19087n;
    private ConnectionResult f19088o = null;

    final class zzb extends Handler {
        final /* synthetic */ zzmi f19089a;

        zzb(zzmi com_google_android_gms_internal_zzmi, Looper looper) {
            this.f19089a = com_google_android_gms_internal_zzmi;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    ((zza) message.obj).a(this.f19089a);
                    return;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    public zzmi(Context context, zzmg com_google_android_gms_internal_zzmg, Lock lock, Looper looper, GoogleApiAvailability googleApiAvailability, Map<zzc<?>, com.google.android.gms.common.api.Api.zzb> map, zzf com_google_android_gms_common_internal_zzf, Map<Api<?>, Integer> map2, zza<? extends zzsc, zzsd> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd, ArrayList<zzlz> arrayList, zzmm.zza com_google_android_gms_internal_zzmm_zza) {
        this.f19084k = context;
        this.f19082i = lock;
        this.f19085l = googleApiAvailability;
        this.f19074a = map;
        this.f19076c = com_google_android_gms_common_internal_zzf;
        this.f19077d = map2;
        this.f19078e = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzsc__com_google_android_gms_internal_zzsd;
        this.f19080g = com_google_android_gms_internal_zzmg;
        this.f19081h = com_google_android_gms_internal_zzmm_zza;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((zzlz) it.next()).f18776c = this;
        }
        this.f19086m = new zzb(this, looper);
        this.f19083j = lock.newCondition();
        this.f19087n = new zzmf(this);
    }

    public final ConnectionResult mo3065a(long j, TimeUnit timeUnit) {
        mo3067a();
        long toNanos = timeUnit.toNanos(j);
        while (mo3074e()) {
            if (toNanos <= 0) {
                try {
                    return new ConnectionResult(14, null);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            }
            toNanos = this.f19083j.awaitNanos(toNanos);
        }
        return mo3073d() ? ConnectionResult.f23271a : this.f19088o != null ? this.f19088o : new ConnectionResult(13, null);
    }

    public final <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends zzlx.zza<R, A>> T mo3066a(T t) {
        return this.f19087n.mo3075a((zzlx.zza) t);
    }

    public final void mo3067a() {
        this.f19087n.mo3082c();
    }

    public final void m26790a(int i) {
        this.f19082i.lock();
        try {
            this.f19087n.mo3077a(i);
        } finally {
            this.f19082i.unlock();
        }
    }

    public final void m26791a(Bundle bundle) {
        this.f19082i.lock();
        try {
            this.f19087n.mo3078a(bundle);
        } finally {
            this.f19082i.unlock();
        }
    }

    final void m26792a(ConnectionResult connectionResult) {
        this.f19082i.lock();
        try {
            this.f19088o = connectionResult;
            this.f19087n = new zzmf(this);
            this.f19087n.mo3076a();
            this.f19083j.signalAll();
        } finally {
            this.f19082i.unlock();
        }
    }

    public final void m26793a(ConnectionResult connectionResult, Api<?> api, int i) {
        this.f19082i.lock();
        try {
            this.f19087n.mo3079a(connectionResult, api, i);
        } finally {
            this.f19082i.unlock();
        }
    }

    final void m26794a(zza com_google_android_gms_internal_zzmi_zza) {
        this.f19086m.sendMessage(this.f19086m.obtainMessage(1, com_google_android_gms_internal_zzmi_zza));
    }

    final void m26795a(RuntimeException runtimeException) {
        this.f19086m.sendMessage(this.f19086m.obtainMessage(2, runtimeException));
    }

    public final void mo3068a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "  ";
        for (Api api : this.f19077d.keySet()) {
            printWriter.append(str).append(api.f17876e).println(":");
            ((com.google.android.gms.common.api.Api.zzb) this.f19074a.get(api.m25090c())).mo3031a(str2, printWriter);
        }
    }

    public final boolean mo3069a(zzmp com_google_android_gms_internal_zzmp) {
        return false;
    }

    public final ConnectionResult mo3070b() {
        mo3067a();
        while (mo3074e()) {
            try {
                this.f19083j.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return mo3073d() ? ConnectionResult.f23271a : this.f19088o != null ? this.f19088o : new ConnectionResult(13, null);
    }

    public final <A extends com.google.android.gms.common.api.Api.zzb, T extends zzlx.zza<? extends Result, A>> T mo3071b(T t) {
        return this.f19087n.mo3080b(t);
    }

    public final void mo3072c() {
        this.f19075b.clear();
        this.f19087n.mo3081b();
    }

    public final boolean mo3073d() {
        return this.f19087n instanceof zzmd;
    }

    public final boolean mo3074e() {
        return this.f19087n instanceof zzme;
    }

    final void m26803f() {
        this.f19082i.lock();
        try {
            this.f19087n = new zzme(this, this.f19076c, this.f19077d, this.f19085l, this.f19078e, this.f19082i, this.f19084k);
            this.f19087n.mo3076a();
            this.f19083j.signalAll();
        } finally {
            this.f19082i.unlock();
        }
    }

    final void m26804g() {
        this.f19082i.lock();
        try {
            this.f19080g.m26636j();
            this.f19087n = new zzmd(this);
            this.f19087n.mo3076a();
            this.f19083j.signalAll();
        } finally {
            this.f19082i.unlock();
        }
    }
}
