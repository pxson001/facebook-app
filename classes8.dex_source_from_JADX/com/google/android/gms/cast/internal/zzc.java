package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

public abstract class zzc extends zzd {
    protected final Handler f10061b = new Handler(Looper.getMainLooper());
    protected final long f10062c;
    protected final Runnable f10063d = new zza(this);
    protected boolean f10064e;

    class zza implements Runnable {
        final /* synthetic */ zzc f10126a;

        public zza(zzc com_google_android_gms_cast_internal_zzc) {
            this.f10126a = com_google_android_gms_cast_internal_zzc;
        }

        public void run() {
            this.f10126a.f10064e = false;
            this.f10126a.m11811a(this.f10126a.mo642a(SystemClock.elapsedRealtime()));
        }
    }

    public zzc(String str, String str2, String str3, long j) {
        super(str, str2, str3);
        this.f10062c = j;
        m11811a(false);
    }

    protected final void m11811a(boolean z) {
        if (this.f10064e != z) {
            this.f10064e = z;
            if (z) {
                HandlerDetour.b(this.f10061b, this.f10063d, this.f10062c, -1638901797);
            } else {
                HandlerDetour.a(this.f10061b, this.f10063d);
            }
        }
    }

    protected abstract boolean mo642a(long j);

    public void mo639c() {
        m11811a(false);
    }
}
