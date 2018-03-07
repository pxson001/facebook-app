package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk implements Callback {
    final ArrayList<ConnectionCallbacks> f19053a = new ArrayList();
    private final zza f19054b;
    private final ArrayList<ConnectionCallbacks> f19055c = new ArrayList();
    private final ArrayList<OnConnectionFailedListener> f19056d = new ArrayList();
    private volatile boolean f19057e = false;
    private final AtomicInteger f19058f = new AtomicInteger(0);
    private boolean f19059g = false;
    private final Handler f19060h;
    private final Object f19061i = new Object();

    public interface zza {
        boolean mo3032b();

        Bundle mo3037p();
    }

    public zzk(Looper looper, zza com_google_android_gms_common_internal_zzk_zza) {
        this.f19054b = com_google_android_gms_common_internal_zzk_zza;
        this.f19060h = new Handler(looper, this);
    }

    public final void m26771a() {
        this.f19057e = false;
        this.f19058f.incrementAndGet();
    }

    public final void m26772a(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.f19060h.getLooper()) {
            z = true;
        }
        zzx.m109a(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f19060h.removeMessages(1);
        synchronized (this.f19061i) {
            this.f19059g = true;
            ArrayList arrayList = new ArrayList(this.f19055c);
            int i2 = this.f19058f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (this.f19057e && this.f19058f.get() == i2) {
                    if (this.f19055c.contains(connectionCallbacks)) {
                        connectionCallbacks.mo38a(i);
                    }
                }
            }
            this.f19053a.clear();
            this.f19059g = false;
        }
    }

    public final void m26773a(Bundle bundle) {
        boolean z = true;
        zzx.m109a(Looper.myLooper() == this.f19060h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f19061i) {
            zzx.m108a(!this.f19059g);
            this.f19060h.removeMessages(1);
            this.f19059g = true;
            if (this.f19053a.size() != 0) {
                z = false;
            }
            zzx.m108a(z);
            ArrayList arrayList = new ArrayList(this.f19055c);
            int i = this.f19058f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (this.f19057e && this.f19054b.mo3032b() && this.f19058f.get() == i) {
                    if (!this.f19053a.contains(connectionCallbacks)) {
                        connectionCallbacks.mo39a(bundle);
                    }
                }
            }
            this.f19053a.clear();
            this.f19059g = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m26774a(com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r2 = r5.f19060h;
        r2 = r2.getLooper();
        if (r0 != r2) goto L_0x0046;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r2 = "onConnectionFailure must only be called on the Handler thread";
        com.google.android.gms.common.internal.zzx.m109a(r0, r2);
        r0 = r5.f19060h;
        r0.removeMessages(r1);
        r1 = r5.f19061i;
        monitor-enter(r1);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0054 }
        r2 = r5.f19056d;	 Catch:{ all -> 0x0054 }
        r0.<init>(r2);	 Catch:{ all -> 0x0054 }
        r2 = r5.f19058f;	 Catch:{ all -> 0x0054 }
        r2 = r2.get();	 Catch:{ all -> 0x0054 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0054 }
    L_0x002c:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0057;
    L_0x0032:
        r0 = r3.next();	 Catch:{ all -> 0x0054 }
        r0 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r0;	 Catch:{ all -> 0x0054 }
        r4 = r5.f19057e;	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x0044;
    L_0x003c:
        r4 = r5.f19058f;	 Catch:{ all -> 0x0054 }
        r4 = r4.get();	 Catch:{ all -> 0x0054 }
        if (r4 == r2) goto L_0x0048;
    L_0x0044:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
    L_0x0045:
        return;
    L_0x0046:
        r0 = 0;
        goto L_0x000e;
    L_0x0048:
        r4 = r5.f19056d;	 Catch:{ all -> 0x0054 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x002c;
    L_0x0050:
        r0.mo40a(r6);	 Catch:{ all -> 0x0054 }
        goto L_0x002c;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        monitor-exit(r1);	 Catch:{  }
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzk.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public final void m26775a(ConnectionCallbacks connectionCallbacks) {
        zzx.m104a((Object) connectionCallbacks);
        synchronized (this.f19061i) {
            if (this.f19055c.contains(connectionCallbacks)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + connectionCallbacks + " is already registered");
            } else {
                this.f19055c.add(connectionCallbacks);
            }
        }
        if (this.f19054b.mo3032b()) {
            this.f19060h.sendMessage(this.f19060h.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void m26776a(OnConnectionFailedListener onConnectionFailedListener) {
        zzx.m104a((Object) onConnectionFailedListener);
        synchronized (this.f19061i) {
            if (this.f19056d.contains(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + onConnectionFailedListener + " is already registered");
            } else {
                this.f19056d.add(onConnectionFailedListener);
            }
        }
    }

    public final void m26777b() {
        this.f19057e = true;
    }

    public final void m26778b(ConnectionCallbacks connectionCallbacks) {
        zzx.m104a((Object) connectionCallbacks);
        synchronized (this.f19061i) {
            if (!this.f19055c.remove(connectionCallbacks)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + connectionCallbacks + " not found");
            } else if (this.f19059g) {
                this.f19053a.add(connectionCallbacks);
            }
        }
    }

    public final void m26779b(OnConnectionFailedListener onConnectionFailedListener) {
        zzx.m104a((Object) onConnectionFailedListener);
        synchronized (this.f19061i) {
            if (!this.f19056d.remove(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + onConnectionFailedListener + " not found");
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message.obj;
            synchronized (this.f19061i) {
                if (this.f19057e && this.f19054b.mo3032b() && this.f19055c.contains(connectionCallbacks)) {
                    connectionCallbacks.mo39a(this.f19054b.mo3037p());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }
}
