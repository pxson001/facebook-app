package com.facebook.appupdate;

import android.os.Looper;

/* compiled from: zero_sessionless_backup_rewrite_rules */
public class Preconditions {
    public static void m12786a() {
        m12788a(Looper.getMainLooper().getThread() == Thread.currentThread(), "Not on the main thread!");
    }

    public static void m12789b() {
        m12788a(Looper.getMainLooper().getThread() != Thread.currentThread(), "On the main thread!");
    }

    public static void m12787a(boolean z) {
        m12788a(z, "Precondition failed!");
    }

    public static void m12788a(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }
}
