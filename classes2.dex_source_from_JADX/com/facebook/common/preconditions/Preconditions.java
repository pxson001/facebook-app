package com.facebook.common.preconditions;

/* compiled from: zero_sessionless_backup_rewrite_rules */
public class Preconditions {
    private Preconditions() {
    }

    public static void m2016a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m2017b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
