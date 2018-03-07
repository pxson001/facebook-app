package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzno implements zznl {
    private static zzno f51a;

    public static synchronized zznl m117c() {
        zznl com_google_android_gms_internal_zznl;
        synchronized (zzno.class) {
            if (f51a == null) {
                f51a = new zzno();
            }
            com_google_android_gms_internal_zznl = f51a;
        }
        return com_google_android_gms_internal_zznl;
    }

    public final long mo11a() {
        return System.currentTimeMillis();
    }

    public final long mo12b() {
        return SystemClock.elapsedRealtime();
    }
}
