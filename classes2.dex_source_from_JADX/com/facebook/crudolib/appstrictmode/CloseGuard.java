package com.facebook.crudolib.appstrictmode;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: tap */
public class CloseGuard {
    private static volatile boolean f3282a = false;
    @Nullable
    private volatile Throwable f3283b;

    private CloseGuard() {
    }

    @Nullable
    public static CloseGuard m5451a(@Nullable CloseGuard closeGuard, String str) {
        if (str == null) {
            throw new NullPointerException("closer == null");
        } else if (!f3282a) {
            return null;
        } else {
            if (closeGuard == null) {
                closeGuard = new CloseGuard();
            } else if (closeGuard.f3283b != null) {
                throw new IllegalArgumentException("closeGuard was never released before calling open.", closeGuard.f3283b);
            }
            closeGuard.f3283b = new Throwable("Explicit termination method '" + str + "' not called");
            return closeGuard;
        }
    }

    public static void m5452a(@Nullable CloseGuard closeGuard) {
        if (closeGuard != null) {
            closeGuard.f3283b = null;
        }
    }

    public static void m5453b(@Nullable CloseGuard closeGuard) {
        if (closeGuard != null && closeGuard.f3283b != null) {
            String str = "A resource was acquired and never released.";
            Throwable th = closeGuard.f3283b;
            if (!((PolicyEnforcer.a.b & 1) == 0 || (PolicyEnforcer.a.b & 65536) == 0)) {
                Log.e("AppStrictMode", str, th);
            }
        }
    }

    protected void finalize() {
        try {
            m5453b(this);
        } finally {
            super.finalize();
        }
    }
}
