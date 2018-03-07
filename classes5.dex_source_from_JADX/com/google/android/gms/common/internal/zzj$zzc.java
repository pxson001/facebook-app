package com.google.android.gms.common.internal;

import android.util.Log;

public abstract class zzj$zzc<TListener> {
    private TListener f6569a;
    private boolean f6570b = false;
    final /* synthetic */ zzj f6571d;

    public zzj$zzc(zzj com_google_android_gms_common_internal_zzj, TListener tListener) {
        this.f6571d = com_google_android_gms_common_internal_zzj;
        this.f6569a = tListener;
    }

    protected abstract void mo743a(TListener tListener);

    public final void m12283b() {
        synchronized (this) {
            Object obj = this.f6569a;
            if (this.f6570b) {
                Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
            }
        }
        if (obj != null) {
            try {
                mo743a(obj);
            } catch (RuntimeException e) {
                throw e;
            }
        }
        synchronized (this) {
            this.f6570b = true;
        }
        m12284c();
    }

    public final void m12284c() {
        m12285d();
        synchronized (this.f6571d.m) {
            this.f6571d.m.remove(this);
        }
    }

    public final void m12285d() {
        synchronized (this) {
            this.f6569a = null;
        }
    }
}
