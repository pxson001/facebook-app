package com.facebook.gk.storelogger;

import android.os.SystemClock;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: view_all_comments */
public class TraceGatekeeperStoreLogger {
    private final String f1052a;
    public long f1053b;
    public long f1054c;

    public TraceGatekeeperStoreLogger(String str) {
        this.f1052a = str;
    }

    public final void m2144a() {
        TracerDetour.a("%s.save", this.f1052a, 22522486);
    }

    public final void m2145b() {
        TracerDetour.a(-571548417);
    }

    public final void m2146c() {
        this.f1053b = SystemClock.uptimeMillis();
        TracerDetour.a("%s.load", this.f1052a, 464810741);
    }

    public final void m2147d() {
        TracerDetour.a(-1085128165);
        this.f1054c = SystemClock.uptimeMillis();
    }
}
