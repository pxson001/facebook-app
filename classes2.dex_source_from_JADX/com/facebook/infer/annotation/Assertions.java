package com.facebook.infer.annotation;

import javax.annotation.Nullable;

/* compiled from: tail_fetch_rerun_count_by_cc */
public class Assertions {
    public static <T> T m5467a(@Nullable T t) {
        return t;
    }

    public static <T> T m5471b(@Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new AssertionError();
    }

    public static <T> T m5468a(@Nullable T t, String str) {
        if (t != null) {
            return t;
        }
        throw new AssertionError(str);
    }

    public static void m5469a(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static void m5470a(boolean z, String str) {
        if (!z) {
            throw new AssertionError(str);
        }
    }

    public static AssertionError m5465a() {
        throw new AssertionError();
    }

    public static AssertionError m5466a(String str) {
        throw new AssertionError(str);
    }
}
