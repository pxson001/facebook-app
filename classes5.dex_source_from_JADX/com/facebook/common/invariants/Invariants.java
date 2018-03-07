package com.facebook.common.invariants;

/* compiled from: soundcloud_share */
public final class Invariants {
    private Invariants() {
    }

    public static void m3750a(boolean z) {
        if (!z) {
            throw new InvariantViolationException();
        }
    }

    public static void m3751a(boolean z, String str) {
        if (!z) {
            throw new InvariantViolationException(str);
        }
    }

    public static void m3749a(int i, int i2) {
        if (i != i2) {
            throw new InvariantViolationException("expected = " + i + " , actual = " + i2);
        }
    }
}
