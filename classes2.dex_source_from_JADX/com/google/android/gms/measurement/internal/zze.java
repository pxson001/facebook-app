package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.android.gms.common.internal.zzx;

public abstract class zze {
    private static volatile Handler f245b;
    public final zzt f246a;
    private final Runnable f247c = new C00051(this);
    public volatile long f248d;
    public boolean f249e = true;

    class C00051 implements Runnable {
        final /* synthetic */ zze f250a;

        C00051(zze com_google_android_gms_measurement_internal_zze) {
            this.f250a = com_google_android_gms_measurement_internal_zze;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f250a.f246a.m94g().m555a((Runnable) this);
                return;
            }
            Object obj = this.f250a.f248d != 0 ? 1 : null;
            this.f250a.f248d = 0;
            if (obj != null && this.f250a.f249e) {
                this.f250a.mo41a();
            }
        }
    }

    zze(zzt com_google_android_gms_measurement_internal_zzt) {
        zzx.m104a((Object) com_google_android_gms_measurement_internal_zzt);
        this.f246a = com_google_android_gms_measurement_internal_zzt;
    }

    private Handler m508d() {
        if (f245b != null) {
            return f245b;
        }
        Handler handler;
        synchronized (zze.class) {
            if (f245b == null) {
                f245b = new Handler(this.f246a.m97k().getMainLooper());
            }
            handler = f245b;
        }
        return handler;
    }

    public abstract void mo41a();

    public final void m510a(long j) {
        m511c();
        if (j >= 0) {
            this.f248d = this.f246a.f38l.mo11a();
            if (!HandlerDetour.b(m508d(), this.f247c, j, 128617373)) {
                this.f246a.m93f().f203d.m356a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final void m511c() {
        this.f248d = 0;
        HandlerDetour.a(m508d(), this.f247c);
    }
}
