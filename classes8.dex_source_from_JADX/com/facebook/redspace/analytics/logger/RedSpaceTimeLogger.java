package com.facebook.redspace.analytics.logger;

import com.facebook.common.time.Clock;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: Unable to create QP fragment */
public class RedSpaceTimeLogger {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Clock> f21266a = UltralightRuntime.b;
    private long f21267b;

    public final void m24880a() {
        if (this.f21267b == 0) {
            this.f21267b = ((Clock) this.f21266a.get()).a();
        }
    }

    public final long m24881b() {
        if (this.f21267b == 0) {
            return 0;
        }
        long a = ((Clock) this.f21266a.get()).a() - this.f21267b;
        this.f21267b = 0;
        return a;
    }
}
