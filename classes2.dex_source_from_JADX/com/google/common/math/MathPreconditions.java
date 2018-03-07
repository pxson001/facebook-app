package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: open_application */
public final class MathPreconditions {
    static int m16297a(@Nullable String str, int i) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " (" + i + ") must be > 0");
    }

    static double m16296a(@Nullable String str, double d) {
        if (d >= 0.0d) {
            return d;
        }
        throw new IllegalArgumentException(str + " (" + d + ") must be >= 0");
    }

    static void m16298a(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    public static void m16299b(boolean z) {
        if (!z) {
            throw new ArithmeticException("overflow");
        }
    }

    private MathPreconditions() {
    }
}
